package com.google.games.bridge;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
public final class GenericResolutionActivity extends Activity {
    static final int SELECT_UI_STATUS_INTERNAL_ERROR = 0;
    static final int SELECT_UI_STATUS_RESULT_OK = -1;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            startIntentSenderForResult(((PendingIntent) getIntent().getParcelableExtra("RequestFriendsAccessPermissionPendingIntent")).getIntentSender(), 9011, null, 0, 0, 0, null);
        } catch (IntentSender.SendIntentException unused) {
            finishWithResult(0);
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 9011) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            finishWithResult(-1);
        } else {
            finishWithResult(0);
        }
    }

    private void finishWithResult(int i) {
        setResult(i);
        finish();
    }
}
