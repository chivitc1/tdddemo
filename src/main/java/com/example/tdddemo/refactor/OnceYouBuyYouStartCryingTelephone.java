package com.example.tdddemo.refactor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class OnceYouBuyYouStartCryingTelephone
{

    private static final String SPACE = " ";
    private Map<String, ConnectionType> connectionTypeForNumberMap = new HashMap<String, ConnectionType>();
    private Map<String, Date> cd = new HashMap<String, Date>();

    private Map<ConnectionType, PhoneConnection> connectionForATypeMap
            = new HashMap<ConnectionType, PhoneConnection>();

    public OnceYouBuyYouStartCryingTelephone()
    {
        initialize();
    }

    protected void initialize()
    {
        connectionForATypeMap.put(ConnectionType.TWO_G, new TwoGConnection());
        connectionForATypeMap.put(ConnectionType.THREE_G, new ThreeGConnection());
    }

    /**

     * @param name
     * @param z
     * @param connectionType
     * @return
     **/
    public String addConnection(PersonName name, Date z, ConnectionType connectionType) {
        if (name.getFirstName() == null || name.getLastName() == null || z == null)
            throw new RuntimeException();
        String personName = buildPersonName(name);

        String number = Number.next();
        connectionTypeForNumberMap.put(number, connectionType);
        cd.put(number, z);

        PhoneConnection phoneConnection = connectionForATypeMap.get(connectionType);

        if (connectionType == null) {
            throw new IllegalStateException();
        }
        phoneConnection.activate(personName, number);

        return number;
    }

    protected String buildPersonName(PersonName personName) {
        StringBuffer sb = new StringBuffer();
        if (personName.getPrefix() != null) {
            sb.append(personName.getPrefix()).append(SPACE);
        }
        if (personName.getFirstName() != null) {
            sb.append(personName.getFirstName()).append(SPACE);
        }
        if (personName.getMiddleName() != null) {
            sb.append(personName.getMiddleName()).append(SPACE);
        }
        if (personName.getLastName() != null) {
            sb.append(personName.getLastName());
        }

        return sb.toString();
    }

    /**
     * This method takes number as input and generates post paid bills
     * @param number
     * @return
     **/
    public String bill(String number) {
        ConnectionType connectionType = connectionTypeForNumberMap.get(number);
        if (connectionType == null) {
            throw new RuntimeException();
        }

        PhoneConnection phoneConnection = connectionForATypeMap.get(connectionType);
        return phoneConnection.generateBillFor(number);
    }

    public void chargeIncomingSms(String num) {
        //code....
        //....
    }
}
