package com.lko.awstest.model.constant;

import lombok.Getter;

@Getter
public enum Language {
    ENGLISH("en"),
    KOREAN("ko");

    private String langCode;

    Language(String langCode) {
        this.langCode = langCode;
    }
}