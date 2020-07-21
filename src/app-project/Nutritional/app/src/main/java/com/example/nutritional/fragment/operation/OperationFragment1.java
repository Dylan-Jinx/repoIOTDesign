package com.example.nutritional.fragment.operation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nutritional.R;
import com.example.nutritional.bean.school.AddStorage;
import com.example.nutritional.util.ConstantsUtils;
import com.example.nutritional.util.HttpUtils;

import java.io.IOException;
import java.util.concurrent.ExecutorService;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import okhttp3.FormBody;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @author 69182
 */
public
class OperationFragment1 extends Fragment {

    View view;
    private EditText operation1Productinfo;
    private EditText operation1Price;
    private EditText operation1time;
    private EditText operation1Remark;
    ExecutorService service;
    AddStorage addStorage;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_operation1, container, false);
        initView();
        return view;
    }

    private void initView() {
        service= newFixedThreadPool(1);
        operation1Productinfo=view.findViewById(R.id.operation1_productinfo);
        operation1Price=view.findViewById(R.id.operation1_price);
        operation1time=view.findViewById(R.id.operation1_time);
        operation1Remark=view.findViewById(R.id.operation1_remark);

        getActivity().findViewById(R.id.operation_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addStorageInfo();
            }
        });
    }

    private void addStorageInfo() {
        service.execute(new Runnable() {
            @Override
            public void run() {
                FormBody formBody=new FormBody.Builder()
                        .build();
                final String info = operation1Productinfo.getText().toString();
                final String price = operation1Price.getText().toString();
                final String time = operation1time.getText().toString();
                final String remark = operation1Remark.getText().toString();
                try {
                    addStorage= HttpUtils.okHttpPost(ConstantsUtils.SERVER_URL_SCHOOL+ConstantsUtils.Address_AddStorage
                            +"?productinfo="+info+"&price="+price+"&storagetime="+time+"&remark="+remark,formBody,AddStorage.class);
                    String message="添加成功";
                    if (message.equals(addStorage.getMessage())){
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getActivity(), "添加成功", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }else {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getActivity(), "添加失败", Toast.LENGTH_SHORT).show();
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
