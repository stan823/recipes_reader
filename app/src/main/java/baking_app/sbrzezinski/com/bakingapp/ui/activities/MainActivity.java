package baking_app.sbrzezinski.com.bakingapp.ui.activities;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

import baking_app.sbrzezinski.com.bakingapp.BakingApplication;
import baking_app.sbrzezinski.com.bakingapp.R;
import baking_app.sbrzezinski.com.bakingapp.models.Recipe;
import baking_app.sbrzezinski.com.bakingapp.ui.adapters.recipes_adapter.RecipesAdapter;
import baking_app.sbrzezinski.com.bakingapp.view_models.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    @Inject
    MainActivityViewModel mainActivityViewModel;

    @Inject
    RecipesAdapter recipesAdapter;

    private Observer<List<Recipe>> recipesObserver=recipes -> onRecipesChanged(recipes);
    private Observer<Recipe> selectedRecipeObserver=recipe -> onRecipeSelected(recipe);

    private void onRecipeSelected(Recipe recipe) {
        if (recipe!=null){
            startActivity(new Intent(this,StepsListActivity.class));
        }
    }

    private void onRecipesChanged(List<Recipe> recipes) {
        recipesAdapter.setRecipeList(recipes);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // injecting ViewModel and RecipesAdapter using Dagger Library
        BakingApplication.getBakingApplication().getAppComponent().inject(this);

        setUpAdapter();

        // subscribing to RecipesLiveData changes
        mainActivityViewModel.observeRecipes(this,this.recipesObserver);
        mainActivityViewModel.observeSelectedRecipe(this,this.selectedRecipeObserver);
    }

    private void setUpAdapter() {
        RecyclerView recipesHolder=findViewById(R.id.rv_recipes);
        recipesHolder.setLayoutManager(new LinearLayoutManager(this));
        recipesHolder.setAdapter(recipesAdapter);

    }
}
