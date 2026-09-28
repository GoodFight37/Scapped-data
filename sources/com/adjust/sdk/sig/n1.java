package com.adjust.sdk.sig;

/* JADX INFO: compiled from: r8-map-id-50f36c2f6dbb1f1f4069f6584f1798fc01925cf859372d68181d0fca7f3fe715 */
/* JADX INFO: loaded from: classes.dex */
public final class n1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f147a;
    public final boolean b;
    public final int c;

    public n1(boolean z, boolean z2, int i) {
        this.f147a = z;
        this.b = z2;
        this.c = i;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("JsonConfiguration(encodeDefaults=");
        sb.append(this.f147a).append(", ignoreUnknownKeys=false, isLenient=false, allowStructuredMapKeys=false, prettyPrint=false, explicitNulls=").append(this.b).append(", prettyPrintIndent='    ', coerceInputValues=false, useArrayPolymorphism=false, classDiscriminator='type', allowSpecialFloatingPointValues=false, useAlternativeNames=true, namingStrategy=null, decodeEnumsCaseInsensitive=false, allowTrailingComma=false, allowComments=false, classDiscriminatorMode=");
        int i = this.c;
        if (i == 1) {
            str = "NONE";
        } else if (i != 2) {
            str = i != 3 ? "null" : "POLYMORPHIC";
        } else {
            str = "ALL_JSON_OBJECTS";
        }
        sb.append(str).append(", exceptionsWithDebugInfo=true)");
        return sb.toString();
    }
}
