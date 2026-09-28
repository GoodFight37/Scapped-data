package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseApp;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzaec extends zzaeu implements zzafo {
    private zzadw zza;
    private zzadz zzb;
    private zzaez zzc;
    private final zzaed zzd;
    private final FirebaseApp zze;
    private String zzf;
    private zzaef zzg;

    private final zzaef zzb() {
        if (this.zzg == null) {
            this.zzg = new zzaef(this.zze, this.zzd.zzb());
        }
        return this.zzg;
    }

    zzaec(FirebaseApp firebaseApp, zzaed zzaedVar) {
        this(firebaseApp, zzaedVar, null, null, null);
    }

    private zzaec(FirebaseApp firebaseApp, zzaed zzaedVar, zzaez zzaezVar, zzadw zzadwVar, zzadz zzadzVar) {
        this.zze = firebaseApp;
        this.zzf = firebaseApp.getOptions().getApiKey();
        this.zzd = (zzaed) Preconditions.checkNotNull(zzaedVar);
        zza(null, null, null);
        zzafm.zza(this.zzf, this);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeu
    public final void zza(zzaft zzaftVar, zzaew<zzafw> zzaewVar) {
        Preconditions.checkNotNull(zzaftVar);
        Preconditions.checkNotNull(zzaewVar);
        zzadw zzadwVar = this.zza;
        zzaev.zza(zzadwVar.zza("/createAuthUri", this.zzf), zzaftVar, zzaewVar, zzafw.class, zzadwVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeu
    public final void zza(zzafv zzafvVar, zzaew<Void> zzaewVar) {
        Preconditions.checkNotNull(zzafvVar);
        Preconditions.checkNotNull(zzaewVar);
        zzadw zzadwVar = this.zza;
        zzaev.zza(zzadwVar.zza("/deleteAccount", this.zzf), zzafvVar, zzaewVar, Void.class, zzadwVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeu
    public final void zza(zzafy zzafyVar, zzaew<zzafx> zzaewVar) {
        Preconditions.checkNotNull(zzafyVar);
        Preconditions.checkNotNull(zzaewVar);
        zzadw zzadwVar = this.zza;
        zzaev.zza(zzadwVar.zza("/emailLinkSignin", this.zzf), zzafyVar, zzaewVar, zzafx.class, zzadwVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeu
    public final void zza(zzaga zzagaVar, zzaew<zzafz> zzaewVar) {
        Preconditions.checkNotNull(zzagaVar);
        Preconditions.checkNotNull(zzaewVar);
        zzadz zzadzVar = this.zzb;
        zzadz.zza(zzadzVar.zza("/accounts/mfaEnrollment:finalize", this.zzf), zzagaVar, zzaewVar, zzafz.class, zzadzVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeu
    public final void zza(zzagc zzagcVar, zzaew<zzagb> zzaewVar) {
        Preconditions.checkNotNull(zzagcVar);
        Preconditions.checkNotNull(zzaewVar);
        zzadz zzadzVar = this.zzb;
        zzadz.zza(zzadzVar.zza("/accounts/mfaSignIn:finalize", this.zzf), zzagcVar, zzaewVar, zzagb.class, zzadzVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeu
    public final void zza(zzagk zzagkVar, zzaew<zzagw> zzaewVar) {
        Preconditions.checkNotNull(zzagkVar);
        Preconditions.checkNotNull(zzaewVar);
        zzaez zzaezVar = this.zzc;
        zzaev.zza(zzaezVar.zza("/token", this.zzf), zzagkVar, zzaewVar, zzagw.class, zzaezVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeu
    public final void zza(zzagj zzagjVar, zzaew<zzagm> zzaewVar) {
        Preconditions.checkNotNull(zzagjVar);
        Preconditions.checkNotNull(zzaewVar);
        zzadw zzadwVar = this.zza;
        zzaev.zza(zzadwVar.zza("/getAccountInfo", this.zzf), zzagjVar, zzaewVar, zzagm.class, zzadwVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeu
    public final void zza(zzagn zzagnVar, zzaew<zzagq> zzaewVar) {
        Preconditions.checkNotNull(zzagnVar);
        Preconditions.checkNotNull(zzaewVar);
        if (zzagnVar.zzb() != null) {
            zzb().zzb(zzagnVar.zzb().zze());
        }
        zzadw zzadwVar = this.zza;
        zzaev.zza(zzadwVar.zza("/getOobConfirmationCode", this.zzf), zzagnVar, zzaewVar, zzagq.class, zzadwVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeu
    public final void zza(zzagp zzagpVar, zzaew<zzags> zzaewVar) {
        Preconditions.checkNotNull(zzagpVar);
        Preconditions.checkNotNull(zzaewVar);
        zzadw zzadwVar = this.zza;
        zzaev.zza(zzadwVar.zza("/getRecaptchaParam", this.zzf), zzaewVar, zzags.class, zzadwVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeu
    public final void zza(zzagu zzaguVar, zzaew<zzagt> zzaewVar) {
        Preconditions.checkNotNull(zzaguVar);
        Preconditions.checkNotNull(zzaewVar);
        zzadz zzadzVar = this.zzb;
        String str = zzadzVar.zza("/recaptchaConfig", this.zzf) + "&clientType=" + zzaguVar.zzb() + "&version=" + zzaguVar.zzc();
        if (!zzae.zzc(zzaguVar.zzd())) {
            str = str + "&tenantId=" + zzaguVar.zzd();
        }
        zzaev.zza(str, zzaewVar, zzagt.class, zzadzVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafo
    public final void zza() {
        zza(null, null, null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeu
    public final void zza(zzahd zzahdVar, zzaew<zzahg> zzaewVar) {
        Preconditions.checkNotNull(zzahdVar);
        Preconditions.checkNotNull(zzaewVar);
        zzadw zzadwVar = this.zza;
        zzaev.zza(zzadwVar.zza("/resetPassword", this.zzf), zzahdVar, zzaewVar, zzahg.class, zzadwVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeu
    public final void zza(zzahf zzahfVar, zzaew<zzahh> zzaewVar) {
        Preconditions.checkNotNull(zzahfVar);
        Preconditions.checkNotNull(zzaewVar);
        zzadz zzadzVar = this.zzb;
        zzadz.zza(zzadzVar.zza("/accounts:revokeToken", this.zzf), zzahfVar, zzaewVar, zzahh.class, zzadzVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeu
    public final void zza(zzahk zzahkVar, zzaew<zzahj> zzaewVar) {
        Preconditions.checkNotNull(zzahkVar);
        Preconditions.checkNotNull(zzaewVar);
        if (!TextUtils.isEmpty(zzahkVar.zzc())) {
            zzb().zzb(zzahkVar.zzc());
        }
        zzadw zzadwVar = this.zza;
        zzaev.zza(zzadwVar.zza("/sendVerificationCode", this.zzf), zzahkVar, zzaewVar, zzahj.class, zzadwVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeu
    public final void zza(zzahm zzahmVar, zzaew<zzahl> zzaewVar) {
        Preconditions.checkNotNull(zzahmVar);
        Preconditions.checkNotNull(zzaewVar);
        zzadw zzadwVar = this.zza;
        zzaev.zza(zzadwVar.zza("/setAccountInfo", this.zzf), zzahmVar, zzaewVar, zzahl.class, zzadwVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeu
    public final void zza(String str, zzaew<Void> zzaewVar) {
        Preconditions.checkNotNull(zzaewVar);
        zzb().zza(str);
        zzaewVar.zza((Void) null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeu
    public final void zza(zzahn zzahnVar, zzaew<zzahq> zzaewVar) {
        Preconditions.checkNotNull(zzahnVar);
        Preconditions.checkNotNull(zzaewVar);
        zzadw zzadwVar = this.zza;
        zzaev.zza(zzadwVar.zza("/signupNewUser", this.zzf), zzahnVar, zzaewVar, zzahq.class, zzadwVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeu
    public final void zza(zzahp zzahpVar, zzaew<zzahs> zzaewVar) {
        Preconditions.checkNotNull(zzahpVar);
        Preconditions.checkNotNull(zzaewVar);
        if (zzahpVar instanceof zzaht) {
            zzaht zzahtVar = (zzaht) zzahpVar;
            if (!TextUtils.isEmpty(zzahtVar.zzb())) {
                zzb().zzb(zzahtVar.zzb());
            }
        }
        zzadz zzadzVar = this.zzb;
        zzadz.zza(zzadzVar.zza("/accounts/mfaEnrollment:start", this.zzf), zzahpVar, zzaewVar, zzahs.class, zzadzVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeu
    public final void zza(zzahr zzahrVar, zzaew<zzahu> zzaewVar) {
        Preconditions.checkNotNull(zzahrVar);
        Preconditions.checkNotNull(zzaewVar);
        if (!TextUtils.isEmpty(zzahrVar.zzb())) {
            zzb().zzb(zzahrVar.zzb());
        }
        zzadz zzadzVar = this.zzb;
        zzadz.zza(zzadzVar.zza("/accounts/mfaSignIn:start", this.zzf), zzahrVar, zzaewVar, zzahu.class, zzadzVar.zza);
    }

    private final void zza(zzaez zzaezVar, zzadw zzadwVar, zzadz zzadzVar) {
        this.zzc = null;
        this.zza = null;
        this.zzb = null;
        String strZza = zzafj.zza("firebear.secureToken");
        if (TextUtils.isEmpty(strZza)) {
            strZza = zzafm.zzd(this.zzf);
        } else {
            Log.e("LocalClient", "Found hermetic configuration for secureToken URL: " + strZza);
        }
        if (this.zzc == null) {
            this.zzc = new zzaez(strZza, zzb());
        }
        String strZza2 = zzafj.zza("firebear.identityToolkit");
        if (TextUtils.isEmpty(strZza2)) {
            strZza2 = zzafm.zzb(this.zzf);
        } else {
            Log.e("LocalClient", "Found hermetic configuration for identityToolkit URL: " + strZza2);
        }
        if (this.zza == null) {
            this.zza = new zzadw(strZza2, zzb());
        }
        String strZza3 = zzafj.zza("firebear.identityToolkitV2");
        if (TextUtils.isEmpty(strZza3)) {
            strZza3 = zzafm.zzc(this.zzf);
        } else {
            Log.e("LocalClient", "Found hermetic configuration for identityToolkitV2 URL: " + strZza3);
        }
        if (this.zzb == null) {
            this.zzb = new zzadz(strZza3, zzb());
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeu
    public final void zza(zzaic zzaicVar, zzaew<zzaie> zzaewVar) {
        Preconditions.checkNotNull(zzaicVar);
        Preconditions.checkNotNull(zzaewVar);
        zzadw zzadwVar = this.zza;
        zzaev.zza(zzadwVar.zza("/verifyAssertion", this.zzf), zzaicVar, zzaewVar, zzaie.class, zzadwVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeu
    public final void zza(zzaid zzaidVar, zzaew<zzaig> zzaewVar) {
        Preconditions.checkNotNull(zzaidVar);
        Preconditions.checkNotNull(zzaewVar);
        zzadw zzadwVar = this.zza;
        zzaev.zza(zzadwVar.zza("/verifyCustomToken", this.zzf), zzaidVar, zzaewVar, zzaig.class, zzadwVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeu
    public final void zza(zzaif zzaifVar, zzaew<zzaii> zzaewVar) {
        Preconditions.checkNotNull(zzaifVar);
        Preconditions.checkNotNull(zzaewVar);
        zzadw zzadwVar = this.zza;
        zzaev.zza(zzadwVar.zza("/verifyPassword", this.zzf), zzaifVar, zzaewVar, zzaii.class, zzadwVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeu
    public final void zza(zzaih zzaihVar, zzaew<zzaik> zzaewVar) {
        Preconditions.checkNotNull(zzaihVar);
        Preconditions.checkNotNull(zzaewVar);
        zzadw zzadwVar = this.zza;
        zzaev.zza(zzadwVar.zza("/verifyPhoneNumber", this.zzf), zzaihVar, zzaewVar, zzaik.class, zzadwVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeu
    public final void zza(zzaij zzaijVar, zzaew<zzaim> zzaewVar) {
        Preconditions.checkNotNull(zzaijVar);
        Preconditions.checkNotNull(zzaewVar);
        zzadz zzadzVar = this.zzb;
        zzadz.zza(zzadzVar.zza("/accounts/mfaEnrollment:withdraw", this.zzf), zzaijVar, zzaewVar, zzaim.class, zzadzVar.zza);
    }
}
