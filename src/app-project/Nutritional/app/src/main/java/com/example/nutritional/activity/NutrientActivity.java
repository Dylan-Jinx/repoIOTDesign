package com.example.nutritional.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nutritional.R;
import com.example.nutritional.fragment.nutrient.NutrientFragment1;
import com.example.nutritional.fragment.nutrient.NutrientFragment2;
import com.example.nutritional.util.FragmentUtils;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author 69182
 */
public class NutrientActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nutrientSelectName;
    private Button nutritionBtn;
    int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrient);
        initView();
    }

    private void initView() {
        nutrientSelectName = (EditText) findViewById(R.id.nutrientSelectName);
        nutritionBtn = (Button) findViewById(R.id.nutritionBtn);

        FragmentUtils.ReplaceFragment(getSupportFragmentManager(),R.id.nutritionFrame,new NutrientFragment1());
        nutritionBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.nutritionBtn:
                submit();
                break;
            default:
        }
    }

    private void submit() {
        // validate
        String nutrientSelectNameString = nutrientSelectName.getText().toString().trim();
        if (TextUtils.isEmpty(nutrientSelectNameString)) {
            Toast.makeText(this, "nutrientSelectNameString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
        flag++;
        FragmentUtils.ReplaceFragment(getSupportFragmentManager(),R.id.nutritionFrame,new NutrientFragment2());

    }

    @Override
    public void onBackPressed() {
        if (flag==0){
            finish();
        }else {
            FragmentUtils.ReplaceFragment(getSupportFragmentManager(),R.id.nutritionFrame,new NutrientFragment2());
            flag=0;
        }
    }
}