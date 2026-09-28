package com.google.android.gms.internal.common;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzai extends zzad {
    private final zzal zza;

    zzai(zzal zzalVar, int i) {
        super(zzalVar.size(), i);
        this.zza = zzalVar;
    }

    @Override // com.google.android.gms.internal.common.zzad
    protected final Object zza(int i) {
        return this.zza.get(i);
    }
}
