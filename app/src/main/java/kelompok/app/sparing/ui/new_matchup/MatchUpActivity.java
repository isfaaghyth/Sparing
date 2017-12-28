package kelompok.app.sparing.ui.new_matchup;

import kelompok.app.sparing.R;
import kelompok.app.sparing.base.BaseActivity;

/**
 * Created by isfaaghyth on 12/28/17.
 * github: @isfaaghyth
 */

public class MatchUpActivity extends BaseActivity<MatchUpPresenter> implements MatchUpView {

    @Override protected MatchUpPresenter initPresenter() {
        return new MatchUpPresenter(this);
    }

    @Override protected int setContentView() {
        return R.layout.activity_match_up;
    }

    @Override protected void onActivityLoaded() {
        setTitleBar("Create a new Match Up");
        showBackButton(true);
    }

}
