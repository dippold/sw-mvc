package org.builderforce.web.mvc.enums;

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
     
    
    private final String name;
    
    MODEL(String name) {
        this.name = name;
    }  
    
    public String getName() {
        return name;
    }    
}
