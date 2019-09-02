package com.lko.comprehend.aws;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.translate.AmazonTranslate;
import com.amazonaws.services.translate.AmazonTranslateClientBuilder;
import com.amazonaws.services.translate.model.TranslateTextRequest;
import com.amazonaws.services.translate.model.TranslateTextResult;
import com.lko.comprehend.config.AwsConfig;
import com.lko.comprehend.model.constant.Language;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class AwsTranslateAdapter {
    private AmazonTranslate client;
    private final AwsConfig config;

    public AwsTranslateAdapter(AwsConfig config) {
        this.config = config;
    }

    @PostConstruct
    public void init() {
        BasicAWSCredentials credentials = new BasicAWSCredentials(config.getCredentialsAccessKey(), config.getCredentialsSecretKey());

        client = AmazonTranslateClientBuilder
                .standard()
                .withRegion(Regions.fromName(config.getRegion()))
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();
    }

    public String translateToEnglish(String korMessage, Language from, Language to) {
        TranslateTextRequest request = new TranslateTextRequest()
                .withText(korMessage)
                .withSourceLanguageCode(from.getLangCode())
                .withTargetLanguageCode(to.getLangCode());

        TranslateTextResult result = client.translateText(request);

        return result.getTranslatedText();
    }
}
