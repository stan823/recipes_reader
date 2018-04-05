package baking_app.sbrzezinski.com.bakingapp.dagger.modules;

import javax.inject.Singleton;

import baking_app.sbrzezinski.com.bakingapp.ui.adapters.ingredients_adapter.IngredientsListAdapter;
import baking_app.sbrzezinski.com.bakingapp.ui.adapters.recipes_adapter.RecipesAdapter;
import baking_app.sbrzezinski.com.bakingapp.ui.adapters.steps_list_adapter.StepsListAdapter;
import baking_app.sbrzezinski.com.bakingapp.view_models.RecipesAdapterViewModel;
import baking_app.sbrzezinski.com.bakingapp.view_models.StepsListAdapterViewModel;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Stanislaw Brzezinski  on 28/03/2018 17:29.
 */
@Module(includes = {VMModule.class})
public class AdaptersModule {

    @Singleton
    @Provides
    public IngredientsListAdapter provideIngredientsListAdapter(){
        return new IngredientsListAdapter();
    }

    @Singleton
    @Provides
    public RecipesAdapter provideRecipesAdapter(RecipesAdapterViewModel viewModel){
        return new RecipesAdapter(viewModel);
    }

    @Singleton
    @Provides
    public StepsListAdapter provideStepListAdapter(StepsListAdapterViewModel viewModel){
        return new StepsListAdapter(viewModel);
    }
}
