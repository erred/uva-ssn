package p140me.bridgefy.settings;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.fragment.p081a.C1062d;
import me.bridgefy.main.R;

/* renamed from: me.bridgefy.settings.BridgefyInfoFragment */
public class BridgefyInfoFragment extends C1062d {

    /* renamed from: a */
    Button f9586a;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_bridgefy_info, viewGroup, false);
        this.f9586a = (Button) inflate.findViewById(R.id.btn_go_to_bridgefy);
        this.f9586a.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                BridgefyInfoFragment.this.m10754a(view);
            }
        });
        return inflate;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m10754a(View view) {
        try {
            getActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://bridgefy.me")));
        } catch (ActivityNotFoundException e) {
            Toast.makeText(getActivity(), "No application can handle this request. Please install a webbrowser", 1).show();
            e.printStackTrace();
        }
    }
}
