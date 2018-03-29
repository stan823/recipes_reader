package baking_app.sbrzezinski.com.bakingapp.dagger.components;

import javax.inject.Singleton;

import baking_app.sbrzezinski.com.bakingapp.dagger.modules.AdaptersModule;
import baking_app.sbrzezinski.com.bakingapp.ui.activities.MainActivity;
import baking_app.sbrzezinski.com.bakingapp.dagger.modules.VMModule;
import dagger.Component;

/**
 * Created by Stanislaw Brzezinski  on 22/03/2018 13:12.
 */
@Singleton
@Component(modules = {VMModule.class, AdaptersModule.class})
public interface MainActivityComponent {
    void inject(MainActivity mainActivity);
}
