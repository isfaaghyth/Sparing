package kelompok.app.sparing.ui.create_team;

import java.util.ArrayList;

import io.isfaaghyth.rak.Rak;
import kelompok.app.sparing.base.BasePresenter;
import kelompok.app.sparing.model.User;
import retrofit2.Response;
import rx.Subscriber;

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

    void createTeam(String teamName) {
        String myId = Rak.grab("id");
    }
}
