package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzsm extends zzakg<zzsm, zza> implements zzalp {
    private static final zzsm zzc;
    private static volatile zzalw<zzsm> zzd;
    private int zze;
    private zzss zzf;
    private zzve zzg;

    public static zza zza() {
        return zzc.zzm();
    }

    public static zzsm zza(zzaiw zzaiwVar, zzajv zzajvVar) throws zzakm {
        return (zzsm) zzakg.zza(zzc, zzaiwVar, zzajvVar);
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static final class zza extends zzakg.zzb<zzsm, zza> implements zzalp {
        public final zza zza(zzss zzssVar) {
            zzg();
            zzsm.zza((zzsm) this.zza, zzssVar);
            return this;
        }

        public final zza zza(zzve zzveVar) {
            zzg();
            zzsm.zza((zzsm) this.zza, zzveVar);
            return this;
        }

        private zza() {
            super(zzsm.zzc);
        }
    }

    public final zzss zzc() {
        zzss zzssVar = this.zzf;
        return zzssVar == null ? zzss.zzd() : zzssVar;
    }

    public final zzve zzd() {
        zzve zzveVar = this.zzg;
        return zzveVar == null ? zzve.zze() : zzveVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    protected final Object zza(int i, Object obj, Object obj2) {
        switch (zzsl.zza[i - 1]) {
            case 1:
                return new zzsm();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzalw<zzsm> zzaVar = zzd;
                if (zzaVar == null) {
                    synchronized (zzsm.class) {
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

    static /* synthetic */ void zza(zzsm zzsmVar, zzss zzssVar) {
        zzssVar.getClass();
        zzsmVar.zzf = zzssVar;
        zzsmVar.zze |= 1;
    }

    static /* synthetic */ void zza(zzsm zzsmVar, zzve zzveVar) {
        zzveVar.getClass();
        zzsmVar.zzg = zzveVar;
        zzsmVar.zze |= 2;
    }

    static {
        zzsm zzsmVar = new zzsm();
        zzc = zzsmVar;
        zzakg.zza((Class<zzsm>) zzsm.class, zzsmVar);
    }

    private zzsm() {
    }
}
