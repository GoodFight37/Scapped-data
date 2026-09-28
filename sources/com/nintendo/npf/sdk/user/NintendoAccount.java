package com.nintendo.npf.sdk.user;

import android.app.Activity;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.NPFSDK;
import com.nintendo.npf.sdk.core.x4;
import com.unity.androidnotifications.UnityNotificationManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b=\u0018\u0000 [2\u00020\u0001:\u0003[Y\\B\t\b\u0017¢\u0006\u0004\b\u0002\u0010\u0003BÅ\u0001\b\u0017\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0002\u0010\u001eJ\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u000fH\u0016¢\u0006\u0004\b#\u0010$R.\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010%\u001a\u0004\u0018\u00010\u00048\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R*\u0010\u0007\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00068\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R.\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010%\u001a\u0004\u0018\u00010\u00048\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010&\u001a\u0004\b0\u0010(\"\u0004\b1\u0010*R.\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010%\u001a\u0004\u0018\u00010\t8\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R.\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010%\u001a\u0004\u0018\u00010\u00048\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010&\u001a\u0004\b7\u0010(\"\u0004\b8\u0010*R.\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010%\u001a\u0004\u0018\u00010\u00048\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010&\u001a\u0004\b9\u0010(\"\u0004\b:\u0010*R.\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010%\u001a\u0004\u0018\u00010\u00048\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010&\u001a\u0004\b;\u0010(\"\u0004\b<\u0010*R.\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010%\u001a\u0004\u0018\u00010\u00048\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010&\u001a\u0004\b=\u0010(\"\u0004\b>\u0010*R.\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010%\u001a\u0004\u0018\u00010\u000f8\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR.\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\b\u0010%\u001a\u0004\u0018\u00010\u000f8\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010?\u001a\u0004\bD\u0010A\"\u0004\bE\u0010CR.\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\b\u0010%\u001a\u0004\u0018\u00010\u000f8\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010?\u001a\u0004\bF\u0010A\"\u0004\bG\u0010CR.\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010%\u001a\u0004\u0018\u00010\u00048\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010&\u001a\u0004\bH\u0010(\"\u0004\bI\u0010*R.\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010%\u001a\u0004\u0018\u00010\u00048\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010&\u001a\u0004\bJ\u0010(\"\u0004\bK\u0010*R.\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010%\u001a\u0004\u0018\u00010\u00158\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR.\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010%\u001a\u0004\u0018\u00010\u00048\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010&\u001a\u0004\bQ\u0010(\"\u0004\bR\u0010*R.\u0010\u0019\u001a\u0004\u0018\u00010\u00042\b\u0010%\u001a\u0004\u0018\u00010\u00048\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010&\u001a\u0004\bS\u0010(\"\u0004\bT\u0010*R*\u0010\u0017\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00048\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010&\u001a\u0004\bU\u0010(\"\u0004\bV\u0010*R.\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010%\u001a\u0004\u0018\u00010\u00048\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010&\u001a\u0004\bW\u0010(\"\u0004\bX\u0010*R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010&R\u0016\u0010\u001c\u001a\u00020\u001b8\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\bY\u0010Z¨\u0006]"}, d2 = {"Lcom/nintendo/npf/sdk/user/NintendoAccount;", "", "<init>", "()V", "", "nintendoAccountId", "Lcom/nintendo/npf/sdk/user/NintendoAccount$Type;", "type", "nickname", "Lcom/nintendo/npf/sdk/user/Gender;", "gender", "language", "country", "region", "timezone", "", "birthdayYear", "birthdayMonth", "birthdayDay", "email", "nintendoNetworkId", "Lcom/nintendo/npf/sdk/user/Mii;", "mii", "screenName", "idToken", "accessToken", "sessionToken", "", "expiresTime", "iconUri", "(Ljava/lang/String;Lcom/nintendo/npf/sdk/user/NintendoAccount$Type;Ljava/lang/String;Lcom/nintendo/npf/sdk/user/Gender;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Lcom/nintendo/npf/sdk/user/Mii;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "o", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "<set-?>", "Ljava/lang/String;", "getNintendoAccountId", "()Ljava/lang/String;", "setNintendoAccountId$NPFSDK_release", "(Ljava/lang/String;)V", "Lcom/nintendo/npf/sdk/user/NintendoAccount$Type;", "getType", "()Lcom/nintendo/npf/sdk/user/NintendoAccount$Type;", "setType$NPFSDK_release", "(Lcom/nintendo/npf/sdk/user/NintendoAccount$Type;)V", "getNickname", "setNickname$NPFSDK_release", "Lcom/nintendo/npf/sdk/user/Gender;", "getGender", "()Lcom/nintendo/npf/sdk/user/Gender;", "setGender$NPFSDK_release", "(Lcom/nintendo/npf/sdk/user/Gender;)V", "getLanguage", "setLanguage$NPFSDK_release", "getCountry", "setCountry$NPFSDK_release", "getRegion", "setRegion$NPFSDK_release", "getTimezone", "setTimezone$NPFSDK_release", "Ljava/lang/Integer;", "getBirthdayYear", "()Ljava/lang/Integer;", "setBirthdayYear$NPFSDK_release", "(Ljava/lang/Integer;)V", "getBirthdayMonth", "setBirthdayMonth$NPFSDK_release", "getBirthdayDay", "setBirthdayDay$NPFSDK_release", "getEmail", "setEmail$NPFSDK_release", "getNintendoNetworkId", "setNintendoNetworkId$NPFSDK_release", "Lcom/nintendo/npf/sdk/user/Mii;", "getMii", "()Lcom/nintendo/npf/sdk/user/Mii;", "setMii$NPFSDK_release", "(Lcom/nintendo/npf/sdk/user/Mii;)V", "getIdToken", "setIdToken$NPFSDK_release", "getAccessToken", "setAccessToken$NPFSDK_release", "getScreenName", "setScreenName$NPFSDK_release", "getIconUri", "setIconUri$NPFSDK_release", "a", "J", "Companion", "Type", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NintendoAccount {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public transient long expiresTime;
    private String accessToken;
    private Integer birthdayDay;
    private Integer birthdayMonth;
    private Integer birthdayYear;
    private String country;
    private String email;
    private Gender gender;
    private String iconUri;
    private String idToken;
    private String language;
    private Mii mii;
    private String nickname;
    private String nintendoAccountId;
    private String nintendoNetworkId;
    private String region;
    private String screenName;
    public String sessionToken;
    private String timezone;
    private Type type;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007¨\u0006\t"}, d2 = {"Lcom/nintendo/npf/sdk/user/NintendoAccount$Companion;", "", "()V", "openMiiStudio", "", "activity", "Landroid/app/Activity;", "callback", "Lcom/nintendo/npf/sdk/NPFSDK$NPFErrorCallback;", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void openMiiStudio(Activity activity, final NPFSDK.NPFErrorCallback callback) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            a.f917a.a().getMiiStudioService().a(activity, new NPFSDK.NPFErrorCallback() { // from class: com.nintendo.npf.sdk.user.NintendoAccount$Companion$openMiiStudio$1
                @Override // com.nintendo.npf.sdk.NPFSDK.NPFErrorCallback
                public void onComplete(NPFError error) {
                    NPFSDK.NPFErrorCallback nPFErrorCallback = callback;
                    if (nPFErrorCallback != null) {
                        nPFErrorCallback.onComplete(error);
                    }
                }
            });
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/nintendo/npf/sdk/user/NintendoAccount$Type;", "", "", UnityNotificationManager.KEY_ID, "<init>", "(Ljava/lang/String;II)V", "a", "I", "UNKNOWN", "GENERAL", "CHILD", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum Type {
        UNKNOWN(0),
        GENERAL(1),
        CHILD(2);


        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int id;

        Type(int i) {
            this.id = i;
        }
    }

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f917a = new a();
        private static final x4 b = x4.a.a();

        private a() {
        }

        public final x4 a() {
            return b;
        }
    }

    public NintendoAccount() {
        this.type = Type.UNKNOWN;
        this.birthdayYear = 0;
        this.birthdayMonth = 0;
        this.birthdayDay = 0;
        this.screenName = "";
    }

    @JvmStatic
    public static final void openMiiStudio(Activity activity, NPFSDK.NPFErrorCallback nPFErrorCallback) {
        INSTANCE.openMiiStudio(activity, nPFErrorCallback);
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x00f6, code lost:
    
        r2 = r4.idToken;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x00f8, code lost:
    
        if (r2 == null) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0100, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, r5.idToken) != false) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0105, code lost:
    
        if (r5.idToken == null) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0107, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0108, code lost:
    
        r2 = r4.accessToken;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x010a, code lost:
    
        if (r2 == null) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0112, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, r5.accessToken) != false) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0117, code lost:
    
        if (r5.accessToken == null) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0119, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x011a, code lost:
    
        r2 = r4.iconUri;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x011c, code lost:
    
        if (r2 == null) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0124, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, r5.iconUri) != false) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0129, code lost:
    
        if (r5.iconUri == null) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x012b, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x012c, code lost:
    
        r2 = r4.sessionToken;
        r5 = r5.sessionToken;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0130, code lost:
    
        if (r2 == null) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0136, code lost:
    
        return kotlin.jvm.internal.Intrinsics.areEqual(r2, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0137, code lost:
    
        if (r5 != null) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0139, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x00e3, code lost:
    
        if (r2.equals(r5.mii) == false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x00e8, code lost:
    
        if (r5.mii != null) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x00ea, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x00f3, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r4.screenName, r5.screenName) != false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x00f5, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean equals(java.lang.Object r5) {
        /*
            Method dump skipped, instruction units count: 315
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nintendo.npf.sdk.user.NintendoAccount.equals(java.lang.Object):boolean");
    }

    public final String getAccessToken() {
        return this.accessToken;
    }

    public final Integer getBirthdayDay() {
        return this.birthdayDay;
    }

    public final Integer getBirthdayMonth() {
        return this.birthdayMonth;
    }

    public final Integer getBirthdayYear() {
        return this.birthdayYear;
    }

    public final String getCountry() {
        return this.country;
    }

    public final String getEmail() {
        return this.email;
    }

    public final Gender getGender() {
        return this.gender;
    }

    public final String getIconUri() {
        return this.iconUri;
    }

    public final String getIdToken() {
        return this.idToken;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final Mii getMii() {
        return this.mii;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final String getNintendoAccountId() {
        return this.nintendoAccountId;
    }

    public final String getNintendoNetworkId() {
        return this.nintendoNetworkId;
    }

    public final String getRegion() {
        return this.region;
    }

    public final String getScreenName() {
        return this.screenName;
    }

    public final String getTimezone() {
        return this.timezone;
    }

    public final Type getType() {
        return this.type;
    }

    public int hashCode() {
        String str;
        String str2 = this.nintendoAccountId;
        int iHashCode = 0;
        int iHashCode2 = ((((str2 == null || str2 == null) ? 0 : str2.hashCode()) * 31) + this.type.hashCode()) * 31;
        String str3 = this.nickname;
        int iHashCode3 = (iHashCode2 + ((str3 == null || str3 == null) ? 0 : str3.hashCode())) * 31;
        Gender gender = this.gender;
        int iHashCode4 = (iHashCode3 + ((gender == null || gender == null) ? 0 : gender.hashCode())) * 31;
        String str4 = this.language;
        int iHashCode5 = (iHashCode4 + ((str4 == null || str4 == null) ? 0 : str4.hashCode())) * 31;
        String str5 = this.country;
        int iHashCode6 = (iHashCode5 + ((str5 == null || str5 == null) ? 0 : str5.hashCode())) * 31;
        String str6 = this.region;
        int iHashCode7 = (iHashCode6 + ((str6 == null || str6 == null) ? 0 : str6.hashCode())) * 31;
        String str7 = this.timezone;
        int iHashCode8 = (iHashCode7 + ((str7 == null || str7 == null) ? 0 : str7.hashCode())) * 31;
        Integer num = this.birthdayYear;
        int iIntValue = (iHashCode8 + (num != null ? num.intValue() : 0)) * 31;
        Integer num2 = this.birthdayMonth;
        int iIntValue2 = (iIntValue + (num2 != null ? num2.intValue() : 0)) * 31;
        Integer num3 = this.birthdayDay;
        int iIntValue3 = (iIntValue2 + (num3 != null ? num3.intValue() : 0)) * 31;
        String str8 = this.email;
        int iHashCode9 = (iIntValue3 + ((str8 == null || str8 == null) ? 0 : str8.hashCode())) * 31;
        String str9 = this.nintendoNetworkId;
        int iHashCode10 = (iHashCode9 + ((str9 == null || str9 == null) ? 0 : str9.hashCode())) * 31;
        Mii mii = this.mii;
        int iHashCode11 = (((iHashCode10 + ((mii == null || mii == null) ? 0 : mii.hashCode())) * 31) + this.screenName.hashCode()) * 31;
        String str10 = this.idToken;
        int iHashCode12 = (iHashCode11 + ((str10 == null || str10 == null) ? 0 : str10.hashCode())) * 31;
        String str11 = this.accessToken;
        int iHashCode13 = (iHashCode12 + ((str11 == null || str11 == null) ? 0 : str11.hashCode())) * 31;
        String str12 = this.sessionToken;
        int iHashCode14 = (iHashCode13 + ((str12 == null || str12 == null) ? 0 : str12.hashCode())) * 31;
        if (this.iconUri != null && (str = this.accessToken) != null) {
            iHashCode = str.hashCode();
        }
        return iHashCode14 + iHashCode;
    }

    public final void setAccessToken$NPFSDK_release(String str) {
        this.accessToken = str;
    }

    public final void setBirthdayDay$NPFSDK_release(Integer num) {
        this.birthdayDay = num;
    }

    public final void setBirthdayMonth$NPFSDK_release(Integer num) {
        this.birthdayMonth = num;
    }

    public final void setBirthdayYear$NPFSDK_release(Integer num) {
        this.birthdayYear = num;
    }

    public final void setCountry$NPFSDK_release(String str) {
        this.country = str;
    }

    public final void setEmail$NPFSDK_release(String str) {
        this.email = str;
    }

    public final void setGender$NPFSDK_release(Gender gender) {
        this.gender = gender;
    }

    public final void setIconUri$NPFSDK_release(String str) {
        this.iconUri = str;
    }

    public final void setIdToken$NPFSDK_release(String str) {
        this.idToken = str;
    }

    public final void setLanguage$NPFSDK_release(String str) {
        this.language = str;
    }

    public final void setMii$NPFSDK_release(Mii mii) {
        this.mii = mii;
    }

    public final void setNickname$NPFSDK_release(String str) {
        this.nickname = str;
    }

    public final void setNintendoAccountId$NPFSDK_release(String str) {
        this.nintendoAccountId = str;
    }

    public final void setNintendoNetworkId$NPFSDK_release(String str) {
        this.nintendoNetworkId = str;
    }

    public final void setRegion$NPFSDK_release(String str) {
        this.region = str;
    }

    public final void setScreenName$NPFSDK_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.screenName = str;
    }

    public final void setTimezone$NPFSDK_release(String str) {
        this.timezone = str;
    }

    public final void setType$NPFSDK_release(Type type) {
        Intrinsics.checkNotNullParameter(type, "<set-?>");
        this.type = type;
    }

    public NintendoAccount(String str, Type type, String str2, Gender gender, String str3, String str4, String str5, String str6, int i, int i2, int i3, String str7, String str8, Mii mii, String screenName, String str9, String str10, String str11, long j, String str12) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(screenName, "screenName");
        this.type = Type.UNKNOWN;
        this.birthdayYear = 0;
        this.birthdayMonth = 0;
        this.birthdayDay = 0;
        this.screenName = "";
        this.nintendoAccountId = str;
        this.type = type;
        this.nickname = str2;
        this.gender = gender;
        this.language = str3;
        this.country = str4;
        this.region = str5;
        this.timezone = str6;
        this.birthdayYear = Integer.valueOf(i);
        this.birthdayMonth = Integer.valueOf(i2);
        this.birthdayDay = Integer.valueOf(i3);
        this.email = str7;
        this.nintendoNetworkId = str8;
        this.mii = mii;
        this.screenName = screenName;
        this.idToken = str9;
        this.accessToken = str10;
        this.sessionToken = str11;
        this.expiresTime = j;
        this.iconUri = str12;
    }
}
