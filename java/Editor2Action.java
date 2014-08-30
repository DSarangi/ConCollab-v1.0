/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Beans.Editor1Bean;
import Beans.Editor2Bean;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author diptimaya
 */
public class Editor2Action extends org.apache.struts.action.Action {

    /* forward name="success" path="" */

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Editor2Bean eb22=(Editor2Bean)request.getSession().getAttribute("eb2");
        String p=eb22.getProjectname();
        Editor2Bean e2b=(Editor2Bean)form;
        int m=e2b.getModnoview();
        int c=e2b.getCodenoview();
        String filename=p+m+"."+c+".txt";
        URL urldemo=new URL("file:///C:/apache-tomcat-7.0.55/webapps/"+filename);
        URLConnection yc=urldemo.openConnection();
        BufferedReader reader=new BufferedReader(new InputStreamReader(yc.getInputStream()));
        String line;
        StringBuilder stringBuilder=new StringBuilder();
        while((line=reader.readLine())!=null)
        {
           stringBuilder.append(line);
           
        }
        String text=stringBuilder.toString();
        System.out.println(text);
        request.getSession().setAttribute("e2b",e2b);
        e2b.setCode2(text);
        System.out.println(e2b.getCode2());
        return mapping.findForward("loadcode2");
    }
}
