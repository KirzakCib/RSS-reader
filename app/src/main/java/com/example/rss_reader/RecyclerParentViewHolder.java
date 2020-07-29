package com.example.rss_reader;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;


public class RecyclerParentViewHolder extends GroupViewHolder {

    TextView textView_title;
    TextView textView_home;
    ImageView imageView;
    Context context;

    public RecyclerParentViewHolder(View itemView) {
        super(itemView);
        this.context = itemView.getContext();
        textView_title = itemView.findViewById(R.id.text_name);
        textView_home = itemView.findViewById(R.id.text_home);
        imageView = itemView.findViewById(R.id.image);

    }

    public void bind(DataList dataList ) {
        textView_title.setText(dataList.getName());
        textView_home.setText(dataList.getHome());
        Picasso.with(context).load(dataList.getPicture().replace("http", "https")).error(R.mipmap.ic_launcher).into(imageView);
    }

}
