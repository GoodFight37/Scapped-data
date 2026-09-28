package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzxi extends zzakg<zzxi, zza> implements zzalp {
    private static final zzxi zzc;
    private static volatile zzalw<zzxi> zzd;
    private int zze;
    private int zzf;
    private zzxl zzg;

    public final int zza() {
        return this.zzf;
    }

    public static zza zzb() {
        return zzc.zzm();
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static final class zza extends zzakg.zzb<zzxi, zza> implements zzalp {
        public final zza zza(zzxl zzxlVar) {
            zzg();
            zzxi.zza((zzxi) this.zza, zzxlVar);
            return this;
        }

        private zza() {
            super(zzxi.zzc);
        }
    }

    public static zzxi zza(zzaiw zzaiwVar, zzajv zzajvVar) throws zzakm {
        return (zzxi) zzakg.zza(zzc, zzaiwVar, zzajvVar);
    }

    public final zzxl zzd() {
        zzxl zzxlVar = this.zzg;
        return zzxlVar == null ? zzxl.zzd() : zzxlVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    protected final Object zza(int i, Object obj, Object obj2) {
        switch (zzxk.zza[i - 1]) {
            case 1:
                return new zzxi();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0002\u0000\u0001\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003ဉ\u0000", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzalw<zzxi> zzaVar = zzd;
                if (zzaVar == null) {
                    synchronized (zzxi.class) {
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

    static /* synthetic */ void zza(zzxi zzxiVar, zzxl zzxlVar) {
        zzxlVar.getClass();
        zzxiVar.zzg = zzxlVar;
        zzxiVar.zze |= 1;
    }

    static {
        zzxi zzxiVar = new zzxi();
        zzc = zzxiVar;
        zzakg.zza((Class<zzxi>) zzxi.class, zzxiVar);
    }

    private zzxi() {
    }
}
