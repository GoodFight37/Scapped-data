package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzss extends zzakg<zzss, zza> implements zzalp {
    private static final zzss zzc;
    private static volatile zzalw<zzss> zzd;
    private int zze;
    private zzsv zzf;
    private int zzg;

    public final int zza() {
        return this.zzg;
    }

    public static zza zzb() {
        return zzc.zzm();
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static final class zza extends zzakg.zzb<zzss, zza> implements zzalp {
        public final zza zza(int i) {
            zzg();
            ((zzss) this.zza).zzg = i;
            return this;
        }

        public final zza zza(zzsv zzsvVar) {
            zzg();
            zzss.zza((zzss) this.zza, zzsvVar);
            return this;
        }

        private zza() {
            super(zzss.zzc);
        }
    }

    public static zzss zzd() {
        return zzc;
    }

    public final zzsv zze() {
        zzsv zzsvVar = this.zzf;
        return zzsvVar == null ? zzsv.zzd() : zzsvVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    protected final Object zza(int i, Object obj, Object obj2) {
        switch (zzsr.zza[i - 1]) {
            case 1:
                return new zzss();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzalw<zzss> zzaVar = zzd;
                if (zzaVar == null) {
                    synchronized (zzss.class) {
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

    static /* synthetic */ void zza(zzss zzssVar, zzsv zzsvVar) {
        zzsvVar.getClass();
        zzssVar.zzf = zzsvVar;
        zzssVar.zze |= 1;
    }

    static {
        zzss zzssVar = new zzss();
        zzc = zzssVar;
        zzakg.zza((Class<zzss>) zzss.class, zzssVar);
    }

    private zzss() {
    }
}
