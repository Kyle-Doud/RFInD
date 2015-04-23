package com.robert.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.robert.myapplication.R;
import com.robert.myapplication.item.RfidItem;

import java.util.List;

/**
 * @author Robert
 * @date 20-Apr-15.
 */
public class ItemAdapter extends ArrayAdapter<RfidItem> {
    public ItemAdapter(Context context, int resource, List<RfidItem> items) {
        super(context, resource, items);
        Adapter_Context = context;
        Resource_ID = resource;
    }

    private class Holder {
        ImageView Image_View;
        TextView Text_View;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        Holder holder;

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) Adapter_Context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(Resource_ID, parent, false);

            holder = new Holder();
            holder.Image_View = (ImageView) view.findViewById(R.id.image);
            holder.Text_View = (TextView) view.findViewById(R.id.text);

            view.setTag(holder);
        } else {
            holder = (Holder) view.getTag();
        }
        RfidItem item = getItem(position);
        holder.Text_View.setText(item.Content);
        holder.Image_View.setImageResource(R.drawable.college_shirt);

        return view;
    }

    private int Resource_ID;
    private Context Adapter_Context;
}
