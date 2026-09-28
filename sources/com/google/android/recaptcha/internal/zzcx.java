package com.google.android.recaptcha.internal;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* JADX INFO: loaded from: classes2.dex */
final class zzcx extends ContinuationImpl {
    /* synthetic */ Object zza;
    final /* synthetic */ zzdc zzb;
    int zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzcx(zzdc zzdcVar, Continuation continuation) {
        super(continuation);
        this.zzb = zzdcVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object objMo100executegIAlus = this.zzb.mo100executegIAlus(null, this);
        return objMo100executegIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo100executegIAlus : Result.m247boximpl(objMo100executegIAlus);
    }
}
