package com.adjust.sdk.sig;

/* JADX INFO: compiled from: r8-map-id-50f36c2f6dbb1f1f4069f6584f1798fc01925cf859372d68181d0fca7f3fe715 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a0 implements t1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a0 f114a;
    public static final f2 b;

    static {
        a0 a0Var = new a0();
        f114a = a0Var;
        f2 f2Var = new f2(a0Var);
        f2Var.a("os_name");
        f2Var.a("battery");
        b = f2Var;
    }

    @Override // com.adjust.sdk.sig.t1
    public final p2 a() {
        return b;
    }

    @Override // com.adjust.sdk.sig.t1
    public final void a(z2 z2Var, Object obj) {
        t3 t3Var;
        b0 b0Var = (b0) obj;
        f2 f2Var = b;
        i3 i3Var = i3.f137a;
        if (i3Var == j3.f139a) {
            t3Var = t3.LIST;
        } else if (i3Var != k3.f143a) {
            t3Var = t3.OBJ;
        } else {
            p2 p2VarA = u3.a(f2Var.b(0));
            t2 t2VarE = p2VarA.e();
            if (!(t2VarE instanceof j2) && !i1.a(t2VarE, s2.f159a)) {
                throw new o1("Value of type '" + p2VarA.b() + "' can't be used in JSON as a key in the map. It should have either primitive or enum kind, but its kind is '" + p2VarA.e() + '\'', "Use 'allowStructuredMapKeys = true' in 'Json {}' builder to convert such maps to [key1, value1, key2, value2,...] arrays.");
            }
            t3Var = t3.MAP;
        }
        z2Var.f167a.a(t3Var.f161a);
        z2Var.f167a.b = true;
        String str = z2Var.g;
        if (str != null) {
            String str2 = z2Var.h;
            if (str2 == null) {
                str2 = "com.adjust.sdk.sig.755f89ae93acbe52c30f8a09";
            }
            z2Var.f167a.a();
            z2Var.a(str);
            z2Var.f167a.a(':');
            y yVar = z2Var.f167a;
            z2Var.a(str2);
            z2Var.g = null;
            z2Var.h = null;
        }
        if (z2Var.c != t3Var) {
            z2 z2Var2 = z2Var.d[t3Var.ordinal()];
            if (z2Var2 == null) {
                z2Var2 = new z2(z2Var.f167a, z2Var.b, t3Var, z2Var.d);
            }
            z2Var = z2Var2;
        }
        if (z2Var.e.f147a) {
            z2Var.a(f2Var, 0, b3.f118a, "android");
        }
        if (z2Var.e.f147a || b0Var.f116a != null) {
            z2Var.a(f2Var, 1, h1.f134a, b0Var.f116a);
        }
        y yVar2 = z2Var.f167a;
        z2Var.f167a.b = false;
        z2Var.f167a.a(z2Var.c.b);
    }
}
