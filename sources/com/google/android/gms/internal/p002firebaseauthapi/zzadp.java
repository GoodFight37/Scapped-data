package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.firebase.auth.PhoneAuthCredential;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public class zzadp {
    private final zzadm zza;
    private final Logger zzb;

    public zzadp(zzadp zzadpVar) {
        this(zzadpVar.zza, zzadpVar.zzb);
    }

    public zzadp(zzadm zzadmVar, Logger logger) {
        this.zza = (zzadm) Preconditions.checkNotNull(zzadmVar);
        this.zzb = (Logger) Preconditions.checkNotNull(logger);
    }

    public final void zza(String str) {
        try {
            this.zza.zza(str);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending auto retrieval timeout response.", e, new Object[0]);
        }
    }

    public void zzb(String str) {
        try {
            this.zza.zzb(str);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending send verification code response.", e, new Object[0]);
        }
    }

    public final void zza(zzafw zzafwVar) {
        try {
            this.zza.zza(zzafwVar);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending create auth uri response.", e, new Object[0]);
        }
    }

    public final void zza() {
        try {
            this.zza.zza();
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending delete account response.", e, new Object[0]);
        }
    }

    public final void zza(zzzt zzztVar) {
        try {
            this.zza.zza(zzztVar);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending failure result with credential", e, new Object[0]);
        }
    }

    public final void zza(zzzs zzzsVar) {
        try {
            this.zza.zza(zzzsVar);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending failure result for mfa", e, new Object[0]);
        }
    }

    public final void zza(Status status, PhoneAuthCredential phoneAuthCredential) {
        try {
            this.zza.zza(status, phoneAuthCredential);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending failure result.", e, new Object[0]);
        }
    }

    public void zza(Status status) {
        try {
            this.zza.zza(status);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending failure result.", e, new Object[0]);
        }
    }

    public final void zza(zzags zzagsVar) {
        try {
            this.zza.zza(zzagsVar);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending Play Integrity Producer project response.", e, new Object[0]);
        }
    }

    public final void zza(zzagt zzagtVar) {
        try {
            this.zza.zza(zzagtVar);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending get recaptcha config response.", e, new Object[0]);
        }
    }

    public final void zza(zzagw zzagwVar, zzagl zzaglVar) {
        try {
            this.zza.zza(zzagwVar, zzaglVar);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending get token and account info user response", e, new Object[0]);
        }
    }

    public final void zza(zzahg zzahgVar) {
        try {
            this.zza.zza(zzahgVar);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending password reset response.", e, new Object[0]);
        }
    }

    public final void zza(zzahh zzahhVar) {
        try {
            this.zza.zza(zzahhVar);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending revoke token response.", e, new Object[0]);
        }
    }

    public final void zzb() {
        try {
            this.zza.zzb();
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending email verification response.", e, new Object[0]);
        }
    }

    public final void zzc(String str) {
        try {
            this.zza.zzc(str);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending set account info response.", e, new Object[0]);
        }
    }

    public final void zzc() {
        try {
            this.zza.zzc();
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when setting FirebaseUI Version", e, new Object[0]);
        }
    }

    public final void zza(zzahs zzahsVar) {
        try {
            this.zza.zza(zzahsVar);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending start mfa enrollment response.", e, new Object[0]);
        }
    }

    public final void zza(zzagw zzagwVar) {
        try {
            this.zza.zza(zzagwVar);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending token result.", e, new Object[0]);
        }
    }

    public final void zza(PhoneAuthCredential phoneAuthCredential) {
        try {
            this.zza.zza(phoneAuthCredential);
        } catch (RemoteException e) {
            this.zzb.e("RemoteException when sending verification completed response.", e, new Object[0]);
        }
    }
}
