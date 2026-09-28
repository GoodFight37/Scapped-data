package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.Mac;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzzh extends ThreadLocal<Mac> {
    private final /* synthetic */ zzze zza;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.ThreadLocal
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final Mac initialValue() {
        try {
            Mac macZza = zzym.zzb.zza(this.zza.zzc);
            macZza.init(this.zza.zzd);
            return macZza;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }

    zzzh(zzze zzzeVar) {
        this.zza = zzzeVar;
    }
}
