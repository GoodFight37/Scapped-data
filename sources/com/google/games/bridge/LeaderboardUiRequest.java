package com.google.games.bridge;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.games.PlayGames;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes2.dex */
class LeaderboardUiRequest extends SimpleUiRequest {
    private static final String TAG = "AllLeaderboardsUiRequest";
    private final String leaderboardId;
    private final int timeSpan;

    LeaderboardUiRequest(String str, int i) {
        this.leaderboardId = str;
        this.timeSpan = i;
    }

    @Override // com.google.games.bridge.SimpleUiRequest
    protected Task<Intent> getIntent(Activity activity) {
        return PlayGames.getLeaderboardsClient(activity).getLeaderboardIntent(this.leaderboardId, this.timeSpan);
    }
}
