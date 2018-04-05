package baking_app.sbrzezinski.com.bakingapp.ui.fragments;


import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import javax.inject.Inject;

import baking_app.sbrzezinski.com.bakingapp.BakingApplication;
import baking_app.sbrzezinski.com.bakingapp.R;
import baking_app.sbrzezinski.com.bakingapp.models.Recipe;
import baking_app.sbrzezinski.com.bakingapp.ui.adapters.ingredients_adapter.IngredientsListAdapter;
import baking_app.sbrzezinski.com.bakingapp.ui.adapters.steps_list_adapter.StepsListAdapter;
import baking_app.sbrzezinski.com.bakingapp.view_models.StepListFragmentViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class StepsListFragment extends Fragment {

    @Inject
    IngredientsListAdapter ingredientsAdapter;
    @Inject
    StepListFragmentViewModel viewModel;
    @Inject
    StepsListAdapter stepsAdapter;
    private Observer<Recipe> recipeObserver = recipe -> onRecipesChanged(recipe);

    public StepsListFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_steps_list, container, false);
        BakingApplication.getBakingApplication().getAppComponent().inject(this);
        init(view);
        viewModel.observe(this, this.recipeObserver);
        return view;
    }

    private void init(View view) {
        RecyclerView stepsHolder = view.findViewById(R.id.rv_steps);
        stepsHolder.setLayoutManager(new LinearLayoutManager(getActivity()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        stepsHolder.setNestedScrollingEnabled(false);
        stepsHolder.setAdapter(stepsAdapter);
        RecyclerView ingredientsHolder = view.findViewById(R.id.rv_ingredients);
        ingredientsHolder.setLayoutManager(new LinearLayoutManager(getActivity()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        ingredientsHolder.setAdapter(ingredientsAdapter);
        ingredientsHolder.setNestedScrollingEnabled(false);


    }

    private void onRecipesChanged(Recipe recipe) {
        if (recipe != null) {
            if (recipe.getSteps() != null) {
                stepsAdapter.setSteps(recipe.getSteps());
            }
            if (recipe.getIngredients() != null) {
                ingredientsAdapter.setIngredients(recipe.getIngredients());
            }
        } else {
            stepsAdapter.setSteps(new ArrayList<>());
            ingredientsAdapter.setIngredients(new ArrayList<>());
        }
    }

}
