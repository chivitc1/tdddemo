package com.example.tdddemo.bazarretail;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.verification.Times;

import java.util.ArrayList;

import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BiggestBazarRetailTest {
    @Mock
    PublicAddressSystem pas;
    @Mock
    Inventory inventory;

    BiggestBazarRetail bazar;
    ArrayList<Item> expiredList = new ArrayList<Item>();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        bazar = new BiggestBazarRetail(inventory, pas);
    }

    @Test
    public void issues_discount() throws Exception {
        // Create expected item list
        Item soap = new Item("123", "Luxury Soap", 100.00, 50.00);
        expiredList.add(soap);

        // Stubbing database call for getItemsExpireInAMonth
        when(inventory.getItemsExpireInAMonth()).thenReturn(expiredList);
        //Stubbing update count
        when(inventory.itemsUpdated()).thenReturn(1);

        // Test
        bazar.issueDiscountForItemsExpireIn30Days(0.30);

        //Verify that inventory update and publci announcement were invoked
        verify(inventory).update(soap, 70.00);
        verify(pas).announce(isA(Offer.class));
    }

    @Test
    public void when_no_item_qualifies_then_does_not_issue_discount() throws Exception {
        //create expected item list
        Item soap = new Item("123", "Luxury Soap", 100.00, 90.00);
        expiredList.add(soap);

        // Stubbing database call for getItemsExpireInAMonth
        when(inventory.getItemsExpireInAMonth()).thenReturn(expiredList);

        // Stubbing update count
        when(inventory.itemsUpdated()).thenReturn(1);

        // Test the method
        bazar.issueDiscountForItemsExpireIn30Days(0.30);

        // Verify
        verify(inventory, new Times(0)).update(isA(Item.class), anyDouble());
        verify(pas, new Times(0)).announce(isA(Offer.class));
    }

    @Test(expected = RuntimeException.class)
    public void announce_method_throws_exception() throws Exception {
        // Stubbing method will throw exception
        doThrow(new RuntimeException()).when(pas).announce(isA(Offer.class));

        // Execute
        pas.announce(new Offer(null, 0));

        //Verify
        fail("Code should not reach here");
    }
}
