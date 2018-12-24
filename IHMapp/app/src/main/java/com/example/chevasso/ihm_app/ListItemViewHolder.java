package com.example.chevasso.ihm_app;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Instanciée pour chaque cellule
 */
public class ListItemViewHolder extends RecyclerView.ViewHolder {

    private TextView textViewName;
    final private NameItemListener nameItemListener;

    private String name;

    public ListItemViewHolder(@NonNull View itemView, final NameItemListener nameItemListener) {
        super(itemView);
        this.nameItemListener = nameItemListener;

        CardView cardView = itemView.findViewById(R.id.listeitem_textview_name);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameItemListener.clickOnItem(name);
            }
        });

        this.textViewName = itemView.findViewById(R.id.listeitem_textview_name);
    }

    public void setContent(String name) {
        this.name = name;
        textViewName.setText(name);
    }
}
