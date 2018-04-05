package baking_app.sbrzezinski.com.bakingapp.ui.activities;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import javax.inject.Inject;

import baking_app.sbrzezinski.com.bakingapp.BakingApplication;
import baking_app.sbrzezinski.com.bakingapp.R;
import baking_app.sbrzezinski.com.bakingapp.models.Step;
import baking_app.sbrzezinski.com.bakingapp.ui.fragments.StepsListFragment;
import baking_app.sbrzezinski.com.bakingapp.view_models.StepsListActivityViewModel;

/**
 * Created by Stanislaw Brzezinski  on 29/03/2018 10:38.
 */

public class StepsListActivity extends AppCompatActivity {


    @Inject
    StepsListActivityViewModel viewModel;
    private Observer<Step> selectedStepObserver=step -> onStepSelected(step);

    private void onStepSelected(Step step) {
        if (step!=null) {
            startActivity(new Intent(this, DetailActivity.class));
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        BakingApplication.getBakingApplication().getAppComponent().inject(this);
        if (getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
            startActivity(new Intent(this,CombinedActivity.class));
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps_list);
        if (getSupportActionBar()!=null){
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(viewModel.getRecipeName());
        }
        viewModel.observeSelectedStep(this,selectedStepObserver);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("hrere","I'm here");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            viewModel.clearRecipe();
        }
        return super.onOptionsItemSelected(item);
    }
}
