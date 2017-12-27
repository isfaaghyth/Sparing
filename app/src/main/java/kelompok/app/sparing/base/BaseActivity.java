package kelompok.app.sparing.base;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import kelompok.app.sparing.R;
import kelompok.app.sparing.utils.ProgressLoader;
import rx.Subscription;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by isfaaghyth on 12/8/17.
 * github: @isfaaghyth
 */

abstract public class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    @BindView(R.id.toolbar) @Nullable Toolbar toolbar;
    @BindView(R.id.txt_title_toolbar) @Nullable TextView txtTitleBar;

    protected P presenter;
    protected abstract P initPresenter();
    protected abstract @LayoutRes int setContentView();
    protected abstract void onActivityLoaded();

    protected Subscription subscriber; //backup

    protected ProgressLoader loader;

    @Override public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding(setContentView());
    }

    protected void binding(int layout) {
        setContentView(layout);
        ButterKnife.bind(this);
        presenter = initPresenter();
        setSupportActionBar(toolbar);
        loader = new ProgressLoader(this);
        onActivityLoaded();
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setTitleBar(@Nullable String txtTitleBar) {
        this.txtTitleBar.setText(txtTitleBar);
    }

    protected void showBackButton(boolean isShow) {
        getSupportActionBar().setDisplayShowHomeEnabled(isShow);
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
        if (subscriber != null) {
            if (!subscriber.isUnsubscribed()) {
                subscriber.unsubscribe();
            }
        }
    }

}