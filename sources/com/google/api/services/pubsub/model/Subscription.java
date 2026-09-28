package com.google.api.services.pubsub.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class Subscription extends GenericJson {

    @Key
    private Integer ackDeadlineSeconds;

    @Key
    private DeadLetterPolicy deadLetterPolicy;

    @Key
    private Boolean detached;

    @Key
    private Boolean enableMessageOrdering;

    @Key
    private ExpirationPolicy expirationPolicy;

    @Key
    private String filter;

    @Key
    private Map<String, String> labels;

    @Key
    private String messageRetentionDuration;

    @Key
    private String name;

    @Key
    private PushConfig pushConfig;

    @Key
    private Boolean retainAckedMessages;

    @Key
    private RetryPolicy retryPolicy;

    @Key
    private String topic;

    public Integer getAckDeadlineSeconds() {
        return this.ackDeadlineSeconds;
    }

    public Subscription setAckDeadlineSeconds(Integer num) {
        this.ackDeadlineSeconds = num;
        return this;
    }

    public DeadLetterPolicy getDeadLetterPolicy() {
        return this.deadLetterPolicy;
    }

    public Subscription setDeadLetterPolicy(DeadLetterPolicy deadLetterPolicy) {
        this.deadLetterPolicy = deadLetterPolicy;
        return this;
    }

    public Boolean getDetached() {
        return this.detached;
    }

    public Subscription setDetached(Boolean bool) {
        this.detached = bool;
        return this;
    }

    public Boolean getEnableMessageOrdering() {
        return this.enableMessageOrdering;
    }

    public Subscription setEnableMessageOrdering(Boolean bool) {
        this.enableMessageOrdering = bool;
        return this;
    }

    public ExpirationPolicy getExpirationPolicy() {
        return this.expirationPolicy;
    }

    public Subscription setExpirationPolicy(ExpirationPolicy expirationPolicy) {
        this.expirationPolicy = expirationPolicy;
        return this;
    }

    public String getFilter() {
        return this.filter;
    }

    public Subscription setFilter(String str) {
        this.filter = str;
        return this;
    }

    public Map<String, String> getLabels() {
        return this.labels;
    }

    public Subscription setLabels(Map<String, String> map) {
        this.labels = map;
        return this;
    }

    public String getMessageRetentionDuration() {
        return this.messageRetentionDuration;
    }

    public Subscription setMessageRetentionDuration(String str) {
        this.messageRetentionDuration = str;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Subscription setName(String str) {
        this.name = str;
        return this;
    }

    public PushConfig getPushConfig() {
        return this.pushConfig;
    }

    public Subscription setPushConfig(PushConfig pushConfig) {
        this.pushConfig = pushConfig;
        return this;
    }

    public Boolean getRetainAckedMessages() {
        return this.retainAckedMessages;
    }

    public Subscription setRetainAckedMessages(Boolean bool) {
        this.retainAckedMessages = bool;
        return this;
    }

    public RetryPolicy getRetryPolicy() {
        return this.retryPolicy;
    }

    public Subscription setRetryPolicy(RetryPolicy retryPolicy) {
        this.retryPolicy = retryPolicy;
        return this;
    }

    public String getTopic() {
        return this.topic;
    }

    public Subscription setTopic(String str) {
        this.topic = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Subscription set(String str, Object obj) {
        return (Subscription) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Subscription clone() {
        return (Subscription) super.clone();
    }
}
