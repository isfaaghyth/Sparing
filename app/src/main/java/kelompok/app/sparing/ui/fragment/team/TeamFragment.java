package kelompok.app.sparing.ui.fragment.team;

import android.util.Log;

import com.mindorks.placeholderview.InfinitePlaceHolderView;

import java.util.ArrayList;

import butterknife.BindView;
import io.isfaaghyth.rak.Rak;
import kelompok.app.sparing.R;
import kelompok.app.sparing.adapter.TeamAdapter;
import kelompok.app.sparing.base.BaseFragment;
import kelompok.app.sparing.model.Teams;

/**
 * Created by Jack on 12/15/2017.
 */

public class TeamFragment extends BaseFragment<TeamPresenter> implements TeamView {

    @BindView(R.id.lst_team) InfinitePlaceHolderView lstTeam;

    @Override protected TeamPresenter initPresenter() {
        return new TeamPresenter(this);
    }

    @Override protected int setContentView() {
        return R.layout.fragment_friend;
    }

    @Override protected void onFragmentLoaded() {
        presenter.getTeams(String.valueOf(Rak.grab("id"))); //my own
    }

    @Override public void onTeamSuccess(ArrayList<Teams> team) {
        lstTeam.removeAllViews();
        int position = 0;
        for (Teams teams: team) {
            lstTeam.addView(new TeamAdapter(position).setTeam(teams));
            position++;
        }
    }

    @Override public void onError(String err) {

    }
}
