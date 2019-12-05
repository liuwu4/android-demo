package cn.yj.store;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import cn.yj.store.login.LoginActivity;
import cn.yj.store.utils.BaseActivity;

public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivityForResult(intent, 1);
    }
}
