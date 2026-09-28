package com.google.android.gms.internal.games_v2;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzab {
    private final Handler zza;
    private boolean zzc;
    final Object zzb = new Object();
    private final HashMap zzd = new HashMap();

    public zzab(Looper looper, int i) {
        this.zza = new zzfr(looper);
    }

    protected abstract void zza(String str, int i);

    public final void zzb(String str, int i) {
        synchronized (this.zzb) {
            if (!this.zzc) {
                this.zzc = true;
                this.zza.postDelayed(new zzaa(this), 1000L);
            }
            HashMap map = this.zzd;
            AtomicInteger atomicInteger = (AtomicInteger) map.get(str);
            if (atomicInteger == null) {
                atomicInteger = new AtomicInteger();
                map.put(str, atomicInteger);
            }
            atomicInteger.addAndGet(i);
        }
    }

    public final void zzc() {
        synchronized (this.zzb) {
            HashMap map = this.zzd;
            for (Map.Entry entry : map.entrySet()) {
                zza((String) entry.getKey(), ((AtomicInteger) entry.getValue()).get());
            }
            map.clear();
        }
    }

    final /* synthetic */ void zzd() {
        synchronized (this.zzb) {
            this.zzc = false;
            zzc();
        }
    }
}
