package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* JADX INFO: loaded from: classes2.dex */
final class zzom implements zzow {
    private final zzoi zza;
    private final zzpl zzb;
    private final boolean zzc;
    private final zzmp zzd;

    private zzom(zzpl zzplVar, zzmp zzmpVar, zzoi zzoiVar) {
        this.zzb = zzplVar;
        this.zzc = zzoiVar instanceof zzna;
        this.zzd = zzmpVar;
        this.zza = zzoiVar;
    }

    static zzom zzc(zzpl zzplVar, zzmp zzmpVar, zzoi zzoiVar) {
        return new zzom(zzplVar, zzmpVar, zzoiVar);
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final int zza(Object obj) {
        int iZzb = ((zznd) obj).zzc.zzb();
        return this.zzc ? iZzb + ((zzna) obj).zzb.zzb() : iZzb;
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final int zzb(Object obj) {
        int iHashCode = ((zznd) obj).zzc.hashCode();
        return this.zzc ? (iHashCode * 53) + ((zzna) obj).zzb.zza.hashCode() : iHashCode;
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final Object zze() {
        zzoi zzoiVar = this.zza;
        return zzoiVar instanceof zznd ? ((zznd) zzoiVar).zzv() : zzoiVar.zzad().zzl();
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final void zzf(Object obj) {
        this.zzb.zzi(obj);
        this.zzd.zza(obj);
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final void zzg(Object obj, Object obj2) {
        zzoy.zzq(this.zzb, obj, obj2);
        if (this.zzc) {
            zzoy.zzp(this.zzd, obj, obj2);
        }
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final void zzh(Object obj, zzov zzovVar, zzmo zzmoVar) throws IOException {
        boolean zZzO;
        zzpl zzplVar = this.zzb;
        Object objZza = zzplVar.zza(obj);
        ((zzna) obj).zzi();
        while (zzovVar.zzc() != Integer.MAX_VALUE) {
            try {
                int iZzd = zzovVar.zzd();
                int iZzj = 0;
                if (iZzd != 11) {
                    if ((iZzd & 7) == 2) {
                        zznc zzncVarZza = zzmoVar.zza(this.zza, iZzd >>> 3);
                        if (zzncVarZza != null) {
                            zznc zzncVar = zzncVarZza;
                            throw null;
                        }
                        zZzO = zzplVar.zzk(objZza, zzovVar, 0);
                    } else {
                        zZzO = zzovVar.zzO();
                    }
                    if (!zZzO) {
                        break;
                    }
                } else {
                    zznc zzncVarZza2 = null;
                    zzle zzleVarZzp = null;
                    while (zzovVar.zzc() != Integer.MAX_VALUE) {
                        int iZzd2 = zzovVar.zzd();
                        if (iZzd2 == 16) {
                            iZzj = zzovVar.zzj();
                            zzncVarZza2 = zzmoVar.zza(this.zza, iZzj);
                        } else if (iZzd2 == 26) {
                            if (zzncVarZza2 != null) {
                                zznc zzncVar2 = zzncVarZza2;
                                throw null;
                            }
                            zzleVarZzp = zzovVar.zzp();
                        } else if (!zzovVar.zzO()) {
                            break;
                        }
                    }
                    if (zzovVar.zzd() != 12) {
                        throw new zznn("Protocol message end-group tag did not match expected tag.");
                    }
                    if (zzleVarZzp == null) {
                        continue;
                    } else {
                        if (zzncVarZza2 != null) {
                            zznc zzncVar3 = zzncVarZza2;
                            throw null;
                        }
                        zzplVar.zzg(objZza, iZzj, zzleVarZzp);
                    }
                }
            } catch (Throwable th) {
                zzplVar.zzj(obj, objZza);
                throw th;
            }
        }
        zzplVar.zzj(obj, objZza);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0085  */
    /* JADX WARN: Code duplicated, block: B:56:0x008a A[EDGE_INSN: B:56:0x008a->B:34:0x008a BREAK  A[LOOP:1: B:18:0x004b->B:61:0x004b], SYNTHETIC] */
    @Override // com.google.android.recaptcha.internal.zzow
    public final void zzi(Object obj, byte[] bArr, int i, int i2, zzkt zzktVar) throws IOException {
        zznd zzndVar = (zznd) obj;
        zzpm zzpmVarZzf = zzndVar.zzc;
        if (zzpmVarZzf == zzpm.zzc()) {
            zzpmVarZzf = zzpm.zzf();
            zzndVar.zzc = zzpmVarZzf;
        }
        ((zzna) obj).zzi();
        zznc zzncVarZza = null;
        while (i < i2) {
            int iZzi = zzku.zzi(bArr, i, zzktVar);
            int i3 = zzktVar.zza;
            if (i3 == 11) {
                int i4 = 0;
                zzle zzleVar = null;
                while (iZzi < i2) {
                    iZzi = zzku.zzi(bArr, iZzi, zzktVar);
                    int i5 = zzktVar.zza;
                    int i6 = i5 >>> 3;
                    int i7 = i5 & 7;
                    if (i6 == 2) {
                        if (i7 != 0) {
                            if (i5 != 12) {
                                break;
                                break;
                            }
                            iZzi = zzku.zzo(i5, bArr, iZzi, i2, zzktVar);
                        } else {
                            iZzi = zzku.zzi(bArr, iZzi, zzktVar);
                            i4 = zzktVar.zza;
                            zzncVarZza = zzktVar.zzd.zza(this.zza, i4);
                        }
                    } else {
                        if (i6 == 3) {
                            if (zzncVarZza != null) {
                                int i8 = zzos.zza;
                                throw null;
                            }
                            if (i7 == 2) {
                                iZzi = zzku.zza(bArr, iZzi, zzktVar);
                                zzleVar = (zzle) zzktVar.zzc;
                            }
                        }
                        if (i5 != 12) {
                            break;
                        } else {
                            iZzi = zzku.zzo(i5, bArr, iZzi, i2, zzktVar);
                        }
                    }
                }
                if (zzleVar != null) {
                    zzpmVarZzf.zzj((i4 << 3) | 2, zzleVar);
                }
                i = iZzi;
            } else if ((i3 & 7) == 2) {
                zzncVarZza = zzktVar.zzd.zza(this.zza, i3 >>> 3);
                if (zzncVarZza != null) {
                    int i9 = zzos.zza;
                    throw null;
                }
                i = zzku.zzh(i3, bArr, iZzi, i2, zzpmVarZzf, zzktVar);
            } else {
                i = zzku.zzo(i3, bArr, iZzi, i2, zzktVar);
            }
        }
        if (i != i2) {
            throw new zznn("Failed to parse the message.");
        }
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final void zzj(Object obj, zzpy zzpyVar) throws IOException {
        Iterator itZzf = ((zzna) obj).zzb.zzf();
        while (itZzf.hasNext()) {
            Map.Entry entry = (Map.Entry) itZzf.next();
            zzms zzmsVar = (zzms) entry.getKey();
            if (zzmsVar.zze() != zzpx.MESSAGE) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            zzmsVar.zzg();
            zzmsVar.zzf();
            if (entry instanceof zznp) {
                zzpyVar.zzw(zzmsVar.zza(), ((zznp) entry).zza().zzb());
            } else {
                zzpyVar.zzw(zzmsVar.zza(), entry.getValue());
            }
        }
        ((zznd) obj).zzc.zzk(zzpyVar);
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final boolean zzk(Object obj, Object obj2) {
        if (!((zznd) obj).zzc.equals(((zznd) obj2).zzc)) {
            return false;
        }
        if (this.zzc) {
            return ((zzna) obj).zzb.equals(((zzna) obj2).zzb);
        }
        return true;
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final boolean zzl(Object obj) {
        return ((zzna) obj).zzb.zzk();
    }
}
