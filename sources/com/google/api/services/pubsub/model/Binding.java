package com.google.api.services.pubsub.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class Binding extends GenericJson {

    @Key
    private Expr condition;

    @Key
    private List<String> members;

    @Key
    private String role;

    public Expr getCondition() {
        return this.condition;
    }

    public Binding setCondition(Expr expr) {
        this.condition = expr;
        return this;
    }

    public List<String> getMembers() {
        return this.members;
    }

    public Binding setMembers(List<String> list) {
        this.members = list;
        return this;
    }

    public String getRole() {
        return this.role;
    }

    public Binding setRole(String str) {
        this.role = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Binding set(String str, Object obj) {
        return (Binding) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Binding clone() {
        return (Binding) super.clone();
    }
}
