package com.nintendo.npf.sdk.internal.bridge.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.nintendo.npf.sdk.internal.model.IProfanityWord;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class ProfanityWord extends GeneratedMessageLite<ProfanityWord, Builder> implements IProfanityWord, ProfanityWordOrBuilder {
    public static final int CHECK_STATUS_FIELD_NUMBER = 4;
    private static final ProfanityWord DEFAULT_INSTANCE;
    public static final int DICTIONARY_TYPE_FIELD_NUMBER = 3;
    public static final int LANGUAGE_FIELD_NUMBER = 1;
    private static volatile Parser<ProfanityWord> PARSER = null;
    public static final int TEXT_FIELD_NUMBER = 2;
    private int bitField0_;
    private int checkStatus_;
    private int dictionaryType_;
    private String language_ = "";
    private String text_ = "";

    public static final class Builder extends GeneratedMessageLite.Builder<ProfanityWord, Builder> implements ProfanityWordOrBuilder {
        /* synthetic */ Builder(a aVar) {
            this();
        }

        public Builder clearCheckStatus() {
            copyOnWrite();
            ((ProfanityWord) this.instance).clearCheckStatus();
            return this;
        }

        public Builder clearDictionaryType() {
            copyOnWrite();
            ((ProfanityWord) this.instance).clearDictionaryType();
            return this;
        }

        public Builder clearLanguage() {
            copyOnWrite();
            ((ProfanityWord) this.instance).clearLanguage();
            return this;
        }

        public Builder clearText() {
            copyOnWrite();
            ((ProfanityWord) this.instance).clearText();
            return this;
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.ProfanityWordOrBuilder
        public ProfanityCheckStatus getCheckStatus() {
            return ((ProfanityWord) this.instance).getCheckStatus();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.ProfanityWordOrBuilder
        public ProfanityDictionaryType getDictionaryType() {
            return ((ProfanityWord) this.instance).getDictionaryType();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.ProfanityWordOrBuilder
        public String getLanguage() {
            return ((ProfanityWord) this.instance).getLanguage();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.ProfanityWordOrBuilder
        public ByteString getLanguageBytes() {
            return ((ProfanityWord) this.instance).getLanguageBytes();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.ProfanityWordOrBuilder
        public String getText() {
            return ((ProfanityWord) this.instance).getText();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.ProfanityWordOrBuilder
        public ByteString getTextBytes() {
            return ((ProfanityWord) this.instance).getTextBytes();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.ProfanityWordOrBuilder
        public boolean hasCheckStatus() {
            return ((ProfanityWord) this.instance).hasCheckStatus();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.ProfanityWordOrBuilder
        public boolean hasDictionaryType() {
            return ((ProfanityWord) this.instance).hasDictionaryType();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.ProfanityWordOrBuilder
        public boolean hasLanguage() {
            return ((ProfanityWord) this.instance).hasLanguage();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.ProfanityWordOrBuilder
        public boolean hasText() {
            return ((ProfanityWord) this.instance).hasText();
        }

        public Builder setCheckStatus(ProfanityCheckStatus profanityCheckStatus) {
            copyOnWrite();
            ((ProfanityWord) this.instance).setCheckStatus(profanityCheckStatus);
            return this;
        }

        public Builder setDictionaryType(ProfanityDictionaryType profanityDictionaryType) {
            copyOnWrite();
            ((ProfanityWord) this.instance).setDictionaryType(profanityDictionaryType);
            return this;
        }

        public Builder setLanguage(String str) {
            copyOnWrite();
            ((ProfanityWord) this.instance).setLanguage(str);
            return this;
        }

        public Builder setLanguageBytes(ByteString byteString) {
            copyOnWrite();
            ((ProfanityWord) this.instance).setLanguageBytes(byteString);
            return this;
        }

        public Builder setText(String str) {
            copyOnWrite();
            ((ProfanityWord) this.instance).setText(str);
            return this;
        }

        public Builder setTextBytes(ByteString byteString) {
            copyOnWrite();
            ((ProfanityWord) this.instance).setTextBytes(byteString);
            return this;
        }

        private Builder() {
            super(ProfanityWord.DEFAULT_INSTANCE);
        }
    }

    public enum ProfanityCheckStatus implements Internal.EnumLite {
        UNCHECKED(0),
        INVALID(1),
        VALID(2);

        public static final int INVALID_VALUE = 1;
        public static final int UNCHECKED_VALUE = 0;
        public static final int VALID_VALUE = 2;
        private static final Internal.EnumLiteMap<ProfanityCheckStatus> internalValueMap = new a();
        private final int value;

        class a implements Internal.EnumLiteMap {
            a() {
            }

            @Override // com.google.protobuf.Internal.EnumLiteMap
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ProfanityCheckStatus findValueByNumber(int i) {
                return ProfanityCheckStatus.forNumber(i);
            }
        }

        private static final class b implements Internal.EnumVerifier {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            static final Internal.EnumVerifier f736a = new b();

            private b() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return ProfanityCheckStatus.forNumber(i) != null;
            }
        }

        ProfanityCheckStatus(int i) {
            this.value = i;
        }

        public static ProfanityCheckStatus forNumber(int i) {
            if (i == 0) {
                return UNCHECKED;
            }
            if (i == 1) {
                return INVALID;
            }
            if (i != 2) {
                return null;
            }
            return VALID;
        }

        public static Internal.EnumLiteMap<ProfanityCheckStatus> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return b.f736a;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static ProfanityCheckStatus valueOf(int i) {
            return forNumber(i);
        }
    }

    public enum ProfanityDictionaryType implements Internal.EnumLite {
        NICKNAME(0),
        COMMON(1);

        public static final int COMMON_VALUE = 1;
        public static final int NICKNAME_VALUE = 0;
        private static final Internal.EnumLiteMap<ProfanityDictionaryType> internalValueMap = new a();
        private final int value;

        class a implements Internal.EnumLiteMap {
            a() {
            }

            @Override // com.google.protobuf.Internal.EnumLiteMap
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ProfanityDictionaryType findValueByNumber(int i) {
                return ProfanityDictionaryType.forNumber(i);
            }
        }

        private static final class b implements Internal.EnumVerifier {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            static final Internal.EnumVerifier f737a = new b();

            private b() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return ProfanityDictionaryType.forNumber(i) != null;
            }
        }

        ProfanityDictionaryType(int i) {
            this.value = i;
        }

        public static ProfanityDictionaryType forNumber(int i) {
            if (i == 0) {
                return NICKNAME;
            }
            if (i != 1) {
                return null;
            }
            return COMMON;
        }

        public static Internal.EnumLiteMap<ProfanityDictionaryType> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return b.f737a;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static ProfanityDictionaryType valueOf(int i) {
            return forNumber(i);
        }
    }

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f738a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f738a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f738a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f738a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f738a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f738a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f738a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f738a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    static {
        ProfanityWord profanityWord = new ProfanityWord();
        DEFAULT_INSTANCE = profanityWord;
        GeneratedMessageLite.registerDefaultInstance(ProfanityWord.class, profanityWord);
    }

    private ProfanityWord() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCheckStatus() {
        this.bitField0_ &= -9;
        this.checkStatus_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDictionaryType() {
        this.bitField0_ &= -5;
        this.dictionaryType_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLanguage() {
        this.bitField0_ &= -2;
        this.language_ = getDefaultInstance().getLanguage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearText() {
        this.bitField0_ &= -3;
        this.text_ = getDefaultInstance().getText();
    }

    public static ProfanityWord getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static ProfanityWord parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ProfanityWord) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ProfanityWord parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ProfanityWord) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ProfanityWord> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckStatus(ProfanityCheckStatus profanityCheckStatus) {
        this.checkStatus_ = profanityCheckStatus.getNumber();
        this.bitField0_ |= 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDictionaryType(ProfanityDictionaryType profanityDictionaryType) {
        this.dictionaryType_ = profanityDictionaryType.getNumber();
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLanguage(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.language_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLanguageBytes(ByteString byteString) {
        this.language_ = byteString.toStringUtf8();
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setText(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.text_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTextBytes(ByteString byteString) {
        this.text_ = byteString.toStringUtf8();
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        a aVar = null;
        switch (a.f738a[methodToInvoke.ordinal()]) {
            case 1:
                return new ProfanityWord();
            case 2:
                return new Builder(aVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဌ\u0002\u0004ဌ\u0003", new Object[]{"bitField0_", "language_", "text_", "dictionaryType_", ProfanityDictionaryType.internalGetVerifier(), "checkStatus_", ProfanityCheckStatus.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ProfanityWord> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ProfanityWord.class) {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                    break;
                }
                return defaultInstanceBasedParser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.ProfanityWordOrBuilder
    public ProfanityCheckStatus getCheckStatus() {
        ProfanityCheckStatus profanityCheckStatusForNumber = ProfanityCheckStatus.forNumber(this.checkStatus_);
        return profanityCheckStatusForNumber == null ? ProfanityCheckStatus.UNCHECKED : profanityCheckStatusForNumber;
    }

    @Override // com.nintendo.npf.sdk.internal.model.IProfanityWord
    public String getCheckStatusString() {
        return getCheckStatus().name();
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.ProfanityWordOrBuilder
    public ProfanityDictionaryType getDictionaryType() {
        ProfanityDictionaryType profanityDictionaryTypeForNumber = ProfanityDictionaryType.forNumber(this.dictionaryType_);
        return profanityDictionaryTypeForNumber == null ? ProfanityDictionaryType.NICKNAME : profanityDictionaryTypeForNumber;
    }

    @Override // com.nintendo.npf.sdk.internal.model.IProfanityWord
    public String getDictionaryTypeString() {
        return getDictionaryType().name();
    }

    @Override // com.nintendo.npf.sdk.internal.model.IProfanityWord
    public String getLanguage() {
        return this.language_;
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.ProfanityWordOrBuilder
    public ByteString getLanguageBytes() {
        return ByteString.copyFromUtf8(this.language_);
    }

    @Override // com.nintendo.npf.sdk.internal.model.IProfanityWord
    public String getText() {
        return this.text_;
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.ProfanityWordOrBuilder
    public ByteString getTextBytes() {
        return ByteString.copyFromUtf8(this.text_);
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.ProfanityWordOrBuilder
    public boolean hasCheckStatus() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.ProfanityWordOrBuilder
    public boolean hasDictionaryType() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.ProfanityWordOrBuilder
    public boolean hasLanguage() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.ProfanityWordOrBuilder
    public boolean hasText() {
        return (this.bitField0_ & 2) != 0;
    }

    public static Builder newBuilder(ProfanityWord profanityWord) {
        return DEFAULT_INSTANCE.createBuilder(profanityWord);
    }

    public static ProfanityWord parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ProfanityWord) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ProfanityWord parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ProfanityWord) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ProfanityWord parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ProfanityWord) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ProfanityWord parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ProfanityWord) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ProfanityWord parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ProfanityWord) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ProfanityWord parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ProfanityWord) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ProfanityWord parseFrom(InputStream inputStream) throws IOException {
        return (ProfanityWord) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ProfanityWord parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ProfanityWord) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ProfanityWord parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ProfanityWord) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ProfanityWord parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ProfanityWord) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
