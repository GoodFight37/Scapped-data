package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.InstantApps;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzqr;
import com.google.android.gms.internal.measurement.zzrp;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzgs extends zzg {
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private String zze;
    private long zzf;
    private final long zzg;
    private final long zzh;
    private List zzi;
    private String zzj;
    private int zzk;
    private String zzl;
    private String zzm;
    private String zzn;
    private long zzo;
    private String zzp;

    zzgs(zzio zzioVar, long j, long j2) {
        super(zzioVar);
        this.zzo = 0L;
        this.zzp = null;
        this.zzg = j;
        this.zzh = j2;
    }

    /* JADX WARN: Code duplicated, block: B:106:0x0253 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:28:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:33:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:36:0x00f2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:37:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:39:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:41:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:43:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:45:0x0100  */
    /* JADX WARN: Code duplicated, block: B:47:0x0104  */
    /* JADX WARN: Code duplicated, block: B:48:0x011f  */
    /* JADX WARN: Code duplicated, block: B:49:0x012d  */
    /* JADX WARN: Code duplicated, block: B:50:0x013b  */
    /* JADX WARN: Code duplicated, block: B:51:0x0149  */
    /* JADX WARN: Code duplicated, block: B:52:0x0157  */
    /* JADX WARN: Code duplicated, block: B:53:0x0165  */
    /* JADX WARN: Code duplicated, block: B:54:0x0173  */
    /* JADX WARN: Code duplicated, block: B:57:0x0189  */
    /* JADX WARN: Code duplicated, block: B:60:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:61:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:68:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:69:0x01cf A[Catch: IllegalStateException -> 0x01fa, TryCatch #2 {IllegalStateException -> 0x01fa, blocks: (B:58:0x018f, B:62:0x01a5, B:64:0x01b3, B:66:0x01b9, B:70:0x01d3, B:69:0x01cf, B:72:0x01dd, B:74:0x01f1, B:76:0x01f6, B:75:0x01f4), top: B:102:0x018f }] */
    /* JADX WARN: Code duplicated, block: B:72:0x01dd A[Catch: IllegalStateException -> 0x01fa, TryCatch #2 {IllegalStateException -> 0x01fa, blocks: (B:58:0x018f, B:62:0x01a5, B:64:0x01b3, B:66:0x01b9, B:70:0x01d3, B:69:0x01cf, B:72:0x01dd, B:74:0x01f1, B:76:0x01f6, B:75:0x01f4), top: B:102:0x018f }] */
    /* JADX WARN: Code duplicated, block: B:74:0x01f1 A[Catch: IllegalStateException -> 0x01fa, TryCatch #2 {IllegalStateException -> 0x01fa, blocks: (B:58:0x018f, B:62:0x01a5, B:64:0x01b3, B:66:0x01b9, B:70:0x01d3, B:69:0x01cf, B:72:0x01dd, B:74:0x01f1, B:76:0x01f6, B:75:0x01f4), top: B:102:0x018f }] */
    /* JADX WARN: Code duplicated, block: B:75:0x01f4 A[Catch: IllegalStateException -> 0x01fa, TryCatch #2 {IllegalStateException -> 0x01fa, blocks: (B:58:0x018f, B:62:0x01a5, B:64:0x01b3, B:66:0x01b9, B:70:0x01d3, B:69:0x01cf, B:72:0x01dd, B:74:0x01f1, B:76:0x01f6, B:75:0x01f4), top: B:102:0x018f }] */
    /* JADX WARN: Code duplicated, block: B:83:0x0222  */
    /* JADX WARN: Code duplicated, block: B:85:0x0228  */
    /* JADX WARN: Code duplicated, block: B:86:0x0236  */
    /* JADX WARN: Code duplicated, block: B:89:0x0240  */
    /* JADX WARN: Code duplicated, block: B:92:0x0253 A[EDGE_INSN: B:92:0x0253->B:93:0x0255 BREAK  A[LOOP:0: B:87:0x023a->B:108:?]] */
    /* JADX WARN: Code duplicated, block: B:94:0x0257  */
    /* JADX WARN: Code duplicated, block: B:96:0x0262  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.measurement.internal.zzg
    @EnsuresNonNull({"appId", "appStore", "appName", "gmpAppId", "gaAppId"})
    protected final void zzd() {
        String str;
        String string;
        zzio zzioVar;
        byte b;
        zzio zzioVar2;
        int iZza;
        zzio zzioVar3;
        List listZzt;
        Iterator it;
        String strZzc;
        String str2;
        Context contextZzaT;
        String strZzA;
        zzio zzioVar4;
        zzio zzioVar5 = this.zzu;
        zzioVar5.zzaW().zzj().zzc("sdkVersion bundled with app, dynamiteVersion", Long.valueOf(this.zzh), Long.valueOf(this.zzg));
        String packageName = zzioVar5.zzaT().getPackageName();
        PackageManager packageManager = zzioVar5.zzaT().getPackageManager();
        int i = Integer.MIN_VALUE;
        String str3 = "";
        String str4 = "Unknown";
        String installerPackageName = EnvironmentCompat.MEDIA_UNKNOWN;
        try {
            if (packageManager != null) {
                try {
                    installerPackageName = packageManager.getInstallerPackageName(packageName);
                } catch (IllegalArgumentException unused) {
                    this.zzu.zzaW().zze().zzb("Error retrieving app installer package name. appId", zzhe.zzn(packageName));
                }
                if (installerPackageName == null) {
                    installerPackageName = "manual_install";
                } else if ("com.android.vending".equals(installerPackageName)) {
                    installerPackageName = "";
                }
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(this.zzu.zzaT().getPackageName(), 0);
                    if (packageInfo != null) {
                        CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                        string = !TextUtils.isEmpty(applicationLabel) ? applicationLabel.toString() : "Unknown";
                        try {
                            str4 = packageInfo.versionName;
                            i = packageInfo.versionCode;
                        } catch (PackageManager.NameNotFoundException unused2) {
                            str = str4;
                            str4 = string;
                            this.zzu.zzaW().zze().zzc("Error retrieving package info. appId, appName", zzhe.zzn(packageName), str4);
                            string = str4;
                            str4 = str;
                        }
                    }
                } catch (PackageManager.NameNotFoundException unused3) {
                    str = "Unknown";
                }
                this.zza = packageName;
                this.zzd = installerPackageName;
                this.zzb = str4;
                this.zzc = i;
                this.zze = string;
                this.zzf = 0L;
                zzioVar = this.zzu;
                if (zzioVar.zzf().zzx(null, zzgi.zzbp)) {
                    b = false;
                } else {
                    zzioVar4 = this.zzu;
                    if (TextUtils.isEmpty(zzioVar4.zzx()) && "am".equals(zzioVar4.zzy())) {
                        b = true;
                    } else {
                        b = false;
                    }
                }
                zzioVar2 = this.zzu;
                iZza = zzioVar2.zza();
                if (iZza != 0) {
                    zzioVar.zzaW().zzj().zza("App measurement collection enabled");
                } else if (iZza != 1) {
                    zzioVar.zzaW().zzi().zza("App measurement deactivated via the manifest");
                } else if (iZza != 3) {
                    zzioVar.zzaW().zzi().zza("App measurement disabled by setAnalyticsCollectionEnabled(false)");
                } else if (iZza != 4) {
                    zzioVar.zzaW().zzi().zza("App measurement disabled via the manifest");
                } else if (iZza != 6) {
                    zzioVar.zzaW().zzl().zza("App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics");
                } else if (iZza != 7) {
                    zzioVar.zzaW().zzi().zza("App measurement disabled via the global data collection setting");
                } else if (iZza != 8) {
                    zzioVar.zzaW().zzi().zza("App measurement disabled");
                    zzioVar.zzaW().zzh().zza("Invalid scion state in identity");
                } else {
                    zzioVar.zzaW().zzi().zza("App measurement disabled due to denied storage consent");
                }
                this.zzl = "";
                this.zzm = "";
                zzioVar.zzaV();
                if (b != false) {
                    this.zzm = zzioVar2.zzx();
                }
                strZzc = zzmg.zzc(zzioVar.zzaT(), "google_app_id", zzioVar2.zzA());
                if (TextUtils.isEmpty(strZzc)) {
                    str3 = strZzc;
                }
                this.zzl = str3;
                if (!zzioVar.zzf().zzx(null, zzgi.zzbp) && !TextUtils.isEmpty(strZzc)) {
                    contextZzaT = zzioVar.zzaT();
                    strZzA = zzioVar2.zzA();
                    Preconditions.checkNotNull(contextZzaT);
                    Resources resources = contextZzaT.getResources();
                    if (!TextUtils.isEmpty(strZzA)) {
                        strZzA = zzig.zza(contextZzaT);
                    }
                    this.zzm = zzig.zzb("admob_app_id", resources, strZzA);
                }
                if (iZza == 0) {
                    zzhc zzhcVarZzj = zzioVar.zzaW().zzj();
                    String str5 = this.zza;
                    if (TextUtils.isEmpty(this.zzl)) {
                        str2 = this.zzm;
                    } else {
                        str2 = this.zzl;
                    }
                    zzhcVarZzj.zzc("App measurement enabled for app package, google app id", str5, str2);
                }
                this.zzi = null;
                zzioVar3 = this.zzu;
                zzioVar3.zzaV();
                listZzt = zzioVar3.zzf().zzt("analytics.safelisted_events");
                if (listZzt != null) {
                    this.zzi = listZzt;
                    break;
                } else if (listZzt.isEmpty()) {
                    it = listZzt.iterator();
                    do {
                        if (it.hasNext()) {
                            this.zzi = listZzt;
                            break;
                        }
                    } while (zzioVar3.zzw().zzag("safelisted event", (String) it.next()));
                } else {
                    zzioVar3.zzaW().zzl().zza("Safelisted event list is empty. Ignoring");
                }
                if (packageManager != null) {
                    this.zzk = InstantApps.isInstantApp(zzioVar3.zzaT()) ? 1 : 0;
                } else {
                    this.zzk = 0;
                }
            }
            zzioVar5.zzaW().zze().zzb("PackageManager is null, app identity information might be inaccurate. appId", zzhe.zzn(packageName));
            strZzc = zzmg.zzc(zzioVar.zzaT(), "google_app_id", zzioVar2.zzA());
            if (TextUtils.isEmpty(strZzc)) {
                str3 = strZzc;
            }
            this.zzl = str3;
            if (!zzioVar.zzf().zzx(null, zzgi.zzbp)) {
                contextZzaT = zzioVar.zzaT();
                strZzA = zzioVar2.zzA();
                Preconditions.checkNotNull(contextZzaT);
                Resources resources2 = contextZzaT.getResources();
                if (!TextUtils.isEmpty(strZzA)) {
                    strZzA = zzig.zza(contextZzaT);
                }
                this.zzm = zzig.zzb("admob_app_id", resources2, strZzA);
            }
            if (iZza == 0) {
                zzhc zzhcVarZzj2 = zzioVar.zzaW().zzj();
                String str6 = this.zza;
                if (TextUtils.isEmpty(this.zzl)) {
                    str2 = this.zzm;
                } else {
                    str2 = this.zzl;
                }
                zzhcVarZzj2.zzc("App measurement enabled for app package, google app id", str6, str2);
            }
        } catch (IllegalStateException e) {
            this.zzu.zzaW().zze().zzc("Fetching Google App Id failed with exception. appId", zzhe.zzn(packageName), e);
        }
        string = "Unknown";
        this.zza = packageName;
        this.zzd = installerPackageName;
        this.zzb = str4;
        this.zzc = i;
        this.zze = string;
        this.zzf = 0L;
        zzioVar = this.zzu;
        if (zzioVar.zzf().zzx(null, zzgi.zzbp)) {
            zzioVar4 = this.zzu;
            if (TextUtils.isEmpty(zzioVar4.zzx())) {
                b = false;
            } else {
                b = false;
            }
        } else {
            b = false;
        }
        zzioVar2 = this.zzu;
        iZza = zzioVar2.zza();
        if (iZza != 0) {
            zzioVar.zzaW().zzj().zza("App measurement collection enabled");
        } else if (iZza != 1) {
            zzioVar.zzaW().zzi().zza("App measurement deactivated via the manifest");
        } else if (iZza != 3) {
            zzioVar.zzaW().zzi().zza("App measurement disabled by setAnalyticsCollectionEnabled(false)");
        } else if (iZza != 4) {
            zzioVar.zzaW().zzi().zza("App measurement disabled via the manifest");
        } else if (iZza != 6) {
            zzioVar.zzaW().zzl().zza("App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics");
        } else if (iZza != 7) {
            zzioVar.zzaW().zzi().zza("App measurement disabled via the global data collection setting");
        } else if (iZza != 8) {
            zzioVar.zzaW().zzi().zza("App measurement disabled");
            zzioVar.zzaW().zzh().zza("Invalid scion state in identity");
        } else {
            zzioVar.zzaW().zzi().zza("App measurement disabled due to denied storage consent");
        }
        this.zzl = "";
        this.zzm = "";
        zzioVar.zzaV();
        if (b != false) {
            this.zzm = zzioVar2.zzx();
        }
        this.zzi = null;
        zzioVar3 = this.zzu;
        zzioVar3.zzaV();
        listZzt = zzioVar3.zzf().zzt("analytics.safelisted_events");
        if (listZzt != null) {
            this.zzi = listZzt;
            break;
        } else if (listZzt.isEmpty()) {
            it = listZzt.iterator();
            do {
                if (it.hasNext()) {
                    this.zzi = listZzt;
                    break;
                }
            } while (zzioVar3.zzw().zzag("safelisted event", (String) it.next()));
        } else {
            zzioVar3.zzaW().zzl().zza("Safelisted event list is empty. Ignoring");
        }
        if (packageManager != null) {
            this.zzk = InstantApps.isInstantApp(zzioVar3.zzaT()) ? 1 : 0;
        } else {
            this.zzk = 0;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zzf() {
        return true;
    }

    final int zzh() {
        zza();
        return this.zzk;
    }

    final int zzi() {
        zza();
        return this.zzc;
    }

    final long zzj() {
        return this.zzh;
    }

    final zzr zzk(String str) {
        String str2;
        long j;
        int i;
        List list;
        String str3;
        int i2;
        int i3;
        long j2;
        long jZzr;
        zzg();
        String strZzm = zzm();
        String strZzo = zzo();
        zza();
        String str4 = this.zzb;
        zza();
        long j3 = this.zzc;
        zza();
        Preconditions.checkNotNull(this.zzd);
        String str5 = this.zzd;
        zzio zzioVar = this.zzu;
        zzioVar.zzf().zzj();
        zza();
        zzg();
        long j4 = this.zzf;
        if (j4 == 0) {
            zzqf zzqfVarZzw = this.zzu.zzw();
            Context contextZzaT = zzioVar.zzaT();
            String packageName = zzioVar.zzaT().getPackageName();
            zzqfVarZzw.zzg();
            Preconditions.checkNotNull(contextZzaT);
            Preconditions.checkNotEmpty(packageName);
            PackageManager packageManager = contextZzaT.getPackageManager();
            MessageDigest messageDigestZzI = zzqf.zzI();
            if (messageDigestZzI == null) {
                zzqfVarZzw.zzu.zzaW().zze().zza("Could not get MD5 instance");
                j4 = -1;
            } else if (packageManager != null) {
                try {
                    if (zzqfVarZzw.zzam(contextZzaT, packageName)) {
                        jZzr = 0;
                    } else {
                        PackageManagerWrapper packageManagerWrapperPackageManager = Wrappers.packageManager(contextZzaT);
                        zzio zzioVar2 = zzqfVarZzw.zzu;
                        PackageInfo packageInfo = packageManagerWrapperPackageManager.getPackageInfo(zzioVar2.zzaT().getPackageName(), 64);
                        if (packageInfo.signatures == null || packageInfo.signatures.length <= 0) {
                            zzioVar2.zzaW().zzk().zza("Could not get signatures");
                            jZzr = -1;
                        } else {
                            jZzr = zzqf.zzr(messageDigestZzI.digest(packageInfo.signatures[0].toByteArray()));
                        }
                    }
                    j4 = jZzr;
                } catch (PackageManager.NameNotFoundException e) {
                    zzqfVarZzw.zzu.zzaW().zze().zzb("Package name not found", e);
                    j4 = 0;
                }
            } else {
                j4 = 0;
            }
            this.zzf = j4;
        }
        long j5 = j4;
        zzio zzioVar3 = this.zzu;
        zzio zzioVar4 = this.zzu;
        boolean zZzJ = zzioVar3.zzJ();
        boolean z = !zzioVar4.zzm().zzm;
        zzg();
        if (zzioVar3.zzJ()) {
            zzrp.zzb();
            if (zzioVar4.zzf().zzx(null, zzgi.zzaG)) {
                this.zzu.zzaW().zzj().zza("Disabled IID for tests.");
            } else {
                try {
                    Class<?> clsLoadClass = zzioVar4.zzaT().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                    if (clsLoadClass != null) {
                        try {
                            Object objInvoke = clsLoadClass.getDeclaredMethod("getInstance", Context.class).invoke(null, this.zzu.zzaT());
                            if (objInvoke != null) {
                                try {
                                    str2 = (String) clsLoadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(objInvoke, new Object[0]);
                                } catch (Exception unused) {
                                    this.zzu.zzaW().zzl().zza("Failed to retrieve Firebase Instance Id");
                                    str2 = null;
                                }
                            }
                        } catch (Exception unused2) {
                            this.zzu.zzaW().zzm().zza("Failed to obtain Firebase Analytics instance");
                        }
                    }
                } catch (ClassNotFoundException unused3) {
                }
            }
            str2 = null;
        } else {
            str2 = null;
        }
        zzio zzioVar5 = this.zzu;
        long jZza = zzioVar5.zzm().zzc.zza();
        long jMin = jZza == 0 ? zzioVar5.zza : Math.min(zzioVar5.zza, jZza);
        zza();
        int i4 = this.zzk;
        zzio zzioVar6 = this.zzu;
        boolean zZzw = zzioVar6.zzf().zzw();
        zzht zzhtVarZzm = zzioVar6.zzm();
        zzhtVarZzm.zzg();
        boolean z2 = zzhtVarZzm.zzb().getBoolean("deferred_analytics_collection", false);
        String strZzl = zzl();
        boolean z3 = zzioVar6.zzf().zzm("google_analytics_default_allow_ad_personalization_signals", true) != zzju.GRANTED;
        long j6 = this.zzg;
        Boolean boolValueOf = Boolean.valueOf(z3);
        List list2 = this.zzi;
        String strZzq = zzioVar6.zzm().zzh().zzq();
        if (this.zzj == null) {
            this.zzj = zzioVar6.zzw().zzF();
        }
        String str6 = this.zzj;
        if (zzioVar6.zzm().zzh().zzr(zzjw.ANALYTICS_STORAGE)) {
            zzg();
            j = 0;
            if (this.zzo == 0) {
                i = i4;
                list = list2;
            } else {
                i = i4;
                list = list2;
                long jCurrentTimeMillis = zzioVar6.zzaU().currentTimeMillis() - this.zzo;
                if (this.zzn != null && jCurrentTimeMillis > 86400000 && this.zzp == null) {
                    zzq();
                }
            }
            if (this.zzn == null) {
                zzq();
            }
            str3 = this.zzn;
        } else {
            i = i4;
            list = list2;
            j = 0;
            str3 = null;
        }
        boolean zZzE = zzioVar6.zzf().zzE();
        zzqf zzqfVarZzw2 = zzioVar6.zzw();
        String strZzm2 = zzm();
        zzio zzioVar7 = zzqfVarZzw2.zzu;
        if (zzioVar7.zzaT().getPackageManager() == null) {
            j2 = j;
            i2 = 0;
        } else {
            try {
                i2 = 0;
                try {
                    ApplicationInfo applicationInfo = Wrappers.packageManager(zzioVar7.zzaT()).getApplicationInfo(strZzm2, 0);
                    i3 = applicationInfo != null ? applicationInfo.targetSdkVersion : i2;
                } catch (PackageManager.NameNotFoundException unused4) {
                    zzio zzioVar8 = zzqfVarZzw2.zzu;
                    zzioVar8.zzaV();
                    zzioVar8.zzaW().zzi().zzb("PackageManager failed to find running app: app_id", strZzm2);
                }
            } catch (PackageManager.NameNotFoundException unused5) {
                i2 = 0;
            }
            j2 = i3;
        }
        zzio zzioVar9 = this.zzu;
        int iZzb = zzioVar9.zzm().zzh().zzb();
        String strZzj = zzioVar9.zzm().zzf().zzj();
        zzqr.zzb();
        zzam zzamVarZzf = zzioVar9.zzf();
        zzgg zzggVar = zzgi.zzaW;
        int iZzl = zzamVarZzf.zzx(null, zzggVar) ? zzioVar9.zzw().zzl() : i2;
        zzqr.zzb();
        return new zzr(strZzm, strZzo, str4, j3, str5, 119002L, j5, str, zZzJ, z, str2, jMin, i, zZzw, z2, strZzl, boolValueOf, j6, list, (String) null, strZzq, str6, str3, zZzE, j2, iZzb, strZzj, iZzl, zzioVar9.zzf().zzx(null, zzggVar) ? zzioVar9.zzw().zzq() : j, zzioVar9.zzf().zzs(), new zze(zzioVar9.zzf().zzm("google_analytics_default_allow_ad_personalization_signals", true)).zzc(), this.zzu.zza, zzioVar9.zzf().zzx(null, zzgi.zzaR) ? this.zzu.zzs().zzi().zza() : 0);
    }

    final String zzl() {
        zza();
        if (this.zzu.zzf().zzx(null, zzgi.zzbp)) {
            return null;
        }
        return this.zzm;
    }

    final String zzm() {
        zza();
        Preconditions.checkNotNull(this.zza);
        return this.zza;
    }

    final String zzn() {
        zza();
        Preconditions.checkNotNull(this.zze);
        return this.zze;
    }

    final String zzo() {
        zzg();
        zza();
        Preconditions.checkNotNull(this.zzl);
        return this.zzl;
    }

    final List zzp() {
        return this.zzi;
    }

    final void zzq() {
        String str;
        zzg();
        zzio zzioVar = this.zzu;
        if (zzioVar.zzm().zzh().zzr(zzjw.ANALYTICS_STORAGE)) {
            byte[] bArr = new byte[16];
            zzioVar.zzw().zzJ().nextBytes(bArr);
            str = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        } else {
            zzioVar.zzaW().zzd().zza("Analytics Storage consent is not granted");
            str = null;
        }
        zzhc zzhcVarZzd = zzioVar.zzaW().zzd();
        Object[] objArr = new Object[1];
        objArr[0] = str == null ? "null" : "not null";
        zzhcVarZzd.zza(String.format("Resetting session stitching token to %s", objArr));
        this.zzn = str;
        this.zzo = zzioVar.zzaU().currentTimeMillis();
    }

    final boolean zzr(String str) {
        String str2 = this.zzp;
        boolean z = false;
        if (str2 != null && !str2.equals(str)) {
            z = true;
        }
        this.zzp = str;
        return z;
    }
}
