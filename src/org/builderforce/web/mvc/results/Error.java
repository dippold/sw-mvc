package org.builderforce.web.mvc.results;

/**
 *
 * @author Fabio.Dippold
 * @version 1.0.0 - 2020-1-9
 * 
 */
public class Error {
    private String code;
    private String description;

    public Error(String code, String description) {
        this.code = code;
        this.description = description;
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
