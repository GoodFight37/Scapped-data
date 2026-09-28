package com.unity3d.player;

import android.app.GameManager;
import android.app.GameState;
import android.content.Context;
import com.unity3d.player.a.AbstractC0086t;

/* JADX INFO: loaded from: classes2.dex */
public class UnityGameState {
    public static void setGameState(Context context, boolean z, int i) {
        if (!PlatformSupport.TIRAMISU_SUPPORT) {
            AbstractC0086t.Log(6, "setGameState: API level not supported. API level 33 is required.");
            return;
        }
        GameManager gameManager = (GameManager) UnityGameManager.getGameManager(context);
        if (gameManager == null) {
            AbstractC0086t.Log(6, "UnityGame: GameManager not available.");
        } else {
            AbstractC0086t.Log(4, "SetGameState: " + z + " " + i);
            gameManager.setGameState(new GameState(z, i));
        }
    }

    private static String ModeName(int i) {
        if (i == 0) {
            return "UNKNOWN";
        }
        if (i == 1) {
            return "NONE";
        }
        if (i == 2) {
            return "GAMEPLAY_INTERRUPTIBLE";
        }
        if (i == 3) {
            return "GAMEPLAY_UNINTERRUPTIBLE";
        }
        if (i == 4) {
            return "CONTENT";
        }
        return String.valueOf(i);
    }

    public static void setGameState(Context context, boolean z, int i, int i2, int i3) {
        if (!PlatformSupport.TIRAMISU_SUPPORT) {
            AbstractC0086t.Log(6, "setGameState: API level not supported. API level 33 is required.");
            return;
        }
        GameManager gameManager = (GameManager) UnityGameManager.getGameManager(context);
        if (gameManager == null) {
            AbstractC0086t.Log(6, "UnityGame: GameManager not available.");
        } else {
            AbstractC0086t.Log(4, "SetGameState: isLoading: " + z + ", mode: " + ModeName(i) + ", label: " + i2 + ", quality: " + i3);
            gameManager.setGameState(new GameState(z, i, i2, i3));
        }
    }
}
