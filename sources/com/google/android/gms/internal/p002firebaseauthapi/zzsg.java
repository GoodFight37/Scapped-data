package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzsg extends zzakg<zzsg, zza> implements zzalp {
    private static final zzsg zzc;
    private static volatile zzalw<zzsg> zzd;
    private int zze;

    public final int zza() {
        return this.zze;
    }

    public static zza zzb() {
        return zzc.zzm();
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static final class zza extends zzakg.zzb<zzsg, zza> implements zzalp {
        public final zza zza(int i) {
            zzg();
            ((zzsg) this.zza).zze = i;
            return this;
        }

        private zza() {
            super(zzsg.zzc);
        }
    }

    public static zzsg zzd() {
        return zzc;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    protected final Object zza(int i, Object obj, Object obj2) {
        switch (zzsf.zza[i - 1]) {
            case 1:
                return new zzsg();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                zzalw<zzsg> zzaVar = zzd;
                if (zzaVar == null) {
                    synchronized (zzsg.class) {
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
        zzsg zzsgVar = new zzsg();
        zzc = zzsgVar;
        zzakg.zza((Class<zzsg>) zzsg.class, zzsgVar);
    }

    private zzsg() {
    }
}
