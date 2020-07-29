package com.example.rss_reader;

import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public class RecyclerChildViewHolder extends ChildViewHolder {

    TextView textView_description;

    public RecyclerChildViewHolder(View itemView) {
        super(itemView);
        textView_description = itemView.findViewById(R.id.description);
    }

    public void bind(Child child) {
        textView_description.setText(child.getDescription());
    }

}
