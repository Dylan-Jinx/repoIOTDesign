package com.example.nutritional.fragment.nutrient;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nutritional.R;
import com.example.nutritional.bean.food.UseNutritionNameBySearchInfo;
import com.example.nutritional.util.ConstantsUtils;
import com.example.nutritional.util.HttpUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import okhttp3.FormBody;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @author 69182
 */
public
class NutrientFragment2 extends Fragment {
    View view;
    private TextView nutrient2Name;
    private TextView nutrient2OtherName;
    private TextView nutrient2Unit;
    private TextView nutrient2Introduction;
    private TextView nutrient2DeSymptom;
    private TextView nutrient2MuchHarm;
    private TextView nutrient2Source;
    private TextView nutrient2HighContentOfSource;
    private TextView nutrient2FocusGroups;
    private CardView nutrient2CardView;
    ExecutorService service;
    UseNutritionNameBySearchInfo useNutritionNameBySearchInfo;
    List<UseNutritionNameBySearchInfo.NutrientInformationBean> beanList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_nutrient2, container, false);
        initView();
        return view;
    }

    private void initView() {
        service = newFixedThreadPool(1);
        beanList = new ArrayList<>();
        nutrient2Name = view.findViewById(R.id.nutrient2Name);
        nutrient2OtherName = view.findViewById(R.id.nutrient2OtherName);
        nutrient2Unit = view.findViewById(R.id.nutrient2Unit);
        nutrient2Introduction = view.findViewById(R.id.nutrient2Introduction);
        nutrient2DeSymptom = view.findViewById(R.id.nutrient2DeSymptom);
        nutrient2MuchHarm = view.findViewById(R.id.nutrient2MuchHarm);
        nutrient2Source = view.findViewById(R.id.nutrient2Source);
        nutrient2HighContentOfSource = view.findViewById(R.id.nutrient2HighContentOfSource);
        nutrient2FocusGroups = view.findViewById(R.id.nutrient2FocusGroups);
        nutrient2CardView = view.findViewById(R.id.nutrient2CardView);

        useNutritionNameBySearchData();
    }

    private void useNutritionNameBySearchData() {
        service.execute(new Runnable() {
            @Override
            public void run() {
                View viewById = getActivity().findViewById(R.id.nutrientSelectName);
                String string = ((TextView) viewById).getText().toString();
                FormBody formBody = new FormBody.Builder()
                        .build();
                try {
                    useNutritionNameBySearchInfo = HttpUtils.okHttpPost(ConstantsUtils.SERVER_URL_FOOD + ConstantsUtils.Address_UseNutritionNameBySearchInfo + "?NutritionName=" + string, formBody, UseNutritionNameBySearchInfo.class);
                    String message = "获取成功";
                    if (message.equals(useNutritionNameBySearchInfo.getMessage())) {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                beanList.addAll(useNutritionNameBySearchInfo.getNutrientInformation());
                                nutrient2CardView.setVisibility(View.VISIBLE);
                                nutrient2Name.setText("名称：" + beanList.get(0).getName());
                                nutrient2OtherName.setText("别称：" + beanList.get(0).getOtherName());
                                nutrient2Unit.setText("单位：" + beanList.get(0).getUnit());
                                nutrient2Introduction.setText("简介：" + beanList.get(0).getIntroduction());
                                nutrient2DeSymptom.setText("缺失：" + beanList.get(0).getDeSymptom());
                                nutrient2MuchHarm.setText("过量：" + beanList.get(0).getMuchHarm());
                                nutrient2Source.setText("来源：" + beanList.get(0).getSource());
                                nutrient2FocusGroups.setText("适用人群：" + beanList.get(0).getFocusGroups());
                                nutrient2HighContentOfSource.setText("高含量食品：" + beanList.get(0).getHighContentOfSource());
                            }
                        });
                    }else {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getActivity(), "查询失败", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onStop() {
        super.onStop();
        service.shutdown();
    }
}
