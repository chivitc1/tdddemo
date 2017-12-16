package com.example.tdddemo.healthcare;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ServiceCatalogueTest {
    @Test
    public void user_can_add_a_service_to_catalogue() {
        Procedure proc = new Procedure("1234", "Basic Oxygen Setup");
        ServiceCatalogue catalogue = new ServiceCatalogue();
        catalogue.add(proc, BigDecimal.TEN);

        assertNotNull(catalogue.find(proc.getId()));
        assertEquals(catalogue.find(proc.getId()), proc);
    }
}
