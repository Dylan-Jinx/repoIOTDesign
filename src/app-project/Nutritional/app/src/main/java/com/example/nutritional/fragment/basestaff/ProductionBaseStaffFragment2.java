package com.example.nutritional.fragment.basestaff;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.nutritional.R;
import com.example.nutritional.bean.safety.UserIdByBaseStaffSearch;
import com.example.nutritional.util.ConstantsUtils;
import com.example.nutritional.util.HttpUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.FormBody;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProductionBaseStaffFragment2#newInstance} factory method to
 * create an instance of this fragment.
 *
 * @author 69182
 */
public class ProductionBaseStaffFragment2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ExecutorService service;
    UserIdByBaseStaffSearch userIdByBaseStaffSearch;
    List<UserIdByBaseStaffSearch.StaffsBean> beanList;

    public ProductionBaseStaffFragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProductionBaseStaffFragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static ProductionBaseStaffFragment2 newInstance(String param1, String param2) {
        ProductionBaseStaffFragment2 fragment = new ProductionBaseStaffFragment2();
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
        View view = inflater.inflate(R.layout.fragment_production_base_staff2, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        service = newFixedThreadPool(1);
        beanList = new ArrayList<>();
        ViewHolder viewHolder = new ViewHolder(view);
        UserIdBySearch(viewHolder);
    }

    private void UserIdBySearch(final ViewHolder viewHolder) {
        service.execute(new Runnable() {
            @Override
            public void run() {
                FormBody formBody = new FormBody.Builder()
                        .build();
                View viewById = getActivity().findViewById(R.id.base_staff_id);
                String string = ((TextView) viewById).getText().toString();
                try {
                    userIdByBaseStaffSearch = HttpUtils.okHttpPost(ConstantsUtils.SERVER_URL_SAFETY + ConstantsUtils.Address_UserIdByStaffSearch + "?id=" + string, formBody, UserIdByBaseStaffSearch.class);
                    String message = "操作成功";
                    if (message.equals(userIdByBaseStaffSearch.getMessage())) {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                beanList.addAll(userIdByBaseStaffSearch.getStaffs());
                                viewHolder.baseStaff2CardView.setVisibility(View.VISIBLE);
                                viewHolder.baseStaff2Basename.setText(beanList.get(0).getProductionBaseName());
                                viewHolder.baseStaff2Name.setText(beanList.get(0).getStaffName());
                                viewHolder.baseStaff2Position.setText("职称："+beanList.get(0).getPosition());
                                viewHolder.baseStaff2Telephone.setText("联系电话："+beanList.get(0).getTelephone());
                                Glide.with(getActivity()).load(ConstantsUtils.SERVER_URL_SAFETY + "/" + beanList.get(0).getImage()).into(viewHolder.baseStaff2Img);
                            }
                        });
                    } else {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getActivity(), userIdByBaseStaffSearch.getMessage(), Toast.LENGTH_SHORT).show();

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
        public CircleImageView baseStaff2Img;
        public TextView baseStaff2Name;
        public TextView baseStaff2Basename;
        public TextView baseStaff2Position;
        public TextView baseStaff2Telephone;
        public CardView baseStaff2CardView;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.baseStaff2Img = (CircleImageView) rootView.findViewById(R.id.base_staff2_img);
            this.baseStaff2Name = (TextView) rootView.findViewById(R.id.base_staff2_Name);
            this.baseStaff2Basename = (TextView) rootView.findViewById(R.id.base_staff2_Basename);
            this.baseStaff2Position = (TextView) rootView.findViewById(R.id.base_staff2_position);
            this.baseStaff2Telephone = (TextView) rootView.findViewById(R.id.base_staff2_telephone);
            this.baseStaff2CardView = (CardView) rootView.findViewById(R.id.base_staff2_cardView);
        }

    }
}