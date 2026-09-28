package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzsr extends zzsl {
    public zzsr() {
        super(4);
    }

    public final zzsr zzb(Object obj) {
        obj.getClass();
        super.zza(obj);
        return this;
    }

    public final zzss zzc() {
        int i = this.zzb;
        if (i == 0) {
            return zzsw.zza;
        }
        if (i == 1) {
            Object obj = this.zza[0];
            obj.getClass();
            return new zzsx(obj);
        }
        zzss zzssVarZzl = zzss.zzl(i, this.zza);
        this.zzb = zzssVarZzl.size();
        this.zzc = true;
        return zzssVarZzl;
    }
}
