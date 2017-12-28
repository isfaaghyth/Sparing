package kelompok.app.sparing.ui.fragment.matchup;

import java.util.ArrayList;

import kelompok.app.sparing.base.BasePresenter;
import kelompok.app.sparing.model.Sparing;
import retrofit2.Response;
import rx.Subscriber;

/**
 * Created by isfaaghyth on 12/28/17.
 * github: @isfaaghyth
 */

public class MatchupPresenter extends BasePresenter<MatchupView> {

    MatchupPresenter(MatchupView v) {
        super.attachView(v);
    }

    void getMatchUp() {
        onSubscribe(service.getSparingByStatus("play"), new Subscriber<Response<ArrayList<Sparing>>>() {
            @Override public void onCompleted() {}
            @Override public void onError(Throwable e) {
                view.onError(e.getMessage());
            }
            @Override public void onNext(Response<ArrayList<Sparing>> res) {
                if (res.code() == 200) {
                    view.onGetMatchupSuccess(res.body());
                }
            }
        });
    }
}
