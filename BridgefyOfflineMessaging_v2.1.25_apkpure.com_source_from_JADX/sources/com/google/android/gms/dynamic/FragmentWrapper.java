package com.google.android.gms.dynamic;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.IFragmentWrapper.Stub;

@SuppressLint({"NewApi"})
@KeepForSdk
public final class FragmentWrapper extends Stub {
    private Fragment zzhz;

    @KeepForSdk
    public static FragmentWrapper wrap(Fragment fragment) {
        if (fragment != null) {
            return new FragmentWrapper(fragment);
        }
        return null;
    }

    private FragmentWrapper(Fragment fragment) {
        this.zzhz = fragment;
    }

    public final IObjectWrapper zzae() {
        return ObjectWrapper.wrap(this.zzhz.getActivity());
    }

    public final Bundle getArguments() {
        return this.zzhz.getArguments();
    }

    public final int getId() {
        return this.zzhz.getId();
    }

    public final IFragmentWrapper zzaf() {
        return wrap(this.zzhz.getParentFragment());
    }

    public final IObjectWrapper zzag() {
        return ObjectWrapper.wrap(this.zzhz.getResources());
    }

    public final boolean getRetainInstance() {
        return this.zzhz.getRetainInstance();
    }

    public final String getTag() {
        return this.zzhz.getTag();
    }

    public final IFragmentWrapper zzah() {
        return wrap(this.zzhz.getTargetFragment());
    }

    public final int getTargetRequestCode() {
        return this.zzhz.getTargetRequestCode();
    }

    public final boolean getUserVisibleHint() {
        return this.zzhz.getUserVisibleHint();
    }

    public final IObjectWrapper zzai() {
        return ObjectWrapper.wrap(this.zzhz.getView());
    }

    public final boolean isAdded() {
        return this.zzhz.isAdded();
    }

    public final boolean isDetached() {
        return this.zzhz.isDetached();
    }

    public final boolean isHidden() {
        return this.zzhz.isHidden();
    }

    public final boolean isInLayout() {
        return this.zzhz.isInLayout();
    }

    public final boolean isRemoving() {
        return this.zzhz.isRemoving();
    }

    public final boolean isResumed() {
        return this.zzhz.isResumed();
    }

    public final boolean isVisible() {
        return this.zzhz.isVisible();
    }

    public final void zza(IObjectWrapper iObjectWrapper) {
        this.zzhz.registerForContextMenu((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void setHasOptionsMenu(boolean z) {
        this.zzhz.setHasOptionsMenu(z);
    }

    public final void setMenuVisibility(boolean z) {
        this.zzhz.setMenuVisibility(z);
    }

    public final void setRetainInstance(boolean z) {
        this.zzhz.setRetainInstance(z);
    }

    public final void setUserVisibleHint(boolean z) {
        this.zzhz.setUserVisibleHint(z);
    }

    public final void startActivity(Intent intent) {
        this.zzhz.startActivity(intent);
    }

    public final void startActivityForResult(Intent intent, int i) {
        this.zzhz.startActivityForResult(intent, i);
    }

    public final void zzb(IObjectWrapper iObjectWrapper) {
        this.zzhz.unregisterForContextMenu((View) ObjectWrapper.unwrap(iObjectWrapper));
    }
}
