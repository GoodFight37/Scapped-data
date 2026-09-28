package com.google.firebase.auth;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class OAuthCredential extends AuthCredential {
    public abstract String getAccessToken();

    public abstract String getIdToken();

    public abstract String getSecret();
}
