package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

/* renamed from: androidx.appcompat.widget.b */
/* compiled from: ActionBarBackgroundDrawable */
class C0654b extends Drawable {

    /* renamed from: a */
    final ActionBarContainer f1905a;

    public int getOpacity() {
        return 0;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public C0654b(ActionBarContainer actionBarContainer) {
        this.f1905a = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        if (!this.f1905a.f1492d) {
            if (this.f1905a.f1489a != null) {
                this.f1905a.f1489a.draw(canvas);
            }
            if (this.f1905a.f1490b != null && this.f1905a.f1493e) {
                this.f1905a.f1490b.draw(canvas);
            }
        } else if (this.f1905a.f1491c != null) {
            this.f1905a.f1491c.draw(canvas);
        }
    }

    public void getOutline(Outline outline) {
        if (this.f1905a.f1492d) {
            if (this.f1905a.f1491c != null) {
                this.f1905a.f1491c.getOutline(outline);
            }
        } else if (this.f1905a.f1489a != null) {
            this.f1905a.f1489a.getOutline(outline);
        }
    }
}
