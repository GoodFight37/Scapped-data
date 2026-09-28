package com.google.games.bridge;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.games.PlayGames;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes2.dex */
class AchievementUiRequest extends SimpleUiRequest {
    private static final String TAG = "AchievementUiRequest";

    AchievementUiRequest() {
    }

    @Override // com.google.games.bridge.SimpleUiRequest
    protected Task<Intent> getIntent(Activity activity) {
        return PlayGames.getAchievementsClient(activity).getAchievementsIntent();
    }
}
