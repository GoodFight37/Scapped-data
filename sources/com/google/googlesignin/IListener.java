package com.google.googlesignin;

import com.google.android.gms.auth.api.identity.AuthorizationResult;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;

/* JADX INFO: loaded from: classes2.dex */
public interface IListener extends OnCanceledListener, OnFailureListener {
    void onAuthenticated(String str);

    void onAuthorized(AuthorizationResult authorizationResult);
}
