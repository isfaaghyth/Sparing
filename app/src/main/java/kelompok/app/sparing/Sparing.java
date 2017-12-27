package kelompok.app.sparing;

import android.app.Application;

import io.isfaaghyth.rak.Rak;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by isfaaghyth on 12/8/17.
 * github: @isfaaghyth
 */

public class Sparing extends Application {

    @Override public void onCreate() {
        super.onCreate();
        Rak.initialize(this);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/OpenSans-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());
    }

}
