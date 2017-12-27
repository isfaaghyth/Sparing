package kelompok.app.sparing.ui.login;

import android.support.v7.app.AppCompatActivity;

import kelompok.app.sparing.base.RequestView;
import kelompok.app.sparing.model.Login;

/**
 * Created by isfaaghyth on 12/26/17.
 * github: @isfaaghyth
 */

interface LoginView extends RequestView<Login> {
    AppCompatActivity getThis();
}
