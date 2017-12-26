package kelompok.app.sparing.ui.login;

import kelompok.app.sparing.R;
import kelompok.app.sparing.base.BaseActivity;
import kelompok.app.sparing.model.Login;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView {

    @Override protected LoginPresenter initPresenter() {
        return new LoginPresenter(this);
    }

    @Override protected int setContentView() {
        return R.layout.activity_login;
    }

    @Override protected void onActivityLoaded() {

    }

    @Override public void onSuccess(Login login) {

    }

    @Override public void onError(String err) {

    }
}
