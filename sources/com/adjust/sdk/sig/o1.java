package com.adjust.sdk.sig;

/* JADX INFO: compiled from: r8-map-id-50f36c2f6dbb1f1f4069f6584f1798fc01925cf859372d68181d0fca7f3fe715 */
/* JADX INFO: loaded from: classes.dex */
public final class o1 extends IllegalArgumentException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f151a;

    /* JADX WARN: Illegal instructions before constructor call */
    public o1(String str, String str2) {
        String strConcat;
        StringBuilder sbAppend = new StringBuilder().append(str);
        if (str2 != null) {
            for (int i = 0; i < str2.length(); i++) {
                char cCharAt = str2.charAt(i);
                if (!Character.isWhitespace(cCharAt) && !Character.isSpaceChar(cCharAt)) {
                    strConcat = "\n".concat(str2);
                }
            }
            strConcat = "";
        } else {
            strConcat = "";
        }
        String string = sbAppend.append(strConcat).toString();
        super(string);
        this.f151a = string;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return this.f151a;
    }
}
