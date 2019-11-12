package cn.yj.store.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import cn.yj.store.Citys;

/**
 * @author: Administrator
 * 2019/11/12
 * description:
 */
public class CitysAdapter extends ArrayAdapter<Citys> {

    public CitysAdapter(@NonNull Context context, int resource, @NonNull List<Citys> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
}

