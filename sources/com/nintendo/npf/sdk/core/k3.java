package com.nintendo.npf.sdk.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.NPFException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k3 implements Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f512a = new b(null);
    public static final Parcelable.Creator<k3> CREATOR = new a();

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private b() {
        }
    }

    public static final class c extends k3 {
        public static final a h = new a(null);
        private final NPFError.ErrorType b;
        private final int c;
        private final String d;
        private final String e;
        private final String f;
        private final boolean g;

        public static final class a {
            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final c a(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                NPFError.ErrorType errorTypeA = h3.a(parcel.readInt());
                if (errorTypeA == null) {
                    errorTypeA = NPFError.ErrorType.NPF_ERROR;
                }
                NPFError.ErrorType errorType = errorTypeA;
                int i = parcel.readInt();
                String string = parcel.readString();
                if (string == null) {
                    string = "";
                }
                return new c(errorType, i, string, parcel.readString(), parcel.readString(), parcel.readInt() == 1);
            }

            private a() {
            }
        }

        public /* synthetic */ c(NPFError.ErrorType errorType, int i, String str, String str2, String str3, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(errorType, i, str, (i2 & 8) != 0 ? null : str2, (i2 & 16) != 0 ? null : str3, (i2 & 32) != 0 ? false : z);
        }

        @Override // com.nintendo.npf.sdk.core.k3
        public boolean a() {
            return this.g;
        }

        public final int b() {
            return this.c;
        }

        public final String c() {
            return this.e;
        }

        public final String d() {
            return this.f;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final NPFError.ErrorType e() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.b == cVar.b && this.c == cVar.c && Intrinsics.areEqual(this.d, cVar.d) && Intrinsics.areEqual(this.e, cVar.e) && Intrinsics.areEqual(this.f, cVar.f) && this.g == cVar.g;
        }

        public final boolean f() {
            String str = this.e;
            return !(str == null || str.length() == 0);
        }

        public final NPFError g() {
            return new NPFError(this.b, this.c, this.d);
        }

        public final NPFException h() {
            return new NPFException(g());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11, types: [int] */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARN: Type inference failed for: r1v9, types: [int] */
        public int hashCode() {
            int iHashCode = ((((this.b.hashCode() * 31) + Integer.hashCode(this.c)) * 31) + this.d.hashCode()) * 31;
            String str = this.e;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f;
            int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
            boolean z = this.g;
            ?? r1 = z;
            if (z) {
                r1 = 1;
            }
            return iHashCode3 + r1;
        }

        public String toString() {
            return "Error(type=" + this.b + ", code=" + this.c + ", message=" + this.d + ", report=" + this.e + ", reportMessage=" + this.f + ", isRestored=" + this.g + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int i) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeInt(2);
            dest.writeInt(this.b.getInt());
            dest.writeInt(this.c);
            dest.writeString(this.d);
            dest.writeString(this.e);
            dest.writeString(this.f);
            dest.writeInt(a() ? 1 : 0);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(NPFError.ErrorType type, int i, String message, String str, String str2, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(message, "message");
            this.b = type;
            this.c = i;
            this.d = message;
            this.e = str;
            this.f = str2;
            this.g = z;
        }
    }

    public static final class d extends k3 {
        public static final a e = new a(null);
        private final l3 b;
        private final String c;
        private final boolean d;

        public static final class a {
            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final d a(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                l3 l3Var = (l3) d4.a(parcel, l3.class.getClassLoader(), l3.class);
                if (l3Var == null) {
                    l3Var = new l3(null, null, null, 7, null);
                }
                String string = parcel.readString();
                if (string == null) {
                    string = "";
                }
                return new d(l3Var, string, parcel.readInt() == 1);
            }

            private a() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(l3 session, String sessionTokenCode, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(session, "session");
            Intrinsics.checkNotNullParameter(sessionTokenCode, "sessionTokenCode");
            this.b = session;
            this.c = sessionTokenCode;
            this.d = z;
        }

        @Override // com.nintendo.npf.sdk.core.k3
        public boolean a() {
            return this.d;
        }

        public final l3 b() {
            return this.b;
        }

        public final String c() {
            return this.c;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return Intrinsics.areEqual(this.b, dVar.b) && Intrinsics.areEqual(this.c, dVar.c) && this.d == dVar.d;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v5 */
        public int hashCode() {
            int iHashCode = ((this.b.hashCode() * 31) + this.c.hashCode()) * 31;
            boolean z = this.d;
            ?? r1 = z;
            if (z) {
                r1 = 1;
            }
            return iHashCode + r1;
        }

        public String toString() {
            return "Success(session=" + this.b + ", sessionTokenCode=" + this.c + ", isRestored=" + this.d + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int i) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeInt(1);
            dest.writeParcelable(this.b, i);
            dest.writeString(this.c);
            dest.writeInt(a() ? 1 : 0);
        }
    }

    public /* synthetic */ k3(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract boolean a();

    private k3() {
    }

    public static final class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public k3 createFromParcel(Parcel source) {
            Intrinsics.checkNotNullParameter(source, "source");
            int i = source.readInt();
            if (i == 1) {
                return d.e.a(source);
            }
            if (i == 2) {
                return c.h.a(source);
            }
            throw new IllegalArgumentException("Unknown type");
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public k3[] newArray(int i) {
            return new k3[i];
        }
    }
}
