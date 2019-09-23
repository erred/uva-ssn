package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Icon;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.measurement.AppMeasurement.Param;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: h */
    static final Mode f3048h = Mode.SRC_IN;

    /* renamed from: a */
    public int f3049a;

    /* renamed from: b */
    Object f3050b;

    /* renamed from: c */
    public byte[] f3051c;

    /* renamed from: d */
    public Parcelable f3052d;

    /* renamed from: e */
    public int f3053e;

    /* renamed from: f */
    public int f3054f;

    /* renamed from: g */
    public ColorStateList f3055g = null;

    /* renamed from: i */
    Mode f3056i = f3048h;

    /* renamed from: j */
    public String f3057j;

    /* renamed from: a */
    private static String m3685a(int i) {
        switch (i) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    /* renamed from: a */
    public String mo3788a() {
        if (this.f3049a == -1 && VERSION.SDK_INT >= 23) {
            return m3686a((Icon) this.f3050b);
        }
        if (this.f3049a == 2) {
            return ((String) this.f3050b).split(":", -1)[0];
        }
        StringBuilder sb = new StringBuilder();
        sb.append("called getResPackage() on ");
        sb.append(this);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: b */
    public int mo3790b() {
        if (this.f3049a == -1 && VERSION.SDK_INT >= 23) {
            return m3687b((Icon) this.f3050b);
        }
        if (this.f3049a == 2) {
            return this.f3053e;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("called getResId() on ");
        sb.append(this);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: c */
    public Icon mo3791c() {
        Icon icon;
        int i = this.f3049a;
        if (i == -1) {
            return (Icon) this.f3050b;
        }
        switch (i) {
            case 1:
                icon = Icon.createWithBitmap((Bitmap) this.f3050b);
                break;
            case 2:
                icon = Icon.createWithResource(mo3788a(), this.f3053e);
                break;
            case 3:
                icon = Icon.createWithData((byte[]) this.f3050b, this.f3053e, this.f3054f);
                break;
            case 4:
                icon = Icon.createWithContentUri((String) this.f3050b);
                break;
            case 5:
                if (VERSION.SDK_INT < 26) {
                    icon = Icon.createWithBitmap(m3684a((Bitmap) this.f3050b, false));
                    break;
                } else {
                    icon = Icon.createWithAdaptiveBitmap((Bitmap) this.f3050b);
                    break;
                }
            default:
                throw new IllegalArgumentException("Unknown type");
        }
        if (this.f3055g != null) {
            icon.setTintList(this.f3055g);
        }
        if (this.f3056i != f3048h) {
            icon.setTintMode(this.f3056i);
        }
        return icon;
    }

    /* renamed from: d */
    public Bundle mo3792d() {
        Bundle bundle = new Bundle();
        int i = this.f3049a;
        if (i != -1) {
            switch (i) {
                case 1:
                case 5:
                    bundle.putParcelable("obj", (Bitmap) this.f3050b);
                    break;
                case 2:
                case 4:
                    bundle.putString("obj", (String) this.f3050b);
                    break;
                case 3:
                    bundle.putByteArray("obj", (byte[]) this.f3050b);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid icon");
            }
        } else {
            bundle.putParcelable("obj", (Parcelable) this.f3050b);
        }
        bundle.putInt(Param.TYPE, this.f3049a);
        bundle.putInt("int1", this.f3053e);
        bundle.putInt("int2", this.f3054f);
        if (this.f3055g != null) {
            bundle.putParcelable("tint_list", this.f3055g);
        }
        if (this.f3056i != f3048h) {
            bundle.putString("tint_mode", this.f3056i.name());
        }
        return bundle;
    }

    public String toString() {
        if (this.f3049a == -1) {
            return String.valueOf(this.f3050b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(m3685a(this.f3049a));
        switch (this.f3049a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f3050b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f3050b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(mo3788a());
                sb.append(" id=");
                sb.append(String.format("0x%08x", new Object[]{Integer.valueOf(mo3790b())}));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f3053e);
                if (this.f3054f != 0) {
                    sb.append(" off=");
                    sb.append(this.f3054f);
                    break;
                }
                break;
            case 4:
                sb.append(" uri=");
                sb.append(this.f3050b);
                break;
        }
        if (this.f3055g != null) {
            sb.append(" tint=");
            sb.append(this.f3055g);
        }
        if (this.f3056i != f3048h) {
            sb.append(" mode=");
            sb.append(this.f3056i);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public void mo3789a(boolean z) {
        this.f3057j = this.f3056i.name();
        int i = this.f3049a;
        if (i != -1) {
            switch (i) {
                case 1:
                case 5:
                    if (z) {
                        Bitmap bitmap = (Bitmap) this.f3050b;
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        bitmap.compress(CompressFormat.PNG, 90, byteArrayOutputStream);
                        this.f3051c = byteArrayOutputStream.toByteArray();
                        return;
                    }
                    this.f3052d = (Parcelable) this.f3050b;
                    return;
                case 2:
                    this.f3051c = ((String) this.f3050b).getBytes(Charset.forName("UTF-16"));
                    return;
                case 3:
                    this.f3051c = (byte[]) this.f3050b;
                    return;
                case 4:
                    this.f3051c = this.f3050b.toString().getBytes(Charset.forName("UTF-16"));
                    return;
                default:
                    return;
            }
        } else if (!z) {
            this.f3052d = (Parcelable) this.f3050b;
        } else {
            throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
        }
    }

    /* renamed from: e */
    public void mo3793e() {
        this.f3056i = Mode.valueOf(this.f3057j);
        int i = this.f3049a;
        if (i != -1) {
            switch (i) {
                case 1:
                case 5:
                    if (this.f3052d != null) {
                        this.f3050b = this.f3052d;
                        return;
                    }
                    this.f3050b = this.f3051c;
                    this.f3049a = 3;
                    this.f3053e = 0;
                    this.f3054f = this.f3051c.length;
                    return;
                case 2:
                case 4:
                    this.f3050b = new String(this.f3051c, Charset.forName("UTF-16"));
                    return;
                case 3:
                    this.f3050b = this.f3051c;
                    return;
                default:
                    return;
            }
        } else if (this.f3052d != null) {
            this.f3050b = this.f3052d;
        } else {
            throw new IllegalArgumentException("Invalid icon");
        }
    }

    /* renamed from: a */
    private static String m3686a(Icon icon) {
        if (VERSION.SDK_INT >= 28) {
            return icon.getResPackage();
        }
        try {
            return (String) icon.getClass().getMethod("getResPackage", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e) {
            Log.e("IconCompat", "Unable to get icon package", e);
            return null;
        } catch (InvocationTargetException e2) {
            Log.e("IconCompat", "Unable to get icon package", e2);
            return null;
        } catch (NoSuchMethodException e3) {
            Log.e("IconCompat", "Unable to get icon package", e3);
            return null;
        }
    }

    /* renamed from: b */
    private static int m3687b(Icon icon) {
        if (VERSION.SDK_INT >= 28) {
            return icon.getResId();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e) {
            Log.e("IconCompat", "Unable to get icon resource", e);
            return 0;
        } catch (InvocationTargetException e2) {
            Log.e("IconCompat", "Unable to get icon resource", e2);
            return 0;
        } catch (NoSuchMethodException e3) {
            Log.e("IconCompat", "Unable to get icon resource", e3);
            return 0;
        }
    }

    /* renamed from: a */
    static Bitmap m3684a(Bitmap bitmap, boolean z) {
        int min = (int) (((float) Math.min(bitmap.getWidth(), bitmap.getHeight())) * 0.6666667f);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f = (float) min;
        float f2 = 0.5f * f;
        float f3 = 0.9166667f * f2;
        if (z) {
            float f4 = 0.010416667f * f;
            paint.setColor(0);
            paint.setShadowLayer(f4, BitmapDescriptorFactory.HUE_RED, f * 0.020833334f, 1023410176);
            canvas.drawCircle(f2, f2, f3, paint);
            paint.setShadowLayer(f4, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 503316480);
            canvas.drawCircle(f2, f2, f3, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        BitmapShader bitmapShader = new BitmapShader(bitmap, TileMode.CLAMP, TileMode.CLAMP);
        Matrix matrix = new Matrix();
        matrix.setTranslate((float) ((-(bitmap.getWidth() - min)) / 2), (float) ((-(bitmap.getHeight() - min)) / 2));
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f2, f2, f3, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }
}
