package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzvh extends zzakg<zzvh, zza> implements zzalp {
    private static final zzvh zzc;
    private static volatile zzalw<zzvh> zzd;
    private int zze;
    private int zzf;

    public final int zza() {
        return this.zzf;
    }

    public final zzvc zzb() {
        zzvc zzvcVarZza = zzvc.zza(this.zze);
        return zzvcVarZza == null ? zzvc.UNRECOGNIZED : zzvcVarZza;
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static final class zza extends zzakg.zzb<zzvh, zza> implements zzalp {
        public final zza zza(zzvc zzvcVar) {
            zzg();
            zzvh.zza((zzvh) this.zza, zzvcVar);
            return this;
        }

        public final zza zza(int i) {
            zzg();
            ((zzvh) this.zza).zzf = i;
            return this;
        }

        private zza() {
            super(zzvh.zzc);
        }
    }

    public static zza zzc() {
        return zzc.zzm();
    }

    public static zzvh zze() {
        return zzc;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    protected final Object zza(int i, Object obj, Object obj2) {
        switch (zzvj.zza[i - 1]) {
            case 1:
                return new zzvh();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzalw<zzvh> zzaVar = zzd;
                if (zzaVar == null) {
                    synchronized (zzvh.class) {
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

    static /* synthetic */ void zza(zzvh zzvhVar, zzvc zzvcVar) {
        zzvhVar.zze = zzvcVar.zza();
    }

    static {
        zzvh zzvhVar = new zzvh();
        zzc = zzvhVar;
        zzakg.zza((Class<zzvh>) zzvh.class, zzvhVar);
    }

    private zzvh() {
    }
}
