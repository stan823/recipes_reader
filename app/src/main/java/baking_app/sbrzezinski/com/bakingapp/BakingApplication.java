package baking_app.sbrzezinski.com.bakingapp;

import android.app.Application;

import baking_app.sbrzezinski.com.bakingapp.dagger.components.AppComponent;
import baking_app.sbrzezinski.com.bakingapp.dagger.components.DaggerAppComponent;
import baking_app.sbrzezinski.com.bakingapp.dagger.modules.AppModule;

/**
 * Created by Stanislaw Brzezinski  on 22/03/2018 11:45.
 */

public class BakingApplication extends Application {


    private static BakingApplication bakingApplication;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        bakingApplication = this;
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }


    public AppComponent getAppComponent() {
        return this.appComponent;
    }

    public static BakingApplication getBakingApplication() {
        return bakingApplication;
    }


}
