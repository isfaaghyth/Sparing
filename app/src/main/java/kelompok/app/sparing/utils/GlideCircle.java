package kelompok.app.sparing.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import kelompok.app.sparing.R;

/**
 * Created by isfaaghyth on 12/28/17.
 * github: @isfaaghyth
 */

public class GlideCircle {

    private static volatile GlideCircle glide = new GlideCircle ();
    private Context context;
    private ImageView imageView;

    private GlideCircle() {}

    public static GlideCircle with() {
        return glide;
    }

    public GlideCircle context(Context context) {
        this.context = context;
        return this;
    }

    public GlideCircle setImage(ImageView imageView) {
        this.imageView = imageView;
        return this;
    }

    public void load(String uri) {
        Glide.with(context)
                .load(uri)
                .asBitmap().centerCrop()
                .error(R.mipmap.ic_person)
                .placeholder(R.mipmap.ic_person)
                .into(new BitmapImageViewTarget(imageView) {
                    @Override protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable rounded =
                                RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        rounded.setCircular(true);
                        imageView.setImageDrawable(rounded);
                    }
                });
    }

}
