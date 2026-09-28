package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzue extends zzakg<zzue, zza> implements zzalp {
    private static final zzue zzc;
    private static volatile zzalw<zzue> zzd;
    private int zze;
    private zzwf zzf;

    public static zza zza() {
        return zzc.zzm();
    }

    public static zzue zzc() {
        return zzc;
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static final class zza extends zzakg.zzb<zzue, zza> implements zzalp {
        public final zza zza(zzwf zzwfVar) {
            zzg();
            zzue.zza((zzue) this.zza, zzwfVar);
            return this;
        }

        private zza() {
            super(zzue.zzc);
        }
    }

    public final zzwf zzd() {
        zzwf zzwfVar = this.zzf;
        return zzwfVar == null ? zzwf.zzc() : zzwfVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    protected final Object zza(int i, Object obj, Object obj2) {
        switch (zzug.zza[i - 1]) {
            case 1:
                return new zzue();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0001\u0000\u0001\u0002\u0002\u0001\u0000\u0000\u0000\u0002ဉ\u0000", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzalw<zzue> zzaVar = zzd;
                if (zzaVar == null) {
                    synchronized (zzue.class) {
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

    static /* synthetic */ void zza(zzue zzueVar, zzwf zzwfVar) {
        zzwfVar.getClass();
        zzueVar.zzf = zzwfVar;
        zzueVar.zze |= 1;
    }

    static {
        zzue zzueVar = new zzue();
        zzc = zzueVar;
        zzakg.zza((Class<zzue>) zzue.class, zzueVar);
    }

    private zzue() {
    }
}
