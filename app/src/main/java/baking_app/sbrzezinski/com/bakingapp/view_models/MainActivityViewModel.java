package baking_app.sbrzezinski.com.bakingapp.view_models;

import javax.inject.Inject;

import baking_app.sbrzezinski.com.bakingapp.BakingApplication;
import baking_app.sbrzezinski.com.bakingapp.repositories.interfaces.IMainActivityRepository;

/**
 * Created by Stanislaw Brzezinski  on 22/03/2018 12:25.
 */

public class MainActivityViewModel {
    @Inject
    IMainActivityRepository mainActivityRepository;

    public MainActivityViewModel() {
        BakingApplication.getBakingApplication().getRepositoriesComponent().inject(this);
    }

    public void execute() {
        mainActivityRepository.fetchRecipe(null,null);
    }


}
