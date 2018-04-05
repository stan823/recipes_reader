package baking_app.sbrzezinski.com.bakingapp.view_models;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;

import baking_app.sbrzezinski.com.bakingapp.live_data.SelectedStepLiveData;
import baking_app.sbrzezinski.com.bakingapp.models.Step;

/**
 * Created by Stanislaw Brzezinski  on 05/04/2018 12:05.
 */

public class DetailsFragmentViewModel {
    private SelectedStepLiveData selectedStepLiveData;

    public DetailsFragmentViewModel(SelectedStepLiveData selectedStepLiveData) {
        this.selectedStepLiveData = selectedStepLiveData;
    }

    public void observe(LifecycleOwner owner, Observer<Step> observer){
        selectedStepLiveData.observe(owner, observer);
    }

    public Step getCurrStep(){
        return selectedStepLiveData.getValue();
    }

}
