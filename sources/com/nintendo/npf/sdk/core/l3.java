package com.nintendo.npf.sdk.core;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class l3 implements Parcelable {
    public static final a CREATOR = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f517a;
    private final String b;
    private final String c;

    public static final class a implements Parcelable.Creator {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public l3 createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new l3(parcel, null);
        }

        private a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public l3[] newArray(int i) {
            return new l3[i];
        }
    }

    public /* synthetic */ l3(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    public final String a() {
        return this.f517a;
    }

    public final String b() {
        return this.c;
    }

    public final String c() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l3)) {
            return false;
        }
        l3 l3Var = (l3) obj;
        return Intrinsics.areEqual(this.f517a, l3Var.f517a) && Intrinsics.areEqual(this.b, l3Var.b) && Intrinsics.areEqual(this.c, l3Var.c);
    }

    public int hashCode() {
        int iHashCode = ((this.f517a.hashCode() * 31) + this.b.hashCode()) * 31;
        String str = this.c;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "NaAuthenticationSession(state=" + this.f517a + ", verifier=" + this.b + ", targetNintendoAccountId=" + this.c + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.f517a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }

    public l3(String state, String verifier, String str) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(verifier, "verifier");
        this.f517a = state;
        this.b = verifier;
        this.c = str;
    }

    public /* synthetic */ l3(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? null : str3);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private l3(Parcel parcel) {
        String string = parcel.readString();
        string = string == null ? "" : string;
        String string2 = parcel.readString();
        this(string, string2 != null ? string2 : "", parcel.readString());
    }
}
