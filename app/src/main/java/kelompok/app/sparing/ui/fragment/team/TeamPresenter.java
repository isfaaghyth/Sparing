package kelompok.app.sparing.ui.fragment.team;

import android.util.Log;

import java.util.ArrayList;

import kelompok.app.sparing.base.BasePresenter;
import kelompok.app.sparing.model.Teams;
import retrofit2.Response;
import rx.Subscriber;

/**
 * Created by isfaaghyth on 12/26/17.
 * github: @isfaaghyth
 */

class TeamPresenter extends BasePresenter<TeamView> {

    TeamPresenter(TeamView v) {
        super.attachView(v);
    }

    void getTeams(String ownerId) {
        onSubscribe(service.getTeamByOwner(ownerId), new Subscriber<Response<ArrayList<Teams>>>() {
            @Override public void onCompleted() {}
            @Override public void onError(Throwable e) {
                view.onError(e.getMessage());
            }
            @Override public void onNext(Response<ArrayList<Teams>> res) {
                if (res.code() == 200) {
                    view.onTeamSuccess(res.body());
                }
            }
        });
    }

}
