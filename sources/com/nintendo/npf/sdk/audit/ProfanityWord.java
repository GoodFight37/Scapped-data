package com.nintendo.npf.sdk.audit;

import com.google.android.gms.stats.CodePackage;
import com.nintendo.npf.sdk.internal.model.IProfanityWord;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001:\u0002!\"B-\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J5\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000e¨\u0006#"}, d2 = {"Lcom/nintendo/npf/sdk/audit/ProfanityWord;", "Lcom/nintendo/npf/sdk/internal/model/IProfanityWord;", "language", "", "text", "dictionaryType", "Lcom/nintendo/npf/sdk/audit/ProfanityWord$ProfanityDictionaryType;", "checkStatus", "Lcom/nintendo/npf/sdk/audit/ProfanityWord$ProfanityCheckStatus;", "(Ljava/lang/String;Ljava/lang/String;Lcom/nintendo/npf/sdk/audit/ProfanityWord$ProfanityDictionaryType;Lcom/nintendo/npf/sdk/audit/ProfanityWord$ProfanityCheckStatus;)V", "getCheckStatus", "()Lcom/nintendo/npf/sdk/audit/ProfanityWord$ProfanityCheckStatus;", "checkStatusString", "getCheckStatusString", "()Ljava/lang/String;", "getDictionaryType", "()Lcom/nintendo/npf/sdk/audit/ProfanityWord$ProfanityDictionaryType;", "dictionaryTypeString", "getDictionaryTypeString", "getLanguage", "getText", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ProfanityCheckStatus", "ProfanityDictionaryType", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ProfanityWord implements IProfanityWord {
    private final ProfanityCheckStatus checkStatus;
    private final String checkStatusString;
    private final ProfanityDictionaryType dictionaryType;
    private final String dictionaryTypeString;
    private final String language;
    private final String text;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/nintendo/npf/sdk/audit/ProfanityWord$ProfanityCheckStatus;", "", "", "int", "<init>", "(Ljava/lang/String;II)V", "a", "I", "getInt", "()I", "UNCHECKED", "INVALID", "VALID", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum ProfanityCheckStatus {
        UNCHECKED(-1),
        INVALID(0),
        VALID(1);


        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int int;

        ProfanityCheckStatus(int i) {
            this.int = i;
        }

        public final int getInt() {
            return this.int;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/nintendo/npf/sdk/audit/ProfanityWord$ProfanityDictionaryType;", "", "", "int", "<init>", "(Ljava/lang/String;II)V", "a", "I", "getInt", "()I", "NICKNAME", CodePackage.COMMON, "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum ProfanityDictionaryType {
        NICKNAME(0),
        COMMON(1);


        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int int;

        ProfanityDictionaryType(int i) {
            this.int = i;
        }

        public final int getInt() {
            return this.int;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProfanityWord(String str, String str2, ProfanityDictionaryType dictionaryType) {
        this(str, str2, dictionaryType, null, 8, null);
        Intrinsics.checkNotNullParameter(dictionaryType, "dictionaryType");
    }

    public static /* synthetic */ ProfanityWord copy$default(ProfanityWord profanityWord, String str, String str2, ProfanityDictionaryType profanityDictionaryType, ProfanityCheckStatus profanityCheckStatus, int i, Object obj) {
        if ((i & 1) != 0) {
            str = profanityWord.language;
        }
        if ((i & 2) != 0) {
            str2 = profanityWord.text;
        }
        if ((i & 4) != 0) {
            profanityDictionaryType = profanityWord.dictionaryType;
        }
        if ((i & 8) != 0) {
            profanityCheckStatus = profanityWord.checkStatus;
        }
        return profanityWord.copy(str, str2, profanityDictionaryType, profanityCheckStatus);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLanguage() {
        return this.language;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ProfanityDictionaryType getDictionaryType() {
        return this.dictionaryType;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final ProfanityCheckStatus getCheckStatus() {
        return this.checkStatus;
    }

    public final ProfanityWord copy(String language, String text, ProfanityDictionaryType dictionaryType, ProfanityCheckStatus checkStatus) {
        Intrinsics.checkNotNullParameter(dictionaryType, "dictionaryType");
        Intrinsics.checkNotNullParameter(checkStatus, "checkStatus");
        return new ProfanityWord(language, text, dictionaryType, checkStatus);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProfanityWord)) {
            return false;
        }
        ProfanityWord profanityWord = (ProfanityWord) other;
        return Intrinsics.areEqual(this.language, profanityWord.language) && Intrinsics.areEqual(this.text, profanityWord.text) && this.dictionaryType == profanityWord.dictionaryType && this.checkStatus == profanityWord.checkStatus;
    }

    public final ProfanityCheckStatus getCheckStatus() {
        return this.checkStatus;
    }

    @Override // com.nintendo.npf.sdk.internal.model.IProfanityWord
    public String getCheckStatusString() {
        return this.checkStatusString;
    }

    public final ProfanityDictionaryType getDictionaryType() {
        return this.dictionaryType;
    }

    @Override // com.nintendo.npf.sdk.internal.model.IProfanityWord
    public String getDictionaryTypeString() {
        return this.dictionaryTypeString;
    }

    @Override // com.nintendo.npf.sdk.internal.model.IProfanityWord
    public String getLanguage() {
        return this.language;
    }

    @Override // com.nintendo.npf.sdk.internal.model.IProfanityWord
    public String getText() {
        return this.text;
    }

    public int hashCode() {
        String str = this.language;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.text;
        return ((((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.dictionaryType.hashCode()) * 31) + this.checkStatus.hashCode();
    }

    public String toString() {
        return "ProfanityWord(language=" + this.language + ", text=" + this.text + ", dictionaryType=" + this.dictionaryType + ", checkStatus=" + this.checkStatus + ')';
    }

    public ProfanityWord(String str, String str2, ProfanityDictionaryType dictionaryType, ProfanityCheckStatus checkStatus) {
        Intrinsics.checkNotNullParameter(dictionaryType, "dictionaryType");
        Intrinsics.checkNotNullParameter(checkStatus, "checkStatus");
        this.language = str;
        this.text = str2;
        this.dictionaryType = dictionaryType;
        this.checkStatus = checkStatus;
        this.dictionaryTypeString = dictionaryType.name();
        this.checkStatusString = checkStatus.name();
    }

    public /* synthetic */ ProfanityWord(String str, String str2, ProfanityDictionaryType profanityDictionaryType, ProfanityCheckStatus profanityCheckStatus, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, profanityDictionaryType, (i & 8) != 0 ? ProfanityCheckStatus.UNCHECKED : profanityCheckStatus);
    }
}
