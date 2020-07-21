package com.example.nutritional.fragment.food;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.nutritional.R;
import com.example.nutritional.bean.food.UseFoodNameBySearchInfo;
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
public
class FoodFragment2 extends Fragment {

    View view;
    private CircleImageView food2Img;
    private TextView food2Name;
    private TextView food2NutritionalIngredient;
    private TextView food2Introduce;
    private CardView food2CardView;
    ExecutorService service;
    UseFoodNameBySearchInfo useFoodNameBySearchInfo;
    List<UseFoodNameBySearchInfo.FoodNutritionsBean> beanList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_food2, container, false);
        initView();
        return view;
    }

    private void initView() {
        service = newFixedThreadPool(1);
        beanList = new ArrayList<>();
        food2CardView = view.findViewById(R.id.food2_cardView);
        food2Img = view.findViewById(R.id.food2_img);
        food2Name = view.findViewById(R.id.food2_name);
        food2NutritionalIngredient = view.findViewById(R.id.food2_nutritionalIngredient);
        food2Introduce = view.findViewById(R.id.food2_introduce);
        useFoodNameBySearchData();
    }

    private void useFoodNameBySearchData() {
        service.execute(new Runnable() {
            @Override
            public void run() {
                View viewById = getActivity().findViewById(R.id.nutrient_food);
                String string = ((TextView) viewById).getText().toString();
                FormBody formBody = new FormBody.Builder()
                        .build();
                try {
                    useFoodNameBySearchInfo = HttpUtils.okHttpPost(ConstantsUtils.SERVER_URL_FOOD + ConstantsUtils.Address_UseFoodNameBySearchInfo + "?foodname=" + string, formBody, UseFoodNameBySearchInfo.class);
                    String message = "获取成功";
                    if (message.equals(useFoodNameBySearchInfo.getMessage())) {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                beanList.addAll(useFoodNameBySearchInfo.getFoodNutritions());
                                food2CardView.setVisibility(View.VISIBLE);
                                Glide.with(getActivity()).load(ConstantsUtils.SERVER_URL_FOOD + "/" + beanList.get(0).getImages()).into(food2Img);
                                food2Name.setText(beanList.get(0).getFoodName());
                                food2NutritionalIngredient.setText(beanList.get(0).getNutritionalIngredient());
                                food2Introduce.setText(beanList.get(0).getIntroduce());
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
