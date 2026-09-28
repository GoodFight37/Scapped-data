package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.unity.androidnotifications.UnityNotificationManager;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzmo extends zzg {
    protected zzmh zza;
    private volatile zzmh zzb;
    private volatile zzmh zzc;
    private final Map zzd;
    private com.google.android.gms.internal.measurement.zzdj zze;
    private volatile boolean zzf;
    private volatile zzmh zzg;
    private zzmh zzh;
    private boolean zzi;
    private final Object zzj;

    public zzmo(zzio zzioVar) {
        super(zzioVar);
        this.zzj = new Object();
        this.zzd = new ConcurrentHashMap();
    }

    private final void zzA(String str, zzmh zzmhVar, boolean z) {
        zzmh zzmhVar2;
        zzmh zzmhVar3 = this.zzb == null ? this.zzc : this.zzb;
        if (zzmhVar.zzb == null) {
            zzmhVar2 = new zzmh(zzmhVar.zza, str != null ? zzl(str, "Activity") : null, zzmhVar.zzc, zzmhVar.zze, zzmhVar.zzf);
        } else {
            zzmhVar2 = zzmhVar;
        }
        this.zzc = this.zzb;
        this.zzb = zzmhVar2;
        zzio zzioVar = this.zzu;
        zzioVar.zzaX().zzq(new zzmj(this, zzmhVar2, zzmhVar3, zzioVar.zzaU().elapsedRealtime(), z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:12:0x002f  */
    public final void zzB(zzmh zzmhVar, zzmh zzmhVar2, long j, boolean z, Bundle bundle) {
        boolean z2;
        long j2;
        zzg();
        boolean z3 = false;
        if (zzmhVar2 != null) {
            if (zzmhVar2.zzc == zzmhVar.zzc && Objects.equals(zzmhVar2.zzb, zzmhVar.zzb) && Objects.equals(zzmhVar2.zza, zzmhVar.zza)) {
                z2 = false;
            } else {
                z2 = true;
            }
        } else {
            z2 = true;
        }
        if (z && this.zza != null) {
            z3 = true;
        }
        if (z2) {
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            zzqf.zzN(zzmhVar, bundle2, true);
            if (zzmhVar2 != null) {
                String str = zzmhVar2.zza;
                if (str != null) {
                    bundle2.putString("_pn", str);
                }
                String str2 = zzmhVar2.zzb;
                if (str2 != null) {
                    bundle2.putString("_pc", str2);
                }
                bundle2.putLong("_pi", zzmhVar2.zzc);
            }
            if (z3) {
                zzon zzonVar = this.zzu.zzv().zzb;
                long j3 = j - zzonVar.zzb;
                zzonVar.zzb = j;
                if (j3 > 0) {
                    this.zzu.zzw().zzL(bundle2, j3);
                }
            }
            zzio zzioVar = this.zzu;
            if (!zzioVar.zzf().zzz()) {
                bundle2.putLong("_mst", 1L);
            }
            boolean z4 = zzmhVar.zze;
            String str3 = true != z4 ? DebugKt.DEBUG_PROPERTY_VALUE_AUTO : "app";
            long jCurrentTimeMillis = zzioVar.zzaU().currentTimeMillis();
            if (z4) {
                long j4 = zzmhVar.zzf;
                if (j4 != 0) {
                    j2 = j4;
                }
                this.zzu.zzq().zzS(str3, "_vs", j2, bundle2);
            }
            j2 = jCurrentTimeMillis;
            this.zzu.zzq().zzS(str3, "_vs", j2, bundle2);
        }
        if (z3) {
            zzC(this.zza, true, j);
        }
        this.zza = zzmhVar;
        if (zzmhVar.zze) {
            this.zzh = zzmhVar;
        }
        this.zzu.zzu().zzS(zzmhVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzC(zzmh zzmhVar, boolean z, long j) {
        zzio zzioVar = this.zzu;
        zzio zzioVar2 = this.zzu;
        zzioVar2.zzd().zzf(zzioVar.zzaU().elapsedRealtime());
        if (!zzioVar2.zzv().zzb.zzd(zzmhVar != null && zzmhVar.zzd, z, j) || zzmhVar == null) {
            return;
        }
        zzmhVar.zzd = false;
    }

    static /* bridge */ /* synthetic */ void zzq(zzmo zzmoVar, Bundle bundle, zzmh zzmhVar, zzmh zzmhVar2, long j) {
        bundle.remove(FirebaseAnalytics.Param.SCREEN_NAME);
        bundle.remove(FirebaseAnalytics.Param.SCREEN_CLASS);
        zzmoVar.zzB(zzmhVar, zzmhVar2, j, true, zzmoVar.zzu.zzw().zzA(null, FirebaseAnalytics.Event.SCREEN_VIEW, bundle, null, false));
    }

    private final zzmh zzz(com.google.android.gms.internal.measurement.zzdj zzdjVar) {
        Preconditions.checkNotNull(zzdjVar);
        Integer numValueOf = Integer.valueOf(zzdjVar.zza);
        Map map = this.zzd;
        zzmh zzmhVar = (zzmh) map.get(numValueOf);
        if (zzmhVar == null) {
            zzmh zzmhVar2 = new zzmh(null, zzl(zzdjVar.zzb, "Activity"), this.zzu.zzw().zzs());
            map.put(numValueOf, zzmhVar2);
            zzmhVar = zzmhVar2;
        }
        return this.zzg != null ? this.zzg : zzmhVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zzf() {
        return false;
    }

    public final zzmh zzi() {
        return this.zzb;
    }

    public final zzmh zzj(boolean z) {
        zza();
        zzg();
        if (!z) {
            return this.zza;
        }
        zzmh zzmhVar = this.zza;
        return zzmhVar != null ? zzmhVar : this.zzh;
    }

    final String zzl(String str, String str2) {
        if (str == null) {
            return "Activity";
        }
        String[] strArrSplit = str.split("\\.");
        int length = strArrSplit.length;
        String str3 = length > 0 ? strArrSplit[length - 1] : "";
        zzio zzioVar = this.zzu;
        return str3.length() > zzioVar.zzf().zzc(null, false) ? str3.substring(0, zzioVar.zzf().zzc(null, false)) : str3;
    }

    public final void zzs(com.google.android.gms.internal.measurement.zzdj zzdjVar, Bundle bundle) {
        Bundle bundle2;
        if (!this.zzu.zzf().zzz() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.zzd.put(Integer.valueOf(zzdjVar.zza), new zzmh(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME), bundle2.getString("referrer_name"), bundle2.getLong(UnityNotificationManager.KEY_ID)));
    }

    public final void zzt(com.google.android.gms.internal.measurement.zzdj zzdjVar) {
        synchronized (this.zzj) {
            if (Objects.equals(this.zze, zzdjVar)) {
                this.zze = null;
            }
        }
        if (this.zzu.zzf().zzz()) {
            this.zzd.remove(Integer.valueOf(zzdjVar.zza));
        }
    }

    public final void zzu(com.google.android.gms.internal.measurement.zzdj zzdjVar) {
        synchronized (this.zzj) {
            this.zzi = false;
            this.zzf = true;
        }
        zzio zzioVar = this.zzu;
        long jElapsedRealtime = zzioVar.zzaU().elapsedRealtime();
        if (!zzioVar.zzf().zzz()) {
            this.zzb = null;
            zzioVar.zzaX().zzq(new zzml(this, jElapsedRealtime));
        } else {
            zzmh zzmhVarZzz = zzz(zzdjVar);
            this.zzc = this.zzb;
            this.zzb = null;
            zzioVar.zzaX().zzq(new zzmm(this, zzmhVarZzz, jElapsedRealtime));
        }
    }

    public final void zzv(com.google.android.gms.internal.measurement.zzdj zzdjVar) {
        Object obj = this.zzj;
        synchronized (obj) {
            this.zzi = true;
            if (!Objects.equals(zzdjVar, this.zze)) {
                synchronized (obj) {
                    this.zze = zzdjVar;
                    this.zzf = false;
                    zzio zzioVar = this.zzu;
                    if (zzioVar.zzf().zzz()) {
                        this.zzg = null;
                        zzioVar.zzaX().zzq(new zzmn(this));
                    }
                }
            }
        }
        zzio zzioVar2 = this.zzu;
        if (!zzioVar2.zzf().zzz()) {
            this.zzb = this.zzg;
            zzioVar2.zzaX().zzq(new zzmk(this));
            return;
        }
        zzA(zzdjVar.zzb, zzz(zzdjVar), false);
        zzd zzdVarZzd = this.zzu.zzd();
        zzio zzioVar3 = zzdVarZzd.zzu;
        zzioVar3.zzaX().zzq(new zzc(zzdVarZzd, zzioVar3.zzaU().elapsedRealtime()));
    }

    public final void zzw(com.google.android.gms.internal.measurement.zzdj zzdjVar, Bundle bundle) {
        zzmh zzmhVar;
        if (!this.zzu.zzf().zzz() || bundle == null || (zzmhVar = (zzmh) this.zzd.get(Integer.valueOf(zzdjVar.zza))) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong(UnityNotificationManager.KEY_ID, zzmhVar.zzc);
        bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.NAME, zzmhVar.zza);
        bundle2.putString("referrer_name", zzmhVar.zzb);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    @Deprecated
    public final void zzx(com.google.android.gms.internal.measurement.zzdj zzdjVar, String str, String str2) {
        zzio zzioVar = this.zzu;
        if (!zzioVar.zzf().zzz()) {
            zzioVar.zzaW().zzl().zza("setCurrentScreen cannot be called while screen reporting is disabled.");
            return;
        }
        zzmh zzmhVar = this.zzb;
        if (zzmhVar == null) {
            zzioVar.zzaW().zzl().zza("setCurrentScreen cannot be called while no activity active");
            return;
        }
        Map map = this.zzd;
        Integer numValueOf = Integer.valueOf(zzdjVar.zza);
        if (map.get(numValueOf) == null) {
            zzioVar.zzaW().zzl().zza("setCurrentScreen must be called with an activity in the activity lifecycle");
            return;
        }
        if (str2 == null) {
            str2 = zzl(zzdjVar.zzb, "Activity");
        }
        String str3 = zzmhVar.zzb;
        String str4 = zzmhVar.zza;
        boolean zEquals = Objects.equals(str3, str2);
        boolean zEquals2 = Objects.equals(str4, str);
        if (zEquals && zEquals2) {
            zzioVar.zzaW().zzl().zza("setCurrentScreen cannot be called with the same class and name");
            return;
        }
        if (str != null && (str.length() <= 0 || str.length() > zzioVar.zzf().zzc(null, false))) {
            zzioVar.zzaW().zzl().zzb("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            return;
        }
        if (str2 != null && (str2.length() <= 0 || str2.length() > zzioVar.zzf().zzc(null, false))) {
            zzioVar.zzaW().zzl().zzb("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            return;
        }
        zzioVar.zzaW().zzj().zzc("Setting current screen to name, class", str == null ? "null" : str, str2);
        zzmh zzmhVar2 = new zzmh(str, str2, zzioVar.zzw().zzs());
        map.put(numValueOf, zzmhVar2);
        zzA(zzdjVar.zzb, zzmhVar2, true);
    }

    public final void zzy(Bundle bundle, long j) {
        synchronized (this.zzj) {
            if (!this.zzi) {
                this.zzu.zzaW().zzl().zza("Cannot log screen view event when the app is in the background.");
                return;
            }
            String string = bundle.getString(FirebaseAnalytics.Param.SCREEN_NAME);
            if (string != null && (string.length() <= 0 || string.length() > this.zzu.zzf().zzc(null, false))) {
                this.zzu.zzaW().zzl().zzb("Invalid screen name length for screen view. Length", Integer.valueOf(string.length()));
                return;
            }
            String string2 = bundle.getString(FirebaseAnalytics.Param.SCREEN_CLASS);
            if (string2 != null && (string2.length() <= 0 || string2.length() > this.zzu.zzf().zzc(null, false))) {
                this.zzu.zzaW().zzl().zzb("Invalid screen class length for screen view. Length", Integer.valueOf(string2.length()));
                return;
            }
            if (string2 == null) {
                com.google.android.gms.internal.measurement.zzdj zzdjVar = this.zze;
                string2 = zzdjVar != null ? zzl(zzdjVar.zzb, "Activity") : "Activity";
            }
            zzmh zzmhVar = this.zzb;
            if (this.zzf && zzmhVar != null) {
                this.zzf = false;
                boolean zEquals = Objects.equals(zzmhVar.zzb, string2);
                boolean zEquals2 = Objects.equals(zzmhVar.zza, string);
                if (zEquals && zEquals2) {
                    this.zzu.zzaW().zzl().zza("Ignoring call to log screen view event with duplicate parameters.");
                    return;
                }
            }
            zzio zzioVar = this.zzu;
            zzioVar.zzaW().zzj().zzc("Logging screen view with name, class", string == null ? "null" : string, string2 == null ? "null" : string2);
            zzmh zzmhVar2 = this.zzb == null ? this.zzc : this.zzb;
            zzmh zzmhVar3 = new zzmh(string, string2, zzioVar.zzw().zzs(), true, j);
            this.zzb = zzmhVar3;
            this.zzc = zzmhVar2;
            this.zzg = zzmhVar3;
            zzioVar.zzaX().zzq(new zzmi(this, bundle, zzmhVar3, zzmhVar2, zzioVar.zzaU().elapsedRealtime()));
        }
    }
}
