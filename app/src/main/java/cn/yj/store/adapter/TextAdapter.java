package cn.yj.store.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import cn.yj.store.R;
import cn.yj.store.utils.ListName;

/**
 * @author: Administrator
 * 2019/11/17
 * description:
 */
public class TextAdapter extends ArrayAdapter<ListName> {
    private final String TAG =getClass().getSimpleName();
    private int resourceId = 0;
    public TextAdapter(@NonNull Context context, int resource, @NonNull List<ListName> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ListName listName = getItem(position);
        View  view = LayoutInflater.from(getContext())
                .inflate(resourceId, parent, false );
        TextView textView = view.findViewById(R.id.text);
        textView.setText(listName.getName());
        return view;
    }
}
