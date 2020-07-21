package com.example.nutritional.fragment.house;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nutritional.R;
import com.example.nutritional.bean.safety.UserIdByHouseSearch;
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
 * Use the {@link WareHouseFragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WareHouseFragment2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ExecutorService service;
    UserIdByHouseSearch userIdByHouseSearch;
    List<UserIdByHouseSearch.WarehousesBean> beanList;

    public WareHouseFragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WareHouseFragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static WareHouseFragment2 newInstance(String param1, String param2) {
        WareHouseFragment2 fragment = new WareHouseFragment2();
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
        View view = inflater.inflate(R.layout.fragment_ware_house2, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        service = newFixedThreadPool(1);
        beanList = new ArrayList<>();

        userIdBySearch(view);
    }

    private void userIdBySearch(final View view) {
        service.execute(new Runnable() {
            @Override
            public void run() {
                FormBody formBody=new FormBody.Builder()
                        .build();
                View viewById = getActivity().findViewById(R.id.ware_house_id);
                String string = ((TextView) viewById).getText().toString();
                try {
                    userIdByHouseSearch= HttpUtils.okHttpPost(ConstantsUtils.SERVER_URL_SAFETY+ConstantsUtils.Address_UserIdByHouseSearch+"?id="+string,formBody,UserIdByHouseSearch.class);
                    String message="操作成功";
                    if (message.equals(userIdByHouseSearch.getMessage())){
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                beanList.addAll(userIdByHouseSearch.getWarehouses());
                                ViewHolder viewHolder=new ViewHolder(view);
                                viewHolder.wareHouse2CardView.setVisibility(View.VISIBLE);
                                viewHolder.wareHouse2Name.setText(beanList.get(0).getName());
                                viewHolder.wareHouse2Location.setText(beanList.get(0).getLocation());
                                viewHolder.wareHouse2Temperature.setText("温度："+beanList.get(0).getTemperature());
                                viewHolder.wareHouse2Humidity.setText("湿度："+beanList.get(0).getHumidity());
                                viewHolder.wareHouse2Remark.setText(beanList.get(0).getRemark());
                                viewHolder.wareHouse2ResponsiblePerson.setText("操作员："+beanList.get(0).getResponsiblePerson());
                                viewHolder.wareHouse2Telephone.setText("tel："+beanList.get(0).getTelephone());
                            }
                        });
                    }else {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getActivity(), userIdByHouseSearch.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    public static
    class ViewHolder {
        public View rootView;
        public TextView wareHouse2Name;
        public TextView wareHouse2Location;
        public TextView wareHouse2Temperature;
        public TextView wareHouse2Humidity;
        public TextView wareHouse2Remark;
        public TextView wareHouse2ResponsiblePerson;
        public TextView wareHouse2Telephone;
        public CardView wareHouse2CardView;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.wareHouse2Name = (TextView) rootView.findViewById(R.id.ware_house2_name);
            this.wareHouse2Location = (TextView) rootView.findViewById(R.id.ware_house2_location);
            this.wareHouse2Temperature = (TextView) rootView.findViewById(R.id.ware_house2_temperature);
            this.wareHouse2Humidity = (TextView) rootView.findViewById(R.id.ware_house2_humidity);
            this.wareHouse2Remark = (TextView) rootView.findViewById(R.id.ware_house2_remark);
            this.wareHouse2ResponsiblePerson = (TextView) rootView.findViewById(R.id.ware_house2_responsiblePerson);
            this.wareHouse2Telephone = (TextView) rootView.findViewById(R.id.ware_house2_telephone);
            this.wareHouse2CardView = (CardView) rootView.findViewById(R.id.ware_house2_cardView);
        }

    }

    @Override
    public void onStop() {
        super.onStop();
        service.shutdown();
    }
}