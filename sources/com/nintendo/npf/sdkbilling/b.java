package com.nintendo.npf.sdkbilling;

import java.util.Arrays;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f933a = new b();

    public b() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte bByteValue = ((Number) obj).byteValue();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(bByteValue)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        return str;
    }
}
