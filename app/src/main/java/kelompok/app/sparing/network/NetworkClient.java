package kelompok.app.sparing.network;

import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by isfaaghyth on 12/26/17.
 * github: @isfaaghyth
 */

public class NetworkClient {

    public static Retrofit client() {
        return new Retrofit.Builder()
                    .baseUrl("http://192.168.1.102:1337/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
    }

}
