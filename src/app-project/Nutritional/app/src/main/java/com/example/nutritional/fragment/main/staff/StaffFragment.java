package com.example.nutritional.fragment.main.staff;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nutritional.R;
import com.example.nutritional.activity.CookActivity;
import com.example.nutritional.activity.FoodNutritionActivity;
import com.example.nutritional.activity.NutrientActivity;
import com.example.nutritional.activity.PlantActivity;
import com.example.nutritional.activity.PortationEnvironmentActivity;
import com.example.nutritional.activity.ProductNumActivity;
import com.example.nutritional.activity.ProductionBaseInfoActivity;
import com.example.nutritional.activity.StorageActivity;
import com.example.nutritional.activity.TransCompanyActivity;
import com.example.nutritional.activity.WaterQualityActivity;
import com.makeramen.roundedimageview.RoundedImageView;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StaffFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 * @author 69182
 */

public class StaffFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public StaffFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StaffFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StaffFragment newInstance(String param1, String param2) {
        StaffFragment fragment = new StaffFragment();
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
        View view = inflater.inflate(R.layout.fragment_staff, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.line1.setOnClickListener(this);
        viewHolder.mainImg1.setOnClickListener(this);
        viewHolder.mainText1.setOnClickListener(this);

        viewHolder.line2.setOnClickListener(this);
        viewHolder.mainImg2.setOnClickListener(this);
        viewHolder.mainText2.setOnClickListener(this);
        viewHolder.line3.setOnClickListener(this);
        viewHolder.mainImg3.setOnClickListener(this);
        viewHolder.mainText3.setOnClickListener(this);
        viewHolder.line4.setOnClickListener(this);
        viewHolder.mainImg4.setOnClickListener(this);
        viewHolder.mainText4.setOnClickListener(this);
        viewHolder.line5.setOnClickListener(this);
        viewHolder.mainImg5.setOnClickListener(this);
        viewHolder.mainText5.setOnClickListener(this);
        viewHolder.line6.setOnClickListener(this);
        viewHolder.mainImg6.setOnClickListener(this);
        viewHolder.mainText6.setOnClickListener(this);
        viewHolder.line7.setOnClickListener(this);
        viewHolder.mainImg7.setOnClickListener(this);
        viewHolder.mainText7.setOnClickListener(this);
        viewHolder.line8.setOnClickListener(this);
        viewHolder.mainImg8.setOnClickListener(this);
        viewHolder.mainText8.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.line1:
            case R.id.main_img1:
            case R.id.main_text1:
                startActivity(new Intent(getActivity(), CookActivity.class));
                break;
            case R.id.line2:
            case R.id.main_img2:
            case R.id.main_text2:
                startActivity(new Intent(getActivity(), PlantActivity.class));
                break;
            case R.id.line3:
            case R.id.main_img3:
            case R.id.main_text3:
                startActivity(new Intent(getActivity(), WaterQualityActivity.class));
                break;
            case R.id.line4:
            case R.id.main_img4:
            case R.id.main_text4:
                startActivity(new Intent(getActivity(), StorageActivity.class));
                break;
            case R.id.line5:
            case R.id.main_img5:
            case R.id.main_text5:
                startActivity(new Intent(getActivity(),PortationEnvironmentActivity.class));
                break;
            case R.id.line6:
            case R.id.main_img6:
            case R.id.main_text6:
                startActivity(new Intent(getActivity(), TransCompanyActivity.class));
                break;
            case R.id.line7:
            case R.id.main_img7:
            case R.id.main_text7:
                startActivity(new Intent(getActivity(), FoodNutritionActivity.class));
                break;
            case R.id.line8:
            case R.id.main_img8:
            case R.id.main_text8:
                startActivity(new Intent(getActivity(), NutrientActivity.class));
                break;
            default:
        }
    }

    public static
    class ViewHolder {
        public View rootView;
        public RoundedImageView mainImg1;
        public TextView mainText1;
        public LinearLayout line1;
        public RoundedImageView mainImg2;
        public TextView mainText2;
        public LinearLayout line2;
        public RoundedImageView mainImg3;
        public TextView mainText3;
        public LinearLayout line3;
        public RoundedImageView mainImg4;
        public TextView mainText4;
        public LinearLayout line4;
        public RoundedImageView mainImg5;
        public TextView mainText5;
        public LinearLayout line5;
        public RoundedImageView mainImg6;
        public TextView mainText6;
        public LinearLayout line6;
        public RoundedImageView mainImg7;
        public TextView mainText7;
        public LinearLayout line7;
        public RoundedImageView mainImg8;
        public TextView mainText8;
        public LinearLayout line8;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.mainImg1 = (RoundedImageView) rootView.findViewById(R.id.main_img1);
            this.mainText1 = (TextView) rootView.findViewById(R.id.main_text1);
            this.line1 = (LinearLayout) rootView.findViewById(R.id.line1);
            this.mainImg2 = (RoundedImageView) rootView.findViewById(R.id.main_img2);
            this.mainText2 = (TextView) rootView.findViewById(R.id.main_text2);
            this.line2 = (LinearLayout) rootView.findViewById(R.id.line2);
            this.mainImg3 = (RoundedImageView) rootView.findViewById(R.id.main_img3);
            this.mainText3 = (TextView) rootView.findViewById(R.id.main_text3);
            this.line3 = (LinearLayout) rootView.findViewById(R.id.line3);
            this.mainImg4 = (RoundedImageView) rootView.findViewById(R.id.main_img4);
            this.mainText4 = (TextView) rootView.findViewById(R.id.main_text4);
            this.line4 = (LinearLayout) rootView.findViewById(R.id.line4);
            this.mainImg5 = (RoundedImageView) rootView.findViewById(R.id.main_img5);
            this.mainText5 = (TextView) rootView.findViewById(R.id.main_text5);
            this.line5 = (LinearLayout) rootView.findViewById(R.id.line5);
            this.mainImg6 = (RoundedImageView) rootView.findViewById(R.id.main_img6);
            this.mainText6 = (TextView) rootView.findViewById(R.id.main_text6);
            this.line6 = (LinearLayout) rootView.findViewById(R.id.line6);
            this.mainImg7 = (RoundedImageView) rootView.findViewById(R.id.main_img7);
            this.mainText7 = (TextView) rootView.findViewById(R.id.main_text7);
            this.line7 = (LinearLayout) rootView.findViewById(R.id.line7);
            this.mainImg8 = (RoundedImageView) rootView.findViewById(R.id.main_img8);
            this.mainText8 = (TextView) rootView.findViewById(R.id.main_text8);
            this.line8 = (LinearLayout) rootView.findViewById(R.id.line8);
        }

    }
}