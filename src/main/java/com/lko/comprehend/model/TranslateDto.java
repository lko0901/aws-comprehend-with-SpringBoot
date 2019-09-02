package com.lko.comprehend.model;

import com.lko.comprehend.model.constant.Language;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public interface TranslateDto {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class Request {
        private String message;
        private Language from;
        private Language to;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class Response {
        private String message;
        private String result;
        private Language from;
        private Language to;
    }


}
