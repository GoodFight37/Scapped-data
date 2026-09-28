package com.nintendo.npf.sdk.internal.app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import com.adjust.sdk.Constants;
import com.google.api.client.http.HttpStatusCodes;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.core.a5;
import com.nintendo.npf.sdk.core.c1;
import com.nintendo.npf.sdk.core.d4;
import com.nintendo.npf.sdk.core.e4;
import com.nintendo.npf.sdk.core.k3;
import com.nintendo.npf.sdk.core.l3;
import com.nintendo.npf.sdk.core.m3;
import com.nintendo.npf.sdk.core.x4;
import com.nintendo.npf.sdk.core.z4;
import com.nintendo.npf.sdk.domain.ErrorFactory;
import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u0019\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0014\u0010\u0003R\u0016\u0010\u0017\u001a\u00020\u00158\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0007\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\n\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010 ¨\u0006%"}, d2 = {"Lcom/nintendo/npf/sdk/internal/app/NaAuthenticationActivity;", "Landroidx/activity/ComponentActivity;", "<init>", "()V", "Lcom/nintendo/npf/sdk/core/k3;", MapperConstants.SUBSCRIPTION_FIELD_OWNERSHIP_RESULT, "", "a", "(Lcom/nintendo/npf/sdk/core/k3;)V", "c", "b", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "onResume", "onDestroy", "Lcom/nintendo/npf/sdk/core/l3;", "Lcom/nintendo/npf/sdk/core/l3;", "session", "Lcom/nintendo/npf/sdk/core/x4;", "Lcom/nintendo/npf/sdk/core/x4;", "locator", "Lcom/nintendo/npf/sdk/core/a5;", "Lcom/nintendo/npf/sdk/core/a5;", "mapper", "", "d", "Z", "isRestored", "e", "launched", "f", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NaAuthenticationActivity extends ComponentActivity {

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private l3 session;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private x4 locator;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final a5 mapper = new a5();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private boolean isRestored;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private boolean launched;

    /* JADX INFO: renamed from: com.nintendo.npf.sdk.internal.app.NaAuthenticationActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context, String queryParameter, l3 session) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(queryParameter, "queryParameter");
            Intrinsics.checkNotNullParameter(session, "session");
            Intent intent = new Intent(context, (Class<?>) NaAuthenticationActivity.class);
            intent.putExtra("queryParameter", queryParameter);
            intent.putExtra("session", session);
            return intent;
        }

        private Companion() {
        }
    }

    private final void a(k3 result) {
        int i;
        Intent intentPutExtra = new Intent().putExtra("naAuthorizationResult", result);
        Intrinsics.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(KEY_RESULT, result)");
        if (result instanceof k3.d) {
            i = -1;
        } else {
            if (!(result instanceof k3.c)) {
                throw new NoWhenBranchMatchedException();
            }
            i = 0;
        }
        setResult(i, intentPutExtra);
    }

    private final void b() {
        ErrorFactory errorFactory = new ErrorFactory();
        x4 x4Var = this.locator;
        if (x4Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locator");
            x4Var = null;
        }
        e4 eventDispatcher = x4Var.getEventDispatcher();
        NPFError nPFErrorCreate_NintendoAccount_AuthorizationCanceledClosedApp_Minus1 = errorFactory.create_NintendoAccount_AuthorizationCanceledClosedApp_Minus1();
        Intrinsics.checkNotNullExpressionValue(nPFErrorCreate_NintendoAccount_AuthorizationCanceledClosedApp_Minus1, "errorFactory.create_Nint…anceledClosedApp_Minus1()");
        eventDispatcher.a(nPFErrorCreate_NintendoAccount_AuthorizationCanceledClosedApp_Minus1);
    }

    private final void c() {
        Intent intentPutExtra = new Intent().putExtra("naAuthorizationResult", new k3.c(NPFError.ErrorType.USER_CANCEL, -1, "User canceled for authorization", null, null, this.isRestored, 24, null));
        Intrinsics.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(KEY_RESULT, result)");
        setResult(0, intentPutExtra);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        this.isRestored = savedInstanceState != null;
        SDKLog.i("NaAuthenticationActivity", "onCreate, isRestored: " + this.isRestored);
        x4.a.a(getApplication());
        x4 x4VarA = x4.a.a();
        Intrinsics.checkNotNullExpressionValue(x4VarA, "getInstance()");
        this.locator = x4VarA;
        Intent intent = getIntent();
        x4 x4Var = null;
        Bundle extras = intent != null ? intent.getExtras() : null;
        if (extras == null) {
            SDKLog.e("NaAuthenticationActivity", "Intent extras is null");
            finish();
            return;
        }
        String string = extras.getString("queryParameter");
        l3 l3Var = (l3) d4.a(extras, "session", l3.class);
        if (string == null || l3Var == null) {
            SDKLog.d("NaAuthenticationActivity", "This app was relaunched from the authentication browser after task kill.");
            b();
            startActivity(getPackageManager().getLaunchIntentForPackage(getPackageName()));
            finish();
            return;
        }
        this.session = l3Var;
        if (this.isRestored) {
            return;
        }
        x4 x4Var2 = this.locator;
        if (x4Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locator");
            x4Var2 = null;
        }
        StringBuilder sbAppend = new StringBuilder().append(x4Var2.getHostInformationDataFacade().i() ? "http" : Constants.SCHEME).append("://");
        x4 x4Var3 = this.locator;
        if (x4Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locator");
        } else {
            x4Var = x4Var3;
        }
        String string2 = sbAppend.append(x4Var.getHostInformationDataFacade().e()).append("/connect/1.0.0/authorize?").append(string).toString();
        SDKLog.d("NaAuthenticationActivity", "url: " + string2);
        c1 c1Var = c1.f422a;
        Uri uri = Uri.parse(string2);
        Intrinsics.checkNotNullExpressionValue(uri, "parse(this)");
        if (c1Var.a(this, uri)) {
            return;
        }
        a();
        finish();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        SDKLog.i("NaAuthenticationActivity", "onDestroy");
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        SDKLog.i("NaAuthenticationActivity", "onNewIntent");
        setIntent(intent);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        SDKLog.i("NaAuthenticationActivity", "onResume");
        Intent intent = getIntent();
        l3 l3Var = null;
        if ((intent != null ? intent.getData() : null) == null) {
            if (!this.launched && !this.isRestored) {
                this.launched = true;
                return;
            } else {
                c();
                finish();
                return;
            }
        }
        a5 a5Var = this.mapper;
        Intent intent2 = getIntent();
        z4 z4VarA = a5Var.a(intent2 != null ? intent2.getData() : null);
        m3 m3Var = m3.f522a;
        l3 l3Var2 = this.session;
        if (l3Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("session");
        } else {
            l3Var = l3Var2;
        }
        a(m3Var.a(l3Var, z4VarA, this.isRestored));
        finish();
    }

    private final void a() {
        Intent intentPutExtra = new Intent().putExtra("naAuthorizationResult", new k3.c(NPFError.ErrorType.NPF_ERROR, HttpStatusCodes.STATUS_CODE_FORBIDDEN, "Browser is not available", null, null, this.isRestored, 24, null));
        Intrinsics.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(KEY_RESULT, result)");
        setResult(0, intentPutExtra);
    }
}
