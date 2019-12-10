package cn.yj.store.order;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import cn.yj.store.R;


public class OrderMainActivity extends AppCompatActivity implements View.OnClickListener {
    private String TAG = getClass().getSimpleName();

    private TextView newOrder, handlerOrder, doneOrder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_main);
        newOrder = findViewById(R.id.new_order);
        handlerOrder = findViewById(R.id.handler_order);
        doneOrder = findViewById(R.id.done_order);
        bindClick();
    }

    private void bindClick() {
        newOrder.setOnClickListener(this);
        handlerOrder.setOnClickListener(this);
        doneOrder.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        Log.i(TAG, "onClick: " + v.getId());
        switch (v.getId()) {
            case R.id.new_order:
                break;
            case R.id.handler_order:
                break;
            case R.id.done_order:
                break;
            default:
                break;
        }
    }
}
