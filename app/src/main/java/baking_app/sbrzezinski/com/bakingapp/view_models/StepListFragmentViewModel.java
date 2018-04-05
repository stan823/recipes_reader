package baking_app.sbrzezinski.com.bakingapp.view_models;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;

import baking_app.sbrzezinski.com.bakingapp.live_data.SelectedRecipeLiveData;
import baking_app.sbrzezinski.com.bakingapp.models.Recipe;

/**
 * Created by Stanislaw Brzezinski  on 29/03/2018 16:34.
 */

public class StepListFragmentViewModel {
    private SelectedRecipeLiveData selectedRecipeLiveData;

    public StepListFragmentViewModel(SelectedRecipeLiveData selectedRecipeLiveData) {
        this.selectedRecipeLiveData = selectedRecipeLiveData;
    }

    @MainThread
    public void observe(@NonNull LifecycleOwner owner, @NonNull Observer<Recipe> observer) {
        selectedRecipeLiveData.observe(owner, observer);
    }
}
