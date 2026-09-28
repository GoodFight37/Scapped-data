package com.google.android.gms.games.internal.v2.appshortcuts;

import android.content.Intent;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
public interface zzx extends IInterface {
    void zzb(zzg zzgVar) throws RemoteException;

    void zzc(Intent intent) throws RemoteException;

    void zzd(Status status) throws RemoteException;
}
