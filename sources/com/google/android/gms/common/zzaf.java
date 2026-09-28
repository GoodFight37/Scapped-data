package com.google.android.gms.common;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.common.zzal;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzaf {
    private String zza = null;
    private long zzb = -1;
    private zzal zzc = zzal.zzm();
    private zzal zzd = zzal.zzm();

    zzaf() {
    }

    final zzaf zza(long j) {
        this.zzb = j;
        return this;
    }

    final zzaf zzb(List list) {
        Preconditions.checkNotNull(list);
        this.zzd = zzal.zzl(list);
        return this;
    }

    final zzaf zzc(List list) {
        Preconditions.checkNotNull(list);
        this.zzc = zzal.zzl(list);
        return this;
    }

    final zzaf zzd(String str) {
        this.zza = str;
        return this;
    }

    final zzah zze() {
        if (this.zza == null) {
            throw new IllegalStateException("packageName must be defined");
        }
        if (this.zzb < 0) {
            throw new IllegalStateException("minimumStampedVersionNumber must be greater than or equal to 0");
        }
        if (this.zzc.isEmpty() && this.zzd.isEmpty()) {
            throw new IllegalStateException("Either orderedTestCerts or orderedProdCerts must have at least one cert");
        }
        return new zzah(this.zza, this.zzb, this.zzc, this.zzd, null);
    }
}
