package com.google.api.services.pubsub.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes2.dex */
public final class OidcToken extends GenericJson {

    @Key
    private String audience;

    @Key
    private String serviceAccountEmail;

    public String getAudience() {
        return this.audience;
    }

    public OidcToken setAudience(String str) {
        this.audience = str;
        return this;
    }

    public String getServiceAccountEmail() {
        return this.serviceAccountEmail;
    }

    public OidcToken setServiceAccountEmail(String str) {
        this.serviceAccountEmail = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public OidcToken set(String str, Object obj) {
        return (OidcToken) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public OidcToken clone() {
        return (OidcToken) super.clone();
    }
}
