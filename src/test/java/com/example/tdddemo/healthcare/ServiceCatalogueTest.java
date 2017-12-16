package com.example.tdddemo.healthcare;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class ServiceCatalogueTest {

    @Test
    public void user_can_add_a_service_to_catalogue() {
        Procedure proc = new Procedure("1234", "Basic Oxygen Setup");
        ServiceCatalogue catalogue = new ServiceCatalogue();
        catalogue.add(proc, BigDecimal.TEN);

        assertNotNull(catalogue.find(proc.getId()));
        assertEquals(catalogue.find(proc.getId()), proc);
    }

    @Test
    public void catalogue_returns_null_for_an_uncofigure_procedure_id() throws Exception{
        Procedure proc = new Procedure("1234", "Basic Oxygen Setup");
        ServiceCatalogue catalogue = new ServiceCatalogue();
        catalogue.add(proc, BigDecimal.TEN);
        assertNull(catalogue.find("4567"));
    }

    @Test
    public void catalogue_returns_procedure_for_a_configured_procedure_id() {
        Procedure proc1 = new Procedure("1234", "Basic Oxygen Setup");
        Procedure proc2 = new Procedure("6789", "Basic Oxygen Setup");
        ServiceCatalogue catalogue = new ServiceCatalogue();
        catalogue.add(proc1, BigDecimal.TEN);
        catalogue.add(proc2, BigDecimal.TEN);
        assertNotNull("Expected a procedure 1234", catalogue.find("1234"));
        assertNotNull("Expected a procedure 6789", catalogue.find("6789"));
    }

    @Test
    public void catalogue_returns_procedure_and_price_for_a_configured_procedure() {
        Procedure proc1 = new Procedure("1234", "Basic Oxygen Setup");
        Procedure proc2 = new Procedure("6789", "Basic Oxygen Setup");
        ServiceCatalogue catalogue = new ServiceCatalogue();
        catalogue.add(proc1, BigDecimal.TEN);
        catalogue.add(proc2, BigDecimal.ONE);

        assertEquals(BigDecimal.TEN, catalogue.findPriceBy(proc1.getId()));
        assertEquals(BigDecimal.ONE, catalogue.findPriceBy(proc2.getId()));
    }
}
