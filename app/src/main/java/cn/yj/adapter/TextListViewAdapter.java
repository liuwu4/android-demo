package cn.yj.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import cn.yj.first.R;
import cn.yj.dao.TextListView;

public class TextListViewAdapter extends ArrayAdapter<TextListView> {
    private int testId;
    /**
     * Constructor
     *
     * @param context  The current context.
     * @param resource The resource ID for a layout file containing a TextView to use when
     *                 instantiating views.
     * @param objects  The objects to represent in the ListView.
     */
    public TextListViewAdapter(@NonNull Context context, int resource, @NonNull List<TextListView> objects) {
        super(context, resource, objects);
        testId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextListView textListView = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(testId, parent, false);
        TextView textView = view.findViewById(R.id.list_item_text);
        Button button = view.findViewById(R.id.list_item_btn);
        textView.setText(textListView.getText());
        button.setText(R.string.app_name+textListView.getText());
        return view;
    }
}
