package baking_app.sbrzezinski.com.bakingapp.view_models;

import baking_app.sbrzezinski.com.bakingapp.live_data.SelectedRecipeLiveData;
import baking_app.sbrzezinski.com.bakingapp.models.Recipe;

/**
 * Created by Stanislaw Brzezinski  on 28/03/2018 17:32.
 */

public class RecipesAdapterViewModel {

    private SelectedRecipeLiveData selectedRecipeLiveData;

    public RecipesAdapterViewModel(SelectedRecipeLiveData selectedRecipeLiveData) {
        this.selectedRecipeLiveData = selectedRecipeLiveData;
    }

    public void selectRecipe(Recipe recipe){
        selectedRecipeLiveData.postValue(recipe);
    }
}
