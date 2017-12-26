package kelompok.app.sparing.network;

import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by isfaaghyth on 12/26/17.
 * github: @isfaaghyth
 */

public class NetworkClient {

    private static final String BASE_URL = "http://192.168.1.102:1337/";

    public static Retrofit client() {
        return new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
    }

}
