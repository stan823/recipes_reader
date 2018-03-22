package baking_app.sbrzezinski.com.bakingapp.retrofit;

import baking_app.sbrzezinski.com.bakingapp.models.Recipe;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Stanislaw Brzezinski  on 22/03/2018 12:17.
 */

public interface RetrofitService {
    @GET("/abc")
    Call<Recipe> getRecipes();
}
