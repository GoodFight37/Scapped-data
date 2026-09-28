package com.google.android.gms.internal.nearby;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public interface zzdb extends IInterface {
    void zzb(Status status, List list) throws RemoteException;
}
