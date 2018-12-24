package com.example.chevasso.ihm_app;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ListNameAdapter extends RecyclerView.Adapter<ListItemViewHolder> {

    private List<String> nameList;
    private final NameItemListener nameItemListener;

    public ListNameAdapter(NameItemListener nameItemListener) {
        this.nameItemListener = nameItemListener;
        nameList = new ArrayList<String>();
    }

    @NonNull
    @Override
    public ListItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_list_name, viewGroup, false); // fill viewGroup with item_slist_name
        return new ListItemViewHolder(view, nameItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemViewHolder listItemViewHolder, int i) {
        listItemViewHolder.setContent(nameList.get(i));
    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }

    public void updateData(List<String> nameList) {
        this.nameList.clear();
        this.nameList.addAll(nameList);

        notifyDataSetChanged(); // refresh the whole list
    }
}
