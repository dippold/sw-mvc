package org.builderforce.web.mvc.services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.builderforce.web.mvc.enums.MvcEnum;
import org.builderforce.web.mvc.interfaces.ICmd;

/**
 *
 * @author Fabio Tavares Dippold
 * @version 3.0.3 - 17/10/2016
 * 
 */
@WebServlet(name = "CmdControllerServlet", urlPatterns = {"/mvc"}, initParams = {
    @WebInitParam(name = "cmdPackage", value = "org.builderforce.tasks.web.cmds"),
    @WebInitParam(name = "loginView", value = "login.jsp")
})
public class MvcControllerServlet extends HttpServlet {

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
            
            try {
                
                String cmd = this.readParameter(request, MvcEnum.cmd.toString());
                
                Class theClass = Class.forName(getInitParameter("cmdPackage") + "." + cmd);
                
                ICmd theCmd = (ICmd) theClass.newInstance();
                
                String nextCmd = theCmd.execute(request, response);
                
                request.getRequestDispatcher(nextCmd).forward(request, response);
                
            } catch(ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                
                killSession(request);

                request.setAttribute("msg", 
                        "ERROR MVC LEVEL-1: Não encontrei o Cmd: " 
                                + this.readParameter(
                                        request, 
                                        MvcEnum.cmd.toString(), 
                                        "Não submetido ao controlador!")
                );
                
                request.getRequestDispatcher(getInitParameter("loginView")).forward(request, response);
                
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
