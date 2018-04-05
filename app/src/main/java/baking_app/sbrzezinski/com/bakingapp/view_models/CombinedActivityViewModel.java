package baking_app.sbrzezinski.com.bakingapp.view_models;

import baking_app.sbrzezinski.com.bakingapp.live_data.SelectedRecipeLiveData;
import baking_app.sbrzezinski.com.bakingapp.live_data.SelectedStepLiveData;

/**
 * Created by Stanislaw Brzezinski  on 05/04/2018 11:39.
 */

public class CombinedActivityViewModel {
    private SelectedStepLiveData selectedStepLiveData;
    private SelectedRecipeLiveData selectedRecipeLiveData;

    public CombinedActivityViewModel(SelectedStepLiveData selectedStepLiveData, SelectedRecipeLiveData selectedRecipeLiveData) {
        this.selectedStepLiveData = selectedStepLiveData;
        this.selectedRecipeLiveData=selectedRecipeLiveData;
    }

    public boolean isStepSelected(){
        return selectedStepLiveData.getValue()!=null;
    }

    public void clearRecipe(){
        selectedRecipeLiveData.postValue(null);
        selectedStepLiveData.postValue(null);
    }
}
