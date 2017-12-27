package kelompok.app.sparing.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.expand.ParentPosition;

import kelompok.app.sparing.R;
import kelompok.app.sparing.model.User;
import kelompok.app.sparing.utils.GlideCircle;

/**
 * Created by isfaaghyth on 12/28/17.
 * github: @isfaaghyth
 */

@Layout(R.layout.cardview_member)
public class MemberAdapter {

    @View(R.id.txt_name) private TextView txtName;
    @View(R.id.img_avatar) private ImageView imgAvatar;

    @ParentPosition
    private int position;

    private Context context;
    private User user;

    public MemberAdapter(int position) {
        this.position = position;
    }

    public MemberAdapter setUser(User user) {
        this.user = user;
        return this;
    }

    public MemberAdapter setContext(Context context) {
        this.context = context;
        return this;
    }

    @Resolve
    private void onResolved() {
        GlideCircle.with()
                .context(context)
                .setImage(imgAvatar)
                .load(user.getAvatar());
        txtName.setText(user.getName());
    }
}
