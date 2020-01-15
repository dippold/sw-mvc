package org.softwareworkforce.web.mvc.enums;

import java.util.LinkedList;

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
    MSG("msg"),
    CMD_PACKAGE("org.ftd.workforce.workhours.cmds"),
    URL_SECURITY_LOGOUT("SecurityLogout");
    
    public static String[] getNames() {
        java.util.LinkedList<String> list = new LinkedList<>();
        for (MVC o : MVC.values()) {
            list.add(o.name());
        }

        return list.toArray(new String[list.size()]);
    }    
    
    private final String name;
    
    MVC(String name) {
        this.name = name;
    }  
    
    public String getName() {
        return name;
    }
    
}
