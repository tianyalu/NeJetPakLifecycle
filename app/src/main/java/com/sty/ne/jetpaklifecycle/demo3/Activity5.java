package com.sty.ne.jetpaklifecycle.demo3;

import android.os.Bundle;

import com.sty.ne.jetpaklifecycle.demo2.ICallback;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleObserver;

/**
 * 被观察者
 * @Author: tian
 * @UpdateDate: 2020/11/4 9:34 PM
 */
public class Activity5 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //绑定
        getLifecycle().addObserver(GPSEngine.getInstance());
    }
}
