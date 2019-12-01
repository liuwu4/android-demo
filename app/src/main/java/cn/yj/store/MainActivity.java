package cn.yj.store;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * 主页
 *
 * @author yujie
 */
public class MainActivity extends Activity {
    private final String TAG = getClass().getName();
    private TextView nation;
    private TextView nationCode;
    private EditText consumerName;
    private EditText passWord;
    private EditText code;
    private Button sendCode;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nation = findViewById(R.id.nation);
        nationCode = findViewById(R.id.nation_code);
        consumerName = findViewById(R.id.consumer);
        code = findViewById(R.id.code);
        passWord = findViewById(R.id.password);
        sendCode = findViewById(R.id.send_code);
        login = findViewById(R.id.login);
        btnClick();
        inputEdit();
    }
    private void btnClick(){
        sendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "sendCode:发送验证码 ");
            }
        });
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "login: 登录");
                loginAfter();
            }
        });
    }
    private void inputEdit(){
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
    private void loginAfter(){
        Log.d(TAG, "国家: "+nation.getText());
        Log.d(TAG, "国家code: "+nationCode.getText());
        Log.d(TAG, "用户名: "+consumerName.getText());
        Log.d(TAG, "验证码: "+code.getText());
        Log.d(TAG, "密码: "+passWord.getText());
    }
}
