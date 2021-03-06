package org.softwareworkforce.web.mvc.enums;

import java.util.LinkedList;

/**
 *
 * @author Fabio.Dippold
 * @version 1.0.0 - 2020-1-11
 *
 */
public enum MSGS {
    
    CMD_NOT_FOUND("ERROR MVC LEVEL-1: Não encontrei o Cmd: "), 
    ACTION_NOT_FOUND("ERROR MVC LEVEL-2: Não encontrei a Action: "),     
    INVALID_PASSWD("Senha inválida ou bloqueada!"),
    PASSWD_REQUERED("Informe email e senha p/ autenticação!"),
    INVALID_SESSION("Sessão inválida. Autentique-se novamente."),
    INVALID_RULE("Usuário sem permissão p/ ");
    
    public static String[] getNames() {
        java.util.LinkedList<String> list = new LinkedList<>();
        for (MSGS o : MSGS.values()) {
            list.add(o.name());
        }

        return list.toArray(new String[list.size()]);
    }    
    
    private final String name;
    
    MSGS(String name) {
        this.name = name;
    }  
    
    public String getName() {
        return name;
    }    
}
