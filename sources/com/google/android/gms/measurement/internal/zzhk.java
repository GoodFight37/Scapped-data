package com.google.android.gms.measurement.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzhk extends zzpg {
    public zzhk(zzpv zzpvVar) {
        super(zzpvVar);
    }

    public final void zza(zzh zzhVar, Map map, zzhg zzhgVar) {
        zzg();
        zzav();
        Preconditions.checkNotNull(zzhVar);
        Preconditions.checkNotNull(zzhgVar);
        zzpi zzpiVarZzy = this.zzg.zzy();
        Uri.Builder builder = new Uri.Builder();
        String strZzH = zzhVar.zzH();
        if (TextUtils.isEmpty(strZzH)) {
            strZzH = zzhVar.zzA();
        }
        Uri.Builder builderAppendQueryParameter = builder.scheme((String) zzgi.zze.zza(null)).encodedAuthority((String) zzgi.zzf.zza(null)).path("config/app/".concat(String.valueOf(strZzH))).appendQueryParameter("platform", "android");
        zzpiVarZzy.zzu.zzf().zzj();
        builderAppendQueryParameter.appendQueryParameter("gmp_version", String.valueOf(119002L)).appendQueryParameter("runtime_version", "0");
        String string = builder.build().toString();
        try {
            this.zzu.zzaX().zzp(new zzhi(this, zzhVar.zzC(), new URI(string).toURL(), null, map, zzhgVar));
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused) {
            this.zzu.zzaW().zze().zzc("Failed to parse config URL. Not fetching. appId", zzhe.zzn(zzhVar.zzC()), string);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzpg
    protected final boolean zzb() {
        return false;
    }

    public final void zzc(String str, zzph zzphVar, com.google.android.gms.internal.measurement.zzhv zzhvVar, zzhg zzhgVar) {
        zzg();
        zzav();
        try {
            URL url = new URI(zzphVar.zzc()).toURL();
            this.zzg.zzA();
            this.zzu.zzaX().zzp(new zzhi(this, str, url, zzhvVar.zzcd(), zzphVar.zzd(), zzhgVar));
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused) {
            this.zzu.zzaW().zze().zzc("Failed to parse URL. Not uploading MeasurementBatch. appId", zzhe.zzn(str), zzphVar.zzc());
        }
    }

    public final boolean zzd() {
        zzav();
        ConnectivityManager connectivityManager = (ConnectivityManager) this.zzu.zzaT().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = null;
        if (connectivityManager != null) {
            try {
                activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException unused) {
            }
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
