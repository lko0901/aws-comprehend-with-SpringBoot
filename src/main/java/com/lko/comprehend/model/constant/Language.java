package com.lko.comprehend.model.constant;

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