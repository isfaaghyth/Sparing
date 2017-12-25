package kelompok.app.sparing.ui.login;

import android.os.Bundle;
import android.util.Log;

import kelompok.app.sparing.R;
import kelompok.app.sparing.base.BaseActivity;
import kelompok.app.sparing.base.BaseRequest;
import kelompok.app.sparing.model.Login;
import kelompok.app.sparing.network.ResponseCallback;
import retrofit2.Response;

public class LoginActivity extends BaseActivity {

    private BaseRequest<Response<Login>> login;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(R.layout.activity_login);
        login = new BaseRequest<>();

        requestRegister();
    }

    private void requestRegister() {
        login.request(BaseRequest.with().route().register("name", "email", "pass", "123", "123"),
                new ResponseCallback<Response<Login>>() {
            @Override public void onSuccess(Response<Login> res) {
                Log.d("TAG", res.body().getUser().getEmail());
            }

            @Override public void onError(String err) {

            }
        });
    }
}
