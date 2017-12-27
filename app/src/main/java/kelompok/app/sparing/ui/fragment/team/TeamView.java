package kelompok.app.sparing.ui.fragment.team;

import java.util.ArrayList;

import kelompok.app.sparing.model.Teams;

/**
 * Created by isfaaghyth on 12/26/17.
 * github: @isfaaghyth
 */

interface TeamView {
    void onTeamSuccess(ArrayList<Teams> team);
    void onError(String err);
}
