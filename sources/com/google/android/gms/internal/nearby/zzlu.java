package com.google.android.gms.internal.nearby;

import android.os.Parcel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzlu extends zzly {
    zzlu() {
    }

    @Override // com.google.android.gms.internal.nearby.zzly, android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    @Override // com.google.android.gms.internal.nearby.zzly
    /* JADX INFO: renamed from: zza */
    public final zzlx createFromParcel(Parcel parcel) {
        zzlx zzlxVarCreateFromParcel = super.createFromParcel(parcel);
        if (zzlxVarCreateFromParcel.zzb != null) {
            zzlxVarCreateFromParcel.zza = zzlx.zzd(zzlxVarCreateFromParcel.zzb);
        }
        return zzlxVarCreateFromParcel;
    }
}
