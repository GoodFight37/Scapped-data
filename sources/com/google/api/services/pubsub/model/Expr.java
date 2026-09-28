package com.google.api.services.pubsub.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes2.dex */
public final class Expr extends GenericJson {

    @Key
    private String description;

    @Key
    private String expression;

    @Key
    private String location;

    @Key
    private String title;

    public String getDescription() {
        return this.description;
    }

    public Expr setDescription(String str) {
        this.description = str;
        return this;
    }

    public String getExpression() {
        return this.expression;
    }

    public Expr setExpression(String str) {
        this.expression = str;
        return this;
    }

    public String getLocation() {
        return this.location;
    }

    public Expr setLocation(String str) {
        this.location = str;
        return this;
    }

    public String getTitle() {
        return this.title;
    }

    public Expr setTitle(String str) {
        this.title = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Expr set(String str, Object obj) {
        return (Expr) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Expr clone() {
        return (Expr) super.clone();
    }
}
