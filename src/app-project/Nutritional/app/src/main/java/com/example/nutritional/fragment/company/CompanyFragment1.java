package com.example.nutritional.fragment.company;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.nutritional.R;
import com.example.nutritional.bean.safety.GetAllCompanyInfo;
import com.example.nutritional.util.ConstantsUtils;
import com.example.nutritional.util.HttpUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import androidx.fragment.app.Fragment;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CompanyFragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CompanyFragment1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ListView company1ListView;
    ExecutorService service;
    GetAllCompanyInfo getAllCompanyInfo;
    List<GetAllCompanyInfo.CompanyInfosBean> beanList;

    public CompanyFragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CompanyFragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static CompanyFragment1 newInstance(String param1, String param2) {
        CompanyFragment1 fragment = new CompanyFragment1();
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
        View view = inflater.inflate(R.layout.fragment_company1, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        service = newFixedThreadPool(1);
        beanList = new ArrayList<>();
        company1ListView = view.findViewById(R.id.company1_listView);

        getAllCompanyData();
    }

    private void getAllCompanyData() {
        service.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    getAllCompanyInfo = HttpUtils.okHttpGet(ConstantsUtils.SERVER_URL_SAFETY + ConstantsUtils.Address_GetAllCompanyInfo, GetAllCompanyInfo.class);
                    beanList.addAll(getAllCompanyInfo.getCompanyInfos());
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            company1ListView.setAdapter(new MyAdapter(beanList));
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    static class MyAdapter extends BaseAdapter {

        List<GetAllCompanyInfo.CompanyInfosBean> beanList;

        public MyAdapter(List<GetAllCompanyInfo.CompanyInfosBean> beanList) {
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

        @SuppressLint({"InflateParams", "ViewHolder"})
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_company, null);
            ViewHolder viewHolder = new ViewHolder(view);
            viewHolder.companyName.setText(beanList.get(i).getName());
            viewHolder.companyAddress.setText(beanList.get(i).getAddress());
            viewHolder.companyResponsibleName.setText("操作员："+beanList.get(i).getResponsibleName());
            viewHolder.companyTelephone.setText("Tel："+beanList.get(i).getTelephone());
            return view;
        }

        public static
        class ViewHolder {
            public View rootView;
            public TextView companyName;
            public TextView companyAddress;
            public TextView companyResponsibleName;
            public TextView companyTelephone;

            public ViewHolder(View rootView) {
                this.rootView = rootView;
                this.companyName = (TextView) rootView.findViewById(R.id.company_name);
                this.companyAddress = (TextView) rootView.findViewById(R.id.company_address);
                this.companyResponsibleName = (TextView) rootView.findViewById(R.id.company_responsibleName);
                this.companyTelephone = (TextView) rootView.findViewById(R.id.company_telephone);
            }

        }
    }


    @Override
    public void onStop() {
        super.onStop();
        service.shutdown();
    }
}