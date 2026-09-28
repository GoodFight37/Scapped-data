package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zzao;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzaei implements zzadm {
    final /* synthetic */ zzaeg zza;

    zzaei(zzaeg zzaegVar) {
        this.zza = zzaegVar;
    }

    private final void zza(zzaen zzaenVar) {
        this.zza.zzi.execute(new zzaeo(this, zzaenVar));
    }

    private final void zza(Status status, AuthCredential authCredential, String str, String str2) {
        zzaeg.zza(this.zza, status);
        this.zza.zzn = authCredential;
        this.zza.zzo = str;
        this.zza.zzp = str2;
        if (this.zza.zzf != null) {
            this.zza.zzf.zza(status);
        }
        this.zza.zza(status);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadm
    public final void zza(String str) throws RemoteException {
        Preconditions.checkState(this.zza.zza == 8, "Unexpected response type " + this.zza.zza);
        this.zza.zzu = true;
        zza(new zzaem(this, str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadm
    public final void zzb(String str) throws RemoteException {
        Preconditions.checkState(this.zza.zza == 8, "Unexpected response type " + this.zza.zza);
        zza(new zzaek(this, str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadm
    public final void zza(zzafw zzafwVar) throws RemoteException {
        Preconditions.checkState(this.zza.zza == 3, "Unexpected response type " + this.zza.zza);
        this.zza.zzl = zzafwVar;
        zzaeg.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadm
    public final void zza() throws RemoteException {
        Preconditions.checkState(this.zza.zza == 5, "Unexpected response type " + this.zza.zza);
        zzaeg.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadm
    public final void zza(zzzt zzztVar) {
        zza(zzztVar.zza(), zzztVar.zzb(), zzztVar.zzc(), zzztVar.zzd());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadm
    public final void zza(zzzs zzzsVar) {
        this.zza.zzq = zzzsVar;
        this.zza.zza(zzao.zza("REQUIRES_SECOND_FACTOR_AUTH"));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadm
    public final void zza(Status status, PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        Preconditions.checkState(this.zza.zza == 2, "Unexpected response type " + this.zza.zza);
        zza(status, phoneAuthCredential, null, null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadm
    public final void zza(Status status) throws RemoteException {
        String statusMessage = status.getStatusMessage();
        if (statusMessage != null) {
            if (statusMessage.contains("MISSING_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17081);
            } else if (statusMessage.contains("MISSING_MFA_ENROLLMENT_ID")) {
                status = new Status(17082);
            } else if (statusMessage.contains("INVALID_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17083);
            } else if (statusMessage.contains("MFA_ENROLLMENT_NOT_FOUND")) {
                status = new Status(17084);
            } else if (statusMessage.contains("ADMIN_ONLY_OPERATION")) {
                status = new Status(17085);
            } else if (statusMessage.contains("UNVERIFIED_EMAIL")) {
                status = new Status(17086);
            } else if (statusMessage.contains("SECOND_FACTOR_EXISTS")) {
                status = new Status(17087);
            } else if (statusMessage.contains("SECOND_FACTOR_LIMIT_EXCEEDED")) {
                status = new Status(17088);
            } else if (statusMessage.contains("UNSUPPORTED_FIRST_FACTOR")) {
                status = new Status(17089);
            } else if (statusMessage.contains("EMAIL_CHANGE_NEEDS_VERIFICATION")) {
                status = new Status(17090);
            }
        }
        if (this.zza.zza == 8) {
            this.zza.zzu = true;
            zza(new zzael(this, status));
        } else {
            zzaeg.zza(this.zza, status);
            this.zza.zza(status);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadm
    public final void zza(zzags zzagsVar) throws RemoteException {
        this.zza.zzs = zzagsVar;
        zzaeg.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadm
    public final void zza(zzagt zzagtVar) throws RemoteException {
        this.zza.zzr = zzagtVar;
        zzaeg.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadm
    public final void zza(zzagw zzagwVar, zzagl zzaglVar) throws RemoteException {
        Preconditions.checkState(this.zza.zza == 2, "Unexpected response type: " + this.zza.zza);
        this.zza.zzj = zzagwVar;
        this.zza.zzk = zzaglVar;
        zzaeg.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadm
    public final void zza(zzahg zzahgVar) throws RemoteException {
        Preconditions.checkState(this.zza.zza == 4, "Unexpected response type " + this.zza.zza);
        this.zza.zzm = zzahgVar;
        zzaeg.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadm
    public final void zza(zzahh zzahhVar) throws RemoteException {
        zzaeg.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadm
    public final void zzb() throws RemoteException {
        Preconditions.checkState(this.zza.zza == 6, "Unexpected response type " + this.zza.zza);
        zzaeg.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadm
    public final void zzc(String str) throws RemoteException {
        Preconditions.checkState(this.zza.zza == 7, "Unexpected response type " + this.zza.zza);
        zzaeg.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadm
    public final void zzc() throws RemoteException {
        Preconditions.checkState(this.zza.zza == 9, "Unexpected response type " + this.zza.zza);
        zzaeg.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadm
    public final void zza(zzahs zzahsVar) throws RemoteException {
        this.zza.zzt = zzahsVar;
        zzaeg.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadm
    public final void zza(zzagw zzagwVar) throws RemoteException {
        Preconditions.checkState(this.zza.zza == 1, "Unexpected response type: " + this.zza.zza);
        this.zza.zzj = zzagwVar;
        zzaeg.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadm
    public final void zza(PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        Preconditions.checkState(this.zza.zza == 8, "Unexpected response type " + this.zza.zza);
        this.zza.zzu = true;
        zza(new zzaej(this, phoneAuthCredential));
    }
}
