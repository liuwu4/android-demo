package cn.yj.first;

import android.os.Bundle;

import androidx.annotation.Nullable;

import cn.yj.first.utils.BaseActivity;

public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
