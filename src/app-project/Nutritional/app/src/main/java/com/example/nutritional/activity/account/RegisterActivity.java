package com.example.nutritional.activity.account;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.nutritional.R;
import com.example.nutritional.bean.user.AddParentInfoBean;
import com.example.nutritional.bean.user.ConditionChildrenInfoBean;
import com.example.nutritional.data.StudentIdea;
import com.example.nutritional.util.ConstantsUtils;
import com.example.nutritional.util.HttpUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.FormBody;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @author 69182
 */
public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText registerUser;
    private EditText registerStudent;
    private EditText registerPwd;
    private Spinner registerSpinner;
    private Button registerBtn;
    ExecutorService service;
    private EditText registerParent;

    /**
     * 通过学号学校名称查询学生
     */
    ConditionChildrenInfoBean conditionChildrenInfoBean;
    List<ConditionChildrenInfoBean.ChildrenInfoBean> childrenInfoBeans;
    /**
     * 添加家长用户
     */
    AddParentInfoBean addParentInfoBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    private void initView() {
        service = newFixedThreadPool(1);
        childrenInfoBeans = new ArrayList<>();
        registerUser = (EditText) findViewById(R.id.register_user);
        registerStudent = (EditText) findViewById(R.id.register_student);
        registerPwd = (EditText) findViewById(R.id.register_pwd);
        registerSpinner = (Spinner) findViewById(R.id.register_spinner);
        registerBtn = (Button) findViewById(R.id.register_btn);
        registerParent = (EditText) findViewById(R.id.register_parent);

        registerBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_btn:
                submit();
                break;
            default:
        }
    }

    private void submit() {
        // validate
        String userName = registerUser.getText().toString();
        String user = userName.trim();
        if (TextUtils.isEmpty(user)) {
            Toast.makeText(this, "userName不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String studentNo = registerStudent.getText().toString();
        String student = studentNo.trim();
        if (TextUtils.isEmpty(student)) {
            Toast.makeText(this, "studentName不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String passWord = registerPwd.getText().toString();
        String pwd = passWord.trim();
        if (TextUtils.isEmpty(pwd)) {
            Toast.makeText(this, "pwd不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String parentName = registerParent.getText().toString();
        String parent = parentName.trim();
        if (TextUtils.isEmpty(parent)) {
            Toast.makeText(this, "parentName不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
        String schoolName = registerSpinner.getSelectedItem().toString();
        isClickAddUserState(studentNo, schoolName, parentName, userName, passWord);

    }

    private void isClickAddUserState(final String studentNo, final String schoolName, final String parentName, final String userName, final String passWord) {
        service.execute(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {

                            conditionChildrenInfoBean = HttpUtils.okHttpGet(ConstantsUtils.SERVER_URL_USER + ConstantsUtils.Address_GetConditionChildrenInfo
                                    + "?stuno=" + studentNo + "&schoolname=" + schoolName, ConditionChildrenInfoBean.class);

                            String messageSelect = "查询成功";
                            String messageAdd = "添加成功";
                            if (messageSelect.equals(conditionChildrenInfoBean.getMessage())) {
                                FormBody formBody = new FormBody.Builder()
//                                .add("parentname", parentName)
//                                .add("username", userName)
//                                .add("password", passWord)
//                                .add("childrennum", studentNo)
//                                .add("schoolname", schoolName)
                                        .build();
                                //储存学生信息

                                childrenInfoBeans.addAll(conditionChildrenInfoBean.getChildrenInfo());


//                                if (new StudentIdea(childrenInfoBeans.get(0).getName(), childrenInfoBeans.get(0).getStuNo(),
////                                        childrenInfoBeans.get(0).getAddress(), childrenInfoBeans.get(0).getParentName()
////                                        , childrenInfoBeans.get(0).getSchoolName()).save()) {
////                                    Toast.makeText(RegisterActivity.this, "存储成功", Toast.LENGTH_SHORT).show();
////                                } else {
////                                    Toast.makeText(RegisterActivity.this, "存储失败", Toast.LENGTH_SHORT).show();
////                                }

                                addParentInfoBean = HttpUtils.okHttpPost(
                                        ConstantsUtils.SERVER_URL_USER + ConstantsUtils.Address_AddParentInfo
                                                + "?parentname=" + parentName + "&username=" + userName + "&password=" + passWord + "&childrennum=" + studentNo + "&schoolname=" + schoolName
                                        , formBody, AddParentInfoBean.class);
                                if (messageAdd.equals(addParentInfoBean.getMessage())) {

                                    Toast.makeText(RegisterActivity.this, "家长注册成功", Toast.LENGTH_SHORT).show();

                                }
                            } else {

                                Toast.makeText(RegisterActivity.this, "无法查询到该学生信息", Toast.LENGTH_SHORT).show();

                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        service.shutdown();
    }
}
