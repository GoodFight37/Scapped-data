package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zztt extends zzakg<zztt, zza> implements zzalp {
    private static final zztt zzc;
    private static volatile zzalw<zztt> zzd;
    private int zze;
    private zzaiw zzf = zzaiw.zza;

    public final int zza() {
        return this.zze;
    }

    public static zza zzb() {
        return zzc.zzm();
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static final class zza extends zzakg.zzb<zztt, zza> implements zzalp {
        public final zza zza(zzaiw zzaiwVar) {
            zzg();
            zztt.zza((zztt) this.zza, zzaiwVar);
            return this;
        }

        private zza() {
            super(zztt.zzc);
        }
    }

    public static zztt zza(zzaiw zzaiwVar, zzajv zzajvVar) throws zzakm {
        return (zztt) zzakg.zza(zzc, zzaiwVar, zzajvVar);
    }

    public final zzaiw zzd() {
        return this.zzf;
    }

    public static zzalw<zztt> zze() {
        return (zzalw) zzc.zza(zzakg.zze.zzg, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    protected final Object zza(int i, Object obj, Object obj2) {
        switch (zzts.zza[i - 1]) {
            case 1:
                return new zztt();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzalw<zztt> zzaVar = zzd;
                if (zzaVar == null) {
                    synchronized (zztt.class) {
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

    static /* synthetic */ void zza(zztt zzttVar, zzaiw zzaiwVar) {
        zzaiwVar.getClass();
        zzttVar.zzf = zzaiwVar;
    }

    static {
        zztt zzttVar = new zztt();
        zzc = zzttVar;
        zzakg.zza((Class<zztt>) zztt.class, zzttVar);
    }

    private zztt() {
    }
}
