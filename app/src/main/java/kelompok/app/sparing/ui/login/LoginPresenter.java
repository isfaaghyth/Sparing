package kelompok.app.sparing.ui.login;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;

import io.isfaaghyth.rak.Rak;
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

    GoogleApiClient initGoogleLogin() {
        GoogleSignInOptions gso = new GoogleSignInOptions
                .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        return new GoogleApiClient.Builder(view.getThis())
                .enableAutoManage(view.getThis(), null)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
    }

    void googleLoginResult(GoogleSignInResult result) {
        String fullName = result.getSignInAccount().getDisplayName();
        String avatar = (result.getSignInAccount().getPhotoUrl() != null) ?
                        result.getSignInAccount().getPhotoUrl().toString() :
                        "holder.png";
        String email = result.getSignInAccount().getEmail();
        String username = email.split("@")[0];
        String pass = email.split("@")[0];
        String firebaseToken = Rak.grab("firebase_token");
        onRegister(fullName, email, pass, avatar, username, firebaseToken);
    }

    /**
     * onRegister
     * Pake varargs biar dynamic params
     * @param args{name,email,password,avatar,sportId, firebaseToken}
     */
    void onRegister(final String... args) {
        onSubscribe(service.register(args[0], args[1], args[2], args[3], args[4], args[5]), new Subscriber<Response<Login>>() {
            @Override public void onCompleted() {}
            @Override public void onError(Throwable e) {
                view.onError(e.getMessage());
            }
            @Override public void onNext(Response<Login> res) {
                if (res.code() == 200) { //jika masih belum ke register
                    view.onSuccess(res.body());
                } else if (res.code() == 400) { //jika sudah register, sung login
                    onLogin(args[1], args[2]);
                }
            }
        });
    }

    /**
     * Login, yoi!
     * @param email
     * @param password
     */
    void onLogin(String email, String password) {
        onSubscribe(service.login(email, password), new Subscriber<Response<Login>>() {
            @Override public void onCompleted() {}
            @Override public void onError(Throwable e) {
                view.onError(e.getMessage());
            }
            @Override public void onNext(Response<Login> res) {
                view.onSuccess(res.body());
            }
        });
    }

}
