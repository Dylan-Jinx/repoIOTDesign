package com.example.nutritional.fragment.nutrient;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.nutritional.R;
import com.example.nutritional.bean.food.GetAllNutritionInfo;
import com.example.nutritional.util.ConstantsUtils;
import com.example.nutritional.util.HttpUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @author 69182
 */
public
class NutrientFragment1 extends Fragment {

    View view;
    private ListView nutrientListView;
    ExecutorService service;
    GetAllNutritionInfo getAllNutritionInfo;
    List<GetAllNutritionInfo.NutrientInformationBean> beanList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_nutrient1, container, false);
        initView();
        return view;
    }

    private void initView() {
        service = newFixedThreadPool(1);
        beanList = new ArrayList<>();
        nutrientListView = view.findViewById(R.id.nutrientListView);
        getAllNutritionData();
    }

    private void getAllNutritionData() {
        service.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    getAllNutritionInfo = HttpUtils.okHttpGet(ConstantsUtils.SERVER_URL_FOOD + ConstantsUtils.Address_GetAllNutritionInfo, GetAllNutritionInfo.class);
                    beanList.addAll(getAllNutritionInfo.getNutrientInformation());
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            nutrientListView.setAdapter(new MyAdapter(beanList));
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    static class MyAdapter extends BaseAdapter {

        List<GetAllNutritionInfo.NutrientInformationBean> beanList;

        public MyAdapter(List<GetAllNutritionInfo.NutrientInformationBean> beanList) {
            this.beanList = beanList;
        }

        @Override
        public int getCount() {
            return beanList.size();
        }

        @Override
        public Object getItem(int i) {
            return beanList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return beanList.get(i).getId();
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_nutrient, null);
            ViewHolder viewHolder=new ViewHolder(view);
            viewHolder.nutrientName.setText("名称："+beanList.get(i).getName());
            viewHolder.nutrientOtherName.setText("别称："+beanList.get(i).getOtherName());
            viewHolder.nutrientUnit.setText("单位："+beanList.get(i).getUnit());
            viewHolder.nutrientIntroduction.setText("简介："+String.valueOf(beanList.get(i).getIntroduction()));
            viewHolder.nutrientDeSymptom.setText("缺失："+String.valueOf(beanList.get(i).getDeSymptom()));
            viewHolder.nutrientMuchHarm.setText("过量："+String.valueOf(beanList.get(i).getMuchHarm()));
            viewHolder.nutrientSource.setText("来源："+String.valueOf(beanList.get(i).getSource()));
            viewHolder.nutrientFocusGroups.setText("适用人群："+String.valueOf(beanList.get(i).getFocusGroups()));
            viewHolder.nutrientHighContentOfSource.setText("高含量食品："+String.valueOf(beanList.get(i).getHighContentOfSource()));
            return view;
        }

        public static
        class ViewHolder {
            public View rootView;
            public TextView nutrientName;
            public TextView nutrientOtherName;
            public TextView nutrientUnit;
            public TextView nutrientIntroduction;
            public TextView nutrientDeSymptom;
            public TextView nutrientMuchHarm;
            public TextView nutrientSource;
            public TextView nutrientFocusGroups;
            public TextView nutrientHighContentOfSource;

            public ViewHolder(View rootView) {
                this.rootView = rootView;
                this.nutrientName = (TextView) rootView.findViewById(R.id.nutrientName);
                this.nutrientOtherName = (TextView) rootView.findViewById(R.id.nutrientOtherName);
                this.nutrientUnit = (TextView) rootView.findViewById(R.id.nutrientUnit);
                this.nutrientIntroduction = (TextView) rootView.findViewById(R.id.nutrientIntroduction);
                this.nutrientDeSymptom = (TextView) rootView.findViewById(R.id.nutrientDeSymptom);
                this.nutrientMuchHarm = (TextView) rootView.findViewById(R.id.nutrientMuchHarm);
                this.nutrientSource = (TextView) rootView.findViewById(R.id.nutrientSource);
                this.nutrientFocusGroups = (TextView) rootView.findViewById(R.id.nutrientFocusGroups);
                this.nutrientHighContentOfSource = (TextView) rootView.findViewById(R.id.nutrientHighContentOfSource);
            }

        }
    }

    @Override
    public void onStop() {
        super.onStop();
        service.shutdown();
    }
}
