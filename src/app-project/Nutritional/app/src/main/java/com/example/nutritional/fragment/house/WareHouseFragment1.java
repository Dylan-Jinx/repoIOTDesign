package com.example.nutritional.fragment.house;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.nutritional.R;
import com.example.nutritional.bean.safety.GetWareHouseInfo;
import com.example.nutritional.util.ConstantsUtils;
import com.example.nutritional.util.HttpUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import androidx.fragment.app.Fragment;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WareHouseFragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WareHouseFragment1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ExecutorService service;
    GetWareHouseInfo getWareHouseInfo;
    List<GetWareHouseInfo.WarehousesBean> beanList;
    private ListView wareHouse1ListView;

    public WareHouseFragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WareHouseFragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static WareHouseFragment1 newInstance(String param1, String param2) {
        WareHouseFragment1 fragment = new WareHouseFragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ware_house1, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        service = newFixedThreadPool(1);
        beanList = new ArrayList<>();
        wareHouse1ListView = view.findViewById(R.id.ware_house1_listView);

        getWareHouseData();

    }

    private void getWareHouseData() {
        service.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    getWareHouseInfo = HttpUtils.okHttpGet(ConstantsUtils.SERVER_URL_SAFETY + ConstantsUtils.Address_GetWareHouseInfo, GetWareHouseInfo.class);
                    beanList.addAll(getWareHouseInfo.getWarehouses());
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            wareHouse1ListView.setAdapter(new MyAdapter(beanList));
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    static class MyAdapter extends BaseAdapter {

        List<GetWareHouseInfo.WarehousesBean> beanList;

        public MyAdapter(List<GetWareHouseInfo.WarehousesBean> beanList) {
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

        @SuppressLint({"InflateParams", "ViewHolder"})
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_ware_house, null);
            ViewHolder viewHolder=new ViewHolder(view);
            viewHolder.wareHouseName.setText(beanList.get(i).getName());
            viewHolder.wareHouseLocation.setText(beanList.get(i).getLocation());
            viewHolder.wareHouseTemperature.setText("温度："+beanList.get(i).getTemperature());
            viewHolder.wareHouseHumidity.setText("湿度："+beanList.get(i).getHumidity());
            viewHolder.wareHouseRemark.setText(beanList.get(i).getRemark());
            viewHolder.wareHouseResponsiblePerson.setText("操作员："+beanList.get(i).getResponsiblePerson());
            viewHolder.wareHouseTelephone.setText("tel："+beanList.get(i).getTelephone());
            return view;
        }

        public static
        class ViewHolder {
            public View rootView;
            public TextView wareHouseName;
            public TextView wareHouseLocation;
            public TextView wareHouseTemperature;
            public TextView wareHouseHumidity;
            public TextView wareHouseRemark;
            public TextView wareHouseResponsiblePerson;
            public TextView wareHouseTelephone;

            public ViewHolder(View rootView) {
                this.rootView = rootView;
                this.wareHouseName = (TextView) rootView.findViewById(R.id.ware_house_name);
                this.wareHouseLocation = (TextView) rootView.findViewById(R.id.ware_house_location);
                this.wareHouseTemperature = (TextView) rootView.findViewById(R.id.ware_house_temperature);
                this.wareHouseHumidity = (TextView) rootView.findViewById(R.id.ware_house_humidity);
                this.wareHouseRemark = (TextView) rootView.findViewById(R.id.ware_house_remark);
                this.wareHouseResponsiblePerson = (TextView) rootView.findViewById(R.id.ware_house_responsiblePerson);
                this.wareHouseTelephone = (TextView) rootView.findViewById(R.id.ware_house_telephone);
            }

        }
    }

    @Override
    public void onStop() {
        super.onStop();
        service.shutdown();
    }
}