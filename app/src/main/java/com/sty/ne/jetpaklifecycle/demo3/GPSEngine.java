package com.sty.ne.jetpaklifecycle.demo3;

import android.util.Log;

import com.sty.ne.jetpaklifecycle.demo2.ICallback;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * 模拟GPS 很耗电
 * 观察者角色
 * @Author: tian
 * @UpdateDate: 2020/11/4 9:35 PM
 */
public class GPSEngine implements LifecycleObserver {
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

    //在下面解决了一致性问题，把所有Activity的业务/功能逻辑全部封装到这里来了，统一管理
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResumeAction() {
        //业务/功能逻辑
        setActive(true);
        Log.d(TAG, "启用 启动 GPS 定位...");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPauseAction() {
        //业务/功能逻辑
        setActive(false);
        Log.d(TAG, "停用 停止 GPS 定位...");
    }
}
