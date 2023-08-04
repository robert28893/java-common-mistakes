package vn.unigap.java;

public class StringUtil {

    public StringUtil() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String upperCase(String s) {
        return s.toUpperCase();
    }
}
