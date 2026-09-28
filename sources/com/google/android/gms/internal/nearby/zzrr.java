package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.nearby.uwb.RangingMeasurement;
import com.google.android.gms.nearby.uwb.RangingPosition;
import com.google.android.gms.nearby.uwb.RangingSessionCallback;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzrr extends zzox {
    final /* synthetic */ zzrs zza;
    private final ListenerHolder zzb;
    private final RangingSessionCallback zzc;

    zzrr(zzrs zzrsVar, RangingSessionCallback rangingSessionCallback) {
        this.zza = zzrsVar;
        this.zzb = zzrsVar.registerListener(rangingSessionCallback, RangingSessionCallback.class.getName());
        this.zzc = rangingSessionCallback;
    }

    static /* bridge */ /* synthetic */ RangingPosition zzb(zzrr zzrrVar, zzqa zzqaVar) {
        return new RangingPosition(zzi(zzqaVar.zzd()), zzqaVar.zzc() != null ? zzi(zzqaVar.zzc()) : null, zzqaVar.zze() != null ? zzi(zzqaVar.zze()) : null, zzqaVar.zzb(), zzqaVar.zza());
    }

    private static final RangingMeasurement zzi(zzpu zzpuVar) {
        return new RangingMeasurement(zzpuVar.zzb(), zzpuVar.zza());
    }

    @Override // com.google.android.gms.internal.nearby.zzoy
    public final void zzd(final zzpm zzpmVar) {
        int i = zzrs.zza;
        final Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.nearby.zzrl
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzh(zzpmVar);
            }
        };
        this.zza.doRegisterEventListener(RegistrationMethods.builder().register(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzrm
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                runnable.run();
                ((TaskCompletionSource) obj2).setResult(null);
            }
        }).unregister(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzrn
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                ((TaskCompletionSource) obj2).setResult(null);
            }
        }).withHolder(this.zzb).setFeatures(com.google.android.gms.nearby.zza.zzM).setMethodKey(1304).build());
    }

    @Override // com.google.android.gms.internal.nearby.zzoy
    public final void zze(zzpo zzpoVar) {
        int i = zzrs.zza;
        this.zzb.notifyListener(new zzrp(this, zzpoVar));
    }

    @Override // com.google.android.gms.internal.nearby.zzoy
    public final void zzf(zzpq zzpqVar) {
        int i = zzrs.zza;
        this.zzb.notifyListener(new zzrq(this, zzpqVar));
    }

    final /* synthetic */ void zzh(zzpm zzpmVar) {
        this.zzb.notifyListener(new zzro(this, zzpmVar));
    }
}
