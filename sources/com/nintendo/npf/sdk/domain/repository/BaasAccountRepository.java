package com.nintendo.npf.sdk.domain.repository;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.core.p1;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdk.user.LinkedAccount;
import com.nintendo.npf.sdk.user.OtherUser;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J-\u0010\u0007\u001a\u00020\u00052\u001c\u0010\u0006\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u000b\u001a\u00020\u00052\u001c\u0010\n\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0002H&¢\u0006\u0004\b\u000b\u0010\bJ-\u0010\f\u001a\u00020\u00052\u001c\u0010\n\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0002H&¢\u0006\u0004\b\f\u0010\bJG\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\r2\u001c\u0010\n\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0002H&¢\u0006\u0004\b\u0012\u0010\u0013J=\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u000f2\u001c\u0010\n\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0002H&¢\u0006\u0004\b\u0016\u0010\u0017JI\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u00182\"\u0010\n\u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0002H&¢\u0006\u0004\b\u001b\u0010\u001cJ5\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00032\u001c\u0010\n\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0002H&¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8&X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010\u0014\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/nintendo/npf/sdk/domain/repository/BaasAccountRepository;", "", "Lkotlin/Function2;", "Lcom/nintendo/npf/sdk/user/BaaSUser;", "Lcom/nintendo/npf/sdk/NPFError;", "", "block", "findLoggedInAccount", "(Lkotlin/jvm/functions/Function2;)V", "Lcom/nintendo/npf/sdk/core/p1;", "callback", FirebaseAnalytics.Event.LOGIN, "loginNewBaasUser", "", "currentBaasUserId", "Lcom/nintendo/npf/sdk/user/LinkedAccount;", "linkedAccount", "naCountry", "federate", "(Ljava/lang/String;Lcom/nintendo/npf/sdk/user/LinkedAccount;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "currentBaasUser", "linkTarget", "link", "(Lcom/nintendo/npf/sdk/user/BaaSUser;Lcom/nintendo/npf/sdk/user/LinkedAccount;Lkotlin/jvm/functions/Function2;)V", "", "userIds", "Lcom/nintendo/npf/sdk/user/OtherUser;", "getUsers", "(Lcom/nintendo/npf/sdk/user/BaaSUser;Ljava/util/List;Lkotlin/jvm/functions/Function2;)V", "user", "updateUser", "(Lcom/nintendo/npf/sdk/user/BaaSUser;Lkotlin/jvm/functions/Function2;)V", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isRunning", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "getCurrentBaasUser", "()Lcom/nintendo/npf/sdk/user/BaaSUser;", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface BaasAccountRepository {
    void federate(String currentBaasUserId, LinkedAccount linkedAccount, String naCountry, Function2<? super p1, ? super NPFError, Unit> callback);

    void findLoggedInAccount(Function2<? super BaaSUser, ? super NPFError, Unit> block);

    BaaSUser getCurrentBaasUser();

    void getUsers(BaaSUser currentBaasUser, List<String> userIds, Function2<? super List<? extends OtherUser>, ? super NPFError, Unit> callback);

    AtomicBoolean isRunning();

    void link(BaaSUser currentBaasUser, LinkedAccount linkTarget, Function2<? super BaaSUser, ? super NPFError, Unit> callback);

    void login(Function2<? super p1, ? super NPFError, Unit> callback);

    void loginNewBaasUser(Function2<? super p1, ? super NPFError, Unit> callback);

    void updateUser(BaaSUser user, Function2<? super BaaSUser, ? super NPFError, Unit> callback);
}
