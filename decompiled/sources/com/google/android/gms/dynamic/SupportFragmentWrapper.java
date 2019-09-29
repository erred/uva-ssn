package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.p081a.C1062d;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.IFragmentWrapper.Stub;

@KeepForSdk
public final class SupportFragmentWrapper extends Stub {
    private C1062d zzid;

    @KeepForSdk
    public static SupportFragmentWrapper wrap(C1062d dVar) {
        if (dVar != null) {
            return new SupportFragmentWrapper(dVar);
        }
        return null;
    }

    private SupportFragmentWrapper(C1062d dVar) {
        this.zzid = dVar;
    }

    public final IObjectWrapper zzae() {
        return ObjectWrapper.wrap(this.zzid.getActivity());
    }

    public final Bundle getArguments() {
        return this.zzid.getArguments();
    }

    public final int getId() {
        return this.zzid.getId();
    }

    public final IFragmentWrapper zzaf() {
        return wrap(this.zzid.getParentFragment());
    }

    public final IObjectWrapper zzag() {
        return ObjectWrapper.wrap(this.zzid.getResources());
    }

    public final boolean getRetainInstance() {
        return this.zzid.getRetainInstance();
    }

    public final String getTag() {
        return this.zzid.getTag();
    }

    public final IFragmentWrapper zzah() {
        return wrap(this.zzid.getTargetFragment());
    }

    public final int getTargetRequestCode() {
        return this.zzid.getTargetRequestCode();
    }

    public final boolean getUserVisibleHint() {
        return this.zzid.getUserVisibleHint();
    }

    public final IObjectWrapper zzai() {
        return ObjectWrapper.wrap(this.zzid.getView());
    }

    public final boolean isAdded() {
        return this.zzid.isAdded();
    }

    public final boolean isDetached() {
        return this.zzid.isDetached();
    }

    public final boolean isHidden() {
        return this.zzid.isHidden();
    }

    public final boolean isInLayout() {
        return this.zzid.isInLayout();
    }

    public final boolean isRemoving() {
        return this.zzid.isRemoving();
    }

    public final boolean isResumed() {
        return this.zzid.isResumed();
    }

    public final boolean isVisible() {
        return this.zzid.isVisible();
    }

    public final void zza(IObjectWrapper iObjectWrapper) {
        this.zzid.registerForContextMenu((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void setHasOptionsMenu(boolean z) {
        this.zzid.setHasOptionsMenu(z);
    }

    public final void setMenuVisibility(boolean z) {
        this.zzid.setMenuVisibility(z);
    }

    public final void setRetainInstance(boolean z) {
        this.zzid.setRetainInstance(z);
    }

    public final void setUserVisibleHint(boolean z) {
        this.zzid.setUserVisibleHint(z);
    }

    public final void startActivity(Intent intent) {
        this.zzid.startActivity(intent);
    }

    public final void startActivityForResult(Intent intent, int i) {
        this.zzid.startActivityForResult(intent, i);
    }

    public final void zzb(IObjectWrapper iObjectWrapper) {
        this.zzid.unregisterForContextMenu((View) ObjectWrapper.unwrap(iObjectWrapper));
    }
}
