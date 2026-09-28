package com.google.api.services.pubsub.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes2.dex */
public final class SetIamPolicyRequest extends GenericJson {

    @Key
    private Policy policy;

    public Policy getPolicy() {
        return this.policy;
    }

    public SetIamPolicyRequest setPolicy(Policy policy) {
        this.policy = policy;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public SetIamPolicyRequest set(String str, Object obj) {
        return (SetIamPolicyRequest) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public SetIamPolicyRequest clone() {
        return (SetIamPolicyRequest) super.clone();
    }
}
