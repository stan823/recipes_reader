package baking_app.sbrzezinski.com.bakingapp.view_models;

import javax.inject.Inject;

import baking_app.sbrzezinski.com.bakingapp.BakingApplication;
import baking_app.sbrzezinski.com.bakingapp.connectors.interfaces.IRecipeNetworkFetcher;

/**
 * Created by Stanislaw Brzezinski  on 22/03/2018 12:25.
 */

public class MainActivityViewModel {
    @Inject
    IRecipeNetworkFetcher recipeNetworkFetcher;

    public MainActivityViewModel() {
        BakingApplication.getBakingApplication().getConnectorsComponent().inject(this);
    }

    public void execute(){
        recipeNetworkFetcher.getRecipes(null,null);
    }


}
