package com.lko.awstest.model;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@ApiModel
@Builder
@Getter
@Setter
public class SentimentScore {
    private Float positive;
    private Float negative;
    private Float mixed;
    private Float neutral;

    Map<String, Float> toMap() {
        Map<String, Float> rtn = new HashMap<>();

        rtn.put("positive", this.positive);
        rtn.put("negative", this.negative);
        rtn.put("mixed", this.mixed);
        rtn.put("neutral", this.neutral);

        return rtn;
    }
}
