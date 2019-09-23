package com.google.android.material.dialog;

import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import androidx.appcompat.app.C0446c;
import com.google.android.material.C2167R;

class InsetDialogOnTouchListener implements OnTouchListener {
    private final C0446c dialog;
    private final int leftInset;
    private final int topInset;

    InsetDialogOnTouchListener(C0446c cVar, int i, int i2) {
        this.dialog = cVar;
        this.leftInset = i;
        this.topInset = i2;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        View findViewById = view.findViewById(C2167R.C2170id.parentPanel);
        int left = this.leftInset + findViewById.getLeft();
        int top = this.topInset + findViewById.getTop();
        if (new RectF((float) left, (float) top, (float) (findViewById.getWidth() + left), (float) (findViewById.getHeight() + top)).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(4);
        view.performClick();
        if (VERSION.SDK_INT >= 28) {
            return this.dialog.onTouchEvent(obtain);
        }
        this.dialog.onBackPressed();
        return true;
    }
}
