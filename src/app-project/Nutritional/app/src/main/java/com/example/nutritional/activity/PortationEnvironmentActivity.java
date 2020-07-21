package com.example.nutritional.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nutritional.R;
import com.example.nutritional.fragment.environment.PortationEnvironmentFragment1;
import com.example.nutritional.fragment.environment.PortationEnvironmentFragment2;
import com.example.nutritional.util.FragmentUtils;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author 69182
 */
public class PortationEnvironmentActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText environmentId;
    private Button environmentBtn;
    int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portation_environment);
        initView();
    }

    private void initView() {
        environmentId = (EditText) findViewById(R.id.environment_id);
        environmentBtn = (Button) findViewById(R.id.environment_btn);

        FragmentUtils.ReplaceFragment(getSupportFragmentManager(),R.id.environment_frame,new PortationEnvironmentFragment1());
        environmentBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.environment_btn:
                submit();
                break;
            default:
        }
    }

    private void submit() {
        // validate
        String id = environmentId.getText().toString().trim();
        if (TextUtils.isEmpty(id)) {
            Toast.makeText(this, "id不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
        flag++;
        FragmentUtils.ReplaceFragment(getSupportFragmentManager(),R.id.environment_frame,new PortationEnvironmentFragment2());


    }

    @Override
    public void onBackPressed() {
        if (flag==0){
            finish();
        }else {
            FragmentUtils.ReplaceFragment(getSupportFragmentManager(),R.id.environment_frame,new PortationEnvironmentFragment1());
            flag=0;
        }
    }
}