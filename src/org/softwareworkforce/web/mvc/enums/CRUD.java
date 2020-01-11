package org.softwareworkforce.web.mvc.enums;

import java.util.LinkedList;

/**
 *
 * @author Fabio.Dippold
 * @version 1.0.0 - 2020-1-11
 *
 */
public enum CRUD {
    
    ADD("add"), 
    UPD("upd"), 
    DEL("del"); 

    public static String[] getNames() {
        java.util.LinkedList<String> list = new LinkedList<>();
        for (CRUD o : CRUD.values()) {
            list.add(o.name());
        }

        return list.toArray(new String[list.size()]);
    }
    
    private final String name;
    
    CRUD(String name) {
        this.name = name;
    }  
    
    public String getName() {
        return name;
    }    
}
