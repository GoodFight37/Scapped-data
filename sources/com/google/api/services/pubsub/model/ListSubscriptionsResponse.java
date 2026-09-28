package com.google.api.services.pubsub.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class ListSubscriptionsResponse extends GenericJson {

    @Key
    private String nextPageToken;

    @Key
    private List<Subscription> subscriptions;

    public String getNextPageToken() {
        return this.nextPageToken;
    }

    public ListSubscriptionsResponse setNextPageToken(String str) {
        this.nextPageToken = str;
        return this;
    }

    public List<Subscription> getSubscriptions() {
        return this.subscriptions;
    }

    public ListSubscriptionsResponse setSubscriptions(List<Subscription> list) {
        this.subscriptions = list;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ListSubscriptionsResponse set(String str, Object obj) {
        return (ListSubscriptionsResponse) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ListSubscriptionsResponse clone() {
        return (ListSubscriptionsResponse) super.clone();
    }
}
