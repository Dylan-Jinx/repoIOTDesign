package com.example.nutritional.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nutritional.R;
import com.example.nutritional.fragment.portcompany.PortCompanyFragment1;
import com.example.nutritional.fragment.portcompany.PortCompanyFragment2;
import com.example.nutritional.util.FragmentUtils;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author 69182
 */
public class PortCompanyStaffActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText companyStaffId;
    private Button companyStaffBtn;
    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_port_company);
        initView();
    }

    private void initView() {
        companyStaffId = (EditText) findViewById(R.id.company_staff_id);
        companyStaffBtn = (Button) findViewById(R.id.company_staff_btn);

        FragmentUtils.ReplaceFragment(getSupportFragmentManager(), R.id.company_staff_frame, new PortCompanyFragment1());
        companyStaffBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.company_staff_btn:
                submit();
                break;
            default:
        }
    }

    private void submit() {
        // validate
        String id = companyStaffId.getText().toString().trim();
        if (TextUtils.isEmpty(id)) {
            Toast.makeText(this, "id不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
        flag++;
        FragmentUtils.ReplaceFragment(getSupportFragmentManager(), R.id.company_staff_frame, new PortCompanyFragment2());

    }

    @Override
    public void onBackPressed() {
        if (flag == 0) {
            finish();
        } else {
            FragmentUtils.ReplaceFragment(getSupportFragmentManager(), R.id.company_staff_frame, new PortCompanyFragment1());
            flag = 0;
        }
    }
}