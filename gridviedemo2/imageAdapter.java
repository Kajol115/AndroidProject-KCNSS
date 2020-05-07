package com.example.dell.gridviedemo2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by dell on 31/08/2017.
 */

public class imageAdapter extends BaseAdapter {
    private Context mContext;
    public imageAdapter(Context c) {
        mContext=c;
    }

    public int getCount(){
        return mThumbIds.length;
    }

    private Integer[] mThumbIds={
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3
    };

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView==null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(20, 20, 20, 20);
        }
            else{
                imageView=(ImageView) convertView;
            }
            imageView.setImageResource(mThumbIds[position]);
            return imageView;
        }
}

