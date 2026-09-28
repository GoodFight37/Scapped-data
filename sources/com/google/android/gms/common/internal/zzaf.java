package com.google.android.gms.common.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
public interface zzaf extends IInterface {
    com.google.android.gms.common.zzu zze(com.google.android.gms.common.zzs zzsVar) throws RemoteException;

    com.google.android.gms.common.zzu zzf(com.google.android.gms.common.zzs zzsVar) throws RemoteException;

    boolean zzg() throws RemoteException;

    boolean zzh(com.google.android.gms.common.zzw zzwVar, IObjectWrapper iObjectWrapper) throws RemoteException;

    boolean zzi() throws RemoteException;
}
