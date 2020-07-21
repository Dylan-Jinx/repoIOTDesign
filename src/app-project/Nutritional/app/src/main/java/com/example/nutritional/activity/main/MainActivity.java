package com.example.nutritional.activity.main;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nutritional.R;
import com.example.nutritional.eventbus.EventBusParentInfo;
import com.example.nutritional.eventbus.EventBusStaffInfo;
import com.example.nutritional.fragment.main.parent.ParentFragment;
import com.example.nutritional.fragment.main.parentview.ParentNavigationViewFragment;
import com.example.nutritional.fragment.main.staff.StaffFragment;
import com.example.nutritional.fragment.main.staffview.StaffNavigationViewFragment;
import com.example.nutritional.util.FragmentUtils;
import com.google.android.material.navigation.NavigationView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import static com.example.nutritional.activity.account.LoginActivity.userType;
import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @author 69182
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private Button footerItemSetting;
    private Button footerItemOut;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    NetWorkReceiver netWorkReceiver;
    IntentFilter intentFilter;
    String StaffName = null,ParentName;
    ExecutorService service;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @Subscribe(threadMode = ThreadMode.ASYNC, sticky = true)
    public void onEventBus1(final EventBusParentInfo eventBus1) {
        service.execute(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //需要更新的UI内容
                        ParentName = eventBus1.getUserName();
                        initDrawerLayout();
                    }
                });
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.ASYNC, sticky = true)
    public void onEventBus2(final EventBusStaffInfo eventBus2) {
        service.execute(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //需要更新的UI内容
                        StaffName = eventBus2.getStaffName();
                        initDrawerLayout();
                    }
                });
            }
        });
    }

    private void initView() {
        service = newFixedThreadPool(1);
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        netWorkReceiver = new NetWorkReceiver();

        registerReceiver(netWorkReceiver, intentFilter);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        footerItemSetting = (Button) findViewById(R.id.footer_item_setting);
        footerItemOut = (Button) findViewById(R.id.footer_item_out);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);


        setClickListener();

        footerItemSetting.setOnClickListener(this);
        footerItemOut.setOnClickListener(this);
    }

    private void setClickListener() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.footer_item_setting:

                break;
            case R.id.footer_item_out:
                finish();
                break;
            default:
        }
    }

    @SuppressLint("ObsoleteSdkInt")
    private void initDrawerLayout() {

        //将toolbar与ActionBar关联setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, 0, 0);
        //初始化状态
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        /*---------------------------添加头布局和尾布局-----------------------------*/
        //获取xml头布局view
        View headerView = navigationView.getHeaderView(0);
        //添加头布局的另外一种方式
        //View headview=navigationview.inflateHeaderView(R.layout.navigationview_header);寻找头部里面的控件
        ImageView imageView = headerView.findViewById(R.id.iv_head);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "点击了头像", Toast.LENGTH_LONG).show();
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                return false;
            }
        });

        //ColorStateList csl = (ColorStateList) getResources().getColorStateList(R.color.nav_menu_text_color);
        //设置item的条目颜色
        //navigation_view.setItemTextColor(csl);
        //去掉默认颜色显示原来颜色  设置为null显示本来图片的颜色
        // navigation_view.setItemIconTintList(csl);

        //设置单个消息数量
        // LinearLayout llAndroid = (LinearLayout) navigation_view.getMenu().findItem(R.id.single_1).getActionView();
        // TextView msg= (TextView) llAndroid.findViewById(R.id.msg_bg);
        // msg.setText("99%");

        //设置条目点击监听
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                //安卓
                Toast.makeText(getApplicationContext(), menuItem.getTitle(), Toast.LENGTH_LONG).show();
                //设置哪个按钮被选中
                //menuItem.setChecked(true);
                //关闭侧边栏
                //drawer.closeDrawers();
                return false;
            }
        });

        String user = "家长";

        if (user.equals(userType)) {
            FragmentUtils.ReplaceFragment(getSupportFragmentManager(), R.id.navigation_view, new ParentNavigationViewFragment());
            FragmentUtils.ReplaceFragment(getSupportFragmentManager(), R.id.main_frame, new ParentFragment());
            ((TextView) headerView.findViewById(R.id.nav_header_user)).setText("用户名：" + ParentName);
        } else {
            FragmentUtils.ReplaceFragment(getSupportFragmentManager(), R.id.navigation_view, new StaffNavigationViewFragment());
            FragmentUtils.ReplaceFragment(getSupportFragmentManager(), R.id.main_frame, new StaffFragment());
            ((TextView) headerView.findViewById(R.id.nav_header_user)).setText("用户名：" + StaffName);

        }
        //状态透明
        //        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                //5.x开始需要把颜色设置透明，否则导航栏会呈现系统默认的浅灰色
//                Window window = MainActivity.this.getWindow();
//                View decorView = window.getDecorView();
//                //两个 flag 要结合使用，表示让应用的主体内容占用系统状态栏的空间
//                int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
//                decorView.setSystemUiVisibility(option);
//                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//                window.setStatusBarColor(Color.TRANSPARENT);
//                //导航栏颜色也可以正常设置
////                window.setNavigationBarColor(Color.TRANSPARENT);
//            } else {
//                Window window = MainActivity.this.getWindow();
//                WindowManager.LayoutParams attributes = window.getAttributes();
//                int flagTranslucentStatus = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
//                int flagTranslucentNavigation = WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION;
//                attributes.flags |= flagTranslucentStatus;
////                attributes.flags |= flagTranslucentNavigation;
//                window.setAttributes(attributes);
//            }
//        }
    }

    class NetWorkReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            assert connectivityManager != null;
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities != null) {
                Toast.makeText(context, "网络已开启", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "网络已关闭", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(netWorkReceiver);
    }
}