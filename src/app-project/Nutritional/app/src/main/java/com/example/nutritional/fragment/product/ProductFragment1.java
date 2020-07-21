package com.example.nutritional.fragment.product;

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
import com.example.nutritional.bean.safety.GetAllProductInfo;
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
 * Use the {@link ProductFragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductFragment1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ListView product1ListView;
    ExecutorService service;
    GetAllProductInfo getAllProductInfo;
    List<GetAllProductInfo.ProductsBean> beanList;

    public ProductFragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProductFragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static ProductFragment1 newInstance(String param1, String param2) {
        ProductFragment1 fragment = new ProductFragment1();
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
        View view = inflater.inflate(R.layout.fragment_product1, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        service = newFixedThreadPool(1);
        beanList = new ArrayList<>();
        product1ListView=view.findViewById(R.id.product1_listView);

        getAllProductData();
    }

    private void getAllProductData() {
        service.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    getAllProductInfo = HttpUtils.okHttpGet(ConstantsUtils.SERVER_URL_SAFETY + ConstantsUtils.Address_GetAllProductInfo, GetAllProductInfo.class);
                    beanList.addAll(getAllProductInfo.getProducts());
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            product1ListView.setAdapter(new MyAdapter(beanList));
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    static class MyAdapter extends BaseAdapter {

        List<GetAllProductInfo.ProductsBean> beanList;

        public MyAdapter(List<GetAllProductInfo.ProductsBean> beanList) {
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_product, null);
            ViewHolder viewHolder=new ViewHolder(view);
            viewHolder.productProductinfo.setText(beanList.get(i).getProductInfo());
            viewHolder.productProductionbase.setText("基地："+beanList.get(i).getProductionBase());
            viewHolder.productProductnumber.setText("编码："+beanList.get(i).getProductNumber());
            viewHolder.productWarehouse.setText("仓库："+beanList.get(i).getWareHouse());
            Glide.with(viewGroup.getContext()).load(ConstantsUtils.SERVER_URL_SAFETY+"/"+beanList.get(i).getImage()).into(viewHolder.productImg);
            return view;
        }

        public static
        class ViewHolder {
            public View rootView;
            public CircleImageView productImg;
            public TextView productProductinfo;
            public TextView productProductionbase;
            public TextView productProductnumber;
            public TextView productWarehouse;

            public ViewHolder(View rootView) {
                this.rootView = rootView;
                this.productImg = (CircleImageView) rootView.findViewById(R.id.product_img);
                this.productProductinfo = (TextView) rootView.findViewById(R.id.product_productinfo);
                this.productProductionbase = (TextView) rootView.findViewById(R.id.product_productionbase);
                this.productProductnumber = (TextView) rootView.findViewById(R.id.product_productnumber);
                this.productWarehouse = (TextView) rootView.findViewById(R.id.product_warehouse);
            }

        }
    }

}