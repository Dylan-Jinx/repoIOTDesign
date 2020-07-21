package com.example.nutritional.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nutritional.R;
import com.example.nutritional.fragment.house.WareHouseFragment1;
import com.example.nutritional.fragment.house.WareHouseFragment2;
import com.example.nutritional.util.FragmentUtils;

import androidx.appcompat.app.AppCompatActivity;

public class WareHouseActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText wareHouseId;
    private Button wareHouseBtn;
    int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ware_house);
        initView();
    }

    private void initView() {
        wareHouseId = (EditText) findViewById(R.id.ware_house_id);
        wareHouseBtn = (Button) findViewById(R.id.ware_house_btn);

        FragmentUtils.ReplaceFragment(getSupportFragmentManager(),R.id.ware_house_frame,new WareHouseFragment1());
        wareHouseBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ware_house_btn:
                submit();
                break;
            default:
        }
    }

    private void submit() {
        // validate
        String id = wareHouseId.getText().toString().trim();
        if (TextUtils.isEmpty(id)) {
            Toast.makeText(this, "id不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
        flag++;

        FragmentUtils.ReplaceFragment(getSupportFragmentManager(),R.id.ware_house_frame,new WareHouseFragment2());

    }

    @Override
    public void onBackPressed() {
        if (flag==0){
            finish();
        }else {
            FragmentUtils.ReplaceFragment(getSupportFragmentManager(),R.id.ware_house_frame,new WareHouseFragment1());
            flag=0;
        }
    }
}