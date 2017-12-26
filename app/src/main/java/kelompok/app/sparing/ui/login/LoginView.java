package kelompok.app.sparing.ui.login;

import kelompok.app.sparing.model.Login;

/**
 * Created by isfaaghyth on 12/26/17.
 * github: @isfaaghyth
 */

public interface LoginView {
    void onSuccess(Login login);
    void onError(String err);
}
