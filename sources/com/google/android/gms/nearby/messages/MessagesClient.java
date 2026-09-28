package com.google.android.gms.nearby.messages;

import android.app.PendingIntent;
import android.content.Intent;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public interface MessagesClient extends HasApiKey<MessagesOptions> {
    void handleIntent(Intent intent, MessageListener messageListener);

    Task<Void> publish(Message message);

    Task<Void> publish(Message message, PublishOptions publishOptions);

    Task<Void> registerStatusCallback(StatusCallback statusCallback);

    Task<Void> subscribe(PendingIntent pendingIntent);

    Task<Void> subscribe(PendingIntent pendingIntent, SubscribeOptions subscribeOptions);

    Task<Void> subscribe(MessageListener messageListener);

    Task<Void> subscribe(MessageListener messageListener, SubscribeOptions subscribeOptions);

    Task<Void> unpublish(Message message);

    Task<Void> unregisterStatusCallback(StatusCallback statusCallback);

    Task<Void> unsubscribe(PendingIntent pendingIntent);

    Task<Void> unsubscribe(MessageListener messageListener);
}
