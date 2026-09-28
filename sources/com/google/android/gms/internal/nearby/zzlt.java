package com.google.android.gms.internal.nearby;

import android.util.Log;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.common.util.IOUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzlt {
    private final ExecutorService zza;
    private final SimpleArrayMap zzb;
    private volatile boolean zzc;
    private final SimpleArrayMap zzd;
    private final SimpleArrayMap zze;

    public zzlt() {
        zzg.zza();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(6, 6, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Executors.defaultThreadFactory());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.zza = Executors.unconfigurableExecutorService(threadPoolExecutor);
        this.zzb = new SimpleArrayMap();
        this.zzc = false;
        this.zzd = new SimpleArrayMap();
        this.zze = new SimpleArrayMap();
    }

    static /* bridge */ /* synthetic */ void zza(zzlt zzltVar, OutputStream outputStream, boolean z, long j) {
        try {
            outputStream.write(z ? 1 : 0);
        } catch (IOException e) {
            Log.w("NearbyConnections", String.format("Unable to deliver status for Payload %d", Long.valueOf(j)), e);
        } finally {
            IOUtils.closeQuietly(outputStream);
        }
    }

    final synchronized void zzb(long j) {
        SimpleArrayMap simpleArrayMap = this.zzb;
        Long lValueOf = Long.valueOf(j);
        IOUtils.closeQuietly((Closeable) simpleArrayMap.get(lValueOf));
        this.zzb.remove(lValueOf);
        IOUtils.closeQuietly((Closeable) this.zzd.get(lValueOf));
        this.zzd.remove(lValueOf);
        zzmb zzmbVar = (zzmb) this.zze.remove(lValueOf);
        if (zzmbVar != null) {
            IOUtils.closeQuietly(zzmbVar.zze());
            IOUtils.closeQuietly(zzmbVar.zzf());
        }
    }

    final synchronized void zzc(InputStream inputStream, OutputStream outputStream, OutputStream outputStream2, zzmb zzmbVar, long j) {
        SimpleArrayMap simpleArrayMap = this.zzb;
        Long lValueOf = Long.valueOf(j);
        simpleArrayMap.put(lValueOf, inputStream);
        this.zzd.put(lValueOf, outputStream);
        this.zze.put(lValueOf, zzmbVar);
        this.zza.execute(new zzls(this, inputStream, outputStream, j, outputStream2));
    }

    final synchronized void zzd() {
        this.zzc = true;
        this.zza.shutdownNow();
        for (int i = 0; i < this.zzb.size(); i++) {
            IOUtils.closeQuietly((Closeable) this.zzb.valueAt(i));
        }
        this.zzb.clear();
        for (int i2 = 0; i2 < this.zzd.size(); i2++) {
            IOUtils.closeQuietly((Closeable) this.zzd.valueAt(i2));
        }
        this.zzd.clear();
        for (int i3 = 0; i3 < this.zze.size(); i3++) {
            zzmb zzmbVar = (zzmb) this.zze.valueAt(i3);
            IOUtils.closeQuietly(zzmbVar.zze());
            IOUtils.closeQuietly(zzmbVar.zzf());
        }
        this.zze.clear();
    }
}
