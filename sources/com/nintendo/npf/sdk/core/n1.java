package com.nintendo.npf.sdk.core;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class n1 {
    public static final a d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f526a;
    private final q0 b;
    private final p0 c;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    public n1(Context applicationContext, q0 buildConfigurationMapper) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(buildConfigurationMapper, "buildConfigurationMapper");
        this.f526a = applicationContext;
        this.b = buildConfigurationMapper;
        this.c = b();
    }

    private final p0 b() throws Exception {
        try {
            return this.b.fromJSON(new JSONObject(c()));
        } catch (Exception e) {
            if ((e instanceof JSONException) || (e instanceof IOException)) {
                e.printStackTrace();
                throw new IllegalStateException("npf.json is invalid JSON file.");
            }
            if (!(e instanceof NoSuchMethodException) && !(e instanceof IllegalAccessException) && !(e instanceof InvocationTargetException) && !(e instanceof IllegalArgumentException)) {
                throw e;
            }
            e.printStackTrace();
            throw new IllegalStateException("Failed to reflect the methods in old android version.");
        }
    }

    private final String c() throws IOException {
        AssetManager assets = this.f526a.getResources().getAssets();
        Intrinsics.checkNotNullExpressionValue(assets, "applicationContext.resources.assets");
        InputStream inputStreamOpen = assets.open("npf.json");
        Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "assetManager.open(CONFIG_FILE)");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStreamOpen);
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
            sb.append(line);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "stringBuilder.toString()");
        return string;
    }

    public final p0 a() {
        return this.c;
    }
}
