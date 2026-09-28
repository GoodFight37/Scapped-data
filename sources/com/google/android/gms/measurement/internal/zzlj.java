package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzlj implements Runnable {
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcy zza;
    final /* synthetic */ zzlw zzb;

    zzlj(zzlw zzlwVar, com.google.android.gms.internal.measurement.zzcy zzcyVar) {
        this.zza = zzcyVar;
        this.zzb = zzlwVar;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x005d  */
    /* JADX WARN: Code duplicated, block: B:20:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    public final void run() {
        Long lValueOf;
        zzlw zzlwVar = this.zzb;
        zzio zzioVar = zzlwVar.zzu.zzv().zzu;
        if (zzioVar.zzm().zzh().zzr(zzjw.ANALYTICS_STORAGE)) {
            if (!zzioVar.zzm().zzp(zzioVar.zzaU().currentTimeMillis()) && zzioVar.zzm().zzl.zza() != 0) {
                lValueOf = Long.valueOf(zzioVar.zzm().zzl.zza());
            }
            if (lValueOf == null) {
                zzlwVar.zzu.zzw().zzY(this.zza, lValueOf.longValue());
            } else {
                try {
                    this.zza.zze(null);
                    return;
                } catch (RemoteException e) {
                    this.zzb.zzu.zzaW().zze().zzb("getSessionId failed with exception", e);
                    return;
                }
            }
        }
        zzioVar.zzaW().zzl().zza("Analytics storage consent denied; will not get session id");
        lValueOf = null;
        if (lValueOf == null) {
            this.zza.zze(null);
            return;
        }
        zzlwVar.zzu.zzw().zzY(this.zza, lValueOf.longValue());
    }
}
