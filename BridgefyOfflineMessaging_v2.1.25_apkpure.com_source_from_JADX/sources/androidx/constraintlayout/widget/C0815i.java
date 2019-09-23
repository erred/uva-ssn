package androidx.constraintlayout.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout.C0795a;

/* renamed from: androidx.constraintlayout.widget.i */
/* compiled from: Placeholder */
public class C0815i extends View {

    /* renamed from: a */
    private int f2684a;

    /* renamed from: b */
    private View f2685b;

    /* renamed from: c */
    private int f2686c;

    public void setEmptyVisibility(int i) {
        this.f2686c = i;
    }

    public int getEmptyVisibility() {
        return this.f2686c;
    }

    public View getContent() {
        return this.f2685b;
    }

    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize((float) rect.height());
            int height = rect.height();
            int width = rect.width();
            paint.setTextAlign(Align.LEFT);
            String str = "?";
            paint.getTextBounds(str, 0, str.length(), rect);
            canvas.drawText(str, ((((float) width) / 2.0f) - (((float) rect.width()) / 2.0f)) - ((float) rect.left), ((((float) height) / 2.0f) + (((float) rect.height()) / 2.0f)) - ((float) rect.bottom), paint);
        }
    }

    /* renamed from: a */
    public void mo3317a(ConstraintLayout constraintLayout) {
        if (this.f2684a == -1 && !isInEditMode()) {
            setVisibility(this.f2686c);
        }
        this.f2685b = constraintLayout.findViewById(this.f2684a);
        if (this.f2685b != null) {
            ((C0795a) this.f2685b.getLayoutParams()).f2502aa = true;
            this.f2685b.setVisibility(0);
            setVisibility(0);
        }
    }

    public void setContentId(int i) {
        if (this.f2684a != i) {
            if (this.f2685b != null) {
                this.f2685b.setVisibility(0);
                ((C0795a) this.f2685b.getLayoutParams()).f2502aa = false;
                this.f2685b = null;
            }
            this.f2684a = i;
            if (i != -1) {
                View findViewById = ((View) getParent()).findViewById(i);
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
            }
        }
    }

    /* renamed from: b */
    public void mo3318b(ConstraintLayout constraintLayout) {
        if (this.f2685b != null) {
            C0795a aVar = (C0795a) getLayoutParams();
            C0795a aVar2 = (C0795a) this.f2685b.getLayoutParams();
            aVar2.f2514am.mo3091e(0);
            aVar.f2514am.mo3098h(aVar2.f2514am.mo3113p());
            aVar.f2514am.mo3100i(aVar2.f2514am.mo3116r());
            aVar2.f2514am.mo3091e(8);
        }
    }
}
