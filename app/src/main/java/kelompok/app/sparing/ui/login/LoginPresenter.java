package kelompok.app.sparing.ui.login;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;

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
//        String avatar = (result.getSignInAccount().getPhotoUrl().toString() != null) ?
//                        result.getSignInAccount().getPhotoUrl().toString() :
//                        "holder.png";
        String email = result.getSignInAccount().getEmail();
        String pass = email.split("@")[0];
        onRegister(fullName, email, pass, "", "firebaseToken");
    }

    /**
     * onRegister
     * @param args{name,email,password,avatar,firebaseToken}
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
