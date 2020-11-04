package com.sty.ne.jetpaklifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
//被观察者角色
public class RegisterActivity extends AppCompatActivity {

    //生命周期函数
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //绑定
        getLifecycle().addObserver(new CustomLifecycle());
    }

    //生命周期函数
    @Override
    protected void onStart() {
        super.onStart();
    }

    //生命周期函数
    @Override
    protected void onResume() {
        super.onResume();
    }

    //生命周期函数
    @Override
    protected void onPause() {
        super.onPause();
    }

    //生命周期函数
    @Override
    protected void onStop() {
        super.onStop();
    }

    //生命周期函数
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}