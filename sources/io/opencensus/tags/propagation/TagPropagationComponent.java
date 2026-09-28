package io.opencensus.tags.propagation;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TagPropagationComponent {
    public abstract TagContextBinarySerializer getBinarySerializer();

    public abstract TagContextTextFormat getCorrelationContextFormat();
}
