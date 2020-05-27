package cn.yj.first;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

/**
 * 主页
 *
 * @author yujie
 */
public class MainActivity extends Activity {
Button textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_main);
        textView = findViewById(R.id.main);

    }
}
