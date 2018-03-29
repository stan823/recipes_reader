package baking_app.sbrzezinski.com.bakingapp.connectors.implementations;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import baking_app.sbrzezinski.com.bakingapp.BakingApplication;
import baking_app.sbrzezinski.com.bakingapp.commmon_interfaces.ErrorCallback;
import baking_app.sbrzezinski.com.bakingapp.commmon_interfaces.SuccessCallback;
import baking_app.sbrzezinski.com.bakingapp.connectors.interfaces.IRecipeNetworkFetcher;
import baking_app.sbrzezinski.com.bakingapp.models.Recipe;
import baking_app.sbrzezinski.com.bakingapp.retrofit.RetrofitCallback;
import baking_app.sbrzezinski.com.bakingapp.retrofit.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Stanislaw Brzezinski  on 22/03/2018 12:13.
 */

public class RecipeRetrofitFetcher implements IRecipeNetworkFetcher {

    private RetrofitService retrofitService;

    public RecipeRetrofitFetcher(RetrofitService retrofitService) {
        this.retrofitService = retrofitService;
    }

    @Inject
    @Override
    public void fetchRecipes(SuccessCallback<List<Recipe>> successCallback, ErrorCallback errorCallback) {
        Callback<List<Recipe>> retrofitCallback=new RetrofitCallback<>(successCallback,errorCallback);
        Call<List<Recipe>> call=retrofitService.getRecipes();
        call.enqueue(retrofitCallback);
    }
}
