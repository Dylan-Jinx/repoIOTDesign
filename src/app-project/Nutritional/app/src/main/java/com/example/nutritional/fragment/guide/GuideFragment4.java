package com.example.nutritional.fragment.guide;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nutritional.R;
import com.example.nutritional.activity.account.AccountActivity;
import com.example.nutritional.activity.main.MainActivity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import static java.util.concurrent.Executors.*;

/**
 * @author 69182
 */
public class GuideFragment4 extends Fragment {

    View view;
    int flag=6;
    private AppCompatTextView guide_timer;
    private AppCompatTextView guide_Intent;
    ScheduledExecutorService service;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_guide4, container, false);
        initView();
        return view;
    }

    private void initView() {
        service= newScheduledThreadPool(1);
        guide_timer=view.findViewById(R.id.guide_timer);
        guide_Intent=view.findViewById(R.id.guide_Intent);
        GuideTimer();
        setOnClickListener();
    }

    private void setOnClickListener() {
        guide_Intent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),AccountActivity.class));
                service.shutdown();
                guide_timer.setVisibility(View.INVISIBLE);
            }
        });
    }

    private void GuideTimer() {
        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                flag--;
                guide_timer.setText(flag+" 跳過");
                if (flag==1){
                    flag=6;
                    startActivity(new Intent(getActivity(), AccountActivity.class));
                }
            }
        },0,1000, TimeUnit.MILLISECONDS);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        service.shutdown();
    }

    @Override
    public void onStop() {
        super.onStop();
        service.shutdown();
        guide_timer.setVisibility(View.INVISIBLE);
    }
}
