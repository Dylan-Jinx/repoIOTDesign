package com.example.nutritional.fragment.main.parent;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nutritional.R;
import com.example.nutritional.activity.CookActivity;
import com.example.nutritional.activity.PlantActivity;
import com.example.nutritional.activity.ProductNumActivity;
import com.example.nutritional.activity.ProductionBaseInfoActivity;
import com.example.nutritional.activity.StaffActivity;
import com.example.nutritional.activity.WaterQualityActivity;
import com.example.nutritional.activity.main.ParentActivity;
import com.example.nutritional.activity.main.StudentActivity;
import com.makeramen.roundedimageview.RoundedImageView;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ParentFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 * @author 69182
 */
public class ParentFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ParentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ParentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ParentFragment newInstance(String param1, String param2) {
        ParentFragment fragment = new ParentFragment();
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
        View view = inflater.inflate(R.layout.fragment_parent, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.line1.setOnClickListener(this);
        viewHolder.main1Img.setOnClickListener(this);
        viewHolder.main1Text.setOnClickListener(this);

        viewHolder.line2.setOnClickListener(this);
        viewHolder.main1Img1.setOnClickListener(this);
        viewHolder.main1Text1.setOnClickListener(this);
        viewHolder.line3.setOnClickListener(this);
        viewHolder.main1Img2.setOnClickListener(this);
        viewHolder.main1Text2.setOnClickListener(this);
        viewHolder.line4.setOnClickListener(this);
        viewHolder.main1Img3.setOnClickListener(this);
        viewHolder.main1Text3.setOnClickListener(this);
        viewHolder.line5.setOnClickListener(this);
        viewHolder.main1Img4.setOnClickListener(this);
        viewHolder.main1Text4.setOnClickListener(this);
        viewHolder.line6.setOnClickListener(this);
        viewHolder.main1Img5.setOnClickListener(this);
        viewHolder.main1Text5.setOnClickListener(this);
        viewHolder.line7.setOnClickListener(this);
        viewHolder.main1Img6.setOnClickListener(this);
        viewHolder.main1Text6.setOnClickListener(this);
        viewHolder.line8.setOnClickListener(this);
        viewHolder.main1Img7.setOnClickListener(this);
        viewHolder.main1Text7.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.line1:
            case R.id.main1_img:
            case R.id.main_text:
                startActivity(new Intent(getActivity(), CookActivity.class));
                break;
            case R.id.line2:
            case R.id.main1_img1:
            case R.id.main_text1:
                startActivity(new Intent(getActivity(), ParentActivity.class));
                break;
            case R.id.line3:
            case R.id.main1_img2:
            case R.id.main_text2:
                startActivity(new Intent(getActivity(), StudentActivity.class));
                break;
            case R.id.line4:
            case R.id.main1_img3:
            case R.id.main_text3:
                startActivity(new Intent(getActivity(), StaffActivity.class));
                break;
            case R.id.line5:
            case R.id.main1_img4:
            case R.id.main_text4:
                startActivity(new Intent(getActivity(), PlantActivity.class));
                break;
            case R.id.line6:
            case R.id.main1_img5:
            case R.id.main_text5:
                startActivity(new Intent(getActivity(), ProductNumActivity.class));
                break;
            case R.id.line7:
            case R.id.main1_img6:
            case R.id.main_text6:
                startActivity(new Intent(getActivity(), ProductionBaseInfoActivity.class));
                break;
            case R.id.line8:
            case R.id.main1_img7:
            case R.id.main_text7:
                startActivity(new Intent(getActivity(), WaterQualityActivity.class));
                break;
            default:


        }
    }

    public static
    class ViewHolder {
        public View rootView;
        public RoundedImageView main1Img;
        public TextView main1Text;
        public LinearLayout line1;
        public RoundedImageView main1Img1;
        public TextView main1Text1;
        public LinearLayout line2;
        public RoundedImageView main1Img2;
        public TextView main1Text2;
        public LinearLayout line3;
        public RoundedImageView main1Img3;
        public TextView main1Text3;
        public LinearLayout line4;
        public RoundedImageView main1Img4;
        public TextView main1Text4;
        public LinearLayout line5;
        public RoundedImageView main1Img5;
        public TextView main1Text5;
        public LinearLayout line6;
        public RoundedImageView main1Img6;
        public TextView main1Text6;
        public LinearLayout line7;
        public RoundedImageView main1Img7;
        public TextView main1Text7;
        public LinearLayout line8;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.main1Img = (RoundedImageView) rootView.findViewById(R.id.main1_img);
            this.main1Text = (TextView) rootView.findViewById(R.id.main1_text);
            this.line1 = (LinearLayout) rootView.findViewById(R.id.line1);
            this.main1Img1 = (RoundedImageView) rootView.findViewById(R.id.main1_img1);
            this.main1Text1 = (TextView) rootView.findViewById(R.id.main1_text1);
            this.line2 = (LinearLayout) rootView.findViewById(R.id.line2);
            this.main1Img2 = (RoundedImageView) rootView.findViewById(R.id.main1_img2);
            this.main1Text2 = (TextView) rootView.findViewById(R.id.main1_text2);
            this.line3 = (LinearLayout) rootView.findViewById(R.id.line3);
            this.main1Img3 = (RoundedImageView) rootView.findViewById(R.id.main1_img3);
            this.main1Text3 = (TextView) rootView.findViewById(R.id.main1_text3);
            this.line4 = (LinearLayout) rootView.findViewById(R.id.line4);
            this.main1Img4 = (RoundedImageView) rootView.findViewById(R.id.main1_img4);
            this.main1Text4 = (TextView) rootView.findViewById(R.id.main1_text4);
            this.line5 = (LinearLayout) rootView.findViewById(R.id.line5);
            this.main1Img5 = (RoundedImageView) rootView.findViewById(R.id.main1_img5);
            this.main1Text5 = (TextView) rootView.findViewById(R.id.main1_text5);
            this.line6 = (LinearLayout) rootView.findViewById(R.id.line6);
            this.main1Img6 = (RoundedImageView) rootView.findViewById(R.id.main1_img6);
            this.main1Text6 = (TextView) rootView.findViewById(R.id.main1_text6);
            this.line7 = (LinearLayout) rootView.findViewById(R.id.line7);
            this.main1Img7 = (RoundedImageView) rootView.findViewById(R.id.main1_img7);
            this.main1Text7 = (TextView) rootView.findViewById(R.id.main1_text7);
            this.line8 = (LinearLayout) rootView.findViewById(R.id.line8);
        }

    }
}