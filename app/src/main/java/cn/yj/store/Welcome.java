package cn.yj.store;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import cn.yj.store.login.LoginActivity;
import cn.yj.store.utils.BaseActivity;

import static java.lang.Thread.sleep;

/**
 * 启动页
 *
 * @author yujie
 */
public class Welcome extends BaseActivity {
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_welcome);
        sharedPreferences = getSharedPreferences("set", Context.MODE_PRIVATE);
        new Thread(() -> {
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String token = sharedPreferences.getString("token", "null");
            Intent intent;
            intent = new Intent(Welcome.this, LoginActivity.class);
//            if(token.equals("null")){
//                intent = new Intent(Welcome.this, LoginActivity.class);
//            } else {
//                intent = new Intent(Welcome.this, NavigationMain.class);
//            }
            startActivity(intent);
            finish();
        }).start();
    }
}
