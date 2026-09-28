package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzxr extends zzakg<zzxr, zza> implements zzalp {
    private static final zzxr zzc;
    private static volatile zzalw<zzxr> zzd;
    private int zze;

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static final class zza extends zzakg.zzb<zzxr, zza> implements zzalp {
        private zza() {
            super(zzxr.zzc);
        }
    }

    public final int zza() {
        return this.zze;
    }

    public static zzxr zzc() {
        return zzc;
    }

    public static zzxr zza(zzaiw zzaiwVar, zzajv zzajvVar) throws zzakm {
        return (zzxr) zzakg.zza(zzc, zzaiwVar, zzajvVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    protected final Object zza(int i, Object obj, Object obj2) {
        switch (zzxt.zza[i - 1]) {
            case 1:
                return new zzxr();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                zzalw<zzxr> zzaVar = zzd;
                if (zzaVar == null) {
                    synchronized (zzxr.class) {
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
        zzxr zzxrVar = new zzxr();
        zzc = zzxrVar;
        zzakg.zza((Class<zzxr>) zzxr.class, zzxrVar);
    }

    private zzxr() {
    }
}
