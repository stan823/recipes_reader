package baking_app.sbrzezinski.com.bakingapp.ui.adapters.ingredients_adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import baking_app.sbrzezinski.com.bakingapp.R;
import baking_app.sbrzezinski.com.bakingapp.models.Ingredient;

/**
 * Created by Stanislaw Brzezinski  on 28/03/2018 17:04.
 */

public class IngredientsListAdapter extends RecyclerView.Adapter<IngredientsListViewHolder> {
    @NonNull
    private List<Ingredient> ingredients = new ArrayList<>();

    @Override
    public IngredientsListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_ingredient, parent, false);
        return new IngredientsListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(IngredientsListViewHolder holder, int position) {
        final Ingredient ingredient;
        if (position< ingredients.size() && (ingredient= ingredients.get(position))!=null){

            holder.setName((position+1)+". "+ingredient.getIngredient()+" "+ingredient.getQuantity()+ingredient.getMeasure());
        }
    }

    public void setIngredients(@NonNull List<Ingredient> Ingredients) {
        this.ingredients = Ingredients;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }
}
