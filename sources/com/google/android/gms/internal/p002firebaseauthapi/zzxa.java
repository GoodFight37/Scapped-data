package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzxa extends zzakg<zzxa, zza> implements zzalp {
    private static final zzxa zzc;
    private static volatile zzalw<zzxa> zzd;
    private int zze;
    private String zzf = "";
    private zzwf zzg;

    public final zzwf zza() {
        zzwf zzwfVar = this.zzg;
        return zzwfVar == null ? zzwf.zzc() : zzwfVar;
    }

    public static zza zzb() {
        return zzc.zzm();
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static final class zza extends zzakg.zzb<zzxa, zza> implements zzalp {
        public final zza zza(zzwf zzwfVar) {
            zzg();
            zzxa.zza((zzxa) this.zza, zzwfVar);
            return this;
        }

        public final zza zza(String str) {
            zzg();
            zzxa.zza((zzxa) this.zza, str);
            return this;
        }

        private zza() {
            super(zzxa.zzc);
        }
    }

    public static zzxa zzd() {
        return zzc;
    }

    public static zzxa zza(zzaiw zzaiwVar, zzajv zzajvVar) throws zzakm {
        return (zzxa) zzakg.zza(zzc, zzaiwVar, zzajvVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    protected final Object zza(int i, Object obj, Object obj2) {
        switch (zzwz.zza[i - 1]) {
            case 1:
                return new zzxa();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzalw<zzxa> zzaVar = zzd;
                if (zzaVar == null) {
                    synchronized (zzxa.class) {
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

    public final String zze() {
        return this.zzf;
    }

    static /* synthetic */ void zza(zzxa zzxaVar, zzwf zzwfVar) {
        zzwfVar.getClass();
        zzxaVar.zzg = zzwfVar;
        zzxaVar.zze |= 1;
    }

    static /* synthetic */ void zza(zzxa zzxaVar, String str) {
        str.getClass();
        zzxaVar.zzf = str;
    }

    static {
        zzxa zzxaVar = new zzxa();
        zzc = zzxaVar;
        zzakg.zza((Class<zzxa>) zzxa.class, zzxaVar);
    }

    private zzxa() {
    }
}
