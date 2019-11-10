package cn.yj.store.order;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import cn.yj.store.R;

public class OrderMainActivity extends Activity {
    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_main);
        textView = findViewById(R.id.order);
        button = findViewById(R.id.close);
        mainData();
        btnClick(button, 1, "点击按钮返回");
    }

    @Override
    public void onBackPressed() {
        destroy(1, "物理返回");
    }

    /**
     * 获取上一个活动传递的数据
     */
    public void mainData() {
        Intent intent = getIntent();
        String str = intent.getStringExtra("title");
        textView.setText(str);
    }

    /**
     * 按钮点击事件
     * @param btn button
     * @param code 请求码
     * @param text 内容
     */
    public void btnClick(Button btn, int code, String text) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                destroy(code, text);
            }
        });
    }


    /**
     * 销毁当前活动
     * @param code 请求码
     * @param text 返回数据
     */
    public void destroy(int code, String text) {
        Intent intent = new Intent();
        intent.putExtra("back", text);
        setResult(code, intent);
        finish();
    }
}
