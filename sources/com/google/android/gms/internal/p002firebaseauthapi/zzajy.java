package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaka;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzajy<T extends zzaka<T>> {
    private static final zzajy<?> zzb = new zzajy<>(true);
    final zzamh<T, Object> zza;
    private boolean zzc;
    private boolean zzd;

    static int zza(zzanh zzanhVar, int i, Object obj) {
        int iZzg = zzajo.zzg(i);
        if (zzanhVar == zzanh.zzj) {
            zzaki.zza((zzaln) obj);
            iZzg <<= 1;
        }
        return iZzg + zza(zzanhVar, obj);
    }

    private static int zza(zzanh zzanhVar, Object obj) {
        switch (zzakb.zzb[zzanhVar.ordinal()]) {
            case 1:
                return zzajo.zza(((Double) obj).doubleValue());
            case 2:
                return zzajo.zza(((Float) obj).floatValue());
            case 3:
                return zzajo.zzb(((Long) obj).longValue());
            case 4:
                return zzajo.zze(((Long) obj).longValue());
            case 5:
                return zzajo.zzc(((Integer) obj).intValue());
            case 6:
                return zzajo.zza(((Long) obj).longValue());
            case 7:
                return zzajo.zzb(((Integer) obj).intValue());
            case 8:
                return zzajo.zza(((Boolean) obj).booleanValue());
            case 9:
                return zzajo.zza((zzaln) obj);
            case 10:
                if (obj instanceof zzakr) {
                    return zzajo.zza((zzakr) obj);
                }
                return zzajo.zzb((zzaln) obj);
            case 11:
                if (obj instanceof zzaiw) {
                    return zzajo.zza((zzaiw) obj);
                }
                return zzajo.zza((String) obj);
            case 12:
                if (obj instanceof zzaiw) {
                    return zzajo.zza((zzaiw) obj);
                }
                return zzajo.zza((byte[]) obj);
            case 13:
                return zzajo.zzh(((Integer) obj).intValue());
            case 14:
                return zzajo.zze(((Integer) obj).intValue());
            case 15:
                return zzajo.zzc(((Long) obj).longValue());
            case 16:
                return zzajo.zzf(((Integer) obj).intValue());
            case 17:
                return zzajo.zzd(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzakl) {
                    return zzajo.zza(((zzakl) obj).zza());
                }
                return zzajo.zza(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zza(zzaka<?> zzakaVar, Object obj) {
        zzanh zzanhVarZzb = zzakaVar.zzb();
        int iZza = zzakaVar.zza();
        if (zzakaVar.zze()) {
            List list = (List) obj;
            int size = list.size();
            int i = 0;
            if (!zzakaVar.zzd()) {
                int iZza2 = 0;
                while (i < size) {
                    iZza2 += zza(zzanhVarZzb, iZza, list.get(i));
                    i++;
                }
                return iZza2;
            }
            if (list.isEmpty()) {
                return 0;
            }
            int iZza3 = 0;
            while (i < size) {
                iZza3 += zza(zzanhVarZzb, list.get(i));
                i++;
            }
            return zzajo.zzg(iZza) + iZza3 + zzajo.zzh(iZza3);
        }
        return zza(zzanhVarZzb, iZza, obj);
    }

    public final int zza() {
        int iZzb = this.zza.zzb();
        int iZza = 0;
        for (int i = 0; i < iZzb; i++) {
            iZza += zza((Map.Entry) this.zza.zza(i));
        }
        Iterator it = this.zza.zzc().iterator();
        while (it.hasNext()) {
            iZza += zza((Map.Entry) it.next());
        }
        return iZza;
    }

    private static int zza(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzc() == zzank.MESSAGE && !key.zze() && !key.zzd()) {
            if (value instanceof zzakr) {
                return zzajo.zza(entry.getKey().zza(), (zzakr) value);
            }
            return zzajo.zza(entry.getKey().zza(), (zzaln) value);
        }
        return zza((zzaka<?>) key, value);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public static <T extends zzaka<T>> zzajy<T> zzb() {
        return (zzajy<T>) zzb;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzajy zzajyVar = new zzajy();
        int iZzb = this.zza.zzb();
        for (int i = 0; i < iZzb; i++) {
            Map.Entry<K, Object> entryZza = this.zza.zza(i);
            zzajyVar.zzb((zzaka) entryZza.getKey(), entryZza.getValue());
        }
        Iterator it = this.zza.zzc().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            zzajyVar.zzb((zzaka) entry.getKey(), entry.getValue());
        }
        zzajyVar.zzd = this.zzd;
        return zzajyVar;
    }

    private static Object zza(Object obj) {
        if (obj instanceof zzals) {
            return ((zzals) obj).clone();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final Object zza(T t) {
        Object obj = this.zza.get(t);
        if (!(obj instanceof zzakr)) {
            return obj;
        }
        throw new NoSuchMethodError();
    }

    final Iterator<Map.Entry<T, Object>> zzc() {
        if (this.zza.isEmpty()) {
            return Collections.emptyIterator();
        }
        if (this.zzd) {
            return new zzakt(this.zza.zzd().iterator());
        }
        return this.zza.zzd().iterator();
    }

    public final Iterator<Map.Entry<T, Object>> zzd() {
        if (this.zza.isEmpty()) {
            return Collections.emptyIterator();
        }
        if (this.zzd) {
            return new zzakt(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    private zzajy() {
        this.zza = new zzamg();
    }

    private zzajy(zzamh<T, Object> zzamhVar) {
        this.zza = zzamhVar;
        zze();
    }

    private zzajy(boolean z) {
        this(new zzamg());
        zze();
    }

    public final void zze() {
        if (this.zzc) {
            return;
        }
        int iZzb = this.zza.zzb();
        for (int i = 0; i < iZzb; i++) {
            Object value = this.zza.zza(i).getValue();
            if (value instanceof zzakg) {
                ((zzakg) value).zzt();
            }
        }
        Iterator it = this.zza.zzc().iterator();
        while (it.hasNext()) {
            Object value2 = ((Map.Entry) it.next()).getValue();
            if (value2 instanceof zzakg) {
                ((zzakg) value2).zzt();
            }
        }
        this.zza.zza();
        this.zzc = true;
    }

    public final void zza(zzajy<T> zzajyVar) {
        int iZzb = zzajyVar.zza.zzb();
        for (int i = 0; i < iZzb; i++) {
            zzb((Map.Entry) zzajyVar.zza.zza(i));
        }
        Iterator it = zzajyVar.zza.zzc().iterator();
        while (it.hasNext()) {
            zzb((Map.Entry) it.next());
        }
    }

    private final void zzb(Map.Entry<T, Object> entry) {
        zzaln zzalnVarZze;
        T key = entry.getKey();
        Object value = entry.getValue();
        boolean z = value instanceof zzakr;
        if (key.zze()) {
            if (z) {
                throw new IllegalStateException("Lazy fields can not be repeated");
            }
            Object objZza = zza((zzaka) key);
            List list = (List) value;
            int size = list.size();
            if (objZza == null) {
                objZza = new ArrayList(size);
            }
            List list2 = (List) objZza;
            for (int i = 0; i < size; i++) {
                list2.add(zza(list.get(i)));
            }
            this.zza.put(key, objZza);
            return;
        }
        if (key.zzc() != zzank.MESSAGE) {
            if (z) {
                throw new IllegalStateException("Lazy fields must be message-valued");
            }
            this.zza.put(key, zza(value));
            return;
        }
        Object objZza2 = zza((zzaka) key);
        if (objZza2 == null) {
            this.zza.put(key, zza(value));
            if (z) {
                this.zzd = true;
                return;
            }
            return;
        }
        if (z) {
            throw new NoSuchMethodError();
        }
        if (objZza2 instanceof zzals) {
            zzalnVarZze = key.zza((zzals) objZza2, (zzals) value);
        } else {
            zzalnVarZze = key.zza(((zzaln) objZza2).zzr(), (zzaln) value).zze();
        }
        this.zza.put(key, zzalnVarZze);
    }

    private final void zzb(T t, Object obj) {
        if (t.zze()) {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            List list = (List) obj;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                Object obj2 = list.get(i);
                zzc(t, obj2);
                arrayList.add(obj2);
            }
            obj = arrayList;
        } else {
            zzc(t, obj);
        }
        if (obj instanceof zzakr) {
            this.zzd = true;
        }
        this.zza.put(t, obj);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:32:? A[RETURN, SYNTHETIC] */
    private static void zzc(T t, Object obj) {
        boolean z;
        zzanh zzanhVarZzb = t.zzb();
        zzaki.zza(obj);
        switch (zzakb.zza[zzanhVarZzb.zzb().ordinal()]) {
            case 1:
                z = obj instanceof Integer;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(t.zza()), t.zzb().zzb(), obj.getClass().getName()));
            case 2:
                z = obj instanceof Long;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(t.zza()), t.zzb().zzb(), obj.getClass().getName()));
            case 3:
                z = obj instanceof Float;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(t.zza()), t.zzb().zzb(), obj.getClass().getName()));
            case 4:
                z = obj instanceof Double;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(t.zza()), t.zzb().zzb(), obj.getClass().getName()));
            case 5:
                z = obj instanceof Boolean;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(t.zza()), t.zzb().zzb(), obj.getClass().getName()));
            case 6:
                z = obj instanceof String;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(t.zza()), t.zzb().zzb(), obj.getClass().getName()));
            case 7:
                if ((obj instanceof zzaiw) || (obj instanceof byte[])) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(t.zza()), t.zzb().zzb(), obj.getClass().getName()));
            case 8:
                if ((obj instanceof Integer) || (obj instanceof zzakl)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(t.zza()), t.zzb().zzb(), obj.getClass().getName()));
            case 9:
                if ((obj instanceof zzaln) || (obj instanceof zzakr)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(t.zza()), t.zzb().zzb(), obj.getClass().getName()));
            default:
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(t.zza()), t.zzb().zzb(), obj.getClass().getName()));
        }
    }

    static void zza(zzajo zzajoVar, zzanh zzanhVar, int i, Object obj) throws IOException {
        if (zzanhVar == zzanh.zzj) {
            zzaln zzalnVar = (zzaln) obj;
            zzaki.zza(zzalnVar);
            zzajoVar.zzj(i, 3);
            zzalnVar.zza(zzajoVar);
            zzajoVar.zzj(i, 4);
        }
        zzajoVar.zzj(i, zzanhVar.zza());
        switch (zzakb.zzb[zzanhVar.ordinal()]) {
            case 1:
                zzajoVar.zzb(((Double) obj).doubleValue());
                break;
            case 2:
                zzajoVar.zzb(((Float) obj).floatValue());
                break;
            case 3:
                zzajoVar.zzh(((Long) obj).longValue());
                break;
            case 4:
                zzajoVar.zzh(((Long) obj).longValue());
                break;
            case 5:
                zzajoVar.zzj(((Integer) obj).intValue());
                break;
            case 6:
                zzajoVar.zzf(((Long) obj).longValue());
                break;
            case 7:
                zzajoVar.zzi(((Integer) obj).intValue());
                break;
            case 8:
                zzajoVar.zzb(((Boolean) obj).booleanValue());
                break;
            case 9:
                ((zzaln) obj).zza(zzajoVar);
                break;
            case 10:
                zzajoVar.zzc((zzaln) obj);
                break;
            case 11:
                if (obj instanceof zzaiw) {
                    zzajoVar.zzb((zzaiw) obj);
                } else {
                    zzajoVar.zzb((String) obj);
                }
                break;
            case 12:
                if (obj instanceof zzaiw) {
                    zzajoVar.zzb((zzaiw) obj);
                } else {
                    byte[] bArr = (byte[]) obj;
                    zzajoVar.zzb(bArr, 0, bArr.length);
                }
                break;
            case 13:
                zzajoVar.zzl(((Integer) obj).intValue());
                break;
            case 14:
                zzajoVar.zzi(((Integer) obj).intValue());
                break;
            case 15:
                zzajoVar.zzf(((Long) obj).longValue());
                break;
            case 16:
                zzajoVar.zzk(((Integer) obj).intValue());
                break;
            case 17:
                zzajoVar.zzg(((Long) obj).longValue());
                break;
            case 18:
                if (obj instanceof zzakl) {
                    zzajoVar.zzj(((zzakl) obj).zza());
                } else {
                    zzajoVar.zzj(((Integer) obj).intValue());
                }
                break;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzajy) {
            return this.zza.equals(((zzajy) obj).zza);
        }
        return false;
    }

    public final boolean zzf() {
        return this.zzc;
    }

    public final boolean zzg() {
        int iZzb = this.zza.zzb();
        for (int i = 0; i < iZzb; i++) {
            if (!zzc(this.zza.zza(i))) {
                return false;
            }
        }
        Iterator it = this.zza.zzc().iterator();
        while (it.hasNext()) {
            if (!zzc((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private static <T extends zzaka<T>> boolean zzc(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.zzc() != zzank.MESSAGE) {
            return true;
        }
        if (key.zze()) {
            List list = (List) entry.getValue();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (!zzb(list.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return zzb(entry.getValue());
    }

    private static boolean zzb(Object obj) {
        if (obj instanceof zzalp) {
            return ((zzalp) obj).zzv();
        }
        if (obj instanceof zzakr) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }
}
