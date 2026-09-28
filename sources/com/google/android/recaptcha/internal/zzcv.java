package com.google.android.recaptcha.internal;

import android.app.Application;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.api.ApiException;
import com.google.android.recaptcha.RecaptchaException;
import java.util.UUID;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcv {
    private final Application zza;
    private zzdc zzc;
    private final zzl zze;
    private final Mutex zzb = MutexKt.Mutex$default(false, 1, null);
    private final String zzd = UUID.randomUUID().toString();
    private zzbi zzf = new zzbi();

    public zzcv(Application application) {
        this.zza = application;
        int i = 1;
        this.zze = new zzl(null, i, 0 == true ? 1 : 0);
        int i2 = zzav.zza;
        Application application2 = application;
        zzaw[] zzawVarArr = {new zzaw(915034652, new zzaz(null, 1, null)), new zzaw(915034802, new zzfu()), new zzaw(915034662, new zzbe()), new zzaw(915034909, new zzjd()), new zzaw(915034675, new zzbr("https://www.recaptcha.net/recaptcha/api3")), new zzaw(915034774, new zzex(0 == true ? 1 : 0, i, 0 == true ? 1 : 0)), new zzaw(915034792, new zzfk(true)), new zzaw(Application.class.getName().hashCode(), application), new zzaw(915034663, new zzbf(application2)), new zzaw(915034791, new zzfj()), new zzaw(915034643, new zzbm(application2)), new zzaw(915034775, new zzfa()), new zzaw(915034787, new zzff())};
        for (int i3 = 0; i3 < 13; i3++) {
            zzaw zzawVar = zzawVarArr[i3];
            if (!zzav.zzc.containsKey(Integer.valueOf(zzawVar.zza()))) {
                zzav.zzc.put(Integer.valueOf(zzawVar.zza()), zzawVar);
            }
        }
    }

    public static final /* synthetic */ zzdc zza(zzcv zzcvVar, String str) throws zzbd {
        zzdc zzdcVar = zzcvVar.zzc;
        if (zzdcVar == null) {
            return null;
        }
        if (Intrinsics.areEqual(zzdcVar.zzd(), str)) {
            return zzdcVar;
        }
        throw new zzbd(zzbb.zzd, zzba.zzam, null);
    }

    public static final /* synthetic */ void zzc(zzcv zzcvVar, long j) throws zzbd {
        if (j < 5000) {
            throw new zzbd(zzbb.zzj, zzba.zzI, null);
        }
        if (ContextCompat.checkSelfPermission(zzcvVar.zza, "android.permission.INTERNET") != 0) {
            throw new zzbd(zzbb.zzc, zzba.zzao, null);
        }
    }

    public static final /* synthetic */ zzcn zze(zzcv zzcvVar, String str, zzbi zzbiVar, zzch zzchVar, zzek zzekVar) {
        zzdt zzdtVar = new zzdt(str, zzbiVar, zzekVar, zzcvVar.zze);
        return Intrinsics.areEqual(zzchVar, zzch.zza) ? new zzef(zzdtVar) : new zzec(zzdtVar, zzbiVar, zzekVar, new zzbo());
    }

    public static /* synthetic */ Object zzh(zzcv zzcvVar, String str, long j, zzcn zzcnVar, zzbi zzbiVar, zzch zzchVar, Continuation continuation, int i, Object obj) throws RecaptchaException, TimeoutCancellationException, ApiException {
        return zzcvVar.zzg(str, (i & 2) != 0 ? 10000L : j, null, (i & 8) != 0 ? zzcvVar.zzf : zzbiVar, (i & 16) != 0 ? zzch.zza : zzchVar, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object zzj(String str, int i, Function2 function2, Continuation continuation) throws RecaptchaException {
        zzcu zzcuVar;
        Exception e;
        zzen zzenVar;
        zzbd e2;
        if (continuation instanceof zzcu) {
            zzcuVar = (zzcu) continuation;
            int i2 = zzcuVar.zzc;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                zzcuVar.zzc = i2 - Integer.MIN_VALUE;
            } else {
                zzcuVar = new zzcu(this, continuation);
            }
        } else {
            zzcuVar = new zzcu(this, continuation);
        }
        Object objInvoke = zzcuVar.zza;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = zzcuVar.zzc;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objInvoke);
            zzek zzekVarZzk = zzk(str, this.zzf, i);
            zzen zzenVarZzf = zzekVarZzk.zzf(6);
            try {
                zzcuVar.zzd = zzenVarZzf;
                zzcuVar.zzc = 1;
                objInvoke = function2.invoke(zzekVarZzk, zzcuVar);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                zzenVar = zzenVarZzf;
            } catch (zzbd e3) {
                e2 = e3;
                zzenVar = zzenVarZzf;
                zzenVar.zzb(e2);
                throw e2.zzc();
            } catch (Exception e4) {
                e = e4;
                zzenVar = zzenVarZzf;
                zzbd zzbdVar = new zzbd(zzbb.zzb, zzba.zza, e.getMessage());
                zzenVar.zzb(zzbdVar);
                throw zzbdVar.zzc();
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            zzenVar = zzcuVar.zzd;
            try {
                ResultKt.throwOnFailure(objInvoke);
            } catch (zzbd e5) {
                e2 = e5;
                zzenVar.zzb(e2);
                throw e2.zzc();
            } catch (Exception e6) {
                e = e6;
                zzbd zzbdVar2 = new zzbd(zzbb.zzb, zzba.zza, e.getMessage());
                zzenVar.zzb(zzbdVar2);
                throw zzbdVar2.zzc();
            }
        }
        zzenVar.zza();
        return objInvoke;
    }

    private final zzek zzk(String str, zzbi zzbiVar, int i) {
        String string = UUID.randomUUID().toString();
        int i2 = zzav.zza;
        zzes zzesVar = new zzes(this.zza, new zzeu(((zzbr) LazyKt.lazy(zzcr.zza).getValue()).zzc()), zzbiVar.zza());
        zzek zzekVar = new zzek(str, this.zzd, string, i, this.zza, zzesVar, null);
        zzekVar.zzc(string);
        return zzekVar;
    }

    public final zzbi zzd() {
        return this.zzf;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object zzg(String str, long j, zzcn zzcnVar, zzbi zzbiVar, zzch zzchVar, Continuation continuation) throws Throwable {
        zzcs zzcsVar;
        String str2;
        Mutex mutex;
        zzcv zzcvVar;
        zzbi zzbiVar2;
        zzch zzchVar2;
        long j2;
        Object obj;
        Mutex mutex2;
        int i;
        int i2;
        if (continuation instanceof zzcs) {
            zzcsVar = (zzcs) continuation;
            int i3 = zzcsVar.zzg;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                zzcsVar.zzg = i3 - Integer.MIN_VALUE;
            } else {
                zzcsVar = new zzcs(this, continuation);
            }
        } else {
            zzcsVar = new zzcs(this, continuation);
        }
        Object objZzj = zzcsVar.zze;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = zzcsVar.zzg;
        try {
            try {
                if (i4 == 0) {
                    ResultKt.throwOnFailure(objZzj);
                    Mutex mutex3 = this.zzb;
                    zzcsVar.zza = this;
                    str2 = str;
                    zzcsVar.zzh = str2;
                    zzcsVar.zzb = null;
                    zzcsVar.zzj = zzbiVar;
                    zzcsVar.zzi = zzchVar;
                    zzcsVar.zzc = mutex3;
                    zzcsVar.zzd = j;
                    zzcsVar.zzg = 1;
                    if (mutex3.lock(null, zzcsVar) != coroutine_suspended) {
                        mutex = mutex3;
                        zzcvVar = this;
                        zzbiVar2 = zzbiVar;
                        zzchVar2 = zzchVar;
                        j2 = j;
                    }
                    return coroutine_suspended;
                }
                if (i4 != 1) {
                    if (i4 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mutex2 = (Mutex) zzcsVar.zza;
                    try {
                        ResultKt.throwOnFailure(objZzj);
                        obj = null;
                        try {
                            zzdc zzdcVar = (zzdc) objZzj;
                            mutex2.unlock(obj);
                            return zzdcVar;
                        } catch (Throwable th) {
                            th = th;
                            mutex2.unlock(obj);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        obj = null;
                        mutex2.unlock(obj);
                        throw th;
                    }
                }
                long j3 = zzcsVar.zzd;
                Mutex mutex4 = (Mutex) zzcsVar.zzc;
                zzch zzchVar3 = zzcsVar.zzi;
                zzbi zzbiVar3 = zzcsVar.zzj;
                Object obj2 = zzcsVar.zzb;
                String str3 = zzcsVar.zzh;
                zzcv zzcvVar2 = (zzcv) zzcsVar.zza;
                ResultKt.throwOnFailure(objZzj);
                zzchVar2 = zzchVar3;
                zzbiVar2 = zzbiVar3;
                zzcvVar = zzcvVar2;
                mutex = mutex4;
                str2 = str3;
                j2 = j3;
                if (!Intrinsics.areEqual(zzchVar2, zzch.zza)) {
                    if (Intrinsics.areEqual(zzchVar2, zzch.zzb)) {
                        i2 = 4;
                    } else {
                        i = 2;
                    }
                    int i5 = i;
                    obj = null;
                    zzct zzctVar = new zzct(zzcvVar, str2, j2, null, zzbiVar2, zzchVar2, null);
                    zzcsVar.zza = mutex;
                    zzcsVar.zzh = null;
                    zzcsVar.zzb = null;
                    zzcsVar.zzj = null;
                    zzcsVar.zzi = null;
                    zzcsVar.zzc = null;
                    zzcsVar.zzg = 2;
                    objZzj = zzcvVar.zzj(str2, i5, zzctVar, zzcsVar);
                    if (objZzj != coroutine_suspended) {
                        mutex2 = mutex;
                        zzdc zzdcVar2 = (zzdc) objZzj;
                        mutex2.unlock(obj);
                        return zzdcVar2;
                    }
                    return coroutine_suspended;
                }
                i2 = 3;
                zzct zzctVar2 = new zzct(zzcvVar, str2, j2, null, zzbiVar2, zzchVar2, null);
                zzcsVar.zza = mutex;
                zzcsVar.zzh = null;
                zzcsVar.zzb = null;
                zzcsVar.zzj = null;
                zzcsVar.zzi = null;
                zzcsVar.zzc = null;
                zzcsVar.zzg = 2;
                objZzj = zzcvVar.zzj(str2, i5, zzctVar2, zzcsVar);
                if (objZzj != coroutine_suspended) {
                    mutex2 = mutex;
                    zzdc zzdcVar3 = (zzdc) objZzj;
                    mutex2.unlock(obj);
                    return zzdcVar3;
                }
                return coroutine_suspended;
            } catch (Throwable th3) {
                th = th3;
                mutex2 = mutex;
                mutex2.unlock(obj);
                throw th;
            }
            i = i2;
            int i6 = i;
            obj = null;
        } catch (Throwable th4) {
            th = th4;
            obj = null;
        }
    }
}
