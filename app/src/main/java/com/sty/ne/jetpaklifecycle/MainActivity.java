package com.sty.ne.jetpaklifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//被观察者角色
public class MainActivity extends AppCompatActivity {
    private Button btnLogin;

    //生命周期函数
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //绑定
        getLifecycle().addObserver(new CustomLifecycle());
        initView();
    }

    private void initView() {
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });
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