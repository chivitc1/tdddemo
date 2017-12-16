package com.example.tdddemo.healthcare;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ServiceCatalogue {
    private List<Procedure> procs = new ArrayList<>();

    public void add(Procedure proc, BigDecimal ten) {
        this.procs.add(proc);
    }

    public Procedure find(String id) {
        for (Procedure proc : procs) {
            if (proc.getId().equals(id)) {
                return proc;
            }
        }
        return null;
    }
}
