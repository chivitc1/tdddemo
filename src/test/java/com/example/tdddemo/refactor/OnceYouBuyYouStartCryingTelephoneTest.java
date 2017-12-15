package com.example.tdddemo.refactor;

import org.junit.Test;

import java.util.Date;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertNotNull;

public class OnceYouBuyYouStartCryingTelephoneTest {
    OnceYouBuyYouStartCryingTelephone telephone = new
            OnceYouBuyYouStartCryingTelephone();

    @Test(expected = RuntimeException.class)
    public void when_input_first_name_isnull_then_throws_exception() {
        telephone.addConnection("1", null, null, null, null, 0);
        fail("Code should not reach here");
    }

    @Test(expected=RuntimeException.class)
    public void when_input_prefix_is_null_then_throws_exception()
            throws Exception {
        telephone.addConnection("a", null, null, null, null, 0);
        fail("code should not reach here");
    }

    @Test(expected=RuntimeException.class)
    public void when_input_last_name_is_null_then_throws_exception()
            throws Exception {
        telephone.addConnection("a", null, null, "c", null, 0);
        fail("code should not reach here");
    }

    @Test(expected = RuntimeException.class)
    public void when_input_gen_is_invalid_then_throws_exception()
            throws Exception {
        telephone.addConnection("a", null, null, "c", new Date(), 0);
        fail("code should not reach here");
    }

    @Test
    public void when_valid_input_then_adds_inputs() throws
            Exception {
        assertNotNull(telephone.addConnection("a", null, null, "c", new
                Date(), OnceYouBuyYouStartCryingTelephone.THREE_G));
    }

//    @Test
//    public void when_all_name_attributes_are_passed_then_forms_the_name()
//            throws Exception {
//        String johnsFirstName = "john";
//        String johnsLastName = "smith";
//        String johnsMiddleName = "maddison";
//        String johnsNamePrefix = "dr.";
//        String number = telephone.add(johnsFirstName,
//                johnsNamePrefix,johnsMiddleName,
//                johnsLastName, new Date(),
//                OnceYouBuyYouStartCryingTelephone.FOUR_G);
//        assertNotNull(number);
//        String billDetails = telephone.bill(number);
//        assertTrue(billDetails.contains(johnsNamePrefix));
//        assertTrue(billDetails.contains(johnsLastName));
//        assertTrue(billDetails.contains(johnsMiddleName));
//        assertTrue(billDetails.contains(johnsFirstName));
//    }
}
