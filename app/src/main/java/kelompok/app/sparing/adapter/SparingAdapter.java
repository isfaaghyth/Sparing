package kelompok.app.sparing.adapter;

import android.widget.TextView;

import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.expand.ParentPosition;

import kelompok.app.sparing.R;
import kelompok.app.sparing.model.Sparing;

/**
 * Created by isfaaghyth on 12/28/17.
 * github: @isfaaghyth
 */

@Layout(R.layout.card_sparing_item)
public class SparingAdapter {

    @View(R.id.txt_team_name) private TextView txtTeamName;
    @View(R.id.txt_area) private TextView txtArea;

    @ParentPosition private int position;

    private Sparing sparing;

    public SparingAdapter setSparing(Sparing sparing) {
        this.sparing = sparing;
        return this;
    }

    @Resolve
    private void onResolved() {
        txtTeamName.setText(sparing.getTeam_a().getName() + " VS " + sparing.getTeam_b().getName());
        txtArea.setText(sparing.getArea().getName() + ", " + sparing.getArea().getAddress());
    }
}
