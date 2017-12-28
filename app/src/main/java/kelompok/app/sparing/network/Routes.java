package kelompok.app.sparing.network;

import java.util.ArrayList;

import kelompok.app.sparing.model.Login;
import kelompok.app.sparing.model.Sparing;
import kelompok.app.sparing.model.Team;
import kelompok.app.sparing.model.TeamMember;
import kelompok.app.sparing.model.Teams;
import kelompok.app.sparing.model.User;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by isfaaghyth on 12/26/17.
 * github: @isfaaghyth
 */

public interface Routes {

    @FormUrlEncoded @POST("users")
    Observable<Response<Login>> register(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("avatar") String avatar,
            @Field("sportId") String sportId,
            @Field("firebase_token") String firebaseToken
    );

    @FormUrlEncoded @POST("users/login")
    Observable<Response<Login>> login(
            @Field("email") String email,
            @Field("password") String password
    );

    @FormUrlEncoded @POST("team")
    Observable<Response<Team>> createTeam(
            @Field("name") String teamName,
            @Field("owner") String ownerUserId,
            @Field("status") String status,
            @Field("isPlay") String isPlay
    );

    @FormUrlEncoded @POST("teammember")
    Observable<Response<TeamMember>> storeMember(
            @Field("team") String team,
            @Field("member") String userId
    );

    /**
     * find user by sportId
     * @param sportId
     * @return
     */
    @GET("users")
    Observable<Response<ArrayList<User>>> findUserBySportId(
            @Query("sportId") String sportId
    );

    /**
     * Get team by ownerId
     * @param ownerId
     * @return
     */
    @GET("team")
    Observable<Response<ArrayList<Teams>>> getTeamByOwner(
            @Query("owner") String ownerId
    );

    @GET("team")
    Observable<Response<ArrayList<Teams>>> getTeam();

    @GET("sparing")
    Observable<Response<ArrayList<Sparing>>> getSparingByStatus(
            @Query("status") String status
    );
}
