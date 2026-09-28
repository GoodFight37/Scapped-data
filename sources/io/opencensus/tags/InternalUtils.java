package io.opencensus.tags;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class InternalUtils {
    private InternalUtils() {
    }

    public static Iterator<Tag> getTags(TagContext tagContext) {
        return tagContext.getIterator();
    }
}
