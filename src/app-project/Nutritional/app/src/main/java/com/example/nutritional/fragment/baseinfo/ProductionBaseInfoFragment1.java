package com.example.nutritional.fragment.baseinfo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.nutritional.R;
import com.example.nutritional.bean.safety.GetAllProductionBaseInfo;
import com.example.nutritional.util.ConstantsUtils;
import com.example.nutritional.util.HttpUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import androidx.fragment.app.Fragment;
import de.hdodenhof.circleimageview.CircleImageView;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProductionBaseInfoFragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductionBaseInfoFragment1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ListView baseInfo1ListView;
    ExecutorService service;
    GetAllProductionBaseInfo getAllProductionBaseInfo;
    List<GetAllProductionBaseInfo.ProductionBaseInfosBean> beanList;

    public ProductionBaseInfoFragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProductionBaseInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProductionBaseInfoFragment1 newInstance(String param1, String param2) {
        ProductionBaseInfoFragment1 fragment = new ProductionBaseInfoFragment1();
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
        View view = inflater.inflate(R.layout.fragment_production_base_info1, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        service = newFixedThreadPool(1);
        beanList = new ArrayList<>();
        baseInfo1ListView = view.findViewById(R.id.base_info1_listView);
        getAllProductionBaseData();
    }

    private void getAllProductionBaseData() {
        service.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    getAllProductionBaseInfo = HttpUtils.okHttpGet(ConstantsUtils.SERVER_URL_SAFETY + ConstantsUtils.Address_GetAllProductionBaseInfo, GetAllProductionBaseInfo.class);
                    beanList.addAll(getAllProductionBaseInfo.getProductionBaseInfos());
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            baseInfo1ListView.setAdapter(new MyAdapter(beanList));
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    static class MyAdapter extends BaseAdapter {

        List<GetAllProductionBaseInfo.ProductionBaseInfosBean> beanList;

        public MyAdapter(List<GetAllProductionBaseInfo.ProductionBaseInfosBean> beanList) {
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_base_info, null);
            ViewHolder viewHolder = new ViewHolder(view);
            viewHolder.baseInfoName.setText(beanList.get(i).getName());
            viewHolder.baseInfoCategory.setText(beanList.get(i).getCategory());
            viewHolder.baseInfoResponsibleName.setText("操作员："+beanList.get(i).getResponsibleName());
            viewHolder.baseInfoTelephone.setText("联系电话："+beanList.get(i).getTelephone());
            Glide.with(viewGroup.getContext()).load(ConstantsUtils.SERVER_URL_SAFETY+"/"+beanList.get(i).getImage()).into(viewHolder.baseInfoImg);
            return view;
        }

        public static
        class ViewHolder {
            public View rootView;
            public CircleImageView baseInfoImg;
            public TextView baseInfoCategory;
            public TextView baseInfoName;
            public TextView baseInfoResponsibleName;
            public TextView baseInfoTelephone;

            public ViewHolder(View rootView) {
                this.rootView = rootView;
                this.baseInfoImg = (CircleImageView) rootView.findViewById(R.id.base_info_img);
                this.baseInfoCategory = (TextView) rootView.findViewById(R.id.base_info_category);
                this.baseInfoName = (TextView) rootView.findViewById(R.id.base_info_name);
                this.baseInfoResponsibleName = (TextView) rootView.findViewById(R.id.base_info_responsibleName);
                this.baseInfoTelephone = (TextView) rootView.findViewById(R.id.base_info_telephone);
            }

        }
    }

}