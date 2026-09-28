package com.google.android.gms.internal.games_v2;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzib extends zzhk {
    private final transient zzhg zza;
    private final transient Object[] zzb;
    private final transient int zzc;

    zzib(zzhg zzhgVar, Object[] objArr, int i, int i2) {
        this.zza = zzhgVar;
        this.zzb = objArr;
        this.zzc = i2;
    }

    @Override // com.google.android.gms.internal.games_v2.zzgy, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.zza.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.games_v2.zzhk, com.google.android.gms.internal.games_v2.zzgy, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return zzh().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.games_v2.zzhk, com.google.android.gms.internal.games_v2.zzgy
    /* JADX INFO: renamed from: zza */
    public final zzil iterator() {
        return zzh().listIterator(0);
    }

    @Override // com.google.android.gms.internal.games_v2.zzgy
    final int zze(Object[] objArr, int i) {
        return zzh().zze(objArr, 0);
    }

    @Override // com.google.android.gms.internal.games_v2.zzhk
    final zzhd zzi() {
        return new zzia(this);
    }

    final /* synthetic */ Object[] zzk() {
        return this.zzb;
    }

    final /* synthetic */ int zzl() {
        return this.zzc;
    }
}
