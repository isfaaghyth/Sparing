package kelompok.app.sparing.service;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by isfaaghyth on 12/27/17.
 * github: @isfaaghyth
 */

public class InstanceIdService extends FirebaseInstanceIdService {
    @Override public void onTokenRefresh() {
        super.onTokenRefresh();
        String token = FirebaseInstanceId.getInstance().getToken();;
        //sendToken();
    }
}
