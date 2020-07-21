package com.example.nutritional.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.nutritional.R;
import com.example.nutritional.fragment.cook.CookFragment1;
import com.example.nutritional.fragment.staff.StaffFragment1;
import com.example.nutritional.fragment.staff.StaffFragment2;
import com.example.nutritional.util.FragmentUtils;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author 69182
 */
public class StaffActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText staffId;
    private Button staffBtn;
    private FrameLayout staffFrame;
    int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff);
        initView();
    }

    private void initView() {
        staffId = (EditText) findViewById(R.id.staff_id);
        staffBtn = (Button) findViewById(R.id.staff_btn);
        staffFrame = (FrameLayout) findViewById(R.id.staff_frame);


        FragmentUtils.ReplaceFragment(getSupportFragmentManager(),R.id.staff_frame,new StaffFragment1());
        staffBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.staff_btn:
                submit();
                break;
            default:
        }
    }

    private void submit() {
        // validate
        String id = staffId.getText().toString().trim();
        if (TextUtils.isEmpty(id)) {
            Toast.makeText(this, "id不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
        flag++;
        FragmentUtils.ReplaceFragment(getSupportFragmentManager(),R.id.staff_frame,new StaffFragment2());

    }

    @Override
    public void onBackPressed() {
        if (flag==0){
            finish();
        }else {
            FragmentUtils.ReplaceFragment(getSupportFragmentManager(), R.id.staff_frame, new StaffFragment1());
            flag=0;
        }
    }
}