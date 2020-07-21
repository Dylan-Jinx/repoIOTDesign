package com.example.nutritional.activity.account;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.nutritional.R;

import com.example.nutritional.activity.main.MainActivity;
import com.example.nutritional.bean.user.VerificationParentInfoBean;
import com.example.nutritional.bean.user.VerificationUserInfoBean;

import com.example.nutritional.eventbus.EventBusParentInfo;
import com.example.nutritional.eventbus.EventBusStaffInfo;
import com.example.nutritional.util.ConstantsUtils;
import com.example.nutritional.util.HttpUtils;
import com.example.nutritional.view.ClearEditTextView;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.concurrent.ExecutorService;


import androidx.appcompat.app.AppCompatActivity;
import okhttp3.FormBody;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @author 69182
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ClearEditTextView loginUser;
    private EditText loginPwd;
    private ImageView imagePwd;
    private RadioButton radioParent;
    private RadioButton radioStaff;
    private Button loginBtn;
    int flag = 0;
    private RadioGroup loginGroup;
    public static String userType = null;
    /**
     * POST 验证T_ParentInfo（家长表）用户名密码是否正确
     */
    VerificationParentInfoBean verificationParentInfoBean;
    /**
     * POST 验证员工用户名密码是否正确
     */
    VerificationUserInfoBean verificationUserInfoBean;
    ExecutorService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        service = newFixedThreadPool(1);
        loginUser = (ClearEditTextView) findViewById(R.id.login_user);
        loginPwd = (EditText) findViewById(R.id.login_pwd);
        imagePwd = (ImageView) findViewById(R.id.image_pwd);
        radioParent = (RadioButton) findViewById(R.id.radio_parent);
        radioStaff = (RadioButton) findViewById(R.id.radio_staff);
        loginBtn = (Button) findViewById(R.id.login_btn);
        loginGroup = (RadioGroup) findViewById(R.id.login_group);
        imagePwd.setOnClickListener(this);
        loginPwd.setOnClickListener(this);
        loginBtn.setOnClickListener(this);
        loginGroup.setOnClickListener(this);
        userType = radioParent.getText().toString();
        //判断密码状态
        clickPwdState();
        //判断用户状态
        clickUserState();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_btn:
                submit();
                break;
            case R.id.image_pwd:
                isShowPwd();
                break;
            default:
        }
    }

    private void clickPwdState() {
        loginPwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (loginPwd.getText().toString().length() > 5) {
                    loginBtn.setEnabled(true);
                } else {
                    loginBtn.setEnabled(false);
                }
            }
        });
    }

    private void clickUserState() {
        loginGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                // 选中状态改变时被触发
                switch (i) {
                    case R.id.radio_parent:
                        userType = radioParent.getText().toString();
                        break;
                    case R.id.radio_staff:
                        userType = radioStaff.getText().toString();
                        break;
                    default:
                }
            }
        });
    }

    private void isShowPwd() {
        imagePwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag++;
                if (!"".equals(loginPwd.getText().toString())) {
                    imagePwd.setSelected(true);
                    loginPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    loginPwd.setSelection(loginPwd.getText().toString().length());
                    if (flag % 2 == 0) {
                        imagePwd.setSelected(false);
                        loginPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                        loginPwd.setSelection(loginPwd.getText().toString().length());
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void submit() {
        // validate
        String userName = loginUser.getText().toString();
        String user = userName.trim();
        if (TextUtils.isEmpty(user)) {
            Toast.makeText(this, "UserName", Toast.LENGTH_SHORT).show();
            return;
        }

        String passWord = loginPwd.getText().toString();
        String pwd = passWord.trim();
        if (TextUtils.isEmpty(pwd)) {
            Toast.makeText(this, "PassWord", Toast.LENGTH_SHORT).show();
            return;
        }
        // TODO validate success, do something
        isUserClickState(userName,passWord);
    }

    private void isUserClickState(final String userName, final String passWord) {
        service.execute(new Runnable() {
            @Override
            public void run() {
                FormBody formBody = new FormBody.Builder()
//                        .add("username",userName)
//                        .add("password",passWord)
                        .build();
                try {
                    verificationParentInfoBean = HttpUtils.okHttpPost(ConstantsUtils.SERVER_URL_USER+ ConstantsUtils.Address_VerificationParentInfo
                                    +"?username="+userName+"&password="+passWord
                            , formBody, VerificationParentInfoBean.class);
                    verificationUserInfoBean = HttpUtils.okHttpPost(ConstantsUtils.SERVER_URL_USER + ConstantsUtils.Address_VerificationUserInfo
                                    +"?username="+userName+"&password="+passWord
                            , formBody, VerificationUserInfoBean.class);
                    final String Message = "登录成功";
                    final String user = "员工";
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent=new Intent(LoginActivity.this, MainActivity.class);
                            if (Message.equals(verificationParentInfoBean.getMessage()) && !userType.equals(user)) {
                                //数据传递
                                EventBus.getDefault().postSticky(new EventBusParentInfo(userName));
                                startActivity(intent);
                            }
                            else if (Message.equals(verificationUserInfoBean.getMessage()) && userType.equals(user)){
                                //数据传递
                                EventBus.getDefault().postSticky(new EventBusStaffInfo(userName));
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}