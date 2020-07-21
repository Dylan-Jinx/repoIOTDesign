package com.example.nutritional.fragment.plant;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.nutritional.R;
import com.example.nutritional.bean.safety.GetAllPlantInfo;
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
 * Use the {@link PlantFragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlantFragment1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ListView plant1ListView;
    ExecutorService service;
    GetAllPlantInfo getAllPlantInfo;
    List<GetAllPlantInfo.PlantInfosBean> beanList;

    public PlantFragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PlantFragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static PlantFragment1 newInstance(String param1, String param2) {
        PlantFragment1 fragment = new PlantFragment1();
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
        View view = inflater.inflate(R.layout.fragment_plant1, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        service = newFixedThreadPool(1);
        beanList = new ArrayList<>();
        plant1ListView = view.findViewById(R.id.plant1_listView);
        getAllPlantData();
    }

    private void getAllPlantData() {
        service.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    getAllPlantInfo = HttpUtils.okHttpGet(ConstantsUtils.SERVER_URL_SAFETY + ConstantsUtils.Address_GetAllPlantInfo, GetAllPlantInfo.class);
                    beanList.addAll(getAllPlantInfo.getPlantInfos());
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            plant1ListView.setAdapter(new MyAdapter(beanList));
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    static class MyAdapter extends BaseAdapter {

        List<GetAllPlantInfo.PlantInfosBean> beanList;

        public MyAdapter(List<GetAllPlantInfo.PlantInfosBean> beanList) {
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_plant, null);
            ViewHolder viewHolder=new ViewHolder(view);
            viewHolder.plantSeedSource.setText("地区："+beanList.get(i).getSeedSource());
            viewHolder.plantHarvestTime.setText(beanList.get(i).getHarvestTime());
            viewHolder.plantPlantTime.setText(beanList.get(i).getPlantTime());
            viewHolder.plantPlantFieldNum.setText("基地名称："+beanList.get(i).getPlantFieldNum());
            viewHolder.plantRemark.setText(beanList.get(i).getRemark());
            return view;
        }

        public static
        class ViewHolder {
            public View rootView;
            public TextView plantPlantTime;
            public TextView plantHarvestTime;
            public TextView plantSeedSource;
            public TextView plantPlantFieldNum;
            public TextView plantRemark;

            public ViewHolder(View rootView) {
                this.rootView = rootView;
                this.plantPlantTime = (TextView) rootView.findViewById(R.id.plant_plantTime);
                this.plantHarvestTime = (TextView) rootView.findViewById(R.id.plant_harvestTime);
                this.plantSeedSource = (TextView) rootView.findViewById(R.id.plant_seedSource);
                this.plantPlantFieldNum = (TextView) rootView.findViewById(R.id.plant_plantFieldNum);
                this.plantRemark = (TextView) rootView.findViewById(R.id.plant_remark);
            }

        }
    }

    @Override
    public void onStop() {
        super.onStop();
        service.shutdown();
    }
}