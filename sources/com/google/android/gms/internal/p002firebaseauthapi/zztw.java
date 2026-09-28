package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zztw extends zzakg<zztw, zza> implements zzalp {
    private static final zztw zzc;
    private static volatile zzalw<zztw> zzd;
    private int zze;
    private int zzf;

    public final int zza() {
        return this.zze;
    }

    public final int zzb() {
        return this.zzf;
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static final class zza extends zzakg.zzb<zztw, zza> implements zzalp {
        public final zza zza(int i) {
            zzg();
            ((zztw) this.zza).zze = i;
            return this;
        }

        private zza() {
            super(zztw.zzc);
        }
    }

    public static zza zzc() {
        return zzc.zzm();
    }

    public static zztw zza(zzaiw zzaiwVar, zzajv zzajvVar) throws zzakm {
        return (zztw) zzakg.zza(zzc, zzaiwVar, zzajvVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    protected final Object zza(int i, Object obj, Object obj2) {
        switch (zztv.zza[i - 1]) {
            case 1:
                return new zztw();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzalw<zztw> zzaVar = zzd;
                if (zzaVar == null) {
                    synchronized (zztw.class) {
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

    static {
        zztw zztwVar = new zztw();
        zzc = zztwVar;
        zzakg.zza((Class<zztw>) zztw.class, zztwVar);
    }

    private zztw() {
    }
}
