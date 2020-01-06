package cn.yj.first.ui.product;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import cn.yj.first.R;

public class ProductActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        Intent intent = getIntent();
        String img = intent.getStringExtra("img");
        Log.d(TAG, "onCreate: " + img);
    }
}
