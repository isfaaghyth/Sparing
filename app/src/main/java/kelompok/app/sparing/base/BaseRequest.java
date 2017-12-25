package kelompok.app.sparing.base;

import android.support.annotation.NonNull;
import android.util.Log;

import kelompok.app.sparing.network.NetworkClient;
import kelompok.app.sparing.network.ResponseCallback;
import kelompok.app.sparing.network.Routes;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by isfaaghyth on 12/26/17.
 * github: @isfaaghyth
 */

public class BaseRequest<M> {

    private Routes route;

    public static BaseRequest with() {
        return new BaseRequest();
    }

    public Routes route() {
        route = NetworkClient.client().create(Routes.class);
        return route;
    }

    public void request(Call<M> r, final ResponseCallback<M> callback) {
        r.enqueue(new Callback<M>() {
            @Override public void onResponse(@NonNull Call<M> call, @NonNull Response<M> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                    Log.d("TAG", "onSuccess()");
                }
            }

            @Override public void onFailure(@NonNull Call<M> call, @NonNull Throwable t) {
                Log.d("TAG", "onFailure() " + t.getMessage());
                callback.onError(t.getMessage());
            }
        });
    }

}
