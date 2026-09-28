package com.nintendo.npf.sdk.internal.impl;

import android.app.Application;
import android.content.SharedPreferences;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f841a;
    private final Application b;

    a(Application application) {
        this.b = application;
    }

    private SharedPreferences b() {
        if (this.f841a == null) {
            this.f841a = this.b.getSharedPreferences("AnalyticsEvent", 0);
        }
        return this.f841a;
    }

    synchronized Map a() {
        return b().getAll();
    }

    synchronized boolean a(JSONObject jSONObject) {
        Map<String, ?> all = b().getAll();
        if (all != null && all.keySet().size() > 1000) {
            return false;
        }
        SharedPreferences.Editor editorEdit = b().edit();
        editorEdit.putString(UUID.randomUUID().toString(), jSONObject.toString());
        editorEdit.apply();
        return true;
    }

    synchronized void a(Set set) {
        SharedPreferences.Editor editorEdit = b().edit();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            editorEdit.remove((String) it.next());
        }
        editorEdit.apply();
    }
}
