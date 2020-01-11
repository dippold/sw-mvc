package org.builderforce.web.mvc.enums;

/**
 *
 * @author Fabio.Dippold
 * @version 1.0.1 - 2020-1-10
 * 
 */
public enum MVC {
    
    URL("mvc"), 
    CMD("cmd"), 
    ACTION("do"),
    ID("id"),
    PID("pid"), 
    PPID("ppid"),
    MSG("msg");
    
    private final String name;
    
    MVC(String name) {
        this.name = name;
    }  
    
    public String getName() {
        return name;
    }
    
}
