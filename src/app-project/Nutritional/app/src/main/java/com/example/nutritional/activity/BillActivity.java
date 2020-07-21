package com.example.nutritional.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.nutritional.R;
import com.example.nutritional.bean.school.GetAllBill;
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
public class BillActivity extends AppCompatActivity {

    private ListView billListView;
    ExecutorService service;
    GetAllBill getAllBill;
    List<GetAllBill.BillBean> billBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        initView();
    }

    private void initView() {
        service = newFixedThreadPool(1);
        billBean=new ArrayList<>();
        billListView = (ListView) findViewById(R.id.bill_listView);
        getBillData();

    }

    private void getBillData() {
        service.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    getAllBill = HttpUtils.okHttpGet(ConstantsUtils.SERVER_URL_SCHOOL + ConstantsUtils.Address_GetAllBill, GetAllBill.class);
                    billBean.addAll(getAllBill.getBill());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            billListView.setAdapter(new MyAdapter(billBean));
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    static class MyAdapter extends BaseAdapter {

        List<GetAllBill.BillBean> billBean;

        public MyAdapter(List<GetAllBill.BillBean> billBean) {
            this.billBean = billBean;
        }

        @Override
        public int getCount() {
            return billBean.size();
        }

        @Override
        public Object getItem(int i) {
            return billBean.get(i);
        }

        @Override
        public long getItemId(int i) {
            return billBean.get(i).getId();
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_bill, null);
            ViewHolder viewHolder=new ViewHolder(view);
            viewHolder.bill_time.setText(billBean.get(i).getBillDatetime());
            viewHolder.bill_user.setText(billBean.get(i).getConductor());
            viewHolder.remark.setText(billBean.get(i).getRemark());
            return view;
        }

        class ViewHolder {
            public View rootView;
            public TextView bill_user;
            public TextView bill_time;
            public TextView remark;

            public ViewHolder(View rootView) {
                this.rootView = rootView;
                this.bill_user = (TextView) rootView.findViewById(R.id.bill_user);
                this.bill_time = (TextView) rootView.findViewById(R.id.bill_time);
                this.remark = (TextView) rootView.findViewById(R.id.remark);
            }

        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        service.shutdown();
    }
}