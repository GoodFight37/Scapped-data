package com.google.api.services.pubsub.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class PushConfig extends GenericJson {

    @Key
    private Map<String, String> attributes;

    @Key
    private OidcToken oidcToken;

    @Key
    private String pushEndpoint;

    public Map<String, String> getAttributes() {
        return this.attributes;
    }

    public PushConfig setAttributes(Map<String, String> map) {
        this.attributes = map;
        return this;
    }

    public OidcToken getOidcToken() {
        return this.oidcToken;
    }

    public PushConfig setOidcToken(OidcToken oidcToken) {
        this.oidcToken = oidcToken;
        return this;
    }

    public String getPushEndpoint() {
        return this.pushEndpoint;
    }

    public PushConfig setPushEndpoint(String str) {
        this.pushEndpoint = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public PushConfig set(String str, Object obj) {
        return (PushConfig) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public PushConfig clone() {
        return (PushConfig) super.clone();
    }
}
