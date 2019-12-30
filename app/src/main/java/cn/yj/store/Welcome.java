package cn.yj.store;

import android.content.Intent;
import android.os.Bundle;

import cn.yj.store.utils.BaseActivity;

import static java.lang.Thread.sleep;

/**
 * 启动页
 *
 * @author yujie
 */
public class Welcome extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_welcome);
        new Thread(() -> {
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Intent intent = new Intent(Welcome.this, MainActivity.class);
            startActivity(intent);
        }).start();
    }
}
