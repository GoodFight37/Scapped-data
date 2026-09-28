package com.google.android.gms.tasks;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@18.2.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzm implements Runnable {
    final /* synthetic */ Task zza;
    final /* synthetic */ zzn zzb;

    zzm(zzn zznVar, Task task) {
        this.zza = task;
        this.zzb = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzb.zzb) {
            zzn zznVar = this.zzb;
            if (zznVar.zzc != null) {
                zznVar.zzc.onSuccess(this.zza.getResult());
            }
        }
    }
}
