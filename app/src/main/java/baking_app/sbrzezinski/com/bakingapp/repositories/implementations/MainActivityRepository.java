package baking_app.sbrzezinski.com.bakingapp.repositories.implementations;

import java.util.List;

import baking_app.sbrzezinski.com.bakingapp.commmon_interfaces.ErrorCallback;
import baking_app.sbrzezinski.com.bakingapp.commmon_interfaces.SuccessCallback;
import baking_app.sbrzezinski.com.bakingapp.connectors.interfaces.IRecipeNetworkFetcher;
import baking_app.sbrzezinski.com.bakingapp.models.Recipe;
import baking_app.sbrzezinski.com.bakingapp.repositories.interfaces.IMainActivityRepository;

/**
 * Created by Stanislaw Brzezinski  on 22/03/2018 17:34.
 */

public class MainActivityRepository implements IMainActivityRepository {


    private IRecipeNetworkFetcher recipeNetworkFetcher;

    public MainActivityRepository(IRecipeNetworkFetcher recipeNetworkFetcher) {
        this.recipeNetworkFetcher = recipeNetworkFetcher;
    }

    @Override
    public void fetchRecipe(SuccessCallback<List<Recipe>> successCallback, ErrorCallback errorCallback) {
        recipeNetworkFetcher.fetchRecipes(successCallback, errorCallback);
    }
}
