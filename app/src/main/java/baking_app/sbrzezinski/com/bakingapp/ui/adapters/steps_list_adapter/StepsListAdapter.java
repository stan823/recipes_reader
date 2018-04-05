package baking_app.sbrzezinski.com.bakingapp.ui.adapters.steps_list_adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import baking_app.sbrzezinski.com.bakingapp.R;
import baking_app.sbrzezinski.com.bakingapp.models.Step;
import baking_app.sbrzezinski.com.bakingapp.view_models.StepsListAdapterViewModel;

/**
 * Created by Stanislaw Brzezinski  on 28/03/2018 17:04.
 */

public class StepsListAdapter extends RecyclerView.Adapter<StepsListViewHolder> {
    @NonNull
    private List<Step> steps = new ArrayList<>();

    private StepsListAdapterViewModel viewModel;

    public StepsListAdapter(StepsListAdapterViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public StepsListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_step, parent, false);
        return new StepsListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StepsListViewHolder holder, int position) {
        final Step step;
        if (position < steps.size() && (step = steps.get(position)) != null) {
            if (step==viewModel.getSelectedStep()){
                holder.select();
            }else{
                holder.unselect();
            }
            holder.setName(step.getShortDescription());
            holder.getNameHolder().setOnClickListener(v -> {
                viewModel.selectStep(step);
                notifyDataSetChanged();
            });
        }
    }

    @Override
    public int getItemCount() {
        return steps.size();
    }

    public void setSteps(@NonNull List<Step> steps) {
        this.steps = steps;
        notifyDataSetChanged();
    }
}
