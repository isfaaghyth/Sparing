package kelompok.app.sparing.ui.fragment.profile;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kelompok.app.sparing.R;
import kelompok.app.sparing.base.BaseFragment;

/**
 * Created by Jack on 12/15/2017.
 */

public class ProfileFragment extends BaseFragment<ProfilePresenter> implements ProfileView {

    @Override protected ProfilePresenter initPresenter() {
        return new ProfilePresenter(this);
    }

    @Override protected int setContentView() {
        return R.layout.fragment_profile;
    }

    @Override protected void onFragmentLoaded() {

    }

}
