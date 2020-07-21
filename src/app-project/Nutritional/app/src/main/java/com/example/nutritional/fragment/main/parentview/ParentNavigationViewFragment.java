package com.example.nutritional.fragment.main.parentview;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nutritional.R;
import com.example.nutritional.activity.BillActivity;
import com.example.nutritional.activity.CookActivity;
import com.example.nutritional.activity.FoodNutritionActivity;
import com.example.nutritional.activity.NutrientActivity;
import com.example.nutritional.activity.PlantActivity;
import com.example.nutritional.activity.PortCompanyStaffActivity;
import com.example.nutritional.activity.ProductionBaseStaffActivity;
import com.example.nutritional.activity.StaffActivity;
import com.example.nutritional.activity.main.ParentActivity;
import com.example.nutritional.activity.main.StudentActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @author 69182
 */
public class ParentNavigationViewFragment extends Fragment {

    View view;
    private TextView navigationViewParentText1;
    private TextView navigationViewParentText2;
    private TextView navigationViewParentText3;
    private TextView navigationViewParentText4;
    private TextView navigationViewParentText5;
    private TextView navigationViewParentText6;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_navigationview_parent, container, false);
        initView();
        return view;
    }

    private void initView() {
        navigationViewParentText1 = view.findViewById(R.id.navigationView_parent_text1);
        navigationViewParentText2 = view.findViewById(R.id.navigationView_parent_text2);
        navigationViewParentText3 = view.findViewById(R.id.navigationView_parent_text3);
        navigationViewParentText4 = view.findViewById(R.id.navigationView_parent_text4);
        navigationViewParentText5 = view.findViewById(R.id.navigationView_parent_text5);
        navigationViewParentText6 = view.findViewById(R.id.navigationView_parent_text6);
        setClickListener();
    }

    private void setClickListener() {
        navigationViewParentText1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), BillActivity.class));
            }
        });
        navigationViewParentText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), FoodNutritionActivity.class));

            }
        });
        navigationViewParentText3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), NutrientActivity.class));

            }
        });
        navigationViewParentText4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), StaffActivity.class));

            }
        });
        navigationViewParentText5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ProductionBaseStaffActivity.class));

            }
        });
        navigationViewParentText6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), PortCompanyStaffActivity.class));

            }
        });
    }
}
