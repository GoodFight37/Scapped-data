package com.google.android.gms.internal.nearby;

import android.util.Log;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzls implements Runnable {
    final /* synthetic */ InputStream zza;
    final /* synthetic */ OutputStream zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ OutputStream zzd;
    final /* synthetic */ zzlt zze;

    zzls(zzlt zzltVar, InputStream inputStream, OutputStream outputStream, long j, OutputStream outputStream2) {
        this.zze = zzltVar;
        this.zza = inputStream;
        this.zzb = outputStream;
        this.zzc = j;
        this.zzd = outputStream2;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        boolean z = false;
        try {
            IOUtils.copyStream(this.zza, this.zzb, false, 65536);
            IOUtils.closeQuietly(this.zza);
            zzlt.zza(this.zze, this.zzd, false, this.zzc);
        } catch (IOException e) {
            try {
                if (this.zze.zzc) {
                    Log.d("NearbyConnections", String.format("Terminating copying stream for Payload %d due to shutdown of OutgoingPayloadStreamer.", Long.valueOf(this.zzc)));
                } else {
                    Log.w("NearbyConnections", String.format("Exception copying stream for Payload %d", Long.valueOf(this.zzc)), e);
                }
                IOUtils.closeQuietly(this.zza);
                zzlt.zza(this.zze, this.zzd, true, this.zzc);
            } catch (Throwable th) {
                th = th;
                z = true;
                IOUtils.closeQuietly(this.zza);
                zzlt.zza(this.zze, this.zzd, z, this.zzc);
                IOUtils.closeQuietly(this.zzb);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            IOUtils.closeQuietly(this.zza);
            zzlt.zza(this.zze, this.zzd, z, this.zzc);
            IOUtils.closeQuietly(this.zzb);
            throw th;
        }
        IOUtils.closeQuietly(this.zzb);
    }
}
