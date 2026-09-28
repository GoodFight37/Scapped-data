package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzvp extends zzakg<zzvp, zza> implements zzalp {
    private static final zzvp zzc;
    private static volatile zzalw<zzvp> zzd;
    private int zze;
    private zzvs zzf;

    public static zza zza() {
        return zzc.zzm();
    }

    public static zzvp zza(zzaiw zzaiwVar, zzajv zzajvVar) throws zzakm {
        return (zzvp) zzakg.zza(zzc, zzaiwVar, zzajvVar);
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static final class zza extends zzakg.zzb<zzvp, zza> implements zzalp {
        public final zza zza(zzvs zzvsVar) {
            zzg();
            zzvp.zza((zzvp) this.zza, zzvsVar);
            return this;
        }

        private zza() {
            super(zzvp.zzc);
        }
    }

    public final zzvs zzc() {
        zzvs zzvsVar = this.zzf;
        return zzvsVar == null ? zzvs.zzf() : zzvsVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    protected final Object zza(int i, Object obj, Object obj2) {
        switch (zzvo.zza[i - 1]) {
            case 1:
                return new zzvp();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzalw<zzvp> zzaVar = zzd;
                if (zzaVar == null) {
                    synchronized (zzvp.class) {
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

    static /* synthetic */ void zza(zzvp zzvpVar, zzvs zzvsVar) {
        zzvsVar.getClass();
        zzvpVar.zzf = zzvsVar;
        zzvpVar.zze |= 1;
    }

    static {
        zzvp zzvpVar = new zzvp();
        zzc = zzvpVar;
        zzakg.zza((Class<zzvp>) zzvp.class, zzvpVar);
    }

    private zzvp() {
    }
}
