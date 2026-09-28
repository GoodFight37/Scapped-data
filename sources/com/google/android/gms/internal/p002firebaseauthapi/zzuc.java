package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzuc extends zzakg<zzuc, zza> implements zzalp {
    private static final zzuc zzc;
    private static volatile zzalw<zzuc> zzd;

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static final class zza extends zzakg.zzb<zzuc, zza> implements zzalp {
        private zza() {
            super(zzuc.zzc);
        }
    }

    public static zzuc zzb() {
        return zzc;
    }

    public static zzuc zza(zzaiw zzaiwVar, zzajv zzajvVar) throws zzakm {
        return (zzuc) zzakg.zza(zzc, zzaiwVar, zzajvVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    protected final Object zza(int i, Object obj, Object obj2) {
        switch (zzub.zza[i - 1]) {
            case 1:
                return new zzuc();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0000", (Object[]) null);
            case 4:
                return zzc;
            case 5:
                zzalw<zzuc> zzaVar = zzd;
                if (zzaVar == null) {
                    synchronized (zzuc.class) {
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
        zzuc zzucVar = new zzuc();
        zzc = zzucVar;
        zzakg.zza((Class<zzuc>) zzuc.class, zzucVar);
    }

    private zzuc() {
    }
}
