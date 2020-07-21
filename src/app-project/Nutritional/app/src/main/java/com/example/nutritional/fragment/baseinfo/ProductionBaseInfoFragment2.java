package com.example.nutritional.fragment.baseinfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.nutritional.R;
import com.example.nutritional.bean.safety.UserIdByBaseInfoSearch;
import com.example.nutritional.util.ConstantsUtils;
import com.example.nutritional.util.HttpUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.FormBody;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProductionBaseInfoFragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductionBaseInfoFragment2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private CircleImageView baseInfo2Img;
    private TextView baseInfo2Category;
    private TextView baseInfo2Name;
    private TextView baseInfo2ResponsibleName;
    private TextView baseInfo2Telephone;
    private CardView baseInfo2CardView;
    ExecutorService service;
    UserIdByBaseInfoSearch userIdByBaseInfoSearch;
    List<UserIdByBaseInfoSearch.ProductionBaseInfosBean> beanList;

    public ProductionBaseInfoFragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProductionBaseInfoFragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static ProductionBaseInfoFragment2 newInstance(String param1, String param2) {
        ProductionBaseInfoFragment2 fragment = new ProductionBaseInfoFragment2();
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
        View view = inflater.inflate(R.layout.fragment_production_base_info2, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        service= newFixedThreadPool(1);
        beanList=new ArrayList<>();
        baseInfo2Img = (CircleImageView) view.findViewById(R.id.base_info2_img);
        baseInfo2Category = (TextView) view.findViewById(R.id.base_info2_category);
        baseInfo2Name = (TextView) view.findViewById(R.id.base_info2_name);
        baseInfo2ResponsibleName = (TextView) view.findViewById(R.id.base_info2_responsibleName);
        baseInfo2Telephone = (TextView) view.findViewById(R.id.base_info2_telephone);
        baseInfo2CardView=view.findViewById(R.id.base_info2_cardView);

        userIdBySearch();
    }

    private void userIdBySearch() {
        service.execute(new Runnable() {
            @Override
            public void run() {
                FormBody formBody=new FormBody.Builder()
                        .build();
                View viewById = getActivity().findViewById(R.id.base_info_id);
                String string = ((TextView) viewById).getText().toString();
                try {
                    userIdByBaseInfoSearch= HttpUtils.okHttpPost(ConstantsUtils.SERVER_URL_SAFETY+ConstantsUtils.Address_UserIdByInfoSearch+"?id="+string,formBody,UserIdByBaseInfoSearch.class);
                    String message="操作成功";
                    if (message.equals(userIdByBaseInfoSearch.getMessage())){
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                baseInfo2CardView.setVisibility(View.VISIBLE);
                                beanList.addAll(userIdByBaseInfoSearch.getProductionBaseInfos());
                                baseInfo2Category.setText(beanList.get(0).getCategory());
                                baseInfo2Name.setText(beanList.get(0).getName());
                                baseInfo2ResponsibleName.setText("操作员："+beanList.get(0).getResponsibleName());
                                baseInfo2Telephone.setText("联系电话："+beanList.get(0).getTelephone());
                                Glide.with(getActivity()).load(ConstantsUtils.SERVER_URL_SAFETY+"/"+beanList.get(0).getImage()).into(baseInfo2Img);
                            }
                        });
                    }else {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getActivity(), userIdByBaseInfoSearch.getMessage(), Toast.LENGTH_SHORT).show();
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