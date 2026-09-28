package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zztb extends zzakg<zztb, zza> implements zzalp {
    private static final zztb zzc;
    private static volatile zzalw<zztb> zzd;
    private int zze;
    private zzte zzf;
    private int zzg;

    public final int zza() {
        return this.zzg;
    }

    public static zza zzb() {
        return zzc.zzm();
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static final class zza extends zzakg.zzb<zztb, zza> implements zzalp {
        public final zza zza(int i) {
            zzg();
            ((zztb) this.zza).zzg = i;
            return this;
        }

        public final zza zza(zzte zzteVar) {
            zzg();
            zztb.zza((zztb) this.zza, zzteVar);
            return this;
        }

        private zza() {
            super(zztb.zzc);
        }
    }

    public static zztb zza(zzaiw zzaiwVar, zzajv zzajvVar) throws zzakm {
        return (zztb) zzakg.zza(zzc, zzaiwVar, zzajvVar);
    }

    public final zzte zzd() {
        zzte zzteVar = this.zzf;
        return zzteVar == null ? zzte.zzd() : zzteVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    protected final Object zza(int i, Object obj, Object obj2) {
        switch (zzta.zza[i - 1]) {
            case 1:
                return new zztb();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzalw<zztb> zzaVar = zzd;
                if (zzaVar == null) {
                    synchronized (zztb.class) {
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

    static /* synthetic */ void zza(zztb zztbVar, zzte zzteVar) {
        zzteVar.getClass();
        zztbVar.zzf = zzteVar;
        zztbVar.zze |= 1;
    }

    static {
        zztb zztbVar = new zztb();
        zzc = zztbVar;
        zzakg.zza((Class<zztb>) zztb.class, zztbVar);
    }

    private zztb() {
    }
}
