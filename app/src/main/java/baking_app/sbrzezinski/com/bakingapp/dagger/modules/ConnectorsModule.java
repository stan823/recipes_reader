package baking_app.sbrzezinski.com.bakingapp.dagger.modules;

import javax.inject.Inject;
import javax.inject.Singleton;

import baking_app.sbrzezinski.com.bakingapp.BakingApplication;
import baking_app.sbrzezinski.com.bakingapp.connectors.implementations.RecipeRetrofitFetcher;
import baking_app.sbrzezinski.com.bakingapp.connectors.interfaces.IRecipeNetworkFetcher;
import baking_app.sbrzezinski.com.bakingapp.retrofit.RetrofitService;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Stanislaw Brzezinski  on 22/03/2018 12:15.
 */
@Module(includes = {NetworkModule.class})
public class ConnectorsModule {



    @Singleton
    @Provides
    public IRecipeNetworkFetcher provideRecipesNetworkFetcher(RetrofitService retrofitService){
        return new RecipeRetrofitFetcher(retrofitService);
    }

}
