package baking_app.sbrzezinski.com.bakingapp.exoplayer;

import android.content.Context;
import android.util.Log;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;

/**
 * Created by Stanislaw Brzezinski  on 05/04/2018 14:42.
 */

public class ExoPlayerProvider {
    private SimpleExoPlayer player;

    public ExoPlayerProvider(Context context) {
        Log.d("thumb","cr");
        TrackSelection.Factory videoTrackSelectionFactory =
                new AdaptiveTrackSelection.Factory(null);
        TrackSelector trackSelector =
                new DefaultTrackSelector(videoTrackSelectionFactory);

        player = ExoPlayerFactory.newSimpleInstance(context, trackSelector);
    }

    public SimpleExoPlayer getPlayer() {
        return this.player;
    }
}
