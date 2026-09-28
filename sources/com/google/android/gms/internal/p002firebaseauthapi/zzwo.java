package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzwo extends zzakg<zzwo, zzb> implements zzalp {
    private static final zzwo zzc;
    private static volatile zzalw<zzwo> zzd;
    private int zze;
    private zzakn<zza> zzf = zzp();

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static final class zza extends zzakg<zza, C0006zza> implements zzalp {
        private static final zza zzc;
        private static volatile zzalw<zza> zzd;
        private String zze = "";
        private int zzf;
        private int zzg;
        private int zzh;

        public static C0006zza zza() {
            return zzc.zzm();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        protected final Object zza(int i, Object obj, Object obj2) {
            switch (zzwn.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0006zza();
                case 3:
                    return zza(zzc, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzc;
                case 5:
                    zzalw<zza> zzaVar = zzd;
                    if (zzaVar == null) {
                        synchronized (zza.class) {
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

        /* JADX INFO: renamed from: com.google.android.gms.internal.firebase-auth-api.zzwo$zza$zza, reason: collision with other inner class name */
        /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
        public static final class C0006zza extends zzakg.zzb<zza, C0006zza> implements zzalp {
            public final C0006zza zza(int i) {
                zzg();
                ((zza) this.zza).zzg = i;
                return this;
            }

            public final C0006zza zza(zzxd zzxdVar) {
                zzg();
                zza.zza((zza) this.zza, zzxdVar);
                return this;
            }

            public final C0006zza zza(zzwc zzwcVar) {
                zzg();
                zza.zza((zza) this.zza, zzwcVar);
                return this;
            }

            public final C0006zza zza(String str) {
                zzg();
                zza.zza((zza) this.zza, str);
                return this;
            }

            private C0006zza() {
                super(zza.zzc);
            }
        }

        static /* synthetic */ void zza(zza zzaVar, zzxd zzxdVar) {
            zzaVar.zzh = zzxdVar.zza();
        }

        static /* synthetic */ void zza(zza zzaVar, zzwc zzwcVar) {
            zzaVar.zzf = zzwcVar.zza();
        }

        static /* synthetic */ void zza(zza zzaVar, String str) {
            str.getClass();
            zzaVar.zze = str;
        }

        static {
            zza zzaVar = new zza();
            zzc = zzaVar;
            zzakg.zza((Class<zza>) zza.class, zzaVar);
        }

        private zza() {
        }
    }

    public static zzb zza() {
        return zzc.zzm();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    protected final Object zza(int i, Object obj, Object obj2) {
        switch (zzwn.zza[i - 1]) {
            case 1:
                return new zzwo();
            case 2:
                return new zzb();
            case 3:
                return zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zze", "zzf", zza.class});
            case 4:
                return zzc;
            case 5:
                zzalw<zzwo> zzaVar = zzd;
                if (zzaVar == null) {
                    synchronized (zzwo.class) {
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

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static final class zzb extends zzakg.zzb<zzwo, zzb> implements zzalp {
        public final zzb zza(zza zzaVar) {
            zzg();
            zzwo.zza((zzwo) this.zza, zzaVar);
            return this;
        }

        public final zzb zza(int i) {
            zzg();
            ((zzwo) this.zza).zze = i;
            return this;
        }

        private zzb() {
            super(zzwo.zzc);
        }
    }

    static /* synthetic */ void zza(zzwo zzwoVar, zza zzaVar) {
        zzaVar.getClass();
        zzakn<zza> zzaknVar = zzwoVar.zzf;
        if (!zzaknVar.zzc()) {
            zzwoVar.zzf = zzakg.zza(zzaknVar);
        }
        zzwoVar.zzf.add(zzaVar);
    }

    static {
        zzwo zzwoVar = new zzwo();
        zzc = zzwoVar;
        zzakg.zza((Class<zzwo>) zzwo.class, zzwoVar);
    }

    private zzwo() {
    }
}
