package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzuz extends zzakg<zzuz, zza> implements zzalp {
    private static final zzuz zzc;
    private static volatile zzalw<zzuz> zzd;
    private int zze;
    private zzaiw zzf = zzaiw.zza;
    private zzwo zzg;

    public static zza zza() {
        return zzc.zzm();
    }

    public static zzuz zza(InputStream inputStream, zzajv zzajvVar) throws IOException {
        return (zzuz) zzakg.zza(zzc, inputStream, zzajvVar);
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static final class zza extends zzakg.zzb<zzuz, zza> implements zzalp {
        public final zza zza() {
            zzg();
            zzuz.zza((zzuz) this.zza);
            return this;
        }

        public final zza zza(zzaiw zzaiwVar) {
            zzg();
            zzuz.zza((zzuz) this.zza, zzaiwVar);
            return this;
        }

        public final zza zza(zzwo zzwoVar) {
            zzg();
            zzuz.zza((zzuz) this.zza, zzwoVar);
            return this;
        }

        private zza() {
            super(zzuz.zzc);
        }
    }

    public final zzaiw zzc() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakg
    protected final Object zza(int i, Object obj, Object obj2) {
        switch (zzuy.zza[i - 1]) {
            case 1:
                return new zzuz();
            case 2:
                return new zza();
            case 3:
                return zza(zzc, "\u0000\u0002\u0000\u0001\u0002\u0003\u0002\u0000\u0000\u0000\u0002\n\u0003ဉ\u0000", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzalw<zzuz> zzaVar = zzd;
                if (zzaVar == null) {
                    synchronized (zzuz.class) {
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

    static /* synthetic */ void zza(zzuz zzuzVar) {
        zzuzVar.zzg = null;
        zzuzVar.zze &= -2;
    }

    static /* synthetic */ void zza(zzuz zzuzVar, zzaiw zzaiwVar) {
        zzaiwVar.getClass();
        zzuzVar.zzf = zzaiwVar;
    }

    static /* synthetic */ void zza(zzuz zzuzVar, zzwo zzwoVar) {
        zzwoVar.getClass();
        zzuzVar.zzg = zzwoVar;
        zzuzVar.zze |= 1;
    }

    static {
        zzuz zzuzVar = new zzuz();
        zzc = zzuzVar;
        zzakg.zza((Class<zzuz>) zzuz.class, zzuzVar);
    }

    private zzuz() {
    }
}
