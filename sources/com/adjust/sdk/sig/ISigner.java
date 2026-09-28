package com.adjust.sdk.sig;

import android.content.Context;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-50f36c2f6dbb1f1f4069f6584f1798fc01925cf859372d68181d0fca7f3fe715 */
/* JADX INFO: loaded from: classes.dex */
public interface ISigner {
    void onResume();

    void sign(Context context, Map<String, String> map, String str, String str2);

    void sign(Context context, Map<String, String> map, Map<String, String> map2, Map<String, String> map3);
}
