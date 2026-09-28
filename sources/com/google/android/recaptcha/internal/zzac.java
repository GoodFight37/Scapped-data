package com.google.android.recaptcha.internal;

import com.google.android.play.core.integrity.StandardIntegrityException;
import com.google.android.play.core.integrity.model.StandardIntegrityErrorCode;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* JADX INFO: loaded from: classes2.dex */
final class zzac extends SuspendLambda implements Function2 {
    Object zza;
    int zzb;
    final /* synthetic */ zzae zzc;
    final /* synthetic */ String zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzac(zzae zzaeVar, String str, Continuation continuation) {
        super(2, continuation);
        this.zzc = zzaeVar;
        this.zzd = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new zzac(this.zzc, this.zzd, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzac) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.google.android.recaptcha.internal.zzen] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        zzy zzyVar;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        zzen zzenVar = this.zzb;
        try {
            if (zzenVar == 0) {
                ResultKt.throwOnFailure(obj);
                zzen zzenVarZzb = zzz.zzb(this.zzc, this.zzd);
                zzae zzaeVar = this.zzc;
                this.zza = zzenVarZzb;
                this.zzb = 1;
                obj = zzaeVar.zzc.zzc(zzaeVar.zze, this);
                zzenVar = zzenVarZzb;
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (zzenVar != 1) {
                    zzyVar = (zzy) this.zza;
                    ResultKt.throwOnFailure(obj);
                    int iZza = zzyVar.zza();
                    zztd zztdVar = (zztd) ((zzte) obj).zzr();
                    zztdVar.zzf(zzyVar.zza());
                    return new zzw(iZza, (zzte) zztdVar.zzk());
                }
                zzen zzenVar2 = (zzen) this.zza;
                ResultKt.throwOnFailure(obj);
                zzenVar = zzenVar2;
            }
            zzenVar.zza();
            zzae zzaeVar2 = this.zzc;
            zztf zztfVarZzf = zzti.zzf();
            zztg zztgVarZzf = zzth.zzf();
            zztgVarZzf.zzw((String) obj);
            zztfVarZzf.zzf((zzth) zztgVarZzf.zzk());
            return zzz.zza(zzaeVar2, (zzti) zztfVarZzf.zzk());
        } catch (Exception e) {
            zzenVar.zzb(new zzbd(zzbb.zzb, zzba.zzaa, e.getMessage()));
            zzae zzaeVar3 = this.zzc;
            this.zza = zzaeVar3;
            int i = 2;
            this.zzb = 2;
            if (e instanceof StandardIntegrityException) {
                int errorCode = ((StandardIntegrityException) e).getErrorCode();
                if (errorCode == -100) {
                    i = 44;
                } else if (errorCode == -12) {
                    i = 39;
                } else if (errorCode == -3) {
                    i = 30;
                } else if (errorCode == -2) {
                    i = 29;
                } else if (errorCode != -1) {
                    switch (errorCode) {
                        case StandardIntegrityErrorCode.INTEGRITY_TOKEN_PROVIDER_INVALID /* -19 */:
                            i = 54;
                            break;
                        case StandardIntegrityErrorCode.CLIENT_TRANSIENT_ERROR /* -18 */:
                            i = 53;
                            break;
                        case -17:
                            i = 52;
                            break;
                        case -16:
                            i = 43;
                            break;
                        case -15:
                            i = 42;
                            break;
                        case -14:
                            i = 41;
                            break;
                        default:
                            switch (errorCode) {
                                case -9:
                                    i = 36;
                                    break;
                                case -8:
                                    i = 35;
                                    break;
                                case -7:
                                    i = 34;
                                    break;
                                case -6:
                                    i = 33;
                                    break;
                                case -5:
                                    i = 32;
                                    break;
                            }
                            break;
                    }
                } else {
                    i = 28;
                }
            } else {
                i = 45;
            }
            zztd zztdVarZzf = zzte.zzf();
            zztdVarZzf.zzq(i);
            zztdVarZzf.zzr(15);
            obj = zztdVarZzf.zzk();
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            zzyVar = zzaeVar3;
        }
    }
}
