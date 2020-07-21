package com.example.nutritional.fragment.kitchen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nutritional.R;
import com.example.nutritional.activity.KitchenActivity;
import com.example.nutritional.bean.school.GetConditionCookHouseInfo;
import com.example.nutritional.util.ConstantsUtils;
import com.example.nutritional.util.HttpUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @author 69182
 */
public
class KitchenFragment2 extends Fragment {

    View view;
    ExecutorService service;
    private TextView kitchenTime;
    private TextView kitchenCookHouseName;
    private TextView kitchenTemperature;
    private TextView kitchenHumidity;
    private CardView kitchenCardView;
    GetConditionCookHouseInfo getConditionCookHouseInfo;
    List<GetConditionCookHouseInfo.CookHouseInfoBean> beanList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_kitchen2, container, false);
        initView();
        return view;
    }

    private void initView() {
        service = newFixedThreadPool(1);
        beanList = new ArrayList<>();
        kitchenTime = view.findViewById(R.id.kitchen_time);
        kitchenCookHouseName = view.findViewById(R.id.kitchen_cookHouse);
        kitchenHumidity = view.findViewById(R.id.kitchen_humidity);
        kitchenTemperature = view.findViewById(R.id.kitchen_temperature);
        kitchenCardView = view.findViewById(R.id.kitchen_cardView);
        selectCookHouseInfo();
    }

    private void selectCookHouseInfo() {
        service.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    final View viewById = getActivity().findViewById(R.id.kitchen_cookHouseName);
                    String string = ((TextView) viewById).getText().toString();
                    getConditionCookHouseInfo = HttpUtils.okHttpGet(ConstantsUtils.SERVER_URL_SCHOOL + ConstantsUtils.Address_GetConditionCookHouseInfo + "?cookhousename=" + string, GetConditionCookHouseInfo.class);
                    String s = "查询成功";
                    if (s.equals(getConditionCookHouseInfo.getMessage())){
                        beanList.addAll(getConditionCookHouseInfo.getCookHouseInfo());
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                kitchenCardView.setVisibility(View.VISIBLE);
                                kitchenCookHouseName.setText("厨房：" + beanList.get(0).getCookHouseName());
                                kitchenHumidity.setText("湿度：" + beanList.get(0).getHumidity());
                                kitchenTemperature.setText("温度：" + beanList.get(0).getTemperature());
                                kitchenTime.setText(beanList.get(0).getReportTime());
                                Toast.makeText(getActivity(), "查询成功", Toast.LENGTH_SHORT).show();
                                ((TextView) viewById).setText("");
                            }
                        });
                    }else {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getActivity(), "输入名称有误", Toast.LENGTH_SHORT).show();
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
