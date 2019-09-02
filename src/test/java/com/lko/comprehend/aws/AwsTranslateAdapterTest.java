package com.lko.comprehend.aws;

import com.lko.comprehend.ComprehendApiApplicationTests;
import com.lko.comprehend.model.constant.Language;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;


public class AwsTranslateAdapterTest extends ComprehendApiApplicationTests {

    @Autowired
    private AwsTranslateAdapter awsTranslateAdapter;

    @Test
    public void translateToEnglish() {
        String result = awsTranslateAdapter.translateToEnglish("안녕하세요", Language.KOREAN, Language.ENGLISH);

        assertThat(result).isNotEmpty();
    }
}