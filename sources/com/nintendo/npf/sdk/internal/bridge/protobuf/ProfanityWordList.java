package com.nintendo.npf.sdk.internal.bridge.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class ProfanityWordList extends GeneratedMessageLite<ProfanityWordList, Builder> implements ProfanityWordListOrBuilder {
    private static final ProfanityWordList DEFAULT_INSTANCE;
    private static volatile Parser<ProfanityWordList> PARSER = null;
    public static final int PROFANITY_WORD_FIELD_NUMBER = 1;
    private Internal.ProtobufList<ProfanityWord> profanityWord_ = GeneratedMessageLite.emptyProtobufList();

    public static final class Builder extends GeneratedMessageLite.Builder<ProfanityWordList, Builder> implements ProfanityWordListOrBuilder {
        /* synthetic */ Builder(a aVar) {
            this();
        }

        public Builder addAllProfanityWord(Iterable<? extends ProfanityWord> iterable) {
            copyOnWrite();
            ((ProfanityWordList) this.instance).addAllProfanityWord(iterable);
            return this;
        }

        public Builder addProfanityWord(ProfanityWord profanityWord) {
            copyOnWrite();
            ((ProfanityWordList) this.instance).addProfanityWord(profanityWord);
            return this;
        }

        public Builder clearProfanityWord() {
            copyOnWrite();
            ((ProfanityWordList) this.instance).clearProfanityWord();
            return this;
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.ProfanityWordListOrBuilder
        public ProfanityWord getProfanityWord(int i) {
            return ((ProfanityWordList) this.instance).getProfanityWord(i);
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.ProfanityWordListOrBuilder
        public int getProfanityWordCount() {
            return ((ProfanityWordList) this.instance).getProfanityWordCount();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.ProfanityWordListOrBuilder
        public List<ProfanityWord> getProfanityWordList() {
            return Collections.unmodifiableList(((ProfanityWordList) this.instance).getProfanityWordList());
        }

        public Builder removeProfanityWord(int i) {
            copyOnWrite();
            ((ProfanityWordList) this.instance).removeProfanityWord(i);
            return this;
        }

        public Builder setProfanityWord(int i, ProfanityWord profanityWord) {
            copyOnWrite();
            ((ProfanityWordList) this.instance).setProfanityWord(i, profanityWord);
            return this;
        }

        private Builder() {
            super(ProfanityWordList.DEFAULT_INSTANCE);
        }

        public Builder addProfanityWord(int i, ProfanityWord profanityWord) {
            copyOnWrite();
            ((ProfanityWordList) this.instance).addProfanityWord(i, profanityWord);
            return this;
        }

        public Builder setProfanityWord(int i, ProfanityWord.Builder builder) {
            copyOnWrite();
            ((ProfanityWordList) this.instance).setProfanityWord(i, builder.build());
            return this;
        }

        public Builder addProfanityWord(ProfanityWord.Builder builder) {
            copyOnWrite();
            ((ProfanityWordList) this.instance).addProfanityWord(builder.build());
            return this;
        }

        public Builder addProfanityWord(int i, ProfanityWord.Builder builder) {
            copyOnWrite();
            ((ProfanityWordList) this.instance).addProfanityWord(i, builder.build());
            return this;
        }
    }

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f739a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f739a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f739a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f739a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f739a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f739a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f739a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f739a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    static {
        ProfanityWordList profanityWordList = new ProfanityWordList();
        DEFAULT_INSTANCE = profanityWordList;
        GeneratedMessageLite.registerDefaultInstance(ProfanityWordList.class, profanityWordList);
    }

    private ProfanityWordList() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllProfanityWord(Iterable<? extends ProfanityWord> iterable) {
        ensureProfanityWordIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.profanityWord_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addProfanityWord(ProfanityWord profanityWord) {
        profanityWord.getClass();
        ensureProfanityWordIsMutable();
        this.profanityWord_.add(profanityWord);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearProfanityWord() {
        this.profanityWord_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureProfanityWordIsMutable() {
        Internal.ProtobufList<ProfanityWord> protobufList = this.profanityWord_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.profanityWord_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static ProfanityWordList getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static ProfanityWordList parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ProfanityWordList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ProfanityWordList parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ProfanityWordList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ProfanityWordList> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeProfanityWord(int i) {
        ensureProfanityWordIsMutable();
        this.profanityWord_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProfanityWord(int i, ProfanityWord profanityWord) {
        profanityWord.getClass();
        ensureProfanityWordIsMutable();
        this.profanityWord_.set(i, profanityWord);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        a aVar = null;
        switch (a.f739a[methodToInvoke.ordinal()]) {
            case 1:
                return new ProfanityWordList();
            case 2:
                return new Builder(aVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"profanityWord_", ProfanityWord.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ProfanityWordList> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ProfanityWordList.class) {
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

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.ProfanityWordListOrBuilder
    public ProfanityWord getProfanityWord(int i) {
        return this.profanityWord_.get(i);
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.ProfanityWordListOrBuilder
    public int getProfanityWordCount() {
        return this.profanityWord_.size();
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.ProfanityWordListOrBuilder
    public List<ProfanityWord> getProfanityWordList() {
        return this.profanityWord_;
    }

    public ProfanityWordOrBuilder getProfanityWordOrBuilder(int i) {
        return this.profanityWord_.get(i);
    }

    public List<? extends ProfanityWordOrBuilder> getProfanityWordOrBuilderList() {
        return this.profanityWord_;
    }

    public static Builder newBuilder(ProfanityWordList profanityWordList) {
        return DEFAULT_INSTANCE.createBuilder(profanityWordList);
    }

    public static ProfanityWordList parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ProfanityWordList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ProfanityWordList parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ProfanityWordList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ProfanityWordList parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ProfanityWordList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addProfanityWord(int i, ProfanityWord profanityWord) {
        profanityWord.getClass();
        ensureProfanityWordIsMutable();
        this.profanityWord_.add(i, profanityWord);
    }

    public static ProfanityWordList parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ProfanityWordList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ProfanityWordList parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ProfanityWordList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ProfanityWordList parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ProfanityWordList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ProfanityWordList parseFrom(InputStream inputStream) throws IOException {
        return (ProfanityWordList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ProfanityWordList parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ProfanityWordList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ProfanityWordList parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ProfanityWordList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ProfanityWordList parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ProfanityWordList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
