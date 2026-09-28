package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzaic;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FacebookAuthCredential;
import com.google.firebase.auth.GithubAuthCredential;
import com.google.firebase.auth.GoogleAuthCredential;
import com.google.firebase.auth.PlayGamesAuthCredential;
import com.google.firebase.auth.TwitterAuthCredential;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzk {
    public static zzaic zza(AuthCredential authCredential, String str) {
        Preconditions.checkNotNull(authCredential);
        if (GoogleAuthCredential.class.isAssignableFrom(authCredential.getClass())) {
            return GoogleAuthCredential.zza((GoogleAuthCredential) authCredential, str);
        }
        if (FacebookAuthCredential.class.isAssignableFrom(authCredential.getClass())) {
            return FacebookAuthCredential.zza((FacebookAuthCredential) authCredential, str);
        }
        if (TwitterAuthCredential.class.isAssignableFrom(authCredential.getClass())) {
            return TwitterAuthCredential.zza((TwitterAuthCredential) authCredential, str);
        }
        if (GithubAuthCredential.class.isAssignableFrom(authCredential.getClass())) {
            return GithubAuthCredential.zza((GithubAuthCredential) authCredential, str);
        }
        if (PlayGamesAuthCredential.class.isAssignableFrom(authCredential.getClass())) {
            return PlayGamesAuthCredential.zza((PlayGamesAuthCredential) authCredential, str);
        }
        if (com.google.firebase.auth.zzc.class.isAssignableFrom(authCredential.getClass())) {
            return com.google.firebase.auth.zzc.zza((com.google.firebase.auth.zzc) authCredential, str);
        }
        throw new IllegalArgumentException("Unsupported credential type.");
    }
}
