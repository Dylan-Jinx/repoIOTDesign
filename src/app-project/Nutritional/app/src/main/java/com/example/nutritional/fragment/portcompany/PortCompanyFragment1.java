package com.example.nutritional.fragment.portcompany;

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
import com.example.nutritional.bean.safety.GetAllStaffs;
import com.example.nutritional.util.ConstantsUtils;
import com.example.nutritional.util.HttpUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import androidx.fragment.app.Fragment;
import de.hdodenhof.circleimageview.CircleImageView;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PortCompanyFragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PortCompanyFragment1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ListView company1StaffListView;
    ExecutorService service;
    GetAllStaffs getAllStaffs;
    List<GetAllStaffs.StaffsBean> beanList;

    public PortCompanyFragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PortCompanyFragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static PortCompanyFragment1 newInstance(String param1, String param2) {
        PortCompanyFragment1 fragment = new PortCompanyFragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_port_company1, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        service = newFixedThreadPool(1);
        beanList = new ArrayList<>();
        company1StaffListView=view.findViewById(R.id.company1_staff_listView);

        getAllStaffsData();
    }

    private void getAllStaffsData() {
        service.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    getAllStaffs = HttpUtils.okHttpGet(ConstantsUtils.SERVER_URL_SAFETY + ConstantsUtils.Address_GetAllStaffs, GetAllStaffs.class);
                    beanList.addAll(getAllStaffs.getStaffs());
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            company1StaffListView.setAdapter(new MyAdapter(beanList));
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    static class MyAdapter extends BaseAdapter {

        public MyAdapter(List<GetAllStaffs.StaffsBean> beanList) {
            this.beanList = beanList;
        }

        List<GetAllStaffs.StaffsBean> beanList;

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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_company_staff, null);
            ViewHolder viewHolder=new ViewHolder(view);
            viewHolder.companyStaffStaffName.setText("员工昵称："+beanList.get(i).getStaffName());
            viewHolder.companyStaffTelephone.setText("联系电话："+beanList.get(i).getTelephone());
            viewHolder.companyStaffTransPortCompanyName.setText("公司名称："+beanList.get(i).getTransPortCompanyName());
            Glide.with(viewGroup.getContext()).load(ConstantsUtils.SERVER_URL_SAFETY+"/"+beanList.get(i).getImage()).into(viewHolder.companyStaffImg);
            return view;
        }

        public static
        class ViewHolder {
            public View rootView;
            public CircleImageView companyStaffImg;
            public TextView companyStaffTransPortCompanyName;
            public TextView companyStaffStaffName;
            public TextView companyStaffTelephone;

            public ViewHolder(View rootView) {
                this.rootView = rootView;
                this.companyStaffImg = (CircleImageView) rootView.findViewById(R.id.company_staff_img);
                this.companyStaffTransPortCompanyName = (TextView) rootView.findViewById(R.id.company_staff_transPortCompanyName);
                this.companyStaffStaffName = (TextView) rootView.findViewById(R.id.company_staff_staffName);
                this.companyStaffTelephone = (TextView) rootView.findViewById(R.id.company_staff_telephone);
            }

        }
    }

    @Override
    public void onStop() {
        super.onStop();
        service.shutdown();
    }
}