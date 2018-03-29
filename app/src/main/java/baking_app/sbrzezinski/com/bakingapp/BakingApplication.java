package baking_app.sbrzezinski.com.bakingapp;

import android.app.Application;

import baking_app.sbrzezinski.com.bakingapp.dagger.components.DaggerMainActivityComponent;
import baking_app.sbrzezinski.com.bakingapp.dagger.components.MainActivityComponent;
import baking_app.sbrzezinski.com.bakingapp.dagger.modules.VMModule;

/**
 * Created by Stanislaw Brzezinski  on 22/03/2018 11:45.
 */

public class BakingApplication extends Application {



    private static BakingApplication bakingApplication;
    private MainActivityComponent mainActivityComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        bakingApplication=this;

        mainActivityComponent = DaggerMainActivityComponent.builder().vMModule(new VMModule()).build();
    }






    public MainActivityComponent getMainActivityComponent() {
        return this.mainActivityComponent;
    }

    public static BakingApplication getBakingApplication() {
        return bakingApplication;
    }


}
