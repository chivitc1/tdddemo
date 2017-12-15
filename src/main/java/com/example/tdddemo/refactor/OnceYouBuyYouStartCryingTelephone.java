package com.example.tdddemo.refactor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class OnceYouBuyYouStartCryingTelephone {

    private Map<String, String> names = new HashMap<String, String>();

    //private Map<String, Integer> types = new HashMap<String, Integer>();
    private Map<String, Date> cd = new HashMap<String, Date>();

    private Map<ConnectionType, PhoneConnection> connectionForATypeMap
            = new HashMap<ConnectionType, PhoneConnection>();

    public OnceYouBuyYouStartCryingTelephone(){
        initialize();
    }

    protected void initialize() {
        connectionForATypeMap.put(ConnectionType.TWO_G,
                new TwoGConnection());
        connectionForATypeMap.put(ConnectionType.THREE_G,
                new ThreeGConnection());
    }

    /**
     This method activates a connection for a customer and stores different
     information in following maps for future use names, types and cd. if
     the connection type is 2G then requests TRY for a valid 2G number.
     if portability is not an issue then TRY provides a valid number, that
     number is stored for the customer. Then we activate the connection.
     For 3G - user needs data plan , we don't ask TRY for 3G...we don't
     have permission for 3G data in many cities, so we will hack TRY
     database and assign an id. If TRY catches us then we will disconnect
     the data plan and deactivate the customer.

     Is there any legal consumer forum issue?
     For 4G- we don't have 4th generation spectrum. we will provide 3G
     with a wrapper of 4G
     * @param firstName
     * @param prefix
     * @param middleName
     * @param lastName
     * @param z
     * @param gen
     * @return
     **/
    public String addConnection(String firstName, String prefix, String middleName,
                                String lastName, Date z, ConnectionType gen) {
        if (firstName == null || lastName == null || z == null)
            throw new RuntimeException();
        String personName = "";
        if (prefix != null) {
            personName = personName + " " + prefix;
            if (firstName != null)
                personName = personName + " " + firstName;
            if (middleName != null)
                personName = personName + " " + middleName;
            if (lastName != null)
                personName = personName + lastName;
        } else {
            if (firstName != null)
                personName = personName + " " + firstName;
            if (middleName != null)
                personName = personName + " " + middleName;
            if (lastName != null)
                personName = personName + lastName;
        }
        String number = Number.next();
        connectionForATypeMap.put(number, connectionType);
        cd.put(number, z);
        if (gen == ConnectionType.TWO_G) {
            activate2GCon(number);
            connectionForATypeMap.put(ConnectionType.TWO_G, );
        } else if (gen == ConnectionType.THREE_G) {
            activate3GCon(number);
            types.put(number, THREE_G);
        } else if (gen == ConnectionType.FOUR_G) {
            activate4GCon(number);
            types.put(number, FOUR_G);
        } else {
            throw new IllegalStateException();
        }
        return number;
    }

    private void activate2GCon(String n) {

    }
    private void activate3GCon(String n) {

    }
    private void activate4GCon(String n) {

    }

    /**
     * This method takes number as input and generates post paid bills
     * @param n
     * @return
     **/
    public String bill(String n) {
        Integer gen = types.get(n);
        if (gen == null) {
            throw new RuntimeException();
        }
        switch (gen.intValue()) {
            case TWO_G:
                return gen2GBill(n);
            case THREE_G:
                return gen3GBill(n);
            case FOUR_G:
                return gen4GBill(n);
            default:
                break;
        }
        return "";
    }

    private String gen4GBill(String n) {
        return "";
    }

    private String gen3GBill(String n) {
        return "";
    }

    private String gen2GBill(String n) {
        return "";
    }

    public void chargeIncomingSms(String num) {
        //code....
        //....
    }
}
