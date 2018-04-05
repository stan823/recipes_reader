package baking_app.sbrzezinski.com.bakingapp.ui.adapters.ingredients_adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import baking_app.sbrzezinski.com.bakingapp.R;

/**
 * Created by Stanislaw Brzezinski  on 28/03/2018 16:52.
 */

public class IngredientsListViewHolder extends RecyclerView.ViewHolder {

    private final TextView nameHolder;

    public IngredientsListViewHolder(View itemView) {
        super(itemView);
        nameHolder = itemView.findViewById(R.id.tv_name);
    }



    public void setName(String name) {
        nameHolder.setText(name);
    }
}
