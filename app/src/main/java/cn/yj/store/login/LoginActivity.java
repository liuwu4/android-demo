package cn.yj.store.login;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import cn.yj.store.R;
import cn.yj.store.adapter.CountyAdapter;
import cn.yj.store.utils.BaseActivity;
import cn.yj.store.utils.OkRequest;

/**
 * 主页
 *
 * @author yujie
 */
public class LoginActivity extends BaseActivity {
    private final String TAG = getClass().getName();
    private Handler handler;
    private TextView nation;
    private TextView countyName;
    private LinearLayout nationLine;
    private TextView nationCode;
    private EditText consumerName;
    private EditText passWord;
    private EditText code;
    private Button sendCode;
    private Button login;
    private PopupWindow popupWindow;
    private ListView listView;
    private CountyAdapter countyAdapter;
    String[] str = {
            "12342",
            "125tegfd",
            "1ewth",
            "1sgfjhh",
            "1hgfd465est",
            "1sdfhg",
            "1gfds",
            "1sgdf",
            "1gsdf",
            "1gfds",
            "1fgasfgd",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        nationLine = findViewById(R.id.nation_line);
        nation = findViewById(R.id.nation);
        nationCode = findViewById(R.id.nation_code);
        consumerName = findViewById(R.id.consumer);
        code = findViewById(R.id.code);
        passWord = findViewById(R.id.password);
        sendCode = findViewById(R.id.send_code);
        login = findViewById(R.id.login);
        showPopupWindow();
        btnClick();
        inputEdit();
    }

    private void showPopupWindow() {


        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        View view = LayoutInflater.from(LoginActivity.this).inflate(R.layout.county_list, null);
        listView = view.findViewById(R.id.list_view);
        popupWindow = new PopupWindow(view, displayMetrics.widthPixels, displayMetrics.heightPixels / 2);
        popupWindow.setFocusable(true);// 取得焦点
        //注意  要是点击外部空白处弹框消息  那么必须给弹框设置一个背景色  不然是不起作用的
        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_background));
        //点击外部消失
        popupWindow.setOutsideTouchable(true);
        //设置可以点击
        popupWindow.setTouchable(true);
        popupWindow.setAnimationStyle(R.style.pop_animation);

    }

    private void btnClick() {
        nationLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler = new Handler() {
                    @Override
                    public void handleMessage(@NonNull Message msg) {
                        Log.d(TAG, "handleMessage: " + msg.obj);
                        if (msg.what == 1) {
                            Object data = msg.obj;
                            JSONArray jsonArray = JSON.parseArray(data.toString());
                            countyAdapter = new CountyAdapter(LoginActivity.this, R.layout.county_item, jsonArray);
                            listView.setAdapter(countyAdapter);
                        }
                    }
                };
                new OkRequest().sendGet("countries", handler);
                popupWindow.showAtLocation(nationLine, Gravity.BOTTOM, 0, 0);
            }
        });
        sendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "sendCode:发送验证码 ");
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginAfter();
            }
        });
    }

    private void inputEdit() {
        consumerName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d(TAG, "consumer:before ");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(TAG, "consumer:changed ");
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d(TAG, "consumer:after ");
            }
        });
        code.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        passWord.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void loginAfter() {
        Log.d(TAG, "国家: " + nation.getText());
        Log.d(TAG, "国家code: " + nationCode.getText());
        Log.d(TAG, "用户名: " + consumerName.getText());
        Log.d(TAG, "验证码: " + code.getText());
        Log.d(TAG, "密码: " + passWord.getText());
    }
}
