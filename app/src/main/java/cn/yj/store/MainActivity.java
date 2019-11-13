package cn.yj.store;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;

import cn.yj.store.utils.OkRequest;

/**
 * 主页
 *
 * @author yujie
 */
public class MainActivity extends Activity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.intent);
        click(button);
    }

    public void click(Button btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent("cn.yj.store.ACTION_START");
//                intent.addCategory("cn.yj.store.DEFAULT");
//                intent.putExtra("title", "Hello World");
//                startActivityForResult(intent, 1);
                OkRequest okRequest = new OkRequest();
                try {
                  String str =  okRequest.sendRequest("","countries");
                    JSONArray jsonArray=new JSONArray(str);
                    for(int i=0;i<jsonArray.length();i++)
                    {
                       System.out.println(i);
                    }
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                setButton(requestCode, data);
                break;
            default:
                Toast.makeText(this, "没有符合要求的选项!", Toast.LENGTH_LONG).show();
                break;
        }
    }

    public void setButton(int code, Intent data) {
        if (code == 1) {
            String info = data.getStringExtra("back");
            button.setText(info);
            return;
        }
        Toast.makeText(this, "不符合要求", Toast.LENGTH_LONG).show();
    }
}
