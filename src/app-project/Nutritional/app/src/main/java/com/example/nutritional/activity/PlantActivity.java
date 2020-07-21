package com.example.nutritional.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nutritional.R;
import com.example.nutritional.fragment.cook.CookFragment1;
import com.example.nutritional.fragment.plant.PlantFragment1;
import com.example.nutritional.fragment.plant.PlantFragment2;
import com.example.nutritional.util.FragmentUtils;

import androidx.appcompat.app.AppCompatActivity;

public class PlantActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText plateId;
    private Button plateBtn;
int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant);
        initView();
    }

    private void initView() {
        plateId = (EditText) findViewById(R.id.plate_id);
        plateBtn = (Button) findViewById(R.id.plate_btn);

        FragmentUtils.ReplaceFragment(getSupportFragmentManager(),R.id.plate_frame,new PlantFragment1());
        plateBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.plate_btn:
                submit();
                break;
            default:
        }
    }

    private void submit() {
        // validate
        String id = plateId.getText().toString().trim();
        if (TextUtils.isEmpty(id)) {
            Toast.makeText(this, "id不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
        flag++;
        FragmentUtils.ReplaceFragment(getSupportFragmentManager(),R.id.plate_frame,new PlantFragment2());

    }

    @Override
    public void onBackPressed() {
        if (flag==0){
            finish();
        }else {
            FragmentUtils.ReplaceFragment(getSupportFragmentManager(), R.id.plate_frame, new PlantFragment1());
            flag=0;
        }
    }
}