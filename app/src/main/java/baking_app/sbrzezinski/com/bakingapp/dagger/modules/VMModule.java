package baking_app.sbrzezinski.com.bakingapp.dagger.modules;

import javax.inject.Singleton;

import baking_app.sbrzezinski.com.bakingapp.live_data.RecipesLiveData;
import baking_app.sbrzezinski.com.bakingapp.live_data.SelectedRecipeLiveData;
import baking_app.sbrzezinski.com.bakingapp.repositories.interfaces.IMainActivityRepository;
import baking_app.sbrzezinski.com.bakingapp.view_models.MainActivityViewModel;
import baking_app.sbrzezinski.com.bakingapp.view_models.RecipesAdapterViewModel;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Stanislaw Brzezinski  on 22/03/2018 13:01.
 */
@Module(includes = {LiveDataModule.class,RepositoriesModule.class})
public class VMModule {

    @Provides
    @Singleton
    public MainActivityViewModel provideMainActivityViewModel(SelectedRecipeLiveData selectedRecipeLiveData,RecipesLiveData recipesLiveData, IMainActivityRepository repository){
        return new MainActivityViewModel(repository,recipesLiveData,selectedRecipeLiveData);
    }

    @Provides
    @Singleton
    public RecipesAdapterViewModel provideRecipesAdapterViewModel(SelectedRecipeLiveData selectedRecipeLiveData){
        return new RecipesAdapterViewModel(selectedRecipeLiveData);
    }
}
