package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzamt extends zzakg<zzamt, zza> implements zzalp {
    private static final zzamt zzc;
    private static volatile zzalw<zzamt> zzd;
    private long zze;
    private int zzf;

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static final class zza extends zzakg.zzb<zzamt, zza> implements zzalp {
        public final zza zza(int i) {
            if (!this.zza.zzw()) {
                zzh();
            }
            ((zzamt) this.zza).zzf = i;
            return this;
        }

        public final zza zza(long j) {
            if (!this.zza.zzw()) {
                zzh();
            }
            ((zzamt) this.zza).zze = j;
            return this;
        }

        private zza() {
            super(zzamt.zzc);
        }
    }

    public final int zza() {
        return this.zzf;
    }

    public final long zzb() {
        return this.zze;
    }

    public static zza zzc() {
        return zzc.zzm();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    protected final Object zza(int i, Object obj, Object obj2) {
        switch (zzams.zza[i - 1]) {
            case 1:
                return new zzamt();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzalw<zzamt> zzaVar = zzd;
                if (zzaVar == null) {
                    synchronized (zzamt.class) {
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
        zzamt zzamtVar = new zzamt();
        zzc = zzamtVar;
        zzakg.zza((Class<zzamt>) zzamt.class, zzamtVar);
    }

    private zzamt() {
    }
}
