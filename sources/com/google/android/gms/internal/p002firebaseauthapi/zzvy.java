package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzvy extends zzakg<zzvy, zza> implements zzalp {
    private static final zzvy zzc;
    private static volatile zzalw<zzvy> zzd;
    private int zze;
    private int zzf;
    private zzvs zzg;
    private zzaiw zzh = zzaiw.zza;

    public final int zza() {
        return this.zzf;
    }

    public final zzvs zzb() {
        zzvs zzvsVar = this.zzg;
        return zzvsVar == null ? zzvs.zzf() : zzvsVar;
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static final class zza extends zzakg.zzb<zzvy, zza> implements zzalp {
        public final zza zza(zzvs zzvsVar) {
            zzg();
            zzvy.zza((zzvy) this.zza, zzvsVar);
            return this;
        }

        public final zza zza(zzaiw zzaiwVar) {
            zzg();
            zzvy.zza((zzvy) this.zza, zzaiwVar);
            return this;
        }

        public final zza zza(int i) {
            zzg();
            ((zzvy) this.zza).zzf = 0;
            return this;
        }

        private zza() {
            super(zzvy.zzc);
        }
    }

    public static zza zzc() {
        return zzc.zzm();
    }

    public static zzvy zze() {
        return zzc;
    }

    public static zzvy zza(zzaiw zzaiwVar, zzajv zzajvVar) throws zzakm {
        return (zzvy) zzakg.zza(zzc, zzaiwVar, zzajvVar);
    }

    public final zzaiw zzf() {
        return this.zzh;
    }

    public static zzalw<zzvy> zzg() {
        return (zzalw) zzc.zza(zzakg.zze.zzg, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    protected final Object zza(int i, Object obj, Object obj2) {
        switch (zzvx.zza[i - 1]) {
            case 1:
                return new zzvy();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzalw<zzvy> zzaVar = zzd;
                if (zzaVar == null) {
                    synchronized (zzvy.class) {
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

    static /* synthetic */ void zza(zzvy zzvyVar, zzvs zzvsVar) {
        zzvsVar.getClass();
        zzvyVar.zzg = zzvsVar;
        zzvyVar.zze |= 1;
    }

    static /* synthetic */ void zza(zzvy zzvyVar, zzaiw zzaiwVar) {
        zzaiwVar.getClass();
        zzvyVar.zzh = zzaiwVar;
    }

    static {
        zzvy zzvyVar = new zzvy();
        zzc = zzvyVar;
        zzakg.zza((Class<zzvy>) zzvy.class, zzvyVar);
    }

    private zzvy() {
    }
}
