package kelompok.app.sparing.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import rx.Subscription;

/**
 * Created by isfaaghyth on 12/26/17.
 * github: @isfaaghyth
 */

public abstract class BaseFragment<P extends BasePresenter> extends Fragment {

    protected P presenter;
    protected abstract P initPresenter();
    protected abstract @LayoutRes int setContentView();
    protected abstract void onFragmentLoaded();

    protected Subscription subscriber; //backup

    @Nullable @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return LayoutInflater.from(getContext()).inflate(setContentView(), container, false);
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        presenter = initPresenter();
        onFragmentLoaded();
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        if (presenter != null) {
            presenter.dettachView();
        }
        if (subscriber != null) {
            if (!subscriber.isUnsubscribed()) {
                subscriber.unsubscribe();
            }
        }
    }
}
