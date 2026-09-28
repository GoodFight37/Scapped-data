package com.google.android.gms.internal.p002firebaseauthapi;

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

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzalr<T> implements zzamc<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzana.zzb();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzaln zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final int[] zzk;
    private final int zzl;
    private final int zzm;
    private final zzalv zzn;
    private final zzakx zzo;
    private final zzamv<?, ?> zzp;
    private final zzajx<?> zzq;
    private final zzalg zzr;

    private static <T> double zza(T t, long j) {
        return ((Double) zzana.zze(t, j)).doubleValue();
    }

    private static boolean zzg(int i) {
        return (i & 536870912) != 0;
    }

    private static <T> float zzb(T t, long j) {
        return ((Float) zzana.zze(t, j)).floatValue();
    }

    private static int zza(byte[] bArr, int i, int i2, zzanh zzanhVar, Class<?> cls, zzaiv zzaivVar) throws IOException {
        switch (zzalq.zza[zzanhVar.ordinal()]) {
            case 1:
                int iZzd = zzais.zzd(bArr, i, zzaivVar);
                zzaivVar.zzc = Boolean.valueOf(zzaivVar.zzb != 0);
                return iZzd;
            case 2:
                return zzais.zza(bArr, i, zzaivVar);
            case 3:
                zzaivVar.zzc = Double.valueOf(zzais.zza(bArr, i));
                return i + 8;
            case 4:
            case 5:
                zzaivVar.zzc = Integer.valueOf(zzais.zzc(bArr, i));
                return i + 4;
            case 6:
            case 7:
                zzaivVar.zzc = Long.valueOf(zzais.zzd(bArr, i));
                return i + 8;
            case 8:
                zzaivVar.zzc = Float.valueOf(zzais.zzb(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int iZzc = zzais.zzc(bArr, i, zzaivVar);
                zzaivVar.zzc = Integer.valueOf(zzaivVar.zza);
                return iZzc;
            case 12:
            case 13:
                int iZzd2 = zzais.zzd(bArr, i, zzaivVar);
                zzaivVar.zzc = Long.valueOf(zzaivVar.zzb);
                return iZzd2;
            case 14:
                return zzais.zza(zzaly.zza().zza((Class) cls), bArr, i, i2, zzaivVar);
            case 15:
                int iZzc2 = zzais.zzc(bArr, i, zzaivVar);
                zzaivVar.zzc = Integer.valueOf(zzaji.zza(zzaivVar.zza));
                return iZzc2;
            case 16:
                int iZzd3 = zzais.zzd(bArr, i, zzaivVar);
                zzaivVar.zzc = Long.valueOf(zzaji.zza(zzaivVar.zzb));
                return iZzd3;
            case 17:
                return zzais.zzb(bArr, i, zzaivVar);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v243 */
    /* JADX WARN: Type inference failed for: r0v245 */
    /* JADX WARN: Type inference failed for: r0v246 */
    /* JADX WARN: Type inference failed for: r12v3, types: [int] */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [int] */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v16 */
    /* JADX WARN: Type inference failed for: r15v17 */
    /* JADX WARN: Type inference failed for: r15v18 */
    /* JADX WARN: Type inference failed for: r15v19 */
    /* JADX WARN: Type inference failed for: r15v2, types: [int] */
    /* JADX WARN: Type inference failed for: r15v20 */
    /* JADX WARN: Type inference failed for: r15v21 */
    /* JADX WARN: Type inference failed for: r15v22 */
    /* JADX WARN: Type inference failed for: r15v23 */
    /* JADX WARN: Type inference failed for: r15v24 */
    /* JADX WARN: Type inference failed for: r15v25 */
    /* JADX WARN: Type inference failed for: r15v26 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v57 */
    /* JADX WARN: Type inference failed for: r1v58 */
    /* JADX WARN: Type inference failed for: r1v60 */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.google.android.gms.internal.firebase-auth-api.zzamh, com.google.android.gms.internal.firebase-auth-api.zzamh<T extends com.google.android.gms.internal.firebase-auth-api.zzaka<T>, java.lang.Object>] */
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
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v3, types: [int] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamc
    public final int zza(T t) {
        ?? Zza;
        int i;
        ?? r16;
        ?? r5;
        ?? r15;
        int iZza;
        int iZza2;
        int iZzd;
        int iZzd2;
        int iZzg;
        int iZzh;
        ?? r1;
        Unsafe unsafe = zzb;
        ?? r9 = 0;
        int i2 = 1048575;
        ?? r2 = 0;
        int i3 = 0;
        int iZzd3 = 0;
        int i4 = 1048575;
        while (i3 < this.zzc.length) {
            int iZzc = zzc(i3);
            int i5 = (267386880 & iZzc) >>> 20;
            int[] iArr = this.zzc;
            int i6 = iArr[i3];
            int i7 = iArr[i3 + 2];
            int i8 = i7 & i2;
            if (i5 <= 17) {
                if (i8 != i4) {
                    r1 = i8 == i2 ? r9 : unsafe.getInt(t, i8);
                    i4 = i8;
                }
                i = i4;
                r16 = r1;
                r5 = 1 << (i7 >>> 20);
            } else {
                r1 = r2;
                i = i4;
                r16 = r2 == true ? 1 : 0;
                r5 = r9;
            }
            long j = iZzc & i2;
            if (i5 >= zzakd.DOUBLE_LIST_PACKED.zza()) {
                zzakd.SINT64_LIST_PACKED.zza();
            }
            ?? r17 = r5;
            switch (i5) {
                case 0:
                    r15 = r9;
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza = zzajo.zza(i6, 0.0d);
                        r15 = r15;
                        iZzd3 += iZza;
                    }
                    break;
                case 1:
                    r15 = r9;
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza = zzajo.zza(i6, 0.0f);
                        r15 = r15;
                        iZzd3 += iZza;
                    }
                    break;
                case 2:
                    r15 = r9;
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza = zzajo.zzb(i6, unsafe.getLong(t, j));
                        r15 = r15;
                        iZzd3 += iZza;
                    }
                    break;
                case 3:
                    r15 = r9;
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza = zzajo.zze(i6, unsafe.getLong(t, j));
                        r15 = r15;
                        iZzd3 += iZza;
                    }
                    break;
                case 4:
                    r15 = r9;
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza = zzajo.zzc(i6, unsafe.getInt(t, j));
                        r15 = r15;
                        iZzd3 += iZza;
                    }
                    break;
                case 5:
                    r15 = r9;
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza = zzajo.zza(i6, 0L);
                        r15 = r15;
                        iZzd3 += iZza;
                    }
                    break;
                case 6:
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        r15 = 0;
                        iZza = zzajo.zzb(i6, 0);
                        iZzd3 += iZza;
                    } else {
                        r15 = 0;
                    }
                    break;
                case 7:
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza2 = zzajo.zza(i6, true);
                        iZzd3 += iZza2;
                    }
                    r15 = 0;
                    break;
                case 8:
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        Object object = unsafe.getObject(t, j);
                        if (object instanceof zzaiw) {
                            iZza2 = zzajo.zza(i6, (zzaiw) object);
                        } else {
                            iZza2 = zzajo.zza(i6, (String) object);
                        }
                        iZzd3 += iZza2;
                    }
                    r15 = 0;
                    break;
                case 9:
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza2 = zzame.zza(i6, unsafe.getObject(t, j), (zzamc<?>) zze(i3));
                        iZzd3 += iZza2;
                    }
                    r15 = 0;
                    break;
                case 10:
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza2 = zzajo.zza(i6, (zzaiw) unsafe.getObject(t, j));
                        iZzd3 += iZza2;
                    }
                    r15 = 0;
                    break;
                case 11:
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza2 = zzajo.zzf(i6, unsafe.getInt(t, j));
                        iZzd3 += iZza2;
                    }
                    r15 = 0;
                    break;
                case 12:
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza2 = zzajo.zza(i6, unsafe.getInt(t, j));
                        iZzd3 += iZza2;
                    }
                    r15 = 0;
                    break;
                case 13:
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZzd3 += zzajo.zzd(i6, 0);
                    }
                    r15 = 0;
                    break;
                case 14:
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza2 = zzajo.zzc(i6, 0L);
                        iZzd3 += iZza2;
                    }
                    r15 = 0;
                    break;
                case 15:
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza2 = zzajo.zze(i6, unsafe.getInt(t, j));
                        iZzd3 += iZza2;
                    }
                    r15 = 0;
                    break;
                case 16:
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza2 = zzajo.zzd(i6, unsafe.getLong(t, j));
                        iZzd3 += iZza2;
                    }
                    r15 = 0;
                    break;
                case 17:
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza2 = zzajo.zza(i6, (zzaln) unsafe.getObject(t, j), zze(i3));
                        iZzd3 += iZza2;
                    }
                    r15 = 0;
                    break;
                case 18:
                    iZzd = zzame.zzd(i6, (List) unsafe.getObject(t, j), r9);
                    iZzd3 += iZzd;
                    r15 = r9;
                    break;
                case 19:
                    iZzd = zzame.zzc(i6, (List) unsafe.getObject(t, j), r9);
                    iZzd3 += iZzd;
                    r15 = r9;
                    break;
                case 20:
                    iZzd = zzame.zzf(i6, (List) unsafe.getObject(t, j), r9);
                    iZzd3 += iZzd;
                    r15 = r9;
                    break;
                case 21:
                    iZzd = zzame.zzj(i6, (List) unsafe.getObject(t, j), r9);
                    iZzd3 += iZzd;
                    r15 = r9;
                    break;
                case 22:
                    iZzd = zzame.zze(i6, (List) unsafe.getObject(t, j), r9);
                    iZzd3 += iZzd;
                    r15 = r9;
                    break;
                case 23:
                    iZzd = zzame.zzd(i6, (List) unsafe.getObject(t, j), r9);
                    iZzd3 += iZzd;
                    r15 = r9;
                    break;
                case 24:
                    iZzd = zzame.zzc(i6, (List) unsafe.getObject(t, j), r9);
                    iZzd3 += iZzd;
                    r15 = r9;
                    break;
                case 25:
                    iZzd = zzame.zza(i6, (List<?>) unsafe.getObject(t, j), (boolean) r9);
                    iZzd3 += iZzd;
                    r15 = r9;
                    break;
                case 26:
                    iZzd = zzame.zzb(i6, (List) unsafe.getObject(t, j));
                    iZzd3 += iZzd;
                    r15 = r9;
                    break;
                case MotionEventCompat.AXIS_RELATIVE_X /* 27 */:
                    iZzd = zzame.zzb(i6, (List<?>) unsafe.getObject(t, j), (zzamc<?>) zze(i3));
                    iZzd3 += iZzd;
                    r15 = r9;
                    break;
                case MotionEventCompat.AXIS_RELATIVE_Y /* 28 */:
                    iZzd = zzame.zza(i6, (List<zzaiw>) unsafe.getObject(t, j));
                    iZzd3 += iZzd;
                    r15 = r9;
                    break;
                case 29:
                    iZzd = zzame.zzi(i6, (List) unsafe.getObject(t, j), r9);
                    iZzd3 += iZzd;
                    r15 = r9;
                    break;
                case 30:
                    iZzd = zzame.zzb(i6, (List<Integer>) unsafe.getObject(t, j), (boolean) r9);
                    iZzd3 += iZzd;
                    r15 = r9;
                    break;
                case 31:
                    iZzd = zzame.zzc(i6, (List) unsafe.getObject(t, j), r9);
                    iZzd3 += iZzd;
                    r15 = r9;
                    break;
                case 32:
                    iZzd = zzame.zzd(i6, (List) unsafe.getObject(t, j), r9);
                    iZzd3 += iZzd;
                    r15 = r9;
                    break;
                case 33:
                    iZzd = zzame.zzg(i6, (List) unsafe.getObject(t, j), r9);
                    iZzd3 += iZzd;
                    r15 = r9;
                    break;
                case MotionEventCompat.AXIS_GENERIC_3 /* 34 */:
                    iZzd = zzame.zzh(i6, (List) unsafe.getObject(t, j), r9);
                    iZzd3 += iZzd;
                    r15 = r9;
                    break;
                case MotionEventCompat.AXIS_GENERIC_4 /* 35 */:
                    iZzd2 = zzame.zzd((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzg = zzajo.zzg(i6);
                        iZzh = zzajo.zzh(iZzd2);
                        iZzd3 += iZzg + iZzh + iZzd2;
                    }
                    r15 = r9;
                    break;
                case 36:
                    iZzd2 = zzame.zzc((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzg = zzajo.zzg(i6);
                        iZzh = zzajo.zzh(iZzd2);
                        iZzd3 += iZzg + iZzh + iZzd2;
                    }
                    r15 = r9;
                    break;
                case MotionEventCompat.AXIS_GENERIC_6 /* 37 */:
                    iZzd2 = zzame.zzf((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzg = zzajo.zzg(i6);
                        iZzh = zzajo.zzh(iZzd2);
                        iZzd3 += iZzg + iZzh + iZzd2;
                    }
                    r15 = r9;
                    break;
                case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                    iZzd2 = zzame.zzj((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzg = zzajo.zzg(i6);
                        iZzh = zzajo.zzh(iZzd2);
                        iZzd3 += iZzg + iZzh + iZzd2;
                    }
                    r15 = r9;
                    break;
                case MotionEventCompat.AXIS_GENERIC_8 /* 39 */:
                    iZzd2 = zzame.zze((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzg = zzajo.zzg(i6);
                        iZzh = zzajo.zzh(iZzd2);
                        iZzd3 += iZzg + iZzh + iZzd2;
                    }
                    r15 = r9;
                    break;
                case MotionEventCompat.AXIS_GENERIC_9 /* 40 */:
                    iZzd2 = zzame.zzd((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzg = zzajo.zzg(i6);
                        iZzh = zzajo.zzh(iZzd2);
                        iZzd3 += iZzg + iZzh + iZzd2;
                    }
                    r15 = r9;
                    break;
                case MotionEventCompat.AXIS_GENERIC_10 /* 41 */:
                    iZzd2 = zzame.zzc((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzg = zzajo.zzg(i6);
                        iZzh = zzajo.zzh(iZzd2);
                        iZzd3 += iZzg + iZzh + iZzd2;
                    }
                    r15 = r9;
                    break;
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                    iZzd2 = zzame.zza((List<?>) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzg = zzajo.zzg(i6);
                        iZzh = zzajo.zzh(iZzd2);
                        iZzd3 += iZzg + iZzh + iZzd2;
                    }
                    r15 = r9;
                    break;
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                    iZzd2 = zzame.zzi((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzg = zzajo.zzg(i6);
                        iZzh = zzajo.zzh(iZzd2);
                        iZzd3 += iZzg + iZzh + iZzd2;
                    }
                    r15 = r9;
                    break;
                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                    iZzd2 = zzame.zzb((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzg = zzajo.zzg(i6);
                        iZzh = zzajo.zzh(iZzd2);
                        iZzd3 += iZzg + iZzh + iZzd2;
                    }
                    r15 = r9;
                    break;
                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                    iZzd2 = zzame.zzc((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzg = zzajo.zzg(i6);
                        iZzh = zzajo.zzh(iZzd2);
                        iZzd3 += iZzg + iZzh + iZzd2;
                    }
                    r15 = r9;
                    break;
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                    iZzd2 = zzame.zzd((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzg = zzajo.zzg(i6);
                        iZzh = zzajo.zzh(iZzd2);
                        iZzd3 += iZzg + iZzh + iZzd2;
                    }
                    r15 = r9;
                    break;
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                    iZzd2 = zzame.zzg((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzg = zzajo.zzg(i6);
                        iZzh = zzajo.zzh(iZzd2);
                        iZzd3 += iZzg + iZzh + iZzd2;
                    }
                    r15 = r9;
                    break;
                case 48:
                    iZzd2 = zzame.zzh((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzg = zzajo.zzg(i6);
                        iZzh = zzajo.zzh(iZzd2);
                        iZzd3 += iZzg + iZzh + iZzd2;
                    }
                    r15 = r9;
                    break;
                case 49:
                    iZzd = zzame.zza(i6, (List<zzaln>) unsafe.getObject(t, j), (zzamc<?>) zze(i3));
                    iZzd3 += iZzd;
                    r15 = r9;
                    break;
                case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH /* 50 */:
                    iZzd = this.zzr.zza(i6, unsafe.getObject(t, j), zzf(i3));
                    iZzd3 += iZzd;
                    r15 = r9;
                    break;
                case 51:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzajo.zza(i6, 0.0d);
                        iZzd3 += iZzd;
                    }
                    r15 = r9;
                    break;
                case 52:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzajo.zza(i6, 0.0f);
                        iZzd3 += iZzd;
                    }
                    r15 = r9;
                    break;
                case 53:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzajo.zzb(i6, zzd(t, j));
                        iZzd3 += iZzd;
                    }
                    r15 = r9;
                    break;
                case 54:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzajo.zze(i6, zzd(t, j));
                        iZzd3 += iZzd;
                    }
                    r15 = r9;
                    break;
                case 55:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzajo.zzc(i6, zzc(t, j));
                        iZzd3 += iZzd;
                    }
                    r15 = r9;
                    break;
                case 56:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzajo.zza(i6, 0L);
                        iZzd3 += iZzd;
                    }
                    r15 = r9;
                    break;
                case 57:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzajo.zzb(i6, (int) r9);
                        iZzd3 += iZzd;
                    }
                    r15 = r9;
                    break;
                case 58:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzajo.zza(i6, true);
                        iZzd3 += iZzd;
                    }
                    r15 = r9;
                    break;
                case 59:
                    if (zzc(t, i6, i3)) {
                        Object object2 = unsafe.getObject(t, j);
                        if (object2 instanceof zzaiw) {
                            iZzd = zzajo.zza(i6, (zzaiw) object2);
                        } else {
                            iZzd = zzajo.zza(i6, (String) object2);
                        }
                        iZzd3 += iZzd;
                    }
                    r15 = r9;
                    break;
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzame.zza(i6, unsafe.getObject(t, j), (zzamc<?>) zze(i3));
                        iZzd3 += iZzd;
                    }
                    r15 = r9;
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzajo.zza(i6, (zzaiw) unsafe.getObject(t, j));
                        iZzd3 += iZzd;
                    }
                    r15 = r9;
                    break;
                case 62:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzajo.zzf(i6, zzc(t, j));
                        iZzd3 += iZzd;
                    }
                    r15 = r9;
                    break;
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzajo.zza(i6, zzc(t, j));
                        iZzd3 += iZzd;
                    }
                    r15 = r9;
                    break;
                case 64:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzajo.zzd(i6, (int) r9);
                        iZzd3 += iZzd;
                    }
                    r15 = r9;
                    break;
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzajo.zzc(i6, 0L);
                        iZzd3 += iZzd;
                    }
                    r15 = r9;
                    break;
                case 66:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzajo.zze(i6, zzc(t, j));
                        iZzd3 += iZzd;
                    }
                    r15 = r9;
                    break;
                case 67:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzajo.zzd(i6, zzd(t, j));
                        iZzd3 += iZzd;
                    }
                    r15 = r9;
                    break;
                case 68:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzajo.zza(i6, (zzaln) unsafe.getObject(t, j), zze(i3));
                        iZzd3 += iZzd;
                    }
                    r15 = r9;
                    break;
                default:
                    r15 = r9;
                    break;
            }
            i3 += 3;
            i4 = i;
            r9 = r15;
            r2 = r16;
            i2 = 1048575;
        }
        ?? r18 = r9;
        zzamv<?, ?> zzamvVar = this.zzp;
        int iZza3 = iZzd3 + zzamvVar.zza(zzamvVar.zzd(t));
        if (!this.zzh) {
            return iZza3;
        }
        zzajy zzajyVarZza = this.zzq.zza(t);
        int iZzb = zzajyVarZza.zza.zzb();
        ?? r10 = r18;
        while (r10 < iZzb) {
            Zza = r18;
            Map.Entry entryZza = zzajyVarZza.zza.zza(r10);
            r10++;
            Zza += zzajy.zza((zzaka<?>) entryZza.getKey(), entryZza.getValue());
        }
        Zza = r18;
        ?? Zza2 = Zza;
        for (Map.Entry entry : zzajyVarZza.zza.zzc()) {
            Zza2 += zzajy.zza((zzaka<?>) entry.getKey(), entry.getValue());
        }
        return iZza3 + Zza2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamc
    public final int zzb(T t) {
        int i;
        int iZza;
        int length = this.zzc.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iZzc = zzc(i3);
            int i4 = this.zzc[i3];
            long j = 1048575 & iZzc;
            int iHashCode = 37;
            switch ((iZzc & 267386880) >>> 20) {
                case 0:
                    i = i2 * 53;
                    iZza = zzaki.zza(Double.doubleToLongBits(zzana.zza(t, j)));
                    i2 = i + iZza;
                    break;
                case 1:
                    i = i2 * 53;
                    iZza = Float.floatToIntBits(zzana.zzb(t, j));
                    i2 = i + iZza;
                    break;
                case 2:
                    i = i2 * 53;
                    iZza = zzaki.zza(zzana.zzd(t, j));
                    i2 = i + iZza;
                    break;
                case 3:
                    i = i2 * 53;
                    iZza = zzaki.zza(zzana.zzd(t, j));
                    i2 = i + iZza;
                    break;
                case 4:
                    i = i2 * 53;
                    iZza = zzana.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 5:
                    i = i2 * 53;
                    iZza = zzaki.zza(zzana.zzd(t, j));
                    i2 = i + iZza;
                    break;
                case 6:
                    i = i2 * 53;
                    iZza = zzana.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 7:
                    i = i2 * 53;
                    iZza = zzaki.zza(zzana.zzh(t, j));
                    i2 = i + iZza;
                    break;
                case 8:
                    i = i2 * 53;
                    iZza = ((String) zzana.zze(t, j)).hashCode();
                    i2 = i + iZza;
                    break;
                case 9:
                    Object objZze = zzana.zze(t, j);
                    if (objZze != null) {
                        iHashCode = objZze.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i = i2 * 53;
                    iZza = zzana.zze(t, j).hashCode();
                    i2 = i + iZza;
                    break;
                case 11:
                    i = i2 * 53;
                    iZza = zzana.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 12:
                    i = i2 * 53;
                    iZza = zzana.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 13:
                    i = i2 * 53;
                    iZza = zzana.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 14:
                    i = i2 * 53;
                    iZza = zzaki.zza(zzana.zzd(t, j));
                    i2 = i + iZza;
                    break;
                case 15:
                    i = i2 * 53;
                    iZza = zzana.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 16:
                    i = i2 * 53;
                    iZza = zzaki.zza(zzana.zzd(t, j));
                    i2 = i + iZza;
                    break;
                case 17:
                    Object objZze2 = zzana.zze(t, j);
                    if (objZze2 != null) {
                        iHashCode = objZze2.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
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
                    i = i2 * 53;
                    iZza = zzana.zze(t, j).hashCode();
                    i2 = i + iZza;
                    break;
                case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH /* 50 */:
                    i = i2 * 53;
                    iZza = zzana.zze(t, j).hashCode();
                    i2 = i + iZza;
                    break;
                case 51:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzaki.zza(Double.doubleToLongBits(zza(t, j)));
                        i2 = i + iZza;
                    }
                    break;
                case 52:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = Float.floatToIntBits(zzb(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case 53:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzaki.zza(zzd(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case 54:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzaki.zza(zzd(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case 55:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                    }
                    break;
                case 56:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzaki.zza(zzd(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case 57:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                    }
                    break;
                case 58:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzaki.zza(zze(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case 59:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = ((String) zzana.zze(t, j)).hashCode();
                        i2 = i + iZza;
                    }
                    break;
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzana.zze(t, j).hashCode();
                        i2 = i + iZza;
                    }
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzana.zze(t, j).hashCode();
                        i2 = i + iZza;
                    }
                    break;
                case 62:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                    }
                    break;
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                    }
                    break;
                case 64:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                    }
                    break;
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzaki.zza(zzd(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case 66:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                    }
                    break;
                case 67:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzaki.zza(zzd(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case 68:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzana.zze(t, j).hashCode();
                        i2 = i + iZza;
                    }
                    break;
            }
        }
        int iHashCode2 = (i2 * 53) + this.zzp.zzd(t).hashCode();
        return this.zzh ? (iHashCode2 * 53) + this.zzq.zza(t).hashCode() : iHashCode2;
    }

    private static <T> int zzc(T t, long j) {
        return ((Integer) zzana.zze(t, j)).intValue();
    }

    /* JADX WARN: Code duplicated, block: B:390:0x0939 A[PHI: r7 r8 r9 r10 r12 r13 r15
  0x0939: PHI (r7v132 int) = (r7v69 int), (r7v70 int), (r7v71 int), (r7v86 int), (r7v101 int), (r7v120 int), (r7v133 int) binds: [B:384:0x0918, B:364:0x08b7, B:344:0x0856, B:258:0x06d0, B:209:0x060c, B:152:0x04ad, B:131:0x042a] A[DONT_GENERATE, DONT_INLINE]
  0x0939: PHI (r8v131 int) = 
  (r8v88 int)
  (r8v89 int)
  (r8v90 int)
  (r8v100 int)
  (r8v112 int)
  (r8v123 int)
  (r36v0 int A[IMMUTABLE_TYPE, METHOD_ARGUMENT])
 binds: [B:384:0x0918, B:364:0x08b7, B:344:0x0856, B:258:0x06d0, B:209:0x060c, B:152:0x04ad, B:131:0x042a] A[DONT_GENERATE, DONT_INLINE]
  0x0939: PHI (r9v112 int) = (r9v81 int), (r9v82 int), (r9v83 int), (r9v90 int), (r9v98 int), (r9v107 int), (r9v113 int) binds: [B:384:0x0918, B:364:0x08b7, B:344:0x0856, B:258:0x06d0, B:209:0x060c, B:152:0x04ad, B:131:0x042a] A[DONT_GENERATE, DONT_INLINE]
  0x0939: PHI (r10v81 sun.misc.Unsafe) = 
  (r10v41 sun.misc.Unsafe)
  (r10v42 sun.misc.Unsafe)
  (r10v43 sun.misc.Unsafe)
  (r10v54 sun.misc.Unsafe)
  (r10v68 sun.misc.Unsafe)
  (r10v76 sun.misc.Unsafe)
  (r10v82 sun.misc.Unsafe)
 binds: [B:384:0x0918, B:364:0x08b7, B:344:0x0856, B:258:0x06d0, B:209:0x060c, B:152:0x04ad, B:131:0x042a] A[DONT_GENERATE, DONT_INLINE]
  0x0939: PHI (r12v100 int) = (r12v68 int), (r12v69 int), (r12v70 int), (r12v77 int), (r12v85 int), (r12v95 int), (r12v101 int) binds: [B:384:0x0918, B:364:0x08b7, B:344:0x0856, B:258:0x06d0, B:209:0x060c, B:152:0x04ad, B:131:0x042a] A[DONT_GENERATE, DONT_INLINE]
  0x0939: PHI (r13v85 int) = (r13v53 int), (r13v54 int), (r13v55 int), (r13v62 int), (r13v70 int), (r13v78 int), (r13v86 int) binds: [B:384:0x0918, B:364:0x08b7, B:344:0x0856, B:258:0x06d0, B:209:0x060c, B:152:0x04ad, B:131:0x042a] A[DONT_GENERATE, DONT_INLINE]
  0x0939: PHI (r15v37 com.google.android.gms.internal.firebase-auth-api.zzaiv) = 
  (r15v12 com.google.android.gms.internal.firebase-auth-api.zzaiv)
  (r15v13 com.google.android.gms.internal.firebase-auth-api.zzaiv)
  (r15v14 com.google.android.gms.internal.firebase-auth-api.zzaiv)
  (r15v21 com.google.android.gms.internal.firebase-auth-api.zzaiv)
  (r15v26 com.google.android.gms.internal.firebase-auth-api.zzaiv)
  (r15v32 com.google.android.gms.internal.firebase-auth-api.zzaiv)
  (r15v38 com.google.android.gms.internal.firebase-auth-api.zzaiv)
 binds: [B:384:0x0918, B:364:0x08b7, B:344:0x0856, B:258:0x06d0, B:209:0x060c, B:152:0x04ad, B:131:0x042a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:510:0x0cb4 A[PHI: r4 r5 r8 r9 r17
  0x0cb4: PHI (r4v75 int) = 
  (r4v51 int)
  (r4v52 int)
  (r4v53 int)
  (r4v54 int)
  (r4v55 int)
  (r4v57 int)
  (r4v59 int)
  (r4v60 int)
  (r4v68 int)
  (r4v76 int)
 binds: [B:507:0x0ca0, B:504:0x0c83, B:500:0x0c65, B:497:0x0c49, B:494:0x0c2c, B:491:0x0c0e, B:484:0x0be7, B:470:0x0bac, B:468:0x0b9d, B:441:0x0aa1] A[DONT_GENERATE, DONT_INLINE]
  0x0cb4: PHI (r5v79 'this' com.google.android.gms.internal.firebase-auth-api.zzalr<T>) = 
  (r5v57 'this' com.google.android.gms.internal.firebase-auth-api.zzalr<T>)
  (r5v58 'this' com.google.android.gms.internal.firebase-auth-api.zzalr<T>)
  (r5v59 'this' com.google.android.gms.internal.firebase-auth-api.zzalr<T>)
  (r5v60 'this' com.google.android.gms.internal.firebase-auth-api.zzalr<T>)
  (r5v61 'this' com.google.android.gms.internal.firebase-auth-api.zzalr<T>)
  (r5v63 'this' com.google.android.gms.internal.firebase-auth-api.zzalr<T>)
  (r5v65 'this' com.google.android.gms.internal.firebase-auth-api.zzalr<T>)
  (r5v66 'this' com.google.android.gms.internal.firebase-auth-api.zzalr<T>)
  (r5v74 'this' com.google.android.gms.internal.firebase-auth-api.zzalr<T>)
  (r5v80 'this' com.google.android.gms.internal.firebase-auth-api.zzalr<T>)
 binds: [B:507:0x0ca0, B:504:0x0c83, B:500:0x0c65, B:497:0x0c49, B:494:0x0c2c, B:491:0x0c0e, B:484:0x0be7, B:470:0x0bac, B:468:0x0b9d, B:441:0x0aa1] A[DONT_GENERATE, DONT_INLINE]
  0x0cb4: PHI (r8v83 int) = 
  (r8v58 int)
  (r8v59 int)
  (r8v60 int)
  (r8v61 int)
  (r8v62 int)
  (r8v64 int)
  (r8v66 int)
  (r8v67 int)
  (r8v75 int)
  (r8v84 int)
 binds: [B:507:0x0ca0, B:504:0x0c83, B:500:0x0c65, B:497:0x0c49, B:494:0x0c2c, B:491:0x0c0e, B:484:0x0be7, B:470:0x0bac, B:468:0x0b9d, B:441:0x0aa1] A[DONT_GENERATE, DONT_INLINE]
  0x0cb4: PHI (r9v77 int) = 
  (r9v54 int)
  (r9v55 int)
  (r9v56 int)
  (r9v57 int)
  (r9v58 int)
  (r9v60 int)
  (r9v62 int)
  (r9v63 int)
  (r9v69 int)
  (r9v78 int)
 binds: [B:507:0x0ca0, B:504:0x0c83, B:500:0x0c65, B:497:0x0c49, B:494:0x0c2c, B:491:0x0c0e, B:484:0x0be7, B:470:0x0bac, B:468:0x0b9d, B:441:0x0aa1] A[DONT_GENERATE, DONT_INLINE]
  0x0cb4: PHI (r17v25 int) = 
  (r17v10 int)
  (r17v11 int)
  (r17v12 int)
  (r17v13 int)
  (r17v14 int)
  (r17v16 int)
  (r17v18 int)
  (r17v19 int)
  (r17v21 int)
  (r17v26 int)
 binds: [B:507:0x0ca0, B:504:0x0c83, B:500:0x0c65, B:497:0x0c49, B:494:0x0c2c, B:491:0x0c0e, B:484:0x0be7, B:470:0x0bac, B:468:0x0b9d, B:441:0x0aa1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:588:0x094b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:594:0x0d22 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:615:0x0cb7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:638:0x093c A[SYNTHETIC] */
    final int zza(T t, byte[] bArr, int i, int i2, int i3, zzaiv zzaivVar) throws IOException {
        Unsafe unsafe;
        int i4;
        zzalr<T> zzalrVar;
        int i5;
        int iZza;
        int i6;
        int i7;
        int i8;
        int i9;
        int iZzc;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        zzaiv zzaivVar2;
        int i15;
        int i16;
        int i17;
        int iZzd;
        int i18;
        int i19;
        int iZza2;
        Object obj;
        int i20;
        int i21;
        Unsafe unsafe2;
        Object obj2;
        zzakn zzaknVarZza;
        zzaiv zzaivVar3;
        int i22;
        int i23;
        Unsafe unsafe3;
        int i24;
        int iZzc2;
        int iZza3;
        int i25;
        Unsafe unsafe4;
        int i26;
        int i27;
        int i28;
        zzaiv zzaivVar4;
        int i29;
        int i30;
        zzakn zzaknVar;
        zzaiv zzaivVar5;
        int i31;
        int iZza4;
        zzalr<T> zzalrVar2 = this;
        T t2 = t;
        bArr = bArr;
        i2 = i2;
        i3 = i3;
        zzaiv zzaivVar6 = zzaivVar;
        zzf(t);
        Unsafe unsafe5 = zzb;
        int iZza5 = i;
        int i32 = 0;
        int i33 = 0;
        int i34 = 0;
        int i35 = -1;
        int i36 = 1048575;
        while (true) {
            if (iZza5 < i2) {
                int i37 = iZza5 + 1;
                int i38 = bArr[iZza5];
                if (i38 < 0) {
                    int iZza6 = zzais.zza(i38, bArr, i37, zzaivVar6);
                    i5 = zzaivVar6.zza;
                    i37 = iZza6;
                } else {
                    i5 = i38;
                }
                int i39 = i5 >>> 3;
                int i40 = i5 & 7;
                if (i39 > i35) {
                    iZza = (i39 < zzalrVar2.zze || i39 > zzalrVar2.zzf) ? -1 : zzalrVar2.zza(i39, i32 / 3);
                } else {
                    iZza = zzalrVar2.zza(i39);
                }
                int i41 = iZza;
                if (i41 != -1) {
                    int[] iArr = zzalrVar2.zzc;
                    int i42 = iArr[i41 + 1];
                    int i43 = (i42 & 267386880) >>> 20;
                    int i44 = i37;
                    int i45 = i5;
                    long j = i42 & 1048575;
                    if (i43 <= 17) {
                        int i46 = iArr[i41 + 2];
                        int i47 = 1 << (i46 >>> 20);
                        int i48 = 1048575;
                        int i49 = i46 & 1048575;
                        i32 = i41;
                        if (i49 != i36) {
                            if (i36 != 1048575) {
                                unsafe5.putInt(t2, i36, i34);
                                i48 = 1048575;
                            }
                            i36 = i49;
                            i34 = i49 == i48 ? 0 : unsafe5.getInt(t2, i49);
                        } else {
                            i34 = i34;
                            i36 = i36;
                        }
                        switch (i43) {
                            case 0:
                                i3 = i3;
                                zzaivVar6 = zzaivVar6;
                                i32 = i32;
                                i44 = i44;
                                i9 = i45 == true ? 1 : 0;
                                i35 = i39;
                                unsafe5 = unsafe5;
                                if (i40 == 1) {
                                    zzana.zza(t2, j, zzais.zza(bArr, i44));
                                    iZzc = i44 + 8;
                                    i12 = i34 | i47;
                                    unsafe5 = unsafe5;
                                    i2 = i2;
                                    i32 = i32;
                                    zzaivVar6 = zzaivVar6;
                                    i35 = i35;
                                    i33 = i9;
                                    i36 = i36;
                                    iZza5 = iZzc;
                                    i34 = i12;
                                } else {
                                    i3 = i3;
                                    this = zzalrVar2;
                                    unsafe = unsafe5;
                                    i8 = i44;
                                    i32 = i32;
                                    zzaivVar6 = zzaivVar6;
                                    i6 = i35;
                                    i7 = i9;
                                }
                                break;
                            case 1:
                                i3 = i3;
                                zzaivVar6 = zzaivVar6;
                                i32 = i32;
                                i44 = i44;
                                i9 = i45 == true ? 1 : 0;
                                i35 = i39;
                                unsafe5 = unsafe5;
                                if (i40 == 5) {
                                    zzana.zza((Object) t2, j, zzais.zzb(bArr, i44));
                                    iZzc = i44 + 4;
                                    i12 = i34 | i47;
                                    unsafe5 = unsafe5;
                                    i2 = i2;
                                    i32 = i32;
                                    zzaivVar6 = zzaivVar6;
                                    i35 = i35;
                                    i33 = i9;
                                    i36 = i36;
                                    iZza5 = iZzc;
                                    i34 = i12;
                                } else {
                                    i3 = i3;
                                    this = zzalrVar2;
                                    unsafe = unsafe5;
                                    i8 = i44;
                                    i32 = i32;
                                    zzaivVar6 = zzaivVar6;
                                    i6 = i35;
                                    i7 = i9;
                                }
                                break;
                            case 2:
                            case 3:
                                i10 = i3;
                                zzaivVar6 = zzaivVar6;
                                i32 = i32;
                                i44 = i44;
                                i9 = i45 == true ? 1 : 0;
                                i35 = i39;
                                unsafe5 = unsafe5;
                                if (i40 == 0) {
                                    int iZzd2 = zzais.zzd(bArr, i44, zzaivVar6);
                                    unsafe5.putLong(t, j, zzaivVar6.zzb);
                                    i11 = i34 | i47;
                                    unsafe5 = unsafe5;
                                    i2 = i2;
                                    iZza5 = iZzd2;
                                    i3 = i10;
                                    i32 = i32;
                                    zzaivVar6 = zzaivVar6;
                                    i35 = i35;
                                    i33 = i9 == true ? 1 : 0;
                                    i34 = i11;
                                } else {
                                    i3 = i10;
                                    i3 = i3;
                                    this = zzalrVar2;
                                    unsafe = unsafe5;
                                    i8 = i44;
                                    i32 = i32;
                                    zzaivVar6 = zzaivVar6;
                                    i6 = i35;
                                    i7 = i9;
                                }
                                break;
                            case 4:
                            case 11:
                                i10 = i3;
                                zzaivVar6 = zzaivVar6;
                                i32 = i32;
                                i44 = i44;
                                i9 = i45 == true ? 1 : 0;
                                i35 = i39;
                                unsafe5 = unsafe5;
                                if (i40 == 0) {
                                    iZzc = zzais.zzc(bArr, i44, zzaivVar6);
                                    unsafe5.putInt(t2, j, zzaivVar6.zza);
                                    i12 = i34 | i47;
                                    i3 = i10;
                                    unsafe5 = unsafe5;
                                    i2 = i2;
                                    i32 = i32;
                                    zzaivVar6 = zzaivVar6;
                                    i35 = i35;
                                    i33 = i9;
                                    i36 = i36;
                                    iZza5 = iZzc;
                                    i34 = i12;
                                } else {
                                    i3 = i10;
                                    i3 = i3;
                                    this = zzalrVar2;
                                    unsafe = unsafe5;
                                    i8 = i44;
                                    i32 = i32;
                                    zzaivVar6 = zzaivVar6;
                                    i6 = i35;
                                    i7 = i9;
                                }
                                break;
                            case 5:
                            case 14:
                                i10 = i3;
                                zzaivVar6 = zzaivVar6;
                                i32 = i32;
                                i44 = i44;
                                i9 = i45 == true ? 1 : 0;
                                i35 = i39;
                                unsafe5 = unsafe5;
                                if (i40 == 1) {
                                    unsafe5.putLong(t, j, zzais.zzd(bArr, i44));
                                    iZzc = i44 + 8;
                                    i12 = i34 | i47;
                                    unsafe5 = unsafe5;
                                    i2 = i2;
                                    i3 = i10;
                                    i32 = i32;
                                    zzaivVar6 = zzaivVar6;
                                    i35 = i35;
                                    i33 = i9;
                                    i36 = i36;
                                    iZza5 = iZzc;
                                    i34 = i12;
                                } else {
                                    i3 = i10;
                                    i3 = i3;
                                    this = zzalrVar2;
                                    unsafe = unsafe5;
                                    i8 = i44;
                                    i32 = i32;
                                    zzaivVar6 = zzaivVar6;
                                    i6 = i35;
                                    i7 = i9;
                                }
                                break;
                            case 6:
                            case 13:
                                i10 = i3;
                                zzaivVar6 = zzaivVar6;
                                i32 = i32;
                                i44 = i44;
                                i9 = i45 == true ? 1 : 0;
                                i35 = i39;
                                unsafe5 = unsafe5;
                                if (i40 == 5) {
                                    unsafe5.putInt(t2, j, zzais.zzc(bArr, i44));
                                    iZzc = i44 + 4;
                                    i12 = i34 | i47;
                                    i3 = i10;
                                    unsafe5 = unsafe5;
                                    i2 = i2;
                                    i32 = i32;
                                    zzaivVar6 = zzaivVar6;
                                    i35 = i35;
                                    i33 = i9;
                                    i36 = i36;
                                    iZza5 = iZzc;
                                    i34 = i12;
                                } else {
                                    i3 = i10;
                                    i3 = i3;
                                    this = zzalrVar2;
                                    unsafe = unsafe5;
                                    i8 = i44;
                                    i32 = i32;
                                    zzaivVar6 = zzaivVar6;
                                    i6 = i35;
                                    i7 = i9;
                                }
                                break;
                            case 7:
                                i10 = i3;
                                zzaivVar6 = zzaivVar6;
                                i32 = i32;
                                i44 = i44;
                                i9 = i45 == true ? 1 : 0;
                                i35 = i39;
                                unsafe5 = unsafe5;
                                if (i40 == 0) {
                                    iZzc = zzais.zzd(bArr, i44, zzaivVar6);
                                    zzana.zzc(t2, j, zzaivVar6.zzb != 0);
                                    i12 = i34 | i47;
                                    i3 = i10;
                                    unsafe5 = unsafe5;
                                    i2 = i2;
                                    i32 = i32;
                                    zzaivVar6 = zzaivVar6;
                                    i35 = i35;
                                    i33 = i9;
                                    i36 = i36;
                                    iZza5 = iZzc;
                                    i34 = i12;
                                } else {
                                    i3 = i10;
                                    i3 = i3;
                                    this = zzalrVar2;
                                    unsafe = unsafe5;
                                    i8 = i44;
                                    i32 = i32;
                                    zzaivVar6 = zzaivVar6;
                                    i6 = i35;
                                    i7 = i9;
                                }
                                break;
                            case 8:
                                i10 = i3;
                                zzaivVar6 = zzaivVar6;
                                i32 = i32;
                                i44 = i44;
                                i9 = i45 == true ? 1 : 0;
                                i35 = i39;
                                unsafe5 = unsafe5;
                                if (i40 == 2) {
                                    if (zzg(i42)) {
                                        iZzc = zzais.zzb(bArr, i44, zzaivVar6);
                                    } else {
                                        iZzc = zzais.zzc(bArr, i44, zzaivVar6);
                                        int i50 = zzaivVar6.zza;
                                        if (i50 < 0) {
                                            throw zzakm.zzf();
                                        }
                                        if (i50 == 0) {
                                            zzaivVar6.zzc = "";
                                        } else {
                                            zzaivVar6.zzc = new String(bArr, iZzc, i50, zzaki.zza);
                                            iZzc += i50;
                                        }
                                    }
                                    unsafe5.putObject(t2, j, zzaivVar6.zzc);
                                    i12 = i34 | i47;
                                    i3 = i10;
                                    unsafe5 = unsafe5;
                                    i2 = i2;
                                    i32 = i32;
                                    zzaivVar6 = zzaivVar6;
                                    i35 = i35;
                                    i33 = i9;
                                    i36 = i36;
                                    iZza5 = iZzc;
                                    i34 = i12;
                                } else {
                                    i3 = i10;
                                    i3 = i3;
                                    this = zzalrVar2;
                                    unsafe = unsafe5;
                                    i8 = i44;
                                    i32 = i32;
                                    zzaivVar6 = zzaivVar6;
                                    i6 = i35;
                                    i7 = i9;
                                }
                                break;
                            case 9:
                                i3 = i3;
                                zzaivVar6 = zzaivVar6;
                                i32 = i32;
                                i13 = i45 == true ? 1 : 0;
                                i44 = i44;
                                i35 = i39;
                                unsafe5 = unsafe5;
                                if (i40 == 2) {
                                    Object objZza = zzalrVar2.zza((Object) t2, i32);
                                    zzamc zzamcVarZze = zzalrVar2.zze(i32);
                                    i9 = i13 == true ? 1 : 0;
                                    iZzc = zzais.zza(objZza, zzamcVarZze, bArr, i44, i2, zzaivVar);
                                    zzalrVar2.zza(t2, i32, objZza);
                                    i12 = i34 | i47;
                                    unsafe5 = unsafe5;
                                    i2 = i2;
                                    i3 = i3;
                                    i32 = i32;
                                    zzaivVar6 = zzaivVar6;
                                    i35 = i35;
                                    i33 = i9;
                                    i36 = i36;
                                    iZza5 = iZzc;
                                    i34 = i12;
                                } else {
                                    i9 = i13;
                                    i3 = i3;
                                    this = zzalrVar2;
                                    unsafe = unsafe5;
                                    i8 = i44;
                                    i32 = i32;
                                    zzaivVar6 = zzaivVar6;
                                    i6 = i35;
                                    i7 = i9;
                                }
                                break;
                            case 10:
                                i3 = i3;
                                zzaivVar6 = zzaivVar6;
                                i32 = i32;
                                i13 = i45 == true ? 1 : 0;
                                i44 = i44;
                                i35 = i39;
                                unsafe5 = unsafe5;
                                if (i40 == 2) {
                                    iZzc = zzais.zza(bArr, i44, zzaivVar6);
                                    unsafe5.putObject(t2, j, zzaivVar6.zzc);
                                    i12 = i34 | i47;
                                    i33 = i13 == true ? 1 : 0;
                                    unsafe5 = unsafe5;
                                    i2 = i2;
                                    i32 = i32;
                                    zzaivVar6 = zzaivVar6;
                                    i35 = i35;
                                    i36 = i36;
                                    iZza5 = iZzc;
                                    i34 = i12;
                                } else {
                                    i9 = i13;
                                    i3 = i3;
                                    this = zzalrVar2;
                                    unsafe = unsafe5;
                                    i8 = i44;
                                    i32 = i32;
                                    zzaivVar6 = zzaivVar6;
                                    i6 = i35;
                                    i7 = i9;
                                }
                                break;
                            case 12:
                                i2 = i2;
                                i3 = i3;
                                zzaivVar6 = zzaivVar6;
                                i32 = i32;
                                i44 = i44;
                                i9 = i45 == true ? 1 : 0;
                                i35 = i39;
                                unsafe5 = unsafe5;
                                if (i40 == 0) {
                                    int iZzc3 = zzais.zzc(bArr, i44, zzaivVar6);
                                    int i51 = zzaivVar6.zza;
                                    zzakk zzakkVarZzd = zzalrVar2.zzd(i32);
                                    if ((i42 & Integer.MIN_VALUE) == 0 || zzakkVarZzd == null || zzakkVarZzd.zza(i51)) {
                                        unsafe5.putInt(t2, j, i51);
                                        i33 = i9 == true ? 1 : 0;
                                        i34 |= i47;
                                    } else {
                                        zzc(t).zza(i9 == true ? 1 : 0, Long.valueOf(i51));
                                        i33 = i9 == true ? 1 : 0;
                                        i34 = i34;
                                    }
                                    iZza5 = iZzc3;
                                } else {
                                    i3 = i3;
                                    this = zzalrVar2;
                                    unsafe = unsafe5;
                                    i8 = i44;
                                    i32 = i32;
                                    zzaivVar6 = zzaivVar6;
                                    i6 = i35;
                                    i7 = i9;
                                }
                                break;
                            case 15:
                                i3 = i3;
                                zzaivVar6 = zzaivVar6;
                                i32 = i32;
                                i44 = i44;
                                i9 = i45 == true ? 1 : 0;
                                i35 = i39;
                                unsafe5 = unsafe5;
                                if (i40 == 0) {
                                    iZzc = zzais.zzc(bArr, i44, zzaivVar6);
                                    unsafe5.putInt(t2, j, zzaji.zza(zzaivVar6.zza));
                                    i12 = i34 | i47;
                                    unsafe5 = unsafe5;
                                    i2 = i2;
                                    i32 = i32;
                                    zzaivVar6 = zzaivVar6;
                                    i35 = i35;
                                    i33 = i9;
                                    i36 = i36;
                                    iZza5 = iZzc;
                                    i34 = i12;
                                } else {
                                    i3 = i3;
                                    this = zzalrVar2;
                                    unsafe = unsafe5;
                                    i8 = i44;
                                    i32 = i32;
                                    zzaivVar6 = zzaivVar6;
                                    i6 = i35;
                                    i7 = i9;
                                }
                                break;
                            case 16:
                                if (i40 == 0) {
                                    int iZzd3 = zzais.zzd(bArr, i44, zzaivVar6);
                                    unsafe5.putLong(t, j, zzaji.zza(zzaivVar6.zzb));
                                    i11 = i34 | i47;
                                    unsafe5 = unsafe5;
                                    i2 = i2;
                                    i3 = i3;
                                    i32 = i32;
                                    zzaivVar6 = zzaivVar6;
                                    i35 = i39;
                                    i33 = i45 == true ? 1 : 0;
                                    iZza5 = iZzd3;
                                    i34 = i11;
                                } else {
                                    zzaivVar6 = zzaivVar6;
                                    unsafe5 = unsafe5;
                                    i32 = i32;
                                    i35 = i39;
                                    i44 = i44;
                                    i3 = i3;
                                    i9 = i45 == true ? 1 : 0;
                                    i3 = i3;
                                    this = zzalrVar2;
                                    unsafe = unsafe5;
                                    i8 = i44;
                                    i32 = i32;
                                    zzaivVar6 = zzaivVar6;
                                    i6 = i35;
                                    i7 = i9;
                                }
                                break;
                            case 17:
                                if (i40 == 3) {
                                    Object objZza2 = zzalrVar2.zza((Object) t2, i32);
                                    iZza5 = zzais.zza(objZza2, zzalrVar2.zze(i32), bArr, i44, i2, (i39 << 3) | 4, zzaivVar);
                                    zzalrVar2.zza(t2, i32, objZza2);
                                    i34 |= i47;
                                    i33 = i45 == true ? 1 : 0;
                                    i32 = i32;
                                    i35 = i39;
                                    i36 = i36;
                                    i2 = i2;
                                    i3 = i3;
                                } else {
                                    i9 = i45 == true ? 1 : 0;
                                    i35 = i39;
                                    unsafe5 = unsafe5;
                                    i3 = i3;
                                    this = zzalrVar2;
                                    unsafe = unsafe5;
                                    i8 = i44;
                                    i32 = i32;
                                    zzaivVar6 = zzaivVar6;
                                    i6 = i35;
                                    i7 = i9;
                                }
                                break;
                            default:
                                i9 = i45 == true ? 1 : 0;
                                i35 = i39;
                                unsafe5 = unsafe5;
                                i3 = i3;
                                this = zzalrVar2;
                                unsafe = unsafe5;
                                i8 = i44;
                                i32 = i32;
                                zzaivVar6 = zzaivVar6;
                                i6 = i35;
                                i7 = i9;
                                break;
                        }
                    } else {
                        i34 = i34;
                        i36 = i36;
                        zzaiv zzaivVar7 = zzaivVar6;
                        int i52 = i45 == true ? 1 : 0;
                        Unsafe unsafe6 = unsafe5;
                        int i53 = i2;
                        if (i43 != 27) {
                            Unsafe unsafe7 = unsafe6;
                            if (i43 <= 49) {
                                long j2 = i42;
                                Unsafe unsafe8 = zzb;
                                zzakn zzaknVar2 = (zzakn) unsafe8.getObject(t2, j);
                                if (zzaknVar2.zzc()) {
                                    zzaknVarZza = zzaknVar2;
                                } else {
                                    zzaknVarZza = zzaknVar2.zza(zzaknVar2.size() << 1);
                                    unsafe8.putObject(t2, j, zzaknVarZza);
                                }
                                switch (i43) {
                                    case 18:
                                    case MotionEventCompat.AXIS_GENERIC_4 /* 35 */:
                                        i3 = i3;
                                        i32 = i41;
                                        zzaivVar3 = zzaivVar7;
                                        i22 = i44;
                                        i23 = i52 == true ? 1 : 0;
                                        unsafe3 = unsafe7;
                                        i24 = i53;
                                        if (i40 != 2) {
                                            if (i40 == 1) {
                                                zzajt zzajtVar = (zzajt) zzaknVarZza;
                                                zzajtVar.zza(zzais.zza(bArr, i22));
                                                iZzc2 = i22 + 8;
                                                while (iZzc2 < i24) {
                                                    int iZzc4 = zzais.zzc(bArr, iZzc2, zzaivVar3);
                                                    if (i23 == zzaivVar3.zza) {
                                                        zzajtVar.zza(zzais.zza(bArr, iZzc4));
                                                        iZzc2 = iZzc4 + 8;
                                                    }
                                                }
                                            } else {
                                                iZza3 = i22;
                                            }
                                            if (iZza3 == i22) {
                                                i3 = i3;
                                                i8 = iZza3;
                                                this = zzalrVar2;
                                                i3 = i3;
                                                i32 = i32;
                                                unsafe = unsafe3;
                                                i7 = i23;
                                                zzaivVar6 = zzaivVar3;
                                                i6 = i39;
                                                t2 = t;
                                            } else {
                                                i3 = i3;
                                                iZza5 = iZza3;
                                                i3 = i3;
                                                unsafe5 = unsafe3;
                                                i33 = i23;
                                                i2 = i24;
                                                zzaivVar6 = zzaivVar3;
                                                i35 = i39;
                                                i34 = i34;
                                                i36 = i36;
                                                t2 = t;
                                            }
                                        } else {
                                            zzajt zzajtVar2 = (zzajt) zzaknVarZza;
                                            iZzc2 = zzais.zzc(bArr, i22, zzaivVar3);
                                            int i54 = zzaivVar3.zza;
                                            int i55 = iZzc2 + i54;
                                            if (i55 > bArr.length) {
                                                throw zzakm.zzj();
                                            }
                                            zzajtVar2.zzc(zzajtVar2.size() + (i54 / 8));
                                            while (iZzc2 < i55) {
                                                zzajtVar2.zza(zzais.zza(bArr, iZzc2));
                                                iZzc2 += 8;
                                            }
                                            if (iZzc2 != i55) {
                                                throw zzakm.zzj();
                                            }
                                        }
                                        iZza3 = iZzc2;
                                        if (iZza3 == i22) {
                                            i3 = i3;
                                            i8 = iZza3;
                                            this = zzalrVar2;
                                            i3 = i3;
                                            i32 = i32;
                                            unsafe = unsafe3;
                                            i7 = i23;
                                            zzaivVar6 = zzaivVar3;
                                            i6 = i39;
                                            t2 = t;
                                        } else {
                                            i3 = i3;
                                            iZza5 = iZza3;
                                            i3 = i3;
                                            unsafe5 = unsafe3;
                                            i33 = i23;
                                            i2 = i24;
                                            zzaivVar6 = zzaivVar3;
                                            i35 = i39;
                                            i34 = i34;
                                            i36 = i36;
                                            t2 = t;
                                        }
                                        break;
                                    case 19:
                                    case 36:
                                        i3 = i3;
                                        i32 = i41;
                                        zzaivVar3 = zzaivVar7;
                                        i22 = i44;
                                        i23 = i52 == true ? 1 : 0;
                                        unsafe3 = unsafe7;
                                        i24 = i53;
                                        if (i40 != 2) {
                                            if (i40 == 5) {
                                                zzake zzakeVar = (zzake) zzaknVarZza;
                                                zzakeVar.zza(zzais.zzb(bArr, i22));
                                                iZzc2 = i22 + 4;
                                                while (iZzc2 < i24) {
                                                    int iZzc5 = zzais.zzc(bArr, iZzc2, zzaivVar3);
                                                    if (i23 == zzaivVar3.zza) {
                                                        zzakeVar.zza(zzais.zzb(bArr, iZzc5));
                                                        iZzc2 = iZzc5 + 4;
                                                    }
                                                }
                                            } else {
                                                iZza3 = i22;
                                            }
                                            if (iZza3 == i22) {
                                                i3 = i3;
                                                i8 = iZza3;
                                                this = zzalrVar2;
                                                i3 = i3;
                                                i32 = i32;
                                                unsafe = unsafe3;
                                                i7 = i23;
                                                zzaivVar6 = zzaivVar3;
                                                i6 = i39;
                                                t2 = t;
                                            } else {
                                                i3 = i3;
                                                iZza5 = iZza3;
                                                i3 = i3;
                                                unsafe5 = unsafe3;
                                                i33 = i23;
                                                i2 = i24;
                                                zzaivVar6 = zzaivVar3;
                                                i35 = i39;
                                                i34 = i34;
                                                i36 = i36;
                                                t2 = t;
                                            }
                                        } else {
                                            zzake zzakeVar2 = (zzake) zzaknVarZza;
                                            iZzc2 = zzais.zzc(bArr, i22, zzaivVar3);
                                            int i56 = zzaivVar3.zza;
                                            int i57 = iZzc2 + i56;
                                            if (i57 > bArr.length) {
                                                throw zzakm.zzj();
                                            }
                                            zzakeVar2.zzc(zzakeVar2.size() + (i56 / 4));
                                            while (iZzc2 < i57) {
                                                zzakeVar2.zza(zzais.zzb(bArr, iZzc2));
                                                iZzc2 += 4;
                                            }
                                            if (iZzc2 != i57) {
                                                throw zzakm.zzj();
                                            }
                                        }
                                        iZza3 = iZzc2;
                                        if (iZza3 == i22) {
                                            i3 = i3;
                                            i8 = iZza3;
                                            this = zzalrVar2;
                                            i3 = i3;
                                            i32 = i32;
                                            unsafe = unsafe3;
                                            i7 = i23;
                                            zzaivVar6 = zzaivVar3;
                                            i6 = i39;
                                            t2 = t;
                                        } else {
                                            i3 = i3;
                                            iZza5 = iZza3;
                                            i3 = i3;
                                            unsafe5 = unsafe3;
                                            i33 = i23;
                                            i2 = i24;
                                            zzaivVar6 = zzaivVar3;
                                            i35 = i39;
                                            i34 = i34;
                                            i36 = i36;
                                            t2 = t;
                                        }
                                        break;
                                    case 20:
                                    case 21:
                                    case MotionEventCompat.AXIS_GENERIC_6 /* 37 */:
                                    case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                                        i3 = i3;
                                        i32 = i41;
                                        zzaivVar3 = zzaivVar7;
                                        i22 = i44;
                                        i23 = i52 == true ? 1 : 0;
                                        unsafe3 = unsafe7;
                                        i24 = i53;
                                        if (i40 != 2) {
                                            if (i40 == 0) {
                                                zzaky zzakyVar = (zzaky) zzaknVarZza;
                                                iZzc2 = zzais.zzd(bArr, i22, zzaivVar3);
                                                zzakyVar.zza(zzaivVar3.zzb);
                                                while (iZzc2 < i24) {
                                                    int iZzc6 = zzais.zzc(bArr, iZzc2, zzaivVar3);
                                                    if (i23 == zzaivVar3.zza) {
                                                        iZzc2 = zzais.zzd(bArr, iZzc6, zzaivVar3);
                                                        zzakyVar.zza(zzaivVar3.zzb);
                                                    }
                                                }
                                            } else {
                                                iZza3 = i22;
                                            }
                                            if (iZza3 == i22) {
                                                i3 = i3;
                                                i8 = iZza3;
                                                this = zzalrVar2;
                                                i3 = i3;
                                                i32 = i32;
                                                unsafe = unsafe3;
                                                i7 = i23;
                                                zzaivVar6 = zzaivVar3;
                                                i6 = i39;
                                                t2 = t;
                                            } else {
                                                i3 = i3;
                                                iZza5 = iZza3;
                                                i3 = i3;
                                                unsafe5 = unsafe3;
                                                i33 = i23;
                                                i2 = i24;
                                                zzaivVar6 = zzaivVar3;
                                                i35 = i39;
                                                i34 = i34;
                                                i36 = i36;
                                                t2 = t;
                                            }
                                        } else {
                                            zzaky zzakyVar2 = (zzaky) zzaknVarZza;
                                            iZzc2 = zzais.zzc(bArr, i22, zzaivVar3);
                                            int i58 = zzaivVar3.zza + iZzc2;
                                            while (iZzc2 < i58) {
                                                iZzc2 = zzais.zzd(bArr, iZzc2, zzaivVar3);
                                                zzakyVar2.zza(zzaivVar3.zzb);
                                            }
                                            if (iZzc2 != i58) {
                                                throw zzakm.zzj();
                                            }
                                        }
                                        iZza3 = iZzc2;
                                        if (iZza3 == i22) {
                                            i3 = i3;
                                            i8 = iZza3;
                                            this = zzalrVar2;
                                            i3 = i3;
                                            i32 = i32;
                                            unsafe = unsafe3;
                                            i7 = i23;
                                            zzaivVar6 = zzaivVar3;
                                            i6 = i39;
                                            t2 = t;
                                        } else {
                                            i3 = i3;
                                            iZza5 = iZza3;
                                            i3 = i3;
                                            unsafe5 = unsafe3;
                                            i33 = i23;
                                            i2 = i24;
                                            zzaivVar6 = zzaivVar3;
                                            i35 = i39;
                                            i34 = i34;
                                            i36 = i36;
                                            t2 = t;
                                        }
                                        break;
                                    case 22:
                                    case 29:
                                    case MotionEventCompat.AXIS_GENERIC_8 /* 39 */:
                                    case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                                        i32 = i41;
                                        zzaivVar3 = zzaivVar7;
                                        i25 = i44;
                                        i23 = i52 == true ? 1 : 0;
                                        unsafe4 = unsafe7;
                                        i24 = i53;
                                        i26 = i3;
                                        if (i40 != 2) {
                                            if (i40 == 0) {
                                                i22 = i25;
                                                i3 = i26;
                                                unsafe3 = unsafe4;
                                                iZzc2 = zzais.zza(i23 == true ? 1 : 0, bArr, i22, i2, (zzakn<?>) zzaknVarZza, zzaivVar);
                                                iZza3 = iZzc2;
                                                if (iZza3 == i22) {
                                                    i3 = i3;
                                                    i8 = iZza3;
                                                    this = zzalrVar2;
                                                    i3 = i3;
                                                    i32 = i32;
                                                    unsafe = unsafe3;
                                                    i7 = i23;
                                                    zzaivVar6 = zzaivVar3;
                                                    i6 = i39;
                                                    t2 = t;
                                                } else {
                                                    i3 = i3;
                                                    iZza5 = iZza3;
                                                    i3 = i3;
                                                    unsafe5 = unsafe3;
                                                    i33 = i23;
                                                    i2 = i24;
                                                    zzaivVar6 = zzaivVar3;
                                                    i35 = i39;
                                                    i34 = i34;
                                                    i36 = i36;
                                                    t2 = t;
                                                }
                                            }
                                            i22 = i25;
                                            i3 = i26;
                                            unsafe3 = unsafe4;
                                            iZza3 = i22;
                                            if (iZza3 == i22) {
                                                i3 = i3;
                                                i8 = iZza3;
                                                this = zzalrVar2;
                                                i3 = i3;
                                                i32 = i32;
                                                unsafe = unsafe3;
                                                i7 = i23;
                                                zzaivVar6 = zzaivVar3;
                                                i6 = i39;
                                                t2 = t;
                                            } else {
                                                i3 = i3;
                                                iZza5 = iZza3;
                                                i3 = i3;
                                                unsafe5 = unsafe3;
                                                i33 = i23;
                                                i2 = i24;
                                                zzaivVar6 = zzaivVar3;
                                                i35 = i39;
                                                i34 = i34;
                                                i36 = i36;
                                                t2 = t;
                                            }
                                            break;
                                        } else {
                                            iZza3 = zzais.zza(bArr, i25, (zzakn<?>) zzaknVarZza, zzaivVar3);
                                            i22 = i25;
                                            i3 = i26;
                                            unsafe3 = unsafe4;
                                            if (iZza3 == i22) {
                                                i3 = i3;
                                                i8 = iZza3;
                                                this = zzalrVar2;
                                                i3 = i3;
                                                i32 = i32;
                                                unsafe = unsafe3;
                                                i7 = i23;
                                                zzaivVar6 = zzaivVar3;
                                                i6 = i39;
                                                t2 = t;
                                            } else {
                                                i3 = i3;
                                                iZza5 = iZza3;
                                                i3 = i3;
                                                unsafe5 = unsafe3;
                                                i33 = i23;
                                                i2 = i24;
                                                zzaivVar6 = zzaivVar3;
                                                i35 = i39;
                                                i34 = i34;
                                                i36 = i36;
                                                t2 = t;
                                            }
                                        }
                                        break;
                                    case 23:
                                    case 32:
                                    case MotionEventCompat.AXIS_GENERIC_9 /* 40 */:
                                    case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                                        i32 = i41;
                                        zzaivVar3 = zzaivVar7;
                                        i25 = i44;
                                        i23 = i52 == true ? 1 : 0;
                                        unsafe4 = unsafe7;
                                        i24 = i53;
                                        i26 = i3;
                                        if (i40 != 2) {
                                            if (i40 == 1) {
                                                zzaky zzakyVar3 = (zzaky) zzaknVarZza;
                                                zzakyVar3.zza(zzais.zzd(bArr, i25));
                                                i27 = i25 + 8;
                                                while (i27 < i24) {
                                                    int iZzc7 = zzais.zzc(bArr, i27, zzaivVar3);
                                                    if (i23 != zzaivVar3.zza) {
                                                        i22 = i25;
                                                        i3 = i26;
                                                        iZza3 = i27;
                                                        unsafe3 = unsafe4;
                                                        if (iZza3 == i22) {
                                                            i3 = i3;
                                                            i8 = iZza3;
                                                            this = zzalrVar2;
                                                            i3 = i3;
                                                            i32 = i32;
                                                            unsafe = unsafe3;
                                                            i7 = i23;
                                                            zzaivVar6 = zzaivVar3;
                                                            i6 = i39;
                                                            t2 = t;
                                                        } else {
                                                            i3 = i3;
                                                            iZza5 = iZza3;
                                                            i3 = i3;
                                                            unsafe5 = unsafe3;
                                                            i33 = i23;
                                                            i2 = i24;
                                                            zzaivVar6 = zzaivVar3;
                                                            i35 = i39;
                                                            i34 = i34;
                                                            i36 = i36;
                                                            t2 = t;
                                                        }
                                                    } else {
                                                        zzakyVar3.zza(zzais.zzd(bArr, iZzc7));
                                                        i27 = iZzc7 + 8;
                                                    }
                                                    break;
                                                }
                                                i22 = i25;
                                                i3 = i26;
                                                iZza3 = i27;
                                                unsafe3 = unsafe4;
                                                if (iZza3 == i22) {
                                                    i3 = i3;
                                                    i8 = iZza3;
                                                    this = zzalrVar2;
                                                    i3 = i3;
                                                    i32 = i32;
                                                    unsafe = unsafe3;
                                                    i7 = i23;
                                                    zzaivVar6 = zzaivVar3;
                                                    i6 = i39;
                                                    t2 = t;
                                                } else {
                                                    i3 = i3;
                                                    iZza5 = iZza3;
                                                    i3 = i3;
                                                    unsafe5 = unsafe3;
                                                    i33 = i23;
                                                    i2 = i24;
                                                    zzaivVar6 = zzaivVar3;
                                                    i35 = i39;
                                                    i34 = i34;
                                                    i36 = i36;
                                                    t2 = t;
                                                }
                                            }
                                            i22 = i25;
                                            i3 = i26;
                                            unsafe3 = unsafe4;
                                            iZza3 = i22;
                                            if (iZza3 == i22) {
                                                i3 = i3;
                                                i8 = iZza3;
                                                this = zzalrVar2;
                                                i3 = i3;
                                                i32 = i32;
                                                unsafe = unsafe3;
                                                i7 = i23;
                                                zzaivVar6 = zzaivVar3;
                                                i6 = i39;
                                                t2 = t;
                                            } else {
                                                i3 = i3;
                                                iZza5 = iZza3;
                                                i3 = i3;
                                                unsafe5 = unsafe3;
                                                i33 = i23;
                                                i2 = i24;
                                                zzaivVar6 = zzaivVar3;
                                                i35 = i39;
                                                i34 = i34;
                                                i36 = i36;
                                                t2 = t;
                                            }
                                            break;
                                        } else {
                                            zzaky zzakyVar4 = (zzaky) zzaknVarZza;
                                            iZza3 = zzais.zzc(bArr, i25, zzaivVar3);
                                            int i59 = zzaivVar3.zza;
                                            int i60 = iZza3 + i59;
                                            if (i60 > bArr.length) {
                                                throw zzakm.zzj();
                                            }
                                            zzakyVar4.zzc(zzakyVar4.size() + (i59 / 8));
                                            while (iZza3 < i60) {
                                                zzakyVar4.zza(zzais.zzd(bArr, iZza3));
                                                iZza3 += 8;
                                            }
                                            if (iZza3 != i60) {
                                                throw zzakm.zzj();
                                            }
                                            i22 = i25;
                                            i3 = i26;
                                            unsafe3 = unsafe4;
                                            if (iZza3 == i22) {
                                                i3 = i3;
                                                i8 = iZza3;
                                                this = zzalrVar2;
                                                i3 = i3;
                                                i32 = i32;
                                                unsafe = unsafe3;
                                                i7 = i23;
                                                zzaivVar6 = zzaivVar3;
                                                i6 = i39;
                                                t2 = t;
                                            } else {
                                                i3 = i3;
                                                iZza5 = iZza3;
                                                i3 = i3;
                                                unsafe5 = unsafe3;
                                                i33 = i23;
                                                i2 = i24;
                                                zzaivVar6 = zzaivVar3;
                                                i35 = i39;
                                                i34 = i34;
                                                i36 = i36;
                                                t2 = t;
                                            }
                                        }
                                        break;
                                    case 24:
                                    case 31:
                                    case MotionEventCompat.AXIS_GENERIC_10 /* 41 */:
                                    case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                                        i32 = i41;
                                        zzaivVar3 = zzaivVar7;
                                        i25 = i44;
                                        i23 = i52 == true ? 1 : 0;
                                        unsafe4 = unsafe7;
                                        i24 = i53;
                                        i26 = i3;
                                        if (i40 != 2) {
                                            if (i40 == 5) {
                                                zzakj zzakjVar = (zzakj) zzaknVarZza;
                                                zzakjVar.zzc(zzais.zzc(bArr, i25));
                                                i27 = i25 + 4;
                                                while (i27 < i24) {
                                                    int iZzc8 = zzais.zzc(bArr, i27, zzaivVar3);
                                                    if (i23 != zzaivVar3.zza) {
                                                        i22 = i25;
                                                        i3 = i26;
                                                        iZza3 = i27;
                                                        unsafe3 = unsafe4;
                                                        if (iZza3 == i22) {
                                                            i3 = i3;
                                                            i8 = iZza3;
                                                            this = zzalrVar2;
                                                            i3 = i3;
                                                            i32 = i32;
                                                            unsafe = unsafe3;
                                                            i7 = i23;
                                                            zzaivVar6 = zzaivVar3;
                                                            i6 = i39;
                                                            t2 = t;
                                                        } else {
                                                            i3 = i3;
                                                            iZza5 = iZza3;
                                                            i3 = i3;
                                                            unsafe5 = unsafe3;
                                                            i33 = i23;
                                                            i2 = i24;
                                                            zzaivVar6 = zzaivVar3;
                                                            i35 = i39;
                                                            i34 = i34;
                                                            i36 = i36;
                                                            t2 = t;
                                                        }
                                                    } else {
                                                        zzakjVar.zzc(zzais.zzc(bArr, iZzc8));
                                                        i27 = iZzc8 + 4;
                                                    }
                                                    break;
                                                }
                                                i22 = i25;
                                                i3 = i26;
                                                iZza3 = i27;
                                                unsafe3 = unsafe4;
                                                if (iZza3 == i22) {
                                                    i3 = i3;
                                                    i8 = iZza3;
                                                    this = zzalrVar2;
                                                    i3 = i3;
                                                    i32 = i32;
                                                    unsafe = unsafe3;
                                                    i7 = i23;
                                                    zzaivVar6 = zzaivVar3;
                                                    i6 = i39;
                                                    t2 = t;
                                                } else {
                                                    i3 = i3;
                                                    iZza5 = iZza3;
                                                    i3 = i3;
                                                    unsafe5 = unsafe3;
                                                    i33 = i23;
                                                    i2 = i24;
                                                    zzaivVar6 = zzaivVar3;
                                                    i35 = i39;
                                                    i34 = i34;
                                                    i36 = i36;
                                                    t2 = t;
                                                }
                                            }
                                            i22 = i25;
                                            i3 = i26;
                                            unsafe3 = unsafe4;
                                            iZza3 = i22;
                                            if (iZza3 == i22) {
                                                i3 = i3;
                                                i8 = iZza3;
                                                this = zzalrVar2;
                                                i3 = i3;
                                                i32 = i32;
                                                unsafe = unsafe3;
                                                i7 = i23;
                                                zzaivVar6 = zzaivVar3;
                                                i6 = i39;
                                                t2 = t;
                                            } else {
                                                i3 = i3;
                                                iZza5 = iZza3;
                                                i3 = i3;
                                                unsafe5 = unsafe3;
                                                i33 = i23;
                                                i2 = i24;
                                                zzaivVar6 = zzaivVar3;
                                                i35 = i39;
                                                i34 = i34;
                                                i36 = i36;
                                                t2 = t;
                                            }
                                            break;
                                        } else {
                                            zzakj zzakjVar2 = (zzakj) zzaknVarZza;
                                            iZza3 = zzais.zzc(bArr, i25, zzaivVar3);
                                            int i61 = zzaivVar3.zza;
                                            int i62 = iZza3 + i61;
                                            if (i62 > bArr.length) {
                                                throw zzakm.zzj();
                                            }
                                            zzakjVar2.zzd(zzakjVar2.size() + (i61 / 4));
                                            while (iZza3 < i62) {
                                                zzakjVar2.zzc(zzais.zzc(bArr, iZza3));
                                                iZza3 += 4;
                                            }
                                            if (iZza3 != i62) {
                                                throw zzakm.zzj();
                                            }
                                            i22 = i25;
                                            i3 = i26;
                                            unsafe3 = unsafe4;
                                            if (iZza3 == i22) {
                                                i3 = i3;
                                                i8 = iZza3;
                                                this = zzalrVar2;
                                                i3 = i3;
                                                i32 = i32;
                                                unsafe = unsafe3;
                                                i7 = i23;
                                                zzaivVar6 = zzaivVar3;
                                                i6 = i39;
                                                t2 = t;
                                            } else {
                                                i3 = i3;
                                                iZza5 = iZza3;
                                                i3 = i3;
                                                unsafe5 = unsafe3;
                                                i33 = i23;
                                                i2 = i24;
                                                zzaivVar6 = zzaivVar3;
                                                i35 = i39;
                                                i34 = i34;
                                                i36 = i36;
                                                t2 = t;
                                            }
                                        }
                                        break;
                                    case 25:
                                    case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                                        i32 = i41;
                                        zzaivVar3 = zzaivVar7;
                                        i25 = i44;
                                        i23 = i52 == true ? 1 : 0;
                                        unsafe4 = unsafe7;
                                        i24 = i53;
                                        i26 = i3;
                                        if (i40 != 2) {
                                            if (i40 == 0) {
                                                zzaiu zzaiuVar = (zzaiu) zzaknVarZza;
                                                iZza3 = zzais.zzd(bArr, i25, zzaivVar3);
                                                zzaiuVar.zza(zzaivVar3.zzb != 0);
                                                while (iZza3 < i24) {
                                                    int iZzc9 = zzais.zzc(bArr, iZza3, zzaivVar3);
                                                    if (i23 == zzaivVar3.zza) {
                                                        iZza3 = zzais.zzd(bArr, iZzc9, zzaivVar3);
                                                        zzaiuVar.zza(zzaivVar3.zzb != 0);
                                                    }
                                                }
                                            }
                                            i22 = i25;
                                            i3 = i26;
                                            unsafe3 = unsafe4;
                                            iZza3 = i22;
                                            if (iZza3 == i22) {
                                                i3 = i3;
                                                i8 = iZza3;
                                                this = zzalrVar2;
                                                i3 = i3;
                                                i32 = i32;
                                                unsafe = unsafe3;
                                                i7 = i23;
                                                zzaivVar6 = zzaivVar3;
                                                i6 = i39;
                                                t2 = t;
                                            } else {
                                                i3 = i3;
                                                iZza5 = iZza3;
                                                i3 = i3;
                                                unsafe5 = unsafe3;
                                                i33 = i23;
                                                i2 = i24;
                                                zzaivVar6 = zzaivVar3;
                                                i35 = i39;
                                                i34 = i34;
                                                i36 = i36;
                                                t2 = t;
                                            }
                                        } else {
                                            zzaiu zzaiuVar2 = (zzaiu) zzaknVarZza;
                                            iZza3 = zzais.zzc(bArr, i25, zzaivVar3);
                                            int i63 = zzaivVar3.zza + iZza3;
                                            while (iZza3 < i63) {
                                                iZza3 = zzais.zzd(bArr, iZza3, zzaivVar3);
                                                zzaiuVar2.zza(zzaivVar3.zzb != 0);
                                            }
                                            if (iZza3 != i63) {
                                                throw zzakm.zzj();
                                            }
                                        }
                                        i22 = i25;
                                        i3 = i26;
                                        unsafe3 = unsafe4;
                                        if (iZza3 == i22) {
                                            i3 = i3;
                                            i8 = iZza3;
                                            this = zzalrVar2;
                                            i3 = i3;
                                            i32 = i32;
                                            unsafe = unsafe3;
                                            i7 = i23;
                                            zzaivVar6 = zzaivVar3;
                                            i6 = i39;
                                            t2 = t;
                                        } else {
                                            i3 = i3;
                                            iZza5 = iZza3;
                                            i3 = i3;
                                            unsafe5 = unsafe3;
                                            i33 = i23;
                                            i2 = i24;
                                            zzaivVar6 = zzaivVar3;
                                            i35 = i39;
                                            i34 = i34;
                                            i36 = i36;
                                            t2 = t;
                                        }
                                        break;
                                    case 26:
                                        i32 = i41;
                                        zzaivVar3 = zzaivVar7;
                                        i25 = i44;
                                        i23 = i52 == true ? 1 : 0;
                                        unsafe4 = unsafe7;
                                        i24 = i53;
                                        i26 = i3;
                                        if (i40 == 2) {
                                            if ((j2 & 536870912) == 0) {
                                                iZza3 = zzais.zzc(bArr, i25, zzaivVar3);
                                                int i64 = zzaivVar3.zza;
                                                if (i64 < 0) {
                                                    throw zzakm.zzf();
                                                }
                                                if (i64 == 0) {
                                                    zzaknVarZza.add("");
                                                } else {
                                                    zzaknVarZza.add(new String(bArr, iZza3, i64, zzaki.zza));
                                                    iZza3 += i64;
                                                }
                                                while (iZza3 < i24) {
                                                    int iZzc10 = zzais.zzc(bArr, iZza3, zzaivVar3);
                                                    if (i23 == zzaivVar3.zza) {
                                                        iZza3 = zzais.zzc(bArr, iZzc10, zzaivVar3);
                                                        int i65 = zzaivVar3.zza;
                                                        if (i65 < 0) {
                                                            throw zzakm.zzf();
                                                        }
                                                        if (i65 == 0) {
                                                            zzaknVarZza.add("");
                                                        } else {
                                                            zzaknVarZza.add(new String(bArr, iZza3, i65, zzaki.zza));
                                                            iZza3 += i65;
                                                        }
                                                    }
                                                }
                                            } else {
                                                iZza3 = zzais.zzc(bArr, i25, zzaivVar3);
                                                int i66 = zzaivVar3.zza;
                                                if (i66 < 0) {
                                                    throw zzakm.zzf();
                                                }
                                                if (i66 == 0) {
                                                    zzaknVarZza.add("");
                                                } else {
                                                    int i67 = iZza3 + i66;
                                                    if (!zzanb.zzc(bArr, iZza3, i67)) {
                                                        throw zzakm.zzd();
                                                    }
                                                    zzaknVarZza.add(new String(bArr, iZza3, i66, zzaki.zza));
                                                    iZza3 = i67;
                                                }
                                                while (iZza3 < i24) {
                                                    int iZzc11 = zzais.zzc(bArr, iZza3, zzaivVar3);
                                                    if (i23 == zzaivVar3.zza) {
                                                        iZza3 = zzais.zzc(bArr, iZzc11, zzaivVar3);
                                                        int i68 = zzaivVar3.zza;
                                                        if (i68 < 0) {
                                                            throw zzakm.zzf();
                                                        }
                                                        if (i68 == 0) {
                                                            zzaknVarZza.add("");
                                                        } else {
                                                            int i69 = iZza3 + i68;
                                                            if (!zzanb.zzc(bArr, iZza3, i69)) {
                                                                throw zzakm.zzd();
                                                            }
                                                            zzaknVarZza.add(new String(bArr, iZza3, i68, zzaki.zza));
                                                            iZza3 = i69;
                                                        }
                                                    }
                                                }
                                            }
                                            i22 = i25;
                                            i3 = i26;
                                            unsafe3 = unsafe4;
                                            if (iZza3 == i22) {
                                                i3 = i3;
                                                i8 = iZza3;
                                                this = zzalrVar2;
                                                i3 = i3;
                                                i32 = i32;
                                                unsafe = unsafe3;
                                                i7 = i23;
                                                zzaivVar6 = zzaivVar3;
                                                i6 = i39;
                                                t2 = t;
                                            } else {
                                                i3 = i3;
                                                iZza5 = iZza3;
                                                i3 = i3;
                                                unsafe5 = unsafe3;
                                                i33 = i23;
                                                i2 = i24;
                                                zzaivVar6 = zzaivVar3;
                                                i35 = i39;
                                                i34 = i34;
                                                i36 = i36;
                                                t2 = t;
                                            }
                                        }
                                        i22 = i25;
                                        i3 = i26;
                                        unsafe3 = unsafe4;
                                        iZza3 = i22;
                                        if (iZza3 == i22) {
                                            i3 = i3;
                                            i8 = iZza3;
                                            this = zzalrVar2;
                                            i3 = i3;
                                            i32 = i32;
                                            unsafe = unsafe3;
                                            i7 = i23;
                                            zzaivVar6 = zzaivVar3;
                                            i6 = i39;
                                            t2 = t;
                                        } else {
                                            i3 = i3;
                                            iZza5 = iZza3;
                                            i3 = i3;
                                            unsafe5 = unsafe3;
                                            i33 = i23;
                                            i2 = i24;
                                            zzaivVar6 = zzaivVar3;
                                            i35 = i39;
                                            i34 = i34;
                                            i36 = i36;
                                            t2 = t;
                                        }
                                        break;
                                    case MotionEventCompat.AXIS_RELATIVE_X /* 27 */:
                                        i3 = i3;
                                        i53 = i53;
                                        i28 = i41;
                                        zzaivVar4 = zzaivVar7;
                                        i29 = i44;
                                        i30 = i52 == true ? 1 : 0;
                                        unsafe7 = unsafe7;
                                        if (i40 == 2) {
                                            zzaivVar3 = zzaivVar4;
                                            int iZzb = zzais.zzb(zzalrVar2.zze(i28), i30 == true ? 1 : 0, bArr, i29, i2, zzaknVarZza, zzaivVar);
                                            i24 = i53;
                                            i32 = i28;
                                            unsafe3 = unsafe7;
                                            i23 = i30 == true ? 1 : 0;
                                            iZza3 = iZzb;
                                            i22 = i29;
                                        } else {
                                            zzaivVar3 = zzaivVar4;
                                            i23 = i30;
                                            i24 = i53;
                                            unsafe3 = unsafe7;
                                            i22 = i29;
                                            i32 = i28;
                                            iZza3 = i22;
                                        }
                                        if (iZza3 == i22) {
                                            i3 = i3;
                                            i8 = iZza3;
                                            this = zzalrVar2;
                                            i3 = i3;
                                            i32 = i32;
                                            unsafe = unsafe3;
                                            i7 = i23;
                                            zzaivVar6 = zzaivVar3;
                                            i6 = i39;
                                            t2 = t;
                                        } else {
                                            i3 = i3;
                                            iZza5 = iZza3;
                                            i3 = i3;
                                            unsafe5 = unsafe3;
                                            i33 = i23;
                                            i2 = i24;
                                            zzaivVar6 = zzaivVar3;
                                            i35 = i39;
                                            i34 = i34;
                                            i36 = i36;
                                            t2 = t;
                                        }
                                        break;
                                    case MotionEventCompat.AXIS_RELATIVE_Y /* 28 */:
                                        i3 = i3;
                                        i53 = i53;
                                        zzakn zzaknVar3 = zzaknVarZza;
                                        i28 = i41;
                                        zzaivVar4 = zzaivVar7;
                                        i29 = i44;
                                        i30 = i52 == true ? 1 : 0;
                                        unsafe7 = unsafe7;
                                        if (i40 == 2) {
                                            int iZzc12 = zzais.zzc(bArr, i29, zzaivVar4);
                                            int i70 = zzaivVar4.zza;
                                            if (i70 < 0) {
                                                throw zzakm.zzf();
                                            }
                                            if (i70 > bArr.length - iZzc12) {
                                                throw zzakm.zzj();
                                            }
                                            if (i70 == 0) {
                                                zzaknVar = zzaknVar3;
                                                zzaknVar.add(zzaiw.zza);
                                            } else {
                                                zzaknVar = zzaknVar3;
                                                zzaknVar.add(zzaiw.zza(bArr, iZzc12, i70));
                                                iZzc12 += i70;
                                            }
                                            while (iZzc12 < i53) {
                                                int iZzc13 = zzais.zzc(bArr, iZzc12, zzaivVar4);
                                                if (i30 != zzaivVar4.zza) {
                                                    iZza3 = iZzc12;
                                                    zzaivVar3 = zzaivVar4;
                                                    i23 = i30 == true ? 1 : 0;
                                                    i24 = i53;
                                                    unsafe3 = unsafe7;
                                                    i22 = i29;
                                                    i32 = i28;
                                                    if (iZza3 == i22) {
                                                        i3 = i3;
                                                        i8 = iZza3;
                                                        this = zzalrVar2;
                                                        i3 = i3;
                                                        i32 = i32;
                                                        unsafe = unsafe3;
                                                        i7 = i23;
                                                        zzaivVar6 = zzaivVar3;
                                                        i6 = i39;
                                                        t2 = t;
                                                    } else {
                                                        i3 = i3;
                                                        iZza5 = iZza3;
                                                        i3 = i3;
                                                        unsafe5 = unsafe3;
                                                        i33 = i23;
                                                        i2 = i24;
                                                        zzaivVar6 = zzaivVar3;
                                                        i35 = i39;
                                                        i34 = i34;
                                                        i36 = i36;
                                                        t2 = t;
                                                    }
                                                    break;
                                                } else {
                                                    iZzc12 = zzais.zzc(bArr, iZzc13, zzaivVar4);
                                                    int i71 = zzaivVar4.zza;
                                                    if (i71 < 0) {
                                                        throw zzakm.zzf();
                                                    }
                                                    if (i71 > bArr.length - iZzc12) {
                                                        throw zzakm.zzj();
                                                    }
                                                    if (i71 == 0) {
                                                        zzaknVar.add(zzaiw.zza);
                                                    } else {
                                                        zzaknVar.add(zzaiw.zza(bArr, iZzc12, i71));
                                                        iZzc12 += i71;
                                                    }
                                                }
                                            }
                                            iZza3 = iZzc12;
                                            zzaivVar3 = zzaivVar4;
                                            i23 = i30 == true ? 1 : 0;
                                            i24 = i53;
                                            unsafe3 = unsafe7;
                                            i22 = i29;
                                            i32 = i28;
                                            if (iZza3 == i22) {
                                                i3 = i3;
                                                i8 = iZza3;
                                                this = zzalrVar2;
                                                i3 = i3;
                                                i32 = i32;
                                                unsafe = unsafe3;
                                                i7 = i23;
                                                zzaivVar6 = zzaivVar3;
                                                i6 = i39;
                                                t2 = t;
                                            } else {
                                                i3 = i3;
                                                iZza5 = iZza3;
                                                i3 = i3;
                                                unsafe5 = unsafe3;
                                                i33 = i23;
                                                i2 = i24;
                                                zzaivVar6 = zzaivVar3;
                                                i35 = i39;
                                                i34 = i34;
                                                i36 = i36;
                                                t2 = t;
                                            }
                                        }
                                        zzaivVar3 = zzaivVar4;
                                        i23 = i30;
                                        i24 = i53;
                                        unsafe3 = unsafe7;
                                        i22 = i29;
                                        i32 = i28;
                                        iZza3 = i22;
                                        if (iZza3 == i22) {
                                            i3 = i3;
                                            i8 = iZza3;
                                            this = zzalrVar2;
                                            i3 = i3;
                                            i32 = i32;
                                            unsafe = unsafe3;
                                            i7 = i23;
                                            zzaivVar6 = zzaivVar3;
                                            i6 = i39;
                                            t2 = t;
                                        } else {
                                            i3 = i3;
                                            iZza5 = iZza3;
                                            i3 = i3;
                                            unsafe5 = unsafe3;
                                            i33 = i23;
                                            i2 = i24;
                                            zzaivVar6 = zzaivVar3;
                                            i35 = i39;
                                            i34 = i34;
                                            i36 = i36;
                                            t2 = t;
                                        }
                                        break;
                                    case 30:
                                    case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                                        i28 = i41;
                                        zzaivVar5 = zzaivVar7;
                                        i29 = i44;
                                        i31 = i52 == true ? 1 : 0;
                                        if (i40 != 2) {
                                            if (i40 == 0) {
                                                iZza4 = zzais.zza(i31 == true ? 1 : 0, bArr, i29, i2, (zzakn<?>) zzaknVarZza, zzaivVar);
                                            }
                                            zzaivVar3 = zzaivVar5;
                                            i32 = i28;
                                            i22 = i29;
                                            i23 = i31;
                                            unsafe3 = unsafe7;
                                            i24 = i53;
                                            iZza3 = i22;
                                            if (iZza3 == i22) {
                                                i3 = i3;
                                                i8 = iZza3;
                                                this = zzalrVar2;
                                                i3 = i3;
                                                i32 = i32;
                                                unsafe = unsafe3;
                                                i7 = i23;
                                                zzaivVar6 = zzaivVar3;
                                                i6 = i39;
                                                t2 = t;
                                            } else {
                                                i3 = i3;
                                                iZza5 = iZza3;
                                                i3 = i3;
                                                unsafe5 = unsafe3;
                                                i33 = i23;
                                                i2 = i24;
                                                zzaivVar6 = zzaivVar3;
                                                i35 = i39;
                                                i34 = i34;
                                                i36 = i36;
                                                t2 = t;
                                            }
                                        } else {
                                            iZza4 = zzais.zza(bArr, i29, (zzakn<?>) zzaknVarZza, zzaivVar5);
                                        }
                                        zzame.zza(t, i39, zzaknVarZza, zzalrVar2.zzd(i28), null, zzalrVar2.zzp);
                                        zzaivVar3 = zzaivVar5;
                                        i23 = i31 == true ? 1 : 0;
                                        iZza3 = iZza4;
                                        i24 = i53;
                                        unsafe3 = unsafe7;
                                        i22 = i29;
                                        i32 = i28;
                                        if (iZza3 == i22) {
                                            i3 = i3;
                                            i8 = iZza3;
                                            this = zzalrVar2;
                                            i3 = i3;
                                            i32 = i32;
                                            unsafe = unsafe3;
                                            i7 = i23;
                                            zzaivVar6 = zzaivVar3;
                                            i6 = i39;
                                            t2 = t;
                                        } else {
                                            i3 = i3;
                                            iZza5 = iZza3;
                                            i3 = i3;
                                            unsafe5 = unsafe3;
                                            i33 = i23;
                                            i2 = i24;
                                            zzaivVar6 = zzaivVar3;
                                            i35 = i39;
                                            i34 = i34;
                                            i36 = i36;
                                            t2 = t;
                                        }
                                        break;
                                    case 33:
                                    case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                                        i28 = i41;
                                        zzaivVar5 = zzaivVar7;
                                        i29 = i44;
                                        i31 = i52 == true ? 1 : 0;
                                        if (i40 != 2) {
                                            if (i40 == 0) {
                                                zzakj zzakjVar3 = (zzakj) zzaknVarZza;
                                                iZza3 = zzais.zzc(bArr, i29, zzaivVar5);
                                                zzakjVar3.zzc(zzaji.zza(zzaivVar5.zza));
                                                while (iZza3 < i53) {
                                                    int iZzc14 = zzais.zzc(bArr, iZza3, zzaivVar5);
                                                    if (i31 == zzaivVar5.zza) {
                                                        iZza3 = zzais.zzc(bArr, iZzc14, zzaivVar5);
                                                        zzakjVar3.zzc(zzaji.zza(zzaivVar5.zza));
                                                    }
                                                }
                                            }
                                            zzaivVar3 = zzaivVar5;
                                            i32 = i28;
                                            i22 = i29;
                                            i23 = i31;
                                            unsafe3 = unsafe7;
                                            i24 = i53;
                                            iZza3 = i22;
                                            if (iZza3 == i22) {
                                                i3 = i3;
                                                i8 = iZza3;
                                                this = zzalrVar2;
                                                i3 = i3;
                                                i32 = i32;
                                                unsafe = unsafe3;
                                                i7 = i23;
                                                zzaivVar6 = zzaivVar3;
                                                i6 = i39;
                                                t2 = t;
                                            } else {
                                                i3 = i3;
                                                iZza5 = iZza3;
                                                i3 = i3;
                                                unsafe5 = unsafe3;
                                                i33 = i23;
                                                i2 = i24;
                                                zzaivVar6 = zzaivVar3;
                                                i35 = i39;
                                                i34 = i34;
                                                i36 = i36;
                                                t2 = t;
                                            }
                                        } else {
                                            zzakj zzakjVar4 = (zzakj) zzaknVarZza;
                                            iZza3 = zzais.zzc(bArr, i29, zzaivVar5);
                                            int i72 = zzaivVar5.zza + iZza3;
                                            while (iZza3 < i72) {
                                                iZza3 = zzais.zzc(bArr, iZza3, zzaivVar5);
                                                zzakjVar4.zzc(zzaji.zza(zzaivVar5.zza));
                                            }
                                            if (iZza3 != i72) {
                                                throw zzakm.zzj();
                                            }
                                        }
                                        i3 = i3;
                                        zzaivVar3 = zzaivVar5;
                                        i32 = i28;
                                        i22 = i29;
                                        i23 = i31;
                                        unsafe3 = unsafe7;
                                        i24 = i53;
                                        if (iZza3 == i22) {
                                            i3 = i3;
                                            i8 = iZza3;
                                            this = zzalrVar2;
                                            i3 = i3;
                                            i32 = i32;
                                            unsafe = unsafe3;
                                            i7 = i23;
                                            zzaivVar6 = zzaivVar3;
                                            i6 = i39;
                                            t2 = t;
                                        } else {
                                            i3 = i3;
                                            iZza5 = iZza3;
                                            i3 = i3;
                                            unsafe5 = unsafe3;
                                            i33 = i23;
                                            i2 = i24;
                                            zzaivVar6 = zzaivVar3;
                                            i35 = i39;
                                            i34 = i34;
                                            i36 = i36;
                                            t2 = t;
                                        }
                                        break;
                                    case MotionEventCompat.AXIS_GENERIC_3 /* 34 */:
                                    case 48:
                                        i28 = i41;
                                        zzaivVar5 = zzaivVar7;
                                        i29 = i44;
                                        if (i40 == 2) {
                                            zzaky zzakyVar5 = (zzaky) zzaknVarZza;
                                            iZza3 = zzais.zzc(bArr, i29, zzaivVar5);
                                            int i73 = zzaivVar5.zza + iZza3;
                                            while (iZza3 < i73) {
                                                iZza3 = zzais.zzd(bArr, iZza3, zzaivVar5);
                                                zzakyVar5.zza(zzaji.zza(zzaivVar5.zzb));
                                            }
                                            if (iZza3 != i73) {
                                                throw zzakm.zzj();
                                            }
                                            i3 = i3;
                                            zzaivVar3 = zzaivVar5;
                                            i32 = i28;
                                            i24 = i53;
                                            i22 = i29;
                                            i23 = i52 == true ? 1 : 0;
                                            unsafe3 = unsafe7;
                                            if (iZza3 == i22) {
                                                i3 = i3;
                                                i8 = iZza3;
                                                this = zzalrVar2;
                                                i3 = i3;
                                                i32 = i32;
                                                unsafe = unsafe3;
                                                i7 = i23;
                                                zzaivVar6 = zzaivVar3;
                                                i6 = i39;
                                                t2 = t;
                                            } else {
                                                i3 = i3;
                                                iZza5 = iZza3;
                                                i3 = i3;
                                                unsafe5 = unsafe3;
                                                i33 = i23;
                                                i2 = i24;
                                                zzaivVar6 = zzaivVar3;
                                                i35 = i39;
                                                i34 = i34;
                                                i36 = i36;
                                                t2 = t;
                                            }
                                        } else if (i40 == 0) {
                                            zzaky zzakyVar6 = (zzaky) zzaknVarZza;
                                            iZza3 = zzais.zzd(bArr, i29, zzaivVar5);
                                            zzakyVar6.zza(zzaji.zza(zzaivVar5.zzb));
                                            while (true) {
                                                if (iZza3 < i53) {
                                                    int iZzc15 = zzais.zzc(bArr, iZza3, zzaivVar5);
                                                    i31 = i52;
                                                    if (i31 == zzaivVar5.zza) {
                                                        iZza3 = zzais.zzd(bArr, iZzc15, zzaivVar5);
                                                        zzakyVar6.zza(zzaji.zza(zzaivVar5.zzb));
                                                        i52 = i31 == true ? 1 : 0;
                                                    }
                                                } else {
                                                    i31 = i52;
                                                }
                                            }
                                            i3 = i3;
                                            zzaivVar3 = zzaivVar5;
                                            i32 = i28;
                                            i22 = i29;
                                            i23 = i31;
                                            unsafe3 = unsafe7;
                                            i24 = i53;
                                            if (iZza3 == i22) {
                                                i3 = i3;
                                                i8 = iZza3;
                                                this = zzalrVar2;
                                                i3 = i3;
                                                i32 = i32;
                                                unsafe = unsafe3;
                                                i7 = i23;
                                                zzaivVar6 = zzaivVar3;
                                                i6 = i39;
                                                t2 = t;
                                            } else {
                                                i3 = i3;
                                                iZza5 = iZza3;
                                                i3 = i3;
                                                unsafe5 = unsafe3;
                                                i33 = i23;
                                                i2 = i24;
                                                zzaivVar6 = zzaivVar3;
                                                i35 = i39;
                                                i34 = i34;
                                                i36 = i36;
                                                t2 = t;
                                            }
                                        } else {
                                            i3 = i3;
                                            zzaivVar3 = zzaivVar5;
                                            i32 = i28;
                                            i24 = i53;
                                            i22 = i29;
                                            i23 = i52 == true ? 1 : 0;
                                            unsafe3 = unsafe7;
                                            iZza3 = i22;
                                            if (iZza3 == i22) {
                                                i3 = i3;
                                                i8 = iZza3;
                                                this = zzalrVar2;
                                                i3 = i3;
                                                i32 = i32;
                                                unsafe = unsafe3;
                                                i7 = i23;
                                                zzaivVar6 = zzaivVar3;
                                                i6 = i39;
                                                t2 = t;
                                            } else {
                                                i3 = i3;
                                                iZza5 = iZza3;
                                                i3 = i3;
                                                unsafe5 = unsafe3;
                                                i33 = i23;
                                                i2 = i24;
                                                zzaivVar6 = zzaivVar3;
                                                i35 = i39;
                                                i34 = i34;
                                                i36 = i36;
                                                t2 = t;
                                            }
                                        }
                                        break;
                                    case 49:
                                        if (i40 == 3) {
                                            i29 = i44;
                                            i28 = i41;
                                            zzaivVar5 = zzaivVar7;
                                            iZza3 = zzais.zza((zzamc<?>) zzalrVar2.zze(i41), i52 == true ? 1 : 0, bArr, i29, i2, (zzakn<Object>) zzaknVarZza, zzaivVar);
                                            i3 = i3;
                                            zzaivVar3 = zzaivVar5;
                                            i32 = i28;
                                            i24 = i53;
                                            i22 = i29;
                                            i23 = i52 == true ? 1 : 0;
                                            unsafe3 = unsafe7;
                                            if (iZza3 == i22) {
                                                i3 = i3;
                                                i8 = iZza3;
                                                this = zzalrVar2;
                                                i3 = i3;
                                                i32 = i32;
                                                unsafe = unsafe3;
                                                i7 = i23;
                                                zzaivVar6 = zzaivVar3;
                                                i6 = i39;
                                                t2 = t;
                                            } else {
                                                i3 = i3;
                                                iZza5 = iZza3;
                                                i3 = i3;
                                                unsafe5 = unsafe3;
                                                i33 = i23;
                                                i2 = i24;
                                                zzaivVar6 = zzaivVar3;
                                                i35 = i39;
                                                i34 = i34;
                                                i36 = i36;
                                                t2 = t;
                                            }
                                            break;
                                        }
                                    default:
                                        i32 = i41;
                                        zzaivVar3 = zzaivVar7;
                                        i22 = i44;
                                        i23 = i52 == true ? 1 : 0;
                                        unsafe3 = unsafe7;
                                        i24 = i53;
                                        iZza3 = i22;
                                        if (iZza3 == i22) {
                                            i3 = i3;
                                            i8 = iZza3;
                                            this = zzalrVar2;
                                            i3 = i3;
                                            i32 = i32;
                                            unsafe = unsafe3;
                                            i7 = i23;
                                            zzaivVar6 = zzaivVar3;
                                            i6 = i39;
                                            t2 = t;
                                        } else {
                                            i3 = i3;
                                            iZza5 = iZza3;
                                            i3 = i3;
                                            unsafe5 = unsafe3;
                                            i33 = i23;
                                            i2 = i24;
                                            zzaivVar6 = zzaivVar3;
                                            i35 = i39;
                                            i34 = i34;
                                            i36 = i36;
                                            t2 = t;
                                        }
                                        break;
                                }
                            } else {
                                Unsafe unsafe9 = unsafe7;
                                i32 = i41;
                                i14 = i44;
                                int i74 = i52 == true ? 1 : 0;
                                if (i43 != 50) {
                                    zzaivVar6 = zzaivVar7;
                                    unsafe = unsafe9;
                                    t2 = t;
                                    Unsafe unsafe10 = zzb;
                                    long j3 = iArr[i32 + 2] & 1048575;
                                    switch (i43) {
                                        case 51:
                                            this = this;
                                            i16 = i14;
                                            i32 = i32;
                                            i6 = i39;
                                            i7 = i74 == true ? 1 : 0;
                                            if (i40 == 1) {
                                                unsafe10.putObject(t2, j, Double.valueOf(zzais.zza(bArr, i16)));
                                                i17 = i16 + 8;
                                                unsafe10.putInt(t2, j3, i6);
                                                iZza5 = i17;
                                            } else {
                                                iZza5 = i16;
                                            }
                                            if (iZza5 != i16) {
                                                i6 = i6;
                                                this = this;
                                                i3 = i3;
                                                i8 = iZza5;
                                            } else {
                                                i6 = i6;
                                                this = this;
                                                boolean z = i7 == true ? 1 : 0;
                                                int i75 = i6;
                                                bArr = bArr;
                                                i2 = i2;
                                                zzaivVar6 = zzaivVar6;
                                                i35 = i75;
                                                i32 = i32;
                                                i33 = z ? 1 : 0;
                                                i34 = i34;
                                                i36 = i36;
                                                unsafe5 = unsafe;
                                                zzalrVar2 = this;
                                                i3 = i3;
                                            }
                                            break;
                                        case 52:
                                            this = this;
                                            i16 = i14;
                                            i32 = i32;
                                            i6 = i39;
                                            i7 = i74 == true ? 1 : 0;
                                            if (i40 == 5) {
                                                unsafe10.putObject(t2, j, Float.valueOf(zzais.zzb(bArr, i16)));
                                                i17 = i16 + 4;
                                                unsafe10.putInt(t2, j3, i6);
                                                iZza5 = i17;
                                            } else {
                                                iZza5 = i16;
                                            }
                                            if (iZza5 != i16) {
                                                i6 = i6;
                                                this = this;
                                                i3 = i3;
                                                i8 = iZza5;
                                            } else {
                                                i6 = i6;
                                                this = this;
                                                boolean z2 = i7 == true ? 1 : 0;
                                                int i76 = i6;
                                                bArr = bArr;
                                                i2 = i2;
                                                zzaivVar6 = zzaivVar6;
                                                i35 = i76;
                                                i32 = i32;
                                                i33 = z2 ? 1 : 0;
                                                i34 = i34;
                                                i36 = i36;
                                                unsafe5 = unsafe;
                                                zzalrVar2 = this;
                                                i3 = i3;
                                            }
                                            break;
                                        case 53:
                                        case 54:
                                            this = this;
                                            i16 = i14;
                                            i32 = i32;
                                            i6 = i39;
                                            i7 = i74 == true ? 1 : 0;
                                            if (i40 == 0) {
                                                iZzd = zzais.zzd(bArr, i16, zzaivVar6);
                                                unsafe10.putObject(t2, j, Long.valueOf(zzaivVar6.zzb));
                                                unsafe10.putInt(t2, j3, i6);
                                                iZza5 = iZzd;
                                            } else {
                                                iZza5 = i16;
                                            }
                                            if (iZza5 != i16) {
                                                i6 = i6;
                                                this = this;
                                                i3 = i3;
                                                i8 = iZza5;
                                            } else {
                                                i6 = i6;
                                                this = this;
                                                boolean z3 = i7 == true ? 1 : 0;
                                                int i77 = i6;
                                                bArr = bArr;
                                                i2 = i2;
                                                zzaivVar6 = zzaivVar6;
                                                i35 = i77;
                                                i32 = i32;
                                                i33 = z3 ? 1 : 0;
                                                i34 = i34;
                                                i36 = i36;
                                                unsafe5 = unsafe;
                                                zzalrVar2 = this;
                                                i3 = i3;
                                            }
                                            break;
                                        case 55:
                                        case 62:
                                            this = this;
                                            i16 = i14;
                                            i32 = i32;
                                            i6 = i39;
                                            i7 = i74 == true ? 1 : 0;
                                            if (i40 == 0) {
                                                iZzd = zzais.zzc(bArr, i16, zzaivVar6);
                                                unsafe10.putObject(t2, j, Integer.valueOf(zzaivVar6.zza));
                                                unsafe10.putInt(t2, j3, i6);
                                                iZza5 = iZzd;
                                            } else {
                                                iZza5 = i16;
                                            }
                                            if (iZza5 != i16) {
                                                i6 = i6;
                                                this = this;
                                                i3 = i3;
                                                i8 = iZza5;
                                            } else {
                                                i6 = i6;
                                                this = this;
                                                boolean z4 = i7 == true ? 1 : 0;
                                                int i78 = i6;
                                                bArr = bArr;
                                                i2 = i2;
                                                zzaivVar6 = zzaivVar6;
                                                i35 = i78;
                                                i32 = i32;
                                                i33 = z4 ? 1 : 0;
                                                i34 = i34;
                                                i36 = i36;
                                                unsafe5 = unsafe;
                                                zzalrVar2 = this;
                                                i3 = i3;
                                            }
                                            break;
                                        case 56:
                                        case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                                            this = this;
                                            i16 = i14;
                                            i32 = i32;
                                            i6 = i39;
                                            i7 = i74 == true ? 1 : 0;
                                            if (i40 == 1) {
                                                unsafe10.putObject(t2, j, Long.valueOf(zzais.zzd(bArr, i16)));
                                                i17 = i16 + 8;
                                                unsafe10.putInt(t2, j3, i6);
                                                iZza5 = i17;
                                            } else {
                                                iZza5 = i16;
                                            }
                                            if (iZza5 != i16) {
                                                i6 = i6;
                                                this = this;
                                                i3 = i3;
                                                i8 = iZza5;
                                            } else {
                                                i6 = i6;
                                                this = this;
                                                boolean z5 = i7 == true ? 1 : 0;
                                                int i79 = i6;
                                                bArr = bArr;
                                                i2 = i2;
                                                zzaivVar6 = zzaivVar6;
                                                i35 = i79;
                                                i32 = i32;
                                                i33 = z5 ? 1 : 0;
                                                i34 = i34;
                                                i36 = i36;
                                                unsafe5 = unsafe;
                                                zzalrVar2 = this;
                                                i3 = i3;
                                            }
                                            break;
                                        case 57:
                                        case 64:
                                            this = this;
                                            i16 = i14;
                                            i32 = i32;
                                            i6 = i39;
                                            i7 = i74 == true ? 1 : 0;
                                            if (i40 == 5) {
                                                unsafe10.putObject(t2, j, Integer.valueOf(zzais.zzc(bArr, i16)));
                                                i17 = i16 + 4;
                                                unsafe10.putInt(t2, j3, i6);
                                                iZza5 = i17;
                                            } else {
                                                iZza5 = i16;
                                            }
                                            if (iZza5 != i16) {
                                                i6 = i6;
                                                this = this;
                                                i3 = i3;
                                                i8 = iZza5;
                                            } else {
                                                i6 = i6;
                                                this = this;
                                                boolean z6 = i7 == true ? 1 : 0;
                                                int i710 = i6;
                                                bArr = bArr;
                                                i2 = i2;
                                                zzaivVar6 = zzaivVar6;
                                                i35 = i710;
                                                i32 = i32;
                                                i33 = z6 ? 1 : 0;
                                                i34 = i34;
                                                i36 = i36;
                                                unsafe5 = unsafe;
                                                zzalrVar2 = this;
                                                i3 = i3;
                                            }
                                            break;
                                        case 58:
                                            this = this;
                                            i16 = i14;
                                            i32 = i32;
                                            i6 = i39;
                                            i7 = i74 == true ? 1 : 0;
                                            if (i40 == 0) {
                                                iZzd = zzais.zzd(bArr, i16, zzaivVar6);
                                                unsafe10.putObject(t2, j, Boolean.valueOf(zzaivVar6.zzb != 0));
                                                unsafe10.putInt(t2, j3, i6);
                                                iZza5 = iZzd;
                                            } else {
                                                iZza5 = i16;
                                            }
                                            if (iZza5 != i16) {
                                                i6 = i6;
                                                this = this;
                                                i3 = i3;
                                                i8 = iZza5;
                                            } else {
                                                i6 = i6;
                                                this = this;
                                                boolean z7 = i7 == true ? 1 : 0;
                                                int i711 = i6;
                                                bArr = bArr;
                                                i2 = i2;
                                                zzaivVar6 = zzaivVar6;
                                                i35 = i711;
                                                i32 = i32;
                                                i33 = z7 ? 1 : 0;
                                                i34 = i34;
                                                i36 = i36;
                                                unsafe5 = unsafe;
                                                zzalrVar2 = this;
                                                i3 = i3;
                                            }
                                            break;
                                        case 59:
                                            this = this;
                                            i16 = i14;
                                            i32 = i32;
                                            i6 = i39;
                                            i7 = i74 == true ? 1 : 0;
                                            if (i40 == 2) {
                                                int iZzc16 = zzais.zzc(bArr, i16, zzaivVar6);
                                                int i80 = zzaivVar6.zza;
                                                if (i80 == 0) {
                                                    unsafe10.putObject(t2, j, "");
                                                } else {
                                                    if ((i42 & 536870912) != 0 && !zzanb.zzc(bArr, iZzc16, iZzc16 + i80)) {
                                                        throw zzakm.zzd();
                                                    }
                                                    unsafe10.putObject(t2, j, new String(bArr, iZzc16, i80, zzaki.zza));
                                                    iZzc16 += i80;
                                                }
                                                unsafe10.putInt(t2, j3, i6);
                                                iZza5 = iZzc16;
                                            } else {
                                                iZza5 = i16;
                                            }
                                            if (iZza5 != i16) {
                                                i6 = i6;
                                                this = this;
                                                i3 = i3;
                                                i8 = iZza5;
                                            } else {
                                                i6 = i6;
                                                this = this;
                                                boolean z8 = i7 == true ? 1 : 0;
                                                int i712 = i6;
                                                bArr = bArr;
                                                i2 = i2;
                                                zzaivVar6 = zzaivVar6;
                                                i35 = i712;
                                                i32 = i32;
                                                i33 = z8 ? 1 : 0;
                                                i34 = i34;
                                                i36 = i36;
                                                unsafe5 = unsafe;
                                                zzalrVar2 = this;
                                                i3 = i3;
                                            }
                                            break;
                                        case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                                            this = this;
                                            i18 = i14;
                                            i19 = i32;
                                            i6 = i39;
                                            i7 = i74 == true ? 1 : 0;
                                            if (i40 == 2) {
                                                Object objZza3 = this.zza(t2, i6, i19);
                                                int iZza7 = zzais.zza(objZza3, this.zze(i19), bArr, i18, i2, zzaivVar);
                                                this.zza(t2, i6, i19, objZza3);
                                                iZza5 = iZza7;
                                                i32 = i19;
                                                i16 = i18;
                                            } else {
                                                i32 = i19;
                                                i16 = i18;
                                                iZza5 = i16;
                                            }
                                            if (iZza5 != i16) {
                                                i6 = i6;
                                                this = this;
                                                i3 = i3;
                                                i8 = iZza5;
                                            } else {
                                                i6 = i6;
                                                this = this;
                                                boolean z9 = i7 == true ? 1 : 0;
                                                int i713 = i6;
                                                bArr = bArr;
                                                i2 = i2;
                                                zzaivVar6 = zzaivVar6;
                                                i35 = i713;
                                                i32 = i32;
                                                i33 = z9 ? 1 : 0;
                                                i34 = i34;
                                                i36 = i36;
                                                unsafe5 = unsafe;
                                                zzalrVar2 = this;
                                                i3 = i3;
                                            }
                                            break;
                                        case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                                            this = this;
                                            i18 = i14;
                                            i19 = i32;
                                            i6 = i39;
                                            i7 = i74 == true ? 1 : 0;
                                            if (i40 == 2) {
                                                iZza2 = zzais.zza(bArr, i18, zzaivVar6);
                                                unsafe10.putObject(t2, j, zzaivVar6.zzc);
                                                unsafe10.putInt(t2, j3, i6);
                                                iZza5 = iZza2;
                                                i32 = i19;
                                                i16 = i18;
                                                if (iZza5 != i16) {
                                                    i6 = i6;
                                                    this = this;
                                                    i3 = i3;
                                                    i8 = iZza5;
                                                } else {
                                                    i6 = i6;
                                                    this = this;
                                                    boolean z10 = i7 == true ? 1 : 0;
                                                    int i714 = i6;
                                                    bArr = bArr;
                                                    i2 = i2;
                                                    zzaivVar6 = zzaivVar6;
                                                    i35 = i714;
                                                    i32 = i32;
                                                    i33 = z10 ? 1 : 0;
                                                    i34 = i34;
                                                    i36 = i36;
                                                    unsafe5 = unsafe;
                                                    zzalrVar2 = this;
                                                    i3 = i3;
                                                }
                                            }
                                            i32 = i19;
                                            i16 = i18;
                                            iZza5 = i16;
                                            if (iZza5 != i16) {
                                                i6 = i6;
                                                this = this;
                                                i3 = i3;
                                                i8 = iZza5;
                                            } else {
                                                i6 = i6;
                                                this = this;
                                                boolean z11 = i7 == true ? 1 : 0;
                                                int i715 = i6;
                                                bArr = bArr;
                                                i2 = i2;
                                                zzaivVar6 = zzaivVar6;
                                                i35 = i715;
                                                i32 = i32;
                                                i33 = z11 ? 1 : 0;
                                                i34 = i34;
                                                i36 = i36;
                                                unsafe5 = unsafe;
                                                zzalrVar2 = this;
                                                i3 = i3;
                                            }
                                            break;
                                        case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                                            this = this;
                                            i18 = i14;
                                            i19 = i32;
                                            i6 = i39;
                                            i7 = i74 == true ? 1 : 0;
                                            if (i40 == 0) {
                                                iZza2 = zzais.zzc(bArr, i18, zzaivVar6);
                                                int i81 = zzaivVar6.zza;
                                                zzakk zzakkVarZzd2 = this.zzd(i19);
                                                if (zzakkVarZzd2 == null || zzakkVarZzd2.zza(i81)) {
                                                    unsafe10.putObject(t2, j, Integer.valueOf(i81));
                                                    unsafe10.putInt(t2, j3, i6);
                                                } else {
                                                    zzc(t).zza(i7 == true ? 1 : 0, Long.valueOf(i81));
                                                }
                                                iZza5 = iZza2;
                                                i32 = i19;
                                                i16 = i18;
                                                if (iZza5 != i16) {
                                                    i6 = i6;
                                                    this = this;
                                                    i3 = i3;
                                                    i8 = iZza5;
                                                } else {
                                                    i6 = i6;
                                                    this = this;
                                                    boolean z12 = i7 == true ? 1 : 0;
                                                    int i716 = i6;
                                                    bArr = bArr;
                                                    i2 = i2;
                                                    zzaivVar6 = zzaivVar6;
                                                    i35 = i716;
                                                    i32 = i32;
                                                    i33 = z12 ? 1 : 0;
                                                    i34 = i34;
                                                    i36 = i36;
                                                    unsafe5 = unsafe;
                                                    zzalrVar2 = this;
                                                    i3 = i3;
                                                }
                                            }
                                            i32 = i19;
                                            i16 = i18;
                                            iZza5 = i16;
                                            if (iZza5 != i16) {
                                                i6 = i6;
                                                this = this;
                                                i3 = i3;
                                                i8 = iZza5;
                                            } else {
                                                i6 = i6;
                                                this = this;
                                                boolean z13 = i7 == true ? 1 : 0;
                                                int i717 = i6;
                                                bArr = bArr;
                                                i2 = i2;
                                                zzaivVar6 = zzaivVar6;
                                                i35 = i717;
                                                i32 = i32;
                                                i33 = z13 ? 1 : 0;
                                                i34 = i34;
                                                i36 = i36;
                                                unsafe5 = unsafe;
                                                zzalrVar2 = this;
                                                i3 = i3;
                                            }
                                            break;
                                        case 66:
                                            this = this;
                                            i18 = i14;
                                            i19 = i32;
                                            i6 = i39;
                                            i7 = i74 == true ? 1 : 0;
                                            if (i40 == 0) {
                                                iZza2 = zzais.zzc(bArr, i18, zzaivVar6);
                                                unsafe10.putObject(t2, j, Integer.valueOf(zzaji.zza(zzaivVar6.zza)));
                                                unsafe10.putInt(t2, j3, i6);
                                                iZza5 = iZza2;
                                                i32 = i19;
                                                i16 = i18;
                                                if (iZza5 != i16) {
                                                    i6 = i6;
                                                    this = this;
                                                    i3 = i3;
                                                    i8 = iZza5;
                                                } else {
                                                    i6 = i6;
                                                    this = this;
                                                    boolean z14 = i7 == true ? 1 : 0;
                                                    int i718 = i6;
                                                    bArr = bArr;
                                                    i2 = i2;
                                                    zzaivVar6 = zzaivVar6;
                                                    i35 = i718;
                                                    i32 = i32;
                                                    i33 = z14 ? 1 : 0;
                                                    i34 = i34;
                                                    i36 = i36;
                                                    unsafe5 = unsafe;
                                                    zzalrVar2 = this;
                                                    i3 = i3;
                                                }
                                            }
                                            i32 = i19;
                                            i16 = i18;
                                            iZza5 = i16;
                                            if (iZza5 != i16) {
                                                i6 = i6;
                                                this = this;
                                                i3 = i3;
                                                i8 = iZza5;
                                            } else {
                                                i6 = i6;
                                                this = this;
                                                boolean z15 = i7 == true ? 1 : 0;
                                                int i719 = i6;
                                                bArr = bArr;
                                                i2 = i2;
                                                zzaivVar6 = zzaivVar6;
                                                i35 = i719;
                                                i32 = i32;
                                                i33 = z15 ? 1 : 0;
                                                i34 = i34;
                                                i36 = i36;
                                                unsafe5 = unsafe;
                                                zzalrVar2 = this;
                                                i3 = i3;
                                            }
                                            break;
                                        case 67:
                                            this = this;
                                            i18 = i14;
                                            i19 = i32;
                                            i6 = i39;
                                            i7 = i74 == true ? 1 : 0;
                                            if (i40 == 0) {
                                                int iZzd4 = zzais.zzd(bArr, i18, zzaivVar6);
                                                unsafe10.putObject(t2, j, Long.valueOf(zzaji.zza(zzaivVar6.zzb)));
                                                unsafe10.putInt(t2, j3, i6);
                                                iZza5 = iZzd4;
                                                i32 = i19;
                                                i16 = i18;
                                                if (iZza5 != i16) {
                                                    i6 = i6;
                                                    this = this;
                                                    i3 = i3;
                                                    i8 = iZza5;
                                                } else {
                                                    i6 = i6;
                                                    this = this;
                                                    boolean z16 = i7 == true ? 1 : 0;
                                                    int i7110 = i6;
                                                    bArr = bArr;
                                                    i2 = i2;
                                                    zzaivVar6 = zzaivVar6;
                                                    i35 = i7110;
                                                    i32 = i32;
                                                    i33 = z16 ? 1 : 0;
                                                    i34 = i34;
                                                    i36 = i36;
                                                    unsafe5 = unsafe;
                                                    zzalrVar2 = this;
                                                    i3 = i3;
                                                }
                                            }
                                            i32 = i19;
                                            i16 = i18;
                                            iZza5 = i16;
                                            if (iZza5 != i16) {
                                                i6 = i6;
                                                this = this;
                                                i3 = i3;
                                                i8 = iZza5;
                                            } else {
                                                i6 = i6;
                                                this = this;
                                                boolean z17 = i7 == true ? 1 : 0;
                                                int i7111 = i6;
                                                bArr = bArr;
                                                i2 = i2;
                                                zzaivVar6 = zzaivVar6;
                                                i35 = i7111;
                                                i32 = i32;
                                                i33 = z17 ? 1 : 0;
                                                i34 = i34;
                                                i36 = i36;
                                                unsafe5 = unsafe;
                                                zzalrVar2 = this;
                                                i3 = i3;
                                            }
                                            break;
                                        case 68:
                                            if (i40 == 3) {
                                                this = this;
                                                i6 = i39;
                                                Object objZza4 = this.zza(t2, i6, i32);
                                                iZza5 = zzais.zza(objZza4, this.zze(i32), bArr, i14, i2, ((i74 == true ? 1 : 0) & (-8)) | 4, zzaivVar);
                                                this.zza(t2, i6, i32, objZza4);
                                                i32 = i32;
                                                i16 = i14;
                                                i7 = i74 == true ? 1 : 0;
                                            }
                                            if (iZza5 != i16) {
                                                i6 = i6;
                                                this = this;
                                                boolean z18 = i7 == true ? 1 : 0;
                                                int i7112 = i6;
                                                bArr = bArr;
                                                i2 = i2;
                                                zzaivVar6 = zzaivVar6;
                                                i35 = i7112;
                                                i32 = i32;
                                                i33 = z18 ? 1 : 0;
                                                i34 = i34;
                                                i36 = i36;
                                                unsafe5 = unsafe;
                                                zzalrVar2 = this;
                                                i3 = i3;
                                                break;
                                            } else {
                                                i6 = i6;
                                                this = this;
                                                i3 = i3;
                                                i8 = iZza5;
                                                break;
                                            }
                                        default:
                                            this = this;
                                            i16 = i14;
                                            i32 = i32;
                                            i6 = i39;
                                            i7 = i74 == true ? 1 : 0;
                                            iZza5 = i16;
                                            if (iZza5 != i16) {
                                                i6 = i6;
                                                this = this;
                                                i3 = i3;
                                                i8 = iZza5;
                                            } else {
                                                i6 = i6;
                                                this = this;
                                                boolean z19 = i7 == true ? 1 : 0;
                                                int i7113 = i6;
                                                bArr = bArr;
                                                i2 = i2;
                                                zzaivVar6 = zzaivVar6;
                                                i35 = i7113;
                                                i32 = i32;
                                                i33 = z19 ? 1 : 0;
                                                i34 = i34;
                                                i36 = i36;
                                                unsafe5 = unsafe;
                                                zzalrVar2 = this;
                                                i3 = i3;
                                            }
                                            break;
                                    }
                                } else if (i40 == 2) {
                                    Unsafe unsafe11 = zzb;
                                    Object objZzf = zzalrVar2.zzf(i32);
                                    zzaivVar2 = zzaivVar7;
                                    t2 = t;
                                    Object object = unsafe11.getObject(t2, j);
                                    if (zzalrVar2.zzr.zzf(object)) {
                                        Object objZzb = zzalrVar2.zzr.zzb(objZzf);
                                        zzalrVar2.zzr.zza(objZzb, object);
                                        unsafe11.putObject(t2, j, objZzb);
                                        object = objZzb;
                                    }
                                    zzale<?, ?> zzaleVarZza = zzalrVar2.zzr.zza(objZzf);
                                    Map<?, ?> mapZze = zzalrVar2.zzr.zze(object);
                                    int iZzc17 = zzais.zzc(bArr, i14, zzaivVar2);
                                    int i82 = zzaivVar2.zza;
                                    if (i82 < 0 || i82 > i53 - iZzc17) {
                                        throw zzakm.zzj();
                                    }
                                    int i83 = iZzc17 + i82;
                                    Object obj3 = zzaleVarZza.zzb;
                                    Object obj4 = zzaleVarZza.zzd;
                                    Object obj5 = obj3;
                                    while (iZzc17 < i83) {
                                        int iZza8 = iZzc17 + 1;
                                        int i84 = bArr[iZzc17];
                                        if (i84 < 0) {
                                            obj = obj4;
                                            iZza8 = zzais.zza(i84, bArr, iZza8, zzaivVar2);
                                            i84 = zzaivVar2.zza;
                                        }
                                        obj = obj4;
                                        Object obj6 = obj;
                                        int i85 = i84 >>> 3;
                                        Object obj7 = obj5;
                                        int i86 = i84 & 7;
                                        if (i85 != 1) {
                                            if (i85 == 2) {
                                                if (i86 == zzaleVarZza.zzc.zza()) {
                                                    iZzc17 = zza(bArr, iZza8, i2, zzaleVarZza.zzc, zzaleVarZza.zzd.getClass(), zzaivVar);
                                                    obj2 = zzaivVar2.zzc;
                                                    i83 = i83;
                                                    obj5 = obj7;
                                                    i74 = i74 == true ? 1 : 0;
                                                } else {
                                                    i20 = i83;
                                                    i21 = i74;
                                                    unsafe2 = unsafe9;
                                                }
                                            } else {
                                                i20 = i83;
                                                i21 = i74;
                                                obj7 = obj7;
                                                unsafe2 = unsafe9;
                                                iZzc17 = zzais.zza(i84, bArr, iZza8, i53, zzaivVar2);
                                                i83 = i20;
                                                obj5 = obj7;
                                                obj2 = obj6;
                                                i74 = i21;
                                                unsafe9 = unsafe2;
                                            }
                                            obj = obj2;
                                        } else {
                                            i20 = i83;
                                            i21 = i74;
                                            unsafe2 = unsafe9;
                                            if (i86 == zzaleVarZza.zza.zza()) {
                                                iZzc17 = zza(bArr, iZza8, i2, zzaleVarZza.zza, (Class<?>) null, zzaivVar);
                                                obj5 = zzaivVar2.zzc;
                                                i83 = i20;
                                                obj2 = obj6;
                                            }
                                            i74 = i21;
                                            unsafe9 = unsafe2;
                                            obj = obj2;
                                        }
                                        iZzc17 = zzais.zza(i84, bArr, iZza8, i53, zzaivVar2);
                                        i83 = i20;
                                        obj5 = obj7;
                                        obj2 = obj6;
                                        i74 = i21;
                                        unsafe9 = unsafe2;
                                        obj = obj2;
                                    }
                                    obj = obj4;
                                    int i87 = i83;
                                    i15 = i74;
                                    unsafe = unsafe9;
                                    Object obj8 = obj5;
                                    if (iZzc17 != i87) {
                                        throw zzakm.zzg();
                                    }
                                    mapZze.put(obj8, obj);
                                    if (i87 == i14) {
                                        i8 = i87;
                                        zzaivVar6 = zzaivVar2;
                                        i32 = i32;
                                        i6 = i39;
                                        i7 = i15;
                                    } else {
                                        i3 = i3;
                                        iZza5 = i87;
                                        zzaivVar6 = zzaivVar2;
                                        i2 = i53;
                                        i35 = i39;
                                        i34 = i34;
                                        i33 = i15 == true ? 1 : 0;
                                        i36 = i36;
                                        unsafe5 = unsafe;
                                        zzalrVar2 = this;
                                    }
                                } else {
                                    i15 = i74 == true ? 1 : 0;
                                    zzaivVar2 = zzaivVar7;
                                    unsafe = unsafe9;
                                    t2 = t;
                                    i8 = i14;
                                    zzaivVar6 = zzaivVar2;
                                    i32 = i32;
                                    i6 = i39;
                                    i7 = i15;
                                }
                            }
                        } else if (i40 == 2) {
                            zzakn zzaknVarZza2 = (zzakn) unsafe6.getObject(t2, j);
                            if (!zzaknVarZza2.zzc()) {
                                int size = zzaknVarZza2.size();
                                zzaknVarZza2 = zzaknVarZza2.zza(size == 0 ? 10 : size << 1);
                                unsafe6.putObject(t2, j, zzaknVarZza2);
                            }
                            iZza5 = zzais.zzb(zzalrVar2.zze(i41), i52 == true ? 1 : 0, bArr, i44, i2, zzaknVarZza2, zzaivVar);
                            zzaivVar6 = zzaivVar7;
                            i32 = i41;
                            i2 = i53;
                            unsafe5 = unsafe6;
                            i35 = i39;
                            i33 = i52 == true ? 1 : 0;
                            i34 = i34;
                            i36 = i36;
                            i3 = i3;
                        } else {
                            unsafe = unsafe6;
                            i14 = i44;
                            i32 = i41;
                            zzaivVar2 = zzaivVar7;
                            i15 = i52 == true ? 1 : 0;
                            i8 = i14;
                            zzaivVar6 = zzaivVar2;
                            i32 = i32;
                            i6 = i39;
                            i7 = i15;
                        }
                    }
                } else {
                    unsafe = unsafe5;
                    i3 = i3;
                    this = zzalrVar2;
                    i6 = i39;
                    i7 = i5;
                    i34 = i34;
                    i36 = i36;
                    i32 = 0;
                    zzaivVar6 = zzaivVar6;
                    i8 = i37;
                }
                if (i7 != i3 || i3 == 0) {
                    if (this.zzh && zzaivVar6.zzd != zzajv.zza) {
                        iZza5 = zzais.zza(i7 == true ? 1 : 0, bArr, i8, i2, t, this.zzg, this.zzp, zzaivVar);
                        i35 = i6;
                        i33 = i7 == true ? 1 : 0;
                        zzalrVar2 = this;
                        i3 = i3;
                    } else {
                        int i88 = i7;
                        zzalr<T> zzalrVar3 = this;
                        iZza5 = zzais.zza(i88 == true ? 1 : 0, bArr, i8, i2, zzc(t), zzaivVar);
                        i3 = i3;
                        i35 = i6;
                        zzalrVar2 = zzalrVar3;
                        i33 = i88 == true ? 1 : 0;
                    }
                    unsafe5 = unsafe;
                } else {
                    iZza5 = i8;
                    i4 = i3;
                    zzalrVar = this;
                    i33 = i7;
                    i34 = i34;
                    i36 = i36;
                }
            } else {
                unsafe = unsafe5;
                i4 = i3;
                zzalrVar = zzalrVar2;
            }
        }
        if (i36 != 1048575) {
            unsafe.putInt(t2, i36, i34);
        }
        zzamy zzamyVar = null;
        for (int i89 = zzalrVar.zzl; i89 < zzalrVar.zzm; i89++) {
            zzamyVar = (zzamy) zza(t, zzalrVar.zzk[i89], zzamyVar, (zzamv<UT, zzamy>) zzalrVar.zzp, t);
        }
        if (zzamyVar != null) {
            zzalrVar.zzp.zzb(t2, zzamyVar);
        }
        if (i4 == 0) {
            if (iZza5 != i2) {
                throw zzakm.zzg();
            }
        } else if (iZza5 > i2 || i33 != i4) {
            throw zzakm.zzg();
        }
        return iZza5;
    }

    private final int zza(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zza(i, 0);
    }

    private final int zzb(int i) {
        return this.zzc[i + 2];
    }

    private final int zza(int i, int i2) {
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

    private final int zzc(int i) {
        return this.zzc[i + 1];
    }

    private static <T> long zzd(T t, long j) {
        return ((Long) zzana.zze(t, j)).longValue();
    }

    private final zzakk zzd(int i) {
        return (zzakk) this.zzd[((i / 3) << 1) + 1];
    }

    /* JADX WARN: Code duplicated, block: B:124:0x0264  */
    /* JADX WARN: Code duplicated, block: B:125:0x0267  */
    /* JADX WARN: Code duplicated, block: B:128:0x027e  */
    /* JADX WARN: Code duplicated, block: B:129:0x0281  */
    /* JADX WARN: Code duplicated, block: B:166:0x033b  */
    /* JADX WARN: Code duplicated, block: B:180:0x0387  */
    /* JADX WARN: Code duplicated, block: B:183:0x0394  */
    static <T> zzalr<T> zza(Class<T> cls, zzall zzallVar, zzalv zzalvVar, zzakx zzakxVar, zzamv<?, ?> zzamvVar, zzajx<?> zzajxVar, zzalg zzalgVar) {
        int i;
        int iCharAt;
        int iCharAt2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int[] iArr;
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
        zzama zzamaVar;
        int i19;
        int iObjectFieldOffset;
        int iObjectFieldOffset2;
        int i20;
        int i21;
        Field fieldZza;
        int i22;
        char cCharAt9;
        int i23;
        int i24;
        int i25;
        int i26;
        Object obj;
        Field fieldZza2;
        int i27;
        Object obj2;
        Field fieldZza3;
        int i28;
        char cCharAt10;
        int i29;
        char cCharAt11;
        int i30;
        char cCharAt12;
        int i31;
        char cCharAt13;
        if (zzallVar instanceof zzama) {
            zzama zzamaVar2 = (zzama) zzallVar;
            String strZzd = zzamaVar2.zzd();
            int length = strZzd.length();
            char c = 55296;
            if (strZzd.charAt(0) >= 55296) {
                int i32 = 1;
                while (true) {
                    i = i32 + 1;
                    if (strZzd.charAt(i32) < 55296) {
                        break;
                    }
                    i32 = i;
                }
            } else {
                i = 1;
            }
            int i33 = i + 1;
            int iCharAt3 = strZzd.charAt(i);
            if (iCharAt3 >= 55296) {
                int i34 = iCharAt3 & 8191;
                int i35 = 13;
                while (true) {
                    i31 = i33 + 1;
                    cCharAt13 = strZzd.charAt(i33);
                    if (cCharAt13 < 55296) {
                        break;
                    }
                    i34 |= (cCharAt13 & 8191) << i35;
                    i35 += 13;
                    i33 = i31;
                }
                iCharAt3 = i34 | (cCharAt13 << i35);
                i33 = i31;
            }
            if (iCharAt3 == 0) {
                i6 = 0;
                iCharAt = 0;
                iCharAt2 = 0;
                i5 = 0;
                i4 = 0;
                i3 = 0;
                iArr = zza;
                i2 = 0;
            } else {
                int i36 = i33 + 1;
                int iCharAt4 = strZzd.charAt(i33);
                if (iCharAt4 >= 55296) {
                    int i37 = iCharAt4 & 8191;
                    int i38 = 13;
                    while (true) {
                        i14 = i36 + 1;
                        cCharAt8 = strZzd.charAt(i36);
                        if (cCharAt8 < 55296) {
                            break;
                        }
                        i37 |= (cCharAt8 & 8191) << i38;
                        i38 += 13;
                        i36 = i14;
                    }
                    iCharAt4 = i37 | (cCharAt8 << i38);
                    i36 = i14;
                }
                int i39 = i36 + 1;
                int iCharAt5 = strZzd.charAt(i36);
                if (iCharAt5 >= 55296) {
                    int i40 = iCharAt5 & 8191;
                    int i41 = 13;
                    while (true) {
                        i13 = i39 + 1;
                        cCharAt7 = strZzd.charAt(i39);
                        if (cCharAt7 < 55296) {
                            break;
                        }
                        i40 |= (cCharAt7 & 8191) << i41;
                        i41 += 13;
                        i39 = i13;
                    }
                    iCharAt5 = i40 | (cCharAt7 << i41);
                    i39 = i13;
                }
                int i42 = i39 + 1;
                int iCharAt6 = strZzd.charAt(i39);
                if (iCharAt6 >= 55296) {
                    int i43 = iCharAt6 & 8191;
                    int i44 = 13;
                    while (true) {
                        i12 = i42 + 1;
                        cCharAt6 = strZzd.charAt(i42);
                        if (cCharAt6 < 55296) {
                            break;
                        }
                        i43 |= (cCharAt6 & 8191) << i44;
                        i44 += 13;
                        i42 = i12;
                    }
                    iCharAt6 = i43 | (cCharAt6 << i44);
                    i42 = i12;
                }
                int i45 = i42 + 1;
                int iCharAt7 = strZzd.charAt(i42);
                if (iCharAt7 >= 55296) {
                    int i46 = iCharAt7 & 8191;
                    int i47 = 13;
                    while (true) {
                        i11 = i45 + 1;
                        cCharAt5 = strZzd.charAt(i45);
                        if (cCharAt5 < 55296) {
                            break;
                        }
                        i46 |= (cCharAt5 & 8191) << i47;
                        i47 += 13;
                        i45 = i11;
                    }
                    iCharAt7 = i46 | (cCharAt5 << i47);
                    i45 = i11;
                }
                int i48 = i45 + 1;
                iCharAt = strZzd.charAt(i45);
                if (iCharAt >= 55296) {
                    int i49 = iCharAt & 8191;
                    int i50 = 13;
                    while (true) {
                        i10 = i48 + 1;
                        cCharAt4 = strZzd.charAt(i48);
                        if (cCharAt4 < 55296) {
                            break;
                        }
                        i49 |= (cCharAt4 & 8191) << i50;
                        i50 += 13;
                        i48 = i10;
                    }
                    iCharAt = i49 | (cCharAt4 << i50);
                    i48 = i10;
                }
                int i51 = i48 + 1;
                iCharAt2 = strZzd.charAt(i48);
                if (iCharAt2 >= 55296) {
                    int i52 = iCharAt2 & 8191;
                    int i53 = 13;
                    while (true) {
                        i9 = i51 + 1;
                        cCharAt3 = strZzd.charAt(i51);
                        if (cCharAt3 < 55296) {
                            break;
                        }
                        i52 |= (cCharAt3 & 8191) << i53;
                        i53 += 13;
                        i51 = i9;
                    }
                    iCharAt2 = i52 | (cCharAt3 << i53);
                    i51 = i9;
                }
                int i54 = i51 + 1;
                int iCharAt8 = strZzd.charAt(i51);
                if (iCharAt8 >= 55296) {
                    int i55 = iCharAt8 & 8191;
                    int i56 = 13;
                    while (true) {
                        i8 = i54 + 1;
                        cCharAt2 = strZzd.charAt(i54);
                        if (cCharAt2 < 55296) {
                            break;
                        }
                        i55 |= (cCharAt2 & 8191) << i56;
                        i56 += 13;
                        i54 = i8;
                    }
                    iCharAt8 = i55 | (cCharAt2 << i56);
                    i54 = i8;
                }
                int i57 = i54 + 1;
                int iCharAt9 = strZzd.charAt(i54);
                if (iCharAt9 >= 55296) {
                    int i58 = iCharAt9 & 8191;
                    int i59 = 13;
                    while (true) {
                        i7 = i57 + 1;
                        cCharAt = strZzd.charAt(i57);
                        if (cCharAt < 55296) {
                            break;
                        }
                        i58 |= (cCharAt & 8191) << i59;
                        i59 += 13;
                        i57 = i7;
                    }
                    iCharAt9 = i58 | (cCharAt << i59);
                    i57 = i7;
                }
                int[] iArr2 = new int[iCharAt9 + iCharAt2 + iCharAt8];
                int i60 = (iCharAt4 << 1) + iCharAt5;
                i2 = iCharAt4;
                i3 = iCharAt9;
                i33 = i57;
                i4 = iCharAt7;
                i5 = iCharAt6;
                i6 = i60;
                iArr = iArr2;
            }
            Unsafe unsafe = zzb;
            Object[] objArrZze = zzamaVar2.zze();
            Class<?> cls2 = zzamaVar2.zza().getClass();
            int[] iArr3 = new int[iCharAt * 3];
            Object[] objArr = new Object[iCharAt << 1];
            int i61 = i3 + iCharAt2;
            int i62 = i3;
            int i63 = i61;
            int i64 = 0;
            int i65 = 0;
            while (i33 < length) {
                int i66 = i33 + 1;
                int iCharAt10 = strZzd.charAt(i33);
                if (iCharAt10 >= c) {
                    int i67 = iCharAt10 & 8191;
                    int i68 = i66;
                    int i69 = 13;
                    while (true) {
                        i30 = i68 + 1;
                        cCharAt12 = strZzd.charAt(i68);
                        if (cCharAt12 < c) {
                            break;
                        }
                        i67 |= (cCharAt12 & 8191) << i69;
                        i69 += 13;
                        i68 = i30;
                    }
                    iCharAt10 = i67 | (cCharAt12 << i69);
                    i15 = i30;
                } else {
                    i15 = i66;
                }
                int i70 = i15 + 1;
                int iCharAt11 = strZzd.charAt(i15);
                if (iCharAt11 >= c) {
                    int i71 = iCharAt11 & 8191;
                    int i72 = i70;
                    int i73 = 13;
                    while (true) {
                        i29 = i72 + 1;
                        cCharAt11 = strZzd.charAt(i72);
                        i16 = length;
                        if (cCharAt11 < 55296) {
                            break;
                        }
                        i71 |= (cCharAt11 & 8191) << i73;
                        i73 += 13;
                        i72 = i29;
                        length = i16;
                    }
                    iCharAt11 = i71 | (cCharAt11 << i73);
                    i17 = i29;
                } else {
                    i16 = length;
                    i17 = i70;
                }
                int i74 = iCharAt11 & 255;
                int i75 = i4;
                if ((iCharAt11 & 1024) != 0) {
                    iArr[i65] = i64;
                    i65++;
                }
                int i76 = i5;
                if (i74 >= 51) {
                    int i77 = i17 + 1;
                    int iCharAt12 = strZzd.charAt(i17);
                    char c2 = 55296;
                    if (iCharAt12 >= 55296) {
                        int i78 = iCharAt12 & 8191;
                        int i79 = 13;
                        while (true) {
                            i28 = i77 + 1;
                            cCharAt10 = strZzd.charAt(i77);
                            if (cCharAt10 < c2) {
                                break;
                            }
                            i78 |= (cCharAt10 & 8191) << i79;
                            i79 += 13;
                            i77 = i28;
                            c2 = 55296;
                        }
                        iCharAt12 = i78 | (cCharAt10 << i79);
                        i77 = i28;
                    }
                    int i80 = i74 - 51;
                    int i81 = i77;
                    if (i80 == 9 || i80 == 17) {
                        i24 = 1;
                        i25 = i6 + 1;
                        objArr[((i64 / 3) << 1) + 1] = objArrZze[i6];
                    } else {
                        if (i80 != 12 || (!zzamaVar2.zzb().equals(zzalz.PROTO2) && (iCharAt11 & 2048) == 0)) {
                            i24 = 1;
                        } else {
                            i24 = 1;
                            i25 = i6 + 1;
                            objArr[((i64 / 3) << 1) + 1] = objArrZze[i6];
                        }
                        i26 = iCharAt12 << i24;
                        obj = objArrZze[i26];
                        if (obj instanceof Field) {
                            fieldZza2 = (Field) obj;
                        } else {
                            fieldZza2 = zza(cls2, (String) obj);
                            objArrZze[i26] = fieldZza2;
                        }
                        int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZza2);
                        i27 = i26 + 1;
                        obj2 = objArrZze[i27];
                        int i82 = i6;
                        if (obj2 instanceof Field) {
                            fieldZza3 = (Field) obj2;
                        } else {
                            fieldZza3 = zza(cls2, (String) obj2);
                            objArrZze[i27] = fieldZza3;
                        }
                        iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZza3);
                        strZzd = strZzd;
                        iObjectFieldOffset = iObjectFieldOffset3;
                        i19 = i82;
                        i21 = 0;
                        zzamaVar = zzamaVar2;
                        i18 = iCharAt10;
                        i20 = i81;
                    }
                    i6 = i25;
                    i26 = iCharAt12 << i24;
                    obj = objArrZze[i26];
                    if (obj instanceof Field) {
                        fieldZza2 = (Field) obj;
                    } else {
                        fieldZza2 = zza(cls2, (String) obj);
                        objArrZze[i26] = fieldZza2;
                    }
                    int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldZza2);
                    i27 = i26 + 1;
                    obj2 = objArrZze[i27];
                    int i83 = i6;
                    if (obj2 instanceof Field) {
                        fieldZza3 = (Field) obj2;
                    } else {
                        fieldZza3 = zza(cls2, (String) obj2);
                        objArrZze[i27] = fieldZza3;
                    }
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZza3);
                    strZzd = strZzd;
                    iObjectFieldOffset = iObjectFieldOffset4;
                    i19 = i83;
                    i21 = 0;
                    zzamaVar = zzamaVar2;
                    i18 = iCharAt10;
                    i20 = i81;
                } else {
                    int i84 = i6 + 1;
                    Field fieldZza4 = zza(cls2, (String) objArrZze[i6]);
                    i18 = iCharAt10;
                    if (i74 == 9 || i74 == 17) {
                        zzamaVar = zzamaVar2;
                        objArr[((i64 / 3) << 1) + 1] = fieldZza4.getType();
                    } else {
                        if (i74 == 27 || i74 == 49) {
                            zzamaVar = zzamaVar2;
                            i23 = i6 + 2;
                            objArr[((i64 / 3) << 1) + 1] = objArrZze[i84];
                        } else if (i74 == 12 || i74 == 30 || i74 == 44) {
                            zzamaVar = zzamaVar2;
                            if (zzamaVar2.zzb() == zzalz.PROTO2 || (iCharAt11 & 2048) != 0) {
                                i23 = i6 + 2;
                                objArr[((i64 / 3) << 1) + 1] = objArrZze[i84];
                            }
                            iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZza4);
                            if ((iCharAt11 & 4096) != 0 || i74 > 17) {
                                iObjectFieldOffset2 = 1048575;
                                i20 = i17;
                                i21 = 0;
                            } else {
                                i20 = i17 + 1;
                                int iCharAt13 = strZzd.charAt(i17);
                                if (iCharAt13 >= 55296) {
                                    int i85 = iCharAt13 & 8191;
                                    int i86 = 13;
                                    while (true) {
                                        i22 = i20 + 1;
                                        cCharAt9 = strZzd.charAt(i20);
                                        if (cCharAt9 < 55296) {
                                            break;
                                        }
                                        i85 |= (cCharAt9 & 8191) << i86;
                                        i86 += 13;
                                        i20 = i22;
                                    }
                                    iCharAt13 = i85 | (cCharAt9 << i86);
                                    i20 = i22;
                                }
                                int i87 = (i2 << 1) + (iCharAt13 / 32);
                                Object obj3 = objArrZze[i87];
                                if (obj3 instanceof Field) {
                                    fieldZza = (Field) obj3;
                                } else {
                                    fieldZza = zza(cls2, (String) obj3);
                                    objArrZze[i87] = fieldZza;
                                }
                                i21 = iCharAt13 % 32;
                                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZza);
                            }
                            if (i74 >= 18 && i74 <= 49) {
                                iArr[i63] = iObjectFieldOffset;
                                i63++;
                            }
                        } else if (i74 == 50) {
                            int i88 = i62 + 1;
                            iArr[i62] = i64;
                            int i89 = (i64 / 3) << 1;
                            int i90 = i6 + 2;
                            objArr[i89] = objArrZze[i84];
                            if ((iCharAt11 & 2048) != 0) {
                                i84 = i6 + 3;
                                objArr[i89 + 1] = objArrZze[i90];
                                zzamaVar = zzamaVar2;
                                i62 = i88;
                            } else {
                                i62 = i88;
                                zzamaVar = zzamaVar2;
                                i19 = i90;
                            }
                            iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZza4);
                            if ((iCharAt11 & 4096) != 0) {
                                iObjectFieldOffset2 = 1048575;
                                i20 = i17;
                                i21 = 0;
                            } else {
                                iObjectFieldOffset2 = 1048575;
                                i20 = i17;
                                i21 = 0;
                            }
                            if (i74 >= 18) {
                                iArr[i63] = iObjectFieldOffset;
                                i63++;
                            }
                        } else {
                            zzamaVar = zzamaVar2;
                        }
                        i19 = i23;
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZza4);
                        if ((iCharAt11 & 4096) != 0) {
                            iObjectFieldOffset2 = 1048575;
                            i20 = i17;
                            i21 = 0;
                        } else {
                            iObjectFieldOffset2 = 1048575;
                            i20 = i17;
                            i21 = 0;
                        }
                        if (i74 >= 18) {
                            iArr[i63] = iObjectFieldOffset;
                            i63++;
                        }
                    }
                    i19 = i84;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZza4);
                    if ((iCharAt11 & 4096) != 0) {
                        iObjectFieldOffset2 = 1048575;
                        i20 = i17;
                        i21 = 0;
                    } else {
                        iObjectFieldOffset2 = 1048575;
                        i20 = i17;
                        i21 = 0;
                    }
                    if (i74 >= 18) {
                        iArr[i63] = iObjectFieldOffset;
                        i63++;
                    }
                }
                int i91 = i64 + 1;
                iArr3[i64] = i18;
                int i92 = i64 + 2;
                Class<?> cls3 = cls2;
                int i93 = i20;
                iArr3[i91] = ((iCharAt11 & 512) != 0 ? 536870912 : 0) | ((iCharAt11 & 256) != 0 ? 268435456 : 0) | ((iCharAt11 & 2048) != 0 ? Integer.MIN_VALUE : 0) | (i74 << 20) | iObjectFieldOffset;
                i64 += 3;
                iArr3[i92] = (i21 << 20) | iObjectFieldOffset2;
                strZzd = strZzd;
                i4 = i75;
                i6 = i19;
                zzamaVar2 = zzamaVar;
                length = i16;
                i5 = i76;
                cls2 = cls3;
                i33 = i93;
                c = 55296;
            }
            return new zzalr<>(iArr3, objArr, i5, i4, zzamaVar2.zza(), false, iArr, i3, i61, zzalvVar, zzakxVar, zzamvVar, zzajxVar, zzalgVar);
        }
        throw new NoSuchMethodError();
    }

    private final zzamc zze(int i) {
        int i2 = (i / 3) << 1;
        zzamc zzamcVar = (zzamc) this.zzd[i2];
        if (zzamcVar != null) {
            return zzamcVar;
        }
        zzamc<T> zzamcVarZza = zzaly.zza().zza((Class) this.zzd[i2 + 1]);
        this.zzd[i2] = zzamcVarZza;
        return zzamcVarZza;
    }

    static zzamy zzc(Object obj) {
        zzakg zzakgVar = (zzakg) obj;
        zzamy zzamyVar = zzakgVar.zzb;
        if (zzamyVar != zzamy.zzc()) {
            return zzamyVar;
        }
        zzamy zzamyVarZzd = zzamy.zzd();
        zzakgVar.zzb = zzamyVarZzd;
        return zzamyVarZzd;
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzamv<UT, UB> zzamvVar, Object obj2) {
        zzakk zzakkVarZzd;
        int i2 = this.zzc[i];
        Object objZze = zzana.zze(obj, zzc(i) & 1048575);
        return (objZze == null || (zzakkVarZzd = zzd(i)) == null) ? ub : (UB) zza(i, i2, this.zzr.zze(objZze), zzakkVarZzd, ub, zzamvVar, obj2);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzakk zzakkVar, UB ub, zzamv<UT, UB> zzamvVar, Object obj) {
        zzale<?, ?> zzaleVarZza = this.zzr.zza(zzf(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzakkVar.zza(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzamvVar.zzc(obj);
                }
                zzajf zzajfVarZzc = zzaiw.zzc(zzalf.zza(zzaleVarZza, next.getKey(), next.getValue()));
                try {
                    zzalf.zza(zzajfVarZzc.zzb(), zzaleVarZza, next.getKey(), next.getValue());
                    zzamvVar.zza(ub, i2, zzajfVarZzc.zza());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    private final Object zzf(int i) {
        return this.zzd[(i / 3) << 1];
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object zza(T t, int i) {
        zzamc zzamcVarZze = zze(i);
        long jZzc = zzc(i) & 1048575;
        if (!zzc((Object) t, i)) {
            return zzamcVarZze.zza();
        }
        Object object = zzb.getObject(t, jZzc);
        if (zzg(object)) {
            return object;
        }
        Object objZza = zzamcVarZze.zza();
        if (object != null) {
            zzamcVarZze.zza(objZza, object);
        }
        return objZza;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object zza(T t, int i, int i2) {
        zzamc zzamcVarZze = zze(i2);
        if (!zzc(t, i, i2)) {
            return zzamcVarZze.zza();
        }
        Object object = zzb.getObject(t, zzc(i2) & 1048575);
        if (zzg(object)) {
            return object;
        }
        Object objZza = zzamcVarZze.zza();
        if (object != null) {
            zzamcVarZze.zza(objZza, object);
        }
        return objZza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamc
    public final T zza() {
        return (T) this.zzn.zza(this.zzg);
    }

    private static Field zza(Class<?> cls, String str) {
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

    private zzalr(int[] iArr, Object[] objArr, int i, int i2, zzaln zzalnVar, boolean z, int[] iArr2, int i3, int i4, zzalv zzalvVar, zzakx zzakxVar, zzamv<?, ?> zzamvVar, zzajx<?> zzajxVar, zzalg zzalgVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzalnVar instanceof zzakg;
        this.zzh = zzajxVar != null && zzajxVar.zza(zzalnVar);
        this.zzj = false;
        this.zzk = iArr2;
        this.zzl = i3;
        this.zzm = i4;
        this.zzn = zzalvVar;
        this.zzo = zzakxVar;
        this.zzp = zzamvVar;
        this.zzq = zzajxVar;
        this.zzg = zzalnVar;
        this.zzr = zzalgVar;
    }

    private static void zzf(Object obj) {
        if (zzg(obj)) {
            return;
        }
        throw new IllegalArgumentException("Mutating immutable message: " + String.valueOf(obj));
    }

    /* JADX WARN: Code duplicated, block: B:25:0x006d  */
    /* JADX WARN: Code duplicated, block: B:27:0x0073  */
    /* JADX WARN: Code duplicated, block: B:40:0x0080 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamc
    public final void zzd(T t) {
        if (zzg(t)) {
            if (t instanceof zzakg) {
                zzakg zzakgVar = (zzakg) t;
                zzakgVar.zzb(Integer.MAX_VALUE);
                zzakgVar.zza = 0;
                zzakgVar.zzu();
            }
            int length = this.zzc.length;
            for (int i = 0; i < length; i += 3) {
                int iZzc = zzc(i);
                long j = 1048575 & iZzc;
                int i2 = (iZzc & 267386880) >>> 20;
                if (i2 != 9) {
                    if (i2 != 60 && i2 != 68) {
                        switch (i2) {
                            case 17:
                                if (zzc((Object) t, i)) {
                                    zze(i).zzd(zzb.getObject(t, j));
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
                                this.zzo.zzb(t, j);
                                break;
                            case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH /* 50 */:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(t, j);
                                if (object != null) {
                                    unsafe.putObject(t, j, this.zzr.zzc(object));
                                }
                                break;
                        }
                    } else if (zzc(t, this.zzc[i], i)) {
                        zze(i).zzd(zzb.getObject(t, j));
                    }
                } else if (zzc((Object) t, i)) {
                    zze(i).zzd(zzb.getObject(t, j));
                }
            }
            this.zzp.zzf(t);
            if (this.zzh) {
                this.zzq.zzc(t);
            }
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamc
    public final void zza(T t, T t2) {
        zzf(t);
        t2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzc = zzc(i);
            long j = 1048575 & iZzc;
            int i2 = this.zzc[i];
            switch ((iZzc & 267386880) >>> 20) {
                case 0:
                    if (zzc((Object) t2, i)) {
                        zzana.zza(t, j, zzana.zza(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 1:
                    if (zzc((Object) t2, i)) {
                        zzana.zza((Object) t, j, zzana.zzb(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 2:
                    if (zzc((Object) t2, i)) {
                        zzana.zza((Object) t, j, zzana.zzd(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 3:
                    if (zzc((Object) t2, i)) {
                        zzana.zza((Object) t, j, zzana.zzd(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 4:
                    if (zzc((Object) t2, i)) {
                        zzana.zza((Object) t, j, zzana.zzc(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 5:
                    if (zzc((Object) t2, i)) {
                        zzana.zza((Object) t, j, zzana.zzd(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 6:
                    if (zzc((Object) t2, i)) {
                        zzana.zza((Object) t, j, zzana.zzc(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 7:
                    if (zzc((Object) t2, i)) {
                        zzana.zzc(t, j, zzana.zzh(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 8:
                    if (zzc((Object) t2, i)) {
                        zzana.zza(t, j, zzana.zze(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 9:
                    zza(t, t2, i);
                    break;
                case 10:
                    if (zzc((Object) t2, i)) {
                        zzana.zza(t, j, zzana.zze(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 11:
                    if (zzc((Object) t2, i)) {
                        zzana.zza((Object) t, j, zzana.zzc(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 12:
                    if (zzc((Object) t2, i)) {
                        zzana.zza((Object) t, j, zzana.zzc(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 13:
                    if (zzc((Object) t2, i)) {
                        zzana.zza((Object) t, j, zzana.zzc(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 14:
                    if (zzc((Object) t2, i)) {
                        zzana.zza((Object) t, j, zzana.zzd(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 15:
                    if (zzc((Object) t2, i)) {
                        zzana.zza((Object) t, j, zzana.zzc(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 16:
                    if (zzc((Object) t2, i)) {
                        zzana.zza((Object) t, j, zzana.zzd(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 17:
                    zza(t, t2, i);
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
                    this.zzo.zza(t, t2, j);
                    break;
                case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH /* 50 */:
                    zzame.zza(this.zzr, t, t2, j);
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
                    if (zzc(t2, i2, i)) {
                        zzana.zza(t, j, zzana.zze(t2, j));
                        zzb(t, i2, i);
                    }
                    break;
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                    zzb(t, t2, i);
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                case 62:
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                case 64:
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                case 66:
                case 67:
                    if (zzc(t2, i2, i)) {
                        zzana.zza(t, j, zzana.zze(t2, j));
                        zzb(t, i2, i);
                    }
                    break;
                case 68:
                    zzb(t, t2, i);
                    break;
            }
        }
        zzame.zza(this.zzp, t, t2);
        if (this.zzh) {
            zzame.zza(this.zzq, t, t2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:165:0x0625 A[Catch: all -> 0x0297, TryCatch #2 {all -> 0x0297, blocks: (B:153:0x05f6, B:163:0x0620, B:165:0x0625, B:166:0x062a, B:50:0x00cc, B:51:0x00de, B:52:0x00f0, B:53:0x0102, B:54:0x0113, B:55:0x0124, B:57:0x012e, B:60:0x0135, B:61:0x013b, B:62:0x0148, B:63:0x0159, B:64:0x0166, B:65:0x0177, B:67:0x0182, B:68:0x0193, B:69:0x01a4, B:70:0x01b5, B:71:0x01c6, B:72:0x01d7, B:73:0x01e8, B:74:0x01f9, B:75:0x020b, B:77:0x021b, B:81:0x023c, B:78:0x0225, B:80:0x022d, B:82:0x024d, B:83:0x025f, B:84:0x026d, B:85:0x027b, B:86:0x0289), top: B:193:0x05f6 }] */
    /* JADX WARN: Code duplicated, block: B:171:0x0636 A[LOOP:1: B:169:0x0632->B:171:0x0636, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:173:0x064a  */
    /* JADX WARN: Code duplicated, block: B:183:0x065b A[LOOP:3: B:181:0x0657->B:183:0x065b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:185:0x066f  */
    /* JADX WARN: Code duplicated, block: B:210:0x0630 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:293:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r19v0, types: [com.google.android.gms.internal.firebase-auth-api.zzamd] */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamc
    public final void zza(T t, zzamd zzamdVar, zzajv zzajvVar) throws Throwable {
        zzamv zzamvVar;
        T t2;
        int i;
        zzamv zzamvVar2;
        T t3;
        zzajx<?> zzajxVar;
        zzajv zzajvVar2;
        Object obj;
        Object obj2;
        int i2;
        T t4 = t;
        zzajv zzajvVar3 = zzajvVar;
        zzajvVar.getClass();
        zzf(t);
        zzamv zzamvVar3 = this.zzp;
        zzajx<?> zzajxVar2 = this.zzq;
        Object objZza = null;
        zzajy zzajyVarZzb = null;
        while (true) {
            try {
                int iZzc = zzamdVar.zzc();
                int iZza = zza(iZzc);
                if (iZza < 0) {
                    if (iZzc == Integer.MAX_VALUE) {
                        for (int i3 = this.zzl; i3 < this.zzm; i3++) {
                            objZza = zza(t, this.zzk[i3], objZza, (zzamv<UT, Object>) zzamvVar3, t);
                        }
                        if (objZza != null) {
                            zzamvVar3.zzb(t4, objZza);
                            return;
                        }
                        return;
                    }
                    try {
                        Object objZza2 = !this.zzh ? null : zzajxVar2.zza(zzajvVar3, this.zzg, iZzc);
                        if (objZza2 != null) {
                            if (zzajyVarZzb == null) {
                                zzajyVarZzb = zzajxVar2.zzb(t4);
                            }
                            zzajy zzajyVar = zzajyVarZzb;
                            zzamvVar2 = zzamvVar3;
                            t3 = t4;
                            try {
                                objZza = zzajxVar2.zza(t, zzamdVar, objZza2, zzajvVar, zzajyVar, objZza, zzamvVar2);
                                zzajyVarZzb = zzajyVar;
                            } catch (Throwable th) {
                                th = th;
                                t2 = t3;
                                zzamvVar = zzamvVar2;
                                while (i < this.zzm) {
                                    objZza = zza(t, this.zzk[i], objZza, (zzamv<UT, Object>) zzamvVar, t);
                                }
                                if (objZza != null) {
                                    zzamvVar.zzb(t2, objZza);
                                }
                                throw th;
                            }
                        } else {
                            zzamvVar2 = zzamvVar3;
                            t3 = t4;
                            zzamvVar2.zza((zzamd) zzamdVar);
                            if (objZza == null) {
                                objZza = zzamvVar2.zzc(t3);
                            }
                            zzajyVarZzb = zzajyVarZzb;
                            if (!zzamvVar2.zza(objZza, (zzamd) zzamdVar, 0)) {
                                int i4 = this.zzl;
                                while (i4 < this.zzm) {
                                    zzamv zzamvVar4 = zzamvVar2;
                                    objZza = zza(t, this.zzk[i4], objZza, (zzamv<UT, Object>) zzamvVar4, t);
                                    i4++;
                                    t3 = t3;
                                    zzamvVar2 = zzamvVar4;
                                }
                                T t5 = t3;
                                zzamv zzamvVar5 = zzamvVar2;
                                if (objZza != null) {
                                    zzamvVar5.zzb(t5, objZza);
                                    return;
                                }
                                return;
                            }
                        }
                        t4 = t3;
                        zzamvVar3 = zzamvVar2;
                    } catch (Throwable th2) {
                        th = th2;
                        zzamvVar = zzamvVar3;
                        t2 = t4;
                    }
                } else {
                    zzamvVar = zzamvVar3;
                    t2 = t4;
                    try {
                        int iZzc2 = zzc(iZza);
                        switch ((267386880 & iZzc2) >>> 20) {
                            case 0:
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzana.zza(t2, iZzc2 & 1048575, zzamdVar.zza());
                                zzb((Object) t2, iZza);
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 1:
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzana.zza((Object) t2, iZzc2 & 1048575, zzamdVar.zzb());
                                zzb((Object) t2, iZza);
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 2:
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzana.zza((Object) t2, iZzc2 & 1048575, zzamdVar.zzl());
                                zzb((Object) t2, iZza);
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 3:
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzana.zza((Object) t2, iZzc2 & 1048575, zzamdVar.zzo());
                                zzb((Object) t2, iZza);
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 4:
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzana.zza((Object) t2, iZzc2 & 1048575, zzamdVar.zzg());
                                zzb((Object) t2, iZza);
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 5:
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzana.zza((Object) t2, iZzc2 & 1048575, zzamdVar.zzk());
                                zzb((Object) t2, iZza);
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 6:
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzana.zza((Object) t2, iZzc2 & 1048575, zzamdVar.zzf());
                                zzb((Object) t2, iZza);
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 7:
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzana.zzc(t2, iZzc2 & 1048575, zzamdVar.zzs());
                                zzb((Object) t2, iZza);
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 8:
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zza((Object) t2, iZzc2, (zzamd) zzamdVar);
                                zzb((Object) t2, iZza);
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 9:
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzaln zzalnVar = (zzaln) zza((Object) t2, iZza);
                                zzamdVar.zzb(zzalnVar, zze(iZza), zzajvVar2);
                                zza(t2, iZza, zzalnVar);
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 10:
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzana.zza(t2, iZzc2 & 1048575, zzamdVar.zzp());
                                zzb((Object) t2, iZza);
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 11:
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzana.zza((Object) t2, iZzc2 & 1048575, zzamdVar.zzj());
                                zzb((Object) t2, iZza);
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 12:
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                int iZze = zzamdVar.zze();
                                zzakk zzakkVarZzd = zzd(iZza);
                                if (zzakkVarZzd != null && !zzakkVarZzd.zza(iZze)) {
                                    objZza = zzame.zza(t2, iZzc, iZze, obj2, zzamvVar);
                                    zzamvVar3 = zzamvVar;
                                    zzajxVar2 = zzajxVar;
                                    zzajvVar3 = zzajvVar2;
                                    t4 = t2;
                                }
                                zzana.zza((Object) t2, iZzc2 & 1048575, iZze);
                                zzb((Object) t2, iZza);
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 13:
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzana.zza((Object) t2, iZzc2 & 1048575, zzamdVar.zzh());
                                zzb((Object) t2, iZza);
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 14:
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzana.zza((Object) t2, iZzc2 & 1048575, zzamdVar.zzm());
                                zzb((Object) t2, iZza);
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 15:
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzana.zza((Object) t2, iZzc2 & 1048575, zzamdVar.zzi());
                                zzb((Object) t2, iZza);
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 16:
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzana.zza((Object) t2, iZzc2 & 1048575, zzamdVar.zzn());
                                zzb((Object) t2, iZza);
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 17:
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzaln zzalnVar2 = (zzaln) zza((Object) t2, iZza);
                                zzamdVar.zza(zzalnVar2, zze(iZza), zzajvVar2);
                                zza(t2, iZza, zzalnVar2);
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 18:
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzamdVar.zzc(this.zzo.zza(t2, iZzc2 & 1048575));
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 19:
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzamdVar.zzg(this.zzo.zza(t2, iZzc2 & 1048575));
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 20:
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzamdVar.zzi(this.zzo.zza(t2, iZzc2 & 1048575));
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 21:
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzamdVar.zzq(this.zzo.zza(t2, iZzc2 & 1048575));
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 22:
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzamdVar.zzh(this.zzo.zza(t2, iZzc2 & 1048575));
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 23:
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzamdVar.zzf(this.zzo.zza(t2, iZzc2 & 1048575));
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 24:
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzamdVar.zze(this.zzo.zza(t2, iZzc2 & 1048575));
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 25:
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzamdVar.zza(this.zzo.zza(t2, iZzc2 & 1048575));
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 26:
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                if (zzg(iZzc2)) {
                                    zzamdVar.zzo(this.zzo.zza(t2, iZzc2 & 1048575));
                                } else {
                                    zzamdVar.zzn(this.zzo.zza(t2, iZzc2 & 1048575));
                                }
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case MotionEventCompat.AXIS_RELATIVE_X /* 27 */:
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzamdVar.zzb(this.zzo.zza(t2, iZzc2 & 1048575), zze(iZza), zzajvVar2);
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case MotionEventCompat.AXIS_RELATIVE_Y /* 28 */:
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzamdVar.zzb(this.zzo.zza(t2, iZzc2 & 1048575));
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 29:
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzamdVar.zzp(this.zzo.zza(t2, iZzc2 & 1048575));
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 30:
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                List listZza = this.zzo.zza(t2, iZzc2 & 1048575);
                                zzamdVar.zzd(listZza);
                                objZza = zzame.zza(t, iZzc, listZza, zzd(iZza), objZza, zzamvVar);
                                zzamvVar3 = zzamvVar;
                                zzajxVar2 = zzajxVar;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                break;
                            case 31:
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzamdVar.zzj(this.zzo.zza(t2, iZzc2 & 1048575));
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 32:
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzamdVar.zzk(this.zzo.zza(t2, iZzc2 & 1048575));
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 33:
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzamdVar.zzl(this.zzo.zza(t2, iZzc2 & 1048575));
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case MotionEventCompat.AXIS_GENERIC_3 /* 34 */:
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzamdVar.zzm(this.zzo.zza(t2, iZzc2 & 1048575));
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case MotionEventCompat.AXIS_GENERIC_4 /* 35 */:
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzamdVar.zzc(this.zzo.zza(t2, iZzc2 & 1048575));
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 36:
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzamdVar.zzg(this.zzo.zza(t2, iZzc2 & 1048575));
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case MotionEventCompat.AXIS_GENERIC_6 /* 37 */:
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzamdVar.zzi(this.zzo.zza(t2, iZzc2 & 1048575));
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzamdVar.zzq(this.zzo.zza(t2, iZzc2 & 1048575));
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case MotionEventCompat.AXIS_GENERIC_8 /* 39 */:
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzamdVar.zzh(this.zzo.zza(t2, iZzc2 & 1048575));
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case MotionEventCompat.AXIS_GENERIC_9 /* 40 */:
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzamdVar.zzf(this.zzo.zza(t2, iZzc2 & 1048575));
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case MotionEventCompat.AXIS_GENERIC_10 /* 41 */:
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzamdVar.zze(this.zzo.zza(t2, iZzc2 & 1048575));
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzamdVar.zza(this.zzo.zza(t2, iZzc2 & 1048575));
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzamdVar.zzp(this.zzo.zza(t2, iZzc2 & 1048575));
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                                List listZza2 = this.zzo.zza(t2, iZzc2 & 1048575);
                                zzamdVar.zzd(listZza2);
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                objZza = zzame.zza(t, iZzc, listZza2, zzd(iZza), objZza, zzamvVar);
                                zzamvVar3 = zzamvVar;
                                zzajxVar2 = zzajxVar;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                break;
                            case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                                zzamdVar.zzj(this.zzo.zza(t2, iZzc2 & 1048575));
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                                zzamdVar.zzk(this.zzo.zza(t2, iZzc2 & 1048575));
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                                zzamdVar.zzl(this.zzo.zza(t2, iZzc2 & 1048575));
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 48:
                                zzamdVar.zzm(this.zzo.zza(t2, iZzc2 & 1048575));
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 49:
                                zzamdVar.zza(this.zzo.zza(t2, iZzc2 & 1048575), zze(iZza), zzajvVar3);
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH /* 50 */:
                                Object objZzf = zzf(iZza);
                                long jZzc = zzc(iZza) & 1048575;
                                Object objZze = zzana.zze(t2, jZzc);
                                if (objZze == null) {
                                    objZze = this.zzr.zzb(objZzf);
                                    zzana.zza(t2, jZzc, objZze);
                                } else if (this.zzr.zzf(objZze)) {
                                    Object objZzb = this.zzr.zzb(objZzf);
                                    this.zzr.zza(objZzb, objZze);
                                    zzana.zza(t2, jZzc, objZzb);
                                    objZze = objZzb;
                                }
                                zzamdVar.zza(this.zzr.zze(objZze), this.zzr.zza(objZzf), zzajvVar3);
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 51:
                                zzana.zza(t2, iZzc2 & 1048575, Double.valueOf(zzamdVar.zza()));
                                zzb(t2, iZzc, iZza);
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 52:
                                zzana.zza(t2, iZzc2 & 1048575, Float.valueOf(zzamdVar.zzb()));
                                zzb(t2, iZzc, iZza);
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 53:
                                zzana.zza(t2, iZzc2 & 1048575, Long.valueOf(zzamdVar.zzl()));
                                zzb(t2, iZzc, iZza);
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 54:
                                zzana.zza(t2, iZzc2 & 1048575, Long.valueOf(zzamdVar.zzo()));
                                zzb(t2, iZzc, iZza);
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 55:
                                zzana.zza(t2, iZzc2 & 1048575, Integer.valueOf(zzamdVar.zzg()));
                                zzb(t2, iZzc, iZza);
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 56:
                                zzana.zza(t2, iZzc2 & 1048575, Long.valueOf(zzamdVar.zzk()));
                                zzb(t2, iZzc, iZza);
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 57:
                                zzana.zza(t2, iZzc2 & 1048575, Integer.valueOf(zzamdVar.zzf()));
                                zzb(t2, iZzc, iZza);
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 58:
                                zzana.zza(t2, iZzc2 & 1048575, Boolean.valueOf(zzamdVar.zzs()));
                                zzb(t2, iZzc, iZza);
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 59:
                                zza((Object) t2, iZzc2, (zzamd) zzamdVar);
                                zzb(t2, iZzc, iZza);
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                                zzaln zzalnVar3 = (zzaln) zza(t2, iZzc, iZza);
                                zzamdVar.zzb(zzalnVar3, zze(iZza), zzajvVar3);
                                zza(t2, iZzc, iZza, zzalnVar3);
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                                zzana.zza(t2, iZzc2 & 1048575, zzamdVar.zzp());
                                zzb(t2, iZzc, iZza);
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 62:
                                zzana.zza(t2, iZzc2 & 1048575, Integer.valueOf(zzamdVar.zzj()));
                                zzb(t2, iZzc, iZza);
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                                int iZze2 = zzamdVar.zze();
                                zzakk zzakkVarZzd2 = zzd(iZza);
                                if (zzakkVarZzd2 == null || zzakkVarZzd2.zza(iZze2)) {
                                    zzana.zza(t2, iZzc2 & 1048575, Integer.valueOf(iZze2));
                                    zzb(t2, iZzc, iZza);
                                    obj2 = objZza;
                                    zzajxVar = zzajxVar2;
                                    zzajvVar2 = zzajvVar3;
                                    zzajxVar2 = zzajxVar;
                                    objZza = obj2;
                                    zzajvVar3 = zzajvVar2;
                                } else {
                                    objZza = zzame.zza(t2, iZzc, iZze2, objZza, zzamvVar);
                                }
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 64:
                                zzana.zza(t2, iZzc2 & 1048575, Integer.valueOf(zzamdVar.zzh()));
                                zzb(t2, iZzc, iZza);
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                                zzana.zza(t2, iZzc2 & 1048575, Long.valueOf(zzamdVar.zzm()));
                                zzb(t2, iZzc, iZza);
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 66:
                                zzana.zza(t2, iZzc2 & 1048575, Integer.valueOf(zzamdVar.zzi()));
                                zzb(t2, iZzc, iZza);
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 67:
                                zzana.zza(t2, iZzc2 & 1048575, Long.valueOf(zzamdVar.zzn()));
                                zzb(t2, iZzc, iZza);
                                obj2 = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                zzajxVar2 = zzajxVar;
                                objZza = obj2;
                                zzajvVar3 = zzajvVar2;
                                t4 = t2;
                                zzamvVar3 = zzamvVar;
                                break;
                            case 68:
                                try {
                                    zzaln zzalnVar4 = (zzaln) zza(t2, iZzc, iZza);
                                    zzamdVar.zza(zzalnVar4, zze(iZza), zzajvVar3);
                                    zza(t2, iZzc, iZza, zzalnVar4);
                                    obj2 = objZza;
                                    zzajxVar = zzajxVar2;
                                    zzajvVar2 = zzajvVar3;
                                    zzajxVar2 = zzajxVar;
                                    objZza = obj2;
                                    zzajvVar3 = zzajvVar2;
                                    t4 = t2;
                                    zzamvVar3 = zzamvVar;
                                } catch (zzakp unused) {
                                    obj = objZza;
                                    zzajxVar = zzajxVar2;
                                    zzajvVar2 = zzajvVar3;
                                    objZza = obj;
                                    zzamvVar.zza((zzamd) zzamdVar);
                                    if (objZza == null) {
                                        objZza = zzamvVar.zzc(t2);
                                    }
                                    if (!zzamvVar.zza(objZza, (zzamd) zzamdVar, 0)) {
                                        for (i2 = this.zzl; i2 < this.zzm; i2++) {
                                            objZza = zza(t, this.zzk[i2], objZza, (zzamv<UT, Object>) zzamvVar, t);
                                        }
                                        if (objZza != null) {
                                            zzamvVar.zzb(t2, objZza);
                                            return;
                                        }
                                        return;
                                    }
                                    zzamvVar3 = zzamvVar;
                                    zzajxVar2 = zzajxVar;
                                    zzajvVar3 = zzajvVar2;
                                    t4 = t2;
                                }
                                break;
                            default:
                                obj = objZza;
                                zzajxVar = zzajxVar2;
                                zzajvVar2 = zzajvVar3;
                                if (obj == null) {
                                    try {
                                        objZza = zzamvVar.zzc(t2);
                                    } catch (zzakp unused2) {
                                        objZza = obj;
                                        zzamvVar.zza((zzamd) zzamdVar);
                                        if (objZza == null) {
                                            objZza = zzamvVar.zzc(t2);
                                        }
                                        if (!zzamvVar.zza(objZza, (zzamd) zzamdVar, 0)) {
                                            while (i2 < this.zzm) {
                                                objZza = zza(t, this.zzk[i2], objZza, (zzamv<UT, Object>) zzamvVar, t);
                                            }
                                            if (objZza != null) {
                                                zzamvVar.zzb(t2, objZza);
                                                return;
                                            }
                                            return;
                                        }
                                        zzamvVar3 = zzamvVar;
                                        zzajxVar2 = zzajxVar;
                                        zzajvVar3 = zzajvVar2;
                                        t4 = t2;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        objZza = obj;
                                        for (i = this.zzl; i < this.zzm; i++) {
                                            objZza = zza(t, this.zzk[i], objZza, (zzamv<UT, Object>) zzamvVar, t);
                                        }
                                        if (objZza != null) {
                                            zzamvVar.zzb(t2, objZza);
                                        }
                                        throw th;
                                    }
                                } else {
                                    objZza = obj;
                                }
                                try {
                                    try {
                                        if (!zzamvVar.zza(objZza, (zzamd) zzamdVar, 0)) {
                                            for (int i5 = this.zzl; i5 < this.zzm; i5++) {
                                                objZza = zza(t, this.zzk[i5], objZza, (zzamv<UT, Object>) zzamvVar, t);
                                            }
                                            if (objZza != null) {
                                                zzamvVar.zzb(t2, objZza);
                                                return;
                                            }
                                            return;
                                        }
                                    } catch (zzakp unused3) {
                                        zzamvVar.zza((zzamd) zzamdVar);
                                        if (objZza == null) {
                                            objZza = zzamvVar.zzc(t2);
                                        }
                                        if (!zzamvVar.zza(objZza, (zzamd) zzamdVar, 0)) {
                                            while (i2 < this.zzm) {
                                                objZza = zza(t, this.zzk[i2], objZza, (zzamv<UT, Object>) zzamvVar, t);
                                            }
                                            if (objZza != null) {
                                                zzamvVar.zzb(t2, objZza);
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    zzamvVar3 = zzamvVar;
                                    zzajxVar2 = zzajxVar;
                                    zzajvVar3 = zzajvVar2;
                                    t4 = t2;
                                } catch (Throwable th4) {
                                    th = th4;
                                    while (i < this.zzm) {
                                        objZza = zza(t, this.zzk[i], objZza, (zzamv<UT, Object>) zzamvVar, t);
                                    }
                                    if (objZza != null) {
                                        zzamvVar.zzb(t2, objZza);
                                    }
                                    throw th;
                                }
                                break;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        while (i < this.zzm) {
                            objZza = zza(t, this.zzk[i], objZza, (zzamv<UT, Object>) zzamvVar, t);
                        }
                        if (objZza != null) {
                            zzamvVar.zzb(t2, objZza);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                zzamvVar = zzamvVar3;
                t2 = t4;
            }
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamc
    public final void zza(T t, byte[] bArr, int i, int i2, zzaiv zzaivVar) throws IOException {
        zza(t, bArr, i, i2, 0, zzaivVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zza(T t, T t2, int i) {
        if (zzc((Object) t2, i)) {
            long jZzc = zzc(i) & 1048575;
            Unsafe unsafe = zzb;
            Object object = unsafe.getObject(t2, jZzc);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + String.valueOf(t2));
            }
            zzamc zzamcVarZze = zze(i);
            if (!zzc((Object) t, i)) {
                if (!zzg(object)) {
                    unsafe.putObject(t, jZzc, object);
                } else {
                    Object objZza = zzamcVarZze.zza();
                    zzamcVarZze.zza(objZza, object);
                    unsafe.putObject(t, jZzc, objZza);
                }
                zzb((Object) t, i);
                return;
            }
            Object object2 = unsafe.getObject(t, jZzc);
            if (!zzg(object2)) {
                Object objZza2 = zzamcVarZze.zza();
                zzamcVarZze.zza(objZza2, object2);
                unsafe.putObject(t, jZzc, objZza2);
                object2 = objZza2;
            }
            zzamcVarZze.zza(object2, object);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zzb(T t, T t2, int i) {
        int i2 = this.zzc[i];
        if (zzc(t2, i2, i)) {
            long jZzc = zzc(i) & 1048575;
            Unsafe unsafe = zzb;
            Object object = unsafe.getObject(t2, jZzc);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + String.valueOf(t2));
            }
            zzamc zzamcVarZze = zze(i);
            if (!zzc(t, i2, i)) {
                if (!zzg(object)) {
                    unsafe.putObject(t, jZzc, object);
                } else {
                    Object objZza = zzamcVarZze.zza();
                    zzamcVarZze.zza(objZza, object);
                    unsafe.putObject(t, jZzc, objZza);
                }
                zzb(t, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(t, jZzc);
            if (!zzg(object2)) {
                Object objZza2 = zzamcVarZze.zza();
                zzamcVarZze.zza(objZza2, object2);
                unsafe.putObject(t, jZzc, objZza2);
                object2 = objZza2;
            }
            zzamcVarZze.zza(object2, object);
        }
    }

    private final void zza(Object obj, int i, zzamd zzamdVar) throws IOException {
        if (zzg(i)) {
            zzana.zza(obj, i & 1048575, zzamdVar.zzr());
        } else if (this.zzi) {
            zzana.zza(obj, i & 1048575, zzamdVar.zzq());
        } else {
            zzana.zza(obj, i & 1048575, zzamdVar.zzp());
        }
    }

    private final void zzb(T t, int i) {
        int iZzb = zzb(i);
        long j = 1048575 & iZzb;
        if (j == 1048575) {
            return;
        }
        zzana.zza((Object) t, j, (1 << (iZzb >>> 20)) | zzana.zzc(t, j));
    }

    private final void zzb(T t, int i, int i2) {
        zzana.zza((Object) t, zzb(i2) & 1048575, i);
    }

    private final void zza(T t, int i, Object obj) {
        zzb.putObject(t, zzc(i) & 1048575, obj);
        zzb((Object) t, i);
    }

    private final void zza(T t, int i, int i2, Object obj) {
        zzb.putObject(t, zzc(i2) & 1048575, obj);
        zzb(t, i, i2);
    }

    private final <K, V> void zza(zzanm zzanmVar, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzanmVar.zza(i, this.zzr.zza(zzf(i2)), this.zzr.zzd(obj));
        }
    }

    private static void zza(int i, Object obj, zzanm zzanmVar) throws IOException {
        if (obj instanceof String) {
            zzanmVar.zza(i, (String) obj);
        } else {
            zzanmVar.zza(i, (zzaiw) obj);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:176:0x054a  */
    /* JADX WARN: Code duplicated, block: B:9:0x0036  */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamc
    public final void zza(T t, zzanm zzanmVar) throws IOException {
        Map.Entry<?, ?> entry;
        Iterator it;
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        Unsafe unsafe;
        boolean z2;
        Iterator itZzc;
        Map.Entry<?, ?> entry2;
        zzanm zzanmVar2 = zzanmVar;
        int i5 = 267386880;
        int i6 = 1048575;
        if (zzanmVar.zza() == 2) {
            zza(this.zzp, t, zzanmVar2);
            if (this.zzh) {
                zzajy<T> zzajyVarZza = this.zzq.zza(t);
                if (zzajyVarZza.zza.isEmpty()) {
                    itZzc = null;
                    entry2 = null;
                } else {
                    itZzc = zzajyVarZza.zzc();
                    entry2 = (Map.Entry) itZzc.next();
                }
            } else {
                itZzc = null;
                entry2 = null;
            }
            for (int length = this.zzc.length - 3; length >= 0; length -= 3) {
                int iZzc = zzc(length);
                int i7 = this.zzc[length];
                while (entry2 != null && this.zzq.zza(entry2) > i7) {
                    this.zzq.zza(zzanmVar2, entry2);
                    entry2 = itZzc.hasNext() ? (Map.Entry) itZzc.next() : null;
                }
                switch ((iZzc & 267386880) >>> 20) {
                    case 0:
                        if (zzc((Object) t, length)) {
                            zzanmVar2.zza(i7, zzana.zza(t, iZzc & 1048575));
                        }
                        break;
                    case 1:
                        if (zzc((Object) t, length)) {
                            zzanmVar2.zza(i7, zzana.zzb(t, iZzc & 1048575));
                        }
                        break;
                    case 2:
                        if (zzc((Object) t, length)) {
                            zzanmVar2.zzb(i7, zzana.zzd(t, iZzc & 1048575));
                        }
                        break;
                    case 3:
                        if (zzc((Object) t, length)) {
                            zzanmVar2.zze(i7, zzana.zzd(t, iZzc & 1048575));
                        }
                        break;
                    case 4:
                        if (zzc((Object) t, length)) {
                            zzanmVar2.zzc(i7, zzana.zzc(t, iZzc & 1048575));
                        }
                        break;
                    case 5:
                        if (zzc((Object) t, length)) {
                            zzanmVar2.zza(i7, zzana.zzd(t, iZzc & 1048575));
                        }
                        break;
                    case 6:
                        if (zzc((Object) t, length)) {
                            zzanmVar2.zzb(i7, zzana.zzc(t, iZzc & 1048575));
                        }
                        break;
                    case 7:
                        if (zzc((Object) t, length)) {
                            zzanmVar2.zza(i7, zzana.zzh(t, iZzc & 1048575));
                        }
                        break;
                    case 8:
                        if (zzc((Object) t, length)) {
                            zza(i7, zzana.zze(t, iZzc & 1048575), zzanmVar2);
                        }
                        break;
                    case 9:
                        if (zzc((Object) t, length)) {
                            zzanmVar2.zzb(i7, zzana.zze(t, iZzc & 1048575), zze(length));
                        }
                        break;
                    case 10:
                        if (zzc((Object) t, length)) {
                            zzanmVar2.zza(i7, (zzaiw) zzana.zze(t, iZzc & 1048575));
                        }
                        break;
                    case 11:
                        if (zzc((Object) t, length)) {
                            zzanmVar2.zzf(i7, zzana.zzc(t, iZzc & 1048575));
                        }
                        break;
                    case 12:
                        if (zzc((Object) t, length)) {
                            zzanmVar2.zza(i7, zzana.zzc(t, iZzc & 1048575));
                        }
                        break;
                    case 13:
                        if (zzc((Object) t, length)) {
                            zzanmVar2.zzd(i7, zzana.zzc(t, iZzc & 1048575));
                        }
                        break;
                    case 14:
                        if (zzc((Object) t, length)) {
                            zzanmVar2.zzc(i7, zzana.zzd(t, iZzc & 1048575));
                        }
                        break;
                    case 15:
                        if (zzc((Object) t, length)) {
                            zzanmVar2.zze(i7, zzana.zzc(t, iZzc & 1048575));
                        }
                        break;
                    case 16:
                        if (zzc((Object) t, length)) {
                            zzanmVar2.zzd(i7, zzana.zzd(t, iZzc & 1048575));
                        }
                        break;
                    case 17:
                        if (zzc((Object) t, length)) {
                            zzanmVar2.zza(i7, zzana.zze(t, iZzc & 1048575), zze(length));
                        }
                        break;
                    case 18:
                        zzame.zzb(this.zzc[length], (List<Double>) zzana.zze(t, iZzc & 1048575), zzanmVar2, false);
                        break;
                    case 19:
                        zzame.zzf(this.zzc[length], (List) zzana.zze(t, iZzc & 1048575), zzanmVar2, false);
                        break;
                    case 20:
                        zzame.zzh(this.zzc[length], (List) zzana.zze(t, iZzc & 1048575), zzanmVar2, false);
                        break;
                    case 21:
                        zzame.zzn(this.zzc[length], (List) zzana.zze(t, iZzc & 1048575), zzanmVar2, false);
                        break;
                    case 22:
                        zzame.zzg(this.zzc[length], (List) zzana.zze(t, iZzc & 1048575), zzanmVar2, false);
                        break;
                    case 23:
                        zzame.zze(this.zzc[length], (List) zzana.zze(t, iZzc & 1048575), zzanmVar2, false);
                        break;
                    case 24:
                        zzame.zzd(this.zzc[length], (List) zzana.zze(t, iZzc & 1048575), zzanmVar2, false);
                        break;
                    case 25:
                        zzame.zza(this.zzc[length], (List<Boolean>) zzana.zze(t, iZzc & 1048575), zzanmVar2, false);
                        break;
                    case 26:
                        zzame.zzb(this.zzc[length], (List<String>) zzana.zze(t, iZzc & 1048575), zzanmVar2);
                        break;
                    case MotionEventCompat.AXIS_RELATIVE_X /* 27 */:
                        zzame.zzb(this.zzc[length], (List<?>) zzana.zze(t, iZzc & 1048575), zzanmVar2, (zzamc<?>) zze(length));
                        break;
                    case MotionEventCompat.AXIS_RELATIVE_Y /* 28 */:
                        zzame.zza(this.zzc[length], (List<zzaiw>) zzana.zze(t, iZzc & 1048575), zzanmVar2);
                        break;
                    case 29:
                        zzame.zzm(this.zzc[length], (List) zzana.zze(t, iZzc & 1048575), zzanmVar2, false);
                        break;
                    case 30:
                        zzame.zzc(this.zzc[length], (List) zzana.zze(t, iZzc & 1048575), zzanmVar2, false);
                        break;
                    case 31:
                        zzame.zzi(this.zzc[length], (List) zzana.zze(t, iZzc & 1048575), zzanmVar2, false);
                        break;
                    case 32:
                        zzame.zzj(this.zzc[length], (List) zzana.zze(t, iZzc & 1048575), zzanmVar2, false);
                        break;
                    case 33:
                        zzame.zzk(this.zzc[length], (List) zzana.zze(t, iZzc & 1048575), zzanmVar2, false);
                        break;
                    case MotionEventCompat.AXIS_GENERIC_3 /* 34 */:
                        zzame.zzl(this.zzc[length], (List) zzana.zze(t, iZzc & 1048575), zzanmVar2, false);
                        break;
                    case MotionEventCompat.AXIS_GENERIC_4 /* 35 */:
                        zzame.zzb(this.zzc[length], (List<Double>) zzana.zze(t, iZzc & 1048575), zzanmVar2, true);
                        break;
                    case 36:
                        zzame.zzf(this.zzc[length], (List) zzana.zze(t, iZzc & 1048575), zzanmVar2, true);
                        break;
                    case MotionEventCompat.AXIS_GENERIC_6 /* 37 */:
                        zzame.zzh(this.zzc[length], (List) zzana.zze(t, iZzc & 1048575), zzanmVar2, true);
                        break;
                    case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                        zzame.zzn(this.zzc[length], (List) zzana.zze(t, iZzc & 1048575), zzanmVar2, true);
                        break;
                    case MotionEventCompat.AXIS_GENERIC_8 /* 39 */:
                        zzame.zzg(this.zzc[length], (List) zzana.zze(t, iZzc & 1048575), zzanmVar2, true);
                        break;
                    case MotionEventCompat.AXIS_GENERIC_9 /* 40 */:
                        zzame.zze(this.zzc[length], (List) zzana.zze(t, iZzc & 1048575), zzanmVar2, true);
                        break;
                    case MotionEventCompat.AXIS_GENERIC_10 /* 41 */:
                        zzame.zzd(this.zzc[length], (List) zzana.zze(t, iZzc & 1048575), zzanmVar2, true);
                        break;
                    case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                        zzame.zza(this.zzc[length], (List<Boolean>) zzana.zze(t, iZzc & 1048575), zzanmVar2, true);
                        break;
                    case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                        zzame.zzm(this.zzc[length], (List) zzana.zze(t, iZzc & 1048575), zzanmVar2, true);
                        break;
                    case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                        zzame.zzc(this.zzc[length], (List) zzana.zze(t, iZzc & 1048575), zzanmVar2, true);
                        break;
                    case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                        zzame.zzi(this.zzc[length], (List) zzana.zze(t, iZzc & 1048575), zzanmVar2, true);
                        break;
                    case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                        zzame.zzj(this.zzc[length], (List) zzana.zze(t, iZzc & 1048575), zzanmVar2, true);
                        break;
                    case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                        zzame.zzk(this.zzc[length], (List) zzana.zze(t, iZzc & 1048575), zzanmVar2, true);
                        break;
                    case 48:
                        zzame.zzl(this.zzc[length], (List) zzana.zze(t, iZzc & 1048575), zzanmVar2, true);
                        break;
                    case 49:
                        zzame.zza(this.zzc[length], (List<?>) zzana.zze(t, iZzc & 1048575), zzanmVar2, (zzamc<?>) zze(length));
                        break;
                    case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH /* 50 */:
                        zza(zzanmVar2, i7, zzana.zze(t, iZzc & 1048575), length);
                        break;
                    case 51:
                        if (zzc(t, i7, length)) {
                            zzanmVar2.zza(i7, zza(t, iZzc & 1048575));
                        }
                        break;
                    case 52:
                        if (zzc(t, i7, length)) {
                            zzanmVar2.zza(i7, zzb(t, iZzc & 1048575));
                        }
                        break;
                    case 53:
                        if (zzc(t, i7, length)) {
                            zzanmVar2.zzb(i7, zzd(t, iZzc & 1048575));
                        }
                        break;
                    case 54:
                        if (zzc(t, i7, length)) {
                            zzanmVar2.zze(i7, zzd(t, iZzc & 1048575));
                        }
                        break;
                    case 55:
                        if (zzc(t, i7, length)) {
                            zzanmVar2.zzc(i7, zzc(t, iZzc & 1048575));
                        }
                        break;
                    case 56:
                        if (zzc(t, i7, length)) {
                            zzanmVar2.zza(i7, zzd(t, iZzc & 1048575));
                        }
                        break;
                    case 57:
                        if (zzc(t, i7, length)) {
                            zzanmVar2.zzb(i7, zzc(t, iZzc & 1048575));
                        }
                        break;
                    case 58:
                        if (zzc(t, i7, length)) {
                            zzanmVar2.zza(i7, zze(t, iZzc & 1048575));
                        }
                        break;
                    case 59:
                        if (zzc(t, i7, length)) {
                            zza(i7, zzana.zze(t, iZzc & 1048575), zzanmVar2);
                        }
                        break;
                    case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                        if (zzc(t, i7, length)) {
                            zzanmVar2.zzb(i7, zzana.zze(t, iZzc & 1048575), zze(length));
                        }
                        break;
                    case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                        if (zzc(t, i7, length)) {
                            zzanmVar2.zza(i7, (zzaiw) zzana.zze(t, iZzc & 1048575));
                        }
                        break;
                    case 62:
                        if (zzc(t, i7, length)) {
                            zzanmVar2.zzf(i7, zzc(t, iZzc & 1048575));
                        }
                        break;
                    case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                        if (zzc(t, i7, length)) {
                            zzanmVar2.zza(i7, zzc(t, iZzc & 1048575));
                        }
                        break;
                    case 64:
                        if (zzc(t, i7, length)) {
                            zzanmVar2.zzd(i7, zzc(t, iZzc & 1048575));
                        }
                        break;
                    case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                        if (zzc(t, i7, length)) {
                            zzanmVar2.zzc(i7, zzd(t, iZzc & 1048575));
                        }
                        break;
                    case 66:
                        if (zzc(t, i7, length)) {
                            zzanmVar2.zze(i7, zzc(t, iZzc & 1048575));
                        }
                        break;
                    case 67:
                        if (zzc(t, i7, length)) {
                            zzanmVar2.zzd(i7, zzd(t, iZzc & 1048575));
                        }
                        break;
                    case 68:
                        if (zzc(t, i7, length)) {
                            zzanmVar2.zza(i7, zzana.zze(t, iZzc & 1048575), zze(length));
                        }
                        break;
                }
            }
            while (entry2 != null) {
                this.zzq.zza(zzanmVar2, entry2);
                entry2 = itZzc.hasNext() ? (Map.Entry) itZzc.next() : null;
            }
            return;
        }
        if (this.zzh) {
            zzajy<T> zzajyVarZza2 = this.zzq.zza(t);
            if (zzajyVarZza2.zza.isEmpty()) {
                entry = null;
                it = null;
            } else {
                Iterator itZzd = zzajyVarZza2.zzd();
                entry = (Map.Entry) itZzd.next();
                it = itZzd;
            }
        } else {
            entry = null;
            it = null;
        }
        int length2 = this.zzc.length;
        Unsafe unsafe2 = zzb;
        int i8 = 0;
        int i9 = 0;
        int i10 = 1048575;
        while (i9 < length2) {
            int iZzc2 = zzc(i9);
            int[] iArr = this.zzc;
            int i11 = iArr[i9];
            int i12 = (iZzc2 & i5) >>> 20;
            if (i12 <= 17) {
                int i13 = iArr[i9 + 2];
                int i14 = i13 & i6;
                if (i14 != i10) {
                    i8 = i14 == i6 ? 0 : unsafe2.getInt(t, i14);
                    i10 = i14;
                } else {
                    it = it;
                }
                i2 = i8;
                i3 = 1 << (i13 >>> 20);
                i = i10;
            } else {
                it = it;
                i = i10;
                i2 = i8;
                i3 = 0;
            }
            while (entry != null && this.zzq.zza(entry) <= i11) {
                this.zzq.zza(zzanmVar2, entry);
                entry = it.hasNext() ? (Map.Entry) it.next() : null;
            }
            long j = iZzc2 & 1048575;
            switch (i12) {
                case 0:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zzanmVar2.zza(i11, zzana.zza(t, j));
                    }
                    break;
                case 1:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zzanmVar2.zza(i11, zzana.zzb(t, j));
                    }
                    break;
                case 2:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zzanmVar2.zzb(i11, unsafe.getLong(t, j));
                    }
                    break;
                case 3:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zzanmVar2.zze(i11, unsafe.getLong(t, j));
                    }
                    break;
                case 4:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zzanmVar2.zzc(i11, unsafe.getInt(t, j));
                    }
                    break;
                case 5:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zzanmVar2.zza(i11, unsafe.getLong(t, j));
                    }
                    break;
                case 6:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zzanmVar2.zzb(i11, unsafe.getInt(t, j));
                    }
                    break;
                case 7:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zzanmVar2.zza(i11, zzana.zzh(t, j));
                    }
                    break;
                case 8:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zza(i11, unsafe.getObject(t, j), zzanmVar2);
                    }
                    break;
                case 9:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zzanmVar2.zzb(i11, unsafe.getObject(t, j), zze(i4));
                    }
                    break;
                case 10:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zzanmVar2.zza(i11, (zzaiw) unsafe.getObject(t, j));
                    }
                    break;
                case 11:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zzanmVar2.zzf(i11, unsafe.getInt(t, j));
                    }
                    break;
                case 12:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zzanmVar2.zza(i11, unsafe.getInt(t, j));
                    }
                    break;
                case 13:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zzanmVar2.zzd(i11, unsafe.getInt(t, j));
                    }
                    break;
                case 14:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zzanmVar2.zzc(i11, unsafe.getLong(t, j));
                    }
                    break;
                case 15:
                    i = i;
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    if (zza(t, i4, i, i2, i3)) {
                        zzanmVar2.zze(i11, unsafe.getInt(t, j));
                    }
                    break;
                case 16:
                    entry = entry;
                    length2 = length2;
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    i = i;
                    if (zza(t, i4, i, i2, i3)) {
                        zzanmVar2.zzd(i11, unsafe.getLong(t, j));
                    }
                    break;
                case 17:
                    z = false;
                    entry = entry;
                    i4 = i9;
                    length2 = length2;
                    unsafe = unsafe2;
                    if (zza(t, i9, i, i2, i3)) {
                        zzanmVar2 = zzanmVar;
                        zzanmVar2.zza(i11, unsafe.getObject(t, j), zze(i4));
                    } else {
                        zzanmVar2 = zzanmVar;
                    }
                    i = i;
                    break;
                case 18:
                    z2 = false;
                    zzame.zzb(this.zzc[i9], (List<Double>) unsafe2.getObject(t, j), zzanmVar2, false);
                    z = z2;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 19:
                    z2 = false;
                    zzame.zzf(this.zzc[i9], (List) unsafe2.getObject(t, j), zzanmVar2, false);
                    z = z2;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 20:
                    z2 = false;
                    zzame.zzh(this.zzc[i9], (List) unsafe2.getObject(t, j), zzanmVar2, false);
                    z = z2;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 21:
                    z2 = false;
                    zzame.zzn(this.zzc[i9], (List) unsafe2.getObject(t, j), zzanmVar2, false);
                    z = z2;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 22:
                    z2 = false;
                    zzame.zzg(this.zzc[i9], (List) unsafe2.getObject(t, j), zzanmVar2, false);
                    z = z2;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 23:
                    z2 = false;
                    zzame.zze(this.zzc[i9], (List) unsafe2.getObject(t, j), zzanmVar2, false);
                    z = z2;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 24:
                    z2 = false;
                    zzame.zzd(this.zzc[i9], (List) unsafe2.getObject(t, j), zzanmVar2, false);
                    z = z2;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 25:
                    z2 = false;
                    zzame.zza(this.zzc[i9], (List<Boolean>) unsafe2.getObject(t, j), zzanmVar2, false);
                    z = z2;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 26:
                    zzame.zzb(this.zzc[i9], (List<String>) unsafe2.getObject(t, j), zzanmVar2);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case MotionEventCompat.AXIS_RELATIVE_X /* 27 */:
                    zzame.zzb(this.zzc[i9], (List<?>) unsafe2.getObject(t, j), zzanmVar2, (zzamc<?>) zze(i9));
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case MotionEventCompat.AXIS_RELATIVE_Y /* 28 */:
                    zzame.zza(this.zzc[i9], (List<zzaiw>) unsafe2.getObject(t, j), zzanmVar2);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 29:
                    z2 = false;
                    zzame.zzm(this.zzc[i9], (List) unsafe2.getObject(t, j), zzanmVar2, false);
                    z = z2;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 30:
                    z2 = false;
                    zzame.zzc(this.zzc[i9], (List) unsafe2.getObject(t, j), zzanmVar2, false);
                    z = z2;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 31:
                    z2 = false;
                    zzame.zzi(this.zzc[i9], (List) unsafe2.getObject(t, j), zzanmVar2, false);
                    z = z2;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 32:
                    z2 = false;
                    zzame.zzj(this.zzc[i9], (List) unsafe2.getObject(t, j), zzanmVar2, false);
                    z = z2;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 33:
                    z2 = false;
                    zzame.zzk(this.zzc[i9], (List) unsafe2.getObject(t, j), zzanmVar2, false);
                    z = z2;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case MotionEventCompat.AXIS_GENERIC_3 /* 34 */:
                    z2 = false;
                    zzame.zzl(this.zzc[i9], (List) unsafe2.getObject(t, j), zzanmVar2, false);
                    z = z2;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case MotionEventCompat.AXIS_GENERIC_4 /* 35 */:
                    zzame.zzb(this.zzc[i9], (List<Double>) unsafe2.getObject(t, j), zzanmVar2, true);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 36:
                    zzame.zzf(this.zzc[i9], (List) unsafe2.getObject(t, j), zzanmVar2, true);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case MotionEventCompat.AXIS_GENERIC_6 /* 37 */:
                    zzame.zzh(this.zzc[i9], (List) unsafe2.getObject(t, j), zzanmVar2, true);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                    zzame.zzn(this.zzc[i9], (List) unsafe2.getObject(t, j), zzanmVar2, true);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case MotionEventCompat.AXIS_GENERIC_8 /* 39 */:
                    zzame.zzg(this.zzc[i9], (List) unsafe2.getObject(t, j), zzanmVar2, true);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case MotionEventCompat.AXIS_GENERIC_9 /* 40 */:
                    zzame.zze(this.zzc[i9], (List) unsafe2.getObject(t, j), zzanmVar2, true);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case MotionEventCompat.AXIS_GENERIC_10 /* 41 */:
                    zzame.zzd(this.zzc[i9], (List) unsafe2.getObject(t, j), zzanmVar2, true);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                    zzame.zza(this.zzc[i9], (List<Boolean>) unsafe2.getObject(t, j), zzanmVar2, true);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                    zzame.zzm(this.zzc[i9], (List) unsafe2.getObject(t, j), zzanmVar2, true);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                    zzame.zzc(this.zzc[i9], (List) unsafe2.getObject(t, j), zzanmVar2, true);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                    zzame.zzi(this.zzc[i9], (List) unsafe2.getObject(t, j), zzanmVar2, true);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                    zzame.zzj(this.zzc[i9], (List) unsafe2.getObject(t, j), zzanmVar2, true);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                    zzame.zzk(this.zzc[i9], (List) unsafe2.getObject(t, j), zzanmVar2, true);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 48:
                    zzame.zzl(this.zzc[i9], (List) unsafe2.getObject(t, j), zzanmVar2, true);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 49:
                    zzame.zza(this.zzc[i9], (List<?>) unsafe2.getObject(t, j), zzanmVar2, (zzamc<?>) zze(i9));
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH /* 50 */:
                    zza(zzanmVar2, i11, unsafe2.getObject(t, j), i9);
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 51:
                    if (zzc(t, i11, i9)) {
                        zzanmVar2.zza(i11, zza(t, j));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 52:
                    if (zzc(t, i11, i9)) {
                        zzanmVar2.zza(i11, zzb(t, j));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 53:
                    if (zzc(t, i11, i9)) {
                        zzanmVar2.zzb(i11, zzd(t, j));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 54:
                    if (zzc(t, i11, i9)) {
                        zzanmVar2.zze(i11, zzd(t, j));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 55:
                    if (zzc(t, i11, i9)) {
                        zzanmVar2.zzc(i11, zzc(t, j));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 56:
                    if (zzc(t, i11, i9)) {
                        zzanmVar2.zza(i11, zzd(t, j));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 57:
                    if (zzc(t, i11, i9)) {
                        zzanmVar2.zzb(i11, zzc(t, j));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 58:
                    if (zzc(t, i11, i9)) {
                        zzanmVar2.zza(i11, zze(t, j));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 59:
                    if (zzc(t, i11, i9)) {
                        zza(i11, unsafe2.getObject(t, j), zzanmVar2);
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                    if (zzc(t, i11, i9)) {
                        zzanmVar2.zzb(i11, unsafe2.getObject(t, j), zze(i9));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzc(t, i11, i9)) {
                        zzanmVar2.zza(i11, (zzaiw) unsafe2.getObject(t, j));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 62:
                    if (zzc(t, i11, i9)) {
                        zzanmVar2.zzf(i11, zzc(t, j));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (zzc(t, i11, i9)) {
                        zzanmVar2.zza(i11, zzc(t, j));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 64:
                    if (zzc(t, i11, i9)) {
                        zzanmVar2.zzd(i11, zzc(t, j));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (zzc(t, i11, i9)) {
                        zzanmVar2.zzc(i11, zzd(t, j));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 66:
                    if (zzc(t, i11, i9)) {
                        zzanmVar2.zze(i11, zzc(t, j));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 67:
                    if (zzc(t, i11, i9)) {
                        zzanmVar2.zzd(i11, zzd(t, j));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                case 68:
                    if (zzc(t, i11, i9)) {
                        zzanmVar2.zza(i11, unsafe2.getObject(t, j), zze(i9));
                    }
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
                default:
                    z = false;
                    i4 = i9;
                    unsafe = unsafe2;
                    break;
            }
            i9 = i4 + 3;
            i8 = i2;
            unsafe2 = unsafe;
            i6 = 1048575;
            it = it;
            entry = entry;
            length2 = length2;
            i10 = i;
            i5 = 267386880;
        }
        Iterator it2 = it;
        while (entry != null) {
            this.zzq.zza(zzanmVar2, entry);
            entry = it2.hasNext() ? (Map.Entry) it2.next() : null;
        }
        zza(this.zzp, t, zzanmVar2);
    }

    private static <UT, UB> void zza(zzamv<UT, UB> zzamvVar, T t, zzanm zzanmVar) throws IOException {
        zzamvVar.zzb(zzamvVar.zzd(t), zzanmVar);
    }

    private final boolean zzc(T t, T t2, int i) {
        return zzc((Object) t, i) == zzc((Object) t2, i);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamc
    public final boolean zzb(T t, T t2) {
        boolean zZza;
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int iZzc = zzc(i);
            long j = iZzc & 1048575;
            switch ((iZzc & 267386880) >>> 20) {
                case 0:
                    if (!zzc(t, t2, i) || Double.doubleToLongBits(zzana.zza(t, j)) != Double.doubleToLongBits(zzana.zza(t2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzc(t, t2, i) || Float.floatToIntBits(zzana.zzb(t, j)) != Float.floatToIntBits(zzana.zzb(t2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzc(t, t2, i) || zzana.zzd(t, j) != zzana.zzd(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzc(t, t2, i) || zzana.zzd(t, j) != zzana.zzd(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzc(t, t2, i) || zzana.zzc(t, j) != zzana.zzc(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzc(t, t2, i) || zzana.zzd(t, j) != zzana.zzd(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzc(t, t2, i) || zzana.zzc(t, j) != zzana.zzc(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzc(t, t2, i) || zzana.zzh(t, j) != zzana.zzh(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzc(t, t2, i) || !zzame.zza(zzana.zze(t, j), zzana.zze(t2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzc(t, t2, i) || !zzame.zza(zzana.zze(t, j), zzana.zze(t2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzc(t, t2, i) || !zzame.zza(zzana.zze(t, j), zzana.zze(t2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzc(t, t2, i) || zzana.zzc(t, j) != zzana.zzc(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzc(t, t2, i) || zzana.zzc(t, j) != zzana.zzc(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzc(t, t2, i) || zzana.zzc(t, j) != zzana.zzc(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzc(t, t2, i) || zzana.zzd(t, j) != zzana.zzd(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzc(t, t2, i) || zzana.zzc(t, j) != zzana.zzc(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzc(t, t2, i) || zzana.zzd(t, j) != zzana.zzd(t2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzc(t, t2, i) || !zzame.zza(zzana.zze(t, j), zzana.zze(t2, j))) {
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
                    zZza = zzame.zza(zzana.zze(t, j), zzana.zze(t2, j));
                    break;
                case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH /* 50 */:
                    zZza = zzame.zza(zzana.zze(t, j), zzana.zze(t2, j));
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
                    long jZzb = zzb(i) & 1048575;
                    if (zzana.zzc(t, jZzb) != zzana.zzc(t2, jZzb) || !zzame.zza(zzana.zze(t, j), zzana.zze(t2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    continue;
                    break;
            }
            if (!zZza) {
                return false;
            }
        }
        if (!this.zzp.zzd(t).equals(this.zzp.zzd(t2))) {
            return false;
        }
        if (this.zzh) {
            return this.zzq.zza(t).equals(this.zzq.zza(t2));
        }
        return true;
    }

    private final boolean zzc(T t, int i) {
        int iZzb = zzb(i);
        long j = iZzb & 1048575;
        if (j != 1048575) {
            return (zzana.zzc(t, j) & (1 << (iZzb >>> 20))) != 0;
        }
        int iZzc = zzc(i);
        long j2 = iZzc & 1048575;
        switch ((iZzc & 267386880) >>> 20) {
            case 0:
                return Double.doubleToRawLongBits(zzana.zza(t, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzana.zzb(t, j2)) != 0;
            case 2:
                return zzana.zzd(t, j2) != 0;
            case 3:
                return zzana.zzd(t, j2) != 0;
            case 4:
                return zzana.zzc(t, j2) != 0;
            case 5:
                return zzana.zzd(t, j2) != 0;
            case 6:
                return zzana.zzc(t, j2) != 0;
            case 7:
                return zzana.zzh(t, j2);
            case 8:
                Object objZze = zzana.zze(t, j2);
                if (objZze instanceof String) {
                    return !((String) objZze).isEmpty();
                }
                if (objZze instanceof zzaiw) {
                    return !zzaiw.zza.equals(objZze);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzana.zze(t, j2) != null;
            case 10:
                return !zzaiw.zza.equals(zzana.zze(t, j2));
            case 11:
                return zzana.zzc(t, j2) != 0;
            case 12:
                return zzana.zzc(t, j2) != 0;
            case 13:
                return zzana.zzc(t, j2) != 0;
            case 14:
                return zzana.zzd(t, j2) != 0;
            case 15:
                return zzana.zzc(t, j2) != 0;
            case 16:
                return zzana.zzd(t, j2) != 0;
            case 17:
                return zzana.zze(t, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zza(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzc((Object) t, i);
        }
        return (i3 & i4) != 0;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:51:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:54:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:57:0x00f7 A[LOOP:2: B:52:0x00e6->B:57:0x00f7, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:74:0x00f6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x0114 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23, types: [com.google.android.gms.internal.firebase-auth-api.zzamc] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.google.android.gms.internal.firebase-auth-api.zzamc] */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamc
    public final boolean zze(T t) {
        int i;
        int i2;
        List list;
        ?? Zze;
        int i3;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        while (i6 < this.zzl) {
            int i7 = this.zzk[i6];
            int i8 = this.zzc[i7];
            int iZzc = zzc(i7);
            int i9 = this.zzc[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i4) {
                if (i10 != 1048575) {
                    i5 = zzb.getInt(t, i10);
                }
                i2 = i5;
                i = i10;
            } else {
                i = i4;
                i2 = i5;
            }
            if ((268435456 & iZzc) != 0 && !zza(t, i7, i, i2, i11)) {
                return false;
            }
            int i12 = (267386880 & iZzc) >>> 20;
            if (i12 == 9 || i12 == 17) {
                if (zza(t, i7, i, i2, i11) && !zza((Object) t, iZzc, zze(i7))) {
                    return false;
                }
            } else if (i12 == 27) {
                list = (List) zzana.zze(t, iZzc & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    Zze = zze(i7);
                    for (i3 = 0; i3 < list.size(); i3++) {
                        if (!Zze.zze(list.get(i3))) {
                            return false;
                        }
                    }
                }
            } else if (i12 == 60 || i12 == 68) {
                if (zzc(t, i8, i7) && !zza((Object) t, iZzc, zze(i7))) {
                    return false;
                }
            } else if (i12 == 49) {
                list = (List) zzana.zze(t, iZzc & 1048575);
                if (list.isEmpty()) {
                    Zze = zze(i7);
                    while (i3 < list.size()) {
                        if (!Zze.zze(list.get(i3))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (i12 != 50) {
                continue;
            } else {
                Map<?, ?> mapZzd = this.zzr.zzd(zzana.zze(t, iZzc & 1048575));
                if (mapZzd.isEmpty()) {
                    continue;
                } else if (this.zzr.zza(zzf(i7)).zzc.zzb() == zzank.MESSAGE) {
                    ?? Zza = 0;
                    for (Object obj : mapZzd.values()) {
                        if (Zza == 0) {
                            Zza = Zza;
                            Zza = zzaly.zza().zza((Class) obj.getClass());
                        }
                        Zza = Zza;
                        if (!Zza.zze(obj)) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            }
            i6++;
            i4 = i;
            i5 = i2;
        }
        return !this.zzh || this.zzq.zza(t).zzg();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i, zzamc zzamcVar) {
        return zzamcVar.zze(zzana.zze(obj, i & 1048575));
    }

    private static boolean zzg(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzakg) {
            return ((zzakg) obj).zzw();
        }
        return true;
    }

    private final boolean zzc(T t, int i, int i2) {
        return zzana.zzc(t, (long) (zzb(i2) & 1048575)) == i;
    }

    private static <T> boolean zze(T t, long j) {
        return ((Boolean) zzana.zze(t, j)).booleanValue();
    }
}
