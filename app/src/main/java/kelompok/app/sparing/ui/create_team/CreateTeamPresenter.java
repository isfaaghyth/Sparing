package kelompok.app.sparing.ui.create_team;

import java.util.ArrayList;

import io.isfaaghyth.rak.Rak;
import kelompok.app.sparing.base.BasePresenter;
import kelompok.app.sparing.model.Team;
import kelompok.app.sparing.model.TeamMember;
import kelompok.app.sparing.model.User;
import retrofit2.Response;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by isfaaghyth on 12/28/17.
 * github: @isfaaghyth
 */

public class CreateTeamPresenter extends BasePresenter<CreateTeamView> {

    public CreateTeamPresenter(CreateTeamView view) {
        super.attachView(view);
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
        onSubscribe(service.createTeam(teamName, myId, status), new Subscriber<Response<Team>>() {
            @Override public void onCompleted() {}
            @Override public void onError(Throwable e) {
                view.onError(e.getMessage());
            }
            @Override public void onNext(Response<Team> res) {
                if (res.code() == 200) {
                    storeTeamMember(res.body().getId(), members);
                }
            }
        });
    }

    private void storeTeamMember(final int teamId, ArrayList<User> members) {
        Observable.from(members)
                .flatMap(new Func1<User, Observable<Response<TeamMember>>>() {
                    @Override public Observable<Response<TeamMember>> call(User user) {
                        return service.storeMember(
                                String.valueOf(teamId),
                                String.valueOf(user.getId())
                        );
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<TeamMember>>() {
                    @Override public void onCompleted() {
                        view.onCompletedStoreMember();
                    }

                    @Override public void onError(Throwable e) {
                        view.onError(e.getMessage());
                    }

                    @Override public void onNext(Response<TeamMember> teamMember) {
                        view.onCreateTeamSuccess();
                    }
                });
    }
}
