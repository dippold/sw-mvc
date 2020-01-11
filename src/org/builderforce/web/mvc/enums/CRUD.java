package org.builderforce.web.mvc.enums;

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
    
    private final String name;
    
    CRUD(String name) {
        this.name = name;
    }  
    
    public String getName() {
        return name;
    }    
}
