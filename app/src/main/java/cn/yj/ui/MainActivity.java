package cn.yj.ui;

import android.app.Activity;
import android.os.Bundle;

import cn.yj.R;

/**
 * 主页
 *
 * @author yujie
 */
public class MainActivity extends Activity {
    private final static String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_bind_test);
    }

}
