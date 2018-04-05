package baking_app.sbrzezinski.com.bakingapp.ui.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import javax.inject.Inject;

import baking_app.sbrzezinski.com.bakingapp.BakingApplication;
import baking_app.sbrzezinski.com.bakingapp.R;
import baking_app.sbrzezinski.com.bakingapp.view_models.CombinedActivityViewModel;

public class CombinedActivity extends AppCompatActivity {

    @Inject
    CombinedActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        BakingApplication.getBakingApplication().getAppComponent().inject(this);
        if (getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT) {
            if (viewModel.isStepSelected()){
                startActivity(new Intent(this,DetailActivity.class));
            }else{
                startActivity(new Intent(this,StepsListActivity.class));
            }
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combined);
        if (getSupportActionBar()!=null){
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            viewModel.clearRecipe();
        }
        return super.onOptionsItemSelected(item);
    }
}
