package baking_app.sbrzezinski.com.bakingapp.view_models;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import baking_app.sbrzezinski.com.bakingapp.BakingApplication;
import baking_app.sbrzezinski.com.bakingapp.live_data.RecipesLiveData;
import baking_app.sbrzezinski.com.bakingapp.live_data.SelectedRecipeLiveData;
import baking_app.sbrzezinski.com.bakingapp.models.Recipe;
import baking_app.sbrzezinski.com.bakingapp.repositories.interfaces.IMainActivityRepository;

/**
 * Created by Stanislaw Brzezinski  on 22/03/2018 12:25.
 */

public class MainActivityViewModel {
    private IMainActivityRepository mainActivityRepository;
    private RecipesLiveData recipesLiveData;
    private SelectedRecipeLiveData selectedRecipeLiveData;

    public MainActivityViewModel(IMainActivityRepository mainActivityRepository, RecipesLiveData recipesLiveData,SelectedRecipeLiveData selectedRecipeLiveData) {
        this.mainActivityRepository = mainActivityRepository;
        this.recipesLiveData = recipesLiveData;
        this.selectedRecipeLiveData=selectedRecipeLiveData;
        mainActivityRepository.fetchRecipe(this::recipesFetcherSuccessCallback,this::recipesFetcherErrorCallback);
    }


    @MainThread
    public void observeRecipes(@NonNull LifecycleOwner owner, @NonNull Observer<List<Recipe>> observer) {
        recipesLiveData.observe(owner, observer);
    }

    private void recipesFetcherErrorCallback() {
        Log.d("recipes","error");
    }

    private void recipesFetcherSuccessCallback(List<Recipe> recipes) {

        recipesLiveData.postValue(recipes);
    }

    @MainThread
    public void observeSelectedRecipe(@NonNull LifecycleOwner owner, @NonNull Observer<Recipe> observer) {
        selectedRecipeLiveData.observe(owner, observer);
    }
}
