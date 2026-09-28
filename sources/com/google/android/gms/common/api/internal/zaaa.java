package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
final class zaaa implements PendingResult.StatusListener {
    final /* synthetic */ BasePendingResult zaa;
    final /* synthetic */ zaac zab;

    zaaa(zaac zaacVar, BasePendingResult basePendingResult) {
        this.zaa = basePendingResult;
        this.zab = zaacVar;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void onComplete(Status status) {
        this.zab.zaa.remove(this.zaa);
    }
}
