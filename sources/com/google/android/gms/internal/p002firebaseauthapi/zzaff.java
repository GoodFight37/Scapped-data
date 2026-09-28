package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.tasks.OnFailureListener;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzaff implements OnFailureListener {
    zzaff(zzafd zzafdVar) {
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        zzafd.zza.e("SmsRetrieverClient failed to start: " + exc.getMessage(), new Object[0]);
    }
}
