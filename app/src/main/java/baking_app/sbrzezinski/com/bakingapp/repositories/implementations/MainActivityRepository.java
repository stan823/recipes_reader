package baking_app.sbrzezinski.com.bakingapp.repositories.implementations;

import javax.inject.Inject;

import baking_app.sbrzezinski.com.bakingapp.BakingApplication;
import baking_app.sbrzezinski.com.bakingapp.commmon_interfaces.ErrorCallback;
import baking_app.sbrzezinski.com.bakingapp.commmon_interfaces.SuccessCallback;
import baking_app.sbrzezinski.com.bakingapp.connectors.interfaces.IRecipeNetworkFetcher;
import baking_app.sbrzezinski.com.bakingapp.models.Recipe;
import baking_app.sbrzezinski.com.bakingapp.repositories.interfaces.IMainActivityRepository;

/**
 * Created by Stanislaw Brzezinski  on 22/03/2018 17:34.
 */

public class MainActivityRepository implements IMainActivityRepository{
    @Inject
    IRecipeNetworkFetcher recipeNetworkFetcher;

    public MainActivityRepository() {
        BakingApplication.getBakingApplication().getConnectorsComponent().inject(this);
    }

    @Override
    public void fetchRecipe(SuccessCallback<Recipe> successCallback, ErrorCallback errorCallback) {
        recipeNetworkFetcher.fetchRecipes(successCallback, errorCallback);
    }
}
