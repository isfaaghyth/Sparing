package kelompok.app.sparing.ui.fragment.matchup;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.OnClick;
import kelompok.app.sparing.R;
import kelompok.app.sparing.base.BaseFragment;
import kelompok.app.sparing.ui.create_team.CreateTeamActivity;

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

    @OnClick(R.id.btn_create_team)
    public void onCreateTeamClicked() {
        startActivity(new Intent(getContext(), CreateTeamActivity.class));
    }

}
