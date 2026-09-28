package com.google.firebase.messaging.cpp;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
public final class SerializedTokenReceived extends Table {
    public static void ValidateVersion() {
        Constants.FLATBUFFERS_1_12_0();
    }

    public static SerializedTokenReceived getRootAsSerializedTokenReceived(ByteBuffer byteBuffer) {
        return getRootAsSerializedTokenReceived(byteBuffer, new SerializedTokenReceived());
    }

    public static SerializedTokenReceived getRootAsSerializedTokenReceived(ByteBuffer byteBuffer, SerializedTokenReceived serializedTokenReceived) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return serializedTokenReceived.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public SerializedTokenReceived __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public String token() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer tokenAsByteBuffer() {
        return __vector_as_bytebuffer(4, 1);
    }

    public ByteBuffer tokenInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 4, 1);
    }

    public static int createSerializedTokenReceived(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startTable(1);
        addToken(flatBufferBuilder, i);
        return endSerializedTokenReceived(flatBufferBuilder);
    }

    public static void startSerializedTokenReceived(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(1);
    }

    public static void addToken(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(0, i, 0);
    }

    public static int endSerializedTokenReceived(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public SerializedTokenReceived get(int i) {
            return get(new SerializedTokenReceived(), i);
        }

        public SerializedTokenReceived get(SerializedTokenReceived serializedTokenReceived, int i) {
            return serializedTokenReceived.__assign(SerializedTokenReceived.__indirect(__element(i), this.bb), this.bb);
        }
    }
}
