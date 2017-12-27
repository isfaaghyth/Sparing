package kelompok.app.sparing.ui.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;

import butterknife.OnClick;
import io.isfaaghyth.rak.Rak;
import kelompok.app.sparing.R;
import kelompok.app.sparing.base.BaseActivity;
import kelompok.app.sparing.model.Login;
import kelompok.app.sparing.model.User;
import kelompok.app.sparing.ui.main.MainActivity;
import kelompok.app.sparing.utils.StartActivities;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView {

    private static GoogleApiClient googleApiClient;
    private static final int RC_SIGNIN_CODE = 1;

    @Override protected LoginPresenter initPresenter() {
        return new LoginPresenter(this);
    }

    @Override protected int setContentView() {
        return R.layout.activity_login;
    }

    @Override protected void onActivityLoaded() {
        googleApiClient = presenter.initGoogleLogin();
        //cek jika sudah login, bypass login
        if (Rak.isExist("login")) {
            if (Rak.grab("login")) {
                StartActivities.start(this, MainActivity.class);
            }
        }
    }

    @OnClick(R.id.btn_login)
    public void onLoginClicked() {
        startActivityForResult(Auth.GoogleSignInApi.getSignInIntent(googleApiClient), RC_SIGNIN_CODE);
    }

    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGNIN_CODE) {
            GoogleSignInResult res = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (res.isSuccess()) presenter.googleLoginResult(res);
        }
    }

    @Override public void onSuccess(Login login) {
        Rak.entry("login", true);
        Rak.entry("id", login.getUser().getId());
        Rak.entry("name", login.getUser().getName());
        Rak.entry("email", login.getUser().getEmail());
        Rak.entry("token", login.getToken());
        Rak.entry("sportId", login.getUser().getSportId());
        StartActivities.start(this, MainActivity.class);
    }

    @Override public void onError(String err) {
        Toast(err);
    }

    @Override public AppCompatActivity getThis() {
        return this;
    }
}
