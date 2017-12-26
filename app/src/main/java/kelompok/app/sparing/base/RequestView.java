package kelompok.app.sparing.base;

/**
 * Created by isfaaghyth on 12/26/17.
 * github: @isfaaghyth
 */

public interface RequestView<M> {
    void onSuccess(M res);
    void onError(String err);
}
