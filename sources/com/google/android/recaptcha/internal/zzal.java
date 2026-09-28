package com.google.android.recaptcha.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* JADX INFO: loaded from: classes2.dex */
final class zzal extends SuspendLambda implements Function2 {
    long zza;
    boolean zzb;
    int zzc;
    final /* synthetic */ zzan zzd;
    final /* synthetic */ zzen zze;
    final /* synthetic */ Ref.ObjectRef zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzal(zzan zzanVar, zzen zzenVar, Ref.ObjectRef objectRef, Continuation continuation) {
        super(2, continuation);
        this.zzd = zzanVar;
        this.zze = zzenVar;
        this.zzf = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new zzal(this.zzd, this.zze, this.zzf, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzal) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0026 A[Catch: Exception -> 0x001c, TRY_ENTER, TryCatch #0 {Exception -> 0x001c, blocks: (B:14:0x0026, B:16:0x0035, B:8:0x0018), top: B:43:0x0018 }] */
    /* JADX WARN: Code duplicated, block: B:18:0x004e A[RETURN] */
    /* JADX WARN: Type inference failed for: r8v2, types: [T, java.lang.Exception, java.lang.Throwable] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x004c -> B:13:0x0024). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0084 -> B:6:0x0013). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.zzc
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L16
            boolean r1 = r7.zzb
            long r4 = r7.zza
            kotlin.ResultKt.throwOnFailure(r8)
        L13:
            r8 = r1
            goto L87
        L16:
            long r4 = r7.zza
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Exception -> L1c
            goto L35
        L1c:
            r8 = move-exception
            goto L4f
        L1e:
            kotlin.ResultKt.throwOnFailure(r8)
            r4 = 1000(0x3e8, double:4.94E-321)
            r8 = r3
        L24:
            if (r8 == 0) goto L8b
            com.google.android.recaptcha.internal.zzan r8 = r7.zzd     // Catch: java.lang.Exception -> L1c
            r1 = r7
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1     // Catch: java.lang.Exception -> L1c
            r7.zza = r4     // Catch: java.lang.Exception -> L1c
            r7.zzc = r3     // Catch: java.lang.Exception -> L1c
            java.lang.Object r8 = com.google.android.recaptcha.internal.zzan.zza(r8, r1)     // Catch: java.lang.Exception -> L1c
            if (r8 == r0) goto L4e
        L35:
            com.google.android.play.core.integrity.StandardIntegrityManager$StandardIntegrityTokenProvider r8 = (com.google.android.play.core.integrity.StandardIntegrityManager.StandardIntegrityTokenProvider) r8     // Catch: java.lang.Exception -> L1c
            com.google.android.recaptcha.internal.zzan r1 = r7.zzd     // Catch: java.lang.Exception -> L1c
            kotlinx.coroutines.CompletableDeferred r1 = r1.zzf()     // Catch: java.lang.Exception -> L1c
            r1.complete(r8)     // Catch: java.lang.Exception -> L1c
            com.google.android.recaptcha.internal.zzan r8 = r7.zzd     // Catch: java.lang.Exception -> L1c
            com.google.android.recaptcha.internal.zzao r1 = com.google.android.recaptcha.internal.zzao.zzc     // Catch: java.lang.Exception -> L1c
            com.google.android.recaptcha.internal.zzan.zzh(r8, r1)     // Catch: java.lang.Exception -> L1c
            com.google.android.recaptcha.internal.zzen r8 = r7.zze     // Catch: java.lang.Exception -> L1c
            r8.zza()     // Catch: java.lang.Exception -> L1c
            r8 = r2
            goto L24
        L4e:
            return r0
        L4f:
            kotlin.jvm.internal.Ref$ObjectRef r1 = r7.zzf
            r1.element = r8
            boolean r1 = r8 instanceof com.google.android.play.core.integrity.StandardIntegrityException
            if (r1 == 0) goto L73
            r1 = r8
            com.google.android.play.core.integrity.StandardIntegrityException r1 = (com.google.android.play.core.integrity.StandardIntegrityException) r1
            int r1 = r1.getErrorCode()
            r6 = -100
            if (r1 == r6) goto L71
            r6 = -18
            if (r1 == r6) goto L71
            r6 = -12
            if (r1 == r6) goto L71
            r6 = -8
            if (r1 == r6) goto L71
            r6 = -3
            if (r1 == r6) goto L71
            goto L73
        L71:
            r1 = r3
            goto L74
        L73:
            r1 = r2
        L74:
            if (r1 == 0) goto L8a
            r8 = r7
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r7.zza = r4
            r7.zzb = r3
            r6 = 2
            r7.zzc = r6
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r4, r8)
            if (r8 == r0) goto L89
            goto L13
        L87:
            long r4 = r4 + r4
            goto L24
        L89:
            return r0
        L8a:
            throw r8
        L8b:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzal.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
