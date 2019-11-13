package cn.yj.store;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * 主页
 *
 * @author yujie
 */
public class MainActivity extends Activity {
    private final String TAG = getClass().getName();
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        button = findViewById(R.id.login);
//        click(button, "cn.yj.store.LOGIN_START");
    }
    private void click(Button btn, String action){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(action);
                startActivityForResult(intent, 1);
            }
        });

    }
}
