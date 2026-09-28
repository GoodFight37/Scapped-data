package com.unity3d.player;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.google.api.client.googleapis.media.MediaHttpDownloader;

/* JADX INFO: renamed from: com.unity3d.player.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0129t implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1121a;
    public final UnityPlayerForActivityOrService b;
    public final EditText c = createEditText(this);
    public boolean d;
    public boolean e;
    public I0 f;
    public C0118n0 g;

    public abstract void a(boolean z);

    public abstract void b();

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public abstract EditText createEditText(AbstractC0129t abstractC0129t);

    public abstract void d();

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public AbstractC0129t(Context context, UnityPlayerForActivityOrService unityPlayerForActivityOrService) {
        this.f1121a = context;
        this.b = unityPlayerForActivityOrService;
    }

    public void a(String str, int i, boolean z, boolean z2, boolean z3, boolean z4, String str2, int i2, boolean z5, boolean z6) {
        this.e = z6;
        setupTextInput(str, i, z, z2, z3, z4, str2, i2);
        a(z5);
    }

    public void invokeOnClose() {
        C0118n0 c0118n0 = this.g;
        if (c0118n0 != null) {
            RunnableC0120o0 runnableC0120o0 = c0118n0.f1110a;
            runnableC0120o0.f1112a = true;
            if (runnableC0120o0.b) {
                runnableC0120o0.c.release();
            }
        }
    }

    public void setupTextInput(String str, int i, boolean z, boolean z2, boolean z3, boolean z4, String str2, int i2) {
        this.c.setOnEditorActionListener(new C0127s(this));
        this.c.setBackgroundColor(-1);
        this.c.setImeOptions(6);
        this.c.setText(str);
        this.c.setHint(str2);
        this.c.setHintTextColor(1627389952);
        EditText editText = this.c;
        int i3 = (z ? 32768 : 524288) | (z2 ? 131072 : 0) | (z3 ? 128 : 0);
        if (i >= 0 && i <= 11) {
            int i4 = new int[]{1, 16385, 12290, 17, 2, 3, 8289, 33, 1, 16417, 17, 8194}[i];
            if ((i4 & 2) != 0) {
                i3 = (z3 ? 16 : 0) | i4;
            } else {
                i3 |= i4;
            }
        }
        editText.setInputType(i3);
        this.c.setImeOptions(MediaHttpDownloader.MAXIMUM_CHUNK_SIZE);
        if (i2 > 0) {
            this.c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
        }
        this.c.addTextChangedListener(this);
        EditText editText2 = this.c;
        editText2.setSelection(editText2.getText().length());
        this.c.setClickable(true);
    }

    public boolean c() {
        return this.e;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        this.b.reportSoftInputStr(editable.toString(), 0, false);
        int selectionStart = this.c.getSelectionStart();
        this.b.reportSoftInputSelection(selectionStart, this.c.getSelectionEnd() - selectionStart);
    }

    public final void a(String str, boolean z) {
        this.c.setSelection(0, 0);
        this.b.reportSoftInputStr(str, 1, z);
    }

    public final void e() {
        ((InputMethodManager) this.f1121a.getSystemService(InputMethodManager.class)).showSoftInput(this.c, 0);
    }

    public final String a() {
        EditText editText = this.c;
        if (editText == null) {
            return null;
        }
        return editText.getText().toString();
    }
}
