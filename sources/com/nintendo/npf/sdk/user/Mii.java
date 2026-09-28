package com.nintendo.npf.sdk.user;

import android.graphics.Color;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0004KLMNBI\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u0013\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010J\u001a\u00020\rH\u0016R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\u001a\u0010\u001b\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001a\u0010\u001e\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R\u001a\u0010!\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011R\u001a\u0010$\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0011\u0010\n\u001a\u00020%¢\u0006\b\n\u0000\u001a\u0004\b4\u0010'R\u001a\u00105\u001a\u000206X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010-R\u0013\u0010<\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b=\u0010-R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010-R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b?\u0010+R\u001a\u0010@\u001a\u00020AX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bF\u0010-¨\u0006O"}, d2 = {"Lcom/nintendo/npf/sdk/user/Mii;", "", "urlTemplate", "", "miiId", "coreData", "", "storeData", "imageOrigin", "etag", "favoriteColor", "(Ljava/lang/String;Ljava/lang/String;[B[BLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "bgColor", "", "getBgColor", "()I", "setBgColor", "(I)V", "cameraXRotate", "getCameraXRotate", "setCameraXRotate", "cameraYRotate", "getCameraYRotate", "setCameraYRotate", "cameraZRotate", "getCameraZRotate", "setCameraZRotate", "characterXRotate", "getCharacterXRotate", "setCharacterXRotate", "characterYRotate", "getCharacterYRotate", "setCharacterYRotate", "characterZRotate", "getCharacterZRotate", "setCharacterZRotate", "clothesColor", "Lcom/nintendo/npf/sdk/user/Mii$MiiColor;", "getClothesColor", "()Lcom/nintendo/npf/sdk/user/Mii$MiiColor;", "setClothesColor", "(Lcom/nintendo/npf/sdk/user/Mii$MiiColor;)V", "getCoreData", "()[B", "getEtag", "()Ljava/lang/String;", "expression", "Lcom/nintendo/npf/sdk/user/Mii$Expression;", "getExpression", "()Lcom/nintendo/npf/sdk/user/Mii$Expression;", "setExpression", "(Lcom/nintendo/npf/sdk/user/Mii$Expression;)V", "getFavoriteColor", "format", "Lcom/nintendo/npf/sdk/user/Mii$Format;", "getFormat", "()Lcom/nintendo/npf/sdk/user/Mii$Format;", "setFormat", "(Lcom/nintendo/npf/sdk/user/Mii$Format;)V", "getImageOrigin", "imageUrl", "getImageUrl", "getMiiId", "getStoreData", "type", "Lcom/nintendo/npf/sdk/user/Mii$Type;", "getType", "()Lcom/nintendo/npf/sdk/user/Mii$Type;", "setType", "(Lcom/nintendo/npf/sdk/user/Mii$Type;)V", "getUrlTemplate", "equals", "", "o", "hashCode", "Expression", "Format", "MiiColor", "Type", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class Mii {
    private int bgColor;
    private int cameraXRotate;
    private int cameraYRotate;
    private int cameraZRotate;
    private int characterXRotate;
    private int characterYRotate;
    private int characterZRotate;
    private MiiColor clothesColor;
    private final byte[] coreData;
    private final String etag;
    private Expression expression;
    private final MiiColor favoriteColor;
    private Format format;
    private final String imageOrigin;
    private final String miiId;
    private final byte[] storeData;
    private Type type;
    private final String urlTemplate;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u001b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c¨\u0006\u001d"}, d2 = {"Lcom/nintendo/npf/sdk/user/Mii$Expression;", "", "", "int", "<init>", "(Ljava/lang/String;II)V", "a", "I", "getInt", "()I", "NORMAL", "SMILE", "ANGER", "SORROW", "SURPRISE", "BLINK", "NORMAL_OPEN_MOUTH", "SMILE_OPEN_MOUTH", "ANGER_OPEN_MOUTH", "SURPRISE_OPEN_MOUTH", "SORROW_OPEN_MOUTH", "BLINK_OPEN_MOUTH", "WINK_LEFT", "WINK_RIGHT", "WINK_LEFT_OPEN_MOUTH", "WINK_RIGHT_OPEN_MOUTH", "LIKE_WINK_LEFT", "LIKE_WINK_RIGHT", "FRUSTRATED", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum Expression {
        NORMAL(0),
        SMILE(1),
        ANGER(2),
        SORROW(3),
        SURPRISE(4),
        BLINK(5),
        NORMAL_OPEN_MOUTH(6),
        SMILE_OPEN_MOUTH(7),
        ANGER_OPEN_MOUTH(8),
        SURPRISE_OPEN_MOUTH(9),
        SORROW_OPEN_MOUTH(10),
        BLINK_OPEN_MOUTH(11),
        WINK_LEFT(12),
        WINK_RIGHT(13),
        WINK_LEFT_OPEN_MOUTH(14),
        WINK_RIGHT_OPEN_MOUTH(15),
        LIKE_WINK_LEFT(16),
        LIKE_WINK_RIGHT(17),
        FRUSTRATED(18);


        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int int;

        Expression(int i) {
            this.int = i;
        }

        public final int getInt() {
            return this.int;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/nintendo/npf/sdk/user/Mii$Format;", "", "", "int", "<init>", "(Ljava/lang/String;II)V", "a", "I", "getInt", "()I", "PNG", "TGA", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum Format {
        PNG(0),
        TGA(1);


        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int int;

        Format(int i) {
            this.int = i;
        }

        public final int getInt() {
            return this.int;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/nintendo/npf/sdk/user/Mii$MiiColor;", "", "", "int", "<init>", "(Ljava/lang/String;II)V", "a", "I", "getInt", "()I", "DEFAULT", "RED", "ORANGE", "YELLOW", "YELLOWGREEN", "GREEN", "BLUE", "SKYBLUE", "PINK", "PURPLE", "BROWN", "WHITE", "BLACK", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum MiiColor {
        DEFAULT(0),
        RED(1),
        ORANGE(2),
        YELLOW(3),
        YELLOWGREEN(4),
        GREEN(5),
        BLUE(6),
        SKYBLUE(7),
        PINK(8),
        PURPLE(9),
        BROWN(10),
        WHITE(11),
        BLACK(12);


        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int int;

        MiiColor(int i) {
            this.int = i;
        }

        public final int getInt() {
            return this.int;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/nintendo/npf/sdk/user/Mii$Type;", "", "", "int", "<init>", "(Ljava/lang/String;II)V", "a", "I", "getInt", "()I", "FACE_96", "FACE_128", "FACE_270", "FACE_512", "FACE_ONLY_96", "FACE_ONLY_128", "FACE_ONLY_270", "FACE_ONLY_512", "ALL_BODY_96", "ALL_BODY_270", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum Type {
        FACE_96(0),
        FACE_128(1),
        FACE_270(2),
        FACE_512(3),
        FACE_ONLY_96(4),
        FACE_ONLY_128(5),
        FACE_ONLY_270(6),
        FACE_ONLY_512(7),
        ALL_BODY_96(8),
        ALL_BODY_270(9);


        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int int;

        Type(int i) {
            this.int = i;
        }

        public final int getInt() {
            return this.int;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f913a;

        static {
            int[] iArr = new int[Type.values().length];
            try {
                iArr[Type.FACE_96.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Type.FACE_128.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Type.FACE_270.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Type.FACE_512.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Type.FACE_ONLY_96.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Type.FACE_ONLY_128.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Type.FACE_ONLY_270.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[Type.FACE_ONLY_512.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[Type.ALL_BODY_96.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[Type.ALL_BODY_270.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            f913a = iArr;
        }
    }

    protected Mii(String urlTemplate, String miiId, byte[] bArr, byte[] bArr2, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(urlTemplate, "urlTemplate");
        Intrinsics.checkNotNullParameter(miiId, "miiId");
        this.urlTemplate = urlTemplate;
        this.miiId = miiId;
        this.coreData = bArr;
        this.storeData = bArr2;
        this.imageOrigin = str;
        this.etag = str2;
        this.format = Format.PNG;
        this.type = Type.FACE_96;
        this.expression = Expression.NORMAL;
        this.bgColor = Color.argb(0, 255, 255, 255);
        MiiColor miiColor = MiiColor.DEFAULT;
        this.clothesColor = miiColor;
        if (str3 == null) {
            this.favoriteColor = miiColor;
            return;
        }
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String upperCase = str3.toUpperCase(US);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        this.favoriteColor = MiiColor.valueOf(upperCase);
    }

    public boolean equals(Object o) {
        byte[] bArr;
        byte[] bArr2;
        if (this == o) {
            return true;
        }
        if (o != null && Intrinsics.areEqual(getClass(), o.getClass())) {
            Mii mii = (Mii) o;
            if (this.bgColor != mii.bgColor || this.cameraXRotate != mii.cameraXRotate || this.cameraYRotate != mii.cameraYRotate || this.cameraZRotate != mii.cameraZRotate || this.characterXRotate != mii.characterXRotate || this.characterYRotate != mii.characterYRotate || this.characterZRotate != mii.characterZRotate || !Intrinsics.areEqual(this.urlTemplate, mii.urlTemplate) || !Intrinsics.areEqual(this.miiId, mii.miiId)) {
                return false;
            }
            byte[] bArr3 = this.coreData;
            if (bArr3 == null || (bArr2 = mii.coreData) == null ? !(bArr3 != null || mii.coreData != null) : Arrays.equals(bArr3, bArr2)) {
                byte[] bArr4 = this.storeData;
                if (bArr4 == null || (bArr = mii.storeData) == null ? !(bArr4 != null || mii.storeData != null) : Arrays.equals(bArr4, bArr)) {
                    if (this.favoriteColor != mii.favoriteColor) {
                        return false;
                    }
                    String str = this.imageOrigin;
                    if (str == null ? mii.imageOrigin != null : !Intrinsics.areEqual(str, mii.imageOrigin)) {
                        return false;
                    }
                    String str2 = this.etag;
                    if (str2 == null ? mii.etag != null : !Intrinsics.areEqual(str2, mii.etag)) {
                        return false;
                    }
                    if (this.format == mii.format && this.type == mii.type && this.expression == mii.expression && this.clothesColor == mii.clothesColor) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int getBgColor() {
        return this.bgColor;
    }

    public final int getCameraXRotate() {
        return this.cameraXRotate;
    }

    public final int getCameraYRotate() {
        return this.cameraYRotate;
    }

    public final int getCameraZRotate() {
        return this.cameraZRotate;
    }

    public final int getCharacterXRotate() {
        return this.characterXRotate;
    }

    public final int getCharacterYRotate() {
        return this.characterYRotate;
    }

    public final int getCharacterZRotate() {
        return this.characterZRotate;
    }

    public final MiiColor getClothesColor() {
        return this.clothesColor;
    }

    public final byte[] getCoreData() {
        return this.coreData;
    }

    public final String getEtag() {
        return this.etag;
    }

    public final Expression getExpression() {
        return this.expression;
    }

    public final MiiColor getFavoriteColor() {
        return this.favoriteColor;
    }

    public final Format getFormat() {
        return this.format;
    }

    public final String getImageOrigin() {
        return this.imageOrigin;
    }

    public final String getImageUrl() {
        String str;
        String str2;
        if (this.imageOrigin == null || this.etag == null) {
            return null;
        }
        String str3 = this.urlTemplate;
        String strSubstring = str3.substring(0, StringsKt.indexOf$default((CharSequence) str3, "?", 0, false, 6, (Object) null));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        String strReplace = StringsKt.replace(StringsKt.replace(StringsKt.replace(new Regex("\\{").replace(strSubstring, ""), "imageOrigin}", this.imageOrigin, false), "id}", this.miiId, false), "etag}", this.etag, false);
        String string = this.format.toString();
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = string.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        StringBuilder sbAppend = new StringBuilder().append(StringsKt.replace(strReplace, "format}", lowerCase, false)).append("?expression=");
        String string2 = this.expression.toString();
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase2 = string2.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
        StringBuilder sbAppend2 = new StringBuilder().append(sbAppend.append(lowerCase2).toString());
        Type type = this.type;
        int[] iArr = WhenMappings.f913a;
        switch (iArr[type.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                str = "&type=face";
                break;
            case 5:
            case 6:
            case 7:
            case 8:
                str = "&type=face_only";
                break;
            case 9:
            case 10:
                str = "&type=all_body";
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        StringBuilder sbAppend3 = new StringBuilder().append(sbAppend2.append(str).toString());
        switch (iArr[this.type.ordinal()]) {
            case 1:
            case 5:
            case 9:
                str2 = "&width=96";
                break;
            case 2:
            case 6:
                str2 = "&width=128";
                break;
            case 3:
            case 7:
            case 10:
                str2 = "&width=270";
                break;
            case 4:
            case 8:
                str2 = "&width=512";
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        String string3 = sbAppend3.append(str2).toString();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str4 = String.format(US, "%08X", Arrays.copyOf(new Object[]{Integer.valueOf(this.bgColor)}, 1));
        Intrinsics.checkNotNullExpressionValue(str4, "format(locale, format, *args)");
        String strSubstring2 = str4.substring(2);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
        StringBuilder sbAppend4 = new StringBuilder().append(strSubstring2);
        String strSubstring3 = str4.substring(0, 2);
        Intrinsics.checkNotNullExpressionValue(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
        StringBuilder sbAppend5 = new StringBuilder().append(string3 + "&bgColor=" + sbAppend4.append(strSubstring3).toString()).append("&clothesColor=");
        String string4 = this.clothesColor.toString();
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase3 = string4.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase3, "this as java.lang.String).toLowerCase(locale)");
        return (((((sbAppend5.append(lowerCase3).toString() + "&cameraXRotate=" + this.cameraXRotate) + "&cameraYRotate=" + this.cameraYRotate) + "&cameraZRotate=" + this.cameraZRotate) + "&characterXRotate=" + this.characterXRotate) + "&characterYRotate=" + this.characterYRotate) + "&characterZRotate=" + this.characterZRotate;
    }

    public final String getMiiId() {
        return this.miiId;
    }

    public final byte[] getStoreData() {
        return this.storeData;
    }

    public final Type getType() {
        return this.type;
    }

    public final String getUrlTemplate() {
        return this.urlTemplate;
    }

    public int hashCode() {
        int iHashCode = ((this.urlTemplate.hashCode() * 31) + this.miiId.hashCode()) * 31;
        byte[] bArr = this.coreData;
        int iHashCode2 = (iHashCode + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 31;
        byte[] bArr2 = this.storeData;
        int iHashCode3 = (((iHashCode2 + (bArr2 != null ? Arrays.hashCode(bArr2) : 0)) * 31) + this.favoriteColor.hashCode()) * 31;
        String str = this.imageOrigin;
        int iHashCode4 = (iHashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.etag;
        return ((((((((((((((((((((((iHashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.format.hashCode()) * 31) + this.type.hashCode()) * 31) + this.expression.hashCode()) * 31) + this.bgColor) * 31) + this.clothesColor.hashCode()) * 31) + this.cameraXRotate) * 31) + this.cameraYRotate) * 31) + this.cameraZRotate) * 31) + this.characterXRotate) * 31) + this.characterYRotate) * 31) + this.characterZRotate;
    }

    public final void setBgColor(int i) {
        this.bgColor = i;
    }

    public final void setCameraXRotate(int i) {
        this.cameraXRotate = i;
    }

    public final void setCameraYRotate(int i) {
        this.cameraYRotate = i;
    }

    public final void setCameraZRotate(int i) {
        this.cameraZRotate = i;
    }

    public final void setCharacterXRotate(int i) {
        this.characterXRotate = i;
    }

    public final void setCharacterYRotate(int i) {
        this.characterYRotate = i;
    }

    public final void setCharacterZRotate(int i) {
        this.characterZRotate = i;
    }

    public final void setClothesColor(MiiColor miiColor) {
        Intrinsics.checkNotNullParameter(miiColor, "<set-?>");
        this.clothesColor = miiColor;
    }

    public final void setExpression(Expression expression) {
        Intrinsics.checkNotNullParameter(expression, "<set-?>");
        this.expression = expression;
    }

    public final void setFormat(Format format) {
        Intrinsics.checkNotNullParameter(format, "<set-?>");
        this.format = format;
    }

    public final void setType(Type type) {
        Intrinsics.checkNotNullParameter(type, "<set-?>");
        this.type = type;
    }
}
