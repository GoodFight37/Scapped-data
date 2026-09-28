package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzao;
import com.google.firebase.auth.zzc;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzzv {
    private final zzaeu zza;

    static /* synthetic */ void zza(zzzv zzzvVar, zzaie zzaieVar, zzadp zzadpVar, zzaet zzaetVar) {
        if (!zzaieVar.zzo()) {
            zzzvVar.zza(new zzagw(zzaieVar.zzi(), zzaieVar.zze(), Long.valueOf(zzaieVar.zza()), "Bearer"), zzaieVar.zzh(), zzaieVar.zzg(), Boolean.valueOf(zzaieVar.zzn()), zzaieVar.zzb(), zzadpVar, zzaetVar);
            return;
        }
        zzadpVar.zza(new zzzt(zzaieVar.zzm() ? new Status(FirebaseError.ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL) : zzao.zza(zzaieVar.zzd()), zzaieVar.zzb(), zzaieVar.zzc(), zzaieVar.zzj()));
    }

    static /* synthetic */ void zza(zzzv zzzvVar, zzadp zzadpVar, zzahn zzahnVar, zzaet zzaetVar) {
        Preconditions.checkNotNull(zzadpVar);
        Preconditions.checkNotNull(zzahnVar);
        Preconditions.checkNotNull(zzaetVar);
        zzzvVar.zza.zza(zzahnVar, new zzaak(zzzvVar, zzadpVar, zzaetVar));
    }

    static /* synthetic */ void zza(zzzv zzzvVar, zzadp zzadpVar, zzagw zzagwVar, zzahm zzahmVar, zzaet zzaetVar) {
        Preconditions.checkNotNull(zzadpVar);
        Preconditions.checkNotNull(zzagwVar);
        Preconditions.checkNotNull(zzahmVar);
        Preconditions.checkNotNull(zzaetVar);
        zzzvVar.zza.zza(new zzagj(zzagwVar.zzc()), new zzaab(zzzvVar, zzaetVar, zzadpVar, zzagwVar, zzahmVar));
    }

    static /* synthetic */ void zza(zzzv zzzvVar, zzadp zzadpVar, zzagw zzagwVar, zzagl zzaglVar, zzahm zzahmVar, zzaet zzaetVar) {
        Preconditions.checkNotNull(zzadpVar);
        Preconditions.checkNotNull(zzagwVar);
        Preconditions.checkNotNull(zzaglVar);
        Preconditions.checkNotNull(zzahmVar);
        Preconditions.checkNotNull(zzaetVar);
        zzzvVar.zza.zza(zzahmVar, new zzaaa(zzzvVar, zzahmVar, zzaglVar, zzadpVar, zzagwVar, zzaetVar));
    }

    public zzzv(zzaeu zzaeuVar) {
        this.zza = (zzaeu) Preconditions.checkNotNull(zzaeuVar);
    }

    public final void zza(String str, String str2, zzadp zzadpVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzadpVar);
        zzahm zzahmVar = new zzahm();
        zzahmVar.zze(str);
        zzahmVar.zzh(str2);
        this.zza.zza(zzahmVar, new zzabp(this, zzadpVar));
    }

    public final void zzb(String str, String str2, zzadp zzadpVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzadpVar);
        zza(str, new zzabn(this, str2, zzadpVar));
    }

    public final void zzc(String str, String str2, zzadp zzadpVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzadpVar);
        zza(str, new zzabm(this, str2, zzadpVar));
    }

    public final void zzd(String str, String str2, zzadp zzadpVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzadpVar);
        this.zza.zza(new zzahd(str, null, str2), new zzaae(this, zzadpVar));
    }

    public final void zza(zzahd zzahdVar, zzadp zzadpVar) {
        Preconditions.checkNotEmpty(zzahdVar.zzb());
        Preconditions.checkNotNull(zzadpVar);
        this.zza.zza(zzahdVar, new zzaag(this, zzadpVar));
    }

    public final void zza(String str, String str2, String str3, String str4, zzadp zzadpVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzadpVar);
        this.zza.zza(new zzahn(str, str2, null, str3, str4, null), new zzzx(this, zzadpVar));
    }

    public final void zza(String str, zzadp zzadpVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzadpVar);
        zza(str, new zzabe(this, zzadpVar));
    }

    private final void zza(String str, zzaew<zzagw> zzaewVar) {
        Preconditions.checkNotNull(zzaewVar);
        Preconditions.checkNotEmpty(str);
        zzagw zzagwVarZzb = zzagw.zzb(str);
        if (zzagwVarZzb.zzg()) {
            zzaewVar.zza(zzagwVarZzb);
        } else {
            this.zza.zza(new zzagk(zzagwVarZzb.zzd()), new zzabo(this, zzaewVar));
        }
    }

    public final void zza(zzaga zzagaVar, String str, zzadp zzadpVar) {
        Preconditions.checkNotNull(zzagaVar);
        Preconditions.checkNotNull(zzadpVar);
        zza(str, new zzaaw(this, zzagaVar, zzadpVar));
    }

    public final void zza(zzagc zzagcVar, zzadp zzadpVar) {
        Preconditions.checkNotNull(zzagcVar);
        Preconditions.checkNotNull(zzadpVar);
        this.zza.zza(zzagcVar, new zzaay(this, zzadpVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzafy zzafyVar, zzadp zzadpVar) {
        Preconditions.checkNotNull(zzafyVar);
        Preconditions.checkNotNull(zzadpVar);
        this.zza.zza(zzafyVar, new zzzy(this, zzadpVar));
    }

    public final void zzb(String str, zzadp zzadpVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzadpVar);
        this.zza.zza(new zzagk(str), new zzzu(this, zzadpVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzagw zzagwVar, String str, String str2, Boolean bool, zzc zzcVar, zzadp zzadpVar, zzaet zzaetVar) {
        Preconditions.checkNotNull(zzagwVar);
        Preconditions.checkNotNull(zzaetVar);
        Preconditions.checkNotNull(zzadpVar);
        this.zza.zza(new zzagj(zzagwVar.zzc()), new zzaad(this, zzaetVar, str2, str, bool, zzcVar, zzadpVar, zzagwVar));
    }

    private final void zzd(zzagn zzagnVar, zzadp zzadpVar) {
        Preconditions.checkNotNull(zzagnVar);
        Preconditions.checkNotNull(zzadpVar);
        this.zza.zza(zzagnVar, new zzabj(this, zzadpVar));
    }

    public final void zza(zzagp zzagpVar, zzadp zzadpVar) {
        Preconditions.checkNotNull(zzagpVar);
        Preconditions.checkNotNull(zzadpVar);
        this.zza.zza(zzagpVar, new zzabd(this, zzadpVar));
    }

    public final void zze(String str, String str2, zzadp zzadpVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzadpVar);
        this.zza.zza(new zzaft(str, str2), new zzaac(this, zzadpVar));
    }

    public final void zza(zzagu zzaguVar, zzadp zzadpVar) {
        Preconditions.checkNotNull(zzaguVar);
        Preconditions.checkNotNull(zzadpVar);
        this.zza.zza(zzaguVar, new zzaba(this, zzadpVar));
    }

    public final void zza(String str, String str2, String str3, String str4, String str5, zzadp zzadpVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzadpVar);
        zza(str3, new zzaal(this, str, str2, str4, str5, zzadpVar));
    }

    public final void zza(String str, zzaic zzaicVar, zzadp zzadpVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaicVar);
        Preconditions.checkNotNull(zzadpVar);
        zza(str, new zzaap(this, zzaicVar, zzadpVar));
    }

    public final void zza(String str, zzaih zzaihVar, zzadp zzadpVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaihVar);
        Preconditions.checkNotNull(zzadpVar);
        zza(str, new zzaan(this, zzaihVar, zzadpVar));
    }

    public final void zzc(String str, zzadp zzadpVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzadpVar);
        zza(str, new zzabc(this, zzadpVar));
    }

    public final void zza(zzahf zzahfVar, zzadp zzadpVar) {
        this.zza.zza(zzahfVar, new zzabl(this, zzadpVar));
    }

    public final void zza(zzagn zzagnVar, zzadp zzadpVar) {
        Preconditions.checkNotEmpty(zzagnVar.zzd());
        Preconditions.checkNotNull(zzadpVar);
        zzd(zzagnVar, zzadpVar);
    }

    public final void zzb(zzagn zzagnVar, zzadp zzadpVar) {
        Preconditions.checkNotEmpty(zzagnVar.zzc());
        Preconditions.checkNotNull(zzadpVar);
        this.zza.zza(zzagnVar, new zzaaf(this, zzadpVar));
    }

    public final void zza(zzahk zzahkVar, zzadp zzadpVar) {
        Preconditions.checkNotEmpty(zzahkVar.zzd());
        Preconditions.checkNotNull(zzadpVar);
        this.zza.zza(zzahkVar, new zzaaj(this, zzadpVar));
    }

    public final void zzd(String str, zzadp zzadpVar) {
        Preconditions.checkNotNull(zzadpVar);
        this.zza.zza(str, new zzabg(this, zzadpVar));
    }

    public final void zze(String str, zzadp zzadpVar) {
        Preconditions.checkNotNull(zzadpVar);
        this.zza.zza(new zzahn(str), new zzabi(this, zzadpVar));
    }

    public final void zza(zzaic zzaicVar, zzadp zzadpVar) {
        Preconditions.checkNotNull(zzaicVar);
        Preconditions.checkNotNull(zzadpVar);
        zzaicVar.zzb(true);
        this.zza.zza(zzaicVar, new zzaau(this, zzadpVar));
    }

    public final void zza(zzaid zzaidVar, zzadp zzadpVar) {
        Preconditions.checkNotNull(zzaidVar);
        Preconditions.checkNotNull(zzadpVar);
        this.zza.zza(zzaidVar, new zzaah(this, zzadpVar));
    }

    public final void zzb(String str, String str2, String str3, String str4, zzadp zzadpVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzadpVar);
        this.zza.zza(new zzaif(str, str2, str3, str4), new zzzw(this, zzadpVar));
    }

    public final void zza(EmailAuthCredential emailAuthCredential, String str, zzadp zzadpVar) {
        Preconditions.checkNotNull(emailAuthCredential);
        Preconditions.checkNotNull(zzadpVar);
        if (emailAuthCredential.zzg()) {
            zza(emailAuthCredential.zzb(), new zzzz(this, emailAuthCredential, str, zzadpVar));
        } else {
            zza(new zzafy(emailAuthCredential, null, str), zzadpVar);
        }
    }

    public final void zza(zzaih zzaihVar, zzadp zzadpVar) {
        Preconditions.checkNotNull(zzaihVar);
        Preconditions.checkNotNull(zzadpVar);
        this.zza.zza(zzaihVar, new zzaai(this, zzadpVar));
    }

    public final void zza(zzahp zzahpVar, zzadp zzadpVar) {
        Preconditions.checkNotNull(zzahpVar);
        Preconditions.checkNotNull(zzadpVar);
        this.zza.zza(zzahpVar, new zzaax(this, zzahpVar, zzadpVar));
    }

    public final void zza(zzahr zzahrVar, zzadp zzadpVar) {
        Preconditions.checkNotNull(zzahrVar);
        Preconditions.checkNotNull(zzadpVar);
        this.zza.zza(zzahrVar, new zzabb(this, zzadpVar));
    }

    public final void zza(String str, String str2, String str3, zzadp zzadpVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzadpVar);
        zza(str, new zzaas(this, str2, str3, zzadpVar));
    }

    public final void zzf(String str, zzadp zzadpVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzadpVar);
        zza(str, new zzaar(this, zzadpVar));
    }

    public final void zzf(String str, String str2, zzadp zzadpVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzadpVar);
        zza(str2, new zzaaq(this, str, zzadpVar));
    }

    public final void zza(String str, UserProfileChangeRequest userProfileChangeRequest, zzadp zzadpVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(userProfileChangeRequest);
        Preconditions.checkNotNull(zzadpVar);
        zza(str, new zzabk(this, userProfileChangeRequest, zzadpVar));
    }

    public final void zzc(zzagn zzagnVar, zzadp zzadpVar) {
        zzd(zzagnVar, zzadpVar);
    }
}
