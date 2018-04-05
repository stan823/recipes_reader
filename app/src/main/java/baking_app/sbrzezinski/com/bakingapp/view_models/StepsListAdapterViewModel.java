package baking_app.sbrzezinski.com.bakingapp.view_models;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;

import baking_app.sbrzezinski.com.bakingapp.live_data.SelectedRecipeLiveData;
import baking_app.sbrzezinski.com.bakingapp.live_data.SelectedStepLiveData;
import baking_app.sbrzezinski.com.bakingapp.models.Recipe;
import baking_app.sbrzezinski.com.bakingapp.models.Step;

/**
 * Created by Stanislaw Brzezinski  on 29/03/2018 10:48.
 */

public class StepsListAdapterViewModel {
    private SelectedStepLiveData selectedStepLiveData;

    public StepsListAdapterViewModel(SelectedStepLiveData selectedStepLiveData) {
        this.selectedStepLiveData = selectedStepLiveData;
    }

    public void selectStep(Step step){
        selectedStepLiveData.postValue(step);
    }

    public Step getSelectedStep(){
        return selectedStepLiveData.getValue();
    }

}
