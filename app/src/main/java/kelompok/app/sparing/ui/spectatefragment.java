package kelompok.app.sparing.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kelompok.app.sparing.R;

/**
 * Created by Jack on 12/15/2017.
 */

public class spectatefragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.spectate,container,false);
        return v;
    }
}
