package com.example.tdddemo.refactor;

import java.util.Random;

public class Number {
    public static String next() {
        return ""+ (9831501137L + new Random().nextLong());
    }
}
