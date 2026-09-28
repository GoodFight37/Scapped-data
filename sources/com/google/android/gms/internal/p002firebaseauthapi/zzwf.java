package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzwf extends zzakg<zzwf, zza> implements zzalp {
    private static final zzwf zzc;
    private static volatile zzalw<zzwf> zzd;
    private String zze = "";
    private zzaiw zzf = zzaiw.zza;
    private int zzg;

    public static zza zza() {
        return zzc.zzm();
    }

    public static zza zza(zzwf zzwfVar) {
        return zzc.zzm().zza(zzwfVar);
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static final class zza extends zzakg.zzb<zzwf, zza> implements zzalp {
        public final zza zza(zzxd zzxdVar) {
            zzg();
            zzwf.zza((zzwf) this.zza, zzxdVar);
            return this;
        }

        public final zza zza(String str) {
            zzg();
            zzwf.zza((zzwf) this.zza, str);
            return this;
        }

        public final zza zza(zzaiw zzaiwVar) {
            zzg();
            zzwf.zza((zzwf) this.zza, zzaiwVar);
            return this;
        }

        private zza() {
            super(zzwf.zzc);
        }
    }

    public static zzwf zzc() {
        return zzc;
    }

    public static zzwf zza(byte[] bArr, zzajv zzajvVar) throws zzakm {
        return (zzwf) zzakg.zza(zzc, bArr, zzajvVar);
    }

    public final zzxd zzd() {
        zzxd zzxdVarZza = zzxd.zza(this.zzg);
        return zzxdVarZza == null ? zzxd.UNRECOGNIZED : zzxdVarZza;
    }

    public final zzaiw zze() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    protected final Object zza(int i, Object obj, Object obj2) {
        switch (zzwe.zza[i - 1]) {
            case 1:
                return new zzwf();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzalw<zzwf> zzaVar = zzd;
                if (zzaVar == null) {
                    synchronized (zzwf.class) {
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

    public final String zzf() {
        return this.zze;
    }

    static /* synthetic */ void zza(zzwf zzwfVar, zzxd zzxdVar) {
        zzwfVar.zzg = zzxdVar.zza();
    }

    static /* synthetic */ void zza(zzwf zzwfVar, String str) {
        str.getClass();
        zzwfVar.zze = str;
    }

    static /* synthetic */ void zza(zzwf zzwfVar, zzaiw zzaiwVar) {
        zzaiwVar.getClass();
        zzwfVar.zzf = zzaiwVar;
    }

    static {
        zzwf zzwfVar = new zzwf();
        zzc = zzwfVar;
        zzakg.zza((Class<zzwf>) zzwf.class, zzwfVar);
    }

    private zzwf() {
    }
}
