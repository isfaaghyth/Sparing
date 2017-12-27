package kelompok.app.sparing.ui.fragment.team;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.mindorks.placeholderview.InfinitePlaceHolderView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import io.isfaaghyth.rak.Rak;
import kelompok.app.sparing.R;
import kelompok.app.sparing.adapter.TeamAdapter;
import kelompok.app.sparing.base.BaseFragment;
import kelompok.app.sparing.model.Teams;
import kelompok.app.sparing.ui.create_team.CreateTeamActivity;

/**
 * Created by Jack on 12/15/2017.
 */

public class TeamFragment extends BaseFragment<TeamPresenter> implements TeamView {

    @BindView(R.id.lst_team) InfinitePlaceHolderView lstTeam;

    @Override protected TeamPresenter initPresenter() {
        return new TeamPresenter(this);
    }

    @Override protected int setContentView() {
        return R.layout.fragment_team;
    }

    @Override protected void onFragmentLoaded() {
        presenter.getTeams(String.valueOf(Rak.grab("id"))); //my own
    }

    @OnClick(R.id.btn_new_team)
    public void onNewTeamClicked() {
        startActivity(new Intent(getContext(), CreateTeamActivity.class));
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
