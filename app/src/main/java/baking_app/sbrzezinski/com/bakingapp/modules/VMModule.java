package baking_app.sbrzezinski.com.bakingapp.modules;

import javax.inject.Inject;
import javax.inject.Singleton;

import baking_app.sbrzezinski.com.bakingapp.BakingApplication;
import baking_app.sbrzezinski.com.bakingapp.connectors.interfaces.IRecipeNetworkFetcher;
import baking_app.sbrzezinski.com.bakingapp.view_models.MainActivityViewModel;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Stanislaw Brzezinski  on 22/03/2018 13:01.
 */
@Module
public class VMModule {

    @Provides
    @Singleton
    public MainActivityViewModel provideMainActivityViewModel(){
        return new MainActivityViewModel();
    }
}
