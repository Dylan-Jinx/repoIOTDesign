package com.example.nutritional.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nutritional.R;
import com.example.nutritional.fragment.food.FoodFragment1;
import com.example.nutritional.fragment.food.FoodFragment2;
import com.example.nutritional.util.FragmentUtils;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author 69182
 */
public class FoodNutritionActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nutrientFood;
    private Button nutritionBtn;
    int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_nutrition);
        initView();
    }

    private void initView() {
        nutrientFood = (EditText) findViewById(R.id.nutrient_food);
        nutritionBtn = (Button) findViewById(R.id.nutrition_btn);
        FragmentUtils.ReplaceFragment(getSupportFragmentManager(),R.id.nutrition_frame,new FoodFragment1());
        nutritionBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.nutrition_btn:
                submit();
                break;
            default:
        }
    }

    private void submit() {
        // validate
        String food = nutrientFood.getText().toString().trim();
        if (TextUtils.isEmpty(food)) {
            Toast.makeText(this, "food不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
        flag++;
        FragmentUtils.ReplaceFragment(getSupportFragmentManager(),R.id.nutrition_frame,new FoodFragment2());
    }

    @Override
    public void onBackPressed() {
        if (flag==0){
            finish();
        }else {
            FragmentUtils.ReplaceFragment(getSupportFragmentManager(),R.id.nutrition_frame,new FoodFragment1());
            flag=0;
        }
    }
}