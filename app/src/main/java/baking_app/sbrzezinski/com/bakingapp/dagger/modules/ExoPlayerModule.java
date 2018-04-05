package baking_app.sbrzezinski.com.bakingapp.dagger.modules;

import android.content.Context;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.SimpleExoPlayer;

import javax.inject.Singleton;

import baking_app.sbrzezinski.com.bakingapp.exoplayer.ExoPlayerProvider;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Stanislaw Brzezinski  on 05/04/2018 14:48.
 */
@Module
public class ExoPlayerModule {
    @Provides
    @Singleton
    SimpleExoPlayer provideExoPlayer(Context context){
        return new ExoPlayerProvider(context).getPlayer();
    }
}
