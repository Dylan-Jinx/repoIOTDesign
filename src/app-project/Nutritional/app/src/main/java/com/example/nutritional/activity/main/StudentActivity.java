package com.example.nutritional.activity.main;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.nutritional.R;
import com.example.nutritional.bean.user.GetConditionParentInfoBean;
import com.example.nutritional.bean.user.UseParentNameGetStudentinfo;
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
import androidx.cardview.widget.CardView;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @author 69182
 */
public class StudentActivity extends AppCompatActivity {

    private TextView studentName;
    private TextView studentNo;
    private TextView studentAddress;
    private TextView studentParentName;
    private TextView studentSchoolName;
    private CardView cardView;
    ExecutorService service;
    UseParentNameGetStudentinfo useParentNameGetStudentinfo;
    List<UseParentNameGetStudentinfo.ChildrenInfoBean> beanList;

    GetConditionParentInfoBean getConditionParentInfo;
    List<GetConditionParentInfoBean.ParentInfoBean> infoBeans;

    String Name=null;
    private static final String TAG = "StudentActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        initView();
    }

    private void initView() {
        service = newFixedThreadPool(2);
        beanList = new ArrayList<>();
        infoBeans=new ArrayList<>();
        studentName = (TextView) findViewById(R.id.student_name);
        studentNo = (TextView) findViewById(R.id.student_no);
        studentAddress = (TextView) findViewById(R.id.student_address);
        studentParentName = (TextView) findViewById(R.id.student_parentName);
        studentSchoolName = (TextView) findViewById(R.id.student_schoolName);
        cardView = findViewById(R.id.student_cardView);
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
                        getStudentDataInfo();
                    }
                });
            }
        });
    }

    private void getStudentDataInfo() {
        service.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    getConditionParentInfo = HttpUtils.okHttpGet(ConstantsUtils.SERVER_URL_USER + ConstantsUtils.Address_GetConditionParentInfo + "?username=" + Name, GetConditionParentInfoBean.class);
                    infoBeans.addAll(getConditionParentInfo.getParentInfo());

                    useParentNameGetStudentinfo = HttpUtils.okHttpGet(ConstantsUtils.SERVER_URL_USER + ConstantsUtils.Address_UseParentNameGetStudentinfo + "?parentname=" +infoBeans.get(0).getParentName() , UseParentNameGetStudentinfo.class);
                    beanList.addAll(useParentNameGetStudentinfo.getChildrenInfo());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            studentName.setText("姓名："+beanList.get(0).getName());
                            studentNo.setText("学号："+beanList.get(0).getStuNo());
                            studentAddress.setText("地址："+beanList.get(0).getAddress());
                            studentParentName.setText("家长姓名："+beanList.get(0).getParentName());
                            studentSchoolName.setText("学校名称："+beanList.get(0).getSchoolName());
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