package com.example.nutritional.fragment.company;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nutritional.R;
import com.example.nutritional.bean.safety.UserIdByCompanySearch;
import com.example.nutritional.util.ConstantsUtils;
import com.example.nutritional.util.HttpUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import okhttp3.FormBody;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CompanyFragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CompanyFragment2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ExecutorService service;
    UserIdByCompanySearch userIdByCompanySearch;
    List<UserIdByCompanySearch.CompanyInfosBean> beanList;

    public CompanyFragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CompanyFragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static CompanyFragment2 newInstance(String param1, String param2) {
        CompanyFragment2 fragment = new CompanyFragment2();
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
        View view = inflater.inflate(R.layout.fragment_company2, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        service = newFixedThreadPool(1);
        beanList = new ArrayList<>();

        userIdBySearch(view);
    }

    private void userIdBySearch(final View view) {
        service.execute(new Runnable() {
            @Override
            public void run() {
                FormBody formBody = new FormBody.Builder()
                        .build();
                final ViewHolder viewHolder = new ViewHolder(view);
                View viewById = getActivity().findViewById(R.id.company_id);
                String string = ((TextView) viewById).getText().toString();
                try {
                    userIdByCompanySearch = HttpUtils.okHttpPost(ConstantsUtils.SERVER_URL_SAFETY + ConstantsUtils.Address_UserIdByCompanySearch + "?id=" + string, formBody, UserIdByCompanySearch.class);
                    String message = "操作成功";
                    if (message.equals(userIdByCompanySearch.getMessage())) {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                beanList.addAll(userIdByCompanySearch.getCompanyInfos());
                                viewHolder.company2CardView.setVisibility(View.VISIBLE);
                                viewHolder.company2Name.setText(beanList.get(0).getName());
                                viewHolder.company2Address.setText(beanList.get(0).getAddress());
                                viewHolder.company2ResponsibleName.setText("操作员："+beanList.get(0).getResponsibleName());
                                viewHolder.company2Telephone.setText("Tel："+beanList.get(0).getTelephone());
                            }
                        });
                    } else {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getActivity(), userIdByCompanySearch.getMessage(), Toast.LENGTH_SHORT).show();

                            }
                        });
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static
    class ViewHolder {
        public View rootView;
        public TextView company2Name;
        public TextView company2Address;
        public TextView company2ResponsibleName;
        public TextView company2Telephone;
        public CardView company2CardView;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.company2Name = (TextView) rootView.findViewById(R.id.company2_name);
            this.company2Address = (TextView) rootView.findViewById(R.id.company2_address);
            this.company2ResponsibleName = (TextView) rootView.findViewById(R.id.company2_responsibleName);
            this.company2Telephone = (TextView) rootView.findViewById(R.id.company2_telephone);
            this.company2CardView = (CardView) rootView.findViewById(R.id.company2_cardView);
        }

    }

    @Override
    public void onStop() {
        super.onStop();
        service.shutdown();
    }
}