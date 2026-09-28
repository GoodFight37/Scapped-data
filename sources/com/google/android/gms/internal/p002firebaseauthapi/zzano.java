package com.google.android.gms.internal.p002firebaseauthapi;

import java.text.SimpleDateFormat;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzano extends ThreadLocal<SimpleDateFormat> {
    @Override // java.lang.ThreadLocal
    protected final /* synthetic */ SimpleDateFormat initialValue() {
        return zzanp.zza();
    }

    zzano() {
    }
}
