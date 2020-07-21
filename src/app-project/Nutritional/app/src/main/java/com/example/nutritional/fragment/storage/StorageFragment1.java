package com.example.nutritional.fragment.storage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.nutritional.R;
import com.example.nutritional.bean.school.GetAllStorage;
import com.example.nutritional.util.ConstantsUtils;
import com.example.nutritional.util.HttpUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @author 69182
 */
public
class StorageFragment1 extends Fragment {

    View view;
    private ListView storageListView;
    ExecutorService service;
    GetAllStorage getAllStorage;
    List<GetAllStorage.UserInfoBean> beanList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_storage1, container, false);
        initView();
        return view;
    }

    private void initView() {
        service = newFixedThreadPool(1);
        beanList = new ArrayList<>();
        storageListView = view.findViewById(R.id.storage_listView);
        getAllStorage();
    }

    private void getAllStorage() {
        service.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    getAllStorage = HttpUtils.okHttpGet(ConstantsUtils.SERVER_URL_SCHOOL + ConstantsUtils.Address_GetAllStorage, GetAllStorage.class);
                    beanList.addAll(getAllStorage.getUserInfo());
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            storageListView.setAdapter(new MyAdapter(beanList));
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    static class MyAdapter extends BaseAdapter {

        public MyAdapter(List<GetAllStorage.UserInfoBean> beanList) {
            this.beanList = beanList;
        }

        List<GetAllStorage.UserInfoBean> beanList;

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

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_storage, null);
            ViewHolder viewHolder=new ViewHolder(view);
            viewHolder.storageRemark.setText(beanList.get(i).getRemark());
            viewHolder.storageTime.setText(beanList.get(i).getStorageTime());
            viewHolder.storageProductInfo.setText(beanList.get(i).getProductInfo());
            viewHolder.storagePrice.setText("价格"+beanList.get(i).getPrice());
            return view;
        }

        public static
        class ViewHolder {
            public View rootView;
            public TextView storageTime;
            public TextView storageProductInfo;
            public TextView storagePrice;
            public TextView storageRemark;

            public ViewHolder(View rootView) {
                this.rootView = rootView;
                this.storageTime = (TextView) rootView.findViewById(R.id.storage_time);
                this.storageProductInfo = (TextView) rootView.findViewById(R.id.storage_productInfo);
                this.storagePrice = (TextView) rootView.findViewById(R.id.storage_price);
                this.storageRemark = (TextView) rootView.findViewById(R.id.storage_remark);
            }

        }
    }

    @Override
    public void onStop() {
        super.onStop();
        service.shutdown();
    }
}
