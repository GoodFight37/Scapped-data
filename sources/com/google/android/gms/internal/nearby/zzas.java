package com.google.android.gms.internal.nearby;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzas extends IStatusCallback.Stub {
    final /* synthetic */ List zza;
    final /* synthetic */ TaskCompletionSource zzb;

    zzas(zzax zzaxVar, List list, TaskCompletionSource taskCompletionSource) {
        this.zza = list;
        this.zzb = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.IStatusCallback
    public final void onResult(Status status) {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            try {
                ((ParcelFileDescriptor) it.next()).close();
            } catch (IOException e) {
                Log.w("ExposureNotification", "Failed to close file", e);
            }
        }
        TaskUtil.trySetResultOrApiException(status, null, this.zzb);
    }
}
