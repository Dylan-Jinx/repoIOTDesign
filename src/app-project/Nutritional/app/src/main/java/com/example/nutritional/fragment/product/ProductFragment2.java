package com.example.nutritional.fragment.product;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.nutritional.R;
import com.example.nutritional.bean.safety.UserIdByProductSearch;
import com.example.nutritional.util.ConstantsUtils;
import com.example.nutritional.util.HttpUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.FormBody;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProductFragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductFragment2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ExecutorService service;
    UserIdByProductSearch userIdByProductSearch;
    List<UserIdByProductSearch.ProductsBean> beanList;

    public ProductFragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProductFragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static ProductFragment2 newInstance(String param1, String param2) {
        ProductFragment2 fragment = new ProductFragment2();
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
        View view = inflater.inflate(R.layout.fragment_product2, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        service = newFixedThreadPool(1);
        beanList = new ArrayList<>();
        ViewHolder viewHolder=new ViewHolder(view);

        userIdBySearch(viewHolder);
    }

    private void userIdBySearch(final ViewHolder viewHolder) {
        service.execute(new Runnable() {
            @Override
            public void run() {
                FormBody formBody = new FormBody.Builder()
                        .build();
                View viewById = getActivity().findViewById(R.id.product_num_id);
                String string = ((TextView) viewById).getText().toString();
                try {
                    userIdByProductSearch = HttpUtils.okHttpPost(ConstantsUtils.SERVER_URL_SAFETY + ConstantsUtils.Address_UserIdByNumSearch + "?id=" + string, formBody, UserIdByProductSearch.class);
                    String message = "操作成功";
                    if (message.equals(userIdByProductSearch.getMessage())) {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                beanList.addAll(userIdByProductSearch.getProducts());
                                viewHolder.product2CardView.setVisibility(View.VISIBLE);
                                viewHolder.product2Productinfo.setText(beanList.get(0).getProductInfo());
                                viewHolder.product2Productionbase.setText("基地："+beanList.get(0).getProductionBase());
                                viewHolder.product2Productnumber.setText("编码："+beanList.get(0).getProductNumber());
                                viewHolder.product2Warehouse.setText("仓库："+beanList.get(0).getWareHouse());
                                Glide.with(getActivity()).load(ConstantsUtils.SERVER_URL_SAFETY+"/"+beanList.get(0).getImage()).into(viewHolder.product2Img);
                            }
                        });
                    }else {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getActivity(), userIdByProductSearch.getMessage(), Toast.LENGTH_SHORT).show();
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
        public CircleImageView product2Img;
        public TextView product2Productinfo;
        public TextView product2Productionbase;
        public TextView product2Productnumber;
        public TextView product2Warehouse;
        public CardView product2CardView;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.product2Img = (CircleImageView) rootView.findViewById(R.id.product2_img);
            this.product2Productinfo = (TextView) rootView.findViewById(R.id.product2_productinfo);
            this.product2Productionbase = (TextView) rootView.findViewById(R.id.product2_productionbase);
            this.product2Productnumber = (TextView) rootView.findViewById(R.id.product2_productnumber);
            this.product2Warehouse = (TextView) rootView.findViewById(R.id.product2_warehouse);
            this.product2CardView = (CardView) rootView.findViewById(R.id.product2_cardView);
        }

    }
}