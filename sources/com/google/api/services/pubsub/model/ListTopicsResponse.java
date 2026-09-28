package com.google.api.services.pubsub.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class ListTopicsResponse extends GenericJson {

    @Key
    private String nextPageToken;

    @Key
    private List<Topic> topics;

    public String getNextPageToken() {
        return this.nextPageToken;
    }

    public ListTopicsResponse setNextPageToken(String str) {
        this.nextPageToken = str;
        return this;
    }

    public List<Topic> getTopics() {
        return this.topics;
    }

    public ListTopicsResponse setTopics(List<Topic> list) {
        this.topics = list;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ListTopicsResponse set(String str, Object obj) {
        return (ListTopicsResponse) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ListTopicsResponse clone() {
        return (ListTopicsResponse) super.clone();
    }
}
