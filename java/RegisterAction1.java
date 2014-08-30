/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import java.sql.*;
import java.util.Random;
import Beans.*;

/**
 *
 * @author diptimaya
 */
public class RegisterAction1 extends org.apache.struts.action.Action
{
   


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

      try{
        RegisterFormBean1 rfb=(RegisterFormBean1)form;
        String projectname=rfb.getProjectname();
        System.out.println(projectname);
         int projecttime=rfb.getProjecttime();
         int s1=rfb.getS1();
         int s2=rfb.getS2();
         int s3=rfb.getS3();
         int s4=rfb.getS4();
         System.out.println(s4);
         int s5=rfb.getS5();
         int nomodules=rfb.getNomodules();
         String adminname=rfb.getAdminname();
         String adminpass=rfb.getAdminpass();
         String member1=rfb.getMember1();
         String member2=rfb.getMember2();
         String member3=rfb.getMember3();
         String member4=rfb.getMember4();
         String member5=rfb.getMember5();
         String member6=rfb.getMember6();
         String member7=rfb.getMember7();
         String member8=rfb.getMember8();
         String member9=rfb.getMember9();
         String member10=rfb.getMember10();
         String[] members={member1,member2,member3,member4,member5,member6,member7,member8,member9,member10};
         int membercount=0;
                 
         System.out.println(member2);
         
        Class.forName("oracle.jdbc.driver.OracleDriver");
	System.out.println("Driver loaded successfully");
	Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","pass");
        PreparedStatement ps=con.prepareStatement("insert into CONCOLLABUSERS values(?,?,?,?)");
        ps.setString(1,adminname);
        ps.setString(2,adminpass);
        ps.setString(3,projectname);
        ps.setString(4,"admin");
        
        int r=ps.executeUpdate();
        System.out.println("value of r:"+r);
        
        
        for(int i=0;i<10;i++)
        {
            if(members[i]!=null && members[i]!="")
            {
                membercount++;
                PreparedStatement ps1=con.prepareStatement("insert into CONCOLLABUSERS values(?,?,?,?)");
                ps1.setString(1,members[i]);
                ps1.setString(2,"");
                ps1.setString(3,projectname);
                ps1.setString(4,"user");
                int r1=ps1.executeUpdate();
                System.out.println(r1);
                
                
            }
        }
        System.out.println("No.of members="+membercount);
        
        Random rg=new Random();
        int key=rg.nextInt(500);
        System.out.println("Key is="+key);
        rfb.setKey(key);
        System.out.println(rfb.getKey());
                
        PreparedStatement ps2=con.prepareStatement("insert into CONCOLLABPROJECTS values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ps2.setString(1,projectname);
        ps2.setInt(2,key);
        ps2.setInt(3,membercount);
        ps2.setInt(4,nomodules);
        ps2.setInt(5,projecttime);
        ps2.setInt(6,s1);
        ps2.setInt(7,s2);
        ps2.setInt(8,s3);
        ps2.setInt(9,s4);
        ps2.setInt(10,s5);
        ps2.setInt(11,0);
        ps2.setInt(12,0);
        ps2.setInt(13,0);
        ps2.setInt(14,0);
        ps2.setInt(15,0);
        ps2.setInt(16,0);
        
        int r2=ps2.executeUpdate();
        System.out.println(r2+"!!!");
        
        
       /* Connection con2= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","pass");
        */System.out.println("Going ahead--->");
         for(int i=1;i<=nomodules;i++)
        {    
          PreparedStatement ps3=con.prepareStatement("insert into CONCOLLABMODULES values(?,?,?,?,?)");
          ps3.setInt(1,i);
          ps3.setString(2,projectname);
          ps3.setString(3,"");
          ps3.setString(4,"");
          ps3.setString(5,"");
          int r3=ps3.executeUpdate();
          System.out.println(r3+"@@@@@@");
      
        }
        
        con.close();
       request.setAttribute("rfb",rfb);
      }
      catch(ClassNotFoundException cne)
      {
          System.out.println("Sorry Error!!!");
      }
      
      catch(SQLException se)
      {
          System.out.println("Connection Unsuccessful");
      }
      System.out.println("checked");
      return mapping.findForward("okay1");
    }
    
}
