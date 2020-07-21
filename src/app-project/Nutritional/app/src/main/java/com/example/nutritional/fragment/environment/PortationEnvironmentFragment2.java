package com.example.nutritional.fragment.environment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nutritional.R;
import com.example.nutritional.bean.safety.UseProductNumSearchInfo;
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
 * Use the {@link PortationEnvironmentFragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PortationEnvironmentFragment2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ExecutorService service;
    UseProductNumSearchInfo useProductNumSearchInfo;
    List<UseProductNumSearchInfo.EnvironmentInfosBean> beanList;

    public PortationEnvironmentFragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PortationEnvironmentFragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static PortationEnvironmentFragment2 newInstance(String param1, String param2) {
        PortationEnvironmentFragment2 fragment = new PortationEnvironmentFragment2();
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
        View view = inflater.inflate(R.layout.fragment_portation_environment2, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        service = newFixedThreadPool(1);
        beanList = new ArrayList<>();

        useProductNumSearch(view);
    }

    private void useProductNumSearch(final View view) {
        service.execute(new Runnable() {
            @Override
            public void run() {
                FormBody formBody = new FormBody.Builder()
                        .build();
                View viewById = getActivity().findViewById(R.id.environment_id);
                String string = ((TextView) viewById).getText().toString();
                try {
                    useProductNumSearchInfo = HttpUtils.okHttpPost(ConstantsUtils.SERVER_URL_SAFETY + ConstantsUtils.Address_UseProductNumSearchInfo + "?productnum=" + string, formBody, UseProductNumSearchInfo.class);
                    String message = "操作成功";
                    if (message.equals(useProductNumSearchInfo.getMessage())) {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                beanList.addAll(useProductNumSearchInfo.getEnvironmentInfos());
                                ViewHolder viewHolder = new ViewHolder(view);
                                viewHolder.environment2CardView.setVisibility(View.VISIBLE);
                                viewHolder.environment2Timer.setText(beanList.get(0).getDateTime());
                                viewHolder.environment2Driver.setText("驾驶员："+beanList.get(0).getDriver());
                                viewHolder.environment2Humidity.setText("湿度："+beanList.get(0).getHumidity());
                                viewHolder.environment2Plate.setText(beanList.get(0).getPlate());
                                viewHolder.environment2Temperature.setText("温度："+beanList.get(0).getTemperature());
                                viewHolder.environment2Telephone.setText("联系电话："+beanList.get(0).getTelephone());
                            }
                        });
                    } else {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getActivity(), useProductNumSearchInfo.getMessage(), Toast.LENGTH_SHORT).show();
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

    public static
    class ViewHolder {
        public View rootView;
        public TextView environment2Timer;
        public TextView environment2Plate;
        public TextView environment2ProductNumber;
        public TextView environment2Temperature;
        public TextView environment2Humidity;
        public TextView environment2Driver;
        public TextView environment2Telephone;
        public CardView environment2CardView;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.environment2Timer = (TextView) rootView.findViewById(R.id.environment2_timer);
            this.environment2Plate = (TextView) rootView.findViewById(R.id.environment2_plate);
            this.environment2ProductNumber = (TextView) rootView.findViewById(R.id.environment2_productNumber);
            this.environment2Temperature = (TextView) rootView.findViewById(R.id.environment2_temperature);
            this.environment2Humidity = (TextView) rootView.findViewById(R.id.environment2_humidity);
            this.environment2Driver = (TextView) rootView.findViewById(R.id.environment2_driver);
            this.environment2Telephone = (TextView) rootView.findViewById(R.id.environment2_telephone);
            this.environment2CardView = (CardView) rootView.findViewById(R.id.environment2_cardView);
        }

    }
}