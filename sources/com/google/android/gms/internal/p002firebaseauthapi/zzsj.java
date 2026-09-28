package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzsj extends zzakg<zzsj, zza> implements zzalp {
    private static final zzsj zzc;
    private static volatile zzalw<zzsj> zzd;
    private int zze;
    private int zzf;
    private zzsp zzg;
    private zzvb zzh;

    public final int zza() {
        return this.zzf;
    }

    public static zza zzb() {
        return zzc.zzm();
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static final class zza extends zzakg.zzb<zzsj, zza> implements zzalp {
        public final zza zza(zzsp zzspVar) {
            zzg();
            zzsj.zza((zzsj) this.zza, zzspVar);
            return this;
        }

        public final zza zza(zzvb zzvbVar) {
            zzg();
            zzsj.zza((zzsj) this.zza, zzvbVar);
            return this;
        }

        private zza() {
            super(zzsj.zzc);
        }
    }

    public static zzsj zza(zzaiw zzaiwVar, zzajv zzajvVar) throws zzakm {
        return (zzsj) zzakg.zza(zzc, zzaiwVar, zzajvVar);
    }

    public final zzsp zzd() {
        zzsp zzspVar = this.zzg;
        return zzspVar == null ? zzsp.zzd() : zzspVar;
    }

    public final zzvb zze() {
        zzvb zzvbVar = this.zzh;
        return zzvbVar == null ? zzvb.zzd() : zzvbVar;
    }

    public static zzalw<zzsj> zzf() {
        return (zzalw) zzc.zza(zzakg.zze.zzg, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    protected final Object zza(int i, Object obj, Object obj2) {
        switch (zzsi.zza[i - 1]) {
            case 1:
                return new zzsj();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzalw<zzsj> zzaVar = zzd;
                if (zzaVar == null) {
                    synchronized (zzsj.class) {
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

    static /* synthetic */ void zza(zzsj zzsjVar, zzsp zzspVar) {
        zzspVar.getClass();
        zzsjVar.zzg = zzspVar;
        zzsjVar.zze |= 1;
    }

    static /* synthetic */ void zza(zzsj zzsjVar, zzvb zzvbVar) {
        zzvbVar.getClass();
        zzsjVar.zzh = zzvbVar;
        zzsjVar.zze |= 2;
    }

    static {
        zzsj zzsjVar = new zzsj();
        zzc = zzsjVar;
        zzakg.zza((Class<zzsj>) zzsj.class, zzsjVar);
    }

    private zzsj() {
    }
}
