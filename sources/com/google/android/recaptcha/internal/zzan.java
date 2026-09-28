package com.google.android.recaptcha.internal;

import android.content.Context;
import com.google.android.play.core.integrity.StandardIntegrityManager;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzan {
    public CompletableDeferred zza;
    private final CoroutineScope zzb;
    private final zzek zzc;
    private final StandardIntegrityManager zzd;
    private long zzf;
    private boolean zzh;
    private zzao zze = zzao.zza;
    private final Mutex zzg = MutexKt.Mutex$default(false, 1, null);

    public zzan(Context context, CoroutineScope coroutineScope, zzek zzekVar, StandardIntegrityManager standardIntegrityManager, long j) {
        this.zzb = coroutineScope;
        this.zzc = zzekVar;
        this.zzd = standardIntegrityManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object zzi(Continuation continuation) throws Exception {
        zzag zzagVar;
        if (continuation instanceof zzag) {
            zzagVar = (zzag) continuation;
            int i = zzagVar.zzc;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzagVar.zzc = i - Integer.MIN_VALUE;
            } else {
                zzagVar = new zzag(this, continuation);
            }
        } else {
            zzagVar = new zzag(this, continuation);
        }
        Object objAwait = zzagVar.zza;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzagVar.zzc;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objAwait);
            Deferred deferredZza = zzbx.zza(this.zzd.prepareIntegrityToken(StandardIntegrityManager.PrepareIntegrityTokenRequest.builder().setCloudProjectNumber(this.zzf).build()));
            zzagVar.zzc = 1;
            objAwait = deferredZza.await(zzagVar);
            if (objAwait == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objAwait);
        }
        return objAwait;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006d, code lost:
    
        if (r7 == r1) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzj(java.lang.String r6, kotlin.coroutines.Continuation r7) throws java.lang.Exception {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.google.android.recaptcha.internal.zzah
            if (r0 == 0) goto L13
            r0 = r7
            com.google.android.recaptcha.internal.zzah r0 = (com.google.android.recaptcha.internal.zzah) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzc = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzah r0 = new com.google.android.recaptcha.internal.zzah
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.zza
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzc
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3d
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r7)
            goto L70
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            java.lang.String r6 = r0.zzd
            r2 = r6
            java.lang.String r2 = (java.lang.String) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L4e
        L3d:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.CompletableDeferred r7 = r5.zzf()
            r0.zzd = r6
            r0.zzc = r4
            java.lang.Object r7 = r7.await(r0)
            if (r7 == r1) goto L77
        L4e:
            com.google.android.play.core.integrity.StandardIntegrityManager$StandardIntegrityTokenProvider r7 = (com.google.android.play.core.integrity.StandardIntegrityManager.StandardIntegrityTokenProvider) r7
            com.google.android.play.core.integrity.StandardIntegrityManager$StandardIntegrityTokenRequest$Builder r2 = com.google.android.play.core.integrity.StandardIntegrityManager.StandardIntegrityTokenRequest.builder()
            com.google.android.play.core.integrity.StandardIntegrityManager$StandardIntegrityTokenRequest$Builder r6 = r2.setRequestHash(r6)
            com.google.android.play.core.integrity.StandardIntegrityManager$StandardIntegrityTokenRequest r6 = r6.build()
            com.google.android.gms.tasks.Task r6 = r7.request(r6)
            kotlinx.coroutines.Deferred r6 = com.google.android.recaptcha.internal.zzbx.zza(r6)
            r7 = 0
            r0.zzd = r7
            r0.zzc = r3
            java.lang.Object r7 = r6.await(r0)
            if (r7 != r1) goto L70
            goto L77
        L70:
            com.google.android.play.core.integrity.StandardIntegrityManager$StandardIntegrityToken r7 = (com.google.android.play.core.integrity.StandardIntegrityManager.StandardIntegrityToken) r7
            java.lang.String r6 = r7.token()
            return r6
        L77:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzan.zzj(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0074 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x0085 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object zzc(String str, Continuation continuation) throws Exception {
        zzaf zzafVar;
        zzan zzanVar;
        if (continuation instanceof zzaf) {
            zzafVar = (zzaf) continuation;
            int i = zzafVar.zzc;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzafVar.zzc = i - Integer.MIN_VALUE;
            } else {
                zzafVar = new zzaf(this, continuation);
            }
        } else {
            zzafVar = new zzaf(this, continuation);
        }
        Object objZzj = zzafVar.zza;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzafVar.zzc;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objZzj);
            try {
                zzafVar.zzd = this;
                zzafVar.zze = str;
                zzafVar.zzc = 1;
                objZzj = zzj(str, zzafVar);
                if (objZzj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                zzanVar = this;
            } catch (Exception unused) {
                zzanVar = this;
                zzafVar.zzd = zzanVar;
                zzafVar.zze = str;
                zzafVar.zzc = 2;
                if (zzanVar.zze(zzafVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                zzafVar.zzd = null;
                zzafVar.zze = null;
                zzafVar.zzc = 3;
                objZzj = zzanVar.zzj(str, zzafVar);
                if (objZzj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return (String) objZzj;
            }
        } else {
            if (i2 != 1) {
                if (i2 == 2) {
                    str = zzafVar.zze;
                    zzanVar = zzafVar.zzd;
                    ResultKt.throwOnFailure(objZzj);
                    zzafVar.zzd = null;
                    zzafVar.zze = null;
                    zzafVar.zzc = 3;
                    objZzj = zzanVar.zzj(str, zzafVar);
                    if (objZzj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i2 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(objZzj);
                }
                return (String) objZzj;
            }
            str = zzafVar.zze;
            zzanVar = zzafVar.zzd;
            try {
                ResultKt.throwOnFailure(objZzj);
            } catch (Exception unused2) {
                zzafVar.zzd = zzanVar;
                zzafVar.zze = str;
                zzafVar.zzc = 2;
                if (zzanVar.zze(zzafVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                zzafVar.zzd = null;
                zzafVar.zze = null;
                zzafVar.zzc = 3;
                objZzj = zzanVar.zzj(str, zzafVar);
                if (objZzj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return (String) objZzj;
            }
        }
        return (String) objZzj;
    }

    public final Object zzd(long j, Continuation continuation) {
        this.zzf = j;
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b9, code lost:
    
        if (kotlin.Unit.INSTANCE == r1) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zze(kotlin.coroutines.Continuation r14) {
        /*
            r13 = this;
            boolean r0 = r14 instanceof com.google.android.recaptcha.internal.zzak
            if (r0 == 0) goto L13
            r0 = r14
            com.google.android.recaptcha.internal.zzak r0 = (com.google.android.recaptcha.internal.zzak) r0
            int r1 = r0.zzd
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzd = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzak r0 = new com.google.android.recaptcha.internal.zzak
            r0.<init>(r13, r14)
        L18:
            java.lang.Object r14 = r0.zzb
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzd
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L43
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            kotlin.ResultKt.throwOnFailure(r14)
            goto Lbc
        L2e:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L36:
            java.lang.Object r2 = r0.zza
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            com.google.android.recaptcha.internal.zzan r6 = r0.zze
            r7 = r6
            com.google.android.recaptcha.internal.zzan r7 = (com.google.android.recaptcha.internal.zzan) r7
            kotlin.ResultKt.throwOnFailure(r14)
            goto L55
        L43:
            kotlin.ResultKt.throwOnFailure(r14)
            kotlinx.coroutines.sync.Mutex r2 = r13.zzg
            r0.zze = r13
            r0.zza = r2
            r0.zzd = r4
            java.lang.Object r14 = r2.lock(r5, r0)
            if (r14 == r1) goto Lc4
            r6 = r13
        L55:
            com.google.android.recaptcha.internal.zzao r14 = r6.zze     // Catch: java.lang.Throwable -> Lbf
            com.google.android.recaptcha.internal.zzao r7 = com.google.android.recaptcha.internal.zzao.zza     // Catch: java.lang.Throwable -> Lbf
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual(r14, r7)     // Catch: java.lang.Throwable -> Lbf
            if (r14 != 0) goto L65
            kotlin.Unit r14 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> Lbf
            r2.unlock(r5)
            return r14
        L65:
            com.google.android.recaptcha.internal.zzao r14 = com.google.android.recaptcha.internal.zzao.zzb     // Catch: java.lang.Throwable -> Lbf
            r6.zze = r14     // Catch: java.lang.Throwable -> Lbf
            kotlin.Unit r14 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> Lbf
            r2.unlock(r5)
            com.google.android.recaptcha.internal.zzek r14 = r6.zzc
            java.lang.String r2 = r14.zzd()
            r14.zzc(r2)
            r14.zzb(r3)
            r2 = 38
            com.google.android.recaptcha.internal.zzen r14 = r14.zzf(r2)
            kotlinx.coroutines.CompletableDeferred r2 = kotlinx.coroutines.CompletableDeferredKt.CompletableDeferred$default(r5, r4, r5)
            r6.zza = r2
            kotlinx.coroutines.CoroutineScope r7 = r6.zzb
            com.google.android.recaptcha.internal.zzam r2 = new com.google.android.recaptcha.internal.zzam
            r2.<init>(r6, r14, r5)
            r10 = r2
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r11 = 3
            r12 = 0
            r8 = 0
            r9 = 0
            kotlinx.coroutines.BuildersKt.launch$default(r7, r8, r9, r10, r11, r12)
            r0.zze = r5
            r0.zza = r5
            r0.zzd = r3
            boolean r14 = r6.zzh
            if (r14 != 0) goto Lb7
            java.util.Timer r7 = new java.util.Timer
            r7.<init>()
            com.google.android.recaptcha.internal.zzai r14 = new com.google.android.recaptcha.internal.zzai
            r14.<init>(r6)
            r8 = r14
            java.util.TimerTask r8 = (java.util.TimerTask) r8
            r11 = 28800000(0x1b77400, double:1.42290906E-316)
            r9 = r11
            r7.schedule(r8, r9, r11)
            r6.zzh = r4
        Lb7:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            if (r14 != r1) goto Lbc
            goto Lc4
        Lbc:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        Lbf:
            r14 = move-exception
            r2.unlock(r5)
            throw r14
        Lc4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzan.zze(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final CompletableDeferred zzf() {
        CompletableDeferred completableDeferred = this.zza;
        if (completableDeferred != null) {
            return completableDeferred;
        }
        return null;
    }
}
