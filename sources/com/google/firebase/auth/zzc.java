package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.p002firebaseauthapi.zzaic;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzc extends OAuthCredential {
    public static final Parcelable.Creator<zzc> CREATOR = new zze();
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final zzaic zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;

    @Override // com.google.firebase.auth.AuthCredential
    public final AuthCredential zza() {
        return new zzc(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg);
    }

    public static zzc zza(zzaic zzaicVar) {
        Preconditions.checkNotNull(zzaicVar, "Must specify a non-null webSignInCredential");
        return new zzc(null, null, null, zzaicVar, null, null, null);
    }

    public static zzc zza(String str, String str2, String str3) {
        return zza(str, str2, str3, null, null);
    }

    public static zzc zza(String str, String str2, String str3, String str4, String str5) {
        Preconditions.checkNotEmpty(str, "Must specify a non-empty providerId");
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
        }
        return new zzc(str, str2, str3, null, str4, str5, null);
    }

    static zzc zza(String str, String str2, String str3, String str4) {
        Preconditions.checkNotEmpty(str, "Must specify a non-empty providerId");
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
        }
        return new zzc(str, str2, str3, null, null, null, str4);
    }

    public static zzaic zza(zzc zzcVar, String str) {
        Preconditions.checkNotNull(zzcVar);
        zzaic zzaicVar = zzcVar.zzd;
        return zzaicVar != null ? zzaicVar : new zzaic(zzcVar.getIdToken(), zzcVar.getAccessToken(), zzcVar.getProvider(), null, zzcVar.getSecret(), null, str, zzcVar.zze, zzcVar.zzg);
    }

    @Override // com.google.firebase.auth.OAuthCredential
    public String getAccessToken() {
        return this.zzc;
    }

    @Override // com.google.firebase.auth.OAuthCredential
    public String getIdToken() {
        return this.zzb;
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getProvider() {
        return this.zza;
    }

    @Override // com.google.firebase.auth.OAuthCredential
    public String getSecret() {
        return this.zzf;
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getSignInMethod() {
        return this.zza;
    }

    zzc(String str, String str2, String str3, zzaic zzaicVar, String str4, String str5, String str6) {
        this.zza = com.google.android.gms.internal.p002firebaseauthapi.zzae.zzb(str);
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = zzaicVar;
        this.zze = str4;
        this.zzf = str5;
        this.zzg = str6;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getProvider(), false);
        SafeParcelWriter.writeString(parcel, 2, getIdToken(), false);
        SafeParcelWriter.writeString(parcel, 3, getAccessToken(), false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeString(parcel, 5, this.zze, false);
        SafeParcelWriter.writeString(parcel, 6, getSecret(), false);
        SafeParcelWriter.writeString(parcel, 7, this.zzg, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
