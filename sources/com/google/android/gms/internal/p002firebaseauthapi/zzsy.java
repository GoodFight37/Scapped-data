package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzsy extends zzakg<zzsy, zza> implements zzalp {
    private static final zzsy zzc;
    private static volatile zzalw<zzsy> zzd;
    private int zze;
    private int zzf;
    private zzte zzg;
    private zzaiw zzh = zzaiw.zza;

    public final int zza() {
        return this.zzf;
    }

    public static zza zzb() {
        return zzc.zzm();
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static final class zza extends zzakg.zzb<zzsy, zza> implements zzalp {
        public final zza zza(zzaiw zzaiwVar) {
            zzg();
            zzsy.zza((zzsy) this.zza, zzaiwVar);
            return this;
        }

        public final zza zza(zzte zzteVar) {
            zzg();
            zzsy.zza((zzsy) this.zza, zzteVar);
            return this;
        }

        private zza() {
            super(zzsy.zzc);
        }
    }

    public static zzsy zza(zzaiw zzaiwVar, zzajv zzajvVar) throws zzakm {
        return (zzsy) zzakg.zza(zzc, zzaiwVar, zzajvVar);
    }

    public final zzte zzd() {
        zzte zzteVar = this.zzg;
        return zzteVar == null ? zzte.zzd() : zzteVar;
    }

    public final zzaiw zze() {
        return this.zzh;
    }

    public static zzalw<zzsy> zzf() {
        return (zzalw) zzc.zza(zzakg.zze.zzg, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    protected final Object zza(int i, Object obj, Object obj2) {
        switch (zzsx.zza[i - 1]) {
            case 1:
                return new zzsy();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzalw<zzsy> zzaVar = zzd;
                if (zzaVar == null) {
                    synchronized (zzsy.class) {
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

    static /* synthetic */ void zza(zzsy zzsyVar, zzaiw zzaiwVar) {
        zzaiwVar.getClass();
        zzsyVar.zzh = zzaiwVar;
    }

    static /* synthetic */ void zza(zzsy zzsyVar, zzte zzteVar) {
        zzteVar.getClass();
        zzsyVar.zzg = zzteVar;
        zzsyVar.zze |= 1;
    }

    static {
        zzsy zzsyVar = new zzsy();
        zzc = zzsyVar;
        zzakg.zza((Class<zzsy>) zzsy.class, zzsyVar);
    }

    private zzsy() {
    }
}
