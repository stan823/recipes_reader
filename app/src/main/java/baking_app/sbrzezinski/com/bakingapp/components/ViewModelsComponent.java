package baking_app.sbrzezinski.com.bakingapp.components;

import javax.inject.Singleton;

import baking_app.sbrzezinski.com.bakingapp.MainActivity;
import baking_app.sbrzezinski.com.bakingapp.modules.VMModule;
import dagger.Component;

/**
 * Created by Stanislaw Brzezinski  on 22/03/2018 13:12.
 */
@Singleton
@Component(modules = {VMModule.class})
public interface ViewModelsComponent {
    void inject(MainActivity mainActivity);
}
