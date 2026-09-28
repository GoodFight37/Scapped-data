package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zztn extends zzakg<zztn, zza> implements zzalp {
    private static final zztn zzc;
    private static volatile zzalw<zztn> zzd;
    private int zze;
    private zzaiw zzf = zzaiw.zza;

    public final int zza() {
        return this.zze;
    }

    public static zza zzb() {
        return zzc.zzm();
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static final class zza extends zzakg.zzb<zztn, zza> implements zzalp {
        public final zza zza(zzaiw zzaiwVar) {
            zzg();
            zztn.zza((zztn) this.zza, zzaiwVar);
            return this;
        }

        private zza() {
            super(zztn.zzc);
        }
    }

    public static zztn zza(zzaiw zzaiwVar, zzajv zzajvVar) throws zzakm {
        return (zztn) zzakg.zza(zzc, zzaiwVar, zzajvVar);
    }

    public final zzaiw zzd() {
        return this.zzf;
    }

    public static zzalw<zztn> zze() {
        return (zzalw) zzc.zza(zzakg.zze.zzg, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    protected final Object zza(int i, Object obj, Object obj2) {
        switch (zztm.zza[i - 1]) {
            case 1:
                return new zztn();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzalw<zztn> zzaVar = zzd;
                if (zzaVar == null) {
                    synchronized (zztn.class) {
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

    static /* synthetic */ void zza(zztn zztnVar, zzaiw zzaiwVar) {
        zzaiwVar.getClass();
        zztnVar.zzf = zzaiwVar;
    }

    static {
        zztn zztnVar = new zztn();
        zzc = zztnVar;
        zzakg.zza((Class<zztn>) zztn.class, zztnVar);
    }

    private zztn() {
    }
}
