package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class zzwi extends zzakg<zzwi, zza> implements zzalp {
    private static final zzwi zzc;
    private static volatile zzalw<zzwi> zzd;
    private int zzg;
    private boolean zzh;
    private String zze = "";
    private String zzf = "";
    private String zzi = "";

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static final class zza extends zzakg.zzb<zzwi, zza> implements zzalp {
        private zza() {
            super(zzwi.zzc);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    protected final Object zza(int i, Object obj, Object obj2) {
        switch (zzwh.zza[i - 1]) {
            case 1:
                return new zzwi();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u0007\u0005Ȉ", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
            case 4:
                return zzc;
            case 5:
                zzalw<zzwi> zzaVar = zzd;
                if (zzaVar == null) {
                    synchronized (zzwi.class) {
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
        zzwi zzwiVar = new zzwi();
        zzc = zzwiVar;
        zzakg.zza((Class<zzwi>) zzwi.class, zzwiVar);
    }

    private zzwi() {
    }
}
