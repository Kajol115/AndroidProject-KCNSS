package com.example.dell.navigationdrawer;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by dell on 11/02/2018.
 */

public class CustomAdapter extends ArrayAdapter {
    model[] modelItems = null;
    Context context;
    public CustomAdapter(@NonNull Context context,  model[] resource) {
        super(context,R.layout.row, resource);
        this.context = context;
        this.modelItems = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.row, parent, false);
        TextView name = (TextView) convertView.findViewById(R.id.t1);
       // CheckBox cb = (CheckBox) convertView.findViewById(R.id.checkBox1);
        name.setText(modelItems[position].getName());
        /*if(modelItems[position].getValue() == 1)
            cb.setChecked(true);
        else
            cb.setChecked(false);*/
        return convertView;
    }
}
