package com.example.nutritional.fragment.staff;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.nutritional.R;
import com.example.nutritional.bean.school.GetAllStaff;
import com.example.nutritional.util.ConstantsUtils;
import com.example.nutritional.util.HttpUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import de.hdodenhof.circleimageview.CircleImageView;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @author 69182
 */
public
class StaffFragment1 extends Fragment {

    View view;
    ExecutorService service;
    private ListView staffListView;
    GetAllStaff getAllStaff;
    List<GetAllStaff.StaffBean> beanList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_staff1, container, false);
        initView();
        return view;
    }

    private void initView() {
        service = newFixedThreadPool(1);
        beanList = new ArrayList<>();
        staffListView = view.findViewById(R.id.staff_listView);

        getAllStaffData();
    }

    private void getAllStaffData() {
        service.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    getAllStaff = HttpUtils.okHttpGet(ConstantsUtils.SERVER_URL_SCHOOL + ConstantsUtils.Address_GetAllStaff, GetAllStaff.class);
                    beanList.addAll(getAllStaff.getStaff());
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            staffListView.setAdapter(new MyAdapter(beanList));
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    static class MyAdapter extends BaseAdapter {

        List<GetAllStaff.StaffBean> beanList;

        public MyAdapter(List<GetAllStaff.StaffBean> beanList) {
            this.beanList = beanList;
        }

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

        @SuppressLint({"ViewHolder", "InflateParams"})
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_staff, null);
            ViewHolder viewHolder=new ViewHolder(view);
            viewHolder.staffName.setText(beanList.get(i).getStaffName());
            viewHolder.staffPosition.setText("职务："+beanList.get(i).getPosition());
            viewHolder.staffTelephone.setText("联系方式："+beanList.get(i).getTelephone());
            Glide.with(viewGroup.getContext()).load(ConstantsUtils.SERVER_URL_SCHOOL+"/"+beanList.get(i).getImage()).into(viewHolder.staffImg);
            return view;
        }

        public static
        class ViewHolder {
            public View rootView;
            public CircleImageView staffImg;
            public TextView staffName;
            public TextView staffTelephone;
            public TextView staffPosition;

            public ViewHolder(View rootView) {
                this.rootView = rootView;
                this.staffImg = (CircleImageView) rootView.findViewById(R.id.staff_img);
                this.staffName = (TextView) rootView.findViewById(R.id.staff_name);
                this.staffTelephone = (TextView) rootView.findViewById(R.id.staff_telephone);
                this.staffPosition = (TextView) rootView.findViewById(R.id.staff_position);
            }

        }
    }
}
