package kelompok.app.sparing.ui.create_team;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mindorks.placeholderview.InfinitePlaceHolderView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import kelompok.app.sparing.R;
import kelompok.app.sparing.adapter.MemberAdapter;
import kelompok.app.sparing.base.BaseActivity;
import kelompok.app.sparing.model.Team;
import kelompok.app.sparing.model.User;

/**
 * Created by isfaaghyth on 12/28/17.
 * github: @isfaaghyth
 */

public class CreateTeamActivity extends BaseActivity<CreateTeamPresenter> implements CreateTeamView {

    @BindView(R.id.lst_team_member) InfinitePlaceHolderView lstTeamMember;
    @BindView(R.id.edt_search_member) EditText edtSearchMember;
    @BindView(R.id.layout_member) LinearLayout layoutMember;
    @BindView(R.id.layout_team) LinearLayout layoutTeam;
    @BindView(R.id.edt_team_name) EditText edtTeamName;
    @BindView(R.id.txt_warning) TextView txtWarning;

    ArrayList<User> members = new ArrayList<>();

    @Override protected CreateTeamPresenter initPresenter() {
        return new CreateTeamPresenter(this);
    }

    @Override protected int setContentView() {
        return R.layout.activity_create_team;
    }

    @Override protected void onActivityLoaded() {
        setTitleBar("Create Team");
        showBackButton(true);
    }

    @OnClick(R.id.btn_create_team)
    public void onCreateTeamClicked() {

    }

    @OnClick(R.id.btn_next)
    public void onNextClicked() {

    }

    @OnClick(R.id.btn_find_member)
    public void findFriendClicked() {
        String sportId = edtSearchMember.getText().toString().trim();
        presenter.findUserBySportId(sportId);
    }

    void createTeam() {

    }

    void memberList() {
        int position = 0;
        lstTeamMember.removeAllViews();
        for (User usr: members) {
            lstTeamMember.addView(
                    new MemberAdapter(position)
                        .setContext(this)
                        .setUser(usr)
            );
            position++;
        }
    }

    @Override public void onFindSuccess(User usr) {
        if (usr == null) {
            txtWarning.setVisibility(View.VISIBLE);
            txtWarning.setText(R.string.str_not_found);
        } else {
            members.add(usr);
            memberList();
        }
    }

    @Override public void onCreateTeamSuccess(Team team) {

    }

    @Override public void onCompletedStoreMember() {

    }

    @Override public void onError(String err) {

    }
}
