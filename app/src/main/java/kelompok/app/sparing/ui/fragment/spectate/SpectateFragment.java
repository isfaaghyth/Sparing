package kelompok.app.sparing.ui.fragment.spectate;

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

public class SpectateFragment extends BaseFragment<SpectatePresenter> implements SpectateView {


    @Override protected SpectatePresenter initPresenter() {
        return new SpectatePresenter(this);
    }

    @Override protected int setContentView() {
        return R.layout.fragment_spectate;
    }

    @Override protected void onFragmentLoaded() {

    }
}
