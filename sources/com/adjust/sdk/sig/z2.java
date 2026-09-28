package com.adjust.sdk.sig;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-50f36c2f6dbb1f1f4069f6584f1798fc01925cf859372d68181d0fca7f3fe715 */
/* JADX INFO: loaded from: classes.dex */
public final class z2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f167a;
    public final k1 b;
    public final t3 c;
    public final z2[] d;
    public final n1 e;
    public boolean f;
    public String g;
    public String h;

    public z2(y yVar, k1 k1Var, t3 t3Var, z2[] z2VarArr) {
        this.f167a = yVar;
        this.b = k1Var;
        this.c = t3Var;
        this.d = z2VarArr;
        this.e = k1Var.f141a;
        int iOrdinal = t3Var.ordinal();
        z2 z2Var = z2VarArr[iOrdinal];
        if (z2Var == null && z2Var == this) {
            return;
        }
        z2VarArr[iOrdinal] = this;
    }

    public final void a(t1 t1Var, Object obj) {
        String strDiscriminator;
        Set setC;
        int iA = y1.a(this.b.f141a.c);
        if (iA == 0) {
            strDiscriminator = null;
        } else {
            if (iA == 1) {
                t2 t2VarE = t1Var.a().e();
                if (i1.a(t2VarE, i3.f137a) || i1.a(t2VarE, l3.f146a)) {
                    Iterator it = t1Var.a().getAnnotations().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            strDiscriminator = "type";
                            break;
                        }
                        Annotation annotation = (Annotation) it.next();
                        if (annotation instanceof m1) {
                            strDiscriminator = ((m1) annotation).discriminator();
                            break;
                        }
                    }
                }
            } else if (iA != 2) {
                throw new a2();
            }
            strDiscriminator = null;
        }
        if (strDiscriminator != null) {
            k1 k1Var = this.b;
            p2 p2VarA = t1Var.a();
            i1.a(p2VarA.e(), i3.f137a);
            if (p2VarA instanceof i) {
                setC = ((i) p2VarA).c();
            } else {
                HashSet hashSet = new HashSet(p2VarA.f());
                int iF = p2VarA.f();
                for (int i = 0; i < iF; i++) {
                    hashSet.add(p2VarA.a(i));
                }
                setC = hashSet;
            }
            if (setC.contains(strDiscriminator)) {
                String strB = t1Var.a().b();
                String strB2 = t1Var.a().b();
                throw new o1("Class '" + strB2 + "' cannot be serialized " + ((k1Var.f141a.c == 2 && i1.a(strB, strB2)) ? "in ALL_JSON_OBJECTS class discriminator mode" : "as base class '" + strB + '\'') + " because it has property name that conflicts with JSON class discriminator '" + strDiscriminator + "'.", "You can either change class discriminator in JsonConfiguration, or rename property with @SerialName annotation.");
            }
            t2 t2VarE2 = t1Var.a().e();
            if (t2VarE2 instanceof s2) {
                throw new IllegalStateException("Enums cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead");
            }
            if (t2VarE2 instanceof j2) {
                throw new IllegalStateException("Primitives cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead");
            }
            String strB3 = t1Var.a().b();
            this.g = strDiscriminator;
            this.h = strB3;
        }
        t1Var.a(this, obj);
    }

    public final void a(p2 p2Var, int i, t1 t1Var, Object obj) {
        if (obj != null || this.e.b) {
            int iOrdinal = this.c.ordinal();
            boolean z = true;
            if (iOrdinal == 1) {
                y yVar = this.f167a;
                if (!yVar.b) {
                    yVar.a(',');
                }
                this.f167a.a();
            } else if (iOrdinal == 2) {
                y yVar2 = this.f167a;
                if (!yVar2.b) {
                    if (i % 2 == 0) {
                        yVar2.a(',');
                        this.f167a.a();
                    } else {
                        yVar2.a(':');
                        this.f167a.b();
                        z = false;
                    }
                    this.f = z;
                } else {
                    this.f = true;
                    yVar2.a();
                }
            } else if (iOrdinal != 3) {
                y yVar3 = this.f167a;
                if (!yVar3.b) {
                    yVar3.a(',');
                }
                this.f167a.a();
                i1.a(p2Var.e(), i3.f137a);
                a(p2Var.a(i));
                this.f167a.a(':');
                this.f167a.b();
            } else {
                if (i == 0) {
                    this.f = true;
                }
                if (i == 1) {
                    this.f167a.a(',');
                    this.f167a.b();
                    this.f = false;
                }
            }
            if (t1Var.a().d()) {
                a(t1Var, obj);
            } else if (obj == null) {
                this.f167a.f164a.a("null");
            } else {
                a(t1Var, obj);
            }
        }
    }

    public final void a(String str) {
        byte b;
        q1 q1Var = this.f167a.f164a;
        q1Var.a(q1Var.b, str.length() + 2);
        char[] cArr = q1Var.f154a;
        int i = q1Var.b;
        int i2 = i + 1;
        cArr[i] = '\"';
        int length = str.length();
        str.getChars(0, length, cArr, i2);
        int i3 = length + i2;
        int i4 = i2;
        while (i4 < i3) {
            char c = cArr[i4];
            byte[] bArr = a3.b;
            if (c < bArr.length && bArr[c] != 0) {
                int length2 = str.length();
                for (int i5 = i4 - i2; i5 < length2; i5++) {
                    int iA = q1Var.a(i4, 2);
                    char cCharAt = str.charAt(i5);
                    byte[] bArr2 = a3.b;
                    if (cCharAt >= bArr2.length || (b = bArr2[cCharAt]) == 0) {
                        int i6 = iA + 1;
                        q1Var.f154a[iA] = cCharAt;
                        i4 = i6;
                    } else if (b == 1) {
                        String str2 = a3.f115a[cCharAt];
                        int iA2 = q1Var.a(iA, str2.length());
                        str2.getChars(0, str2.length(), q1Var.f154a, iA2);
                        int length3 = str2.length() + iA2;
                        q1Var.b = length3;
                        i4 = length3;
                    } else {
                        char[] cArr2 = q1Var.f154a;
                        cArr2[iA] = '\\';
                        cArr2[iA + 1] = (char) b;
                        i4 = iA + 2;
                        q1Var.b = i4;
                    }
                }
                int iA3 = q1Var.a(i4, 1);
                q1Var.f154a[iA3] = '\"';
                q1Var.b = iA3 + 1;
                return;
            }
            i4++;
        }
        cArr[i3] = '\"';
        q1Var.b = i3 + 1;
    }
}
