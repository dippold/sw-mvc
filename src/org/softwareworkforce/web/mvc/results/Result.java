package org.softwareworkforce.web.mvc.results;

import java.util.ArrayList;
import org.softwareworkforce.web.mvc.interfaces.ICmd;

/**
 *
 * @author Fabio.Dippold
 * @version 1.0.0 - 2020-1-9
 * 
 */
public class Result {
    
    private boolean success;
    private Object data;
    
    private ICmd source; // Quem enviou?
    // Quem me invocou 
    private ArrayList<org.softwareworkforce.web.mvc.results.Parameters> inputs;
    
    private ICmd nextCmd; 
    private String nextView;
    
    private ArrayList<org.softwareworkforce.web.mvc.results.Parameters> outputs; // Quem receber, vai receber o que?
    
    private ArrayList<org.softwareworkforce.web.mvc.results.Error> errors;        
    
    private String msg;
    
}
