package com.google.android.gms.internal.nearby;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzsp extends zzsq {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzsq zzc;

    zzsp(zzsq zzsqVar, int i, int i2) {
        this.zzc = zzsqVar;
        this.zza = i;
        this.zzb = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzsg.zza(i, this.zzb, FirebaseAnalytics.Param.INDEX);
        return this.zzc.get(i + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.nearby.zzsq, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    @Override // com.google.android.gms.internal.nearby.zzsn
    final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // com.google.android.gms.internal.nearby.zzsn
    final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.nearby.zzsn
    final boolean zzf() {
        return true;
    }

    @Override // com.google.android.gms.internal.nearby.zzsn
    @CheckForNull
    final Object[] zzg() {
        return this.zzc.zzg();
    }

    @Override // com.google.android.gms.internal.nearby.zzsq
    /* JADX INFO: renamed from: zzh */
    public final zzsq subList(int i, int i2) {
        zzsg.zzg(i, i2, this.zzb);
        zzsq zzsqVar = this.zzc;
        int i3 = this.zza;
        return zzsqVar.subList(i + i3, i2 + i3);
    }
}
