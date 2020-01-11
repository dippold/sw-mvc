package org.softwareworkforce.web.mvc.abstracts;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.softwareworkforce.web.mvc.enums.CRUD;
import org.softwareworkforce.web.mvc.enums.MODEL;
import org.softwareworkforce.web.mvc.enums.MSGS;
import org.softwareworkforce.web.mvc.enums.MVC;
import org.softwareworkforce.web.mvc.enums.VIEWS;

/**
 *
 * @author Fabio.Dippold
 * @version 1.0.2 - 2020-1-11
 *
 */
public abstract class AbstractCmd {

    String execute(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String action = readParameter(req, MVC.ACTION.getName());
        String nextCmd;

        if (action.equals(CRUD.ADD.getName())) {
            nextCmd = __add(req, res);
        } else if (action.equals(CRUD.UPD.getName())) {
            nextCmd = __upd(req, res);
        } else if (action.equals(CRUD.DEL.getName())) {
            nextCmd = __del(req, res);
        } else if (action.equals(MODEL.ADD.getName())) {
            nextCmd = __addBuildModel(req, res);
        } else if (action.equals(MODEL.UPD.getName())) {
            nextCmd = __updBuildModel(req, res);
        } else if (action.equals(MODEL.DEL.getName())) {
            nextCmd = __delBuildModel(req, res);
        } else if (action.equals(MODEL.LST.getName())) {
            nextCmd = __lstBuildModel(req, res);
        } else if (action.equals(MODEL.VIEW.getName())) {
            nextCmd = __viewBuildModel(req, res);
        } else {
            nextCmd = "";
            __notFoundAction(req, res, action);            
        }

//        switch (action) {            
//            case "add":
//                nextCmd = __add(req, res);
//                break;
//            case "upd":
//                nextCmd = __upd(req, res);
//                break;
//            case "del":
//                nextCmd = __del(req, res);
//                break;
//            case "bm-add":
//                nextCmd = __add(req, res);
//                break;
//            case "bm-upd":
//                nextCmd = __upd(req, res);
//                break;
//            case "bm-del":
//                nextCmd = __del(req, res);
//                break;            
//            case "bm-lst":
//                nextCmd = __add(req, res);
//                break;
//            case "bm-view":
//                nextCmd = __upd(req, res);
//                break;
//            default:
//                nextCmd = "NotFoundActionCmd";
//                break;
//        }
        return nextCmd;
    }

    protected abstract String __add(HttpServletRequest req, HttpServletResponse res);

    protected abstract String __upd(HttpServletRequest req, HttpServletResponse res);

    protected abstract String __del(HttpServletRequest req, HttpServletResponse res);

    protected abstract String __addBuildModel(HttpServletRequest req, HttpServletResponse res);

    protected abstract String __updBuildModel(HttpServletRequest req, HttpServletResponse res);

    protected abstract String __delBuildModel(HttpServletRequest req, HttpServletResponse res);

    protected abstract String __viewBuildModel(HttpServletRequest req, HttpServletResponse res);

    protected abstract String __lstBuildModel(HttpServletRequest req, HttpServletResponse res);

    protected void __notFoundAction(HttpServletRequest req, HttpServletResponse res, String action) throws ServletException, IOException {
        killSession(req);
        req.setAttribute(MVC.MSG.getName(),MSGS.ACTION_NOT_FOUND + action);
        req.getRequestDispatcher(VIEWS.LOGIN.name()).forward(req, res);
    }

    public static String readParameter(HttpServletRequest req, String parameterName) {

        return readParameter(req, parameterName, "");
    }

    public static String readParameter(HttpServletRequest req, String parameterName, String defaultValue) {
        String value = req.getParameter(parameterName);
        if ((value == null) || (value.equals(""))) {
            value = defaultValue;
        }

        return value;
    }

    public static void killSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        session.invalidate();
    }

}
