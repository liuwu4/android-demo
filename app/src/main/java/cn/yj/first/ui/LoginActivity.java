package cn.yj.first.ui;

import android.content.Intent;
import android.hardware.biometrics.BiometricPrompt;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alibaba.fastjson.JSONObject;

import cn.yj.first.R;
import cn.yj.first.ui.product.ProductActivity;
import cn.yj.first.utils.BaseActivity;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private final String TAG = getClass().getSimpleName();
    private TextView country, areaCode, sendCode;
    private EditText phone, verification, password;
    private Button login;
    private ImageView hideShow, picTure;
    private BiometricPrompt biometricPrompt;
    private BiometricPrompt mBiometricPrompt;
    private CancellationSignal mCancellationSignal;
    private BiometricPrompt.AuthenticationCallback mAuthenticationCallback;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        country = findViewById(R.id.country);
        areaCode = findViewById(R.id.area_code);
        phone = findViewById(R.id.phone);
        verification = findViewById(R.id.verification);
        sendCode = findViewById(R.id.send_code);
        password = findViewById(R.id.password);
        hideShow = findViewById(R.id.hide_show);
        login = findViewById(R.id.login);
        picTure = findViewById(R.id.picture);
//        Glide.with(this).load("http://cn.bing.com/az/hprichbg/rb/Dongdaemun_ZH-CN10736487148_1920x1080.jpg").into(picTure);
        listener();
    }

    /**
     * 点击事件
     */
    private void listener() {
        sendCode.setOnClickListener(this);
        hideShow.setOnClickListener(this);
        login.setOnClickListener(this);
    }


    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        Log.d(TAG, "onClick: " + v.getId());
        switch (v.getId()) {
            case R.id.send_code:
                Log.d(TAG, "onClick: 发送验证码");
                break;
            case R.id.hide_show:
                Log.d(TAG, "onClick: 小眼睛");
                break;
            case R.id.login:

                JSONObject loginJson = new JSONObject();
                loginJson.put("country_code", "CN");
                loginJson.put("phone", "+86-18080394810");
                loginJson.put("password", "123456");
                loginJson.put("phone_code", "");
                loginJson.put("device_code", "1234");
                loginJson.put("salesman_login_judgment", "0");
                Handler handler = new Handler(new Handler.Callback() {
                    @Override
                    public boolean handleMessage(@NonNull Message msg) {
                        if (msg.what == 200) {
                            Intent intent = new Intent(LoginActivity.this, ProductActivity.class);
                            intent.putExtra("img", msg.obj.toString());
                            startActivity(intent);
                            finish();
                        }
                        return false;
                    }
                });
//                new OkRequest().sendBaidu(handler);
//                new OkRequest().sendMethod("POSt", "unauthorization/salesman?action=login ", loginJson.toString(), handler);
                Log.d(TAG, "onClick: 登录");
//                closeKeyboard();
                break;
            default:
                break;
        }
    }

    private void closeKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.getSystemService(INPUT_METHOD_SERVICE);
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.getWindow().getDecorView().getWindowToken(), 0);
        }
    }
}
