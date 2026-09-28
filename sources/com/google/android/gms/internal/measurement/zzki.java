package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzki {
    public static final /* synthetic */ int zzc = 0;
    private static final Object zzd = new Object();

    @Nullable
    private static volatile zzkg zze = null;
    private static volatile boolean zzf = false;
    private static final AtomicInteger zzg;
    final zzkf zza;
    final String zzb;
    private Object zzh;
    private volatile int zzi = -1;
    private volatile Object zzj;
    private volatile boolean zzk;

    static {
        new AtomicReference();
        Preconditions.checkNotNull(new Object() { // from class: com.google.android.gms.internal.measurement.zzka
        }, "BuildInfo must be non-null");
        zzg = new AtomicInteger();
    }

    /* synthetic */ zzki(zzkf zzkfVar, String str, Object obj, boolean z, zzkh zzkhVar) {
        if (zzkfVar.zza == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        this.zza = zzkfVar;
        this.zzb = str;
        this.zzh = obj;
        this.zzk = false;
    }

    public static void zzc() {
        zzg.incrementAndGet();
    }

    public static void zzd(final Context context) {
        if (zze != null || context == null) {
            return;
        }
        Object obj = zzd;
        synchronized (obj) {
            if (zze == null) {
                synchronized (obj) {
                    zzkg zzkgVar = zze;
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext != null) {
                        context = applicationContext;
                    }
                    if (zzkgVar == null || zzkgVar.zza() != context) {
                        if (zzkgVar != null) {
                            zzjm.zze();
                            zzkk.zzd();
                            zzju.zze();
                        }
                        zze = new zzjj(context, Suppliers.memoize(new Supplier() { // from class: com.google.android.gms.internal.measurement.zzjz
                            @Override // com.google.common.base.Supplier
                            public final Object get() {
                                int i = zzki.zzc;
                                return zzjv.zza(context);
                            }
                        }));
                        zzg.incrementAndGet();
                    }
                }
            }
        }
    }

    @Nullable
    abstract Object zza(Object obj);

    /* JADX WARN: Code duplicated, block: B:14:0x0047 A[PHI: r2
  0x0047: PHI (r2v1 com.google.common.base.Optional) = (r2v0 com.google.common.base.Optional), (r2v0 com.google.common.base.Optional), (r2v7 com.google.common.base.Optional) binds: [B:8:0x0016, B:10:0x001c, B:12:0x0032] A[DONT_GENERATE, DONT_INLINE]] */
    public final Object zzb() {
        String strZza;
        zzjr zzjrVarZza;
        String strZzb;
        Object objZzb;
        int i = zzg.get();
        if (this.zzi < i) {
            synchronized (this) {
                if (this.zzi < i) {
                    zzkg zzkgVar = zze;
                    Optional optionalAbsent = Optional.absent();
                    Object objZza = null;
                    if (zzkgVar == null || zzkgVar.zzb() == null) {
                        strZza = null;
                    } else {
                        optionalAbsent = (Optional) ((Supplier) Preconditions.checkNotNull(zzkgVar.zzb())).get();
                        if (optionalAbsent.isPresent()) {
                            zzjo zzjoVar = (zzjo) optionalAbsent.get();
                            zzkf zzkfVar = this.zza;
                            strZza = zzjoVar.zza(zzkfVar.zza, null, zzkfVar.zzc, this.zzb);
                        } else {
                            strZza = null;
                        }
                    }
                    Preconditions.checkState(zzkgVar != null, "Must call PhenotypeFlagInitializer.maybeInit() first");
                    zzkf zzkfVar2 = this.zza;
                    Uri uri = zzkfVar2.zza;
                    if (uri != null) {
                        zzjrVarZza = zzjw.zza(zzkgVar.zza(), uri) ? zzjm.zza(zzkgVar.zza().getContentResolver(), uri, new Runnable() { // from class: com.google.android.gms.internal.measurement.zzjy
                            @Override // java.lang.Runnable
                            public final void run() {
                                zzki.zzc();
                            }
                        }) : null;
                    } else {
                        zzjrVarZza = zzkk.zza(zzkgVar.zza(), (String) Preconditions.checkNotNull(null), new Runnable() { // from class: com.google.android.gms.internal.measurement.zzjy
                            @Override // java.lang.Runnable
                            public final void run() {
                                zzki.zzc();
                            }
                        });
                    }
                    Object objZza2 = (zzjrVarZza == null || (objZzb = zzjrVarZza.zzb(this.zzb)) == null) ? null : zza(objZzb);
                    if (objZza2 == null) {
                        if (!zzkfVar2.zzd && (strZzb = zzju.zza(zzkgVar.zza()).zzb(this.zzb)) != null) {
                            objZza = zza(strZzb);
                        }
                        objZza2 = objZza == null ? this.zzh : objZza;
                    }
                    if (optionalAbsent.isPresent()) {
                        objZza2 = strZza == null ? this.zzh : zza(strZza);
                    }
                    this.zzj = objZza2;
                    this.zzi = i;
                }
            }
        }
        return this.zzj;
    }
}
