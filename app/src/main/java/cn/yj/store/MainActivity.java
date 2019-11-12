package cn.yj.store;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.yj.store.utils.OkRequest;
import okhttp3.Response;

/**
 * 主页
 *
 * @author yujie
 */
public class MainActivity extends Activity {
    private final String TAG = getClass().getName();
    private OkRequest okRequest = new OkRequest();
    private Button button;
    private ListView listView;

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
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Response response = okRequest.sendGet("china");
                        try {
                            JSONArray jsonArray = new JSONArray(response.body().string());
                            List arrayList = getData(jsonArray);
                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.citys_item, arrayList);
                            View view = getLayoutInflater().inflate(R.layout.city, null);
                            listView = view.findViewById(R.id.city);
                            listView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });
    }

    private List<String> getData(JSONArray jsonArray) throws JSONException {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            arrayList.add(jsonArray.getJSONObject(i).getString("name"));
        }
        return arrayList;
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
