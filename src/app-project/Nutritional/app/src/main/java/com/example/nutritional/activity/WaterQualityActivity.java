package com.example.nutritional.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.nutritional.R;
import com.example.nutritional.activity.account.LoginActivity;
import com.example.nutritional.bean.safety.GetAllWaterQualityInfo;
import com.example.nutritional.util.ConstantsUtils;
import com.example.nutritional.util.HttpUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import androidx.appcompat.app.AppCompatActivity;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @author 69182
 */
public class WaterQualityActivity extends AppCompatActivity implements View.OnClickListener {

    private Button qualityBtn;
    private ListView qualityListView;
    ExecutorService service;
    GetAllWaterQualityInfo getAllWaterQualityInfo;
    List<GetAllWaterQualityInfo.WaterQualityInfosBean> beanList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_quality);
        initView();
    }

    private void initView() {
        service = newFixedThreadPool(1);
        beanList = new ArrayList<>();

        qualityBtn = (Button) findViewById(R.id.quality_btn);
        qualityListView = (ListView) findViewById(R.id.quality_listView);

        qualityBtn.setOnClickListener(this);
        String type="家长";
        if (type.equals(LoginActivity.userType)){
            qualityBtn.setVisibility(View.GONE);
        }else {
            qualityBtn.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        getAllWaterQualityData();
    }

    private void getAllWaterQualityData() {
        service.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    getAllWaterQualityInfo = HttpUtils.okHttpGet(ConstantsUtils.SERVER_URL_SAFETY + ConstantsUtils.Address_GetAllWaterQualityInfo, GetAllWaterQualityInfo.class);
                    beanList.addAll(getAllWaterQualityInfo.getWaterQualityInfos());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            qualityListView.setAdapter(new MyAdapter(beanList));
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    static class MyAdapter extends BaseAdapter {

        public MyAdapter(List<GetAllWaterQualityInfo.WaterQualityInfosBean> beanList) {
            this.beanList = beanList;
        }

        List<GetAllWaterQualityInfo.WaterQualityInfosBean> beanList;

        @Override
        public int getCount() {
            return beanList.size();
        }

        @Override
        public Object getItem(int i) {
            return beanList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return beanList.get(i).getId();
        }

        @SuppressLint({"InflateParams", "ViewHolder"})
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_water_quality, null);
            ViewHolder viewHolder=new ViewHolder(view);
            viewHolder.waterOperationComprehensiveEvaluation.setText(beanList.get(i).getComprehensiveEvaluation());
            viewHolder.waterOperationPh.setText(""+beanList.get(i).getPh());
            viewHolder.waterOperationRemake.setText(""+beanList.get(i).getRemark());
            viewHolder.waterOperationTime.setText(""+beanList.get(i).getDateOfSampling());
            Glide.with(viewGroup.getContext()).load(ConstantsUtils.SERVER_URL_SAFETY+"/"+beanList.get(i).getImage()).into(viewHolder.waterOperationImg);
            return view;
        }

        public static
        class ViewHolder {
            public View rootView;
            public ImageView waterOperationImg;
            public TextView waterOperationTime;
            public TextView waterOperationPh;
            public TextView waterOperationComprehensiveEvaluation;
            public TextView waterOperationRemake;

            public ViewHolder(View rootView) {
                this.rootView = rootView;
                this.waterOperationImg = (ImageView) rootView.findViewById(R.id.water_operation_img);
                this.waterOperationTime = (TextView) rootView.findViewById(R.id.water_operation_time);
                this.waterOperationPh = (TextView) rootView.findViewById(R.id.water_operation_ph);
                this.waterOperationComprehensiveEvaluation = (TextView) rootView.findViewById(R.id.water_operation_ComprehensiveEvaluation);
                this.waterOperationRemake = (TextView) rootView.findViewById(R.id.water_operation_remake);
            }

        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.quality_btn:
                startActivity(new Intent(WaterQualityActivity.this, WaterQualityOperationActivity.class));
                break;
            default:
        }
    }
}