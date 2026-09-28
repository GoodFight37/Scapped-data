package com.google.android.gms.internal.play_billing;

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
import java.util.RandomAccess;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.0.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzgo<T> implements zzgv<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzho.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzgl zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzhh zzl;
    private final zzev zzm;

    private zzgo(int[] iArr, Object[] objArr, int i, int i2, zzgl zzglVar, boolean z, int[] iArr2, int i3, int i4, zzgq zzgqVar, zzfy zzfyVar, zzhh zzhhVar, zzev zzevVar, zzgg zzggVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        boolean z2 = false;
        if (zzevVar != null && (zzglVar instanceof zzff)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzi = iArr2;
        this.zzj = i3;
        this.zzk = i4;
        this.zzl = zzhhVar;
        this.zzm = zzevVar;
        this.zzg = zzglVar;
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
            zzgv zzgvVarZzv = zzv(i);
            if (!zzI(obj, i)) {
                if (zzL(object)) {
                    Object objZze = zzgvVarZzv.zze();
                    zzgvVarZzv.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzD(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object objZze2 = zzgvVarZzv.zze();
                zzgvVarZzv.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzgvVarZzv.zzg(object2, object);
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
            zzgv zzgvVarZzv = zzv(i);
            if (!zzM(obj, i2, i)) {
                if (zzL(object)) {
                    Object objZze = zzgvVarZzv.zze();
                    zzgvVarZzv.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzE(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object objZze2 = zzgvVarZzv.zze();
                zzgvVarZzv.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzgvVarZzv.zzg(object2, object);
        }
    }

    private final void zzD(Object obj, int i) {
        int iZzp = zzp(i);
        long j = 1048575 & iZzp;
        if (j == 1048575) {
            return;
        }
        zzho.zzq(obj, j, (1 << (iZzp >>> 20)) | zzho.zzc(obj, j));
    }

    private final void zzE(Object obj, int i, int i2) {
        zzho.zzq(obj, zzp(i2) & 1048575, i);
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
            return (zzho.zzc(obj, j) & (1 << (iZzp >>> 20))) != 0;
        }
        int iZzs = zzs(i);
        long j2 = iZzs & 1048575;
        switch (zzr(iZzs)) {
            case 0:
                return Double.doubleToRawLongBits(zzho.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzho.zzb(obj, j2)) != 0;
            case 2:
                return zzho.zzd(obj, j2) != 0;
            case 3:
                return zzho.zzd(obj, j2) != 0;
            case 4:
                return zzho.zzc(obj, j2) != 0;
            case 5:
                return zzho.zzd(obj, j2) != 0;
            case 6:
                return zzho.zzc(obj, j2) != 0;
            case 7:
                return zzho.zzw(obj, j2);
            case 8:
                Object objZzf = zzho.zzf(obj, j2);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzei) {
                    return !zzei.zzb.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzho.zzf(obj, j2) != null;
            case 10:
                return !zzei.zzb.equals(zzho.zzf(obj, j2));
            case 11:
                return zzho.zzc(obj, j2) != 0;
            case 12:
                return zzho.zzc(obj, j2) != 0;
            case 13:
                return zzho.zzc(obj, j2) != 0;
            case 14:
                return zzho.zzd(obj, j2) != 0;
            case 15:
                return zzho.zzc(obj, j2) != 0;
            case 16:
                return zzho.zzd(obj, j2) != 0;
            case 17:
                return zzho.zzf(obj, j2) != null;
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

    private static boolean zzK(Object obj, int i, zzgv zzgvVar) {
        return zzgvVar.zzk(zzho.zzf(obj, i & 1048575));
    }

    private static boolean zzL(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzfi) {
            return ((zzfi) obj).zzz();
        }
        return true;
    }

    private final boolean zzM(Object obj, int i, int i2) {
        return zzho.zzc(obj, (long) (zzp(i2) & 1048575)) == i;
    }

    private static boolean zzN(Object obj, long j) {
        return ((Boolean) zzho.zzf(obj, j)).booleanValue();
    }

    private static final void zzO(int i, Object obj, zzhu zzhuVar) throws IOException {
        if (obj instanceof String) {
            zzhuVar.zzG(i, (String) obj);
        } else {
            zzhuVar.zzd(i, (zzei) obj);
        }
    }

    static zzhi zzd(Object obj) {
        zzfi zzfiVar = (zzfi) obj;
        zzhi zzhiVar = zzfiVar.zzc;
        if (zzhiVar != zzhi.zzc()) {
            return zzhiVar;
        }
        zzhi zzhiVarZzf = zzhi.zzf();
        zzfiVar.zzc = zzhiVarZzf;
        return zzhiVarZzf;
    }

    /* JADX WARN: Code duplicated, block: B:125:0x0265  */
    /* JADX WARN: Code duplicated, block: B:126:0x0268  */
    /* JADX WARN: Code duplicated, block: B:129:0x027f  */
    /* JADX WARN: Code duplicated, block: B:130:0x0282  */
    /* JADX WARN: Code duplicated, block: B:169:0x0345  */
    /* JADX WARN: Code duplicated, block: B:183:0x0391  */
    /* JADX WARN: Code duplicated, block: B:186:0x039a  */
    static zzgo zzl(Class cls, zzgi zzgiVar, zzgq zzgqVar, zzfy zzfyVar, zzhh zzhhVar, zzev zzevVar, zzgg zzggVar) {
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
        if (!(zzgiVar instanceof zzgu)) {
            throw null;
        }
        zzgu zzguVar = (zzgu) zzgiVar;
        String strZzd = zzguVar.zzd();
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
        Object[] objArrZze = zzguVar.zze();
        Class<?> cls2 = zzguVar.zza().getClass();
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
                        if (zzguVar.zzc() == 1 || i78 != 0) {
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
                    zzguVar = zzguVar;
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
                zzguVar = zzguVar;
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
                            zzguVar = zzguVar;
                            if (zzguVar.zzc() == 1 || i78 != 0) {
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
                                zzguVar = zzguVar;
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
            zzguVar = zzguVar;
            i34 = i19;
            i2 = i17;
            c = 55296;
        }
        return new zzgo(iArr3, objArr, i2, i5, zzguVar.zza(), false, iArr, i3, i62, zzgqVar, zzfyVar, zzhhVar, zzevVar, zzggVar);
    }

    private static double zzm(Object obj, long j) {
        return ((Double) zzho.zzf(obj, j)).doubleValue();
    }

    private static float zzn(Object obj, long j) {
        return ((Float) zzho.zzf(obj, j)).floatValue();
    }

    private static int zzo(Object obj, long j) {
        return ((Integer) zzho.zzf(obj, j)).intValue();
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
        return ((Long) zzho.zzf(obj, j)).longValue();
    }

    private final zzfl zzu(int i) {
        int i2 = i / 3;
        return (zzfl) this.zzd[i2 + i2 + 1];
    }

    private final zzgv zzv(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzgv zzgvVar = (zzgv) objArr[i3];
        if (zzgvVar != null) {
            return zzgvVar;
        }
        zzgv zzgvVarZzb = zzgs.zza().zzb((Class) objArr[i3 + 1]);
        objArr[i3] = zzgvVarZzb;
        return zzgvVarZzb;
    }

    private final Object zzw(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final Object zzx(Object obj, int i) {
        zzgv zzgvVarZzv = zzv(i);
        int iZzs = zzs(i) & 1048575;
        if (!zzI(obj, i)) {
            return zzgvVarZzv.zze();
        }
        Object object = zzb.getObject(obj, iZzs);
        if (zzL(object)) {
            return object;
        }
        Object objZze = zzgvVarZzv.zze();
        if (object != null) {
            zzgvVarZzv.zzg(objZze, object);
        }
        return objZze;
    }

    private final Object zzy(Object obj, int i, int i2) {
        zzgv zzgvVarZzv = zzv(i2);
        if (!zzM(obj, i, i2)) {
            return zzgvVarZzv.zze();
        }
        Object object = zzb.getObject(obj, zzs(i2) & 1048575);
        if (zzL(object)) {
            return object;
        }
        Object objZze = zzgvVarZzv.zze();
        if (object != null) {
            zzgvVarZzv.zzg(objZze, object);
        }
        return objZze;
    }

    private static Field zzz(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields), e);
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
    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final int zza(Object obj) {
        int i;
        ?? r16;
        ?? r5;
        int iZzC;
        int iZzC2;
        int iZzC3;
        int iZzD;
        int iZzC4;
        int iZzC5;
        int iZzd;
        int iZzC6;
        ?? Zzg;
        int size;
        int iZzC7;
        int iZzB;
        int iZzB2;
        ?? r3;
        int iZzA;
        ?? ZzC;
        ?? Zzh;
        int iZze;
        int iZzC8;
        int iZzC9;
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
                int iZza = i4 + ((zzfi) obj).zzc.zza();
                if (!this.zzh) {
                    return iZza;
                }
                zzhd zzhdVar = ((zzff) obj).zzb.zza;
                int iZzc = zzhdVar.zzc();
                int iZzc2 = 0;
                for (int i6 = 0; i6 < iZzc; i6++) {
                    Map.Entry entryZzg = zzhdVar.zzg(i6);
                    iZzc2 += zzez.zzc((zzey) ((zzgz) entryZzg).zza(), entryZzg.getValue());
                }
                for (Map.Entry entry : zzhdVar.zzd()) {
                    iZzc2 += zzez.zzc((zzey) entry.getKey(), entry.getValue());
                }
                return iZza + iZzc2;
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
            if (iZzr >= zzfa.DOUBLE_LIST_PACKED.zza()) {
                zzfa.SINT64_LIST_PACKED.zza();
            }
            long j = i10;
            switch (iZzr) {
                case 0:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzC = zzep.zzC(i7 << 3);
                        Zzh = iZzC + 8;
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
                        iZzC2 = zzep.zzC(i7 << 3);
                        Zzh = iZzC2 + 4;
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
                        iZzC3 = zzep.zzC(i7 << 3);
                        iZzD = zzep.zzD(j2);
                        Zzh = iZzC3 + iZzD;
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
                        iZzC3 = zzep.zzC(i7 << 3);
                        iZzD = zzep.zzD(j3);
                        Zzh = iZzC3 + iZzD;
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
                        iZzC3 = zzep.zzC(i7 << 3);
                        iZzD = zzep.zzD(j4);
                        Zzh = iZzC3 + iZzD;
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
                        iZzC = zzep.zzC(i7 << 3);
                        Zzh = iZzC + 8;
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
                        iZzC2 = zzep.zzC(i7 << 3);
                        Zzh = iZzC2 + 4;
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
                        iZzC4 = zzep.zzC(i7 << 3);
                        Zzh = iZzC4 + 1;
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
                        if (object instanceof zzei) {
                            iZzC5 = zzep.zzC(i11);
                            iZzd = ((zzei) object).zzd();
                            iZzC6 = zzep.zzC(iZzd);
                            Zzh = iZzC5 + iZzC6 + iZzd;
                            i4 += Zzh;
                        } else {
                            iZzC3 = zzep.zzC(i11);
                            iZzD = zzep.zzB((String) object);
                            Zzh = iZzC3 + iZzD;
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
                        Zzh = zzgx.zzh(i7, unsafe.getObject(obj, j), zzv(i3));
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
                        zzei zzeiVar = (zzei) unsafe.getObject(obj, j);
                        iZzC5 = zzep.zzC(i7 << 3);
                        iZzd = zzeiVar.zzd();
                        iZzC6 = zzep.zzC(iZzd);
                        Zzh = iZzC5 + iZzC6 + iZzd;
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
                        iZzC3 = zzep.zzC(i7 << 3);
                        iZzD = zzep.zzC(i12);
                        Zzh = iZzC3 + iZzD;
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
                        iZzC3 = zzep.zzC(i7 << 3);
                        iZzD = zzep.zzD(j5);
                        Zzh = iZzC3 + iZzD;
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
                        iZzC2 = zzep.zzC(i7 << 3);
                        Zzh = iZzC2 + 4;
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
                        iZzC = zzep.zzC(i7 << 3);
                        Zzh = iZzC + 8;
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
                        iZzC3 = zzep.zzC(i7 << 3);
                        iZzD = zzep.zzC((i13 >> 31) ^ (i13 + i13));
                        Zzh = iZzC3 + iZzD;
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
                        iZzC3 = zzep.zzC(i7 << 3);
                        iZzD = zzep.zzD((j6 >> 63) ^ (j6 + j6));
                        Zzh = iZzC3 + iZzD;
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
                        Zzh = zzep.zzy(i7, (zzgl) unsafe.getObject(obj, j), zzv(i3));
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 18:
                    Zzh = zzgx.zzd(i7, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 19:
                    Zzh = zzgx.zzb(i7, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(obj, j);
                    int i14 = zzgx.zza;
                    if (list.size() == 0) {
                        Zzg = z;
                    } else {
                        Zzg = zzgx.zzg(list) + (list.size() * zzep.zzC(i7 << 3));
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
                    int i15 = zzgx.zza;
                    size = list2.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzC3 = zzgx.zzl(list2);
                        iZzC7 = zzep.zzC(i7 << 3);
                        iZzD = size * iZzC7;
                        Zzh = iZzC3 + iZzD;
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
                    int i16 = zzgx.zza;
                    size = list3.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzC3 = zzgx.zzf(list3);
                        iZzC7 = zzep.zzC(i7 << 3);
                        iZzD = size * iZzC7;
                        Zzh = iZzC3 + iZzD;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 23:
                    Zzh = zzgx.zzd(i7, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 24:
                    Zzh = zzgx.zzb(i7, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 25:
                    List list4 = (List) unsafe.getObject(obj, j);
                    int i17 = zzgx.zza;
                    int size2 = list4.size();
                    if (size2 == 0) {
                        Zzh = z;
                    } else {
                        Zzh = size2 * (zzep.zzC(i7 << 3) + 1);
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
                    int i18 = zzgx.zza;
                    int size3 = r0.size();
                    if (size3 == 0) {
                        Zzg = z;
                    } else {
                        int iZzC10 = zzep.zzC(i7 << 3) * size3;
                        if (r0 instanceof zzfx) {
                            zzfx zzfxVar = (zzfx) r0;
                            for (?? r7 = z; r7 < size3; r7++) {
                                Object objZza = zzfxVar.zza();
                                if (objZza instanceof zzei) {
                                    Zzg = iZzC10;
                                    int iZzd2 = ((zzei) objZza).zzd();
                                    iZzB2 = Zzg + zzep.zzC(iZzd2) + iZzd2;
                                } else {
                                    Zzg = iZzC10;
                                    iZzB2 = Zzg + zzep.zzB((String) objZza);
                                }
                                Zzg = iZzB2;
                            }
                            Zzg = iZzC10;
                        } else {
                            for (?? r8 = z; r8 < size3; r8++) {
                                Object obj2 = r0.get(r8);
                                if (obj2 instanceof zzei) {
                                    Zzg = iZzC10;
                                    int iZzd3 = ((zzei) obj2).zzd();
                                    iZzB = Zzg + zzep.zzC(iZzd3) + iZzd3;
                                } else {
                                    Zzg = iZzC10;
                                    iZzB = Zzg + zzep.zzB((String) obj2);
                                }
                                Zzg = iZzB;
                            }
                            Zzg = iZzC10;
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
                    zzgv zzgvVarZzv = zzv(i3);
                    int i19 = zzgx.zza;
                    int size4 = r9.size();
                    if (size4 == 0) {
                        r3 = z;
                    } else {
                        int iZzC11 = zzep.zzC(i7 << 3) * size4;
                        for (?? r10 = z; r10 < size4; r10++) {
                            Object obj3 = r9.get(r10);
                            if (obj3 instanceof zzfw) {
                                r3 = iZzC11;
                                int iZza2 = ((zzfw) obj3).zza();
                                iZzA = (r3 == true ? 1 : 0) + zzep.zzC(iZza2) + iZza2;
                            } else {
                                r3 = iZzC11;
                                iZzA = (r3 == true ? 1 : 0) + zzep.zzA((zzgl) obj3, zzgvVarZzv);
                            }
                            r3 = iZzA;
                        }
                        r3 = iZzC11;
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
                    int i20 = zzgx.zza;
                    int size5 = r11.size();
                    if (size5 == 0) {
                        ZzC = z;
                    } else {
                        ZzC = size5 * zzep.zzC(i7 << 3);
                        for (?? r12 = z; r12 < r11.size(); r12++) {
                            int iZzd4 = ((zzei) r11.get(r12)).zzd();
                            ZzC += zzep.zzC(iZzd4) + iZzd4;
                        }
                    }
                    i4 += ZzC;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 29:
                    List list5 = (List) unsafe.getObject(obj, j);
                    int i21 = zzgx.zza;
                    size = list5.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzC3 = zzgx.zzk(list5);
                        iZzC7 = zzep.zzC(i7 << 3);
                        iZzD = size * iZzC7;
                        Zzh = iZzC3 + iZzD;
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
                    int i22 = zzgx.zza;
                    size = list6.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzC3 = zzgx.zza(list6);
                        iZzC7 = zzep.zzC(i7 << 3);
                        iZzD = size * iZzC7;
                        Zzh = iZzC3 + iZzD;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 31:
                    Zzh = zzgx.zzb(i7, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 32:
                    Zzh = zzgx.zzd(i7, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 33:
                    List list7 = (List) unsafe.getObject(obj, j);
                    int i23 = zzgx.zza;
                    size = list7.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzC3 = zzgx.zzi(list7);
                        iZzC7 = zzep.zzC(i7 << 3);
                        iZzD = size * iZzC7;
                        Zzh = iZzC3 + iZzD;
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
                    int i24 = zzgx.zza;
                    size = list8.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzC3 = zzgx.zzj(list8);
                        iZzC7 = zzep.zzC(i7 << 3);
                        iZzD = size * iZzC7;
                        Zzh = iZzC3 + iZzD;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_4 /* 35 */:
                    iZze = zzgx.zze((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzC8 = zzep.zzC(i7 << 3);
                        iZzC9 = zzep.zzC(iZze);
                        ZzC = iZzC8 + iZzC9 + iZze;
                        i4 += ZzC;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 36:
                    iZze = zzgx.zzc((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzC8 = zzep.zzC(i7 << 3);
                        iZzC9 = zzep.zzC(iZze);
                        ZzC = iZzC8 + iZzC9 + iZze;
                        i4 += ZzC;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_6 /* 37 */:
                    iZze = zzgx.zzg((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzC8 = zzep.zzC(i7 << 3);
                        iZzC9 = zzep.zzC(iZze);
                        ZzC = iZzC8 + iZzC9 + iZze;
                        i4 += ZzC;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                    iZze = zzgx.zzl((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzC8 = zzep.zzC(i7 << 3);
                        iZzC9 = zzep.zzC(iZze);
                        ZzC = iZzC8 + iZzC9 + iZze;
                        i4 += ZzC;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_8 /* 39 */:
                    iZze = zzgx.zzf((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzC8 = zzep.zzC(i7 << 3);
                        iZzC9 = zzep.zzC(iZze);
                        ZzC = iZzC8 + iZzC9 + iZze;
                        i4 += ZzC;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_9 /* 40 */:
                    iZze = zzgx.zze((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzC8 = zzep.zzC(i7 << 3);
                        iZzC9 = zzep.zzC(iZze);
                        ZzC = iZzC8 + iZzC9 + iZze;
                        i4 += ZzC;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_10 /* 41 */:
                    iZze = zzgx.zzc((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzC8 = zzep.zzC(i7 << 3);
                        iZzC9 = zzep.zzC(iZze);
                        ZzC = iZzC8 + iZzC9 + iZze;
                        i4 += ZzC;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                    List list9 = (List) unsafe.getObject(obj, j);
                    int i25 = zzgx.zza;
                    iZze = list9.size();
                    if (iZze > 0) {
                        iZzC8 = zzep.zzC(i7 << 3);
                        iZzC9 = zzep.zzC(iZze);
                        ZzC = iZzC8 + iZzC9 + iZze;
                        i4 += ZzC;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                    iZze = zzgx.zzk((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzC8 = zzep.zzC(i7 << 3);
                        iZzC9 = zzep.zzC(iZze);
                        ZzC = iZzC8 + iZzC9 + iZze;
                        i4 += ZzC;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                    iZze = zzgx.zza((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzC8 = zzep.zzC(i7 << 3);
                        iZzC9 = zzep.zzC(iZze);
                        ZzC = iZzC8 + iZzC9 + iZze;
                        i4 += ZzC;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                    iZze = zzgx.zzc((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzC8 = zzep.zzC(i7 << 3);
                        iZzC9 = zzep.zzC(iZze);
                        ZzC = iZzC8 + iZzC9 + iZze;
                        i4 += ZzC;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                    iZze = zzgx.zze((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzC8 = zzep.zzC(i7 << 3);
                        iZzC9 = zzep.zzC(iZze);
                        ZzC = iZzC8 + iZzC9 + iZze;
                        i4 += ZzC;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                    iZze = zzgx.zzi((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzC8 = zzep.zzC(i7 << 3);
                        iZzC9 = zzep.zzC(iZze);
                        ZzC = iZzC8 + iZzC9 + iZze;
                        i4 += ZzC;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 48:
                    iZze = zzgx.zzj((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzC8 = zzep.zzC(i7 << 3);
                        iZzC9 = zzep.zzC(iZze);
                        ZzC = iZzC8 + iZzC9 + iZze;
                        i4 += ZzC;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 49:
                    ?? r13 = (List) unsafe.getObject(obj, j);
                    zzgv zzgvVarZzv2 = zzv(i3);
                    int i26 = zzgx.zza;
                    int size6 = r13.size();
                    if (size6 == 0) {
                        r4 = z;
                    } else {
                        boolean z2 = z;
                        r4 = z2;
                        while (r6 < size6) {
                            r6 = z2;
                            int iZzy = zzep.zzy(i7, (zzgl) r13.get(r6), zzgvVarZzv2);
                            r6++;
                            r4 = (r4 == true ? 1 : 0) + iZzy;
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
                    zzgf zzgfVar = (zzgf) unsafe.getObject(obj, j);
                    if (zzgfVar.isEmpty()) {
                        continue;
                    } else {
                        Iterator it = zzgfVar.entrySet().iterator();
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
                        iZzC = zzep.zzC(i7 << 3);
                        Zzh = iZzC + 8;
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
                        iZzC2 = zzep.zzC(i7 << 3);
                        Zzh = iZzC2 + 4;
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
                        iZzC3 = zzep.zzC(i7 << 3);
                        iZzD = zzep.zzD(jZzt);
                        Zzh = iZzC3 + iZzD;
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
                        iZzC3 = zzep.zzC(i7 << 3);
                        iZzD = zzep.zzD(jZzt2);
                        Zzh = iZzC3 + iZzD;
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
                        iZzC3 = zzep.zzC(i7 << 3);
                        iZzD = zzep.zzD(jZzo);
                        Zzh = iZzC3 + iZzD;
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
                        iZzC = zzep.zzC(i7 << 3);
                        Zzh = iZzC + 8;
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
                        iZzC2 = zzep.zzC(i7 << 3);
                        Zzh = iZzC2 + 4;
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
                        iZzC4 = zzep.zzC(i7 << 3);
                        Zzh = iZzC4 + 1;
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
                        if (object2 instanceof zzei) {
                            iZzC5 = zzep.zzC(i27);
                            iZzd = ((zzei) object2).zzd();
                            iZzC6 = zzep.zzC(iZzd);
                            Zzh = iZzC5 + iZzC6 + iZzd;
                            i4 += Zzh;
                        } else {
                            iZzC3 = zzep.zzC(i27);
                            iZzD = zzep.zzB((String) object2);
                            Zzh = iZzC3 + iZzD;
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
                        Zzh = zzgx.zzh(i7, unsafe.getObject(obj, j), zzv(i3));
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
                        zzei zzeiVar2 = (zzei) unsafe.getObject(obj, j);
                        iZzC5 = zzep.zzC(i7 << 3);
                        iZzd = zzeiVar2.zzd();
                        iZzC6 = zzep.zzC(iZzd);
                        Zzh = iZzC5 + iZzC6 + iZzd;
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
                        iZzC3 = zzep.zzC(i7 << 3);
                        iZzD = zzep.zzC(iZzo);
                        Zzh = iZzC3 + iZzD;
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
                        iZzC3 = zzep.zzC(i7 << 3);
                        iZzD = zzep.zzD(jZzo2);
                        Zzh = iZzC3 + iZzD;
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
                        iZzC2 = zzep.zzC(i7 << 3);
                        Zzh = iZzC2 + 4;
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
                        iZzC = zzep.zzC(i7 << 3);
                        Zzh = iZzC + 8;
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
                        iZzC3 = zzep.zzC(i7 << 3);
                        iZzD = zzep.zzC((iZzo2 >> 31) ^ (iZzo2 + iZzo2));
                        Zzh = iZzC3 + iZzD;
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
                        iZzC3 = zzep.zzC(i7 << 3);
                        iZzD = zzep.zzD((jZzt3 >> 63) ^ (jZzt3 + jZzt3));
                        Zzh = iZzC3 + iZzD;
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
                        Zzh = zzep.zzy(i7, (zzgl) unsafe.getObject(obj, j), zzv(i3));
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

    @Override // com.google.android.gms.internal.play_billing.zzgv
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
                int iHashCode = (i4 * 53) + ((zzfi) obj).zzc.hashCode();
                return this.zzh ? (iHashCode * 53) + ((zzff) obj).zzb.zza.hashCode() : iHashCode;
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
                    jDoubleToLongBits = Double.doubleToLongBits(zzho.zza(obj, j));
                    byte[] bArr = zzfo.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 1:
                    i = i4 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzho.zzb(obj, j));
                    i4 = i + iFloatToIntBits;
                    break;
                case 2:
                    i = i4 * 53;
                    jDoubleToLongBits = zzho.zzd(obj, j);
                    byte[] bArr2 = zzfo.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 3:
                    i = i4 * 53;
                    jDoubleToLongBits = zzho.zzd(obj, j);
                    byte[] bArr3 = zzfo.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 4:
                    i = i4 * 53;
                    iFloatToIntBits = zzho.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 5:
                    i = i4 * 53;
                    jDoubleToLongBits = zzho.zzd(obj, j);
                    byte[] bArr4 = zzfo.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 6:
                    i = i4 * 53;
                    iFloatToIntBits = zzho.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 7:
                    i = i4 * 53;
                    iFloatToIntBits = zzfo.zza(zzho.zzw(obj, j));
                    i4 = i + iFloatToIntBits;
                    break;
                case 8:
                    i = i4 * 53;
                    iFloatToIntBits = ((String) zzho.zzf(obj, j)).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 9:
                    i2 = i4 * 53;
                    Object objZzf = zzho.zzf(obj, j);
                    if (objZzf != null) {
                        iHashCode2 = objZzf.hashCode();
                    }
                    i4 = i2 + iHashCode2;
                    break;
                case 10:
                    i = i4 * 53;
                    iFloatToIntBits = zzho.zzf(obj, j).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 11:
                    i = i4 * 53;
                    iFloatToIntBits = zzho.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 12:
                    i = i4 * 53;
                    iFloatToIntBits = zzho.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 13:
                    i = i4 * 53;
                    iFloatToIntBits = zzho.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 14:
                    i = i4 * 53;
                    jDoubleToLongBits = zzho.zzd(obj, j);
                    byte[] bArr5 = zzfo.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 15:
                    i = i4 * 53;
                    iFloatToIntBits = zzho.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 16:
                    i = i4 * 53;
                    jDoubleToLongBits = zzho.zzd(obj, j);
                    byte[] bArr6 = zzfo.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 17:
                    i2 = i4 * 53;
                    Object objZzf2 = zzho.zzf(obj, j);
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
                    iFloatToIntBits = zzho.zzf(obj, j).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH /* 50 */:
                    i = i4 * 53;
                    iFloatToIntBits = zzho.zzf(obj, j).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 51:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzm(obj, j));
                        byte[] bArr7 = zzfo.zzb;
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
                        byte[] bArr8 = zzfo.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 54:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr9 = zzfo.zzb;
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
                        byte[] bArr10 = zzfo.zzb;
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
                        iFloatToIntBits = zzfo.zza(zzN(obj, j));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 59:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = ((String) zzho.zzf(obj, j)).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzho.zzf(obj, j).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzho.zzf(obj, j).hashCode();
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
                        byte[] bArr11 = zzfo.zzb;
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
                        byte[] bArr12 = zzfo.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 68:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzho.zzf(obj, j).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
            }
            i3 += 3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:116:0x031a  */
    /* JADX WARN: Code duplicated, block: B:118:0x0320  */
    /* JADX WARN: Code duplicated, block: B:119:0x0323  */
    /* JADX WARN: Code duplicated, block: B:127:0x037f  */
    /* JADX WARN: Code duplicated, block: B:128:0x038f  */
    /* JADX WARN: Code duplicated, block: B:131:0x0397  */
    /* JADX WARN: Code duplicated, block: B:133:0x03a6  */
    /* JADX WARN: Code duplicated, block: B:134:0x03c6  */
    /* JADX WARN: Code duplicated, block: B:136:0x03c9  */
    /* JADX WARN: Code duplicated, block: B:138:0x03d6 A[LOOP:3: B:137:0x03d4->B:138:0x03d6, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:140:0x03e6  */
    /* JADX WARN: Code duplicated, block: B:143:0x03fb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:144:0x03fd  */
    /* JADX WARN: Code duplicated, block: B:146:0x0410  */
    /* JADX WARN: Code duplicated, block: B:148:0x041a A[LOOP:4: B:145:0x040e->B:148:0x041a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:150:0x042d  */
    /* JADX WARN: Code duplicated, block: B:151:0x043b  */
    /* JADX WARN: Code duplicated, block: B:153:0x0440  */
    /* JADX WARN: Code duplicated, block: B:155:0x044d A[LOOP:5: B:154:0x044b->B:155:0x044d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:160:0x0464 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:161:0x0466  */
    /* JADX WARN: Code duplicated, block: B:163:0x0479  */
    /* JADX WARN: Code duplicated, block: B:165:0x0481 A[LOOP:6: B:162:0x0477->B:165:0x0481, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:168:0x049d  */
    /* JADX WARN: Code duplicated, block: B:169:0x04aa  */
    /* JADX WARN: Code duplicated, block: B:171:0x04af  */
    /* JADX WARN: Code duplicated, block: B:173:0x04b9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:174:0x04bb  */
    /* JADX WARN: Code duplicated, block: B:177:0x04d6  */
    /* JADX WARN: Code duplicated, block: B:179:0x04da  */
    /* JADX WARN: Code duplicated, block: B:181:0x04e9  */
    /* JADX WARN: Code duplicated, block: B:183:0x04f9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:184:0x04fb  */
    /* JADX WARN: Code duplicated, block: B:186:0x0505  */
    /* JADX WARN: Code duplicated, block: B:189:0x0510  */
    /* JADX WARN: Code duplicated, block: B:190:0x0518  */
    /* JADX WARN: Code duplicated, block: B:193:0x0528  */
    /* JADX WARN: Code duplicated, block: B:196:0x0540  */
    /* JADX WARN: Code duplicated, block: B:198:0x0550  */
    /* JADX WARN: Code duplicated, block: B:199:0x055f  */
    /* JADX WARN: Code duplicated, block: B:201:0x0569  */
    /* JADX WARN: Code duplicated, block: B:203:0x0571  */
    /* JADX WARN: Code duplicated, block: B:205:0x0575 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:206:0x0577  */
    /* JADX WARN: Code duplicated, block: B:207:0x057d  */
    /* JADX WARN: Code duplicated, block: B:210:0x0587  */
    /* JADX WARN: Code duplicated, block: B:212:0x058f  */
    /* JADX WARN: Code duplicated, block: B:214:0x0597  */
    /* JADX WARN: Code duplicated, block: B:216:0x059b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:228:0x05cf  */
    /* JADX WARN: Code duplicated, block: B:229:0x05d9  */
    /* JADX WARN: Code duplicated, block: B:231:0x05e3  */
    /* JADX WARN: Code duplicated, block: B:232:0x0607  */
    /* JADX WARN: Code duplicated, block: B:234:0x0613  */
    /* JADX WARN: Code duplicated, block: B:236:0x0621  */
    /* JADX WARN: Code duplicated, block: B:238:0x062a  */
    /* JADX WARN: Code duplicated, block: B:240:0x0632 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:241:0x0634  */
    /* JADX WARN: Code duplicated, block: B:242:0x063a  */
    /* JADX WARN: Code duplicated, block: B:245:0x0649  */
    /* JADX WARN: Code duplicated, block: B:247:0x0651  */
    /* JADX WARN: Code duplicated, block: B:249:0x0659 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:257:0x067c  */
    /* JADX WARN: Code duplicated, block: B:259:0x0686 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:260:0x0688  */
    /* JADX WARN: Code duplicated, block: B:261:0x068c  */
    /* JADX WARN: Code duplicated, block: B:263:0x0694  */
    /* JADX WARN: Code duplicated, block: B:265:0x06a1  */
    /* JADX WARN: Code duplicated, block: B:267:0x06a9  */
    /* JADX WARN: Code duplicated, block: B:269:0x06b1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:26:0x006c  */
    /* JADX WARN: Code duplicated, block: B:273:0x06bf  */
    /* JADX WARN: Code duplicated, block: B:282:0x06e7 A[PHI: r0 r4 r5 r11 r19
  0x06e7: PHI (r0v33 int) = (r0v24 int), (r0v25 int), (r0v28 int), (r0v31 int), (r0v36 int) binds: [B:354:0x0837, B:344:0x07fb, B:324:0x0798, B:296:0x0724, B:235:0x061f] A[DONT_GENERATE, DONT_INLINE]
  0x06e7: PHI (r4v51 int) = (r4v46 int), (r4v48 int), (r4v49 int), (r4v50 int), (r4v53 int) binds: [B:354:0x0837, B:344:0x07fb, B:324:0x0798, B:296:0x0724, B:235:0x061f] A[DONT_GENERATE, DONT_INLINE]
  0x06e7: PHI (r5v59 int) = (r5v54 int), (r5v56 int), (r5v57 int), (r5v58 int), (r5v61 int) binds: [B:354:0x0837, B:344:0x07fb, B:324:0x0798, B:296:0x0724, B:235:0x061f] A[DONT_GENERATE, DONT_INLINE]
  0x06e7: PHI (r11v19 int) = (r11v15 int), (r11v16 int), (r11v17 int), (r11v18 int), (r11v22 int) binds: [B:354:0x0837, B:344:0x07fb, B:324:0x0798, B:296:0x0724, B:235:0x061f] A[DONT_GENERATE, DONT_INLINE]
  0x06e7: PHI (r19v12 sun.misc.Unsafe) = 
  (r19v8 sun.misc.Unsafe)
  (r19v9 sun.misc.Unsafe)
  (r19v10 sun.misc.Unsafe)
  (r19v11 sun.misc.Unsafe)
  (r19v15 sun.misc.Unsafe)
 binds: [B:354:0x0837, B:344:0x07fb, B:324:0x0798, B:296:0x0724, B:235:0x061f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:283:0x06f0  */
    /* JADX WARN: Code duplicated, block: B:285:0x06fb  */
    /* JADX WARN: Code duplicated, block: B:287:0x0708  */
    /* JADX WARN: Code duplicated, block: B:289:0x0712  */
    /* JADX WARN: Code duplicated, block: B:290:0x0714  */
    /* JADX WARN: Code duplicated, block: B:296:0x0724 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:297:0x0726  */
    /* JADX WARN: Code duplicated, block: B:299:0x0734  */
    /* JADX WARN: Code duplicated, block: B:300:0x0736  */
    /* JADX WARN: Code duplicated, block: B:303:0x073d  */
    /* JADX WARN: Code duplicated, block: B:305:0x0745  */
    /* JADX WARN: Code duplicated, block: B:307:0x074f  */
    /* JADX WARN: Code duplicated, block: B:308:0x0751  */
    /* JADX WARN: Code duplicated, block: B:30:0x00a6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:310:0x0757  */
    /* JADX WARN: Code duplicated, block: B:312:0x0762  */
    /* JADX WARN: Code duplicated, block: B:314:0x0771  */
    /* JADX WARN: Code duplicated, block: B:316:0x077d A[LOOP:14: B:315:0x077b->B:316:0x077d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:31:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:323:0x0797  */
    /* JADX WARN: Code duplicated, block: B:325:0x079a  */
    /* JADX WARN: Code duplicated, block: B:327:0x07a9  */
    /* JADX WARN: Code duplicated, block: B:329:0x07b1 A[LOOP:15: B:326:0x07a7->B:329:0x07b1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:330:0x07bb  */
    /* JADX WARN: Code duplicated, block: B:332:0x07c6  */
    /* JADX WARN: Code duplicated, block: B:334:0x07d5  */
    /* JADX WARN: Code duplicated, block: B:336:0x07e1 A[LOOP:16: B:335:0x07df->B:336:0x07e1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:33:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:343:0x07fa  */
    /* JADX WARN: Code duplicated, block: B:345:0x07fd  */
    /* JADX WARN: Code duplicated, block: B:347:0x080c  */
    /* JADX WARN: Code duplicated, block: B:349:0x0814 A[LOOP:17: B:346:0x080a->B:349:0x0814, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:34:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:350:0x081e  */
    /* JADX WARN: Code duplicated, block: B:352:0x0829  */
    /* JADX WARN: Code duplicated, block: B:354:0x0837 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:355:0x0839  */
    /* JADX WARN: Code duplicated, block: B:356:0x0850  */
    /* JADX WARN: Code duplicated, block: B:358:0x085f  */
    /* JADX WARN: Code duplicated, block: B:360:0x086c A[LOOP:18: B:359:0x086a->B:360:0x086c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:365:0x0880 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:366:0x0882  */
    /* JADX WARN: Code duplicated, block: B:368:0x0891  */
    /* JADX WARN: Code duplicated, block: B:36:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:370:0x0899 A[LOOP:19: B:367:0x088f->B:370:0x0899, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:371:0x08a3  */
    /* JADX WARN: Code duplicated, block: B:373:0x08b2  */
    /* JADX WARN: Code duplicated, block: B:375:0x08c1  */
    /* JADX WARN: Code duplicated, block: B:377:0x08cd A[LOOP:20: B:376:0x08cb->B:377:0x08cd, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:384:0x08eb  */
    /* JADX WARN: Code duplicated, block: B:386:0x08ee  */
    /* JADX WARN: Code duplicated, block: B:388:0x0901  */
    /* JADX WARN: Code duplicated, block: B:390:0x0909 A[LOOP:21: B:387:0x08ff->B:390:0x0909, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:391:0x0917  */
    /* JADX WARN: Code duplicated, block: B:393:0x0926  */
    /* JADX WARN: Code duplicated, block: B:395:0x0935  */
    /* JADX WARN: Code duplicated, block: B:397:0x0941 A[LOOP:22: B:396:0x093f->B:397:0x0941, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:404:0x095e  */
    /* JADX WARN: Code duplicated, block: B:406:0x0961  */
    /* JADX WARN: Code duplicated, block: B:408:0x0974  */
    /* JADX WARN: Code duplicated, block: B:410:0x097c A[LOOP:23: B:407:0x0972->B:410:0x097c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:413:0x0990  */
    /* JADX WARN: Code duplicated, block: B:415:0x0998 A[LOOP:2: B:412:0x098e->B:415:0x0998, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:416:0x09ab A[PHI: r0 r6 r9 r10 r11 r14 r19
  0x09ab: PHI (r0v67 int) = (r0v16 int), (r0v19 int), (r0v22 int), (r0v71 int) binds: [B:405:0x095f, B:385:0x08ec, B:365:0x0880, B:132:0x03a4] A[DONT_GENERATE, DONT_INLINE]
  0x09ab: PHI (r6v43 com.google.android.gms.internal.play_billing.zzgo<T>) = 
  (r6v22 com.google.android.gms.internal.play_billing.zzgo<T>)
  (r6v23 com.google.android.gms.internal.play_billing.zzgo<T>)
  (r6v24 com.google.android.gms.internal.play_billing.zzgo<T>)
  (r6v46 com.google.android.gms.internal.play_billing.zzgo<T>)
 binds: [B:405:0x095f, B:385:0x08ec, B:365:0x0880, B:132:0x03a4] A[DONT_GENERATE, DONT_INLINE]
  0x09ab: PHI (r9v71 com.google.android.gms.internal.play_billing.zzdw) = 
  (r9v37 com.google.android.gms.internal.play_billing.zzdw)
  (r9v38 com.google.android.gms.internal.play_billing.zzdw)
  (r9v39 com.google.android.gms.internal.play_billing.zzdw)
  (r9v74 com.google.android.gms.internal.play_billing.zzdw)
 binds: [B:405:0x095f, B:385:0x08ec, B:365:0x0880, B:132:0x03a4] A[DONT_GENERATE, DONT_INLINE]
  0x09ab: PHI (r10v78 int) = (r10v38 int), (r10v39 int), (r10v40 int), (r10v82 int) binds: [B:405:0x095f, B:385:0x08ec, B:365:0x0880, B:132:0x03a4] A[DONT_GENERATE, DONT_INLINE]
  0x09ab: PHI (r11v41 int) = (r11v12 int), (r11v13 int), (r11v14 int), (r11v45 int) binds: [B:405:0x095f, B:385:0x08ec, B:365:0x0880, B:132:0x03a4] A[DONT_GENERATE, DONT_INLINE]
  0x09ab: PHI (r14v49 int) = (r14v15 int), (r14v16 int), (r14v17 int), (r14v52 int) binds: [B:405:0x095f, B:385:0x08ec, B:365:0x0880, B:132:0x03a4] A[DONT_GENERATE, DONT_INLINE]
  0x09ab: PHI (r19v34 sun.misc.Unsafe) = (r19v5 sun.misc.Unsafe), (r19v6 sun.misc.Unsafe), (r19v7 sun.misc.Unsafe), (r19v36 sun.misc.Unsafe) binds: [B:405:0x095f, B:385:0x08ec, B:365:0x0880, B:132:0x03a4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:427:0x09fc  */
    /* JADX WARN: Code duplicated, block: B:430:0x0a0d  */
    /* JADX WARN: Code duplicated, block: B:432:0x0a1b  */
    /* JADX WARN: Code duplicated, block: B:434:0x0a2c  */
    /* JADX WARN: Code duplicated, block: B:435:0x0a3a  */
    /* JADX WARN: Code duplicated, block: B:437:0x0a3d  */
    /* JADX WARN: Code duplicated, block: B:438:0x0a6f  */
    /* JADX WARN: Code duplicated, block: B:439:0x0a7d  */
    /* JADX WARN: Code duplicated, block: B:441:0x0a8a  */
    /* JADX WARN: Code duplicated, block: B:442:0x0a9f  */
    /* JADX WARN: Code duplicated, block: B:444:0x0aac  */
    /* JADX WARN: Code duplicated, block: B:446:0x0ac5  */
    /* JADX WARN: Code duplicated, block: B:448:0x0ad2  */
    /* JADX WARN: Code duplicated, block: B:454:0x0af4  */
    /* JADX WARN: Code duplicated, block: B:456:0x0b05  */
    /* JADX WARN: Code duplicated, block: B:458:0x0b12  */
    /* JADX WARN: Code duplicated, block: B:461:0x0b26  */
    /* JADX WARN: Code duplicated, block: B:463:0x0b2e  */
    /* JADX WARN: Code duplicated, block: B:465:0x0b3a  */
    /* JADX WARN: Code duplicated, block: B:466:0x0b63  */
    /* JADX WARN: Code duplicated, block: B:467:0x0b6d  */
    /* JADX WARN: Code duplicated, block: B:469:0x0b80  */
    /* JADX WARN: Code duplicated, block: B:471:0x0b88  */
    /* JADX WARN: Code duplicated, block: B:472:0x0b8c  */
    /* JADX WARN: Code duplicated, block: B:481:0x0baf  */
    /* JADX WARN: Code duplicated, block: B:483:0x0bc1  */
    /* JADX WARN: Code duplicated, block: B:485:0x0bcb  */
    /* JADX WARN: Code duplicated, block: B:486:0x0bcd  */
    /* JADX WARN: Code duplicated, block: B:488:0x0bdb  */
    /* JADX WARN: Code duplicated, block: B:490:0x0bee  */
    /* JADX WARN: Code duplicated, block: B:491:0x0c00  */
    /* JADX WARN: Code duplicated, block: B:493:0x0c13  */
    /* JADX WARN: Code duplicated, block: B:494:0x0c25  */
    /* JADX WARN: Code duplicated, block: B:496:0x0c37  */
    /* JADX WARN: Code duplicated, block: B:497:0x0c49  */
    /* JADX WARN: Code duplicated, block: B:499:0x0c5b  */
    /* JADX WARN: Code duplicated, block: B:500:0x0c6c  */
    /* JADX WARN: Code duplicated, block: B:502:0x0c7f  */
    /* JADX WARN: Code duplicated, block: B:503:0x0c94  */
    /* JADX WARN: Code duplicated, block: B:505:0x0ca7  */
    /* JADX WARN: Code duplicated, block: B:506:0x0cbc A[PHI: r0 r6 r7 r8 r11 r19 r27
  0x0cbc: PHI (r0v98 int) = 
  (r0v75 int)
  (r0v76 int)
  (r0v77 int)
  (r0v78 int)
  (r0v79 int)
  (r0v80 int)
  (r0v81 int)
  (r0v82 int)
  (r0v84 int)
  (r0v89 int)
  (r0v94 int)
  (r0v99 int)
 binds: [B:504:0x0ca5, B:501:0x0c7d, B:498:0x0c59, B:495:0x0c35, B:492:0x0c11, B:489:0x0bec, B:482:0x0bbf, B:468:0x0b7e, B:466:0x0b63, B:462:0x0b2b, B:438:0x0a6f, B:434:0x0a2c] A[DONT_GENERATE, DONT_INLINE]
  0x0cbc: PHI (r6v78 com.google.android.gms.internal.play_billing.zzdw) = 
  (r6v52 com.google.android.gms.internal.play_billing.zzdw)
  (r6v53 com.google.android.gms.internal.play_billing.zzdw)
  (r6v54 com.google.android.gms.internal.play_billing.zzdw)
  (r6v55 com.google.android.gms.internal.play_billing.zzdw)
  (r6v56 com.google.android.gms.internal.play_billing.zzdw)
  (r6v57 com.google.android.gms.internal.play_billing.zzdw)
  (r6v58 com.google.android.gms.internal.play_billing.zzdw)
  (r6v59 com.google.android.gms.internal.play_billing.zzdw)
  (r6v61 com.google.android.gms.internal.play_billing.zzdw)
  (r6v68 com.google.android.gms.internal.play_billing.zzdw)
  (r6v73 com.google.android.gms.internal.play_billing.zzdw)
  (r6v79 com.google.android.gms.internal.play_billing.zzdw)
 binds: [B:504:0x0ca5, B:501:0x0c7d, B:498:0x0c59, B:495:0x0c35, B:492:0x0c11, B:489:0x0bec, B:482:0x0bbf, B:468:0x0b7e, B:466:0x0b63, B:462:0x0b2b, B:438:0x0a6f, B:434:0x0a2c] A[DONT_GENERATE, DONT_INLINE]
  0x0cbc: PHI (r7v26 java.lang.Object) = 
  (r7v5 java.lang.Object)
  (r7v6 java.lang.Object)
  (r7v7 java.lang.Object)
  (r7v8 java.lang.Object)
  (r7v9 java.lang.Object)
  (r7v10 java.lang.Object)
  (r7v11 java.lang.Object)
  (r7v12 java.lang.Object)
  (r7v13 java.lang.Object)
  (r7v18 java.lang.Object)
  (r7v23 java.lang.Object)
  (r7v27 java.lang.Object)
 binds: [B:504:0x0ca5, B:501:0x0c7d, B:498:0x0c59, B:495:0x0c35, B:492:0x0c11, B:489:0x0bec, B:482:0x0bbf, B:468:0x0b7e, B:466:0x0b63, B:462:0x0b2b, B:438:0x0a6f, B:434:0x0a2c] A[DONT_GENERATE, DONT_INLINE]
  0x0cbc: PHI (r8v91 com.google.android.gms.internal.play_billing.zzgo<T>) = 
  (r8v68 com.google.android.gms.internal.play_billing.zzgo<T>)
  (r8v69 com.google.android.gms.internal.play_billing.zzgo<T>)
  (r8v70 com.google.android.gms.internal.play_billing.zzgo<T>)
  (r8v71 com.google.android.gms.internal.play_billing.zzgo<T>)
  (r8v72 com.google.android.gms.internal.play_billing.zzgo<T>)
  (r8v73 com.google.android.gms.internal.play_billing.zzgo<T>)
  (r8v74 com.google.android.gms.internal.play_billing.zzgo<T>)
  (r8v75 com.google.android.gms.internal.play_billing.zzgo<T>)
  (r8v76 com.google.android.gms.internal.play_billing.zzgo<T>)
  (r8v81 com.google.android.gms.internal.play_billing.zzgo<T>)
  (r8v86 com.google.android.gms.internal.play_billing.zzgo<T>)
  (r8v92 com.google.android.gms.internal.play_billing.zzgo<T>)
 binds: [B:504:0x0ca5, B:501:0x0c7d, B:498:0x0c59, B:495:0x0c35, B:492:0x0c11, B:489:0x0bec, B:482:0x0bbf, B:468:0x0b7e, B:466:0x0b63, B:462:0x0b2b, B:438:0x0a6f, B:434:0x0a2c] A[DONT_GENERATE, DONT_INLINE]
  0x0cbc: PHI (r11v71 sun.misc.Unsafe) = 
  (r11v46 sun.misc.Unsafe)
  (r11v47 sun.misc.Unsafe)
  (r11v48 sun.misc.Unsafe)
  (r11v49 sun.misc.Unsafe)
  (r11v50 sun.misc.Unsafe)
  (r11v51 sun.misc.Unsafe)
  (r11v52 sun.misc.Unsafe)
  (r11v53 sun.misc.Unsafe)
  (r11v54 sun.misc.Unsafe)
  (r11v62 sun.misc.Unsafe)
  (r11v67 sun.misc.Unsafe)
  (r11v72 sun.misc.Unsafe)
 binds: [B:504:0x0ca5, B:501:0x0c7d, B:498:0x0c59, B:495:0x0c35, B:492:0x0c11, B:489:0x0bec, B:482:0x0bbf, B:468:0x0b7e, B:466:0x0b63, B:462:0x0b2b, B:438:0x0a6f, B:434:0x0a2c] A[DONT_GENERATE, DONT_INLINE]
  0x0cbc: PHI (r19v62 int) = 
  (r19v40 int)
  (r19v41 int)
  (r19v42 int)
  (r19v43 int)
  (r19v44 int)
  (r19v45 int)
  (r19v46 int)
  (r19v47 int)
  (r19v48 int)
  (r19v54 int)
  (r19v59 int)
  (r19v63 int)
 binds: [B:504:0x0ca5, B:501:0x0c7d, B:498:0x0c59, B:495:0x0c35, B:492:0x0c11, B:489:0x0bec, B:482:0x0bbf, B:468:0x0b7e, B:466:0x0b63, B:462:0x0b2b, B:438:0x0a6f, B:434:0x0a2c] A[DONT_GENERATE, DONT_INLINE]
  0x0cbc: PHI (r27v21 int) = 
  (r27v2 int)
  (r27v3 int)
  (r27v4 int)
  (r27v5 int)
  (r27v6 int)
  (r27v7 int)
  (r27v8 int)
  (r27v9 int)
  (r27v10 int)
  (r27v14 int)
  (r27v18 int)
  (r27v22 int)
 binds: [B:504:0x0ca5, B:501:0x0c7d, B:498:0x0c59, B:495:0x0c35, B:492:0x0c11, B:489:0x0bec, B:482:0x0bbf, B:468:0x0b7e, B:466:0x0b63, B:462:0x0b2b, B:438:0x0a6f, B:434:0x0a2c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:515:0x0cea  */
    /* JADX WARN: Code duplicated, block: B:517:0x0cf4  */
    /* JADX WARN: Code duplicated, block: B:519:0x0cfe  */
    /* JADX WARN: Code duplicated, block: B:522:0x0d14  */
    /* JADX WARN: Code duplicated, block: B:555:0x00c9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:556:0x0111 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:557:0x0141 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:558:0x0159 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:559:0x018f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:560:0x01a4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:561:0x01d0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:562:0x0210 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:563:0x022d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:564:0x0243 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:565:0x0265 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:566:0x0279 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:567:0x029b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:568:0x02b4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:569:0x030e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x0180  */
    /* JADX WARN: Code duplicated, block: B:570:0x03f5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:571:0x045e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:572:0x05c9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:573:0x05c3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:574:0x05b1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:575:0x05ab A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:576:0x0676 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:577:0x066a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:578:0x06e1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:579:0x06d9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:580:0x06d3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:581:0x06cb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:582:0x071e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:583:0x0791 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:584:0x078b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:585:0x07f4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:586:0x07ee A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:587:0x087a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:588:0x08e5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:589:0x08df A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:590:0x0958 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:591:0x0952 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:592:0x09b1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:593:0x09e9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:595:0x0cbf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:597:0x0d10 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:598:0x0059 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:599:0x02ec A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:600:0x010f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:601:0x013a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:602:0x0152 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:603:0x0187 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:604:0x019c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:605:0x01c7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:606:0x0208 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:607:0x0224 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:608:0x023a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:609:0x025d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:610:0x0271 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:611:0x0292 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:612:0x02ab A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:613:0x02d0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:614:0x00c0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:615:0x012f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:616:0x01c4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:617:0x01c4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:618:0x01c4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:619:0x01c4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:620:0x02d0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:621:0x0200 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:622:0x02d0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:623:0x02d0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:624:0x02d0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:625:0x02d0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:626:0x02d0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:627:0x02d0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:628:0x02d0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:629:0x0092 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:630:0x035e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:631:0x0352 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:632:0x030b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:633:0x09d1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:634:0x09c4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:635:0x036a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:636:0x09e6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:637:0x0cd3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:650:0x09af A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:652:0x042a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:653:0x048f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:656:0x048f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:661:0x0538 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:663:0x0522 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:666:0x05b7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:667:0x05a3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:668:0x059d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:674:0x0670 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:675:0x065f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:676:0x065b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:682:0x082d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:683:0x06b7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:684:0x06b3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:692:0x082d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:698:0x082d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:701:0x082d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:703:0x098a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:707:0x098a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:710:0x098a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:74:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:75:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:84:0x021c  */
    /* JADX WARN: Code duplicated, block: B:85:0x021e  */
    final int zzc(Object obj, byte[] bArr, int i, int i2, int i3, zzdw zzdwVar) throws IOException {
        zzgo<T> zzgoVar;
        int i4;
        int i5;
        int iZzj;
        int i6;
        int i7;
        int iZzq;
        int i8;
        int i9;
        int i10;
        int i11;
        zzdw zzdwVar2;
        int i12;
        int i13;
        int i14;
        zzeu zzeuVar;
        zzgl zzglVar;
        int i15;
        int[] iArr;
        int i16;
        int i17;
        int iZzr;
        long j;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        byte b;
        boolean z;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        Unsafe unsafe;
        int i29;
        int i30;
        int i31;
        int i32;
        zzdw zzdwVar3;
        int i33;
        Unsafe unsafe2;
        int i34;
        zzgo<T> zzgoVar2;
        int i35;
        zzdw zzdwVar4;
        int i36;
        zzfn zzfnVarZzd;
        int size;
        int i37;
        int i38;
        long j2;
        zzfn zzfnVarZzd2;
        zzfn zzfnVar;
        int i39;
        zzdw zzdwVar5;
        zzgo<T> zzgoVar3;
        int i40;
        Unsafe unsafe3;
        zzer zzerVar;
        int iZzi;
        zzer zzerVar2;
        int i41;
        int i42;
        zzfb zzfbVar;
        int iZzi2;
        zzfb zzfbVar2;
        int i43;
        int i44;
        zzga zzgaVar;
        int iZzi3;
        zzga zzgaVar2;
        int i45;
        int i46;
        int i47;
        int iZzf;
        zzga zzgaVar3;
        int iZzi4;
        zzga zzgaVar4;
        int i48;
        int i49;
        zzfj zzfjVar;
        int iZzi5;
        zzfj zzfjVar2;
        int i50;
        int i51;
        zzdy zzdyVar;
        boolean z2;
        int iZzi6;
        boolean z3;
        zzdy zzdyVar2;
        int i52;
        boolean z4;
        int i53;
        int i54;
        int iZzi7;
        int i55;
        int i56;
        int iZzi8;
        int i57;
        Object obj2;
        int iZzi9;
        int i58;
        int i59;
        int iZzi10;
        int i60;
        int iZzi11;
        int i61;
        int iZzk;
        zzfl zzflVarZzu;
        zzhh zzhhVar;
        int i62;
        Iterator it;
        Object objZzn;
        int iIntValue;
        int size2;
        Object objZzn2;
        int i63;
        int i64;
        int iIntValue2;
        int i65;
        zzfj zzfjVar3;
        int iZzi12;
        zzfj zzfjVar4;
        int i66;
        zzga zzgaVar5;
        int iZzi13;
        zzga zzgaVar6;
        int iZzi14;
        int i67;
        int i68;
        zzgv zzgvVarZzv;
        int iZzi15;
        Object object;
        long j3;
        int i69;
        int i70;
        int iZzl;
        boolean z5;
        int i71;
        int i72;
        int i73;
        int i74;
        Unsafe unsafe4;
        int i75;
        zzfl zzflVarZzu2;
        zzgo<T> zzgoVar4 = this;
        Object obj3 = obj;
        i2 = i2;
        i3 = i3;
        zzdw zzdwVar6 = zzdwVar;
        zzA(obj);
        Unsafe unsafe5 = zzb;
        int i76 = 0;
        int iZzh = i;
        int i77 = 0;
        int i78 = 0;
        int i79 = 0;
        int i80 = -1;
        int i81 = 1048575;
        while (true) {
            if (iZzh < i2) {
                int i82 = iZzh + 1;
                int i83 = bArr[iZzh];
                if (i83 < 0) {
                    iZzj = zzdx.zzj(i83, bArr, i82, zzdwVar6);
                    i5 = zzdwVar6.zza;
                } else {
                    i5 = i83;
                    iZzj = i82;
                }
                int i84 = i5 >>> 3;
                if (i84 > i80) {
                    iZzq = (i84 < zzgoVar4.zze || i84 > zzgoVar4.zzf) ? -1 : zzgoVar4.zzq(i84, i77 / 3);
                } else {
                    if (i84 < zzgoVar4.zze || i84 > zzgoVar4.zzf) {
                        i6 = -1;
                        i7 = -1;
                    } else {
                        iZzq = zzgoVar4.zzq(i84, i76);
                    }
                    if (i7 == i6) {
                        i15 = i5 & 7;
                        iArr = zzgoVar4.zzc;
                        i16 = iArr[i7 + 1];
                        i17 = i5;
                        iZzr = zzr(i16);
                        j = i16 & 1048575;
                        if (iZzr <= 17) {
                            int i85 = iArr[i7 + 2];
                            i18 = 1 << (i85 >>> 20);
                            i19 = 1048575;
                            i20 = i85 & 1048575;
                            if (i20 != i81) {
                                if (i81 != 1048575) {
                                    unsafe5.putInt(obj3, i81, i79);
                                    i19 = 1048575;
                                }
                                if (i20 == i19) {
                                    i79 = 0;
                                } else {
                                    i79 = unsafe5.getInt(obj3, i20);
                                }
                                i10 = i20;
                            } else {
                                i10 = i81;
                            }
                            switch (iZzr) {
                                case 0:
                                    i21 = iZzj;
                                    i22 = i7;
                                    i23 = i17;
                                    b = -1;
                                    if (i15 == 1) {
                                        iZzh = i21 + 8;
                                        i79 |= i18;
                                        zzho.zzo(obj3, j, Double.longBitsToDouble(zzdx.zzo(bArr, i21)));
                                        i78 = i23;
                                        i77 = i22;
                                        i80 = i84;
                                        i81 = i10;
                                        i76 = 0;
                                    } else {
                                        i27 = i23;
                                        i28 = i22;
                                        i11 = 0;
                                        i4 = i3;
                                        i76 = i28;
                                        unsafe5 = unsafe5;
                                        i9 = i79;
                                        i12 = i27;
                                        zzgoVar = zzgoVar4;
                                        zzdwVar2 = zzdwVar6;
                                        i13 = i84;
                                        i8 = i21;
                                    }
                                    break;
                                case 1:
                                    i21 = iZzj;
                                    i22 = i7;
                                    i23 = i17;
                                    b = -1;
                                    if (i15 == 5) {
                                        iZzh = i21 + 4;
                                        i79 |= i18;
                                        zzho.zzp(obj3, j, Float.intBitsToFloat(zzdx.zzb(bArr, i21)));
                                        i78 = i23;
                                        i77 = i22;
                                        i80 = i84;
                                        i81 = i10;
                                        i76 = 0;
                                    } else {
                                        i27 = i23;
                                        i28 = i22;
                                        i11 = 0;
                                        i4 = i3;
                                        i76 = i28;
                                        unsafe5 = unsafe5;
                                        i9 = i79;
                                        i12 = i27;
                                        zzgoVar = zzgoVar4;
                                        zzdwVar2 = zzdwVar6;
                                        i13 = i84;
                                        i8 = i21;
                                    }
                                    break;
                                case 2:
                                case 3:
                                    i21 = iZzj;
                                    i22 = i7;
                                    i23 = i17;
                                    b = -1;
                                    if (i15 == 0) {
                                        int iZzl2 = zzdx.zzl(bArr, i21, zzdwVar6);
                                        unsafe5.putLong(obj, j, zzdwVar6.zzb);
                                        i2 = i2;
                                        i3 = i3;
                                        i79 |= i18;
                                        i78 = i23;
                                        i77 = i22;
                                        iZzh = iZzl2;
                                        i80 = i84;
                                        i81 = i10;
                                        i76 = 0;
                                    } else {
                                        i27 = i23;
                                        i28 = i22;
                                        i11 = 0;
                                        i4 = i3;
                                        i76 = i28;
                                        unsafe5 = unsafe5;
                                        i9 = i79;
                                        i12 = i27;
                                        zzgoVar = zzgoVar4;
                                        zzdwVar2 = zzdwVar6;
                                        i13 = i84;
                                        i8 = i21;
                                    }
                                    break;
                                case 4:
                                case 11:
                                    i21 = iZzj;
                                    i22 = i7;
                                    i23 = i17;
                                    b = -1;
                                    if (i15 == 0) {
                                        i79 |= i18;
                                        iZzh = zzdx.zzi(bArr, i21, zzdwVar6);
                                        unsafe5.putInt(obj3, j, zzdwVar6.zza);
                                        i78 = i23;
                                        i77 = i22;
                                        i80 = i84;
                                        i81 = i10;
                                        i76 = 0;
                                    } else {
                                        i27 = i23;
                                        i28 = i22;
                                        i11 = 0;
                                        i4 = i3;
                                        i76 = i28;
                                        unsafe5 = unsafe5;
                                        i9 = i79;
                                        i12 = i27;
                                        zzgoVar = zzgoVar4;
                                        zzdwVar2 = zzdwVar6;
                                        i13 = i84;
                                        i8 = i21;
                                    }
                                    break;
                                case 5:
                                case 14:
                                    i21 = iZzj;
                                    i22 = i7;
                                    i23 = i17;
                                    b = -1;
                                    if (i15 == 1) {
                                        unsafe5.putLong(obj, j, zzdx.zzo(bArr, i21));
                                        i2 = i2;
                                        i3 = i3;
                                        iZzh = i21 + 8;
                                        i78 = i23;
                                        i77 = i22;
                                        i79 |= i18;
                                        i80 = i84;
                                        i81 = i10;
                                        i76 = 0;
                                    } else {
                                        i27 = i23;
                                        i28 = i22;
                                        i11 = 0;
                                        i4 = i3;
                                        i76 = i28;
                                        unsafe5 = unsafe5;
                                        i9 = i79;
                                        i12 = i27;
                                        zzgoVar = zzgoVar4;
                                        zzdwVar2 = zzdwVar6;
                                        i13 = i84;
                                        i8 = i21;
                                    }
                                    break;
                                case 6:
                                case 13:
                                    i21 = iZzj;
                                    i22 = i7;
                                    i23 = i17;
                                    b = -1;
                                    if (i15 == 5) {
                                        iZzh = i21 + 4;
                                        i79 |= i18;
                                        unsafe5.putInt(obj3, j, zzdx.zzb(bArr, i21));
                                        i78 = i23;
                                        i77 = i22;
                                        i80 = i84;
                                        i81 = i10;
                                        i76 = 0;
                                    } else {
                                        i27 = i23;
                                        i28 = i22;
                                        i11 = 0;
                                        i4 = i3;
                                        i76 = i28;
                                        unsafe5 = unsafe5;
                                        i9 = i79;
                                        i12 = i27;
                                        zzgoVar = zzgoVar4;
                                        zzdwVar2 = zzdwVar6;
                                        i13 = i84;
                                        i8 = i21;
                                    }
                                    break;
                                case 7:
                                    i21 = iZzj;
                                    i22 = i7;
                                    i23 = i17;
                                    b = -1;
                                    if (i15 == 0) {
                                        i79 |= i18;
                                        iZzh = zzdx.zzl(bArr, i21, zzdwVar6);
                                        if (zzdwVar6.zzb != 0) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        zzho.zzm(obj3, j, z);
                                        i78 = i23;
                                        i77 = i22;
                                        i80 = i84;
                                        i81 = i10;
                                        i76 = 0;
                                    } else {
                                        i27 = i23;
                                        i28 = i22;
                                        i11 = 0;
                                        i4 = i3;
                                        i76 = i28;
                                        unsafe5 = unsafe5;
                                        i9 = i79;
                                        i12 = i27;
                                        zzgoVar = zzgoVar4;
                                        zzdwVar2 = zzdwVar6;
                                        i13 = i84;
                                        i8 = i21;
                                    }
                                    break;
                                case 8:
                                    i21 = iZzj;
                                    i22 = i7;
                                    i23 = i17;
                                    b = -1;
                                    if (i15 == 2) {
                                        if ((i16 & 536870912) != 0) {
                                            i79 |= i18;
                                            iZzh = zzdx.zzg(bArr, i21, zzdwVar6);
                                        } else {
                                            iZzh = zzdx.zzi(bArr, i21, zzdwVar6);
                                            i24 = zzdwVar6.zza;
                                            if (i24 >= 0) {
                                                throw new zzfq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                            }
                                            int i86 = i79 | i18;
                                            if (i24 == 0) {
                                                zzdwVar6.zzc = "";
                                            } else {
                                                zzdwVar6.zzc = new String(bArr, iZzh, i24, zzfo.zza);
                                                iZzh += i24;
                                            }
                                            i79 = i86;
                                        }
                                        unsafe5.putObject(obj3, j, zzdwVar6.zzc);
                                        i78 = i23;
                                        i77 = i22;
                                        i80 = i84;
                                        i81 = i10;
                                        i76 = 0;
                                    } else {
                                        i27 = i23;
                                        i28 = i22;
                                        i11 = 0;
                                        i4 = i3;
                                        i76 = i28;
                                        unsafe5 = unsafe5;
                                        i9 = i79;
                                        i12 = i27;
                                        zzgoVar = zzgoVar4;
                                        zzdwVar2 = zzdwVar6;
                                        i13 = i84;
                                        i8 = i21;
                                    }
                                    break;
                                case 9:
                                    i22 = i7;
                                    i23 = i17;
                                    b = -1;
                                    if (i15 == 2) {
                                        i25 = i79 | i18;
                                        Object objZzx = zzgoVar4.zzx(obj3, i22);
                                        iZzh = zzdx.zzn(objZzx, zzgoVar4.zzv(i22), bArr, iZzj, i2, zzdwVar);
                                        zzgoVar4.zzF(obj3, i22, objZzx);
                                        i79 = i25;
                                        i78 = i23;
                                        i77 = i22;
                                        i80 = i84;
                                        i81 = i10;
                                        i76 = 0;
                                    } else {
                                        i21 = iZzj;
                                        i27 = i23;
                                        i28 = i22;
                                        i11 = 0;
                                        i4 = i3;
                                        i76 = i28;
                                        unsafe5 = unsafe5;
                                        i9 = i79;
                                        i12 = i27;
                                        zzgoVar = zzgoVar4;
                                        zzdwVar2 = zzdwVar6;
                                        i13 = i84;
                                        i8 = i21;
                                    }
                                    break;
                                case 10:
                                    i22 = i7;
                                    i23 = i17;
                                    b = -1;
                                    if (i15 == 2) {
                                        i79 |= i18;
                                        iZzh = zzdx.zza(bArr, iZzj, zzdwVar6);
                                        unsafe5.putObject(obj3, j, zzdwVar6.zzc);
                                        i78 = i23;
                                        i77 = i22;
                                        i80 = i84;
                                        i81 = i10;
                                        i76 = 0;
                                    } else {
                                        i21 = iZzj;
                                        i27 = i23;
                                        i28 = i22;
                                        i11 = 0;
                                        i4 = i3;
                                        i76 = i28;
                                        unsafe5 = unsafe5;
                                        i9 = i79;
                                        i12 = i27;
                                        zzgoVar = zzgoVar4;
                                        zzdwVar2 = zzdwVar6;
                                        i13 = i84;
                                        i8 = i21;
                                    }
                                    break;
                                case 12:
                                    i22 = i7;
                                    i23 = i17;
                                    b = -1;
                                    if (i15 == 0) {
                                        iZzh = zzdx.zzi(bArr, iZzj, zzdwVar6);
                                        i26 = zzdwVar6.zza;
                                        zzfl zzflVarZzu3 = zzgoVar4.zzu(i22);
                                        if ((i16 & Integer.MIN_VALUE) != 0 || zzflVarZzu3 == null || zzflVarZzu3.zza(i26)) {
                                            i79 |= i18;
                                            unsafe5.putInt(obj3, j, i26);
                                        } else {
                                            zzd(obj).zzj(i23, Long.valueOf(i26));
                                        }
                                        i78 = i23;
                                        i77 = i22;
                                        i80 = i84;
                                        i81 = i10;
                                        i76 = 0;
                                    } else {
                                        i21 = iZzj;
                                        i27 = i23;
                                        i28 = i22;
                                        i11 = 0;
                                        i4 = i3;
                                        i76 = i28;
                                        unsafe5 = unsafe5;
                                        i9 = i79;
                                        i12 = i27;
                                        zzgoVar = zzgoVar4;
                                        zzdwVar2 = zzdwVar6;
                                        i13 = i84;
                                        i8 = i21;
                                    }
                                    break;
                                case 15:
                                    i22 = i7;
                                    i23 = i17;
                                    b = -1;
                                    if (i15 == 0) {
                                        i79 |= i18;
                                        iZzh = zzdx.zzi(bArr, iZzj, zzdwVar6);
                                        unsafe5.putInt(obj3, j, zzel.zzb(zzdwVar6.zza));
                                        i78 = i23;
                                        i77 = i22;
                                        i80 = i84;
                                        i81 = i10;
                                        i76 = 0;
                                    } else {
                                        i21 = iZzj;
                                        i27 = i23;
                                        i28 = i22;
                                        i11 = 0;
                                        i4 = i3;
                                        i76 = i28;
                                        unsafe5 = unsafe5;
                                        i9 = i79;
                                        i12 = i27;
                                        zzgoVar = zzgoVar4;
                                        zzdwVar2 = zzdwVar6;
                                        i13 = i84;
                                        i8 = i21;
                                    }
                                    break;
                                case 16:
                                    if (i15 == 0) {
                                        i25 = i79 | i18;
                                        int iZzl3 = zzdx.zzl(bArr, iZzj, zzdwVar6);
                                        i23 = i17;
                                        i22 = i7;
                                        unsafe5.putLong(obj, j, zzel.zzc(zzdwVar6.zzb));
                                        iZzh = iZzl3;
                                        i79 = i25;
                                        i78 = i23;
                                        i77 = i22;
                                        i80 = i84;
                                        i81 = i10;
                                        i76 = 0;
                                    } else {
                                        b = -1;
                                        i21 = iZzj;
                                        i28 = i7;
                                        i27 = i17;
                                        i11 = 0;
                                        i4 = i3;
                                        i76 = i28;
                                        unsafe5 = unsafe5;
                                        i9 = i79;
                                        i12 = i27;
                                        zzgoVar = zzgoVar4;
                                        zzdwVar2 = zzdwVar6;
                                        i13 = i84;
                                        i8 = i21;
                                    }
                                    break;
                                default:
                                    i21 = iZzj;
                                    i22 = i7;
                                    i23 = i17;
                                    b = -1;
                                    if (i15 == 3) {
                                        int i87 = i79 | i18;
                                        Object objZzx2 = zzgoVar4.zzx(obj3, i22);
                                        int iZzm = zzdx.zzm(objZzx2, zzgoVar4.zzv(i22), bArr, i21, i2, (i84 << 3) | 4, zzdwVar);
                                        zzgoVar4.zzF(obj3, i22, objZzx2);
                                        i3 = i3;
                                        zzdwVar6 = zzdwVar6;
                                        i2 = i2;
                                        unsafe5 = unsafe5;
                                        iZzh = iZzm;
                                        i76 = 0;
                                        i78 = i23;
                                        i81 = i10;
                                        i79 = i87;
                                        i77 = i22;
                                        i80 = i84;
                                    } else {
                                        i27 = i23;
                                        i28 = i22;
                                        i11 = 0;
                                        i4 = i3;
                                        i76 = i28;
                                        unsafe5 = unsafe5;
                                        i9 = i79;
                                        i12 = i27;
                                        zzgoVar = zzgoVar4;
                                        zzdwVar2 = zzdwVar6;
                                        i13 = i84;
                                        i8 = i21;
                                    }
                                    break;
                            }
                        } else {
                            i10 = i81;
                            unsafe = unsafe5;
                            i29 = i17;
                            i11 = 0;
                            i30 = i7;
                            i9 = i79;
                            i31 = i2;
                            i32 = iZzj;
                            zzdwVar3 = zzdwVar6;
                            i33 = i84;
                            if (iZzr == 27) {
                                i38 = i32;
                                if (iZzr <= 49) {
                                    j2 = i16;
                                    zzfnVarZzd2 = (zzfn) unsafe.getObject(obj3, j);
                                    if (!zzfnVarZzd2.zzc()) {
                                        int size3 = zzfnVarZzd2.size();
                                        zzfnVarZzd2 = zzfnVarZzd2.zzd(size3 + size3);
                                        unsafe.putObject(obj3, j, zzfnVarZzd2);
                                    }
                                    zzfnVar = zzfnVarZzd2;
                                    switch (iZzr) {
                                        case 18:
                                        case MotionEventCompat.AXIS_GENERIC_4 /* 35 */:
                                            i31 = i31;
                                            i38 = i38;
                                            i39 = i30;
                                            zzdwVar5 = zzdwVar3;
                                            zzgoVar3 = zzgoVar4;
                                            i40 = i29;
                                            unsafe3 = unsafe;
                                            if (i15 == 2) {
                                                if (i15 == 1) {
                                                    iZzh = i38 + 8;
                                                    int i88 = zzdx.zza;
                                                    zzerVar = (zzer) zzfnVar;
                                                    zzerVar.zzf(Double.longBitsToDouble(zzdx.zzo(bArr, i38)));
                                                    while (iZzh < i31) {
                                                        iZzi = zzdx.zzi(bArr, iZzh, zzdwVar5);
                                                        if (i40 == zzdwVar5.zza) {
                                                            zzerVar.zzf(Double.longBitsToDouble(zzdx.zzo(bArr, iZzi)));
                                                            iZzh = iZzi + 8;
                                                        }
                                                    }
                                                }
                                                i33 = i33;
                                                this = zzgoVar3;
                                                iZzh = i38;
                                                if (iZzh != i38) {
                                                    i31 = i31;
                                                    i39 = i30;
                                                    i3 = i3;
                                                    i78 = i40;
                                                    i2 = i31;
                                                    i77 = i39;
                                                    zzgoVar4 = this;
                                                    i76 = 0;
                                                    unsafe5 = unsafe3;
                                                    i79 = i9;
                                                    i81 = i10;
                                                    i80 = i33;
                                                    zzdwVar6 = zzdwVar5;
                                                } else {
                                                    i31 = i31;
                                                    i39 = i30;
                                                    i12 = i40;
                                                    i8 = iZzh;
                                                    zzdwVar2 = zzdwVar5;
                                                    i76 = i39;
                                                    zzgoVar = this;
                                                    unsafe5 = unsafe3;
                                                    i13 = i33;
                                                    i4 = i3;
                                                }
                                            } else {
                                                int i89 = zzdx.zza;
                                                zzerVar2 = (zzer) zzfnVar;
                                                iZzh = zzdx.zzi(bArr, i38, zzdwVar5);
                                                i41 = zzdwVar5.zza;
                                                i42 = iZzh + i41;
                                                if (i42 <= bArr.length) {
                                                    throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                zzerVar2.zzg(zzerVar2.size() + (i41 / 8));
                                                while (iZzh < i42) {
                                                    zzerVar2.zzf(Double.longBitsToDouble(zzdx.zzo(bArr, iZzh)));
                                                    iZzh += 8;
                                                }
                                                if (iZzh != i42) {
                                                    throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            }
                                            i33 = i33;
                                            this = zzgoVar3;
                                            if (iZzh != i38) {
                                                i31 = i31;
                                                i39 = i30;
                                                i3 = i3;
                                                i78 = i40;
                                                i2 = i31;
                                                i77 = i39;
                                                zzgoVar4 = this;
                                                i76 = 0;
                                                unsafe5 = unsafe3;
                                                i79 = i9;
                                                i81 = i10;
                                                i80 = i33;
                                                zzdwVar6 = zzdwVar5;
                                            } else {
                                                i31 = i31;
                                                i39 = i30;
                                                i12 = i40;
                                                i8 = iZzh;
                                                zzdwVar2 = zzdwVar5;
                                                i76 = i39;
                                                zzgoVar = this;
                                                unsafe5 = unsafe3;
                                                i13 = i33;
                                                i4 = i3;
                                            }
                                            break;
                                        case 19:
                                        case 36:
                                            i31 = i31;
                                            i38 = i38;
                                            i39 = i30;
                                            zzdwVar5 = zzdwVar3;
                                            zzgoVar3 = zzgoVar4;
                                            i40 = i29;
                                            unsafe3 = unsafe;
                                            if (i15 == 2) {
                                                if (i15 == 5) {
                                                    iZzh = i38 + 4;
                                                    int i90 = zzdx.zza;
                                                    zzfbVar = (zzfb) zzfnVar;
                                                    zzfbVar.zzf(Float.intBitsToFloat(zzdx.zzb(bArr, i38)));
                                                    while (iZzh < i31) {
                                                        iZzi2 = zzdx.zzi(bArr, iZzh, zzdwVar5);
                                                        if (i40 == zzdwVar5.zza) {
                                                            zzfbVar.zzf(Float.intBitsToFloat(zzdx.zzb(bArr, iZzi2)));
                                                            iZzh = iZzi2 + 4;
                                                        }
                                                    }
                                                }
                                                i33 = i33;
                                                this = zzgoVar3;
                                                iZzh = i38;
                                                if (iZzh != i38) {
                                                    i31 = i31;
                                                    i39 = i30;
                                                    i3 = i3;
                                                    i78 = i40;
                                                    i2 = i31;
                                                    i77 = i39;
                                                    zzgoVar4 = this;
                                                    i76 = 0;
                                                    unsafe5 = unsafe3;
                                                    i79 = i9;
                                                    i81 = i10;
                                                    i80 = i33;
                                                    zzdwVar6 = zzdwVar5;
                                                } else {
                                                    i31 = i31;
                                                    i39 = i30;
                                                    i12 = i40;
                                                    i8 = iZzh;
                                                    zzdwVar2 = zzdwVar5;
                                                    i76 = i39;
                                                    zzgoVar = this;
                                                    unsafe5 = unsafe3;
                                                    i13 = i33;
                                                    i4 = i3;
                                                }
                                            } else {
                                                int i91 = zzdx.zza;
                                                zzfbVar2 = (zzfb) zzfnVar;
                                                iZzh = zzdx.zzi(bArr, i38, zzdwVar5);
                                                i43 = zzdwVar5.zza;
                                                i44 = iZzh + i43;
                                                if (i44 <= bArr.length) {
                                                    throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                zzfbVar2.zzg(zzfbVar2.size() + (i43 / 4));
                                                while (iZzh < i44) {
                                                    zzfbVar2.zzf(Float.intBitsToFloat(zzdx.zzb(bArr, iZzh)));
                                                    iZzh += 4;
                                                }
                                                if (iZzh != i44) {
                                                    throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            }
                                            i33 = i33;
                                            this = zzgoVar3;
                                            if (iZzh != i38) {
                                                i31 = i31;
                                                i39 = i30;
                                                i3 = i3;
                                                i78 = i40;
                                                i2 = i31;
                                                i77 = i39;
                                                zzgoVar4 = this;
                                                i76 = 0;
                                                unsafe5 = unsafe3;
                                                i79 = i9;
                                                i81 = i10;
                                                i80 = i33;
                                                zzdwVar6 = zzdwVar5;
                                            } else {
                                                i31 = i31;
                                                i39 = i30;
                                                i12 = i40;
                                                i8 = iZzh;
                                                zzdwVar2 = zzdwVar5;
                                                i76 = i39;
                                                zzgoVar = this;
                                                unsafe5 = unsafe3;
                                                i13 = i33;
                                                i4 = i3;
                                            }
                                            break;
                                        case 20:
                                        case 21:
                                        case MotionEventCompat.AXIS_GENERIC_6 /* 37 */:
                                        case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                                            i31 = i31;
                                            i38 = i38;
                                            i39 = i30;
                                            zzdwVar5 = zzdwVar3;
                                            zzgoVar3 = zzgoVar4;
                                            i40 = i29;
                                            unsafe3 = unsafe;
                                            if (i15 == 2) {
                                                if (i15 == 0) {
                                                    int i92 = zzdx.zza;
                                                    zzgaVar = (zzga) zzfnVar;
                                                    iZzh = zzdx.zzl(bArr, i38, zzdwVar5);
                                                    zzgaVar.zzf(zzdwVar5.zzb);
                                                    while (iZzh < i31) {
                                                        iZzi3 = zzdx.zzi(bArr, iZzh, zzdwVar5);
                                                        if (i40 == zzdwVar5.zza) {
                                                            iZzh = zzdx.zzl(bArr, iZzi3, zzdwVar5);
                                                            zzgaVar.zzf(zzdwVar5.zzb);
                                                        }
                                                    }
                                                }
                                                i33 = i33;
                                                this = zzgoVar3;
                                                iZzh = i38;
                                                if (iZzh != i38) {
                                                    i31 = i31;
                                                    i39 = i30;
                                                    i3 = i3;
                                                    i78 = i40;
                                                    i2 = i31;
                                                    i77 = i39;
                                                    zzgoVar4 = this;
                                                    i76 = 0;
                                                    unsafe5 = unsafe3;
                                                    i79 = i9;
                                                    i81 = i10;
                                                    i80 = i33;
                                                    zzdwVar6 = zzdwVar5;
                                                } else {
                                                    i31 = i31;
                                                    i39 = i30;
                                                    i12 = i40;
                                                    i8 = iZzh;
                                                    zzdwVar2 = zzdwVar5;
                                                    i76 = i39;
                                                    zzgoVar = this;
                                                    unsafe5 = unsafe3;
                                                    i13 = i33;
                                                    i4 = i3;
                                                }
                                            } else {
                                                int i93 = zzdx.zza;
                                                zzgaVar2 = (zzga) zzfnVar;
                                                iZzh = zzdx.zzi(bArr, i38, zzdwVar5);
                                                i45 = zzdwVar5.zza + iZzh;
                                                while (iZzh < i45) {
                                                    iZzh = zzdx.zzl(bArr, iZzh, zzdwVar5);
                                                    zzgaVar2.zzf(zzdwVar5.zzb);
                                                }
                                                if (iZzh != i45) {
                                                    throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            }
                                            i33 = i33;
                                            this = zzgoVar3;
                                            if (iZzh != i38) {
                                                i31 = i31;
                                                i39 = i30;
                                                i3 = i3;
                                                i78 = i40;
                                                i2 = i31;
                                                i77 = i39;
                                                zzgoVar4 = this;
                                                i76 = 0;
                                                unsafe5 = unsafe3;
                                                i79 = i9;
                                                i81 = i10;
                                                i80 = i33;
                                                zzdwVar6 = zzdwVar5;
                                            } else {
                                                i31 = i31;
                                                i39 = i30;
                                                i12 = i40;
                                                i8 = iZzh;
                                                zzdwVar2 = zzdwVar5;
                                                i76 = i39;
                                                zzgoVar = this;
                                                unsafe5 = unsafe3;
                                                i13 = i33;
                                                i4 = i3;
                                            }
                                            break;
                                        case 22:
                                        case 29:
                                        case MotionEventCompat.AXIS_GENERIC_8 /* 39 */:
                                        case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                                            i46 = i31;
                                            i47 = i38;
                                            i40 = i29;
                                            i39 = i30;
                                            unsafe3 = unsafe;
                                            if (i15 == 2) {
                                                iZzf = zzdx.zzf(bArr, i47, zzfnVar, zzdwVar3);
                                                zzdwVar5 = zzdwVar3;
                                                iZzh = iZzf;
                                                i31 = i46;
                                                i38 = i47;
                                                i33 = i33;
                                                this = this;
                                            } else if (i15 == 0) {
                                                zzdwVar5 = zzdwVar3;
                                                i31 = i46;
                                                i38 = i47;
                                                iZzh = zzdx.zzk(i40, bArr, i47, i2, zzfnVar, zzdwVar);
                                                i33 = i33;
                                                this = this;
                                            } else {
                                                zzdwVar5 = zzdwVar3;
                                                i31 = i46;
                                                i38 = i47;
                                                i33 = i33;
                                                this = this;
                                                iZzh = i38;
                                            }
                                            if (iZzh != i38) {
                                                i31 = i31;
                                                i39 = i30;
                                                i3 = i3;
                                                i78 = i40;
                                                i2 = i31;
                                                i77 = i39;
                                                zzgoVar4 = this;
                                                i76 = 0;
                                                unsafe5 = unsafe3;
                                                i79 = i9;
                                                i81 = i10;
                                                i80 = i33;
                                                zzdwVar6 = zzdwVar5;
                                            } else {
                                                i31 = i31;
                                                i39 = i30;
                                                i12 = i40;
                                                i8 = iZzh;
                                                zzdwVar2 = zzdwVar5;
                                                i76 = i39;
                                                zzgoVar = this;
                                                unsafe5 = unsafe3;
                                                i13 = i33;
                                                i4 = i3;
                                            }
                                            break;
                                        case 23:
                                        case 32:
                                        case MotionEventCompat.AXIS_GENERIC_9 /* 40 */:
                                        case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                                            i46 = i31;
                                            i47 = i38;
                                            i40 = i29;
                                            i39 = i30;
                                            unsafe3 = unsafe;
                                            if (i15 == 2) {
                                                if (i15 == 1) {
                                                    iZzf = i47 + 8;
                                                    int i94 = zzdx.zza;
                                                    zzgaVar3 = (zzga) zzfnVar;
                                                    zzgaVar3.zzf(zzdx.zzo(bArr, i47));
                                                    while (iZzf < i46) {
                                                        iZzi4 = zzdx.zzi(bArr, iZzf, zzdwVar3);
                                                        if (i40 == zzdwVar3.zza) {
                                                            zzgaVar3.zzf(zzdx.zzo(bArr, iZzi4));
                                                            iZzf = iZzi4 + 8;
                                                        }
                                                    }
                                                }
                                                zzdwVar5 = zzdwVar3;
                                                i31 = i46;
                                                i38 = i47;
                                                i33 = i33;
                                                this = this;
                                                iZzh = i38;
                                                if (iZzh != i38) {
                                                    i31 = i31;
                                                    i39 = i30;
                                                    i3 = i3;
                                                    i78 = i40;
                                                    i2 = i31;
                                                    i77 = i39;
                                                    zzgoVar4 = this;
                                                    i76 = 0;
                                                    unsafe5 = unsafe3;
                                                    i79 = i9;
                                                    i81 = i10;
                                                    i80 = i33;
                                                    zzdwVar6 = zzdwVar5;
                                                } else {
                                                    i31 = i31;
                                                    i39 = i30;
                                                    i12 = i40;
                                                    i8 = iZzh;
                                                    zzdwVar2 = zzdwVar5;
                                                    i76 = i39;
                                                    zzgoVar = this;
                                                    unsafe5 = unsafe3;
                                                    i13 = i33;
                                                    i4 = i3;
                                                }
                                            } else {
                                                int i95 = zzdx.zza;
                                                zzgaVar4 = (zzga) zzfnVar;
                                                iZzf = zzdx.zzi(bArr, i47, zzdwVar3);
                                                i48 = zzdwVar3.zza;
                                                i49 = iZzf + i48;
                                                if (i49 <= bArr.length) {
                                                    throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                zzgaVar4.zzg(zzgaVar4.size() + (i48 / 8));
                                                while (iZzf < i49) {
                                                    zzgaVar4.zzf(zzdx.zzo(bArr, iZzf));
                                                    iZzf += 8;
                                                }
                                                if (iZzf != i49) {
                                                    throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            }
                                            zzdwVar5 = zzdwVar3;
                                            iZzh = iZzf;
                                            i31 = i46;
                                            i38 = i47;
                                            i33 = i33;
                                            this = this;
                                            if (iZzh != i38) {
                                                i31 = i31;
                                                i39 = i30;
                                                i3 = i3;
                                                i78 = i40;
                                                i2 = i31;
                                                i77 = i39;
                                                zzgoVar4 = this;
                                                i76 = 0;
                                                unsafe5 = unsafe3;
                                                i79 = i9;
                                                i81 = i10;
                                                i80 = i33;
                                                zzdwVar6 = zzdwVar5;
                                            } else {
                                                i31 = i31;
                                                i39 = i30;
                                                i12 = i40;
                                                i8 = iZzh;
                                                zzdwVar2 = zzdwVar5;
                                                i76 = i39;
                                                zzgoVar = this;
                                                unsafe5 = unsafe3;
                                                i13 = i33;
                                                i4 = i3;
                                            }
                                            break;
                                        case 24:
                                        case 31:
                                        case MotionEventCompat.AXIS_GENERIC_10 /* 41 */:
                                        case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                                            i46 = i31;
                                            i47 = i38;
                                            i40 = i29;
                                            i39 = i30;
                                            unsafe3 = unsafe;
                                            if (i15 == 2) {
                                                if (i15 == 5) {
                                                    iZzf = i47 + 4;
                                                    int i96 = zzdx.zza;
                                                    zzfjVar = (zzfj) zzfnVar;
                                                    zzfjVar.zzg(zzdx.zzb(bArr, i47));
                                                    while (iZzf < i46) {
                                                        iZzi5 = zzdx.zzi(bArr, iZzf, zzdwVar3);
                                                        if (i40 == zzdwVar3.zza) {
                                                            zzfjVar.zzg(zzdx.zzb(bArr, iZzi5));
                                                            iZzf = iZzi5 + 4;
                                                        }
                                                    }
                                                }
                                                zzdwVar5 = zzdwVar3;
                                                i31 = i46;
                                                i38 = i47;
                                                i33 = i33;
                                                this = this;
                                                iZzh = i38;
                                                if (iZzh != i38) {
                                                    i31 = i31;
                                                    i39 = i30;
                                                    i3 = i3;
                                                    i78 = i40;
                                                    i2 = i31;
                                                    i77 = i39;
                                                    zzgoVar4 = this;
                                                    i76 = 0;
                                                    unsafe5 = unsafe3;
                                                    i79 = i9;
                                                    i81 = i10;
                                                    i80 = i33;
                                                    zzdwVar6 = zzdwVar5;
                                                } else {
                                                    i31 = i31;
                                                    i39 = i30;
                                                    i12 = i40;
                                                    i8 = iZzh;
                                                    zzdwVar2 = zzdwVar5;
                                                    i76 = i39;
                                                    zzgoVar = this;
                                                    unsafe5 = unsafe3;
                                                    i13 = i33;
                                                    i4 = i3;
                                                }
                                            } else {
                                                int i97 = zzdx.zza;
                                                zzfjVar2 = (zzfj) zzfnVar;
                                                iZzf = zzdx.zzi(bArr, i47, zzdwVar3);
                                                i50 = zzdwVar3.zza;
                                                i51 = iZzf + i50;
                                                if (i51 <= bArr.length) {
                                                    throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                zzfjVar2.zzh(zzfjVar2.size() + (i50 / 4));
                                                while (iZzf < i51) {
                                                    zzfjVar2.zzg(zzdx.zzb(bArr, iZzf));
                                                    iZzf += 4;
                                                }
                                                if (iZzf != i51) {
                                                    throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            }
                                            zzdwVar5 = zzdwVar3;
                                            iZzh = iZzf;
                                            i31 = i46;
                                            i38 = i47;
                                            i33 = i33;
                                            this = this;
                                            if (iZzh != i38) {
                                                i31 = i31;
                                                i39 = i30;
                                                i3 = i3;
                                                i78 = i40;
                                                i2 = i31;
                                                i77 = i39;
                                                zzgoVar4 = this;
                                                i76 = 0;
                                                unsafe5 = unsafe3;
                                                i79 = i9;
                                                i81 = i10;
                                                i80 = i33;
                                                zzdwVar6 = zzdwVar5;
                                            } else {
                                                i31 = i31;
                                                i39 = i30;
                                                i12 = i40;
                                                i8 = iZzh;
                                                zzdwVar2 = zzdwVar5;
                                                i76 = i39;
                                                zzgoVar = this;
                                                unsafe5 = unsafe3;
                                                i13 = i33;
                                                i4 = i3;
                                            }
                                            break;
                                        case 25:
                                        case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                                            i46 = i31;
                                            i47 = i38;
                                            i40 = i29;
                                            i39 = i30;
                                            unsafe3 = unsafe;
                                            if (i15 == 2) {
                                                if (i15 == 0) {
                                                    int i98 = zzdx.zza;
                                                    zzdyVar = (zzdy) zzfnVar;
                                                    iZzf = zzdx.zzl(bArr, i47, zzdwVar3);
                                                    if (zzdwVar3.zzb != 0) {
                                                        z2 = true;
                                                    } else {
                                                        z2 = false;
                                                    }
                                                    zzdyVar.zze(z2);
                                                    while (iZzf < i46) {
                                                        iZzi6 = zzdx.zzi(bArr, iZzf, zzdwVar3);
                                                        if (i40 == zzdwVar3.zza) {
                                                            iZzf = zzdx.zzl(bArr, iZzi6, zzdwVar3);
                                                            if (zzdwVar3.zzb != 0) {
                                                                z3 = true;
                                                            } else {
                                                                z3 = false;
                                                            }
                                                            zzdyVar.zze(z3);
                                                        }
                                                    }
                                                }
                                                zzdwVar5 = zzdwVar3;
                                                i31 = i46;
                                                i38 = i47;
                                                i33 = i33;
                                                this = this;
                                                iZzh = i38;
                                                if (iZzh != i38) {
                                                    i31 = i31;
                                                    i39 = i30;
                                                    i3 = i3;
                                                    i78 = i40;
                                                    i2 = i31;
                                                    i77 = i39;
                                                    zzgoVar4 = this;
                                                    i76 = 0;
                                                    unsafe5 = unsafe3;
                                                    i79 = i9;
                                                    i81 = i10;
                                                    i80 = i33;
                                                    zzdwVar6 = zzdwVar5;
                                                } else {
                                                    i31 = i31;
                                                    i39 = i30;
                                                    i12 = i40;
                                                    i8 = iZzh;
                                                    zzdwVar2 = zzdwVar5;
                                                    i76 = i39;
                                                    zzgoVar = this;
                                                    unsafe5 = unsafe3;
                                                    i13 = i33;
                                                    i4 = i3;
                                                }
                                            } else {
                                                int i99 = zzdx.zza;
                                                zzdyVar2 = (zzdy) zzfnVar;
                                                iZzf = zzdx.zzi(bArr, i47, zzdwVar3);
                                                i52 = zzdwVar3.zza + iZzf;
                                                while (iZzf < i52) {
                                                    iZzf = zzdx.zzl(bArr, iZzf, zzdwVar3);
                                                    if (zzdwVar3.zzb != 0) {
                                                        z4 = true;
                                                    } else {
                                                        z4 = false;
                                                    }
                                                    zzdyVar2.zze(z4);
                                                }
                                                if (iZzf != i52) {
                                                    throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            }
                                            zzdwVar5 = zzdwVar3;
                                            iZzh = iZzf;
                                            i31 = i46;
                                            i38 = i47;
                                            i33 = i33;
                                            this = this;
                                            if (iZzh != i38) {
                                                i31 = i31;
                                                i39 = i30;
                                                i3 = i3;
                                                i78 = i40;
                                                i2 = i31;
                                                i77 = i39;
                                                zzgoVar4 = this;
                                                i76 = 0;
                                                unsafe5 = unsafe3;
                                                i79 = i9;
                                                i81 = i10;
                                                i80 = i33;
                                                zzdwVar6 = zzdwVar5;
                                            } else {
                                                i31 = i31;
                                                i39 = i30;
                                                i12 = i40;
                                                i8 = iZzh;
                                                zzdwVar2 = zzdwVar5;
                                                i76 = i39;
                                                zzgoVar = this;
                                                unsafe5 = unsafe3;
                                                i13 = i33;
                                                i4 = i3;
                                            }
                                            break;
                                        case 26:
                                            i46 = i31;
                                            i47 = i38;
                                            i39 = i30;
                                            zzgoVar3 = zzgoVar4;
                                            i40 = i29;
                                            unsafe3 = unsafe;
                                            if (i15 == 2) {
                                                if ((j2 & 536870912) == 0) {
                                                    iZzf = zzdx.zzi(bArr, i47, zzdwVar3);
                                                    i53 = zzdwVar3.zza;
                                                    if (i53 >= 0) {
                                                        throw new zzfq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                    }
                                                    if (i53 == 0) {
                                                        zzfnVar.add("");
                                                    } else {
                                                        i54 = iZzf + i53;
                                                        if (zzhr.zzd(bArr, iZzf, i54)) {
                                                            throw new zzfq("Protocol message had invalid UTF-8.");
                                                        }
                                                        zzfnVar.add(new String(bArr, iZzf, i53, zzfo.zza));
                                                        iZzf = i54;
                                                    }
                                                    while (iZzf < i46) {
                                                        iZzi7 = zzdx.zzi(bArr, iZzf, zzdwVar3);
                                                        if (i40 == zzdwVar3.zza) {
                                                            zzdwVar5 = zzdwVar3;
                                                            iZzh = iZzf;
                                                            i31 = i46;
                                                            i38 = i47;
                                                            i33 = i33;
                                                            this = this;
                                                            if (iZzh != i38) {
                                                                i31 = i31;
                                                                i39 = i30;
                                                                i3 = i3;
                                                                i78 = i40;
                                                                i2 = i31;
                                                                i77 = i39;
                                                                zzgoVar4 = this;
                                                                i76 = 0;
                                                                unsafe5 = unsafe3;
                                                                i79 = i9;
                                                                i81 = i10;
                                                                i80 = i33;
                                                                zzdwVar6 = zzdwVar5;
                                                            } else {
                                                                i31 = i31;
                                                                i39 = i30;
                                                                i12 = i40;
                                                                i8 = iZzh;
                                                                zzdwVar2 = zzdwVar5;
                                                                i76 = i39;
                                                                zzgoVar = this;
                                                                unsafe5 = unsafe3;
                                                                i13 = i33;
                                                                i4 = i3;
                                                            }
                                                            break;
                                                        } else {
                                                            iZzf = zzdx.zzi(bArr, iZzi7, zzdwVar3);
                                                            i55 = zzdwVar3.zza;
                                                            if (i55 >= 0) {
                                                                throw new zzfq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                            }
                                                            if (i55 == 0) {
                                                                zzfnVar.add("");
                                                            } else {
                                                                i56 = iZzf + i55;
                                                                if (zzhr.zzd(bArr, iZzf, i56)) {
                                                                    throw new zzfq("Protocol message had invalid UTF-8.");
                                                                }
                                                                zzfnVar.add(new String(bArr, iZzf, i55, zzfo.zza));
                                                                iZzf = i56;
                                                            }
                                                        }
                                                    }
                                                    zzdwVar5 = zzdwVar3;
                                                    iZzh = iZzf;
                                                    i31 = i46;
                                                    i38 = i47;
                                                    i33 = i33;
                                                    this = this;
                                                    if (iZzh != i38) {
                                                        i31 = i31;
                                                        i39 = i30;
                                                        i3 = i3;
                                                        i78 = i40;
                                                        i2 = i31;
                                                        i77 = i39;
                                                        zzgoVar4 = this;
                                                        i76 = 0;
                                                        unsafe5 = unsafe3;
                                                        i79 = i9;
                                                        i81 = i10;
                                                        i80 = i33;
                                                        zzdwVar6 = zzdwVar5;
                                                    } else {
                                                        i31 = i31;
                                                        i39 = i30;
                                                        i12 = i40;
                                                        i8 = iZzh;
                                                        zzdwVar2 = zzdwVar5;
                                                        i76 = i39;
                                                        zzgoVar = this;
                                                        unsafe5 = unsafe3;
                                                        i13 = i33;
                                                        i4 = i3;
                                                    }
                                                } else {
                                                    iZzi8 = zzdx.zzi(bArr, i47, zzdwVar3);
                                                    i57 = zzdwVar3.zza;
                                                    if (i57 >= 0) {
                                                        throw new zzfq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                    }
                                                    if (i57 == 0) {
                                                        obj2 = "";
                                                        zzfnVar.add(obj2);
                                                    } else {
                                                        obj2 = "";
                                                        zzfnVar.add(new String(bArr, iZzi8, i57, zzfo.zza));
                                                        iZzi8 += i57;
                                                    }
                                                    while (iZzi8 < i46) {
                                                        iZzi9 = zzdx.zzi(bArr, iZzi8, zzdwVar3);
                                                        if (i40 == zzdwVar3.zza) {
                                                            zzdwVar5 = zzdwVar3;
                                                            iZzh = iZzi8;
                                                            i31 = i46;
                                                            i38 = i47;
                                                            i33 = i33;
                                                            this = zzgoVar3;
                                                            if (iZzh != i38) {
                                                                i31 = i31;
                                                                i39 = i30;
                                                                i3 = i3;
                                                                i78 = i40;
                                                                i2 = i31;
                                                                i77 = i39;
                                                                zzgoVar4 = this;
                                                                i76 = 0;
                                                                unsafe5 = unsafe3;
                                                                i79 = i9;
                                                                i81 = i10;
                                                                i80 = i33;
                                                                zzdwVar6 = zzdwVar5;
                                                            } else {
                                                                i31 = i31;
                                                                i39 = i30;
                                                                i12 = i40;
                                                                i8 = iZzh;
                                                                zzdwVar2 = zzdwVar5;
                                                                i76 = i39;
                                                                zzgoVar = this;
                                                                unsafe5 = unsafe3;
                                                                i13 = i33;
                                                                i4 = i3;
                                                            }
                                                            break;
                                                        } else {
                                                            iZzi8 = zzdx.zzi(bArr, iZzi9, zzdwVar3);
                                                            i58 = zzdwVar3.zza;
                                                            if (i58 >= 0) {
                                                                throw new zzfq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                            }
                                                            if (i58 == 0) {
                                                                zzfnVar.add(obj2);
                                                            } else {
                                                                zzfnVar.add(new String(bArr, iZzi8, i58, zzfo.zza));
                                                                iZzi8 += i58;
                                                            }
                                                        }
                                                    }
                                                    zzdwVar5 = zzdwVar3;
                                                    iZzh = iZzi8;
                                                    i31 = i46;
                                                    i38 = i47;
                                                    i33 = i33;
                                                    this = zzgoVar3;
                                                    if (iZzh != i38) {
                                                        i31 = i31;
                                                        i39 = i30;
                                                        i3 = i3;
                                                        i78 = i40;
                                                        i2 = i31;
                                                        i77 = i39;
                                                        zzgoVar4 = this;
                                                        i76 = 0;
                                                        unsafe5 = unsafe3;
                                                        i79 = i9;
                                                        i81 = i10;
                                                        i80 = i33;
                                                        zzdwVar6 = zzdwVar5;
                                                    } else {
                                                        i31 = i31;
                                                        i39 = i30;
                                                        i12 = i40;
                                                        i8 = iZzh;
                                                        zzdwVar2 = zzdwVar5;
                                                        i76 = i39;
                                                        zzgoVar = this;
                                                        unsafe5 = unsafe3;
                                                        i13 = i33;
                                                        i4 = i3;
                                                    }
                                                }
                                            }
                                            zzdwVar5 = zzdwVar3;
                                            i31 = i46;
                                            i38 = i47;
                                            i33 = i33;
                                            this = this;
                                            iZzh = i38;
                                            if (iZzh != i38) {
                                                i31 = i31;
                                                i39 = i30;
                                                i3 = i3;
                                                i78 = i40;
                                                i2 = i31;
                                                i77 = i39;
                                                zzgoVar4 = this;
                                                i76 = 0;
                                                unsafe5 = unsafe3;
                                                i79 = i9;
                                                i81 = i10;
                                                i80 = i33;
                                                zzdwVar6 = zzdwVar5;
                                            } else {
                                                i31 = i31;
                                                i39 = i30;
                                                i12 = i40;
                                                i8 = iZzh;
                                                zzdwVar2 = zzdwVar5;
                                                i76 = i39;
                                                zzgoVar = this;
                                                unsafe5 = unsafe3;
                                                i13 = i33;
                                                i4 = i3;
                                            }
                                            break;
                                        case MotionEventCompat.AXIS_RELATIVE_X /* 27 */:
                                            i31 = i31;
                                            i59 = i30;
                                            if (i15 == 2) {
                                                unsafe3 = unsafe;
                                                i40 = i29;
                                                int iZze = zzdx.zze(zzv(i59), i29, bArr, i38, i2, zzfnVar, zzdwVar);
                                                zzdwVar5 = zzdwVar3;
                                                i39 = i59;
                                                i33 = i33;
                                                i38 = i38;
                                                this = this;
                                                iZzh = iZze;
                                            } else {
                                                unsafe3 = unsafe;
                                                i40 = i29;
                                                zzdwVar5 = zzdwVar3;
                                                i39 = i59;
                                                iZzh = i38;
                                            }
                                            if (iZzh != i38) {
                                                i31 = i31;
                                                i39 = i30;
                                                i3 = i3;
                                                i78 = i40;
                                                i2 = i31;
                                                i77 = i39;
                                                zzgoVar4 = this;
                                                i76 = 0;
                                                unsafe5 = unsafe3;
                                                i79 = i9;
                                                i81 = i10;
                                                i80 = i33;
                                                zzdwVar6 = zzdwVar5;
                                            } else {
                                                i31 = i31;
                                                i39 = i30;
                                                i12 = i40;
                                                i8 = iZzh;
                                                zzdwVar2 = zzdwVar5;
                                                i76 = i39;
                                                zzgoVar = this;
                                                unsafe5 = unsafe3;
                                                i13 = i33;
                                                i4 = i3;
                                            }
                                            break;
                                        case MotionEventCompat.AXIS_RELATIVE_Y /* 28 */:
                                            i31 = i31;
                                            i59 = i30;
                                            if (i15 == 2) {
                                                iZzi10 = zzdx.zzi(bArr, i38, zzdwVar3);
                                                i60 = zzdwVar3.zza;
                                                if (i60 >= 0) {
                                                    throw new zzfq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                                if (i60 <= bArr.length - iZzi10) {
                                                    throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                if (i60 == 0) {
                                                    zzfnVar.add(zzei.zzb);
                                                } else {
                                                    zzfnVar.add(zzei.zzj(bArr, iZzi10, i60));
                                                    iZzi10 += i60;
                                                }
                                                while (iZzi10 < i31) {
                                                    iZzi11 = zzdx.zzi(bArr, iZzi10, zzdwVar3);
                                                    if (i29 == zzdwVar3.zza) {
                                                        unsafe3 = unsafe;
                                                        i40 = i29;
                                                        this = this;
                                                        zzdwVar5 = zzdwVar3;
                                                        i39 = i59;
                                                        iZzh = iZzi10;
                                                        if (iZzh != i38) {
                                                            i31 = i31;
                                                            i39 = i30;
                                                            i3 = i3;
                                                            i78 = i40;
                                                            i2 = i31;
                                                            i77 = i39;
                                                            zzgoVar4 = this;
                                                            i76 = 0;
                                                            unsafe5 = unsafe3;
                                                            i79 = i9;
                                                            i81 = i10;
                                                            i80 = i33;
                                                            zzdwVar6 = zzdwVar5;
                                                        } else {
                                                            i31 = i31;
                                                            i39 = i30;
                                                            i12 = i40;
                                                            i8 = iZzh;
                                                            zzdwVar2 = zzdwVar5;
                                                            i76 = i39;
                                                            zzgoVar = this;
                                                            unsafe5 = unsafe3;
                                                            i13 = i33;
                                                            i4 = i3;
                                                        }
                                                        break;
                                                    } else {
                                                        iZzi10 = zzdx.zzi(bArr, iZzi11, zzdwVar3);
                                                        i61 = zzdwVar3.zza;
                                                        if (i61 >= 0) {
                                                            throw new zzfq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                        }
                                                        if (i61 <= bArr.length - iZzi10) {
                                                            throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                        }
                                                        if (i61 == 0) {
                                                            zzfnVar.add(zzei.zzb);
                                                        } else {
                                                            zzfnVar.add(zzei.zzj(bArr, iZzi10, i61));
                                                            iZzi10 += i61;
                                                        }
                                                    }
                                                }
                                                unsafe3 = unsafe;
                                                i40 = i29;
                                                this = this;
                                                zzdwVar5 = zzdwVar3;
                                                i39 = i59;
                                                iZzh = iZzi10;
                                                if (iZzh != i38) {
                                                    i31 = i31;
                                                    i39 = i30;
                                                    i3 = i3;
                                                    i78 = i40;
                                                    i2 = i31;
                                                    i77 = i39;
                                                    zzgoVar4 = this;
                                                    i76 = 0;
                                                    unsafe5 = unsafe3;
                                                    i79 = i9;
                                                    i81 = i10;
                                                    i80 = i33;
                                                    zzdwVar6 = zzdwVar5;
                                                } else {
                                                    i31 = i31;
                                                    i39 = i30;
                                                    i12 = i40;
                                                    i8 = iZzh;
                                                    zzdwVar2 = zzdwVar5;
                                                    i76 = i39;
                                                    zzgoVar = this;
                                                    unsafe5 = unsafe3;
                                                    i13 = i33;
                                                    i4 = i3;
                                                }
                                            } else {
                                                unsafe3 = unsafe;
                                                i40 = i29;
                                                zzdwVar5 = zzdwVar3;
                                                i39 = i59;
                                                iZzh = i38;
                                                if (iZzh != i38) {
                                                    i31 = i31;
                                                    i39 = i30;
                                                    i3 = i3;
                                                    i78 = i40;
                                                    i2 = i31;
                                                    i77 = i39;
                                                    zzgoVar4 = this;
                                                    i76 = 0;
                                                    unsafe5 = unsafe3;
                                                    i79 = i9;
                                                    i81 = i10;
                                                    i80 = i33;
                                                    zzdwVar6 = zzdwVar5;
                                                } else {
                                                    i31 = i31;
                                                    i39 = i30;
                                                    i12 = i40;
                                                    i8 = iZzh;
                                                    zzdwVar2 = zzdwVar5;
                                                    i76 = i39;
                                                    zzgoVar = this;
                                                    unsafe5 = unsafe3;
                                                    i13 = i33;
                                                    i4 = i3;
                                                }
                                            }
                                            break;
                                        case 30:
                                        case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                                            if (i15 == 2) {
                                                iZzk = zzdx.zzf(bArr, i38, zzfnVar, zzdwVar3);
                                            } else if (i15 == 0) {
                                                i31 = i31;
                                                unsafe3 = unsafe;
                                                i33 = i33;
                                                i40 = i29;
                                                this = this;
                                                i38 = i38;
                                                zzdwVar5 = zzdwVar3;
                                                i39 = i30;
                                                iZzh = i38;
                                                if (iZzh != i38) {
                                                    i31 = i31;
                                                    i39 = i30;
                                                    i3 = i3;
                                                    i78 = i40;
                                                    i2 = i31;
                                                    i77 = i39;
                                                    zzgoVar4 = this;
                                                    i76 = 0;
                                                    unsafe5 = unsafe3;
                                                    i79 = i9;
                                                    i81 = i10;
                                                    i80 = i33;
                                                    zzdwVar6 = zzdwVar5;
                                                } else {
                                                    i31 = i31;
                                                    i39 = i30;
                                                    i12 = i40;
                                                    i8 = iZzh;
                                                    zzdwVar2 = zzdwVar5;
                                                    i76 = i39;
                                                    zzgoVar = this;
                                                    unsafe5 = unsafe3;
                                                    i13 = i33;
                                                    i4 = i3;
                                                }
                                            } else {
                                                iZzk = zzdx.zzk(i29, bArr, i38, i2, zzfnVar, zzdwVar);
                                            }
                                            zzflVarZzu = zzgoVar4.zzu(i30);
                                            zzhhVar = zzgoVar4.zzl;
                                            int i100 = zzgx.zza;
                                            if (zzflVarZzu != null) {
                                                i62 = iZzk;
                                                unsafe3 = unsafe;
                                            } else if (zzfnVar instanceof RandomAccess) {
                                                size2 = zzfnVar.size();
                                                i62 = iZzk;
                                                unsafe3 = unsafe;
                                                objZzn2 = null;
                                                i63 = 0;
                                                for (i64 = 0; i64 < size2; i64++) {
                                                    iIntValue2 = ((Integer) zzfnVar.get(i64)).intValue();
                                                    if (zzflVarZzu.zza(iIntValue2)) {
                                                        if (i64 != i63) {
                                                            zzfnVar.set(i63, Integer.valueOf(iIntValue2));
                                                        }
                                                        i63++;
                                                    } else {
                                                        objZzn2 = zzgx.zzn(obj3, i33, iIntValue2, objZzn2, zzhhVar);
                                                    }
                                                }
                                                if (i63 != size2) {
                                                    zzfnVar.subList(i63, size2).clear();
                                                }
                                            } else {
                                                i62 = iZzk;
                                                unsafe3 = unsafe;
                                                it = zzfnVar.iterator();
                                                objZzn = null;
                                                while (it.hasNext()) {
                                                    iIntValue = ((Integer) it.next()).intValue();
                                                    if (!zzflVarZzu.zza(iIntValue)) {
                                                        objZzn = zzgx.zzn(obj3, i33, iIntValue, objZzn, zzhhVar);
                                                        it.remove();
                                                    }
                                                }
                                            }
                                            i33 = i33;
                                            i40 = i29;
                                            this = this;
                                            i38 = i38;
                                            zzdwVar5 = zzdwVar3;
                                            i39 = i30;
                                            iZzh = i62;
                                            if (iZzh != i38) {
                                                i31 = i31;
                                                i39 = i30;
                                                i3 = i3;
                                                i78 = i40;
                                                i2 = i31;
                                                i77 = i39;
                                                zzgoVar4 = this;
                                                i76 = 0;
                                                unsafe5 = unsafe3;
                                                i79 = i9;
                                                i81 = i10;
                                                i80 = i33;
                                                zzdwVar6 = zzdwVar5;
                                            } else {
                                                i31 = i31;
                                                i39 = i30;
                                                i12 = i40;
                                                i8 = iZzh;
                                                zzdwVar2 = zzdwVar5;
                                                i76 = i39;
                                                zzgoVar = this;
                                                unsafe5 = unsafe3;
                                                i13 = i33;
                                                i4 = i3;
                                            }
                                            break;
                                        case 33:
                                        case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                                            i65 = i29;
                                            if (i15 == 2) {
                                                int i101 = zzdx.zza;
                                                zzfjVar4 = (zzfj) zzfnVar;
                                                iZzi10 = zzdx.zzi(bArr, i38, zzdwVar3);
                                                i66 = zzdwVar3.zza + iZzi10;
                                                while (iZzi10 < i66) {
                                                    iZzi10 = zzdx.zzi(bArr, iZzi10, zzdwVar3);
                                                    zzfjVar4.zzg(zzel.zzb(zzdwVar3.zza));
                                                }
                                                if (iZzi10 != i66) {
                                                    throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                            } else if (i15 == 0) {
                                                i31 = i31;
                                                unsafe3 = unsafe;
                                                i33 = i33;
                                                i39 = i30;
                                                this = zzgoVar4;
                                                i40 = i65;
                                                i38 = i38;
                                                zzdwVar5 = zzdwVar3;
                                                iZzh = i38;
                                                if (iZzh != i38) {
                                                    i31 = i31;
                                                    i39 = i30;
                                                    i3 = i3;
                                                    i78 = i40;
                                                    i2 = i31;
                                                    i77 = i39;
                                                    zzgoVar4 = this;
                                                    i76 = 0;
                                                    unsafe5 = unsafe3;
                                                    i79 = i9;
                                                    i81 = i10;
                                                    i80 = i33;
                                                    zzdwVar6 = zzdwVar5;
                                                } else {
                                                    i31 = i31;
                                                    i39 = i30;
                                                    i12 = i40;
                                                    i8 = iZzh;
                                                    zzdwVar2 = zzdwVar5;
                                                    i76 = i39;
                                                    zzgoVar = this;
                                                    unsafe5 = unsafe3;
                                                    i13 = i33;
                                                    i4 = i3;
                                                }
                                                break;
                                            } else {
                                                int i102 = zzdx.zza;
                                                zzfjVar3 = (zzfj) zzfnVar;
                                                iZzi10 = zzdx.zzi(bArr, i38, zzdwVar3);
                                                zzfjVar3.zzg(zzel.zzb(zzdwVar3.zza));
                                                while (iZzi10 < i31) {
                                                    iZzi12 = zzdx.zzi(bArr, iZzi10, zzdwVar3);
                                                    if (i65 == zzdwVar3.zza) {
                                                        iZzi10 = zzdx.zzi(bArr, iZzi12, zzdwVar3);
                                                        zzfjVar3.zzg(zzel.zzb(zzdwVar3.zza));
                                                    }
                                                }
                                            }
                                            i31 = i31;
                                            unsafe3 = unsafe;
                                            i39 = i30;
                                            this = zzgoVar4;
                                            i40 = i65;
                                            zzdwVar5 = zzdwVar3;
                                            iZzh = iZzi10;
                                            if (iZzh != i38) {
                                                i31 = i31;
                                                i39 = i30;
                                                i3 = i3;
                                                i78 = i40;
                                                i2 = i31;
                                                i77 = i39;
                                                zzgoVar4 = this;
                                                i76 = 0;
                                                unsafe5 = unsafe3;
                                                i79 = i9;
                                                i81 = i10;
                                                i80 = i33;
                                                zzdwVar6 = zzdwVar5;
                                            } else {
                                                i31 = i31;
                                                i39 = i30;
                                                i12 = i40;
                                                i8 = iZzh;
                                                zzdwVar2 = zzdwVar5;
                                                i76 = i39;
                                                zzgoVar = this;
                                                unsafe5 = unsafe3;
                                                i13 = i33;
                                                i4 = i3;
                                            }
                                            break;
                                        case MotionEventCompat.AXIS_GENERIC_3 /* 34 */:
                                        case 48:
                                            if (i15 == 2) {
                                                int i103 = zzdx.zza;
                                                zzgaVar6 = (zzga) zzfnVar;
                                                iZzi14 = zzdx.zzi(bArr, i38, zzdwVar3);
                                                i67 = zzdwVar3.zza + iZzi14;
                                                while (iZzi14 < i67) {
                                                    iZzi14 = zzdx.zzl(bArr, iZzi14, zzdwVar3);
                                                    zzgaVar6.zzf(zzel.zzc(zzdwVar3.zzb));
                                                }
                                                if (iZzi14 == i67) {
                                                    throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                i31 = i31;
                                                i38 = i38;
                                                i33 = i33;
                                                this = zzgoVar4;
                                                zzdwVar5 = zzdwVar3;
                                                iZzh = iZzi14;
                                                i40 = i29;
                                                unsafe3 = unsafe;
                                            } else if (i15 == 0) {
                                                int i104 = zzdx.zza;
                                                zzgaVar5 = (zzga) zzfnVar;
                                                iZzi10 = zzdx.zzl(bArr, i38, zzdwVar3);
                                                zzgaVar5.zzf(zzel.zzc(zzdwVar3.zzb));
                                                while (true) {
                                                    if (iZzi10 < i31) {
                                                        iZzi13 = zzdx.zzi(bArr, iZzi10, zzdwVar3);
                                                        i65 = i29;
                                                        if (i65 == zzdwVar3.zza) {
                                                            iZzi10 = zzdx.zzl(bArr, iZzi13, zzdwVar3);
                                                            zzgaVar5.zzf(zzel.zzc(zzdwVar3.zzb));
                                                            i29 = i65;
                                                        }
                                                    } else {
                                                        i65 = i29;
                                                    }
                                                }
                                                i31 = i31;
                                                unsafe3 = unsafe;
                                                i39 = i30;
                                                this = zzgoVar4;
                                                i40 = i65;
                                                zzdwVar5 = zzdwVar3;
                                                iZzh = iZzi10;
                                            } else {
                                                i31 = i31;
                                                i38 = i38;
                                                i33 = i33;
                                                i39 = i30;
                                                this = zzgoVar4;
                                                zzdwVar5 = zzdwVar3;
                                                i40 = i29;
                                                unsafe3 = unsafe;
                                                iZzh = i38;
                                            }
                                            if (iZzh != i38) {
                                                i31 = i31;
                                                i39 = i30;
                                                i3 = i3;
                                                i78 = i40;
                                                i2 = i31;
                                                i77 = i39;
                                                zzgoVar4 = this;
                                                i76 = 0;
                                                unsafe5 = unsafe3;
                                                i79 = i9;
                                                i81 = i10;
                                                i80 = i33;
                                                zzdwVar6 = zzdwVar5;
                                            } else {
                                                i31 = i31;
                                                i39 = i30;
                                                i12 = i40;
                                                i8 = iZzh;
                                                zzdwVar2 = zzdwVar5;
                                                i76 = i39;
                                                zzgoVar = this;
                                                unsafe5 = unsafe3;
                                                i13 = i33;
                                                i4 = i3;
                                            }
                                            break;
                                        default:
                                            i31 = i31;
                                            i38 = i38;
                                            i39 = i30;
                                            zzdwVar5 = zzdwVar3;
                                            zzgoVar3 = zzgoVar4;
                                            i40 = i29;
                                            unsafe3 = unsafe;
                                            if (i15 == 3) {
                                                i68 = (i40 & (-8)) | 4;
                                                zzgvVarZzv = zzgoVar3.zzv(i39);
                                                i33 = i33;
                                                this = zzgoVar3;
                                                iZzh = zzdx.zzc(zzgvVarZzv, bArr, i38, i2, i68, zzdwVar);
                                                zzfnVar.add(zzdwVar5.zzc);
                                                while (iZzh < i31) {
                                                    iZzi15 = zzdx.zzi(bArr, iZzh, zzdwVar5);
                                                    if (i40 == zzdwVar5.zza) {
                                                        iZzh = zzdx.zzc(zzgvVarZzv, bArr, iZzi15, i2, i68, zzdwVar);
                                                        zzfnVar.add(zzdwVar5.zzc);
                                                    }
                                                }
                                            } else {
                                                i33 = i33;
                                                this = zzgoVar3;
                                                iZzh = i38;
                                            }
                                            if (iZzh != i38) {
                                                i31 = i31;
                                                i39 = i30;
                                                i3 = i3;
                                                i78 = i40;
                                                i2 = i31;
                                                i77 = i39;
                                                zzgoVar4 = this;
                                                i76 = 0;
                                                unsafe5 = unsafe3;
                                                i79 = i9;
                                                i81 = i10;
                                                i80 = i33;
                                                zzdwVar6 = zzdwVar5;
                                            } else {
                                                i31 = i31;
                                                i39 = i30;
                                                i12 = i40;
                                                i8 = iZzh;
                                                zzdwVar2 = zzdwVar5;
                                                i76 = i39;
                                                zzgoVar = this;
                                                unsafe5 = unsafe3;
                                                i13 = i33;
                                                i4 = i3;
                                            }
                                            break;
                                    }
                                } else {
                                    zzgoVar2 = zzgoVar4;
                                    i35 = i29;
                                    zzdwVar4 = zzdwVar3;
                                    i36 = i38;
                                    i34 = i33;
                                    if (iZzr == 50) {
                                        j3 = iArr[i30 + 2] & 1048575;
                                        switch (iZzr) {
                                            case 51:
                                                i69 = i35;
                                                i70 = i30;
                                                zzgoVar = zzgoVar2;
                                                unsafe5 = unsafe;
                                                i13 = i34;
                                                obj3 = obj;
                                                zzdwVar2 = zzdwVar4;
                                                if (i15 == 1) {
                                                    iZzl = i36 + 8;
                                                    unsafe5.putObject(obj3, j, Double.valueOf(Double.longBitsToDouble(zzdx.zzo(bArr, i36))));
                                                    unsafe5.putInt(obj3, j3, i13);
                                                } else {
                                                    iZzl = i36;
                                                }
                                                if (iZzl != i36) {
                                                    i36 = i36;
                                                    i2 = i2;
                                                    i3 = i3;
                                                    iZzh = iZzl;
                                                    zzdwVar6 = zzdwVar2;
                                                    i76 = 0;
                                                    i78 = i69;
                                                    i79 = i9;
                                                    i81 = i10;
                                                    i77 = i70;
                                                    i80 = i13;
                                                    zzgoVar4 = zzgoVar;
                                                } else {
                                                    i36 = i36;
                                                    i4 = i3;
                                                    i8 = iZzl;
                                                    i12 = i69;
                                                    i76 = i70;
                                                }
                                                break;
                                            case 52:
                                                i69 = i35;
                                                i70 = i30;
                                                zzgoVar = zzgoVar2;
                                                unsafe5 = unsafe;
                                                i13 = i34;
                                                obj3 = obj;
                                                zzdwVar2 = zzdwVar4;
                                                if (i15 == 5) {
                                                    iZzl = i36 + 4;
                                                    unsafe5.putObject(obj3, j, Float.valueOf(Float.intBitsToFloat(zzdx.zzb(bArr, i36))));
                                                    unsafe5.putInt(obj3, j3, i13);
                                                } else {
                                                    iZzl = i36;
                                                }
                                                if (iZzl != i36) {
                                                    i36 = i36;
                                                    i2 = i2;
                                                    i3 = i3;
                                                    iZzh = iZzl;
                                                    zzdwVar6 = zzdwVar2;
                                                    i76 = 0;
                                                    i78 = i69;
                                                    i79 = i9;
                                                    i81 = i10;
                                                    i77 = i70;
                                                    i80 = i13;
                                                    zzgoVar4 = zzgoVar;
                                                } else {
                                                    i36 = i36;
                                                    i4 = i3;
                                                    i8 = iZzl;
                                                    i12 = i69;
                                                    i76 = i70;
                                                }
                                                break;
                                            case 53:
                                            case 54:
                                                i69 = i35;
                                                i70 = i30;
                                                zzgoVar = zzgoVar2;
                                                unsafe5 = unsafe;
                                                i13 = i34;
                                                obj3 = obj;
                                                zzdwVar2 = zzdwVar4;
                                                if (i15 == 0) {
                                                    iZzl = zzdx.zzl(bArr, i36, zzdwVar2);
                                                    unsafe5.putObject(obj3, j, Long.valueOf(zzdwVar2.zzb));
                                                    unsafe5.putInt(obj3, j3, i13);
                                                } else {
                                                    iZzl = i36;
                                                }
                                                if (iZzl != i36) {
                                                    i36 = i36;
                                                    i2 = i2;
                                                    i3 = i3;
                                                    iZzh = iZzl;
                                                    zzdwVar6 = zzdwVar2;
                                                    i76 = 0;
                                                    i78 = i69;
                                                    i79 = i9;
                                                    i81 = i10;
                                                    i77 = i70;
                                                    i80 = i13;
                                                    zzgoVar4 = zzgoVar;
                                                } else {
                                                    i36 = i36;
                                                    i4 = i3;
                                                    i8 = iZzl;
                                                    i12 = i69;
                                                    i76 = i70;
                                                }
                                                break;
                                            case 55:
                                            case 62:
                                                i69 = i35;
                                                i70 = i30;
                                                zzgoVar = zzgoVar2;
                                                unsafe5 = unsafe;
                                                i13 = i34;
                                                obj3 = obj;
                                                zzdwVar2 = zzdwVar4;
                                                if (i15 == 0) {
                                                    iZzl = zzdx.zzi(bArr, i36, zzdwVar2);
                                                    unsafe5.putObject(obj3, j, Integer.valueOf(zzdwVar2.zza));
                                                    unsafe5.putInt(obj3, j3, i13);
                                                } else {
                                                    iZzl = i36;
                                                }
                                                if (iZzl != i36) {
                                                    i36 = i36;
                                                    i2 = i2;
                                                    i3 = i3;
                                                    iZzh = iZzl;
                                                    zzdwVar6 = zzdwVar2;
                                                    i76 = 0;
                                                    i78 = i69;
                                                    i79 = i9;
                                                    i81 = i10;
                                                    i77 = i70;
                                                    i80 = i13;
                                                    zzgoVar4 = zzgoVar;
                                                } else {
                                                    i36 = i36;
                                                    i4 = i3;
                                                    i8 = iZzl;
                                                    i12 = i69;
                                                    i76 = i70;
                                                }
                                                break;
                                            case 56:
                                            case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                                                i69 = i35;
                                                i70 = i30;
                                                zzgoVar = zzgoVar2;
                                                unsafe5 = unsafe;
                                                i13 = i34;
                                                obj3 = obj;
                                                zzdwVar2 = zzdwVar4;
                                                if (i15 == 1) {
                                                    iZzl = i36 + 8;
                                                    unsafe5.putObject(obj3, j, Long.valueOf(zzdx.zzo(bArr, i36)));
                                                    unsafe5.putInt(obj3, j3, i13);
                                                } else {
                                                    iZzl = i36;
                                                }
                                                if (iZzl != i36) {
                                                    i36 = i36;
                                                    i2 = i2;
                                                    i3 = i3;
                                                    iZzh = iZzl;
                                                    zzdwVar6 = zzdwVar2;
                                                    i76 = 0;
                                                    i78 = i69;
                                                    i79 = i9;
                                                    i81 = i10;
                                                    i77 = i70;
                                                    i80 = i13;
                                                    zzgoVar4 = zzgoVar;
                                                } else {
                                                    i36 = i36;
                                                    i4 = i3;
                                                    i8 = iZzl;
                                                    i12 = i69;
                                                    i76 = i70;
                                                }
                                                break;
                                            case 57:
                                            case 64:
                                                i69 = i35;
                                                i70 = i30;
                                                zzgoVar = zzgoVar2;
                                                unsafe5 = unsafe;
                                                i13 = i34;
                                                obj3 = obj;
                                                zzdwVar2 = zzdwVar4;
                                                if (i15 == 5) {
                                                    iZzl = i36 + 4;
                                                    unsafe5.putObject(obj3, j, Integer.valueOf(zzdx.zzb(bArr, i36)));
                                                    unsafe5.putInt(obj3, j3, i13);
                                                } else {
                                                    iZzl = i36;
                                                }
                                                if (iZzl != i36) {
                                                    i36 = i36;
                                                    i2 = i2;
                                                    i3 = i3;
                                                    iZzh = iZzl;
                                                    zzdwVar6 = zzdwVar2;
                                                    i76 = 0;
                                                    i78 = i69;
                                                    i79 = i9;
                                                    i81 = i10;
                                                    i77 = i70;
                                                    i80 = i13;
                                                    zzgoVar4 = zzgoVar;
                                                } else {
                                                    i36 = i36;
                                                    i4 = i3;
                                                    i8 = iZzl;
                                                    i12 = i69;
                                                    i76 = i70;
                                                }
                                                break;
                                            case 58:
                                                i69 = i35;
                                                i70 = i30;
                                                zzgoVar = zzgoVar2;
                                                unsafe5 = unsafe;
                                                i13 = i34;
                                                obj3 = obj;
                                                zzdwVar2 = zzdwVar4;
                                                if (i15 == 0) {
                                                    iZzl = zzdx.zzl(bArr, i36, zzdwVar2);
                                                    if (zzdwVar2.zzb != 0) {
                                                        z5 = true;
                                                    } else {
                                                        z5 = false;
                                                    }
                                                    unsafe5.putObject(obj3, j, Boolean.valueOf(z5));
                                                    unsafe5.putInt(obj3, j3, i13);
                                                } else {
                                                    iZzl = i36;
                                                }
                                                if (iZzl != i36) {
                                                    i36 = i36;
                                                    i2 = i2;
                                                    i3 = i3;
                                                    iZzh = iZzl;
                                                    zzdwVar6 = zzdwVar2;
                                                    i76 = 0;
                                                    i78 = i69;
                                                    i79 = i9;
                                                    i81 = i10;
                                                    i77 = i70;
                                                    i80 = i13;
                                                    zzgoVar4 = zzgoVar;
                                                } else {
                                                    i36 = i36;
                                                    i4 = i3;
                                                    i8 = iZzl;
                                                    i12 = i69;
                                                    i76 = i70;
                                                }
                                                break;
                                            case 59:
                                                i69 = i35;
                                                i70 = i30;
                                                zzgoVar = zzgoVar2;
                                                unsafe5 = unsafe;
                                                i13 = i34;
                                                obj3 = obj;
                                                zzdwVar2 = zzdwVar4;
                                                if (i15 == 2) {
                                                    iZzl = zzdx.zzi(bArr, i36, zzdwVar2);
                                                    i71 = zzdwVar2.zza;
                                                    if (i71 == 0) {
                                                        unsafe5.putObject(obj3, j, "");
                                                    } else {
                                                        i72 = iZzl + i71;
                                                        if ((i16 & 536870912) == 0 && !zzhr.zzd(bArr, iZzl, i72)) {
                                                            throw new zzfq("Protocol message had invalid UTF-8.");
                                                        }
                                                        unsafe5.putObject(obj3, j, new String(bArr, iZzl, i71, zzfo.zza));
                                                        iZzl = i72;
                                                    }
                                                    unsafe5.putInt(obj3, j3, i13);
                                                } else {
                                                    iZzl = i36;
                                                }
                                                if (iZzl != i36) {
                                                    i36 = i36;
                                                    i2 = i2;
                                                    i3 = i3;
                                                    iZzh = iZzl;
                                                    zzdwVar6 = zzdwVar2;
                                                    i76 = 0;
                                                    i78 = i69;
                                                    i79 = i9;
                                                    i81 = i10;
                                                    i77 = i70;
                                                    i80 = i13;
                                                    zzgoVar4 = zzgoVar;
                                                } else {
                                                    i36 = i36;
                                                    i4 = i3;
                                                    i8 = iZzl;
                                                    i12 = i69;
                                                    i76 = i70;
                                                }
                                                break;
                                            case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                                                obj3 = obj;
                                                zzgoVar = zzgoVar2;
                                                i13 = i34;
                                                if (i15 == 2) {
                                                    Object objZzy = zzgoVar.zzy(obj3, i13, i30);
                                                    zzgv zzgvVarZzv2 = zzgoVar.zzv(i30);
                                                    unsafe5 = unsafe;
                                                    int iZzn = zzdx.zzn(objZzy, zzgvVarZzv2, bArr, i36, i2, zzdwVar);
                                                    zzgoVar.zzG(obj3, i13, i30, objZzy);
                                                    iZzl = iZzn;
                                                    i69 = i35;
                                                    i70 = i30;
                                                    zzdwVar2 = zzdwVar4;
                                                } else {
                                                    unsafe5 = unsafe;
                                                    i70 = i30;
                                                    zzdwVar2 = zzdwVar4;
                                                    i69 = i35;
                                                    iZzl = i36;
                                                }
                                                if (iZzl != i36) {
                                                    i36 = i36;
                                                    i2 = i2;
                                                    i3 = i3;
                                                    iZzh = iZzl;
                                                    zzdwVar6 = zzdwVar2;
                                                    i76 = 0;
                                                    i78 = i69;
                                                    i79 = i9;
                                                    i81 = i10;
                                                    i77 = i70;
                                                    i80 = i13;
                                                    zzgoVar4 = zzgoVar;
                                                } else {
                                                    i36 = i36;
                                                    i4 = i3;
                                                    i8 = iZzl;
                                                    i12 = i69;
                                                    i76 = i70;
                                                }
                                                break;
                                            case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                                                i73 = i35;
                                                i74 = i30;
                                                zzgoVar = zzgoVar2;
                                                i13 = i34;
                                                unsafe4 = unsafe;
                                                obj3 = obj;
                                                if (i15 == 2) {
                                                    iZzl = zzdx.zza(bArr, i36, zzdwVar4);
                                                    unsafe4.putObject(obj3, j, zzdwVar4.zzc);
                                                    unsafe4.putInt(obj3, j3, i13);
                                                    i70 = i74;
                                                    unsafe5 = unsafe4;
                                                    i69 = i73;
                                                    zzdwVar2 = zzdwVar4;
                                                    if (iZzl != i36) {
                                                        i36 = i36;
                                                        i2 = i2;
                                                        i3 = i3;
                                                        iZzh = iZzl;
                                                        zzdwVar6 = zzdwVar2;
                                                        i76 = 0;
                                                        i78 = i69;
                                                        i79 = i9;
                                                        i81 = i10;
                                                        i77 = i70;
                                                        i80 = i13;
                                                        zzgoVar4 = zzgoVar;
                                                    } else {
                                                        i36 = i36;
                                                        i4 = i3;
                                                        i8 = iZzl;
                                                        i12 = i69;
                                                        i76 = i70;
                                                    }
                                                } else {
                                                    i70 = i74;
                                                    unsafe5 = unsafe4;
                                                    i69 = i73;
                                                    zzdwVar2 = zzdwVar4;
                                                    iZzl = i36;
                                                    if (iZzl != i36) {
                                                        i36 = i36;
                                                        i2 = i2;
                                                        i3 = i3;
                                                        iZzh = iZzl;
                                                        zzdwVar6 = zzdwVar2;
                                                        i76 = 0;
                                                        i78 = i69;
                                                        i79 = i9;
                                                        i81 = i10;
                                                        i77 = i70;
                                                        i80 = i13;
                                                        zzgoVar4 = zzgoVar;
                                                    } else {
                                                        i36 = i36;
                                                        i4 = i3;
                                                        i8 = iZzl;
                                                        i12 = i69;
                                                        i76 = i70;
                                                    }
                                                }
                                                break;
                                            case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                                                i69 = i35;
                                                i74 = i30;
                                                zzgoVar = zzgoVar2;
                                                i13 = i34;
                                                unsafe4 = unsafe;
                                                obj3 = obj;
                                                if (i15 == 0) {
                                                    iZzl = zzdx.zzi(bArr, i36, zzdwVar4);
                                                    i75 = zzdwVar4.zza;
                                                    zzflVarZzu2 = zzgoVar.zzu(i74);
                                                    if (zzflVarZzu2 != null || zzflVarZzu2.zza(i75)) {
                                                        i73 = i69;
                                                        unsafe4.putObject(obj3, j, Integer.valueOf(i75));
                                                        unsafe4.putInt(obj3, j3, i13);
                                                    } else {
                                                        i73 = i69;
                                                        zzd(obj).zzj(i73, Long.valueOf(i75));
                                                    }
                                                    i70 = i74;
                                                    unsafe5 = unsafe4;
                                                    i69 = i73;
                                                    zzdwVar2 = zzdwVar4;
                                                    if (iZzl != i36) {
                                                        i36 = i36;
                                                        i2 = i2;
                                                        i3 = i3;
                                                        iZzh = iZzl;
                                                        zzdwVar6 = zzdwVar2;
                                                        i76 = 0;
                                                        i78 = i69;
                                                        i79 = i9;
                                                        i81 = i10;
                                                        i77 = i70;
                                                        i80 = i13;
                                                        zzgoVar4 = zzgoVar;
                                                    } else {
                                                        i36 = i36;
                                                        i4 = i3;
                                                        i8 = iZzl;
                                                        i12 = i69;
                                                        i76 = i70;
                                                    }
                                                }
                                                i70 = i74;
                                                unsafe5 = unsafe4;
                                                zzdwVar2 = zzdwVar4;
                                                iZzl = i36;
                                                if (iZzl != i36) {
                                                    i36 = i36;
                                                    i2 = i2;
                                                    i3 = i3;
                                                    iZzh = iZzl;
                                                    zzdwVar6 = zzdwVar2;
                                                    i76 = 0;
                                                    i78 = i69;
                                                    i79 = i9;
                                                    i81 = i10;
                                                    i77 = i70;
                                                    i80 = i13;
                                                    zzgoVar4 = zzgoVar;
                                                } else {
                                                    i36 = i36;
                                                    i4 = i3;
                                                    i8 = iZzl;
                                                    i12 = i69;
                                                    i76 = i70;
                                                }
                                                break;
                                            case 66:
                                                i69 = i35;
                                                i74 = i30;
                                                zzgoVar = zzgoVar2;
                                                i13 = i34;
                                                unsafe4 = unsafe;
                                                obj3 = obj;
                                                if (i15 == 0) {
                                                    iZzl = zzdx.zzi(bArr, i36, zzdwVar4);
                                                    unsafe4.putObject(obj3, j, Integer.valueOf(zzel.zzb(zzdwVar4.zza)));
                                                    unsafe4.putInt(obj3, j3, i13);
                                                    i70 = i74;
                                                    unsafe5 = unsafe4;
                                                    zzdwVar2 = zzdwVar4;
                                                    if (iZzl != i36) {
                                                        i36 = i36;
                                                        i2 = i2;
                                                        i3 = i3;
                                                        iZzh = iZzl;
                                                        zzdwVar6 = zzdwVar2;
                                                        i76 = 0;
                                                        i78 = i69;
                                                        i79 = i9;
                                                        i81 = i10;
                                                        i77 = i70;
                                                        i80 = i13;
                                                        zzgoVar4 = zzgoVar;
                                                    } else {
                                                        i36 = i36;
                                                        i4 = i3;
                                                        i8 = iZzl;
                                                        i12 = i69;
                                                        i76 = i70;
                                                    }
                                                }
                                                i70 = i74;
                                                unsafe5 = unsafe4;
                                                zzdwVar2 = zzdwVar4;
                                                iZzl = i36;
                                                if (iZzl != i36) {
                                                    i36 = i36;
                                                    i2 = i2;
                                                    i3 = i3;
                                                    iZzh = iZzl;
                                                    zzdwVar6 = zzdwVar2;
                                                    i76 = 0;
                                                    i78 = i69;
                                                    i79 = i9;
                                                    i81 = i10;
                                                    i77 = i70;
                                                    i80 = i13;
                                                    zzgoVar4 = zzgoVar;
                                                } else {
                                                    i36 = i36;
                                                    i4 = i3;
                                                    i8 = iZzl;
                                                    i12 = i69;
                                                    i76 = i70;
                                                }
                                                break;
                                            case 67:
                                                i69 = i35;
                                                i74 = i30;
                                                zzgoVar = zzgoVar2;
                                                i13 = i34;
                                                unsafe4 = unsafe;
                                                obj3 = obj;
                                                if (i15 == 0) {
                                                    iZzl = zzdx.zzl(bArr, i36, zzdwVar4);
                                                    unsafe4.putObject(obj3, j, Long.valueOf(zzel.zzc(zzdwVar4.zzb)));
                                                    unsafe4.putInt(obj3, j3, i13);
                                                    i70 = i74;
                                                    unsafe5 = unsafe4;
                                                    zzdwVar2 = zzdwVar4;
                                                    if (iZzl != i36) {
                                                        i36 = i36;
                                                        i2 = i2;
                                                        i3 = i3;
                                                        iZzh = iZzl;
                                                        zzdwVar6 = zzdwVar2;
                                                        i76 = 0;
                                                        i78 = i69;
                                                        i79 = i9;
                                                        i81 = i10;
                                                        i77 = i70;
                                                        i80 = i13;
                                                        zzgoVar4 = zzgoVar;
                                                    } else {
                                                        i36 = i36;
                                                        i4 = i3;
                                                        i8 = iZzl;
                                                        i12 = i69;
                                                        i76 = i70;
                                                    }
                                                }
                                                i70 = i74;
                                                unsafe5 = unsafe4;
                                                zzdwVar2 = zzdwVar4;
                                                iZzl = i36;
                                                if (iZzl != i36) {
                                                    i36 = i36;
                                                    i2 = i2;
                                                    i3 = i3;
                                                    iZzh = iZzl;
                                                    zzdwVar6 = zzdwVar2;
                                                    i76 = 0;
                                                    i78 = i69;
                                                    i79 = i9;
                                                    i81 = i10;
                                                    i77 = i70;
                                                    i80 = i13;
                                                    zzgoVar4 = zzgoVar;
                                                } else {
                                                    i36 = i36;
                                                    i4 = i3;
                                                    i8 = iZzl;
                                                    i12 = i69;
                                                    i76 = i70;
                                                }
                                                break;
                                            case 68:
                                                if (i15 == 3) {
                                                    int i105 = (i35 & (-8)) | 4;
                                                    obj3 = obj;
                                                    Object objZzy2 = zzgoVar2.zzy(obj3, i34, i30);
                                                    i69 = i35;
                                                    i13 = i34;
                                                    int iZzm2 = zzdx.zzm(objZzy2, zzgoVar2.zzv(i30), bArr, i36, i2, i105, zzdwVar);
                                                    zzgoVar2.zzG(obj3, i13, i30, objZzy2);
                                                    i70 = i30;
                                                    unsafe5 = unsafe;
                                                    zzdwVar2 = zzdwVar4;
                                                    zzgoVar = zzgoVar2;
                                                    iZzl = iZzm2;
                                                } else {
                                                    obj3 = obj;
                                                    i69 = i35;
                                                    i13 = i34;
                                                    zzdwVar2 = zzdwVar4;
                                                    i70 = i30;
                                                    zzgoVar = zzgoVar2;
                                                    unsafe5 = unsafe;
                                                    iZzl = i36;
                                                }
                                                if (iZzl != i36) {
                                                    i36 = i36;
                                                    i2 = i2;
                                                    i3 = i3;
                                                    iZzh = iZzl;
                                                    zzdwVar6 = zzdwVar2;
                                                    i76 = 0;
                                                    i78 = i69;
                                                    i79 = i9;
                                                    i81 = i10;
                                                    i77 = i70;
                                                    i80 = i13;
                                                    zzgoVar4 = zzgoVar;
                                                } else {
                                                    i36 = i36;
                                                    i4 = i3;
                                                    i8 = iZzl;
                                                    i12 = i69;
                                                    i76 = i70;
                                                }
                                                break;
                                            default:
                                                obj3 = obj;
                                                i69 = i35;
                                                zzdwVar2 = zzdwVar4;
                                                i70 = i30;
                                                zzgoVar = zzgoVar2;
                                                unsafe5 = unsafe;
                                                i13 = i34;
                                                iZzl = i36;
                                                if (iZzl != i36) {
                                                    i36 = i36;
                                                    i2 = i2;
                                                    i3 = i3;
                                                    iZzh = iZzl;
                                                    zzdwVar6 = zzdwVar2;
                                                    i76 = 0;
                                                    i78 = i69;
                                                    i79 = i9;
                                                    i81 = i10;
                                                    i77 = i70;
                                                    i80 = i13;
                                                    zzgoVar4 = zzgoVar;
                                                } else {
                                                    i36 = i36;
                                                    i4 = i3;
                                                    i8 = iZzl;
                                                    i12 = i69;
                                                    i76 = i70;
                                                }
                                                break;
                                        }
                                    } else {
                                        if (i15 == 2) {
                                            Object objZzw = zzgoVar2.zzw(i30);
                                            object = unsafe.getObject(obj3, j);
                                            if (!((zzgf) object).zze()) {
                                                zzgf zzgfVarZzb = zzgf.zza().zzb();
                                                zzgg.zza(zzgfVarZzb, object);
                                                unsafe.putObject(obj3, j, zzgfVarZzb);
                                            }
                                            throw null;
                                        }
                                        unsafe2 = unsafe;
                                        i4 = i3;
                                        i8 = i36;
                                        zzdwVar2 = zzdwVar4;
                                        i76 = i30;
                                        i12 = i35;
                                        unsafe5 = unsafe2;
                                        zzgoVar = zzgoVar2;
                                        i13 = i34;
                                    }
                                }
                            } else if (i15 == 2) {
                                zzfnVarZzd = (zzfn) unsafe.getObject(obj3, j);
                                if (!zzfnVarZzd.zzc()) {
                                    size = zzfnVarZzd.size();
                                    if (size == 0) {
                                        i37 = 10;
                                    } else {
                                        i37 = size + size;
                                    }
                                    zzfnVarZzd = zzfnVarZzd.zzd(i37);
                                    unsafe.putObject(obj3, j, zzfnVarZzd);
                                }
                                i77 = i30;
                                i3 = i3;
                                zzdwVar6 = zzdwVar3;
                                iZzh = zzdx.zze(zzgoVar4.zzv(i30), i29, bArr, i32, i2, zzfnVarZzd, zzdwVar);
                                i80 = i33;
                                i2 = i31;
                                unsafe5 = unsafe;
                                i76 = 0;
                                i78 = i29;
                                i79 = i9;
                                i81 = i10;
                            } else {
                                unsafe2 = unsafe;
                                i34 = i33;
                                zzgoVar2 = zzgoVar4;
                                i35 = i29;
                                zzdwVar4 = zzdwVar3;
                                i36 = i32;
                                i4 = i3;
                                i8 = i36;
                                zzdwVar2 = zzdwVar4;
                                i76 = i30;
                                i12 = i35;
                                unsafe5 = unsafe2;
                                zzgoVar = zzgoVar2;
                                i13 = i34;
                            }
                        }
                    } else {
                        i8 = iZzj;
                        i9 = i79;
                        i10 = i81;
                        i11 = i76;
                        zzdwVar2 = zzdwVar6;
                        i4 = i3;
                        i12 = i5;
                        zzgoVar = zzgoVar4;
                        i13 = i84;
                    }
                    if (i12 == i4 || i4 == 0) {
                        if (zzgoVar.zzh) {
                            zzeuVar = zzdwVar2.zzd;
                            int i106 = zzeu.zzb;
                            int i107 = zzgs.zza;
                            if (zzeuVar != zzeu.zza) {
                                zzglVar = zzgoVar.zzg;
                                int i108 = zzdx.zza;
                                if (zzeuVar.zzb(zzglVar, i13) == null) {
                                    throw null;
                                }
                                i14 = i12;
                                iZzh = zzdx.zzh(i12, bArr, i8, i2, zzd(obj), zzdwVar);
                            } else {
                                i14 = i12;
                                iZzh = zzdx.zzh(i14, bArr, i8, i2, zzd(obj), zzdwVar);
                            }
                        } else {
                            i14 = i12;
                            iZzh = zzdx.zzh(i14, bArr, i8, i2, zzd(obj), zzdwVar);
                        }
                        i2 = i2;
                        zzdwVar6 = zzdwVar;
                        i80 = i13;
                        zzgoVar4 = zzgoVar;
                        i77 = i76;
                        i78 = i14;
                        i76 = i11;
                        i79 = i9;
                        i81 = i10;
                        i3 = i4;
                    } else {
                        iZzh = i8;
                        i78 = i12;
                        i79 = i9;
                        i81 = i10;
                    }
                }
                i7 = iZzq;
                i6 = -1;
                if (i7 == i6) {
                    i15 = i5 & 7;
                    iArr = zzgoVar4.zzc;
                    i16 = iArr[i7 + 1];
                    i17 = i5;
                    iZzr = zzr(i16);
                    j = i16 & 1048575;
                    if (iZzr <= 17) {
                        int i810 = iArr[i7 + 2];
                        i18 = 1 << (i810 >>> 20);
                        i19 = 1048575;
                        i20 = i810 & 1048575;
                        if (i20 != i81) {
                            if (i81 != 1048575) {
                                unsafe5.putInt(obj3, i81, i79);
                                i19 = 1048575;
                            }
                            if (i20 == i19) {
                                i79 = 0;
                            } else {
                                i79 = unsafe5.getInt(obj3, i20);
                            }
                            i10 = i20;
                        } else {
                            i10 = i81;
                        }
                        switch (iZzr) {
                            case 0:
                                i21 = iZzj;
                                i22 = i7;
                                i23 = i17;
                                b = -1;
                                if (i15 == 1) {
                                    iZzh = i21 + 8;
                                    i79 |= i18;
                                    zzho.zzo(obj3, j, Double.longBitsToDouble(zzdx.zzo(bArr, i21)));
                                    i78 = i23;
                                    i77 = i22;
                                    i80 = i84;
                                    i81 = i10;
                                    i76 = 0;
                                } else {
                                    i27 = i23;
                                    i28 = i22;
                                    i11 = 0;
                                    i4 = i3;
                                    i76 = i28;
                                    unsafe5 = unsafe5;
                                    i9 = i79;
                                    i12 = i27;
                                    zzgoVar = zzgoVar4;
                                    zzdwVar2 = zzdwVar6;
                                    i13 = i84;
                                    i8 = i21;
                                }
                                break;
                            case 1:
                                i21 = iZzj;
                                i22 = i7;
                                i23 = i17;
                                b = -1;
                                if (i15 == 5) {
                                    iZzh = i21 + 4;
                                    i79 |= i18;
                                    zzho.zzp(obj3, j, Float.intBitsToFloat(zzdx.zzb(bArr, i21)));
                                    i78 = i23;
                                    i77 = i22;
                                    i80 = i84;
                                    i81 = i10;
                                    i76 = 0;
                                } else {
                                    i27 = i23;
                                    i28 = i22;
                                    i11 = 0;
                                    i4 = i3;
                                    i76 = i28;
                                    unsafe5 = unsafe5;
                                    i9 = i79;
                                    i12 = i27;
                                    zzgoVar = zzgoVar4;
                                    zzdwVar2 = zzdwVar6;
                                    i13 = i84;
                                    i8 = i21;
                                }
                                break;
                            case 2:
                            case 3:
                                i21 = iZzj;
                                i22 = i7;
                                i23 = i17;
                                b = -1;
                                if (i15 == 0) {
                                    int iZzl4 = zzdx.zzl(bArr, i21, zzdwVar6);
                                    unsafe5.putLong(obj, j, zzdwVar6.zzb);
                                    i2 = i2;
                                    i3 = i3;
                                    i79 |= i18;
                                    i78 = i23;
                                    i77 = i22;
                                    iZzh = iZzl4;
                                    i80 = i84;
                                    i81 = i10;
                                    i76 = 0;
                                } else {
                                    i27 = i23;
                                    i28 = i22;
                                    i11 = 0;
                                    i4 = i3;
                                    i76 = i28;
                                    unsafe5 = unsafe5;
                                    i9 = i79;
                                    i12 = i27;
                                    zzgoVar = zzgoVar4;
                                    zzdwVar2 = zzdwVar6;
                                    i13 = i84;
                                    i8 = i21;
                                }
                                break;
                            case 4:
                            case 11:
                                i21 = iZzj;
                                i22 = i7;
                                i23 = i17;
                                b = -1;
                                if (i15 == 0) {
                                    i79 |= i18;
                                    iZzh = zzdx.zzi(bArr, i21, zzdwVar6);
                                    unsafe5.putInt(obj3, j, zzdwVar6.zza);
                                    i78 = i23;
                                    i77 = i22;
                                    i80 = i84;
                                    i81 = i10;
                                    i76 = 0;
                                } else {
                                    i27 = i23;
                                    i28 = i22;
                                    i11 = 0;
                                    i4 = i3;
                                    i76 = i28;
                                    unsafe5 = unsafe5;
                                    i9 = i79;
                                    i12 = i27;
                                    zzgoVar = zzgoVar4;
                                    zzdwVar2 = zzdwVar6;
                                    i13 = i84;
                                    i8 = i21;
                                }
                                break;
                            case 5:
                            case 14:
                                i21 = iZzj;
                                i22 = i7;
                                i23 = i17;
                                b = -1;
                                if (i15 == 1) {
                                    unsafe5.putLong(obj, j, zzdx.zzo(bArr, i21));
                                    i2 = i2;
                                    i3 = i3;
                                    iZzh = i21 + 8;
                                    i78 = i23;
                                    i77 = i22;
                                    i79 |= i18;
                                    i80 = i84;
                                    i81 = i10;
                                    i76 = 0;
                                } else {
                                    i27 = i23;
                                    i28 = i22;
                                    i11 = 0;
                                    i4 = i3;
                                    i76 = i28;
                                    unsafe5 = unsafe5;
                                    i9 = i79;
                                    i12 = i27;
                                    zzgoVar = zzgoVar4;
                                    zzdwVar2 = zzdwVar6;
                                    i13 = i84;
                                    i8 = i21;
                                }
                                break;
                            case 6:
                            case 13:
                                i21 = iZzj;
                                i22 = i7;
                                i23 = i17;
                                b = -1;
                                if (i15 == 5) {
                                    iZzh = i21 + 4;
                                    i79 |= i18;
                                    unsafe5.putInt(obj3, j, zzdx.zzb(bArr, i21));
                                    i78 = i23;
                                    i77 = i22;
                                    i80 = i84;
                                    i81 = i10;
                                    i76 = 0;
                                } else {
                                    i27 = i23;
                                    i28 = i22;
                                    i11 = 0;
                                    i4 = i3;
                                    i76 = i28;
                                    unsafe5 = unsafe5;
                                    i9 = i79;
                                    i12 = i27;
                                    zzgoVar = zzgoVar4;
                                    zzdwVar2 = zzdwVar6;
                                    i13 = i84;
                                    i8 = i21;
                                }
                                break;
                            case 7:
                                i21 = iZzj;
                                i22 = i7;
                                i23 = i17;
                                b = -1;
                                if (i15 == 0) {
                                    i79 |= i18;
                                    iZzh = zzdx.zzl(bArr, i21, zzdwVar6);
                                    if (zzdwVar6.zzb != 0) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    zzho.zzm(obj3, j, z);
                                    i78 = i23;
                                    i77 = i22;
                                    i80 = i84;
                                    i81 = i10;
                                    i76 = 0;
                                } else {
                                    i27 = i23;
                                    i28 = i22;
                                    i11 = 0;
                                    i4 = i3;
                                    i76 = i28;
                                    unsafe5 = unsafe5;
                                    i9 = i79;
                                    i12 = i27;
                                    zzgoVar = zzgoVar4;
                                    zzdwVar2 = zzdwVar6;
                                    i13 = i84;
                                    i8 = i21;
                                }
                                break;
                            case 8:
                                i21 = iZzj;
                                i22 = i7;
                                i23 = i17;
                                b = -1;
                                if (i15 == 2) {
                                    if ((i16 & 536870912) != 0) {
                                        i79 |= i18;
                                        iZzh = zzdx.zzg(bArr, i21, zzdwVar6);
                                    } else {
                                        iZzh = zzdx.zzi(bArr, i21, zzdwVar6);
                                        i24 = zzdwVar6.zza;
                                        if (i24 >= 0) {
                                            throw new zzfq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                        }
                                        int i811 = i79 | i18;
                                        if (i24 == 0) {
                                            zzdwVar6.zzc = "";
                                        } else {
                                            zzdwVar6.zzc = new String(bArr, iZzh, i24, zzfo.zza);
                                            iZzh += i24;
                                        }
                                        i79 = i811;
                                    }
                                    unsafe5.putObject(obj3, j, zzdwVar6.zzc);
                                    i78 = i23;
                                    i77 = i22;
                                    i80 = i84;
                                    i81 = i10;
                                    i76 = 0;
                                } else {
                                    i27 = i23;
                                    i28 = i22;
                                    i11 = 0;
                                    i4 = i3;
                                    i76 = i28;
                                    unsafe5 = unsafe5;
                                    i9 = i79;
                                    i12 = i27;
                                    zzgoVar = zzgoVar4;
                                    zzdwVar2 = zzdwVar6;
                                    i13 = i84;
                                    i8 = i21;
                                }
                                break;
                            case 9:
                                i22 = i7;
                                i23 = i17;
                                b = -1;
                                if (i15 == 2) {
                                    i25 = i79 | i18;
                                    Object objZzx3 = zzgoVar4.zzx(obj3, i22);
                                    iZzh = zzdx.zzn(objZzx3, zzgoVar4.zzv(i22), bArr, iZzj, i2, zzdwVar);
                                    zzgoVar4.zzF(obj3, i22, objZzx3);
                                    i79 = i25;
                                    i78 = i23;
                                    i77 = i22;
                                    i80 = i84;
                                    i81 = i10;
                                    i76 = 0;
                                } else {
                                    i21 = iZzj;
                                    i27 = i23;
                                    i28 = i22;
                                    i11 = 0;
                                    i4 = i3;
                                    i76 = i28;
                                    unsafe5 = unsafe5;
                                    i9 = i79;
                                    i12 = i27;
                                    zzgoVar = zzgoVar4;
                                    zzdwVar2 = zzdwVar6;
                                    i13 = i84;
                                    i8 = i21;
                                }
                                break;
                            case 10:
                                i22 = i7;
                                i23 = i17;
                                b = -1;
                                if (i15 == 2) {
                                    i79 |= i18;
                                    iZzh = zzdx.zza(bArr, iZzj, zzdwVar6);
                                    unsafe5.putObject(obj3, j, zzdwVar6.zzc);
                                    i78 = i23;
                                    i77 = i22;
                                    i80 = i84;
                                    i81 = i10;
                                    i76 = 0;
                                } else {
                                    i21 = iZzj;
                                    i27 = i23;
                                    i28 = i22;
                                    i11 = 0;
                                    i4 = i3;
                                    i76 = i28;
                                    unsafe5 = unsafe5;
                                    i9 = i79;
                                    i12 = i27;
                                    zzgoVar = zzgoVar4;
                                    zzdwVar2 = zzdwVar6;
                                    i13 = i84;
                                    i8 = i21;
                                }
                                break;
                            case 12:
                                i22 = i7;
                                i23 = i17;
                                b = -1;
                                if (i15 == 0) {
                                    iZzh = zzdx.zzi(bArr, iZzj, zzdwVar6);
                                    i26 = zzdwVar6.zza;
                                    zzfl zzflVarZzu4 = zzgoVar4.zzu(i22);
                                    if ((i16 & Integer.MIN_VALUE) != 0) {
                                        i79 |= i18;
                                        unsafe5.putInt(obj3, j, i26);
                                    } else {
                                        i79 |= i18;
                                        unsafe5.putInt(obj3, j, i26);
                                    }
                                    i78 = i23;
                                    i77 = i22;
                                    i80 = i84;
                                    i81 = i10;
                                    i76 = 0;
                                } else {
                                    i21 = iZzj;
                                    i27 = i23;
                                    i28 = i22;
                                    i11 = 0;
                                    i4 = i3;
                                    i76 = i28;
                                    unsafe5 = unsafe5;
                                    i9 = i79;
                                    i12 = i27;
                                    zzgoVar = zzgoVar4;
                                    zzdwVar2 = zzdwVar6;
                                    i13 = i84;
                                    i8 = i21;
                                }
                                break;
                            case 15:
                                i22 = i7;
                                i23 = i17;
                                b = -1;
                                if (i15 == 0) {
                                    i79 |= i18;
                                    iZzh = zzdx.zzi(bArr, iZzj, zzdwVar6);
                                    unsafe5.putInt(obj3, j, zzel.zzb(zzdwVar6.zza));
                                    i78 = i23;
                                    i77 = i22;
                                    i80 = i84;
                                    i81 = i10;
                                    i76 = 0;
                                } else {
                                    i21 = iZzj;
                                    i27 = i23;
                                    i28 = i22;
                                    i11 = 0;
                                    i4 = i3;
                                    i76 = i28;
                                    unsafe5 = unsafe5;
                                    i9 = i79;
                                    i12 = i27;
                                    zzgoVar = zzgoVar4;
                                    zzdwVar2 = zzdwVar6;
                                    i13 = i84;
                                    i8 = i21;
                                }
                                break;
                            case 16:
                                if (i15 == 0) {
                                    i25 = i79 | i18;
                                    int iZzl5 = zzdx.zzl(bArr, iZzj, zzdwVar6);
                                    i23 = i17;
                                    i22 = i7;
                                    unsafe5.putLong(obj, j, zzel.zzc(zzdwVar6.zzb));
                                    iZzh = iZzl5;
                                    i79 = i25;
                                    i78 = i23;
                                    i77 = i22;
                                    i80 = i84;
                                    i81 = i10;
                                    i76 = 0;
                                } else {
                                    b = -1;
                                    i21 = iZzj;
                                    i28 = i7;
                                    i27 = i17;
                                    i11 = 0;
                                    i4 = i3;
                                    i76 = i28;
                                    unsafe5 = unsafe5;
                                    i9 = i79;
                                    i12 = i27;
                                    zzgoVar = zzgoVar4;
                                    zzdwVar2 = zzdwVar6;
                                    i13 = i84;
                                    i8 = i21;
                                }
                                break;
                            default:
                                i21 = iZzj;
                                i22 = i7;
                                i23 = i17;
                                b = -1;
                                if (i15 == 3) {
                                    int i812 = i79 | i18;
                                    Object objZzx4 = zzgoVar4.zzx(obj3, i22);
                                    int iZzm3 = zzdx.zzm(objZzx4, zzgoVar4.zzv(i22), bArr, i21, i2, (i84 << 3) | 4, zzdwVar);
                                    zzgoVar4.zzF(obj3, i22, objZzx4);
                                    i3 = i3;
                                    zzdwVar6 = zzdwVar6;
                                    i2 = i2;
                                    unsafe5 = unsafe5;
                                    iZzh = iZzm3;
                                    i76 = 0;
                                    i78 = i23;
                                    i81 = i10;
                                    i79 = i812;
                                    i77 = i22;
                                    i80 = i84;
                                } else {
                                    i27 = i23;
                                    i28 = i22;
                                    i11 = 0;
                                    i4 = i3;
                                    i76 = i28;
                                    unsafe5 = unsafe5;
                                    i9 = i79;
                                    i12 = i27;
                                    zzgoVar = zzgoVar4;
                                    zzdwVar2 = zzdwVar6;
                                    i13 = i84;
                                    i8 = i21;
                                }
                                break;
                        }
                    } else {
                        i10 = i81;
                        unsafe = unsafe5;
                        i29 = i17;
                        i11 = 0;
                        i30 = i7;
                        i9 = i79;
                        i31 = i2;
                        i32 = iZzj;
                        zzdwVar3 = zzdwVar6;
                        i33 = i84;
                        if (iZzr == 27) {
                            i38 = i32;
                            if (iZzr <= 49) {
                                j2 = i16;
                                zzfnVarZzd2 = (zzfn) unsafe.getObject(obj3, j);
                                if (!zzfnVarZzd2.zzc()) {
                                    int size4 = zzfnVarZzd2.size();
                                    zzfnVarZzd2 = zzfnVarZzd2.zzd(size4 + size4);
                                    unsafe.putObject(obj3, j, zzfnVarZzd2);
                                }
                                zzfnVar = zzfnVarZzd2;
                                switch (iZzr) {
                                    case 18:
                                    case MotionEventCompat.AXIS_GENERIC_4 /* 35 */:
                                        i31 = i31;
                                        i38 = i38;
                                        i39 = i30;
                                        zzdwVar5 = zzdwVar3;
                                        zzgoVar3 = zzgoVar4;
                                        i40 = i29;
                                        unsafe3 = unsafe;
                                        if (i15 == 2) {
                                            if (i15 == 1) {
                                                iZzh = i38 + 8;
                                                int i813 = zzdx.zza;
                                                zzerVar = (zzer) zzfnVar;
                                                zzerVar.zzf(Double.longBitsToDouble(zzdx.zzo(bArr, i38)));
                                                while (iZzh < i31) {
                                                    iZzi = zzdx.zzi(bArr, iZzh, zzdwVar5);
                                                    if (i40 == zzdwVar5.zza) {
                                                        zzerVar.zzf(Double.longBitsToDouble(zzdx.zzo(bArr, iZzi)));
                                                        iZzh = iZzi + 8;
                                                    }
                                                }
                                            }
                                            i33 = i33;
                                            this = zzgoVar3;
                                            iZzh = i38;
                                            if (iZzh != i38) {
                                                i31 = i31;
                                                i39 = i30;
                                                i3 = i3;
                                                i78 = i40;
                                                i2 = i31;
                                                i77 = i39;
                                                zzgoVar4 = this;
                                                i76 = 0;
                                                unsafe5 = unsafe3;
                                                i79 = i9;
                                                i81 = i10;
                                                i80 = i33;
                                                zzdwVar6 = zzdwVar5;
                                            } else {
                                                i31 = i31;
                                                i39 = i30;
                                                i12 = i40;
                                                i8 = iZzh;
                                                zzdwVar2 = zzdwVar5;
                                                i76 = i39;
                                                zzgoVar = this;
                                                unsafe5 = unsafe3;
                                                i13 = i33;
                                                i4 = i3;
                                            }
                                        } else {
                                            int i814 = zzdx.zza;
                                            zzerVar2 = (zzer) zzfnVar;
                                            iZzh = zzdx.zzi(bArr, i38, zzdwVar5);
                                            i41 = zzdwVar5.zza;
                                            i42 = iZzh + i41;
                                            if (i42 <= bArr.length) {
                                                throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            zzerVar2.zzg(zzerVar2.size() + (i41 / 8));
                                            while (iZzh < i42) {
                                                zzerVar2.zzf(Double.longBitsToDouble(zzdx.zzo(bArr, iZzh)));
                                                iZzh += 8;
                                            }
                                            if (iZzh != i42) {
                                                throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        i33 = i33;
                                        this = zzgoVar3;
                                        if (iZzh != i38) {
                                            i31 = i31;
                                            i39 = i30;
                                            i3 = i3;
                                            i78 = i40;
                                            i2 = i31;
                                            i77 = i39;
                                            zzgoVar4 = this;
                                            i76 = 0;
                                            unsafe5 = unsafe3;
                                            i79 = i9;
                                            i81 = i10;
                                            i80 = i33;
                                            zzdwVar6 = zzdwVar5;
                                        } else {
                                            i31 = i31;
                                            i39 = i30;
                                            i12 = i40;
                                            i8 = iZzh;
                                            zzdwVar2 = zzdwVar5;
                                            i76 = i39;
                                            zzgoVar = this;
                                            unsafe5 = unsafe3;
                                            i13 = i33;
                                            i4 = i3;
                                        }
                                        break;
                                    case 19:
                                    case 36:
                                        i31 = i31;
                                        i38 = i38;
                                        i39 = i30;
                                        zzdwVar5 = zzdwVar3;
                                        zzgoVar3 = zzgoVar4;
                                        i40 = i29;
                                        unsafe3 = unsafe;
                                        if (i15 == 2) {
                                            if (i15 == 5) {
                                                iZzh = i38 + 4;
                                                int i910 = zzdx.zza;
                                                zzfbVar = (zzfb) zzfnVar;
                                                zzfbVar.zzf(Float.intBitsToFloat(zzdx.zzb(bArr, i38)));
                                                while (iZzh < i31) {
                                                    iZzi2 = zzdx.zzi(bArr, iZzh, zzdwVar5);
                                                    if (i40 == zzdwVar5.zza) {
                                                        zzfbVar.zzf(Float.intBitsToFloat(zzdx.zzb(bArr, iZzi2)));
                                                        iZzh = iZzi2 + 4;
                                                    }
                                                }
                                            }
                                            i33 = i33;
                                            this = zzgoVar3;
                                            iZzh = i38;
                                            if (iZzh != i38) {
                                                i31 = i31;
                                                i39 = i30;
                                                i3 = i3;
                                                i78 = i40;
                                                i2 = i31;
                                                i77 = i39;
                                                zzgoVar4 = this;
                                                i76 = 0;
                                                unsafe5 = unsafe3;
                                                i79 = i9;
                                                i81 = i10;
                                                i80 = i33;
                                                zzdwVar6 = zzdwVar5;
                                            } else {
                                                i31 = i31;
                                                i39 = i30;
                                                i12 = i40;
                                                i8 = iZzh;
                                                zzdwVar2 = zzdwVar5;
                                                i76 = i39;
                                                zzgoVar = this;
                                                unsafe5 = unsafe3;
                                                i13 = i33;
                                                i4 = i3;
                                            }
                                        } else {
                                            int i911 = zzdx.zza;
                                            zzfbVar2 = (zzfb) zzfnVar;
                                            iZzh = zzdx.zzi(bArr, i38, zzdwVar5);
                                            i43 = zzdwVar5.zza;
                                            i44 = iZzh + i43;
                                            if (i44 <= bArr.length) {
                                                throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            zzfbVar2.zzg(zzfbVar2.size() + (i43 / 4));
                                            while (iZzh < i44) {
                                                zzfbVar2.zzf(Float.intBitsToFloat(zzdx.zzb(bArr, iZzh)));
                                                iZzh += 4;
                                            }
                                            if (iZzh != i44) {
                                                throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        i33 = i33;
                                        this = zzgoVar3;
                                        if (iZzh != i38) {
                                            i31 = i31;
                                            i39 = i30;
                                            i3 = i3;
                                            i78 = i40;
                                            i2 = i31;
                                            i77 = i39;
                                            zzgoVar4 = this;
                                            i76 = 0;
                                            unsafe5 = unsafe3;
                                            i79 = i9;
                                            i81 = i10;
                                            i80 = i33;
                                            zzdwVar6 = zzdwVar5;
                                        } else {
                                            i31 = i31;
                                            i39 = i30;
                                            i12 = i40;
                                            i8 = iZzh;
                                            zzdwVar2 = zzdwVar5;
                                            i76 = i39;
                                            zzgoVar = this;
                                            unsafe5 = unsafe3;
                                            i13 = i33;
                                            i4 = i3;
                                        }
                                        break;
                                    case 20:
                                    case 21:
                                    case MotionEventCompat.AXIS_GENERIC_6 /* 37 */:
                                    case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                                        i31 = i31;
                                        i38 = i38;
                                        i39 = i30;
                                        zzdwVar5 = zzdwVar3;
                                        zzgoVar3 = zzgoVar4;
                                        i40 = i29;
                                        unsafe3 = unsafe;
                                        if (i15 == 2) {
                                            if (i15 == 0) {
                                                int i912 = zzdx.zza;
                                                zzgaVar = (zzga) zzfnVar;
                                                iZzh = zzdx.zzl(bArr, i38, zzdwVar5);
                                                zzgaVar.zzf(zzdwVar5.zzb);
                                                while (iZzh < i31) {
                                                    iZzi3 = zzdx.zzi(bArr, iZzh, zzdwVar5);
                                                    if (i40 == zzdwVar5.zza) {
                                                        iZzh = zzdx.zzl(bArr, iZzi3, zzdwVar5);
                                                        zzgaVar.zzf(zzdwVar5.zzb);
                                                    }
                                                }
                                            }
                                            i33 = i33;
                                            this = zzgoVar3;
                                            iZzh = i38;
                                            if (iZzh != i38) {
                                                i31 = i31;
                                                i39 = i30;
                                                i3 = i3;
                                                i78 = i40;
                                                i2 = i31;
                                                i77 = i39;
                                                zzgoVar4 = this;
                                                i76 = 0;
                                                unsafe5 = unsafe3;
                                                i79 = i9;
                                                i81 = i10;
                                                i80 = i33;
                                                zzdwVar6 = zzdwVar5;
                                            } else {
                                                i31 = i31;
                                                i39 = i30;
                                                i12 = i40;
                                                i8 = iZzh;
                                                zzdwVar2 = zzdwVar5;
                                                i76 = i39;
                                                zzgoVar = this;
                                                unsafe5 = unsafe3;
                                                i13 = i33;
                                                i4 = i3;
                                            }
                                        } else {
                                            int i913 = zzdx.zza;
                                            zzgaVar2 = (zzga) zzfnVar;
                                            iZzh = zzdx.zzi(bArr, i38, zzdwVar5);
                                            i45 = zzdwVar5.zza + iZzh;
                                            while (iZzh < i45) {
                                                iZzh = zzdx.zzl(bArr, iZzh, zzdwVar5);
                                                zzgaVar2.zzf(zzdwVar5.zzb);
                                            }
                                            if (iZzh != i45) {
                                                throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        i33 = i33;
                                        this = zzgoVar3;
                                        if (iZzh != i38) {
                                            i31 = i31;
                                            i39 = i30;
                                            i3 = i3;
                                            i78 = i40;
                                            i2 = i31;
                                            i77 = i39;
                                            zzgoVar4 = this;
                                            i76 = 0;
                                            unsafe5 = unsafe3;
                                            i79 = i9;
                                            i81 = i10;
                                            i80 = i33;
                                            zzdwVar6 = zzdwVar5;
                                        } else {
                                            i31 = i31;
                                            i39 = i30;
                                            i12 = i40;
                                            i8 = iZzh;
                                            zzdwVar2 = zzdwVar5;
                                            i76 = i39;
                                            zzgoVar = this;
                                            unsafe5 = unsafe3;
                                            i13 = i33;
                                            i4 = i3;
                                        }
                                        break;
                                    case 22:
                                    case 29:
                                    case MotionEventCompat.AXIS_GENERIC_8 /* 39 */:
                                    case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                                        i46 = i31;
                                        i47 = i38;
                                        i40 = i29;
                                        i39 = i30;
                                        unsafe3 = unsafe;
                                        if (i15 == 2) {
                                            iZzf = zzdx.zzf(bArr, i47, zzfnVar, zzdwVar3);
                                            zzdwVar5 = zzdwVar3;
                                            iZzh = iZzf;
                                            i31 = i46;
                                            i38 = i47;
                                            i33 = i33;
                                            this = this;
                                        } else if (i15 == 0) {
                                            zzdwVar5 = zzdwVar3;
                                            i31 = i46;
                                            i38 = i47;
                                            iZzh = zzdx.zzk(i40, bArr, i47, i2, zzfnVar, zzdwVar);
                                            i33 = i33;
                                            this = this;
                                        } else {
                                            zzdwVar5 = zzdwVar3;
                                            i31 = i46;
                                            i38 = i47;
                                            i33 = i33;
                                            this = this;
                                            iZzh = i38;
                                        }
                                        if (iZzh != i38) {
                                            i31 = i31;
                                            i39 = i30;
                                            i3 = i3;
                                            i78 = i40;
                                            i2 = i31;
                                            i77 = i39;
                                            zzgoVar4 = this;
                                            i76 = 0;
                                            unsafe5 = unsafe3;
                                            i79 = i9;
                                            i81 = i10;
                                            i80 = i33;
                                            zzdwVar6 = zzdwVar5;
                                        } else {
                                            i31 = i31;
                                            i39 = i30;
                                            i12 = i40;
                                            i8 = iZzh;
                                            zzdwVar2 = zzdwVar5;
                                            i76 = i39;
                                            zzgoVar = this;
                                            unsafe5 = unsafe3;
                                            i13 = i33;
                                            i4 = i3;
                                        }
                                        break;
                                    case 23:
                                    case 32:
                                    case MotionEventCompat.AXIS_GENERIC_9 /* 40 */:
                                    case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                                        i46 = i31;
                                        i47 = i38;
                                        i40 = i29;
                                        i39 = i30;
                                        unsafe3 = unsafe;
                                        if (i15 == 2) {
                                            if (i15 == 1) {
                                                iZzf = i47 + 8;
                                                int i914 = zzdx.zza;
                                                zzgaVar3 = (zzga) zzfnVar;
                                                zzgaVar3.zzf(zzdx.zzo(bArr, i47));
                                                while (iZzf < i46) {
                                                    iZzi4 = zzdx.zzi(bArr, iZzf, zzdwVar3);
                                                    if (i40 == zzdwVar3.zza) {
                                                        zzgaVar3.zzf(zzdx.zzo(bArr, iZzi4));
                                                        iZzf = iZzi4 + 8;
                                                    }
                                                }
                                            }
                                            zzdwVar5 = zzdwVar3;
                                            i31 = i46;
                                            i38 = i47;
                                            i33 = i33;
                                            this = this;
                                            iZzh = i38;
                                            if (iZzh != i38) {
                                                i31 = i31;
                                                i39 = i30;
                                                i3 = i3;
                                                i78 = i40;
                                                i2 = i31;
                                                i77 = i39;
                                                zzgoVar4 = this;
                                                i76 = 0;
                                                unsafe5 = unsafe3;
                                                i79 = i9;
                                                i81 = i10;
                                                i80 = i33;
                                                zzdwVar6 = zzdwVar5;
                                            } else {
                                                i31 = i31;
                                                i39 = i30;
                                                i12 = i40;
                                                i8 = iZzh;
                                                zzdwVar2 = zzdwVar5;
                                                i76 = i39;
                                                zzgoVar = this;
                                                unsafe5 = unsafe3;
                                                i13 = i33;
                                                i4 = i3;
                                            }
                                        } else {
                                            int i915 = zzdx.zza;
                                            zzgaVar4 = (zzga) zzfnVar;
                                            iZzf = zzdx.zzi(bArr, i47, zzdwVar3);
                                            i48 = zzdwVar3.zza;
                                            i49 = iZzf + i48;
                                            if (i49 <= bArr.length) {
                                                throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            zzgaVar4.zzg(zzgaVar4.size() + (i48 / 8));
                                            while (iZzf < i49) {
                                                zzgaVar4.zzf(zzdx.zzo(bArr, iZzf));
                                                iZzf += 8;
                                            }
                                            if (iZzf != i49) {
                                                throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        zzdwVar5 = zzdwVar3;
                                        iZzh = iZzf;
                                        i31 = i46;
                                        i38 = i47;
                                        i33 = i33;
                                        this = this;
                                        if (iZzh != i38) {
                                            i31 = i31;
                                            i39 = i30;
                                            i3 = i3;
                                            i78 = i40;
                                            i2 = i31;
                                            i77 = i39;
                                            zzgoVar4 = this;
                                            i76 = 0;
                                            unsafe5 = unsafe3;
                                            i79 = i9;
                                            i81 = i10;
                                            i80 = i33;
                                            zzdwVar6 = zzdwVar5;
                                        } else {
                                            i31 = i31;
                                            i39 = i30;
                                            i12 = i40;
                                            i8 = iZzh;
                                            zzdwVar2 = zzdwVar5;
                                            i76 = i39;
                                            zzgoVar = this;
                                            unsafe5 = unsafe3;
                                            i13 = i33;
                                            i4 = i3;
                                        }
                                        break;
                                    case 24:
                                    case 31:
                                    case MotionEventCompat.AXIS_GENERIC_10 /* 41 */:
                                    case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                                        i46 = i31;
                                        i47 = i38;
                                        i40 = i29;
                                        i39 = i30;
                                        unsafe3 = unsafe;
                                        if (i15 == 2) {
                                            if (i15 == 5) {
                                                iZzf = i47 + 4;
                                                int i916 = zzdx.zza;
                                                zzfjVar = (zzfj) zzfnVar;
                                                zzfjVar.zzg(zzdx.zzb(bArr, i47));
                                                while (iZzf < i46) {
                                                    iZzi5 = zzdx.zzi(bArr, iZzf, zzdwVar3);
                                                    if (i40 == zzdwVar3.zza) {
                                                        zzfjVar.zzg(zzdx.zzb(bArr, iZzi5));
                                                        iZzf = iZzi5 + 4;
                                                    }
                                                }
                                            }
                                            zzdwVar5 = zzdwVar3;
                                            i31 = i46;
                                            i38 = i47;
                                            i33 = i33;
                                            this = this;
                                            iZzh = i38;
                                            if (iZzh != i38) {
                                                i31 = i31;
                                                i39 = i30;
                                                i3 = i3;
                                                i78 = i40;
                                                i2 = i31;
                                                i77 = i39;
                                                zzgoVar4 = this;
                                                i76 = 0;
                                                unsafe5 = unsafe3;
                                                i79 = i9;
                                                i81 = i10;
                                                i80 = i33;
                                                zzdwVar6 = zzdwVar5;
                                            } else {
                                                i31 = i31;
                                                i39 = i30;
                                                i12 = i40;
                                                i8 = iZzh;
                                                zzdwVar2 = zzdwVar5;
                                                i76 = i39;
                                                zzgoVar = this;
                                                unsafe5 = unsafe3;
                                                i13 = i33;
                                                i4 = i3;
                                            }
                                        } else {
                                            int i917 = zzdx.zza;
                                            zzfjVar2 = (zzfj) zzfnVar;
                                            iZzf = zzdx.zzi(bArr, i47, zzdwVar3);
                                            i50 = zzdwVar3.zza;
                                            i51 = iZzf + i50;
                                            if (i51 <= bArr.length) {
                                                throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            zzfjVar2.zzh(zzfjVar2.size() + (i50 / 4));
                                            while (iZzf < i51) {
                                                zzfjVar2.zzg(zzdx.zzb(bArr, iZzf));
                                                iZzf += 4;
                                            }
                                            if (iZzf != i51) {
                                                throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        zzdwVar5 = zzdwVar3;
                                        iZzh = iZzf;
                                        i31 = i46;
                                        i38 = i47;
                                        i33 = i33;
                                        this = this;
                                        if (iZzh != i38) {
                                            i31 = i31;
                                            i39 = i30;
                                            i3 = i3;
                                            i78 = i40;
                                            i2 = i31;
                                            i77 = i39;
                                            zzgoVar4 = this;
                                            i76 = 0;
                                            unsafe5 = unsafe3;
                                            i79 = i9;
                                            i81 = i10;
                                            i80 = i33;
                                            zzdwVar6 = zzdwVar5;
                                        } else {
                                            i31 = i31;
                                            i39 = i30;
                                            i12 = i40;
                                            i8 = iZzh;
                                            zzdwVar2 = zzdwVar5;
                                            i76 = i39;
                                            zzgoVar = this;
                                            unsafe5 = unsafe3;
                                            i13 = i33;
                                            i4 = i3;
                                        }
                                        break;
                                    case 25:
                                    case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                                        i46 = i31;
                                        i47 = i38;
                                        i40 = i29;
                                        i39 = i30;
                                        unsafe3 = unsafe;
                                        if (i15 == 2) {
                                            if (i15 == 0) {
                                                int i918 = zzdx.zza;
                                                zzdyVar = (zzdy) zzfnVar;
                                                iZzf = zzdx.zzl(bArr, i47, zzdwVar3);
                                                if (zzdwVar3.zzb != 0) {
                                                    z2 = true;
                                                } else {
                                                    z2 = false;
                                                }
                                                zzdyVar.zze(z2);
                                                while (iZzf < i46) {
                                                    iZzi6 = zzdx.zzi(bArr, iZzf, zzdwVar3);
                                                    if (i40 == zzdwVar3.zza) {
                                                        iZzf = zzdx.zzl(bArr, iZzi6, zzdwVar3);
                                                        if (zzdwVar3.zzb != 0) {
                                                            z3 = true;
                                                        } else {
                                                            z3 = false;
                                                        }
                                                        zzdyVar.zze(z3);
                                                    }
                                                }
                                            }
                                            zzdwVar5 = zzdwVar3;
                                            i31 = i46;
                                            i38 = i47;
                                            i33 = i33;
                                            this = this;
                                            iZzh = i38;
                                            if (iZzh != i38) {
                                                i31 = i31;
                                                i39 = i30;
                                                i3 = i3;
                                                i78 = i40;
                                                i2 = i31;
                                                i77 = i39;
                                                zzgoVar4 = this;
                                                i76 = 0;
                                                unsafe5 = unsafe3;
                                                i79 = i9;
                                                i81 = i10;
                                                i80 = i33;
                                                zzdwVar6 = zzdwVar5;
                                            } else {
                                                i31 = i31;
                                                i39 = i30;
                                                i12 = i40;
                                                i8 = iZzh;
                                                zzdwVar2 = zzdwVar5;
                                                i76 = i39;
                                                zzgoVar = this;
                                                unsafe5 = unsafe3;
                                                i13 = i33;
                                                i4 = i3;
                                            }
                                        } else {
                                            int i919 = zzdx.zza;
                                            zzdyVar2 = (zzdy) zzfnVar;
                                            iZzf = zzdx.zzi(bArr, i47, zzdwVar3);
                                            i52 = zzdwVar3.zza + iZzf;
                                            while (iZzf < i52) {
                                                iZzf = zzdx.zzl(bArr, iZzf, zzdwVar3);
                                                if (zzdwVar3.zzb != 0) {
                                                    z4 = true;
                                                } else {
                                                    z4 = false;
                                                }
                                                zzdyVar2.zze(z4);
                                            }
                                            if (iZzf != i52) {
                                                throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        zzdwVar5 = zzdwVar3;
                                        iZzh = iZzf;
                                        i31 = i46;
                                        i38 = i47;
                                        i33 = i33;
                                        this = this;
                                        if (iZzh != i38) {
                                            i31 = i31;
                                            i39 = i30;
                                            i3 = i3;
                                            i78 = i40;
                                            i2 = i31;
                                            i77 = i39;
                                            zzgoVar4 = this;
                                            i76 = 0;
                                            unsafe5 = unsafe3;
                                            i79 = i9;
                                            i81 = i10;
                                            i80 = i33;
                                            zzdwVar6 = zzdwVar5;
                                        } else {
                                            i31 = i31;
                                            i39 = i30;
                                            i12 = i40;
                                            i8 = iZzh;
                                            zzdwVar2 = zzdwVar5;
                                            i76 = i39;
                                            zzgoVar = this;
                                            unsafe5 = unsafe3;
                                            i13 = i33;
                                            i4 = i3;
                                        }
                                        break;
                                    case 26:
                                        i46 = i31;
                                        i47 = i38;
                                        i39 = i30;
                                        zzgoVar3 = zzgoVar4;
                                        i40 = i29;
                                        unsafe3 = unsafe;
                                        if (i15 == 2) {
                                            if ((j2 & 536870912) == 0) {
                                                iZzf = zzdx.zzi(bArr, i47, zzdwVar3);
                                                i53 = zzdwVar3.zza;
                                                if (i53 >= 0) {
                                                    throw new zzfq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                                if (i53 == 0) {
                                                    zzfnVar.add("");
                                                } else {
                                                    i54 = iZzf + i53;
                                                    if (zzhr.zzd(bArr, iZzf, i54)) {
                                                        throw new zzfq("Protocol message had invalid UTF-8.");
                                                    }
                                                    zzfnVar.add(new String(bArr, iZzf, i53, zzfo.zza));
                                                    iZzf = i54;
                                                }
                                                while (iZzf < i46) {
                                                    iZzi7 = zzdx.zzi(bArr, iZzf, zzdwVar3);
                                                    if (i40 == zzdwVar3.zza) {
                                                        zzdwVar5 = zzdwVar3;
                                                        iZzh = iZzf;
                                                        i31 = i46;
                                                        i38 = i47;
                                                        i33 = i33;
                                                        this = this;
                                                        if (iZzh != i38) {
                                                            i31 = i31;
                                                            i39 = i30;
                                                            i3 = i3;
                                                            i78 = i40;
                                                            i2 = i31;
                                                            i77 = i39;
                                                            zzgoVar4 = this;
                                                            i76 = 0;
                                                            unsafe5 = unsafe3;
                                                            i79 = i9;
                                                            i81 = i10;
                                                            i80 = i33;
                                                            zzdwVar6 = zzdwVar5;
                                                        } else {
                                                            i31 = i31;
                                                            i39 = i30;
                                                            i12 = i40;
                                                            i8 = iZzh;
                                                            zzdwVar2 = zzdwVar5;
                                                            i76 = i39;
                                                            zzgoVar = this;
                                                            unsafe5 = unsafe3;
                                                            i13 = i33;
                                                            i4 = i3;
                                                        }
                                                        break;
                                                    } else {
                                                        iZzf = zzdx.zzi(bArr, iZzi7, zzdwVar3);
                                                        i55 = zzdwVar3.zza;
                                                        if (i55 >= 0) {
                                                            throw new zzfq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                        }
                                                        if (i55 == 0) {
                                                            zzfnVar.add("");
                                                        } else {
                                                            i56 = iZzf + i55;
                                                            if (zzhr.zzd(bArr, iZzf, i56)) {
                                                                throw new zzfq("Protocol message had invalid UTF-8.");
                                                            }
                                                            zzfnVar.add(new String(bArr, iZzf, i55, zzfo.zza));
                                                            iZzf = i56;
                                                        }
                                                    }
                                                }
                                                zzdwVar5 = zzdwVar3;
                                                iZzh = iZzf;
                                                i31 = i46;
                                                i38 = i47;
                                                i33 = i33;
                                                this = this;
                                                if (iZzh != i38) {
                                                    i31 = i31;
                                                    i39 = i30;
                                                    i3 = i3;
                                                    i78 = i40;
                                                    i2 = i31;
                                                    i77 = i39;
                                                    zzgoVar4 = this;
                                                    i76 = 0;
                                                    unsafe5 = unsafe3;
                                                    i79 = i9;
                                                    i81 = i10;
                                                    i80 = i33;
                                                    zzdwVar6 = zzdwVar5;
                                                } else {
                                                    i31 = i31;
                                                    i39 = i30;
                                                    i12 = i40;
                                                    i8 = iZzh;
                                                    zzdwVar2 = zzdwVar5;
                                                    i76 = i39;
                                                    zzgoVar = this;
                                                    unsafe5 = unsafe3;
                                                    i13 = i33;
                                                    i4 = i3;
                                                }
                                            } else {
                                                iZzi8 = zzdx.zzi(bArr, i47, zzdwVar3);
                                                i57 = zzdwVar3.zza;
                                                if (i57 >= 0) {
                                                    throw new zzfq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                                if (i57 == 0) {
                                                    obj2 = "";
                                                    zzfnVar.add(obj2);
                                                } else {
                                                    obj2 = "";
                                                    zzfnVar.add(new String(bArr, iZzi8, i57, zzfo.zza));
                                                    iZzi8 += i57;
                                                }
                                                while (iZzi8 < i46) {
                                                    iZzi9 = zzdx.zzi(bArr, iZzi8, zzdwVar3);
                                                    if (i40 == zzdwVar3.zza) {
                                                        zzdwVar5 = zzdwVar3;
                                                        iZzh = iZzi8;
                                                        i31 = i46;
                                                        i38 = i47;
                                                        i33 = i33;
                                                        this = zzgoVar3;
                                                        if (iZzh != i38) {
                                                            i31 = i31;
                                                            i39 = i30;
                                                            i3 = i3;
                                                            i78 = i40;
                                                            i2 = i31;
                                                            i77 = i39;
                                                            zzgoVar4 = this;
                                                            i76 = 0;
                                                            unsafe5 = unsafe3;
                                                            i79 = i9;
                                                            i81 = i10;
                                                            i80 = i33;
                                                            zzdwVar6 = zzdwVar5;
                                                        } else {
                                                            i31 = i31;
                                                            i39 = i30;
                                                            i12 = i40;
                                                            i8 = iZzh;
                                                            zzdwVar2 = zzdwVar5;
                                                            i76 = i39;
                                                            zzgoVar = this;
                                                            unsafe5 = unsafe3;
                                                            i13 = i33;
                                                            i4 = i3;
                                                        }
                                                        break;
                                                    } else {
                                                        iZzi8 = zzdx.zzi(bArr, iZzi9, zzdwVar3);
                                                        i58 = zzdwVar3.zza;
                                                        if (i58 >= 0) {
                                                            throw new zzfq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                        }
                                                        if (i58 == 0) {
                                                            zzfnVar.add(obj2);
                                                        } else {
                                                            zzfnVar.add(new String(bArr, iZzi8, i58, zzfo.zza));
                                                            iZzi8 += i58;
                                                        }
                                                    }
                                                }
                                                zzdwVar5 = zzdwVar3;
                                                iZzh = iZzi8;
                                                i31 = i46;
                                                i38 = i47;
                                                i33 = i33;
                                                this = zzgoVar3;
                                                if (iZzh != i38) {
                                                    i31 = i31;
                                                    i39 = i30;
                                                    i3 = i3;
                                                    i78 = i40;
                                                    i2 = i31;
                                                    i77 = i39;
                                                    zzgoVar4 = this;
                                                    i76 = 0;
                                                    unsafe5 = unsafe3;
                                                    i79 = i9;
                                                    i81 = i10;
                                                    i80 = i33;
                                                    zzdwVar6 = zzdwVar5;
                                                } else {
                                                    i31 = i31;
                                                    i39 = i30;
                                                    i12 = i40;
                                                    i8 = iZzh;
                                                    zzdwVar2 = zzdwVar5;
                                                    i76 = i39;
                                                    zzgoVar = this;
                                                    unsafe5 = unsafe3;
                                                    i13 = i33;
                                                    i4 = i3;
                                                }
                                            }
                                        }
                                        zzdwVar5 = zzdwVar3;
                                        i31 = i46;
                                        i38 = i47;
                                        i33 = i33;
                                        this = this;
                                        iZzh = i38;
                                        if (iZzh != i38) {
                                            i31 = i31;
                                            i39 = i30;
                                            i3 = i3;
                                            i78 = i40;
                                            i2 = i31;
                                            i77 = i39;
                                            zzgoVar4 = this;
                                            i76 = 0;
                                            unsafe5 = unsafe3;
                                            i79 = i9;
                                            i81 = i10;
                                            i80 = i33;
                                            zzdwVar6 = zzdwVar5;
                                        } else {
                                            i31 = i31;
                                            i39 = i30;
                                            i12 = i40;
                                            i8 = iZzh;
                                            zzdwVar2 = zzdwVar5;
                                            i76 = i39;
                                            zzgoVar = this;
                                            unsafe5 = unsafe3;
                                            i13 = i33;
                                            i4 = i3;
                                        }
                                        break;
                                    case MotionEventCompat.AXIS_RELATIVE_X /* 27 */:
                                        i31 = i31;
                                        i59 = i30;
                                        if (i15 == 2) {
                                            unsafe3 = unsafe;
                                            i40 = i29;
                                            int iZze2 = zzdx.zze(zzv(i59), i29, bArr, i38, i2, zzfnVar, zzdwVar);
                                            zzdwVar5 = zzdwVar3;
                                            i39 = i59;
                                            i33 = i33;
                                            i38 = i38;
                                            this = this;
                                            iZzh = iZze2;
                                        } else {
                                            unsafe3 = unsafe;
                                            i40 = i29;
                                            zzdwVar5 = zzdwVar3;
                                            i39 = i59;
                                            iZzh = i38;
                                        }
                                        if (iZzh != i38) {
                                            i31 = i31;
                                            i39 = i30;
                                            i3 = i3;
                                            i78 = i40;
                                            i2 = i31;
                                            i77 = i39;
                                            zzgoVar4 = this;
                                            i76 = 0;
                                            unsafe5 = unsafe3;
                                            i79 = i9;
                                            i81 = i10;
                                            i80 = i33;
                                            zzdwVar6 = zzdwVar5;
                                        } else {
                                            i31 = i31;
                                            i39 = i30;
                                            i12 = i40;
                                            i8 = iZzh;
                                            zzdwVar2 = zzdwVar5;
                                            i76 = i39;
                                            zzgoVar = this;
                                            unsafe5 = unsafe3;
                                            i13 = i33;
                                            i4 = i3;
                                        }
                                        break;
                                    case MotionEventCompat.AXIS_RELATIVE_Y /* 28 */:
                                        i31 = i31;
                                        i59 = i30;
                                        if (i15 == 2) {
                                            iZzi10 = zzdx.zzi(bArr, i38, zzdwVar3);
                                            i60 = zzdwVar3.zza;
                                            if (i60 >= 0) {
                                                throw new zzfq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                            }
                                            if (i60 <= bArr.length - iZzi10) {
                                                throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            if (i60 == 0) {
                                                zzfnVar.add(zzei.zzb);
                                            } else {
                                                zzfnVar.add(zzei.zzj(bArr, iZzi10, i60));
                                                iZzi10 += i60;
                                            }
                                            while (iZzi10 < i31) {
                                                iZzi11 = zzdx.zzi(bArr, iZzi10, zzdwVar3);
                                                if (i29 == zzdwVar3.zza) {
                                                    unsafe3 = unsafe;
                                                    i40 = i29;
                                                    this = this;
                                                    zzdwVar5 = zzdwVar3;
                                                    i39 = i59;
                                                    iZzh = iZzi10;
                                                    if (iZzh != i38) {
                                                        i31 = i31;
                                                        i39 = i30;
                                                        i3 = i3;
                                                        i78 = i40;
                                                        i2 = i31;
                                                        i77 = i39;
                                                        zzgoVar4 = this;
                                                        i76 = 0;
                                                        unsafe5 = unsafe3;
                                                        i79 = i9;
                                                        i81 = i10;
                                                        i80 = i33;
                                                        zzdwVar6 = zzdwVar5;
                                                    } else {
                                                        i31 = i31;
                                                        i39 = i30;
                                                        i12 = i40;
                                                        i8 = iZzh;
                                                        zzdwVar2 = zzdwVar5;
                                                        i76 = i39;
                                                        zzgoVar = this;
                                                        unsafe5 = unsafe3;
                                                        i13 = i33;
                                                        i4 = i3;
                                                    }
                                                    break;
                                                } else {
                                                    iZzi10 = zzdx.zzi(bArr, iZzi11, zzdwVar3);
                                                    i61 = zzdwVar3.zza;
                                                    if (i61 >= 0) {
                                                        throw new zzfq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                    }
                                                    if (i61 <= bArr.length - iZzi10) {
                                                        throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                    }
                                                    if (i61 == 0) {
                                                        zzfnVar.add(zzei.zzb);
                                                    } else {
                                                        zzfnVar.add(zzei.zzj(bArr, iZzi10, i61));
                                                        iZzi10 += i61;
                                                    }
                                                }
                                            }
                                            unsafe3 = unsafe;
                                            i40 = i29;
                                            this = this;
                                            zzdwVar5 = zzdwVar3;
                                            i39 = i59;
                                            iZzh = iZzi10;
                                            if (iZzh != i38) {
                                                i31 = i31;
                                                i39 = i30;
                                                i3 = i3;
                                                i78 = i40;
                                                i2 = i31;
                                                i77 = i39;
                                                zzgoVar4 = this;
                                                i76 = 0;
                                                unsafe5 = unsafe3;
                                                i79 = i9;
                                                i81 = i10;
                                                i80 = i33;
                                                zzdwVar6 = zzdwVar5;
                                            } else {
                                                i31 = i31;
                                                i39 = i30;
                                                i12 = i40;
                                                i8 = iZzh;
                                                zzdwVar2 = zzdwVar5;
                                                i76 = i39;
                                                zzgoVar = this;
                                                unsafe5 = unsafe3;
                                                i13 = i33;
                                                i4 = i3;
                                            }
                                        } else {
                                            unsafe3 = unsafe;
                                            i40 = i29;
                                            zzdwVar5 = zzdwVar3;
                                            i39 = i59;
                                            iZzh = i38;
                                            if (iZzh != i38) {
                                                i31 = i31;
                                                i39 = i30;
                                                i3 = i3;
                                                i78 = i40;
                                                i2 = i31;
                                                i77 = i39;
                                                zzgoVar4 = this;
                                                i76 = 0;
                                                unsafe5 = unsafe3;
                                                i79 = i9;
                                                i81 = i10;
                                                i80 = i33;
                                                zzdwVar6 = zzdwVar5;
                                            } else {
                                                i31 = i31;
                                                i39 = i30;
                                                i12 = i40;
                                                i8 = iZzh;
                                                zzdwVar2 = zzdwVar5;
                                                i76 = i39;
                                                zzgoVar = this;
                                                unsafe5 = unsafe3;
                                                i13 = i33;
                                                i4 = i3;
                                            }
                                        }
                                        break;
                                    case 30:
                                    case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                                        if (i15 == 2) {
                                            iZzk = zzdx.zzf(bArr, i38, zzfnVar, zzdwVar3);
                                        } else if (i15 == 0) {
                                            i31 = i31;
                                            unsafe3 = unsafe;
                                            i33 = i33;
                                            i40 = i29;
                                            this = this;
                                            i38 = i38;
                                            zzdwVar5 = zzdwVar3;
                                            i39 = i30;
                                            iZzh = i38;
                                            if (iZzh != i38) {
                                                i31 = i31;
                                                i39 = i30;
                                                i3 = i3;
                                                i78 = i40;
                                                i2 = i31;
                                                i77 = i39;
                                                zzgoVar4 = this;
                                                i76 = 0;
                                                unsafe5 = unsafe3;
                                                i79 = i9;
                                                i81 = i10;
                                                i80 = i33;
                                                zzdwVar6 = zzdwVar5;
                                            } else {
                                                i31 = i31;
                                                i39 = i30;
                                                i12 = i40;
                                                i8 = iZzh;
                                                zzdwVar2 = zzdwVar5;
                                                i76 = i39;
                                                zzgoVar = this;
                                                unsafe5 = unsafe3;
                                                i13 = i33;
                                                i4 = i3;
                                            }
                                        } else {
                                            iZzk = zzdx.zzk(i29, bArr, i38, i2, zzfnVar, zzdwVar);
                                        }
                                        zzflVarZzu = zzgoVar4.zzu(i30);
                                        zzhhVar = zzgoVar4.zzl;
                                        int i109 = zzgx.zza;
                                        if (zzflVarZzu != null) {
                                            i62 = iZzk;
                                            unsafe3 = unsafe;
                                        } else if (zzfnVar instanceof RandomAccess) {
                                            size2 = zzfnVar.size();
                                            i62 = iZzk;
                                            unsafe3 = unsafe;
                                            objZzn2 = null;
                                            i63 = 0;
                                            while (i64 < size2) {
                                                iIntValue2 = ((Integer) zzfnVar.get(i64)).intValue();
                                                if (zzflVarZzu.zza(iIntValue2)) {
                                                    if (i64 != i63) {
                                                        zzfnVar.set(i63, Integer.valueOf(iIntValue2));
                                                    }
                                                    i63++;
                                                } else {
                                                    objZzn2 = zzgx.zzn(obj3, i33, iIntValue2, objZzn2, zzhhVar);
                                                }
                                            }
                                            if (i63 != size2) {
                                                zzfnVar.subList(i63, size2).clear();
                                            }
                                        } else {
                                            i62 = iZzk;
                                            unsafe3 = unsafe;
                                            it = zzfnVar.iterator();
                                            objZzn = null;
                                            while (it.hasNext()) {
                                                iIntValue = ((Integer) it.next()).intValue();
                                                if (!zzflVarZzu.zza(iIntValue)) {
                                                    objZzn = zzgx.zzn(obj3, i33, iIntValue, objZzn, zzhhVar);
                                                    it.remove();
                                                }
                                            }
                                        }
                                        i33 = i33;
                                        i40 = i29;
                                        this = this;
                                        i38 = i38;
                                        zzdwVar5 = zzdwVar3;
                                        i39 = i30;
                                        iZzh = i62;
                                        if (iZzh != i38) {
                                            i31 = i31;
                                            i39 = i30;
                                            i3 = i3;
                                            i78 = i40;
                                            i2 = i31;
                                            i77 = i39;
                                            zzgoVar4 = this;
                                            i76 = 0;
                                            unsafe5 = unsafe3;
                                            i79 = i9;
                                            i81 = i10;
                                            i80 = i33;
                                            zzdwVar6 = zzdwVar5;
                                        } else {
                                            i31 = i31;
                                            i39 = i30;
                                            i12 = i40;
                                            i8 = iZzh;
                                            zzdwVar2 = zzdwVar5;
                                            i76 = i39;
                                            zzgoVar = this;
                                            unsafe5 = unsafe3;
                                            i13 = i33;
                                            i4 = i3;
                                        }
                                        break;
                                    case 33:
                                    case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                                        i65 = i29;
                                        if (i15 == 2) {
                                            int i1010 = zzdx.zza;
                                            zzfjVar4 = (zzfj) zzfnVar;
                                            iZzi10 = zzdx.zzi(bArr, i38, zzdwVar3);
                                            i66 = zzdwVar3.zza + iZzi10;
                                            while (iZzi10 < i66) {
                                                iZzi10 = zzdx.zzi(bArr, iZzi10, zzdwVar3);
                                                zzfjVar4.zzg(zzel.zzb(zzdwVar3.zza));
                                            }
                                            if (iZzi10 != i66) {
                                                throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        } else if (i15 == 0) {
                                            i31 = i31;
                                            unsafe3 = unsafe;
                                            i33 = i33;
                                            i39 = i30;
                                            this = zzgoVar4;
                                            i40 = i65;
                                            i38 = i38;
                                            zzdwVar5 = zzdwVar3;
                                            iZzh = i38;
                                            if (iZzh != i38) {
                                                i31 = i31;
                                                i39 = i30;
                                                i3 = i3;
                                                i78 = i40;
                                                i2 = i31;
                                                i77 = i39;
                                                zzgoVar4 = this;
                                                i76 = 0;
                                                unsafe5 = unsafe3;
                                                i79 = i9;
                                                i81 = i10;
                                                i80 = i33;
                                                zzdwVar6 = zzdwVar5;
                                            } else {
                                                i31 = i31;
                                                i39 = i30;
                                                i12 = i40;
                                                i8 = iZzh;
                                                zzdwVar2 = zzdwVar5;
                                                i76 = i39;
                                                zzgoVar = this;
                                                unsafe5 = unsafe3;
                                                i13 = i33;
                                                i4 = i3;
                                            }
                                            break;
                                        } else {
                                            int i1011 = zzdx.zza;
                                            zzfjVar3 = (zzfj) zzfnVar;
                                            iZzi10 = zzdx.zzi(bArr, i38, zzdwVar3);
                                            zzfjVar3.zzg(zzel.zzb(zzdwVar3.zza));
                                            while (iZzi10 < i31) {
                                                iZzi12 = zzdx.zzi(bArr, iZzi10, zzdwVar3);
                                                if (i65 == zzdwVar3.zza) {
                                                    iZzi10 = zzdx.zzi(bArr, iZzi12, zzdwVar3);
                                                    zzfjVar3.zzg(zzel.zzb(zzdwVar3.zza));
                                                }
                                            }
                                        }
                                        i31 = i31;
                                        unsafe3 = unsafe;
                                        i39 = i30;
                                        this = zzgoVar4;
                                        i40 = i65;
                                        zzdwVar5 = zzdwVar3;
                                        iZzh = iZzi10;
                                        if (iZzh != i38) {
                                            i31 = i31;
                                            i39 = i30;
                                            i3 = i3;
                                            i78 = i40;
                                            i2 = i31;
                                            i77 = i39;
                                            zzgoVar4 = this;
                                            i76 = 0;
                                            unsafe5 = unsafe3;
                                            i79 = i9;
                                            i81 = i10;
                                            i80 = i33;
                                            zzdwVar6 = zzdwVar5;
                                        } else {
                                            i31 = i31;
                                            i39 = i30;
                                            i12 = i40;
                                            i8 = iZzh;
                                            zzdwVar2 = zzdwVar5;
                                            i76 = i39;
                                            zzgoVar = this;
                                            unsafe5 = unsafe3;
                                            i13 = i33;
                                            i4 = i3;
                                        }
                                        break;
                                    case MotionEventCompat.AXIS_GENERIC_3 /* 34 */:
                                    case 48:
                                        if (i15 == 2) {
                                            int i1012 = zzdx.zza;
                                            zzgaVar6 = (zzga) zzfnVar;
                                            iZzi14 = zzdx.zzi(bArr, i38, zzdwVar3);
                                            i67 = zzdwVar3.zza + iZzi14;
                                            while (iZzi14 < i67) {
                                                iZzi14 = zzdx.zzl(bArr, iZzi14, zzdwVar3);
                                                zzgaVar6.zzf(zzel.zzc(zzdwVar3.zzb));
                                            }
                                            if (iZzi14 == i67) {
                                                throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            i31 = i31;
                                            i38 = i38;
                                            i33 = i33;
                                            this = zzgoVar4;
                                            zzdwVar5 = zzdwVar3;
                                            iZzh = iZzi14;
                                            i40 = i29;
                                            unsafe3 = unsafe;
                                        } else if (i15 == 0) {
                                            int i1013 = zzdx.zza;
                                            zzgaVar5 = (zzga) zzfnVar;
                                            iZzi10 = zzdx.zzl(bArr, i38, zzdwVar3);
                                            zzgaVar5.zzf(zzel.zzc(zzdwVar3.zzb));
                                            while (true) {
                                                if (iZzi10 < i31) {
                                                    iZzi13 = zzdx.zzi(bArr, iZzi10, zzdwVar3);
                                                    i65 = i29;
                                                    if (i65 == zzdwVar3.zza) {
                                                        iZzi10 = zzdx.zzl(bArr, iZzi13, zzdwVar3);
                                                        zzgaVar5.zzf(zzel.zzc(zzdwVar3.zzb));
                                                        i29 = i65;
                                                    }
                                                } else {
                                                    i65 = i29;
                                                }
                                            }
                                            i31 = i31;
                                            unsafe3 = unsafe;
                                            i39 = i30;
                                            this = zzgoVar4;
                                            i40 = i65;
                                            zzdwVar5 = zzdwVar3;
                                            iZzh = iZzi10;
                                        } else {
                                            i31 = i31;
                                            i38 = i38;
                                            i33 = i33;
                                            i39 = i30;
                                            this = zzgoVar4;
                                            zzdwVar5 = zzdwVar3;
                                            i40 = i29;
                                            unsafe3 = unsafe;
                                            iZzh = i38;
                                        }
                                        if (iZzh != i38) {
                                            i31 = i31;
                                            i39 = i30;
                                            i3 = i3;
                                            i78 = i40;
                                            i2 = i31;
                                            i77 = i39;
                                            zzgoVar4 = this;
                                            i76 = 0;
                                            unsafe5 = unsafe3;
                                            i79 = i9;
                                            i81 = i10;
                                            i80 = i33;
                                            zzdwVar6 = zzdwVar5;
                                        } else {
                                            i31 = i31;
                                            i39 = i30;
                                            i12 = i40;
                                            i8 = iZzh;
                                            zzdwVar2 = zzdwVar5;
                                            i76 = i39;
                                            zzgoVar = this;
                                            unsafe5 = unsafe3;
                                            i13 = i33;
                                            i4 = i3;
                                        }
                                        break;
                                    default:
                                        i31 = i31;
                                        i38 = i38;
                                        i39 = i30;
                                        zzdwVar5 = zzdwVar3;
                                        zzgoVar3 = zzgoVar4;
                                        i40 = i29;
                                        unsafe3 = unsafe;
                                        if (i15 == 3) {
                                            i68 = (i40 & (-8)) | 4;
                                            zzgvVarZzv = zzgoVar3.zzv(i39);
                                            i33 = i33;
                                            this = zzgoVar3;
                                            iZzh = zzdx.zzc(zzgvVarZzv, bArr, i38, i2, i68, zzdwVar);
                                            zzfnVar.add(zzdwVar5.zzc);
                                            while (iZzh < i31) {
                                                iZzi15 = zzdx.zzi(bArr, iZzh, zzdwVar5);
                                                if (i40 == zzdwVar5.zza) {
                                                    iZzh = zzdx.zzc(zzgvVarZzv, bArr, iZzi15, i2, i68, zzdwVar);
                                                    zzfnVar.add(zzdwVar5.zzc);
                                                }
                                            }
                                        } else {
                                            i33 = i33;
                                            this = zzgoVar3;
                                            iZzh = i38;
                                        }
                                        if (iZzh != i38) {
                                            i31 = i31;
                                            i39 = i30;
                                            i3 = i3;
                                            i78 = i40;
                                            i2 = i31;
                                            i77 = i39;
                                            zzgoVar4 = this;
                                            i76 = 0;
                                            unsafe5 = unsafe3;
                                            i79 = i9;
                                            i81 = i10;
                                            i80 = i33;
                                            zzdwVar6 = zzdwVar5;
                                        } else {
                                            i31 = i31;
                                            i39 = i30;
                                            i12 = i40;
                                            i8 = iZzh;
                                            zzdwVar2 = zzdwVar5;
                                            i76 = i39;
                                            zzgoVar = this;
                                            unsafe5 = unsafe3;
                                            i13 = i33;
                                            i4 = i3;
                                        }
                                        break;
                                }
                            } else {
                                zzgoVar2 = zzgoVar4;
                                i35 = i29;
                                zzdwVar4 = zzdwVar3;
                                i36 = i38;
                                i34 = i33;
                                if (iZzr == 50) {
                                    j3 = iArr[i30 + 2] & 1048575;
                                    switch (iZzr) {
                                        case 51:
                                            i69 = i35;
                                            i70 = i30;
                                            zzgoVar = zzgoVar2;
                                            unsafe5 = unsafe;
                                            i13 = i34;
                                            obj3 = obj;
                                            zzdwVar2 = zzdwVar4;
                                            if (i15 == 1) {
                                                iZzl = i36 + 8;
                                                unsafe5.putObject(obj3, j, Double.valueOf(Double.longBitsToDouble(zzdx.zzo(bArr, i36))));
                                                unsafe5.putInt(obj3, j3, i13);
                                            } else {
                                                iZzl = i36;
                                            }
                                            if (iZzl != i36) {
                                                i36 = i36;
                                                i2 = i2;
                                                i3 = i3;
                                                iZzh = iZzl;
                                                zzdwVar6 = zzdwVar2;
                                                i76 = 0;
                                                i78 = i69;
                                                i79 = i9;
                                                i81 = i10;
                                                i77 = i70;
                                                i80 = i13;
                                                zzgoVar4 = zzgoVar;
                                            } else {
                                                i36 = i36;
                                                i4 = i3;
                                                i8 = iZzl;
                                                i12 = i69;
                                                i76 = i70;
                                            }
                                            break;
                                        case 52:
                                            i69 = i35;
                                            i70 = i30;
                                            zzgoVar = zzgoVar2;
                                            unsafe5 = unsafe;
                                            i13 = i34;
                                            obj3 = obj;
                                            zzdwVar2 = zzdwVar4;
                                            if (i15 == 5) {
                                                iZzl = i36 + 4;
                                                unsafe5.putObject(obj3, j, Float.valueOf(Float.intBitsToFloat(zzdx.zzb(bArr, i36))));
                                                unsafe5.putInt(obj3, j3, i13);
                                            } else {
                                                iZzl = i36;
                                            }
                                            if (iZzl != i36) {
                                                i36 = i36;
                                                i2 = i2;
                                                i3 = i3;
                                                iZzh = iZzl;
                                                zzdwVar6 = zzdwVar2;
                                                i76 = 0;
                                                i78 = i69;
                                                i79 = i9;
                                                i81 = i10;
                                                i77 = i70;
                                                i80 = i13;
                                                zzgoVar4 = zzgoVar;
                                            } else {
                                                i36 = i36;
                                                i4 = i3;
                                                i8 = iZzl;
                                                i12 = i69;
                                                i76 = i70;
                                            }
                                            break;
                                        case 53:
                                        case 54:
                                            i69 = i35;
                                            i70 = i30;
                                            zzgoVar = zzgoVar2;
                                            unsafe5 = unsafe;
                                            i13 = i34;
                                            obj3 = obj;
                                            zzdwVar2 = zzdwVar4;
                                            if (i15 == 0) {
                                                iZzl = zzdx.zzl(bArr, i36, zzdwVar2);
                                                unsafe5.putObject(obj3, j, Long.valueOf(zzdwVar2.zzb));
                                                unsafe5.putInt(obj3, j3, i13);
                                            } else {
                                                iZzl = i36;
                                            }
                                            if (iZzl != i36) {
                                                i36 = i36;
                                                i2 = i2;
                                                i3 = i3;
                                                iZzh = iZzl;
                                                zzdwVar6 = zzdwVar2;
                                                i76 = 0;
                                                i78 = i69;
                                                i79 = i9;
                                                i81 = i10;
                                                i77 = i70;
                                                i80 = i13;
                                                zzgoVar4 = zzgoVar;
                                            } else {
                                                i36 = i36;
                                                i4 = i3;
                                                i8 = iZzl;
                                                i12 = i69;
                                                i76 = i70;
                                            }
                                            break;
                                        case 55:
                                        case 62:
                                            i69 = i35;
                                            i70 = i30;
                                            zzgoVar = zzgoVar2;
                                            unsafe5 = unsafe;
                                            i13 = i34;
                                            obj3 = obj;
                                            zzdwVar2 = zzdwVar4;
                                            if (i15 == 0) {
                                                iZzl = zzdx.zzi(bArr, i36, zzdwVar2);
                                                unsafe5.putObject(obj3, j, Integer.valueOf(zzdwVar2.zza));
                                                unsafe5.putInt(obj3, j3, i13);
                                            } else {
                                                iZzl = i36;
                                            }
                                            if (iZzl != i36) {
                                                i36 = i36;
                                                i2 = i2;
                                                i3 = i3;
                                                iZzh = iZzl;
                                                zzdwVar6 = zzdwVar2;
                                                i76 = 0;
                                                i78 = i69;
                                                i79 = i9;
                                                i81 = i10;
                                                i77 = i70;
                                                i80 = i13;
                                                zzgoVar4 = zzgoVar;
                                            } else {
                                                i36 = i36;
                                                i4 = i3;
                                                i8 = iZzl;
                                                i12 = i69;
                                                i76 = i70;
                                            }
                                            break;
                                        case 56:
                                        case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                                            i69 = i35;
                                            i70 = i30;
                                            zzgoVar = zzgoVar2;
                                            unsafe5 = unsafe;
                                            i13 = i34;
                                            obj3 = obj;
                                            zzdwVar2 = zzdwVar4;
                                            if (i15 == 1) {
                                                iZzl = i36 + 8;
                                                unsafe5.putObject(obj3, j, Long.valueOf(zzdx.zzo(bArr, i36)));
                                                unsafe5.putInt(obj3, j3, i13);
                                            } else {
                                                iZzl = i36;
                                            }
                                            if (iZzl != i36) {
                                                i36 = i36;
                                                i2 = i2;
                                                i3 = i3;
                                                iZzh = iZzl;
                                                zzdwVar6 = zzdwVar2;
                                                i76 = 0;
                                                i78 = i69;
                                                i79 = i9;
                                                i81 = i10;
                                                i77 = i70;
                                                i80 = i13;
                                                zzgoVar4 = zzgoVar;
                                            } else {
                                                i36 = i36;
                                                i4 = i3;
                                                i8 = iZzl;
                                                i12 = i69;
                                                i76 = i70;
                                            }
                                            break;
                                        case 57:
                                        case 64:
                                            i69 = i35;
                                            i70 = i30;
                                            zzgoVar = zzgoVar2;
                                            unsafe5 = unsafe;
                                            i13 = i34;
                                            obj3 = obj;
                                            zzdwVar2 = zzdwVar4;
                                            if (i15 == 5) {
                                                iZzl = i36 + 4;
                                                unsafe5.putObject(obj3, j, Integer.valueOf(zzdx.zzb(bArr, i36)));
                                                unsafe5.putInt(obj3, j3, i13);
                                            } else {
                                                iZzl = i36;
                                            }
                                            if (iZzl != i36) {
                                                i36 = i36;
                                                i2 = i2;
                                                i3 = i3;
                                                iZzh = iZzl;
                                                zzdwVar6 = zzdwVar2;
                                                i76 = 0;
                                                i78 = i69;
                                                i79 = i9;
                                                i81 = i10;
                                                i77 = i70;
                                                i80 = i13;
                                                zzgoVar4 = zzgoVar;
                                            } else {
                                                i36 = i36;
                                                i4 = i3;
                                                i8 = iZzl;
                                                i12 = i69;
                                                i76 = i70;
                                            }
                                            break;
                                        case 58:
                                            i69 = i35;
                                            i70 = i30;
                                            zzgoVar = zzgoVar2;
                                            unsafe5 = unsafe;
                                            i13 = i34;
                                            obj3 = obj;
                                            zzdwVar2 = zzdwVar4;
                                            if (i15 == 0) {
                                                iZzl = zzdx.zzl(bArr, i36, zzdwVar2);
                                                if (zzdwVar2.zzb != 0) {
                                                    z5 = true;
                                                } else {
                                                    z5 = false;
                                                }
                                                unsafe5.putObject(obj3, j, Boolean.valueOf(z5));
                                                unsafe5.putInt(obj3, j3, i13);
                                            } else {
                                                iZzl = i36;
                                            }
                                            if (iZzl != i36) {
                                                i36 = i36;
                                                i2 = i2;
                                                i3 = i3;
                                                iZzh = iZzl;
                                                zzdwVar6 = zzdwVar2;
                                                i76 = 0;
                                                i78 = i69;
                                                i79 = i9;
                                                i81 = i10;
                                                i77 = i70;
                                                i80 = i13;
                                                zzgoVar4 = zzgoVar;
                                            } else {
                                                i36 = i36;
                                                i4 = i3;
                                                i8 = iZzl;
                                                i12 = i69;
                                                i76 = i70;
                                            }
                                            break;
                                        case 59:
                                            i69 = i35;
                                            i70 = i30;
                                            zzgoVar = zzgoVar2;
                                            unsafe5 = unsafe;
                                            i13 = i34;
                                            obj3 = obj;
                                            zzdwVar2 = zzdwVar4;
                                            if (i15 == 2) {
                                                iZzl = zzdx.zzi(bArr, i36, zzdwVar2);
                                                i71 = zzdwVar2.zza;
                                                if (i71 == 0) {
                                                    unsafe5.putObject(obj3, j, "");
                                                } else {
                                                    i72 = iZzl + i71;
                                                    if ((i16 & 536870912) == 0) {
                                                    }
                                                    unsafe5.putObject(obj3, j, new String(bArr, iZzl, i71, zzfo.zza));
                                                    iZzl = i72;
                                                }
                                                unsafe5.putInt(obj3, j3, i13);
                                            } else {
                                                iZzl = i36;
                                            }
                                            if (iZzl != i36) {
                                                i36 = i36;
                                                i2 = i2;
                                                i3 = i3;
                                                iZzh = iZzl;
                                                zzdwVar6 = zzdwVar2;
                                                i76 = 0;
                                                i78 = i69;
                                                i79 = i9;
                                                i81 = i10;
                                                i77 = i70;
                                                i80 = i13;
                                                zzgoVar4 = zzgoVar;
                                            } else {
                                                i36 = i36;
                                                i4 = i3;
                                                i8 = iZzl;
                                                i12 = i69;
                                                i76 = i70;
                                            }
                                            break;
                                        case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                                            obj3 = obj;
                                            zzgoVar = zzgoVar2;
                                            i13 = i34;
                                            if (i15 == 2) {
                                                Object objZzy3 = zzgoVar.zzy(obj3, i13, i30);
                                                zzgv zzgvVarZzv3 = zzgoVar.zzv(i30);
                                                unsafe5 = unsafe;
                                                int iZzn2 = zzdx.zzn(objZzy3, zzgvVarZzv3, bArr, i36, i2, zzdwVar);
                                                zzgoVar.zzG(obj3, i13, i30, objZzy3);
                                                iZzl = iZzn2;
                                                i69 = i35;
                                                i70 = i30;
                                                zzdwVar2 = zzdwVar4;
                                            } else {
                                                unsafe5 = unsafe;
                                                i70 = i30;
                                                zzdwVar2 = zzdwVar4;
                                                i69 = i35;
                                                iZzl = i36;
                                            }
                                            if (iZzl != i36) {
                                                i36 = i36;
                                                i2 = i2;
                                                i3 = i3;
                                                iZzh = iZzl;
                                                zzdwVar6 = zzdwVar2;
                                                i76 = 0;
                                                i78 = i69;
                                                i79 = i9;
                                                i81 = i10;
                                                i77 = i70;
                                                i80 = i13;
                                                zzgoVar4 = zzgoVar;
                                            } else {
                                                i36 = i36;
                                                i4 = i3;
                                                i8 = iZzl;
                                                i12 = i69;
                                                i76 = i70;
                                            }
                                            break;
                                        case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                                            i73 = i35;
                                            i74 = i30;
                                            zzgoVar = zzgoVar2;
                                            i13 = i34;
                                            unsafe4 = unsafe;
                                            obj3 = obj;
                                            if (i15 == 2) {
                                                iZzl = zzdx.zza(bArr, i36, zzdwVar4);
                                                unsafe4.putObject(obj3, j, zzdwVar4.zzc);
                                                unsafe4.putInt(obj3, j3, i13);
                                                i70 = i74;
                                                unsafe5 = unsafe4;
                                                i69 = i73;
                                                zzdwVar2 = zzdwVar4;
                                                if (iZzl != i36) {
                                                    i36 = i36;
                                                    i2 = i2;
                                                    i3 = i3;
                                                    iZzh = iZzl;
                                                    zzdwVar6 = zzdwVar2;
                                                    i76 = 0;
                                                    i78 = i69;
                                                    i79 = i9;
                                                    i81 = i10;
                                                    i77 = i70;
                                                    i80 = i13;
                                                    zzgoVar4 = zzgoVar;
                                                } else {
                                                    i36 = i36;
                                                    i4 = i3;
                                                    i8 = iZzl;
                                                    i12 = i69;
                                                    i76 = i70;
                                                }
                                            } else {
                                                i70 = i74;
                                                unsafe5 = unsafe4;
                                                i69 = i73;
                                                zzdwVar2 = zzdwVar4;
                                                iZzl = i36;
                                                if (iZzl != i36) {
                                                    i36 = i36;
                                                    i2 = i2;
                                                    i3 = i3;
                                                    iZzh = iZzl;
                                                    zzdwVar6 = zzdwVar2;
                                                    i76 = 0;
                                                    i78 = i69;
                                                    i79 = i9;
                                                    i81 = i10;
                                                    i77 = i70;
                                                    i80 = i13;
                                                    zzgoVar4 = zzgoVar;
                                                } else {
                                                    i36 = i36;
                                                    i4 = i3;
                                                    i8 = iZzl;
                                                    i12 = i69;
                                                    i76 = i70;
                                                }
                                            }
                                            break;
                                        case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                                            i69 = i35;
                                            i74 = i30;
                                            zzgoVar = zzgoVar2;
                                            i13 = i34;
                                            unsafe4 = unsafe;
                                            obj3 = obj;
                                            if (i15 == 0) {
                                                iZzl = zzdx.zzi(bArr, i36, zzdwVar4);
                                                i75 = zzdwVar4.zza;
                                                zzflVarZzu2 = zzgoVar.zzu(i74);
                                                if (zzflVarZzu2 != null) {
                                                    i73 = i69;
                                                    unsafe4.putObject(obj3, j, Integer.valueOf(i75));
                                                    unsafe4.putInt(obj3, j3, i13);
                                                } else {
                                                    i73 = i69;
                                                    unsafe4.putObject(obj3, j, Integer.valueOf(i75));
                                                    unsafe4.putInt(obj3, j3, i13);
                                                }
                                                i70 = i74;
                                                unsafe5 = unsafe4;
                                                i69 = i73;
                                                zzdwVar2 = zzdwVar4;
                                                if (iZzl != i36) {
                                                    i36 = i36;
                                                    i2 = i2;
                                                    i3 = i3;
                                                    iZzh = iZzl;
                                                    zzdwVar6 = zzdwVar2;
                                                    i76 = 0;
                                                    i78 = i69;
                                                    i79 = i9;
                                                    i81 = i10;
                                                    i77 = i70;
                                                    i80 = i13;
                                                    zzgoVar4 = zzgoVar;
                                                } else {
                                                    i36 = i36;
                                                    i4 = i3;
                                                    i8 = iZzl;
                                                    i12 = i69;
                                                    i76 = i70;
                                                }
                                            }
                                            i70 = i74;
                                            unsafe5 = unsafe4;
                                            zzdwVar2 = zzdwVar4;
                                            iZzl = i36;
                                            if (iZzl != i36) {
                                                i36 = i36;
                                                i2 = i2;
                                                i3 = i3;
                                                iZzh = iZzl;
                                                zzdwVar6 = zzdwVar2;
                                                i76 = 0;
                                                i78 = i69;
                                                i79 = i9;
                                                i81 = i10;
                                                i77 = i70;
                                                i80 = i13;
                                                zzgoVar4 = zzgoVar;
                                            } else {
                                                i36 = i36;
                                                i4 = i3;
                                                i8 = iZzl;
                                                i12 = i69;
                                                i76 = i70;
                                            }
                                            break;
                                        case 66:
                                            i69 = i35;
                                            i74 = i30;
                                            zzgoVar = zzgoVar2;
                                            i13 = i34;
                                            unsafe4 = unsafe;
                                            obj3 = obj;
                                            if (i15 == 0) {
                                                iZzl = zzdx.zzi(bArr, i36, zzdwVar4);
                                                unsafe4.putObject(obj3, j, Integer.valueOf(zzel.zzb(zzdwVar4.zza)));
                                                unsafe4.putInt(obj3, j3, i13);
                                                i70 = i74;
                                                unsafe5 = unsafe4;
                                                zzdwVar2 = zzdwVar4;
                                                if (iZzl != i36) {
                                                    i36 = i36;
                                                    i2 = i2;
                                                    i3 = i3;
                                                    iZzh = iZzl;
                                                    zzdwVar6 = zzdwVar2;
                                                    i76 = 0;
                                                    i78 = i69;
                                                    i79 = i9;
                                                    i81 = i10;
                                                    i77 = i70;
                                                    i80 = i13;
                                                    zzgoVar4 = zzgoVar;
                                                } else {
                                                    i36 = i36;
                                                    i4 = i3;
                                                    i8 = iZzl;
                                                    i12 = i69;
                                                    i76 = i70;
                                                }
                                            }
                                            i70 = i74;
                                            unsafe5 = unsafe4;
                                            zzdwVar2 = zzdwVar4;
                                            iZzl = i36;
                                            if (iZzl != i36) {
                                                i36 = i36;
                                                i2 = i2;
                                                i3 = i3;
                                                iZzh = iZzl;
                                                zzdwVar6 = zzdwVar2;
                                                i76 = 0;
                                                i78 = i69;
                                                i79 = i9;
                                                i81 = i10;
                                                i77 = i70;
                                                i80 = i13;
                                                zzgoVar4 = zzgoVar;
                                            } else {
                                                i36 = i36;
                                                i4 = i3;
                                                i8 = iZzl;
                                                i12 = i69;
                                                i76 = i70;
                                            }
                                            break;
                                        case 67:
                                            i69 = i35;
                                            i74 = i30;
                                            zzgoVar = zzgoVar2;
                                            i13 = i34;
                                            unsafe4 = unsafe;
                                            obj3 = obj;
                                            if (i15 == 0) {
                                                iZzl = zzdx.zzl(bArr, i36, zzdwVar4);
                                                unsafe4.putObject(obj3, j, Long.valueOf(zzel.zzc(zzdwVar4.zzb)));
                                                unsafe4.putInt(obj3, j3, i13);
                                                i70 = i74;
                                                unsafe5 = unsafe4;
                                                zzdwVar2 = zzdwVar4;
                                                if (iZzl != i36) {
                                                    i36 = i36;
                                                    i2 = i2;
                                                    i3 = i3;
                                                    iZzh = iZzl;
                                                    zzdwVar6 = zzdwVar2;
                                                    i76 = 0;
                                                    i78 = i69;
                                                    i79 = i9;
                                                    i81 = i10;
                                                    i77 = i70;
                                                    i80 = i13;
                                                    zzgoVar4 = zzgoVar;
                                                } else {
                                                    i36 = i36;
                                                    i4 = i3;
                                                    i8 = iZzl;
                                                    i12 = i69;
                                                    i76 = i70;
                                                }
                                            }
                                            i70 = i74;
                                            unsafe5 = unsafe4;
                                            zzdwVar2 = zzdwVar4;
                                            iZzl = i36;
                                            if (iZzl != i36) {
                                                i36 = i36;
                                                i2 = i2;
                                                i3 = i3;
                                                iZzh = iZzl;
                                                zzdwVar6 = zzdwVar2;
                                                i76 = 0;
                                                i78 = i69;
                                                i79 = i9;
                                                i81 = i10;
                                                i77 = i70;
                                                i80 = i13;
                                                zzgoVar4 = zzgoVar;
                                            } else {
                                                i36 = i36;
                                                i4 = i3;
                                                i8 = iZzl;
                                                i12 = i69;
                                                i76 = i70;
                                            }
                                            break;
                                        case 68:
                                            if (i15 == 3) {
                                                int i1014 = (i35 & (-8)) | 4;
                                                obj3 = obj;
                                                Object objZzy4 = zzgoVar2.zzy(obj3, i34, i30);
                                                i69 = i35;
                                                i13 = i34;
                                                int iZzm4 = zzdx.zzm(objZzy4, zzgoVar2.zzv(i30), bArr, i36, i2, i1014, zzdwVar);
                                                zzgoVar2.zzG(obj3, i13, i30, objZzy4);
                                                i70 = i30;
                                                unsafe5 = unsafe;
                                                zzdwVar2 = zzdwVar4;
                                                zzgoVar = zzgoVar2;
                                                iZzl = iZzm4;
                                            } else {
                                                obj3 = obj;
                                                i69 = i35;
                                                i13 = i34;
                                                zzdwVar2 = zzdwVar4;
                                                i70 = i30;
                                                zzgoVar = zzgoVar2;
                                                unsafe5 = unsafe;
                                                iZzl = i36;
                                            }
                                            if (iZzl != i36) {
                                                i36 = i36;
                                                i2 = i2;
                                                i3 = i3;
                                                iZzh = iZzl;
                                                zzdwVar6 = zzdwVar2;
                                                i76 = 0;
                                                i78 = i69;
                                                i79 = i9;
                                                i81 = i10;
                                                i77 = i70;
                                                i80 = i13;
                                                zzgoVar4 = zzgoVar;
                                            } else {
                                                i36 = i36;
                                                i4 = i3;
                                                i8 = iZzl;
                                                i12 = i69;
                                                i76 = i70;
                                            }
                                            break;
                                        default:
                                            obj3 = obj;
                                            i69 = i35;
                                            zzdwVar2 = zzdwVar4;
                                            i70 = i30;
                                            zzgoVar = zzgoVar2;
                                            unsafe5 = unsafe;
                                            i13 = i34;
                                            iZzl = i36;
                                            if (iZzl != i36) {
                                                i36 = i36;
                                                i2 = i2;
                                                i3 = i3;
                                                iZzh = iZzl;
                                                zzdwVar6 = zzdwVar2;
                                                i76 = 0;
                                                i78 = i69;
                                                i79 = i9;
                                                i81 = i10;
                                                i77 = i70;
                                                i80 = i13;
                                                zzgoVar4 = zzgoVar;
                                            } else {
                                                i36 = i36;
                                                i4 = i3;
                                                i8 = iZzl;
                                                i12 = i69;
                                                i76 = i70;
                                            }
                                            break;
                                    }
                                } else {
                                    if (i15 == 2) {
                                        Object objZzw2 = zzgoVar2.zzw(i30);
                                        object = unsafe.getObject(obj3, j);
                                        if (!((zzgf) object).zze()) {
                                            zzgf zzgfVarZzb2 = zzgf.zza().zzb();
                                            zzgg.zza(zzgfVarZzb2, object);
                                            unsafe.putObject(obj3, j, zzgfVarZzb2);
                                        }
                                        throw null;
                                    }
                                    unsafe2 = unsafe;
                                    i4 = i3;
                                    i8 = i36;
                                    zzdwVar2 = zzdwVar4;
                                    i76 = i30;
                                    i12 = i35;
                                    unsafe5 = unsafe2;
                                    zzgoVar = zzgoVar2;
                                    i13 = i34;
                                }
                            }
                        } else if (i15 == 2) {
                            zzfnVarZzd = (zzfn) unsafe.getObject(obj3, j);
                            if (!zzfnVarZzd.zzc()) {
                                size = zzfnVarZzd.size();
                                if (size == 0) {
                                    i37 = 10;
                                } else {
                                    i37 = size + size;
                                }
                                zzfnVarZzd = zzfnVarZzd.zzd(i37);
                                unsafe.putObject(obj3, j, zzfnVarZzd);
                            }
                            i77 = i30;
                            i3 = i3;
                            zzdwVar6 = zzdwVar3;
                            iZzh = zzdx.zze(zzgoVar4.zzv(i30), i29, bArr, i32, i2, zzfnVarZzd, zzdwVar);
                            i80 = i33;
                            i2 = i31;
                            unsafe5 = unsafe;
                            i76 = 0;
                            i78 = i29;
                            i79 = i9;
                            i81 = i10;
                        } else {
                            unsafe2 = unsafe;
                            i34 = i33;
                            zzgoVar2 = zzgoVar4;
                            i35 = i29;
                            zzdwVar4 = zzdwVar3;
                            i36 = i32;
                            i4 = i3;
                            i8 = i36;
                            zzdwVar2 = zzdwVar4;
                            i76 = i30;
                            i12 = i35;
                            unsafe5 = unsafe2;
                            zzgoVar = zzgoVar2;
                            i13 = i34;
                        }
                    }
                } else {
                    i8 = iZzj;
                    i9 = i79;
                    i10 = i81;
                    i11 = i76;
                    zzdwVar2 = zzdwVar6;
                    i4 = i3;
                    i12 = i5;
                    zzgoVar = zzgoVar4;
                    i13 = i84;
                }
                if (i12 == i4) {
                }
                if (zzgoVar.zzh) {
                    zzeuVar = zzdwVar2.zzd;
                    int i1015 = zzeu.zzb;
                    int i1016 = zzgs.zza;
                    if (zzeuVar != zzeu.zza) {
                        zzglVar = zzgoVar.zzg;
                        int i1017 = zzdx.zza;
                        if (zzeuVar.zzb(zzglVar, i13) == null) {
                            throw null;
                        }
                        i14 = i12;
                        iZzh = zzdx.zzh(i12, bArr, i8, i2, zzd(obj), zzdwVar);
                    } else {
                        i14 = i12;
                        iZzh = zzdx.zzh(i14, bArr, i8, i2, zzd(obj), zzdwVar);
                    }
                } else {
                    i14 = i12;
                    iZzh = zzdx.zzh(i14, bArr, i8, i2, zzd(obj), zzdwVar);
                }
                i2 = i2;
                zzdwVar6 = zzdwVar;
                i80 = i13;
                zzgoVar4 = zzgoVar;
                i77 = i76;
                i78 = i14;
                i76 = i11;
                i79 = i9;
                i81 = i10;
                i3 = i4;
            } else {
                zzgoVar = zzgoVar4;
                i4 = i3;
            }
        }
        if (i81 != 1048575) {
            unsafe5.putInt(obj3, i81, i79);
        }
        for (int i110 = zzgoVar.zzj; i110 < zzgoVar.zzk; i110++) {
            int[] iArr2 = zzgoVar.zzi;
            int[] iArr3 = zzgoVar.zzc;
            int i111 = iArr2[i110];
            int i112 = iArr3[i111];
            Object objZzf = zzho.zzf(obj3, zzgoVar.zzs(i111) & 1048575);
            if (objZzf != null && zzgoVar.zzu(i111) != null) {
                throw null;
            }
        }
        if (i4 == 0) {
            if (iZzh != i2) {
                throw new zzfq("Failed to parse the message.");
            }
        } else if (iZzh > i2 || i78 != i4) {
            throw new zzfq("Failed to parse the message.");
        }
        return iZzh;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final Object zze() {
        return ((zzfi) this.zzg).zzo();
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006f  */
    /* JADX WARN: Code duplicated, block: B:28:0x0075  */
    /* JADX WARN: Code duplicated, block: B:41:0x0082 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final void zzf(Object obj) {
        if (zzL(obj)) {
            if (obj instanceof zzfi) {
                zzfi zzfiVar = (zzfi) obj;
                zzfiVar.zzx(Integer.MAX_VALUE);
                zzfiVar.zza = 0;
                zzfiVar.zzv();
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
                                ((zzfn) zzho.zzf(obj, j)).zzb();
                                break;
                            case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH /* 50 */:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzgf) object).zzc();
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
            this.zzl.zzb(obj);
            if (this.zzh) {
                this.zzm.zza(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final void zzg(Object obj, Object obj2) {
        zzA(obj);
        obj2.getClass();
        int i = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i >= iArr.length) {
                zzgx.zzp(this.zzl, obj, obj2);
                if (this.zzh) {
                    zzgx.zzo(this.zzm, obj, obj2);
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
                        zzho.zzo(obj, j, zzho.zza(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 1:
                    if (zzI(obj2, i)) {
                        zzho.zzp(obj, j, zzho.zzb(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 2:
                    if (zzI(obj2, i)) {
                        zzho.zzr(obj, j, zzho.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 3:
                    if (zzI(obj2, i)) {
                        zzho.zzr(obj, j, zzho.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 4:
                    if (zzI(obj2, i)) {
                        zzho.zzq(obj, j, zzho.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 5:
                    if (zzI(obj2, i)) {
                        zzho.zzr(obj, j, zzho.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 6:
                    if (zzI(obj2, i)) {
                        zzho.zzq(obj, j, zzho.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 7:
                    if (zzI(obj2, i)) {
                        zzho.zzm(obj, j, zzho.zzw(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 8:
                    if (zzI(obj2, i)) {
                        zzho.zzs(obj, j, zzho.zzf(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 9:
                    zzB(obj, obj2, i);
                    break;
                case 10:
                    if (zzI(obj2, i)) {
                        zzho.zzs(obj, j, zzho.zzf(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 11:
                    if (zzI(obj2, i)) {
                        zzho.zzq(obj, j, zzho.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 12:
                    if (zzI(obj2, i)) {
                        zzho.zzq(obj, j, zzho.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 13:
                    if (zzI(obj2, i)) {
                        zzho.zzq(obj, j, zzho.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 14:
                    if (zzI(obj2, i)) {
                        zzho.zzr(obj, j, zzho.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 15:
                    if (zzI(obj2, i)) {
                        zzho.zzq(obj, j, zzho.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 16:
                    if (zzI(obj2, i)) {
                        zzho.zzr(obj, j, zzho.zzd(obj2, j));
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
                    zzfn zzfnVarZzd = (zzfn) zzho.zzf(obj, j);
                    zzfn zzfnVar = (zzfn) zzho.zzf(obj2, j);
                    int size = zzfnVarZzd.size();
                    int size2 = zzfnVar.size();
                    if (size > 0 && size2 > 0) {
                        if (!zzfnVarZzd.zzc()) {
                            zzfnVarZzd = zzfnVarZzd.zzd(size2 + size);
                        }
                        zzfnVarZzd.addAll(zzfnVar);
                    }
                    if (size > 0) {
                        zzfnVar = zzfnVarZzd;
                    }
                    zzho.zzs(obj, j, zzfnVar);
                    break;
                case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH /* 50 */:
                    int i4 = zzgx.zza;
                    zzho.zzs(obj, j, zzgg.zza(zzho.zzf(obj, j), zzho.zzf(obj2, j)));
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
                        zzho.zzs(obj, j, zzho.zzf(obj2, j));
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
                        zzho.zzs(obj, j, zzho.zzf(obj2, j));
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

    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzdw zzdwVar) throws IOException {
        zzc(obj, bArr, i, i2, 0, zzdwVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0023  */
    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final void zzi(Object obj, zzhu zzhuVar) throws IOException {
        Map.Entry entry;
        int i;
        int i2;
        int i3;
        int[] iArr;
        if (this.zzh) {
            zzez zzezVar = ((zzff) obj).zzb;
            if (zzezVar.zza.isEmpty()) {
                entry = null;
            } else {
                entry = (Map.Entry) zzezVar.zzf().next();
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
                        zzhuVar.zzf(i8, zzho.zza(obj, j));
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
                        zzhuVar.zzo(i8, zzho.zzb(obj, j));
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
                        zzhuVar.zzt(i8, unsafe.getLong(obj, j));
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
                        zzhuVar.zzK(i8, unsafe.getLong(obj, j));
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
                        zzhuVar.zzr(i8, unsafe.getInt(obj, j));
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
                        zzhuVar.zzm(i8, unsafe.getLong(obj, j));
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
                        zzhuVar.zzk(i8, unsafe.getInt(obj, j));
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
                        zzhuVar.zzb(i8, zzho.zzw(obj, j));
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
                        zzO(i8, unsafe.getObject(obj, j), zzhuVar);
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
                        zzhuVar.zzv(i8, unsafe.getObject(obj, j), zzv(i7));
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
                        zzhuVar.zzd(i8, (zzei) unsafe.getObject(obj, j));
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
                        zzhuVar.zzI(i8, unsafe.getInt(obj, j));
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
                        zzhuVar.zzi(i8, unsafe.getInt(obj, j));
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
                        zzhuVar.zzx(i8, unsafe.getInt(obj, j));
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
                        zzhuVar.zzz(i8, unsafe.getLong(obj, j));
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
                        zzhuVar.zzB(i8, unsafe.getInt(obj, j));
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
                        zzhuVar.zzD(i8, unsafe.getLong(obj, j));
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
                        zzhuVar.zzq(i8, unsafe.getObject(obj, j), zzv(i7));
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
                    zzgx.zzr(iArr2[i7], (List) unsafe.getObject(obj, j), zzhuVar, false);
                    break;
                case 19:
                    zzgx.zzv(iArr2[i7], (List) unsafe.getObject(obj, j), zzhuVar, false);
                    break;
                case 20:
                    zzgx.zzx(iArr2[i7], (List) unsafe.getObject(obj, j), zzhuVar, false);
                    break;
                case 21:
                    zzgx.zzD(iArr2[i7], (List) unsafe.getObject(obj, j), zzhuVar, false);
                    break;
                case 22:
                    zzgx.zzw(iArr2[i7], (List) unsafe.getObject(obj, j), zzhuVar, false);
                    break;
                case 23:
                    zzgx.zzu(iArr2[i7], (List) unsafe.getObject(obj, j), zzhuVar, false);
                    break;
                case 24:
                    zzgx.zzt(iArr2[i7], (List) unsafe.getObject(obj, j), zzhuVar, false);
                    break;
                case 25:
                    zzgx.zzq(iArr2[i7], (List) unsafe.getObject(obj, j), zzhuVar, false);
                    break;
                case 26:
                    int i11 = iArr2[i7];
                    List list = (List) unsafe.getObject(obj, j);
                    int i12 = zzgx.zza;
                    if (list != null && !list.isEmpty()) {
                        zzhuVar.zzH(i11, list);
                    }
                    break;
                case MotionEventCompat.AXIS_RELATIVE_X /* 27 */:
                    int i13 = iArr2[i7];
                    List list2 = (List) unsafe.getObject(obj, j);
                    zzgv zzgvVarZzv = zzv(i7);
                    int i14 = zzgx.zza;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i15 = 0; i15 < list2.size(); i15++) {
                            ((zzeq) zzhuVar).zzv(i13, list2.get(i15), zzgvVarZzv);
                        }
                    }
                    break;
                case MotionEventCompat.AXIS_RELATIVE_Y /* 28 */:
                    int i16 = iArr2[i7];
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i17 = zzgx.zza;
                    if (list3 != null && !list3.isEmpty()) {
                        zzhuVar.zze(i16, list3);
                    }
                    break;
                case 29:
                    zzgx.zzC(iArr2[i7], (List) unsafe.getObject(obj, j), zzhuVar, false);
                    break;
                case 30:
                    zzgx.zzs(iArr2[i7], (List) unsafe.getObject(obj, j), zzhuVar, false);
                    break;
                case 31:
                    zzgx.zzy(iArr2[i7], (List) unsafe.getObject(obj, j), zzhuVar, false);
                    break;
                case 32:
                    zzgx.zzz(iArr2[i7], (List) unsafe.getObject(obj, j), zzhuVar, false);
                    break;
                case 33:
                    zzgx.zzA(iArr2[i7], (List) unsafe.getObject(obj, j), zzhuVar, false);
                    break;
                case MotionEventCompat.AXIS_GENERIC_3 /* 34 */:
                    zzgx.zzB(iArr2[i7], (List) unsafe.getObject(obj, j), zzhuVar, false);
                    break;
                case MotionEventCompat.AXIS_GENERIC_4 /* 35 */:
                    zzgx.zzr(iArr2[i7], (List) unsafe.getObject(obj, j), zzhuVar, true);
                    break;
                case 36:
                    zzgx.zzv(iArr2[i7], (List) unsafe.getObject(obj, j), zzhuVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_6 /* 37 */:
                    zzgx.zzx(iArr2[i7], (List) unsafe.getObject(obj, j), zzhuVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                    zzgx.zzD(iArr2[i7], (List) unsafe.getObject(obj, j), zzhuVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_8 /* 39 */:
                    zzgx.zzw(iArr2[i7], (List) unsafe.getObject(obj, j), zzhuVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_9 /* 40 */:
                    zzgx.zzu(iArr2[i7], (List) unsafe.getObject(obj, j), zzhuVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_10 /* 41 */:
                    zzgx.zzt(iArr2[i7], (List) unsafe.getObject(obj, j), zzhuVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                    zzgx.zzq(iArr2[i7], (List) unsafe.getObject(obj, j), zzhuVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                    zzgx.zzC(iArr2[i7], (List) unsafe.getObject(obj, j), zzhuVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                    zzgx.zzs(iArr2[i7], (List) unsafe.getObject(obj, j), zzhuVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                    zzgx.zzy(iArr2[i7], (List) unsafe.getObject(obj, j), zzhuVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                    zzgx.zzz(iArr2[i7], (List) unsafe.getObject(obj, j), zzhuVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                    zzgx.zzA(iArr2[i7], (List) unsafe.getObject(obj, j), zzhuVar, true);
                    break;
                case 48:
                    zzgx.zzB(iArr2[i7], (List) unsafe.getObject(obj, j), zzhuVar, true);
                    break;
                case 49:
                    int i18 = iArr2[i7];
                    List list4 = (List) unsafe.getObject(obj, j);
                    zzgv zzgvVarZzv2 = zzv(i7);
                    int i19 = zzgx.zza;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i20 = 0; i20 < list4.size(); i20++) {
                            ((zzeq) zzhuVar).zzq(i18, list4.get(i20), zzgvVarZzv2);
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
                        zzhuVar.zzf(i8, zzm(obj, j));
                    }
                    break;
                case 52:
                    if (zzM(obj, i8, i7)) {
                        zzhuVar.zzo(i8, zzn(obj, j));
                    }
                    break;
                case 53:
                    if (zzM(obj, i8, i7)) {
                        zzhuVar.zzt(i8, zzt(obj, j));
                    }
                    break;
                case 54:
                    if (zzM(obj, i8, i7)) {
                        zzhuVar.zzK(i8, zzt(obj, j));
                    }
                    break;
                case 55:
                    if (zzM(obj, i8, i7)) {
                        zzhuVar.zzr(i8, zzo(obj, j));
                    }
                    break;
                case 56:
                    if (zzM(obj, i8, i7)) {
                        zzhuVar.zzm(i8, zzt(obj, j));
                    }
                    break;
                case 57:
                    if (zzM(obj, i8, i7)) {
                        zzhuVar.zzk(i8, zzo(obj, j));
                    }
                    break;
                case 58:
                    if (zzM(obj, i8, i7)) {
                        zzhuVar.zzb(i8, zzN(obj, j));
                    }
                    break;
                case 59:
                    if (zzM(obj, i8, i7)) {
                        zzO(i8, unsafe.getObject(obj, j), zzhuVar);
                    }
                    break;
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                    if (zzM(obj, i8, i7)) {
                        zzhuVar.zzv(i8, unsafe.getObject(obj, j), zzv(i7));
                    }
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzM(obj, i8, i7)) {
                        zzhuVar.zzd(i8, (zzei) unsafe.getObject(obj, j));
                    }
                    break;
                case 62:
                    if (zzM(obj, i8, i7)) {
                        zzhuVar.zzI(i8, zzo(obj, j));
                    }
                    break;
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (zzM(obj, i8, i7)) {
                        zzhuVar.zzi(i8, zzo(obj, j));
                    }
                    break;
                case 64:
                    if (zzM(obj, i8, i7)) {
                        zzhuVar.zzx(i8, zzo(obj, j));
                    }
                    break;
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (zzM(obj, i8, i7)) {
                        zzhuVar.zzz(i8, zzt(obj, j));
                    }
                    break;
                case 66:
                    if (zzM(obj, i8, i7)) {
                        zzhuVar.zzB(i8, zzo(obj, j));
                    }
                    break;
                case 67:
                    if (zzM(obj, i8, i7)) {
                        zzhuVar.zzD(i8, zzt(obj, j));
                    }
                    break;
                case 68:
                    if (zzM(obj, i8, i7)) {
                        zzhuVar.zzq(i8, unsafe.getObject(obj, j), zzv(i7));
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
        ((zzfi) obj).zzc.zzl(zzhuVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final boolean zzj(Object obj, Object obj2) {
        boolean zZzE;
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzs = zzs(i);
            long j = iZzs & 1048575;
            switch (zzr(iZzs)) {
                case 0:
                    if (!zzH(obj, obj2, i) || Double.doubleToLongBits(zzho.zza(obj, j)) != Double.doubleToLongBits(zzho.zza(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzH(obj, obj2, i) || Float.floatToIntBits(zzho.zzb(obj, j)) != Float.floatToIntBits(zzho.zzb(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzH(obj, obj2, i) || zzho.zzd(obj, j) != zzho.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzH(obj, obj2, i) || zzho.zzd(obj, j) != zzho.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzH(obj, obj2, i) || zzho.zzc(obj, j) != zzho.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzH(obj, obj2, i) || zzho.zzd(obj, j) != zzho.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzH(obj, obj2, i) || zzho.zzc(obj, j) != zzho.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzH(obj, obj2, i) || zzho.zzw(obj, j) != zzho.zzw(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzH(obj, obj2, i) || !zzgx.zzE(zzho.zzf(obj, j), zzho.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzH(obj, obj2, i) || !zzgx.zzE(zzho.zzf(obj, j), zzho.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzH(obj, obj2, i) || !zzgx.zzE(zzho.zzf(obj, j), zzho.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzH(obj, obj2, i) || zzho.zzc(obj, j) != zzho.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzH(obj, obj2, i) || zzho.zzc(obj, j) != zzho.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzH(obj, obj2, i) || zzho.zzc(obj, j) != zzho.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzH(obj, obj2, i) || zzho.zzd(obj, j) != zzho.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzH(obj, obj2, i) || zzho.zzc(obj, j) != zzho.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzH(obj, obj2, i) || zzho.zzd(obj, j) != zzho.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzH(obj, obj2, i) || !zzgx.zzE(zzho.zzf(obj, j), zzho.zzf(obj2, j))) {
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
                    zZzE = zzgx.zzE(zzho.zzf(obj, j), zzho.zzf(obj2, j));
                    break;
                case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH /* 50 */:
                    zZzE = zzgx.zzE(zzho.zzf(obj, j), zzho.zzf(obj2, j));
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
                    if (zzho.zzc(obj, jZzp) != zzho.zzc(obj2, jZzp) || !zzgx.zzE(zzho.zzf(obj, j), zzho.zzf(obj2, j))) {
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
        if (!((zzfi) obj).zzc.equals(((zzfi) obj2).zzc)) {
            return false;
        }
        if (this.zzh) {
            return ((zzff) obj).zzb.equals(((zzff) obj2).zzb);
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x0099  */
    /* JADX WARN: Code duplicated, block: B:44:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:50:0x00be A[LOOP:1: B:45:0x00ad->B:50:0x00be, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:67:0x00bd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x00db A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final boolean zzk(Object obj) {
        int i;
        int i2;
        List list;
        zzgv zzgvVarZzv;
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
                list = (List) zzho.zzf(obj, iZzs & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzgvVarZzv = zzv(i7);
                    for (i3 = 0; i3 < list.size(); i3++) {
                        if (!zzgvVarZzv.zzk(list.get(i3))) {
                            return false;
                        }
                    }
                }
            } else if (iZzr == 60 || iZzr == 68) {
                if (zzM(obj, i8, i7) && !zzK(obj, iZzs, zzv(i7))) {
                    return false;
                }
            } else if (iZzr == 49) {
                list = (List) zzho.zzf(obj, iZzs & 1048575);
                if (list.isEmpty()) {
                    zzgvVarZzv = zzv(i7);
                    while (i3 < list.size()) {
                        if (!zzgvVarZzv.zzk(list.get(i3))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iZzr == 50 && !((zzgf) zzho.zzf(obj, iZzs & 1048575)).isEmpty()) {
                throw null;
            }
            i5++;
            i6 = i;
            i4 = i2;
        }
        return !this.zzh || ((zzff) obj).zzb.zzi();
    }
}
