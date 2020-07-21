package com.example.nutritional.fragment.main.staffview;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nutritional.R;
import com.example.nutritional.activity.FoodNutritionActivity;
import com.example.nutritional.activity.KitchenActivity;
import com.example.nutritional.activity.PlantActivity;
import com.example.nutritional.activity.PortCompanyStaffActivity;
import com.example.nutritional.activity.PortationEnvironmentActivity;
import com.example.nutritional.activity.ProductionBaseInfoActivity;
import com.example.nutritional.activity.ProductionBaseStaffActivity;
import com.example.nutritional.activity.StorageActivity;
import com.example.nutritional.activity.TransCompanyActivity;
import com.example.nutritional.activity.WareHouseActivity;
import com.example.nutritional.activity.WaterQualityActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @author 69182
 */
public class StaffNavigationViewFragment extends Fragment {

    View view;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_navigationview_staff, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        ViewHolder viewHolder=new ViewHolder(view);
        viewHolder.navigationViewStaffText1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), WareHouseActivity.class));
            }
        });
        viewHolder.navigationViewStaffText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), KitchenActivity.class));
            }
        });
        viewHolder.navigationViewStaffText3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), PortCompanyStaffActivity.class));
            }
        });
        viewHolder.navigationViewStaffText4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ProductionBaseStaffActivity.class));
            }
        });
        viewHolder.navigationViewStaffText5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ProductionBaseInfoActivity.class));
            }
        });
        viewHolder.navigationViewStaffText6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), StorageActivity.class));
            }
        });
    }

    public static
    class ViewHolder {
        public View rootView;
        public TextView navigationViewStaffText1;
        public TextView navigationViewStaffText2;
        public TextView navigationViewStaffText3;
        public TextView navigationViewStaffText4;
        public TextView navigationViewStaffText5;
        public TextView navigationViewStaffText6;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.navigationViewStaffText1 = (TextView) rootView.findViewById(R.id.navigationView_staff_text1);
            this.navigationViewStaffText2 = (TextView) rootView.findViewById(R.id.navigationView_staff_text2);
            this.navigationViewStaffText3 = (TextView) rootView.findViewById(R.id.navigationView_staff_text3);
            this.navigationViewStaffText4 = (TextView) rootView.findViewById(R.id.navigationView_staff_text4);
            this.navigationViewStaffText5 = (TextView) rootView.findViewById(R.id.navigationView_staff_text5);
            this.navigationViewStaffText6 = (TextView) rootView.findViewById(R.id.navigationView_staff_text6);
        }

    }
}
