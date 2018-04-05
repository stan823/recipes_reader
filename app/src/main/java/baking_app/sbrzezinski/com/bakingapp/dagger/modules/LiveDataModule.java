package baking_app.sbrzezinski.com.bakingapp.dagger.modules;

import javax.inject.Singleton;

import baking_app.sbrzezinski.com.bakingapp.live_data.ExoPlayerCurrentPositionLiveData;
import baking_app.sbrzezinski.com.bakingapp.live_data.RecipesLiveData;
import baking_app.sbrzezinski.com.bakingapp.live_data.SelectedRecipeLiveData;
import baking_app.sbrzezinski.com.bakingapp.live_data.SelectedStepLiveData;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Stanislaw Brzezinski  on 26/03/2018 11:12.
 */
@Module
public class LiveDataModule {
    @Provides
    @Singleton
    RecipesLiveData providesRecipesLiveData(){
        return new RecipesLiveData();
    }

    @Provides
    @Singleton
    SelectedRecipeLiveData provideSelectedRecipeLiveData(){
        return new SelectedRecipeLiveData();
    }

    @Provides
    @Singleton
    SelectedStepLiveData provideSelectedStepLiveData(){
        return new SelectedStepLiveData();
    }

    @Provides
    @Singleton
    ExoPlayerCurrentPositionLiveData provideExoPlayerLiveData(){
        return new ExoPlayerCurrentPositionLiveData();
    }
}
