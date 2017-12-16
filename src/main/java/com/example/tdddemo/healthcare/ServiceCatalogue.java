package com.example.tdddemo.healthcare;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceCatalogue {
    private List<Procedure> procs = new ArrayList<>();
    private Map<String, BigDecimal> prices = new HashMap<>();

    public void add(Procedure proc, BigDecimal price) {
        this.procs.add(proc);
        this.prices.put(proc.getId(), price);
    }

    public Procedure find(String id) {
        for (Procedure proc : procs) {
            if (proc.getId().equals(id)) {
                return proc;
            }
        }
        return null;
    }

    public BigDecimal findPriceBy(String id) {
        if (prices.containsKey(id)) {
            return this.prices.get(id);
        }
        return null;
    }
}
