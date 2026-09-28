package com.nintendo.npf.sdk.user;

import android.app.Activity;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.NPFSDK;
import com.nintendo.npf.sdk.core.j0;
import com.nintendo.npf.sdk.core.x4;
import com.nintendo.npf.sdk.inquiry.InquiryStatus;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\bC\n\u0002\u0010%\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0004z{|}B\t\b\u0017¢\u0006\u0004\b\u0002\u0010\u0003B\u008b\u0001\b\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\u0004\b\u0002\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010#\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b#\u0010$JK\u0010+\u001a\u00020\"2\u0006\u0010&\u001a\u00020%2\u0010\u0010(\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010'2\u0018\u0010)\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00172\b\u0010!\u001a\u0004\u0018\u00010*¢\u0006\u0004\b+\u0010,JI\u0010-\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010%2\u0010\u0010(\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010'2\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00172\b\u0010!\u001a\u0004\u0018\u00010*¢\u0006\u0004\b-\u0010,J\u0017\u0010.\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010*¢\u0006\u0004\b.\u0010/J\u0017\u00101\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u000100¢\u0006\u0004\b1\u00102R*\u0010\u0005\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u00048\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R.\u00109\u001a\u0004\u0018\u00010\u00042\b\u00103\u001a\u0004\u0018\u00010\u00048\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u00104\u001a\u0004\b:\u00106\"\u0004\b;\u00108R.\u0010<\u001a\u0004\u0018\u00010\u00042\b\u00103\u001a\u0004\u0018\u00010\u00048\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u00104\u001a\u0004\b=\u00106\"\u0004\b>\u00108R.\u0010?\u001a\u0004\u0018\u00010\u00042\b\u00103\u001a\u0004\u0018\u00010\u00048\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u00104\u001a\u0004\b@\u00106\"\u0004\bA\u00108R.\u0010B\u001a\u0004\u0018\u00010\u00042\b\u00103\u001a\u0004\u0018\u00010\u00048\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u00104\u001a\u0004\bC\u00106\"\u0004\bD\u00108R$\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u00104\u001a\u0004\bE\u00106\"\u0004\bF\u00108R$\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u00104\u001a\u0004\bG\u00106\"\u0004\bH\u00108R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\"\u0010\f\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010N\u001a\u0004\bS\u0010P\"\u0004\bT\u0010RR\"\u0010\r\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010N\u001a\u0004\bU\u0010P\"\u0004\bV\u0010RR*\u0010\u000f\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u000e8\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R*\u0010\u0010\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u000e8\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010W\u001a\u0004\b\\\u0010Y\"\u0004\b]\u0010[R.\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u00103\u001a\u0004\u0018\u00010\u00148\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR.\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u00103\u001a\u0004\u0018\u00010\u001e8\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR*\u0010\u0016\u001a\u00020\u00112\u0006\u00103\u001a\u00020\u00118\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\"\u0010\u0012\u001a\u00020\u00118\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010h\u001a\u0004\bm\u0010j\"\u0004\bn\u0010lR\"\u0010\u0013\u001a\u00020\u00118\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010h\u001a\u0004\bo\u0010j\"\u0004\bp\u0010lR\"\u0010q\u001a\u00020\u00118\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bq\u0010h\u001a\u0004\br\u0010j\"\u0004\bs\u0010lR.\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00180t8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010y¨\u0006~"}, d2 = {"Lcom/nintendo/npf/sdk/user/BaaSUser;", "", "<init>", "()V", "", "userId", "nickname", "country", "Lcom/nintendo/npf/sdk/user/Gender;", "gender", "", "birthdayYear", "birthdayMonth", "birthdayDay", "", "personalAnalytics", "personalNotification", "", "personalAnalyticsUpdatedAt", "personalNotificationUpdatedAt", "Lcom/nintendo/npf/sdk/inquiry/InquiryStatus;", "inquiryStatus", "createdAt", "", "Lcom/nintendo/npf/sdk/user/LinkedAccount;", "linkedAccounts", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/nintendo/npf/sdk/user/Gender;IIIZZJJLcom/nintendo/npf/sdk/inquiry/InquiryStatus;JLjava/util/Map;)V", "Lcom/nintendo/npf/sdk/core/j0;", "a", "()Lcom/nintendo/npf/sdk/core/j0;", "Lcom/nintendo/npf/sdk/user/NintendoAccount;", "nintendoAccount", "Lcom/nintendo/npf/sdk/user/BaaSUser$LinkNintendoAccountCallback;", "callback", "", "linkNintendoAccount", "(Lcom/nintendo/npf/sdk/user/NintendoAccount;Lcom/nintendo/npf/sdk/user/BaaSUser$LinkNintendoAccountCallback;)V", "Landroid/app/Activity;", "activity", "", "scope", "profileSource", "Lcom/nintendo/npf/sdk/user/BaaSUser$SwitchByNintendoAccountCallback;", "switchByNintendoAccount", "(Landroid/app/Activity;Ljava/util/List;Ljava/util/Map;Lcom/nintendo/npf/sdk/user/BaaSUser$SwitchByNintendoAccountCallback;)V", "switchByNintendoAccount2", "retryPendingSwitchByNintendoAccount2", "(Lcom/nintendo/npf/sdk/user/BaaSUser$SwitchByNintendoAccountCallback;)V", "Lcom/nintendo/npf/sdk/user/BaaSUser$SaveCallback;", "save", "(Lcom/nintendo/npf/sdk/user/BaaSUser$SaveCallback;)V", "<set-?>", "Ljava/lang/String;", "getUserId", "()Ljava/lang/String;", "setUserId$NPFSDK_release", "(Ljava/lang/String;)V", "idToken", "getIdToken", "setIdToken$NPFSDK_release", "accessToken", "getAccessToken", "setAccessToken$NPFSDK_release", "deviceAccount", "getDeviceAccount", "setDeviceAccount$NPFSDK_release", "devicePassword", "getDevicePassword", "setDevicePassword$NPFSDK_release", "getNickname", "setNickname", "getCountry", "setCountry", "Lcom/nintendo/npf/sdk/user/Gender;", "getGender", "()Lcom/nintendo/npf/sdk/user/Gender;", "setGender", "(Lcom/nintendo/npf/sdk/user/Gender;)V", "I", "getBirthdayYear", "()I", "setBirthdayYear", "(I)V", "getBirthdayMonth", "setBirthdayMonth", "getBirthdayDay", "setBirthdayDay", "Z", "getPersonalAnalytics", "()Z", "setPersonalAnalytics$NPFSDK_release", "(Z)V", "getPersonalNotification", "setPersonalNotification$NPFSDK_release", "Lcom/nintendo/npf/sdk/inquiry/InquiryStatus;", "getInquiryStatus", "()Lcom/nintendo/npf/sdk/inquiry/InquiryStatus;", "setInquiryStatus$NPFSDK_release", "(Lcom/nintendo/npf/sdk/inquiry/InquiryStatus;)V", "Lcom/nintendo/npf/sdk/user/NintendoAccount;", "getNintendoAccount", "()Lcom/nintendo/npf/sdk/user/NintendoAccount;", "setNintendoAccount$NPFSDK_release", "(Lcom/nintendo/npf/sdk/user/NintendoAccount;)V", "J", "getCreatedAt", "()J", "setCreatedAt$NPFSDK_release", "(J)V", "getPersonalAnalyticsUpdatedAt$NPFSDK_release", "setPersonalAnalyticsUpdatedAt$NPFSDK_release", "getPersonalNotificationUpdatedAt$NPFSDK_release", "setPersonalNotificationUpdatedAt$NPFSDK_release", "expiresTime", "getExpiresTime$NPFSDK_release", "setExpiresTime$NPFSDK_release", "", "Ljava/util/Map;", "getLinkedAccounts$NPFSDK_release", "()Ljava/util/Map;", "setLinkedAccounts$NPFSDK_release", "(Ljava/util/Map;)V", "AuthorizationCallback", "LinkNintendoAccountCallback", "SaveCallback", "SwitchByNintendoAccountCallback", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BaaSUser {
    private String accessToken;
    private int birthdayDay;
    private int birthdayMonth;
    private int birthdayYear;
    private String country;
    private long createdAt;
    private String deviceAccount;
    private String devicePassword;
    private long expiresTime;
    private Gender gender;
    private String idToken;
    private InquiryStatus inquiryStatus;
    private Map<String, LinkedAccount> linkedAccounts;
    private String nickname;
    private NintendoAccount nintendoAccount;
    private boolean personalAnalytics;
    private long personalAnalyticsUpdatedAt;
    private boolean personalNotification;
    private long personalNotificationUpdatedAt;
    private String userId;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/nintendo/npf/sdk/user/BaaSUser$AuthorizationCallback;", "", "onComplete", "", "user", "Lcom/nintendo/npf/sdk/user/BaaSUser;", "error", "Lcom/nintendo/npf/sdk/NPFError;", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface AuthorizationCallback {
        void onComplete(BaaSUser user, NPFError error);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/nintendo/npf/sdk/user/BaaSUser$LinkNintendoAccountCallback;", "", "onComplete", "", "error", "Lcom/nintendo/npf/sdk/NPFError;", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface LinkNintendoAccountCallback {
        void onComplete(NPFError error);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/nintendo/npf/sdk/user/BaaSUser$SaveCallback;", "", "onComplete", "", "error", "Lcom/nintendo/npf/sdk/NPFError;", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface SaveCallback {
        void onComplete(NPFError error);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH&¨\u0006\u000b"}, d2 = {"Lcom/nintendo/npf/sdk/user/BaaSUser$SwitchByNintendoAccountCallback;", "", "onComplete", "", "oldUserId", "", "newUserId", "nintendoAccount", "Lcom/nintendo/npf/sdk/user/NintendoAccount;", "error", "Lcom/nintendo/npf/sdk/NPFError;", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface SwitchByNintendoAccountCallback {
        void onComplete(String oldUserId, String newUserId, NintendoAccount nintendoAccount, NPFError error);
    }

    static final class a extends Lambda implements Function1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LinkNintendoAccountCallback f897a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(LinkNintendoAccountCallback linkNintendoAccountCallback) {
            super(1);
            this.f897a = linkNintendoAccountCallback;
        }

        public final void a(NPFError nPFError) {
            LinkNintendoAccountCallback linkNintendoAccountCallback = this.f897a;
            if (linkNintendoAccountCallback != null) {
                linkNintendoAccountCallback.onComplete(nPFError);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((NPFError) obj);
            return Unit.INSTANCE;
        }
    }

    static final class b extends Lambda implements Function1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SaveCallback f898a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(SaveCallback saveCallback) {
            super(1);
            this.f898a = saveCallback;
        }

        public final void a(NPFError nPFError) {
            SaveCallback saveCallback = this.f898a;
            if (saveCallback != null) {
                saveCallback.onComplete(nPFError);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((NPFError) obj);
            return Unit.INSTANCE;
        }
    }

    public BaaSUser() {
        this.userId = "";
        this.gender = Gender.UNKNOWN;
        this.linkedAccounts = new HashMap();
    }

    private final j0 a() {
        j0 baasUser = x4.a.a().getBaasUser();
        Intrinsics.checkNotNullExpressionValue(baasUser, "getInstance().baasUser");
        return baasUser;
    }

    public final String getAccessToken() {
        return this.accessToken;
    }

    public final int getBirthdayDay() {
        return this.birthdayDay;
    }

    public final int getBirthdayMonth() {
        return this.birthdayMonth;
    }

    public final int getBirthdayYear() {
        return this.birthdayYear;
    }

    public final String getCountry() {
        return this.country;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final String getDeviceAccount() {
        return this.deviceAccount;
    }

    public final String getDevicePassword() {
        return this.devicePassword;
    }

    /* JADX INFO: renamed from: getExpiresTime$NPFSDK_release, reason: from getter */
    public final long getExpiresTime() {
        return this.expiresTime;
    }

    public final Gender getGender() {
        return this.gender;
    }

    public final String getIdToken() {
        return this.idToken;
    }

    public final InquiryStatus getInquiryStatus() {
        return this.inquiryStatus;
    }

    public final Map<String, LinkedAccount> getLinkedAccounts$NPFSDK_release() {
        return this.linkedAccounts;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final NintendoAccount getNintendoAccount() {
        return this.nintendoAccount;
    }

    public final boolean getPersonalAnalytics() {
        return this.personalAnalytics;
    }

    /* JADX INFO: renamed from: getPersonalAnalyticsUpdatedAt$NPFSDK_release, reason: from getter */
    public final long getPersonalAnalyticsUpdatedAt() {
        return this.personalAnalyticsUpdatedAt;
    }

    public final boolean getPersonalNotification() {
        return this.personalNotification;
    }

    /* JADX INFO: renamed from: getPersonalNotificationUpdatedAt$NPFSDK_release, reason: from getter */
    public final long getPersonalNotificationUpdatedAt() {
        return this.personalNotificationUpdatedAt;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void linkNintendoAccount(NintendoAccount nintendoAccount, LinkNintendoAccountCallback callback) {
        Intrinsics.checkNotNullParameter(nintendoAccount, "nintendoAccount");
        NPFSDK.getBaasAccountService().linkNintendoAccount(nintendoAccount, new a(callback));
    }

    public final void retryPendingSwitchByNintendoAccount2(final SwitchByNintendoAccountCallback callback) {
        a().a(new SwitchByNintendoAccountCallback() { // from class: com.nintendo.npf.sdk.user.BaaSUser.retryPendingSwitchByNintendoAccount2.1
            @Override // com.nintendo.npf.sdk.user.BaaSUser.SwitchByNintendoAccountCallback
            public void onComplete(String oldUserId, String newUserId, NintendoAccount nintendoAccount, NPFError error) {
                SwitchByNintendoAccountCallback switchByNintendoAccountCallback = callback;
                if (switchByNintendoAccountCallback != null) {
                    switchByNintendoAccountCallback.onComplete(oldUserId, newUserId, nintendoAccount, error);
                }
            }
        });
    }

    public final void save(SaveCallback callback) {
        NPFSDK.getBaasAccountService().save(new b(callback));
    }

    public final void setAccessToken$NPFSDK_release(String str) {
        this.accessToken = str;
    }

    public final void setBirthdayDay(int i) {
        this.birthdayDay = i;
    }

    public final void setBirthdayMonth(int i) {
        this.birthdayMonth = i;
    }

    public final void setBirthdayYear(int i) {
        this.birthdayYear = i;
    }

    public final void setCountry(String str) {
        this.country = str;
    }

    public final void setCreatedAt$NPFSDK_release(long j) {
        this.createdAt = j;
    }

    public final void setDeviceAccount$NPFSDK_release(String str) {
        this.deviceAccount = str;
    }

    public final void setDevicePassword$NPFSDK_release(String str) {
        this.devicePassword = str;
    }

    public final void setExpiresTime$NPFSDK_release(long j) {
        this.expiresTime = j;
    }

    public final void setGender(Gender gender) {
        Intrinsics.checkNotNullParameter(gender, "<set-?>");
        this.gender = gender;
    }

    public final void setIdToken$NPFSDK_release(String str) {
        this.idToken = str;
    }

    public final void setInquiryStatus$NPFSDK_release(InquiryStatus inquiryStatus) {
        this.inquiryStatus = inquiryStatus;
    }

    public final void setLinkedAccounts$NPFSDK_release(Map<String, LinkedAccount> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.linkedAccounts = map;
    }

    public final void setNickname(String str) {
        this.nickname = str;
    }

    public final void setNintendoAccount$NPFSDK_release(NintendoAccount nintendoAccount) {
        this.nintendoAccount = nintendoAccount;
    }

    public final void setPersonalAnalytics$NPFSDK_release(boolean z) {
        this.personalAnalytics = z;
    }

    public final void setPersonalAnalyticsUpdatedAt$NPFSDK_release(long j) {
        this.personalAnalyticsUpdatedAt = j;
    }

    public final void setPersonalNotification$NPFSDK_release(boolean z) {
        this.personalNotification = z;
    }

    public final void setPersonalNotificationUpdatedAt$NPFSDK_release(long j) {
        this.personalNotificationUpdatedAt = j;
    }

    public final void setUserId$NPFSDK_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userId = str;
    }

    public final void switchByNintendoAccount(Activity activity, List<String> scope, Map<String, String> profileSource, final SwitchByNintendoAccountCallback callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        a().a(this, activity, scope, new SwitchByNintendoAccountCallback() { // from class: com.nintendo.npf.sdk.user.BaaSUser.switchByNintendoAccount.1
            @Override // com.nintendo.npf.sdk.user.BaaSUser.SwitchByNintendoAccountCallback
            public void onComplete(String oldUserId, String newUserId, NintendoAccount nintendoAccount, NPFError error) {
                SwitchByNintendoAccountCallback switchByNintendoAccountCallback = callback;
                if (switchByNintendoAccountCallback != null) {
                    switchByNintendoAccountCallback.onComplete(oldUserId, newUserId, nintendoAccount, error);
                }
            }
        });
    }

    public final void switchByNintendoAccount2(Activity activity, List<String> scope, Map<String, String> profileSource, final SwitchByNintendoAccountCallback callback) {
        j0 j0VarA = a();
        Intrinsics.checkNotNull(activity);
        j0VarA.a(activity, scope, new SwitchByNintendoAccountCallback() { // from class: com.nintendo.npf.sdk.user.BaaSUser.switchByNintendoAccount2.1
            @Override // com.nintendo.npf.sdk.user.BaaSUser.SwitchByNintendoAccountCallback
            public void onComplete(String oldUserId, String newUserId, NintendoAccount nintendoAccount, NPFError error) {
                SwitchByNintendoAccountCallback switchByNintendoAccountCallback = callback;
                if (switchByNintendoAccountCallback != null) {
                    switchByNintendoAccountCallback.onComplete(oldUserId, newUserId, nintendoAccount, error);
                }
            }
        });
    }

    public BaaSUser(String userId, String str, String str2, Gender gender, int i, int i2, int i3, boolean z, boolean z2, long j, long j2, InquiryStatus inquiryStatus, long j3, Map<String, LinkedAccount> linkedAccounts) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(linkedAccounts, "linkedAccounts");
        this.userId = userId;
        this.nickname = str;
        this.country = str2;
        this.gender = gender;
        this.birthdayYear = i;
        this.birthdayMonth = i2;
        this.birthdayDay = i3;
        this.personalAnalytics = z;
        this.personalNotification = z2;
        this.personalAnalyticsUpdatedAt = j;
        this.personalNotificationUpdatedAt = j2;
        this.inquiryStatus = inquiryStatus;
        this.createdAt = j3;
        this.linkedAccounts = MapsKt.toMutableMap(linkedAccounts);
    }
}
