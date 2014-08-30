/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Beans.LiveEditFormBean;
import Beans.LiveEditFormBean2;
import java.io.*;
import java.sql.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
/**
 *
 * @author diptimaya
 */
public class SaveLiveEditAction extends org.apache.struts.action.Action {

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
        LiveEditFormBean2 lfb22=(LiveEditFormBean2)request.getSession().getAttribute("lfb2");
        String p=lfb22.getProjectname();
        System.out.println("PROJECT NAME="+p);
        LiveEditFormBean2 lfb2=(LiveEditFormBean2)form;
        int m=lfb2.getModnosave();
        /*int c=lfb2.getCodenosave();*/
        String code=lfb2.getEditorcontent();
        int m1=lfb2.getModnosave1();
        int c1=lfb2.getCodenosave1();
        int c=0;
        System.out.println("@@@!!!"+m+","+p);
        System.out.println("@@@!!!222**"+m1+","+c1+","+p);

 
      try{   
          
          if(m1!=0 && c1!=0)
        {
           Class.forName("oracle.jdbc.driver.OracleDriver");
	   System.out.println("Driver loaded successfully");
	   Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","pass"); 
           PreparedStatement pst1=conn.prepareStatement("select code1,code2,code3,code4,code5,code6,code7,code8 from CONCOLLABMODULES where projectname=? and moduleno=?");
           System.out.println("okay!!@@@@");
           pst1.setString(1,p);
           pst1.setInt(2,m1);
           System.out.println("allright@");
           ResultSet rst1=pst1.executeQuery();
           System.out.println("allright@2");
           int count1=0;
          while(rst1.next()) 
          { if(rst1.getString(1)!=null)
               count1=count1+1;
           if(rst1.getString(2)!=null)
               count1=count1+1;
           if(rst1.getString(3)!=null)
               count1=count1+1;
           if(rst1.getString(4)!=null)
               count1=count1+1;
           if(rst1.getString(5)!=null)
               count1=count1+1;
           if(rst1.getString(6)!=null)
               count1=count1+1;
           if(rst1.getString(7)!=null)
               count1=count1+1;
           if(rst1.getString(8)!=null)
               count1=count1+1;
          }
           if(c1>0 && c1<=count1 && c1<9)
           {    
           File ff1=new File("a1.txt");
           FileOutputStream fos=new FileOutputStream(ff1);
           byte bb[]=code.getBytes();
           fos.write(bb);
           fos.close();
           String filepath="C:\\apache-tomcat-7.0.55\\webapps";
           String filename=p+m1+"."+c1+".txt";
           File ff2=new File(filepath, filename);
           System.out.println("Output file="+ff2);
           FileUtils.copyFile(ff1, ff2);
           System.out.println("Attempting to update db!!!!!!");
           
           
           String qrr="update CONCOLLABMODULES set code"+c1+"=? where projectname=? and moduleno=?";

           PreparedStatement pst2=conn.prepareStatement(qrr);
           pst2.setString(1,"okay1");
           pst2.setString(2,p);
           pst2.setInt(3,m1);
           int rr=pst2.executeUpdate();
           System.out.println("Overwrite update over!!!!="+rr);
           conn.close();
           }
           
            
        }
       else{  
        
           File ff=new File("a.txt");
           FileOutputStream fos=new FileOutputStream(ff);
           byte b[]=code.getBytes();
           fos.write(b);
           fos.close();
           String filepath1="C:\\apache-tomcat-7.0.55\\webapps";
           
           Class.forName("oracle.jdbc.driver.OracleDriver");
	   System.out.println("Driver loaded successfully");
	   Connection con1= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","pass");
           System.out.println("Connection successful!!!");
           PreparedStatement ps=con1.prepareStatement("select code1,code2,code3,code4,code5,code6,code7,code8 from CONCOLLABMODULES where projectname=? and moduleno=?");
           System.out.println("okay!!@@@@");
           ps.setString(1,p);
           ps.setInt(2,m);
           System.out.println("allright@");
           ResultSet rs=ps.executeQuery();
           System.out.println("allright@2");
           int count=0;
          while(rs.next()) 
          { if(rs.getString(1)!=null)
               count=count+1;
           if(rs.getString(2)!=null)
               count=count+1;
           if(rs.getString(3)!=null)
               count=count+1;
           if(rs.getString(4)!=null)
               count=count+1;
           if(rs.getString(5)!=null)
               count=count+1;
           if(rs.getString(6)!=null)
               count=count+1;
           if(rs.getString(7)!=null)
               count=count+1;
           if(rs.getString(8)!=null)
               count=count+1;
          }
           System.out.println("allright@3");
           c=count+1;
           System.out.println("!!!c="+c);
           if(c<9)
           {    
           String filename=p+m+"."+c+".txt";
           File ff1=new File(filepath1, filename);
           System.out.println("Output file="+ff1);
           FileUtils.copyFile(ff, ff1);
           System.out.println("Attempting to update db");
           
           
           String q="update CONCOLLABMODULES set code"+c+"=? where projectname=? and moduleno=?";
           System.out.println("allright@4");
           PreparedStatement ps1=con1.prepareStatement(q);
           System.out.println("allright@5");
           ps1.setString(1,"okay");
           ps1.setString(2,p);
           ps1.setInt(3,m);
           System.out.println("allright@6");
           int r1=ps1.executeUpdate();
           System.out.println("allright@7");
           System.out.println("$$$$"+r1);
           con1.close();
           }
        }   
       }
       catch(SQLException se)
       {
           System.out.println("Sorry SQL Error");
       }
       catch(FileNotFoundException fne)
       {
            System.out.println("Sorry file error");
     
       }
        catch(Exception ee)
        {
            System.out.println("Sorry Error");

        }
        
        return mapping.findForward("backtoeditor");
    }
}
