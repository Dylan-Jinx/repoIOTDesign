package com.example.nutritional.activity.account;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.nutritional.R;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author 69182
 *
 *
 *
 */
public class AccountActivity extends AppCompatActivity implements View.OnClickListener {

    private Button accountUser;
    private Button accountLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        initView();
    }

    private void initView() {
        accountUser = (Button) findViewById(R.id.account_user);
        accountLogin = (Button) findViewById(R.id.account_login);

        accountUser.setOnClickListener(this);
        accountLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.account_user:
                startActivity(new Intent(AccountActivity.this,RegisterActivity.class));
                break;
            case R.id.account_login:
                startActivity(new Intent(AccountActivity.this,LoginActivity.class));
                break;
            default:
        }
    }
}