package com.example.tdddemo.refactor;

import java.util.HashMap;
import java.util.Map;

public class ThreeGConnection implements PhoneConnection
{
    private Map<String, String> numberAndNameMap = new HashMap<String, String>();
    @Override
    public boolean activate(String connectionForUserName, String number)
    {
        System.out.println("activating 3G for user="+connectionForUserName+"and number=" +number);
        numberAndNameMap.put(number, connectionForUserName);
        return true;
    }

    @Override
    public String generateBillFor(String number)
    {
        return "3G bill for "+numberAndNameMap.get(number);
    }
}
