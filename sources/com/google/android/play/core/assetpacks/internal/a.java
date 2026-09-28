package com.google.android.play.core.assetpacks.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.1.0 */
/* JADX INFO: loaded from: classes.dex */
public class a implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IBinder f279a;
    private final String b;

    protected a(IBinder iBinder, String str) {
        this.f279a = iBinder;
        this.b = str;
    }

    protected final Parcel a() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.b);
        return parcelObtain;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f279a;
    }

    protected final void b(int i, Parcel parcel) throws RemoteException {
        try {
            this.f279a.transact(i, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
