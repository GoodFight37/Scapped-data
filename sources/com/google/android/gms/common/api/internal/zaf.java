package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zaf extends zad {
    public final zacg zab;

    public zaf(zacg zacgVar, TaskCompletionSource taskCompletionSource) {
        super(3, taskCompletionSource);
        this.zab = zacgVar;
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final boolean zaa(zabo zaboVar) {
        return this.zab.zaa.zab();
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final Feature[] zab(zabo zaboVar) {
        return this.zab.zaa.getRequiredFeatures();
    }

    @Override // com.google.android.gms.common.api.internal.zad
    public final void zac(zabo zaboVar) throws RemoteException {
        this.zab.zaa.registerListener(zaboVar.zaf(), this.zaa);
        ListenerHolder.ListenerKey listenerKey = this.zab.zaa.getListenerKey();
        if (listenerKey != null) {
            zaboVar.zah().put(listenerKey, this.zab);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zad, com.google.android.gms.common.api.internal.zai
    public final /* bridge */ /* synthetic */ void zag(zaac zaacVar, boolean z) {
    }
}
