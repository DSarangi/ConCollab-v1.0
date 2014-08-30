/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Beans.Editor1Bean;
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
public class Editor1Action extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";

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
        
        Editor1Bean eb11=(Editor1Bean)request.getSession().getAttribute("eb1");
        String p=eb11.getProjectname();
        Editor1Bean e1b=(Editor1Bean)form;
        int m=e1b.getModnoview();
        int c=e1b.getCodenoview();
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
        System.out.println("TEXT IS:"+text);
        request.getSession().setAttribute("e1b",e1b);
        e1b.setCode1(text);
        System.out.println(e1b.getCode1());
        return mapping.findForward("loadcode1");
    }
}
