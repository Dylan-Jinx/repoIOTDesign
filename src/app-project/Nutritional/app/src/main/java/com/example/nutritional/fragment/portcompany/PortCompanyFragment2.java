package com.example.nutritional.fragment.portcompany;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.nutritional.R;
import com.example.nutritional.bean.safety.UserIdByCompanyStaffSearch;
import com.example.nutritional.util.ConstantsUtils;
import com.example.nutritional.util.HttpUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.FormBody;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PortCompanyFragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PortCompanyFragment2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ExecutorService service;
    UserIdByCompanyStaffSearch userIdByCompanyStaffSearch;
    List<UserIdByCompanyStaffSearch.StaffsBean> beanList;

    public PortCompanyFragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PortCompanyFragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static PortCompanyFragment2 newInstance(String param1, String param2) {
        PortCompanyFragment2 fragment = new PortCompanyFragment2();
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
        View view = inflater.inflate(R.layout.fragment_port_company2, container, false);
        iniTView(view);
        return view;
    }

    private void iniTView(View view) {
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
                View viewById = getActivity().findViewById(R.id.company_staff_id);
                String string = ((TextView) viewById).getText().toString();
                try {
                    userIdByCompanyStaffSearch = HttpUtils.okHttpPost(ConstantsUtils.SERVER_URL_SAFETY + ConstantsUtils.Address_UserIdByStaffsSearch + "?id=" + string, formBody, UserIdByCompanyStaffSearch.class);
                    String message = "操作成功";
                    if (message.equals(userIdByCompanyStaffSearch.getMessage())) {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                ViewHolder viewHolder=new ViewHolder(view);
                                beanList.addAll(userIdByCompanyStaffSearch.getStaffs());
                                viewHolder.companyStaff2CardView.setVisibility(View.VISIBLE);
                                viewHolder.companyStaff2StaffName.setText("员工昵称："+beanList.get(0).getStaffName());
                                viewHolder.companyStaff2Telephone.setText("联系电话："+beanList.get(0).getTelephone());
                                viewHolder.companyStaff2TransPortCompanyName.setText("公司名称："+beanList.get(0).getTransPortCompanyName());
                                Glide.with(getActivity()).load(ConstantsUtils.SERVER_URL_SAFETY+"/"+beanList.get(0).getImage()).into(viewHolder.companyStaff2Img);
                            }
                        });
                    }else {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getActivity(), userIdByCompanyStaffSearch.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    @Override
    public void onStop() {
        super.onStop();
        service.shutdown();
    }

    public static
    class ViewHolder {
        public View rootView;
        public CircleImageView companyStaff2Img;
        public TextView companyStaff2TransPortCompanyName;
        public TextView companyStaff2StaffName;
        public TextView companyStaff2Telephone;
        public CardView companyStaff2CardView;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.companyStaff2Img = (CircleImageView) rootView.findViewById(R.id.company_staff2_img);
            this.companyStaff2TransPortCompanyName = (TextView) rootView.findViewById(R.id.company_staff2_transPortCompanyName);
            this.companyStaff2StaffName = (TextView) rootView.findViewById(R.id.company_staff2_staffName);
            this.companyStaff2Telephone = (TextView) rootView.findViewById(R.id.company_staff2_telephone);
            this.companyStaff2CardView = (CardView) rootView.findViewById(R.id.company_staff2_cardView);
        }

    }
}