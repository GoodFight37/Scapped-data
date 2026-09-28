package com.google.api.services.pubsub.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes2.dex */
public final class UpdateSubscriptionRequest extends GenericJson {

    @Key
    private Subscription subscription;

    @Key
    private String updateMask;

    public Subscription getSubscription() {
        return this.subscription;
    }

    public UpdateSubscriptionRequest setSubscription(Subscription subscription) {
        this.subscription = subscription;
        return this;
    }

    public String getUpdateMask() {
        return this.updateMask;
    }

    public UpdateSubscriptionRequest setUpdateMask(String str) {
        this.updateMask = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public UpdateSubscriptionRequest set(String str, Object obj) {
        return (UpdateSubscriptionRequest) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public UpdateSubscriptionRequest clone() {
        return (UpdateSubscriptionRequest) super.clone();
    }
}
