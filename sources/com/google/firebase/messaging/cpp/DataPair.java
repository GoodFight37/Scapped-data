package com.google.firebase.messaging.cpp;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
public final class DataPair extends Table {
    public static void ValidateVersion() {
        Constants.FLATBUFFERS_1_12_0();
    }

    public static DataPair getRootAsDataPair(ByteBuffer byteBuffer) {
        return getRootAsDataPair(byteBuffer, new DataPair());
    }

    public static DataPair getRootAsDataPair(ByteBuffer byteBuffer, DataPair dataPair) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return dataPair.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public DataPair __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public String key() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer keyAsByteBuffer() {
        return __vector_as_bytebuffer(4, 1);
    }

    public ByteBuffer keyInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 4, 1);
    }

    public String value() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer valueAsByteBuffer() {
        return __vector_as_bytebuffer(6, 1);
    }

    public ByteBuffer valueInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 6, 1);
    }

    public static int createDataPair(FlatBufferBuilder flatBufferBuilder, int i, int i2) {
        flatBufferBuilder.startTable(2);
        addValue(flatBufferBuilder, i2);
        addKey(flatBufferBuilder, i);
        return endDataPair(flatBufferBuilder);
    }

    public static void startDataPair(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(2);
    }

    public static void addKey(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(0, i, 0);
    }

    public static void addValue(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(1, i, 0);
    }

    public static int endDataPair(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public DataPair get(int i) {
            return get(new DataPair(), i);
        }

        public DataPair get(DataPair dataPair, int i) {
            return dataPair.__assign(DataPair.__indirect(__element(i), this.bb), this.bb);
        }
    }
}
