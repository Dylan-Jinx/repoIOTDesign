package com.example.nutritional.fragment.plant;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nutritional.R;
import com.example.nutritional.bean.safety.UserIdByPlantSearch;
import com.example.nutritional.util.ConstantsUtils;
import com.example.nutritional.util.HttpUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import okhttp3.FormBody;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PlantFragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlantFragment2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView plant2PlantTime;
    private TextView plant2HarvestTime;
    private TextView plant2SeedSource;
    private TextView plant2PlantFieldNum;
    private TextView plant2Remark;
    ExecutorService service;
    UserIdByPlantSearch userIdByPlantSearch;
    List<UserIdByPlantSearch.PlantInfosBean> beanList;
    private CardView plant2CardView;

    public PlantFragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PlantFragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static PlantFragment2 newInstance(String param1, String param2) {
        PlantFragment2 fragment = new PlantFragment2();
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
        View view = inflater.inflate(R.layout.fragment_plant2, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        service = newFixedThreadPool(1);
        beanList = new ArrayList<>();
        plant2PlantTime = (TextView) view.findViewById(R.id.plant2_plantTime);
        plant2HarvestTime = (TextView) view.findViewById(R.id.plant2_harvestTime);
        plant2SeedSource = (TextView) view.findViewById(R.id.plant2_seedSource);
        plant2PlantFieldNum = (TextView) view.findViewById(R.id.plant2_plantFieldNum);
        plant2Remark = (TextView) view.findViewById(R.id.plant2_remark);
        plant2CardView=view.findViewById(R.id.plant2_cardView);
        userIdBySearch();
    }

    private void userIdBySearch() {
        service.execute(new Runnable() {
            @Override
            public void run() {
                FormBody formBody = new FormBody.Builder()
                        .build();
                View viewById = getActivity().findViewById(R.id.plate_id);
                String string = ((TextView) viewById).getText().toString();
                try {
                    userIdByPlantSearch = HttpUtils.okHttpPost(ConstantsUtils.SERVER_URL_SAFETY + ConstantsUtils.Address_UserIdByPlantSearch + "?id=" + string, formBody, UserIdByPlantSearch.class);
                    String message = "操作成功";
                    if (message.equals(userIdByPlantSearch.getMessage())) {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                beanList.addAll(userIdByPlantSearch.getPlantInfos());
                                plant2CardView.setVisibility(View.VISIBLE);
                                plant2SeedSource.setText("地区："+beanList.get(0).getSeedSource());
                                plant2PlantTime.setText(beanList.get(0).getPlantTime());
                                plant2HarvestTime.setText(beanList.get(0).getHarvestTime());
                                plant2PlantFieldNum.setText("基地名称："+beanList.get(0).getPlantFieldNum());
                                plant2Remark.setText(beanList.get(0).getRemark());
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