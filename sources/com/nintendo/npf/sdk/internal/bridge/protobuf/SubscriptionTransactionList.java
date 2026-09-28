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
public final class SubscriptionTransactionList extends GeneratedMessageLite<SubscriptionTransactionList, Builder> implements SubscriptionTransactionListOrBuilder {
    private static final SubscriptionTransactionList DEFAULT_INSTANCE;
    private static volatile Parser<SubscriptionTransactionList> PARSER = null;
    public static final int SUBSCRIPTION_TRANSACTION_FIELD_NUMBER = 1;
    private Internal.ProtobufList<SubscriptionTransaction> subscriptionTransaction_ = GeneratedMessageLite.emptyProtobufList();

    public static final class Builder extends GeneratedMessageLite.Builder<SubscriptionTransactionList, Builder> implements SubscriptionTransactionListOrBuilder {
        /* synthetic */ Builder(a aVar) {
            this();
        }

        public Builder addAllSubscriptionTransaction(Iterable<? extends SubscriptionTransaction> iterable) {
            copyOnWrite();
            ((SubscriptionTransactionList) this.instance).addAllSubscriptionTransaction(iterable);
            return this;
        }

        public Builder addSubscriptionTransaction(SubscriptionTransaction subscriptionTransaction) {
            copyOnWrite();
            ((SubscriptionTransactionList) this.instance).addSubscriptionTransaction(subscriptionTransaction);
            return this;
        }

        public Builder clearSubscriptionTransaction() {
            copyOnWrite();
            ((SubscriptionTransactionList) this.instance).clearSubscriptionTransaction();
            return this;
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.SubscriptionTransactionListOrBuilder
        public SubscriptionTransaction getSubscriptionTransaction(int i) {
            return ((SubscriptionTransactionList) this.instance).getSubscriptionTransaction(i);
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.SubscriptionTransactionListOrBuilder
        public int getSubscriptionTransactionCount() {
            return ((SubscriptionTransactionList) this.instance).getSubscriptionTransactionCount();
        }

        @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.SubscriptionTransactionListOrBuilder
        public List<SubscriptionTransaction> getSubscriptionTransactionList() {
            return Collections.unmodifiableList(((SubscriptionTransactionList) this.instance).getSubscriptionTransactionList());
        }

        public Builder removeSubscriptionTransaction(int i) {
            copyOnWrite();
            ((SubscriptionTransactionList) this.instance).removeSubscriptionTransaction(i);
            return this;
        }

        public Builder setSubscriptionTransaction(int i, SubscriptionTransaction subscriptionTransaction) {
            copyOnWrite();
            ((SubscriptionTransactionList) this.instance).setSubscriptionTransaction(i, subscriptionTransaction);
            return this;
        }

        private Builder() {
            super(SubscriptionTransactionList.DEFAULT_INSTANCE);
        }

        public Builder addSubscriptionTransaction(int i, SubscriptionTransaction subscriptionTransaction) {
            copyOnWrite();
            ((SubscriptionTransactionList) this.instance).addSubscriptionTransaction(i, subscriptionTransaction);
            return this;
        }

        public Builder setSubscriptionTransaction(int i, SubscriptionTransaction.Builder builder) {
            copyOnWrite();
            ((SubscriptionTransactionList) this.instance).setSubscriptionTransaction(i, builder.build());
            return this;
        }

        public Builder addSubscriptionTransaction(SubscriptionTransaction.Builder builder) {
            copyOnWrite();
            ((SubscriptionTransactionList) this.instance).addSubscriptionTransaction(builder.build());
            return this;
        }

        public Builder addSubscriptionTransaction(int i, SubscriptionTransaction.Builder builder) {
            copyOnWrite();
            ((SubscriptionTransactionList) this.instance).addSubscriptionTransaction(i, builder.build());
            return this;
        }
    }

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f742a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f742a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f742a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f742a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f742a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f742a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f742a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f742a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    static {
        SubscriptionTransactionList subscriptionTransactionList = new SubscriptionTransactionList();
        DEFAULT_INSTANCE = subscriptionTransactionList;
        GeneratedMessageLite.registerDefaultInstance(SubscriptionTransactionList.class, subscriptionTransactionList);
    }

    private SubscriptionTransactionList() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllSubscriptionTransaction(Iterable<? extends SubscriptionTransaction> iterable) {
        ensureSubscriptionTransactionIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.subscriptionTransaction_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSubscriptionTransaction(SubscriptionTransaction subscriptionTransaction) {
        subscriptionTransaction.getClass();
        ensureSubscriptionTransactionIsMutable();
        this.subscriptionTransaction_.add(subscriptionTransaction);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSubscriptionTransaction() {
        this.subscriptionTransaction_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureSubscriptionTransactionIsMutable() {
        Internal.ProtobufList<SubscriptionTransaction> protobufList = this.subscriptionTransaction_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.subscriptionTransaction_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static SubscriptionTransactionList getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static SubscriptionTransactionList parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (SubscriptionTransactionList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SubscriptionTransactionList parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (SubscriptionTransactionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<SubscriptionTransactionList> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeSubscriptionTransaction(int i) {
        ensureSubscriptionTransactionIsMutable();
        this.subscriptionTransaction_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSubscriptionTransaction(int i, SubscriptionTransaction subscriptionTransaction) {
        subscriptionTransaction.getClass();
        ensureSubscriptionTransactionIsMutable();
        this.subscriptionTransaction_.set(i, subscriptionTransaction);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        a aVar = null;
        switch (a.f742a[methodToInvoke.ordinal()]) {
            case 1:
                return new SubscriptionTransactionList();
            case 2:
                return new Builder(aVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"subscriptionTransaction_", SubscriptionTransaction.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<SubscriptionTransactionList> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (SubscriptionTransactionList.class) {
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

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.SubscriptionTransactionListOrBuilder
    public SubscriptionTransaction getSubscriptionTransaction(int i) {
        return this.subscriptionTransaction_.get(i);
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.SubscriptionTransactionListOrBuilder
    public int getSubscriptionTransactionCount() {
        return this.subscriptionTransaction_.size();
    }

    @Override // com.nintendo.npf.sdk.internal.bridge.protobuf.SubscriptionTransactionListOrBuilder
    public List<SubscriptionTransaction> getSubscriptionTransactionList() {
        return this.subscriptionTransaction_;
    }

    public SubscriptionTransactionOrBuilder getSubscriptionTransactionOrBuilder(int i) {
        return this.subscriptionTransaction_.get(i);
    }

    public List<? extends SubscriptionTransactionOrBuilder> getSubscriptionTransactionOrBuilderList() {
        return this.subscriptionTransaction_;
    }

    public static Builder newBuilder(SubscriptionTransactionList subscriptionTransactionList) {
        return DEFAULT_INSTANCE.createBuilder(subscriptionTransactionList);
    }

    public static SubscriptionTransactionList parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SubscriptionTransactionList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SubscriptionTransactionList parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (SubscriptionTransactionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static SubscriptionTransactionList parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (SubscriptionTransactionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSubscriptionTransaction(int i, SubscriptionTransaction subscriptionTransaction) {
        subscriptionTransaction.getClass();
        ensureSubscriptionTransactionIsMutable();
        this.subscriptionTransaction_.add(i, subscriptionTransaction);
    }

    public static SubscriptionTransactionList parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (SubscriptionTransactionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static SubscriptionTransactionList parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (SubscriptionTransactionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SubscriptionTransactionList parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (SubscriptionTransactionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static SubscriptionTransactionList parseFrom(InputStream inputStream) throws IOException {
        return (SubscriptionTransactionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SubscriptionTransactionList parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SubscriptionTransactionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SubscriptionTransactionList parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (SubscriptionTransactionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static SubscriptionTransactionList parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SubscriptionTransactionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
