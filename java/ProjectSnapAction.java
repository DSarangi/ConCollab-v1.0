/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Beans.ProjectSnapBean;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import java.sql.*;

/**
 *
 * @author diptimaya
 */
public class ProjectSnapAction extends org.apache.struts.action.Action {

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
        
        ProjectSnapBean psb22=(ProjectSnapBean)form;
        String projectname=psb22.getProjname1();
        System.out.println(projectname);
        int nomodules=0;
        ArrayList arr=new ArrayList();
        
        try{
        
        Class.forName("oracle.jdbc.driver.OracleDriver");
	System.out.println("Driver loaded successfully");
        Connection cn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","pass");
        System.out.println("connection successfull");
   
             PreparedStatement ps2=cn.prepareStatement("select * from CONCOLLABMODULES where projectname=?");
             ps2.setString(1,projectname);
             ResultSet rs2=ps2.executeQuery();
             while(rs2.next())
             {  
                int c=0;
                nomodules++;
                
                 if(rs2.getString(3)!=null)
                  c=c+1;
                  
                 
                 if(rs2.getString(4)!=null)
                  c=c+1;
                 
                 if(rs2.getString(5)!=null)
                  c=c+1;
                 
                 if(rs2.getString(6)!=null)
                  c=c+1;
                 
                 if(rs2.getString(7)!=null)
                  c=c+1;
                 
                 if(rs2.getString(8)!=null)
                  c=c+1;
                 
                 if(rs2.getString(9)!=null)
                  c=c+1;
               
                 if(rs2.getString(10)!=null)
                  c=c+1;
                 
                System.out.println("c="+c);
                arr.add(c);
                                    
             }
             System.out.println("No of modules="+nomodules);
             Integer list2[] = new Integer[arr.size()];
             list2 = (Integer[]) arr.toArray(list2);
             int[] myarray=new int[list2.length];
             for(int m=0;m<list2.length;m++)
             {
                myarray[m]=list2[m];
                System.out.println("int[] array element="+myarray[m]);
             }
             psb22.setProjectname(projectname);
             psb22.setNomodules(nomodules);
             psb22.setList(myarray);
             System.out.println("from bean---");
             System.out.println(psb22.getProjectname()+" "+psb22.getNomodules()+" "+psb22.getList());
             request.getSession().setAttribute("psb", psb22);

        }
        
        catch(SQLException se)
        {
            System.out.println("Connection unsuccessful");
        }
        
        
        return mapping.findForward("projectsnapshot");
    }
}
