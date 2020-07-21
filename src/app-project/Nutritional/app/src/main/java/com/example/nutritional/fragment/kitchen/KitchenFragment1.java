package com.example.nutritional.fragment.kitchen;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.nutritional.R;
import com.example.nutritional.bean.school.GetAllCookHouseInfo;
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
public class KitchenFragment1 extends Fragment {

    View view;
    ExecutorService service;
    private ListView kitchenListView;
    GetAllCookHouseInfo getAllCookHouseInfo;
    List<GetAllCookHouseInfo.CookHouseInfoBean> beanList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_kitchen1, container, false);
        initView();
        return view;
    }

    private void initView() {
        service = newFixedThreadPool(1);
        beanList = new ArrayList<>();
        kitchenListView = view.findViewById(R.id.kitchen_listView);
        getCookHouseData();
    }

    private void getCookHouseData() {
        service.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    getAllCookHouseInfo = HttpUtils.okHttpGet(ConstantsUtils.SERVER_URL_SCHOOL + ConstantsUtils.Address_GetAllCookHouseInfo, GetAllCookHouseInfo.class);
                    beanList.addAll(getAllCookHouseInfo.getCookHouseInfo());
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            kitchenListView.setAdapter(new MyAdapter(beanList));
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    static class MyAdapter extends BaseAdapter {

        List<GetAllCookHouseInfo.CookHouseInfoBean> beanList;

        public MyAdapter(List<GetAllCookHouseInfo.CookHouseInfoBean> beanList) {
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

        @SuppressLint("ViewHolder")
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_kitchen, null);
            ViewHolder viewHolder=new ViewHolder(view);
            viewHolder.bill_humidity.setText("湿度："+beanList.get(i).getHumidity());
            viewHolder.bill_temperature.setText("湿度："+beanList.get(i).getTemperature());
            viewHolder.billCookHouseName.setText("厨房："+beanList.get(i).getCookHouseName());
            viewHolder.billTime.setText(beanList.get(i).getReportTime());
            return view;
        }

        public static
        class ViewHolder {
            public View rootView;
            public TextView billTime;
            public TextView billCookHouseName;
            public TextView bill_temperature;
            public TextView bill_humidity;

            public ViewHolder(View rootView) {
                this.rootView = rootView;
                this.billTime = (TextView) rootView.findViewById(R.id.bill_time);
                this.billCookHouseName = (TextView) rootView.findViewById(R.id.bill_cookHouseName);
                this.bill_temperature = (TextView) rootView.findViewById(R.id.bill_temperature);
                this.bill_humidity = (TextView) rootView.findViewById(R.id.bill_humidity);
            }

        }
    }

    @Override
    public void onStop() {
        super.onStop();
        service.shutdown();
    }
}
