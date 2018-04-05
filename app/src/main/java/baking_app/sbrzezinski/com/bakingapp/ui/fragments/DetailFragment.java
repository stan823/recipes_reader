package baking_app.sbrzezinski.com.bakingapp.ui.fragments;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.squareup.picasso.Picasso;

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
    @Inject
    SimpleExoPlayer player;
    private TextView nameHolder;
    private TextView descriptionHolder;
    private ImageView imageHolder;
    private SimpleExoPlayerView sev;


    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        init(view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        player.setPlayWhenReady(true);
        long currentPosition = viewModel.getCurrentPosition();
        player.seekTo(currentPosition);

    }

    @Override
    public void onPause() {
        super.onPause();
        viewModel.setCurrentPosition(player.getCurrentPosition());
        player.setPlayWhenReady(false);
    }

    private void init(View view) {
        BakingApplication.getBakingApplication().getAppComponent().inject(this);
        nameHolder = view.findViewById(R.id.tv_name);
        descriptionHolder = view.findViewById(R.id.tv_description);
        imageHolder = view.findViewById(R.id.iv_image);
        sev = view.findViewById(R.id.player);
        sev.setPlayer(player);
        viewModel.observe(this, this::stepObsever);
    }

    private void stepObsever(Step step) {
        if (step != null) {
            nameHolder.setText(step.getShortDescription());
            descriptionHolder.setText(step.getDescription());
            if (step.getThumbnailURL() != null && !step.getThumbnailURL().isEmpty()) {
                imageHolder.setVisibility(View.VISIBLE);
                Picasso.with(getActivity()).load(step.getThumbnailURL()).into(imageHolder);
            } else {
                imageHolder.setImageDrawable(null);
                imageHolder.setVisibility(View.GONE);
            }
            if (step != null && step.getVideoURL() != null && !step.getVideoURL().isEmpty()) {
                Log.d("thumb", "obsr");
                // Produces DataSource instances through which media data is loaded.
                DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(getActivity(),
                        Util.getUserAgent(getActivity(), "BakingApp"), null);
                // This is the MediaSource representing the media to be played.
                MediaSource videoSource = new ExtractorMediaSource(Uri.parse(step.getVideoURL()), dataSourceFactory, new DefaultExtractorsFactory(), null, null);
                // Prepare the player with the source.
                player.prepare(videoSource);
                player.setPlayWhenReady(true);
                sev.setVisibility(View.VISIBLE);
            } else {
                sev.setVisibility(View.GONE);
            }
        }
    }
}
