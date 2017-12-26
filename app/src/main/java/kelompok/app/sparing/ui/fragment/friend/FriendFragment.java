package kelompok.app.sparing.ui.fragment.friend;

import kelompok.app.sparing.R;
import kelompok.app.sparing.base.BaseFragment;

/**
 * Created by Jack on 12/15/2017.
 */

public class FriendFragment extends BaseFragment<FriendPresenter> implements FriendView {

    @Override protected FriendPresenter initPresenter() {
        return new FriendPresenter(this);
    }

    @Override protected int setContentView() {
        return R.layout.fragment_friend;
    }

    @Override protected void onFragmentLoaded() {

    }

}
