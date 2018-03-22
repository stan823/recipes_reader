package baking_app.sbrzezinski.com.bakingapp.repositories.interfaces;

import baking_app.sbrzezinski.com.bakingapp.commmon_interfaces.ErrorCallback;
import baking_app.sbrzezinski.com.bakingapp.commmon_interfaces.SuccessCallback;
import baking_app.sbrzezinski.com.bakingapp.models.Recipe;

/**
 * Created by Stanislaw Brzezinski  on 22/03/2018 17:33.
 */

public interface IMainActivityRepository {
    void fetchRecipe(SuccessCallback<Recipe> successCallback, ErrorCallback errorCallback);
}
