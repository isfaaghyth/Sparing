package kelompok.app.sparing.ui.main;

import android.support.v4.app.FragmentManager;

import kelompok.app.sparing.utils.CustomViewPager;

/**
 * Created by isfaaghyth on 12/26/17.
 * github: @isfaaghyth
 */

interface MainView {
    FragmentManager getFragment();
    void setTitleFragmentBar(String text);
}
