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
import com.example.nutritional.fragment.cook.CookFragment1;
import com.example.nutritional.fragment.product.ProductFragment1;
import com.example.nutritional.fragment.product.ProductFragment2;
import com.example.nutritional.fragment.staff.StaffFragment2;
import com.example.nutritional.util.FragmentUtils;

import androidx.appcompat.app.AppCompatActivity;

public class ProductNumActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText productNumId;
    private Button productNumBtn;
    private Button productNumAdd;
    int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_num);
        initView();
    }

    private void initView() {
        productNumId = (EditText) findViewById(R.id.product_num_id);
        productNumBtn = (Button) findViewById(R.id.product_num_btn);
        productNumAdd = (Button) findViewById(R.id.product_num_add);

        FragmentUtils.ReplaceFragment(getSupportFragmentManager(),R.id.product_num_frame,new ProductFragment1());
        productNumBtn.setOnClickListener(this);
        productNumAdd.setOnClickListener(this);
        String type="家长";
        if (type.equals(LoginActivity.userType)){
            productNumAdd.setVisibility(View.GONE);
        }else {
            productNumAdd.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.product_num_btn:
                submit();
                break;
            case R.id.product_num_add:
                startActivity(new Intent(this,ProduNumOperationActivity.class));
                break;
            default:
        }
    }

    private void submit() {
        // validate
        String id = productNumId.getText().toString().trim();
        if (TextUtils.isEmpty(id)) {
            Toast.makeText(this, "id不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
        flag++;
        FragmentUtils.ReplaceFragment(getSupportFragmentManager(),R.id.product_num_frame,new ProductFragment2());
    }

    @Override
    public void onBackPressed() {
        if (flag==0){
            finish();
        }else {
            FragmentUtils.ReplaceFragment(getSupportFragmentManager(),R.id.product_num_frame,new ProductFragment1());
            flag=0;
        }
    }
}