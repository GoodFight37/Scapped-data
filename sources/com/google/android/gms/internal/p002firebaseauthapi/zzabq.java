package com.google.android.gms.internal.p002firebaseauthapi;

import android.app.Activity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.ActionCodeResult;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.PhoneMultiFactorAssertion;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.auth.TotpMultiFactorAssertion;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzab;
import com.google.firebase.auth.internal.zzaf;
import com.google.firebase.auth.internal.zzah;
import com.google.firebase.auth.internal.zzam;
import com.google.firebase.auth.internal.zzau;
import com.google.firebase.auth.internal.zzav;
import com.google.firebase.auth.internal.zzbk;
import com.google.firebase.auth.internal.zzcc;
import com.google.firebase.auth.internal.zzl;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzabq extends zzaep {
    public final Task<Void> zza(FirebaseApp firebaseApp, String str, String str2) {
        return zza((zzabt) new zzabt(str, str2).zza(firebaseApp));
    }

    public final Task<ActionCodeResult> zzb(FirebaseApp firebaseApp, String str, String str2) {
        return zza((zzabs) new zzabs(str, str2).zza(firebaseApp));
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, String str, String str2, String str3) {
        return zza((zzabv) new zzabv(str, str2, str3).zza(firebaseApp));
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, String str, String str2, String str3, String str4, zzl zzlVar) {
        return zza((zzabu) new zzabu(str, str2, str3, str4).zza(firebaseApp).zza(zzlVar));
    }

    public final Task<Void> zza(FirebaseUser firebaseUser, zzav zzavVar) {
        return zza((zzabx) new zzabx().zza(firebaseUser).zza(zzavVar).zza((zzau) zzavVar));
    }

    public final Task<SignInMethodQueryResult> zzc(FirebaseApp firebaseApp, String str, String str2) {
        return zza((zzabw) new zzabw(str, str2).zza(firebaseApp));
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, PhoneMultiFactorAssertion phoneMultiFactorAssertion, FirebaseUser firebaseUser, String str, zzl zzlVar) {
        zzafc.zza();
        zzabz zzabzVar = new zzabz(phoneMultiFactorAssertion, firebaseUser.zze(), str, null);
        zzabzVar.zza(firebaseApp).zza(zzlVar);
        return zza(zzabzVar);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, TotpMultiFactorAssertion totpMultiFactorAssertion, FirebaseUser firebaseUser, String str, String str2, zzl zzlVar) {
        zzabz zzabzVar = new zzabz(totpMultiFactorAssertion, firebaseUser.zze(), str, str2);
        zzabzVar.zza(firebaseApp).zza(zzlVar);
        return zza(zzabzVar);
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneMultiFactorAssertion phoneMultiFactorAssertion, String str, zzl zzlVar) {
        zzafc.zza();
        zzaby zzabyVar = new zzaby(phoneMultiFactorAssertion, str, null);
        zzabyVar.zza(firebaseApp).zza(zzlVar);
        if (firebaseUser != null) {
            zzabyVar.zza(firebaseUser);
        }
        return zza(zzabyVar);
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, TotpMultiFactorAssertion totpMultiFactorAssertion, String str, String str2, zzl zzlVar) {
        zzaby zzabyVar = new zzaby(totpMultiFactorAssertion, str, str2);
        zzabyVar.zza(firebaseApp).zza(zzlVar);
        if (firebaseUser != null) {
            zzabyVar.zza(firebaseUser);
        }
        return zza(zzabyVar);
    }

    public final Task<GetTokenResult> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzcc zzccVar) {
        return zza((zzacb) new zzacb(str).zza(firebaseApp).zza(firebaseUser).zza(zzccVar).zza((zzau) zzccVar));
    }

    public final Task<zzags> zza() {
        return zza(new zzaca());
    }

    public final Task<zzagt> zza(String str, String str2) {
        return zza(new zzacd(str, str2));
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, String str, zzcc zzccVar) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(authCredential);
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzccVar);
        List<String> listZzg = firebaseUser.zzg();
        if (listZzg != null && listZzg.contains(authCredential.getProvider())) {
            return Tasks.forException(zzadr.zza(new Status(FirebaseError.ERROR_PROVIDER_ALREADY_LINKED)));
        }
        if (authCredential instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredential;
            if (!emailAuthCredential.zzf()) {
                return zza((zzacc) new zzacc(emailAuthCredential, str).zza(firebaseApp).zza(firebaseUser).zza(zzccVar).zza((zzau) zzccVar));
            }
            return zza((zzach) new zzach(emailAuthCredential).zza(firebaseApp).zza(firebaseUser).zza(zzccVar).zza((zzau) zzccVar));
        }
        if (authCredential instanceof PhoneAuthCredential) {
            zzafc.zza();
            return zza((zzace) new zzace((PhoneAuthCredential) authCredential).zza(firebaseApp).zza(firebaseUser).zza(zzccVar).zza((zzau) zzccVar));
        }
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(authCredential);
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzccVar);
        return zza((zzacf) new zzacf(authCredential).zza(firebaseApp).zza(firebaseUser).zza(zzccVar).zza((zzau) zzccVar));
    }

    public final Task<Void> zzb(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, String str, zzcc zzccVar) {
        return zza((zzacg) new zzacg(authCredential, str).zza(firebaseApp).zza(firebaseUser).zza(zzccVar).zza((zzau) zzccVar));
    }

    public final Task<AuthResult> zzc(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, String str, zzcc zzccVar) {
        return zza((zzacj) new zzacj(authCredential, str).zza(firebaseApp).zza(firebaseUser).zza(zzccVar).zza((zzau) zzccVar));
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential, String str, zzcc zzccVar) {
        return zza((zzaci) new zzaci(emailAuthCredential, str).zza(firebaseApp).zza(firebaseUser).zza(zzccVar).zza((zzau) zzccVar));
    }

    public final Task<AuthResult> zzb(FirebaseApp firebaseApp, FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential, String str, zzcc zzccVar) {
        return zza((zzacl) new zzacl(emailAuthCredential, str).zza(firebaseApp).zza(firebaseUser).zza(zzccVar).zza((zzau) zzccVar));
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, String str2, String str3, String str4, zzcc zzccVar) {
        return zza((zzack) new zzack(str, str2, str3, str4).zza(firebaseApp).zza(firebaseUser).zza(zzccVar).zza((zzau) zzccVar));
    }

    public final Task<AuthResult> zzb(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, String str2, String str3, String str4, zzcc zzccVar) {
        return zza((zzacn) new zzacn(str, str2, str3, str4).zza(firebaseApp).zza(firebaseUser).zza(zzccVar).zza((zzau) zzccVar));
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, String str, zzcc zzccVar) {
        zzafc.zza();
        return zza((zzacm) new zzacm(phoneAuthCredential, str).zza(firebaseApp).zza(firebaseUser).zza(zzccVar).zza((zzau) zzccVar));
    }

    public final Task<AuthResult> zzb(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, String str, zzcc zzccVar) {
        zzafc.zza();
        return zza((zzacp) new zzacp(phoneAuthCredential, str).zza(firebaseApp).zza(firebaseUser).zza(zzccVar).zza((zzau) zzccVar));
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, zzcc zzccVar) {
        return zza((zzaco) new zzaco().zza(firebaseApp).zza(firebaseUser).zza(zzccVar).zza((zzau) zzccVar));
    }

    public final Task<Void> zza(String str, String str2, String str3, String str4) {
        return zza(new zzacr(str, str2, str3, str4));
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, ActionCodeSettings actionCodeSettings, String str) {
        return zza((zzacq) new zzacq(str, actionCodeSettings).zza(firebaseApp));
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, String str, ActionCodeSettings actionCodeSettings, String str2, String str3) {
        actionCodeSettings.zza(1);
        return zza((zzact) new zzact(str, actionCodeSettings, str2, str3, "sendPasswordResetEmail").zza(firebaseApp));
    }

    public final Task<Void> zzb(FirebaseApp firebaseApp, String str, ActionCodeSettings actionCodeSettings, String str2, String str3) {
        actionCodeSettings.zza(6);
        return zza((zzact) new zzact(str, actionCodeSettings, str2, str3, "sendSignInLinkToEmail").zza(firebaseApp));
    }

    public final Task<Void> zza(String str) {
        return zza(new zzacs(str));
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, zzl zzlVar, String str) {
        return zza((zzacv) new zzacv(str).zza(firebaseApp).zza(zzlVar));
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, AuthCredential authCredential, String str, zzl zzlVar) {
        return zza((zzacu) new zzacu(authCredential, str).zza(firebaseApp).zza(zzlVar));
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, String str, String str2, zzl zzlVar) {
        return zza((zzacx) new zzacx(str, str2).zza(firebaseApp).zza(zzlVar));
    }

    public final Task<AuthResult> zzb(FirebaseApp firebaseApp, String str, String str2, String str3, String str4, zzl zzlVar) {
        return zza((zzacw) new zzacw(str, str2, str3, str4).zza(firebaseApp).zza(zzlVar));
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, EmailAuthCredential emailAuthCredential, String str, zzl zzlVar) {
        return zza((zzacz) new zzacz(emailAuthCredential, str).zza(firebaseApp).zza(zzlVar));
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, PhoneAuthCredential phoneAuthCredential, String str, zzl zzlVar) {
        zzafc.zza();
        return zza((zzacy) new zzacy(phoneAuthCredential, str).zza(firebaseApp).zza(zzlVar));
    }

    public final Task<Void> zza(zzam zzamVar, String str, String str2, long j, boolean z, boolean z2, String str3, String str4, String str5, boolean z3, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Executor executor, Activity activity) {
        zzadb zzadbVar = new zzadb(zzamVar, str, str2, j, z, z2, str3, str4, str5, z3);
        zzadbVar.zza(onVerificationStateChangedCallbacks, activity, executor, str);
        return zza(zzadbVar);
    }

    public final Task<zzahs> zza(zzam zzamVar, String str) {
        return zza(new zzada(zzamVar, str));
    }

    public final Task<Void> zza(zzam zzamVar, PhoneMultiFactorInfo phoneMultiFactorInfo, String str, long j, boolean z, boolean z2, String str2, String str3, String str4, boolean z3, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Executor executor, Activity activity) {
        zzadd zzaddVar = new zzadd(phoneMultiFactorInfo, Preconditions.checkNotEmpty(zzamVar.zzc()), str, j, z, z2, str2, str3, str4, z3);
        zzaddVar.zza(onVerificationStateChangedCallbacks, activity, executor, phoneMultiFactorInfo.getUid());
        return zza(zzaddVar);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, String str2, zzcc zzccVar) {
        return zza((zzadc) new zzadc(firebaseUser.zze(), str, str2).zza(firebaseApp).zza(firebaseUser).zza(zzccVar).zza((zzau) zzccVar));
    }

    public final Task<AuthResult> zzb(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzcc zzccVar) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzccVar);
        List<String> listZzg = firebaseUser.zzg();
        if ((listZzg != null && !listZzg.contains(str)) || firebaseUser.isAnonymous()) {
            return Tasks.forException(zzadr.zza(new Status(FirebaseError.ERROR_NO_SUCH_PROVIDER, str)));
        }
        str.hashCode();
        if (str.equals("password")) {
            return zza((zzadf) new zzadf().zza(firebaseApp).zza(firebaseUser).zza(zzccVar).zza((zzau) zzccVar));
        }
        return zza((zzade) new zzade(str).zza(firebaseApp).zza(firebaseUser).zza(zzccVar).zza((zzau) zzccVar));
    }

    public final Task<Void> zzc(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzcc zzccVar) {
        return zza((zzadh) new zzadh(str).zza(firebaseApp).zza(firebaseUser).zza(zzccVar).zza((zzau) zzccVar));
    }

    public final Task<Void> zzd(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzcc zzccVar) {
        return zza((zzadg) new zzadg(str).zza(firebaseApp).zza(firebaseUser).zza(zzccVar).zza((zzau) zzccVar));
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, zzcc zzccVar) {
        zzafc.zza();
        return zza((zzadj) new zzadj(phoneAuthCredential).zza(firebaseApp).zza(firebaseUser).zza(zzccVar).zza((zzau) zzccVar));
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, UserProfileChangeRequest userProfileChangeRequest, zzcc zzccVar) {
        return zza((zzadi) new zzadi(userProfileChangeRequest).zza(firebaseApp).zza(firebaseUser).zza(zzccVar).zza((zzau) zzccVar));
    }

    public final Task<Void> zza(String str, String str2, ActionCodeSettings actionCodeSettings) {
        actionCodeSettings.zza(7);
        return zza(new zzadl(str, str2, actionCodeSettings));
    }

    public final Task<String> zzd(FirebaseApp firebaseApp, String str, String str2) {
        return zza((zzadk) new zzadk(str, str2).zza(firebaseApp));
    }

    static zzaf zza(FirebaseApp firebaseApp, zzagl zzaglVar) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(zzaglVar);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new zzab(zzaglVar, FirebaseAuthProvider.PROVIDER_ID));
        List<zzahc> listZzl = zzaglVar.zzl();
        if (listZzl != null && !listZzl.isEmpty()) {
            for (int i = 0; i < listZzl.size(); i++) {
                arrayList.add(new zzab(listZzl.get(i)));
            }
        }
        zzaf zzafVar = new zzaf(firebaseApp, arrayList);
        zzafVar.zza(new zzah(zzaglVar.zzb(), zzaglVar.zza()));
        zzafVar.zza(zzaglVar.zzn());
        zzafVar.zza(zzaglVar.zze());
        zzafVar.zzc(zzbk.zza(zzaglVar.zzk()));
        zzafVar.zzb(zzaglVar.zzd());
        return zzafVar;
    }

    public zzabq(FirebaseApp firebaseApp, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        this.zza = new zzado(firebaseApp, scheduledExecutorService);
        this.zzb = executor;
    }

    public final void zza(FirebaseApp firebaseApp, zzahk zzahkVar, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Activity activity, Executor executor) {
        zza((zzadn) new zzadn(zzahkVar).zza(firebaseApp).zza(onVerificationStateChangedCallbacks, activity, executor, zzahkVar.zzd()));
    }
}
