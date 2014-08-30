/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Beans.UploadFormBean;
import java.io.*;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionServlet;

/**
 *
 * @author diptimaya
 */
public class UploadAction extends org.apache.struts.action.Action {
     
    
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
            throws Exception 
    {
       
       UploadFormBean ufb=(UploadFormBean)form;
       String tacontent=ufb.getTextarea11();
       String filename=ufb.getTextinput11();
       System.out.println("!"+tacontent+","+filename);
       
       try{
           File ff=new File("a.txt");
           FileOutputStream fos=new FileOutputStream(ff);
           byte b[]=tacontent.getBytes();
           fos.write(b);
           fos.close();
           String filepath1="C:\\apache-tomcat-7.0.55\\webapps";
           File ff1=new File(filepath1, filename);
           System.out.println("Output file="+ff1);
           FileUtils.copyFile(ff, ff1);
           System.out.println("What happened???");
       }
       catch(Exception ee)
       {
           System.out.println("Sorry Error");
       }
        return mapping.findForward(SUCCESS);
    }
}
