package baking_app.sbrzezinski.com.bakingapp.view_models;

import baking_app.sbrzezinski.com.bakingapp.live_data.SelectedStepLiveData;

/**
 * Created by Stanislaw Brzezinski  on 04/04/2018 17:37.
 */

public class DetailActivityViewModel {
    private SelectedStepLiveData selectedStepLiveData;

    public DetailActivityViewModel(SelectedStepLiveData selectedStepLiveData) {
        this.selectedStepLiveData = selectedStepLiveData;
    }

    public void clearStep(){
        selectedStepLiveData.setValue(null);
    }

    public boolean isStepSelected(){
        return selectedStepLiveData.getValue()!=null;
    }
}
