package com.nintendo.npf.sdk.internal.bridge.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface ProfanityWordOrBuilder extends MessageLiteOrBuilder {
    ProfanityWord.ProfanityCheckStatus getCheckStatus();

    ProfanityWord.ProfanityDictionaryType getDictionaryType();

    String getLanguage();

    ByteString getLanguageBytes();

    String getText();

    ByteString getTextBytes();

    boolean hasCheckStatus();

    boolean hasDictionaryType();

    boolean hasLanguage();

    boolean hasText();
}
