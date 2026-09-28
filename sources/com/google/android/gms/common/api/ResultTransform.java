package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zacm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ResultTransform<R extends Result, S extends Result> {
    public final PendingResult<S> createFailedResult(Status status) {
        return new zacm(status);
    }

    public Status onFailure(Status status) {
        return status;
    }

    public abstract PendingResult<S> onSuccess(R r);
}
