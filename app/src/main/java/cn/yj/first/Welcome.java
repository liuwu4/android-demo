package cn.yj.first;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import static java.lang.Thread.sleep;

/**
 * 启动页
 *
 * @author yujie
 */
public class Welcome extends Activity {
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
            finish();
        }).start();
    }
}
