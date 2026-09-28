package com.google.firebase.auth;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public class GithubAuthProvider {
    public static final String GITHUB_SIGN_IN_METHOD = "github.com";
    public static final String PROVIDER_ID = "github.com";

    public static AuthCredential getCredential(String str) {
        return new GithubAuthCredential(str);
    }

    private GithubAuthProvider() {
    }
}
