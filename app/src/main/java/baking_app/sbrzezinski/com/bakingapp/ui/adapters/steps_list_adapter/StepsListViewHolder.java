package baking_app.sbrzezinski.com.bakingapp.ui.adapters.steps_list_adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import baking_app.sbrzezinski.com.bakingapp.R;

/**
 * Created by Stanislaw Brzezinski  on 28/03/2018 16:52.
 */

public class StepsListViewHolder extends RecyclerView.ViewHolder {

    private final TextView nameHolder;

    public StepsListViewHolder(View itemView) {
        super(itemView);
        nameHolder = itemView.findViewById(R.id.tv_name);
    }


    public void select() {
        nameHolder.setSelected(true);
    }

    public void unselect() {
        nameHolder.setSelected(false);
    }

    public TextView getNameHolder() {
        return this.nameHolder;
    }

    public void setName(String name) {
        nameHolder.setText(name);
    }
}
