package com.adjust.sdk.sig;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import kotlin.text.Typography;

/* JADX INFO: compiled from: r8-map-id-50f36c2f6dbb1f1f4069f6584f1798fc01925cf859372d68181d0fca7f3fe715 */
/* JADX INFO: loaded from: classes.dex */
public abstract class t2 {
    public final int hashCode() {
        return toString().hashCode();
    }

    public final String toString() {
        String strA;
        String strA2;
        Class<?> cls = getClass();
        l2.f145a.getClass();
        String strConcat = null;
        if (cls.isAnonymousClass()) {
            return null;
        }
        if (cls.isLocalClass()) {
            strA = cls.getSimpleName();
            Method enclosingMethod = cls.getEnclosingMethod();
            if (enclosingMethod != null) {
                String str = enclosingMethod.getName() + Typography.dollar;
                int iIndexOf = strA.indexOf(str, 0);
                if (iIndexOf != -1) {
                    return strA.substring(str.length() + iIndexOf, strA.length());
                }
            } else {
                Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
                if (enclosingConstructor != null) {
                    String str2 = enclosingConstructor.getName() + Typography.dollar;
                    int iIndexOf2 = strA.indexOf(str2, 0);
                    if (iIndexOf2 != -1) {
                        return strA.substring(str2.length() + iIndexOf2, strA.length());
                    }
                } else {
                    int iIndexOf3 = strA.indexOf(36, 0);
                    if (iIndexOf3 != -1) {
                        return strA.substring(iIndexOf3 + 1, strA.length());
                    }
                }
            }
        } else {
            if (cls.isArray()) {
                Class<?> componentType = cls.getComponentType();
                if (componentType.isPrimitive() && (strA2 = m.a(componentType.getName())) != null) {
                    strConcat = strA2.concat("Array");
                }
                return strConcat == null ? "Array" : strConcat;
            }
            strA = m.a(cls.getName());
            if (strA == null) {
                return cls.getSimpleName();
            }
        }
        return strA;
    }
}
