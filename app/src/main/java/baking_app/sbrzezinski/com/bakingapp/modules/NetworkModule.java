package baking_app.sbrzezinski.com.bakingapp.modules;

import com.google.gson.Gson;

import javax.inject.Singleton;

import baking_app.sbrzezinski.com.bakingapp.retrofit.RetrofitService;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Stanislaw Brzezinski  on 22/03/2018 11:37.
 */
@Module
public class NetworkModule {
    private String baseUrlPagth;

    public NetworkModule(String baseUrlPagth) {
        this.baseUrlPagth = baseUrlPagth;
    }

    @Singleton
    @Provides
    public Gson provideGson(){
        return new Gson();
    }

    @Singleton
    @Provides
    public Retrofit provideRetrofit(Gson gson){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(baseUrlPagth)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit;
    }

    @Singleton
    @Provides
    public RetrofitService provideRetrofitService(Retrofit retrofit){
        return retrofit.create(RetrofitService.class);
    }
}
