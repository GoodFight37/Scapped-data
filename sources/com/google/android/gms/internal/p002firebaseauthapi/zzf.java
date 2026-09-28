package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzf {
    public int zza(CharSequence charSequence, int i) {
        int length = charSequence.length();
        zzw.zza(i, length, FirebaseAnalytics.Param.INDEX);
        while (i < length) {
            if (zza(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public abstract boolean zza(char c);

    protected zzf() {
    }
}
