package cn.yj.store.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

import cn.yj.store.R;


public class CountyAdapter extends ArrayAdapter<Object> {
    private final  String TAG = getClass().getSimpleName();
    private int resourceId;

    /**
     * Constructor
     *
     * @param context  The current context.
     * @param resource The resource ID for a layout file containing a TextView to use when
     *                 instantiating views.
     * @param objects  The objects to represent in the ListView.
     */
    public CountyAdapter(@NonNull Context context, int resource, @NonNull List<Object> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Object obj = getItem(position);
        View view = null;
        if(view == null){
             view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        }

        TextView textView = view.findViewById(R.id.county_name);
        JSONObject jsonObject = (JSONObject) JSON.toJSON(obj);
        try {
            textView.setText((CharSequence) jsonObject.get("name"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return view;
    }
}
