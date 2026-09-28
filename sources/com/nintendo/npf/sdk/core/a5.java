package com.nintendo.npf.sdk.core;

import android.net.Uri;
import com.adjust.sdk.Constants;
import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class a5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f410a = new a(null);

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    static final class b extends Lambda implements Function1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f411a = new b();

        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Sequence invoke(String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return SequencesKt.zipWithNext(CollectionsKt.asSequence(StringsKt.split$default((CharSequence) it, new String[]{"="}, false, 2, 2, (Object) null)));
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x007b  */
    public final z4 a(Uri uri) {
        String string;
        List listSplit$default;
        Sequence sequenceAsSequence;
        Sequence<Pair> sequenceFlatMap;
        String str;
        if (uri == null || (string = uri.toString()) == null) {
            string = "uri is null";
        }
        String str2 = null;
        if (uri != null) {
            try {
                String fragment = uri.getFragment();
                if (fragment == null || (listSplit$default = StringsKt.split$default((CharSequence) fragment, new String[]{"&"}, false, 0, 6, (Object) null)) == null || (sequenceAsSequence = CollectionsKt.asSequence(listSplit$default)) == null || (sequenceFlatMap = SequencesKt.flatMap(sequenceAsSequence, b.f411a)) == null) {
                    str = null;
                } else {
                    String str3 = null;
                    for (Pair pair : sequenceFlatMap) {
                        String strDecode = URLDecoder.decode((String) pair.getFirst(), Constants.ENCODING);
                        String strDecode2 = URLDecoder.decode((String) pair.getSecond(), Constants.ENCODING);
                        if (Intrinsics.areEqual(strDecode, "session_token_code")) {
                            str3 = strDecode2;
                        } else if (Intrinsics.areEqual(strDecode, MapperConstants.SUBSCRIPTION_FIELD_STATE)) {
                            str2 = strDecode2;
                        }
                    }
                    str = str2;
                    str2 = str3;
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                throw new IllegalStateException(e);
            }
        } else {
            str = null;
        }
        return new z4(str2, str, string);
    }
}
