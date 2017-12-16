package com.example.tdddemo.refactor;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertNotNull;

public class OnceYouBuyYouStartCryingTelephoneTest
{
    OnceYouBuyYouStartCryingTelephone telephone = new
            OnceYouBuyYouStartCryingTelephone();
    PersonName name = null;

    @Before
    public void setUp()
    {
        name = new PersonName();
    }
    @Test(expected = RuntimeException.class)
    public void when_input_first_name_is_null_then_throws_exception() throws Exception
    {
        telephone.addConnection(name, null, null);
        fail("code should not reach here");
    }

    @Test(expected = RuntimeException.class)
    public void when_input_lasst_name_is_null_then_throws_exception() throws Exception
    {
        name.setFirstName("John");
        telephone.addConnection(name, null, null);
        fail("code should not reach here");
    }

    @Test(expected = RuntimeException.class)
    public void when_input_z_is_null_then_throws_exception() throws Exception
    {
        name.setFirstName("John");
        name.setLastName("Doe");
        telephone.addConnection(name, null, null);
        fail("code should not reach here");
    }

    @Test(expected = RuntimeException.class)
    public void when_input_connection_type_is_null_then_throws_exception()
            throws Exception {
        name.setFirstName("John");
        name.setLastName("Doe");
        telephone.addConnection(name, new Date(), null);
        fail("code should not reach here");
    }

    @Test
    public void when_valid_input_then_adds_inputs() throws
            Exception {
        name.setFirstName("John");
        name.setLastName("Doe");
        assertNotNull(telephone.addConnection(name, new Date(), ConnectionType.THREE_G));
    }

    @Test
    public void when_all_name_attributes_are_passed_then_forms_the_name() throws Exception {
        String firstName = "john";
        String lastName = "smith";
        String middleName = "addison";
        String prefix = "dr.";

        name.setFirstName(firstName);
        name.setLastName(lastName);
        name.setMiddleName(middleName);
        name.setPrefix(prefix);

        String number = telephone.addConnection(name, new Date(), ConnectionType.TWO_G);

        assertNotNull(number);

        String billDetails = telephone.bill(number);
        assertTrue(billDetails.contains(firstName));
        assertTrue(billDetails.contains(lastName));
        assertTrue(billDetails.contains(middleName));
        assertTrue(billDetails.contains(prefix));

    }

}
