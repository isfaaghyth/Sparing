package kelompok.app.sparing.ui.create_team;

import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.Button;
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
import kelompok.app.sparing.service.NotifEvent;
import kelompok.app.sparing.utils.StartActivities;
import rx.functions.Action1;

/**
 * Created by isfaaghyth on 12/28/17.
 * github: @isfaaghyth
 */

public class CreateTeamActivity extends BaseActivity<CreateTeamPresenter> implements CreateTeamView {

    @BindView(R.id.lst_team_member) InfinitePlaceHolderView lstTeamMember;
    @BindView(R.id.edt_search_member) EditText edtSearchMember;
    @BindView(R.id.layout_member) LinearLayout layoutMember;
    @BindView(R.id.btn_create_team) Button btnCreateTeam;
    @BindView(R.id.layout_team) LinearLayout layoutTeam;
    @BindView(R.id.edt_team_name) EditText edtTeamName;
    @BindView(R.id.txt_warning) TextView txtWarning;
    @BindView(R.id.btn_next) Button btnNext;

    private ArrayList<User> members = new ArrayList<>();

    @Override protected CreateTeamPresenter initPresenter() {
        return new CreateTeamPresenter(this);
    }

    @Override protected int setContentView() {
        return R.layout.activity_create_team;
    }

    @Override protected void onActivityLoaded() {
        setTitleBar("Create Team");
        showBackButton(true);
        lstTeamMember.setLayoutManager(new GridLayoutManager(this, 4));
    }

    @OnClick(R.id.btn_create_team)
    public void onCreateTeamClicked() {
        String teamName = edtTeamName.getText().toString().trim();
        presenter.createTeam(teamName, members);
        loader.show();
    }

    @OnClick(R.id.btn_next)
    public void onNextClicked() {
        if (members.size() == 0) {
            Toast("At least there are one member with you");
        } else {
            createTeam();
        }
    }

    @OnClick(R.id.btn_find_member)
    public void findFriendClicked() {
        txtWarning.setVisibility(View.GONE); //if exist
        String sportId = edtSearchMember.getText().toString().trim();
        presenter.findUserBySportId(sportId);
    }

    void createTeam() {
        btnCreateTeam.setVisibility(View.VISIBLE);
        layoutTeam.setVisibility(View.VISIBLE);
        layoutMember.setVisibility(View.GONE);
        btnNext.setVisibility(View.GONE);
    }

    void memberList() {
        int position = 0;
        lstTeamMember.removeAllViews();
        for (User usr: members) {
            lstTeamMember.addView(new MemberAdapter(position).setContext(this).setUser(usr));
            position++;
        }
    }

    @Override public void onFindSuccess(User usr) {
        if (usr == null) {
            txtWarning.setVisibility(View.VISIBLE);
            txtWarning.setText(R.string.str_not_found);
        } else {
            if (!presenter.isMemberExist(usr, members)) {
                members.add(usr);
                memberList();
            }
        }
    }

    @Override public void onCompletedStoreMember() {
        loader.hide();
        Toast("alhamdulillah, udah jadi.");
        NotifEvent.getInstance().post(true);
        onBackPressed();
        finish();
    }

    @Override public void onError(String err) {
        loader.hide();
        Toast(err);
    }
}
