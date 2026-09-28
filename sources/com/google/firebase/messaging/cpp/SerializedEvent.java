package com.google.firebase.messaging.cpp;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
public final class SerializedEvent extends Table {
    public static void ValidateVersion() {
        Constants.FLATBUFFERS_1_12_0();
    }

    public static SerializedEvent getRootAsSerializedEvent(ByteBuffer byteBuffer) {
        return getRootAsSerializedEvent(byteBuffer, new SerializedEvent());
    }

    public static SerializedEvent getRootAsSerializedEvent(ByteBuffer byteBuffer, SerializedEvent serializedEvent) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return serializedEvent.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public SerializedEvent __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public byte eventType() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return this.bb.get(i__offset + this.bb_pos);
        }
        return (byte) 0;
    }

    public Table event(Table table) {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __union(table, i__offset + this.bb_pos);
        }
        return null;
    }

    public static int createSerializedEvent(FlatBufferBuilder flatBufferBuilder, byte b, int i) {
        flatBufferBuilder.startTable(2);
        addEvent(flatBufferBuilder, i);
        addEventType(flatBufferBuilder, b);
        return endSerializedEvent(flatBufferBuilder);
    }

    public static void startSerializedEvent(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(2);
    }

    public static void addEventType(FlatBufferBuilder flatBufferBuilder, byte b) {
        flatBufferBuilder.addByte(0, b, 0);
    }

    public static void addEvent(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(1, i, 0);
    }

    public static int endSerializedEvent(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static void finishSerializedEventBuffer(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.finish(i);
    }

    public static void finishSizePrefixedSerializedEventBuffer(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.finishSizePrefixed(i);
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public SerializedEvent get(int i) {
            return get(new SerializedEvent(), i);
        }

        public SerializedEvent get(SerializedEvent serializedEvent, int i) {
            return serializedEvent.__assign(SerializedEvent.__indirect(__element(i), this.bb), this.bb);
        }
    }
}
