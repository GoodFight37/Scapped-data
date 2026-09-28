package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.RecaptchaAction;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzef implements zzcn {
    private final zzdt zza;
    private zzcm zzb = zzcm.zza;
    private zzsc zzc;

    public zzef(zzdt zzdtVar) {
        this.zza = zzdtVar;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    @Override // com.google.android.recaptcha.internal.zzcn
    public final Object zza(String str, RecaptchaAction recaptchaAction, long j, Continuation continuation) throws zzbd {
        zzed zzedVar;
        RecaptchaAction recaptchaAction2;
        double d;
        zzef zzefVar;
        zzef zzefVar2;
        String str2 = str;
        if (continuation instanceof zzed) {
            zzedVar = (zzed) continuation;
            int i = zzedVar.zzd;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzedVar.zzd = i - Integer.MIN_VALUE;
            } else {
                zzedVar = new zzed(this, continuation);
            }
        } else {
            zzedVar = new zzed(this, continuation);
        }
        zzed zzedVar2 = zzedVar;
        Object objZzl = zzedVar2.zzb;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzedVar2.zzd;
        try {
            if (i2 != 0) {
                if (i2 == 1) {
                    double d2 = zzedVar2.zza;
                    RecaptchaAction recaptchaAction3 = zzedVar2.zzg;
                    String str3 = zzedVar2.zzf;
                    zzef zzefVar3 = zzedVar2.zze;
                    ResultKt.throwOnFailure(objZzl);
                    d = d2;
                    zzefVar = zzefVar3;
                    recaptchaAction2 = recaptchaAction3;
                    str2 = str3;
                } else {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    str2 = zzedVar2.zzf;
                    zzefVar2 = zzedVar2.zze;
                    ResultKt.throwOnFailure(objZzl);
                }
                zzsr zzsrVar = (zzsr) objZzl;
                zzefVar2.zza.zzq(str2, zzsrVar);
                return zzsrVar.zzj();
            }
            ResultKt.throwOnFailure(objZzl);
            if (!Intrinsics.areEqual(this.zzb, zzcm.zzb)) {
                throw new zzbd(zzbb.zzb, zzba.zzar, null);
            }
            double d3 = j;
            zzdt zzdtVar = this.zza;
            double d4 = 0.45d * d3;
            zzedVar2.zze = this;
            zzedVar2.zzf = str2;
            recaptchaAction2 = recaptchaAction;
            zzedVar2.zzg = recaptchaAction2;
            double d5 = d3 * 0.55d;
            zzedVar2.zza = d5;
            zzedVar2.zzd = 1;
            objZzl = zzdtVar.zzl(str2, (long) d4, zzedVar2);
            if (objZzl != coroutine_suspended) {
                d = d5;
                zzefVar = this;
            }
            return coroutine_suspended;
            zzsi zzsiVar = (zzsi) objZzl;
            zzdt zzdtVar2 = zzefVar.zza;
            zzsc zzscVar = zzefVar.zzc;
            if (zzscVar == null) {
                zzscVar = null;
            }
            zzsp zzspVarZzi = zzdtVar2.zzi(recaptchaAction2, zzsiVar, zzscVar);
            zzedVar2.zze = zzefVar;
            zzedVar2.zzf = str2;
            zzedVar2.zzg = null;
            zzedVar2.zzd = 2;
            objZzl = zzefVar.zza.zzm(zzspVarZzi, str2, (long) d, zzedVar2);
            if (objZzl != coroutine_suspended) {
                zzefVar2 = zzefVar;
                zzsr zzsrVar2 = (zzsr) objZzl;
                zzefVar2.zza.zzq(str2, zzsrVar2);
                return zzsrVar2.zzj();
            }
            return coroutine_suspended;
        } catch (zzbd e) {
            throw e;
        } catch (Exception e2) {
            throw new zzbd(zzbb.zzb, zzba.zzaz, e2.getMessage());
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a1, code lost:
    
        if (r12 != r1) goto L35;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v10, types: [com.google.android.recaptcha.internal.zzef] */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18 */
    @Override // com.google.android.recaptcha.internal.zzcn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzb(long r11, kotlin.coroutines.Continuation r13) throws com.google.android.recaptcha.internal.zzbd {
        /*
            r10 = this;
            boolean r0 = r13 instanceof com.google.android.recaptcha.internal.zzee
            if (r0 == 0) goto L13
            r0 = r13
            com.google.android.recaptcha.internal.zzee r0 = (com.google.android.recaptcha.internal.zzee) r0
            int r1 = r0.zzd
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzd = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzee r0 = new com.google.android.recaptcha.internal.zzee
            r0.<init>(r10, r13)
        L18:
            java.lang.Object r13 = r0.zzb
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzd
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4f
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            com.google.android.recaptcha.internal.zzef r11 = r0.zze
            r12 = r11
            com.google.android.recaptcha.internal.zzef r12 = (com.google.android.recaptcha.internal.zzef) r12
            kotlin.ResultKt.throwOnFailure(r13)     // Catch: com.google.android.recaptcha.internal.zzbd -> L32
            goto La3
        L32:
            r12 = move-exception
            goto Lb2
        L35:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L3d:
            double r11 = r0.zza
            com.google.android.recaptcha.internal.zzef r2 = r0.zze
            r4 = r2
            com.google.android.recaptcha.internal.zzef r4 = (com.google.android.recaptcha.internal.zzef) r4
            kotlin.ResultKt.throwOnFailure(r13)     // Catch: com.google.android.recaptcha.internal.zzbd -> L4c
            r9 = r2
            r2 = r13
            r12 = r11
            r11 = r9
            goto L92
        L4c:
            r12 = move-exception
            r11 = r2
            goto Lb2
        L4f:
            kotlin.ResultKt.throwOnFailure(r13)
            com.google.android.recaptcha.internal.zzcm r13 = r10.zzb
            com.google.android.recaptcha.internal.zzcj r2 = com.google.android.recaptcha.internal.zzcm.zzb()
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual(r13, r2)
            if (r13 != 0) goto Lbb
            com.google.android.recaptcha.internal.zzcm r13 = r10.zzb
            com.google.android.recaptcha.internal.zzci r2 = com.google.android.recaptcha.internal.zzcm.zza()
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual(r13, r2)
            if (r13 == 0) goto L6b
            goto Lbb
        L6b:
            com.google.android.recaptcha.internal.zzck r13 = com.google.android.recaptcha.internal.zzcm.zzc()
            com.google.android.recaptcha.internal.zzcm r13 = (com.google.android.recaptcha.internal.zzcm) r13
            r10.zzb = r13
            double r11 = (double) r11
            com.google.android.recaptcha.internal.zzdt r13 = r10.zza     // Catch: com.google.android.recaptcha.internal.zzbd -> Laf
            r5 = 4603579539098121011(0x3fe3333333333333, double:0.6)
            double r5 = r5 * r11
            r0.zze = r10     // Catch: com.google.android.recaptcha.internal.zzbd -> Laf
            r7 = 4600877379321698714(0x3fd999999999999a, double:0.4)
            double r11 = r11 * r7
            r0.zza = r11     // Catch: com.google.android.recaptcha.internal.zzbd -> Laf
            r0.zzd = r4     // Catch: com.google.android.recaptcha.internal.zzbd -> Laf
            long r4 = (long) r5     // Catch: com.google.android.recaptcha.internal.zzbd -> Laf
            java.lang.Object r13 = r13.zzo(r4, r0)     // Catch: com.google.android.recaptcha.internal.zzbd -> Laf
            if (r13 == r1) goto Lae
            r2 = r13
            r12 = r11
            r11 = r10
        L92:
            com.google.android.recaptcha.internal.zzsc r2 = (com.google.android.recaptcha.internal.zzsc) r2     // Catch: com.google.android.recaptcha.internal.zzbd -> L32
            r11.zzc = r2     // Catch: com.google.android.recaptcha.internal.zzbd -> L32
            com.google.android.recaptcha.internal.zzdt r4 = r11.zza     // Catch: com.google.android.recaptcha.internal.zzbd -> L32
            long r12 = (long) r12     // Catch: com.google.android.recaptcha.internal.zzbd -> L32
            r0.zze = r11     // Catch: com.google.android.recaptcha.internal.zzbd -> L32
            r0.zzd = r3     // Catch: com.google.android.recaptcha.internal.zzbd -> L32
            java.lang.Object r12 = r4.zzn(r2, r12, r0)     // Catch: com.google.android.recaptcha.internal.zzbd -> L32
            if (r12 == r1) goto Lae
        La3:
            com.google.android.recaptcha.internal.zzcj r12 = com.google.android.recaptcha.internal.zzcm.zzb()     // Catch: com.google.android.recaptcha.internal.zzbd -> L32
            com.google.android.recaptcha.internal.zzcm r12 = (com.google.android.recaptcha.internal.zzcm) r12     // Catch: com.google.android.recaptcha.internal.zzbd -> L32
            r11.zzb = r12     // Catch: com.google.android.recaptcha.internal.zzbd -> L32
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        Lae:
            return r1
        Laf:
            r11 = move-exception
            r12 = r11
            r11 = r10
        Lb2:
            com.google.android.recaptcha.internal.zzci r13 = com.google.android.recaptcha.internal.zzcm.zza()
            com.google.android.recaptcha.internal.zzcm r13 = (com.google.android.recaptcha.internal.zzcm) r13
            r11.zzb = r13
            throw r12
        Lbb:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzef.zzb(long, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
