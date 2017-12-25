package kelompok.app.sparing.network;

import kelompok.app.sparing.model.Login;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by isfaaghyth on 12/26/17.
 * github: @isfaaghyth
 */

public interface Routes {

    @FormUrlEncoded @POST("users")
    Call<Response<Login>> register(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("phone_number") String phoneNumber,
            @Field("firebase_token") String firebaseToken
    );

    @FormUrlEncoded @POST("users/login")
    Call<Response<Login>> login(
            @Field("email") String email,
            @Field("password") String password
    );

}
