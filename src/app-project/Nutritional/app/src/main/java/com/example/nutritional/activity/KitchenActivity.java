package com.example.nutritional.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nutritional.R;
import com.example.nutritional.fragment.kitchen.KitchenFragment1;
import com.example.nutritional.fragment.kitchen.KitchenFragment2;
import com.example.nutritional.util.FragmentUtils;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author 69182
 */
public class KitchenActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText kitchenCookHouseName;
    private Button kitchenBtn;
    int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen);
        initView();
    }

    private void initView() {
        kitchenCookHouseName = (EditText) findViewById(R.id.kitchen_cookHouseName);
        kitchenBtn = (Button) findViewById(R.id.kitchen_btn);

        FragmentUtils.ReplaceFragment(getSupportFragmentManager(),R.id.kitchen_frame,new KitchenFragment1());
        kitchenBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.kitchen_btn:
                submit();
                break;
            default:
        }
    }

    private void submit() {
        // validate
        String cookHouseName = kitchenCookHouseName.getText().toString().trim();
        if (TextUtils.isEmpty(cookHouseName)) {
            Toast.makeText(this, "cookHouseName不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
        flag++;
        FragmentUtils.ReplaceFragment(getSupportFragmentManager(),R.id.kitchen_frame,new KitchenFragment2());

    }

    @Override
    public void onBackPressed() {
        if (flag==0){
            finish();
        }else {
            FragmentUtils.ReplaceFragment(getSupportFragmentManager(),R.id.kitchen_frame,new KitchenFragment1());
            flag=0;
        }
    }
}