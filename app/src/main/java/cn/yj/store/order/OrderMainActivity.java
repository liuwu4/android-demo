package cn.yj.store.order;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

import androidx.annotation.Nullable;

import cn.yj.store.login.LoginActivity;
import cn.yj.store.R;
import cn.yj.store.components.RecyclerViewActivity;
import cn.yj.store.utils.BaseActivity;


public class OrderMainActivity extends BaseActivity {
    private Button mainButton;
    private Button dialogButton;
    private View view;
    private Button popButton;
    private Button recyclerButton;
    PopupWindow popupWindow;
    private final String TAG = getClass().getName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_main);
        mainButton = findViewById(R.id.main_activity);
        dialogButton = findViewById(R.id.dialog_activity);
        popButton = findViewById(R.id.popup_window);
        recyclerButton = findViewById(R.id.recycler_activity);
        showPopupWindow();
        click();
    }

    private void showPopupWindow() {
        view = LayoutInflater.from(OrderMainActivity.this).inflate(R.layout.county_item, null);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        popupWindow = new PopupWindow(view,
                ViewGroup.LayoutParams.MATCH_PARENT,
                displayMetrics.heightPixels/2);
        popupWindow.setFocusable(true);// 取得焦点
        //注意  要是点击外部空白处弹框消息  那么必须给弹框设置一个背景色  不然是不起作用的
        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_background));
        //点击外部消失
        popupWindow.setOutsideTouchable(true);
        //设置可以点击
        popupWindow.setTouchable(true);
        popupWindow.setAnimationStyle(R.style.pop_animation);
    }

    private void click() {
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderMainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderMainActivity.this, DialogActivity.class);
                startActivity(intent);
            }
        });
        recyclerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderMainActivity.this, RecyclerViewActivity.class);
                startActivity(intent);
            }
        });
        popButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.showAtLocation(popButton, Gravity.BOTTOM, 0, 0);
            }
        });
    }
}
