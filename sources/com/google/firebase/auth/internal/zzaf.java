package com.google.firebase.auth.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.p002firebaseauthapi.zzagw;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseUserMetadata;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.MultiFactor;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.UserInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzaf extends FirebaseUser {
    public static final Parcelable.Creator<zzaf> CREATOR = new zzae();
    private zzagw zza;
    private zzab zzb;
    private String zzc;
    private String zzd;
    private List<zzab> zze;
    private List<String> zzf;
    private String zzg;
    private Boolean zzh;
    private zzah zzi;
    private boolean zzj;
    private com.google.firebase.auth.zzc zzk;
    private zzbj zzl;
    private List<com.google.firebase.auth.zzal> zzm;

    @Override // com.google.firebase.auth.FirebaseUser, com.google.firebase.auth.UserInfo
    public Uri getPhotoUrl() {
        return this.zzb.getPhotoUrl();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final FirebaseApp zza() {
        return FirebaseApp.getInstance(this.zzc);
    }

    public final com.google.firebase.auth.zzc zzh() {
        return this.zzk;
    }

    public static FirebaseUser zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser) {
        zzaf zzafVar = new zzaf(firebaseApp, firebaseUser.getProviderData());
        if (firebaseUser instanceof zzaf) {
            zzaf zzafVar2 = (zzaf) firebaseUser;
            zzafVar.zzg = zzafVar2.zzg;
            zzafVar.zzd = zzafVar2.zzd;
            zzafVar.zzi = (zzah) zzafVar2.getMetadata();
        } else {
            zzafVar.zzi = null;
        }
        if (firebaseUser.zzc() != null) {
            zzafVar.zza(firebaseUser.zzc());
        }
        if (!firebaseUser.isAnonymous()) {
            zzafVar.zzb();
        }
        return zzafVar;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final /* synthetic */ FirebaseUser zzb() {
        this.zzh = false;
        return this;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final synchronized FirebaseUser zza(List<? extends UserInfo> list) {
        Preconditions.checkNotNull(list);
        this.zze = new ArrayList(list.size());
        this.zzf = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            UserInfo userInfo = list.get(i);
            if (userInfo.getProviderId().equals(FirebaseAuthProvider.PROVIDER_ID)) {
                this.zzb = (zzab) userInfo;
            } else {
                this.zzf.add(userInfo.getProviderId());
            }
            this.zze.add((zzab) userInfo);
        }
        if (this.zzb == null) {
            this.zzb = this.zze.get(0);
        }
        return this;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public FirebaseUserMetadata getMetadata() {
        return this.zzi;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public /* synthetic */ MultiFactor getMultiFactor() {
        return new zzaj(this);
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final zzagw zzc() {
        return this.zza;
    }

    public final zzaf zza(String str) {
        this.zzg = str;
        return this;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final String zzd() {
        return zzc().zzc();
    }

    @Override // com.google.firebase.auth.FirebaseUser, com.google.firebase.auth.UserInfo
    public String getDisplayName() {
        return this.zzb.getDisplayName();
    }

    @Override // com.google.firebase.auth.FirebaseUser, com.google.firebase.auth.UserInfo
    public String getEmail() {
        return this.zzb.getEmail();
    }

    @Override // com.google.firebase.auth.FirebaseUser, com.google.firebase.auth.UserInfo
    public String getPhoneNumber() {
        return this.zzb.getPhoneNumber();
    }

    @Override // com.google.firebase.auth.FirebaseUser, com.google.firebase.auth.UserInfo
    public String getProviderId() {
        return this.zzb.getProviderId();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final String zze() {
        return this.zza.zzf();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public String getTenantId() {
        Map map;
        zzagw zzagwVar = this.zza;
        if (zzagwVar == null || zzagwVar.zzc() == null || (map = (Map) zzbi.zza(this.zza.zzc()).getClaims().get(FirebaseAuthProvider.PROVIDER_ID)) == null) {
            return null;
        }
        return (String) map.get("tenant");
    }

    @Override // com.google.firebase.auth.FirebaseUser, com.google.firebase.auth.UserInfo
    public String getUid() {
        return this.zzb.getUid();
    }

    public final List<MultiFactorInfo> zzi() {
        zzbj zzbjVar = this.zzl;
        if (zzbjVar != null) {
            return zzbjVar.zza();
        }
        return new ArrayList();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final List<com.google.firebase.auth.zzal> zzf() {
        return this.zzm;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public List<? extends UserInfo> getProviderData() {
        return this.zze;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final List<String> zzg() {
        return this.zzf;
    }

    public final List<zzab> zzj() {
        return this.zze;
    }

    public zzaf(FirebaseApp firebaseApp, List<? extends UserInfo> list) {
        Preconditions.checkNotNull(firebaseApp);
        this.zzc = firebaseApp.getName();
        this.zzd = "com.google.firebase.auth.internal.DefaultFirebaseUser";
        this.zzg = "2";
        zza(list);
    }

    zzaf(zzagw zzagwVar, zzab zzabVar, String str, String str2, List<zzab> list, List<String> list2, String str3, Boolean bool, zzah zzahVar, boolean z, com.google.firebase.auth.zzc zzcVar, zzbj zzbjVar, List<com.google.firebase.auth.zzal> list3) {
        this.zza = zzagwVar;
        this.zzb = zzabVar;
        this.zzc = str;
        this.zzd = str2;
        this.zze = list;
        this.zzf = list2;
        this.zzg = str3;
        this.zzh = bool;
        this.zzi = zzahVar;
        this.zzj = z;
        this.zzk = zzcVar;
        this.zzl = zzbjVar;
        this.zzm = list3;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final void zza(zzagw zzagwVar) {
        this.zza = (zzagw) Preconditions.checkNotNull(zzagwVar);
    }

    public final void zza(com.google.firebase.auth.zzc zzcVar) {
        this.zzk = zzcVar;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final void zzb(List<com.google.firebase.auth.zzal> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.zzm = list;
    }

    public final void zza(boolean z) {
        this.zzj = z;
    }

    public final void zza(zzah zzahVar) {
        this.zzi = zzahVar;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final void zzc(List<MultiFactorInfo> list) {
        this.zzl = zzbj.zza(list);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, zzc(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeTypedList(parcel, 5, this.zze, false);
        SafeParcelWriter.writeStringList(parcel, 6, zzg(), false);
        SafeParcelWriter.writeString(parcel, 7, this.zzg, false);
        SafeParcelWriter.writeBooleanObject(parcel, 8, Boolean.valueOf(isAnonymous()), false);
        SafeParcelWriter.writeParcelable(parcel, 9, getMetadata(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzj);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzk, i, false);
        SafeParcelWriter.writeParcelable(parcel, 12, this.zzl, i, false);
        SafeParcelWriter.writeTypedList(parcel, 13, zzf(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public boolean isAnonymous() {
        GetTokenResult getTokenResultZza;
        Boolean bool = this.zzh;
        if (bool == null || bool.booleanValue()) {
            zzagw zzagwVar = this.zza;
            String signInProvider = "";
            if (zzagwVar != null && (getTokenResultZza = zzbi.zza(zzagwVar.zzc())) != null) {
                signInProvider = getTokenResultZza.getSignInProvider();
            }
            boolean z = true;
            if (getProviderData().size() > 1 || (signInProvider != null && signInProvider.equals("custom"))) {
                z = false;
            }
            this.zzh = Boolean.valueOf(z);
        }
        return this.zzh.booleanValue();
    }

    @Override // com.google.firebase.auth.UserInfo
    public boolean isEmailVerified() {
        return this.zzb.isEmailVerified();
    }

    public final boolean zzk() {
        return this.zzj;
    }
}
