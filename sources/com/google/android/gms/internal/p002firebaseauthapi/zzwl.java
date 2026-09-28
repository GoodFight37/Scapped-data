package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzwl extends zzakg<zzwl, zzb> implements zzalp {
    private static final zzwl zzc;
    private static volatile zzalw<zzwl> zzd;
    private int zze;
    private zzakn<zza> zzf = zzp();

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static final class zza extends zzakg<zza, C0005zza> implements zzalp {
        private static final zza zzc;
        private static volatile zzalw<zza> zzd;
        private int zze;
        private zzwb zzf;
        private int zzg;
        private int zzh;
        private int zzi;

        public final int zza() {
            return this.zzh;
        }

        public final zzwb zzb() {
            zzwb zzwbVar = this.zzf;
            return zzwbVar == null ? zzwb.zzd() : zzwbVar;
        }

        /* JADX INFO: renamed from: com.google.android.gms.internal.firebase-auth-api.zzwl$zza$zza, reason: collision with other inner class name */
        /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
        public static final class C0005zza extends zzakg.zzb<zza, C0005zza> implements zzalp {
            public final C0005zza zza(zzwb.zzb zzbVar) {
                zzg();
                zza.zza((zza) this.zza, (zzwb) ((zzakg) zzbVar.zze()));
                return this;
            }

            public final C0005zza zza(zzwb zzwbVar) {
                zzg();
                zza.zza((zza) this.zza, zzwbVar);
                return this;
            }

            public final C0005zza zza(int i) {
                zzg();
                ((zza) this.zza).zzh = i;
                return this;
            }

            public final C0005zza zza(zzxd zzxdVar) {
                zzg();
                zza.zza((zza) this.zza, zzxdVar);
                return this;
            }

            public final C0005zza zza(zzwc zzwcVar) {
                zzg();
                zza.zza((zza) this.zza, zzwcVar);
                return this;
            }

            private C0005zza() {
                super(zza.zzc);
            }
        }

        public final zzwc zzc() {
            zzwc zzwcVarZza = zzwc.zza(this.zzg);
            return zzwcVarZza == null ? zzwc.UNRECOGNIZED : zzwcVarZza;
        }

        public static C0005zza zzd() {
            return zzc.zzm();
        }

        public final zzxd zzf() {
            zzxd zzxdVarZza = zzxd.zza(this.zzi);
            return zzxdVarZza == null ? zzxd.UNRECOGNIZED : zzxdVarZza;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
        protected final Object zza(int i, Object obj, Object obj2) {
            switch (zzwk.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0005zza();
                case 3:
                    return zza(zzc, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f\u0003\u000b\u0004\f", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
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

        static /* synthetic */ void zza(zza zzaVar, zzwb zzwbVar) {
            zzwbVar.getClass();
            zzaVar.zzf = zzwbVar;
            zzaVar.zze |= 1;
        }

        static /* synthetic */ void zza(zza zzaVar, zzxd zzxdVar) {
            zzaVar.zzi = zzxdVar.zza();
        }

        static /* synthetic */ void zza(zza zzaVar, zzwc zzwcVar) {
            zzaVar.zzg = zzwcVar.zza();
        }

        static {
            zza zzaVar = new zza();
            zzc = zzaVar;
            zzakg.zza((Class<zza>) zza.class, zzaVar);
        }

        private zza() {
        }

        public final boolean zzg() {
            return (this.zze & 1) != 0;
        }
    }

    public final int zza() {
        return this.zzf.size();
    }

    public final int zzb() {
        return this.zze;
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static final class zzb extends zzakg.zzb<zzwl, zzb> implements zzalp {
        public final zzb zza(zza zzaVar) {
            zzg();
            zzwl.zza((zzwl) this.zza, zzaVar);
            return this;
        }

        public final zzb zza(int i) {
            zzg();
            ((zzwl) this.zza).zze = i;
            return this;
        }

        private zzb() {
            super(zzwl.zzc);
        }
    }

    public static zzb zzc() {
        return zzc.zzm();
    }

    public final zza zza(int i) {
        return this.zzf.get(i);
    }

    public static zzwl zza(InputStream inputStream, zzajv zzajvVar) throws IOException {
        return (zzwl) zzakg.zza(zzc, inputStream, zzajvVar);
    }

    public static zzwl zza(byte[] bArr, zzajv zzajvVar) throws zzakm {
        return (zzwl) zzakg.zza(zzc, bArr, zzajvVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    protected final Object zza(int i, Object obj, Object obj2) {
        switch (zzwk.zza[i - 1]) {
            case 1:
                return new zzwl();
            case 2:
                return new zzb();
            case 3:
                return zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zze", "zzf", zza.class});
            case 4:
                return zzc;
            case 5:
                zzalw<zzwl> zzaVar = zzd;
                if (zzaVar == null) {
                    synchronized (zzwl.class) {
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

    public final List<zza> zze() {
        return this.zzf;
    }

    static /* synthetic */ void zza(zzwl zzwlVar, zza zzaVar) {
        zzaVar.getClass();
        zzakn<zza> zzaknVar = zzwlVar.zzf;
        if (!zzaknVar.zzc()) {
            zzwlVar.zzf = zzakg.zza(zzaknVar);
        }
        zzwlVar.zzf.add(zzaVar);
    }

    static {
        zzwl zzwlVar = new zzwl();
        zzc = zzwlVar;
        zzakg.zza((Class<zzwl>) zzwl.class, zzwlVar);
    }

    private zzwl() {
    }
}
