package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.common.primitives.Ints;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import kotlin.UShort;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzau<K, V> extends zzan<K, V> {
    private static final zzan<Object, Object> zza = new zzau(null, new Object[0], 0);
    private final transient Object zzb;
    private final transient Object[] zzc;
    private final transient int zzd;

    @Override // java.util.Map
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzan
    final boolean zzd() {
        return false;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzan
    final zzai<V> zza() {
        return new zzay(this.zzc, 1, this.zzd);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzan
    final zzas<Map.Entry<K, V>> zzb() {
        return new zzat(this, this.zzc, 0, this.zzd);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzan
    final zzas<K> zzc() {
        return new zzav(this, new zzay(this.zzc, 0, this.zzd));
    }

    /* JADX WARN: Code duplicated, block: B:76:0x019a A[PHI: r4
  0x019a: PHI (r4v3 ??) = (r4v2 ??), (r4v4 short[]) binds: [B:75:0x0198, B:58:0x0136] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r4v2, types: [int[], java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v3 */
    static <K, V> zzau<K, V> zza(int i, Object[] objArr, zzaq<K, V> zzaqVar) {
        int iHighestOneBit;
        short[] sArr;
        int i2 = i;
        Object[] objArrCopyOf = objArr;
        if (i2 == 0) {
            return (zzau) zza;
        }
        zzap zzapVar = null;
        ?? r3 = 0;
        zzap zzapVar2 = null;
        zzap zzapVar3 = null;
        if (i2 == 1) {
            zzag.zza(Objects.requireNonNull(objArrCopyOf[0]), Objects.requireNonNull(objArrCopyOf[1]));
            return new zzau<>(null, objArrCopyOf, 1);
        }
        zzw.zzb(i2, objArrCopyOf.length >> 1);
        int iMax = Math.max(i2, 2);
        if (iMax < 751619276) {
            iHighestOneBit = Integer.highestOneBit(iMax - 1) << 1;
            while (((double) iHighestOneBit) * 0.7d < iMax) {
                iHighestOneBit <<= 1;
            }
        } else {
            iHighestOneBit = Ints.MAX_POWER_OF_TWO;
            if (!(iMax < 1073741824)) {
                throw new IllegalArgumentException("collection too large");
            }
        }
        if (i2 == 1) {
            zzag.zza(Objects.requireNonNull(objArrCopyOf[0]), Objects.requireNonNull(objArrCopyOf[1]));
        } else {
            int i3 = iHighestOneBit - 1;
            byte b = -1;
            if (iHighestOneBit <= 128) {
                byte[] bArr = new byte[iHighestOneBit];
                Arrays.fill(bArr, (byte) -1);
                int i4 = 0;
                for (int i5 = 0; i5 < i2; i5++) {
                    int i6 = i5 * 2;
                    int i7 = i4 * 2;
                    Object objRequireNonNull = Objects.requireNonNull(objArrCopyOf[i6]);
                    Object objRequireNonNull2 = Objects.requireNonNull(objArrCopyOf[i6 ^ 1]);
                    zzag.zza(objRequireNonNull, objRequireNonNull2);
                    int iZza = zzaf.zza(objRequireNonNull.hashCode());
                    while (true) {
                        int i8 = iZza & i3;
                        int i9 = bArr[i8] & 255;
                        if (i9 == 255) {
                            bArr[i8] = (byte) i7;
                            if (i4 < i5) {
                                objArrCopyOf[i7] = objRequireNonNull;
                                objArrCopyOf[i7 ^ 1] = objRequireNonNull2;
                            }
                            i4++;
                            break;
                        }
                        if (objRequireNonNull.equals(objArrCopyOf[i9 == true ? 1 : 0])) {
                            int i10 = ~i9;
                            zzapVar2 = new zzap(objRequireNonNull, objRequireNonNull2, Objects.requireNonNull(objArrCopyOf[i10 == true ? 1 : 0]));
                            objArrCopyOf[i10 == true ? 1 : 0] = objRequireNonNull2;
                            break;
                        }
                        iZza = i8 + 1;
                    }
                }
                r3 = i4 == i2 ? bArr : new Object[]{bArr, Integer.valueOf(i4), zzapVar2};
            } else if (iHighestOneBit <= 32768) {
                sArr = new short[iHighestOneBit];
                Arrays.fill(sArr, (short) -1);
                int i11 = 0;
                for (int i12 = 0; i12 < i2; i12++) {
                    int i13 = i12 * 2;
                    int i14 = i11 * 2;
                    Object objRequireNonNull3 = Objects.requireNonNull(objArrCopyOf[i13]);
                    Object objRequireNonNull4 = Objects.requireNonNull(objArrCopyOf[i13 ^ 1]);
                    zzag.zza(objRequireNonNull3, objRequireNonNull4);
                    int iZza2 = zzaf.zza(objRequireNonNull3.hashCode());
                    while (true) {
                        int i15 = iZza2 & i3;
                        int i16 = sArr[i15] & UShort.MAX_VALUE;
                        if (i16 == 65535) {
                            sArr[i15] = (short) i14;
                            if (i11 < i12) {
                                objArrCopyOf[i14] = objRequireNonNull3;
                                objArrCopyOf[i14 ^ 1] = objRequireNonNull4;
                            }
                            i11++;
                            break;
                        }
                        if (objRequireNonNull3.equals(objArrCopyOf[i16 == true ? 1 : 0])) {
                            int i17 = ~i16;
                            zzapVar3 = new zzap(objRequireNonNull3, objRequireNonNull4, Objects.requireNonNull(objArrCopyOf[i17 == true ? 1 : 0]));
                            objArrCopyOf[i17 == true ? 1 : 0] = objRequireNonNull4;
                            break;
                        }
                        iZza2 = i15 + 1;
                    }
                }
                if (i11 == i2) {
                    r3 = sArr;
                } else {
                    r3 = new Object[]{sArr, Integer.valueOf(i11), zzapVar3};
                }
            } else {
                sArr = new int[iHighestOneBit];
                Arrays.fill((int[]) sArr, -1);
                int i18 = 0;
                int i19 = 0;
                while (i18 < i2) {
                    int i20 = i18 * 2;
                    int i21 = i19 * 2;
                    Object objRequireNonNull5 = Objects.requireNonNull(objArrCopyOf[i20]);
                    Object objRequireNonNull6 = Objects.requireNonNull(objArrCopyOf[i20 ^ 1]);
                    zzag.zza(objRequireNonNull5, objRequireNonNull6);
                    int iZza3 = zzaf.zza(objRequireNonNull5.hashCode());
                    while (true) {
                        int i22 = iZza3 & i3;
                        ?? r15 = sArr[i22];
                        if (r15 == b) {
                            sArr[i22] = i21;
                            if (i19 < i18) {
                                objArrCopyOf[i21] = objRequireNonNull5;
                                objArrCopyOf[i21 ^ 1] = objRequireNonNull6;
                            }
                            i19++;
                            break;
                        }
                        if (objRequireNonNull5.equals(objArrCopyOf[r15])) {
                            int i23 = r15 ^ 1;
                            zzapVar = new zzap(objRequireNonNull5, objRequireNonNull6, Objects.requireNonNull(objArrCopyOf[i23 == true ? 1 : 0]));
                            objArrCopyOf[i23 == true ? 1 : 0] = objRequireNonNull6;
                            break;
                        }
                        iZza3 = i22 + 1;
                        b = -1;
                    }
                    i18++;
                    b = -1;
                }
                if (i19 == i2) {
                    r3 = sArr;
                } else {
                    r3 = new Object[]{sArr, Integer.valueOf(i19), zzapVar};
                }
            }
        }
        boolean z = r3 instanceof Object[];
        ?? r4 = r3;
        if (z) {
            Object[] objArr2 = (Object[]) r3;
            zzap zzapVar4 = (zzap) objArr2[2];
            if (zzaqVar == null) {
                throw zzapVar4.zza();
            }
            zzaqVar.zza = zzapVar4;
            Object obj = objArr2[0];
            int iIntValue = ((Integer) objArr2[1]).intValue();
            objArrCopyOf = Arrays.copyOf(objArrCopyOf, iIntValue << 1);
            r4 = obj;
            i2 = iIntValue;
        }
        return new zzau<>(r4, objArrCopyOf, i2);
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0009 A[EDGE_INSN: B:43:0x0009->B:4:0x0009 BREAK  A[LOOP:0: B:15:0x0039->B:21:0x004f], EDGE_INSN: B:45:0x0009->B:4:0x0009 BREAK  A[LOOP:1: B:25:0x0064->B:31:0x007b], EDGE_INSN: B:47:0x0009->B:4:0x0009 BREAK  A[LOOP:2: B:33:0x008a->B:42:0x00a2]] */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzan, java.util.Map
    public final V get(Object obj) {
        V v;
        Object obj2 = this.zzb;
        Object[] objArr = this.zzc;
        int i = this.zzd;
        if (obj == null) {
            v = null;
        } else if (i == 1) {
            if (Objects.requireNonNull(objArr[0]).equals(obj)) {
                v = (V) Objects.requireNonNull(objArr[1]);
            } else {
                v = null;
            }
        } else if (obj2 == null) {
            v = null;
        } else if (obj2 instanceof byte[]) {
            byte[] bArr = (byte[]) obj2;
            int length = bArr.length - 1;
            int iZza = zzaf.zza(obj.hashCode());
            while (true) {
                int i2 = iZza & length;
                int i3 = bArr[i2] & 255;
                if (i3 == 255) {
                    break;
                }
                if (obj.equals(objArr[i3])) {
                    v = (V) objArr[i3 ^ 1];
                } else {
                    iZza = i2 + 1;
                }
            }
            v = null;
        } else if (obj2 instanceof short[]) {
            short[] sArr = (short[]) obj2;
            int length2 = sArr.length - 1;
            int iZza2 = zzaf.zza(obj.hashCode());
            while (true) {
                int i4 = iZza2 & length2;
                int i5 = sArr[i4] & UShort.MAX_VALUE;
                if (i5 == 65535) {
                    break;
                }
                if (obj.equals(objArr[i5])) {
                    v = (V) objArr[i5 ^ 1];
                } else {
                    iZza2 = i4 + 1;
                }
            }
            v = null;
        } else {
            int[] iArr = (int[]) obj2;
            int length3 = iArr.length - 1;
            int iZza3 = zzaf.zza(obj.hashCode());
            while (true) {
                int i6 = iZza3 & length3;
                int i7 = iArr[i6];
                if (i7 == -1) {
                    break;
                }
                if (obj.equals(objArr[i7])) {
                    v = (V) objArr[i7 ^ 1];
                } else {
                    iZza3 = i6 + 1;
                }
            }
            v = null;
        }
        if (v == null) {
            return null;
        }
        return v;
    }

    private zzau(Object obj, Object[] objArr, int i) {
        this.zzb = obj;
        this.zzc = objArr;
        this.zzd = i;
    }
}
