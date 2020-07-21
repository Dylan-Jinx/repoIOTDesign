package com.example.nutritional.fragment.cook;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.nutritional.R;
import com.example.nutritional.bean.food.UseCookBookNameBySearchInfo;
import com.example.nutritional.bean.food.UseNutritionNameBySearchInfo;
import com.example.nutritional.util.ConstantsUtils;
import com.example.nutritional.util.HttpUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.FormBody;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @author 69182
 */
public class CookFragment2 extends Fragment {

    View view;
    private CircleImageView cook2Img;
    private TextView cook2Name;
    private TextView cook2Material;
    private TextView cook2Flavour;
    private TextView cook2NutritionalIngredient;
    private CardView cookCardView;
    ExecutorService service;

    UseCookBookNameBySearchInfo useCookBookNameBySearchInfo;
    List<UseCookBookNameBySearchInfo.CookBooksBean> beanList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_cook2, container, false);
        initView();
        return view;
    }

    private void initView() {
        service = newFixedThreadPool(1);
        beanList=new ArrayList<>();
        cook2Img=view.findViewById(R.id.cook2_img);
        cook2Name=view.findViewById(R.id.cook2_name);
        cook2Material=view.findViewById(R.id.cook2_material);
        cook2Flavour=view.findViewById(R.id.cook2_flavour);
        cook2NutritionalIngredient=view.findViewById(R.id.cook2_nutritionalIngredient);
        cookCardView=view.findViewById(R.id.cook_cardView);
        useCookBookNameBySearchData();
    }

    private void useCookBookNameBySearchData() {
        service.execute(new Runnable() {
            @Override
            public void run() {
                FormBody formBody=new FormBody.Builder()
                        .build();
                View viewById = getActivity().findViewById(R.id.cook_food);
                String string = ((TextView) viewById).getText().toString();
                String message="获取成功";
                try {
                    useCookBookNameBySearchInfo= HttpUtils.okHttpPost(ConstantsUtils.SERVER_URL_FOOD+ConstantsUtils.Address_UseCookBookNameBySearchInfo+"?cookbookname="+string,formBody,UseCookBookNameBySearchInfo.class);
                    if (message.equals(useCookBookNameBySearchInfo.getMessage())){
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                cookCardView.setVisibility(View.VISIBLE);
                                beanList.addAll(useCookBookNameBySearchInfo.getCookBooks());
                                cook2Name.setText(beanList.get(0).getName());
                                cook2Material.setText("原料："+beanList.get(0).getMaterial());
                                cook2Flavour.setText("味道："+beanList.get(0).getFlavour());
                                cook2NutritionalIngredient.setText("营养成分："+beanList.get(0).getNutritionalIngredient());
                                Glide.with(getActivity()).load(ConstantsUtils.SERVER_URL_FOOD+"/"+beanList.get(0).getImage()).into(cook2Img);
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
