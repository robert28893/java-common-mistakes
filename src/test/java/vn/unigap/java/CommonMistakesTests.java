package vn.unigap.java;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class CommonMistakesTests {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    void redundantObjectCreation() {
        StopWatch sw = new StopWatch();
        sw.start();
        for (int i = 0; i < 100; i++) {
            System.out.println(new StringUtil().upperCase("Hello " + i));
        }
        sw.stop();
        System.out.println("Duration: " + sw.getTotalTimeMillis());
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

    @Test
    void ignoringExceptions() {
        FileInputStream input = null;
        try {
            input = new FileInputStream("file1.txt");
        } catch (IOException e) {
        }

    }

    @Test
    void hashCodeFunction() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("x"));

        System.out.println("Contains: " + carList.contains(new Car("x")));

        Set<Car> carSet = new HashSet<>();
        carSet.add(new Car("x"));

        System.out.println("Contains: " + carSet.contains(new Car("x")));
    }

    @Test
    void noConfig() {
        String s = restTemplate.getForObject("https://reqres.in/api/users?page=2", String.class);
        System.out.println(s);
    }
}
