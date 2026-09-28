package com.google.api.client.util.store;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class DataStoreUtils {
    public static String toString(DataStore<?> dataStore) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append('{');
            boolean z = true;
            for (String str : dataStore.keySet()) {
                if (z) {
                    z = false;
                } else {
                    sb.append(", ");
                }
                sb.append(str).append('=').append(dataStore.get(str));
            }
            return sb.append('}').toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private DataStoreUtils() {
    }
}
