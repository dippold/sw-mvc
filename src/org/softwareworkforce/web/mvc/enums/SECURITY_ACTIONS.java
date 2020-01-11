
package org.softwareworkforce.web.mvc.enums;

import java.util.LinkedList;

/**
 *
 * @author Fabio.Dippold
 * @version 1.0.0 - 2020-1-11
 * 
 */
public enum SECURITY_ACTIONS {
    
    REQUEST_ACCESS(""), 
    LOGIN(""), 
    LOGOUT(""), 
    LOCK_USER(""), 
    ADD_PERMISSION(""), 
    DEL_PERMISSION("");
        
    public static String[] getNames() {
        java.util.LinkedList<String> list = new LinkedList<>();
        for (SECURITY_ACTIONS o : SECURITY_ACTIONS.values()) {
            list.add(o.getDescription());
        }

        return list.toArray(new String[list.size()]);
    }    
    
    
    private final String description;
    
    SECURITY_ACTIONS(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    
    
}
