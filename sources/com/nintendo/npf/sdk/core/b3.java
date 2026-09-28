package com.nintendo.npf.sdk.core;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.adjust.sdk.Constants;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.ErrorFactory;
import com.nintendo.npf.sdk.internal.app.MiiStudioActivity;
import com.nintendo.npf.sdk.internal.model.Capabilities;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class b3 implements e {
    public static final a h = new a(null);
    private static final String i = "b3";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MiiStudioActivity f416a;
    private final String b;
    private final ErrorFactory c;
    private final Lazy d;
    private boolean e;
    private boolean f;
    private boolean g;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    static final class b extends Lambda implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f417a = new b();

        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final x4 invoke() {
            return x4.a.a();
        }
    }

    static final class c extends Lambda implements Function1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f418a = new c();

        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(Pair pair) {
            Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
            return ((String) pair.component1()) + '=' + URLEncoder.encode((String) pair.component2(), Constants.ENCODING);
        }
    }

    public b3(MiiStudioActivity activity, String naIdToken, ErrorFactory errorFactory) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(naIdToken, "naIdToken");
        Intrinsics.checkNotNullParameter(errorFactory, "errorFactory");
        this.f416a = activity;
        this.b = naIdToken;
        this.c = errorFactory;
        this.d = LazyKt.lazy(b.f417a);
    }

    @Override // com.nintendo.npf.sdk.core.e
    public void a(int i2, int i3, Intent intent) {
    }

    @Override // com.nintendo.npf.sdk.core.e
    public void a(Bundle bundle) {
        this.f416a.requestWindowFeature(1);
        if (bundle != null) {
            this.f = true;
            return;
        }
        String strC = c();
        SDKLog.d(i, "url : " + strC);
        c1 c1Var = c1.f422a;
        MiiStudioActivity miiStudioActivity = this.f416a;
        Uri uri = Uri.parse(strC);
        Intrinsics.checkNotNullExpressionValue(uri, "parse(this)");
        if (c1Var.a(miiStudioActivity, uri)) {
            return;
        }
        NPFError nPFErrorCreate_NintendoAccount_BrowserNotAvailable_403 = this.c.create_NintendoAccount_BrowserNotAvailable_403();
        Intrinsics.checkNotNullExpressionValue(nPFErrorCreate_NintendoAccount_BrowserNotAvailable_403, "errorFactory.create_Nint…BrowserNotAvailable_403()");
        n4.b("mii_studio_error", "MiiStudio#BrowserNotAvailable", nPFErrorCreate_NintendoAccount_BrowserNotAvailable_403);
        a(nPFErrorCreate_NintendoAccount_BrowserNotAvailable_403);
        this.f416a.finish();
    }

    @Override // com.nintendo.npf.sdk.core.e
    public void b(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
    }

    public final String c() {
        Capabilities capabilities = b().getCapabilities();
        String str = capabilities.isUsingHttp() ? "http" : Constants.SCHEME;
        String clientId = capabilities.getClientId();
        try {
            try {
                return str + "://" + capabilities.getAccountHost() + "/mii_studio?" + CollectionsKt.joinToString$default(CollectionsKt.listOf((Object[]) new Pair[]{new Pair("redirect_uri", "npf" + clientId + "://mii_studio"), new Pair("client_id", clientId), new Pair("lang", b().getDeviceDataFacade().getLanguage()), new Pair("id_token_hint", this.b)}), "&", null, null, 0, null, c.f418a, 30, null);
            } catch (UnsupportedEncodingException unused) {
                throw new IllegalArgumentException("clientId=" + clientId);
            }
        } catch (UnsupportedEncodingException unused2) {
        }
    }

    @Override // com.nintendo.npf.sdk.core.e
    public void onResume() {
        SDKLog.i(i, "onResume");
        if (!this.e && !this.f) {
            this.e = true;
        } else {
            if (this.f416a.isFinishing()) {
                return;
            }
            this.f416a.finish();
        }
    }

    private final x4 b() {
        return (x4) this.d.getValue();
    }

    public /* synthetic */ b3(MiiStudioActivity miiStudioActivity, String str, ErrorFactory errorFactory, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(miiStudioActivity, str, (i2 & 4) != 0 ? new ErrorFactory() : errorFactory);
    }

    @Override // com.nintendo.npf.sdk.core.e
    public void a(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        SDKLog.i(i, "onNewIntent");
        if (this.g) {
            return;
        }
        NPFError nPFErrorA = a(intent.getData());
        if (nPFErrorA != null) {
            if (nPFErrorA.getErrorType() == NPFError.ErrorType.USER_CANCEL) {
                n4.b("mii_studio_error", "MiiStudio#UserCanceledOnBrowser", nPFErrorA);
            } else {
                n4.b("mii_studio_error", "MiiStudio#OtherError", nPFErrorA);
            }
        }
        a(nPFErrorA);
        this.f416a.finish();
    }

    @Override // com.nintendo.npf.sdk.core.e
    public void a() {
        SDKLog.i(i, "onDestroy");
        if (this.g) {
            return;
        }
        NPFError nPFError = new NPFError(NPFError.ErrorType.USER_CANCEL, -1, "User canceled for openMiiStudio.");
        n4.b("mii_studio_error", "MiiStudio#BackFromBrowser", nPFError);
        a(nPFError);
    }

    private final void a(NPFError nPFError) {
        this.g = true;
        b().getMiiStudioService().a(nPFError);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00a1  */
    public final NPFError a(Uri uri) {
        String str;
        String str2;
        String query;
        List listSplit$default;
        if (uri == null || (query = uri.getQuery()) == null) {
            str = null;
            str2 = null;
        } else {
            String str3 = !StringsKt.isBlank(query) ? query : null;
            if (str3 == null || (listSplit$default = StringsKt.split$default((CharSequence) str3, new String[]{"&"}, false, 0, 6, (Object) null)) == null) {
                str = null;
                str2 = null;
            } else {
                ArrayList<Pair> arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit$default, 10));
                Iterator it = listSplit$default.iterator();
                while (it.hasNext()) {
                    List listSplit$default2 = StringsKt.split$default((CharSequence) it.next(), new String[]{"="}, false, 0, 6, (Object) null);
                    arrayList.add(new Pair(URLDecoder.decode((String) listSplit$default2.get(0), Constants.ENCODING), URLDecoder.decode((String) listSplit$default2.get(1), Constants.ENCODING)));
                }
                str = null;
                str2 = null;
                for (Pair pair : arrayList) {
                    String str4 = (String) pair.component1();
                    String str5 = (String) pair.component2();
                    if (Intrinsics.areEqual(str4, "error")) {
                        str = str5;
                    } else if (Intrinsics.areEqual(str4, "error_description")) {
                        str2 = str5;
                    }
                }
            }
        }
        if (str != null) {
            if ((!StringsKt.isBlank(str) ? str : null) != null) {
                if (Intrinsics.areEqual(str, "user_canceled")) {
                    return new NPFError(NPFError.ErrorType.USER_CANCEL, -1, str2);
                }
                return new NPFError(NPFError.ErrorType.NPF_ERROR, 4900, str2);
            }
        }
        return null;
    }
}
