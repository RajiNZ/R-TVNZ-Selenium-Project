package org.example.day12;

public class Main {
    static String year = "2000";

    public int tests() {
        return 2222;
    }

    public static void main(String[] args) {

        // This is data driver [pameterization
        new TestParameterising().registration("bbb", "aaa", "rr@rrr.com", "2000", "Female", "11111111");
        new TestParameterising().registration("ccc", "ddd", "mm@rrr.com", "2001", "Male", "11111112");

    }
}
