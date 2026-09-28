package com.google.firebase.auth.internal;

import android.util.Base64;
import android.util.Log;
import com.adjust.sdk.Constants;
import com.google.android.gms.internal.p002firebaseauthapi.zzags;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.integrity.IntegrityManager;
import com.google.android.play.core.integrity.IntegrityTokenRequest;
import com.google.android.play.core.integrity.IntegrityTokenResponse;
import java.security.MessageDigest;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zze implements Continuation<zzags, Task<IntegrityTokenResponse>> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ IntegrityManager zzb;
    private final /* synthetic */ zzb zzc;

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<IntegrityTokenResponse> then(Task<zzags> task) throws Exception {
        if (task.isSuccessful()) {
            this.zzc.zzc = task.getResult().zza();
            return this.zzb.requestIntegrityToken(IntegrityTokenRequest.builder().setCloudProjectNumber(Long.parseLong(task.getResult().zza())).setNonce(new String(Base64.encode(MessageDigest.getInstance("SHA-256").digest(this.zza.getBytes(Constants.ENCODING)), 11))).build());
        }
        Log.e(zzb.zza, "Problem retrieving Play Integrity producer project:  " + task.getException().getMessage());
        return Tasks.forException(task.getException());
    }

    zze(zzb zzbVar, String str, IntegrityManager integrityManager) {
        this.zza = str;
        this.zzb = integrityManager;
        this.zzc = zzbVar;
    }
}
