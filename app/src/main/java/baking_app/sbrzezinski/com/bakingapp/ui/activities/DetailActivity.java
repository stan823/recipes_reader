package baking_app.sbrzezinski.com.bakingapp.ui.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import javax.inject.Inject;

import baking_app.sbrzezinski.com.bakingapp.BakingApplication;
import baking_app.sbrzezinski.com.bakingapp.R;
import baking_app.sbrzezinski.com.bakingapp.view_models.DetailActivityViewModel;

public class DetailActivity extends AppCompatActivity {

    @Inject
    DetailActivityViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE){
            startActivity(new Intent(this,CombinedActivity.class));
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if (getSupportActionBar()!=null){
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        BakingApplication.getBakingApplication().getAppComponent().inject(this);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            viewModel.clearStep();
        }
        return super.onOptionsItemSelected(item);
    }
}
