package baking_app.sbrzezinski.com.bakingapp.components;

import javax.inject.Singleton;

import baking_app.sbrzezinski.com.bakingapp.MainActivity;
import baking_app.sbrzezinski.com.bakingapp.modules.ConnectorsModule;
import baking_app.sbrzezinski.com.bakingapp.modules.VMModule;
import baking_app.sbrzezinski.com.bakingapp.view_models.MainActivityViewModel;
import dagger.Component;

/**
 * Created by Stanislaw Brzezinski  on 22/03/2018 12:50.
 */
@Singleton
@Component(modules = {ConnectorsModule.class})
public interface ConnectorsComponent {
    void inject(MainActivityViewModel viewModel);
}
