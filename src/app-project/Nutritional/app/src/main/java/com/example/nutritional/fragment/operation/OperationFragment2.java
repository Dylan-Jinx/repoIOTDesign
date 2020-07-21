package com.example.nutritional.fragment.operation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nutritional.R;
import com.example.nutritional.bean.school.UpdateStorage;
import com.example.nutritional.util.ConstantsUtils;
import com.example.nutritional.util.HttpUtils;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import okhttp3.FormBody;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @author 69182
 */
public
class OperationFragment2 extends Fragment {

    View view;
    private EditText operation2Productinfo;
    private EditText operation2Price;
    private EditText operation2Time;
    private EditText operation2Remark;
    ExecutorService service;
    UpdateStorage updateStorage;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_operation2, container, false);
        initView();
        return view;
    }

    private void initView() {
        service = newFixedThreadPool(1);
        operation2Productinfo = view.findViewById(R.id.operation2_productinfo);
        operation2Price = view.findViewById(R.id.operation2_price);
        operation2Time = view.findViewById(R.id.operation2_time);
        operation2Remark = view.findViewById(R.id.operation2_remark);


        getActivity().findViewById(R.id.operation_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateStorageInfo();
            }
        });
    }

    private void UpdateStorageInfo() {
        service.execute(new Runnable() {
            @Override
            public void run() {
                FormBody formBody = new FormBody.Builder()
                        .build();
                final String info = operation2Productinfo.getText().toString();
                final String price = operation2Price.getText().toString();
                final String time = operation2Time.getText().toString();
                final String remark = operation2Remark.getText().toString();
                try {
                    updateStorage = HttpUtils.okHttpPost(ConstantsUtils.SERVER_URL_SCHOOL + ConstantsUtils.Address_UpdateStorage
                            + "?conditionuserproductinfo=" + info + "&productinfo=" + info + "&price=" + price + "&storagetime=" + time + "&remark=" + remark, formBody, UpdateStorage.class);
                    String message = "修改成功";
                    if (message.equals(updateStorage.getMessage())) {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getActivity(), "修改成功", Toast.LENGTH_SHORT).show();
                            }
                        });
                    } else {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getActivity(), "修改失败", Toast.LENGTH_SHORT).show();
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
