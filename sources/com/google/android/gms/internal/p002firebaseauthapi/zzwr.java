package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzwr extends zzakg<zzwr, zza> implements zzalp {
    private static final zzwr zzc;
    private static volatile zzalw<zzwr> zzd;
    private int zze;
    private int zzf;
    private zzwu zzg;

    public final int zza() {
        return this.zzf;
    }

    public static zza zzb() {
        return zzc.zzm();
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static final class zza extends zzakg.zzb<zzwr, zza> implements zzalp {
        public final zza zza(zzwu zzwuVar) {
            zzg();
            zzwr.zza((zzwr) this.zza, zzwuVar);
            return this;
        }

        private zza() {
            super(zzwr.zzc);
        }
    }

    public static zzwr zza(zzaiw zzaiwVar, zzajv zzajvVar) throws zzakm {
        return (zzwr) zzakg.zza(zzc, zzaiwVar, zzajvVar);
    }

    public final zzwu zzd() {
        zzwu zzwuVar = this.zzg;
        return zzwuVar == null ? zzwu.zzc() : zzwuVar;
    }

    public static zzalw<zzwr> zze() {
        return (zzalw) zzc.zza(zzakg.zze.zzg, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    protected final Object zza(int i, Object obj, Object obj2) {
        switch (zzwq.zza[i - 1]) {
            case 1:
                return new zzwr();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzalw<zzwr> zzaVar = zzd;
                if (zzaVar == null) {
                    synchronized (zzwr.class) {
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

    static /* synthetic */ void zza(zzwr zzwrVar, zzwu zzwuVar) {
        zzwuVar.getClass();
        zzwrVar.zzg = zzwuVar;
        zzwrVar.zze |= 1;
    }

    static {
        zzwr zzwrVar = new zzwr();
        zzc = zzwrVar;
        zzakg.zza((Class<zzwr>) zzwr.class, zzwrVar);
    }

    private zzwr() {
    }
}
