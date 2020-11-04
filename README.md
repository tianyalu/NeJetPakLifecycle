# JetPack之LifeCycle

[TOC]

## 一、概念

### 1.1 `JetPack`

`Jetpack` 是一个由多个库组成的套件，可帮助开发者遵循最佳做法，减少样板代码并编写可在各种 Android 版本和设备中一致运行的代码，让开发者精力集中编写重要的代码。

### 1.2 `Lifecycle`

`Lifecycle`可以用来监听`Activity/Fragment`的生命周期。其有如下优势：

* 解决代码入侵问题
* 解决内存泄漏问题
* 解决统一管理问题

## 二、实操

### 2.0 问题演进与优化

* `demo1`：如果有多个`Activity/Fragment`，为其所有的生命周期函数中添加业务/功能逻辑，一旦哪个`Activity/Fragment`中忘记写了，就会引发**一致性问题**；

* `demo2`：通过**接口**解决了**一致性问题** ，其实是吧功能/业务逻辑都写到了`GPSEngine`中，统一管理；虽然能解决**一致性问题**，但是引发**代码入侵问题**，还可能引发**内存泄漏问题**；

* `demo3`：使用**`Lifecycle`** 观察所有的`Actiivty/Fragment`，因为是观察者，所以没有**代码入侵**和**内存泄漏**。
### 2.1 使用示例

观察者角色：`CustomLifecycle`

```java
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
```

被观察者角色：`MainActivity`、`LoginActivity`、`RegisterActivity`

```java
//被观察者角色
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //绑定
        getLifecycle().addObserver(new CustomLifecycle());
    }
}
```

### 2.2 `GPSEngine`示例

观察者角色：`GPSEngine`

```java
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
```

被观察者角色：`Activity1`、`Activity2`...

```java
public class Activity1 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //绑定
        getLifecycle().addObserver(GPSEngine.getInstance());
    }
}
```

