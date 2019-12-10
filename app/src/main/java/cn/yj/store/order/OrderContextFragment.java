package cn.yj.store.order;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import cn.yj.store.R;

public class OrderContextFragment extends Fragment implements View.OnClickListener {
    private String TAG = getClass().getSimpleName();
    private TextView newOrder, handlerOrder, doneOrder;
    private List<TextView> textViewList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.order_context, container, false);
        newOrder = view.findViewById(R.id.new_order);
        handlerOrder = view.findViewById(R.id.handler_order);
        doneOrder = view.findViewById(R.id.done_order);
        textViewList = new ArrayList<>();
        bindClick();
        selectedTab(R.id.new_order);
        return view;
    }

    private void bindClick() {
        textViewList.add(newOrder);
        textViewList.add(handlerOrder);
        textViewList.add(doneOrder);
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
        switch (v.getId()) {
            case R.id.new_order:
                selectedTab(R.id.new_order);
                break;
            case R.id.handler_order:
                selectedTab(R.id.handler_order);
                break;
            case R.id.done_order:
                selectedTab(R.id.done_order);
                break;
            default:
                break;
        }
    }

    private void selectedTab(int id) {
        for (TextView textView : textViewList) {
            if (textView.getId() == id) {
                textView.setBackgroundResource(R.drawable.tab_selected);
            } else {
                textView.setBackgroundResource(R.drawable.tab_un_selected);
            }
        }
    }
}
