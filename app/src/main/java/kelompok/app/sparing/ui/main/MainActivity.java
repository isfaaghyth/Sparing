package kelompok.app.sparing.ui.main;

import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuItem;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import butterknife.BindView;
import kelompok.app.sparing.R;
import kelompok.app.sparing.base.BaseActivity;
import kelompok.app.sparing.utils.CustomViewPager;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView {

    @BindView(R.id.viewpager_main) CustomViewPager viewPagerMain;
    @BindView(R.id.bottombar_main) BottomBar bottomBarMain;

    @Override protected MainPresenter initPresenter() {
        return new MainPresenter(this);
    }

    @Override protected int setContentView() {
        return R.layout.activity_main;
    }

    @Override protected void onActivityLoaded() {
        presenter.setupViewPager(viewPagerMain);
        viewPagerMain.setPagingEnabled(false);
        bottomBarMain.setOnTabSelectListener(new OnTabSelectListener() {
            @Override public void onTabSelected(@IdRes int tabId) {
                presenter.bottomChanged(viewPagerMain, tabId);
            }
        });
    }

    @Override public FragmentManager getFragment() {
        return getSupportFragmentManager();
    }

    @Override public void setTitleFragmentBar(String text) {
        setTitleBar(text);
    }
}
