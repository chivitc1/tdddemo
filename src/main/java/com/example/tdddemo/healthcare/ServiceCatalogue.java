package com.example.tdddemo.healthcare;

import java.math.BigDecimal;

public class ServiceCatalogue {
    private Procedure proc;

    public void add(Procedure proc, BigDecimal ten) {
        this.proc = proc;
    }

    public Procedure find(String id) {
        return proc;
    }
}
