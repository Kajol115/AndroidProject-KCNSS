package com.example.dell.navigationdrawer;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by dell on 14/03/2018.
 */

public class CustomList extends ArrayAdapter<String> {

    private String[] urls;
    private String[] names;
    private Bitmap[] bitmaps;
    private Activity context;

    public CustomList(Activity context, String[] urls,String[] names, Bitmap[] bitmaps) {
        super(context, R.layout.image_list_view, urls);
        this.context = context;
        this.urls= urls;
        this.bitmaps= bitmaps;
        this.names=names;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.image_list_view, null, true);
        TextView textViewURL = (TextView) listViewItem.findViewById(R.id.textViewURL);
        textViewURL.setText(urls[position]);
        ImageView image = (ImageView) listViewItem.findViewById(R.id.imageDownloaded);


        image.setImageBitmap(Bitmap.createScaledBitmap(bitmaps[position],100,50,false));
        return  listViewItem;
    }

}
