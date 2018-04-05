package baking_app.sbrzezinski.com.bakingapp.dagger.components;

import javax.inject.Singleton;

import baking_app.sbrzezinski.com.bakingapp.dagger.modules.AdaptersModule;
import baking_app.sbrzezinski.com.bakingapp.dagger.modules.AppModule;
import baking_app.sbrzezinski.com.bakingapp.dagger.modules.ExoPlayerModule;
import baking_app.sbrzezinski.com.bakingapp.ui.activities.CombinedActivity;
import baking_app.sbrzezinski.com.bakingapp.ui.activities.DetailActivity;
import baking_app.sbrzezinski.com.bakingapp.ui.activities.MainActivity;
import baking_app.sbrzezinski.com.bakingapp.dagger.modules.VMModule;
import baking_app.sbrzezinski.com.bakingapp.ui.activities.StepsListActivity;
import baking_app.sbrzezinski.com.bakingapp.ui.adapters.steps_list_adapter.StepsListAdapter;
import baking_app.sbrzezinski.com.bakingapp.ui.fragments.DetailFragment;
import baking_app.sbrzezinski.com.bakingapp.ui.fragments.StepsListFragment;
import dagger.Component;

/**
 * Created by Stanislaw Brzezinski  on 22/03/2018 13:12.
 */
@Singleton
@Component(modules = {VMModule.class, AdaptersModule.class, AppModule.class, ExoPlayerModule.class})
public interface AppComponent {
    void inject(MainActivity mainActivity);
    void inject(StepsListFragment stepsListFragment);
    void inject(StepsListAdapter adapter);
    void inject(StepsListActivity activity);
    void inject(DetailActivity activity);
    void inject(DetailFragment fragment);
    void inject(CombinedActivity activity);
}
