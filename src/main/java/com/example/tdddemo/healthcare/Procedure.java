package com.example.tdddemo.healthcare;

public class Procedure {
    private String id;
    private String name;

    public Procedure(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
