/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Beans.AddingModuleBean;
import Beans.AdminToolsBean;
import Beans.DummyBean;
import Beans.Editor1Bean;
import Beans.Editor2Bean;
import Beans.LiveEditFormBean2;
import Beans.ProjectSnapBean;
import java.sql.*;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.Session;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author diptimaya
 */
public class LoginAction extends org.apache.struts.action.Action {

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
        
        DummyBean db=(DummyBean)form;
        String name=db.getName();
        System.out.println(name);
        String projectname;
        int nomodules=0;
        ArrayList arr=new ArrayList();
        
        try{
        
        Class.forName("oracle.jdbc.driver.OracleDriver");
	System.out.println("Driver loaded successfully");
        Connection cn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","pass");
        System.out.println("connection successfull");

        PreparedStatement ps=cn.prepareStatement("select * from CONCOLLABUSERS where name=?");
        ps.setString(1,name);
        ResultSet rs=ps.executeQuery();
        if(rs.next())
        {
           projectname=rs.getString(3);
           System.out.println(projectname);
          
           /*PreparedStatement ps1=cn.prepareStatement("select * from CONCOLLABPROJECTS where projectname=?");
           ps1.setString(1,projectname);
           ResultSet rs1=ps1.executeQuery();
           
           nomodules=rs1.getInt(4);
           System.out.println("no of modules="+nomodules);
           */        
               
           
           
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
             ProjectSnapBean psb=new ProjectSnapBean();
             psb.setProjectname(projectname);
             psb.setNomodules(nomodules);
             psb.setList(myarray);
             request.getSession().setAttribute("psb",psb);
             System.out.println("from bean---");
             System.out.println(psb.getProjectname()+" "+psb.getNomodules()+" "+psb.getList());
             
             AddingModuleBean amb=new AddingModuleBean();
             amb.setProjectname(projectname);
             request.getSession().setAttribute("amb",amb);
             
             AdminToolsBean atb=new AdminToolsBean();
             atb.setUsername(name);
             request.getSession().setAttribute("atb",atb);
             
             LiveEditFormBean2 lfb2=new LiveEditFormBean2();
             lfb2.setProjectname(projectname);
             request.getSession().setAttribute("lfb2", lfb2);
             
             Editor1Bean eb1=new Editor1Bean();
             eb1.setProjectname(projectname);
             request.getSession().setAttribute("eb1", eb1);
             
             Editor2Bean eb2=new Editor2Bean();
             eb2.setProjectname(projectname);
             request.getSession().setAttribute("eb2", eb2);
             
             
             
        }
        }
        catch(SQLException se)
        {
            System.out.println("Connection unsuccessful");
        }
        
        return mapping.findForward("startup");
    }
}
