package cn.yj.store.login;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import cn.yj.store.R;

/**
 * 选择国家弹窗
 */
public class County extends AppCompatActivity {
    private String TAG = getClass().getSimpleName();
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.county_list);
        listView = findViewById(R.id.county_list);
        itemClick();
    }

    private void itemClick() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "onItemClick: 点击列表");
            }
        });
    }
}
