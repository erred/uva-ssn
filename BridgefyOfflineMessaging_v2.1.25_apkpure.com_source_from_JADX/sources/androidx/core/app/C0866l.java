package androidx.core.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.util.List;
import java.util.Map;

/* renamed from: androidx.core.app.l */
/* compiled from: SharedElementCallback */
public abstract class C0866l {

    /* renamed from: a */
    private Matrix f2821a;

    /* renamed from: androidx.core.app.l$a */
    /* compiled from: SharedElementCallback */
    public interface C0867a {
        /* renamed from: a */
        void mo3463a();
    }

    /* renamed from: a */
    public void mo3537a(List<View> list) {
    }

    /* renamed from: a */
    public void mo3539a(List<String> list, List<View> list2, List<View> list3) {
    }

    /* renamed from: a */
    public void mo3540a(List<String> list, Map<String, View> map) {
    }

    /* renamed from: b */
    public void mo3541b(List<String> list, List<View> list2, List<View> list3) {
    }

    /* renamed from: a */
    public Parcelable mo3535a(View view, Matrix matrix, RectF rectF) {
        if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;
            Drawable drawable = imageView.getDrawable();
            Drawable background = imageView.getBackground();
            if (drawable != null && background == null) {
                Bitmap a = m3208a(drawable);
                if (a != null) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("sharedElement:snapshot:bitmap", a);
                    bundle.putString("sharedElement:snapshot:imageScaleType", imageView.getScaleType().toString());
                    if (imageView.getScaleType() == ScaleType.MATRIX) {
                        float[] fArr = new float[9];
                        imageView.getImageMatrix().getValues(fArr);
                        bundle.putFloatArray("sharedElement:snapshot:imageMatrix", fArr);
                    }
                    return bundle;
                }
            }
        }
        int round = Math.round(rectF.width());
        int round2 = Math.round(rectF.height());
        Bitmap bitmap = null;
        if (round > 0 && round2 > 0) {
            float min = Math.min(1.0f, 1048576.0f / ((float) (round * round2)));
            int i = (int) (((float) round) * min);
            int i2 = (int) (((float) round2) * min);
            if (this.f2821a == null) {
                this.f2821a = new Matrix();
            }
            this.f2821a.set(matrix);
            this.f2821a.postTranslate(-rectF.left, -rectF.top);
            this.f2821a.postScale(min, min);
            bitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            canvas.concat(this.f2821a);
            view.draw(canvas);
        }
        return bitmap;
    }

    /* renamed from: a */
    private static Bitmap m3208a(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return null;
        }
        float min = Math.min(1.0f, 1048576.0f / ((float) (intrinsicWidth * intrinsicHeight)));
        if ((drawable instanceof BitmapDrawable) && min == 1.0f) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int i = (int) (((float) intrinsicWidth) * min);
        int i2 = (int) (((float) intrinsicHeight) * min);
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Rect bounds = drawable.getBounds();
        int i3 = bounds.left;
        int i4 = bounds.top;
        int i5 = bounds.right;
        int i6 = bounds.bottom;
        drawable.setBounds(0, 0, i, i2);
        drawable.draw(canvas);
        drawable.setBounds(i3, i4, i5, i6);
        return createBitmap;
    }

    /* renamed from: a */
    public View mo3536a(Context context, Parcelable parcelable) {
        ImageView imageView = null;
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            Bitmap bitmap = (Bitmap) bundle.getParcelable("sharedElement:snapshot:bitmap");
            if (bitmap == null) {
                return null;
            }
            imageView = new ImageView(context);
            imageView.setImageBitmap(bitmap);
            imageView.setScaleType(ScaleType.valueOf(bundle.getString("sharedElement:snapshot:imageScaleType")));
            if (imageView.getScaleType() == ScaleType.MATRIX) {
                float[] floatArray = bundle.getFloatArray("sharedElement:snapshot:imageMatrix");
                Matrix matrix = new Matrix();
                matrix.setValues(floatArray);
                imageView.setImageMatrix(matrix);
            }
        } else if (parcelable instanceof Bitmap) {
            Bitmap bitmap2 = (Bitmap) parcelable;
            imageView = new ImageView(context);
            imageView.setImageBitmap(bitmap2);
        }
        return imageView;
    }

    /* renamed from: a */
    public void mo3538a(List<String> list, List<View> list2, C0867a aVar) {
        aVar.mo3463a();
    }
}
