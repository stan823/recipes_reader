package baking_app.sbrzezinski.com.bakingapp.retrofit;

import android.support.annotation.NonNull;

import baking_app.sbrzezinski.com.bakingapp.commmon_interfaces.ErrorCallback;
import baking_app.sbrzezinski.com.bakingapp.commmon_interfaces.SuccessCallback;
import baking_app.sbrzezinski.com.bakingapp.models.Recipe;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Stanislaw Brzezinski  on 22/03/2018 12:08.
 */

public class RetrofitCallback<T> implements Callback<T> {
    @NonNull private SuccessCallback<T> successCallback;
    @NonNull private ErrorCallback errorCallback;

    public RetrofitCallback(@NonNull SuccessCallback<T> successCallback, @NonNull ErrorCallback errorCallback) {
        this.successCallback = successCallback;
        this.errorCallback = errorCallback;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        successCallback.onSuccess(response.body());
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        errorCallback.onError();
    }
}
