package kelompok.app.sparing.ui.main;

import kelompok.app.sparing.R;
import kelompok.app.sparing.adapter.ViewPagerAdapter;
import kelompok.app.sparing.base.BasePresenter;
import kelompok.app.sparing.ui.fragment.friend.FriendFragment;
import kelompok.app.sparing.utils.CustomViewPager;

/**
 * Created by isfaaghyth on 12/26/17.
 * github: @isfaaghyth
 */

class MainPresenter extends BasePresenter<MainView> {

    MainPresenter(MainView v) {
        super.attachView(v);
    }

    void setupViewPager(CustomViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(view.getFragment(), true);
        adapter.addFragment(new FriendFragment(), "Friends");
        adapter.addFragment(new FriendFragment(), "Friends");
        adapter.addFragment(new FriendFragment(), "Friends");
        adapter.addFragment(new FriendFragment(), "Friends");
        viewPager.setAdapter(adapter);
    }

    void bottomChanged(CustomViewPager viewPagerMain, int tabId) {
        int tabIds[] = {R.id.tab_matchup, R.id.tab_spectate, R.id.tab_friend, R.id.tab_profile};
        for (int i=0; i < tabIds.length; i++) {
            if (tabId == tabIds[i]) {
                viewPagerMain.setCurrentItem(i, true);
                break;
            }
        }
    }
}
