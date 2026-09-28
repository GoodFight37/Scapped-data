package com.nintendo.npf.sdk.internal.client.core;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface e {

    public static final class a implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f771a = new a();

        private a() {
        }

        @Override // com.nintendo.npf.sdk.internal.client.core.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public JSONArray a(String body) {
            Intrinsics.checkNotNullParameter(body, "body");
            return new JSONArray(body);
        }
    }

    public static final class b implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f772a = new b();

        private b() {
        }

        @Override // com.nintendo.npf.sdk.internal.client.core.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public JSONObject a(String body) {
            Intrinsics.checkNotNullParameter(body, "body");
            return new JSONObject(body);
        }
    }

    public static final class c implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f773a = new c();

        private c() {
        }

        @Override // com.nintendo.npf.sdk.internal.client.core.e
        public /* bridge */ /* synthetic */ Object a(String str) {
            b(str);
            return Unit.INSTANCE;
        }

        public void b(String body) {
            Intrinsics.checkNotNullParameter(body, "body");
        }
    }

    Object a(String str);
}
