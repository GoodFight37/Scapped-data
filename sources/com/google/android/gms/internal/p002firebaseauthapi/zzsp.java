package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzsp extends zzakg<zzsp, zza> implements zzalp {
    private static final zzsp zzc;
    private static volatile zzalw<zzsp> zzd;
    private int zze;
    private int zzf;
    private zzsv zzg;
    private zzaiw zzh = zzaiw.zza;

    public final int zza() {
        return this.zzf;
    }

    public static zza zzb() {
        return zzc.zzm();
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static final class zza extends zzakg.zzb<zzsp, zza> implements zzalp {
        public final zza zza(zzaiw zzaiwVar) {
            zzg();
            zzsp.zza((zzsp) this.zza, zzaiwVar);
            return this;
        }

        public final zza zza(zzsv zzsvVar) {
            zzg();
            zzsp.zza((zzsp) this.zza, zzsvVar);
            return this;
        }

        private zza() {
            super(zzsp.zzc);
        }
    }

    public static zzsp zzd() {
        return zzc;
    }

    public final zzsv zze() {
        zzsv zzsvVar = this.zzg;
        return zzsvVar == null ? zzsv.zzd() : zzsvVar;
    }

    public final zzaiw zzf() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    protected final Object zza(int i, Object obj, Object obj2) {
        switch (zzso.zza[i - 1]) {
            case 1:
                return new zzsp();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzalw<zzsp> zzaVar = zzd;
                if (zzaVar == null) {
                    synchronized (zzsp.class) {
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

    static /* synthetic */ void zza(zzsp zzspVar, zzaiw zzaiwVar) {
        zzaiwVar.getClass();
        zzspVar.zzh = zzaiwVar;
    }

    static /* synthetic */ void zza(zzsp zzspVar, zzsv zzsvVar) {
        zzsvVar.getClass();
        zzspVar.zzg = zzsvVar;
        zzspVar.zze |= 1;
    }

    static {
        zzsp zzspVar = new zzsp();
        zzc = zzspVar;
        zzakg.zza((Class<zzsp>) zzsp.class, zzspVar);
    }

    private zzsp() {
    }
}
