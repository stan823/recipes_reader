package baking_app.sbrzezinski.com.bakingapp.retrofit;

import java.util.List;

import baking_app.sbrzezinski.com.bakingapp.models.Recipe;
import baking_app.sbrzezinski.com.bakingapp.statics.WebUrls;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Stanislaw Brzezinski  on 22/03/2018 12:17.
 */

public interface RetrofitService {
    @GET(WebUrls.GET_URL)
    Call<List<Recipe>> getRecipes();
}
