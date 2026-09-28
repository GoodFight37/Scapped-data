package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.MultiFactorAssertion;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneMultiFactorAssertion;
import com.google.firebase.auth.TotpMultiFactorAssertion;
import com.google.firebase.auth.TotpSecret;
import com.google.firebase.auth.UserProfileChangeRequest;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzado {
    private static final Logger zza = new Logger("FirebaseAuth", "FirebaseAuthFallback:");
    private final zzzv zzb;
    private final zzafd zzc;

    zzado(FirebaseApp firebaseApp, ScheduledExecutorService scheduledExecutorService) {
        Preconditions.checkNotNull(firebaseApp);
        Context applicationContext = firebaseApp.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.zzb = new zzzv(new zzaec(firebaseApp, zzaed.zza()));
        this.zzc = new zzafd(applicationContext, scheduledExecutorService);
    }

    public final void zza(String str, String str2, zzadm zzadmVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzadmVar);
        this.zzb.zza(str, str2, new zzadp(zzadmVar, zza));
    }

    public final void zzb(String str, String str2, zzadm zzadmVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzadmVar);
        this.zzb.zzb(str, str2, new zzadp(zzadmVar, zza));
    }

    public final void zzc(String str, String str2, zzadm zzadmVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzadmVar);
        this.zzb.zzc(str, str2, new zzadp(zzadmVar, zza));
    }

    public final void zzd(String str, String str2, zzadm zzadmVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzadmVar);
        this.zzb.zzd(str, str2, new zzadp(zzadmVar, zza));
    }

    public final void zza(zzahd zzahdVar, zzadm zzadmVar) {
        Preconditions.checkNotNull(zzahdVar);
        Preconditions.checkNotEmpty(zzahdVar.zzb());
        Preconditions.checkNotNull(zzadmVar);
        this.zzb.zza(zzahdVar, new zzadp(zzadmVar, zza));
    }

    public final void zza(String str, String str2, String str3, String str4, zzadm zzadmVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzadmVar);
        this.zzb.zza(str, str2, str3, str4, new zzadp(zzadmVar, zza));
    }

    public final void zza(String str, zzadm zzadmVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzadmVar);
        this.zzb.zza(str, new zzadp(zzadmVar, zza));
    }

    public final void zza(MultiFactorAssertion multiFactorAssertion, String str, String str2, String str3, zzadm zzadmVar) {
        zzaga zzagaVarZza;
        Preconditions.checkNotNull(multiFactorAssertion);
        Preconditions.checkNotEmpty(str, "cachedTokenState should not be empty.");
        Preconditions.checkNotNull(zzadmVar);
        if (multiFactorAssertion instanceof PhoneMultiFactorAssertion) {
            PhoneAuthCredential phoneAuthCredentialZza = ((PhoneMultiFactorAssertion) multiFactorAssertion).zza();
            zzagaVarZza = zzage.zza(str, (String) Preconditions.checkNotNull(phoneAuthCredentialZza.zzc()), (String) Preconditions.checkNotNull(phoneAuthCredentialZza.getSmsCode()), str2, str3);
        } else if (multiFactorAssertion instanceof TotpMultiFactorAssertion) {
            TotpMultiFactorAssertion totpMultiFactorAssertion = (TotpMultiFactorAssertion) multiFactorAssertion;
            zzagaVarZza = zzagg.zza(str, Preconditions.checkNotEmpty(str2), Preconditions.checkNotEmpty(((TotpSecret) Preconditions.checkNotNull(totpMultiFactorAssertion.zza())).getSessionInfo()), Preconditions.checkNotEmpty(totpMultiFactorAssertion.zzc()), str3);
        } else {
            throw new IllegalArgumentException("multiFactorAssertion must be either PhoneMultiFactorAssertion or TotpMultiFactorAssertion.");
        }
        this.zzb.zza(zzagaVarZza, str, new zzadp(zzadmVar, zza));
    }

    public final void zza(String str, MultiFactorAssertion multiFactorAssertion, String str2, zzadm zzadmVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(multiFactorAssertion);
        Preconditions.checkNotNull(zzadmVar);
        if (multiFactorAssertion instanceof PhoneMultiFactorAssertion) {
            PhoneAuthCredential phoneAuthCredentialZza = ((PhoneMultiFactorAssertion) multiFactorAssertion).zza();
            this.zzb.zza(zzagd.zza(str, (String) Preconditions.checkNotNull(phoneAuthCredentialZza.zzc()), (String) Preconditions.checkNotNull(phoneAuthCredentialZza.getSmsCode()), str2), new zzadp(zzadmVar, zza));
        } else {
            if (multiFactorAssertion instanceof TotpMultiFactorAssertion) {
                TotpMultiFactorAssertion totpMultiFactorAssertion = (TotpMultiFactorAssertion) multiFactorAssertion;
                this.zzb.zza(zzagf.zza(str, Preconditions.checkNotEmpty(totpMultiFactorAssertion.zzc()), str2, Preconditions.checkNotEmpty(totpMultiFactorAssertion.zzb())), new zzadp(zzadmVar, zza));
                return;
            }
            throw new IllegalArgumentException("multiFactorAssertion must be either PhoneMultiFactorAssertion or TotpMultiFactorAssertion.");
        }
    }

    public final void zzb(String str, zzadm zzadmVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzadmVar);
        this.zzb.zzb(str, new zzadp(zzadmVar, zza));
    }

    public final void zza(zzagp zzagpVar, zzadm zzadmVar) {
        Preconditions.checkNotNull(zzagpVar);
        this.zzb.zza(zzagpVar, new zzadp(zzadmVar, zza));
    }

    public final void zze(String str, String str2, zzadm zzadmVar) {
        Preconditions.checkNotEmpty(str);
        this.zzb.zze(str, str2, new zzadp(zzadmVar, zza));
    }

    public final void zza(zzagu zzaguVar, zzadm zzadmVar) {
        Preconditions.checkNotNull(zzaguVar);
        this.zzb.zza(zzaguVar, new zzadp(zzadmVar, zza));
    }

    public final void zza(String str, String str2, String str3, String str4, String str5, zzadm zzadmVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzadmVar);
        this.zzb.zza(str, str2, str3, str4, str5, new zzadp(zzadmVar, zza));
    }

    public final void zza(String str, zzaic zzaicVar, zzadm zzadmVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaicVar);
        Preconditions.checkNotNull(zzadmVar);
        this.zzb.zza(str, zzaicVar, new zzadp(zzadmVar, zza));
    }

    public final void zza(zzaha zzahaVar, zzadm zzadmVar) {
        Preconditions.checkNotNull(zzadmVar);
        Preconditions.checkNotNull(zzahaVar);
        this.zzb.zza(Preconditions.checkNotEmpty(zzahaVar.zzb()), zzahaVar.zza(), new zzadp(zzadmVar, zza));
    }

    public final void zzc(String str, zzadm zzadmVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzadmVar);
        this.zzb.zzc(str, new zzadp(zzadmVar, zza));
    }

    public final void zza(zzahf zzahfVar, zzadm zzadmVar) {
        Preconditions.checkNotNull(zzahfVar);
        this.zzb.zza(zzahfVar, new zzadp(zzadmVar, zza));
    }

    public final void zza(zzagn zzagnVar, zzadm zzadmVar) {
        Preconditions.checkNotNull(zzagnVar);
        Preconditions.checkNotEmpty(zzagnVar.zzd());
        Preconditions.checkNotNull(zzadmVar);
        this.zzb.zza(zzagnVar, new zzadp(zzadmVar, zza));
    }

    public final void zzb(zzagn zzagnVar, zzadm zzadmVar) {
        Preconditions.checkNotNull(zzagnVar);
        Preconditions.checkNotEmpty(zzagnVar.zzc());
        Preconditions.checkNotNull(zzadmVar);
        this.zzb.zzb(zzagnVar, new zzadp(zzadmVar, zza));
    }

    public final void zza(zzahk zzahkVar, zzadm zzadmVar) {
        Preconditions.checkNotNull(zzadmVar);
        Preconditions.checkNotNull(zzahkVar);
        String strZzd = zzahkVar.zzd();
        zzadp zzadpVar = new zzadp(zzadmVar, zza);
        if (this.zzc.zzc(strZzd)) {
            if (zzahkVar.zze()) {
                this.zzc.zzb(strZzd);
            } else {
                this.zzc.zzb(zzadpVar, strZzd);
                return;
            }
        }
        long jZzb = zzahkVar.zzb();
        boolean zZzf = zzahkVar.zzf();
        if (zza(jZzb, zZzf)) {
            zzahkVar.zza(new zzafn(this.zzc.zzb()));
        }
        this.zzc.zza(strZzd, zzadpVar, jZzb, zZzf);
        this.zzb.zza(zzahkVar, this.zzc.zza(zzadpVar, strZzd));
    }

    public final void zza(zzaho zzahoVar, zzadm zzadmVar) {
        Preconditions.checkNotNull(zzahoVar);
        Preconditions.checkNotNull(zzadmVar);
        this.zzb.zzd(zzahoVar.zza(), new zzadp(zzadmVar, zza));
    }

    public final void zzd(String str, zzadm zzadmVar) {
        Preconditions.checkNotNull(zzadmVar);
        this.zzb.zze(str, new zzadp(zzadmVar, zza));
    }

    public final void zza(zzaic zzaicVar, zzadm zzadmVar) {
        Preconditions.checkNotNull(zzaicVar);
        Preconditions.checkNotNull(zzadmVar);
        this.zzb.zza(zzaicVar, new zzadp(zzadmVar, zza));
    }

    public final void zza(zzaid zzaidVar, zzadm zzadmVar) {
        Preconditions.checkNotNull(zzaidVar);
        Preconditions.checkNotNull(zzadmVar);
        this.zzb.zza(zzaidVar, new zzadp(zzadmVar, zza));
    }

    public final void zzb(String str, String str2, String str3, String str4, zzadm zzadmVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzadmVar);
        Preconditions.checkNotNull(zzadmVar);
        this.zzb.zzb(str, str2, str3, str4, new zzadp(zzadmVar, zza));
    }

    public final void zza(zzafy zzafyVar, zzadm zzadmVar) {
        Preconditions.checkNotNull(zzadmVar);
        Preconditions.checkNotNull(zzafyVar.zzb());
        this.zzb.zza(zzafyVar.zzb(), zzafyVar.zzc(), new zzadp(zzadmVar, zza));
    }

    public final void zza(zzzr zzzrVar, zzadm zzadmVar) {
        Preconditions.checkNotNull(zzadmVar);
        Preconditions.checkNotNull(zzzrVar);
        this.zzb.zza(zzaex.zza((PhoneAuthCredential) Preconditions.checkNotNull(zzzrVar.zza())), new zzadp(zzadmVar, zza));
    }

    public final void zza(String str, String str2, String str3, long j, boolean z, boolean z2, String str4, String str5, String str6, boolean z3, zzadm zzadmVar) {
        Preconditions.checkNotEmpty(str, "idToken should not be empty.");
        Preconditions.checkNotNull(zzadmVar);
        zzadp zzadpVar = new zzadp(zzadmVar, zza);
        if (this.zzc.zzc(str2)) {
            if (z) {
                this.zzc.zzb(str2);
            } else {
                this.zzc.zzb(zzadpVar, str2);
                return;
            }
        }
        zzaht zzahtVarZza = zzaht.zza(str, str2, str3, str4, str5, str6, null);
        if (zza(j, z3)) {
            zzahtVarZza.zza(new zzafn(this.zzc.zzb()));
        }
        this.zzc.zza(str2, zzadpVar, j, z3);
        this.zzb.zza(zzahtVarZza, this.zzc.zza(zzadpVar, str2));
    }

    public final void zza(zzzq zzzqVar, zzadm zzadmVar) {
        Preconditions.checkNotNull(zzzqVar);
        Preconditions.checkNotNull(zzadmVar);
        String phoneNumber = zzzqVar.zzb().getPhoneNumber();
        zzadp zzadpVar = new zzadp(zzadmVar, zza);
        if (this.zzc.zzc(phoneNumber)) {
            if (zzzqVar.zzh()) {
                this.zzc.zzb(phoneNumber);
            } else {
                this.zzc.zzb(zzadpVar, phoneNumber);
                return;
            }
        }
        long jZza = zzzqVar.zza();
        boolean zZzi = zzzqVar.zzi();
        zzahr zzahrVarZza = zzahr.zza(zzzqVar.zze(), zzzqVar.zzb().getUid(), zzzqVar.zzb().getPhoneNumber(), zzzqVar.zzd(), zzzqVar.zzg(), zzzqVar.zzf(), zzzqVar.zzc());
        if (zza(jZza, zZzi)) {
            zzahrVarZza.zza(new zzafn(this.zzc.zzb()));
        }
        this.zzc.zza(phoneNumber, zzadpVar, jZza, zZzi);
        this.zzb.zza(zzahrVarZza, this.zzc.zza(zzadpVar, phoneNumber));
    }

    public final void zza(zzahv zzahvVar, zzadm zzadmVar) {
        this.zzb.zza(zzahvVar, new zzadp((zzadm) Preconditions.checkNotNull(zzadmVar), zza));
    }

    public final void zza(String str, String str2, String str3, zzadm zzadmVar) {
        Preconditions.checkNotEmpty(str, "cachedTokenState should not be empty.");
        Preconditions.checkNotEmpty(str2, "uid should not be empty.");
        Preconditions.checkNotNull(zzadmVar);
        this.zzb.zza(str, str2, str3, new zzadp(zzadmVar, zza));
    }

    public final void zze(String str, zzadm zzadmVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzadmVar);
        this.zzb.zzf(str, new zzadp(zzadmVar, zza));
    }

    public final void zzf(String str, String str2, zzadm zzadmVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzadmVar);
        this.zzb.zzf(str, str2, new zzadp(zzadmVar, zza));
    }

    public final void zza(String str, UserProfileChangeRequest userProfileChangeRequest, zzadm zzadmVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(userProfileChangeRequest);
        Preconditions.checkNotNull(zzadmVar);
        this.zzb.zza(str, userProfileChangeRequest, new zzadp(zzadmVar, zza));
    }

    public final void zzc(zzagn zzagnVar, zzadm zzadmVar) {
        Preconditions.checkNotNull(zzagnVar);
        this.zzb.zzc(zzagnVar, new zzadp(zzadmVar, zza));
    }

    private static boolean zza(long j, boolean z) {
        if (j > 0 && z) {
            return true;
        }
        zza.w("App hash will not be appended to the request.", new Object[0]);
        return false;
    }
}
