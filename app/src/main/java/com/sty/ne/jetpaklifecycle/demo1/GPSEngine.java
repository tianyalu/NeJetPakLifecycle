package com.sty.ne.jetpaklifecycle.demo1;

import android.util.Log;

/**
 * 模拟GPS 很耗电
 * @Author: tian
 * @UpdateDate: 2020/11/4 9:35 PM
 */
public class GPSEngine {
    private static final String TAG = GPSEngine.class.getSimpleName();
    private static volatile GPSEngine gpsEngine;
    private boolean isActive;

    private GPSEngine() {

    }

    public static GPSEngine getInstance() {
        if(gpsEngine == null) {
            synchronized (GPSEngine.class) {
                if(gpsEngine == null) {
                    gpsEngine = new GPSEngine();
                }
            }
        }
        return gpsEngine;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void onResumeAction() {
        //业务/功能逻辑
        Log.d(TAG, "启用 启动 GPS 定位...");
    }

    public void onPauseAction() {
        //业务/功能逻辑
        Log.d(TAG, "停用 停止 GPS 定位...");
    }
}
