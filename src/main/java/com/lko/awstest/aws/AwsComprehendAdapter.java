package com.lko.awstest.aws;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.comprehend.AmazonComprehend;
import com.amazonaws.services.comprehend.AmazonComprehendClientBuilder;
import com.amazonaws.services.comprehend.model.DetectSentimentRequest;
import com.amazonaws.services.comprehend.model.DetectSentimentResult;
import com.amazonaws.services.comprehend.model.LanguageCode;
import com.lko.awstest.config.AwsConfig;
import com.lko.awstest.model.constant.Language;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class AwsComprehendAdapter {
    private AmazonComprehend client;
    private final AwsConfig config;

    public AwsComprehendAdapter(AwsConfig config) {
        this.config = config;
    }

    @PostConstruct
    public void init() {
        BasicAWSCredentials credentials = new BasicAWSCredentials(config.getCredentialsAccessKey(), config.getCredentialsSecretKey());
        client = AmazonComprehendClientBuilder.standard()
                .withRegion(Regions.fromName(config.getRegion()))
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();
    }

    public DetectSentimentResult comprehend(String engMessage, Language code) {
        DetectSentimentRequest request = new DetectSentimentRequest();
        request.withText(engMessage)
                .withLanguageCode(LanguageCode.fromValue(code.getLangCode()));
        return client.detectSentiment(request);
    }
}
