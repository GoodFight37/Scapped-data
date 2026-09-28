package com.google.android.recaptcha.internal;

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

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* JADX INFO: loaded from: classes2.dex */
final class zzol<T> implements zzow<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzps.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzoi zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzpl zzm;
    private final zzmp zzn;

    private zzol(int[] iArr, Object[] objArr, int i, int i2, zzoi zzoiVar, boolean z, int[] iArr2, int i3, int i4, zzoo zzooVar, zznv zznvVar, zzpl zzplVar, zzmp zzmpVar, zzod zzodVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzoiVar instanceof zznd;
        boolean z2 = false;
        if (zzmpVar != null && (zzoiVar instanceof zzna)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzj = iArr2;
        this.zzk = i3;
        this.zzl = i4;
        this.zzm = zzplVar;
        this.zzn = zzmpVar;
        this.zzg = zzoiVar;
    }

    private final Object zzA(Object obj, int i) {
        zzow zzowVarZzx = zzx(i);
        int iZzu = zzu(i) & 1048575;
        if (!zzN(obj, i)) {
            return zzowVarZzx.zze();
        }
        Object object = zzb.getObject(obj, iZzu);
        if (zzQ(object)) {
            return object;
        }
        Object objZze = zzowVarZzx.zze();
        if (object != null) {
            zzowVarZzx.zzg(objZze, object);
        }
        return objZze;
    }

    private final Object zzB(Object obj, int i, int i2) {
        zzow zzowVarZzx = zzx(i2);
        if (!zzR(obj, i, i2)) {
            return zzowVarZzx.zze();
        }
        Object object = zzb.getObject(obj, zzu(i2) & 1048575);
        if (zzQ(object)) {
            return object;
        }
        Object objZze = zzowVarZzx.zze();
        if (object != null) {
            zzowVarZzx.zzg(objZze, object);
        }
        return objZze;
    }

    private static Field zzC(Class cls, String str) {
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

    private static void zzD(Object obj) {
        if (!zzQ(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    private final void zzE(Object obj, Object obj2, int i) {
        if (zzN(obj2, i)) {
            int iZzu = zzu(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzu;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzow zzowVarZzx = zzx(i);
            if (!zzN(obj, i)) {
                if (zzQ(object)) {
                    Object objZze = zzowVarZzx.zze();
                    zzowVarZzx.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzH(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzQ(object2)) {
                Object objZze2 = zzowVarZzx.zze();
                zzowVarZzx.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzowVarZzx.zzg(object2, object);
        }
    }

    private final void zzF(Object obj, Object obj2, int i) {
        int i2 = this.zzc[i];
        if (zzR(obj2, i2, i)) {
            int iZzu = zzu(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzu;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzow zzowVarZzx = zzx(i);
            if (!zzR(obj, i2, i)) {
                if (zzQ(object)) {
                    Object objZze = zzowVarZzx.zze();
                    zzowVarZzx.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzI(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzQ(object2)) {
                Object objZze2 = zzowVarZzx.zze();
                zzowVarZzx.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzowVarZzx.zzg(object2, object);
        }
    }

    private final void zzG(Object obj, int i, zzov zzovVar) throws IOException {
        long j = i & 1048575;
        if (zzM(i)) {
            zzps.zzs(obj, j, zzovVar.zzs());
        } else if (this.zzi) {
            zzps.zzs(obj, j, zzovVar.zzr());
        } else {
            zzps.zzs(obj, j, zzovVar.zzp());
        }
    }

    private final void zzH(Object obj, int i) {
        int iZzr = zzr(i);
        long j = 1048575 & iZzr;
        if (j == 1048575) {
            return;
        }
        zzps.zzq(obj, j, (1 << (iZzr >>> 20)) | zzps.zzc(obj, j));
    }

    private final void zzI(Object obj, int i, int i2) {
        zzps.zzq(obj, zzr(i2) & 1048575, i);
    }

    private final void zzJ(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzu(i) & 1048575, obj2);
        zzH(obj, i);
    }

    private final void zzK(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzu(i2) & 1048575, obj2);
        zzI(obj, i, i2);
    }

    private final boolean zzL(Object obj, Object obj2, int i) {
        return zzN(obj, i) == zzN(obj2, i);
    }

    private static boolean zzM(int i) {
        return (i & 536870912) != 0;
    }

    private final boolean zzN(Object obj, int i) {
        int iZzr = zzr(i);
        long j = iZzr & 1048575;
        if (j != 1048575) {
            return (zzps.zzc(obj, j) & (1 << (iZzr >>> 20))) != 0;
        }
        int iZzu = zzu(i);
        long j2 = iZzu & 1048575;
        switch (zzt(iZzu)) {
            case 0:
                return Double.doubleToRawLongBits(zzps.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzps.zzb(obj, j2)) != 0;
            case 2:
                return zzps.zzd(obj, j2) != 0;
            case 3:
                return zzps.zzd(obj, j2) != 0;
            case 4:
                return zzps.zzc(obj, j2) != 0;
            case 5:
                return zzps.zzd(obj, j2) != 0;
            case 6:
                return zzps.zzc(obj, j2) != 0;
            case 7:
                return zzps.zzw(obj, j2);
            case 8:
                Object objZzf = zzps.zzf(obj, j2);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzle) {
                    return !zzle.zzb.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzps.zzf(obj, j2) != null;
            case 10:
                return !zzle.zzb.equals(zzps.zzf(obj, j2));
            case 11:
                return zzps.zzc(obj, j2) != 0;
            case 12:
                return zzps.zzc(obj, j2) != 0;
            case 13:
                return zzps.zzc(obj, j2) != 0;
            case 14:
                return zzps.zzd(obj, j2) != 0;
            case 15:
                return zzps.zzc(obj, j2) != 0;
            case 16:
                return zzps.zzd(obj, j2) != 0;
            case 17:
                return zzps.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzO(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzN(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzP(Object obj, int i, zzow zzowVar) {
        return zzowVar.zzl(zzps.zzf(obj, i & 1048575));
    }

    private static boolean zzQ(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zznd) {
            return ((zznd) obj).zzL();
        }
        return true;
    }

    private final boolean zzR(Object obj, int i, int i2) {
        return zzps.zzc(obj, (long) (zzr(i2) & 1048575)) == i;
    }

    private static boolean zzS(Object obj, long j) {
        return ((Boolean) zzps.zzf(obj, j)).booleanValue();
    }

    private static final void zzT(int i, Object obj, zzpy zzpyVar) throws IOException {
        if (obj instanceof String) {
            zzpyVar.zzG(i, (String) obj);
        } else {
            zzpyVar.zzd(i, (zzle) obj);
        }
    }

    static zzpm zzd(Object obj) {
        zznd zzndVar = (zznd) obj;
        zzpm zzpmVar = zzndVar.zzc;
        if (zzpmVar != zzpm.zzc()) {
            return zzpmVar;
        }
        zzpm zzpmVarZzf = zzpm.zzf();
        zzndVar.zzc = zzpmVarZzf;
        return zzpmVarZzf;
    }

    /* JADX WARN: Code duplicated, block: B:125:0x0265  */
    /* JADX WARN: Code duplicated, block: B:126:0x0268  */
    /* JADX WARN: Code duplicated, block: B:129:0x027f  */
    /* JADX WARN: Code duplicated, block: B:130:0x0282  */
    /* JADX WARN: Code duplicated, block: B:169:0x0345  */
    /* JADX WARN: Code duplicated, block: B:183:0x0391  */
    /* JADX WARN: Code duplicated, block: B:186:0x039a  */
    static zzol zzm(Class cls, zzof zzofVar, zzoo zzooVar, zznv zznvVar, zzpl zzplVar, zzmp zzmpVar, zzod zzodVar) {
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
        Field fieldZzC;
        int i22;
        char cCharAt9;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        Object obj;
        Field fieldZzC2;
        int i28;
        Object obj2;
        Field fieldZzC3;
        int i29;
        char cCharAt10;
        int i30;
        char cCharAt11;
        int i31;
        char cCharAt12;
        int i32;
        char cCharAt13;
        if (!(zzofVar instanceof zzou)) {
            throw null;
        }
        zzou zzouVar = (zzou) zzofVar;
        String strZzd = zzouVar.zzd();
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
        Object[] objArrZze = zzouVar.zze();
        Class<?> cls2 = zzouVar.zza().getClass();
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
                        if (zzouVar.zzc() == 1 || i78 != 0) {
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
                        fieldZzC2 = (Field) obj;
                    } else {
                        fieldZzC2 = zzC(cls2, (String) obj);
                        objArrZze[i27] = fieldZzC2;
                    }
                    int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzC2);
                    i28 = i27 + 1;
                    obj2 = objArrZze[i28];
                    int i88 = i78;
                    if (obj2 instanceof Field) {
                        fieldZzC3 = (Field) obj2;
                    } else {
                        fieldZzC3 = zzC(cls2, (String) obj2);
                        objArrZze[i28] = fieldZzC3;
                    }
                    i18 = i4;
                    i19 = i85;
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzC3);
                    i20 = 0;
                    strZzd = strZzd;
                    zzouVar = zzouVar;
                    iObjectFieldOffset = iObjectFieldOffset3;
                    i21 = i88;
                }
                i4 = i26;
                i27 = iCharAt12 + iCharAt12;
                obj = objArrZze[i27];
                if (obj instanceof Field) {
                    fieldZzC2 = (Field) obj;
                } else {
                    fieldZzC2 = zzC(cls2, (String) obj);
                    objArrZze[i27] = fieldZzC2;
                }
                int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldZzC2);
                i28 = i27 + 1;
                obj2 = objArrZze[i28];
                int i89 = i78;
                if (obj2 instanceof Field) {
                    fieldZzC3 = (Field) obj2;
                } else {
                    fieldZzC3 = zzC(cls2, (String) obj2);
                    objArrZze[i28] = fieldZzC3;
                }
                i18 = i4;
                i19 = i85;
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzC3);
                i20 = 0;
                strZzd = strZzd;
                zzouVar = zzouVar;
                iObjectFieldOffset = iObjectFieldOffset4;
                i21 = i89;
            } else {
                i17 = i2;
                i18 = i4 + 1;
                Field fieldZzC4 = zzC(cls2, (String) objArrZze[i4]);
                if (i76 == 9 || i76 == 17) {
                    int i90 = i67 / 3;
                    objArr[i90 + i90 + 1] = fieldZzC4.getType();
                } else {
                    if (i76 != 27) {
                        if (i76 == 49) {
                            i24 = i4 + 2;
                            i23 = 1;
                        } else if (i76 == 12 || i76 == 30 || i76 == 44) {
                            zzouVar = zzouVar;
                            if (zzouVar.zzc() == 1 || i78 != 0) {
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
                                zzouVar = zzouVar;
                            } else {
                                i18 = i92;
                                i64 = i93;
                                i78 = 0;
                            }
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzC4);
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
                                fieldZzC = (Field) obj3;
                            } else {
                                fieldZzC = zzC(cls2, (String) obj3);
                                objArrZze[i99] = fieldZzC;
                            }
                            i20 = iCharAt13 % 32;
                            iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzC);
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
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzC4);
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
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzC4);
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
            zzouVar = zzouVar;
            i34 = i19;
            i2 = i17;
            c = 55296;
        }
        return new zzol(iArr3, objArr, i2, i5, zzouVar.zza(), false, iArr, i3, i62, zzooVar, zznvVar, zzplVar, zzmpVar, zzodVar);
    }

    private static double zzn(Object obj, long j) {
        return ((Double) zzps.zzf(obj, j)).doubleValue();
    }

    private static float zzo(Object obj, long j) {
        return ((Float) zzps.zzf(obj, j)).floatValue();
    }

    private static int zzp(Object obj, long j) {
        return ((Integer) zzps.zzf(obj, j)).intValue();
    }

    private final int zzq(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzs(i, 0);
    }

    private final int zzr(int i) {
        return this.zzc[i + 2];
    }

    private final int zzs(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
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

    private static int zzt(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzu(int i) {
        return this.zzc[i + 1];
    }

    private static long zzv(Object obj, long j) {
        return ((Long) zzps.zzf(obj, j)).longValue();
    }

    private final zznh zzw(int i) {
        int i2 = i / 3;
        return (zznh) this.zzd[i2 + i2 + 1];
    }

    private final zzow zzx(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzow zzowVar = (zzow) objArr[i3];
        if (zzowVar != null) {
            return zzowVar;
        }
        zzow zzowVarZzb = zzos.zza().zzb((Class) objArr[i3 + 1]);
        this.zzd[i3] = zzowVarZzb;
        return zzowVarZzb;
    }

    private final Object zzy(Object obj, int i, Object obj2, zzpl zzplVar, Object obj3) {
        int i2 = this.zzc[i];
        Object objZzf = zzps.zzf(obj, zzu(i) & 1048575);
        if (objZzf == null || zzw(i) == null) {
            return obj2;
        }
        throw null;
    }

    private final Object zzz(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    /* JADX WARN: Code duplicated, block: B:137:0x038d  */
    /* JADX WARN: Code duplicated, block: B:207:0x054e  */
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
    /* JADX WARN: Type inference failed for: r1v120, types: [int] */
    /* JADX WARN: Type inference failed for: r1v123, types: [int] */
    /* JADX WARN: Type inference failed for: r1v162 */
    /* JADX WARN: Type inference failed for: r1v165 */
    /* JADX WARN: Type inference failed for: r1v166 */
    /* JADX WARN: Type inference failed for: r1v168 */
    /* JADX WARN: Type inference failed for: r1v169 */
    /* JADX WARN: Type inference failed for: r1v170 */
    /* JADX WARN: Type inference failed for: r1v80, types: [int] */
    /* JADX WARN: Type inference failed for: r1v82 */
    /* JADX WARN: Type inference failed for: r2v32, types: [int] */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38, types: [int] */
    /* JADX WARN: Type inference failed for: r2v42, types: [int] */
    /* JADX WARN: Type inference failed for: r2v46, types: [int] */
    /* JADX WARN: Type inference failed for: r2v54 */
    /* JADX WARN: Type inference failed for: r2v55, types: [int] */
    /* JADX WARN: Type inference failed for: r2v89 */
    /* JADX WARN: Type inference failed for: r2v90 */
    /* JADX WARN: Type inference failed for: r2v91 */
    /* JADX WARN: Type inference failed for: r2v92 */
    /* JADX WARN: Type inference failed for: r2v93 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27, types: [int] */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v30, types: [int] */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r3v39, types: [int] */
    /* JADX WARN: Type inference failed for: r3v40 */
    /* JADX WARN: Type inference failed for: r3v46, types: [int] */
    /* JADX WARN: Type inference failed for: r3v51 */
    /* JADX WARN: Type inference failed for: r3v52 */
    /* JADX WARN: Type inference failed for: r3v53 */
    /* JADX WARN: Type inference failed for: r3v54 */
    /* JADX WARN: Type inference failed for: r3v55 */
    /* JADX WARN: Type inference failed for: r3v56 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31, types: [int] */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v36 */
    /* JADX WARN: Type inference failed for: r4v38, types: [int] */
    /* JADX WARN: Type inference failed for: r4v39 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v61 */
    /* JADX WARN: Type inference failed for: r4v62 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [int] */
    @Override // com.google.android.recaptcha.internal.zzow
    public final int zza(Object obj) {
        int i;
        ?? r16;
        ?? r5;
        int iZzA;
        int iZzA2;
        int iZzA3;
        int iZzB;
        int iZzA4;
        int iZzA5;
        int iZzd;
        int iZzA6;
        ?? Zzg;
        int size;
        int iZzA7;
        int iZzz;
        int iZzz2;
        ?? r3;
        int iZzy;
        ?? ZzA;
        ?? Zzh;
        int iZze;
        int iZzA8;
        int iZzA9;
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
        while (i3 < this.zzc.length) {
            int iZzu = zzu(i3);
            int iZzt = zzt(iZzu);
            int[] iArr = this.zzc;
            int i6 = iArr[i3];
            int i7 = iArr[i3 + 2];
            int i8 = i7 & i2;
            if (iZzt <= 17) {
                if (i8 != i5) {
                    r1 = i8 == i2 ? z : unsafe.getInt(obj, i8);
                    i5 = i8;
                }
                i = i5;
                r16 = r1;
                r5 = 1 << (i7 >>> 20);
            } else {
                r1 = r2;
                i = i5;
                r16 = r2 == true ? 1 : 0;
                r5 = z;
            }
            int i9 = iZzu & i2;
            if (iZzt >= zzmu.DOUBLE_LIST_PACKED.zza()) {
                zzmu.SINT64_LIST_PACKED.zza();
            }
            long j = i9;
            switch (iZzt) {
                case 0:
                    if (zzO(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzA = zzln.zzA(i6 << 3);
                        Zzh = iZzA + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 1:
                    if (zzO(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzA2 = zzln.zzA(i6 << 3);
                        Zzh = iZzA2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 2:
                    if (zzO(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        long j2 = unsafe.getLong(obj, j);
                        iZzA3 = zzln.zzA(i6 << 3);
                        iZzB = zzln.zzB(j2);
                        Zzh = iZzA3 + iZzB;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 3:
                    if (zzO(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        long j3 = unsafe.getLong(obj, j);
                        iZzA3 = zzln.zzA(i6 << 3);
                        iZzB = zzln.zzB(j3);
                        Zzh = iZzA3 + iZzB;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 4:
                    if (zzO(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        long j4 = unsafe.getInt(obj, j);
                        iZzA3 = zzln.zzA(i6 << 3);
                        iZzB = zzln.zzB(j4);
                        Zzh = iZzA3 + iZzB;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 5:
                    if (zzO(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzA = zzln.zzA(i6 << 3);
                        Zzh = iZzA + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 6:
                    if (zzO(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzA2 = zzln.zzA(i6 << 3);
                        Zzh = iZzA2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 7:
                    if (zzO(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzA4 = zzln.zzA(i6 << 3);
                        Zzh = iZzA4 + 1;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 8:
                    if (zzO(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        int i10 = i6 << 3;
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof zzle) {
                            iZzA5 = zzln.zzA(i10);
                            iZzd = ((zzle) object).zzd();
                            iZzA6 = zzln.zzA(iZzd);
                            Zzh = iZzA5 + iZzA6 + iZzd;
                            i4 += Zzh;
                        } else {
                            iZzA3 = zzln.zzA(i10);
                            iZzB = zzln.zzz((String) object);
                            Zzh = iZzA3 + iZzB;
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
                    if (zzO(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        Zzh = zzoy.zzh(i6, unsafe.getObject(obj, j), zzx(i3));
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 10:
                    if (zzO(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        zzle zzleVar = (zzle) unsafe.getObject(obj, j);
                        iZzA5 = zzln.zzA(i6 << 3);
                        iZzd = zzleVar.zzd();
                        iZzA6 = zzln.zzA(iZzd);
                        Zzh = iZzA5 + iZzA6 + iZzd;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 11:
                    if (zzO(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        int i11 = unsafe.getInt(obj, j);
                        iZzA3 = zzln.zzA(i6 << 3);
                        iZzB = zzln.zzA(i11);
                        Zzh = iZzA3 + iZzB;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 12:
                    if (zzO(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        long j5 = unsafe.getInt(obj, j);
                        iZzA3 = zzln.zzA(i6 << 3);
                        iZzB = zzln.zzB(j5);
                        Zzh = iZzA3 + iZzB;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 13:
                    if (zzO(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzA2 = zzln.zzA(i6 << 3);
                        Zzh = iZzA2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 14:
                    if (zzO(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzA = zzln.zzA(i6 << 3);
                        Zzh = iZzA + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 15:
                    if (zzO(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        int i12 = unsafe.getInt(obj, j);
                        iZzA3 = zzln.zzA(i6 << 3);
                        iZzB = zzln.zzA((i12 >> 31) ^ (i12 + i12));
                        Zzh = iZzA3 + iZzB;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 16:
                    if (zzO(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        long j6 = unsafe.getLong(obj, j);
                        iZzA3 = zzln.zzA(i6 << 3);
                        iZzB = zzln.zzB((j6 >> 63) ^ (j6 + j6));
                        Zzh = iZzA3 + iZzB;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 17:
                    if (zzO(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        Zzh = zzln.zzw(i6, (zzoi) unsafe.getObject(obj, j), zzx(i3));
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 18:
                    Zzh = zzoy.zzd(i6, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 19:
                    Zzh = zzoy.zzb(i6, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(obj, j);
                    int i13 = zzoy.zza;
                    if (list.size() == 0) {
                        Zzg = z;
                    } else {
                        Zzg = zzoy.zzg(list) + (list.size() * zzln.zzA(i6 << 3));
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
                    int i14 = zzoy.zza;
                    size = list2.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzA3 = zzoy.zzl(list2);
                        iZzA7 = zzln.zzA(i6 << 3);
                        iZzB = size * iZzA7;
                        Zzh = iZzA3 + iZzB;
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
                    int i15 = zzoy.zza;
                    size = list3.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzA3 = zzoy.zzf(list3);
                        iZzA7 = zzln.zzA(i6 << 3);
                        iZzB = size * iZzA7;
                        Zzh = iZzA3 + iZzB;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 23:
                    Zzh = zzoy.zzd(i6, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 24:
                    Zzh = zzoy.zzb(i6, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 25:
                    List list4 = (List) unsafe.getObject(obj, j);
                    int i16 = zzoy.zza;
                    int size2 = list4.size();
                    if (size2 == 0) {
                        Zzh = z;
                    } else {
                        Zzh = size2 * (zzln.zzA(i6 << 3) + 1);
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
                    int i17 = zzoy.zza;
                    int size3 = r0.size();
                    if (size3 == 0) {
                        Zzg = z;
                    } else {
                        int iZzA10 = zzln.zzA(i6 << 3) * size3;
                        if (r0 instanceof zznu) {
                            zznu zznuVar = (zznu) r0;
                            for (?? r7 = z; r7 < size3; r7++) {
                                Object objZzc = zznuVar.zzc();
                                if (objZzc instanceof zzle) {
                                    Zzg = iZzA10;
                                    int iZzd2 = ((zzle) objZzc).zzd();
                                    iZzz2 = Zzg + zzln.zzA(iZzd2) + iZzd2;
                                } else {
                                    Zzg = iZzA10;
                                    iZzz2 = Zzg + zzln.zzz((String) objZzc);
                                }
                                Zzg = iZzz2;
                            }
                            Zzg = iZzA10;
                        } else {
                            for (?? r8 = z; r8 < size3; r8++) {
                                Object obj2 = r0.get(r8);
                                if (obj2 instanceof zzle) {
                                    Zzg = iZzA10;
                                    int iZzd3 = ((zzle) obj2).zzd();
                                    iZzz = Zzg + zzln.zzA(iZzd3) + iZzd3;
                                } else {
                                    Zzg = iZzA10;
                                    iZzz = Zzg + zzln.zzz((String) obj2);
                                }
                                Zzg = iZzz;
                            }
                            Zzg = iZzA10;
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
                    zzow zzowVarZzx = zzx(i3);
                    int i18 = zzoy.zza;
                    int size4 = r9.size();
                    if (size4 == 0) {
                        r3 = z;
                    } else {
                        int iZzA11 = zzln.zzA(i6 << 3) * size4;
                        for (?? r10 = z; r10 < size4; r10++) {
                            Object obj3 = r9.get(r10);
                            if (obj3 instanceof zznt) {
                                r3 = iZzA11;
                                int iZza = ((zznt) obj3).zza();
                                iZzy = (r3 == true ? 1 : 0) + zzln.zzA(iZza) + iZza;
                            } else {
                                r3 = iZzA11;
                                iZzy = (r3 == true ? 1 : 0) + zzln.zzy((zzoi) obj3, zzowVarZzx);
                            }
                            r3 = iZzy;
                        }
                        r3 = iZzA11;
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
                    int i19 = zzoy.zza;
                    int size5 = r11.size();
                    if (size5 == 0) {
                        ZzA = z;
                    } else {
                        ZzA = size5 * zzln.zzA(i6 << 3);
                        for (?? r12 = z; r12 < r11.size(); r12++) {
                            int iZzd4 = ((zzle) r11.get(r12)).zzd();
                            ZzA += zzln.zzA(iZzd4) + iZzd4;
                        }
                    }
                    i4 += ZzA;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 29:
                    List list5 = (List) unsafe.getObject(obj, j);
                    int i20 = zzoy.zza;
                    size = list5.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzA3 = zzoy.zzk(list5);
                        iZzA7 = zzln.zzA(i6 << 3);
                        iZzB = size * iZzA7;
                        Zzh = iZzA3 + iZzB;
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
                    int i21 = zzoy.zza;
                    size = list6.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzA3 = zzoy.zza(list6);
                        iZzA7 = zzln.zzA(i6 << 3);
                        iZzB = size * iZzA7;
                        Zzh = iZzA3 + iZzB;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 31:
                    Zzh = zzoy.zzb(i6, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 32:
                    Zzh = zzoy.zzd(i6, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 33:
                    List list7 = (List) unsafe.getObject(obj, j);
                    int i22 = zzoy.zza;
                    size = list7.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzA3 = zzoy.zzi(list7);
                        iZzA7 = zzln.zzA(i6 << 3);
                        iZzB = size * iZzA7;
                        Zzh = iZzA3 + iZzB;
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
                    int i23 = zzoy.zza;
                    size = list8.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzA3 = zzoy.zzj(list8);
                        iZzA7 = zzln.zzA(i6 << 3);
                        iZzB = size * iZzA7;
                        Zzh = iZzA3 + iZzB;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_4 /* 35 */:
                    iZze = zzoy.zze((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzln.zzA(i6 << 3);
                        iZzA9 = zzln.zzA(iZze);
                        ZzA = iZzA8 + iZzA9 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 36:
                    iZze = zzoy.zzc((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzln.zzA(i6 << 3);
                        iZzA9 = zzln.zzA(iZze);
                        ZzA = iZzA8 + iZzA9 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_6 /* 37 */:
                    iZze = zzoy.zzg((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzln.zzA(i6 << 3);
                        iZzA9 = zzln.zzA(iZze);
                        ZzA = iZzA8 + iZzA9 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                    iZze = zzoy.zzl((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzln.zzA(i6 << 3);
                        iZzA9 = zzln.zzA(iZze);
                        ZzA = iZzA8 + iZzA9 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_8 /* 39 */:
                    iZze = zzoy.zzf((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzln.zzA(i6 << 3);
                        iZzA9 = zzln.zzA(iZze);
                        ZzA = iZzA8 + iZzA9 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_9 /* 40 */:
                    iZze = zzoy.zze((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzln.zzA(i6 << 3);
                        iZzA9 = zzln.zzA(iZze);
                        ZzA = iZzA8 + iZzA9 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_10 /* 41 */:
                    iZze = zzoy.zzc((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzln.zzA(i6 << 3);
                        iZzA9 = zzln.zzA(iZze);
                        ZzA = iZzA8 + iZzA9 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                    List list9 = (List) unsafe.getObject(obj, j);
                    int i24 = zzoy.zza;
                    iZze = list9.size();
                    if (iZze > 0) {
                        iZzA8 = zzln.zzA(i6 << 3);
                        iZzA9 = zzln.zzA(iZze);
                        ZzA = iZzA8 + iZzA9 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                    iZze = zzoy.zzk((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzln.zzA(i6 << 3);
                        iZzA9 = zzln.zzA(iZze);
                        ZzA = iZzA8 + iZzA9 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                    iZze = zzoy.zza((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzln.zzA(i6 << 3);
                        iZzA9 = zzln.zzA(iZze);
                        ZzA = iZzA8 + iZzA9 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                    iZze = zzoy.zzc((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzln.zzA(i6 << 3);
                        iZzA9 = zzln.zzA(iZze);
                        ZzA = iZzA8 + iZzA9 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                    iZze = zzoy.zze((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzln.zzA(i6 << 3);
                        iZzA9 = zzln.zzA(iZze);
                        ZzA = iZzA8 + iZzA9 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                    iZze = zzoy.zzi((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzln.zzA(i6 << 3);
                        iZzA9 = zzln.zzA(iZze);
                        ZzA = iZzA8 + iZzA9 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 48:
                    iZze = zzoy.zzj((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA8 = zzln.zzA(i6 << 3);
                        iZzA9 = zzln.zzA(iZze);
                        ZzA = iZzA8 + iZzA9 + iZze;
                        i4 += ZzA;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 49:
                    ?? r13 = (List) unsafe.getObject(obj, j);
                    zzow zzowVarZzx2 = zzx(i3);
                    int i25 = zzoy.zza;
                    int size6 = r13.size();
                    if (size6 == 0) {
                        r4 = z;
                    } else {
                        boolean z2 = z;
                        r4 = z2;
                        while (r6 < size6) {
                            r6 = z2;
                            int iZzw = zzln.zzw(i6, (zzoi) r13.get(r6), zzowVarZzx2);
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
                    zzoc zzocVar = (zzoc) unsafe.getObject(obj, j);
                    if (zzocVar.isEmpty()) {
                        continue;
                    } else {
                        Iterator it = zzocVar.entrySet().iterator();
                        if (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            entry.getKey();
                            entry.getValue();
                            throw null;
                        }
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                case 51:
                    if (zzR(obj, i6, i3)) {
                        iZzA = zzln.zzA(i6 << 3);
                        Zzh = iZzA + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 52:
                    if (zzR(obj, i6, i3)) {
                        iZzA2 = zzln.zzA(i6 << 3);
                        Zzh = iZzA2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 53:
                    if (zzR(obj, i6, i3)) {
                        long jZzv = zzv(obj, j);
                        iZzA3 = zzln.zzA(i6 << 3);
                        iZzB = zzln.zzB(jZzv);
                        Zzh = iZzA3 + iZzB;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 54:
                    if (zzR(obj, i6, i3)) {
                        long jZzv2 = zzv(obj, j);
                        iZzA3 = zzln.zzA(i6 << 3);
                        iZzB = zzln.zzB(jZzv2);
                        Zzh = iZzA3 + iZzB;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 55:
                    if (zzR(obj, i6, i3)) {
                        long jZzp = zzp(obj, j);
                        iZzA3 = zzln.zzA(i6 << 3);
                        iZzB = zzln.zzB(jZzp);
                        Zzh = iZzA3 + iZzB;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 56:
                    if (zzR(obj, i6, i3)) {
                        iZzA = zzln.zzA(i6 << 3);
                        Zzh = iZzA + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 57:
                    if (zzR(obj, i6, i3)) {
                        iZzA2 = zzln.zzA(i6 << 3);
                        Zzh = iZzA2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 58:
                    if (zzR(obj, i6, i3)) {
                        iZzA4 = zzln.zzA(i6 << 3);
                        Zzh = iZzA4 + 1;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 59:
                    if (zzR(obj, i6, i3)) {
                        int i26 = i6 << 3;
                        Object object2 = unsafe.getObject(obj, j);
                        if (object2 instanceof zzle) {
                            iZzA5 = zzln.zzA(i26);
                            iZzd = ((zzle) object2).zzd();
                            iZzA6 = zzln.zzA(iZzd);
                            Zzh = iZzA5 + iZzA6 + iZzd;
                            i4 += Zzh;
                        } else {
                            iZzA3 = zzln.zzA(i26);
                            iZzB = zzln.zzz((String) object2);
                            Zzh = iZzA3 + iZzB;
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
                    if (zzR(obj, i6, i3)) {
                        Zzh = zzoy.zzh(i6, unsafe.getObject(obj, j), zzx(i3));
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzR(obj, i6, i3)) {
                        zzle zzleVar2 = (zzle) unsafe.getObject(obj, j);
                        iZzA5 = zzln.zzA(i6 << 3);
                        iZzd = zzleVar2.zzd();
                        iZzA6 = zzln.zzA(iZzd);
                        Zzh = iZzA5 + iZzA6 + iZzd;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 62:
                    if (zzR(obj, i6, i3)) {
                        int iZzp = zzp(obj, j);
                        iZzA3 = zzln.zzA(i6 << 3);
                        iZzB = zzln.zzA(iZzp);
                        Zzh = iZzA3 + iZzB;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (zzR(obj, i6, i3)) {
                        long jZzp2 = zzp(obj, j);
                        iZzA3 = zzln.zzA(i6 << 3);
                        iZzB = zzln.zzB(jZzp2);
                        Zzh = iZzA3 + iZzB;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 64:
                    if (zzR(obj, i6, i3)) {
                        iZzA2 = zzln.zzA(i6 << 3);
                        Zzh = iZzA2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (zzR(obj, i6, i3)) {
                        iZzA = zzln.zzA(i6 << 3);
                        Zzh = iZzA + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 66:
                    if (zzR(obj, i6, i3)) {
                        int iZzp2 = zzp(obj, j);
                        iZzA3 = zzln.zzA(i6 << 3);
                        iZzB = zzln.zzA((iZzp2 >> 31) ^ (iZzp2 + iZzp2));
                        Zzh = iZzA3 + iZzB;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 67:
                    if (zzR(obj, i6, i3)) {
                        long jZzv3 = zzv(obj, j);
                        iZzA3 = zzln.zzA(i6 << 3);
                        iZzB = zzln.zzB((jZzv3 >> 63) ^ (jZzv3 + jZzv3));
                        Zzh = iZzA3 + iZzB;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r16;
                    z = false;
                    i2 = 1048575;
                    break;
                case 68:
                    if (zzR(obj, i6, i3)) {
                        Zzh = zzln.zzw(i6, (zzoi) unsafe.getObject(obj, j), zzx(i3));
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
        int iZza2 = i4 + ((zznd) obj).zzc.zza();
        if (!this.zzh) {
            return iZza2;
        }
        zzmt zzmtVar = ((zzna) obj).zzb;
        int iZzc = zzmtVar.zza.zzc();
        int iZza3 = 0;
        for (int i27 = 0; i27 < iZzc; i27++) {
            Map.Entry entryZzg = zzmtVar.zza.zzg(i27);
            iZza3 += zzmt.zza((zzms) ((zzpa) entryZzg).zza(), entryZzg.getValue());
        }
        for (Map.Entry entry2 : zzmtVar.zza.zzd()) {
            iZza3 += zzmt.zza((zzms) entry2.getKey(), entry2.getValue());
        }
        return iZza2 + iZza3;
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final int zzb(Object obj) {
        int i;
        long jDoubleToLongBits;
        int iFloatToIntBits;
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < this.zzc.length; i4 += 3) {
            int iZzu = zzu(i4);
            int[] iArr = this.zzc;
            int i5 = 1048575 & iZzu;
            int iZzt = zzt(iZzu);
            int i6 = iArr[i4];
            long j = i5;
            int iHashCode = 37;
            switch (iZzt) {
                case 0:
                    i = i3 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzps.zza(obj, j));
                    byte[] bArr = zznl.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 1:
                    i = i3 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzps.zzb(obj, j));
                    i3 = i + iFloatToIntBits;
                    break;
                case 2:
                    i = i3 * 53;
                    jDoubleToLongBits = zzps.zzd(obj, j);
                    byte[] bArr2 = zznl.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 3:
                    i = i3 * 53;
                    jDoubleToLongBits = zzps.zzd(obj, j);
                    byte[] bArr3 = zznl.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 4:
                    i = i3 * 53;
                    iFloatToIntBits = zzps.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 5:
                    i = i3 * 53;
                    jDoubleToLongBits = zzps.zzd(obj, j);
                    byte[] bArr4 = zznl.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 6:
                    i = i3 * 53;
                    iFloatToIntBits = zzps.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 7:
                    i = i3 * 53;
                    iFloatToIntBits = zznl.zza(zzps.zzw(obj, j));
                    i3 = i + iFloatToIntBits;
                    break;
                case 8:
                    i = i3 * 53;
                    iFloatToIntBits = ((String) zzps.zzf(obj, j)).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case 9:
                    i2 = i3 * 53;
                    Object objZzf = zzps.zzf(obj, j);
                    if (objZzf != null) {
                        iHashCode = objZzf.hashCode();
                    }
                    i3 = i2 + iHashCode;
                    break;
                case 10:
                    i = i3 * 53;
                    iFloatToIntBits = zzps.zzf(obj, j).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case 11:
                    i = i3 * 53;
                    iFloatToIntBits = zzps.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 12:
                    i = i3 * 53;
                    iFloatToIntBits = zzps.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 13:
                    i = i3 * 53;
                    iFloatToIntBits = zzps.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 14:
                    i = i3 * 53;
                    jDoubleToLongBits = zzps.zzd(obj, j);
                    byte[] bArr5 = zznl.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 15:
                    i = i3 * 53;
                    iFloatToIntBits = zzps.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 16:
                    i = i3 * 53;
                    jDoubleToLongBits = zzps.zzd(obj, j);
                    byte[] bArr6 = zznl.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 17:
                    i2 = i3 * 53;
                    Object objZzf2 = zzps.zzf(obj, j);
                    if (objZzf2 != null) {
                        iHashCode = objZzf2.hashCode();
                    }
                    i3 = i2 + iHashCode;
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
                    i = i3 * 53;
                    iFloatToIntBits = zzps.zzf(obj, j).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH /* 50 */:
                    i = i3 * 53;
                    iFloatToIntBits = zzps.zzf(obj, j).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case 51:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzn(obj, j));
                        byte[] bArr7 = zznl.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 52:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzo(obj, j));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 53:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzv(obj, j);
                        byte[] bArr8 = zznl.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 54:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzv(obj, j);
                        byte[] bArr9 = zznl.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 55:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 56:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzv(obj, j);
                        byte[] bArr10 = zznl.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 57:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 58:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zznl.zza(zzS(obj, j));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 59:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = ((String) zzps.zzf(obj, j)).hashCode();
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzps.zzf(obj, j).hashCode();
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzps.zzf(obj, j).hashCode();
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 62:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 64:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzv(obj, j);
                        byte[] bArr11 = zznl.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 66:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 67:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzv(obj, j);
                        byte[] bArr12 = zznl.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 68:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzps.zzf(obj, j).hashCode();
                        i3 = i + iFloatToIntBits;
                    }
                    break;
            }
        }
        int iHashCode2 = (i3 * 53) + ((zznd) obj).zzc.hashCode();
        return this.zzh ? (iHashCode2 * 53) + ((zzna) obj).zzb.zza.hashCode() : iHashCode2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:402:0x0963 A[PHI: r5 r8 r9 r11 r14 r31
  0x0963: PHI (r5v70 boolean) = (r5v54 boolean), (r5v73 boolean) binds: [B:391:0x0917, B:136:0x03fe] A[DONT_GENERATE, DONT_INLINE]
  0x0963: PHI (r8v135 int) = (r8v74 int), (r8v138 int) binds: [B:391:0x0917, B:136:0x03fe] A[DONT_GENERATE, DONT_INLINE]
  0x0963: PHI (r9v84 'this' com.google.android.recaptcha.internal.zzol<T>) = 
  (r9v45 'this' com.google.android.recaptcha.internal.zzol<T>)
  (r9v87 'this' com.google.android.recaptcha.internal.zzol<T>)
 binds: [B:391:0x0917, B:136:0x03fe] A[DONT_GENERATE, DONT_INLINE]
  0x0963: PHI (r11v50 int) = (r11v26 int), (r11v53 int) binds: [B:391:0x0917, B:136:0x03fe] A[DONT_GENERATE, DONT_INLINE]
  0x0963: PHI (r14v62 int) = (r14v28 int), (r14v64 int) binds: [B:391:0x0917, B:136:0x03fe] A[DONT_GENERATE, DONT_INLINE]
  0x0963: PHI (r31v32 sun.misc.Unsafe) = (r31v8 sun.misc.Unsafe), (r31v34 sun.misc.Unsafe) binds: [B:391:0x0917, B:136:0x03fe] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:490:0x0bef A[PHI: r0 r3 r8 r9 r22
  0x0bef: PHI (r0v111 int) = (r0v80 int), (r0v81 int), (r0v82 int), (r0v83 int), (r0v84 int), (r0v98 int), (r0v112 int) binds: [B:488:0x0bd8, B:485:0x0bb7, B:482:0x0b99, B:479:0x0b7b, B:476:0x0b5d, B:474:0x0b50, B:419:0x09d8] A[DONT_GENERATE, DONT_INLINE]
  0x0bef: PHI (r3v68 int) = (r3v50 int), (r3v51 int), (r3v52 int), (r3v53 int), (r3v54 int), (r3v60 int), (r3v69 int) binds: [B:488:0x0bd8, B:485:0x0bb7, B:482:0x0b99, B:479:0x0b7b, B:476:0x0b5d, B:474:0x0b50, B:419:0x09d8] A[DONT_GENERATE, DONT_INLINE]
  0x0bef: PHI (r8v71 com.google.android.recaptcha.internal.zzkt) = 
  (r8v48 com.google.android.recaptcha.internal.zzkt)
  (r8v49 com.google.android.recaptcha.internal.zzkt)
  (r8v50 com.google.android.recaptcha.internal.zzkt)
  (r8v51 com.google.android.recaptcha.internal.zzkt)
  (r8v52 com.google.android.recaptcha.internal.zzkt)
  (r8v61 com.google.android.recaptcha.internal.zzkt)
  (r8v72 com.google.android.recaptcha.internal.zzkt)
 binds: [B:488:0x0bd8, B:485:0x0bb7, B:482:0x0b99, B:479:0x0b7b, B:476:0x0b5d, B:474:0x0b50, B:419:0x09d8] A[DONT_GENERATE, DONT_INLINE]
  0x0bef: PHI (r9v43 int) = (r9v21 int), (r9v22 int), (r9v23 int), (r9v24 int), (r9v25 int), (r9v34 int), (r9v44 int) binds: [B:488:0x0bd8, B:485:0x0bb7, B:482:0x0b99, B:479:0x0b7b, B:476:0x0b5d, B:474:0x0b50, B:419:0x09d8] A[DONT_GENERATE, DONT_INLINE]
  0x0bef: PHI (r22v46 int) = (r22v25 int), (r22v26 int), (r22v27 int), (r22v28 int), (r22v29 int), (r22v40 int), (r22v47 int) binds: [B:488:0x0bd8, B:485:0x0bb7, B:482:0x0b99, B:479:0x0b7b, B:476:0x0b5d, B:474:0x0b50, B:419:0x09d8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:533:0x0d06  */
    /* JADX WARN: Code duplicated, block: B:595:0x0968 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:598:0x0bf2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:637:0x0c04 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:643:0x0979 A[SYNTHETIC] */
    final int zzc(Object obj, byte[] bArr, int i, int i2, int i3, zzkt zzktVar) throws IOException {
        Unsafe unsafe;
        int i4;
        int i5;
        zzol<T> zzolVar;
        int i6;
        int i7;
        int i8;
        int iZzl;
        int i9;
        int i10;
        zzol<T> zzolVar2;
        int i11;
        zzkt zzktVar2;
        int i12;
        int i13;
        Object obj2;
        int i14;
        zzol<T> zzolVar3;
        int i15;
        int i16;
        boolean z;
        int i17;
        int iZzl2;
        zzol<T> zzolVar4;
        int i18;
        int i19;
        int i20;
        int i21;
        boolean z2;
        int i22;
        int iZzl3;
        int iZzl4;
        int i23;
        int iZza;
        int i24;
        int i25;
        boolean z3;
        boolean z4;
        int i26;
        int i27;
        int i28;
        zzol<T> zzolVar5;
        int iZzf;
        int i29;
        int iZzi;
        Object obj3;
        int i30;
        boolean z5;
        int iZzk;
        zzol<T> zzolVar6 = this;
        i2 = i2;
        i3 = i3;
        zzkt zzktVar3 = zzktVar;
        zzD(obj);
        Unsafe unsafe2 = zzb;
        int i31 = -1;
        int iZzh = i;
        int i32 = -1;
        int i33 = 0;
        int i34 = 0;
        int i35 = 0;
        int i36 = 1048575;
        while (true) {
            if (iZzh < i2) {
                int i37 = iZzh + 1;
                int i38 = bArr[iZzh];
                if (i38 < 0) {
                    int iZzj = zzku.zzj(i38, bArr, i37, zzktVar3);
                    i8 = zzktVar3.zza;
                    i37 = iZzj;
                } else {
                    i8 = i38;
                }
                int i39 = i8 >>> 3;
                int iZzs = i39 > i32 ? (i39 < zzolVar6.zze || i39 > zzolVar6.zzf) ? i31 : zzolVar6.zzs(i39, i33 / 3) : zzolVar6.zzq(i39);
                Object objValueOf = null;
                if (iZzs == i31) {
                    iZzl = i37;
                    i9 = i35;
                    i10 = i36;
                    zzolVar2 = zzolVar6;
                    i7 = i8;
                    i11 = i31;
                    unsafe = unsafe2;
                    zzktVar2 = zzktVar3;
                    i4 = i3;
                    i12 = 0;
                    i13 = i39;
                } else {
                    int i40 = i8 & 7;
                    int[] iArr = zzolVar6.zzc;
                    int i41 = iArr[iZzs + 1];
                    int i42 = i39;
                    int iZzt = zzt(i41);
                    long j = i41 & 1048575;
                    int i43 = i8;
                    if (iZzt <= 17) {
                        int i44 = iArr[iZzs + 2];
                        int i45 = 1 << (i44 >>> 20);
                        int i46 = i44 & 1048575;
                        if (i46 != i36) {
                            if (i36 != 1048575) {
                                unsafe2.putInt(obj, i36, i35);
                            }
                            i35 = i46 == 1048575 ? 0 : unsafe2.getInt(obj, i46);
                            i10 = i46;
                        } else {
                            i10 = i36;
                        }
                        switch (iZzt) {
                            case 0:
                                zzolVar3 = this;
                                i15 = i42;
                                i16 = i43;
                                z = true;
                                i12 = iZzs;
                                if (i40 == 1) {
                                    iZzh = i37 + 8;
                                    i35 |= i45;
                                    zzps.zzo(obj, j, Double.longBitsToDouble(zzku.zzp(bArr, i37)));
                                    i2 = i2;
                                    i32 = i15;
                                    i34 = i16;
                                    i36 = i10;
                                    i31 = -1;
                                    int i47 = i12;
                                    zzolVar6 = zzolVar3;
                                    i33 = i47;
                                } else {
                                    i18 = i16;
                                    i11 = -1;
                                    i42 = i15;
                                    i4 = i3;
                                    i7 = i18;
                                    unsafe = unsafe2;
                                    i9 = i35;
                                    zzktVar2 = zzktVar3;
                                    zzolVar2 = zzolVar3;
                                    iZzl = i37;
                                    i13 = i42;
                                }
                                break;
                            case 1:
                                zzolVar3 = this;
                                i15 = i42;
                                i16 = i43;
                                i12 = iZzs;
                                if (i40 == 5) {
                                    iZzh = i37 + 4;
                                    i35 |= i45;
                                    zzps.zzp(obj, j, Float.intBitsToFloat(zzku.zzb(bArr, i37)));
                                    i2 = i2;
                                    i32 = i15;
                                    i34 = i16;
                                    i36 = i10;
                                    i31 = -1;
                                    int i48 = i12;
                                    zzolVar6 = zzolVar3;
                                    i33 = i48;
                                } else {
                                    i18 = i16;
                                    z = true;
                                    i11 = -1;
                                    i42 = i15;
                                    i4 = i3;
                                    i7 = i18;
                                    unsafe = unsafe2;
                                    i9 = i35;
                                    zzktVar2 = zzktVar3;
                                    zzolVar2 = zzolVar3;
                                    iZzl = i37;
                                    i13 = i42;
                                }
                                break;
                            case 2:
                            case 3:
                                zzolVar2 = this;
                                i15 = i42;
                                i16 = i43;
                                i12 = iZzs;
                                if (i40 == 0) {
                                    i17 = i45 | i35;
                                    iZzl2 = zzku.zzl(bArr, i37, zzktVar3);
                                    zzolVar4 = zzolVar2;
                                    unsafe2.putLong(obj, j, zzktVar3.zzb);
                                    i33 = i12;
                                    i32 = i15;
                                    i35 = i17;
                                    iZzh = iZzl2;
                                    zzolVar6 = zzolVar4;
                                    i34 = i16;
                                    i36 = i10;
                                    i31 = -1;
                                    i3 = i3;
                                } else {
                                    zzolVar3 = zzolVar2;
                                    i18 = i16;
                                    z = true;
                                    i11 = -1;
                                    i42 = i15;
                                    i4 = i3;
                                    i7 = i18;
                                    unsafe = unsafe2;
                                    i9 = i35;
                                    zzktVar2 = zzktVar3;
                                    zzolVar2 = zzolVar3;
                                    iZzl = i37;
                                    i13 = i42;
                                }
                                break;
                            case 4:
                            case 11:
                                zzolVar2 = this;
                                i15 = i42;
                                i16 = i43;
                                i12 = iZzs;
                                if (i40 == 0) {
                                    i35 |= i45;
                                    iZzh = zzku.zzi(bArr, i37, zzktVar3);
                                    unsafe2.putInt(obj, j, zzktVar3.zza);
                                    i33 = i12;
                                    i32 = i15;
                                    i34 = i16;
                                    i31 = -1;
                                    zzolVar6 = zzolVar2;
                                    i36 = i10;
                                } else {
                                    zzolVar3 = zzolVar2;
                                    i18 = i16;
                                    z = true;
                                    i11 = -1;
                                    i42 = i15;
                                    i4 = i3;
                                    i7 = i18;
                                    unsafe = unsafe2;
                                    i9 = i35;
                                    zzktVar2 = zzktVar3;
                                    zzolVar2 = zzolVar3;
                                    iZzl = i37;
                                    i13 = i42;
                                }
                                break;
                            case 5:
                            case 14:
                                i15 = i42;
                                i16 = i43;
                                z = true;
                                i12 = iZzs;
                                if (i40 == 1) {
                                    iZzl2 = i37 + 8;
                                    i17 = i45 | i35;
                                    zzolVar4 = this;
                                    unsafe2.putLong(obj, j, zzku.zzp(bArr, i37));
                                    i33 = i12;
                                    i32 = i15;
                                    i35 = i17;
                                    iZzh = iZzl2;
                                    zzolVar6 = zzolVar4;
                                    i34 = i16;
                                    i36 = i10;
                                    i31 = -1;
                                    i3 = i3;
                                } else {
                                    zzolVar3 = this;
                                    i18 = i16;
                                    i11 = -1;
                                    i42 = i15;
                                    i4 = i3;
                                    i7 = i18;
                                    unsafe = unsafe2;
                                    i9 = i35;
                                    zzktVar2 = zzktVar3;
                                    zzolVar2 = zzolVar3;
                                    iZzl = i37;
                                    i13 = i42;
                                }
                                break;
                            case 6:
                            case 13:
                                zzolVar2 = this;
                                i15 = i42;
                                i16 = i43;
                                i12 = iZzs;
                                if (i40 == 5) {
                                    iZzh = i37 + 4;
                                    i35 |= i45;
                                    unsafe2.putInt(obj, j, zzku.zzb(bArr, i37));
                                    i33 = i12;
                                    i32 = i15;
                                    i34 = i16;
                                    i31 = -1;
                                    zzolVar6 = zzolVar2;
                                    i36 = i10;
                                } else {
                                    zzolVar3 = zzolVar2;
                                    i18 = i16;
                                    z = true;
                                    i11 = -1;
                                    i42 = i15;
                                    i4 = i3;
                                    i7 = i18;
                                    unsafe = unsafe2;
                                    i9 = i35;
                                    zzktVar2 = zzktVar3;
                                    zzolVar2 = zzolVar3;
                                    iZzl = i37;
                                    i13 = i42;
                                }
                                break;
                            case 7:
                                zzolVar2 = this;
                                i15 = i42;
                                i16 = i43;
                                i12 = iZzs;
                                if (i40 == 0) {
                                    i35 |= i45;
                                    iZzh = zzku.zzl(bArr, i37, zzktVar3);
                                    zzps.zzm(obj, j, zzktVar3.zzb != 0);
                                    i33 = i12;
                                    i32 = i15;
                                    i34 = i16;
                                    i31 = -1;
                                    zzolVar6 = zzolVar2;
                                    i36 = i10;
                                } else {
                                    zzolVar3 = zzolVar2;
                                    i18 = i16;
                                    z = true;
                                    i11 = -1;
                                    i42 = i15;
                                    i4 = i3;
                                    i7 = i18;
                                    unsafe = unsafe2;
                                    i9 = i35;
                                    zzktVar2 = zzktVar3;
                                    zzolVar2 = zzolVar3;
                                    iZzl = i37;
                                    i13 = i42;
                                }
                                break;
                            case 8:
                                zzolVar2 = this;
                                i15 = i42;
                                i16 = i43;
                                i12 = iZzs;
                                if (i40 == 2) {
                                    if (zzM(i41)) {
                                        iZzh = zzku.zzi(bArr, i37, zzktVar3);
                                        int i49 = zzktVar3.zza;
                                        if (i49 < 0) {
                                            throw new zznn("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                        }
                                        int i50 = i35 | i45;
                                        if (i49 == 0) {
                                            zzktVar3.zzc = "";
                                        } else {
                                            zzktVar3.zzc = zzpv.zzd(bArr, iZzh, i49);
                                            iZzh += i49;
                                        }
                                        i35 = i50;
                                    } else {
                                        i35 |= i45;
                                        iZzh = zzku.zzg(bArr, i37, zzktVar3);
                                    }
                                    unsafe2.putObject(obj, j, zzktVar3.zzc);
                                    i33 = i12;
                                    i32 = i15;
                                    i34 = i16;
                                    i31 = -1;
                                    zzolVar6 = zzolVar2;
                                    i36 = i10;
                                } else {
                                    zzolVar3 = zzolVar2;
                                    i18 = i16;
                                    z = true;
                                    i11 = -1;
                                    i42 = i15;
                                    i4 = i3;
                                    i7 = i18;
                                    unsafe = unsafe2;
                                    i9 = i35;
                                    zzktVar2 = zzktVar3;
                                    zzolVar2 = zzolVar3;
                                    iZzl = i37;
                                    i13 = i42;
                                }
                                break;
                            case 9:
                                zzolVar2 = this;
                                i15 = i42;
                                i16 = i43;
                                i12 = iZzs;
                                if (i40 == 2) {
                                    Object objZzA = zzolVar2.zzA(obj, i12);
                                    zzolVar4 = zzolVar2;
                                    iZzh = zzku.zzn(objZzA, zzolVar2.zzx(i12), bArr, i37, i2, zzktVar);
                                    zzolVar4.zzJ(obj, i12, objZzA);
                                    i33 = i12;
                                    i32 = i15;
                                    i35 = i45 | i35;
                                    zzolVar6 = zzolVar4;
                                    i34 = i16;
                                    i36 = i10;
                                    i31 = -1;
                                    i3 = i3;
                                } else {
                                    zzolVar3 = zzolVar2;
                                    i18 = i16;
                                    z = true;
                                    i11 = -1;
                                    i42 = i15;
                                    i4 = i3;
                                    i7 = i18;
                                    unsafe = unsafe2;
                                    i9 = i35;
                                    zzktVar2 = zzktVar3;
                                    zzolVar2 = zzolVar3;
                                    iZzl = i37;
                                    i13 = i42;
                                }
                                break;
                            case 10:
                                zzolVar2 = this;
                                i15 = i42;
                                i16 = i43;
                                i12 = iZzs;
                                if (i40 == 2) {
                                    i35 |= i45;
                                    iZzh = zzku.zza(bArr, i37, zzktVar3);
                                    unsafe2.putObject(obj, j, zzktVar3.zzc);
                                    i33 = i12;
                                    i32 = i15;
                                    i34 = i16;
                                    i31 = -1;
                                    zzolVar6 = zzolVar2;
                                    i36 = i10;
                                } else {
                                    zzolVar3 = zzolVar2;
                                    i18 = i16;
                                    z = true;
                                    i11 = -1;
                                    i42 = i15;
                                    i4 = i3;
                                    i7 = i18;
                                    unsafe = unsafe2;
                                    i9 = i35;
                                    zzktVar2 = zzktVar3;
                                    zzolVar2 = zzolVar3;
                                    iZzl = i37;
                                    i13 = i42;
                                }
                                break;
                            case 12:
                                i12 = iZzs;
                                i19 = i42;
                                if (i40 == 0) {
                                    iZzh = zzku.zzi(bArr, i37, zzktVar3);
                                    int i51 = zzktVar3.zza;
                                    zzolVar2 = this;
                                    zznh zznhVarZzw = zzolVar2.zzw(i12);
                                    if ((i41 & Integer.MIN_VALUE) == 0 || zznhVarZzw == null || zznhVarZzw.zza(i51)) {
                                        i20 = i43;
                                        i35 |= i45;
                                        unsafe2.putInt(obj, j, i51);
                                    } else {
                                        i20 = i43;
                                        zzd(obj).zzj(i20, Long.valueOf(i51));
                                    }
                                    i33 = i12;
                                    i32 = i19;
                                    i34 = i20;
                                    i31 = -1;
                                    zzolVar6 = zzolVar2;
                                    i36 = i10;
                                } else {
                                    zzolVar3 = this;
                                    i42 = i19;
                                    unsafe2 = unsafe2;
                                    i18 = i43;
                                    z = true;
                                    i11 = -1;
                                    i4 = i3;
                                    i7 = i18;
                                    unsafe = unsafe2;
                                    i9 = i35;
                                    zzktVar2 = zzktVar3;
                                    zzolVar2 = zzolVar3;
                                    iZzl = i37;
                                    i13 = i42;
                                }
                                break;
                            case 15:
                                i12 = iZzs;
                                i19 = i42;
                                if (i40 == 0) {
                                    i35 |= i45;
                                    iZzh = zzku.zzi(bArr, i37, zzktVar3);
                                    unsafe2.putInt(obj, j, zzli.zzF(zzktVar3.zza));
                                    i33 = i12;
                                    i32 = i19;
                                    i34 = i43;
                                    i36 = i10;
                                    i31 = -1;
                                    zzolVar6 = this;
                                } else {
                                    zzolVar3 = this;
                                    i42 = i19;
                                    unsafe2 = unsafe2;
                                    i18 = i43;
                                    z = true;
                                    i11 = -1;
                                    i4 = i3;
                                    i7 = i18;
                                    unsafe = unsafe2;
                                    i9 = i35;
                                    zzktVar2 = zzktVar3;
                                    zzolVar2 = zzolVar3;
                                    iZzl = i37;
                                    i13 = i42;
                                }
                                break;
                            case 16:
                                if (i40 == 0) {
                                    int i52 = i35 | i45;
                                    int iZzl5 = zzku.zzl(bArr, i37, zzktVar3);
                                    unsafe2.putLong(obj, j, zzli.zzG(zzktVar3.zzb));
                                    i33 = iZzs;
                                    i35 = i52;
                                    iZzh = iZzl5;
                                    i32 = i42;
                                    i34 = i43;
                                    i36 = i10;
                                    i31 = -1;
                                    zzolVar6 = this;
                                } else {
                                    i12 = iZzs;
                                    zzolVar3 = this;
                                    unsafe2 = unsafe2;
                                    i18 = i43;
                                    z = true;
                                    i11 = -1;
                                    i4 = i3;
                                    i7 = i18;
                                    unsafe = unsafe2;
                                    i9 = i35;
                                    zzktVar2 = zzktVar3;
                                    zzolVar2 = zzolVar3;
                                    iZzl = i37;
                                    i13 = i42;
                                }
                                break;
                            default:
                                zzolVar3 = this;
                                i15 = i42;
                                i16 = i43;
                                z = true;
                                i12 = iZzs;
                                if (i40 == 3) {
                                    Object objZzA2 = zzolVar3.zzA(obj, i12);
                                    int iZzm = zzku.zzm(objZzA2, zzolVar3.zzx(i12), bArr, i37, i2, (i15 << 3) | 4, zzktVar);
                                    zzolVar3.zzJ(obj, i12, objZzA2);
                                    zzktVar3 = zzktVar3;
                                    i2 = i2;
                                    unsafe2 = unsafe2;
                                    iZzh = iZzm;
                                    i31 = -1;
                                    i36 = i10;
                                    i35 |= i45;
                                    i34 = i16;
                                    i32 = i15;
                                    int i410 = i12;
                                    zzolVar6 = zzolVar3;
                                    i33 = i410;
                                } else {
                                    i18 = i16;
                                    i11 = -1;
                                    i42 = i15;
                                    i4 = i3;
                                    i7 = i18;
                                    unsafe = unsafe2;
                                    i9 = i35;
                                    zzktVar2 = zzktVar3;
                                    zzolVar2 = zzolVar3;
                                    iZzl = i37;
                                    i13 = i42;
                                }
                                break;
                        }
                    } else {
                        i9 = i35;
                        i10 = i36;
                        Unsafe unsafe3 = unsafe2;
                        i11 = -1;
                        zzol<T> zzolVar7 = zzolVar6;
                        i12 = iZzs;
                        zzolVar3 = zzolVar7;
                        if (iZzt != 27) {
                            zzktVar3 = zzktVar;
                            unsafe = unsafe3;
                            if (iZzt <= 49) {
                                long j2 = i41;
                                Unsafe unsafe4 = zzb;
                                zznk zznkVarZzd = (zznk) unsafe4.getObject(obj, j);
                                if (!zznkVarZzd.zzc()) {
                                    int size = zznkVarZzd.size();
                                    zznkVarZzd = zznkVarZzd.zzd(size + size);
                                    unsafe4.putObject(obj, j, zznkVarZzd);
                                }
                                zznk zznkVar = zznkVarZzd;
                                switch (iZzt) {
                                    case 18:
                                    case MotionEventCompat.AXIS_GENERIC_4 /* 35 */:
                                        this = this;
                                        i2 = i2;
                                        i24 = i43;
                                        unsafe = unsafe;
                                        i25 = i37;
                                        if (i40 == 2) {
                                            int i53 = zzku.zza;
                                            zzmi zzmiVar = (zzmi) zznkVar;
                                            iZzh = zzku.zzi(bArr, i25, zzktVar3);
                                            int i54 = zzktVar3.zza;
                                            int i55 = iZzh + i54;
                                            if (i55 > bArr.length) {
                                                throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            zzmiVar.zzg(zzmiVar.size() + (i54 / 8));
                                            while (iZzh < i55) {
                                                zzmiVar.zzf(Double.longBitsToDouble(zzku.zzp(bArr, iZzh)));
                                                iZzh += 8;
                                            }
                                            if (iZzh != i55) {
                                                throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            z4 = true;
                                        } else {
                                            z3 = true;
                                            if (i40 == 1) {
                                                int i56 = i25 + 8;
                                                int i57 = zzku.zza;
                                                zzmi zzmiVar2 = (zzmi) zznkVar;
                                                zzmiVar2.zzf(Double.longBitsToDouble(zzku.zzp(bArr, i25)));
                                                while (i56 < i2) {
                                                    int iZzi2 = zzku.zzi(bArr, i56, zzktVar3);
                                                    if (i24 == zzktVar3.zza) {
                                                        zzmiVar2.zzf(Double.longBitsToDouble(zzku.zzp(bArr, iZzi2)));
                                                        i56 = iZzi2 + 8;
                                                    } else {
                                                        iZzh = i56;
                                                        z4 = true;
                                                    }
                                                }
                                                iZzh = i56;
                                                z4 = true;
                                            } else {
                                                z4 = z3;
                                                iZzh = i25;
                                            }
                                        }
                                        if (iZzh != i25) {
                                            i3 = i3;
                                            i33 = i12;
                                            i34 = i24;
                                            zzolVar6 = this;
                                            i31 = -1;
                                            i35 = i9;
                                            i32 = i42;
                                            i36 = i10;
                                            unsafe2 = unsafe;
                                        } else {
                                            i4 = i3;
                                            iZzl = iZzh;
                                            zzolVar2 = this;
                                            i13 = i42;
                                            i7 = i24;
                                            zzktVar2 = zzktVar3;
                                        }
                                        break;
                                    case 19:
                                    case 36:
                                        this = this;
                                        i2 = i2;
                                        i24 = i43;
                                        unsafe = unsafe;
                                        i25 = i37;
                                        if (i40 != 2) {
                                            if (i40 == 5) {
                                                int i58 = i25 + 4;
                                                int i59 = zzku.zza;
                                                zzmv zzmvVar = (zzmv) zznkVar;
                                                zzmvVar.zzf(Float.intBitsToFloat(zzku.zzb(bArr, i25)));
                                                while (i58 < i2) {
                                                    int iZzi3 = zzku.zzi(bArr, i58, zzktVar3);
                                                    if (i24 == zzktVar3.zza) {
                                                        zzmvVar.zzf(Float.intBitsToFloat(zzku.zzb(bArr, iZzi3)));
                                                        i58 = iZzi3 + 4;
                                                    } else {
                                                        iZzh = i58;
                                                    }
                                                }
                                                iZzh = i58;
                                            }
                                            z4 = true;
                                            iZzh = i25;
                                            if (iZzh != i25) {
                                                i3 = i3;
                                                i33 = i12;
                                                i34 = i24;
                                                zzolVar6 = this;
                                                i31 = -1;
                                                i35 = i9;
                                                i32 = i42;
                                                i36 = i10;
                                                unsafe2 = unsafe;
                                            } else {
                                                i4 = i3;
                                                iZzl = iZzh;
                                                zzolVar2 = this;
                                                i13 = i42;
                                                i7 = i24;
                                                zzktVar2 = zzktVar3;
                                            }
                                        } else {
                                            int i60 = zzku.zza;
                                            zzmv zzmvVar2 = (zzmv) zznkVar;
                                            iZzh = zzku.zzi(bArr, i25, zzktVar3);
                                            int i61 = zzktVar3.zza;
                                            int i62 = iZzh + i61;
                                            if (i62 > bArr.length) {
                                                throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            zzmvVar2.zzg(zzmvVar2.size() + (i61 / 4));
                                            while (iZzh < i62) {
                                                zzmvVar2.zzf(Float.intBitsToFloat(zzku.zzb(bArr, iZzh)));
                                                iZzh += 4;
                                            }
                                            if (iZzh != i62) {
                                                throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        z4 = true;
                                        if (iZzh != i25) {
                                            i3 = i3;
                                            i33 = i12;
                                            i34 = i24;
                                            zzolVar6 = this;
                                            i31 = -1;
                                            i35 = i9;
                                            i32 = i42;
                                            i36 = i10;
                                            unsafe2 = unsafe;
                                        } else {
                                            i4 = i3;
                                            iZzl = iZzh;
                                            zzolVar2 = this;
                                            i13 = i42;
                                            i7 = i24;
                                            zzktVar2 = zzktVar3;
                                        }
                                        break;
                                    case 20:
                                    case 21:
                                    case MotionEventCompat.AXIS_GENERIC_6 /* 37 */:
                                    case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                                        this = this;
                                        i2 = i2;
                                        i24 = i43;
                                        unsafe = unsafe;
                                        i25 = i37;
                                        if (i40 != 2) {
                                            if (i40 == 0) {
                                                int i63 = zzku.zza;
                                                zznx zznxVar = (zznx) zznkVar;
                                                iZzh = zzku.zzl(bArr, i25, zzktVar3);
                                                zznxVar.zzg(zzktVar3.zzb);
                                                while (iZzh < i2) {
                                                    int iZzi4 = zzku.zzi(bArr, iZzh, zzktVar3);
                                                    if (i24 == zzktVar3.zza) {
                                                        iZzh = zzku.zzl(bArr, iZzi4, zzktVar3);
                                                        zznxVar.zzg(zzktVar3.zzb);
                                                    }
                                                }
                                            }
                                            z4 = true;
                                            iZzh = i25;
                                            if (iZzh != i25) {
                                                i3 = i3;
                                                i33 = i12;
                                                i34 = i24;
                                                zzolVar6 = this;
                                                i31 = -1;
                                                i35 = i9;
                                                i32 = i42;
                                                i36 = i10;
                                                unsafe2 = unsafe;
                                            } else {
                                                i4 = i3;
                                                iZzl = iZzh;
                                                zzolVar2 = this;
                                                i13 = i42;
                                                i7 = i24;
                                                zzktVar2 = zzktVar3;
                                            }
                                        } else {
                                            int i64 = zzku.zza;
                                            zznx zznxVar2 = (zznx) zznkVar;
                                            iZzh = zzku.zzi(bArr, i25, zzktVar3);
                                            int i65 = zzktVar3.zza + iZzh;
                                            while (iZzh < i65) {
                                                iZzh = zzku.zzl(bArr, iZzh, zzktVar3);
                                                zznxVar2.zzg(zzktVar3.zzb);
                                            }
                                            if (iZzh != i65) {
                                                throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        z4 = true;
                                        if (iZzh != i25) {
                                            i3 = i3;
                                            i33 = i12;
                                            i34 = i24;
                                            zzolVar6 = this;
                                            i31 = -1;
                                            i35 = i9;
                                            i32 = i42;
                                            i36 = i10;
                                            unsafe2 = unsafe;
                                        } else {
                                            i4 = i3;
                                            iZzl = iZzh;
                                            zzolVar2 = this;
                                            i13 = i42;
                                            i7 = i24;
                                            zzktVar2 = zzktVar3;
                                        }
                                        break;
                                    case 22:
                                    case 29:
                                    case MotionEventCompat.AXIS_GENERIC_8 /* 39 */:
                                    case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                                        i26 = i2;
                                        i27 = i43;
                                        unsafe = unsafe;
                                        i28 = i37;
                                        zzolVar5 = this;
                                        if (i40 != 2) {
                                            if (i40 == 0) {
                                                i24 = i27;
                                                this = zzolVar5;
                                                i25 = i28;
                                                i2 = i26;
                                                iZzh = zzku.zzk(i27, bArr, i28, i2, zznkVar, zzktVar);
                                            }
                                            i24 = i27;
                                            this = zzolVar5;
                                            i25 = i28;
                                            i2 = i26;
                                            z4 = true;
                                            iZzh = i25;
                                            if (iZzh != i25) {
                                                i3 = i3;
                                                i33 = i12;
                                                i34 = i24;
                                                zzolVar6 = this;
                                                i31 = -1;
                                                i35 = i9;
                                                i32 = i42;
                                                i36 = i10;
                                                unsafe2 = unsafe;
                                            } else {
                                                i4 = i3;
                                                iZzl = iZzh;
                                                zzolVar2 = this;
                                                i13 = i42;
                                                i7 = i24;
                                                zzktVar2 = zzktVar3;
                                            }
                                        } else {
                                            iZzf = zzku.zzf(bArr, i28, zznkVar, zzktVar3);
                                            i24 = i27;
                                            iZzh = iZzf;
                                            this = zzolVar5;
                                            i25 = i28;
                                            i2 = i26;
                                        }
                                        z4 = true;
                                        if (iZzh != i25) {
                                            i3 = i3;
                                            i33 = i12;
                                            i34 = i24;
                                            zzolVar6 = this;
                                            i31 = -1;
                                            i35 = i9;
                                            i32 = i42;
                                            i36 = i10;
                                            unsafe2 = unsafe;
                                        } else {
                                            i4 = i3;
                                            iZzl = iZzh;
                                            zzolVar2 = this;
                                            i13 = i42;
                                            i7 = i24;
                                            zzktVar2 = zzktVar3;
                                        }
                                        break;
                                    case 23:
                                    case 32:
                                    case MotionEventCompat.AXIS_GENERIC_9 /* 40 */:
                                    case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                                        i26 = i2;
                                        i27 = i43;
                                        unsafe = unsafe;
                                        i28 = i37;
                                        zzolVar5 = this;
                                        if (i40 == 2) {
                                            int i66 = zzku.zza;
                                            zznx zznxVar3 = (zznx) zznkVar;
                                            iZzf = zzku.zzi(bArr, i28, zzktVar3);
                                            int i67 = zzktVar3.zza;
                                            int i68 = iZzf + i67;
                                            if (i68 > bArr.length) {
                                                throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            zznxVar3.zzh(zznxVar3.size() + (i67 / 8));
                                            while (iZzf < i68) {
                                                zznxVar3.zzg(zzku.zzp(bArr, iZzf));
                                                iZzf += 8;
                                            }
                                            if (iZzf != i68) {
                                                throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        } else if (i40 != 1) {
                                            i24 = i27;
                                            z4 = true;
                                            this = zzolVar5;
                                            i25 = i28;
                                            i2 = i26;
                                            iZzh = i25;
                                            if (iZzh != i25) {
                                                i3 = i3;
                                                i33 = i12;
                                                i34 = i24;
                                                zzolVar6 = this;
                                                i31 = -1;
                                                i35 = i9;
                                                i32 = i42;
                                                i36 = i10;
                                                unsafe2 = unsafe;
                                            } else {
                                                i4 = i3;
                                                iZzl = iZzh;
                                                zzolVar2 = this;
                                                i13 = i42;
                                                i7 = i24;
                                                zzktVar2 = zzktVar3;
                                            }
                                            break;
                                        } else {
                                            iZzf = i28 + 8;
                                            int i69 = zzku.zza;
                                            zznx zznxVar4 = (zznx) zznkVar;
                                            zznxVar4.zzg(zzku.zzp(bArr, i28));
                                            while (iZzf < i26) {
                                                int iZzi5 = zzku.zzi(bArr, iZzf, zzktVar3);
                                                if (i27 == zzktVar3.zza) {
                                                    zznxVar4.zzg(zzku.zzp(bArr, iZzi5));
                                                    iZzf = iZzi5 + 8;
                                                }
                                            }
                                        }
                                        i24 = i27;
                                        iZzh = iZzf;
                                        this = zzolVar5;
                                        i25 = i28;
                                        i2 = i26;
                                        z4 = true;
                                        if (iZzh != i25) {
                                            i3 = i3;
                                            i33 = i12;
                                            i34 = i24;
                                            zzolVar6 = this;
                                            i31 = -1;
                                            i35 = i9;
                                            i32 = i42;
                                            i36 = i10;
                                            unsafe2 = unsafe;
                                        } else {
                                            i4 = i3;
                                            iZzl = iZzh;
                                            zzolVar2 = this;
                                            i13 = i42;
                                            i7 = i24;
                                            zzktVar2 = zzktVar3;
                                        }
                                        break;
                                    case 24:
                                    case 31:
                                    case MotionEventCompat.AXIS_GENERIC_10 /* 41 */:
                                    case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                                        i26 = i2;
                                        i27 = i43;
                                        unsafe = unsafe;
                                        i28 = i37;
                                        zzolVar5 = this;
                                        if (i40 != 2) {
                                            if (i40 == 5) {
                                                iZzf = i28 + 4;
                                                int i70 = zzku.zza;
                                                zzne zzneVar = (zzne) zznkVar;
                                                zzneVar.zzh(zzku.zzb(bArr, i28));
                                                while (iZzf < i26) {
                                                    int iZzi6 = zzku.zzi(bArr, iZzf, zzktVar3);
                                                    if (i27 == zzktVar3.zza) {
                                                        zzneVar.zzh(zzku.zzb(bArr, iZzi6));
                                                        iZzf = iZzi6 + 4;
                                                    }
                                                }
                                            }
                                            i24 = i27;
                                            this = zzolVar5;
                                            i25 = i28;
                                            i2 = i26;
                                            z4 = true;
                                            iZzh = i25;
                                            if (iZzh != i25) {
                                                i3 = i3;
                                                i33 = i12;
                                                i34 = i24;
                                                zzolVar6 = this;
                                                i31 = -1;
                                                i35 = i9;
                                                i32 = i42;
                                                i36 = i10;
                                                unsafe2 = unsafe;
                                            } else {
                                                i4 = i3;
                                                iZzl = iZzh;
                                                zzolVar2 = this;
                                                i13 = i42;
                                                i7 = i24;
                                                zzktVar2 = zzktVar3;
                                            }
                                        } else {
                                            int i71 = zzku.zza;
                                            zzne zzneVar2 = (zzne) zznkVar;
                                            iZzf = zzku.zzi(bArr, i28, zzktVar3);
                                            int i72 = zzktVar3.zza;
                                            int i73 = iZzf + i72;
                                            if (i73 > bArr.length) {
                                                throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            zzneVar2.zzi(zzneVar2.size() + (i72 / 4));
                                            while (iZzf < i73) {
                                                zzneVar2.zzh(zzku.zzb(bArr, iZzf));
                                                iZzf += 4;
                                            }
                                            if (iZzf != i73) {
                                                throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        i24 = i27;
                                        iZzh = iZzf;
                                        this = zzolVar5;
                                        i25 = i28;
                                        i2 = i26;
                                        z4 = true;
                                        if (iZzh != i25) {
                                            i3 = i3;
                                            i33 = i12;
                                            i34 = i24;
                                            zzolVar6 = this;
                                            i31 = -1;
                                            i35 = i9;
                                            i32 = i42;
                                            i36 = i10;
                                            unsafe2 = unsafe;
                                        } else {
                                            i4 = i3;
                                            iZzl = iZzh;
                                            zzolVar2 = this;
                                            i13 = i42;
                                            i7 = i24;
                                            zzktVar2 = zzktVar3;
                                        }
                                        break;
                                    case 25:
                                    case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                                        i26 = i2;
                                        i27 = i43;
                                        unsafe = unsafe;
                                        i28 = i37;
                                        zzolVar5 = this;
                                        if (i40 != 2) {
                                            if (i40 == 0) {
                                                int i74 = zzku.zza;
                                                zzkv zzkvVar = (zzkv) zznkVar;
                                                iZzf = zzku.zzl(bArr, i28, zzktVar3);
                                                zzkvVar.zze(zzktVar3.zzb != 0);
                                                while (iZzf < i26) {
                                                    int iZzi7 = zzku.zzi(bArr, iZzf, zzktVar3);
                                                    if (i27 == zzktVar3.zza) {
                                                        iZzf = zzku.zzl(bArr, iZzi7, zzktVar3);
                                                        zzkvVar.zze(zzktVar3.zzb != 0);
                                                    }
                                                }
                                            }
                                            i24 = i27;
                                            this = zzolVar5;
                                            i25 = i28;
                                            i2 = i26;
                                            z4 = true;
                                            iZzh = i25;
                                            if (iZzh != i25) {
                                                i3 = i3;
                                                i33 = i12;
                                                i34 = i24;
                                                zzolVar6 = this;
                                                i31 = -1;
                                                i35 = i9;
                                                i32 = i42;
                                                i36 = i10;
                                                unsafe2 = unsafe;
                                            } else {
                                                i4 = i3;
                                                iZzl = iZzh;
                                                zzolVar2 = this;
                                                i13 = i42;
                                                i7 = i24;
                                                zzktVar2 = zzktVar3;
                                            }
                                        } else {
                                            int i75 = zzku.zza;
                                            zzkv zzkvVar2 = (zzkv) zznkVar;
                                            iZzf = zzku.zzi(bArr, i28, zzktVar3);
                                            int i76 = zzktVar3.zza + iZzf;
                                            while (iZzf < i76) {
                                                iZzf = zzku.zzl(bArr, iZzf, zzktVar3);
                                                zzkvVar2.zze(zzktVar3.zzb != 0);
                                            }
                                            if (iZzf != i76) {
                                                throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        i24 = i27;
                                        iZzh = iZzf;
                                        this = zzolVar5;
                                        i25 = i28;
                                        i2 = i26;
                                        z4 = true;
                                        if (iZzh != i25) {
                                            i3 = i3;
                                            i33 = i12;
                                            i34 = i24;
                                            zzolVar6 = this;
                                            i31 = -1;
                                            i35 = i9;
                                            i32 = i42;
                                            i36 = i10;
                                            unsafe2 = unsafe;
                                        } else {
                                            i4 = i3;
                                            iZzl = iZzh;
                                            zzolVar2 = this;
                                            i13 = i42;
                                            i7 = i24;
                                            zzktVar2 = zzktVar3;
                                        }
                                        break;
                                    case 26:
                                        i29 = i43;
                                        unsafe = unsafe;
                                        int i77 = i37;
                                        if (i40 == 2) {
                                            if ((j2 & 536870912) == 0) {
                                                iZzi = zzku.zzi(bArr, i77, zzktVar3);
                                                int i78 = zzktVar3.zza;
                                                if (i78 < 0) {
                                                    throw new zznn("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                                if (i78 == 0) {
                                                    obj3 = "";
                                                    zznkVar.add(obj3);
                                                } else {
                                                    obj3 = "";
                                                    zznkVar.add(new String(bArr, iZzi, i78, zznl.zza));
                                                    iZzi += i78;
                                                }
                                                while (iZzi < i2) {
                                                    int iZzi8 = zzku.zzi(bArr, iZzi, zzktVar3);
                                                    if (i29 == zzktVar3.zza) {
                                                        iZzi = zzku.zzi(bArr, iZzi8, zzktVar3);
                                                        int i79 = zzktVar3.zza;
                                                        if (i79 < 0) {
                                                            throw new zznn("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                        }
                                                        if (i79 == 0) {
                                                            zznkVar.add(obj3);
                                                        } else {
                                                            zznkVar.add(new String(bArr, iZzi, i79, zznl.zza));
                                                            iZzi += i79;
                                                        }
                                                    } else {
                                                        this = this;
                                                        i25 = i77;
                                                        i2 = i2;
                                                        z4 = true;
                                                        zzktVar3 = zzktVar3;
                                                    }
                                                }
                                                this = this;
                                                i25 = i77;
                                                i2 = i2;
                                                z4 = true;
                                                zzktVar3 = zzktVar3;
                                            } else {
                                                iZzi = zzku.zzi(bArr, i77, zzktVar3);
                                                int i80 = zzktVar3.zza;
                                                if (i80 < 0) {
                                                    throw new zznn("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                                if (i80 == 0) {
                                                    zznkVar.add("");
                                                } else {
                                                    int i81 = iZzi + i80;
                                                    if (!zzpv.zze(bArr, iZzi, i81)) {
                                                        throw new zznn("Protocol message had invalid UTF-8.");
                                                    }
                                                    zznkVar.add(new String(bArr, iZzi, i80, zznl.zza));
                                                    iZzi = i81;
                                                }
                                                while (iZzi < i2) {
                                                    int iZzi9 = zzku.zzi(bArr, iZzi, zzktVar3);
                                                    if (i29 == zzktVar3.zza) {
                                                        iZzi = zzku.zzi(bArr, iZzi9, zzktVar3);
                                                        int i82 = zzktVar3.zza;
                                                        if (i82 < 0) {
                                                            throw new zznn("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                        }
                                                        if (i82 == 0) {
                                                            zznkVar.add("");
                                                        } else {
                                                            int i83 = iZzi + i82;
                                                            if (!zzpv.zze(bArr, iZzi, i83)) {
                                                                throw new zznn("Protocol message had invalid UTF-8.");
                                                            }
                                                            zznkVar.add(new String(bArr, iZzi, i82, zznl.zza));
                                                            iZzi = i83;
                                                        }
                                                    } else {
                                                        zzktVar3 = zzktVar3;
                                                        this = this;
                                                        i25 = i77;
                                                        i2 = i2;
                                                        z4 = true;
                                                    }
                                                }
                                                zzktVar3 = zzktVar3;
                                                this = this;
                                                i25 = i77;
                                                i2 = i2;
                                                z4 = true;
                                            }
                                            int i84 = iZzi;
                                            i24 = i29;
                                            iZzh = i84;
                                            if (iZzh != i25) {
                                                i3 = i3;
                                                i33 = i12;
                                                i34 = i24;
                                                zzolVar6 = this;
                                                i31 = -1;
                                                i35 = i9;
                                                i32 = i42;
                                                i36 = i10;
                                                unsafe2 = unsafe;
                                            } else {
                                                i4 = i3;
                                                iZzl = iZzh;
                                                zzolVar2 = this;
                                                i13 = i42;
                                                i7 = i24;
                                                zzktVar2 = zzktVar3;
                                            }
                                        } else {
                                            i24 = i29;
                                            this = this;
                                            i25 = i77;
                                            i2 = i2;
                                            z4 = true;
                                            zzktVar3 = zzktVar3;
                                            iZzh = i25;
                                            if (iZzh != i25) {
                                                i3 = i3;
                                                i33 = i12;
                                                i34 = i24;
                                                zzolVar6 = this;
                                                i31 = -1;
                                                i35 = i9;
                                                i32 = i42;
                                                i36 = i10;
                                                unsafe2 = unsafe;
                                            } else {
                                                i4 = i3;
                                                iZzl = iZzh;
                                                zzolVar2 = this;
                                                i13 = i42;
                                                i7 = i24;
                                                zzktVar2 = zzktVar3;
                                            }
                                        }
                                        break;
                                    case MotionEventCompat.AXIS_RELATIVE_X /* 27 */:
                                        this = this;
                                        i37 = i37;
                                        i30 = i2;
                                        z5 = true;
                                        unsafe = unsafe;
                                        if (i40 == 2) {
                                            i29 = i43;
                                            i25 = i37;
                                            iZzi = zzku.zze(this.zzx(i12), i43, bArr, i25, i2, zznkVar, zzktVar);
                                            z4 = true;
                                            zzktVar3 = zzktVar3;
                                            this = this;
                                            i2 = i30;
                                            int i85 = iZzi;
                                            i24 = i29;
                                            iZzh = i85;
                                            if (iZzh != i25) {
                                                i3 = i3;
                                                i33 = i12;
                                                i34 = i24;
                                                zzolVar6 = this;
                                                i31 = -1;
                                                i35 = i9;
                                                i32 = i42;
                                                i36 = i10;
                                                unsafe2 = unsafe;
                                            } else {
                                                i4 = i3;
                                                iZzl = iZzh;
                                                zzolVar2 = this;
                                                i13 = i42;
                                                i7 = i24;
                                                zzktVar2 = zzktVar3;
                                            }
                                        }
                                        z4 = z5;
                                        i2 = i30;
                                        i25 = i37;
                                        i24 = i43;
                                        iZzh = i25;
                                        if (iZzh != i25) {
                                            i3 = i3;
                                            i33 = i12;
                                            i34 = i24;
                                            zzolVar6 = this;
                                            i31 = -1;
                                            i35 = i9;
                                            i32 = i42;
                                            i36 = i10;
                                            unsafe2 = unsafe;
                                        } else {
                                            i4 = i3;
                                            iZzl = iZzh;
                                            zzolVar2 = this;
                                            i13 = i42;
                                            i7 = i24;
                                            zzktVar2 = zzktVar3;
                                        }
                                        break;
                                    case MotionEventCompat.AXIS_RELATIVE_Y /* 28 */:
                                        this = this;
                                        i37 = i37;
                                        i30 = i2;
                                        z5 = true;
                                        unsafe = unsafe;
                                        if (i40 == 2) {
                                            iZzh = zzku.zzi(bArr, i37, zzktVar3);
                                            int i86 = zzktVar3.zza;
                                            if (i86 < 0) {
                                                throw new zznn("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                            }
                                            if (i86 > bArr.length - iZzh) {
                                                throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            if (i86 == 0) {
                                                zznkVar.add(zzle.zzb);
                                            } else {
                                                zznkVar.add(zzle.zzk(bArr, iZzh, i86));
                                                iZzh += i86;
                                            }
                                            while (iZzh < i30) {
                                                int iZzi10 = zzku.zzi(bArr, iZzh, zzktVar3);
                                                if (i43 != zzktVar3.zza) {
                                                    z4 = true;
                                                    i2 = i30;
                                                    i25 = i37;
                                                    i24 = i43;
                                                    if (iZzh != i25) {
                                                        i3 = i3;
                                                        i33 = i12;
                                                        i34 = i24;
                                                        zzolVar6 = this;
                                                        i31 = -1;
                                                        i35 = i9;
                                                        i32 = i42;
                                                        i36 = i10;
                                                        unsafe2 = unsafe;
                                                    } else {
                                                        i4 = i3;
                                                        iZzl = iZzh;
                                                        zzolVar2 = this;
                                                        i13 = i42;
                                                        i7 = i24;
                                                        zzktVar2 = zzktVar3;
                                                    }
                                                    break;
                                                } else {
                                                    iZzh = zzku.zzi(bArr, iZzi10, zzktVar3);
                                                    int i87 = zzktVar3.zza;
                                                    if (i87 < 0) {
                                                        throw new zznn("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                    }
                                                    if (i87 > bArr.length - iZzh) {
                                                        throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                    }
                                                    if (i87 == 0) {
                                                        zznkVar.add(zzle.zzb);
                                                    } else {
                                                        zznkVar.add(zzle.zzk(bArr, iZzh, i87));
                                                        iZzh += i87;
                                                    }
                                                }
                                            }
                                            z4 = true;
                                            i2 = i30;
                                            i25 = i37;
                                            i24 = i43;
                                            if (iZzh != i25) {
                                                i3 = i3;
                                                i33 = i12;
                                                i34 = i24;
                                                zzolVar6 = this;
                                                i31 = -1;
                                                i35 = i9;
                                                i32 = i42;
                                                i36 = i10;
                                                unsafe2 = unsafe;
                                            } else {
                                                i4 = i3;
                                                iZzl = iZzh;
                                                zzolVar2 = this;
                                                i13 = i42;
                                                i7 = i24;
                                                zzktVar2 = zzktVar3;
                                            }
                                        }
                                        z4 = z5;
                                        i2 = i30;
                                        i25 = i37;
                                        i24 = i43;
                                        iZzh = i25;
                                        if (iZzh != i25) {
                                            i3 = i3;
                                            i33 = i12;
                                            i34 = i24;
                                            zzolVar6 = this;
                                            i31 = -1;
                                            i35 = i9;
                                            i32 = i42;
                                            i36 = i10;
                                            unsafe2 = unsafe;
                                        } else {
                                            i4 = i3;
                                            iZzl = iZzh;
                                            zzolVar2 = this;
                                            i13 = i42;
                                            i7 = i24;
                                            zzktVar2 = zzktVar3;
                                        }
                                        break;
                                    case 30:
                                    case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                                        if (i40 == 2) {
                                            iZzk = zzku.zzf(bArr, i37, zznkVar, zzktVar3);
                                        } else if (i40 != 0) {
                                            unsafe = unsafe;
                                            this = this;
                                            i2 = i2;
                                            i24 = i43;
                                            z4 = true;
                                            i25 = i37;
                                            iZzh = i25;
                                            if (iZzh != i25) {
                                                i3 = i3;
                                                i33 = i12;
                                                i34 = i24;
                                                zzolVar6 = this;
                                                i31 = -1;
                                                i35 = i9;
                                                i32 = i42;
                                                i36 = i10;
                                                unsafe2 = unsafe;
                                            } else {
                                                i4 = i3;
                                                iZzl = iZzh;
                                                zzolVar2 = this;
                                                i13 = i42;
                                                i7 = i24;
                                                zzktVar2 = zzktVar3;
                                            }
                                        } else {
                                            iZzk = zzku.zzk(i43, bArr, i37, i2, zznkVar, zzktVar);
                                        }
                                        int i88 = iZzk;
                                        zzoy.zzn(obj, i42, zznkVar, zzw(i12), null, this.zzm);
                                        z4 = true;
                                        iZzh = i88;
                                        i2 = i2;
                                        i25 = i37;
                                        i24 = i43;
                                        if (iZzh != i25) {
                                            i3 = i3;
                                            i33 = i12;
                                            i34 = i24;
                                            zzolVar6 = this;
                                            i31 = -1;
                                            i35 = i9;
                                            i32 = i42;
                                            i36 = i10;
                                            unsafe2 = unsafe;
                                        } else {
                                            i4 = i3;
                                            iZzl = iZzh;
                                            zzolVar2 = this;
                                            i13 = i42;
                                            i7 = i24;
                                            zzktVar2 = zzktVar3;
                                        }
                                        break;
                                    case 33:
                                    case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                                        if (i40 != 2) {
                                            if (i40 == 0) {
                                                int i89 = zzku.zza;
                                                zzne zzneVar3 = (zzne) zznkVar;
                                                iZzh = zzku.zzi(bArr, i37, zzktVar3);
                                                zzneVar3.zzh(zzli.zzF(zzktVar3.zza));
                                                while (iZzh < i2) {
                                                    int iZzi11 = zzku.zzi(bArr, iZzh, zzktVar3);
                                                    if (i43 == zzktVar3.zza) {
                                                        iZzh = zzku.zzi(bArr, iZzi11, zzktVar3);
                                                        zzneVar3.zzh(zzli.zzF(zzktVar3.zza));
                                                    }
                                                }
                                            }
                                            this = this;
                                            i2 = i2;
                                            i24 = i43;
                                            unsafe = unsafe;
                                            i25 = i37;
                                            z4 = true;
                                            iZzh = i25;
                                            if (iZzh != i25) {
                                                i3 = i3;
                                                i33 = i12;
                                                i34 = i24;
                                                zzolVar6 = this;
                                                i31 = -1;
                                                i35 = i9;
                                                i32 = i42;
                                                i36 = i10;
                                                unsafe2 = unsafe;
                                            } else {
                                                i4 = i3;
                                                iZzl = iZzh;
                                                zzolVar2 = this;
                                                i13 = i42;
                                                i7 = i24;
                                                zzktVar2 = zzktVar3;
                                            }
                                        } else {
                                            int i90 = zzku.zza;
                                            zzne zzneVar4 = (zzne) zznkVar;
                                            iZzh = zzku.zzi(bArr, i37, zzktVar3);
                                            int i91 = zzktVar3.zza + iZzh;
                                            while (iZzh < i91) {
                                                iZzh = zzku.zzi(bArr, iZzh, zzktVar3);
                                                zzneVar4.zzh(zzli.zzF(zzktVar3.zza));
                                            }
                                            if (iZzh != i91) {
                                                throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        this = this;
                                        i2 = i2;
                                        i24 = i43;
                                        unsafe = unsafe;
                                        i25 = i37;
                                        z4 = true;
                                        if (iZzh != i25) {
                                            i3 = i3;
                                            i33 = i12;
                                            i34 = i24;
                                            zzolVar6 = this;
                                            i31 = -1;
                                            i35 = i9;
                                            i32 = i42;
                                            i36 = i10;
                                            unsafe2 = unsafe;
                                        } else {
                                            i4 = i3;
                                            iZzl = iZzh;
                                            zzolVar2 = this;
                                            i13 = i42;
                                            i7 = i24;
                                            zzktVar2 = zzktVar3;
                                        }
                                        break;
                                    case MotionEventCompat.AXIS_GENERIC_3 /* 34 */:
                                    case 48:
                                        if (i40 != 2) {
                                            if (i40 == 0) {
                                                int i92 = zzku.zza;
                                                zznx zznxVar5 = (zznx) zznkVar;
                                                iZzh = zzku.zzl(bArr, i37, zzktVar3);
                                                zznxVar5.zzg(zzli.zzG(zzktVar3.zzb));
                                                while (iZzh < i2) {
                                                    int iZzi12 = zzku.zzi(bArr, iZzh, zzktVar3);
                                                    if (i43 == zzktVar3.zza) {
                                                        iZzh = zzku.zzl(bArr, iZzi12, zzktVar3);
                                                        zznxVar5.zzg(zzli.zzG(zzktVar3.zzb));
                                                    }
                                                }
                                            }
                                            this = this;
                                            i2 = i2;
                                            i24 = i43;
                                            unsafe = unsafe;
                                            i25 = i37;
                                            z4 = true;
                                            iZzh = i25;
                                            if (iZzh != i25) {
                                                i3 = i3;
                                                i33 = i12;
                                                i34 = i24;
                                                zzolVar6 = this;
                                                i31 = -1;
                                                i35 = i9;
                                                i32 = i42;
                                                i36 = i10;
                                                unsafe2 = unsafe;
                                            } else {
                                                i4 = i3;
                                                iZzl = iZzh;
                                                zzolVar2 = this;
                                                i13 = i42;
                                                i7 = i24;
                                                zzktVar2 = zzktVar3;
                                            }
                                        } else {
                                            int i93 = zzku.zza;
                                            zznx zznxVar6 = (zznx) zznkVar;
                                            iZzh = zzku.zzi(bArr, i37, zzktVar3);
                                            int i94 = zzktVar3.zza + iZzh;
                                            while (iZzh < i94) {
                                                iZzh = zzku.zzl(bArr, iZzh, zzktVar3);
                                                zznxVar6.zzg(zzli.zzG(zzktVar3.zzb));
                                            }
                                            if (iZzh != i94) {
                                                throw new zznn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        this = this;
                                        i2 = i2;
                                        i24 = i43;
                                        unsafe = unsafe;
                                        i25 = i37;
                                        z4 = true;
                                        if (iZzh != i25) {
                                            i3 = i3;
                                            i33 = i12;
                                            i34 = i24;
                                            zzolVar6 = this;
                                            i31 = -1;
                                            i35 = i9;
                                            i32 = i42;
                                            i36 = i10;
                                            unsafe2 = unsafe;
                                        } else {
                                            i4 = i3;
                                            iZzl = iZzh;
                                            zzolVar2 = this;
                                            i13 = i42;
                                            i7 = i24;
                                            zzktVar2 = zzktVar3;
                                        }
                                        break;
                                    default:
                                        this = this;
                                        i2 = i2;
                                        i24 = i43;
                                        z3 = true;
                                        unsafe = unsafe;
                                        i25 = i37;
                                        if (i40 == 3) {
                                            int i95 = (i24 & (-8)) | 4;
                                            zzow zzowVarZzx = this.zzx(i12);
                                            z4 = true;
                                            iZzh = zzku.zzc(zzowVarZzx, bArr, i25, i2, i95, zzktVar);
                                            zznkVar.add(zzktVar3.zzc);
                                            while (iZzh < i2) {
                                                int iZzi13 = zzku.zzi(bArr, iZzh, zzktVar3);
                                                if (i24 == zzktVar3.zza) {
                                                    iZzh = zzku.zzc(zzowVarZzx, bArr, iZzi13, i2, i95, zzktVar);
                                                    zznkVar.add(zzktVar3.zzc);
                                                }
                                            }
                                        } else {
                                            z4 = z3;
                                            iZzh = i25;
                                        }
                                        if (iZzh != i25) {
                                            i3 = i3;
                                            i33 = i12;
                                            i34 = i24;
                                            zzolVar6 = this;
                                            i31 = -1;
                                            i35 = i9;
                                            i32 = i42;
                                            i36 = i10;
                                            unsafe2 = unsafe;
                                        } else {
                                            i4 = i3;
                                            iZzl = iZzh;
                                            zzolVar2 = this;
                                            i13 = i42;
                                            i7 = i24;
                                            zzktVar2 = zzktVar3;
                                        }
                                        break;
                                }
                            } else {
                                unsafe = unsafe;
                                zzolVar2 = this;
                                z2 = true;
                                i21 = i43;
                                if (iZzt != 50) {
                                    Unsafe unsafe5 = zzb;
                                    long j3 = iArr[i12 + 2] & 1048575;
                                    switch (iZzt) {
                                        case 51:
                                            i22 = i37;
                                            i7 = i21;
                                            i13 = i42;
                                            zzktVar2 = zzktVar;
                                            i12 = i12;
                                            if (i40 == 1) {
                                                iZzl3 = i22 + 8;
                                                unsafe5.putObject(obj, j, Double.valueOf(Double.longBitsToDouble(zzku.zzp(bArr, i22))));
                                                unsafe5.putInt(obj, j3, i13);
                                            } else {
                                                iZzl3 = i22;
                                            }
                                            if (iZzl3 == i22) {
                                                zzolVar2 = zzolVar2;
                                                i2 = i2;
                                                i3 = i3;
                                                i32 = i13;
                                                iZzh = iZzl3;
                                                zzktVar3 = zzktVar2;
                                                i34 = i7;
                                                i31 = -1;
                                                i35 = i9;
                                                i33 = i12;
                                                unsafe2 = unsafe;
                                                zzolVar6 = zzolVar2;
                                                i36 = i10;
                                            } else {
                                                zzolVar2 = zzolVar2;
                                                i4 = i3;
                                                iZzl = iZzl3;
                                                i12 = i12;
                                            }
                                            break;
                                        case 52:
                                            i22 = i37;
                                            i7 = i21;
                                            i13 = i42;
                                            zzktVar2 = zzktVar;
                                            i12 = i12;
                                            if (i40 == 5) {
                                                iZzl3 = i22 + 4;
                                                unsafe5.putObject(obj, j, Float.valueOf(Float.intBitsToFloat(zzku.zzb(bArr, i22))));
                                                unsafe5.putInt(obj, j3, i13);
                                            } else {
                                                iZzl3 = i22;
                                            }
                                            if (iZzl3 == i22) {
                                                zzolVar2 = zzolVar2;
                                                i2 = i2;
                                                i3 = i3;
                                                i32 = i13;
                                                iZzh = iZzl3;
                                                zzktVar3 = zzktVar2;
                                                i34 = i7;
                                                i31 = -1;
                                                i35 = i9;
                                                i33 = i12;
                                                unsafe2 = unsafe;
                                                zzolVar6 = zzolVar2;
                                                i36 = i10;
                                            } else {
                                                zzolVar2 = zzolVar2;
                                                i4 = i3;
                                                iZzl = iZzl3;
                                                i12 = i12;
                                            }
                                            break;
                                        case 53:
                                        case 54:
                                            i22 = i37;
                                            i7 = i21;
                                            i13 = i42;
                                            zzktVar2 = zzktVar;
                                            i12 = i12;
                                            if (i40 == 0) {
                                                iZzl3 = zzku.zzl(bArr, i22, zzktVar2);
                                                unsafe5.putObject(obj, j, Long.valueOf(zzktVar2.zzb));
                                                unsafe5.putInt(obj, j3, i13);
                                            } else {
                                                iZzl3 = i22;
                                            }
                                            if (iZzl3 == i22) {
                                                zzolVar2 = zzolVar2;
                                                i2 = i2;
                                                i3 = i3;
                                                i32 = i13;
                                                iZzh = iZzl3;
                                                zzktVar3 = zzktVar2;
                                                i34 = i7;
                                                i31 = -1;
                                                i35 = i9;
                                                i33 = i12;
                                                unsafe2 = unsafe;
                                                zzolVar6 = zzolVar2;
                                                i36 = i10;
                                            } else {
                                                zzolVar2 = zzolVar2;
                                                i4 = i3;
                                                iZzl = iZzl3;
                                                i12 = i12;
                                            }
                                            break;
                                        case 55:
                                        case 62:
                                            i22 = i37;
                                            i7 = i21;
                                            i13 = i42;
                                            zzktVar2 = zzktVar;
                                            i12 = i12;
                                            if (i40 == 0) {
                                                iZzl3 = zzku.zzi(bArr, i22, zzktVar2);
                                                unsafe5.putObject(obj, j, Integer.valueOf(zzktVar2.zza));
                                                unsafe5.putInt(obj, j3, i13);
                                            } else {
                                                iZzl3 = i22;
                                            }
                                            if (iZzl3 == i22) {
                                                zzolVar2 = zzolVar2;
                                                i2 = i2;
                                                i3 = i3;
                                                i32 = i13;
                                                iZzh = iZzl3;
                                                zzktVar3 = zzktVar2;
                                                i34 = i7;
                                                i31 = -1;
                                                i35 = i9;
                                                i33 = i12;
                                                unsafe2 = unsafe;
                                                zzolVar6 = zzolVar2;
                                                i36 = i10;
                                            } else {
                                                zzolVar2 = zzolVar2;
                                                i4 = i3;
                                                iZzl = iZzl3;
                                                i12 = i12;
                                            }
                                            break;
                                        case 56:
                                        case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                                            i22 = i37;
                                            i7 = i21;
                                            i13 = i42;
                                            zzktVar2 = zzktVar;
                                            i12 = i12;
                                            if (i40 == 1) {
                                                iZzl3 = i22 + 8;
                                                unsafe5.putObject(obj, j, Long.valueOf(zzku.zzp(bArr, i22)));
                                                unsafe5.putInt(obj, j3, i13);
                                            } else {
                                                iZzl3 = i22;
                                            }
                                            if (iZzl3 == i22) {
                                                zzolVar2 = zzolVar2;
                                                i2 = i2;
                                                i3 = i3;
                                                i32 = i13;
                                                iZzh = iZzl3;
                                                zzktVar3 = zzktVar2;
                                                i34 = i7;
                                                i31 = -1;
                                                i35 = i9;
                                                i33 = i12;
                                                unsafe2 = unsafe;
                                                zzolVar6 = zzolVar2;
                                                i36 = i10;
                                            } else {
                                                zzolVar2 = zzolVar2;
                                                i4 = i3;
                                                iZzl = iZzl3;
                                                i12 = i12;
                                            }
                                            break;
                                        case 57:
                                        case 64:
                                            i22 = i37;
                                            i7 = i21;
                                            i13 = i42;
                                            zzktVar2 = zzktVar;
                                            i12 = i12;
                                            if (i40 == 5) {
                                                iZzl4 = i22 + 4;
                                                unsafe5.putObject(obj, j, Integer.valueOf(zzku.zzb(bArr, i22)));
                                                unsafe5.putInt(obj, j3, i13);
                                                iZzl3 = iZzl4;
                                                if (iZzl3 == i22) {
                                                    zzolVar2 = zzolVar2;
                                                    i2 = i2;
                                                    i3 = i3;
                                                    i32 = i13;
                                                    iZzh = iZzl3;
                                                    zzktVar3 = zzktVar2;
                                                    i34 = i7;
                                                    i31 = -1;
                                                    i35 = i9;
                                                    i33 = i12;
                                                    unsafe2 = unsafe;
                                                    zzolVar6 = zzolVar2;
                                                    i36 = i10;
                                                } else {
                                                    zzolVar2 = zzolVar2;
                                                    i4 = i3;
                                                    iZzl = iZzl3;
                                                    i12 = i12;
                                                }
                                            }
                                            iZzl3 = i22;
                                            if (iZzl3 == i22) {
                                                zzolVar2 = zzolVar2;
                                                i2 = i2;
                                                i3 = i3;
                                                i32 = i13;
                                                iZzh = iZzl3;
                                                zzktVar3 = zzktVar2;
                                                i34 = i7;
                                                i31 = -1;
                                                i35 = i9;
                                                i33 = i12;
                                                unsafe2 = unsafe;
                                                zzolVar6 = zzolVar2;
                                                i36 = i10;
                                            } else {
                                                zzolVar2 = zzolVar2;
                                                i4 = i3;
                                                iZzl = iZzl3;
                                                i12 = i12;
                                            }
                                            break;
                                        case 58:
                                            i22 = i37;
                                            i7 = i21;
                                            i13 = i42;
                                            zzktVar2 = zzktVar;
                                            i12 = i12;
                                            if (i40 == 0) {
                                                iZzl4 = zzku.zzl(bArr, i22, zzktVar2);
                                                unsafe5.putObject(obj, j, Boolean.valueOf(zzktVar2.zzb != 0));
                                                unsafe5.putInt(obj, j3, i13);
                                                iZzl3 = iZzl4;
                                                if (iZzl3 == i22) {
                                                    zzolVar2 = zzolVar2;
                                                    i2 = i2;
                                                    i3 = i3;
                                                    i32 = i13;
                                                    iZzh = iZzl3;
                                                    zzktVar3 = zzktVar2;
                                                    i34 = i7;
                                                    i31 = -1;
                                                    i35 = i9;
                                                    i33 = i12;
                                                    unsafe2 = unsafe;
                                                    zzolVar6 = zzolVar2;
                                                    i36 = i10;
                                                } else {
                                                    zzolVar2 = zzolVar2;
                                                    i4 = i3;
                                                    iZzl = iZzl3;
                                                    i12 = i12;
                                                }
                                            }
                                            iZzl3 = i22;
                                            if (iZzl3 == i22) {
                                                zzolVar2 = zzolVar2;
                                                i2 = i2;
                                                i3 = i3;
                                                i32 = i13;
                                                iZzh = iZzl3;
                                                zzktVar3 = zzktVar2;
                                                i34 = i7;
                                                i31 = -1;
                                                i35 = i9;
                                                i33 = i12;
                                                unsafe2 = unsafe;
                                                zzolVar6 = zzolVar2;
                                                i36 = i10;
                                            } else {
                                                zzolVar2 = zzolVar2;
                                                i4 = i3;
                                                iZzl = iZzl3;
                                                i12 = i12;
                                            }
                                            break;
                                        case 59:
                                            i22 = i37;
                                            i7 = i21;
                                            i13 = i42;
                                            zzktVar2 = zzktVar;
                                            if (i40 == 2) {
                                                iZzl4 = zzku.zzi(bArr, i22, zzktVar2);
                                                int i96 = zzktVar2.zza;
                                                if (i96 == 0) {
                                                    unsafe5.putObject(obj, j, "");
                                                } else {
                                                    int i97 = iZzl4 + i96;
                                                    if ((i41 & 536870912) != 0 && !zzpv.zze(bArr, iZzl4, i97)) {
                                                        throw new zznn("Protocol message had invalid UTF-8.");
                                                    }
                                                    unsafe5.putObject(obj, j, new String(bArr, iZzl4, i96, zznl.zza));
                                                    iZzl4 = i97;
                                                }
                                                unsafe5.putInt(obj, j3, i13);
                                                iZzl3 = iZzl4;
                                                if (iZzl3 == i22) {
                                                    zzolVar2 = zzolVar2;
                                                    i2 = i2;
                                                    i3 = i3;
                                                    i32 = i13;
                                                    iZzh = iZzl3;
                                                    zzktVar3 = zzktVar2;
                                                    i34 = i7;
                                                    i31 = -1;
                                                    i35 = i9;
                                                    i33 = i12;
                                                    unsafe2 = unsafe;
                                                    zzolVar6 = zzolVar2;
                                                    i36 = i10;
                                                } else {
                                                    zzolVar2 = zzolVar2;
                                                    i4 = i3;
                                                    iZzl = iZzl3;
                                                    i12 = i12;
                                                }
                                            }
                                            i12 = i12;
                                            iZzl3 = i22;
                                            if (iZzl3 == i22) {
                                                zzolVar2 = zzolVar2;
                                                i2 = i2;
                                                i3 = i3;
                                                i32 = i13;
                                                iZzh = iZzl3;
                                                zzktVar3 = zzktVar2;
                                                i34 = i7;
                                                i31 = -1;
                                                i35 = i9;
                                                i33 = i12;
                                                unsafe2 = unsafe;
                                                zzolVar6 = zzolVar2;
                                                i36 = i10;
                                            } else {
                                                zzolVar2 = zzolVar2;
                                                i4 = i3;
                                                iZzl = iZzl3;
                                                i12 = i12;
                                            }
                                            break;
                                        case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                                            i7 = i21;
                                            i23 = i42;
                                            zzktVar2 = zzktVar;
                                            if (i40 == 2) {
                                                Object objZzB = zzolVar2.zzB(obj, i23, i12);
                                                int i98 = i37;
                                                int iZzn = zzku.zzn(objZzB, zzolVar2.zzx(i12), bArr, i37, i2, zzktVar);
                                                zzolVar2.zzK(obj, i23, i12, objZzB);
                                                i12 = i12;
                                                i13 = i23;
                                                iZzl3 = iZzn;
                                                i22 = i98;
                                            } else {
                                                i22 = i37;
                                                i13 = i23;
                                                i12 = i12;
                                                iZzl3 = i22;
                                            }
                                            if (iZzl3 == i22) {
                                                zzolVar2 = zzolVar2;
                                                i2 = i2;
                                                i3 = i3;
                                                i32 = i13;
                                                iZzh = iZzl3;
                                                zzktVar3 = zzktVar2;
                                                i34 = i7;
                                                i31 = -1;
                                                i35 = i9;
                                                i33 = i12;
                                                unsafe2 = unsafe;
                                                zzolVar6 = zzolVar2;
                                                i36 = i10;
                                            } else {
                                                zzolVar2 = zzolVar2;
                                                i4 = i3;
                                                iZzl = iZzl3;
                                                i12 = i12;
                                            }
                                            break;
                                        case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                                            i7 = i21;
                                            i23 = i42;
                                            zzktVar2 = zzktVar;
                                            if (i40 == 2) {
                                                iZza = zzku.zza(bArr, i37, zzktVar2);
                                                unsafe5.putObject(obj, j, zzktVar2.zzc);
                                                unsafe5.putInt(obj, j3, i23);
                                                i12 = i12;
                                                iZzl3 = iZza;
                                                i22 = i37;
                                                i13 = i23;
                                                if (iZzl3 == i22) {
                                                    zzolVar2 = zzolVar2;
                                                    i2 = i2;
                                                    i3 = i3;
                                                    i32 = i13;
                                                    iZzh = iZzl3;
                                                    zzktVar3 = zzktVar2;
                                                    i34 = i7;
                                                    i31 = -1;
                                                    i35 = i9;
                                                    i33 = i12;
                                                    unsafe2 = unsafe;
                                                    zzolVar6 = zzolVar2;
                                                    i36 = i10;
                                                } else {
                                                    zzolVar2 = zzolVar2;
                                                    i4 = i3;
                                                    iZzl = iZzl3;
                                                    i12 = i12;
                                                }
                                            }
                                            i22 = i37;
                                            i13 = i23;
                                            i12 = i12;
                                            iZzl3 = i22;
                                            if (iZzl3 == i22) {
                                                zzolVar2 = zzolVar2;
                                                i2 = i2;
                                                i3 = i3;
                                                i32 = i13;
                                                iZzh = iZzl3;
                                                zzktVar3 = zzktVar2;
                                                i34 = i7;
                                                i31 = -1;
                                                i35 = i9;
                                                i33 = i12;
                                                unsafe2 = unsafe;
                                                zzolVar6 = zzolVar2;
                                                i36 = i10;
                                            } else {
                                                zzolVar2 = zzolVar2;
                                                i4 = i3;
                                                iZzl = iZzl3;
                                                i12 = i12;
                                            }
                                            break;
                                        case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                                            i7 = i21;
                                            i23 = i42;
                                            zzktVar2 = zzktVar;
                                            if (i40 == 0) {
                                                iZza = zzku.zzi(bArr, i37, zzktVar2);
                                                int i99 = zzktVar2.zza;
                                                zznh zznhVarZzw2 = zzolVar2.zzw(i12);
                                                if (zznhVarZzw2 == null || zznhVarZzw2.zza(i99)) {
                                                    unsafe5.putObject(obj, j, Integer.valueOf(i99));
                                                    unsafe5.putInt(obj, j3, i23);
                                                } else {
                                                    zzd(obj).zzj(i7, Long.valueOf(i99));
                                                }
                                                i12 = i12;
                                                iZzl3 = iZza;
                                                i22 = i37;
                                                i13 = i23;
                                                if (iZzl3 == i22) {
                                                    zzolVar2 = zzolVar2;
                                                    i2 = i2;
                                                    i3 = i3;
                                                    i32 = i13;
                                                    iZzh = iZzl3;
                                                    zzktVar3 = zzktVar2;
                                                    i34 = i7;
                                                    i31 = -1;
                                                    i35 = i9;
                                                    i33 = i12;
                                                    unsafe2 = unsafe;
                                                    zzolVar6 = zzolVar2;
                                                    i36 = i10;
                                                } else {
                                                    zzolVar2 = zzolVar2;
                                                    i4 = i3;
                                                    iZzl = iZzl3;
                                                    i12 = i12;
                                                }
                                            }
                                            i22 = i37;
                                            i13 = i23;
                                            i12 = i12;
                                            iZzl3 = i22;
                                            if (iZzl3 == i22) {
                                                zzolVar2 = zzolVar2;
                                                i2 = i2;
                                                i3 = i3;
                                                i32 = i13;
                                                iZzh = iZzl3;
                                                zzktVar3 = zzktVar2;
                                                i34 = i7;
                                                i31 = -1;
                                                i35 = i9;
                                                i33 = i12;
                                                unsafe2 = unsafe;
                                                zzolVar6 = zzolVar2;
                                                i36 = i10;
                                            } else {
                                                zzolVar2 = zzolVar2;
                                                i4 = i3;
                                                iZzl = iZzl3;
                                                i12 = i12;
                                            }
                                            break;
                                        case 66:
                                            i7 = i21;
                                            i23 = i42;
                                            zzktVar2 = zzktVar;
                                            if (i40 == 0) {
                                                iZza = zzku.zzi(bArr, i37, zzktVar2);
                                                unsafe5.putObject(obj, j, Integer.valueOf(zzli.zzF(zzktVar2.zza)));
                                                unsafe5.putInt(obj, j3, i23);
                                                i12 = i12;
                                                iZzl3 = iZza;
                                                i22 = i37;
                                                i13 = i23;
                                                if (iZzl3 == i22) {
                                                    zzolVar2 = zzolVar2;
                                                    i2 = i2;
                                                    i3 = i3;
                                                    i32 = i13;
                                                    iZzh = iZzl3;
                                                    zzktVar3 = zzktVar2;
                                                    i34 = i7;
                                                    i31 = -1;
                                                    i35 = i9;
                                                    i33 = i12;
                                                    unsafe2 = unsafe;
                                                    zzolVar6 = zzolVar2;
                                                    i36 = i10;
                                                } else {
                                                    zzolVar2 = zzolVar2;
                                                    i4 = i3;
                                                    iZzl = iZzl3;
                                                    i12 = i12;
                                                }
                                            }
                                            i22 = i37;
                                            i13 = i23;
                                            i12 = i12;
                                            iZzl3 = i22;
                                            if (iZzl3 == i22) {
                                                zzolVar2 = zzolVar2;
                                                i2 = i2;
                                                i3 = i3;
                                                i32 = i13;
                                                iZzh = iZzl3;
                                                zzktVar3 = zzktVar2;
                                                i34 = i7;
                                                i31 = -1;
                                                i35 = i9;
                                                i33 = i12;
                                                unsafe2 = unsafe;
                                                zzolVar6 = zzolVar2;
                                                i36 = i10;
                                            } else {
                                                zzolVar2 = zzolVar2;
                                                i4 = i3;
                                                iZzl = iZzl3;
                                                i12 = i12;
                                            }
                                            break;
                                        case 67:
                                            i7 = i21;
                                            i23 = i42;
                                            zzktVar2 = zzktVar;
                                            if (i40 == 0) {
                                                iZza = zzku.zzl(bArr, i37, zzktVar2);
                                                unsafe5.putObject(obj, j, Long.valueOf(zzli.zzG(zzktVar2.zzb)));
                                                unsafe5.putInt(obj, j3, i23);
                                                i12 = i12;
                                                iZzl3 = iZza;
                                                i22 = i37;
                                                i13 = i23;
                                                if (iZzl3 == i22) {
                                                    zzolVar2 = zzolVar2;
                                                    i2 = i2;
                                                    i3 = i3;
                                                    i32 = i13;
                                                    iZzh = iZzl3;
                                                    zzktVar3 = zzktVar2;
                                                    i34 = i7;
                                                    i31 = -1;
                                                    i35 = i9;
                                                    i33 = i12;
                                                    unsafe2 = unsafe;
                                                    zzolVar6 = zzolVar2;
                                                    i36 = i10;
                                                } else {
                                                    zzolVar2 = zzolVar2;
                                                    i4 = i3;
                                                    iZzl = iZzl3;
                                                    i12 = i12;
                                                }
                                            }
                                            i22 = i37;
                                            i13 = i23;
                                            i12 = i12;
                                            iZzl3 = i22;
                                            if (iZzl3 == i22) {
                                                zzolVar2 = zzolVar2;
                                                i2 = i2;
                                                i3 = i3;
                                                i32 = i13;
                                                iZzh = iZzl3;
                                                zzktVar3 = zzktVar2;
                                                i34 = i7;
                                                i31 = -1;
                                                i35 = i9;
                                                i33 = i12;
                                                unsafe2 = unsafe;
                                                zzolVar6 = zzolVar2;
                                                i36 = i10;
                                            } else {
                                                zzolVar2 = zzolVar2;
                                                i4 = i3;
                                                iZzl = iZzl3;
                                                i12 = i12;
                                            }
                                            break;
                                        case 68:
                                            if (i40 == 3) {
                                                Object objZzB2 = zzolVar2.zzB(obj, i42, i12);
                                                int iZzm2 = zzku.zzm(objZzB2, zzolVar2.zzx(i12), bArr, i37, i2, (i21 & (-8)) | 4, zzktVar);
                                                zzolVar2.zzK(obj, i42, i12, objZzB2);
                                                i7 = i21;
                                                i22 = i37;
                                                i13 = i42;
                                                i12 = i12;
                                                iZzl3 = iZzm2;
                                                zzktVar2 = zzktVar;
                                            }
                                            if (iZzl3 == i22) {
                                                zzolVar2 = zzolVar2;
                                                i4 = i3;
                                                iZzl = iZzl3;
                                                i12 = i12;
                                                break;
                                            } else {
                                                zzolVar2 = zzolVar2;
                                                i2 = i2;
                                                i3 = i3;
                                                i32 = i13;
                                                iZzh = iZzl3;
                                                zzktVar3 = zzktVar2;
                                                i34 = i7;
                                                i31 = -1;
                                                i35 = i9;
                                                i33 = i12;
                                                unsafe2 = unsafe;
                                                zzolVar6 = zzolVar2;
                                                i36 = i10;
                                                break;
                                            }
                                        default:
                                            i22 = i37;
                                            i7 = i21;
                                            i13 = i42;
                                            zzktVar2 = zzktVar;
                                            i12 = i12;
                                            iZzl3 = i22;
                                            if (iZzl3 == i22) {
                                                zzolVar2 = zzolVar2;
                                                i2 = i2;
                                                i3 = i3;
                                                i32 = i13;
                                                iZzh = iZzl3;
                                                zzktVar3 = zzktVar2;
                                                i34 = i7;
                                                i31 = -1;
                                                i35 = i9;
                                                i33 = i12;
                                                unsafe2 = unsafe;
                                                zzolVar6 = zzolVar2;
                                                i36 = i10;
                                            } else {
                                                zzolVar2 = zzolVar2;
                                                i4 = i3;
                                                iZzl = iZzl3;
                                                i12 = i12;
                                            }
                                            break;
                                    }
                                } else if (i40 == 2) {
                                    Unsafe unsafe6 = zzb;
                                    Object objZzz = zzolVar2.zzz(i12);
                                    Object object = unsafe6.getObject(obj, j);
                                    if (zzod.zza(object)) {
                                        zzoc zzocVarZzb = zzoc.zza().zzb();
                                        zzod.zzb(zzocVarZzb, object);
                                        unsafe6.putObject(obj, j, zzocVarZzb);
                                    }
                                    throw null;
                                }
                            }
                        } else if (i40 == 2) {
                            zznk zznkVarZzd2 = (zznk) unsafe3.getObject(obj, j);
                            if (!zznkVarZzd2.zzc()) {
                                int size2 = zznkVarZzd2.size();
                                zznkVarZzd2 = zznkVarZzd2.zzd(size2 == 0 ? 10 : size2 + size2);
                                unsafe3.putObject(obj, j, zznkVarZzd2);
                            }
                            int iZze = zzku.zze(zzolVar3.zzx(i12), i43, bArr, i37, i2, zznkVarZzd2, zzktVar);
                            zzktVar3 = zzktVar;
                            i2 = i2;
                            unsafe2 = unsafe3;
                            i31 = -1;
                            i35 = i9;
                            i36 = i10;
                            i34 = i43;
                            i32 = i42;
                            iZzh = iZze;
                            int i411 = i12;
                            zzolVar6 = zzolVar3;
                            i33 = i411;
                        } else {
                            zzktVar3 = zzktVar;
                            unsafe = unsafe3;
                            i21 = i43;
                            z2 = true;
                            zzolVar2 = zzolVar3;
                        }
                        i4 = i3;
                        iZzl = i37;
                        i7 = i21;
                        zzktVar2 = zzktVar3;
                        i13 = i42;
                    }
                }
                if (i7 != i4 || i4 == 0) {
                    if (zzolVar2.zzh) {
                        zzmo zzmoVar = zzktVar2.zzd;
                        int i100 = zzmo.zzb;
                        int i101 = zzos.zza;
                        if (zzmoVar != zzmo.zza) {
                            zzoi zzoiVar = zzolVar2.zzg;
                            zzmo zzmoVar2 = zzktVar2.zzd;
                            int i102 = zzku.zza;
                            zznc zzncVarZza = zzmoVar2.zza(zzoiVar, i13);
                            if (zzncVarZza != null) {
                                zzna zznaVar = (zzna) obj;
                                zznaVar.zzi();
                                zzmt zzmtVar = zznaVar.zzb;
                                zzpw zzpwVar = zzncVarZza.zza.zzb;
                                if (zzpwVar == zzpw.ENUM) {
                                    zzku.zzi(bArr, iZzl, zzktVar2);
                                    throw null;
                                }
                                switch (zzpwVar) {
                                    case DOUBLE:
                                        i14 = iZzl + 8;
                                        objValueOf = Double.valueOf(Double.longBitsToDouble(zzku.zzp(bArr, iZzl)));
                                        iZzl = i14;
                                        obj2 = objValueOf;
                                        zzmtVar.zzi(zzncVarZza.zza, obj2);
                                        iZzh = iZzl;
                                        break;
                                    case FLOAT:
                                        i14 = iZzl + 4;
                                        objValueOf = Float.valueOf(Float.intBitsToFloat(zzku.zzb(bArr, iZzl)));
                                        iZzl = i14;
                                        obj2 = objValueOf;
                                        zzmtVar.zzi(zzncVarZza.zza, obj2);
                                        iZzh = iZzl;
                                        break;
                                    case INT64:
                                    case UINT64:
                                        iZzl = zzku.zzl(bArr, iZzl, zzktVar2);
                                        objValueOf = Long.valueOf(zzktVar2.zzb);
                                        obj2 = objValueOf;
                                        zzmtVar.zzi(zzncVarZza.zza, obj2);
                                        iZzh = iZzl;
                                        break;
                                    case INT32:
                                    case UINT32:
                                        iZzl = zzku.zzi(bArr, iZzl, zzktVar2);
                                        objValueOf = Integer.valueOf(zzktVar2.zza);
                                        obj2 = objValueOf;
                                        zzmtVar.zzi(zzncVarZza.zza, obj2);
                                        iZzh = iZzl;
                                        break;
                                    case FIXED64:
                                    case SFIXED64:
                                        i14 = iZzl + 8;
                                        objValueOf = Long.valueOf(zzku.zzp(bArr, iZzl));
                                        iZzl = i14;
                                        obj2 = objValueOf;
                                        zzmtVar.zzi(zzncVarZza.zza, obj2);
                                        iZzh = iZzl;
                                        break;
                                    case FIXED32:
                                    case SFIXED32:
                                        i14 = iZzl + 4;
                                        objValueOf = Integer.valueOf(zzku.zzb(bArr, iZzl));
                                        iZzl = i14;
                                        obj2 = objValueOf;
                                        zzmtVar.zzi(zzncVarZza.zza, obj2);
                                        iZzh = iZzl;
                                        break;
                                    case BOOL:
                                        iZzl = zzku.zzl(bArr, iZzl, zzktVar2);
                                        objValueOf = Boolean.valueOf(zzktVar2.zzb != 0);
                                        obj2 = objValueOf;
                                        zzmtVar.zzi(zzncVarZza.zza, obj2);
                                        iZzh = iZzl;
                                        break;
                                    case STRING:
                                        iZzl = zzku.zzg(bArr, iZzl, zzktVar2);
                                        obj2 = zzktVar2.zzc;
                                        zzmtVar.zzi(zzncVarZza.zza, obj2);
                                        iZzh = iZzl;
                                        break;
                                    case GROUP:
                                        throw null;
                                    case MESSAGE:
                                        throw null;
                                    case BYTES:
                                        iZzl = zzku.zza(bArr, iZzl, zzktVar2);
                                        obj2 = zzktVar2.zzc;
                                        zzmtVar.zzi(zzncVarZza.zza, obj2);
                                        iZzh = iZzl;
                                        break;
                                    case ENUM:
                                        throw new IllegalStateException("Shouldn't reach here.");
                                    case SINT32:
                                        iZzl = zzku.zzi(bArr, iZzl, zzktVar2);
                                        objValueOf = Integer.valueOf(zzli.zzF(zzktVar2.zza));
                                        obj2 = objValueOf;
                                        zzmtVar.zzi(zzncVarZza.zza, obj2);
                                        iZzh = iZzl;
                                        break;
                                    case SINT64:
                                        iZzl = zzku.zzl(bArr, iZzl, zzktVar2);
                                        objValueOf = Long.valueOf(zzli.zzG(zzktVar2.zzb));
                                        obj2 = objValueOf;
                                        zzmtVar.zzi(zzncVarZza.zza, obj2);
                                        iZzh = iZzl;
                                        break;
                                    default:
                                        obj2 = objValueOf;
                                        zzmtVar.zzi(zzncVarZza.zza, obj2);
                                        iZzh = iZzl;
                                        break;
                                }
                            } else {
                                iZzh = zzku.zzh(i7, bArr, iZzl, i2, zzd(obj), zzktVar);
                            }
                        } else {
                            iZzh = zzku.zzh(i7, bArr, iZzl, i2, zzd(obj), zzktVar);
                        }
                    } else {
                        iZzh = zzku.zzh(i7, bArr, iZzl, i2, zzd(obj), zzktVar);
                    }
                    i33 = i12;
                    i34 = i7;
                    i32 = i13;
                    i2 = i2;
                    zzolVar6 = zzolVar2;
                    i35 = i9;
                    i36 = i10;
                    unsafe2 = unsafe;
                    zzktVar3 = zzktVar2;
                    i3 = i4;
                    i31 = i11;
                } else {
                    i5 = i2;
                    i6 = iZzl;
                    zzolVar = zzolVar2;
                    i35 = i9;
                    i36 = i10;
                }
            } else {
                unsafe = unsafe2;
                i4 = i3;
                i5 = i2;
                zzolVar = zzolVar6;
                i6 = iZzh;
                i7 = i34;
            }
        }
        if (i36 != 1048575) {
            unsafe.putInt(obj, i36, i35);
        }
        for (int i103 = zzolVar.zzk; i103 < zzolVar.zzl; i103++) {
            zzy(obj, zzolVar.zzj[i103], null, zzolVar.zzm, obj);
        }
        if (i4 == 0) {
            if (i6 != i5) {
                throw new zznn("Failed to parse the message.");
            }
        } else if (i6 > i5 || i7 != i4) {
            throw new zznn("Failed to parse the message.");
        }
        return i6;
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final Object zze() {
        return ((zznd) this.zzg).zzv();
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0071  */
    /* JADX WARN: Code duplicated, block: B:28:0x0077  */
    /* JADX WARN: Code duplicated, block: B:41:0x0084 A[SYNTHETIC] */
    @Override // com.google.android.recaptcha.internal.zzow
    public final void zzf(Object obj) {
        if (zzQ(obj)) {
            if (obj instanceof zznd) {
                zznd zzndVar = (zznd) obj;
                zzndVar.zzJ(Integer.MAX_VALUE);
                zzndVar.zza = 0;
                zzndVar.zzH();
            }
            int[] iArr = this.zzc;
            for (int i = 0; i < iArr.length; i += 3) {
                int iZzu = zzu(i);
                int i2 = 1048575 & iZzu;
                int iZzt = zzt(iZzu);
                long j = i2;
                if (iZzt != 9) {
                    if (iZzt != 60 && iZzt != 68) {
                        switch (iZzt) {
                            case 17:
                                if (zzN(obj, i)) {
                                    zzx(i).zzf(zzb.getObject(obj, j));
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
                                ((zznk) zzps.zzf(obj, j)).zzb();
                                break;
                            case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH /* 50 */:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzoc) object).zzc();
                                    unsafe.putObject(obj, j, object);
                                }
                                break;
                        }
                    } else if (zzR(obj, this.zzc[i], i)) {
                        zzx(i).zzf(zzb.getObject(obj, j));
                    }
                } else if (zzN(obj, i)) {
                    zzx(i).zzf(zzb.getObject(obj, j));
                }
            }
            this.zzm.zzi(obj);
            if (this.zzh) {
                this.zzn.zza(obj);
            }
        }
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final void zzg(Object obj, Object obj2) {
        zzD(obj);
        obj2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzu = zzu(i);
            int i2 = 1048575 & iZzu;
            int[] iArr = this.zzc;
            int iZzt = zzt(iZzu);
            int i3 = iArr[i];
            long j = i2;
            switch (iZzt) {
                case 0:
                    if (zzN(obj2, i)) {
                        zzps.zzo(obj, j, zzps.zza(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 1:
                    if (zzN(obj2, i)) {
                        zzps.zzp(obj, j, zzps.zzb(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 2:
                    if (zzN(obj2, i)) {
                        zzps.zzr(obj, j, zzps.zzd(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 3:
                    if (zzN(obj2, i)) {
                        zzps.zzr(obj, j, zzps.zzd(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 4:
                    if (zzN(obj2, i)) {
                        zzps.zzq(obj, j, zzps.zzc(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 5:
                    if (zzN(obj2, i)) {
                        zzps.zzr(obj, j, zzps.zzd(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 6:
                    if (zzN(obj2, i)) {
                        zzps.zzq(obj, j, zzps.zzc(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 7:
                    if (zzN(obj2, i)) {
                        zzps.zzm(obj, j, zzps.zzw(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 8:
                    if (zzN(obj2, i)) {
                        zzps.zzs(obj, j, zzps.zzf(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 9:
                    zzE(obj, obj2, i);
                    break;
                case 10:
                    if (zzN(obj2, i)) {
                        zzps.zzs(obj, j, zzps.zzf(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 11:
                    if (zzN(obj2, i)) {
                        zzps.zzq(obj, j, zzps.zzc(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 12:
                    if (zzN(obj2, i)) {
                        zzps.zzq(obj, j, zzps.zzc(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 13:
                    if (zzN(obj2, i)) {
                        zzps.zzq(obj, j, zzps.zzc(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 14:
                    if (zzN(obj2, i)) {
                        zzps.zzr(obj, j, zzps.zzd(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 15:
                    if (zzN(obj2, i)) {
                        zzps.zzq(obj, j, zzps.zzc(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 16:
                    if (zzN(obj2, i)) {
                        zzps.zzr(obj, j, zzps.zzd(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 17:
                    zzE(obj, obj2, i);
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
                    zznk zznkVarZzd = (zznk) zzps.zzf(obj, j);
                    zznk zznkVar = (zznk) zzps.zzf(obj2, j);
                    int size = zznkVarZzd.size();
                    int size2 = zznkVar.size();
                    if (size > 0 && size2 > 0) {
                        if (!zznkVarZzd.zzc()) {
                            zznkVarZzd = zznkVarZzd.zzd(size2 + size);
                        }
                        zznkVarZzd.addAll(zznkVar);
                    }
                    if (size > 0) {
                        zznkVar = zznkVarZzd;
                    }
                    zzps.zzs(obj, j, zznkVar);
                    break;
                case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH /* 50 */:
                    int i4 = zzoy.zza;
                    zzps.zzs(obj, j, zzod.zzb(zzps.zzf(obj, j), zzps.zzf(obj2, j)));
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
                    if (zzR(obj2, i3, i)) {
                        zzps.zzs(obj, j, zzps.zzf(obj2, j));
                        zzI(obj, i3, i);
                    }
                    break;
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                    zzF(obj, obj2, i);
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                case 62:
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                case 64:
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                case 66:
                case 67:
                    if (zzR(obj2, i3, i)) {
                        zzps.zzs(obj, j, zzps.zzf(obj2, j));
                        zzI(obj, i3, i);
                    }
                    break;
                case 68:
                    zzF(obj, obj2, i);
                    break;
            }
        }
        zzoy.zzq(this.zzm, obj, obj2);
        if (this.zzh) {
            zzoy.zzp(this.zzn, obj, obj2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:187:0x0653  */
    /* JADX WARN: Code duplicated, block: B:391:? A[RETURN, SYNTHETIC] */
    @Override // com.google.android.recaptcha.internal.zzow
    public final void zzh(Object obj, zzov zzovVar, zzmo zzmoVar) throws IOException {
        Object objValueOf;
        Object objZze;
        zzmoVar.getClass();
        zzD(obj);
        zzpl zzplVar = this.zzm;
        Object objZza = null;
        zzmt zzmtVarZzi = null;
        while (true) {
            try {
                int iZzc = zzovVar.zzc();
                int iZzq = zzq(iZzc);
                if (iZzq >= 0) {
                    int iZzu = zzu(iZzq);
                    try {
                        switch (zzt(iZzu)) {
                            case 0:
                                zzps.zzo(obj, iZzu & 1048575, zzovVar.zza());
                                zzH(obj, iZzq);
                                break;
                            case 1:
                                zzps.zzp(obj, iZzu & 1048575, zzovVar.zzb());
                                zzH(obj, iZzq);
                                break;
                            case 2:
                                zzps.zzr(obj, iZzu & 1048575, zzovVar.zzl());
                                zzH(obj, iZzq);
                                break;
                            case 3:
                                zzps.zzr(obj, iZzu & 1048575, zzovVar.zzo());
                                zzH(obj, iZzq);
                                break;
                            case 4:
                                zzps.zzq(obj, iZzu & 1048575, zzovVar.zzg());
                                zzH(obj, iZzq);
                                break;
                            case 5:
                                zzps.zzr(obj, iZzu & 1048575, zzovVar.zzk());
                                zzH(obj, iZzq);
                                break;
                            case 6:
                                zzps.zzq(obj, iZzu & 1048575, zzovVar.zzf());
                                zzH(obj, iZzq);
                                break;
                            case 7:
                                zzps.zzm(obj, iZzu & 1048575, zzovVar.zzN());
                                zzH(obj, iZzq);
                                break;
                            case 8:
                                zzG(obj, iZzu, zzovVar);
                                zzH(obj, iZzq);
                                break;
                            case 9:
                                zzoi zzoiVar = (zzoi) zzA(obj, iZzq);
                                zzovVar.zzu(zzoiVar, zzx(iZzq), zzmoVar);
                                zzJ(obj, iZzq, zzoiVar);
                                break;
                            case 10:
                                zzps.zzs(obj, iZzu & 1048575, zzovVar.zzp());
                                zzH(obj, iZzq);
                                break;
                            case 11:
                                zzps.zzq(obj, iZzu & 1048575, zzovVar.zzj());
                                zzH(obj, iZzq);
                                break;
                            case 12:
                                int iZze = zzovVar.zze();
                                zznh zznhVarZzw = zzw(iZzq);
                                if (zznhVarZzw == null || zznhVarZzw.zza(iZze)) {
                                    zzps.zzq(obj, iZzu & 1048575, iZze);
                                    zzH(obj, iZzq);
                                } else {
                                    objZza = zzoy.zzo(obj, iZzc, iZze, objZza, zzplVar);
                                }
                                break;
                            case 13:
                                zzps.zzq(obj, iZzu & 1048575, zzovVar.zzh());
                                zzH(obj, iZzq);
                                break;
                            case 14:
                                zzps.zzr(obj, iZzu & 1048575, zzovVar.zzm());
                                zzH(obj, iZzq);
                                break;
                            case 15:
                                zzps.zzq(obj, iZzu & 1048575, zzovVar.zzi());
                                zzH(obj, iZzq);
                                break;
                            case 16:
                                zzps.zzr(obj, iZzu & 1048575, zzovVar.zzn());
                                zzH(obj, iZzq);
                                break;
                            case 17:
                                zzoi zzoiVar2 = (zzoi) zzA(obj, iZzq);
                                zzovVar.zzt(zzoiVar2, zzx(iZzq), zzmoVar);
                                zzJ(obj, iZzq, zzoiVar2);
                                break;
                            case 18:
                                zzovVar.zzx(zznv.zza(obj, iZzu & 1048575));
                                break;
                            case 19:
                                zzovVar.zzB(zznv.zza(obj, iZzu & 1048575));
                                break;
                            case 20:
                                zzovVar.zzE(zznv.zza(obj, iZzu & 1048575));
                                break;
                            case 21:
                                zzovVar.zzM(zznv.zza(obj, iZzu & 1048575));
                                break;
                            case 22:
                                zzovVar.zzD(zznv.zza(obj, iZzu & 1048575));
                                break;
                            case 23:
                                zzovVar.zzA(zznv.zza(obj, iZzu & 1048575));
                                break;
                            case 24:
                                zzovVar.zzz(zznv.zza(obj, iZzu & 1048575));
                                break;
                            case 25:
                                zzovVar.zzv(zznv.zza(obj, iZzu & 1048575));
                                break;
                            case 26:
                                if (zzM(iZzu)) {
                                    ((zzlj) zzovVar).zzK(zznv.zza(obj, iZzu & 1048575), true);
                                } else {
                                    ((zzlj) zzovVar).zzK(zznv.zza(obj, iZzu & 1048575), false);
                                }
                                break;
                            case MotionEventCompat.AXIS_RELATIVE_X /* 27 */:
                                zzovVar.zzF(zznv.zza(obj, iZzu & 1048575), zzx(iZzq), zzmoVar);
                                break;
                            case MotionEventCompat.AXIS_RELATIVE_Y /* 28 */:
                                zzovVar.zzw(zznv.zza(obj, iZzu & 1048575));
                                break;
                            case 29:
                                zzovVar.zzL(zznv.zza(obj, iZzu & 1048575));
                                break;
                            case 30:
                                List listZza = zznv.zza(obj, iZzu & 1048575);
                                zzovVar.zzy(listZza);
                                objZza = zzoy.zzn(obj, iZzc, listZza, zzw(iZzq), objZza, zzplVar);
                                break;
                            case 31:
                                zzovVar.zzG(zznv.zza(obj, iZzu & 1048575));
                                break;
                            case 32:
                                zzovVar.zzH(zznv.zza(obj, iZzu & 1048575));
                                break;
                            case 33:
                                zzovVar.zzI(zznv.zza(obj, iZzu & 1048575));
                                break;
                            case MotionEventCompat.AXIS_GENERIC_3 /* 34 */:
                                zzovVar.zzJ(zznv.zza(obj, iZzu & 1048575));
                                break;
                            case MotionEventCompat.AXIS_GENERIC_4 /* 35 */:
                                zzovVar.zzx(zznv.zza(obj, iZzu & 1048575));
                                break;
                            case 36:
                                zzovVar.zzB(zznv.zza(obj, iZzu & 1048575));
                                break;
                            case MotionEventCompat.AXIS_GENERIC_6 /* 37 */:
                                zzovVar.zzE(zznv.zza(obj, iZzu & 1048575));
                                break;
                            case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                                zzovVar.zzM(zznv.zza(obj, iZzu & 1048575));
                                break;
                            case MotionEventCompat.AXIS_GENERIC_8 /* 39 */:
                                zzovVar.zzD(zznv.zza(obj, iZzu & 1048575));
                                break;
                            case MotionEventCompat.AXIS_GENERIC_9 /* 40 */:
                                zzovVar.zzA(zznv.zza(obj, iZzu & 1048575));
                                break;
                            case MotionEventCompat.AXIS_GENERIC_10 /* 41 */:
                                zzovVar.zzz(zznv.zza(obj, iZzu & 1048575));
                                break;
                            case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                                zzovVar.zzv(zznv.zza(obj, iZzu & 1048575));
                                break;
                            case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                                zzovVar.zzL(zznv.zza(obj, iZzu & 1048575));
                                break;
                            case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                                List listZza2 = zznv.zza(obj, iZzu & 1048575);
                                zzovVar.zzy(listZza2);
                                objZza = zzoy.zzn(obj, iZzc, listZza2, zzw(iZzq), objZza, zzplVar);
                                break;
                            case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                                zzovVar.zzG(zznv.zza(obj, iZzu & 1048575));
                                break;
                            case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                                zzovVar.zzH(zznv.zza(obj, iZzu & 1048575));
                                break;
                            case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                                zzovVar.zzI(zznv.zza(obj, iZzu & 1048575));
                                break;
                            case 48:
                                zzovVar.zzJ(zznv.zza(obj, iZzu & 1048575));
                                break;
                            case 49:
                                zzovVar.zzC(zznv.zza(obj, iZzu & 1048575), zzx(iZzq), zzmoVar);
                                break;
                            case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH /* 50 */:
                                Object objZzz = zzz(iZzq);
                                long jZzu = zzu(iZzq) & 1048575;
                                Object objZzf = zzps.zzf(obj, jZzu);
                                if (objZzf == null) {
                                    objZzf = zzoc.zza().zzb();
                                    zzps.zzs(obj, jZzu, objZzf);
                                } else if (zzod.zza(objZzf)) {
                                    Object objZzb = zzoc.zza().zzb();
                                    zzod.zzb(objZzb, objZzf);
                                    zzps.zzs(obj, jZzu, objZzb);
                                    objZzf = objZzb;
                                }
                                throw null;
                            case 51:
                                zzps.zzs(obj, iZzu & 1048575, Double.valueOf(zzovVar.zza()));
                                zzI(obj, iZzc, iZzq);
                                break;
                            case 52:
                                zzps.zzs(obj, iZzu & 1048575, Float.valueOf(zzovVar.zzb()));
                                zzI(obj, iZzc, iZzq);
                                break;
                            case 53:
                                zzps.zzs(obj, iZzu & 1048575, Long.valueOf(zzovVar.zzl()));
                                zzI(obj, iZzc, iZzq);
                                break;
                            case 54:
                                zzps.zzs(obj, iZzu & 1048575, Long.valueOf(zzovVar.zzo()));
                                zzI(obj, iZzc, iZzq);
                                break;
                            case 55:
                                zzps.zzs(obj, iZzu & 1048575, Integer.valueOf(zzovVar.zzg()));
                                zzI(obj, iZzc, iZzq);
                                break;
                            case 56:
                                zzps.zzs(obj, iZzu & 1048575, Long.valueOf(zzovVar.zzk()));
                                zzI(obj, iZzc, iZzq);
                                break;
                            case 57:
                                zzps.zzs(obj, iZzu & 1048575, Integer.valueOf(zzovVar.zzf()));
                                zzI(obj, iZzc, iZzq);
                                break;
                            case 58:
                                zzps.zzs(obj, iZzu & 1048575, Boolean.valueOf(zzovVar.zzN()));
                                zzI(obj, iZzc, iZzq);
                                break;
                            case 59:
                                zzG(obj, iZzu, zzovVar);
                                zzI(obj, iZzc, iZzq);
                                break;
                            case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                                zzoi zzoiVar3 = (zzoi) zzB(obj, iZzc, iZzq);
                                zzovVar.zzu(zzoiVar3, zzx(iZzq), zzmoVar);
                                zzK(obj, iZzc, iZzq, zzoiVar3);
                                break;
                            case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                                zzps.zzs(obj, iZzu & 1048575, zzovVar.zzp());
                                zzI(obj, iZzc, iZzq);
                                break;
                            case 62:
                                zzps.zzs(obj, iZzu & 1048575, Integer.valueOf(zzovVar.zzj()));
                                zzI(obj, iZzc, iZzq);
                                break;
                            case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                                int iZze2 = zzovVar.zze();
                                zznh zznhVarZzw2 = zzw(iZzq);
                                if (zznhVarZzw2 == null || zznhVarZzw2.zza(iZze2)) {
                                    zzps.zzs(obj, iZzu & 1048575, Integer.valueOf(iZze2));
                                    zzI(obj, iZzc, iZzq);
                                } else {
                                    objZza = zzoy.zzo(obj, iZzc, iZze2, objZza, zzplVar);
                                }
                                break;
                            case 64:
                                zzps.zzs(obj, iZzu & 1048575, Integer.valueOf(zzovVar.zzh()));
                                zzI(obj, iZzc, iZzq);
                                break;
                            case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                                zzps.zzs(obj, iZzu & 1048575, Long.valueOf(zzovVar.zzm()));
                                zzI(obj, iZzc, iZzq);
                                break;
                            case 66:
                                zzps.zzs(obj, iZzu & 1048575, Integer.valueOf(zzovVar.zzi()));
                                zzI(obj, iZzc, iZzq);
                                break;
                            case 67:
                                zzps.zzs(obj, iZzu & 1048575, Long.valueOf(zzovVar.zzn()));
                                zzI(obj, iZzc, iZzq);
                                break;
                            case 68:
                                zzoi zzoiVar4 = (zzoi) zzB(obj, iZzc, iZzq);
                                zzovVar.zzt(zzoiVar4, zzx(iZzq), zzmoVar);
                                zzK(obj, iZzc, iZzq, zzoiVar4);
                                break;
                            default:
                                if (objZza == null) {
                                    objZza = zzplVar.zza(obj);
                                }
                                if (!zzplVar.zzk(objZza, zzovVar, 0)) {
                                    for (int i = this.zzk; i < this.zzl; i++) {
                                        zzy(obj, this.zzj[i], objZza, zzplVar, obj);
                                    }
                                }
                                break;
                        }
                    } catch (zznm unused) {
                        if (objZza == null) {
                            objZza = zzplVar.zza(obj);
                        }
                        if (!zzplVar.zzk(objZza, zzovVar, 0)) {
                            for (int i2 = this.zzk; i2 < this.zzl; i2++) {
                                zzy(obj, this.zzj[i2], objZza, zzplVar, obj);
                            }
                            if (objZza != null) {
                                zzplVar.zzj(obj, objZza);
                            }
                        }
                    }
                } else if (iZzc == Integer.MAX_VALUE) {
                    for (int i3 = this.zzk; i3 < this.zzl; i3++) {
                        zzy(obj, this.zzj[i3], objZza, zzplVar, obj);
                    }
                } else {
                    zznc zzncVarZza = !this.zzh ? null : zzmoVar.zza(this.zzg, iZzc);
                    if (zzncVarZza != null) {
                        if (zzmtVarZzi == null) {
                            zzmtVarZzi = ((zzna) obj).zzi();
                        }
                        zznc zzncVar = zzncVarZza;
                        if (zzncVarZza.zza.zzb == zzpw.ENUM) {
                            zzovVar.zzg();
                            throw null;
                        }
                        switch (zzncVarZza.zza.zzb) {
                            case DOUBLE:
                                objValueOf = Double.valueOf(zzovVar.zza());
                                break;
                            case FLOAT:
                                objValueOf = Float.valueOf(zzovVar.zzb());
                                break;
                            case INT64:
                                objValueOf = Long.valueOf(zzovVar.zzl());
                                break;
                            case UINT64:
                                objValueOf = Long.valueOf(zzovVar.zzo());
                                break;
                            case INT32:
                                objValueOf = Integer.valueOf(zzovVar.zzg());
                                break;
                            case FIXED64:
                                objValueOf = Long.valueOf(zzovVar.zzk());
                                break;
                            case FIXED32:
                                objValueOf = Integer.valueOf(zzovVar.zzf());
                                break;
                            case BOOL:
                                objValueOf = Boolean.valueOf(zzovVar.zzN());
                                break;
                            case STRING:
                                objValueOf = zzovVar.zzr();
                                break;
                            case GROUP:
                                Object objZze2 = zzmtVarZzi.zze(zzncVarZza.zza);
                                if (!(objZze2 instanceof zznd)) {
                                    throw null;
                                }
                                zzow zzowVarZzb = zzos.zza().zzb(objZze2.getClass());
                                if (!((zznd) objZze2).zzL()) {
                                    Object objZze3 = zzowVarZzb.zze();
                                    zzowVarZzb.zzg(objZze3, objZze2);
                                    zzmtVarZzi.zzi(zzncVarZza.zza, objZze3);
                                    objZze2 = objZze3;
                                }
                                zzovVar.zzt(objZze2, zzowVarZzb, zzmoVar);
                                continue;
                                break;
                            case MESSAGE:
                                Object objZze4 = zzmtVarZzi.zze(zzncVarZza.zza);
                                if (!(objZze4 instanceof zznd)) {
                                    throw null;
                                }
                                zzow zzowVarZzb2 = zzos.zza().zzb(objZze4.getClass());
                                if (!((zznd) objZze4).zzL()) {
                                    Object objZze5 = zzowVarZzb2.zze();
                                    zzowVarZzb2.zzg(objZze5, objZze4);
                                    zzmtVarZzi.zzi(zzncVarZza.zza, objZze5);
                                    objZze4 = objZze5;
                                }
                                zzovVar.zzu(objZze4, zzowVarZzb2, zzmoVar);
                                continue;
                                break;
                            case BYTES:
                                objValueOf = zzovVar.zzp();
                                break;
                            case UINT32:
                                objValueOf = Integer.valueOf(zzovVar.zzj());
                                break;
                            case ENUM:
                                throw new IllegalStateException("Shouldn't reach here.");
                            case SFIXED32:
                                objValueOf = Integer.valueOf(zzovVar.zzh());
                                break;
                            case SFIXED64:
                                objValueOf = Long.valueOf(zzovVar.zzm());
                                break;
                            case SINT32:
                                objValueOf = Integer.valueOf(zzovVar.zzi());
                                break;
                            case SINT64:
                                objValueOf = Long.valueOf(zzovVar.zzn());
                                break;
                            default:
                                objValueOf = null;
                                break;
                        }
                        int iOrdinal = zzncVarZza.zza.zzb.ordinal();
                        if ((iOrdinal == 9 || iOrdinal == 10) && (objZze = zzmtVarZzi.zze(zzncVarZza.zza)) != null) {
                            byte[] bArr = zznl.zzb;
                            objValueOf = ((zzoi) objZze).zzae().zzc((zzoi) objValueOf).zzl();
                        }
                        zzmtVarZzi.zzi(zzncVarZza.zza, objValueOf);
                    } else {
                        if (objZza == null) {
                            objZza = zzplVar.zza(obj);
                        }
                        if (!zzplVar.zzk(objZza, zzovVar, 0)) {
                            for (int i4 = this.zzk; i4 < this.zzl; i4++) {
                                zzy(obj, this.zzj[i4], objZza, zzplVar, obj);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                for (int i5 = this.zzk; i5 < this.zzl; i5++) {
                    zzy(obj, this.zzj[i5], objZza, zzplVar, obj);
                }
                if (objZza != null) {
                    zzplVar.zzj(obj, objZza);
                }
                throw th;
            }
        }
        if (objZza != null) {
            zzplVar.zzj(obj, objZza);
        }
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final void zzi(Object obj, byte[] bArr, int i, int i2, zzkt zzktVar) throws IOException {
        zzc(obj, bArr, i, i2, 0, zzktVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x0023  */
    @Override // com.google.android.recaptcha.internal.zzow
    public final void zzj(Object obj, zzpy zzpyVar) throws IOException {
        Map.Entry entry;
        Iterator it;
        int i;
        Map.Entry entry2;
        int i2;
        boolean z;
        boolean z2;
        if (this.zzh) {
            zzmt zzmtVar = ((zzna) obj).zzb;
            if (zzmtVar.zza.isEmpty()) {
                entry = null;
                it = null;
            } else {
                Iterator itZzf = zzmtVar.zzf();
                entry = (Map.Entry) itZzf.next();
                it = itZzf;
            }
        } else {
            entry = null;
            it = null;
        }
        int[] iArr = this.zzc;
        Unsafe unsafe = zzb;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i5 < iArr.length) {
            int iZzu = zzu(i5);
            int[] iArr2 = this.zzc;
            int iZzt = zzt(iZzu);
            int i6 = iArr2[i5];
            if (iZzt <= 17) {
                int i7 = iArr2[i5 + 2];
                int i8 = i7 & 1048575;
                if (i8 != i3) {
                    i4 = i8 == 1048575 ? 0 : unsafe.getInt(obj, i8);
                    i3 = i8;
                } else {
                    entry = entry;
                }
                i2 = 1 << (i7 >>> 20);
                i = i4;
                entry2 = entry;
            } else {
                i = i4;
                entry2 = entry;
                i2 = 0;
            }
            int i9 = i3;
            while (entry2 != null && ((zznb) entry2.getKey()).zza <= i6) {
                this.zzn.zzb(zzpyVar, entry2);
                entry2 = it.hasNext() ? (Map.Entry) it.next() : null;
            }
            long j = iZzu & 1048575;
            switch (iZzt) {
                case 0:
                    it = it;
                    iArr = iArr;
                    if (zzO(obj, i5, i9, i, i2)) {
                        zzpyVar.zzf(i6, zzps.zza(obj, j));
                    }
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 1:
                    it = it;
                    iArr = iArr;
                    if (zzO(obj, i5, i9, i, i2)) {
                        zzpyVar.zzo(i6, zzps.zzb(obj, j));
                    }
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 2:
                    it = it;
                    iArr = iArr;
                    if (zzO(obj, i5, i9, i, i2)) {
                        zzpyVar.zzt(i6, unsafe.getLong(obj, j));
                    }
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 3:
                    it = it;
                    iArr = iArr;
                    if (zzO(obj, i5, i9, i, i2)) {
                        zzpyVar.zzK(i6, unsafe.getLong(obj, j));
                    }
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 4:
                    it = it;
                    iArr = iArr;
                    if (zzO(obj, i5, i9, i, i2)) {
                        zzpyVar.zzr(i6, unsafe.getInt(obj, j));
                    }
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 5:
                    it = it;
                    iArr = iArr;
                    if (zzO(obj, i5, i9, i, i2)) {
                        zzpyVar.zzm(i6, unsafe.getLong(obj, j));
                    }
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 6:
                    it = it;
                    iArr = iArr;
                    if (zzO(obj, i5, i9, i, i2)) {
                        zzpyVar.zzk(i6, unsafe.getInt(obj, j));
                    }
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 7:
                    it = it;
                    iArr = iArr;
                    if (zzO(obj, i5, i9, i, i2)) {
                        zzpyVar.zzb(i6, zzps.zzw(obj, j));
                    }
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 8:
                    it = it;
                    iArr = iArr;
                    if (zzO(obj, i5, i9, i, i2)) {
                        zzT(i6, unsafe.getObject(obj, j), zzpyVar);
                    }
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 9:
                    it = it;
                    iArr = iArr;
                    if (zzO(obj, i5, i9, i, i2)) {
                        zzpyVar.zzv(i6, unsafe.getObject(obj, j), zzx(i5));
                    }
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 10:
                    it = it;
                    iArr = iArr;
                    if (zzO(obj, i5, i9, i, i2)) {
                        zzpyVar.zzd(i6, (zzle) unsafe.getObject(obj, j));
                    }
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 11:
                    it = it;
                    iArr = iArr;
                    if (zzO(obj, i5, i9, i, i2)) {
                        zzpyVar.zzI(i6, unsafe.getInt(obj, j));
                    }
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 12:
                    it = it;
                    iArr = iArr;
                    if (zzO(obj, i5, i9, i, i2)) {
                        zzpyVar.zzi(i6, unsafe.getInt(obj, j));
                    }
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 13:
                    it = it;
                    iArr = iArr;
                    if (zzO(obj, i5, i9, i, i2)) {
                        zzpyVar.zzx(i6, unsafe.getInt(obj, j));
                    }
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 14:
                    it = it;
                    iArr = iArr;
                    if (zzO(obj, i5, i9, i, i2)) {
                        zzpyVar.zzz(i6, unsafe.getLong(obj, j));
                    }
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 15:
                    it = it;
                    iArr = iArr;
                    if (zzO(obj, i5, i9, i, i2)) {
                        zzpyVar.zzB(i6, unsafe.getInt(obj, j));
                    }
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 16:
                    it = it;
                    iArr = iArr;
                    if (zzO(obj, i5, i9, i, i2)) {
                        zzpyVar.zzD(i6, unsafe.getLong(obj, j));
                    }
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 17:
                    it = it;
                    iArr = iArr;
                    if (zzO(obj, i5, i9, i, i2)) {
                        zzpyVar.zzq(i6, unsafe.getObject(obj, j), zzx(i5));
                    }
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 18:
                    z = false;
                    zzoy.zzs(this.zzc[i5], (List) unsafe.getObject(obj, j), zzpyVar, false);
                    it = it;
                    iArr = iArr;
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 19:
                    z = false;
                    zzoy.zzw(this.zzc[i5], (List) unsafe.getObject(obj, j), zzpyVar, false);
                    it = it;
                    iArr = iArr;
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 20:
                    z = false;
                    zzoy.zzy(this.zzc[i5], (List) unsafe.getObject(obj, j), zzpyVar, false);
                    it = it;
                    iArr = iArr;
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 21:
                    z = false;
                    zzoy.zzE(this.zzc[i5], (List) unsafe.getObject(obj, j), zzpyVar, false);
                    it = it;
                    iArr = iArr;
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 22:
                    z = false;
                    zzoy.zzx(this.zzc[i5], (List) unsafe.getObject(obj, j), zzpyVar, false);
                    it = it;
                    iArr = iArr;
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 23:
                    z = false;
                    zzoy.zzv(this.zzc[i5], (List) unsafe.getObject(obj, j), zzpyVar, false);
                    it = it;
                    iArr = iArr;
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 24:
                    z = false;
                    zzoy.zzu(this.zzc[i5], (List) unsafe.getObject(obj, j), zzpyVar, false);
                    it = it;
                    iArr = iArr;
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 25:
                    z = false;
                    zzoy.zzr(this.zzc[i5], (List) unsafe.getObject(obj, j), zzpyVar, false);
                    it = it;
                    iArr = iArr;
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 26:
                    int i10 = this.zzc[i5];
                    List list = (List) unsafe.getObject(obj, j);
                    int i11 = zzoy.zza;
                    if (list != null && !list.isEmpty()) {
                        zzpyVar.zzH(i10, list);
                    }
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case MotionEventCompat.AXIS_RELATIVE_X /* 27 */:
                    int i12 = this.zzc[i5];
                    List list2 = (List) unsafe.getObject(obj, j);
                    zzow zzowVarZzx = zzx(i5);
                    int i13 = zzoy.zza;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i14 = 0; i14 < list2.size(); i14++) {
                            ((zzlo) zzpyVar).zzv(i12, list2.get(i14), zzowVarZzx);
                        }
                    }
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case MotionEventCompat.AXIS_RELATIVE_Y /* 28 */:
                    int i15 = this.zzc[i5];
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i16 = zzoy.zza;
                    if (list3 != null && !list3.isEmpty()) {
                        zzpyVar.zze(i15, list3);
                    }
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 29:
                    z2 = false;
                    zzoy.zzD(this.zzc[i5], (List) unsafe.getObject(obj, j), zzpyVar, false);
                    it = it;
                    iArr = iArr;
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 30:
                    z2 = false;
                    zzoy.zzt(this.zzc[i5], (List) unsafe.getObject(obj, j), zzpyVar, false);
                    it = it;
                    iArr = iArr;
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 31:
                    z2 = false;
                    zzoy.zzz(this.zzc[i5], (List) unsafe.getObject(obj, j), zzpyVar, false);
                    it = it;
                    iArr = iArr;
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 32:
                    z2 = false;
                    zzoy.zzA(this.zzc[i5], (List) unsafe.getObject(obj, j), zzpyVar, false);
                    it = it;
                    iArr = iArr;
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 33:
                    z2 = false;
                    zzoy.zzB(this.zzc[i5], (List) unsafe.getObject(obj, j), zzpyVar, false);
                    it = it;
                    iArr = iArr;
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case MotionEventCompat.AXIS_GENERIC_3 /* 34 */:
                    z2 = false;
                    zzoy.zzC(this.zzc[i5], (List) unsafe.getObject(obj, j), zzpyVar, false);
                    it = it;
                    iArr = iArr;
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case MotionEventCompat.AXIS_GENERIC_4 /* 35 */:
                    zzoy.zzs(this.zzc[i5], (List) unsafe.getObject(obj, j), zzpyVar, true);
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 36:
                    zzoy.zzw(this.zzc[i5], (List) unsafe.getObject(obj, j), zzpyVar, true);
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case MotionEventCompat.AXIS_GENERIC_6 /* 37 */:
                    zzoy.zzy(this.zzc[i5], (List) unsafe.getObject(obj, j), zzpyVar, true);
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                    zzoy.zzE(this.zzc[i5], (List) unsafe.getObject(obj, j), zzpyVar, true);
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case MotionEventCompat.AXIS_GENERIC_8 /* 39 */:
                    zzoy.zzx(this.zzc[i5], (List) unsafe.getObject(obj, j), zzpyVar, true);
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case MotionEventCompat.AXIS_GENERIC_9 /* 40 */:
                    zzoy.zzv(this.zzc[i5], (List) unsafe.getObject(obj, j), zzpyVar, true);
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case MotionEventCompat.AXIS_GENERIC_10 /* 41 */:
                    zzoy.zzu(this.zzc[i5], (List) unsafe.getObject(obj, j), zzpyVar, true);
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                    zzoy.zzr(this.zzc[i5], (List) unsafe.getObject(obj, j), zzpyVar, true);
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                    zzoy.zzD(this.zzc[i5], (List) unsafe.getObject(obj, j), zzpyVar, true);
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                    zzoy.zzt(this.zzc[i5], (List) unsafe.getObject(obj, j), zzpyVar, true);
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                    zzoy.zzz(this.zzc[i5], (List) unsafe.getObject(obj, j), zzpyVar, true);
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                    zzoy.zzA(this.zzc[i5], (List) unsafe.getObject(obj, j), zzpyVar, true);
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                    zzoy.zzB(this.zzc[i5], (List) unsafe.getObject(obj, j), zzpyVar, true);
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 48:
                    zzoy.zzC(this.zzc[i5], (List) unsafe.getObject(obj, j), zzpyVar, true);
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 49:
                    int i17 = this.zzc[i5];
                    List list4 = (List) unsafe.getObject(obj, j);
                    zzow zzowVarZzx2 = zzx(i5);
                    int i18 = zzoy.zza;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i19 = 0; i19 < list4.size(); i19++) {
                            ((zzlo) zzpyVar).zzq(i17, list4.get(i19), zzowVarZzx2);
                        }
                    }
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH /* 50 */:
                    if (unsafe.getObject(obj, j) != null) {
                        throw null;
                    }
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 51:
                    if (zzR(obj, i6, i5)) {
                        zzpyVar.zzf(i6, zzn(obj, j));
                    }
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 52:
                    if (zzR(obj, i6, i5)) {
                        zzpyVar.zzo(i6, zzo(obj, j));
                    }
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 53:
                    if (zzR(obj, i6, i5)) {
                        zzpyVar.zzt(i6, zzv(obj, j));
                    }
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 54:
                    if (zzR(obj, i6, i5)) {
                        zzpyVar.zzK(i6, zzv(obj, j));
                    }
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 55:
                    if (zzR(obj, i6, i5)) {
                        zzpyVar.zzr(i6, zzp(obj, j));
                    }
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 56:
                    if (zzR(obj, i6, i5)) {
                        zzpyVar.zzm(i6, zzv(obj, j));
                    }
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 57:
                    if (zzR(obj, i6, i5)) {
                        zzpyVar.zzk(i6, zzp(obj, j));
                    }
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 58:
                    if (zzR(obj, i6, i5)) {
                        zzpyVar.zzb(i6, zzS(obj, j));
                    }
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 59:
                    if (zzR(obj, i6, i5)) {
                        zzT(i6, unsafe.getObject(obj, j), zzpyVar);
                    }
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                    if (zzR(obj, i6, i5)) {
                        zzpyVar.zzv(i6, unsafe.getObject(obj, j), zzx(i5));
                    }
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzR(obj, i6, i5)) {
                        zzpyVar.zzd(i6, (zzle) unsafe.getObject(obj, j));
                    }
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 62:
                    if (zzR(obj, i6, i5)) {
                        zzpyVar.zzI(i6, zzp(obj, j));
                    }
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (zzR(obj, i6, i5)) {
                        zzpyVar.zzi(i6, zzp(obj, j));
                    }
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 64:
                    if (zzR(obj, i6, i5)) {
                        zzpyVar.zzx(i6, zzp(obj, j));
                    }
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (zzR(obj, i6, i5)) {
                        zzpyVar.zzz(i6, zzv(obj, j));
                    }
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 66:
                    if (zzR(obj, i6, i5)) {
                        zzpyVar.zzB(i6, zzp(obj, j));
                    }
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 67:
                    if (zzR(obj, i6, i5)) {
                        zzpyVar.zzD(i6, zzv(obj, j));
                    }
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                case 68:
                    if (zzR(obj, i6, i5)) {
                        zzpyVar.zzq(i6, unsafe.getObject(obj, j), zzx(i5));
                    }
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
                default:
                    i5 += 3;
                    i3 = i9;
                    entry = entry2;
                    it = it;
                    iArr = iArr;
                    i4 = i;
                    break;
            }
        }
        Iterator it2 = it;
        while (entry != null) {
            this.zzn.zzb(zzpyVar, entry);
            entry = it2.hasNext() ? (Map.Entry) it2.next() : null;
        }
        ((zznd) obj).zzc.zzl(zzpyVar);
    }

    @Override // com.google.android.recaptcha.internal.zzow
    public final boolean zzk(Object obj, Object obj2) {
        boolean zZzF;
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzu = zzu(i);
            long j = iZzu & 1048575;
            switch (zzt(iZzu)) {
                case 0:
                    if (!zzL(obj, obj2, i) || Double.doubleToLongBits(zzps.zza(obj, j)) != Double.doubleToLongBits(zzps.zza(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzL(obj, obj2, i) || Float.floatToIntBits(zzps.zzb(obj, j)) != Float.floatToIntBits(zzps.zzb(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzL(obj, obj2, i) || zzps.zzd(obj, j) != zzps.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzL(obj, obj2, i) || zzps.zzd(obj, j) != zzps.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzL(obj, obj2, i) || zzps.zzc(obj, j) != zzps.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzL(obj, obj2, i) || zzps.zzd(obj, j) != zzps.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzL(obj, obj2, i) || zzps.zzc(obj, j) != zzps.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzL(obj, obj2, i) || zzps.zzw(obj, j) != zzps.zzw(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzL(obj, obj2, i) || !zzoy.zzF(zzps.zzf(obj, j), zzps.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzL(obj, obj2, i) || !zzoy.zzF(zzps.zzf(obj, j), zzps.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzL(obj, obj2, i) || !zzoy.zzF(zzps.zzf(obj, j), zzps.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzL(obj, obj2, i) || zzps.zzc(obj, j) != zzps.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzL(obj, obj2, i) || zzps.zzc(obj, j) != zzps.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzL(obj, obj2, i) || zzps.zzc(obj, j) != zzps.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzL(obj, obj2, i) || zzps.zzd(obj, j) != zzps.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzL(obj, obj2, i) || zzps.zzc(obj, j) != zzps.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzL(obj, obj2, i) || zzps.zzd(obj, j) != zzps.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzL(obj, obj2, i) || !zzoy.zzF(zzps.zzf(obj, j), zzps.zzf(obj2, j))) {
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
                    zZzF = zzoy.zzF(zzps.zzf(obj, j), zzps.zzf(obj2, j));
                    break;
                case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH /* 50 */:
                    zZzF = zzoy.zzF(zzps.zzf(obj, j), zzps.zzf(obj2, j));
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
                    long jZzr = zzr(i) & 1048575;
                    if (zzps.zzc(obj, jZzr) != zzps.zzc(obj2, jZzr) || !zzoy.zzF(zzps.zzf(obj, j), zzps.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    continue;
                    break;
            }
            if (!zZzF) {
                return false;
            }
        }
        if (!((zznd) obj).zzc.equals(((zznd) obj2).zzc)) {
            return false;
        }
        if (this.zzh) {
            return ((zzna) obj).zzb.equals(((zzna) obj2).zzb);
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x009b  */
    /* JADX WARN: Code duplicated, block: B:44:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:50:0x00c0 A[LOOP:1: B:45:0x00af->B:50:0x00c0, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:67:0x00bf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x00dd A[SYNTHETIC] */
    @Override // com.google.android.recaptcha.internal.zzow
    public final boolean zzl(Object obj) {
        int i;
        int i2;
        List list;
        zzow zzowVarZzx;
        int i3;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1048575;
        while (i5 < this.zzk) {
            int[] iArr = this.zzj;
            int[] iArr2 = this.zzc;
            int i7 = iArr[i5];
            int i8 = iArr2[i7];
            int iZzu = zzu(i7);
            int i9 = this.zzc[i7 + 2];
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
            if ((268435456 & iZzu) != 0 && !zzO(obj, i7, i, i2, i11)) {
                return false;
            }
            int iZzt = zzt(iZzu);
            if (iZzt == 9 || iZzt == 17) {
                if (zzO(obj, i7, i, i2, i11) && !zzP(obj, iZzu, zzx(i7))) {
                    return false;
                }
            } else if (iZzt == 27) {
                list = (List) zzps.zzf(obj, iZzu & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzowVarZzx = zzx(i7);
                    for (i3 = 0; i3 < list.size(); i3++) {
                        if (!zzowVarZzx.zzl(list.get(i3))) {
                            return false;
                        }
                    }
                }
            } else if (iZzt == 60 || iZzt == 68) {
                if (zzR(obj, i8, i7) && !zzP(obj, iZzu, zzx(i7))) {
                    return false;
                }
            } else if (iZzt == 49) {
                list = (List) zzps.zzf(obj, iZzu & 1048575);
                if (list.isEmpty()) {
                    zzowVarZzx = zzx(i7);
                    while (i3 < list.size()) {
                        if (!zzowVarZzx.zzl(list.get(i3))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iZzt == 50 && !((zzoc) zzps.zzf(obj, iZzu & 1048575)).isEmpty()) {
                throw null;
            }
            i5++;
            i6 = i;
            i4 = i2;
        }
        return !this.zzh || ((zzna) obj).zzb.zzk();
    }
}
