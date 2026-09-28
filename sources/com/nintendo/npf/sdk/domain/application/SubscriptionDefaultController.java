package com.nintendo.npf.sdk.domain.application;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.adjust.sdk.Constants;
import com.google.android.gms.common.internal.ImagesContract;
import com.nintendo.npf.sdk.internal.model.Capabilities;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import com.nintendo.npf.sdk.subscription.SubscriptionController;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u0000 \u00172\u00020\u0001:\u0001\rB\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0014R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/nintendo/npf/sdk/domain/application/SubscriptionDefaultController;", "Lcom/nintendo/npf/sdk/subscription/SubscriptionController;", "Lkotlin/Function0;", "Landroid/app/Activity;", "activityProvider", "Lcom/nintendo/npf/sdk/internal/model/Capabilities;", "capabilities", "<init>", "(Lkotlin/jvm/functions/Function0;Lcom/nintendo/npf/sdk/internal/model/Capabilities;)V", "activity", "", ImagesContract.URL, "", "a", "(Landroid/app/Activity;Ljava/lang/String;)V", "openLink", "()V", "productId", "openDeepLink", "(Ljava/lang/String;)V", "Lkotlin/jvm/functions/Function0;", "b", "Lcom/nintendo/npf/sdk/internal/model/Capabilities;", "Companion", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SubscriptionDefaultController implements SubscriptionController {
    private static final String c = "SubscriptionDefaultController";

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Function0 activityProvider;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final Capabilities capabilities;

    public SubscriptionDefaultController(Function0<? extends Activity> activityProvider, Capabilities capabilities) {
        Intrinsics.checkNotNullParameter(activityProvider, "activityProvider");
        Intrinsics.checkNotNullParameter(capabilities, "capabilities");
        this.activityProvider = activityProvider;
        this.capabilities = capabilities;
    }

    private final void a(Activity activity, String url) {
        activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
    }

    @Override // com.nintendo.npf.sdk.subscription.SubscriptionController
    public void openDeepLink(String productId) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        SDKLog.i(c, "openDeepLink is called");
        try {
            String strEncode = URLEncoder.encode(this.capabilities.getPackageName(), Constants.ENCODING);
            Intrinsics.checkNotNullExpressionValue(strEncode, "encode(capabilities.packageName, CHARSET_UTF_8)");
            String strEncode2 = URLEncoder.encode(productId, Constants.ENCODING);
            Intrinsics.checkNotNullExpressionValue(strEncode2, "encode(productId, CHARSET_UTF_8)");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(Locale.US, "%s?package=%s&sku=%s", Arrays.copyOf(new Object[]{"http://play.google.com/store/account/subscriptions", strEncode, strEncode2}, 3));
            Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
            a((Activity) this.activityProvider.invoke(), str);
        } catch (UnsupportedEncodingException e) {
            SDKLog.e(c, "openDeepLink", e);
        }
    }

    @Override // com.nintendo.npf.sdk.subscription.SubscriptionController
    public void openLink() {
        SDKLog.i(c, "openLink is called");
        a((Activity) this.activityProvider.invoke(), "http://play.google.com/store/account/subscriptions");
    }
}
