package com.lko.comprehend;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-local.yml")
public class ComprehendApiApplicationTests {
  public ComprehendApiApplicationTests() {
    contextLoads();
  }

  @Test
  public void contextLoads() {
    System.out.println("test Hello");
  }

}
