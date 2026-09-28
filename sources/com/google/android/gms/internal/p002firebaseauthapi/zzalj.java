package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzalj implements zzalg {
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalg
    public final int zza(int i, Object obj, Object obj2) {
        zzalh zzalhVar = (zzalh) obj;
        if (zzalhVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzalhVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalg
    public final zzale<?, ?> zza(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalg
    public final Object zza(Object obj, Object obj2) {
        zzalh zzalhVarZzb = (zzalh) obj;
        zzalh zzalhVar = (zzalh) obj2;
        if (!zzalhVar.isEmpty()) {
            if (!zzalhVarZzb.zzd()) {
                zzalhVarZzb = zzalhVarZzb.zzb();
            }
            zzalhVarZzb.zza(zzalhVar);
        }
        return zzalhVarZzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalg
    public final Object zzb(Object obj) {
        return zzalh.zza().zzb();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalg
    public final Object zzc(Object obj) {
        ((zzalh) obj).zzc();
        return obj;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalg
    public final Map<?, ?> zzd(Object obj) {
        return (zzalh) obj;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalg
    public final Map<?, ?> zze(Object obj) {
        return (zzalh) obj;
    }

    zzalj() {
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalg
    public final boolean zzf(Object obj) {
        return !((zzalh) obj).zzd();
    }
}
