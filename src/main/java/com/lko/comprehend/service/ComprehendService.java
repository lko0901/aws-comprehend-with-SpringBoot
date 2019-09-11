package com.lko.comprehend.service;

import com.amazonaws.services.comprehend.model.DetectSentimentResult;
import com.amazonaws.services.comprehend.model.SentimentScore;
import com.lko.comprehend.cloud.aws.AwsComprehendAdapter;
import com.lko.comprehend.cloud.aws.AwsTranslateAdapter;
import com.lko.comprehend.model.ComprehendDto;
import com.lko.comprehend.model.Sentiment;
import com.lko.comprehend.model.TranslateDto;
import com.lko.comprehend.model.constant.Language;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ComprehendService {
    private final AwsTranslateAdapter awsTranslateAdapter;
    private final AwsComprehendAdapter awsComprehendAdapter;

    public ComprehendService(AwsTranslateAdapter awsTranslateAdapter, AwsComprehendAdapter awsComprehendAdapter) {
        this.awsTranslateAdapter = awsTranslateAdapter;
        this.awsComprehendAdapter = awsComprehendAdapter;
    }

    public Map<String, Object> comprehend(Map<String, String> param) {
        Language to = Language.valueOf(param.get("to"));
        TranslateDto.Response result = translate(TranslateDto.Request.builder()
                .message(param.get("message"))
                .from(Language.valueOf(param.get("from")))
                .to(to)
                .build());

        String translated = result.getResult();
        DetectSentimentResult comprehendResult = awsComprehendAdapter.comprehend(translated, to);
        Map<String, Object> sentiment = SentimentConverter.sentimentResultToMap(comprehendResult);
        sentiment.put("translated", translated);

        Map<String, Object> rtn = new HashMap<>();
        rtn.put("param", param);
        rtn.put("result", sentiment);

        return rtn;
    }

    public Map<String, Object> translate(Map<String, String> param) {
        TranslateDto.Response result = translate(TranslateDto.Request.builder()
                .message(param.get("message"))
                .from(Language.valueOf(param.get("from")))
                .to(Language.valueOf(param.get("to")))
                .build());

        Map<String, Object> rtn = new HashMap<>();
        rtn.put("param", param);
        rtn.put("result", result.getResult());

        return rtn;
    }

    public TranslateDto.Response translate(TranslateDto.Request param) {
        return TranslateDto.Response.builder()
                .message(param.getMessage())
                .from(param.getFrom())
                .to(param.getTo())
                .result(awsTranslateAdapter.translateToEnglish(param.getMessage(), param.getFrom(), param.getTo()))
                .build();
    }

    public ComprehendDto.Response comprehend(ComprehendDto.Request param) {
        String translated = awsTranslateAdapter.translateToEnglish(param.getMessage(), param.getFrom(), param.getTo());

        DetectSentimentResult result = awsComprehendAdapter.comprehend(translated, param.getTo());
        Sentiment sentiment = SentimentConverter.sentiment(result);
        sentiment.setTranslated(translated);

        return ComprehendDto.Response.builder()
                .param(param)
                .result(sentiment)
                .build();
    }
}

class SentimentConverter {
    static Map<String, Object> sentimentResultToMap(DetectSentimentResult comprehendResult) {
        return sentiment(comprehendResult)
                .toMap();
    }

    static Sentiment sentiment(DetectSentimentResult comprehendResult) {
        return Sentiment.builder()
                .sentiment(comprehendResult.getSentiment())
                .score(sentimentScore(comprehendResult.getSentimentScore()))
                .build();
    }

    private static com.lko.comprehend.model.SentimentScore sentimentScore(SentimentScore score) {
        return com.lko.comprehend.model.SentimentScore.builder()
                .positive(score.getPositive())
                .negative(score.getNegative())
                .neutral(score.getNeutral())
                .mixed(score.getMixed())
                .build();
    }
}
