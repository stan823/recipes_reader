package baking_app.sbrzezinski.com.bakingapp.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.inject.Inject;

import baking_app.sbrzezinski.com.bakingapp.BakingApplication;
import baking_app.sbrzezinski.com.bakingapp.R;
import baking_app.sbrzezinski.com.bakingapp.models.Step;
import baking_app.sbrzezinski.com.bakingapp.view_models.DetailsFragmentViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    @Inject
    DetailsFragmentViewModel viewModel;
    private TextView nameHolder;


    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_detail, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        BakingApplication.getBakingApplication().getAppComponent().inject(this);
        nameHolder = view.findViewById(R.id.tv_name);

        viewModel.observe(this,this::stepObsever);
    }

    private void stepObsever(Step step) {
        if (step!=null && step.getShortDescription()!=null){
            nameHolder.setText(step.getShortDescription());
        }
    }

}
