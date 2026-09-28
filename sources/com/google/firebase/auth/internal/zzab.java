package com.google.firebase.auth.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.p002firebaseauthapi.zzagl;
import com.google.android.gms.internal.p002firebaseauthapi.zzahc;
import com.google.android.gms.internal.p002firebaseauthapi.zzzp;
import com.google.firebase.auth.UserInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzab extends AbstractSafeParcelable implements UserInfo {
    public static final Parcelable.Creator<zzab> CREATOR = new zzaa();
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private Uri zze;
    private String zzf;
    private String zzg;
    private boolean zzh;
    private String zzi;

    @Override // com.google.firebase.auth.UserInfo
    public final Uri getPhotoUrl() {
        if (!TextUtils.isEmpty(this.zzd) && this.zze == null) {
            this.zze = Uri.parse(this.zzd);
        }
        return this.zze;
    }

    public static zzab zza(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new zzab(jSONObject.optString("userId"), jSONObject.optString("providerId"), jSONObject.optString("email"), jSONObject.optString("phoneNumber"), jSONObject.optString("displayName"), jSONObject.optString("photoUrl"), jSONObject.optBoolean("isEmailVerified"), jSONObject.optString("rawUserInfo"));
        } catch (JSONException e) {
            Log.d("DefaultAuthUserInfo", "Failed to unpack UserInfo from JSON");
            throw new zzzp(e);
        }
    }

    @Override // com.google.firebase.auth.UserInfo
    public final String getDisplayName() {
        return this.zzc;
    }

    @Override // com.google.firebase.auth.UserInfo
    public final String getEmail() {
        return this.zzf;
    }

    @Override // com.google.firebase.auth.UserInfo
    public final String getPhoneNumber() {
        return this.zzg;
    }

    @Override // com.google.firebase.auth.UserInfo
    public final String getProviderId() {
        return this.zzb;
    }

    public final String zza() {
        return this.zzi;
    }

    @Override // com.google.firebase.auth.UserInfo
    public final String getUid() {
        return this.zza;
    }

    public final String zzb() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("userId", this.zza);
            jSONObject.putOpt("providerId", this.zzb);
            jSONObject.putOpt("displayName", this.zzc);
            jSONObject.putOpt("photoUrl", this.zzd);
            jSONObject.putOpt("email", this.zzf);
            jSONObject.putOpt("phoneNumber", this.zzg);
            jSONObject.putOpt("isEmailVerified", Boolean.valueOf(this.zzh));
            jSONObject.putOpt("rawUserInfo", this.zzi);
            return jSONObject.toString();
        } catch (JSONException e) {
            Log.d("DefaultAuthUserInfo", "Failed to jsonify this object");
            throw new zzzp(e);
        }
    }

    public zzab(zzahc zzahcVar) {
        Preconditions.checkNotNull(zzahcVar);
        this.zza = zzahcVar.zzd();
        this.zzb = Preconditions.checkNotEmpty(zzahcVar.zzf());
        this.zzc = zzahcVar.zzb();
        Uri uriZza = zzahcVar.zza();
        if (uriZza != null) {
            this.zzd = uriZza.toString();
            this.zze = uriZza;
        }
        this.zzf = zzahcVar.zzc();
        this.zzg = zzahcVar.zze();
        this.zzh = false;
        this.zzi = zzahcVar.zzg();
    }

    public zzab(zzagl zzaglVar, String str) {
        Preconditions.checkNotNull(zzaglVar);
        Preconditions.checkNotEmpty(str);
        this.zza = Preconditions.checkNotEmpty(zzaglVar.zzi());
        this.zzb = str;
        this.zzf = zzaglVar.zzh();
        this.zzc = zzaglVar.zzg();
        Uri uriZzc = zzaglVar.zzc();
        if (uriZzc != null) {
            this.zzd = uriZzc.toString();
            this.zze = uriZzc;
        }
        this.zzh = zzaglVar.zzm();
        this.zzi = null;
        this.zzg = zzaglVar.zzj();
    }

    public zzab(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7) {
        this.zza = str;
        this.zzb = str2;
        this.zzf = str3;
        this.zzg = str4;
        this.zzc = str5;
        this.zzd = str6;
        if (!TextUtils.isEmpty(str6)) {
            this.zze = Uri.parse(this.zzd);
        }
        this.zzh = z;
        this.zzi = str7;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getUid(), false);
        SafeParcelWriter.writeString(parcel, 2, getProviderId(), false);
        SafeParcelWriter.writeString(parcel, 3, getDisplayName(), false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeString(parcel, 5, getEmail(), false);
        SafeParcelWriter.writeString(parcel, 6, getPhoneNumber(), false);
        SafeParcelWriter.writeBoolean(parcel, 7, isEmailVerified());
        SafeParcelWriter.writeString(parcel, 8, this.zzi, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @Override // com.google.firebase.auth.UserInfo
    public final boolean isEmailVerified() {
        return this.zzh;
    }
}
