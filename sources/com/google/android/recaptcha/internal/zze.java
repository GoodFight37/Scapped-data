package com.google.android.recaptcha.internal;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zze {
    private boolean zza;

    protected zzen zza(String str) {
        throw null;
    }

    protected zzen zzb() {
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:44:0x00e7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:47:0x00ed A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    public final Object zzc(String str, long j, Continuation continuation) throws zzbd {
        zza zzaVar;
        zzen zzenVarZza;
        Exception exc;
        long j2;
        zzen zzenVar;
        zze zzeVar;
        zze zzeVar2;
        zzbd zzbdVarZza;
        long j3;
        String str2 = str;
        long j4 = j;
        if (continuation instanceof zza) {
            zzaVar = (zza) continuation;
            int i = zzaVar.zze;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzaVar.zze = i - Integer.MIN_VALUE;
            } else {
                zzaVar = new zza(this, continuation);
            }
        } else {
            zzaVar = new zza(this, continuation);
        }
        Object objWithTimeout = zzaVar.zzc;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzaVar.zze;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithTimeout);
            zzenVarZza = zza(str);
            try {
                zzb zzbVar = new zzb(this, str2, null);
                zzaVar.zza = this;
                zzaVar.zzf = str2;
                zzaVar.zzg = zzenVarZza;
                zzaVar.zzb = j4;
                zzaVar.zze = 1;
                objWithTimeout = TimeoutKt.withTimeout(j4, zzbVar, zzaVar);
                if (objWithTimeout == coroutine_suspended) {
                    return coroutine_suspended;
                }
                zzeVar2 = this;
            } catch (Exception e) {
                exc = e;
                j2 = j4;
                zzenVar = zzenVarZza;
                zzeVar = this;
                zzbdVarZza = zzf.zza(exc, new zzbd(zzbb.zzb, zzba.zzaa, exc.getMessage()));
                if (zzenVar != null) {
                    zzenVar.zzb(zzbdVarZza);
                }
                zzaVar.zza = zzeVar;
                zzaVar.zzf = str2;
                zzaVar.zzg = null;
                zzaVar.zze = 2;
                if (zzeVar.zzi(str2, j2, exc, zzaVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Result.Companion companion = Result.INSTANCE;
                zzaVar.zza = null;
                zzaVar.zzf = null;
                zzaVar.zze = 3;
                objWithTimeout = zzeVar.zzd(str2, zzaVar);
                if (objWithTimeout == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Result.m248constructorimpl(objWithTimeout);
            }
        } else {
            if (i2 != 1) {
                if (i2 == 2) {
                    str2 = zzaVar.zzf;
                    zzeVar = (zze) zzaVar.zza;
                    ResultKt.throwOnFailure(objWithTimeout);
                    Result.Companion companion2 = Result.INSTANCE;
                    zzaVar.zza = null;
                    zzaVar.zzf = null;
                    zzaVar.zze = 3;
                    objWithTimeout = zzeVar.zzd(str2, zzaVar);
                    if (objWithTimeout == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i2 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(objWithTimeout);
                }
                return Result.m248constructorimpl(objWithTimeout);
            }
            long j5 = zzaVar.zzb;
            zzenVar = zzaVar.zzg;
            String str3 = zzaVar.zzf;
            zzeVar2 = (zze) zzaVar.zza;
            try {
                ResultKt.throwOnFailure(objWithTimeout);
                zzenVarZza = zzenVar;
                j4 = j5;
                str2 = str3;
            } catch (Exception e2) {
                exc = e2;
                j3 = j5;
                str2 = str3;
                zzeVar = zzeVar2;
                j2 = j3;
                zzbdVarZza = zzf.zza(exc, new zzbd(zzbb.zzb, zzba.zzaa, exc.getMessage()));
                if (zzenVar != null) {
                    zzenVar.zzb(zzbdVarZza);
                }
                zzaVar.zza = zzeVar;
                zzaVar.zzf = str2;
                zzaVar.zzg = null;
                zzaVar.zze = 2;
                if (zzeVar.zzi(str2, j2, exc, zzaVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Result.Companion companion3 = Result.INSTANCE;
                zzaVar.zza = null;
                zzaVar.zzf = null;
                zzaVar.zze = 3;
                objWithTimeout = zzeVar.zzd(str2, zzaVar);
                if (objWithTimeout == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Result.m248constructorimpl(objWithTimeout);
            }
        }
        try {
            Object value = ((Result) objWithTimeout).getValue();
            ResultKt.throwOnFailure(value);
            zzsi zzsiVar = (zzsi) value;
            if (zzenVarZza != null) {
                zzenVarZza.zza();
            }
            return Result.m248constructorimpl(zzsiVar);
        } catch (Exception e3) {
            exc = e3;
            j3 = j4;
            zzenVar = zzenVarZza;
            zzeVar = zzeVar2;
            j2 = j3;
            zzbdVarZza = zzf.zza(exc, new zzbd(zzbb.zzb, zzba.zzaa, exc.getMessage()));
            if (zzenVar != null) {
                zzenVar.zzb(zzbdVarZza);
            }
            zzaVar.zza = zzeVar;
            zzaVar.zzf = str2;
            zzaVar.zzg = null;
            zzaVar.zze = 2;
            if (zzeVar.zzi(str2, j2, exc, zzaVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            Result.Companion companion4 = Result.INSTANCE;
            zzaVar.zza = null;
            zzaVar.zzf = null;
            zzaVar.zze = 3;
            objWithTimeout = zzeVar.zzd(str2, zzaVar);
            if (objWithTimeout == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Result.m248constructorimpl(objWithTimeout);
        }
    }

    protected abstract Object zzd(String str, Continuation continuation);

    /* JADX WARN: Code duplicated, block: B:38:0x00b2 A[PHI: r9 r10 r12
  0x00b2: PHI (r9v12 com.google.android.recaptcha.internal.zzen) = (r9v8 com.google.android.recaptcha.internal.zzen), (r9v20 com.google.android.recaptcha.internal.zzen) binds: [B:37:0x00b0, B:16:0x003d] A[DONT_GENERATE, DONT_INLINE]
  0x00b2: PHI (r10v5 com.google.android.recaptcha.internal.zze) = (r10v2 com.google.android.recaptcha.internal.zze), (r10v14 com.google.android.recaptcha.internal.zze) binds: [B:37:0x00b0, B:16:0x003d] A[DONT_GENERATE, DONT_INLINE]
  0x00b2: PHI (r12v8 java.lang.Object) = (r12v5 java.lang.Object), (r12v1 java.lang.Object) binds: [B:37:0x00b0, B:16:0x003d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:40:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:43:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object zze(long j, zzsc zzscVar, Continuation continuation) throws zzbd {
        zzc zzcVar;
        Exception e;
        zze zzeVar;
        zzen zzenVar;
        zzbd zzbdVar;
        zzbd zzbdVar2;
        if (continuation instanceof zzc) {
            zzcVar = (zzc) continuation;
            int i = zzcVar.zzd;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzcVar.zzd = i - Integer.MIN_VALUE;
            } else {
                zzcVar = new zzc(this, continuation);
            }
        } else {
            zzcVar = new zzc(this, continuation);
        }
        Object objZzj = zzcVar.zzb;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzcVar.zzd;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objZzj);
            zzen zzenVarZzb = zzb();
            if (this.zza) {
                zzenVarZzb.zza();
                Result.Companion companion = Result.INSTANCE;
                return Result.m248constructorimpl(Unit.INSTANCE);
            }
            try {
                zzd zzdVar = new zzd(this, zzscVar, null);
                zzcVar.zza = this;
                zzcVar.zze = zzenVarZzb;
                zzcVar.zzd = 1;
                Object objWithTimeout = TimeoutKt.withTimeout(j, zzdVar, zzcVar);
                if (objWithTimeout != coroutine_suspended) {
                    zzeVar = this;
                    objZzj = objWithTimeout;
                    zzenVar = zzenVarZzb;
                }
            } catch (Exception e2) {
                e = e2;
                zzeVar = this;
                zzenVar = zzenVarZzb;
                zzeVar.zza = false;
                zzcVar.zza = zzeVar;
                zzcVar.zze = zzenVar;
                zzcVar.zzd = 2;
                objZzj = zzeVar.zzj(e, zzcVar);
                if (objZzj != coroutine_suspended) {
                    zzbdVar = (zzbd) objZzj;
                    if (zzenVar != null) {
                        zzenVar.zzb(zzbdVar);
                    }
                    zzcVar.zza = zzbdVar;
                    zzcVar.zze = null;
                    zzcVar.zzd = 3;
                    if (zzeVar.zzg(zzbdVar, zzcVar) != coroutine_suspended) {
                        zzbdVar2 = zzbdVar;
                        Result.Companion companion2 = Result.INSTANCE;
                        return Result.m248constructorimpl(ResultKt.createFailure(zzbdVar2));
                    }
                }
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 == 2) {
                zzenVar = zzcVar.zze;
                zzeVar = (zze) zzcVar.zza;
                ResultKt.throwOnFailure(objZzj);
                zzbdVar = (zzbd) objZzj;
                if (zzenVar != null) {
                    zzenVar.zzb(zzbdVar);
                }
                zzcVar.zza = zzbdVar;
                zzcVar.zze = null;
                zzcVar.zzd = 3;
                if (zzeVar.zzg(zzbdVar, zzcVar) != coroutine_suspended) {
                    zzbdVar2 = zzbdVar;
                }
                return coroutine_suspended;
            }
            if (i2 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            zzbdVar2 = (zzbd) zzcVar.zza;
            ResultKt.throwOnFailure(objZzj);
            Result.Companion companion3 = Result.INSTANCE;
            return Result.m248constructorimpl(ResultKt.createFailure(zzbdVar2));
        }
        zzenVar = zzcVar.zze;
        zzeVar = (zze) zzcVar.zza;
        try {
            ResultKt.throwOnFailure(objZzj);
        } catch (Exception e3) {
            e = e3;
            zzeVar.zza = false;
            zzcVar.zza = zzeVar;
            zzcVar.zze = zzenVar;
            zzcVar.zzd = 2;
            objZzj = zzeVar.zzj(e, zzcVar);
            if (objZzj != coroutine_suspended) {
                zzbdVar = (zzbd) objZzj;
                if (zzenVar != null) {
                    zzenVar.zzb(zzbdVar);
                }
                zzcVar.zza = zzbdVar;
                zzcVar.zze = null;
                zzcVar.zzd = 3;
                if (zzeVar.zzg(zzbdVar, zzcVar) != coroutine_suspended) {
                    zzbdVar2 = zzbdVar;
                    Result.Companion companion4 = Result.INSTANCE;
                    return Result.m248constructorimpl(ResultKt.createFailure(zzbdVar2));
                }
            }
            return coroutine_suspended;
        }
        ResultKt.throwOnFailure(((Result) objZzj).getValue());
        Unit unit = Unit.INSTANCE;
        zzeVar.zza = true;
        if (zzenVar != null) {
            zzenVar.zza();
        }
        return Result.m248constructorimpl(unit);
    }

    protected abstract Object zzf(String str, Continuation continuation) throws zzbd;

    protected Object zzg(zzbd zzbdVar, Continuation continuation) {
        return Unit.INSTANCE;
    }

    protected abstract Object zzh(zzsc zzscVar, Continuation continuation) throws zzbd;

    protected Object zzi(String str, long j, Exception exc, Continuation continuation) {
        return Unit.INSTANCE;
    }

    protected Object zzj(Exception exc, Continuation continuation) {
        return zzf.zza(exc, new zzbd(zzbb.zzb, zzba.zzap, exc.getMessage()));
    }

    protected void zzk(zzsr zzsrVar) {
    }

    public final boolean zzl() {
        return this.zza;
    }
}
