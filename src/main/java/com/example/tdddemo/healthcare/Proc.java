package com.example.tdddemo.healthcare;

import java.math.BigDecimal;

public class Proc {
    private Procedure proc;
    private BigDecimal price;

    public Proc(Procedure proc, BigDecimal price) {
        this.proc = proc;
        this.price = price;
    }

    public Procedure getProc() {
        return proc;
    }

    public void setProc(Procedure proc) {
        this.proc = proc;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
