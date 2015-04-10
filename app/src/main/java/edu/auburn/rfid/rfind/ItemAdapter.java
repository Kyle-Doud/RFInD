package edu.auburn.rfid.rfind;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends BaseAdapter {

    public ItemAdapter(Context context, ArrayList list) {
        Adapter_Context = context;
        Adapter_List = list;
    }

    @Override
    public int getCount() {
        return Adapter_List.size();
    }

    @Override
    public Object getItem(int position) {
        return Adapter_List.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private String getTextForView(int position) {
        String result = Adapter_List.get(position).getUpcDescription().getVendor();
        result += Adapter_List.get(position).getUpcDescription().getStyle();
        return result;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //https://www.caveofprogramming.com/guest-posts/custom-gridview-with-imageview-and-textview-in-android.html
        View view;
        LayoutInflater inflater = (LayoutInflater) Adapter_Context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.image_and_text, null);
        ((TextView) view.findViewById(R.id.text)).setText(getTextForView(position));
        ((ImageView) view.findViewById(R.id.image)).setImageResource(R.drawable.collegeshirt);

        return view;
    }

    private Context Adapter_Context;
    private ArrayList<RfidItem> Adapter_List;
}
