package kelompok.app.sparing.ui.create_team;

import android.util.Log;

import java.util.ArrayList;

import io.isfaaghyth.rak.Rak;
import kelompok.app.sparing.base.BasePresenter;
import kelompok.app.sparing.model.Team;
import kelompok.app.sparing.model.TeamMember;
import kelompok.app.sparing.model.User;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Created by isfaaghyth on 12/28/17.
 * github: @isfaaghyth
 */

public class CreateTeamPresenter extends BasePresenter<CreateTeamView> {

    public CreateTeamPresenter(CreateTeamView view) {
        super.attachView(view);
    }

    boolean isMemberExist(User usr, ArrayList<User> members) {
        if (members.size() == 0) return false;
        for (int i=0; i<members.size(); i++) {
            if (members.get(i).getId() == usr.getId()) {
                return true;
            }
        }
        return false;
    }

    void findUserBySportId(String sportId) {
        onSubscribe(service.findUserBySportId(sportId), new Subscriber<Response<ArrayList<User>>>() {
            @Override public void onCompleted() {}
            @Override public void onError(Throwable e) {
                view.onError(e.getMessage());
            }
            @Override public void onNext(Response<ArrayList<User>> res) {
                if (res.code() == 200) {
                    if (res.body().size() > 0) {
                        view.onFindSuccess(res.body().get(0));
                    } else {
                        view.onFindSuccess(null);
                    }
                }
            }
        });
    }

    void createTeam(String teamName, final ArrayList<User> members) {
        String myId = String.valueOf(Rak.grab("id"));
        String status = "active";
        String isPlay = "false";
        onSubscribe(service.createTeam(teamName, myId, status, isPlay), new Subscriber<Response<Team>>() {
            String teamId;
            @Override public void onCompleted() {
                storeTeamMember(teamId, members);
            }
            @Override public void onError(Throwable e) {
                view.onError(e.getMessage());
            }
            @Override public void onNext(Response<Team> res) {
                if (res.isSuccessful()) {
                    teamId = String.valueOf(res.body().getId());
                }
            }
        });
    }

    private void storeTeamMember(final String teamId, ArrayList<User> members) {
        onSubscribe(Observable.from(members)
                .flatMap(new Func1<User, Observable<Response<TeamMember>>>() {
                    @Override public Observable<Response<TeamMember>> call(User user) {
                        return service.storeMember(teamId, String.valueOf(user.getId()));
                    }
                }), new Subscriber<Response<TeamMember>>() {
            @Override public void onCompleted() {
                view.onCompletedStoreMember();
            }

            @Override public void onError(Throwable e) {
                view.onError(e.getMessage());
            }
            @Override public void onNext(Response<TeamMember> res) {}
        });
    }
}
