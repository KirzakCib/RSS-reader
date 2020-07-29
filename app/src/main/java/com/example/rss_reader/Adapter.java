package com.example.rss_reader;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class Adapter extends ExpandableRecyclerViewAdapter<RecyclerParentViewHolder,RecyclerChildViewHolder> {


    public Adapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public RecyclerParentViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_holder, parent, false);
        return new RecyclerParentViewHolder(v);
    }

    @Override
    public RecyclerChildViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.expansion_recycler, parent, false);
        return new RecyclerChildViewHolder(v);
    }

    @Override
    public void onBindChildViewHolder(RecyclerChildViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        final Child child= (Child) group.getItems().get(childIndex);
        holder.bind(child);
    }

    @Override
    public void onBindGroupViewHolder(RecyclerParentViewHolder holder, int flatPosition, ExpandableGroup group) {
        final DataList dataList = (DataList) group;
        holder.bind(dataList);
    }
}
