package kelompok.app.sparing.ui.main;

import kelompok.app.sparing.R;
import kelompok.app.sparing.adapter.ViewPagerAdapter;
import kelompok.app.sparing.base.BasePresenter;
import kelompok.app.sparing.ui.fragment.team.TeamFragment;
import kelompok.app.sparing.ui.fragment.matchup.MatchupFragment;
import kelompok.app.sparing.ui.fragment.profile.ProfileFragment;
import kelompok.app.sparing.ui.fragment.spectate.SpectateFragment;
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
        adapter.addFragment(new MatchupFragment(), "Matchup");
        adapter.addFragment(new SpectateFragment(), "Spectate");
        adapter.addFragment(new TeamFragment(), "Team");
        adapter.addFragment(new ProfileFragment(), "Profile");
        viewPager.setAdapter(adapter);
    }

    void bottomChanged(CustomViewPager viewPagerMain, int tabId) {
        String title[] = {"Match Up", "Spectate", "My Team", "Profile"};
        int tabIds[] = {R.id.tab_matchup, R.id.tab_spectate, R.id.tab_team, R.id.tab_profile};
        for (int i=0; i < tabIds.length; i++) {
            if (tabId == tabIds[i]) {
                view.setTitleFragmentBar(title[i]);
                viewPagerMain.setCurrentItem(i, true);
                break;
            }
        }
    }
}
