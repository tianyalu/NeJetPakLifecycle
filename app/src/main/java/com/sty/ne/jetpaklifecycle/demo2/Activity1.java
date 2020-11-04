package com.sty.ne.jetpaklifecycle.demo2;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @Author: tian
 * @UpdateDate: 2020/11/4 9:34 PM
 */
//使用接口解决了 一致性问题 ， 但是代码被入侵了,还可能会继续引发内存泄漏问题
public class Activity1 extends AppCompatActivity {
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
