package com.example.nutritional.fragment.cook;

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
import com.example.nutritional.bean.food.GetAllCookBook;
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
class CookFragment1 extends Fragment {

    View view;
    private ListView cookListView;
    ExecutorService service;
    GetAllCookBook getAllCookBook;
    List<GetAllCookBook.CookBooksBean> beanList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_cook1, container, false);
        initView();
        return view;
    }

    private void initView() {
        service = newFixedThreadPool(1);
        beanList = new ArrayList<>();
        cookListView = view.findViewById(R.id.cook_listView);
        getAllFoodNutritionData();
    }

    private void getAllFoodNutritionData() {
        service.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    getAllCookBook = HttpUtils.okHttpGet(ConstantsUtils.SERVER_URL_FOOD + ConstantsUtils.Address_GetAllCookBook, GetAllCookBook.class);
                    beanList.addAll(getAllCookBook.getCookBooks());
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            cookListView.setAdapter(new MyAdapter(beanList));
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    static class MyAdapter extends BaseAdapter {

        List<GetAllCookBook.CookBooksBean> beanList;

        public MyAdapter(List<GetAllCookBook.CookBooksBean> beanList) {
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cook, null);
            ViewHolder viewHolder=new ViewHolder(view);
            viewHolder.cookFlavour.setText("味道："+beanList.get(i).getFlavour());
            viewHolder.cookMaterial.setText("原料："+beanList.get(i).getMaterial());
            viewHolder.cookName.setText(beanList.get(i).getName());
            viewHolder.cookNutritionalIngredient.setText("营养成分："+beanList.get(i).getNutritionalIngredient());
            Glide.with(viewGroup.getContext()).load(ConstantsUtils.SERVER_URL_FOOD+"/"+beanList.get(i).getImage()).into(viewHolder.cookImg);
            return view;
        }

        public static
        class ViewHolder {
            public View rootView;
            public CircleImageView cookImg;
            public TextView cookName;
            public TextView cookMaterial;
            public TextView cookFlavour;
            public TextView cookNutritionalIngredient;

            public ViewHolder(View rootView) {
                this.rootView = rootView;
                this.cookImg = (CircleImageView) rootView.findViewById(R.id.cook_img);
                this.cookName = (TextView) rootView.findViewById(R.id.cook_name);
                this.cookMaterial = (TextView) rootView.findViewById(R.id.cook_material);
                this.cookFlavour = (TextView) rootView.findViewById(R.id.cook_flavour);
                this.cookNutritionalIngredient = (TextView) rootView.findViewById(R.id.cook_nutritionalIngredient);
            }

        }
    }

    @Override
    public void onStop() {
        super.onStop();
        service.shutdown();
    }
}
