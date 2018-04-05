package baking_app.sbrzezinski.com.bakingapp.live_data;

import android.arch.lifecycle.MutableLiveData;

/**
 * Created by Stanislaw Brzezinski  on 05/04/2018 17:10.
 */

public class ExoPlayerCurrentPositionLiveData extends MutableLiveData<Long> {
    public ExoPlayerCurrentPositionLiveData() {
        setValue(0L);
    }
}
