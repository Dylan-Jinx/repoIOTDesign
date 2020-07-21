package com.example.nutritional.fragment.food;

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
import com.example.nutritional.bean.food.GetAllFoodNutrition;
import com.example.nutritional.util.ConstantsUtils;
import com.example.nutritional.util.HttpUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import de.hdodenhof.circleimageview.CircleImageView;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @author 69182
 */
public
class FoodFragment1 extends Fragment {

    View view;
    private ListView foodListView;
    ExecutorService service;
    GetAllFoodNutrition getAllFoodNutrition;
    List<GetAllFoodNutrition.FoodNutritionsBean> beanList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_food1, container, false);
        initView();
        return view;
    }

    private void initView() {
        service = newFixedThreadPool(1);
        beanList = new ArrayList<>();
        foodListView = view.findViewById(R.id.food_listView);
        getAllFoodNutritionData();
    }

    private void getAllFoodNutritionData() {
        service.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    getAllFoodNutrition = HttpUtils.okHttpGet(ConstantsUtils.SERVER_URL_FOOD + ConstantsUtils.Address_GetAllFoodNutrition, GetAllFoodNutrition.class);
                    beanList.addAll(getAllFoodNutrition.getFoodNutritions());
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            foodListView.setAdapter(new MyAdapter(beanList));
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    static class MyAdapter extends BaseAdapter {

        List<GetAllFoodNutrition.FoodNutritionsBean> beanList;

        public MyAdapter(List<GetAllFoodNutrition.FoodNutritionsBean> beanList) {
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

        @SuppressLint("ViewHolder")
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_food, null);
            ViewHolder viewHolder=new ViewHolder(view);
            viewHolder.foodIntroduce.setText(beanList.get(i).getIntroduce());
            viewHolder.foodName.setText(beanList.get(i).getFoodName());
            viewHolder.foodNutritionalIngredient.setText(beanList.get(i).getNutritionalIngredient().trim());
            Glide.with(viewGroup.getContext()).load(ConstantsUtils.SERVER_URL_FOOD+"/"+beanList.get(i).getImages()).into(viewHolder.foodImg);
            return view;
        }

        public static
        class ViewHolder {
            public View rootView;
            public CircleImageView foodImg;
            public TextView foodName;
            public TextView foodNutritionalIngredient;
            public TextView foodIntroduce;

            public ViewHolder(View rootView) {
                this.rootView = rootView;
                this.foodImg = (CircleImageView) rootView.findViewById(R.id.food_img);
                this.foodName = (TextView) rootView.findViewById(R.id.food_name);
                this.foodNutritionalIngredient = (TextView) rootView.findViewById(R.id.food_nutritionalIngredient);
                this.foodIntroduce = (TextView) rootView.findViewById(R.id.food_introduce);
            }

        }
    }

    @Override
    public void onStop() {
        super.onStop();
        service.shutdown();
    }
}
