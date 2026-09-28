package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.firebase-auth-api.zzakg.zzb;
import com.google.android.gms.internal.p002firebaseauthapi.zzakg;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzakg<MessageType extends zzakg<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzain<MessageType, BuilderType> {
    private static Map<Class<?>, zzakg<?, ?>> zzc = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzamy zzb = zzamy.zzc();

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    protected static class zza<T extends zzakg<T, ?>> extends zzair<T> {
        public zza(T t) {
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    static final class zzc implements zzaka<zzc> {
        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaka
        public final int zza() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaka
        public final zzalm zza(zzalm zzalmVar, zzaln zzalnVar) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaka
        public final zzals zza(zzals zzalsVar, zzals zzalsVar2) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaka
        public final zzanh zzb() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaka
        public final zzank zzc() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaka
        public final boolean zzd() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaka
        public final boolean zze() {
            throw new NoSuchMethodError();
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static abstract class zzd<MessageType extends zzd<MessageType, BuilderType>, BuilderType> extends zzakg<MessageType, BuilderType> implements zzalp {
        protected zzajy<zzc> zzc = zzajy.zzb();

        final zzajy<zzc> zza() {
            if (this.zzc.zzf()) {
                this.zzc = (zzajy) this.zzc.clone();
            }
            return this.zzc;
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static class zzf<ContainingType extends zzaln, Type> extends zzajs<ContainingType, Type> {
    }

    private final int zza() {
        return zzaly.zza().zza(this).zzb(this);
    }

    static /* synthetic */ boolean zza(zzakg zzakgVar, boolean z) {
        return zzb(zzakgVar, false);
    }

    protected abstract Object zza(int i, Object obj, Object obj2);

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static abstract class zzb<MessageType extends zzakg<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzaip<MessageType, BuilderType> {
        protected MessageType zza;
        private final MessageType zzb;

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaip
        /* JADX INFO: renamed from: zzb */
        public final /* synthetic */ zzaip clone() {
            return (zzb) clone();
        }

        public final BuilderType zza(MessageType messagetype) {
            if (this.zzb.equals(messagetype)) {
                return this;
            }
            if (!this.zza.zzw()) {
                zzh();
            }
            zza(this.zza, messagetype);
            return this;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalm
        /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
        public final MessageType zze() {
            MessageType messagetype = (MessageType) zzf();
            if (messagetype.zzv()) {
                return messagetype;
            }
            throw new zzamw(messagetype);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalm
        /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
        public MessageType zzf() {
            if (!this.zza.zzw()) {
                return this.zza;
            }
            this.zza.zzt();
            return this.zza;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalp
        public final /* synthetic */ zzaln zzs() {
            return this.zzb;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaip
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zzb zzbVar = (zzb) this.zzb.zza(zze.zze, null, null);
            zzbVar.zza = (MessageType) zzf();
            return zzbVar;
        }

        protected zzb(MessageType messagetype) {
            this.zzb = messagetype;
            if (messagetype.zzw()) {
                throw new IllegalArgumentException("Default instance must be immutable.");
            }
            this.zza = (MessageType) messagetype.zzo();
        }

        protected final void zzg() {
            if (this.zza.zzw()) {
                return;
            }
            zzh();
        }

        protected void zzh() {
            MessageType messagetype = (MessageType) this.zzb.zzo();
            zza(messagetype, this.zza);
            this.zza = messagetype;
        }

        private static <MessageType> void zza(MessageType messagetype, MessageType messagetype2) {
            zzaly.zza().zza(messagetype).zza(messagetype, messagetype2);
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalp
        public final boolean zzv() {
            return zzakg.zza((zzakg) this.zza, false);
        }
    }

    private final int zzb(zzamc<?> zzamcVar) {
        if (zzamcVar == null) {
            return zzaly.zza().zza(this).zza(this);
        }
        return zzamcVar.zza(this);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzain
    final int zzi() {
        return this.zzd & Integer.MAX_VALUE;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaln
    public final int zzl() {
        return zza((zzamc) null);
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static final enum zze {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        private static final /* synthetic */ int[] zzh = {1, 2, 3, 4, 5, 6, 7};

        public static int[] zza() {
            return (int[]) zzh.clone();
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzain
    final int zza(zzamc zzamcVar) {
        if (zzw()) {
            int iZzb = zzb((zzamc<?>) zzamcVar);
            if (iZzb >= 0) {
                return iZzb;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + iZzb);
        }
        if (zzi() != Integer.MAX_VALUE) {
            return zzi();
        }
        int iZzb2 = zzb((zzamc<?>) zzamcVar);
        zzb(iZzb2);
        return iZzb2;
    }

    public int hashCode() {
        if (zzw()) {
            return zza();
        }
        if (this.zza == 0) {
            this.zza = zza();
        }
        return this.zza;
    }

    protected final <MessageType extends zzakg<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> BuilderType zzm() {
        return (BuilderType) zza(zze.zze, (Object) null, (Object) null);
    }

    public final BuilderType zzn() {
        return (BuilderType) ((zzb) zza(zze.zze, (Object) null, (Object) null)).zza(this);
    }

    private static <T extends zzakg<T, ?>> T zza(T t) throws zzakm {
        if (t == null || zzb(t, true)) {
            return t;
        }
        zzakm zzakmVarZza = new zzamw(t).zza();
        zzakmVarZza.getClass();
        throw zzakmVarZza;
    }

    static <T extends zzakg<?, ?>> T zza(Class<T> cls) {
        zzakg<?, ?> zzakgVar = zzc.get(cls);
        if (zzakgVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzakgVar = zzc.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzakgVar == null) {
            zzakgVar = (T) ((zzakg) zzana.zza(cls)).zza(zze.zzf, (Object) null, (Object) null);
            if (zzakgVar == null) {
                throw new IllegalStateException();
            }
            zzc.put((Class<?>) cls, zzakgVar);
        }
        return (T) zzakgVar;
    }

    final MessageType zzo() {
        return (MessageType) zza(zze.zzd, (Object) null, (Object) null);
    }

    protected static <T extends zzakg<T, ?>> T zza(T t, zzaiw zzaiwVar, zzajv zzajvVar) throws zzakm {
        return (T) zza(zzb(t, zzaiwVar, zzajvVar));
    }

    protected static <T extends zzakg<T, ?>> T zza(T t, InputStream inputStream, zzajv zzajvVar) throws zzakm {
        zzaji zzajkVar;
        if (inputStream == null) {
            byte[] bArr = zzaki.zzb;
            zzajkVar = zzaji.zza(bArr, 0, bArr.length, false);
        } else {
            zzajkVar = new zzajk(inputStream);
        }
        return (T) zza(zza(t, zzajkVar, zzajvVar));
    }

    protected static <T extends zzakg<T, ?>> T zza(T t, byte[] bArr, zzajv zzajvVar) throws zzakm {
        return (T) zza(zza(t, bArr, 0, bArr.length, zzajvVar));
    }

    private static <T extends zzakg<T, ?>> T zzb(T t, zzaiw zzaiwVar, zzajv zzajvVar) throws zzakm {
        zzaji zzajiVarZzc = zzaiwVar.zzc();
        T t2 = (T) zza(t, zzajiVarZzc, zzajvVar);
        zzajiVarZzc.zzc(0);
        return t2;
    }

    private static <T extends zzakg<T, ?>> T zza(T t, zzaji zzajiVar, zzajv zzajvVar) throws zzakm {
        T t2 = (T) t.zzo();
        try {
            zzamc zzamcVarZza = zzaly.zza().zza(t2);
            zzamcVarZza.zza(t2, zzajm.zza(zzajiVar), zzajvVar);
            zzamcVarZza.zzd(t2);
            return t2;
        } catch (zzakm e) {
            if (e.zzl()) {
                throw new zzakm(e);
            }
            throw e;
        } catch (zzamw e2) {
            zzakm zzakmVarZza = e2.zza();
            zzakmVarZza.getClass();
            throw zzakmVarZza;
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzakm) {
                throw ((zzakm) e3.getCause());
            }
            throw new zzakm(e3);
        } catch (RuntimeException e4) {
            if (e4.getCause() instanceof zzakm) {
                throw ((zzakm) e4.getCause());
            }
            throw e4;
        }
    }

    private static <T extends zzakg<T, ?>> T zza(T t, byte[] bArr, int i, int i2, zzajv zzajvVar) throws zzakm {
        if (i2 == 0) {
            return t;
        }
        T t2 = (T) t.zzo();
        try {
            zzamc zzamcVarZza = zzaly.zza().zza(t2);
            zzamcVarZza.zza(t2, bArr, 0, i2, new zzaiv(zzajvVar));
            zzamcVarZza.zzd(t2);
            return t2;
        } catch (zzakm e) {
            if (e.zzl()) {
                throw new zzakm(e);
            }
            throw e;
        } catch (zzamw e2) {
            zzakm zzakmVarZza = e2.zza();
            zzakmVarZza.getClass();
            throw zzakmVarZza;
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzakm) {
                throw ((zzakm) e3.getCause());
            }
            throw new zzakm(e3);
        } catch (IndexOutOfBoundsException unused) {
            zzakm zzakmVarZzj = zzakm.zzj();
            zzakmVarZzj.getClass();
            throw zzakmVarZzj;
        }
    }

    protected static <E> zzakn<E> zzp() {
        return zzamb.zzd();
    }

    protected static <E> zzakn<E> zza(zzakn<E> zzaknVar) {
        return zzaknVar.zza(zzaknVar.size() << 1);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaln
    public final /* synthetic */ zzalm zzq() {
        return (zzb) zza(zze.zze, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaln
    public final /* synthetic */ zzalm zzr() {
        return ((zzb) zza(zze.zze, (Object) null, (Object) null)).zza(this);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalp
    public final /* synthetic */ zzaln zzs() {
        return (zzakg) zza(zze.zzf, (Object) null, (Object) null);
    }

    static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected static Object zza(zzaln zzalnVar, String str, Object[] objArr) {
        return new zzama(zzalnVar, str, objArr);
    }

    public String toString() {
        return zzalo.zza(this, super.toString());
    }

    protected final void zzt() {
        zzaly.zza().zza(this).zzd(this);
        zzu();
    }

    final void zzu() {
        this.zzd &= Integer.MAX_VALUE;
    }

    protected static <T extends zzakg<?, ?>> void zza(Class<T> cls, T t) {
        t.zzu();
        zzc.put(cls, t);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzain
    final void zzb(int i) {
        if (i < 0) {
            throw new IllegalStateException("serialized size must be non-negative, was " + i);
        }
        this.zzd = (i & Integer.MAX_VALUE) | (this.zzd & Integer.MIN_VALUE);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaln
    public final void zza(zzajo zzajoVar) throws IOException {
        zzaly.zza().zza(this).zza(this, zzajq.zza(zzajoVar));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzaly.zza().zza(this).zzb(this, (zzakg) obj);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalp
    public final boolean zzv() {
        return zzb(this, true);
    }

    private static final <T extends zzakg<T, ?>> boolean zzb(T t, boolean z) {
        byte bByteValue = ((Byte) t.zza(zze.zza, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZze = zzaly.zza().zza(t).zze(t);
        if (z) {
            t.zza(zze.zzb, zZze ? t : null, null);
        }
        return zZze;
    }

    final boolean zzw() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }
}
