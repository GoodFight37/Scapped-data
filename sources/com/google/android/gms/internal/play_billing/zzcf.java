package com.google.android.gms.internal.play_billing;

import com.google.common.primitives.Ints;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.0.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzcf extends zzbw {
    static final zzbw zza = new zzcf(null, new Object[0], 0);
    final transient Object[] zzb;
    private final transient Object zzc;
    private final transient int zzd;

    private zzcf(Object obj, Object[] objArr, int i) {
        this.zzc = obj;
        this.zzb = objArr;
        this.zzd = i;
    }

    /* JADX WARN: Code duplicated, block: B:73:0x0199 A[PHI: r4
  0x0199: PHI (r4v3 ??) = (r4v2 ??), (r4v4 short[]) binds: [B:72:0x0197, B:55:0x0134] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r3v33 */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r4v2, types: [int[], java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v3 */
    static zzcf zzg(int i, Object[] objArr, zzbv zzbvVar) {
        int iHighestOneBit;
        short[] sArr;
        int i2 = i;
        Object[] objArrCopyOf = objArr;
        if (i2 == 0) {
            return (zzcf) zza;
        }
        zzbu zzbuVar = null;
        ?? r3 = 0;
        zzbu zzbuVar2 = null;
        zzbu zzbuVar3 = null;
        if (i2 == 1) {
            zzbo.zza(Objects.requireNonNull(objArrCopyOf[0]), Objects.requireNonNull(objArrCopyOf[1]));
            return new zzcf(null, objArrCopyOf, 1);
        }
        zzbg.zzb(i2, objArrCopyOf.length >> 1, FirebaseAnalytics.Param.INDEX);
        int iMax = Math.max(i2, 2);
        if (iMax < 751619276) {
            iHighestOneBit = Integer.highestOneBit(iMax - 1);
            do {
                iHighestOneBit += iHighestOneBit;
            } while (((double) iHighestOneBit) * 0.7d < iMax);
        } else {
            iHighestOneBit = Ints.MAX_POWER_OF_TWO;
            if (iMax >= 1073741824) {
                throw new IllegalArgumentException("collection too large");
            }
        }
        if (i2 == 1) {
            zzbo.zza(Objects.requireNonNull(objArrCopyOf[0]), Objects.requireNonNull(objArrCopyOf[1]));
            i2 = 1;
        } else {
            int i3 = iHighestOneBit - 1;
            byte b = -1;
            if (iHighestOneBit <= 128) {
                byte[] bArr = new byte[iHighestOneBit];
                Arrays.fill(bArr, (byte) -1);
                int i4 = 0;
                for (int i5 = 0; i5 < i2; i5++) {
                    int i6 = i4 + i4;
                    int i7 = i5 + i5;
                    Object objRequireNonNull = Objects.requireNonNull(objArrCopyOf[i7]);
                    Object objRequireNonNull2 = Objects.requireNonNull(objArrCopyOf[i7 ^ 1]);
                    zzbo.zza(objRequireNonNull, objRequireNonNull2);
                    int iZza = zzbp.zza(objRequireNonNull.hashCode());
                    while (true) {
                        int i8 = iZza & i3;
                        int i9 = bArr[i8] & 255;
                        if (i9 == 255) {
                            bArr[i8] = (byte) i6;
                            if (i4 < i5) {
                                objArrCopyOf[i6] = objRequireNonNull;
                                objArrCopyOf[i6 ^ 1] = objRequireNonNull2;
                            }
                            i4++;
                            break;
                        }
                        if (objRequireNonNull.equals(objArrCopyOf[i9 == true ? 1 : 0])) {
                            int i10 = ~i9;
                            zzbu zzbuVar4 = new zzbu(objRequireNonNull, objRequireNonNull2, Objects.requireNonNull(objArrCopyOf[i10 == true ? 1 : 0]));
                            objArrCopyOf[i10 == true ? 1 : 0] = objRequireNonNull2;
                            zzbuVar2 = zzbuVar4;
                            break;
                        }
                        iZza = i8 + 1;
                    }
                }
                r3 = i4 == i2 ? bArr : new Object[]{bArr, Integer.valueOf(i4), zzbuVar2};
            } else if (iHighestOneBit <= 32768) {
                sArr = new short[iHighestOneBit];
                Arrays.fill(sArr, (short) -1);
                int i11 = 0;
                for (int i12 = 0; i12 < i2; i12++) {
                    int i13 = i11 + i11;
                    int i14 = i12 + i12;
                    Object objRequireNonNull3 = Objects.requireNonNull(objArrCopyOf[i14]);
                    Object objRequireNonNull4 = Objects.requireNonNull(objArrCopyOf[i14 ^ 1]);
                    zzbo.zza(objRequireNonNull3, objRequireNonNull4);
                    int iZza2 = zzbp.zza(objRequireNonNull3.hashCode());
                    while (true) {
                        int i15 = iZza2 & i3;
                        char c = (char) sArr[i15];
                        if (c == 65535) {
                            sArr[i15] = (short) i13;
                            if (i11 < i12) {
                                objArrCopyOf[i13] = objRequireNonNull3;
                                objArrCopyOf[i13 ^ 1] = objRequireNonNull4;
                            }
                            i11++;
                            break;
                        }
                        if (objRequireNonNull3.equals(objArrCopyOf[c])) {
                            int i16 = c ^ 1;
                            zzbu zzbuVar5 = new zzbu(objRequireNonNull3, objRequireNonNull4, Objects.requireNonNull(objArrCopyOf[i16 == true ? 1 : 0]));
                            objArrCopyOf[i16 == true ? 1 : 0] = objRequireNonNull4;
                            zzbuVar3 = zzbuVar5;
                            break;
                        }
                        iZza2 = i15 + 1;
                    }
                }
                if (i11 == i2) {
                    r3 = sArr;
                } else {
                    r3 = new Object[]{sArr, Integer.valueOf(i11), zzbuVar3};
                }
            } else {
                sArr = new int[iHighestOneBit];
                Arrays.fill((int[]) sArr, -1);
                int i17 = 0;
                int i18 = 0;
                while (i17 < i2) {
                    int i19 = i18 + i18;
                    int i20 = i17 + i17;
                    Object objRequireNonNull5 = Objects.requireNonNull(objArrCopyOf[i20]);
                    Object objRequireNonNull6 = Objects.requireNonNull(objArrCopyOf[i20 ^ 1]);
                    zzbo.zza(objRequireNonNull5, objRequireNonNull6);
                    int iZza3 = zzbp.zza(objRequireNonNull5.hashCode());
                    while (true) {
                        int i21 = iZza3 & i3;
                        ?? r15 = sArr[i21];
                        if (r15 == b) {
                            sArr[i21] = i19;
                            if (i18 < i17) {
                                objArrCopyOf[i19] = objRequireNonNull5;
                                objArrCopyOf[i19 ^ 1] = objRequireNonNull6;
                            }
                            i18++;
                            break;
                        }
                        if (objRequireNonNull5.equals(objArrCopyOf[r15])) {
                            int i22 = r15 ^ 1;
                            zzbu zzbuVar6 = new zzbu(objRequireNonNull5, objRequireNonNull6, Objects.requireNonNull(objArrCopyOf[i22 == true ? 1 : 0]));
                            objArrCopyOf[i22 == true ? 1 : 0] = objRequireNonNull6;
                            zzbuVar = zzbuVar6;
                            break;
                        }
                        iZza3 = i21 + 1;
                        b = -1;
                    }
                    i17++;
                    b = -1;
                }
                if (i18 == i2) {
                    r3 = sArr;
                } else {
                    r3 = new Object[]{sArr, Integer.valueOf(i18), zzbuVar};
                }
            }
        }
        boolean z = r3 instanceof Object[];
        ?? r4 = r3;
        if (z) {
            Object[] objArr2 = (Object[]) r3;
            zzbu zzbuVar7 = (zzbu) objArr2[2];
            if (zzbvVar == null) {
                throw zzbuVar7.zza();
            }
            zzbvVar.zzc = zzbuVar7;
            Object obj = objArr2[0];
            int iIntValue = ((Integer) objArr2[1]).intValue();
            objArrCopyOf = Arrays.copyOf(objArrCopyOf, iIntValue + iIntValue);
            r4 = obj;
            i2 = iIntValue;
        }
        return new zzcf(r4, objArrCopyOf, i2);
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0003  */
    @Override // com.google.android.gms.internal.play_billing.zzbw, java.util.Map
    public final Object get(Object obj) {
        Object objRequireNonNull;
        if (obj == null) {
            objRequireNonNull = null;
        } else {
            int i = this.zzd;
            Object[] objArr = this.zzb;
            if (i != 1) {
                Object obj2 = this.zzc;
                if (obj2 == null) {
                    objRequireNonNull = null;
                } else if (obj2 instanceof byte[]) {
                    byte[] bArr = (byte[]) obj2;
                    int length = bArr.length - 1;
                    int iZza = zzbp.zza(obj.hashCode());
                    while (true) {
                        int i2 = iZza & length;
                        int i3 = bArr[i2] & 255;
                        if (i3 == 255) {
                            break;
                        }
                        if (obj.equals(objArr[i3])) {
                            objRequireNonNull = objArr[i3 ^ 1];
                        } else {
                            iZza = i2 + 1;
                        }
                    }
                    objRequireNonNull = null;
                } else if (obj2 instanceof short[]) {
                    short[] sArr = (short[]) obj2;
                    int length2 = sArr.length - 1;
                    int iZza2 = zzbp.zza(obj.hashCode());
                    while (true) {
                        int i4 = iZza2 & length2;
                        char c = (char) sArr[i4];
                        if (c == 65535) {
                            break;
                        }
                        if (obj.equals(objArr[c])) {
                            objRequireNonNull = objArr[c ^ 1];
                        } else {
                            iZza2 = i4 + 1;
                        }
                    }
                    objRequireNonNull = null;
                } else {
                    int[] iArr = (int[]) obj2;
                    int length3 = iArr.length - 1;
                    int iZza3 = zzbp.zza(obj.hashCode());
                    while (true) {
                        int i5 = iZza3 & length3;
                        int i6 = iArr[i5];
                        if (i6 == -1) {
                            break;
                        }
                        if (obj.equals(objArr[i6])) {
                            objRequireNonNull = objArr[i6 ^ 1];
                        } else {
                            iZza3 = i5 + 1;
                        }
                    }
                    objRequireNonNull = null;
                }
            } else if (Objects.requireNonNull(objArr[0]).equals(obj)) {
                objRequireNonNull = Objects.requireNonNull(objArr[1]);
            } else {
                objRequireNonNull = null;
            }
        }
        if (objRequireNonNull == null) {
            return null;
        }
        return objRequireNonNull;
    }

    @Override // java.util.Map
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbw
    final zzbq zza() {
        return new zzce(this.zzb, 1, this.zzd);
    }

    @Override // com.google.android.gms.internal.play_billing.zzbw
    final zzbx zzd() {
        return new zzcc(this, this.zzb, 0, this.zzd);
    }

    @Override // com.google.android.gms.internal.play_billing.zzbw
    final zzbx zze() {
        return new zzcd(this, new zzce(this.zzb, 0, this.zzd));
    }
}
