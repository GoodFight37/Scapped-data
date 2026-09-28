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
public final class VirtualCurrencyTransactionList extends GeneratedMessageLite<VirtualCurrencyTransactionList, Builder> implements VirtualCurrencyTransactionListOrBuilder {
    private static final VirtualCurrencyTransactionList DEFAULT_INSTANCE;
    private static volatile Parser<VirtualCurrencyTransactionList> PARSER = null;
    public static final int VIRTUAL_CURRENCY_TRANSACTION_FIELD_NUMBER = 1;
    private Internal.ProtobufList<VirtualCurrencyTransaction> virtualCurrencyTransaction_ = GeneratedMessageLite.emptyProtobufList();

    public static final class Builder extends GeneratedMessageLite.Builder<VirtualCurrencyTransactionList, Builder> implements VirtualCurrencyTransactionListOrBuilder {
        /* synthetic */ Builder(a aVar) {
            this();
        }

        public Builder addAllVirtualCurrencyTransaction(Iterable<? extends VirtualCurrencyTransaction> iterable) {
            copyOnWrite();
            ((VirtualCurrencyTransactionList) this.instance).addAllVirtualCurrencyTransaction(iterable);
            return this;
        }

        public Builder addVirtualCurrencyTransaction(VirtualCurrencyTransaction virtualCurrencyTransaction) {
            copyOnWrite();
            ((VirtualCurrencyTransactionList) this.instance).addVirtualCurrencyTransaction(virtualCurrencyTransaction);
            return this;
        }

        public Builder clearVirtualCurrencyTransaction() {
            copyOnWrite();
            ((VirtualCurrencyTransactionList) this.instance).clearVirtualCurrencyTransaction();
            return this;
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.VirtualCurrencyTransactionListOrBuilder
        public VirtualCurrencyTransaction getVirtualCurrencyTransaction(int i) {
            return ((VirtualCurrencyTransactionList) this.instance).getVirtualCurrencyTransaction(i);
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.VirtualCurrencyTransactionListOrBuilder
        public int getVirtualCurrencyTransactionCount() {
            return ((VirtualCurrencyTransactionList) this.instance).getVirtualCurrencyTransactionCount();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.VirtualCurrencyTransactionListOrBuilder
        public List<VirtualCurrencyTransaction> getVirtualCurrencyTransactionList() {
            return Collections.unmodifiableList(((VirtualCurrencyTransactionList) this.instance).getVirtualCurrencyTransactionList());
        }

        public Builder removeVirtualCurrencyTransaction(int i) {
            copyOnWrite();
            ((VirtualCurrencyTransactionList) this.instance).removeVirtualCurrencyTransaction(i);
            return this;
        }

        public Builder setVirtualCurrencyTransaction(int i, VirtualCurrencyTransaction virtualCurrencyTransaction) {
            copyOnWrite();
            ((VirtualCurrencyTransactionList) this.instance).setVirtualCurrencyTransaction(i, virtualCurrencyTransaction);
            return this;
        }

        private Builder() {
            super(VirtualCurrencyTransactionList.DEFAULT_INSTANCE);
        }

        public Builder addVirtualCurrencyTransaction(int i, VirtualCurrencyTransaction virtualCurrencyTransaction) {
            copyOnWrite();
            ((VirtualCurrencyTransactionList) this.instance).addVirtualCurrencyTransaction(i, virtualCurrencyTransaction);
            return this;
        }

        public Builder setVirtualCurrencyTransaction(int i, VirtualCurrencyTransaction.Builder builder) {
            copyOnWrite();
            ((VirtualCurrencyTransactionList) this.instance).setVirtualCurrencyTransaction(i, builder.build());
            return this;
        }

        public Builder addVirtualCurrencyTransaction(VirtualCurrencyTransaction.Builder builder) {
            copyOnWrite();
            ((VirtualCurrencyTransactionList) this.instance).addVirtualCurrencyTransaction(builder.build());
            return this;
        }

        public Builder addVirtualCurrencyTransaction(int i, VirtualCurrencyTransaction.Builder builder) {
            copyOnWrite();
            ((VirtualCurrencyTransactionList) this.instance).addVirtualCurrencyTransaction(i, builder.build());
            return this;
        }
    }

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f748a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f748a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f748a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f748a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f748a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f748a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f748a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f748a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    static {
        VirtualCurrencyTransactionList virtualCurrencyTransactionList = new VirtualCurrencyTransactionList();
        DEFAULT_INSTANCE = virtualCurrencyTransactionList;
        GeneratedMessageLite.registerDefaultInstance(VirtualCurrencyTransactionList.class, virtualCurrencyTransactionList);
    }

    private VirtualCurrencyTransactionList() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllVirtualCurrencyTransaction(Iterable<? extends VirtualCurrencyTransaction> iterable) {
        ensureVirtualCurrencyTransactionIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.virtualCurrencyTransaction_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addVirtualCurrencyTransaction(VirtualCurrencyTransaction virtualCurrencyTransaction) {
        virtualCurrencyTransaction.getClass();
        ensureVirtualCurrencyTransactionIsMutable();
        this.virtualCurrencyTransaction_.add(virtualCurrencyTransaction);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVirtualCurrencyTransaction() {
        this.virtualCurrencyTransaction_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureVirtualCurrencyTransactionIsMutable() {
        Internal.ProtobufList<VirtualCurrencyTransaction> protobufList = this.virtualCurrencyTransaction_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.virtualCurrencyTransaction_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static VirtualCurrencyTransactionList getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static VirtualCurrencyTransactionList parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (VirtualCurrencyTransactionList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VirtualCurrencyTransactionList parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (VirtualCurrencyTransactionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<VirtualCurrencyTransactionList> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeVirtualCurrencyTransaction(int i) {
        ensureVirtualCurrencyTransactionIsMutable();
        this.virtualCurrencyTransaction_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVirtualCurrencyTransaction(int i, VirtualCurrencyTransaction virtualCurrencyTransaction) {
        virtualCurrencyTransaction.getClass();
        ensureVirtualCurrencyTransactionIsMutable();
        this.virtualCurrencyTransaction_.set(i, virtualCurrencyTransaction);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        a aVar = null;
        switch (a.f748a[methodToInvoke.ordinal()]) {
            case 1:
                return new VirtualCurrencyTransactionList();
            case 2:
                return new Builder(aVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"virtualCurrencyTransaction_", VirtualCurrencyTransaction.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<VirtualCurrencyTransactionList> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (VirtualCurrencyTransactionList.class) {
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

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.VirtualCurrencyTransactionListOrBuilder
    public VirtualCurrencyTransaction getVirtualCurrencyTransaction(int i) {
        return this.virtualCurrencyTransaction_.get(i);
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.VirtualCurrencyTransactionListOrBuilder
    public int getVirtualCurrencyTransactionCount() {
        return this.virtualCurrencyTransaction_.size();
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.VirtualCurrencyTransactionListOrBuilder
    public List<VirtualCurrencyTransaction> getVirtualCurrencyTransactionList() {
        return this.virtualCurrencyTransaction_;
    }

    public VirtualCurrencyTransactionOrBuilder getVirtualCurrencyTransactionOrBuilder(int i) {
        return this.virtualCurrencyTransaction_.get(i);
    }

    public List<? extends VirtualCurrencyTransactionOrBuilder> getVirtualCurrencyTransactionOrBuilderList() {
        return this.virtualCurrencyTransaction_;
    }

    public static Builder newBuilder(VirtualCurrencyTransactionList virtualCurrencyTransactionList) {
        return DEFAULT_INSTANCE.createBuilder(virtualCurrencyTransactionList);
    }

    public static VirtualCurrencyTransactionList parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (VirtualCurrencyTransactionList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static VirtualCurrencyTransactionList parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (VirtualCurrencyTransactionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static VirtualCurrencyTransactionList parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (VirtualCurrencyTransactionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addVirtualCurrencyTransaction(int i, VirtualCurrencyTransaction virtualCurrencyTransaction) {
        virtualCurrencyTransaction.getClass();
        ensureVirtualCurrencyTransactionIsMutable();
        this.virtualCurrencyTransaction_.add(i, virtualCurrencyTransaction);
    }

    public static VirtualCurrencyTransactionList parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (VirtualCurrencyTransactionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static VirtualCurrencyTransactionList parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (VirtualCurrencyTransactionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static VirtualCurrencyTransactionList parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (VirtualCurrencyTransactionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static VirtualCurrencyTransactionList parseFrom(InputStream inputStream) throws IOException {
        return (VirtualCurrencyTransactionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VirtualCurrencyTransactionList parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (VirtualCurrencyTransactionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static VirtualCurrencyTransactionList parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (VirtualCurrencyTransactionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static VirtualCurrencyTransactionList parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (VirtualCurrencyTransactionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
