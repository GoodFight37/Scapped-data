package com.google.android.gms.games;

import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final class FriendsResolutionRequiredException extends ResolvableApiException {
    private FriendsResolutionRequiredException(Status status) {
        super(status);
    }

    public static FriendsResolutionRequiredException zza(Status status) {
        return new FriendsResolutionRequiredException(status);
    }
}
