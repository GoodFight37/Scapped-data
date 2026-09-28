package com.nintendo.npf.sdk.user;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.core.x4;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000f\u0010B-\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/nintendo/npf/sdk/user/OtherUser;", "", "userId", "", "nickname", "nintendoAccountNickname", "nintendoAccountMii", "Lcom/nintendo/npf/sdk/user/Mii;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/nintendo/npf/sdk/user/Mii;)V", "getNickname", "()Ljava/lang/String;", "getNintendoAccountMii", "()Lcom/nintendo/npf/sdk/user/Mii;", "getNintendoAccountNickname", "getUserId", "Companion", "RetrievingCallback", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class OtherUser {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String nickname;
    private final Mii nintendoAccountMii;
    private final String nintendoAccountNickname;
    private final String userId;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¨\u0006\n"}, d2 = {"Lcom/nintendo/npf/sdk/user/OtherUser$Companion;", "", "()V", "getAsList", "", "userIds", "", "", "callback", "Lcom/nintendo/npf/sdk/user/OtherUser$RetrievingCallback;", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        static final class a extends Lambda implements Function2 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ RetrievingCallback f923a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(RetrievingCallback retrievingCallback) {
                super(2);
                this.f923a = retrievingCallback;
            }

            public final void a(List list, NPFError nPFError) {
                RetrievingCallback retrievingCallback = this.f923a;
                if (retrievingCallback != null) {
                    retrievingCallback.onComplete(list, nPFError);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((List) obj, (NPFError) obj2);
                return Unit.INSTANCE;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void getAsList(List<String> userIds, RetrievingCallback callback) {
            Intrinsics.checkNotNullParameter(userIds, "userIds");
            x4.a.a().getOtherUserService().getAsList(userIds, new a(callback));
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, d2 = {"Lcom/nintendo/npf/sdk/user/OtherUser$RetrievingCallback;", "", "onComplete", "", "otherUsers", "", "Lcom/nintendo/npf/sdk/user/OtherUser;", "error", "Lcom/nintendo/npf/sdk/NPFError;", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface RetrievingCallback {
        void onComplete(List<? extends OtherUser> otherUsers, NPFError error);
    }

    protected OtherUser(String userId, String str, String str2, Mii mii) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        this.userId = userId;
        this.nickname = str;
        this.nintendoAccountNickname = str2;
        this.nintendoAccountMii = mii;
    }

    @JvmStatic
    public static final void getAsList(List<String> list, RetrievingCallback retrievingCallback) {
        INSTANCE.getAsList(list, retrievingCallback);
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final Mii getNintendoAccountMii() {
        return this.nintendoAccountMii;
    }

    public final String getNintendoAccountNickname() {
        return this.nintendoAccountNickname;
    }

    public final String getUserId() {
        return this.userId;
    }
}
