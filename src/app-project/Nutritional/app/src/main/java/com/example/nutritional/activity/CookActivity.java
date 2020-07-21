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
import com.example.nutritional.fragment.cook.CookFragment2;
import com.example.nutritional.util.FragmentUtils;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author 69182
 */
public class CookActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText cookFood;
    private Button cookBtn;
    private Button cookAdd;
    int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cook);
        initView();
    }

    private void initView() {
        cookFood = (EditText) findViewById(R.id.cook_food);
        cookBtn = (Button) findViewById(R.id.cook_btn);
        FragmentUtils.ReplaceFragment(getSupportFragmentManager(), R.id.cook_frame, new CookFragment1());
        cookBtn.setOnClickListener(this);
        cookAdd = (Button) findViewById(R.id.cook_add);
        cookAdd.setOnClickListener(this);
        String type="家长";
        if (type.equals(LoginActivity.userType)){
            cookAdd.setVisibility(View.GONE);
        }else {
            cookAdd.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cook_btn:
                submit();
                break;

            case R.id.cook_add:
                startActivity(new Intent(CookActivity.this,CookOperationActivity.class));
                break;
            default:
        }
    }

    private void submit() {
        // validate
        String food = cookFood.getText().toString().trim();
        if (TextUtils.isEmpty(food)) {
            Toast.makeText(this, "food不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
        flag++;
        FragmentUtils.ReplaceFragment(getSupportFragmentManager(), R.id.cook_frame, new CookFragment2());

    }

    @Override
    public void onBackPressed() {
        if (flag==0){
            finish();
        }else {
            FragmentUtils.ReplaceFragment(getSupportFragmentManager(), R.id.cook_frame, new CookFragment1());
            flag=0;
        }
    }
}