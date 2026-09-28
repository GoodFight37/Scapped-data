package com.nintendo.npf.sdk.internal.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.nintendo.npf.sdk.core.b3;
import com.nintendo.npf.sdk.core.e;
import com.nintendo.npf.sdk.core.q2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001b2\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\u0003J\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0015\u0010\bJ\u000f\u0010\u0016\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0016\u0010\u0003R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/nintendo/npf/sdk/internal/app/MiiStudioActivity;", "Landroid/app/Activity;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "", "requestCode", "resultCode", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "outState", "onSaveInstanceState", "onDestroy", "Lcom/nintendo/npf/sdk/core/e;", "a", "Lcom/nintendo/npf/sdk/core/e;", "currentStrategy", "b", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MiiStudioActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private e currentStrategy;

    @Override // android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        e eVar = this.currentStrategy;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentStrategy");
            eVar = null;
        }
        eVar.a(requestCode, resultCode, data);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        e q2Var;
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        if (extras == null || extras.getInt("requestCode") != 452) {
            q2Var = new q2(this);
        } else {
            String string = extras.getString("naIdToken");
            Intrinsics.checkNotNull(string);
            q2Var = new b3(this, string, null, 4, null);
        }
        this.currentStrategy = q2Var;
        q2Var.a(savedInstanceState);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        e eVar = this.currentStrategy;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentStrategy");
            eVar = null;
        }
        eVar.a();
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        e eVar = this.currentStrategy;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentStrategy");
            eVar = null;
        }
        eVar.a(intent);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        e eVar = this.currentStrategy;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentStrategy");
            eVar = null;
        }
        eVar.onResume();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        e eVar = this.currentStrategy;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentStrategy");
            eVar = null;
        }
        eVar.b(outState);
    }
}
