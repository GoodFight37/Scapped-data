package com.google.android.gms.internal.common;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzah extends zzae {
    public zzah() {
        super(4);
    }

    public final zzah zzb(Object obj) {
        super.zza(obj);
        return this;
    }

    public final zzah zzc(Iterator it) {
        while (it.hasNext()) {
            super.zza(it.next());
        }
        return this;
    }

    public final zzal zzd() {
        this.zzc = true;
        return zzal.zzj(this.zza, this.zzb);
    }

    zzah(int i) {
        super(4);
    }
}
