package baking_app.sbrzezinski.com.bakingapp.view_models;

import baking_app.sbrzezinski.com.bakingapp.live_data.ExoPlayerCurrentPositionLiveData;
import baking_app.sbrzezinski.com.bakingapp.live_data.SelectedStepLiveData;

/**
 * Created by Stanislaw Brzezinski  on 04/04/2018 17:37.
 */

public class DetailActivityViewModel {
    private SelectedStepLiveData selectedStepLiveData;
    private ExoPlayerCurrentPositionLiveData exoPlayerCurrentPositionLiveData;

    public DetailActivityViewModel(SelectedStepLiveData selectedStepLiveData,ExoPlayerCurrentPositionLiveData exoPlayerCurrentPositionLiveData) {
        this.selectedStepLiveData = selectedStepLiveData;
        this.exoPlayerCurrentPositionLiveData=exoPlayerCurrentPositionLiveData;
    }

    public void clearStep(){
        selectedStepLiveData.setValue(null);
        exoPlayerCurrentPositionLiveData.setValue(0L);
    }

    public boolean isStepSelected(){
        return selectedStepLiveData.getValue()!=null;
    }
}
