package com.example.nutritional.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nutritional.R;
import com.example.nutritional.fragment.company.CompanyFragment1;
import com.example.nutritional.fragment.company.CompanyFragment2;
import com.example.nutritional.util.FragmentUtils;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author 69182
 */
public class TransCompanyActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText companyId;
    private Button companyBtn;
    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans_company);
        initView();
    }

    private void initView() {
        companyId = (EditText) findViewById(R.id.company_id);
        companyBtn = (Button) findViewById(R.id.company_btn);

        FragmentUtils.ReplaceFragment(getSupportFragmentManager(), R.id.company_frame, new CompanyFragment1());
        companyBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.company_btn:
                submit();
                break;
            default:
        }
    }

    private void submit() {
        // validate
        String id = companyId.getText().toString().trim();
        if (TextUtils.isEmpty(id)) {
            Toast.makeText(this, "id不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
        flag++;
        FragmentUtils.ReplaceFragment(getSupportFragmentManager(), R.id.company_frame, new CompanyFragment2());

    }

    @Override
    public void onBackPressed() {
        if (flag == 0) {
            finish();
        } else {
            FragmentUtils.ReplaceFragment(getSupportFragmentManager(), R.id.company_frame, new CompanyFragment1());
            flag = 0;
        }
    }
}