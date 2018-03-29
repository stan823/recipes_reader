package baking_app.sbrzezinski.com.bakingapp.live_data;

import android.arch.lifecycle.MutableLiveData;

import javax.inject.Singleton;

import baking_app.sbrzezinski.com.bakingapp.models.Recipe;

/**
 * Created by Stanislaw Brzezinski  on 28/03/2018 17:34.
 */
@Singleton
public class SelectedRecipeLiveData extends MutableLiveData<Recipe> {
    private static SelectedRecipeLiveData instance=new SelectedRecipeLiveData();

    public static SelectedRecipeLiveData getInstance() {
        return instance;
    }

    public SelectedRecipeLiveData(){}
}
