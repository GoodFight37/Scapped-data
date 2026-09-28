package com.adjust.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class GooglePlayServicesClient {

    public static final class GooglePlayServicesInfo {
        private final String gpsAdid;
        private final Boolean trackingEnabled;

        public GooglePlayServicesInfo(String str, Boolean bool) {
            this.gpsAdid = str;
            this.trackingEnabled = bool;
        }

        public String getGpsAdid() {
            return this.gpsAdid;
        }

        public Boolean isTrackingEnabled() {
            return this.trackingEnabled;
        }
    }

    public static final class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f78a;
        public boolean b = false;
        public final LinkedBlockingQueue<IBinder> c = new LinkedBlockingQueue<>(1);

        public a(long j) {
            this.f78a = j;
        }

        public final IBinder a() {
            if (this.b) {
                throw new IllegalStateException();
            }
            this.b = true;
            return this.c.poll(this.f78a, TimeUnit.MILLISECONDS);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.c.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static GooglePlayServicesInfo getGooglePlayServicesInfo(Context context, long j) throws PackageManager.NameNotFoundException, IOException {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Google Play Services info can't be accessed from the main thread");
        }
        context.getPackageManager().getPackageInfo("com.android.vending", 0);
        a aVar = new a(j);
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        try {
            if (!context.bindService(intent, aVar, 1)) {
                throw new IOException("Google Play connection failed");
            }
            try {
                IBinder iBinderA = aVar.a();
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    iBinderA.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    String string = parcelObtain2.readString();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    Parcel parcelObtain3 = Parcel.obtain();
                    Parcel parcelObtain4 = Parcel.obtain();
                    try {
                        parcelObtain3.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                        parcelObtain3.writeInt(1);
                        iBinderA.transact(2, parcelObtain3, parcelObtain4, 0);
                        parcelObtain4.readException();
                        Boolean boolValueOf = Boolean.valueOf(parcelObtain4.readInt() != 0);
                        parcelObtain4.recycle();
                        parcelObtain3.recycle();
                        GooglePlayServicesInfo googlePlayServicesInfo = new GooglePlayServicesInfo(string, boolValueOf != null ? Boolean.valueOf(!boolValueOf.booleanValue()) : null);
                        context.unbindService(aVar);
                        return googlePlayServicesInfo;
                    } catch (Throwable th) {
                        parcelObtain4.recycle();
                        parcelObtain3.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Throwable th3) {
            context.unbindService(aVar);
            throw th3;
        }
    }
}
