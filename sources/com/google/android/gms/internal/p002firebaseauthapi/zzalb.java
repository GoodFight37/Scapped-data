package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzalb implements zzamf {
    private static final zzalk zza = new zzala();
    private final zzalk zzb;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamf
    public final <T> zzamc<T> zza(Class<T> cls) {
        zzame.zza((Class<?>) cls);
        zzall zzallVarZza = this.zzb.zza(cls);
        if (zzallVarZza.zzc()) {
            return zzalt.zza(zzame.zza(), zzajz.zza(), zzallVarZza.zza());
        }
        return zzalr.zza(cls, zzallVarZza, zzalx.zza(), zzakz.zza(), zzame.zza(), zzald.zza[zzallVarZza.zzb().ordinal()] != 1 ? zzajz.zza() : null, zzali.zza());
    }

    public zzalb() {
        this(new zzalc(zzakh.zza(), zza));
    }

    private zzalb(zzalk zzalkVar) {
        this.zzb = (zzalk) zzaki.zza(zzalkVar, "messageInfoFactory");
    }
}
