package com.google.android.gms.internal.common;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzak extends zzal {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzal zzc;

    zzak(zzal zzalVar, int i, int i2) {
        this.zzc = zzalVar;
        this.zza = i;
        this.zzb = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzv.zza(i, this.zzb, FirebaseAnalytics.Param.INDEX);
        return this.zzc.get(i + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.common.zzal, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    @Override // com.google.android.gms.internal.common.zzag
    final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // com.google.android.gms.internal.common.zzag
    final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.common.zzag
    final boolean zzf() {
        return true;
    }

    @Override // com.google.android.gms.internal.common.zzag
    final Object[] zzg() {
        return this.zzc.zzg();
    }

    @Override // com.google.android.gms.internal.common.zzal
    /* JADX INFO: renamed from: zzi */
    public final zzal subList(int i, int i2) {
        zzv.zzc(i, i2, this.zzb);
        int i3 = this.zza;
        return this.zzc.subList(i + i3, i2 + i3);
    }
}
