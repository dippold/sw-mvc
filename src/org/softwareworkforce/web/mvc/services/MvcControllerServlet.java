package org.softwareworkforce.web.mvc.services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.softwareworkforce.web.mvc.enums.MSGS;
import org.softwareworkforce.web.mvc.enums.MVC;
import org.softwareworkforce.web.mvc.enums.VIEWS;
import org.softwareworkforce.web.mvc.interfaces.ICmd;

/**
 *
 * @author Fabio Tavares Dippold
 * @version 1.0.3 - 10/1/2020
 * 
 */
@WebServlet(name = "CmdControllerServlet", urlPatterns = {"/mvc"})
public class MvcControllerServlet extends HttpServlet {

    private static final long serialVersionUID = 7275309812655180741L;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            request.setCharacterEncoding("UTF-8");
            request.setCharacterEncoding("UTF-8");  
            
            String cmd = this.readParameter(request, MVC.CMD.getName());

            try {

                Class theClass = Class.forName(MVC.CMD_PACKAGE.getName() + "." + cmd);
                ICmd theCmd = (ICmd) theClass.newInstance();
                String nextCmd = theCmd.execute(request, response);
                request.getRequestDispatcher(nextCmd).forward(request, response);
                
            } catch(ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                
                killSession(request);
                request.setAttribute(MVC.MSG.getName(), MSGS.CMD_NOT_FOUND.getName() + cmd);
                request.getRequestDispatcher(VIEWS.LOGIN.getName()).forward(request, response);
                
            }
        
    }

    private void killSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        session.invalidate();
    }
    
    private String readParameter(HttpServletRequest req, String parameterName) {
        
        return readParameter(req, parameterName, "");
    }
    
    private String readParameter(HttpServletRequest req, String parameterName, String defaultValue) {
        String value = req.getParameter(parameterName);
        if ((value == null) ||(value.equals(""))) {
            value = defaultValue;
        }
        
        return value;
    }    
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
