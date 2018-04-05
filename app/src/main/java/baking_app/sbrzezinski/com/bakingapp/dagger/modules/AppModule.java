package baking_app.sbrzezinski.com.bakingapp.dagger.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Stanislaw Brzezinski  on 05/04/2018 14:46.
 */
@Module
public class AppModule {
    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    Context provideContext(){
        return this.context;
    }
}
