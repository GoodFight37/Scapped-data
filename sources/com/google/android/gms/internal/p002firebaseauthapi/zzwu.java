package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzwu extends zzakg<zzwu, zza> implements zzalp {
    private static final zzwu zzc;
    private static volatile zzalw<zzwu> zzd;
    private String zze = "";

    public static zza zza() {
        return zzc.zzm();
    }

    public static zzwu zzc() {
        return zzc;
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static final class zza extends zzakg.zzb<zzwu, zza> implements zzalp {
        public final zza zza(String str) {
            zzg();
            zzwu.zza((zzwu) this.zza, str);
            return this;
        }

        private zza() {
            super(zzwu.zzc);
        }
    }

    public static zzwu zza(zzaiw zzaiwVar, zzajv zzajvVar) throws zzakm {
        return (zzwu) zzakg.zza(zzc, zzaiwVar, zzajvVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    protected final Object zza(int i, Object obj, Object obj2) {
        switch (zzwt.zza[i - 1]) {
            case 1:
                return new zzwu();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                zzalw<zzwu> zzaVar = zzd;
                if (zzaVar == null) {
                    synchronized (zzwu.class) {
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

    public final String zzd() {
        return this.zze;
    }

    static /* synthetic */ void zza(zzwu zzwuVar, String str) {
        str.getClass();
        zzwuVar.zze = str;
    }

    static {
        zzwu zzwuVar = new zzwu();
        zzc = zzwuVar;
        zzakg.zza((Class<zzwu>) zzwu.class, zzwuVar);
    }

    private zzwu() {
    }
}
