package com.nintendo.npf.sdk.core;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.internal.app.AppActivityTracker;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class j3 extends Fragment {
    public static final b e = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private o3 f498a;
    private Function0 b;
    private boolean c;
    private boolean d;

    private static final class a extends Exception {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f499a;
        private final Throwable b;

        public /* synthetic */ a(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : th);
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.b;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.f499a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String message, Throwable th) {
            super(message, th);
            Intrinsics.checkNotNullParameter(message, "message");
            this.f499a = message;
            this.b = th;
        }
    }

    public static final class b {

        static final class a extends Lambda implements Function0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ j3 f500a;
            final /* synthetic */ Intent b;
            final /* synthetic */ int c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(j3 j3Var, Intent intent, int i) {
                super(0);
                this.f500a = j3Var;
                this.b = intent;
                this.c = i;
            }

            public final void a() {
                this.f500a.startActivityForResult(this.b, this.c);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(boolean z) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("isLegacyMode", z);
            return bundle;
        }

        private b() {
        }

        public final k3.c a(Activity activity, int i, Intent intent, boolean z) {
            Object objM248constructorimpl;
            Intrinsics.checkNotNullParameter(activity, "activity");
            j3 j3Var = new j3();
            j3Var.a(new a(j3Var, intent, i));
            j3Var.setArguments(j3.e.a(z));
            try {
                Result.Companion companion = Result.INSTANCE;
                a(activity, j3Var);
                objM248constructorimpl = Result.m248constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM248constructorimpl = Result.m248constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m251exceptionOrNullimpl(objM248constructorimpl) != null) {
                try {
                    Result.Companion companion3 = Result.INSTANCE;
                    j3.e.a(AppActivityTracker.f725a.getForegroundActivity(), j3Var);
                    objM248constructorimpl = Result.m248constructorimpl(Unit.INSTANCE);
                } catch (Throwable th2) {
                    Result.Companion companion4 = Result.INSTANCE;
                    objM248constructorimpl = Result.m248constructorimpl(ResultKt.createFailure(th2));
                }
            }
            Throwable thM251exceptionOrNullimpl = Result.m251exceptionOrNullimpl(objM248constructorimpl);
            if (!(thM251exceptionOrNullimpl instanceof a)) {
                return null;
            }
            SDKLog.e("NaAuthenticationFragment", "startActivityForResult:", thM251exceptionOrNullimpl);
            a aVar = (a) thM251exceptionOrNullimpl;
            return new k3.c(NPFError.ErrorType.USER_CANCEL, -1, aVar.getMessage(), "NAAuth3#InvalidStateActivity", "cause=" + aVar.getMessage(), false, 32, null);
        }

        private final void a(Activity activity, j3 j3Var) throws a {
            byte b = 0;
            byte b2 = 0;
            FragmentManager fragmentManager = activity != null ? activity.getFragmentManager() : null;
            if (fragmentManager != null) {
                Fragment fragmentFindFragmentByTag = fragmentManager.findFragmentByTag("com.nintendo.npf.sdk.na_authentication_fragment_tag");
                j3 j3Var2 = fragmentFindFragmentByTag instanceof j3 ? (j3) fragmentFindFragmentByTag : null;
                boolean z = j3Var2 != null;
                try {
                    FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
                    if (z) {
                        fragmentTransactionBeginTransaction.remove(j3Var2);
                    }
                    fragmentTransactionBeginTransaction.add(j3Var, "com.nintendo.npf.sdk.na_authentication_fragment_tag").commit();
                    fragmentManager.executePendingTransactions();
                    return;
                } catch (IllegalStateException e) {
                    throw new a("Can not perform this actions after onSaveInstance State.", e);
                }
            }
            throw new a("FragmentManager is null.", b2 == true ? 1 : 0, 2, b == true ? 1 : 0);
        }
    }

    public final void a(Function0 function0) {
        this.b = function0;
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.c = bundle != null;
        SDKLog.i("NaAuthenticationFragment", "onActivityCreated: isRestored=" + this.c);
        x4.a.a(getActivity().getApplication());
        o3 naAuthorizationHandler = x4.a.a().getNaAuthorizationHandler();
        Intrinsics.checkNotNullExpressionValue(naAuthorizationHandler, "getInstance().naAuthorizationHandler");
        this.f498a = naAuthorizationHandler;
        Bundle arguments = getArguments();
        this.d = arguments != null ? arguments.getBoolean("isLegacyMode") : false;
        Function0 function0 = this.b;
        if (function0 != null) {
            function0.invoke();
            this.b = null;
        }
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        k3 cVar;
        Bundle extras;
        super.onActivityResult(i, i2, intent);
        SDKLog.i("NaAuthenticationFragment", "onActivityResult: resultCode=" + i2 + ", requestCode=" + i);
        q3 q3VarA = q3.b.a(i);
        if (q3VarA != null) {
            int iC = q3VarA.c();
            if (intent == null || (extras = intent.getExtras()) == null || (cVar = (k3) d4.a(extras, "naAuthorizationResult", k3.class)) == null) {
                cVar = new k3.c(NPFError.ErrorType.USER_CANCEL, -1, "User canceled for authorization", null, null, this.c, 24, null);
            }
            o3 o3Var = null;
            if (this.d) {
                o3 o3Var2 = this.f498a;
                if (o3Var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("naAuthorizationHandler");
                } else {
                    o3Var = o3Var2;
                }
                o3Var.b(iC, cVar);
            } else {
                o3 o3Var3 = this.f498a;
                if (o3Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("naAuthorizationHandler");
                } else {
                    o3Var = o3Var3;
                }
                o3Var.a(iC, cVar);
            }
            try {
                getFragmentManager().beginTransaction().remove(this).commit();
            } catch (Exception e2) {
                SDKLog.e("NaAuthenticationFragment", "Failed remove fragment.", e2);
            }
        }
    }

    @Override // android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        SDKLog.i("NaAuthenticationFragment", "onSaveInstanceState");
        if (bundle != null) {
            bundle.putBoolean("isRestored", true);
        }
    }
}
