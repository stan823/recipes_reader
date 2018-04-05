package baking_app.sbrzezinski.com.bakingapp.view_models;

import baking_app.sbrzezinski.com.bakingapp.live_data.ExoPlayerCurrentPositionLiveData;
import baking_app.sbrzezinski.com.bakingapp.live_data.SelectedRecipeLiveData;
import baking_app.sbrzezinski.com.bakingapp.live_data.SelectedStepLiveData;

/**
 * Created by Stanislaw Brzezinski  on 05/04/2018 11:39.
 */

public class CombinedActivityViewModel {
    private SelectedStepLiveData selectedStepLiveData;
    private SelectedRecipeLiveData selectedRecipeLiveData;
    private ExoPlayerCurrentPositionLiveData exoPlayerCurrentPositionLiveData;

    public CombinedActivityViewModel(SelectedStepLiveData selectedStepLiveData, SelectedRecipeLiveData selectedRecipeLiveData, ExoPlayerCurrentPositionLiveData exoPlayerCurrentPositionLiveData) {
        this.selectedStepLiveData = selectedStepLiveData;
        this.selectedRecipeLiveData=selectedRecipeLiveData;
        this.exoPlayerCurrentPositionLiveData=exoPlayerCurrentPositionLiveData;
    }

    public boolean isStepSelected(){
        return selectedStepLiveData.getValue()!=null;
    }

    public void clearRecipe(){
        selectedRecipeLiveData.postValue(null);
        selectedStepLiveData.postValue(null);
        exoPlayerCurrentPositionLiveData.setValue(0L);
    }
}
