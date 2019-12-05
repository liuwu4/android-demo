package cn.yj.store.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.List;

/**
 * @author: Administrator
 * 2019/11/17
 * description:
 */
public class TextAdapter extends ArrayAdapter<String> {
    private final String TAG =getClass().getSimpleName();
    private int resourceId = 0;
//    public TextAdapter(@NonNull Context context, int resource, @NonNull List<ListName> objects) {
////        super(context, resource, objects);
//        resourceId = resource;
//    }

    /**
     * Constructor
     *
     * @param context            The current context.
     * @param resource           The resource ID for a layout file containing a layout to use when
     *                           instantiating views.
     * @param textViewResourceId The id of the TextView within the layout resource to be populated
     * @param objects            The objects to represent in the ListView.
     */
    public TextAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<String> objects) {
        super(context, resource, textViewResourceId, objects);
    }

//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        ListName listName = getItem(position);
//        View  view = LayoutInflater.from(getContext())
//                .inflate(resourceId, parent, false );
//        TextView textView = view.findViewById(R.id.text);
//        textView.setText(listName.getName());
//        return view;
//    }
}
