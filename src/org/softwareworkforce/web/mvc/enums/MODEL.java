package org.softwareworkforce.web.mvc.enums;

import java.util.LinkedList;

/**
 *
 * @author Fabio.Dippold
 * @version 1.0.0 - 2020-1-11
 *
 */
public enum MODEL {
    
    LST("bm-lst"),
    ADD("bm-add"), 
    UPD("bm-upd"), 
    DEL("bm-del"),
    VIEW("bm-view");

    public static String[] getNames() {
        java.util.LinkedList<String> list = new LinkedList<>();
        for (MODEL o : MODEL.values()) {
            list.add(o.name());
        }

        return list.toArray(new String[list.size()]);
    }    
    
    private final String name;
    
    MODEL(String name) {
        this.name = name;
    }  
    
    public String getName() {
        return name;
    }    
}
