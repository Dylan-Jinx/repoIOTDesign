package com.example.nutritional.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.nutritional.R;
import com.example.nutritional.fragment.operation.OperationFragment1;
import com.example.nutritional.fragment.operation.OperationFragment2;
import com.example.nutritional.util.FragmentUtils;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author 69182
 */
public class StorageOperationActivity extends AppCompatActivity {

    private Switch operationSwitch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage_operation);
        initView();
    }

    private void initView() {
        operationSwitch = (Switch) findViewById(R.id.operation_switch);
        FragmentUtils.ReplaceFragment(getSupportFragmentManager(),R.id.operation_frame, new OperationFragment1());
        setClickLister();
    }

    private void setClickLister() {
        operationSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    operationSwitch.setText("修改");
                    FragmentUtils.ReplaceFragment(getSupportFragmentManager(),R.id.operation_frame, new OperationFragment2());
                }else {
                    operationSwitch.setText("添加");
                    FragmentUtils.ReplaceFragment(getSupportFragmentManager(),R.id.operation_frame, new OperationFragment1());
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}