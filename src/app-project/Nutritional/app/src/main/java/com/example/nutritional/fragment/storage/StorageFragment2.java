package com.example.nutritional.fragment.storage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nutritional.R;
import com.example.nutritional.bean.school.GetConditionStorage;
import com.example.nutritional.util.ConstantsUtils;
import com.example.nutritional.util.HttpUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @author 69182
 */
public
class StorageFragment2 extends Fragment {

    View view;
    private TextView storageTime;
    private TextView storageProductInfo;
    private TextView storagePrice;
    private TextView storageRemark;
    private CardView storageCardView;
    ExecutorService service;
    GetConditionStorage getConditionStorage;
    List<GetConditionStorage.UserInfoBean> beanList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_storage2, container, false);
        initView();
        return view;
    }

    private void initView() {
        service = newFixedThreadPool(1);
        beanList = new ArrayList<>();
        storageTime = view.findViewById(R.id.storage_time);
        storageProductInfo = view.findViewById(R.id.storage_productInfo);
        storagePrice = view.findViewById(R.id.storage_price);
        storageRemark = view.findViewById(R.id.storage_remark);
        storageCardView = view.findViewById(R.id.storage_cardView);
        getConditionStorageData();
    }

    private void getConditionStorageData() {
        service.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    final View viewById = getActivity().findViewById(R.id.storage_id);
                    String string = ((TextView) viewById).getText().toString();
                    getConditionStorage = HttpUtils.okHttpGet(ConstantsUtils.SERVER_URL_SCHOOL + ConstantsUtils.Address_GetConditionStorage + "?productinfo=" + string, GetConditionStorage.class);
                    String s = "查询成功";
                    if (s.equals(getConditionStorage.getMessage())) {
                        beanList.addAll(getConditionStorage.getUserInfo());
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                storageCardView.setVisibility(View.VISIBLE);
                                storageProductInfo.setText(beanList.get(0).getProductInfo());
                                storageRemark.setText(beanList.get(0).getProductInfo());
                                storagePrice.setText("价格：" + beanList.get(0).getPrice());
                                storageTime.setText(beanList.get(0).getStorageTime());
                                Toast.makeText(getActivity(), "查询成功", Toast.LENGTH_SHORT).show();
                                ((TextView) viewById).setText("");
                            }
                        });
                    } else {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getActivity(), "输入名称有误", Toast.LENGTH_SHORT).show();
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
