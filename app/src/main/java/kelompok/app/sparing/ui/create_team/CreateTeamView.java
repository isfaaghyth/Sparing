package kelompok.app.sparing.ui.create_team;

import kelompok.app.sparing.model.User;

/**
 * Created by isfaaghyth on 12/28/17.
 * github: @isfaaghyth
 */

interface CreateTeamView {
    void onFindSuccess(User usr);
    void onCompletedStoreMember();
    void onError(String err);
}
