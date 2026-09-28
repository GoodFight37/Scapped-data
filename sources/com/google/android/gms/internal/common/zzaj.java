package com.google.android.gms.internal.common;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzaj extends zzal {
    private final transient zzal zza;

    zzaj(zzal zzalVar) {
        this.zza = zzalVar;
    }

    private final int zzr(int i) {
        return (this.zza.size() - 1) - i;
    }

    @Override // com.google.android.gms.internal.common.zzal, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return this.zza.contains(obj);
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzv.zza(i, this.zza.size(), FirebaseAnalytics.Param.INDEX);
        return this.zza.get(zzr(i));
    }

    @Override // com.google.android.gms.internal.common.zzal, java.util.List
    public final int indexOf(Object obj) {
        int iLastIndexOf = this.zza.lastIndexOf(obj);
        if (iLastIndexOf >= 0) {
            return zzr(iLastIndexOf);
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.common.zzal, java.util.List
    public final int lastIndexOf(Object obj) {
        int iIndexOf = this.zza.indexOf(obj);
        if (iIndexOf >= 0) {
            return zzr(iIndexOf);
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.common.zzal, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    @Override // com.google.android.gms.internal.common.zzag
    final boolean zzf() {
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.common.zzal
    public final zzal zzh() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.common.zzal
    /* JADX INFO: renamed from: zzi */
    public final zzal subList(int i, int i2) {
        zzv.zzc(i, i2, this.zza.size());
        zzal zzalVar = this.zza;
        return zzalVar.subList(zzalVar.size() - i2, this.zza.size() - i).zzh();
    }
}
