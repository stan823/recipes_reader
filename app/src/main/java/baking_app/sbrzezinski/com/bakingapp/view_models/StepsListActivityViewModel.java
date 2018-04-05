package baking_app.sbrzezinski.com.bakingapp.view_models;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;

import baking_app.sbrzezinski.com.bakingapp.live_data.SelectedRecipeLiveData;
import baking_app.sbrzezinski.com.bakingapp.live_data.SelectedStepLiveData;
import baking_app.sbrzezinski.com.bakingapp.models.Step;

/**
 * Created by Stanislaw Brzezinski  on 29/03/2018 16:41.
 */

public class StepsListActivityViewModel {
    private SelectedRecipeLiveData selectedRecipeLiveData;
    private SelectedStepLiveData selectedStepLiveData;

    public StepsListActivityViewModel(SelectedRecipeLiveData selectedRecipeLiveData, SelectedStepLiveData selectedStepLiveData) {
        this.selectedRecipeLiveData = selectedRecipeLiveData;
        this.selectedStepLiveData=selectedStepLiveData;
    }

    public void clearRecipe(){
        this.selectedRecipeLiveData.postValue(null);
    }

    @MainThread
    public void observeSelectedStep(@NonNull LifecycleOwner owner, @NonNull Observer<Step> observer) {
        selectedStepLiveData.observe(owner, observer);
    }

    public String getRecipeName(){
        if (selectedRecipeLiveData.getValue()!=null){
            return selectedRecipeLiveData.getValue().getName();
        }else{
            return "";
        }
    }
}
