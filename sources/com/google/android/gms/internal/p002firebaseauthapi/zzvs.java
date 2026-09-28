package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzvs extends zzakg<zzvs, zza> implements zzalp {
    private static final zzvs zzc;
    private static volatile zzalw<zzvs> zzd;
    private int zze;
    private int zzf;
    private int zzg;

    public final zzvk zza() {
        zzvk zzvkVarZza = zzvk.zza(this.zzg);
        return zzvkVarZza == null ? zzvk.UNRECOGNIZED : zzvkVarZza;
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static final class zza extends zzakg.zzb<zzvs, zza> implements zzalp {
        public final zza zza(zzvk zzvkVar) {
            zzg();
            zzvs.zza((zzvs) this.zza, zzvkVar);
            return this;
        }

        public final zza zza(zzvn zzvnVar) {
            zzg();
            zzvs.zza((zzvs) this.zza, zzvnVar);
            return this;
        }

        public final zza zza(zzvm zzvmVar) {
            zzg();
            zzvs.zza((zzvs) this.zza, zzvmVar);
            return this;
        }

        private zza() {
            super(zzvs.zzc);
        }
    }

    public final zzvn zzb() {
        zzvn zzvnVarZza = zzvn.zza(this.zzf);
        return zzvnVarZza == null ? zzvn.UNRECOGNIZED : zzvnVarZza;
    }

    public final zzvm zzc() {
        zzvm zzvmVarZza = zzvm.zza(this.zze);
        return zzvmVarZza == null ? zzvm.UNRECOGNIZED : zzvmVarZza;
    }

    public static zza zzd() {
        return zzc.zzm();
    }

    public static zzvs zzf() {
        return zzc;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    protected final Object zza(int i, Object obj, Object obj2) {
        switch (zzvr.zza[i - 1]) {
            case 1:
                return new zzvs();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u0003\f", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzalw<zzvs> zzaVar = zzd;
                if (zzaVar == null) {
                    synchronized (zzvs.class) {
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

    static /* synthetic */ void zza(zzvs zzvsVar, zzvk zzvkVar) {
        zzvsVar.zzg = zzvkVar.zza();
    }

    static /* synthetic */ void zza(zzvs zzvsVar, zzvn zzvnVar) {
        zzvsVar.zzf = zzvnVar.zza();
    }

    static /* synthetic */ void zza(zzvs zzvsVar, zzvm zzvmVar) {
        zzvsVar.zze = zzvmVar.zza();
    }

    static {
        zzvs zzvsVar = new zzvs();
        zzc = zzvsVar;
        zzakg.zza((Class<zzvs>) zzvs.class, zzvsVar);
    }

    private zzvs() {
    }
}
