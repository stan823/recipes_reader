package baking_app.sbrzezinski.com.bakingapp.dagger.modules;

import javax.inject.Singleton;

import baking_app.sbrzezinski.com.bakingapp.live_data.RecipesLiveData;
import baking_app.sbrzezinski.com.bakingapp.live_data.SelectedRecipeLiveData;
import baking_app.sbrzezinski.com.bakingapp.live_data.SelectedStepLiveData;
import baking_app.sbrzezinski.com.bakingapp.repositories.interfaces.IMainActivityRepository;
import baking_app.sbrzezinski.com.bakingapp.view_models.CombinedActivityViewModel;
import baking_app.sbrzezinski.com.bakingapp.view_models.DetailActivityViewModel;
import baking_app.sbrzezinski.com.bakingapp.view_models.DetailsFragmentViewModel;
import baking_app.sbrzezinski.com.bakingapp.view_models.MainActivityViewModel;
import baking_app.sbrzezinski.com.bakingapp.view_models.RecipesAdapterViewModel;
import baking_app.sbrzezinski.com.bakingapp.view_models.StepListFragmentViewModel;
import baking_app.sbrzezinski.com.bakingapp.view_models.StepsListActivityViewModel;
import baking_app.sbrzezinski.com.bakingapp.view_models.StepsListAdapterViewModel;
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

    @Provides
    @Singleton
    StepsListAdapterViewModel provideListAdapterViewModel(SelectedStepLiveData selectedStepLiveData){
        return new StepsListAdapterViewModel(selectedStepLiveData);
    }

    @Provides
    @Singleton
    StepListFragmentViewModel provideStepsListFragmentViewModel(SelectedRecipeLiveData selectedRecipeLiveData){
        return new StepListFragmentViewModel(selectedRecipeLiveData);
    }

    @Provides
    @Singleton
    StepsListActivityViewModel provideStepsListAcitvityViewModel(SelectedRecipeLiveData selectedRecipeLiveData,SelectedStepLiveData selectedStepLiveData){
        return new StepsListActivityViewModel(selectedRecipeLiveData,selectedStepLiveData);
    }

    @Provides
    @Singleton
    DetailActivityViewModel provideDetailsActivityViewModel(SelectedStepLiveData selectedStepLiveData){
        return new DetailActivityViewModel(selectedStepLiveData);
    }

    @Provides
    @Singleton
    CombinedActivityViewModel provideCombinedActiviytViewModel(SelectedStepLiveData selectedStepLiveData,SelectedRecipeLiveData selectedRecipeLiveData){
        return new CombinedActivityViewModel(selectedStepLiveData,selectedRecipeLiveData);
    }

    @Provides
    @Singleton
    DetailsFragmentViewModel provideDetailsFragmentViewModel(SelectedStepLiveData selectedStepLiveData){
        return new DetailsFragmentViewModel(selectedStepLiveData);
    }
}
