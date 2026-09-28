package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzsv extends zzakg<zzsv, zza> implements zzalp {
    private static final zzsv zzc;
    private static volatile zzalw<zzsv> zzd;
    private int zze;

    public final int zza() {
        return this.zze;
    }

    public static zza zzb() {
        return zzc.zzm();
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static final class zza extends zzakg.zzb<zzsv, zza> implements zzalp {
        public final zza zza(int i) {
            zzg();
            ((zzsv) this.zza).zze = i;
            return this;
        }

        private zza() {
            super(zzsv.zzc);
        }
    }

    public static zzsv zzd() {
        return zzc;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    protected final Object zza(int i, Object obj, Object obj2) {
        switch (zzsu.zza[i - 1]) {
            case 1:
                return new zzsv();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                zzalw<zzsv> zzaVar = zzd;
                if (zzaVar == null) {
                    synchronized (zzsv.class) {
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
        zzsv zzsvVar = new zzsv();
        zzc = zzsvVar;
        zzakg.zza((Class<zzsv>) zzsv.class, zzsvVar);
    }

    private zzsv() {
    }
}
