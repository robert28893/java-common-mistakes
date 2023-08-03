package vn.unigap.java;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import java.io.FileInputStream;
import java.io.IOException;

@SpringBootTest
class JavaCommonMistakesApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void inefficientStringConcatenation() {
        StopWatch sw = new StopWatch();
        sw.start();
        String s = "";
        for (int i = 0; i < 100000; i++) {
            s += i;
        }
        sw.stop();
        System.out.println("length: " + s.length());
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
    void missingBreakInSwitchCase() {
        int caseIndex = 0;
        switch (caseIndex) {
            case 0:
                System.out.println("Zero");
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
    void confusingEqual() {
        String s1 = new String("hello");
        String s2 = new String("hello");

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
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
}
