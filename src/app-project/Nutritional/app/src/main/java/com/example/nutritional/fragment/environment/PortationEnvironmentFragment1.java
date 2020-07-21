package com.example.nutritional.fragment.environment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.nutritional.R;
import com.example.nutritional.bean.safety.GetAllEnvironmentInfo;
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
 * Use the {@link PortationEnvironmentFragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PortationEnvironmentFragment1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ExecutorService service;
    GetAllEnvironmentInfo getAllEnvironmentInfo;
    List<GetAllEnvironmentInfo.EnvironmentInfosBean> beanList;
    private ListView environment2ListView;

    public PortationEnvironmentFragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PortationEnvironmentFragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static PortationEnvironmentFragment1 newInstance(String param1, String param2) {
        PortationEnvironmentFragment1 fragment = new PortationEnvironmentFragment1();
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
        View view = inflater.inflate(R.layout.fragment_portation_environment1, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        service = newFixedThreadPool(1);
        beanList = new ArrayList<>();
        environment2ListView = view.findViewById(R.id.environment2_listView);

        getAllEnvironmentData();
    }

    private void getAllEnvironmentData() {
        service.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    getAllEnvironmentInfo = HttpUtils.okHttpGet(ConstantsUtils.SERVER_URL_SAFETY + ConstantsUtils.Address_GetAllEnvironmentInfo, GetAllEnvironmentInfo.class);
                    beanList.addAll(getAllEnvironmentInfo.getEnvironmentInfos());
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            environment2ListView.setAdapter(new MyAdapter(beanList));
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    static class MyAdapter extends BaseAdapter {

        List<GetAllEnvironmentInfo.EnvironmentInfosBean> beanList;

        public MyAdapter(List<GetAllEnvironmentInfo.EnvironmentInfosBean> beanList) {
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_environment, null);
            ViewHolder viewHolder = new ViewHolder(view);
            viewHolder.environmentTimer.setText(beanList.get(i).getDateTime());
            viewHolder.environmentDriver.setText("驾驶员："+beanList.get(i).getDriver());
            viewHolder.environmentHumidity.setText("湿度："+beanList.get(i).getHumidity());
            viewHolder.environmentPlate.setText(beanList.get(i).getPlate());
            viewHolder.environmentTemperature.setText("温度："+beanList.get(i).getTemperature());
            viewHolder.environmentTelephone.setText("联系电话："+beanList.get(i).getTelephone());
            return view;
        }

        public static
        class ViewHolder {
            public View rootView;
            public TextView environmentTimer;
            public TextView environmentPlate;
            public TextView environmentProductNumber;
            public TextView environmentTemperature;
            public TextView environmentHumidity;
            public TextView environmentDriver;
            public TextView environmentTelephone;

            public ViewHolder(View rootView) {
                this.rootView = rootView;
                this.environmentTimer = (TextView) rootView.findViewById(R.id.environment_timer);
                this.environmentPlate = (TextView) rootView.findViewById(R.id.environment_plate);
                this.environmentProductNumber = (TextView) rootView.findViewById(R.id.environment_productNumber);
                this.environmentTemperature = (TextView) rootView.findViewById(R.id.environment_temperature);
                this.environmentHumidity = (TextView) rootView.findViewById(R.id.environment_humidity);
                this.environmentDriver = (TextView) rootView.findViewById(R.id.environment_driver);
                this.environmentTelephone = (TextView) rootView.findViewById(R.id.environment_telephone);
            }

        }
    }

    @Override
    public void onStop() {
        super.onStop();
        service.shutdown();
    }
}