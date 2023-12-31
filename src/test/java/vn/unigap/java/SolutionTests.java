package vn.unigap.java;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.FileInputStream;
import java.io.IOException;

@SpringBootTest
public class SolutionTests {

    @Value("${reqres.url}")
    private String reqresUrl;
    @Autowired
    private RestTemplate restTemplate;

    @Test
    void redundantObjectCreation() {
        StopWatch sw = new StopWatch();
        sw.start();
        StringUtil stringUtil = new StringUtil();
        for (int i = 0; i < 100; i++) {
            System.out.println(stringUtil.upperCase("Hello " + i));
        }
        sw.stop();
        System.out.println("Duration: " + sw.getTotalTimeMillis());
    }

    @Test
    void stringConcatenation() {
        StopWatch sw = new StopWatch();
        sw.start();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            sb.append(i);
        }
        sw.stop();
        System.out.println("length: " + sb.length());
        System.out.println("Duration: " + sw.getTotalTimeMillis());
    }

    @Test
    void forgettingReleaseResource() {
        FileInputStream input = null;
        try {
            input = new FileInputStream("file.txt");
            int data = input.read();
            while (data != -1) {
                System.out.print((char) data);
                data = input.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void missingBreakInSwitchCase() {
        int caseIndex = 0;
        switch (caseIndex) {
            case 0:
                System.out.println("Zero");
                break;
            case 1:
                System.out.println("One");
                break;
            case 2:
                System.out.println("Two");
                break;
            default:
                System.out.println("Default");
        }
    }

    @Test
    void noConfig() {
        String uri = UriComponentsBuilder.fromUriString(reqresUrl)
                .path("/api/users")
                .queryParam("page", 2)
                .toUriString();
        String s = restTemplate.getForObject(uri, String.class);
        System.out.println(s);
    }
}
