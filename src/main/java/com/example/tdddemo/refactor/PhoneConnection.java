package com.example.tdddemo.refactor;

public interface PhoneConnection {
    boolean activate(String connectionForUserName, String number);
    String generateBillFor(String number);
}
