package kelompok.app.sparing.ui.fragment.matchup;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kelompok.app.sparing.R;
import kelompok.app.sparing.base.BaseFragment;

/**
 * Created by Jack on 12/15/2017.
 */

public class MatchupFragment extends BaseFragment<MatchupPresenter> implements MatchupView {

    @Override protected MatchupPresenter initPresenter() {
        return new MatchupPresenter(this);
    }

    @Override protected int setContentView() {
        return R.layout.fragment_match_up;
    }

    @Override protected void onFragmentLoaded() {

    }

}
