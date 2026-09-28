package com.nintendo.npf.sdk.user;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/nintendo/npf/sdk/user/Gender;", "", "", "int", "<init>", "(Ljava/lang/String;II)V", "a", "I", "getInt", "()I", "UNKNOWN", "MALE", "FEMALE", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum Gender {
    UNKNOWN(0),
    MALE(1),
    FEMALE(2);


    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int int;

    Gender(int i) {
        this.int = i;
    }

    public final int getInt() {
        return this.int;
    }
}
