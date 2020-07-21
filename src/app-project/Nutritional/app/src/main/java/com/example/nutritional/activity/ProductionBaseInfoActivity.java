package com.example.nutritional.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nutritional.R;
import com.example.nutritional.activity.account.LoginActivity;
import com.example.nutritional.fragment.baseinfo.ProductionBaseInfoFragment1;
import com.example.nutritional.fragment.baseinfo.ProductionBaseInfoFragment2;
import com.example.nutritional.fragment.product.ProductFragment1;
import com.example.nutritional.util.FragmentUtils;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author 69182
 */
public class ProductionBaseInfoActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText baseInfoId;
    private Button baseInfoBtn;
    private Button baseAddUpdate;
    int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_production_base_info);
        initView();
    }

    private void initView() {
        baseInfoId = (EditText) findViewById(R.id.base_info_id);
        baseInfoBtn = (Button) findViewById(R.id.base_info_btn);
        baseAddUpdate = (Button) findViewById(R.id.base_add_update);
        FragmentUtils.ReplaceFragment(getSupportFragmentManager(),R.id.base_info_frame,new ProductionBaseInfoFragment1());
        baseInfoBtn.setOnClickListener(this);
        baseAddUpdate.setOnClickListener(this);
        String type="家长";
        if (type.equals(LoginActivity.userType)){
            baseAddUpdate.setVisibility(View.GONE);
        }else {
            baseAddUpdate.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.base_info_btn:
                submit();
                break;
            case R.id.base_add_update:
                startActivity(new Intent(this,ProductionOperationActivity.class));
                break;
            default:
        }
    }

    private void submit() {
        // validate
        String id = baseInfoId.getText().toString().trim();
        if (TextUtils.isEmpty(id)) {
            Toast.makeText(this, "id不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
        flag++;
        FragmentUtils.ReplaceFragment(getSupportFragmentManager(),R.id.base_info_frame,new ProductionBaseInfoFragment2());
    }

    @Override
    public void onBackPressed() {
        if (flag==0){
            finish();
        }else {
            FragmentUtils.ReplaceFragment(getSupportFragmentManager(),R.id.base_info_frame,new ProductionBaseInfoFragment1());
            flag=0;
        }
    }
}