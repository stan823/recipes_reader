package baking_app.sbrzezinski.com.bakingapp.components;

import javax.inject.Singleton;

import baking_app.sbrzezinski.com.bakingapp.modules.RepositoriesModule;
import baking_app.sbrzezinski.com.bakingapp.view_models.MainActivityViewModel;
import dagger.Component;

/**
 * Created by Stanislaw Brzezinski  on 22/03/2018 17:36.
 */
@Singleton
@Component(modules = {RepositoriesModule.class})
public interface RepositoriesComponent {
    void inject(MainActivityViewModel viewModel);
}
