package com.google.android.gms.internal.p002firebaseauthapi;

import android.app.Activity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.internal.zzau;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzaeg<ResultT, CallbackT> implements zzaer<ResultT> {
    protected final int zza;
    protected FirebaseApp zzc;
    protected FirebaseUser zzd;
    protected CallbackT zze;
    protected zzau zzf;
    protected zzaeh<ResultT> zzg;
    protected Executor zzi;
    protected zzagw zzj;
    protected zzagl zzk;
    protected zzafw zzl;
    protected zzahg zzm;
    protected AuthCredential zzn;
    protected String zzo;
    protected String zzp;
    protected zzzs zzq;
    protected zzagt zzr;
    protected zzags zzs;
    protected zzahs zzt;
    private boolean zzu;
    protected final zzaei zzb = new zzaei(this);
    protected final List<PhoneAuthProvider.OnVerificationStateChangedCallbacks> zzh = new ArrayList();

    public final zzaeg<ResultT, CallbackT> zza(CallbackT callbackt) {
        this.zze = (CallbackT) Preconditions.checkNotNull(callbackt, "external callback cannot be null");
        return this;
    }

    public abstract void zzb();

    public final zzaeg<ResultT, CallbackT> zza(zzau zzauVar) {
        this.zzf = (zzau) Preconditions.checkNotNull(zzauVar, "external failure callback cannot be null");
        return this;
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    private static class zza extends LifecycleCallback {
        private final List<PhoneAuthProvider.OnVerificationStateChangedCallbacks> zza;

        private zza(LifecycleFragment lifecycleFragment, List<PhoneAuthProvider.OnVerificationStateChangedCallbacks> list) {
            super(lifecycleFragment);
            this.mLifecycleFragment.addCallback("PhoneAuthActivityStopCallback", this);
            this.zza = list;
        }

        public static void zza(Activity activity, List<PhoneAuthProvider.OnVerificationStateChangedCallbacks> list) {
            LifecycleFragment fragment = getFragment(activity);
            if (((zza) fragment.getCallbackOrNull("PhoneAuthActivityStopCallback", zza.class)) == null) {
                new zza(fragment, list);
            }
        }

        @Override // com.google.android.gms.common.api.internal.LifecycleCallback
        public void onStop() {
            synchronized (this.zza) {
                this.zza.clear();
            }
        }
    }

    public final zzaeg<ResultT, CallbackT> zza(FirebaseApp firebaseApp) {
        this.zzc = (FirebaseApp) Preconditions.checkNotNull(firebaseApp, "firebaseApp cannot be null");
        return this;
    }

    public final zzaeg<ResultT, CallbackT> zza(FirebaseUser firebaseUser) {
        this.zzd = (FirebaseUser) Preconditions.checkNotNull(firebaseUser, "firebaseUser cannot be null");
        return this;
    }

    public final zzaeg<ResultT, CallbackT> zza(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Activity activity, Executor executor, String str) {
        PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacksZza = zzafc.zza(str, onVerificationStateChangedCallbacks, this);
        synchronized (this.zzh) {
            this.zzh.add((PhoneAuthProvider.OnVerificationStateChangedCallbacks) Preconditions.checkNotNull(onVerificationStateChangedCallbacksZza));
        }
        if (activity != null) {
            zza.zza(activity, this.zzh);
        }
        this.zzi = (Executor) Preconditions.checkNotNull(executor);
        return this;
    }

    static /* synthetic */ void zza(zzaeg zzaegVar) {
        zzaegVar.zzb();
        Preconditions.checkState(zzaegVar.zzu, "no success or failure set on method implementation");
    }

    static /* synthetic */ void zza(zzaeg zzaegVar, Status status) {
        zzau zzauVar = zzaegVar.zzf;
        if (zzauVar != null) {
            zzauVar.zza(status);
        }
    }

    public zzaeg(int i) {
        this.zza = i;
    }

    public final void zza(Status status) {
        this.zzu = true;
        this.zzg.zza(null, status);
    }

    public final void zzb(ResultT resultt) {
        this.zzu = true;
        this.zzg.zza(resultt, null);
    }
}
