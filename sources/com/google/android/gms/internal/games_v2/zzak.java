package com.google.android.gms.internal.games_v2;

import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzak extends zzb implements zzal {
    public static zzal zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.recall.IRecallService");
        return iInterfaceQueryLocalInterface instanceof zzal ? (zzal) iInterfaceQueryLocalInterface : new zzaj(iBinder);
    }
}
