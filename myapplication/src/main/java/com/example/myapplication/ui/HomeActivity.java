package com.example.myapplication.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Switch;
import android.widget.Toast;

import com.example.myapplication.Adapter.HomeAdapter;
import com.example.myapplication.R;

/**
 * Created by john1 on 2017/10/20.
 */

public class HomeActivity extends Activity {
    //声明GrisView
    private GridView gv_home;
    private long mExitTime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化布局
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);
        //初始化GridView
        gv_home = findViewById(R.id.gv_home);
        gv_home.setAdapter(new HomeAdapter(HomeActivity.this));
        gv_home.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        //手机防盗
                        break;
                    case 1: // 点击通讯卫士
                        startActivity(SecurityPhoneActivity.class);
                        break;
                    case 2: // 软件管家
                        startActivity(AppManagerActivity.class);
                        break;
                    case 3:// 手机杀毒
                        startActivity(VirusScanActivity.class);
                        break;
                    case 4:// 缓存清理
                        startActivity(CacheClearListActivity.class);
                        break;
                    case 5:// 进程管理
                        startActivity(ProcessManagerActivity.class);
                        break;
                    case 6: // 流量统计
                        startActivity(TrafficMonitoringActivity.class);
                        break;
                    case 7: // 高级工具
                        startActivity(AdvancedToolsActivity.class);
                        break;
                    case 8: // 设置中心
                        startActivity(SettingsActivity.class);
                        break;
                }
            }
        });
    }

    /**
     * 开启新的Activity不关闭自己
     */
    public void startActivity(Class<?> cls){
        Intent intent = new Intent(HomeActivity.this,cls);
        startActivity(intent);
    }
    /** 判断用户是否设置过手机防盗密码 */
    private boolean isSetUpPassword() {
        return true;
    }

    /**
     * 按两次退出程序
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            if ((System.currentTimeMillis() - mExitTime) < 2000){
                System.exit(0);
            }else {
                Toast.makeText(this,"再按一次退出程序",Toast.LENGTH_SHORT).show();
                mExitTime = System.currentTimeMillis();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
