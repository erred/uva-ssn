package com.twitter.sdk.android.tweetcomposer;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.squareup.picasso.C3068t;
import com.twitter.sdk.android.core.internal.C3204p;
import com.twitter.sdk.android.core.internal.C3204p.C3206a;
import com.twitter.sdk.android.core.p132a.C3123s;
import com.twitter.sdk.android.tweetcomposer.internal.util.ObservableScrollView;
import com.twitter.sdk.android.tweetcomposer.internal.util.ObservableScrollView.C3302a;
import java.util.Locale;

public class ComposerView extends LinearLayout {

    /* renamed from: a */
    ImageView f8581a;

    /* renamed from: b */
    ImageView f8582b;

    /* renamed from: c */
    EditText f8583c;

    /* renamed from: d */
    TextView f8584d;

    /* renamed from: e */
    Button f8585e;

    /* renamed from: f */
    ObservableScrollView f8586f;

    /* renamed from: g */
    View f8587g;

    /* renamed from: h */
    ColorDrawable f8588h;

    /* renamed from: i */
    ImageView f8589i;

    /* renamed from: j */
    C3292a f8590j;

    /* renamed from: k */
    private C3068t f8591k;

    public ComposerView(Context context) {
        this(context, null);
    }

    public ComposerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9585a(context);
    }

    public ComposerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9585a(context);
    }

    /* renamed from: a */
    private void m9585a(Context context) {
        this.f8591k = C3068t.with(getContext());
        this.f8588h = new ColorDrawable(context.getResources().getColor(R.color.tw__composer_light_gray));
        inflate(context, R.layout.tw__composer_view, this);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        mo27926a();
        this.f8582b.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ComposerView.this.f8590j.mo27955a();
            }
        });
        this.f8585e.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ComposerView.this.f8590j.mo27957b(ComposerView.this.getTweetText());
            }
        });
        this.f8583c.setOnEditorActionListener(new OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                ComposerView.this.f8590j.mo27957b(ComposerView.this.getTweetText());
                return true;
            }
        });
        this.f8583c.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                ComposerView.this.f8590j.mo27956a(ComposerView.this.getTweetText());
            }
        });
        this.f8586f.setScrollViewListener(new C3302a() {
            /* renamed from: a */
            public void mo27942a(int i) {
                if (i > 0) {
                    ComposerView.this.f8587g.setVisibility(0);
                } else {
                    ComposerView.this.f8587g.setVisibility(4);
                }
            }
        });
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27926a() {
        this.f8581a = (ImageView) findViewById(R.id.tw__author_avatar);
        this.f8582b = (ImageView) findViewById(R.id.tw__composer_close);
        this.f8583c = (EditText) findViewById(R.id.tw__edit_tweet);
        this.f8584d = (TextView) findViewById(R.id.tw__char_count);
        this.f8585e = (Button) findViewById(R.id.tw__post_tweet);
        this.f8586f = (ObservableScrollView) findViewById(R.id.tw__composer_scroll_view);
        this.f8587g = findViewById(R.id.tw__composer_profile_divider);
        this.f8589i = (ImageView) findViewById(R.id.tw__image_view);
    }

    /* access modifiers changed from: 0000 */
    public void setCallbacks(C3292a aVar) {
        this.f8590j = aVar;
    }

    /* access modifiers changed from: 0000 */
    public void setProfilePhotoView(C3123s sVar) {
        String a = C3204p.m9383a(sVar, C3206a.REASONABLY_SMALL);
        if (this.f8591k != null) {
            this.f8591k.mo27533a(a).mo27574a((Drawable) this.f8588h).mo27575a(this.f8581a);
        }
    }

    /* access modifiers changed from: 0000 */
    public String getTweetText() {
        return this.f8583c.getText().toString();
    }

    /* access modifiers changed from: 0000 */
    public void setTweetText(String str) {
        this.f8583c.setText(str);
    }

    /* access modifiers changed from: 0000 */
    public void setCharCount(int i) {
        this.f8584d.setText(String.format(Locale.getDefault(), "%d", new Object[]{Integer.valueOf(i)}));
    }

    /* access modifiers changed from: 0000 */
    public void setCharCountTextStyle(int i) {
        this.f8584d.setTextAppearance(getContext(), i);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27927a(boolean z) {
        this.f8585e.setEnabled(z);
    }

    /* access modifiers changed from: 0000 */
    public void setImageView(Uri uri) {
        if (this.f8591k != null) {
            this.f8589i.setVisibility(0);
            this.f8591k.mo27532a(uri).mo27575a(this.f8589i);
        }
    }
}
