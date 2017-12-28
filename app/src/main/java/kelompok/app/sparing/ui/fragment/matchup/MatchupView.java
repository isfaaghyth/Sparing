package kelompok.app.sparing.ui.fragment.matchup;

import java.util.ArrayList;

import kelompok.app.sparing.model.Sparing;

/**
 * Created by isfaaghyth on 12/28/17.
 * github: @isfaaghyth
 */

public interface MatchupView {
    void onGetMatchupSuccess(ArrayList<Sparing> res);
    void onError(String err);
}
