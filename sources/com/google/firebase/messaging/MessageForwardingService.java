package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.JobIntentService;
import com.google.firebase.messaging.cpp.DebugLogging;
import com.google.firebase.messaging.cpp.MessageWriter;

/* JADX INFO: loaded from: classes2.dex */
public class MessageForwardingService extends JobIntentService {
    public static final String ACTION_REMOTE_INTENT = "com.google.android.c2dm.intent.RECEIVE";
    private static final String TAG = "FIREBASE_MSG_FWDR";

    public static void enqueueWork(Context context, Intent intent) {
        enqueueWork(context, (Class<?>) MessageForwardingService.class, 1000, intent);
    }

    @Override // androidx.core.app.JobIntentService
    protected void onHandleWork(Intent intent) {
        handleIntent(this, intent, MessageWriter.defaultInstance());
    }

    static void handleIntent(Context context, Intent intent, MessageWriter messageWriter) {
        String action;
        StringBuilder sb = new StringBuilder("onHandleIntent ");
        if (intent == null) {
            action = "null intent";
        } else {
            action = intent.getAction() == null ? "(null)" : intent.getAction();
        }
        DebugLogging.log(TAG, sb.append(action).toString());
        if (intent == null || intent.getAction() == null || !intent.getAction().equals(ACTION_REMOTE_INTENT)) {
            return;
        }
        Bundle extras = intent.getExtras();
        DebugLogging.log(TAG, "extras: " + (extras != null ? extras.toString() : "(null)"));
        if (extras != null) {
            RemoteMessage remoteMessage = new RemoteMessage(extras);
            DebugLogging.log(TAG, "message: " + remoteMessage.toString());
            if (remoteMessage.getFrom() == null || remoteMessage.getMessageId() == null) {
                return;
            }
            messageWriter.writeMessage(context, remoteMessage, true, intent.getData());
        }
    }
}
