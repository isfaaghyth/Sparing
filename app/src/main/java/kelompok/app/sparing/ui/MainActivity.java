package kelompok.app.sparing.ui;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import kelompok.app.sparing.R;
import kelompok.app.sparing.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {

                if (tabId == R.id.matchup){

                }else if (tabId == R.id.chat){

                }else if (tabId == R.id.spectate){

                }else if (tabId == R.id.friend){

                }else if (tabId == R.id.profile){

                }

            }
        });
    }
}
