package kelompok.app.sparing.base;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by isfaaghyth on 12/8/17.
 * github: @isfaaghyth
 */

public class BaseActivity extends AppCompatActivity {

    protected void init(int layoutId) {
        setContentView(layoutId);
    }

    @Override protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

}
