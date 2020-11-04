package com.sty.ne.jetpaklifecycle;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * 监听Activity/Fragment生命周期 --> 观察者角色
 * @Author: tian
 * @UpdateDate: 2020/11/4 9:13 PM
 */
public class CustomLifecycle implements LifecycleObserver {
    private static final String TAG = CustomLifecycle.class.getSimpleName();

    //监听onCreate 生命周期执行
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreateMethod() {
        Log.d(TAG, "onCreate生命周期函数执行了...");
    }

    //监听onStart 生命周期执行
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStartMethod() {
        Log.d(TAG, "onStart生命周期函数执行了...");
    }

    //监听onResume 生命周期执行
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResumeMethod() {
        Log.d(TAG, "onResume生命周期函数执行了...");
    }

    //监听onPause 生命周期执行
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPauseMethod() {
        Log.d(TAG, "onPause生命周期函数执行了...");
    }

    //监听onStop 生命周期执行
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStopMethod() {
        Log.d(TAG, "onStop生命周期函数执行了...");
    }

    //监听onDestroy 生命周期执行
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroyMethod() {
        Log.d(TAG, "onDestroy生命周期函数执行了...");
    }
}
