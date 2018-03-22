package baking_app.sbrzezinski.com.bakingapp.connectors.interfaces;

import baking_app.sbrzezinski.com.bakingapp.commmon_interfaces.ErrorCallback;
import baking_app.sbrzezinski.com.bakingapp.commmon_interfaces.SuccessCallback;
import baking_app.sbrzezinski.com.bakingapp.models.Recipe;

/**
 * Created by Stanislaw Brzezinski  on 22/03/2018 12:08.
 */

public interface IRecipeNetworkFetcher {
    void getRecipes(SuccessCallback<Recipe> successCallback, ErrorCallback errorCallback);
}
