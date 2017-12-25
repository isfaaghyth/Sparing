package kelompok.app.sparing.network;

/**
 * Created by isfaaghyth on 12/26/17.
 * github: @isfaaghyth
 */

public interface ResponseCallback<M> {
    void onSuccess(M res);
    void onError(String err);
}
