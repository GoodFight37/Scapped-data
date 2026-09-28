package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zah extends zad {
    public final ListenerHolder.ListenerKey zab;

    public zah(ListenerHolder.ListenerKey listenerKey, TaskCompletionSource taskCompletionSource) {
        super(4, taskCompletionSource);
        this.zab = listenerKey;
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final boolean zaa(zabo zaboVar) {
        zacg zacgVar = (zacg) zaboVar.zah().get(this.zab);
        return zacgVar != null && zacgVar.zaa.zab();
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final Feature[] zab(zabo zaboVar) {
        zacg zacgVar = (zacg) zaboVar.zah().get(this.zab);
        if (zacgVar == null) {
            return null;
        }
        return zacgVar.zaa.getRequiredFeatures();
    }

    @Override // com.google.android.gms.common.api.internal.zad
    public final void zac(zabo zaboVar) throws RemoteException {
        zacg zacgVar = (zacg) zaboVar.zah().remove(this.zab);
        if (zacgVar == null) {
            this.zaa.trySetResult(false);
            return;
        }
        zacgVar.zab.unregisterListener(zaboVar.zaf(), this.zaa);
        zacgVar.zaa.clearListener();
    }

    @Override // com.google.android.gms.common.api.internal.zad, com.google.android.gms.common.api.internal.zai
    public final /* bridge */ /* synthetic */ void zag(zaac zaacVar, boolean z) {
    }
}
