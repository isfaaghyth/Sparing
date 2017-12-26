package kelompok.app.sparing.ui.main;

import kelompok.app.sparing.R;
import kelompok.app.sparing.base.BaseActivity;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView {

    @Override protected MainPresenter initPresenter() {
        return new MainPresenter(this);
    }

    @Override protected int setContentView() {
        return R.layout.activity_main;
    }

    @Override protected void onActivityLoaded() {

    }

}
