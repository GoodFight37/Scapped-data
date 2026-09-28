package com.google.api.services.pubsub.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Base64;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class Policy extends GenericJson {

    @Key
    private List<Binding> bindings;

    @Key
    private String etag;

    @Key
    private Integer version;

    static {
        Data.nullOf(Binding.class);
    }

    public List<Binding> getBindings() {
        return this.bindings;
    }

    public Policy setBindings(List<Binding> list) {
        this.bindings = list;
        return this;
    }

    public String getEtag() {
        return this.etag;
    }

    public byte[] decodeEtag() {
        return Base64.decodeBase64(this.etag);
    }

    public Policy setEtag(String str) {
        this.etag = str;
        return this;
    }

    public Policy encodeEtag(byte[] bArr) {
        this.etag = Base64.encodeBase64URLSafeString(bArr);
        return this;
    }

    public Integer getVersion() {
        return this.version;
    }

    public Policy setVersion(Integer num) {
        this.version = num;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Policy set(String str, Object obj) {
        return (Policy) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Policy clone() {
        return (Policy) super.clone();
    }
}
