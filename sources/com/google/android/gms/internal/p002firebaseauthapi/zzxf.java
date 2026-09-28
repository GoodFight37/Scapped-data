package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzxf extends zzakg<zzxf, zza> implements zzalp {
    private static final zzxf zzc;
    private static volatile zzalw<zzxf> zzd;
    private int zze;
    private int zzf;
    private zzxl zzg;
    private zzaiw zzh = zzaiw.zza;

    public final int zza() {
        return this.zzf;
    }

    public static zza zzb() {
        return zzc.zzm();
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static final class zza extends zzakg.zzb<zzxf, zza> implements zzalp {
        public final zza zza(zzaiw zzaiwVar) {
            zzg();
            zzxf.zza((zzxf) this.zza, zzaiwVar);
            return this;
        }

        public final zza zza(zzxl zzxlVar) {
            zzg();
            zzxf.zza((zzxf) this.zza, zzxlVar);
            return this;
        }

        private zza() {
            super(zzxf.zzc);
        }
    }

    public static zzxf zza(zzaiw zzaiwVar, zzajv zzajvVar) throws zzakm {
        return (zzxf) zzakg.zza(zzc, zzaiwVar, zzajvVar);
    }

    public final zzxl zzd() {
        zzxl zzxlVar = this.zzg;
        return zzxlVar == null ? zzxl.zzd() : zzxlVar;
    }

    public final zzaiw zze() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    protected final Object zza(int i, Object obj, Object obj2) {
        switch (zzxh.zza[i - 1]) {
            case 1:
                return new zzxf();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzalw<zzxf> zzaVar = zzd;
                if (zzaVar == null) {
                    synchronized (zzxf.class) {
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

    static /* synthetic */ void zza(zzxf zzxfVar, zzaiw zzaiwVar) {
        zzaiwVar.getClass();
        zzxfVar.zzh = zzaiwVar;
    }

    static /* synthetic */ void zza(zzxf zzxfVar, zzxl zzxlVar) {
        zzxlVar.getClass();
        zzxfVar.zzg = zzxlVar;
        zzxfVar.zze |= 1;
    }

    static {
        zzxf zzxfVar = new zzxf();
        zzc = zzxfVar;
        zzakg.zza((Class<zzxf>) zzxf.class, zzxfVar);
    }

    private zzxf() {
    }
}
