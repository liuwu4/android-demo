package cn.yj.store.lifeCycle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import cn.yj.store.R;

/**
 * 生命周期
 */
public class ActiveStatus extends Activity {
    private final String TAG = getClass().getName().toString();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: ");
        setContentView(R.layout.active_status);
    }
}
