package baking_app.sbrzezinski.com.bakingapp.modules;

import javax.inject.Inject;
import javax.inject.Singleton;

import baking_app.sbrzezinski.com.bakingapp.BakingApplication;
import baking_app.sbrzezinski.com.bakingapp.commmon_interfaces.ErrorCallback;
import baking_app.sbrzezinski.com.bakingapp.commmon_interfaces.SuccessCallback;
import baking_app.sbrzezinski.com.bakingapp.connectors.implementations.RecipeRetrofitFetcher;
import baking_app.sbrzezinski.com.bakingapp.connectors.interfaces.IRecipeNetworkFetcher;
import baking_app.sbrzezinski.com.bakingapp.models.Recipe;
import dagger.Component;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Stanislaw Brzezinski  on 22/03/2018 12:15.
 */
@Module
public class ConnectorsModule {

    @Inject
    Retrofit retrofit;

    public ConnectorsModule() {
        BakingApplication.getBakingApplication().getNetworkComponent().inject(this);
    }

    @Singleton
    @Provides
    public IRecipeNetworkFetcher provideRecipesNetworkFetcher(){
        return new RecipeRetrofitFetcher();
    }
}
