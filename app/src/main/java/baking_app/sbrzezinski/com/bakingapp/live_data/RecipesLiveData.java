package baking_app.sbrzezinski.com.bakingapp.live_data;

import android.arch.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import baking_app.sbrzezinski.com.bakingapp.models.Recipe;

/**
 * Created by Stanislaw Brzezinski  on 26/03/2018 11:10.
 */

public class RecipesLiveData extends MutableLiveData<List<Recipe>> {
    public RecipesLiveData() {
        setValue(new ArrayList<Recipe>());
    }
}
