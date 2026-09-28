package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzuh extends zzakg<zzuh, zza> implements zzalp {
    private static final zzuh zzc;
    private static volatile zzalw<zzuh> zzd;
    private int zze;
    private zzuk zzf;

    public static zza zza() {
        return zzc.zzm();
    }

    public static zzuh zza(zzaiw zzaiwVar, zzajv zzajvVar) throws zzakm {
        return (zzuh) zzakg.zza(zzc, zzaiwVar, zzajvVar);
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static final class zza extends zzakg.zzb<zzuh, zza> implements zzalp {
        public final zza zza(zzuk zzukVar) {
            zzg();
            zzuh.zza((zzuh) this.zza, zzukVar);
            return this;
        }

        private zza() {
            super(zzuh.zzc);
        }
    }

    public final zzuk zzc() {
        zzuk zzukVar = this.zzf;
        return zzukVar == null ? zzuk.zze() : zzukVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    protected final Object zza(int i, Object obj, Object obj2) {
        switch (zzuj.zza[i - 1]) {
            case 1:
                return new zzuh();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzalw<zzuh> zzaVar = zzd;
                if (zzaVar == null) {
                    synchronized (zzuh.class) {
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

    static /* synthetic */ void zza(zzuh zzuhVar, zzuk zzukVar) {
        zzukVar.getClass();
        zzuhVar.zzf = zzukVar;
        zzuhVar.zze |= 1;
    }

    static {
        zzuh zzuhVar = new zzuh();
        zzc = zzuhVar;
        zzakg.zza((Class<zzuh>) zzuh.class, zzuhVar);
    }

    private zzuh() {
    }
}
