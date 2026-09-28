package com.google.android.gms.internal.measurement;

import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.text.HtmlCompat;
import androidx.core.view.MotionEventCompat;
import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.4.0 */
/* JADX INFO: loaded from: classes.dex */
final class zznk<T> implements zzns<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzol.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zznh zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzoe zzl;
    private final zzlq zzm;

    private zznk(int[] iArr, Object[] objArr, int i, int i2, zznh zznhVar, boolean z, int[] iArr2, int i3, int i4, zznm zznmVar, zzmu zzmuVar, zzoe zzoeVar, zzlq zzlqVar, zznc zzncVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        boolean z2 = false;
        if (zzlqVar != null && (zznhVar instanceof zzma)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzi = iArr2;
        this.zzj = i3;
        this.zzk = i4;
        this.zzl = zzoeVar;
        this.zzm = zzlqVar;
        this.zzg = zznhVar;
    }

    private static void zzA(Object obj) {
        if (!zzL(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    private final void zzB(Object obj, Object obj2, int i) {
        if (zzI(obj2, i)) {
            int iZzs = zzs(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzs;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzns zznsVarZzv = zzv(i);
            if (!zzI(obj, i)) {
                if (zzL(object)) {
                    Object objZze = zznsVarZzv.zze();
                    zznsVarZzv.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzD(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object objZze2 = zznsVarZzv.zze();
                zznsVarZzv.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zznsVarZzv.zzg(object2, object);
        }
    }

    private final void zzC(Object obj, Object obj2, int i) {
        int[] iArr = this.zzc;
        int i2 = iArr[i];
        if (zzM(obj2, i2, i)) {
            int iZzs = zzs(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzs;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + iArr[i] + " is present but null: " + obj2.toString());
            }
            zzns zznsVarZzv = zzv(i);
            if (!zzM(obj, i2, i)) {
                if (zzL(object)) {
                    Object objZze = zznsVarZzv.zze();
                    zznsVarZzv.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzE(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object objZze2 = zznsVarZzv.zze();
                zznsVarZzv.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zznsVarZzv.zzg(object2, object);
        }
    }

    private final void zzD(Object obj, int i) {
        int iZzp = zzp(i);
        long j = 1048575 & iZzp;
        if (j == 1048575) {
            return;
        }
        zzol.zzq(obj, j, (1 << (iZzp >>> 20)) | zzol.zzc(obj, j));
    }

    private final void zzE(Object obj, int i, int i2) {
        zzol.zzq(obj, zzp(i2) & 1048575, i);
    }

    private final void zzF(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzs(i) & 1048575, obj2);
        zzD(obj, i);
    }

    private final void zzG(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzs(i2) & 1048575, obj2);
        zzE(obj, i, i2);
    }

    private final boolean zzH(Object obj, Object obj2, int i) {
        return zzI(obj, i) == zzI(obj2, i);
    }

    private final boolean zzI(Object obj, int i) {
        int iZzp = zzp(i);
        long j = iZzp & 1048575;
        if (j != 1048575) {
            return (zzol.zzc(obj, j) & (1 << (iZzp >>> 20))) != 0;
        }
        int iZzs = zzs(i);
        long j2 = iZzs & 1048575;
        switch (zzr(iZzs)) {
            case 0:
                return Double.doubleToRawLongBits(zzol.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzol.zzb(obj, j2)) != 0;
            case 2:
                return zzol.zzd(obj, j2) != 0;
            case 3:
                return zzol.zzd(obj, j2) != 0;
            case 4:
                return zzol.zzc(obj, j2) != 0;
            case 5:
                return zzol.zzd(obj, j2) != 0;
            case 6:
                return zzol.zzc(obj, j2) != 0;
            case 7:
                return zzol.zzw(obj, j2);
            case 8:
                Object objZzf = zzol.zzf(obj, j2);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzld) {
                    return !zzld.zzb.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzol.zzf(obj, j2) != null;
            case 10:
                return !zzld.zzb.equals(zzol.zzf(obj, j2));
            case 11:
                return zzol.zzc(obj, j2) != 0;
            case 12:
                return zzol.zzc(obj, j2) != 0;
            case 13:
                return zzol.zzc(obj, j2) != 0;
            case 14:
                return zzol.zzd(obj, j2) != 0;
            case 15:
                return zzol.zzc(obj, j2) != 0;
            case 16:
                return zzol.zzd(obj, j2) != 0;
            case 17:
                return zzol.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzJ(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzI(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzK(Object obj, int i, zzns zznsVar) {
        return zznsVar.zzk(zzol.zzf(obj, i & 1048575));
    }

    private static boolean zzL(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzmd) {
            return ((zzmd) obj).zzcw();
        }
        return true;
    }

    private final boolean zzM(Object obj, int i, int i2) {
        return zzol.zzc(obj, (long) (zzp(i2) & 1048575)) == i;
    }

    private static boolean zzN(Object obj, long j) {
        return ((Boolean) zzol.zzf(obj, j)).booleanValue();
    }

    private static final void zzO(int i, Object obj, zzor zzorVar) throws IOException {
        if (obj instanceof String) {
            zzorVar.zzG(i, (String) obj);
        } else {
            zzorVar.zzd(i, (zzld) obj);
        }
    }

    static zzof zzd(Object obj) {
        zzmd zzmdVar = (zzmd) obj;
        zzof zzofVar = zzmdVar.zzc;
        if (zzofVar != zzof.zzc()) {
            return zzofVar;
        }
        zzof zzofVarZzf = zzof.zzf();
        zzmdVar.zzc = zzofVarZzf;
        return zzofVarZzf;
    }

    /* JADX WARN: Code duplicated, block: B:125:0x0265  */
    /* JADX WARN: Code duplicated, block: B:126:0x0268  */
    /* JADX WARN: Code duplicated, block: B:129:0x027f  */
    /* JADX WARN: Code duplicated, block: B:130:0x0282  */
    /* JADX WARN: Code duplicated, block: B:169:0x0345  */
    /* JADX WARN: Code duplicated, block: B:183:0x0391  */
    /* JADX WARN: Code duplicated, block: B:186:0x039a  */
    static zznk zzl(Class cls, zzne zzneVar, zznm zznmVar, zzmu zzmuVar, zzoe zzoeVar, zzlq zzlqVar, zznc zzncVar) {
        int i;
        int iCharAt;
        int iCharAt2;
        int i2;
        int i3;
        int i4;
        int[] iArr;
        int i5;
        int i6;
        int i7;
        char cCharAt;
        int i8;
        char cCharAt2;
        int i9;
        char cCharAt3;
        int i10;
        char cCharAt4;
        int i11;
        char cCharAt5;
        int i12;
        char cCharAt6;
        int i13;
        char cCharAt7;
        int i14;
        char cCharAt8;
        int i15;
        int i16;
        int i17;
        int i18;
        int iObjectFieldOffset;
        int iObjectFieldOffset2;
        int i19;
        int i20;
        int i21;
        Field fieldZzz;
        int i22;
        char cCharAt9;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        Object obj;
        Field fieldZzz2;
        int i28;
        Object obj2;
        Field fieldZzz3;
        int i29;
        char cCharAt10;
        int i30;
        char cCharAt11;
        int i31;
        char cCharAt12;
        int i32;
        char cCharAt13;
        if (!(zzneVar instanceof zznr)) {
            throw null;
        }
        zznr zznrVar = (zznr) zzneVar;
        String strZzd = zznrVar.zzd();
        int length = strZzd.length();
        char c = 55296;
        if (strZzd.charAt(0) >= 55296) {
            int i33 = 1;
            while (true) {
                i = i33 + 1;
                if (strZzd.charAt(i33) < 55296) {
                    break;
                }
                i33 = i;
            }
        } else {
            i = 1;
        }
        int i34 = i + 1;
        int iCharAt3 = strZzd.charAt(i);
        if (iCharAt3 >= 55296) {
            int i35 = iCharAt3 & 8191;
            int i36 = 13;
            while (true) {
                i32 = i34 + 1;
                cCharAt13 = strZzd.charAt(i34);
                if (cCharAt13 < 55296) {
                    break;
                }
                i35 |= (cCharAt13 & 8191) << i36;
                i36 += 13;
                i34 = i32;
            }
            iCharAt3 = i35 | (cCharAt13 << i36);
            i34 = i32;
        }
        if (iCharAt3 == 0) {
            i4 = 0;
            iCharAt = 0;
            iCharAt2 = 0;
            i2 = 0;
            i5 = 0;
            i3 = 0;
            iArr = zza;
            i6 = 0;
        } else {
            int i37 = i34 + 1;
            int iCharAt4 = strZzd.charAt(i34);
            if (iCharAt4 >= 55296) {
                int i38 = iCharAt4 & 8191;
                int i39 = 13;
                while (true) {
                    i14 = i37 + 1;
                    cCharAt8 = strZzd.charAt(i37);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i38 |= (cCharAt8 & 8191) << i39;
                    i39 += 13;
                    i37 = i14;
                }
                iCharAt4 = i38 | (cCharAt8 << i39);
                i37 = i14;
            }
            int i40 = i37 + 1;
            int iCharAt5 = strZzd.charAt(i37);
            if (iCharAt5 >= 55296) {
                int i41 = iCharAt5 & 8191;
                int i42 = 13;
                while (true) {
                    i13 = i40 + 1;
                    cCharAt7 = strZzd.charAt(i40);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i41 |= (cCharAt7 & 8191) << i42;
                    i42 += 13;
                    i40 = i13;
                }
                iCharAt5 = i41 | (cCharAt7 << i42);
                i40 = i13;
            }
            int i43 = i40 + 1;
            int iCharAt6 = strZzd.charAt(i40);
            if (iCharAt6 >= 55296) {
                int i44 = iCharAt6 & 8191;
                int i45 = 13;
                while (true) {
                    i12 = i43 + 1;
                    cCharAt6 = strZzd.charAt(i43);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i44 |= (cCharAt6 & 8191) << i45;
                    i45 += 13;
                    i43 = i12;
                }
                iCharAt6 = i44 | (cCharAt6 << i45);
                i43 = i12;
            }
            int i46 = i43 + 1;
            int iCharAt7 = strZzd.charAt(i43);
            if (iCharAt7 >= 55296) {
                int i47 = iCharAt7 & 8191;
                int i48 = 13;
                while (true) {
                    i11 = i46 + 1;
                    cCharAt5 = strZzd.charAt(i46);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i47 |= (cCharAt5 & 8191) << i48;
                    i48 += 13;
                    i46 = i11;
                }
                iCharAt7 = i47 | (cCharAt5 << i48);
                i46 = i11;
            }
            int i49 = i46 + 1;
            iCharAt = strZzd.charAt(i46);
            if (iCharAt >= 55296) {
                int i50 = iCharAt & 8191;
                int i51 = 13;
                while (true) {
                    i10 = i49 + 1;
                    cCharAt4 = strZzd.charAt(i49);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i50 |= (cCharAt4 & 8191) << i51;
                    i51 += 13;
                    i49 = i10;
                }
                iCharAt = i50 | (cCharAt4 << i51);
                i49 = i10;
            }
            int i52 = i49 + 1;
            iCharAt2 = strZzd.charAt(i49);
            if (iCharAt2 >= 55296) {
                int i53 = iCharAt2 & 8191;
                int i54 = 13;
                while (true) {
                    i9 = i52 + 1;
                    cCharAt3 = strZzd.charAt(i52);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i53 |= (cCharAt3 & 8191) << i54;
                    i54 += 13;
                    i52 = i9;
                }
                iCharAt2 = i53 | (cCharAt3 << i54);
                i52 = i9;
            }
            int i55 = i52 + 1;
            int iCharAt8 = strZzd.charAt(i52);
            if (iCharAt8 >= 55296) {
                int i56 = iCharAt8 & 8191;
                int i57 = 13;
                while (true) {
                    i8 = i55 + 1;
                    cCharAt2 = strZzd.charAt(i55);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i56 |= (cCharAt2 & 8191) << i57;
                    i57 += 13;
                    i55 = i8;
                }
                iCharAt8 = i56 | (cCharAt2 << i57);
                i55 = i8;
            }
            int i58 = i55 + 1;
            int iCharAt9 = strZzd.charAt(i55);
            if (iCharAt9 >= 55296) {
                int i59 = iCharAt9 & 8191;
                int i60 = 13;
                while (true) {
                    i7 = i58 + 1;
                    cCharAt = strZzd.charAt(i58);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i59 |= (cCharAt & 8191) << i60;
                    i60 += 13;
                    i58 = i7;
                }
                iCharAt9 = i59 | (cCharAt << i60);
                i58 = i7;
            }
            int i61 = iCharAt4 + iCharAt4 + iCharAt5;
            int[] iArr2 = new int[iCharAt9 + iCharAt2 + iCharAt8];
            i2 = iCharAt6;
            i3 = iCharAt9;
            i4 = i61;
            iArr = iArr2;
            i5 = iCharAt7;
            i6 = iCharAt4;
            i34 = i58;
        }
        Unsafe unsafe = zzb;
        Object[] objArrZze = zznrVar.zze();
        Class<?> cls2 = zznrVar.zza().getClass();
        int i62 = i3 + iCharAt2;
        int i63 = iCharAt + iCharAt;
        int[] iArr3 = new int[iCharAt * 3];
        Object[] objArr = new Object[i63];
        int i64 = i3;
        int i65 = i62;
        int i66 = 0;
        int i67 = 0;
        while (i34 < length) {
            int i68 = i34 + 1;
            int iCharAt10 = strZzd.charAt(i34);
            if (iCharAt10 >= c) {
                int i69 = iCharAt10 & 8191;
                int i70 = i68;
                int i71 = 13;
                while (true) {
                    i31 = i70 + 1;
                    cCharAt12 = strZzd.charAt(i70);
                    if (cCharAt12 < c) {
                        break;
                    }
                    i69 |= (cCharAt12 & 8191) << i71;
                    i71 += 13;
                    i70 = i31;
                }
                iCharAt10 = i69 | (cCharAt12 << i71);
                i15 = i31;
            } else {
                i15 = i68;
            }
            int i72 = i15 + 1;
            int iCharAt11 = strZzd.charAt(i15);
            if (iCharAt11 >= c) {
                int i73 = iCharAt11 & 8191;
                int i74 = i72;
                int i75 = 13;
                while (true) {
                    i30 = i74 + 1;
                    cCharAt11 = strZzd.charAt(i74);
                    if (cCharAt11 < c) {
                        break;
                    }
                    i73 |= (cCharAt11 & 8191) << i75;
                    i75 += 13;
                    i74 = i30;
                }
                iCharAt11 = i73 | (cCharAt11 << i75);
                i16 = i30;
            } else {
                i16 = i72;
            }
            if ((iCharAt11 & 1024) != 0) {
                iArr[i66] = i67;
                i66++;
            }
            int i76 = iCharAt11 & 255;
            int i77 = length;
            int i78 = iCharAt11 & 2048;
            int i79 = i5;
            if (i76 >= 51) {
                int i80 = i16 + 1;
                int iCharAt12 = strZzd.charAt(i16);
                if (iCharAt12 >= 55296) {
                    int i81 = iCharAt12 & 8191;
                    int i82 = i80;
                    int i83 = 13;
                    while (true) {
                        i29 = i82 + 1;
                        cCharAt10 = strZzd.charAt(i82);
                        i17 = i2;
                        if (cCharAt10 < 55296) {
                            break;
                        }
                        i81 |= (cCharAt10 & 8191) << i83;
                        i83 += 13;
                        i82 = i29;
                        i2 = i17;
                    }
                    iCharAt12 = i81 | (cCharAt10 << i83);
                    i25 = i29;
                } else {
                    i17 = i2;
                    i25 = i80;
                }
                int i84 = i76 - 51;
                int i85 = i25;
                if (i84 == 9 || i84 == 17) {
                    i26 = i4 + 1;
                    int i86 = i67 / 3;
                    objArr[i86 + i86 + 1] = objArrZze[i4];
                } else {
                    if (i84 == 12) {
                        if (zznrVar.zzc() == 1 || i78 != 0) {
                            i26 = i4 + 1;
                            int i87 = i67 / 3;
                            objArr[i87 + i87 + 1] = objArrZze[i4];
                        } else {
                            i78 = 0;
                        }
                    }
                    i27 = iCharAt12 + iCharAt12;
                    obj = objArrZze[i27];
                    if (obj instanceof Field) {
                        fieldZzz2 = (Field) obj;
                    } else {
                        fieldZzz2 = zzz(cls2, (String) obj);
                        objArrZze[i27] = fieldZzz2;
                    }
                    int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzz2);
                    i28 = i27 + 1;
                    obj2 = objArrZze[i28];
                    int i88 = i78;
                    if (obj2 instanceof Field) {
                        fieldZzz3 = (Field) obj2;
                    } else {
                        fieldZzz3 = zzz(cls2, (String) obj2);
                        objArrZze[i28] = fieldZzz3;
                    }
                    i18 = i4;
                    i19 = i85;
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzz3);
                    i20 = 0;
                    strZzd = strZzd;
                    zznrVar = zznrVar;
                    iObjectFieldOffset = iObjectFieldOffset3;
                    i21 = i88;
                }
                i4 = i26;
                i27 = iCharAt12 + iCharAt12;
                obj = objArrZze[i27];
                if (obj instanceof Field) {
                    fieldZzz2 = (Field) obj;
                } else {
                    fieldZzz2 = zzz(cls2, (String) obj);
                    objArrZze[i27] = fieldZzz2;
                }
                int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldZzz2);
                i28 = i27 + 1;
                obj2 = objArrZze[i28];
                int i89 = i78;
                if (obj2 instanceof Field) {
                    fieldZzz3 = (Field) obj2;
                } else {
                    fieldZzz3 = zzz(cls2, (String) obj2);
                    objArrZze[i28] = fieldZzz3;
                }
                i18 = i4;
                i19 = i85;
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzz3);
                i20 = 0;
                strZzd = strZzd;
                zznrVar = zznrVar;
                iObjectFieldOffset = iObjectFieldOffset4;
                i21 = i89;
            } else {
                i17 = i2;
                i18 = i4 + 1;
                Field fieldZzz4 = zzz(cls2, (String) objArrZze[i4]);
                if (i76 == 9 || i76 == 17) {
                    int i90 = i67 / 3;
                    objArr[i90 + i90 + 1] = fieldZzz4.getType();
                } else {
                    if (i76 != 27) {
                        if (i76 == 49) {
                            i24 = i4 + 2;
                            i23 = 1;
                        } else if (i76 == 12 || i76 == 30 || i76 == 44) {
                            zznrVar = zznrVar;
                            if (zznrVar.zzc() == 1 || i78 != 0) {
                                i24 = i4 + 2;
                                int i91 = i67 / 3;
                                objArr[i91 + i91 + 1] = objArrZze[i18];
                                i18 = i24;
                            } else {
                                i78 = 0;
                            }
                        } else if (i76 == 50) {
                            int i92 = i4 + 2;
                            int i93 = i64 + 1;
                            iArr[i64] = i67;
                            int i94 = i67 / 3;
                            int i95 = i94 + i94;
                            objArr[i95] = objArrZze[i18];
                            if (i78 != 0) {
                                i18 = i4 + 3;
                                objArr[i95 + 1] = objArrZze[i92];
                                i64 = i93;
                                zznrVar = zznrVar;
                            } else {
                                i18 = i92;
                                i64 = i93;
                                i78 = 0;
                            }
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzz4);
                        iObjectFieldOffset2 = 1048575;
                        if ((iCharAt11 & 4096) != 0 || i76 > 17) {
                            i19 = i16;
                            i20 = 0;
                        } else {
                            int i96 = i16 + 1;
                            int iCharAt13 = strZzd.charAt(i16);
                            if (iCharAt13 >= 55296) {
                                int i97 = iCharAt13 & 8191;
                                int i98 = 13;
                                while (true) {
                                    i22 = i96 + 1;
                                    cCharAt9 = strZzd.charAt(i96);
                                    if (cCharAt9 < 55296) {
                                        break;
                                    }
                                    i97 |= (cCharAt9 & 8191) << i98;
                                    i98 += 13;
                                    i96 = i22;
                                }
                                iCharAt13 = i97 | (cCharAt9 << i98);
                                i96 = i22;
                            }
                            int i99 = i6 + i6 + (iCharAt13 / 32);
                            Object obj3 = objArrZze[i99];
                            i19 = i96;
                            if (obj3 instanceof Field) {
                                fieldZzz = (Field) obj3;
                            } else {
                                fieldZzz = zzz(cls2, (String) obj3);
                                objArrZze[i99] = fieldZzz;
                            }
                            i20 = iCharAt13 % 32;
                            iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzz);
                        }
                        if (i76 >= 18 && i76 <= 49) {
                            iArr[i65] = iObjectFieldOffset;
                            i65++;
                        }
                        i21 = i78;
                    } else {
                        i23 = 1;
                        i24 = i4 + 2;
                    }
                    int i100 = i67 / 3;
                    objArr[i100 + i100 + i23] = objArrZze[i18];
                    i18 = i24;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzz4);
                    iObjectFieldOffset2 = 1048575;
                    if ((iCharAt11 & 4096) != 0) {
                        i19 = i16;
                        i20 = 0;
                    } else {
                        i19 = i16;
                        i20 = 0;
                    }
                    if (i76 >= 18) {
                        iArr[i65] = iObjectFieldOffset;
                        i65++;
                    }
                    i21 = i78;
                }
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzz4);
                iObjectFieldOffset2 = 1048575;
                if ((iCharAt11 & 4096) != 0) {
                    i19 = i16;
                    i20 = 0;
                } else {
                    i19 = i16;
                    i20 = 0;
                }
                if (i76 >= 18) {
                    iArr[i65] = iObjectFieldOffset;
                    i65++;
                }
                i21 = i78;
            }
            int i101 = i67 + 1;
            iArr3[i67] = iCharAt10;
            int i102 = i67 + 2;
            Class<?> cls3 = cls2;
            iArr3[i101] = iObjectFieldOffset | (i21 != 0 ? Integer.MIN_VALUE : 0) | ((iCharAt11 & 512) != 0 ? 536870912 : 0) | ((iCharAt11 & 256) != 0 ? 268435456 : 0) | (i76 << 20);
            i67 += 3;
            iArr3[i102] = (i20 << 20) | iObjectFieldOffset2;
            strZzd = strZzd;
            i4 = i18;
            length = i77;
            i5 = i79;
            cls2 = cls3;
            zznrVar = zznrVar;
            i34 = i19;
            i2 = i17;
            c = 55296;
        }
        return new zznk(iArr3, objArr, i2, i5, zznrVar.zza(), false, iArr, i3, i62, zznmVar, zzmuVar, zzoeVar, zzlqVar, zzncVar);
    }

    private static double zzm(Object obj, long j) {
        return ((Double) zzol.zzf(obj, j)).doubleValue();
    }

    private static float zzn(Object obj, long j) {
        return ((Float) zzol.zzf(obj, j)).floatValue();
    }

    private static int zzo(Object obj, long j) {
        return ((Integer) zzol.zzf(obj, j)).intValue();
    }

    private final int zzp(int i) {
        return this.zzc[i + 2];
    }

    private final int zzq(int i, int i2) {
        int[] iArr = this.zzc;
        int length = (iArr.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = iArr[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private static int zzr(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzs(int i) {
        return this.zzc[i + 1];
    }

    private static long zzt(Object obj, long j) {
        return ((Long) zzol.zzf(obj, j)).longValue();
    }

    private final zzmg zzu(int i) {
        int i2 = i / 3;
        return (zzmg) this.zzd[i2 + i2 + 1];
    }

    private final zzns zzv(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzns zznsVar = (zzns) objArr[i3];
        if (zznsVar != null) {
            return zznsVar;
        }
        zzns zznsVarZzb = zznp.zza().zzb((Class) objArr[i3 + 1]);
        objArr[i3] = zznsVarZzb;
        return zznsVarZzb;
    }

    private final Object zzw(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final Object zzx(Object obj, int i) {
        zzns zznsVarZzv = zzv(i);
        int iZzs = zzs(i) & 1048575;
        if (!zzI(obj, i)) {
            return zznsVarZzv.zze();
        }
        Object object = zzb.getObject(obj, iZzs);
        if (zzL(object)) {
            return object;
        }
        Object objZze = zznsVarZzv.zze();
        if (object != null) {
            zznsVarZzv.zzg(objZze, object);
        }
        return objZze;
    }

    private final Object zzy(Object obj, int i, int i2) {
        zzns zznsVarZzv = zzv(i2);
        if (!zzM(obj, i, i2)) {
            return zznsVarZzv.zze();
        }
        Object object = zzb.getObject(obj, zzs(i2) & 1048575);
        if (zzL(object)) {
            return object;
        }
        Object objZze = zznsVarZzv.zze();
        if (object != null) {
            zznsVarZzv.zzg(objZze, object);
        }
        return objZze;
    }

    private static Field zzz(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    /* JADX WARN: Code duplicated, block: B:137:0x038b  */
    /* JADX WARN: Code duplicated, block: B:207:0x054c  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v115, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v118, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v120, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v137 */
    /* JADX WARN: Type inference failed for: r0v185, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v256, types: [int] */
    /* JADX WARN: Type inference failed for: r0v264 */
    /* JADX WARN: Type inference failed for: r0v266 */
    /* JADX WARN: Type inference failed for: r0v267 */
    /* JADX WARN: Type inference failed for: r0v268 */
    /* JADX WARN: Type inference failed for: r0v269 */
    /* JADX WARN: Type inference failed for: r0v270 */
    /* JADX WARN: Type inference failed for: r0v271 */
    /* JADX WARN: Type inference failed for: r0v272 */
    /* JADX WARN: Type inference failed for: r0v273 */
    /* JADX WARN: Type inference failed for: r0v274 */
    /* JADX WARN: Type inference failed for: r0v275 */
    /* JADX WARN: Type inference failed for: r0v276 */
    /* JADX WARN: Type inference failed for: r0v277 */
    /* JADX WARN: Type inference failed for: r0v278 */
    /* JADX WARN: Type inference failed for: r0v279 */
    /* JADX WARN: Type inference failed for: r0v280 */
    /* JADX WARN: Type inference failed for: r0v281 */
    /* JADX WARN: Type inference failed for: r0v282 */
    /* JADX WARN: Type inference failed for: r0v283 */
    /* JADX WARN: Type inference failed for: r12v4, types: [int] */
    /* JADX WARN: Type inference failed for: r12v5, types: [int] */
    /* JADX WARN: Type inference failed for: r12v6, types: [int] */
    /* JADX WARN: Type inference failed for: r12v7, types: [int] */
    /* JADX WARN: Type inference failed for: r12v9, types: [int] */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v118, types: [int] */
    /* JADX WARN: Type inference failed for: r1v121, types: [int] */
    /* JADX WARN: Type inference failed for: r1v160 */
    /* JADX WARN: Type inference failed for: r1v163 */
    /* JADX WARN: Type inference failed for: r1v164 */
    /* JADX WARN: Type inference failed for: r1v166 */
    /* JADX WARN: Type inference failed for: r1v167 */
    /* JADX WARN: Type inference failed for: r1v168 */
    /* JADX WARN: Type inference failed for: r1v78, types: [int] */
    /* JADX WARN: Type inference failed for: r1v80 */
    /* JADX WARN: Type inference failed for: r2v31, types: [int] */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v37, types: [int] */
    /* JADX WARN: Type inference failed for: r2v41, types: [int] */
    /* JADX WARN: Type inference failed for: r2v45, types: [int] */
    /* JADX WARN: Type inference failed for: r2v53 */
    /* JADX WARN: Type inference failed for: r2v54, types: [int] */
    /* JADX WARN: Type inference failed for: r2v90 */
    /* JADX WARN: Type inference failed for: r2v91 */
    /* JADX WARN: Type inference failed for: r2v92 */
    /* JADX WARN: Type inference failed for: r2v93 */
    /* JADX WARN: Type inference failed for: r2v94 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28, types: [int] */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r3v31, types: [int] */
    /* JADX WARN: Type inference failed for: r3v36 */
    /* JADX WARN: Type inference failed for: r3v40, types: [int] */
    /* JADX WARN: Type inference failed for: r3v41 */
    /* JADX WARN: Type inference failed for: r3v47, types: [int] */
    /* JADX WARN: Type inference failed for: r3v52 */
    /* JADX WARN: Type inference failed for: r3v53 */
    /* JADX WARN: Type inference failed for: r3v54 */
    /* JADX WARN: Type inference failed for: r3v55 */
    /* JADX WARN: Type inference failed for: r3v56 */
    /* JADX WARN: Type inference failed for: r3v57 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v30, types: [int] */
    /* JADX WARN: Type inference failed for: r4v34 */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v37, types: [int] */
    /* JADX WARN: Type inference failed for: r4v38 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v58 */
    /* JADX WARN: Type inference failed for: r4v59 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [int] */
    @Override // com.google.android.gms.internal.measurement.zzns
    public final int zza(Object obj) {
        int i;
        ?? r16;
        ?? r5;
        int iZzz;
        int iZzz2;
        int iZzz3;
        int iZzA;
        int iZzz4;
        int iZzz5;
        int iZzd;
        int iZzz6;
        ?? Zzg;
        int size;
        int iZzz7;
        int iZzy;
        int iZzy2;
        ?? r3;
        int iZzx;
        ?? Zzz;
        ?? Zzh;
        int iZze;
        int iZzz8;
        int iZzz9;
        ?? r4;
        ?? r6;
        ?? r1;
        Unsafe unsafe = zzb;
        boolean z = false;
        int i2 = 1048575;
        ?? r2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1048575;
        while (true) {
            int[] iArr = this.zzc;
            if (i3 >= iArr.length) {
                int iZza = i4 + ((zzmd) obj).zzc.zza();
                if (!this.zzh) {
                    return iZza;
                }
                zzoa zzoaVar = ((zzma) obj).zzb.zza;
                int iZzc = zzoaVar.zzc();
                int iZzb = 0;
                for (int i6 = 0; i6 < iZzc; i6++) {
                    Map.Entry entryZzg = zzoaVar.zzg(i6);
                    iZzb += zzlu.zzb((zzlt) ((zznw) entryZzg).zza(), entryZzg.getValue());
                }
                for (Map.Entry entry : zzoaVar.zzd()) {
                    iZzb += zzlu.zzb((zzlt) entry.getKey(), entry.getValue());
                }
                return iZza + iZzb;
            }
            int iZzs = zzs(i3);
            int iZzr = zzr(iZzs);
            int i7 = iArr[i3];
            int i8 = iArr[i3 + 2];
            int i9 = i8 & i2;
            if (iZzr <= 17) {
                if (i9 != i5) {
                    r1 = i9 == i2 ? z : unsafe.getInt(obj, i9);
                    i5 = i9;
                }
                i = i5;
                r16 = r1;
                r5 = 1 << (i8 >>> 20);
            } else {
                r1 = r2;
                i = i5;
                r16 = r2 == true ? 1 : 0;
                r5 = z;
            }
            int i10 = iZzs & i2;
            if (iZzr >= zzlv.DOUBLE_LIST_PACKED.zza()) {
                zzlv.SINT64_LIST_PACKED.zza();
            }
            long j = i10;
            switch (iZzr) {
                case 0:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzz = zzlk.zzz(i7 << 3);
                        Zzh = iZzz + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 1:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzz2 = zzlk.zzz(i7 << 3);
                        Zzh = iZzz2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 2:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        long j2 = unsafe.getLong(obj, j);
                        iZzz3 = zzlk.zzz(i7 << 3);
                        iZzA = zzlk.zzA(j2);
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 3:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        long j3 = unsafe.getLong(obj, j);
                        iZzz3 = zzlk.zzz(i7 << 3);
                        iZzA = zzlk.zzA(j3);
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 4:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        long j4 = unsafe.getInt(obj, j);
                        iZzz3 = zzlk.zzz(i7 << 3);
                        iZzA = zzlk.zzA(j4);
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 5:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzz = zzlk.zzz(i7 << 3);
                        Zzh = iZzz + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 6:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzz2 = zzlk.zzz(i7 << 3);
                        Zzh = iZzz2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 7:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzz4 = zzlk.zzz(i7 << 3);
                        Zzh = iZzz4 + 1;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 8:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        int i11 = i7 << 3;
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof zzld) {
                            iZzz5 = zzlk.zzz(i11);
                            iZzd = ((zzld) object).zzd();
                            iZzz6 = zzlk.zzz(iZzd);
                            Zzh = iZzz5 + iZzz6 + iZzd;
                            i4 += Zzh;
                        } else {
                            iZzz3 = zzlk.zzz(i11);
                            iZzA = zzlk.zzy((String) object);
                            Zzh = iZzz3 + iZzA;
                            i4 += Zzh;
                        }
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 9:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        Zzh = zznu.zzh(i7, unsafe.getObject(obj, j), zzv(i3));
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 10:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        zzld zzldVar = (zzld) unsafe.getObject(obj, j);
                        iZzz5 = zzlk.zzz(i7 << 3);
                        iZzd = zzldVar.zzd();
                        iZzz6 = zzlk.zzz(iZzd);
                        Zzh = iZzz5 + iZzz6 + iZzd;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 11:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        int i12 = unsafe.getInt(obj, j);
                        iZzz3 = zzlk.zzz(i7 << 3);
                        iZzA = zzlk.zzz(i12);
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 12:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        long j5 = unsafe.getInt(obj, j);
                        iZzz3 = zzlk.zzz(i7 << 3);
                        iZzA = zzlk.zzA(j5);
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 13:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzz2 = zzlk.zzz(i7 << 3);
                        Zzh = iZzz2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 14:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzz = zzlk.zzz(i7 << 3);
                        Zzh = iZzz + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 15:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        int i13 = unsafe.getInt(obj, j);
                        iZzz3 = zzlk.zzz(i7 << 3);
                        iZzA = zzlk.zzz((i13 >> 31) ^ (i13 + i13));
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 16:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        long j6 = unsafe.getLong(obj, j);
                        iZzz3 = zzlk.zzz(i7 << 3);
                        iZzA = zzlk.zzA((j6 >> 63) ^ (j6 + j6));
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 17:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        Zzh = zzlk.zzw(i7, (zznh) unsafe.getObject(obj, j), zzv(i3));
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 18:
                    Zzh = zznu.zzd(i7, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 19:
                    Zzh = zznu.zzb(i7, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(obj, j);
                    int i14 = zznu.zza;
                    if (list.size() == 0) {
                        Zzg = z;
                    } else {
                        Zzg = zznu.zzg(list) + (list.size() * zzlk.zzz(i7 << 3));
                    }
                    i4 += Zzg;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 21:
                    List list2 = (List) unsafe.getObject(obj, j);
                    int i15 = zznu.zza;
                    size = list2.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzz3 = zznu.zzl(list2);
                        iZzz7 = zzlk.zzz(i7 << 3);
                        iZzA = size * iZzz7;
                        Zzh = iZzz3 + iZzA;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 22:
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i16 = zznu.zza;
                    size = list3.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzz3 = zznu.zzf(list3);
                        iZzz7 = zzlk.zzz(i7 << 3);
                        iZzA = size * iZzz7;
                        Zzh = iZzz3 + iZzA;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 23:
                    Zzh = zznu.zzd(i7, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 24:
                    Zzh = zznu.zzb(i7, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 25:
                    List list4 = (List) unsafe.getObject(obj, j);
                    int i17 = zznu.zza;
                    int size2 = list4.size();
                    if (size2 == 0) {
                        Zzh = z;
                    } else {
                        Zzh = size2 * (zzlk.zzz(i7 << 3) + 1);
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 26:
                    ?? r0 = (List) unsafe.getObject(obj, j);
                    int i18 = zznu.zza;
                    int size3 = r0.size();
                    if (size3 == 0) {
                        Zzg = z;
                    } else {
                        int iZzz10 = zzlk.zzz(i7 << 3) * size3;
                        if (r0 instanceof zzmt) {
                            zzmt zzmtVar = (zzmt) r0;
                            for (?? r7 = z; r7 < size3; r7++) {
                                Object objZzc = zzmtVar.zzc();
                                if (objZzc instanceof zzld) {
                                    Zzg = iZzz10;
                                    int iZzd2 = ((zzld) objZzc).zzd();
                                    iZzy2 = Zzg + zzlk.zzz(iZzd2) + iZzd2;
                                } else {
                                    Zzg = iZzz10;
                                    iZzy2 = Zzg + zzlk.zzy((String) objZzc);
                                }
                                Zzg = iZzy2;
                            }
                            Zzg = iZzz10;
                        } else {
                            for (?? r8 = z; r8 < size3; r8++) {
                                Object obj2 = r0.get(r8);
                                if (obj2 instanceof zzld) {
                                    Zzg = iZzz10;
                                    int iZzd3 = ((zzld) obj2).zzd();
                                    iZzy = Zzg + zzlk.zzz(iZzd3) + iZzd3;
                                } else {
                                    Zzg = iZzz10;
                                    iZzy = Zzg + zzlk.zzy((String) obj2);
                                }
                                Zzg = iZzy;
                            }
                            Zzg = iZzz10;
                        }
                    }
                    i4 += Zzg;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case MotionEventCompat.AXIS_RELATIVE_X /* 27 */:
                    ?? r9 = (List) unsafe.getObject(obj, j);
                    zzns zznsVarZzv = zzv(i3);
                    int i19 = zznu.zza;
                    int size4 = r9.size();
                    if (size4 == 0) {
                        r3 = z;
                    } else {
                        int iZzz11 = zzlk.zzz(i7 << 3) * size4;
                        for (?? r10 = z; r10 < size4; r10++) {
                            Object obj3 = r9.get(r10);
                            if (obj3 instanceof zzms) {
                                r3 = iZzz11;
                                int iZza2 = ((zzms) obj3).zza();
                                iZzx = (r3 == true ? 1 : 0) + zzlk.zzz(iZza2) + iZza2;
                            } else {
                                r3 = iZzz11;
                                iZzx = (r3 == true ? 1 : 0) + zzlk.zzx((zznh) obj3, zznsVarZzv);
                            }
                            r3 = iZzx;
                        }
                        r3 = iZzz11;
                    }
                    i4 += r3;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case MotionEventCompat.AXIS_RELATIVE_Y /* 28 */:
                    ?? r11 = (List) unsafe.getObject(obj, j);
                    int i20 = zznu.zza;
                    int size5 = r11.size();
                    if (size5 == 0) {
                        Zzz = z;
                    } else {
                        Zzz = size5 * zzlk.zzz(i7 << 3);
                        for (?? r12 = z; r12 < r11.size(); r12++) {
                            int iZzd4 = ((zzld) r11.get(r12)).zzd();
                            Zzz += zzlk.zzz(iZzd4) + iZzd4;
                        }
                    }
                    i4 += Zzz;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 29:
                    List list5 = (List) unsafe.getObject(obj, j);
                    int i21 = zznu.zza;
                    size = list5.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzz3 = zznu.zzk(list5);
                        iZzz7 = zzlk.zzz(i7 << 3);
                        iZzA = size * iZzz7;
                        Zzh = iZzz3 + iZzA;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 30:
                    List list6 = (List) unsafe.getObject(obj, j);
                    int i22 = zznu.zza;
                    size = list6.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzz3 = zznu.zza(list6);
                        iZzz7 = zzlk.zzz(i7 << 3);
                        iZzA = size * iZzz7;
                        Zzh = iZzz3 + iZzA;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 31:
                    Zzh = zznu.zzb(i7, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 32:
                    Zzh = zznu.zzd(i7, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 33:
                    List list7 = (List) unsafe.getObject(obj, j);
                    int i23 = zznu.zza;
                    size = list7.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzz3 = zznu.zzi(list7);
                        iZzz7 = zzlk.zzz(i7 << 3);
                        iZzA = size * iZzz7;
                        Zzh = iZzz3 + iZzA;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_3 /* 34 */:
                    List list8 = (List) unsafe.getObject(obj, j);
                    int i24 = zznu.zza;
                    size = list8.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzz3 = zznu.zzj(list8);
                        iZzz7 = zzlk.zzz(i7 << 3);
                        iZzA = size * iZzz7;
                        Zzh = iZzz3 + iZzA;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_4 /* 35 */:
                    iZze = zznu.zze((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzlk.zzz(i7 << 3);
                        iZzz9 = zzlk.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 36:
                    iZze = zznu.zzc((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzlk.zzz(i7 << 3);
                        iZzz9 = zzlk.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_6 /* 37 */:
                    iZze = zznu.zzg((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzlk.zzz(i7 << 3);
                        iZzz9 = zzlk.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                    iZze = zznu.zzl((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzlk.zzz(i7 << 3);
                        iZzz9 = zzlk.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_8 /* 39 */:
                    iZze = zznu.zzf((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzlk.zzz(i7 << 3);
                        iZzz9 = zzlk.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_9 /* 40 */:
                    iZze = zznu.zze((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzlk.zzz(i7 << 3);
                        iZzz9 = zzlk.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_10 /* 41 */:
                    iZze = zznu.zzc((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzlk.zzz(i7 << 3);
                        iZzz9 = zzlk.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                    List list9 = (List) unsafe.getObject(obj, j);
                    int i25 = zznu.zza;
                    iZze = list9.size();
                    if (iZze > 0) {
                        iZzz8 = zzlk.zzz(i7 << 3);
                        iZzz9 = zzlk.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                    iZze = zznu.zzk((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzlk.zzz(i7 << 3);
                        iZzz9 = zzlk.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                    iZze = zznu.zza((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzlk.zzz(i7 << 3);
                        iZzz9 = zzlk.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                    iZze = zznu.zzc((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzlk.zzz(i7 << 3);
                        iZzz9 = zzlk.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                    iZze = zznu.zze((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzlk.zzz(i7 << 3);
                        iZzz9 = zzlk.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                    iZze = zznu.zzi((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzlk.zzz(i7 << 3);
                        iZzz9 = zzlk.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 48:
                    iZze = zznu.zzj((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzlk.zzz(i7 << 3);
                        iZzz9 = zzlk.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 49:
                    ?? r13 = (List) unsafe.getObject(obj, j);
                    zzns zznsVarZzv2 = zzv(i3);
                    int i26 = zznu.zza;
                    int size6 = r13.size();
                    if (size6 == 0) {
                        r4 = z;
                    } else {
                        boolean z2 = z;
                        r4 = z2;
                        while (r6 < size6) {
                            r6 = z2;
                            int iZzw = zzlk.zzw(i7, (zznh) r13.get(r6), zznsVarZzv2);
                            r6++;
                            r4 = (r4 == true ? 1 : 0) + iZzw;
                        }
                        r6 = z2;
                    }
                    i4 += r4;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH /* 50 */:
                    zznb zznbVar = (zznb) unsafe.getObject(obj, j);
                    if (zznbVar.isEmpty()) {
                        continue;
                    } else {
                        Iterator it = zznbVar.entrySet().iterator();
                        if (it.hasNext()) {
                            Map.Entry entry2 = (Map.Entry) it.next();
                            entry2.getKey();
                            entry2.getValue();
                            throw null;
                        }
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                case 51:
                    if (zzM(obj, i7, i3)) {
                        iZzz = zzlk.zzz(i7 << 3);
                        Zzh = iZzz + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 52:
                    if (zzM(obj, i7, i3)) {
                        iZzz2 = zzlk.zzz(i7 << 3);
                        Zzh = iZzz2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 53:
                    if (zzM(obj, i7, i3)) {
                        long jZzt = zzt(obj, j);
                        iZzz3 = zzlk.zzz(i7 << 3);
                        iZzA = zzlk.zzA(jZzt);
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 54:
                    if (zzM(obj, i7, i3)) {
                        long jZzt2 = zzt(obj, j);
                        iZzz3 = zzlk.zzz(i7 << 3);
                        iZzA = zzlk.zzA(jZzt2);
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 55:
                    if (zzM(obj, i7, i3)) {
                        long jZzo = zzo(obj, j);
                        iZzz3 = zzlk.zzz(i7 << 3);
                        iZzA = zzlk.zzA(jZzo);
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 56:
                    if (zzM(obj, i7, i3)) {
                        iZzz = zzlk.zzz(i7 << 3);
                        Zzh = iZzz + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 57:
                    if (zzM(obj, i7, i3)) {
                        iZzz2 = zzlk.zzz(i7 << 3);
                        Zzh = iZzz2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 58:
                    if (zzM(obj, i7, i3)) {
                        iZzz4 = zzlk.zzz(i7 << 3);
                        Zzh = iZzz4 + 1;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 59:
                    if (zzM(obj, i7, i3)) {
                        int i27 = i7 << 3;
                        Object object2 = unsafe.getObject(obj, j);
                        if (object2 instanceof zzld) {
                            iZzz5 = zzlk.zzz(i27);
                            iZzd = ((zzld) object2).zzd();
                            iZzz6 = zzlk.zzz(iZzd);
                            Zzh = iZzz5 + iZzz6 + iZzd;
                            i4 += Zzh;
                        } else {
                            iZzz3 = zzlk.zzz(i27);
                            iZzA = zzlk.zzy((String) object2);
                            Zzh = iZzz3 + iZzA;
                            i4 += Zzh;
                        }
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                    if (zzM(obj, i7, i3)) {
                        Zzh = zznu.zzh(i7, unsafe.getObject(obj, j), zzv(i3));
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzM(obj, i7, i3)) {
                        zzld zzldVar2 = (zzld) unsafe.getObject(obj, j);
                        iZzz5 = zzlk.zzz(i7 << 3);
                        iZzd = zzldVar2.zzd();
                        iZzz6 = zzlk.zzz(iZzd);
                        Zzh = iZzz5 + iZzz6 + iZzd;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 62:
                    if (zzM(obj, i7, i3)) {
                        int iZzo = zzo(obj, j);
                        iZzz3 = zzlk.zzz(i7 << 3);
                        iZzA = zzlk.zzz(iZzo);
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (zzM(obj, i7, i3)) {
                        long jZzo2 = zzo(obj, j);
                        iZzz3 = zzlk.zzz(i7 << 3);
                        iZzA = zzlk.zzA(jZzo2);
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 64:
                    if (zzM(obj, i7, i3)) {
                        iZzz2 = zzlk.zzz(i7 << 3);
                        Zzh = iZzz2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (zzM(obj, i7, i3)) {
                        iZzz = zzlk.zzz(i7 << 3);
                        Zzh = iZzz + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 66:
                    if (zzM(obj, i7, i3)) {
                        int iZzo2 = zzo(obj, j);
                        iZzz3 = zzlk.zzz(i7 << 3);
                        iZzA = zzlk.zzz((iZzo2 >> 31) ^ (iZzo2 + iZzo2));
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 67:
                    if (zzM(obj, i7, i3)) {
                        long jZzt3 = zzt(obj, j);
                        iZzz3 = zzlk.zzz(i7 << 3);
                        iZzA = zzlk.zzA((jZzt3 >> 63) ^ (jZzt3 + jZzt3));
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 68:
                    if (zzM(obj, i7, i3)) {
                        Zzh = zzlk.zzw(i7, (zznh) unsafe.getObject(obj, j), zzv(i3));
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                default:
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzns
    public final int zzb(Object obj) {
        int i;
        long jDoubleToLongBits;
        int iFloatToIntBits;
        int i2;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i3 >= iArr.length) {
                int iHashCode = (i4 * 53) + ((zzmd) obj).zzc.hashCode();
                return this.zzh ? (iHashCode * 53) + ((zzma) obj).zzb.zza.hashCode() : iHashCode;
            }
            int iZzs = zzs(i3);
            int i5 = 1048575 & iZzs;
            int iZzr = zzr(iZzs);
            int i6 = iArr[i3];
            long j = i5;
            int iHashCode2 = 37;
            switch (iZzr) {
                case 0:
                    i = i4 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzol.zza(obj, j));
                    byte[] bArr = zzmk.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 1:
                    i = i4 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzol.zzb(obj, j));
                    i4 = i + iFloatToIntBits;
                    break;
                case 2:
                    i = i4 * 53;
                    jDoubleToLongBits = zzol.zzd(obj, j);
                    byte[] bArr2 = zzmk.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 3:
                    i = i4 * 53;
                    jDoubleToLongBits = zzol.zzd(obj, j);
                    byte[] bArr3 = zzmk.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 4:
                    i = i4 * 53;
                    iFloatToIntBits = zzol.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 5:
                    i = i4 * 53;
                    jDoubleToLongBits = zzol.zzd(obj, j);
                    byte[] bArr4 = zzmk.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 6:
                    i = i4 * 53;
                    iFloatToIntBits = zzol.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 7:
                    i = i4 * 53;
                    iFloatToIntBits = zzmk.zza(zzol.zzw(obj, j));
                    i4 = i + iFloatToIntBits;
                    break;
                case 8:
                    i = i4 * 53;
                    iFloatToIntBits = ((String) zzol.zzf(obj, j)).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 9:
                    i2 = i4 * 53;
                    Object objZzf = zzol.zzf(obj, j);
                    if (objZzf != null) {
                        iHashCode2 = objZzf.hashCode();
                    }
                    i4 = i2 + iHashCode2;
                    break;
                case 10:
                    i = i4 * 53;
                    iFloatToIntBits = zzol.zzf(obj, j).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 11:
                    i = i4 * 53;
                    iFloatToIntBits = zzol.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 12:
                    i = i4 * 53;
                    iFloatToIntBits = zzol.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 13:
                    i = i4 * 53;
                    iFloatToIntBits = zzol.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 14:
                    i = i4 * 53;
                    jDoubleToLongBits = zzol.zzd(obj, j);
                    byte[] bArr5 = zzmk.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 15:
                    i = i4 * 53;
                    iFloatToIntBits = zzol.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 16:
                    i = i4 * 53;
                    jDoubleToLongBits = zzol.zzd(obj, j);
                    byte[] bArr6 = zzmk.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 17:
                    i2 = i4 * 53;
                    Object objZzf2 = zzol.zzf(obj, j);
                    if (objZzf2 != null) {
                        iHashCode2 = objZzf2.hashCode();
                    }
                    i4 = i2 + iHashCode2;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case MotionEventCompat.AXIS_RELATIVE_X /* 27 */:
                case MotionEventCompat.AXIS_RELATIVE_Y /* 28 */:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case MotionEventCompat.AXIS_GENERIC_3 /* 34 */:
                case MotionEventCompat.AXIS_GENERIC_4 /* 35 */:
                case 36:
                case MotionEventCompat.AXIS_GENERIC_6 /* 37 */:
                case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                case MotionEventCompat.AXIS_GENERIC_8 /* 39 */:
                case MotionEventCompat.AXIS_GENERIC_9 /* 40 */:
                case MotionEventCompat.AXIS_GENERIC_10 /* 41 */:
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                case 48:
                case 49:
                    i = i4 * 53;
                    iFloatToIntBits = zzol.zzf(obj, j).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH /* 50 */:
                    i = i4 * 53;
                    iFloatToIntBits = zzol.zzf(obj, j).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 51:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzm(obj, j));
                        byte[] bArr7 = zzmk.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 52:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzn(obj, j));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 53:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr8 = zzmk.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 54:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr9 = zzmk.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 55:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 56:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr10 = zzmk.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 57:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 58:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzmk.zza(zzN(obj, j));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 59:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = ((String) zzol.zzf(obj, j)).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzol.zzf(obj, j).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzol.zzf(obj, j).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 62:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 64:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr11 = zzmk.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 66:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 67:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr12 = zzmk.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 68:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzol.zzf(obj, j).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
            }
            i3 += 3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0268  */
    /* JADX WARN: Code duplicated, block: B:104:0x0287  */
    /* JADX WARN: Code duplicated, block: B:106:0x028b  */
    /* JADX WARN: Code duplicated, block: B:115:0x02e3  */
    /* JADX WARN: Code duplicated, block: B:117:0x02f2  */
    /* JADX WARN: Code duplicated, block: B:119:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:120:0x02f8  */
    /* JADX WARN: Code duplicated, block: B:129:0x0333  */
    /* JADX WARN: Code duplicated, block: B:130:0x0335  */
    /* JADX WARN: Code duplicated, block: B:161:0x0422  */
    /* JADX WARN: Code duplicated, block: B:163:0x0428  */
    /* JADX WARN: Code duplicated, block: B:164:0x042b  */
    /* JADX WARN: Code duplicated, block: B:170:0x0467  */
    /* JADX WARN: Code duplicated, block: B:172:0x047c  */
    /* JADX WARN: Code duplicated, block: B:173:0x048d  */
    /* JADX WARN: Code duplicated, block: B:176:0x0495  */
    /* JADX WARN: Code duplicated, block: B:178:0x04a3  */
    /* JADX WARN: Code duplicated, block: B:179:0x04c0  */
    /* JADX WARN: Code duplicated, block: B:181:0x04c3  */
    /* JADX WARN: Code duplicated, block: B:183:0x04d0 A[LOOP:3: B:182:0x04ce->B:183:0x04d0, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:185:0x04e0  */
    /* JADX WARN: Code duplicated, block: B:188:0x04ee A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:189:0x04f0  */
    /* JADX WARN: Code duplicated, block: B:191:0x0503  */
    /* JADX WARN: Code duplicated, block: B:193:0x050d A[LOOP:4: B:190:0x0501->B:193:0x050d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:195:0x0520  */
    /* JADX WARN: Code duplicated, block: B:196:0x0527  */
    /* JADX WARN: Code duplicated, block: B:198:0x052c  */
    /* JADX WARN: Code duplicated, block: B:200:0x0539 A[LOOP:5: B:199:0x0537->B:200:0x0539, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:205:0x0550 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:206:0x0552  */
    /* JADX WARN: Code duplicated, block: B:208:0x0565  */
    /* JADX WARN: Code duplicated, block: B:210:0x056d A[LOOP:6: B:207:0x0563->B:210:0x056d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:213:0x0587  */
    /* JADX WARN: Code duplicated, block: B:215:0x058c  */
    /* JADX WARN: Code duplicated, block: B:216:0x0599 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:217:0x059b  */
    /* JADX WARN: Code duplicated, block: B:220:0x05ba  */
    /* JADX WARN: Code duplicated, block: B:222:0x05be  */
    /* JADX WARN: Code duplicated, block: B:224:0x05cb  */
    /* JADX WARN: Code duplicated, block: B:226:0x05dd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:227:0x05df  */
    /* JADX WARN: Code duplicated, block: B:229:0x05e9  */
    /* JADX WARN: Code duplicated, block: B:233:0x05f6  */
    /* JADX WARN: Code duplicated, block: B:234:0x05fe  */
    /* JADX WARN: Code duplicated, block: B:237:0x060e  */
    /* JADX WARN: Code duplicated, block: B:240:0x0626  */
    /* JADX WARN: Code duplicated, block: B:245:0x063f  */
    /* JADX WARN: Code duplicated, block: B:247:0x064c  */
    /* JADX WARN: Code duplicated, block: B:249:0x0654  */
    /* JADX WARN: Code duplicated, block: B:251:0x0658 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:252:0x065a  */
    /* JADX WARN: Code duplicated, block: B:253:0x0660  */
    /* JADX WARN: Code duplicated, block: B:256:0x066a  */
    /* JADX WARN: Code duplicated, block: B:258:0x0672  */
    /* JADX WARN: Code duplicated, block: B:260:0x067a  */
    /* JADX WARN: Code duplicated, block: B:262:0x067e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:26:0x006a  */
    /* JADX WARN: Code duplicated, block: B:274:0x06ab  */
    /* JADX WARN: Code duplicated, block: B:275:0x06b0  */
    /* JADX WARN: Code duplicated, block: B:277:0x06bd  */
    /* JADX WARN: Code duplicated, block: B:278:0x06e0  */
    /* JADX WARN: Code duplicated, block: B:280:0x06e7  */
    /* JADX WARN: Code duplicated, block: B:282:0x06f5  */
    /* JADX WARN: Code duplicated, block: B:284:0x06fd  */
    /* JADX WARN: Code duplicated, block: B:286:0x0705 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:287:0x0707  */
    /* JADX WARN: Code duplicated, block: B:288:0x070d  */
    /* JADX WARN: Code duplicated, block: B:291:0x071c  */
    /* JADX WARN: Code duplicated, block: B:293:0x0724  */
    /* JADX WARN: Code duplicated, block: B:295:0x072c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:303:0x0750  */
    /* JADX WARN: Code duplicated, block: B:305:0x075a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:306:0x075c  */
    /* JADX WARN: Code duplicated, block: B:307:0x0762  */
    /* JADX WARN: Code duplicated, block: B:309:0x076a  */
    /* JADX WARN: Code duplicated, block: B:30:0x00a8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:311:0x0779  */
    /* JADX WARN: Code duplicated, block: B:313:0x0781  */
    /* JADX WARN: Code duplicated, block: B:315:0x0789 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:319:0x0797  */
    /* JADX WARN: Code duplicated, block: B:31:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:328:0x07bf  */
    /* JADX WARN: Code duplicated, block: B:329:0x07c5  */
    /* JADX WARN: Code duplicated, block: B:331:0x07d1  */
    /* JADX WARN: Code duplicated, block: B:333:0x07df  */
    /* JADX WARN: Code duplicated, block: B:335:0x07e9  */
    /* JADX WARN: Code duplicated, block: B:336:0x07eb  */
    /* JADX WARN: Code duplicated, block: B:33:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:342:0x07fb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:343:0x07fd  */
    /* JADX WARN: Code duplicated, block: B:345:0x080c  */
    /* JADX WARN: Code duplicated, block: B:346:0x080e  */
    /* JADX WARN: Code duplicated, block: B:349:0x0815  */
    /* JADX WARN: Code duplicated, block: B:34:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:351:0x081d  */
    /* JADX WARN: Code duplicated, block: B:353:0x0827  */
    /* JADX WARN: Code duplicated, block: B:354:0x0829  */
    /* JADX WARN: Code duplicated, block: B:356:0x082f  */
    /* JADX WARN: Code duplicated, block: B:358:0x083b  */
    /* JADX WARN: Code duplicated, block: B:360:0x084b  */
    /* JADX WARN: Code duplicated, block: B:362:0x0857 A[LOOP:14: B:361:0x0855->B:362:0x0857, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:369:0x0871  */
    /* JADX WARN: Code duplicated, block: B:36:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:371:0x0874  */
    /* JADX WARN: Code duplicated, block: B:373:0x0884  */
    /* JADX WARN: Code duplicated, block: B:375:0x088c A[LOOP:15: B:372:0x0882->B:375:0x088c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:376:0x0896  */
    /* JADX WARN: Code duplicated, block: B:378:0x08a2  */
    /* JADX WARN: Code duplicated, block: B:380:0x08b2  */
    /* JADX WARN: Code duplicated, block: B:382:0x08be A[LOOP:16: B:381:0x08bc->B:382:0x08be, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:389:0x08d7  */
    /* JADX WARN: Code duplicated, block: B:391:0x08da  */
    /* JADX WARN: Code duplicated, block: B:393:0x08ea  */
    /* JADX WARN: Code duplicated, block: B:395:0x08f2 A[LOOP:17: B:392:0x08e8->B:395:0x08f2, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:396:0x08fc  */
    /* JADX WARN: Code duplicated, block: B:398:0x0908  */
    /* JADX WARN: Code duplicated, block: B:400:0x0914 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:401:0x0916  */
    /* JADX WARN: Code duplicated, block: B:402:0x0929 A[PHI: r1 r4 r6 r14 r35
  0x0929: PHI (r1v163 int) = (r1v155 int), (r1v157 int), (r1v160 int), (r1v164 int) binds: [B:400:0x0914, B:390:0x08d8, B:370:0x0872, B:342:0x07fb] A[DONT_GENERATE, DONT_INLINE]
  0x0929: PHI (r4v66 com.google.android.gms.internal.measurement.zzks) = 
  (r4v62 com.google.android.gms.internal.measurement.zzks)
  (r4v64 com.google.android.gms.internal.measurement.zzks)
  (r4v65 com.google.android.gms.internal.measurement.zzks)
  (r4v67 com.google.android.gms.internal.measurement.zzks)
 binds: [B:400:0x0914, B:390:0x08d8, B:370:0x0872, B:342:0x07fb] A[DONT_GENERATE, DONT_INLINE]
  0x0929: PHI (r6v70 int) = (r6v66 int), (r6v68 int), (r6v69 int), (r6v71 int) binds: [B:400:0x0914, B:390:0x08d8, B:370:0x0872, B:342:0x07fb] A[DONT_GENERATE, DONT_INLINE]
  0x0929: PHI (r14v69 int) = (r14v66 int), (r14v67 int), (r14v68 int), (r14v70 int) binds: [B:400:0x0914, B:390:0x08d8, B:370:0x0872, B:342:0x07fb] A[DONT_GENERATE, DONT_INLINE]
  0x0929: PHI (r35v8 sun.misc.Unsafe) = (r35v5 sun.misc.Unsafe), (r35v6 sun.misc.Unsafe), (r35v7 sun.misc.Unsafe), (r35v9 sun.misc.Unsafe) binds: [B:400:0x0914, B:390:0x08d8, B:370:0x0872, B:342:0x07fb] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:403:0x0930  */
    /* JADX WARN: Code duplicated, block: B:405:0x093e  */
    /* JADX WARN: Code duplicated, block: B:407:0x094c A[LOOP:18: B:406:0x094a->B:407:0x094c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:412:0x095f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:413:0x0961  */
    /* JADX WARN: Code duplicated, block: B:415:0x0971  */
    /* JADX WARN: Code duplicated, block: B:417:0x0979 A[LOOP:19: B:414:0x096f->B:417:0x0979, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:419:0x0986  */
    /* JADX WARN: Code duplicated, block: B:421:0x0994  */
    /* JADX WARN: Code duplicated, block: B:423:0x09a4  */
    /* JADX WARN: Code duplicated, block: B:425:0x09b0 A[LOOP:20: B:424:0x09ae->B:425:0x09b0, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:432:0x09cd  */
    /* JADX WARN: Code duplicated, block: B:434:0x09d0  */
    /* JADX WARN: Code duplicated, block: B:436:0x09e4  */
    /* JADX WARN: Code duplicated, block: B:438:0x09ec A[LOOP:21: B:435:0x09e2->B:438:0x09ec, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:439:0x09fa  */
    /* JADX WARN: Code duplicated, block: B:441:0x0a08  */
    /* JADX WARN: Code duplicated, block: B:443:0x0a18  */
    /* JADX WARN: Code duplicated, block: B:445:0x0a24 A[LOOP:22: B:444:0x0a22->B:445:0x0a24, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:452:0x0a44  */
    /* JADX WARN: Code duplicated, block: B:454:0x0a47  */
    /* JADX WARN: Code duplicated, block: B:456:0x0a5b  */
    /* JADX WARN: Code duplicated, block: B:458:0x0a63 A[LOOP:23: B:455:0x0a59->B:458:0x0a63, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:460:0x0a73  */
    /* JADX WARN: Code duplicated, block: B:462:0x0a7b A[LOOP:2: B:459:0x0a71->B:462:0x0a7b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:463:0x0a8e A[PHI: r9 r10 r11 r13 r14 r35
  0x0a8e: PHI (r9v73 com.google.android.gms.internal.measurement.zzks) = 
  (r9v38 com.google.android.gms.internal.measurement.zzks)
  (r9v39 com.google.android.gms.internal.measurement.zzks)
  (r9v41 com.google.android.gms.internal.measurement.zzks)
  (r9v50 com.google.android.gms.internal.measurement.zzks)
  (r9v52 com.google.android.gms.internal.measurement.zzks)
  (r9v61 com.google.android.gms.internal.measurement.zzks)
  (r1v86 com.google.android.gms.internal.measurement.zzks)
  (r9v76 com.google.android.gms.internal.measurement.zzks)
 binds: [B:453:0x0a45, B:433:0x09ce, B:412:0x095f, B:402:0x0929, B:328:0x07bf, B:279:0x06e4, B:244:0x0638, B:177:0x04a1] A[DONT_GENERATE, DONT_INLINE]
  0x0a8e: PHI (r10v79 int) = (r10v39 int), (r10v40 int), (r10v42 int), (r10v44 int), (r10v56 int), (r10v68 int), (r10v74 int), (r10v83 int) binds: [B:453:0x0a45, B:433:0x09ce, B:412:0x095f, B:402:0x0929, B:328:0x07bf, B:279:0x06e4, B:244:0x0638, B:177:0x04a1] A[DONT_GENERATE, DONT_INLINE]
  0x0a8e: PHI (r11v70 int) = (r11v30 int), (r11v31 int), (r11v33 int), (r11v43 int), (r11v49 int), (r11v59 int), (r11v66 int), (r11v74 int) binds: [B:453:0x0a45, B:433:0x09ce, B:412:0x095f, B:402:0x0929, B:328:0x07bf, B:279:0x06e4, B:244:0x0638, B:177:0x04a1] A[DONT_GENERATE, DONT_INLINE]
  0x0a8e: PHI (r13v91 int) = (r13v61 int), (r13v62 int), (r13v64 int), (r13v66 int), (r13v68 int), (r13v73 int), (r13v86 int), (r13v94 int) binds: [B:453:0x0a45, B:433:0x09ce, B:412:0x095f, B:402:0x0929, B:328:0x07bf, B:279:0x06e4, B:244:0x0638, B:177:0x04a1] A[DONT_GENERATE, DONT_INLINE]
  0x0a8e: PHI (r14v84 int) = (r14v62 int), (r14v63 int), (r14v65 int), (r14v69 int), (r14v72 int), (r14v76 int), (r14v82 int), (r14v86 int) binds: [B:453:0x0a45, B:433:0x09ce, B:412:0x095f, B:402:0x0929, B:328:0x07bf, B:279:0x06e4, B:244:0x0638, B:177:0x04a1] A[DONT_GENERATE, DONT_INLINE]
  0x0a8e: PHI (r35v25 sun.misc.Unsafe) = 
  (r35v1 sun.misc.Unsafe)
  (r35v2 sun.misc.Unsafe)
  (r35v4 sun.misc.Unsafe)
  (r35v8 sun.misc.Unsafe)
  (r35v11 sun.misc.Unsafe)
  (r35v14 sun.misc.Unsafe)
  (r14v34 sun.misc.Unsafe)
  (r35v27 sun.misc.Unsafe)
 binds: [B:453:0x0a45, B:433:0x09ce, B:412:0x095f, B:402:0x0929, B:328:0x07bf, B:279:0x06e4, B:244:0x0638, B:177:0x04a1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:467:0x0ab1  */
    /* JADX WARN: Code duplicated, block: B:473:0x0ad8  */
    /* JADX WARN: Code duplicated, block: B:476:0x0ae9  */
    /* JADX WARN: Code duplicated, block: B:478:0x0af6  */
    /* JADX WARN: Code duplicated, block: B:480:0x0b0f A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:483:0x0b18  */
    /* JADX WARN: Code duplicated, block: B:485:0x0b1b  */
    /* JADX WARN: Code duplicated, block: B:486:0x0b44  */
    /* JADX WARN: Code duplicated, block: B:488:0x0b49  */
    /* JADX WARN: Code duplicated, block: B:489:0x0b60  */
    /* JADX WARN: Code duplicated, block: B:491:0x0b67  */
    /* JADX WARN: Code duplicated, block: B:493:0x0b80  */
    /* JADX WARN: Code duplicated, block: B:495:0x0b87  */
    /* JADX WARN: Code duplicated, block: B:501:0x0ba9  */
    /* JADX WARN: Code duplicated, block: B:503:0x0bbb  */
    /* JADX WARN: Code duplicated, block: B:505:0x0bc1  */
    /* JADX WARN: Code duplicated, block: B:509:0x0bd7  */
    /* JADX WARN: Code duplicated, block: B:510:0x0bdc  */
    /* JADX WARN: Code duplicated, block: B:512:0x0be0  */
    /* JADX WARN: Code duplicated, block: B:513:0x0c05  */
    /* JADX WARN: Code duplicated, block: B:514:0x0c0e  */
    /* JADX WARN: Code duplicated, block: B:516:0x0c1d  */
    /* JADX WARN: Code duplicated, block: B:518:0x0c25  */
    /* JADX WARN: Code duplicated, block: B:519:0x0c2d  */
    /* JADX WARN: Code duplicated, block: B:528:0x0c55  */
    /* JADX WARN: Code duplicated, block: B:529:0x0c59  */
    /* JADX WARN: Code duplicated, block: B:531:0x0c64  */
    /* JADX WARN: Code duplicated, block: B:533:0x0c6e  */
    /* JADX WARN: Code duplicated, block: B:534:0x0c71  */
    /* JADX WARN: Code duplicated, block: B:536:0x0c7f  */
    /* JADX WARN: Code duplicated, block: B:538:0x0c8b  */
    /* JADX WARN: Code duplicated, block: B:539:0x0c9d  */
    /* JADX WARN: Code duplicated, block: B:541:0x0ca9  */
    /* JADX WARN: Code duplicated, block: B:542:0x0cbb  */
    /* JADX WARN: Code duplicated, block: B:544:0x0cc6  */
    /* JADX WARN: Code duplicated, block: B:545:0x0cd8  */
    /* JADX WARN: Code duplicated, block: B:547:0x0ce3  */
    /* JADX WARN: Code duplicated, block: B:548:0x0cf4  */
    /* JADX WARN: Code duplicated, block: B:550:0x0d00  */
    /* JADX WARN: Code duplicated, block: B:551:0x0d15  */
    /* JADX WARN: Code duplicated, block: B:553:0x0d21  */
    /* JADX WARN: Code duplicated, block: B:554:0x0d36 A[PHI: r6 r13 r14 r29 r36
  0x0d36: PHI (r6v57 sun.misc.Unsafe) = 
  (r6v43 sun.misc.Unsafe)
  (r6v44 sun.misc.Unsafe)
  (r6v45 sun.misc.Unsafe)
  (r6v46 sun.misc.Unsafe)
  (r6v47 sun.misc.Unsafe)
  (r6v48 sun.misc.Unsafe)
  (r6v49 sun.misc.Unsafe)
  (r6v50 sun.misc.Unsafe)
  (r6v51 sun.misc.Unsafe)
  (r6v58 sun.misc.Unsafe)
 binds: [B:552:0x0d1f, B:549:0x0cfe, B:546:0x0ce1, B:543:0x0cc4, B:540:0x0ca7, B:537:0x0c89, B:530:0x0c62, B:528:0x0c55, B:513:0x0c05, B:482:0x0b14] A[DONT_GENERATE, DONT_INLINE]
  0x0d36: PHI (r13v59 int) = 
  (r13v39 int)
  (r13v40 int)
  (r13v41 int)
  (r13v42 int)
  (r13v43 int)
  (r13v44 int)
  (r13v45 int)
  (r13v46 int)
  (r13v47 int)
  (r13v60 int)
 binds: [B:552:0x0d1f, B:549:0x0cfe, B:546:0x0ce1, B:543:0x0cc4, B:540:0x0ca7, B:537:0x0c89, B:530:0x0c62, B:528:0x0c55, B:513:0x0c05, B:482:0x0b14] A[DONT_GENERATE, DONT_INLINE]
  0x0d36: PHI (r14v58 int) = 
  (r14v37 int)
  (r14v38 int)
  (r14v39 int)
  (r14v40 int)
  (r14v41 int)
  (r14v42 int)
  (r14v43 int)
  (r14v44 int)
  (r14v45 int)
  (r14v59 int)
 binds: [B:552:0x0d1f, B:549:0x0cfe, B:546:0x0ce1, B:543:0x0cc4, B:540:0x0ca7, B:537:0x0c89, B:530:0x0c62, B:528:0x0c55, B:513:0x0c05, B:482:0x0b14] A[DONT_GENERATE, DONT_INLINE]
  0x0d36: PHI (r29v23 int) = 
  (r29v2 int)
  (r29v3 int)
  (r29v4 int)
  (r29v5 int)
  (r29v6 int)
  (r29v7 int)
  (r29v8 int)
  (r29v9 int)
  (r29v13 int)
  (r29v24 int)
 binds: [B:552:0x0d1f, B:549:0x0cfe, B:546:0x0ce1, B:543:0x0cc4, B:540:0x0ca7, B:537:0x0c89, B:530:0x0c62, B:528:0x0c55, B:513:0x0c05, B:482:0x0b14] A[DONT_GENERATE, DONT_INLINE]
  0x0d36: PHI (r36v20 int) = 
  (r36v0 int)
  (r36v1 int)
  (r36v2 int)
  (r36v3 int)
  (r36v4 int)
  (r36v5 int)
  (r36v6 int)
  (r36v7 int)
  (r36v8 int)
  (r36v21 int)
 binds: [B:552:0x0d1f, B:549:0x0cfe, B:546:0x0ce1, B:543:0x0cc4, B:540:0x0ca7, B:537:0x0c89, B:530:0x0c62, B:528:0x0c55, B:513:0x0c05, B:482:0x0b14] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:563:0x0d63  */
    /* JADX WARN: Code duplicated, block: B:565:0x0d6d  */
    /* JADX WARN: Code duplicated, block: B:567:0x0d77  */
    /* JADX WARN: Code duplicated, block: B:56:0x0176  */
    /* JADX WARN: Code duplicated, block: B:570:0x0d8f  */
    /* JADX WARN: Code duplicated, block: B:603:0x00c5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:604:0x0106 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:605:0x0137 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:606:0x0150 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:607:0x0183 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:608:0x0194 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:609:0x01d7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:610:0x0328 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:611:0x0343 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:612:0x0357 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:613:0x0371 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:614:0x0383 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:615:0x039e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:616:0x03b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:617:0x0416 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:618:0x04e8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:619:0x054a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:620:0x06a5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:621:0x069f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:622:0x0694 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:623:0x068e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:624:0x074a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:625:0x073d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:626:0x07b9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:627:0x07b1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:628:0x07ab A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:629:0x07a3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:630:0x07f5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:631:0x086b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:632:0x0865 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:633:0x08d1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:634:0x08cb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:635:0x0959 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:636:0x09c7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:637:0x09c1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:638:0x0a3e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:639:0x0a38 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:640:0x0a91 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:641:0x0ac3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:643:0x0d39 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:645:0x0d8b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:646:0x0059 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:647:0x03ee A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:648:0x0104 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:649:0x0132 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:650:0x0149 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:651:0x017b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:652:0x018e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:653:0x01ce A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:654:0x0321 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:655:0x033b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:656:0x034f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:657:0x036a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:658:0x037c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:659:0x0396 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:660:0x03ad A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:661:0x03d0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:662:0x00bf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:663:0x0122 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:664:0x01bc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:665:0x01bc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:666:0x01bc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:667:0x01bc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:668:0x0413 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:669:0x0aa1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:670:0x0ac0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:671:0x0d4b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:672:0x030f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:673:0x02db A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:674:0x02bf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:675:0x0254 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:676:0x0281 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:677:0x02a9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:678:0x0309 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:679:0x03d0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:680:0x03d0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:681:0x03d0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:682:0x03d0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:683:0x03d0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:684:0x03d0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:685:0x03d0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:686:0x0094 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:687:0x0463 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:688:0x0459 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:700:0x0a8f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:702:0x057b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:703:0x051d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:705:0x057b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x01db  */
    /* JADX WARN: Code duplicated, block: B:711:0x061e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:713:0x0608 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:715:0x069a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:716:0x0686 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:718:0x0680 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:724:0x0743 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:725:0x0732 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:726:0x072e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:732:0x090c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:733:0x078f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:734:0x078b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:743:0x090c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:748:0x090c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:74:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:751:0x090c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:753:0x0983 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:757:0x0a8f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:760:0x0a8f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:761:0x0215 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:765:0x023b A[EDGE_INSN: B:765:0x023b->B:90:0x023b BREAK  A[LOOP:26: B:86:0x0228->B:89:0x0232], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:79:0x0203  */
    /* JADX WARN: Code duplicated, block: B:81:0x020b A[LOOP:24: B:78:0x0201->B:81:0x020b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:83:0x0217  */
    /* JADX WARN: Code duplicated, block: B:85:0x0221  */
    /* JADX WARN: Code duplicated, block: B:87:0x022a  */
    /* JADX WARN: Code duplicated, block: B:89:0x0232 A[LOOP:26: B:86:0x0228->B:89:0x0232, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:91:0x023f  */
    /* JADX WARN: Code duplicated, block: B:93:0x0245 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:94:0x0247  */
    /* JADX WARN: Code duplicated, block: B:97:0x025c  */
    /* JADX WARN: Code duplicated, block: B:99:0x0264  */
    final int zzc(Object obj, byte[] bArr, int i, int i2, int i3, zzks zzksVar) throws IOException {
        Object obj2;
        Unsafe unsafe;
        int i4;
        int i5;
        int iZzi;
        int i6;
        int i7;
        int iZzq;
        int i8;
        int i9;
        int i10;
        int i11;
        Unsafe unsafe2;
        int i12;
        int i13;
        zzks zzksVar2;
        zzlp zzlpVar;
        zznh zznhVar;
        int i14;
        int[] iArr;
        int i15;
        int i16;
        int iZzr;
        long j;
        int i17;
        String str;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        boolean z;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int length;
        int i29;
        char[] cArr;
        int i30;
        int i31;
        int i32;
        byte b;
        int i33;
        int i34;
        String str2;
        byte b2;
        byte b3;
        int i35;
        int i36;
        int i37;
        int i38;
        int i39;
        int i40;
        zzks zzksVar3;
        Unsafe unsafe3;
        int i41;
        Object object;
        Unsafe unsafe4;
        long j2;
        int i42;
        int i43;
        boolean z2;
        int iZzh;
        int i44;
        int i45;
        int i46;
        int iZza;
        int i47;
        zzmg zzmgVarZzu;
        int iZzh2;
        long j3;
        int i48;
        zzmj zzmjVar;
        zzmj zzmjVar2;
        zzmj zzmjVar3;
        int i49;
        int i50;
        int i51;
        zzlm zzlmVar;
        int iZzh3;
        zzlm zzlmVar2;
        int iZzh4;
        int i52;
        int i53;
        zzmj zzmjVar4;
        zzlw zzlwVar;
        int iZzh5;
        zzlw zzlwVar2;
        int i54;
        int i55;
        zzmj zzmjVar5;
        zzmw zzmwVar;
        int iZzh6;
        zzmw zzmwVar2;
        int i56;
        zzks zzksVar4;
        zzmj zzmjVar6;
        int i57;
        int i58;
        int iZzf;
        zzmj zzmjVar7;
        zzmw zzmwVar3;
        int iZzh7;
        zzmw zzmwVar4;
        int i59;
        int i60;
        zzmj zzmjVar8;
        zzme zzmeVar;
        int iZzh8;
        zzme zzmeVar2;
        int i61;
        int i62;
        zzmj zzmjVar9;
        zzku zzkuVar;
        boolean z3;
        int iZzh9;
        boolean z4;
        zzku zzkuVar2;
        int i63;
        boolean z5;
        zzmj zzmjVar10;
        int i64;
        int i65;
        int iZzh10;
        int i66;
        int i67;
        int iZzh11;
        int i68;
        Object obj3;
        int iZzh12;
        int i69;
        int i70;
        int iZzh13;
        int i71;
        int i72;
        int iZzj;
        zzmg zzmgVarZzu2;
        zzoe zzoeVar;
        int i73;
        int i74;
        Iterator it;
        Object objZzn;
        int iIntValue;
        int size;
        Object objZzn2;
        int i75;
        int i76;
        int iIntValue2;
        zzme zzmeVar3;
        int iZzh14;
        int iZzh15;
        zzme zzmeVar4;
        int i77;
        zzmw zzmwVar5;
        int iZzh16;
        zzmw zzmwVar6;
        int iZzh17;
        int i78;
        zzmj zzmjVar11;
        int i79;
        zzns zznsVarZzv;
        int iZzh18;
        zzmj zzmjVarZzd;
        int size2;
        int i80;
        Object obj4 = obj;
        int i81 = i2;
        i3 = i3;
        zzks zzksVar5 = zzksVar;
        zzA(obj);
        Unsafe unsafe5 = zzb;
        int i82 = 0;
        int iZzg = i;
        int i83 = 0;
        int i84 = 0;
        int i85 = 0;
        int i86 = -1;
        int i87 = 1048575;
        while (true) {
            if (iZzg < i81) {
                int i88 = iZzg + 1;
                int i89 = bArr[iZzg];
                if (i89 < 0) {
                    iZzi = zzkt.zzi(i89, bArr, i88, zzksVar5);
                    i5 = zzksVar5.zza;
                } else {
                    i5 = i89;
                    iZzi = i88;
                }
                int i90 = i5 >>> 3;
                if (i90 > i86) {
                    iZzq = (i90 < this.zze || i90 > this.zzf) ? -1 : zzq(i90, i83 / 3);
                } else {
                    if (i90 < this.zze || i90 > this.zzf) {
                        i6 = -1;
                        i7 = -1;
                    } else {
                        iZzq = zzq(i90, i82);
                    }
                    if (i7 == i6) {
                        i8 = iZzi;
                        i9 = i85;
                        i10 = i87;
                        i11 = i82;
                        unsafe2 = unsafe5;
                        i4 = i3;
                        i12 = i5;
                        i13 = i90;
                        obj2 = obj4;
                        zzksVar2 = zzksVar5;
                    } else {
                        i14 = i5 & 7;
                        iArr = this.zzc;
                        i15 = iArr[i7 + 1];
                        i16 = i5;
                        iZzr = zzr(i15);
                        j = i15 & 1048575;
                        i17 = i90;
                        str = "Protocol message had invalid UTF-8.";
                        if (iZzr <= 17) {
                            int i91 = iArr[i7 + 2];
                            i18 = 1 << (i91 >>> 20);
                            i19 = i91 & 1048575;
                            if (i19 != i87) {
                                if (i87 != 1048575) {
                                    unsafe5.putInt(obj4, i87, i85);
                                }
                                if (i19 == 1048575) {
                                    i85 = 0;
                                } else {
                                    i85 = unsafe5.getInt(obj4, i19);
                                }
                                i10 = i19;
                            } else {
                                i10 = i87;
                            }
                            switch (iZzr) {
                                case 0:
                                    i20 = iZzi;
                                    i21 = i7;
                                    i82 = 0;
                                    if (i14 == 1) {
                                        iZzg = i20 + 8;
                                        i85 |= i18;
                                        zzol.zzo(obj4, j, Double.longBitsToDouble(zzkt.zzn(bArr, i20)));
                                        i83 = i21;
                                        i87 = i10;
                                        i84 = i16;
                                        i86 = i17;
                                        i81 = i2;
                                    } else {
                                        i22 = i20;
                                        i11 = i82;
                                        i23 = i21;
                                        i13 = i17;
                                        unsafe2 = unsafe5;
                                        i82 = i23;
                                        i9 = i85;
                                        i8 = i22;
                                        i12 = i16;
                                        i4 = i3;
                                        obj2 = obj4;
                                        zzksVar2 = zzksVar5;
                                    }
                                    break;
                                case 1:
                                    i20 = iZzi;
                                    i21 = i7;
                                    i82 = 0;
                                    if (i14 == 5) {
                                        iZzg = i20 + 4;
                                        i85 |= i18;
                                        zzol.zzp(obj4, j, Float.intBitsToFloat(zzkt.zzb(bArr, i20)));
                                        i83 = i21;
                                        i87 = i10;
                                        i84 = i16;
                                        i86 = i17;
                                        i81 = i2;
                                    } else {
                                        i22 = i20;
                                        i11 = i82;
                                        i23 = i21;
                                        i13 = i17;
                                        unsafe2 = unsafe5;
                                        i82 = i23;
                                        i9 = i85;
                                        i8 = i22;
                                        i12 = i16;
                                        i4 = i3;
                                        obj2 = obj4;
                                        zzksVar2 = zzksVar5;
                                    }
                                    break;
                                case 2:
                                case 3:
                                    i20 = iZzi;
                                    i21 = i7;
                                    i82 = 0;
                                    if (i14 == 0) {
                                        int i92 = i85 | i18;
                                        int iZzk = zzkt.zzk(bArr, i20, zzksVar5);
                                        unsafe5.putLong(obj, j, zzksVar5.zzb);
                                        i85 = i92;
                                        iZzg = iZzk;
                                        i83 = i21;
                                        i87 = i10;
                                        i84 = i16;
                                        i86 = i17;
                                        i81 = i2;
                                    } else {
                                        i22 = i20;
                                        i11 = i82;
                                        i23 = i21;
                                        i13 = i17;
                                        unsafe2 = unsafe5;
                                        i82 = i23;
                                        i9 = i85;
                                        i8 = i22;
                                        i12 = i16;
                                        i4 = i3;
                                        obj2 = obj4;
                                        zzksVar2 = zzksVar5;
                                    }
                                    break;
                                case 4:
                                case 11:
                                    i20 = iZzi;
                                    i21 = i7;
                                    i82 = 0;
                                    if (i14 == 0) {
                                        i85 |= i18;
                                        iZzg = zzkt.zzh(bArr, i20, zzksVar5);
                                        unsafe5.putInt(obj4, j, zzksVar5.zza);
                                        i83 = i21;
                                        i87 = i10;
                                        i84 = i16;
                                        i86 = i17;
                                        i81 = i2;
                                    } else {
                                        i22 = i20;
                                        i11 = i82;
                                        i23 = i21;
                                        i13 = i17;
                                        unsafe2 = unsafe5;
                                        i82 = i23;
                                        i9 = i85;
                                        i8 = i22;
                                        i12 = i16;
                                        i4 = i3;
                                        obj2 = obj4;
                                        zzksVar2 = zzksVar5;
                                    }
                                    break;
                                case 5:
                                case 14:
                                    i20 = iZzi;
                                    i21 = i7;
                                    i82 = 0;
                                    if (i14 == 1) {
                                        unsafe5.putLong(obj, j, zzkt.zzn(bArr, i20));
                                        iZzg = i20 + 8;
                                        i85 = i18 | i85;
                                        i83 = i21;
                                        i87 = i10;
                                        i84 = i16;
                                        i86 = i17;
                                        i81 = i2;
                                    } else {
                                        i22 = i20;
                                        i11 = i82;
                                        i23 = i21;
                                        i13 = i17;
                                        unsafe2 = unsafe5;
                                        i82 = i23;
                                        i9 = i85;
                                        i8 = i22;
                                        i12 = i16;
                                        i4 = i3;
                                        obj2 = obj4;
                                        zzksVar2 = zzksVar5;
                                    }
                                    break;
                                case 6:
                                case 13:
                                    i20 = iZzi;
                                    i21 = i7;
                                    i82 = 0;
                                    if (i14 == 5) {
                                        iZzg = i20 + 4;
                                        i85 |= i18;
                                        unsafe5.putInt(obj4, j, zzkt.zzb(bArr, i20));
                                        i83 = i21;
                                        i87 = i10;
                                        i84 = i16;
                                        i86 = i17;
                                        i81 = i2;
                                    } else {
                                        i22 = i20;
                                        i11 = i82;
                                        i23 = i21;
                                        i13 = i17;
                                        unsafe2 = unsafe5;
                                        i82 = i23;
                                        i9 = i85;
                                        i8 = i22;
                                        i12 = i16;
                                        i4 = i3;
                                        obj2 = obj4;
                                        zzksVar2 = zzksVar5;
                                    }
                                    break;
                                case 7:
                                    i20 = iZzi;
                                    i21 = i7;
                                    i82 = 0;
                                    if (i14 == 0) {
                                        i85 |= i18;
                                        iZzg = zzkt.zzk(bArr, i20, zzksVar5);
                                        if (zzksVar5.zzb != 0) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        zzol.zzm(obj4, j, z);
                                        i83 = i21;
                                        i87 = i10;
                                        i84 = i16;
                                        i86 = i17;
                                        i81 = i2;
                                    } else {
                                        i22 = i20;
                                        i11 = i82;
                                        i23 = i21;
                                        i13 = i17;
                                        unsafe2 = unsafe5;
                                        i82 = i23;
                                        i9 = i85;
                                        i8 = i22;
                                        i12 = i16;
                                        i4 = i3;
                                        obj2 = obj4;
                                        zzksVar2 = zzksVar5;
                                    }
                                    break;
                                case 8:
                                    i24 = iZzi;
                                    i21 = i7;
                                    i25 = i16;
                                    if (i14 == 2) {
                                        if ((i15 & 536870912) != 0) {
                                            iZzg = zzkt.zzh(bArr, i24, zzksVar5);
                                            i27 = zzksVar5.zza;
                                            if (i27 >= 0) {
                                                throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                            }
                                            i28 = i85 | i18;
                                            if (i27 == 0) {
                                                zzksVar5.zzc = "";
                                                i31 = i28;
                                                i16 = i25;
                                                i82 = 0;
                                            } else {
                                                int i93 = zzoo.zza;
                                                length = bArr.length;
                                                if ((((length - iZzg) - i27) | iZzg | i27) >= 0) {
                                                    throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(iZzg), Integer.valueOf(i27)));
                                                }
                                                i29 = iZzg + i27;
                                                cArr = new char[i27];
                                                i30 = 0;
                                                while (iZzg < i29) {
                                                    b3 = bArr[iZzg];
                                                    if (zzom.zzd(b3)) {
                                                        iZzg++;
                                                        cArr[i30] = (char) b3;
                                                        i30++;
                                                    } else {
                                                        while (iZzg < i29) {
                                                            i32 = iZzg + 1;
                                                            b = bArr[iZzg];
                                                            if (zzom.zzd(b)) {
                                                                cArr[i30] = (char) b;
                                                                i30++;
                                                                iZzg = i32;
                                                                while (iZzg < i29) {
                                                                    b2 = bArr[iZzg];
                                                                    if (zzom.zzd(b2)) {
                                                                    }
                                                                    iZzg++;
                                                                    cArr[i30] = (char) b2;
                                                                    i30++;
                                                                    break;
                                                                }
                                                            } else {
                                                                i33 = i28;
                                                                if (b < -32) {
                                                                    i34 = i25;
                                                                    str2 = str;
                                                                    if (b < -16) {
                                                                        if (i32 < i29 - 1) {
                                                                            throw new zzmm(str2);
                                                                        }
                                                                        zzom.zzb(b, bArr[i32], bArr[iZzg + 2], cArr, i30);
                                                                        str = str2;
                                                                        i30++;
                                                                        i28 = i33;
                                                                        i25 = i34;
                                                                        iZzg += 3;
                                                                    } else {
                                                                        if (i32 < i29 - 2) {
                                                                            throw new zzmm(str2);
                                                                        }
                                                                        byte b4 = bArr[i32];
                                                                        int i94 = iZzg + 3;
                                                                        byte b5 = bArr[iZzg + 2];
                                                                        iZzg += 4;
                                                                        zzom.zza(b, b4, b5, bArr[i94], cArr, i30);
                                                                        i30 += 2;
                                                                        str = str2;
                                                                        i28 = i33;
                                                                        i25 = i34;
                                                                    }
                                                                } else {
                                                                    if (i32 < i29) {
                                                                        throw new zzmm(str);
                                                                    }
                                                                    iZzg += 2;
                                                                    zzom.zzc(b, bArr[i32], cArr, i30);
                                                                    i30++;
                                                                    i28 = i33;
                                                                }
                                                            }
                                                        }
                                                        i31 = i28;
                                                        i16 = i25;
                                                        i82 = 0;
                                                        zzksVar5.zzc = new String(cArr, 0, i30);
                                                        iZzg = i29;
                                                    }
                                                }
                                                while (iZzg < i29) {
                                                    i32 = iZzg + 1;
                                                    b = bArr[iZzg];
                                                    if (zzom.zzd(b)) {
                                                        cArr[i30] = (char) b;
                                                        i30++;
                                                        iZzg = i32;
                                                        while (iZzg < i29) {
                                                            b2 = bArr[iZzg];
                                                            if (zzom.zzd(b2)) {
                                                            }
                                                            iZzg++;
                                                            cArr[i30] = (char) b2;
                                                            i30++;
                                                            break;
                                                        }
                                                    } else {
                                                        i33 = i28;
                                                        if (b < -32) {
                                                            i34 = i25;
                                                            str2 = str;
                                                            if (b < -16) {
                                                                if (i32 < i29 - 1) {
                                                                    throw new zzmm(str2);
                                                                }
                                                                zzom.zzb(b, bArr[i32], bArr[iZzg + 2], cArr, i30);
                                                                str = str2;
                                                                i30++;
                                                                i28 = i33;
                                                                i25 = i34;
                                                                iZzg += 3;
                                                            } else {
                                                                if (i32 < i29 - 2) {
                                                                    throw new zzmm(str2);
                                                                }
                                                                byte b6 = bArr[i32];
                                                                int i95 = iZzg + 3;
                                                                byte b7 = bArr[iZzg + 2];
                                                                iZzg += 4;
                                                                zzom.zza(b, b6, b7, bArr[i95], cArr, i30);
                                                                i30 += 2;
                                                                str = str2;
                                                                i28 = i33;
                                                                i25 = i34;
                                                            }
                                                        } else {
                                                            if (i32 < i29) {
                                                                throw new zzmm(str);
                                                            }
                                                            iZzg += 2;
                                                            zzom.zzc(b, bArr[i32], cArr, i30);
                                                            i30++;
                                                            i28 = i33;
                                                        }
                                                    }
                                                }
                                                i31 = i28;
                                                i16 = i25;
                                                i82 = 0;
                                                zzksVar5.zzc = new String(cArr, 0, i30);
                                                iZzg = i29;
                                            }
                                            i85 = i31;
                                        } else {
                                            i16 = i25;
                                            i82 = 0;
                                            iZzg = zzkt.zzh(bArr, i24, zzksVar5);
                                            i26 = zzksVar5.zza;
                                            if (i26 >= 0) {
                                                throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                            }
                                            i85 |= i18;
                                            if (i26 == 0) {
                                                zzksVar5.zzc = "";
                                            } else {
                                                zzksVar5.zzc = new String(bArr, iZzg, i26, zzmk.zza);
                                                iZzg += i26;
                                            }
                                        }
                                        unsafe5.putObject(obj4, j, zzksVar5.zzc);
                                        i83 = i21;
                                        i87 = i10;
                                        i84 = i16;
                                        i86 = i17;
                                        i81 = i2;
                                    } else {
                                        i22 = i24;
                                        i16 = i25;
                                        i23 = i21;
                                        i11 = 0;
                                        i13 = i17;
                                        unsafe2 = unsafe5;
                                        i82 = i23;
                                        i9 = i85;
                                        i8 = i22;
                                        i12 = i16;
                                        i4 = i3;
                                        obj2 = obj4;
                                        zzksVar2 = zzksVar5;
                                    }
                                    break;
                                case 9:
                                    i35 = i7;
                                    i36 = i16;
                                    if (i14 == 2) {
                                        int i96 = i85 | i18;
                                        Object objZzx = zzx(obj4, i35);
                                        iZzg = zzkt.zzm(objZzx, zzv(i35), bArr, iZzi, i2, zzksVar);
                                        zzF(obj4, i35, objZzx);
                                        i85 = i96;
                                        i84 = i36;
                                        i83 = i35;
                                        i87 = i10;
                                        i86 = i17;
                                        i82 = 0;
                                        i81 = i2;
                                        i3 = i3;
                                    } else {
                                        i22 = iZzi;
                                        i85 = i85;
                                        unsafe5 = unsafe5;
                                        zzksVar5 = zzksVar5;
                                        i16 = i36;
                                        i23 = i35;
                                        i17 = i17;
                                        i11 = 0;
                                        i13 = i17;
                                        unsafe2 = unsafe5;
                                        i82 = i23;
                                        i9 = i85;
                                        i8 = i22;
                                        i12 = i16;
                                        i4 = i3;
                                        obj2 = obj4;
                                        zzksVar2 = zzksVar5;
                                    }
                                    break;
                                case 10:
                                    i35 = i7;
                                    i36 = i16;
                                    if (i14 == 2) {
                                        i85 |= i18;
                                        iZzg = zzkt.zza(bArr, iZzi, zzksVar5);
                                        unsafe5.putObject(obj4, j, zzksVar5.zzc);
                                        i84 = i36;
                                        i83 = i35;
                                        i87 = i10;
                                        i86 = i17;
                                        i82 = 0;
                                        i81 = i2;
                                        i3 = i3;
                                    } else {
                                        i22 = iZzi;
                                        i85 = i85;
                                        unsafe5 = unsafe5;
                                        zzksVar5 = zzksVar5;
                                        i16 = i36;
                                        i23 = i35;
                                        i17 = i17;
                                        i11 = 0;
                                        i13 = i17;
                                        unsafe2 = unsafe5;
                                        i82 = i23;
                                        i9 = i85;
                                        i8 = i22;
                                        i12 = i16;
                                        i4 = i3;
                                        obj2 = obj4;
                                        zzksVar2 = zzksVar5;
                                    }
                                    break;
                                case 12:
                                    i35 = i7;
                                    i36 = i16;
                                    if (i14 == 0) {
                                        iZzg = zzkt.zzh(bArr, iZzi, zzksVar5);
                                        i37 = zzksVar5.zza;
                                        zzmg zzmgVarZzu3 = zzu(i35);
                                        if ((i15 & Integer.MIN_VALUE) != 0 || zzmgVarZzu3 == null || zzmgVarZzu3.zza(i37)) {
                                            i85 |= i18;
                                            unsafe5.putInt(obj4, j, i37);
                                        } else {
                                            zzd(obj).zzj(i36, Long.valueOf(i37));
                                        }
                                        i84 = i36;
                                        i83 = i35;
                                        i87 = i10;
                                        i86 = i17;
                                        i82 = 0;
                                        i81 = i2;
                                        i3 = i3;
                                    } else {
                                        i22 = iZzi;
                                        i85 = i85;
                                        unsafe5 = unsafe5;
                                        zzksVar5 = zzksVar5;
                                        i16 = i36;
                                        i23 = i35;
                                        i17 = i17;
                                        i11 = 0;
                                        i13 = i17;
                                        unsafe2 = unsafe5;
                                        i82 = i23;
                                        i9 = i85;
                                        i8 = i22;
                                        i12 = i16;
                                        i4 = i3;
                                        obj2 = obj4;
                                        zzksVar2 = zzksVar5;
                                    }
                                    break;
                                case 15:
                                    i35 = i7;
                                    i36 = i16;
                                    if (i14 == 0) {
                                        i85 |= i18;
                                        iZzg = zzkt.zzh(bArr, iZzi, zzksVar5);
                                        unsafe5.putInt(obj4, j, zzlg.zzb(zzksVar5.zza));
                                        i84 = i36;
                                        i83 = i35;
                                        i87 = i10;
                                        i86 = i17;
                                        i82 = 0;
                                        i81 = i2;
                                        i3 = i3;
                                    } else {
                                        i22 = iZzi;
                                        i85 = i85;
                                        unsafe5 = unsafe5;
                                        zzksVar5 = zzksVar5;
                                        i16 = i36;
                                        i23 = i35;
                                        i17 = i17;
                                        i11 = 0;
                                        i13 = i17;
                                        unsafe2 = unsafe5;
                                        i82 = i23;
                                        i9 = i85;
                                        i8 = i22;
                                        i12 = i16;
                                        i4 = i3;
                                        obj2 = obj4;
                                        zzksVar2 = zzksVar5;
                                    }
                                    break;
                                case 16:
                                    if (i14 == 0) {
                                        int i97 = i85 | i18;
                                        int iZzk2 = zzkt.zzk(bArr, iZzi, zzksVar5);
                                        i35 = i7;
                                        i36 = i16;
                                        unsafe5.putLong(obj, j, zzlg.zzc(zzksVar5.zzb));
                                        i85 = i97;
                                        iZzg = iZzk2;
                                        i84 = i36;
                                        i83 = i35;
                                        i87 = i10;
                                        i86 = i17;
                                        i82 = 0;
                                        i81 = i2;
                                        i3 = i3;
                                    } else {
                                        i22 = iZzi;
                                        i85 = i85;
                                        unsafe5 = unsafe5;
                                        zzksVar5 = zzksVar5;
                                        i11 = 0;
                                        i23 = i7;
                                        i17 = i17;
                                        i13 = i17;
                                        unsafe2 = unsafe5;
                                        i82 = i23;
                                        i9 = i85;
                                        i8 = i22;
                                        i12 = i16;
                                        i4 = i3;
                                        obj2 = obj4;
                                        zzksVar2 = zzksVar5;
                                    }
                                    break;
                                default:
                                    i20 = iZzi;
                                    i21 = i7;
                                    i82 = 0;
                                    if (i14 == 3) {
                                        Object objZzx2 = zzx(obj4, i21);
                                        int iZzl = zzkt.zzl(objZzx2, zzv(i21), bArr, i20, i2, (i17 << 3) | 4, zzksVar);
                                        zzF(obj4, i21, objZzx2);
                                        i3 = i3;
                                        zzksVar5 = zzksVar;
                                        i86 = i17;
                                        unsafe5 = unsafe5;
                                        i83 = i21;
                                        i81 = i2;
                                        iZzg = iZzl;
                                        i87 = i10;
                                        i84 = i16;
                                        i82 = 0;
                                        i85 |= i18;
                                    } else {
                                        i22 = i20;
                                        i11 = i82;
                                        i23 = i21;
                                        i13 = i17;
                                        unsafe2 = unsafe5;
                                        i82 = i23;
                                        i9 = i85;
                                        i8 = i22;
                                        i12 = i16;
                                        i4 = i3;
                                        obj2 = obj4;
                                        zzksVar2 = zzksVar5;
                                    }
                                    break;
                            }
                        } else {
                            i10 = i87;
                            i38 = i17;
                            i11 = 0;
                            i81 = i2;
                            i9 = i85;
                            i39 = i7;
                            zzks zzksVar6 = zzksVar5;
                            i40 = iZzi;
                            zzksVar3 = zzksVar6;
                            unsafe3 = unsafe5;
                            if (iZzr == 27) {
                                if (iZzr <= 49) {
                                    j3 = i15;
                                    i48 = i39;
                                    zzmjVar = (zzmj) unsafe3.getObject(obj4, j);
                                    if (zzmjVar.zzc()) {
                                        zzmjVar2 = zzmjVar;
                                    } else {
                                        int size3 = zzmjVar.size();
                                        zzmj zzmjVarZzd2 = zzmjVar.zzd(size3 + size3);
                                        unsafe3.putObject(obj4, j, zzmjVarZzd2);
                                        zzmjVar2 = zzmjVarZzd2;
                                    }
                                    switch (iZzr) {
                                        case 18:
                                        case MotionEventCompat.AXIS_GENERIC_4 /* 35 */:
                                            zzksVar3 = zzksVar3;
                                            zzmjVar3 = zzmjVar2;
                                            unsafe3 = unsafe3;
                                            i49 = i16;
                                            i50 = i38;
                                            i51 = i48;
                                            i81 = i81;
                                            if (i14 == 2) {
                                                int i98 = zzkt.zza;
                                                zzlmVar2 = (zzlm) zzmjVar3;
                                                iZzh4 = zzkt.zzh(bArr, i40, zzksVar3);
                                                i52 = zzksVar3.zza;
                                                i53 = iZzh4 + i52;
                                                if (i53 <= bArr.length) {
                                                    throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                zzlmVar2.zzg(zzlmVar2.size() + (i52 / 8));
                                                while (iZzh4 < i53) {
                                                    zzlmVar2.zzf(Double.longBitsToDouble(zzkt.zzn(bArr, iZzh4)));
                                                    iZzh4 += 8;
                                                }
                                                if (iZzh4 != i53) {
                                                    throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                iZzg = iZzh4;
                                            } else if (i14 == 1) {
                                                iZzg = i40 + 8;
                                                int i99 = zzkt.zza;
                                                zzlmVar = (zzlm) zzmjVar3;
                                                zzlmVar.zzf(Double.longBitsToDouble(zzkt.zzn(bArr, i40)));
                                                while (iZzg < i81) {
                                                    iZzh3 = zzkt.zzh(bArr, iZzg, zzksVar3);
                                                    if (i49 == zzksVar3.zza) {
                                                        zzlmVar.zzf(Double.longBitsToDouble(zzkt.zzn(bArr, iZzh3)));
                                                        iZzg = iZzh3 + 8;
                                                    }
                                                }
                                            } else {
                                                iZzg = i40;
                                            }
                                            if (iZzg != i40) {
                                                i40 = i40;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj4 = obj;
                                                zzksVar5 = zzksVar3;
                                                i86 = i50;
                                                i83 = i51;
                                                i84 = i49;
                                                i87 = i10;
                                                i82 = 0;
                                                i85 = i9;
                                                unsafe5 = unsafe3;
                                                i3 = i3;
                                            } else {
                                                i40 = i40;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj2 = obj;
                                                i8 = iZzg;
                                                zzksVar2 = zzksVar3;
                                                unsafe2 = unsafe3;
                                                i4 = i3;
                                                int i100 = i49;
                                                i13 = i50;
                                                i82 = i51;
                                                i12 = i100;
                                            }
                                            break;
                                        case 19:
                                        case 36:
                                            zzksVar3 = zzksVar3;
                                            zzmjVar4 = zzmjVar2;
                                            unsafe3 = unsafe3;
                                            i49 = i16;
                                            i50 = i38;
                                            i51 = i48;
                                            i81 = i81;
                                            if (i14 == 2) {
                                                int i101 = zzkt.zza;
                                                zzlwVar2 = (zzlw) zzmjVar4;
                                                iZzh4 = zzkt.zzh(bArr, i40, zzksVar3);
                                                i54 = zzksVar3.zza;
                                                i55 = iZzh4 + i54;
                                                if (i55 <= bArr.length) {
                                                    throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                zzlwVar2.zzg(zzlwVar2.size() + (i54 / 4));
                                                while (iZzh4 < i55) {
                                                    zzlwVar2.zzf(Float.intBitsToFloat(zzkt.zzb(bArr, iZzh4)));
                                                    iZzh4 += 4;
                                                }
                                                if (iZzh4 != i55) {
                                                    throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                iZzg = iZzh4;
                                            } else if (i14 == 5) {
                                                iZzg = i40 + 4;
                                                int i102 = zzkt.zza;
                                                zzlwVar = (zzlw) zzmjVar4;
                                                zzlwVar.zzf(Float.intBitsToFloat(zzkt.zzb(bArr, i40)));
                                                while (iZzg < i81) {
                                                    iZzh5 = zzkt.zzh(bArr, iZzg, zzksVar3);
                                                    if (i49 == zzksVar3.zza) {
                                                        zzlwVar.zzf(Float.intBitsToFloat(zzkt.zzb(bArr, iZzh5)));
                                                        iZzg = iZzh5 + 4;
                                                    }
                                                }
                                            } else {
                                                iZzg = i40;
                                            }
                                            if (iZzg != i40) {
                                                i40 = i40;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj4 = obj;
                                                zzksVar5 = zzksVar3;
                                                i86 = i50;
                                                i83 = i51;
                                                i84 = i49;
                                                i87 = i10;
                                                i82 = 0;
                                                i85 = i9;
                                                unsafe5 = unsafe3;
                                                i3 = i3;
                                            } else {
                                                i40 = i40;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj2 = obj;
                                                i8 = iZzg;
                                                zzksVar2 = zzksVar3;
                                                unsafe2 = unsafe3;
                                                i4 = i3;
                                                int i103 = i49;
                                                i13 = i50;
                                                i82 = i51;
                                                i12 = i103;
                                            }
                                            break;
                                        case 20:
                                        case 21:
                                        case MotionEventCompat.AXIS_GENERIC_6 /* 37 */:
                                        case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                                            zzksVar3 = zzksVar3;
                                            zzmjVar5 = zzmjVar2;
                                            unsafe3 = unsafe3;
                                            i49 = i16;
                                            i50 = i38;
                                            i51 = i48;
                                            i81 = i81;
                                            if (i14 == 2) {
                                                if (i14 == 0) {
                                                    int i104 = zzkt.zza;
                                                    zzmwVar = (zzmw) zzmjVar5;
                                                    iZzh4 = zzkt.zzk(bArr, i40, zzksVar3);
                                                    zzmwVar.zzg(zzksVar3.zzb);
                                                    while (iZzh4 < i81) {
                                                        iZzh6 = zzkt.zzh(bArr, iZzh4, zzksVar3);
                                                        if (i49 == zzksVar3.zza) {
                                                            iZzh4 = zzkt.zzk(bArr, iZzh6, zzksVar3);
                                                            zzmwVar.zzg(zzksVar3.zzb);
                                                        }
                                                    }
                                                } else {
                                                    iZzg = i40;
                                                }
                                                if (iZzg != i40) {
                                                    i40 = i40;
                                                    i81 = i81;
                                                    zzksVar3 = zzksVar3;
                                                    obj4 = obj;
                                                    zzksVar5 = zzksVar3;
                                                    i86 = i50;
                                                    i83 = i51;
                                                    i84 = i49;
                                                    i87 = i10;
                                                    i82 = 0;
                                                    i85 = i9;
                                                    unsafe5 = unsafe3;
                                                    i3 = i3;
                                                } else {
                                                    i40 = i40;
                                                    i81 = i81;
                                                    zzksVar3 = zzksVar3;
                                                    obj2 = obj;
                                                    i8 = iZzg;
                                                    zzksVar2 = zzksVar3;
                                                    unsafe2 = unsafe3;
                                                    i4 = i3;
                                                    int i105 = i49;
                                                    i13 = i50;
                                                    i82 = i51;
                                                    i12 = i105;
                                                }
                                            } else {
                                                int i106 = zzkt.zza;
                                                zzmwVar2 = (zzmw) zzmjVar5;
                                                iZzh4 = zzkt.zzh(bArr, i40, zzksVar3);
                                                i56 = zzksVar3.zza + iZzh4;
                                                while (iZzh4 < i56) {
                                                    iZzh4 = zzkt.zzk(bArr, iZzh4, zzksVar3);
                                                    zzmwVar2.zzg(zzksVar3.zzb);
                                                }
                                                if (iZzh4 != i56) {
                                                    throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            }
                                            iZzg = iZzh4;
                                            if (iZzg != i40) {
                                                i40 = i40;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj4 = obj;
                                                zzksVar5 = zzksVar3;
                                                i86 = i50;
                                                i83 = i51;
                                                i84 = i49;
                                                i87 = i10;
                                                i82 = 0;
                                                i85 = i9;
                                                unsafe5 = unsafe3;
                                                i3 = i3;
                                            } else {
                                                i40 = i40;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj2 = obj;
                                                i8 = iZzg;
                                                zzksVar2 = zzksVar3;
                                                unsafe2 = unsafe3;
                                                i4 = i3;
                                                int i107 = i49;
                                                i13 = i50;
                                                i82 = i51;
                                                i12 = i107;
                                            }
                                            break;
                                        case 22:
                                        case 29:
                                        case MotionEventCompat.AXIS_GENERIC_8 /* 39 */:
                                        case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                                            zzksVar4 = zzksVar3;
                                            zzmjVar6 = zzmjVar2;
                                            unsafe3 = unsafe3;
                                            i57 = i16;
                                            i81 = i81;
                                            i58 = i48;
                                            if (i14 == 2) {
                                                iZzf = zzkt.zzf(bArr, i40, zzmjVar6, zzksVar4);
                                                i49 = i57;
                                                iZzg = iZzf;
                                                zzksVar3 = zzksVar4;
                                                i51 = i58;
                                                i50 = i38;
                                            } else if (i14 == 0) {
                                                i49 = i57;
                                                zzksVar3 = zzksVar4;
                                                i50 = i38;
                                                i51 = i58;
                                                iZzg = zzkt.zzj(i57, bArr, i40, i2, zzmjVar6, zzksVar);
                                            } else {
                                                i49 = i57;
                                                zzksVar3 = zzksVar4;
                                                i51 = i58;
                                                i50 = i38;
                                                iZzg = i40;
                                            }
                                            if (iZzg != i40) {
                                                i40 = i40;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj4 = obj;
                                                zzksVar5 = zzksVar3;
                                                i86 = i50;
                                                i83 = i51;
                                                i84 = i49;
                                                i87 = i10;
                                                i82 = 0;
                                                i85 = i9;
                                                unsafe5 = unsafe3;
                                                i3 = i3;
                                            } else {
                                                i40 = i40;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj2 = obj;
                                                i8 = iZzg;
                                                zzksVar2 = zzksVar3;
                                                unsafe2 = unsafe3;
                                                i4 = i3;
                                                int i108 = i49;
                                                i13 = i50;
                                                i82 = i51;
                                                i12 = i108;
                                            }
                                            break;
                                        case 23:
                                        case 32:
                                        case MotionEventCompat.AXIS_GENERIC_9 /* 40 */:
                                        case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                                            zzksVar4 = zzksVar3;
                                            zzmjVar7 = zzmjVar2;
                                            unsafe3 = unsafe3;
                                            i57 = i16;
                                            i81 = i81;
                                            i58 = i48;
                                            if (i14 == 2) {
                                                if (i14 == 1) {
                                                    iZzf = i40 + 8;
                                                    int i109 = zzkt.zza;
                                                    zzmwVar3 = (zzmw) zzmjVar7;
                                                    zzmwVar3.zzg(zzkt.zzn(bArr, i40));
                                                    while (iZzf < i81) {
                                                        iZzh7 = zzkt.zzh(bArr, iZzf, zzksVar4);
                                                        if (i57 == zzksVar4.zza) {
                                                            zzmwVar3.zzg(zzkt.zzn(bArr, iZzh7));
                                                            iZzf = iZzh7 + 8;
                                                        }
                                                    }
                                                }
                                                i49 = i57;
                                                zzksVar3 = zzksVar4;
                                                i51 = i58;
                                                i50 = i38;
                                                iZzg = i40;
                                                if (iZzg != i40) {
                                                    i40 = i40;
                                                    i81 = i81;
                                                    zzksVar3 = zzksVar3;
                                                    obj4 = obj;
                                                    zzksVar5 = zzksVar3;
                                                    i86 = i50;
                                                    i83 = i51;
                                                    i84 = i49;
                                                    i87 = i10;
                                                    i82 = 0;
                                                    i85 = i9;
                                                    unsafe5 = unsafe3;
                                                    i3 = i3;
                                                } else {
                                                    i40 = i40;
                                                    i81 = i81;
                                                    zzksVar3 = zzksVar3;
                                                    obj2 = obj;
                                                    i8 = iZzg;
                                                    zzksVar2 = zzksVar3;
                                                    unsafe2 = unsafe3;
                                                    i4 = i3;
                                                    int i1010 = i49;
                                                    i13 = i50;
                                                    i82 = i51;
                                                    i12 = i1010;
                                                }
                                            } else {
                                                int i110 = zzkt.zza;
                                                zzmwVar4 = (zzmw) zzmjVar7;
                                                iZzf = zzkt.zzh(bArr, i40, zzksVar4);
                                                i59 = zzksVar4.zza;
                                                i60 = iZzf + i59;
                                                if (i60 <= bArr.length) {
                                                    throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                zzmwVar4.zzh(zzmwVar4.size() + (i59 / 8));
                                                while (iZzf < i60) {
                                                    zzmwVar4.zzg(zzkt.zzn(bArr, iZzf));
                                                    iZzf += 8;
                                                }
                                                if (iZzf != i60) {
                                                    throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            }
                                            i49 = i57;
                                            iZzg = iZzf;
                                            zzksVar3 = zzksVar4;
                                            i51 = i58;
                                            i50 = i38;
                                            if (iZzg != i40) {
                                                i40 = i40;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj4 = obj;
                                                zzksVar5 = zzksVar3;
                                                i86 = i50;
                                                i83 = i51;
                                                i84 = i49;
                                                i87 = i10;
                                                i82 = 0;
                                                i85 = i9;
                                                unsafe5 = unsafe3;
                                                i3 = i3;
                                            } else {
                                                i40 = i40;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj2 = obj;
                                                i8 = iZzg;
                                                zzksVar2 = zzksVar3;
                                                unsafe2 = unsafe3;
                                                i4 = i3;
                                                int i1011 = i49;
                                                i13 = i50;
                                                i82 = i51;
                                                i12 = i1011;
                                            }
                                            break;
                                        case 24:
                                        case 31:
                                        case MotionEventCompat.AXIS_GENERIC_10 /* 41 */:
                                        case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                                            zzksVar4 = zzksVar3;
                                            zzmjVar8 = zzmjVar2;
                                            unsafe3 = unsafe3;
                                            i57 = i16;
                                            i81 = i81;
                                            i58 = i48;
                                            if (i14 == 2) {
                                                if (i14 == 5) {
                                                    iZzf = i40 + 4;
                                                    int i111 = zzkt.zza;
                                                    zzmeVar = (zzme) zzmjVar8;
                                                    zzmeVar.zzh(zzkt.zzb(bArr, i40));
                                                    while (iZzf < i81) {
                                                        iZzh8 = zzkt.zzh(bArr, iZzf, zzksVar4);
                                                        if (i57 == zzksVar4.zza) {
                                                            zzmeVar.zzh(zzkt.zzb(bArr, iZzh8));
                                                            iZzf = iZzh8 + 4;
                                                        }
                                                    }
                                                }
                                                i49 = i57;
                                                zzksVar3 = zzksVar4;
                                                i51 = i58;
                                                i50 = i38;
                                                iZzg = i40;
                                                if (iZzg != i40) {
                                                    i40 = i40;
                                                    i81 = i81;
                                                    zzksVar3 = zzksVar3;
                                                    obj4 = obj;
                                                    zzksVar5 = zzksVar3;
                                                    i86 = i50;
                                                    i83 = i51;
                                                    i84 = i49;
                                                    i87 = i10;
                                                    i82 = 0;
                                                    i85 = i9;
                                                    unsafe5 = unsafe3;
                                                    i3 = i3;
                                                } else {
                                                    i40 = i40;
                                                    i81 = i81;
                                                    zzksVar3 = zzksVar3;
                                                    obj2 = obj;
                                                    i8 = iZzg;
                                                    zzksVar2 = zzksVar3;
                                                    unsafe2 = unsafe3;
                                                    i4 = i3;
                                                    int i1012 = i49;
                                                    i13 = i50;
                                                    i82 = i51;
                                                    i12 = i1012;
                                                }
                                            } else {
                                                int i112 = zzkt.zza;
                                                zzmeVar2 = (zzme) zzmjVar8;
                                                iZzf = zzkt.zzh(bArr, i40, zzksVar4);
                                                i61 = zzksVar4.zza;
                                                i62 = iZzf + i61;
                                                if (i62 <= bArr.length) {
                                                    throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                zzmeVar2.zzi(zzmeVar2.size() + (i61 / 4));
                                                while (iZzf < i62) {
                                                    zzmeVar2.zzh(zzkt.zzb(bArr, iZzf));
                                                    iZzf += 4;
                                                }
                                                if (iZzf != i62) {
                                                    throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            }
                                            i49 = i57;
                                            iZzg = iZzf;
                                            zzksVar3 = zzksVar4;
                                            i51 = i58;
                                            i50 = i38;
                                            if (iZzg != i40) {
                                                i40 = i40;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj4 = obj;
                                                zzksVar5 = zzksVar3;
                                                i86 = i50;
                                                i83 = i51;
                                                i84 = i49;
                                                i87 = i10;
                                                i82 = 0;
                                                i85 = i9;
                                                unsafe5 = unsafe3;
                                                i3 = i3;
                                            } else {
                                                i40 = i40;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj2 = obj;
                                                i8 = iZzg;
                                                zzksVar2 = zzksVar3;
                                                unsafe2 = unsafe3;
                                                i4 = i3;
                                                int i1013 = i49;
                                                i13 = i50;
                                                i82 = i51;
                                                i12 = i1013;
                                            }
                                            break;
                                        case 25:
                                        case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                                            zzksVar4 = zzksVar3;
                                            zzmjVar9 = zzmjVar2;
                                            unsafe3 = unsafe3;
                                            i57 = i16;
                                            i81 = i81;
                                            i58 = i48;
                                            if (i14 == 2) {
                                                if (i14 == 0) {
                                                    int i113 = zzkt.zza;
                                                    zzkuVar = (zzku) zzmjVar9;
                                                    iZzf = zzkt.zzk(bArr, i40, zzksVar4);
                                                    if (zzksVar4.zzb != 0) {
                                                        z3 = true;
                                                    } else {
                                                        z3 = false;
                                                    }
                                                    zzkuVar.zze(z3);
                                                    while (iZzf < i81) {
                                                        iZzh9 = zzkt.zzh(bArr, iZzf, zzksVar4);
                                                        if (i57 == zzksVar4.zza) {
                                                            iZzf = zzkt.zzk(bArr, iZzh9, zzksVar4);
                                                            if (zzksVar4.zzb != 0) {
                                                                z4 = true;
                                                            } else {
                                                                z4 = false;
                                                            }
                                                            zzkuVar.zze(z4);
                                                        }
                                                    }
                                                }
                                                i49 = i57;
                                                zzksVar3 = zzksVar4;
                                                i51 = i58;
                                                i50 = i38;
                                                iZzg = i40;
                                                if (iZzg != i40) {
                                                    i40 = i40;
                                                    i81 = i81;
                                                    zzksVar3 = zzksVar3;
                                                    obj4 = obj;
                                                    zzksVar5 = zzksVar3;
                                                    i86 = i50;
                                                    i83 = i51;
                                                    i84 = i49;
                                                    i87 = i10;
                                                    i82 = 0;
                                                    i85 = i9;
                                                    unsafe5 = unsafe3;
                                                    i3 = i3;
                                                } else {
                                                    i40 = i40;
                                                    i81 = i81;
                                                    zzksVar3 = zzksVar3;
                                                    obj2 = obj;
                                                    i8 = iZzg;
                                                    zzksVar2 = zzksVar3;
                                                    unsafe2 = unsafe3;
                                                    i4 = i3;
                                                    int i1014 = i49;
                                                    i13 = i50;
                                                    i82 = i51;
                                                    i12 = i1014;
                                                }
                                            } else {
                                                int i114 = zzkt.zza;
                                                zzkuVar2 = (zzku) zzmjVar9;
                                                iZzf = zzkt.zzh(bArr, i40, zzksVar4);
                                                i63 = zzksVar4.zza + iZzf;
                                                while (iZzf < i63) {
                                                    iZzf = zzkt.zzk(bArr, iZzf, zzksVar4);
                                                    if (zzksVar4.zzb != 0) {
                                                        z5 = true;
                                                    } else {
                                                        z5 = false;
                                                    }
                                                    zzkuVar2.zze(z5);
                                                }
                                                if (iZzf != i63) {
                                                    throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            }
                                            i49 = i57;
                                            iZzg = iZzf;
                                            zzksVar3 = zzksVar4;
                                            i51 = i58;
                                            i50 = i38;
                                            if (iZzg != i40) {
                                                i40 = i40;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj4 = obj;
                                                zzksVar5 = zzksVar3;
                                                i86 = i50;
                                                i83 = i51;
                                                i84 = i49;
                                                i87 = i10;
                                                i82 = 0;
                                                i85 = i9;
                                                unsafe5 = unsafe3;
                                                i3 = i3;
                                            } else {
                                                i40 = i40;
                                                i81 = i81;
                                                zzksVar3 = zzksVar3;
                                                obj2 = obj;
                                                i8 = iZzg;
                                                zzksVar2 = zzksVar3;
                                                unsafe2 = unsafe3;
                                                i4 = i3;
                                                int i1015 = i49;
                                                i13 = i50;
                                                i82 = i51;
                                                i12 = i1015;
                                            }
                                            break;
                                        case 26:
                                            zzksVar4 = zzksVar3;
                                            zzmjVar10 = zzmjVar2;
                                            unsafe3 = unsafe3;
                                            i57 = i16;
                                            i38 = i38;
                                            i81 = i81;
                                            i58 = i48;
                                            if (i14 == 2) {
                                                i49 = i57;
                                                zzksVar3 = zzksVar4;
                                                i50 = i38;
                                                i51 = i58;
                                                iZzg = i40;
                                            } else if ((j3 & 536870912) == 0) {
                                                iZzh11 = zzkt.zzh(bArr, i40, zzksVar4);
                                                i68 = zzksVar4.zza;
                                                if (i68 >= 0) {
                                                    throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                                if (i68 == 0) {
                                                    obj3 = "";
                                                    zzmjVar10.add(obj3);
                                                } else {
                                                    obj3 = "";
                                                    zzmjVar10.add(new String(bArr, iZzh11, i68, zzmk.zza));
                                                    iZzh11 += i68;
                                                }
                                                while (iZzh11 < i81) {
                                                    iZzh12 = zzkt.zzh(bArr, iZzh11, zzksVar4);
                                                    if (i57 == zzksVar4.zza) {
                                                        iZzh11 = zzkt.zzh(bArr, iZzh12, zzksVar4);
                                                        i69 = zzksVar4.zza;
                                                        if (i69 >= 0) {
                                                            throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                        }
                                                        if (i69 == 0) {
                                                            zzmjVar10.add(obj3);
                                                        } else {
                                                            zzmjVar10.add(new String(bArr, iZzh11, i69, zzmk.zza));
                                                            iZzh11 += i69;
                                                        }
                                                    } else {
                                                        i49 = i57;
                                                        iZzg = iZzh11;
                                                        zzksVar3 = zzksVar4;
                                                        i50 = i38;
                                                        i51 = i58;
                                                    }
                                                }
                                                i49 = i57;
                                                iZzg = iZzh11;
                                                zzksVar3 = zzksVar4;
                                                i50 = i38;
                                                i51 = i58;
                                            } else {
                                                iZzf = zzkt.zzh(bArr, i40, zzksVar4);
                                                i64 = zzksVar4.zza;
                                                if (i64 >= 0) {
                                                    throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                                if (i64 == 0) {
                                                    zzmjVar10.add("");
                                                } else {
                                                    i65 = iZzf + i64;
                                                    if (zzoo.zzd(bArr, iZzf, i65)) {
                                                        throw new zzmm(
                                                        /*  JADX ERROR: Method code generation error
                                                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x07b8: THROW 
                                                              (wrap com.google.android.gms.internal.measurement.zzmm:0x07b5: CONSTRUCTOR (r3v42 ?? I:java.lang.String) A[MD:(java.lang.String):void (m), WRAPPED] (LINE:305) call: com.google.android.gms.internal.measurement.zzmm.<init>(java.lang.String):void type: CONSTRUCTOR)
                                                             (LINE:306) in method: com.google.android.gms.internal.measurement.zznk.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.zzks):int, file: classes.dex
                                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                                                            	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:157)
                                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                            	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:267)
                                                            	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:90)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                            	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:175)
                                                            	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:173)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                                                            	at java.base/java.util.ArrayList.forEach(Unknown Source)
                                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                                                            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
                                                            	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
                                                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
                                                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
                                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
                                                            	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
                                                            	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
                                                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                                                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                                                            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                                                            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                                                            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                                                            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                                                            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                                                            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                                                            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                                                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                                                            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                                                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r3v42 ??
                                                            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
                                                            */
                                                        /*
                                                            Method dump skipped, instruction units count: 3744
                                                            To view this dump change 'Code comments level' option to 'DEBUG'
                                                        */
                                                        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zznk.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.zzks):int");
                                                    }

                                                    @Override // com.google.android.gms.internal.measurement.zzns
                                                    public final Object zze() {
                                                        return ((zzmd) this.zzg).zzcj();
                                                    }

                                                    /* JADX WARN: Code duplicated, block: B:26:0x006f  */
                                                    /* JADX WARN: Code duplicated, block: B:28:0x0075  */
                                                    /* JADX WARN: Code duplicated, block: B:41:0x0082 A[SYNTHETIC] */
                                                    @Override // com.google.android.gms.internal.measurement.zzns
                                                    public final void zzf(Object obj) {
                                                        if (zzL(obj)) {
                                                            if (obj instanceof zzmd) {
                                                                zzmd zzmdVar = (zzmd) obj;
                                                                zzmdVar.zzcu(Integer.MAX_VALUE);
                                                                zzmdVar.zza = 0;
                                                                zzmdVar.zzcs();
                                                            }
                                                            int[] iArr = this.zzc;
                                                            for (int i = 0; i < iArr.length; i += 3) {
                                                                int iZzs = zzs(i);
                                                                int i2 = 1048575 & iZzs;
                                                                int iZzr = zzr(iZzs);
                                                                long j = i2;
                                                                if (iZzr != 9) {
                                                                    if (iZzr != 60 && iZzr != 68) {
                                                                        switch (iZzr) {
                                                                            case 17:
                                                                                if (zzI(obj, i)) {
                                                                                    zzv(i).zzf(zzb.getObject(obj, j));
                                                                                }
                                                                                break;
                                                                            case 18:
                                                                            case 19:
                                                                            case 20:
                                                                            case 21:
                                                                            case 22:
                                                                            case 23:
                                                                            case 24:
                                                                            case 25:
                                                                            case 26:
                                                                            case MotionEventCompat.AXIS_RELATIVE_X /* 27 */:
                                                                            case MotionEventCompat.AXIS_RELATIVE_Y /* 28 */:
                                                                            case 29:
                                                                            case 30:
                                                                            case 31:
                                                                            case 32:
                                                                            case 33:
                                                                            case MotionEventCompat.AXIS_GENERIC_3 /* 34 */:
                                                                            case MotionEventCompat.AXIS_GENERIC_4 /* 35 */:
                                                                            case 36:
                                                                            case MotionEventCompat.AXIS_GENERIC_6 /* 37 */:
                                                                            case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                                                                            case MotionEventCompat.AXIS_GENERIC_8 /* 39 */:
                                                                            case MotionEventCompat.AXIS_GENERIC_9 /* 40 */:
                                                                            case MotionEventCompat.AXIS_GENERIC_10 /* 41 */:
                                                                            case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                                                                            case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                                                                            case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                                                                            case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                                                                            case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                                                                            case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                                                                            case 48:
                                                                            case 49:
                                                                                ((zzmj) zzol.zzf(obj, j)).zzb();
                                                                                break;
                                                                            case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH /* 50 */:
                                                                                Unsafe unsafe = zzb;
                                                                                Object object = unsafe.getObject(obj, j);
                                                                                if (object != null) {
                                                                                    ((zznb) object).zzc();
                                                                                    unsafe.putObject(obj, j, object);
                                                                                }
                                                                                break;
                                                                        }
                                                                    } else if (zzM(obj, iArr[i], i)) {
                                                                        zzv(i).zzf(zzb.getObject(obj, j));
                                                                    }
                                                                } else if (zzI(obj, i)) {
                                                                    zzv(i).zzf(zzb.getObject(obj, j));
                                                                }
                                                            }
                                                            this.zzl.zza(obj);
                                                            if (this.zzh) {
                                                                this.zzm.zza(obj);
                                                            }
                                                        }
                                                    }

                                                    @Override // com.google.android.gms.internal.measurement.zzns
                                                    public final void zzg(Object obj, Object obj2) {
                                                        zzA(obj);
                                                        obj2.getClass();
                                                        int i = 0;
                                                        while (true) {
                                                            int[] iArr = this.zzc;
                                                            if (i >= iArr.length) {
                                                                zznu.zzp(this.zzl, obj, obj2);
                                                                if (this.zzh) {
                                                                    zznu.zzo(this.zzm, obj, obj2);
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            int iZzs = zzs(i);
                                                            int i2 = 1048575 & iZzs;
                                                            int iZzr = zzr(iZzs);
                                                            int i3 = iArr[i];
                                                            long j = i2;
                                                            switch (iZzr) {
                                                                case 0:
                                                                    if (zzI(obj2, i)) {
                                                                        zzol.zzo(obj, j, zzol.zza(obj2, j));
                                                                        zzD(obj, i);
                                                                    }
                                                                    break;
                                                                case 1:
                                                                    if (zzI(obj2, i)) {
                                                                        zzol.zzp(obj, j, zzol.zzb(obj2, j));
                                                                        zzD(obj, i);
                                                                    }
                                                                    break;
                                                                case 2:
                                                                    if (zzI(obj2, i)) {
                                                                        zzol.zzr(obj, j, zzol.zzd(obj2, j));
                                                                        zzD(obj, i);
                                                                    }
                                                                    break;
                                                                case 3:
                                                                    if (zzI(obj2, i)) {
                                                                        zzol.zzr(obj, j, zzol.zzd(obj2, j));
                                                                        zzD(obj, i);
                                                                    }
                                                                    break;
                                                                case 4:
                                                                    if (zzI(obj2, i)) {
                                                                        zzol.zzq(obj, j, zzol.zzc(obj2, j));
                                                                        zzD(obj, i);
                                                                    }
                                                                    break;
                                                                case 5:
                                                                    if (zzI(obj2, i)) {
                                                                        zzol.zzr(obj, j, zzol.zzd(obj2, j));
                                                                        zzD(obj, i);
                                                                    }
                                                                    break;
                                                                case 6:
                                                                    if (zzI(obj2, i)) {
                                                                        zzol.zzq(obj, j, zzol.zzc(obj2, j));
                                                                        zzD(obj, i);
                                                                    }
                                                                    break;
                                                                case 7:
                                                                    if (zzI(obj2, i)) {
                                                                        zzol.zzm(obj, j, zzol.zzw(obj2, j));
                                                                        zzD(obj, i);
                                                                    }
                                                                    break;
                                                                case 8:
                                                                    if (zzI(obj2, i)) {
                                                                        zzol.zzs(obj, j, zzol.zzf(obj2, j));
                                                                        zzD(obj, i);
                                                                    }
                                                                    break;
                                                                case 9:
                                                                    zzB(obj, obj2, i);
                                                                    break;
                                                                case 10:
                                                                    if (zzI(obj2, i)) {
                                                                        zzol.zzs(obj, j, zzol.zzf(obj2, j));
                                                                        zzD(obj, i);
                                                                    }
                                                                    break;
                                                                case 11:
                                                                    if (zzI(obj2, i)) {
                                                                        zzol.zzq(obj, j, zzol.zzc(obj2, j));
                                                                        zzD(obj, i);
                                                                    }
                                                                    break;
                                                                case 12:
                                                                    if (zzI(obj2, i)) {
                                                                        zzol.zzq(obj, j, zzol.zzc(obj2, j));
                                                                        zzD(obj, i);
                                                                    }
                                                                    break;
                                                                case 13:
                                                                    if (zzI(obj2, i)) {
                                                                        zzol.zzq(obj, j, zzol.zzc(obj2, j));
                                                                        zzD(obj, i);
                                                                    }
                                                                    break;
                                                                case 14:
                                                                    if (zzI(obj2, i)) {
                                                                        zzol.zzr(obj, j, zzol.zzd(obj2, j));
                                                                        zzD(obj, i);
                                                                    }
                                                                    break;
                                                                case 15:
                                                                    if (zzI(obj2, i)) {
                                                                        zzol.zzq(obj, j, zzol.zzc(obj2, j));
                                                                        zzD(obj, i);
                                                                    }
                                                                    break;
                                                                case 16:
                                                                    if (zzI(obj2, i)) {
                                                                        zzol.zzr(obj, j, zzol.zzd(obj2, j));
                                                                        zzD(obj, i);
                                                                    }
                                                                    break;
                                                                case 17:
                                                                    zzB(obj, obj2, i);
                                                                    break;
                                                                case 18:
                                                                case 19:
                                                                case 20:
                                                                case 21:
                                                                case 22:
                                                                case 23:
                                                                case 24:
                                                                case 25:
                                                                case 26:
                                                                case MotionEventCompat.AXIS_RELATIVE_X /* 27 */:
                                                                case MotionEventCompat.AXIS_RELATIVE_Y /* 28 */:
                                                                case 29:
                                                                case 30:
                                                                case 31:
                                                                case 32:
                                                                case 33:
                                                                case MotionEventCompat.AXIS_GENERIC_3 /* 34 */:
                                                                case MotionEventCompat.AXIS_GENERIC_4 /* 35 */:
                                                                case 36:
                                                                case MotionEventCompat.AXIS_GENERIC_6 /* 37 */:
                                                                case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                                                                case MotionEventCompat.AXIS_GENERIC_8 /* 39 */:
                                                                case MotionEventCompat.AXIS_GENERIC_9 /* 40 */:
                                                                case MotionEventCompat.AXIS_GENERIC_10 /* 41 */:
                                                                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                                                                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                                                                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                                                                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                                                                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                                                                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                                                                case 48:
                                                                case 49:
                                                                    zzmj zzmjVarZzd = (zzmj) zzol.zzf(obj, j);
                                                                    zzmj zzmjVar = (zzmj) zzol.zzf(obj2, j);
                                                                    int size = zzmjVarZzd.size();
                                                                    int size2 = zzmjVar.size();
                                                                    if (size > 0 && size2 > 0) {
                                                                        if (!zzmjVarZzd.zzc()) {
                                                                            zzmjVarZzd = zzmjVarZzd.zzd(size2 + size);
                                                                        }
                                                                        zzmjVarZzd.addAll(zzmjVar);
                                                                    }
                                                                    if (size > 0) {
                                                                        zzmjVar = zzmjVarZzd;
                                                                    }
                                                                    zzol.zzs(obj, j, zzmjVar);
                                                                    break;
                                                                case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH /* 50 */:
                                                                    int i4 = zznu.zza;
                                                                    zzol.zzs(obj, j, zznc.zza(zzol.zzf(obj, j), zzol.zzf(obj2, j)));
                                                                    break;
                                                                case 51:
                                                                case 52:
                                                                case 53:
                                                                case 54:
                                                                case 55:
                                                                case 56:
                                                                case 57:
                                                                case 58:
                                                                case 59:
                                                                    if (zzM(obj2, i3, i)) {
                                                                        zzol.zzs(obj, j, zzol.zzf(obj2, j));
                                                                        zzE(obj, i3, i);
                                                                    }
                                                                    break;
                                                                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                                                                    zzC(obj, obj2, i);
                                                                    break;
                                                                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                                                                case 62:
                                                                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                                                                case 64:
                                                                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                                                                case 66:
                                                                case 67:
                                                                    if (zzM(obj2, i3, i)) {
                                                                        zzol.zzs(obj, j, zzol.zzf(obj2, j));
                                                                        zzE(obj, i3, i);
                                                                    }
                                                                    break;
                                                                case 68:
                                                                    zzC(obj, obj2, i);
                                                                    break;
                                                            }
                                                            i += 3;
                                                        }
                                                    }

                                                    @Override // com.google.android.gms.internal.measurement.zzns
                                                    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzks zzksVar) throws IOException {
                                                        zzc(obj, bArr, i, i2, 0, zzksVar);
                                                    }

                                                    /* JADX WARN: Code duplicated, block: B:7:0x0023  */
                                                    @Override // com.google.android.gms.internal.measurement.zzns
                                                    public final void zzi(Object obj, zzor zzorVar) throws IOException {
                                                        Map.Entry entry;
                                                        int i;
                                                        int i2;
                                                        int i3;
                                                        int[] iArr;
                                                        if (this.zzh) {
                                                            zzlu zzluVar = ((zzma) obj).zzb;
                                                            if (zzluVar.zza.isEmpty()) {
                                                                entry = null;
                                                            } else {
                                                                entry = (Map.Entry) zzluVar.zze().next();
                                                            }
                                                        } else {
                                                            entry = null;
                                                        }
                                                        int[] iArr2 = this.zzc;
                                                        Unsafe unsafe = zzb;
                                                        int i4 = 1048575;
                                                        int i5 = 1048575;
                                                        int i6 = 0;
                                                        int i7 = 0;
                                                        while (i7 < iArr2.length) {
                                                            int iZzs = zzs(i7);
                                                            int iZzr = zzr(iZzs);
                                                            int i8 = iArr2[i7];
                                                            if (iZzr <= 17) {
                                                                int i9 = iArr2[i7 + 2];
                                                                int i10 = i9 & i4;
                                                                if (i10 != i5) {
                                                                    i6 = i10 == i4 ? 0 : unsafe.getInt(obj, i10);
                                                                    i5 = i10;
                                                                }
                                                                i = i5;
                                                                i2 = i6;
                                                                i3 = 1 << (i9 >>> 20);
                                                            } else {
                                                                i = i5;
                                                                i2 = i6;
                                                                i3 = 0;
                                                            }
                                                            if (entry != null) {
                                                                throw null;
                                                            }
                                                            long j = iZzs & i4;
                                                            switch (iZzr) {
                                                                case 0:
                                                                    iArr = iArr2;
                                                                    if (zzJ(obj, i7, i, i2, i3)) {
                                                                        zzorVar.zzf(i8, zzol.zza(obj, j));
                                                                        continue;
                                                                    }
                                                                    i7 += 3;
                                                                    i5 = i;
                                                                    i6 = i2;
                                                                    iArr2 = iArr;
                                                                    i4 = 1048575;
                                                                    break;
                                                                case 1:
                                                                    iArr = iArr2;
                                                                    if (zzJ(obj, i7, i, i2, i3)) {
                                                                        zzorVar.zzo(i8, zzol.zzb(obj, j));
                                                                    } else {
                                                                        continue;
                                                                    }
                                                                    i7 += 3;
                                                                    i5 = i;
                                                                    i6 = i2;
                                                                    iArr2 = iArr;
                                                                    i4 = 1048575;
                                                                    break;
                                                                case 2:
                                                                    iArr = iArr2;
                                                                    if (zzJ(obj, i7, i, i2, i3)) {
                                                                        zzorVar.zzt(i8, unsafe.getLong(obj, j));
                                                                    } else {
                                                                        continue;
                                                                    }
                                                                    i7 += 3;
                                                                    i5 = i;
                                                                    i6 = i2;
                                                                    iArr2 = iArr;
                                                                    i4 = 1048575;
                                                                    break;
                                                                case 3:
                                                                    iArr = iArr2;
                                                                    if (zzJ(obj, i7, i, i2, i3)) {
                                                                        zzorVar.zzK(i8, unsafe.getLong(obj, j));
                                                                    } else {
                                                                        continue;
                                                                    }
                                                                    i7 += 3;
                                                                    i5 = i;
                                                                    i6 = i2;
                                                                    iArr2 = iArr;
                                                                    i4 = 1048575;
                                                                    break;
                                                                case 4:
                                                                    iArr = iArr2;
                                                                    if (zzJ(obj, i7, i, i2, i3)) {
                                                                        zzorVar.zzr(i8, unsafe.getInt(obj, j));
                                                                    } else {
                                                                        continue;
                                                                    }
                                                                    i7 += 3;
                                                                    i5 = i;
                                                                    i6 = i2;
                                                                    iArr2 = iArr;
                                                                    i4 = 1048575;
                                                                    break;
                                                                case 5:
                                                                    iArr = iArr2;
                                                                    if (zzJ(obj, i7, i, i2, i3)) {
                                                                        zzorVar.zzm(i8, unsafe.getLong(obj, j));
                                                                    } else {
                                                                        continue;
                                                                    }
                                                                    i7 += 3;
                                                                    i5 = i;
                                                                    i6 = i2;
                                                                    iArr2 = iArr;
                                                                    i4 = 1048575;
                                                                    break;
                                                                case 6:
                                                                    iArr = iArr2;
                                                                    if (zzJ(obj, i7, i, i2, i3)) {
                                                                        zzorVar.zzk(i8, unsafe.getInt(obj, j));
                                                                    } else {
                                                                        continue;
                                                                    }
                                                                    i7 += 3;
                                                                    i5 = i;
                                                                    i6 = i2;
                                                                    iArr2 = iArr;
                                                                    i4 = 1048575;
                                                                    break;
                                                                case 7:
                                                                    iArr = iArr2;
                                                                    if (zzJ(obj, i7, i, i2, i3)) {
                                                                        zzorVar.zzb(i8, zzol.zzw(obj, j));
                                                                    } else {
                                                                        continue;
                                                                    }
                                                                    i7 += 3;
                                                                    i5 = i;
                                                                    i6 = i2;
                                                                    iArr2 = iArr;
                                                                    i4 = 1048575;
                                                                    break;
                                                                case 8:
                                                                    iArr = iArr2;
                                                                    if (zzJ(obj, i7, i, i2, i3)) {
                                                                        zzO(i8, unsafe.getObject(obj, j), zzorVar);
                                                                    } else {
                                                                        continue;
                                                                    }
                                                                    i7 += 3;
                                                                    i5 = i;
                                                                    i6 = i2;
                                                                    iArr2 = iArr;
                                                                    i4 = 1048575;
                                                                    break;
                                                                case 9:
                                                                    iArr = iArr2;
                                                                    if (zzJ(obj, i7, i, i2, i3)) {
                                                                        zzorVar.zzv(i8, unsafe.getObject(obj, j), zzv(i7));
                                                                    } else {
                                                                        continue;
                                                                    }
                                                                    i7 += 3;
                                                                    i5 = i;
                                                                    i6 = i2;
                                                                    iArr2 = iArr;
                                                                    i4 = 1048575;
                                                                    break;
                                                                case 10:
                                                                    iArr = iArr2;
                                                                    if (zzJ(obj, i7, i, i2, i3)) {
                                                                        zzorVar.zzd(i8, (zzld) unsafe.getObject(obj, j));
                                                                    } else {
                                                                        continue;
                                                                    }
                                                                    i7 += 3;
                                                                    i5 = i;
                                                                    i6 = i2;
                                                                    iArr2 = iArr;
                                                                    i4 = 1048575;
                                                                    break;
                                                                case 11:
                                                                    iArr = iArr2;
                                                                    if (zzJ(obj, i7, i, i2, i3)) {
                                                                        zzorVar.zzI(i8, unsafe.getInt(obj, j));
                                                                    } else {
                                                                        continue;
                                                                    }
                                                                    i7 += 3;
                                                                    i5 = i;
                                                                    i6 = i2;
                                                                    iArr2 = iArr;
                                                                    i4 = 1048575;
                                                                    break;
                                                                case 12:
                                                                    iArr = iArr2;
                                                                    if (zzJ(obj, i7, i, i2, i3)) {
                                                                        zzorVar.zzi(i8, unsafe.getInt(obj, j));
                                                                    } else {
                                                                        continue;
                                                                    }
                                                                    i7 += 3;
                                                                    i5 = i;
                                                                    i6 = i2;
                                                                    iArr2 = iArr;
                                                                    i4 = 1048575;
                                                                    break;
                                                                case 13:
                                                                    iArr = iArr2;
                                                                    if (zzJ(obj, i7, i, i2, i3)) {
                                                                        zzorVar.zzx(i8, unsafe.getInt(obj, j));
                                                                    } else {
                                                                        continue;
                                                                    }
                                                                    i7 += 3;
                                                                    i5 = i;
                                                                    i6 = i2;
                                                                    iArr2 = iArr;
                                                                    i4 = 1048575;
                                                                    break;
                                                                case 14:
                                                                    iArr = iArr2;
                                                                    if (zzJ(obj, i7, i, i2, i3)) {
                                                                        zzorVar.zzz(i8, unsafe.getLong(obj, j));
                                                                    } else {
                                                                        continue;
                                                                    }
                                                                    i7 += 3;
                                                                    i5 = i;
                                                                    i6 = i2;
                                                                    iArr2 = iArr;
                                                                    i4 = 1048575;
                                                                    break;
                                                                case 15:
                                                                    iArr = iArr2;
                                                                    if (zzJ(obj, i7, i, i2, i3)) {
                                                                        zzorVar.zzB(i8, unsafe.getInt(obj, j));
                                                                    } else {
                                                                        continue;
                                                                    }
                                                                    i7 += 3;
                                                                    i5 = i;
                                                                    i6 = i2;
                                                                    iArr2 = iArr;
                                                                    i4 = 1048575;
                                                                    break;
                                                                case 16:
                                                                    iArr = iArr2;
                                                                    if (zzJ(obj, i7, i, i2, i3)) {
                                                                        zzorVar.zzD(i8, unsafe.getLong(obj, j));
                                                                    } else {
                                                                        continue;
                                                                    }
                                                                    i7 += 3;
                                                                    i5 = i;
                                                                    i6 = i2;
                                                                    iArr2 = iArr;
                                                                    i4 = 1048575;
                                                                    break;
                                                                case 17:
                                                                    iArr = iArr2;
                                                                    if (zzJ(obj, i7, i, i2, i3)) {
                                                                        zzorVar.zzq(i8, unsafe.getObject(obj, j), zzv(i7));
                                                                    } else {
                                                                        continue;
                                                                    }
                                                                    i7 += 3;
                                                                    i5 = i;
                                                                    i6 = i2;
                                                                    iArr2 = iArr;
                                                                    i4 = 1048575;
                                                                    break;
                                                                case 18:
                                                                    zznu.zzr(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, false);
                                                                    break;
                                                                case 19:
                                                                    zznu.zzv(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, false);
                                                                    break;
                                                                case 20:
                                                                    zznu.zzx(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, false);
                                                                    break;
                                                                case 21:
                                                                    zznu.zzD(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, false);
                                                                    break;
                                                                case 22:
                                                                    zznu.zzw(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, false);
                                                                    break;
                                                                case 23:
                                                                    zznu.zzu(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, false);
                                                                    break;
                                                                case 24:
                                                                    zznu.zzt(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, false);
                                                                    break;
                                                                case 25:
                                                                    zznu.zzq(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, false);
                                                                    break;
                                                                case 26:
                                                                    int i11 = iArr2[i7];
                                                                    List list = (List) unsafe.getObject(obj, j);
                                                                    int i12 = zznu.zza;
                                                                    if (list != null && !list.isEmpty()) {
                                                                        zzorVar.zzH(i11, list);
                                                                    }
                                                                    break;
                                                                case MotionEventCompat.AXIS_RELATIVE_X /* 27 */:
                                                                    int i13 = iArr2[i7];
                                                                    List list2 = (List) unsafe.getObject(obj, j);
                                                                    zzns zznsVarZzv = zzv(i7);
                                                                    int i14 = zznu.zza;
                                                                    if (list2 != null && !list2.isEmpty()) {
                                                                        for (int i15 = 0; i15 < list2.size(); i15++) {
                                                                            ((zzll) zzorVar).zzv(i13, list2.get(i15), zznsVarZzv);
                                                                        }
                                                                    }
                                                                    break;
                                                                case MotionEventCompat.AXIS_RELATIVE_Y /* 28 */:
                                                                    int i16 = iArr2[i7];
                                                                    List list3 = (List) unsafe.getObject(obj, j);
                                                                    int i17 = zznu.zza;
                                                                    if (list3 != null && !list3.isEmpty()) {
                                                                        zzorVar.zze(i16, list3);
                                                                    }
                                                                    break;
                                                                case 29:
                                                                    zznu.zzC(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, false);
                                                                    break;
                                                                case 30:
                                                                    zznu.zzs(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, false);
                                                                    break;
                                                                case 31:
                                                                    zznu.zzy(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, false);
                                                                    break;
                                                                case 32:
                                                                    zznu.zzz(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, false);
                                                                    break;
                                                                case 33:
                                                                    zznu.zzA(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, false);
                                                                    break;
                                                                case MotionEventCompat.AXIS_GENERIC_3 /* 34 */:
                                                                    zznu.zzB(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, false);
                                                                    break;
                                                                case MotionEventCompat.AXIS_GENERIC_4 /* 35 */:
                                                                    zznu.zzr(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, true);
                                                                    break;
                                                                case 36:
                                                                    zznu.zzv(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, true);
                                                                    break;
                                                                case MotionEventCompat.AXIS_GENERIC_6 /* 37 */:
                                                                    zznu.zzx(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, true);
                                                                    break;
                                                                case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                                                                    zznu.zzD(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, true);
                                                                    break;
                                                                case MotionEventCompat.AXIS_GENERIC_8 /* 39 */:
                                                                    zznu.zzw(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, true);
                                                                    break;
                                                                case MotionEventCompat.AXIS_GENERIC_9 /* 40 */:
                                                                    zznu.zzu(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, true);
                                                                    break;
                                                                case MotionEventCompat.AXIS_GENERIC_10 /* 41 */:
                                                                    zznu.zzt(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, true);
                                                                    break;
                                                                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                                                                    zznu.zzq(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, true);
                                                                    break;
                                                                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                                                                    zznu.zzC(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, true);
                                                                    break;
                                                                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                                                                    zznu.zzs(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, true);
                                                                    break;
                                                                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                                                                    zznu.zzy(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, true);
                                                                    break;
                                                                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                                                                    zznu.zzz(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, true);
                                                                    break;
                                                                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                                                                    zznu.zzA(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, true);
                                                                    break;
                                                                case 48:
                                                                    zznu.zzB(iArr2[i7], (List) unsafe.getObject(obj, j), zzorVar, true);
                                                                    break;
                                                                case 49:
                                                                    int i18 = iArr2[i7];
                                                                    List list4 = (List) unsafe.getObject(obj, j);
                                                                    zzns zznsVarZzv2 = zzv(i7);
                                                                    int i19 = zznu.zza;
                                                                    if (list4 != null && !list4.isEmpty()) {
                                                                        for (int i20 = 0; i20 < list4.size(); i20++) {
                                                                            ((zzll) zzorVar).zzq(i18, list4.get(i20), zznsVarZzv2);
                                                                        }
                                                                    }
                                                                    break;
                                                                case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH /* 50 */:
                                                                    if (unsafe.getObject(obj, j) != null) {
                                                                        throw null;
                                                                    }
                                                                    break;
                                                                case 51:
                                                                    if (zzM(obj, i8, i7)) {
                                                                        zzorVar.zzf(i8, zzm(obj, j));
                                                                    }
                                                                    break;
                                                                case 52:
                                                                    if (zzM(obj, i8, i7)) {
                                                                        zzorVar.zzo(i8, zzn(obj, j));
                                                                    }
                                                                    break;
                                                                case 53:
                                                                    if (zzM(obj, i8, i7)) {
                                                                        zzorVar.zzt(i8, zzt(obj, j));
                                                                    }
                                                                    break;
                                                                case 54:
                                                                    if (zzM(obj, i8, i7)) {
                                                                        zzorVar.zzK(i8, zzt(obj, j));
                                                                    }
                                                                    break;
                                                                case 55:
                                                                    if (zzM(obj, i8, i7)) {
                                                                        zzorVar.zzr(i8, zzo(obj, j));
                                                                    }
                                                                    break;
                                                                case 56:
                                                                    if (zzM(obj, i8, i7)) {
                                                                        zzorVar.zzm(i8, zzt(obj, j));
                                                                    }
                                                                    break;
                                                                case 57:
                                                                    if (zzM(obj, i8, i7)) {
                                                                        zzorVar.zzk(i8, zzo(obj, j));
                                                                    }
                                                                    break;
                                                                case 58:
                                                                    if (zzM(obj, i8, i7)) {
                                                                        zzorVar.zzb(i8, zzN(obj, j));
                                                                    }
                                                                    break;
                                                                case 59:
                                                                    if (zzM(obj, i8, i7)) {
                                                                        zzO(i8, unsafe.getObject(obj, j), zzorVar);
                                                                    }
                                                                    break;
                                                                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                                                                    if (zzM(obj, i8, i7)) {
                                                                        zzorVar.zzv(i8, unsafe.getObject(obj, j), zzv(i7));
                                                                    }
                                                                    break;
                                                                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                                                                    if (zzM(obj, i8, i7)) {
                                                                        zzorVar.zzd(i8, (zzld) unsafe.getObject(obj, j));
                                                                    }
                                                                    break;
                                                                case 62:
                                                                    if (zzM(obj, i8, i7)) {
                                                                        zzorVar.zzI(i8, zzo(obj, j));
                                                                    }
                                                                    break;
                                                                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                                                                    if (zzM(obj, i8, i7)) {
                                                                        zzorVar.zzi(i8, zzo(obj, j));
                                                                    }
                                                                    break;
                                                                case 64:
                                                                    if (zzM(obj, i8, i7)) {
                                                                        zzorVar.zzx(i8, zzo(obj, j));
                                                                    }
                                                                    break;
                                                                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                                                                    if (zzM(obj, i8, i7)) {
                                                                        zzorVar.zzz(i8, zzt(obj, j));
                                                                    }
                                                                    break;
                                                                case 66:
                                                                    if (zzM(obj, i8, i7)) {
                                                                        zzorVar.zzB(i8, zzo(obj, j));
                                                                    }
                                                                    break;
                                                                case 67:
                                                                    if (zzM(obj, i8, i7)) {
                                                                        zzorVar.zzD(i8, zzt(obj, j));
                                                                    }
                                                                    break;
                                                                case 68:
                                                                    if (zzM(obj, i8, i7)) {
                                                                        zzorVar.zzq(i8, unsafe.getObject(obj, j), zzv(i7));
                                                                    }
                                                                    break;
                                                            }
                                                            iArr = iArr2;
                                                            i7 += 3;
                                                            i5 = i;
                                                            i6 = i2;
                                                            iArr2 = iArr;
                                                            i4 = 1048575;
                                                        }
                                                        if (entry != null) {
                                                            throw null;
                                                        }
                                                        ((zzmd) obj).zzc.zzl(zzorVar);
                                                    }

                                                    @Override // com.google.android.gms.internal.measurement.zzns
                                                    public final boolean zzj(Object obj, Object obj2) {
                                                        boolean zZzE;
                                                        for (int i = 0; i < this.zzc.length; i += 3) {
                                                            int iZzs = zzs(i);
                                                            long j = iZzs & 1048575;
                                                            switch (zzr(iZzs)) {
                                                                case 0:
                                                                    if (!zzH(obj, obj2, i) || Double.doubleToLongBits(zzol.zza(obj, j)) != Double.doubleToLongBits(zzol.zza(obj2, j))) {
                                                                        return false;
                                                                    }
                                                                    continue;
                                                                    break;
                                                                    break;
                                                                case 1:
                                                                    if (!zzH(obj, obj2, i) || Float.floatToIntBits(zzol.zzb(obj, j)) != Float.floatToIntBits(zzol.zzb(obj2, j))) {
                                                                        return false;
                                                                    }
                                                                    continue;
                                                                    break;
                                                                    break;
                                                                case 2:
                                                                    if (!zzH(obj, obj2, i) || zzol.zzd(obj, j) != zzol.zzd(obj2, j)) {
                                                                        return false;
                                                                    }
                                                                    continue;
                                                                    break;
                                                                    break;
                                                                case 3:
                                                                    if (!zzH(obj, obj2, i) || zzol.zzd(obj, j) != zzol.zzd(obj2, j)) {
                                                                        return false;
                                                                    }
                                                                    continue;
                                                                    break;
                                                                    break;
                                                                case 4:
                                                                    if (!zzH(obj, obj2, i) || zzol.zzc(obj, j) != zzol.zzc(obj2, j)) {
                                                                        return false;
                                                                    }
                                                                    continue;
                                                                    break;
                                                                    break;
                                                                case 5:
                                                                    if (!zzH(obj, obj2, i) || zzol.zzd(obj, j) != zzol.zzd(obj2, j)) {
                                                                        return false;
                                                                    }
                                                                    continue;
                                                                    break;
                                                                    break;
                                                                case 6:
                                                                    if (!zzH(obj, obj2, i) || zzol.zzc(obj, j) != zzol.zzc(obj2, j)) {
                                                                        return false;
                                                                    }
                                                                    continue;
                                                                    break;
                                                                    break;
                                                                case 7:
                                                                    if (!zzH(obj, obj2, i) || zzol.zzw(obj, j) != zzol.zzw(obj2, j)) {
                                                                        return false;
                                                                    }
                                                                    continue;
                                                                    break;
                                                                    break;
                                                                case 8:
                                                                    if (!zzH(obj, obj2, i) || !zznu.zzE(zzol.zzf(obj, j), zzol.zzf(obj2, j))) {
                                                                        return false;
                                                                    }
                                                                    continue;
                                                                    break;
                                                                    break;
                                                                case 9:
                                                                    if (!zzH(obj, obj2, i) || !zznu.zzE(zzol.zzf(obj, j), zzol.zzf(obj2, j))) {
                                                                        return false;
                                                                    }
                                                                    continue;
                                                                    break;
                                                                    break;
                                                                case 10:
                                                                    if (!zzH(obj, obj2, i) || !zznu.zzE(zzol.zzf(obj, j), zzol.zzf(obj2, j))) {
                                                                        return false;
                                                                    }
                                                                    continue;
                                                                    break;
                                                                    break;
                                                                case 11:
                                                                    if (!zzH(obj, obj2, i) || zzol.zzc(obj, j) != zzol.zzc(obj2, j)) {
                                                                        return false;
                                                                    }
                                                                    continue;
                                                                    break;
                                                                    break;
                                                                case 12:
                                                                    if (!zzH(obj, obj2, i) || zzol.zzc(obj, j) != zzol.zzc(obj2, j)) {
                                                                        return false;
                                                                    }
                                                                    continue;
                                                                    break;
                                                                    break;
                                                                case 13:
                                                                    if (!zzH(obj, obj2, i) || zzol.zzc(obj, j) != zzol.zzc(obj2, j)) {
                                                                        return false;
                                                                    }
                                                                    continue;
                                                                    break;
                                                                    break;
                                                                case 14:
                                                                    if (!zzH(obj, obj2, i) || zzol.zzd(obj, j) != zzol.zzd(obj2, j)) {
                                                                        return false;
                                                                    }
                                                                    continue;
                                                                    break;
                                                                    break;
                                                                case 15:
                                                                    if (!zzH(obj, obj2, i) || zzol.zzc(obj, j) != zzol.zzc(obj2, j)) {
                                                                        return false;
                                                                    }
                                                                    continue;
                                                                    break;
                                                                    break;
                                                                case 16:
                                                                    if (!zzH(obj, obj2, i) || zzol.zzd(obj, j) != zzol.zzd(obj2, j)) {
                                                                        return false;
                                                                    }
                                                                    continue;
                                                                    break;
                                                                    break;
                                                                case 17:
                                                                    if (!zzH(obj, obj2, i) || !zznu.zzE(zzol.zzf(obj, j), zzol.zzf(obj2, j))) {
                                                                        return false;
                                                                    }
                                                                    continue;
                                                                    break;
                                                                    break;
                                                                case 18:
                                                                case 19:
                                                                case 20:
                                                                case 21:
                                                                case 22:
                                                                case 23:
                                                                case 24:
                                                                case 25:
                                                                case 26:
                                                                case MotionEventCompat.AXIS_RELATIVE_X /* 27 */:
                                                                case MotionEventCompat.AXIS_RELATIVE_Y /* 28 */:
                                                                case 29:
                                                                case 30:
                                                                case 31:
                                                                case 32:
                                                                case 33:
                                                                case MotionEventCompat.AXIS_GENERIC_3 /* 34 */:
                                                                case MotionEventCompat.AXIS_GENERIC_4 /* 35 */:
                                                                case 36:
                                                                case MotionEventCompat.AXIS_GENERIC_6 /* 37 */:
                                                                case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                                                                case MotionEventCompat.AXIS_GENERIC_8 /* 39 */:
                                                                case MotionEventCompat.AXIS_GENERIC_9 /* 40 */:
                                                                case MotionEventCompat.AXIS_GENERIC_10 /* 41 */:
                                                                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                                                                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                                                                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                                                                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                                                                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                                                                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                                                                case 48:
                                                                case 49:
                                                                    zZzE = zznu.zzE(zzol.zzf(obj, j), zzol.zzf(obj2, j));
                                                                    break;
                                                                case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH /* 50 */:
                                                                    zZzE = zznu.zzE(zzol.zzf(obj, j), zzol.zzf(obj2, j));
                                                                    break;
                                                                case 51:
                                                                case 52:
                                                                case 53:
                                                                case 54:
                                                                case 55:
                                                                case 56:
                                                                case 57:
                                                                case 58:
                                                                case 59:
                                                                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                                                                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                                                                case 62:
                                                                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                                                                case 64:
                                                                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                                                                case 66:
                                                                case 67:
                                                                case 68:
                                                                    long jZzp = zzp(i) & 1048575;
                                                                    if (zzol.zzc(obj, jZzp) != zzol.zzc(obj2, jZzp) || !zznu.zzE(zzol.zzf(obj, j), zzol.zzf(obj2, j))) {
                                                                        return false;
                                                                    }
                                                                    continue;
                                                                    break;
                                                                    break;
                                                                default:
                                                                    continue;
                                                                    break;
                                                            }
                                                            if (!zZzE) {
                                                                return false;
                                                            }
                                                        }
                                                        if (!((zzmd) obj).zzc.equals(((zzmd) obj2).zzc)) {
                                                            return false;
                                                        }
                                                        if (this.zzh) {
                                                            return ((zzma) obj).zzb.equals(((zzma) obj2).zzb);
                                                        }
                                                        return true;
                                                    }

                                                    /* JADX WARN: Code duplicated, block: B:42:0x0099  */
                                                    /* JADX WARN: Code duplicated, block: B:44:0x00a8  */
                                                    /* JADX WARN: Code duplicated, block: B:47:0x00b3  */
                                                    /* JADX WARN: Code duplicated, block: B:50:0x00be A[LOOP:1: B:45:0x00ad->B:50:0x00be, LOOP_END] */
                                                    /* JADX WARN: Code duplicated, block: B:67:0x00bd A[SYNTHETIC] */
                                                    /* JADX WARN: Code duplicated, block: B:71:0x00db A[SYNTHETIC] */
                                                    @Override // com.google.android.gms.internal.measurement.zzns
                                                    public final boolean zzk(Object obj) {
                                                        int i;
                                                        int i2;
                                                        List list;
                                                        zzns zznsVarZzv;
                                                        int i3;
                                                        int i4 = 0;
                                                        int i5 = 0;
                                                        int i6 = 1048575;
                                                        while (i5 < this.zzj) {
                                                            int[] iArr = this.zzi;
                                                            int[] iArr2 = this.zzc;
                                                            int i7 = iArr[i5];
                                                            int i8 = iArr2[i7];
                                                            int iZzs = zzs(i7);
                                                            int i9 = iArr2[i7 + 2];
                                                            int i10 = i9 & 1048575;
                                                            int i11 = 1 << (i9 >>> 20);
                                                            if (i10 != i6) {
                                                                if (i10 != 1048575) {
                                                                    i4 = zzb.getInt(obj, i10);
                                                                }
                                                                i2 = i4;
                                                                i = i10;
                                                            } else {
                                                                i = i6;
                                                                i2 = i4;
                                                            }
                                                            if ((268435456 & iZzs) != 0 && !zzJ(obj, i7, i, i2, i11)) {
                                                                return false;
                                                            }
                                                            int iZzr = zzr(iZzs);
                                                            if (iZzr == 9 || iZzr == 17) {
                                                                if (zzJ(obj, i7, i, i2, i11) && !zzK(obj, iZzs, zzv(i7))) {
                                                                    return false;
                                                                }
                                                            } else if (iZzr == 27) {
                                                                list = (List) zzol.zzf(obj, iZzs & 1048575);
                                                                if (list.isEmpty()) {
                                                                    continue;
                                                                } else {
                                                                    zznsVarZzv = zzv(i7);
                                                                    for (i3 = 0; i3 < list.size(); i3++) {
                                                                        if (!zznsVarZzv.zzk(list.get(i3))) {
                                                                            return false;
                                                                        }
                                                                    }
                                                                }
                                                            } else if (iZzr == 60 || iZzr == 68) {
                                                                if (zzM(obj, i8, i7) && !zzK(obj, iZzs, zzv(i7))) {
                                                                    return false;
                                                                }
                                                            } else if (iZzr == 49) {
                                                                list = (List) zzol.zzf(obj, iZzs & 1048575);
                                                                if (list.isEmpty()) {
                                                                    zznsVarZzv = zzv(i7);
                                                                    while (i3 < list.size()) {
                                                                        if (!zznsVarZzv.zzk(list.get(i3))) {
                                                                            return false;
                                                                        }
                                                                    }
                                                                } else {
                                                                    continue;
                                                                }
                                                            } else if (iZzr == 50 && !((zznb) zzol.zzf(obj, iZzs & 1048575)).isEmpty()) {
                                                                throw null;
                                                            }
                                                            i5++;
                                                            i6 = i;
                                                            i4 = i2;
                                                        }
                                                        return !this.zzh || ((zzma) obj).zzb.zzh();
                                                    }
                                                }
