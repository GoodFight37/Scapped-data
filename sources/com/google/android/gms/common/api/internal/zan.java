package com.google.android.gms.common.api.internal;

import android.app.Dialog;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
final class zan extends zabu {
    final /* synthetic */ Dialog zaa;
    final /* synthetic */ zao zab;

    zan(zao zaoVar, Dialog dialog) {
        this.zaa = dialog;
        this.zab = zaoVar;
    }

    @Override // com.google.android.gms.common.api.internal.zabu
    public final void zaa() {
        this.zab.zaa.zad();
        if (this.zaa.isShowing()) {
            this.zaa.dismiss();
        }
    }
}
