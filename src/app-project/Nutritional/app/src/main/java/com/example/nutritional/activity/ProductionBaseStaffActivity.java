package com.example.nutritional.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nutritional.R;
import com.example.nutritional.fragment.basestaff.ProductionBaseStaffFragment1;
import com.example.nutritional.fragment.basestaff.ProductionBaseStaffFragment2;
import com.example.nutritional.util.FragmentUtils;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author 69182
 */
public class ProductionBaseStaffActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText baseStaffId;
    private Button baseStaffBtn;
    int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_production_base_staff);
        initView();
    }

    private void initView() {
        baseStaffId = (EditText) findViewById(R.id.base_staff_id);
        baseStaffBtn = (Button) findViewById(R.id.base_staff_btn);
        FragmentUtils.ReplaceFragment(getSupportFragmentManager(),R.id.base_staff_frame,new ProductionBaseStaffFragment1());
        baseStaffBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.base_staff_btn:
                submit();
                break;
            default:
        }
    }

    private void submit() {
        // validate
        String id = baseStaffId.getText().toString().trim();
        if (TextUtils.isEmpty(id)) {
            Toast.makeText(this, "id不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
        flag++;
        FragmentUtils.ReplaceFragment(getSupportFragmentManager(),R.id.base_staff_frame,new ProductionBaseStaffFragment2());


    }

    @Override
    public void onBackPressed() {
        if (flag==0){
            finish();
        }else {
            FragmentUtils.ReplaceFragment(getSupportFragmentManager(),R.id.base_staff_frame,new ProductionBaseStaffFragment1());
            flag=0;
        }
    }
}