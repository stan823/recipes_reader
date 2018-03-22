package baking_app.sbrzezinski.com.bakingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

import baking_app.sbrzezinski.com.bakingapp.view_models.MainActivityViewModel;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Inject
    MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BakingApplication.getBakingApplication().getViewModelsComponent().inject(this);
       mainActivityViewModel.execute();
    }
}
