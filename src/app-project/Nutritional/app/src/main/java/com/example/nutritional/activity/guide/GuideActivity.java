package com.example.nutritional.activity.guide;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.nutritional.R;
import com.example.nutritional.fragment.guide.GuideFragment1;
import com.example.nutritional.fragment.guide.GuideFragment2;
import com.example.nutritional.fragment.guide.GuideFragment3;
import com.example.nutritional.fragment.guide.GuideFragment4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

/**
 * @author 69182
 */
public class GuideActivity extends AppCompatActivity {

    private ViewPager guideViewPager;
    List<Fragment> list;
    private LinearLayout layout;
    ImageView[] icons;
    Fragment[] fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
    }

    private void initView() {
        list = new ArrayList<>();
        fragments = new Fragment[]{new GuideFragment1(), new GuideFragment2(), new GuideFragment3(), new GuideFragment4()};
        icons = new ImageView[fragments.length];
        guideViewPager = (ViewPager) findViewById(R.id.guide_viewPager);
        layout = (LinearLayout) findViewById(R.id.layout);
        //使图片增添更方便
        //得到ImageView对象
        list.addAll(Arrays.asList(fragments));
        //初始化下标
        initSubscript();
        //viewPager点击事件
        setOnClickListener();

        guideViewPager.setAdapter(new GuideAdapter(getSupportFragmentManager()));
    }

    private void setOnClickListener() {
        guideViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < fragments.length; i++) {
                    icons[i].setSelected(false);
                }
                //将当前下标的指示图片  选中
                icons[position].setSelected(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initSubscript() {
        LinearLayout layout = (LinearLayout) findViewById(R.id.layout);

        for (int i = 0; i < icons.length; i++) {
            //将布局中的指示图片放进数组里
            icons[i] = (ImageView) layout.getChildAt(i);
            //设置是否响应事件
            icons[i].setSelected(false);
            //给指示图片添加下标
            icons[i].setTag(i);
            icons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    guideViewPager.setCurrentItem((Integer) view.getTag());
                }
            });
            icons[0].setSelected(true);
        }
    }

    class GuideAdapter extends FragmentStatePagerAdapter {


        public GuideAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }
}