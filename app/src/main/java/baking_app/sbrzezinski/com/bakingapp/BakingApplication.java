package baking_app.sbrzezinski.com.bakingapp;

import android.app.Application;

import baking_app.sbrzezinski.com.bakingapp.components.ConnectorsComponent;
import baking_app.sbrzezinski.com.bakingapp.components.DaggerConnectorsComponent;
import baking_app.sbrzezinski.com.bakingapp.components.DaggerNetworkComponent;
import baking_app.sbrzezinski.com.bakingapp.components.DaggerRepositoriesComponent;
import baking_app.sbrzezinski.com.bakingapp.components.DaggerViewModelsComponent;
import baking_app.sbrzezinski.com.bakingapp.components.NetworkComponent;
import baking_app.sbrzezinski.com.bakingapp.components.RepositoriesComponent;
import baking_app.sbrzezinski.com.bakingapp.components.ViewModelsComponent;
import baking_app.sbrzezinski.com.bakingapp.modules.ConnectorsModule;
import baking_app.sbrzezinski.com.bakingapp.modules.NetworkModule;
import baking_app.sbrzezinski.com.bakingapp.modules.RepositoriesModule;
import baking_app.sbrzezinski.com.bakingapp.modules.VMModule;

/**
 * Created by Stanislaw Brzezinski  on 22/03/2018 11:45.
 */

public class BakingApplication extends Application {

    private NetworkComponent networkComponent;
    private ConnectorsComponent connectorsComponent;

    private static BakingApplication bakingApplication;
    private ViewModelsComponent viewModelsComponent;
    private RepositoriesComponent repositoriesComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        bakingApplication=this;
        networkComponent = DaggerNetworkComponent.builder()
                .networkModule(new NetworkModule("http://google.com"))
                .build();
        connectorsComponent= DaggerConnectorsComponent.builder().connectorsModule(new ConnectorsModule()).build();
        repositoriesComponent = DaggerRepositoriesComponent.builder().repositoriesModule(new RepositoriesModule()).build();
        viewModelsComponent = DaggerViewModelsComponent.builder().vMModule(new VMModule()).build();


    }

    public RepositoriesComponent getRepositoriesComponent() {
        return this.repositoriesComponent;
    }

    public ViewModelsComponent getViewModelsComponent() {
        return this.viewModelsComponent;
    }

    public NetworkComponent getNetworkComponent() {
        return this.networkComponent;
    }

    public static BakingApplication getBakingApplication() {
        return bakingApplication;
    }

    public ConnectorsComponent getConnectorsComponent() {
        return this.connectorsComponent;
    }


}
