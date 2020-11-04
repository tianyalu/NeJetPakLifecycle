package com.sty.ne.jetpaklifecycle.demo2;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @Author: tian
 * @UpdateDate: 2020/11/4 9:34 PM
 */
public class Activity2 extends AppCompatActivity {
    private ICallback iCallback;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        iCallback = GPSEngine.getInstance();
    }

    @Override
    protected void onResume() {
        super.onResume();

        iCallback.onResumeAction();
        //可能引发内存泄漏问题
        //iCallback.xxx(this);
    }

    @Override
    protected void onPause() {
        super.onPause();

        iCallback.onPauseAction();
    }
}
