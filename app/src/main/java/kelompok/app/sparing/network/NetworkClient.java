package kelompok.app.sparing.network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by isfaaghyth on 12/26/17.
 * github: @isfaaghyth
 */

public class NetworkClient {

    private static final String BASE_URL = "http://192.168.1.100:1337/";

    public static Retrofit client() {
        return new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
    }

}
