package baking_app.sbrzezinski.com.bakingapp.modules;

import javax.inject.Singleton;

import baking_app.sbrzezinski.com.bakingapp.repositories.implementations.MainActivityRepository;
import baking_app.sbrzezinski.com.bakingapp.repositories.interfaces.IMainActivityRepository;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Stanislaw Brzezinski  on 22/03/2018 17:36.
 */
@Module
public class RepositoriesModule {

    @Provides
    @Singleton
    IMainActivityRepository provideMainActivityRepository(){
        return new MainActivityRepository();
    }
}
