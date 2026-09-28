package com.unity3d.player;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* JADX INFO: renamed from: com.unity3d.player.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0113l implements OnCompleteListener {
    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        if (task.isSuccessful()) {
            FirebaseIdentifiersHelper.nativeOnFirebaseAppInstanceIdResult((String) task.getResult());
        } else {
            FirebaseIdentifiersHelper.nativeOnFirebaseAppInstanceIdResult(null);
        }
    }
}
