package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.util.Strings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzahx {
    private List<String> zza;

    public static zzahx zza() {
        return new zzahx(null);
    }

    public final List<String> zzb() {
        return this.zza;
    }

    public zzahx() {
        this(null);
    }

    private zzahx(List<String> list) {
        this.zza = new ArrayList();
    }

    public zzahx(int i, List<String> list) {
        if (list == null || list.isEmpty()) {
            this.zza = Collections.emptyList();
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            list.set(i2, Strings.emptyToNull(list.get(i2)));
        }
        this.zza = Collections.unmodifiableList(list);
    }
}
