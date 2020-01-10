package org.builderforce.web.mvc.interfaces;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fabio.Dippold
 * @version 1.0.0 - 2019-12-05
 *
 */
public interface ICmd {

    String execute(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException;

}
