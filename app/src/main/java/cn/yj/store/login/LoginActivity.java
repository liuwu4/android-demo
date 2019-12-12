package cn.yj.store.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.yj.store.R;
import cn.yj.store.adapter.CountyAdapter;
import cn.yj.store.navigation.NavigationMain;
import cn.yj.store.utils.AnalysisJson;
import cn.yj.store.utils.BaseActivity;
import cn.yj.store.utils.OkRequest;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * 主页
 *
 * @author yujie
 */
public class LoginActivity extends BaseActivity {
    private final String TAG = getClass().getName();
    private String judgment = "0";
    private TextView nation;
    private LinearLayout nationLine;
    private LinearLayout codeLine;
    private TextView nationCode;
    private EditText consumerName;
    private EditText passWord;
    private EditText code;
    private Button sendCode;
    private Button login;
    private PopupWindow popupWindow;
    private ListView listView;
    private CountyAdapter countyAdapter;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedPreferences = getSharedPreferences("set", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        nationLine = findViewById(R.id.nation_line);
        codeLine = findViewById(R.id.code_line);
        nation = findViewById(R.id.nation);
        nationCode = findViewById(R.id.nation_code);
        consumerName = findViewById(R.id.consumer);
        code = findViewById(R.id.code);
        passWord = findViewById(R.id.password);
        sendCode = findViewById(R.id.send_code);
        login = findViewById(R.id.login);
        showPopupWindow();
        btnClick();
        setFocus();
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
                Handler handler = new Handler(new Handler.Callback() {
                    @Override
                    public boolean handleMessage(@NonNull Message msg) {
                        if (msg.what == 1) {
                            Object data = msg.obj;
                            JSONArray jsonArray = JSON.parseArray(data.toString());
                            countyAdapter = new CountyAdapter(LoginActivity.this, R.layout.county_item, jsonArray);
                            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    JSONObject jsonObject = (JSONObject) JSON.toJSON(jsonArray.get(position));
                                    nation.setText(jsonObject.get("name").toString());
                                    nationCode.setText("+" + jsonObject.get("phone_area_code"));
                                    popupWindow.dismiss();
                                }
                            });
                            listView.setAdapter(countyAdapter);
                        }
                        return false;
                    }
                });
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

    private void setFocus() {
        consumerName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (consumerName.getText() == null) {
                        Toast toast = Toast.makeText(getApplicationContext(), "请输入登录账号", Toast.LENGTH_LONG);
                        toast.show();
                    } else {
                        Handler handler = new Handler(new Handler.Callback() {
                            @Override
                            public boolean handleMessage(@NonNull Message msg) {
                                Object obj = msg.obj;
                                JSONObject jsonObject = JSON.parseObject(obj.toString());
                                judgment = (String) jsonObject.get("salesman_login_judgment");
                                if ("0".equals(judgment)) {
                                    codeLine.setVisibility(View.GONE);
                                } else {
                                    codeLine.setVisibility(View.VISIBLE);
                                }
                                return false;
                            }
                        });
                        new OkRequest().sendGet("unauthorization/salesman?phone=" + nationCode.getText() + "-" + consumerName.getText(), handler);
                    }
                }
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
        MediaType mediaType = MediaType.parse("application/json");
        String deviceId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("country_code", nationCode.getText().toString());
        jsonObject.put("device_code", deviceId);
        jsonObject.put("phone", nationCode.getText() + "-" + consumerName.getText());
        jsonObject.put("password", passWord.getText().toString());
        jsonObject.put("phone_code", code.getText().toString() == null ? "" : code.getText().toString());
        jsonObject.put("salesman_login_judgment", judgment);
        RequestBody body = RequestBody.create(mediaType, jsonObject.toString());
        Handler handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(@NonNull Message msg) {
                JSONObject login = new AnalysisJson().analysisObject(msg.obj);
                editor.putString("code", (String) login.get("code"));
                editor.putInt("id", (Integer) login.get("id"));
                editor.putString("token", (String) login.get("token"));
                editor.apply();
                return false;
            }
        });
        new OkRequest().sendMethod("POST", "unauthorization/salesman?action=login", body, handler);
        Intent intent = new Intent(this, NavigationMain.class);
        startActivity(intent);
        finish();
    }
}
