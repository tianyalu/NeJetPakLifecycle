package com.sty.ne.jetpaklifecycle.demo1;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @Author: tian
 * @UpdateDate: 2020/11/4 9:34 PM
 */
//有一个非常严重的问题： 一致性问题
public class Activity5 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        GPSEngine.getInstance().setActive(true); //存活了，打开
        GPSEngine.getInstance().onResumeAction();
    }

    @Override
    protected void onPause() {
        super.onPause();
        GPSEngine.getInstance().setActive(false); //stop
        GPSEngine.getInstance().onPauseAction();
    }
}
