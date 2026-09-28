package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.p002firebaseauthapi.zzaic;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public class GithubAuthCredential extends AuthCredential {
    public static final Parcelable.Creator<GithubAuthCredential> CREATOR = new zzaj();
    private String zza;

    @Override // com.google.firebase.auth.AuthCredential
    public final AuthCredential zza() {
        return new GithubAuthCredential(this.zza);
    }

    public static zzaic zza(GithubAuthCredential githubAuthCredential, String str) {
        Preconditions.checkNotNull(githubAuthCredential);
        return new zzaic(null, githubAuthCredential.zza, githubAuthCredential.getProvider(), null, null, null, str, null, null);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getProvider() {
        return "github.com";
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getSignInMethod() {
        return "github.com";
    }

    GithubAuthCredential(String str) {
        this.zza = Preconditions.checkNotEmpty(str);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
