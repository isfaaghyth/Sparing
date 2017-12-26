package kelompok.app.sparing.base;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by isfaaghyth on 12/8/17.
 * github: @isfaaghyth
 */

abstract public class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    protected P presenter;
    protected abstract P initPresenter();
    protected abstract void onActivityLoaded();
    protected abstract @LayoutRes int setContentView();

    @Override public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding(setContentView());
    }

    protected void binding(int layout) {
        setContentView(layout);
        ButterKnife.bind(this);
        presenter = initPresenter();
        onActivityLoaded();
    }

    protected void Toast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.dettachView();
        }
    }
}