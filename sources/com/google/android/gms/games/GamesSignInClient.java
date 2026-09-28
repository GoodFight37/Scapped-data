package com.google.android.gms.games;

import com.google.android.gms.games.gamessignin.AuthResponse;
import com.google.android.gms.games.gamessignin.AuthScope;
import com.google.android.gms.tasks.Task;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
public interface GamesSignInClient {
    Task<AuthenticationResult> isAuthenticated();

    Task<String> requestServerSideAccess(String str, boolean z);

    Task<AuthResponse> requestServerSideAccess(String str, boolean z, List<AuthScope> list);

    Task<AuthenticationResult> signIn();
}
