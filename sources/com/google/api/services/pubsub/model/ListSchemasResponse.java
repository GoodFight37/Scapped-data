package com.google.api.services.pubsub.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class ListSchemasResponse extends GenericJson {

    @Key
    private String nextPageToken;

    @Key
    private List<Schema> schemas;

    public String getNextPageToken() {
        return this.nextPageToken;
    }

    public ListSchemasResponse setNextPageToken(String str) {
        this.nextPageToken = str;
        return this;
    }

    public List<Schema> getSchemas() {
        return this.schemas;
    }

    public ListSchemasResponse setSchemas(List<Schema> list) {
        this.schemas = list;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ListSchemasResponse set(String str, Object obj) {
        return (ListSchemasResponse) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ListSchemasResponse clone() {
        return (ListSchemasResponse) super.clone();
    }
}
