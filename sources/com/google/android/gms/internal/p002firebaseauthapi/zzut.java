package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzut extends zzakg<zzut, zza> implements zzalp {
    private static final zzut zzc;
    private static volatile zzalw<zzut> zzd;
    private int zze;
    private int zzf;
    private zzaiw zzg = zzaiw.zza;

    public static zza zza() {
        return zzc.zzm();
    }

    public static zzut zzc() {
        return zzc;
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static final class zza extends zzakg.zzb<zzut, zza> implements zzalp {
        public final zza zza(zzuw zzuwVar) {
            zzg();
            zzut.zza((zzut) this.zza, zzuwVar);
            return this;
        }

        public final zza zza(zzvc zzvcVar) {
            zzg();
            zzut.zza((zzut) this.zza, zzvcVar);
            return this;
        }

        public final zza zza(zzaiw zzaiwVar) {
            zzg();
            zzut.zza((zzut) this.zza, zzaiwVar);
            return this;
        }

        private zza() {
            super(zzut.zzc);
        }
    }

    public final zzuw zzd() {
        zzuw zzuwVarZza = zzuw.zza(this.zze);
        return zzuwVarZza == null ? zzuw.UNRECOGNIZED : zzuwVarZza;
    }

    public final zzvc zze() {
        zzvc zzvcVarZza = zzvc.zza(this.zzf);
        return zzvcVarZza == null ? zzvc.UNRECOGNIZED : zzvcVarZza;
    }

    public final zzaiw zzf() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    protected final Object zza(int i, Object obj, Object obj2) {
        switch (zzuv.zza[i - 1]) {
            case 1:
                return new zzut();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzalw<zzut> zzaVar = zzd;
                if (zzaVar == null) {
                    synchronized (zzut.class) {
                        zzaVar = zzd;
                        if (zzaVar == null) {
                            zzaVar = new zzakg.zza<>(zzc);
                            zzd = zzaVar;
                        }
                        break;
                    }
                }
                return zzaVar;
            case 6:
                return (byte) 1;
            default:
                throw null;
        }
    }

    static /* synthetic */ void zza(zzut zzutVar, zzuw zzuwVar) {
        zzutVar.zze = zzuwVar.zza();
    }

    static /* synthetic */ void zza(zzut zzutVar, zzvc zzvcVar) {
        zzutVar.zzf = zzvcVar.zza();
    }

    static /* synthetic */ void zza(zzut zzutVar, zzaiw zzaiwVar) {
        zzaiwVar.getClass();
        zzutVar.zzg = zzaiwVar;
    }

    static {
        zzut zzutVar = new zzut();
        zzc = zzutVar;
        zzakg.zza((Class<zzut>) zzut.class, zzutVar);
    }

    private zzut() {
    }
}
