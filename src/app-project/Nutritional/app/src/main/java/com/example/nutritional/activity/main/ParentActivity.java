package com.example.nutritional.activity.main;

import android.os.Bundle;
import android.widget.TextView;

import com.example.nutritional.R;
import com.example.nutritional.bean.user.GetAllParentInfoBean;
import com.example.nutritional.bean.user.GetConditionParentInfoBean;
import com.example.nutritional.eventbus.EventBusParentInfo;
import com.example.nutritional.util.ConstantsUtils;
import com.example.nutritional.util.HttpUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import androidx.appcompat.app.AppCompatActivity;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @author 69182
 */
public class ParentActivity extends AppCompatActivity {

    ExecutorService service;
    String Name = null;
    GetConditionParentInfoBean getConditionParentInfo;
    List<GetConditionParentInfoBean.ParentInfoBean> beanList;
    private TextView parentName;
    private TextView parentUserName;
    private TextView parentPassword;
    private TextView parentChildrenNum;
    private TextView parentSchoolName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);
        initView();
    }

    @Subscribe(threadMode = ThreadMode.ASYNC, sticky = true)
    public void onEventBus1(final EventBusParentInfo eventBus1) {
        service.execute(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //需要更新的UI内容
                        Name = eventBus1.getUserName();
                        getParentDataInfo();
                    }
                });
            }
        });
    }

    private void initView() {
        service = newFixedThreadPool(1);
        beanList = new ArrayList<>();
        parentName = (TextView) findViewById(R.id.parent_name);
        parentUserName = (TextView) findViewById(R.id.parent_userName);
        parentPassword = (TextView) findViewById(R.id.parent_password);
        parentChildrenNum = (TextView) findViewById(R.id.parent_childrenNum);
        parentSchoolName = (TextView) findViewById(R.id.parent_schoolName);
    }

    private void getParentDataInfo() {
        service.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    getConditionParentInfo = HttpUtils.okHttpGet(ConstantsUtils.SERVER_URL_USER + ConstantsUtils.Address_GetConditionParentInfo + "?username=" + Name, GetConditionParentInfoBean.class);
                    beanList.addAll(getConditionParentInfo.getParentInfo());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            parentName.setText("姓名：" + beanList.get(0).getParentName());
                            parentUserName.setText("用户名：" + beanList.get(0).getUserName());
                            parentPassword.setText("密码：" + beanList.get(0).getPassword());
                            parentChildrenNum.setText("孩子学号：" + beanList.get(0).getChildrenNum());
                            parentSchoolName.setText("学校名称：" + beanList.get(0).getSchoolName());
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
        service.shutdown();
    }
}