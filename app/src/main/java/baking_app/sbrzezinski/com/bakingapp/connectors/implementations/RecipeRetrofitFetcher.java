package baking_app.sbrzezinski.com.bakingapp.connectors.implementations;

import android.util.Log;

import baking_app.sbrzezinski.com.bakingapp.commmon_interfaces.ErrorCallback;
import baking_app.sbrzezinski.com.bakingapp.commmon_interfaces.SuccessCallback;
import baking_app.sbrzezinski.com.bakingapp.connectors.interfaces.IRecipeNetworkFetcher;
import baking_app.sbrzezinski.com.bakingapp.models.Recipe;

/**
 * Created by Stanislaw Brzezinski  on 22/03/2018 12:13.
 */

public class RecipeRetrofitFetcher implements IRecipeNetworkFetcher {
    @Override
    public void getRecipes(SuccessCallback<Recipe> successCallback, ErrorCallback errorCallback) {
        Log.d("abc","executed!!!!!!!!!!!");
    }
}
