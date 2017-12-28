package kelompok.app.sparing.ui.fragment.matchup;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mindorks.placeholderview.InfinitePlaceHolderView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import kelompok.app.sparing.R;
import kelompok.app.sparing.adapter.SparingAdapter;
import kelompok.app.sparing.base.BaseFragment;
import kelompok.app.sparing.model.Sparing;
import kelompok.app.sparing.ui.create_team.CreateTeamActivity;
import kelompok.app.sparing.ui.new_matchup.MatchUpActivity;

/**
 * Created by Jack on 12/15/2017.
 */

public class MatchupFragment extends BaseFragment<MatchupPresenter> implements MatchupView {

    @BindView(R.id.lst_match_up) InfinitePlaceHolderView lstMatchUp;

    @Override protected MatchupPresenter initPresenter() {
        return new MatchupPresenter(this);
    }

    @Override protected int setContentView() {
        return R.layout.fragment_match_up;
    }

    @Override protected void onFragmentLoaded() {
        presenter.getMatchUp();
    }

    @OnClick(R.id.btn_new_matchup)
    public void onNewMatchupClicked() {
        startActivity(new Intent(getContext(), MatchUpActivity.class));
    }

    @Override public void onGetMatchupSuccess(ArrayList<Sparing> res) {
        lstMatchUp.removeAllViews();
        for (Sparing sparing: res) {
            lstMatchUp.addView(new SparingAdapter().setSparing(sparing));
        }
    }

    @Override public void onError(String err) {

    }
}
