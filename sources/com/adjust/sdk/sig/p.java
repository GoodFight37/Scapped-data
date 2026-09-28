package com.adjust.sdk.sig;

/* JADX INFO: compiled from: r8-map-id-50f36c2f6dbb1f1f4069f6584f1798fc01925cf859372d68181d0fca7f3fe715 */
/* JADX INFO: loaded from: classes.dex */
public abstract class p extends x {
    public static String a(Iterable iterable, String str, String str2, s0 s0Var) {
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) str);
        int i = 0;
        for (Object obj : iterable) {
            i++;
            if (i > 1) {
                sb.append((CharSequence) ", ");
            }
            if (s0Var != null) {
                sb.append((CharSequence) s0Var.a(obj));
            } else if (obj == null || (obj instanceof CharSequence)) {
                sb.append((CharSequence) obj);
            } else if (obj instanceof Character) {
                sb.append(((Character) obj).charValue());
            } else {
                sb.append((CharSequence) obj.toString());
            }
        }
        sb.append((CharSequence) str2);
        return sb.toString();
    }
}
