package com.unity3d.player;

import android.app.GameManager;
import android.content.Context;
import com.unity3d.player.a.AbstractC0086t;

/* JADX INFO: loaded from: classes2.dex */
public class UnityGameManager {
    private static Object mGameManager;

    public static Object getGameManager(Context context) {
        if (!PlatformSupport.SNOW_CONE_SUPPORT) {
            AbstractC0086t.Log(6, "getGameManager: API level not supported. API level 31 is required.");
            return null;
        }
        Object obj = mGameManager;
        if (obj != null) {
            return obj;
        }
        if (context == null) {
            AbstractC0086t.Log(6, "UnityGame: Request for GameManager supplied with null context.");
            return null;
        }
        Object systemService = context.getSystemService((Class<Object>) GameManager.class);
        mGameManager = systemService;
        return systemService;
    }

    public static int getGameMode(Context context) {
        if (!PlatformSupport.SNOW_CONE_SUPPORT) {
            AbstractC0086t.Log(6, "getGameMode: API level not supported. API level 31 is required.");
            return 0;
        }
        GameManager gameManager = (GameManager) getGameManager(context);
        if (gameManager == null) {
            AbstractC0086t.Log(6, "UnityGame: GameManager not available.");
            return 0;
        }
        return gameManager.getGameMode();
    }
}
