package com.lko.comprehend.cloud.aws;

import com.amazonaws.services.comprehend.model.DetectKeyPhrasesResult;
import com.amazonaws.services.comprehend.model.DetectSentimentResult;
import com.lko.comprehend.ComprehendApiApplicationTests;
import com.lko.comprehend.model.constant.Language;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;


public class AwsComprehendAdapterTest extends ComprehendApiApplicationTests {

  @Autowired
  private AwsComprehendAdapter awsComprehendAdapter;

  @Test
  public void comprehend() {
    String message = "But humanity’s greatest advances are not in its discoveries but in how those discoveries are applied to reduce inequity";
    Language eng = Language.ENGLISH;

    DetectSentimentResult result = awsComprehendAdapter.comprehend(message, eng);

    assertThat(result).isNotNull();
    assertThat(result.getSentiment()).isNotEmpty();
  }

  @Test
  public void keyPhrase() {
    String message = "But humanity’s greatest advances are not in its discoveries but in how those discoveries are applied to reduce inequity";
    Language eng = Language.ENGLISH;

    DetectKeyPhrasesResult result = awsComprehendAdapter.keyPhrase(message, eng);
    assertThat(result).isNotNull();
    assertThat(result.getKeyPhrases().size()).isGreaterThan(0);
  }
}