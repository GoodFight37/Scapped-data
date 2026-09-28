package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzuq extends zzakg<zzuq, zza> implements zzalp {
    private static final zzuq zzc;
    private static volatile zzalw<zzuq> zzd;
    private int zze;
    private int zzf;
    private zzuk zzg;
    private zzaiw zzh = zzaiw.zza;
    private zzaiw zzi = zzaiw.zza;

    public final int zza() {
        return this.zzf;
    }

    public final zzuk zzb() {
        zzuk zzukVar = this.zzg;
        return zzukVar == null ? zzuk.zze() : zzukVar;
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static final class zza extends zzakg.zzb<zzuq, zza> implements zzalp {
        public final zza zza(zzuk zzukVar) {
            zzg();
            zzuq.zza((zzuq) this.zza, zzukVar);
            return this;
        }

        public final zza zza(int i) {
            zzg();
            ((zzuq) this.zza).zzf = 0;
            return this;
        }

        public final zza zza(zzaiw zzaiwVar) {
            zzg();
            zzuq.zza((zzuq) this.zza, zzaiwVar);
            return this;
        }

        public final zza zzb(zzaiw zzaiwVar) {
            zzg();
            zzuq.zzb((zzuq) this.zza, zzaiwVar);
            return this;
        }

        private zza() {
            super(zzuq.zzc);
        }
    }

    public static zza zzc() {
        return zzc.zzm();
    }

    public static zzuq zze() {
        return zzc;
    }

    public static zzuq zza(zzaiw zzaiwVar, zzajv zzajvVar) throws zzakm {
        return (zzuq) zzakg.zza(zzc, zzaiwVar, zzajvVar);
    }

    public final zzaiw zzf() {
        return this.zzh;
    }

    public final zzaiw zzg() {
        return this.zzi;
    }

    public static zzalw<zzuq> zzh() {
        return (zzalw) zzc.zza(zzakg.zze.zzg, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    protected final Object zza(int i, Object obj, Object obj2) {
        switch (zzus.zza[i - 1]) {
            case 1:
                return new zzuq();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n\u0004\n", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
            case 4:
                return zzc;
            case 5:
                zzalw<zzuq> zzaVar = zzd;
                if (zzaVar == null) {
                    synchronized (zzuq.class) {
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

    static /* synthetic */ void zza(zzuq zzuqVar, zzuk zzukVar) {
        zzukVar.getClass();
        zzuqVar.zzg = zzukVar;
        zzuqVar.zze |= 1;
    }

    static /* synthetic */ void zza(zzuq zzuqVar, zzaiw zzaiwVar) {
        zzaiwVar.getClass();
        zzuqVar.zzh = zzaiwVar;
    }

    static /* synthetic */ void zzb(zzuq zzuqVar, zzaiw zzaiwVar) {
        zzaiwVar.getClass();
        zzuqVar.zzi = zzaiwVar;
    }

    static {
        zzuq zzuqVar = new zzuq();
        zzc = zzuqVar;
        zzakg.zza((Class<zzuq>) zzuq.class, zzuqVar);
    }

    private zzuq() {
    }
}
