package com.lko.awstest.model;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Builder
@ApiModel
@Getter
@Setter
public class Sentiment implements Serializable {
    private String translated;
    private String sentiment;
    private SentimentScore score;

    public Map<String, Object> toMap() {
        Map<String, Object> rtn = new HashMap<>();

        rtn.put("translated", this.translated);
        rtn.put("sentiment", this.sentiment);
        rtn.put("sentimentScore", this.score.toMap());

        return rtn;
    }
}
