package com.google.android.gms.games;

import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
public class zzg extends DataBufferRef {
    public zzg(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    protected final String zzj(String str, String str2) {
        if (!hasColumn(str) || hasNull(str)) {
            return null;
        }
        return getString(str);
    }

    protected final int zzu(String str, int i) {
        return (!hasColumn(str) || hasNull(str)) ? i : getInteger(str);
    }
}
