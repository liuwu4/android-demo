package cn.yj.store.order;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import cn.yj.store.MainActivity;
import cn.yj.store.R;
import cn.yj.store.compoments.RecyclerViewActivity;
import cn.yj.store.utils.BaseActivity;


public class OrderMainActivity extends BaseActivity implements View.OnClickListener {
    private TextView textView;
    private Button mainButton;
    private Button dialogButton;
    private Button recyclerButton;
    private ProgressBar progressBar;
    private final String TAG = getClass().getName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_main);
        progressBar = findViewById(R.id.progress);
        textView = findViewById(R.id.order);
        mainButton = findViewById(R.id.main_activity);
        dialogButton = findViewById(R.id.dialog_activity);
        recyclerButton = findViewById(R.id.recycler_activity);

        click();
    }

    @Override
    public void onClick(View view) {
        Log.i(TAG, "onClick: " + view.getId());
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: ");
    }

    private void click() {
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderMainActivity.this, MainActivity.class);
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
        recyclerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderMainActivity.this, RecyclerViewActivity.class);
                startActivity(intent);
            }
        });
    }
}
