package baking_app.sbrzezinski.com.bakingapp.components;

import javax.inject.Singleton;

import baking_app.sbrzezinski.com.bakingapp.MainActivity;
import baking_app.sbrzezinski.com.bakingapp.modules.ConnectorsModule;
import baking_app.sbrzezinski.com.bakingapp.modules.NetworkModule;
import dagger.Component;

/**
 * Created by Stanislaw Brzezinski  on 22/03/2018 11:43.
 */
@Singleton
@Component(modules = {NetworkModule.class})
public interface NetworkComponent {
    void inject(ConnectorsModule connectorsModule);
}
