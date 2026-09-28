package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzte extends zzakg<zzte, zza> implements zzalp {
    private static final zzte zzc;
    private static volatile zzalw<zzte> zzd;
    private int zze;

    public final int zza() {
        return this.zze;
    }

    public static zza zzb() {
        return zzc.zzm();
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static final class zza extends zzakg.zzb<zzte, zza> implements zzalp {
        public final zza zza(int i) {
            zzg();
            ((zzte) this.zza).zze = i;
            return this;
        }

        private zza() {
            super(zzte.zzc);
        }
    }

    public static zzte zzd() {
        return zzc;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    protected final Object zza(int i, Object obj, Object obj2) {
        switch (zztd.zza[i - 1]) {
            case 1:
                return new zzte();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                zzalw<zzte> zzaVar = zzd;
                if (zzaVar == null) {
                    synchronized (zzte.class) {
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
        zzte zzteVar = new zzte();
        zzc = zzteVar;
        zzakg.zza((Class<zzte>) zzte.class, zzteVar);
    }

    private zzte() {
    }
}
