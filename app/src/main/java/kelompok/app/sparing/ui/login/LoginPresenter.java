package kelompok.app.sparing.ui.login;

import kelompok.app.sparing.base.BasePresenter;
import kelompok.app.sparing.model.Login;
import retrofit2.Response;
import rx.Subscriber;

/**
 * Created by isfaaghyth on 12/26/17.
 * github: @isfaaghyth
 */

class LoginPresenter extends BasePresenter<LoginView> {

    LoginPresenter(LoginView v) {
        super.attachView(v);
    }

    /**
     * onRegister
     * @param args{name,email,password,phoneNumber,firebaseToken}
     */
    void onRegister(String... args) {
        onSubscribe(service.register(args[0], args[1], args[2], args[3], args[4]), new Subscriber<Response<Login>>() {
            @Override public void onCompleted() {}
            @Override public void onError(Throwable e) {
                view.onError(e.getMessage());
            }
            @Override public void onNext(Response<Login> res) {
                if (res.isSuccessful()) {
                    view.onSuccess(res.body());
                }
            }
        });
    }

}
