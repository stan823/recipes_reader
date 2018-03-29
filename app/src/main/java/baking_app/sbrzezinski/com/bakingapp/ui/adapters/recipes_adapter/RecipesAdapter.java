package baking_app.sbrzezinski.com.bakingapp.ui.adapters.recipes_adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import baking_app.sbrzezinski.com.bakingapp.BakingApplication;
import baking_app.sbrzezinski.com.bakingapp.R;
import baking_app.sbrzezinski.com.bakingapp.models.Recipe;
import baking_app.sbrzezinski.com.bakingapp.view_models.RecipesAdapterViewModel;

/**
 * Created by Stanislaw Brzezinski  on 28/03/2018 17:04.
 */

public class RecipesAdapter extends RecyclerView.Adapter<RecipesViewHolder> {
    @NonNull
    private List<Recipe> recipeList = new ArrayList<>();

    RecipesAdapterViewModel viewModel;


    public RecipesAdapter(RecipesAdapterViewModel viewModel) {
        this.viewModel=viewModel;
    }

    @Override
    public RecipesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_recipe, parent, false);
        return new RecipesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecipesViewHolder holder, int position) {
        Recipe recipe=null;
        if (position<recipeList.size() && (recipe=recipeList.get(position))!=null){
            holder.setImage(recipe.getImage());
            holder.setName(recipe.getName());
            holder.getCard().setOnClickListener(v->viewModel.selectRecipe(recipeList.get(position)));
        }
    }

    public void setRecipeList(@NonNull List<Recipe> recipeList) {
        this.recipeList = recipeList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }
}
