package kelompok.app.sparing.adapter;

import android.widget.TextView;

import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.expand.ParentPosition;

import kelompok.app.sparing.R;
import kelompok.app.sparing.model.Teams;

/**
 * Created by isfaaghyth on 12/28/17.
 * github: @isfaaghyth
 */

@Layout(R.layout.card_team_item)
public class TeamAdapter {

    @View(R.id.txt_team_name) private TextView txtTeamName;
    @View(R.id.txt_status) private TextView txtStatus;

    @ParentPosition
    private int position;

    private Teams team;

    public TeamAdapter(int position) {
        this.position = position;
    }

    public TeamAdapter setTeam(Teams team) {
        this.team = team;
        return this;
    }

    @Resolve
    private void onResolved() {
        txtTeamName.setText(team.getName());
        txtStatus.setText(team.getStatus());
    }
}
