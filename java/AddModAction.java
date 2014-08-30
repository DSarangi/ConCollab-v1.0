/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Beans.AddingModuleBean;
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
public class AddModAction extends org.apache.struts.action.Action {

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
        AddingModuleBean amb11=(AddingModuleBean)request.getSession().getAttribute("amb");
        String projname=amb11.getProjectname();
        AddingModuleBean amb=(AddingModuleBean)form;
        System.out.println("from bean-"+projname);
        String moddesc=amb.getModdescription();
        String[] descparts = moddesc.split(",");
        for(int i=0;i<descparts.length;i++)
        System.out.println(descparts[i]);
        int counter=0;
        int j;

        int nomod=amb.getNomodules();
        
      try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
	System.out.println("Driver loaded successfully");
	Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","pass");
        PreparedStatement ps=con.prepareStatement("select * from CONCOLLABMODULES where projectname=?");
        ps.setString(1,projname);
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            counter=counter+1;
        }
        System.out.println("No of rows already present="+counter);
        for(int i=1;i<=nomod;i++)
        {
            j=(counter+i);     
          PreparedStatement ps1=con.prepareStatement("insert into CONCOLLABMODULES values(?,?,?,?,?,?,?,?,?,?,?)");
          ps1.setInt(1,j);
          ps1.setString(2,projname);
          ps1.setString(3,"");
          ps1.setString(4,"");
          ps1.setString(5,"");
          ps1.setString(6,"");
          ps1.setString(7,"");
          ps1.setString(8,"");
          ps1.setString(9,"");
          ps1.setString(10,"");
          ps1.setString(11,descparts[i]);
          System.out.println(descparts[i]);

          int r=ps1.executeUpdate();
          System.out.println(r+"!!!!@@@$$@@@!!!!");
          
        }   
        con.close();
        }
      catch(SQLException se)
      {
          System.out.println("Connection Unsuccessful");
      }
      
        return mapping.findForward(SUCCESS);
    }
}
