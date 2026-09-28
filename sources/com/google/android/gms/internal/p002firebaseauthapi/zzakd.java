package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public enum zzakd {
    DOUBLE(0, zzakf.SCALAR, zzako.DOUBLE),
    FLOAT(1, zzakf.SCALAR, zzako.FLOAT),
    INT64(2, zzakf.SCALAR, zzako.LONG),
    UINT64(3, zzakf.SCALAR, zzako.LONG),
    INT32(4, zzakf.SCALAR, zzako.INT),
    FIXED64(5, zzakf.SCALAR, zzako.LONG),
    FIXED32(6, zzakf.SCALAR, zzako.INT),
    BOOL(7, zzakf.SCALAR, zzako.BOOLEAN),
    STRING(8, zzakf.SCALAR, zzako.STRING),
    MESSAGE(9, zzakf.SCALAR, zzako.MESSAGE),
    BYTES(10, zzakf.SCALAR, zzako.BYTE_STRING),
    UINT32(11, zzakf.SCALAR, zzako.INT),
    ENUM(12, zzakf.SCALAR, zzako.ENUM),
    SFIXED32(13, zzakf.SCALAR, zzako.INT),
    SFIXED64(14, zzakf.SCALAR, zzako.LONG),
    SINT32(15, zzakf.SCALAR, zzako.INT),
    SINT64(16, zzakf.SCALAR, zzako.LONG),
    GROUP(17, zzakf.SCALAR, zzako.MESSAGE),
    DOUBLE_LIST(18, zzakf.VECTOR, zzako.DOUBLE),
    FLOAT_LIST(19, zzakf.VECTOR, zzako.FLOAT),
    INT64_LIST(20, zzakf.VECTOR, zzako.LONG),
    UINT64_LIST(21, zzakf.VECTOR, zzako.LONG),
    INT32_LIST(22, zzakf.VECTOR, zzako.INT),
    FIXED64_LIST(23, zzakf.VECTOR, zzako.LONG),
    FIXED32_LIST(24, zzakf.VECTOR, zzako.INT),
    BOOL_LIST(25, zzakf.VECTOR, zzako.BOOLEAN),
    STRING_LIST(26, zzakf.VECTOR, zzako.STRING),
    MESSAGE_LIST(27, zzakf.VECTOR, zzako.MESSAGE),
    BYTES_LIST(28, zzakf.VECTOR, zzako.BYTE_STRING),
    UINT32_LIST(29, zzakf.VECTOR, zzako.INT),
    ENUM_LIST(30, zzakf.VECTOR, zzako.ENUM),
    SFIXED32_LIST(31, zzakf.VECTOR, zzako.INT),
    SFIXED64_LIST(32, zzakf.VECTOR, zzako.LONG),
    SINT32_LIST(33, zzakf.VECTOR, zzako.INT),
    SINT64_LIST(34, zzakf.VECTOR, zzako.LONG),
    DOUBLE_LIST_PACKED(35, zzakf.PACKED_VECTOR, zzako.DOUBLE),
    FLOAT_LIST_PACKED(36, zzakf.PACKED_VECTOR, zzako.FLOAT),
    INT64_LIST_PACKED(37, zzakf.PACKED_VECTOR, zzako.LONG),
    UINT64_LIST_PACKED(38, zzakf.PACKED_VECTOR, zzako.LONG),
    INT32_LIST_PACKED(39, zzakf.PACKED_VECTOR, zzako.INT),
    FIXED64_LIST_PACKED(40, zzakf.PACKED_VECTOR, zzako.LONG),
    FIXED32_LIST_PACKED(41, zzakf.PACKED_VECTOR, zzako.INT),
    BOOL_LIST_PACKED(42, zzakf.PACKED_VECTOR, zzako.BOOLEAN),
    UINT32_LIST_PACKED(43, zzakf.PACKED_VECTOR, zzako.INT),
    ENUM_LIST_PACKED(44, zzakf.PACKED_VECTOR, zzako.ENUM),
    SFIXED32_LIST_PACKED(45, zzakf.PACKED_VECTOR, zzako.INT),
    SFIXED64_LIST_PACKED(46, zzakf.PACKED_VECTOR, zzako.LONG),
    SINT32_LIST_PACKED(47, zzakf.PACKED_VECTOR, zzako.INT),
    SINT64_LIST_PACKED(48, zzakf.PACKED_VECTOR, zzako.LONG),
    GROUP_LIST(49, zzakf.VECTOR, zzako.MESSAGE),
    MAP(50, zzakf.MAP, zzako.VOID);

    private static final zzakd[] zzaz;
    private final int zzbb;

    public final int zza() {
        return this.zzbb;
    }

    static {
        zzakd[] zzakdVarArrValues = values();
        zzaz = new zzakd[zzakdVarArrValues.length];
        for (zzakd zzakdVar : zzakdVarArrValues) {
            zzaz[zzakdVar.zzbb] = zzakdVar;
        }
    }

    zzakd(int i, zzakf zzakfVar, zzako zzakoVar) {
        this.zzbb = i;
        int iOrdinal = zzakfVar.ordinal();
        if (iOrdinal == 1 || iOrdinal == 3) {
            zzakoVar.zza();
        }
        if (zzakfVar == zzakf.SCALAR) {
            int i2 = zzakc.zza[zzakoVar.ordinal()];
        }
    }
}
