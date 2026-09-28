package com.google.android.gms.games.internal;

import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.common.util.GmsVersion;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class GamesDowngradeableSafeParcel extends DowngradeableSafeParcel {
    protected static boolean zzp(Integer num) {
        if (num == null) {
            return false;
        }
        return GmsVersion.isAtLeastFenacho(num.intValue());
    }

    @Override // com.google.android.gms.common.internal.DowngradeableSafeParcel
    public final boolean prepareForClientVersion(int i) {
        setShouldDowngrade(!zzp(Integer.valueOf(i)));
        return true;
    }
}
