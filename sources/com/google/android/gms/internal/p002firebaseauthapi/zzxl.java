package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzxl extends zzakg<zzxl, zza> implements zzalp {
    private static final zzxl zzc;
    private static volatile zzalw<zzxl> zzd;
    private int zze;

    public final int zza() {
        return this.zze;
    }

    public static zza zzb() {
        return zzc.zzm();
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static final class zza extends zzakg.zzb<zzxl, zza> implements zzalp {
        public final zza zza(int i) {
            zzg();
            ((zzxl) this.zza).zze = i;
            return this;
        }

        private zza() {
            super(zzxl.zzc);
        }
    }

    public static zzxl zzd() {
        return zzc;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    protected final Object zza(int i, Object obj, Object obj2) {
        switch (zzxn.zza[i - 1]) {
            case 1:
                return new zzxl();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                zzalw<zzxl> zzaVar = zzd;
                if (zzaVar == null) {
                    synchronized (zzxl.class) {
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
        zzxl zzxlVar = new zzxl();
        zzc = zzxlVar;
        zzakg.zza((Class<zzxl>) zzxl.class, zzxlVar);
    }

    private zzxl() {
    }
}
