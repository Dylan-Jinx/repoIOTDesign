package com.example.nutritional.fragment.staff;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.nutritional.R;
import com.example.nutritional.bean.school.GetConditionStaff;
import com.example.nutritional.util.ConstantsUtils;
import com.example.nutritional.util.HttpUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import de.hdodenhof.circleimageview.CircleImageView;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @author 69182
 */
public
class StaffFragment2 extends Fragment {

    View view;
    ExecutorService service;
    GetConditionStaff getConditionStaff;
    List<GetConditionStaff.StaffBean> beanList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_staff2, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        service = newFixedThreadPool(1);
        beanList = new ArrayList<>();

        getConditionStaffInfo(view);

    }

    private void getConditionStaffInfo(final View view) {
        service.execute(new Runnable() {
            @Override
            public void run() {
                View viewById = getActivity().findViewById(R.id.staff_id);
                String string = ((TextView) viewById).getText().toString();
                try {
                    getConditionStaff = HttpUtils.okHttpGet(ConstantsUtils.SERVER_URL_SCHOOL + ConstantsUtils.Address_GetConditionStaff + "?id=" + string, GetConditionStaff.class);
                    final String message = "查询成功";

                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (message.equals(getConditionStaff.getMessage())) {
                                ViewHolder viewHolder = new ViewHolder(view);
                                viewHolder.staff2CardView.setVisibility(View.VISIBLE);
                                beanList.addAll(getConditionStaff.getStaff());
                                viewHolder.staff2Name.setText(beanList.get(0).getStaffName());
                                viewHolder.staff2Position.setText("职务："+beanList.get(0).getPosition());
                                viewHolder.staff2Telephone.setText("联系方式："+beanList.get(0).getTelephone());
                                Glide.with(getActivity()).load(ConstantsUtils.SERVER_URL_SCHOOL + "/" + beanList.get(0).getImage()).into(viewHolder.staff2Img);
                            } else {
                                Toast.makeText(getActivity(), getConditionStaff.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static
    class ViewHolder {
        public View rootView;
        public CircleImageView staff2Img;
        public TextView staff2Name;
        public TextView staff2Telephone;
        public TextView staff2Position;
        public CardView staff2CardView;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.staff2Img = (CircleImageView) rootView.findViewById(R.id.staff2_img);
            this.staff2Name = (TextView) rootView.findViewById(R.id.staff2_name);
            this.staff2Telephone = (TextView) rootView.findViewById(R.id.staff2_telephone);
            this.staff2Position = (TextView) rootView.findViewById(R.id.staff2_position);
            this.staff2CardView = (CardView) rootView.findViewById(R.id.staff2_cardView);
        }

    }
}
