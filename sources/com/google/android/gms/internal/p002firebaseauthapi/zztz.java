package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zztz extends zzakg<zztz, zza> implements zzalp {
    private static final zztz zzc;
    private static volatile zzalw<zztz> zzd;
    private int zze;
    private zzaiw zzf = zzaiw.zza;

    public final int zza() {
        return this.zze;
    }

    public static zza zzb() {
        return zzc.zzm();
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static final class zza extends zzakg.zzb<zztz, zza> implements zzalp {
        public final zza zza(zzaiw zzaiwVar) {
            zzg();
            zztz.zza((zztz) this.zza, zzaiwVar);
            return this;
        }

        private zza() {
            super(zztz.zzc);
        }
    }

    public static zztz zza(zzaiw zzaiwVar, zzajv zzajvVar) throws zzakm {
        return (zztz) zzakg.zza(zzc, zzaiwVar, zzajvVar);
    }

    public final zzaiw zzd() {
        return this.zzf;
    }

    public static zzalw<zztz> zze() {
        return (zzalw) zzc.zza(zzakg.zze.zzg, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    protected final Object zza(int i, Object obj, Object obj2) {
        switch (zzty.zza[i - 1]) {
            case 1:
                return new zztz();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzalw<zztz> zzaVar = zzd;
                if (zzaVar == null) {
                    synchronized (zztz.class) {
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

    static /* synthetic */ void zza(zztz zztzVar, zzaiw zzaiwVar) {
        zzaiwVar.getClass();
        zztzVar.zzf = zzaiwVar;
    }

    static {
        zztz zztzVar = new zztz();
        zzc = zztzVar;
        zzakg.zza((Class<zztz>) zztz.class, zztzVar);
    }

    private zztz() {
    }
}
