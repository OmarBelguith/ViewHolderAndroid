package com.example.admin.lab2;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by admin on 4/25/2017.
 */

public class CustomAdapter extends ArrayAdapter<String> {


    public CustomAdapter(Context context, String[] items) {
        super( context,R.layout.custom_row, items);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        ViewHolder viewHolder;
        if (convertView==null){
            convertView = inflater.inflate(R.layout.custom_row,null);
            viewHolder = new ViewHolder();
            viewHolder.label = (TextView) convertView.findViewById(R.id.grade);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.moodImg);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        String item = getItem(position);
        viewHolder.label.setText(item);
        float grade = Float.valueOf(item);
        viewHolder.image.setImageResource((grade>=10)?R.drawable.ic_mood:R.drawable.ic_mood_bad);
        return convertView;
    }
}
