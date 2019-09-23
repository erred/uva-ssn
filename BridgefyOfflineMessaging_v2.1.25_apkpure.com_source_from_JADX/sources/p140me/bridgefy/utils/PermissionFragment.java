package p140me.bridgefy.utils;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import me.bridgefy.main.R;

/* renamed from: me.bridgefy.utils.PermissionFragment */
public class PermissionFragment extends Fragment {

    /* renamed from: a */
    Unbinder f9668a;

    /* renamed from: b */
    private String f9669b;

    /* renamed from: c */
    private C3655a f9670c;
    @BindView(2131296391)
    TextView descriptionText;

    /* renamed from: me.bridgefy.utils.PermissionFragment$a */
    public interface C3655a {
        /* renamed from: c */
        void mo29157c();
    }

    /* renamed from: a */
    public static PermissionFragment m10877a(String str) {
        PermissionFragment permissionFragment = new PermissionFragment();
        Bundle bundle = new Bundle();
        bundle.putString("param1", str);
        permissionFragment.setArguments(bundle);
        return permissionFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f9669b = getArguments().getString("param1");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_permission, viewGroup, false);
        this.f9668a = ButterKnife.bind((Object) this, inflate);
        this.descriptionText.setText(this.f9669b);
        return inflate;
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.f9668a != null) {
            this.f9668a.unbind();
        }
    }

    @OnClick({2131296531})
    public void onButtonPressed() {
        if (this.f9670c != null) {
            this.f9670c.mo29157c();
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f9670c = (C3655a) activity;
        } catch (ClassCastException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append(activity.toString());
            sb.append(" must implement PermissionInteractionListener");
            throw new ClassCastException(sb.toString());
        }
    }

    public void onDetach() {
        super.onDetach();
        this.f9670c = null;
    }
}
