package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzalt<T> implements zzamc<T> {
    private final zzaln zza;
    private final zzamv<?, ?> zzb;
    private final boolean zzc;
    private final zzajx<?> zzd;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamc
    public final int zza(T t) {
        zzamv<?, ?> zzamvVar = this.zzb;
        int iZzb = zzamvVar.zzb(zzamvVar.zzd(t));
        return this.zzc ? iZzb + this.zzd.zza(t).zza() : iZzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamc
    public final int zzb(T t) {
        int iHashCode = this.zzb.zzd(t).hashCode();
        return this.zzc ? (iHashCode * 53) + this.zzd.zza(t).hashCode() : iHashCode;
    }

    static <T> zzalt<T> zza(zzamv<?, ?> zzamvVar, zzajx<?> zzajxVar, zzaln zzalnVar) {
        return new zzalt<>(zzamvVar, zzajxVar, zzalnVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamc
    public final T zza() {
        zzaln zzalnVar = this.zza;
        if (zzalnVar instanceof zzakg) {
            return (T) ((zzakg) zzalnVar).zzo();
        }
        return (T) zzalnVar.zzq().zzf();
    }

    private zzalt(zzamv<?, ?> zzamvVar, zzajx<?> zzajxVar, zzaln zzalnVar) {
        this.zzb = zzamvVar;
        this.zzc = zzajxVar.zza(zzalnVar);
        this.zzd = zzajxVar;
        this.zza = zzalnVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamc
    public final void zzd(T t) {
        this.zzb.zzf(t);
        this.zzd.zzc(t);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamc
    public final void zza(T t, T t2) {
        zzame.zza(this.zzb, t, t2);
        if (this.zzc) {
            zzame.zza(this.zzd, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamc
    public final void zza(T t, zzamd zzamdVar, zzajv zzajvVar) throws IOException {
        boolean zZzt;
        zzamv<?, ?> zzamvVar = this.zzb;
        zzajx<?> zzajxVar = this.zzd;
        Object objZzc = zzamvVar.zzc(t);
        zzajy<T> zzajyVarZzb = zzajxVar.zzb(t);
        while (zzamdVar.zzc() != Integer.MAX_VALUE) {
            try {
                int iZzd = zzamdVar.zzd();
                int iZzj = 0;
                if (iZzd != 11) {
                    if ((iZzd & 7) == 2) {
                        Object objZza = zzajxVar.zza(zzajvVar, this.zza, iZzd >>> 3);
                        if (objZza != null) {
                            zzajxVar.zza(zzamdVar, objZza, zzajvVar, zzajyVarZzb);
                        } else {
                            zZzt = zzamvVar.zza(objZzc, zzamdVar, 0);
                        }
                    } else {
                        zZzt = zzamdVar.zzt();
                    }
                    if (!zZzt) {
                        zzamvVar.zzb(t, objZzc);
                        return;
                    }
                } else {
                    Object objZza2 = null;
                    zzaiw zzaiwVarZzp = null;
                    while (zzamdVar.zzc() != Integer.MAX_VALUE) {
                        int iZzd2 = zzamdVar.zzd();
                        if (iZzd2 == 16) {
                            iZzj = zzamdVar.zzj();
                            objZza2 = zzajxVar.zza(zzajvVar, this.zza, iZzj);
                        } else if (iZzd2 == 26) {
                            if (objZza2 != null) {
                                zzajxVar.zza(zzamdVar, objZza2, zzajvVar, zzajyVarZzb);
                            } else {
                                zzaiwVarZzp = zzamdVar.zzp();
                            }
                        } else if (iZzd2 == 12 || !zzamdVar.zzt()) {
                            break;
                        }
                    }
                    if (zzamdVar.zzd() != 12) {
                        throw zzakm.zzb();
                    }
                    if (zzaiwVarZzp != null) {
                        if (objZza2 != null) {
                            zzajxVar.zza(zzaiwVarZzp, objZza2, zzajvVar, zzajyVarZzb);
                        } else {
                            zzamvVar.zza(objZzc, iZzj, zzaiwVarZzp);
                        }
                    }
                }
            } catch (Throwable th) {
                zzamvVar.zzb(t, objZzc);
                throw th;
            }
        }
        zzamvVar.zzb(t, objZzc);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0094  */
    /* JADX WARN: Code duplicated, block: B:56:0x0099 A[EDGE_INSN: B:56:0x0099->B:34:0x0099 BREAK  A[LOOP:1: B:18:0x0053->B:61:0x0053], SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamc
    public final void zza(T t, byte[] bArr, int i, int i2, zzaiv zzaivVar) throws IOException {
        zzakg zzakgVar = (zzakg) t;
        zzamy zzamyVarZzd = zzakgVar.zzb;
        if (zzamyVarZzd == zzamy.zzc()) {
            zzamyVarZzd = zzamy.zzd();
            zzakgVar.zzb = zzamyVarZzd;
        }
        ((zzakg.zzd) t).zza();
        zzakg.zzf zzfVar = null;
        while (i < i2) {
            int iZzc = zzais.zzc(bArr, i, zzaivVar);
            int i3 = zzaivVar.zza;
            if (i3 == 11) {
                int i4 = 0;
                zzaiw zzaiwVar = null;
                while (iZzc < i2) {
                    iZzc = zzais.zzc(bArr, iZzc, zzaivVar);
                    int i5 = zzaivVar.zza;
                    int i6 = i5 >>> 3;
                    int i7 = i5 & 7;
                    if (i6 == 2) {
                        if (i7 != 0) {
                            if (i5 != 12) {
                                break;
                                break;
                            }
                            iZzc = zzais.zza(i5, bArr, iZzc, i2, zzaivVar);
                        } else {
                            iZzc = zzais.zzc(bArr, iZzc, zzaivVar);
                            i4 = zzaivVar.zza;
                            zzfVar = (zzakg.zzf) this.zzd.zza(zzaivVar.zzd, this.zza, i4);
                        }
                    } else {
                        if (i6 == 3) {
                            if (zzfVar != null) {
                                zzaly.zza();
                                throw new NoSuchMethodError();
                            }
                            if (i7 == 2) {
                                iZzc = zzais.zza(bArr, iZzc, zzaivVar);
                                zzaiwVar = (zzaiw) zzaivVar.zzc;
                            }
                        }
                        if (i5 != 12) {
                            break;
                        } else {
                            iZzc = zzais.zza(i5, bArr, iZzc, i2, zzaivVar);
                        }
                    }
                }
                if (zzaiwVar != null) {
                    zzamyVarZzd.zza((i4 << 3) | 2, zzaiwVar);
                }
                i = iZzc;
            } else if ((i3 & 7) == 2) {
                zzfVar = (zzakg.zzf) this.zzd.zza(zzaivVar.zzd, this.zza, i3 >>> 3);
                if (zzfVar != null) {
                    zzaly.zza();
                    throw new NoSuchMethodError();
                }
                i = zzais.zza(i3, bArr, iZzc, i2, zzamyVarZzd, zzaivVar);
            } else {
                i = zzais.zza(i3, bArr, iZzc, i2, zzaivVar);
            }
        }
        if (i != i2) {
            throw zzakm.zzg();
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamc
    public final void zza(T t, zzanm zzanmVar) throws IOException {
        Iterator itZzd = this.zzd.zza(t).zzd();
        while (itZzd.hasNext()) {
            Map.Entry entry = (Map.Entry) itZzd.next();
            zzaka zzakaVar = (zzaka) entry.getKey();
            if (zzakaVar.zzc() != zzank.MESSAGE || zzakaVar.zze() || zzakaVar.zzd()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof zzakq) {
                zzanmVar.zza(zzakaVar.zza(), (Object) ((zzakq) entry).zza().zzb());
            } else {
                zzanmVar.zza(zzakaVar.zza(), entry.getValue());
            }
        }
        zzamv<?, ?> zzamvVar = this.zzb;
        zzamvVar.zza(zzamvVar.zzd(t), zzanmVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamc
    public final boolean zzb(T t, T t2) {
        if (!this.zzb.zzd(t).equals(this.zzb.zzd(t2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zza(t).equals(this.zzd.zza(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamc
    public final boolean zze(T t) {
        return this.zzd.zza(t).zzg();
    }
}
