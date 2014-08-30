package Beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author diptimaya
 */
public class RegisterFormBean1 extends org.apache.struts.action.ActionForm {
    
    private String projectname;
    private int projecttime;
    private int s1;
    private int s2;
    private int s3;
    private int s4;
    private int s5;
    private int s6;
    private int key;
    private int nomodules;
    private String adminname;
    private String adminpass;
    private String member1;
    private String member2;
    private String member3;
    private String member4;
    private String member5;
    private String member6;
    private String member7;
    private String member8;
    private String member9;
    private String member10;
    


   
    


    /**
     * @return
     */
    

    /**
     * @param st
     */
    public void setProjectname(String st) {
        projectname = st;
    }
    public void setProjecttime(int in) {
        projecttime = in;
    }
    public void setS1(int in)
    {
        s1=in;
    }
    public void setS2(int in)
    {
        s2=in;
    }
    public void setS3(int in)
    {
        s3=in;
    }
    public void setS4(int in)
    {
        s4=in;
    }
    public void setS5(int in)
    {
        s5=in;
    }
    public void setS6(int in)
    {
        s6=in;
    }
    
    
    public void setNomodules(int in) {
        nomodules = in;
    }
    
    public void setAdminname(String st) {
        adminname = st;
        System.out.println("sA()"+adminname);
    }
    public void setAdminpass(String st) {
        adminpass = st;
    }
    
    public void setMember1(String st)
    {
        member1=st;
    }
    public void setMember2(String st)
    {
        member2=st;
    }
    public void setMember3(String st)
    {
        member3=st;
    }
    public void setMember4(String st)
    {
        member4=st;
    }
    public void setMember5(String st)
    {
        member5=st;
    }
    public void setMember6(String st)
    {
        member6=st;
    }
    public void setMember7(String st)
    {
        member7=st;
    }
    public void setMember8(String st)
    {
        member8=st;
    }
    public void setMember9(String st)
    {
        member9=st;
    }
    public void setMember10(String st)
    {
        member10=st;
    }
    public void setKey(int in)
    {
        key=in;
    }
    
    public int getKey()
    {
        return key;
    }
    
    public String getProjectname()
    {
        return projectname;
    }
    
    public int getProjecttime()
    {
        return projecttime;
    }
    public int getS1()
    {
        return s1;
        
    }
    public int getS2()
    {
        return s2;
        
    }
    public int getS3()
    {
        return s3;
        
    }
    public int getS4()
    {
        return s4;
        
    }
    public int getS5()
    {
        return s5;
        
    }
    public int getS6()
    {
        return s6;
        
    }
    
    public int getNomodules()
    {
        return nomodules;
    }

    public String getAdminname()
    {
        System.out.println("gA()s");
        return adminname;
    }
    
    public String getAdminpass()
    {
        return adminpass;
    }
    
    public String getMember1()
     {
        return member1;
     }
    
     public String getMember2()
     {
        return member2;
     }
     public String getMember3()
     {
        return member3;
     }
     public String getMember4()
     {
        return member4;
     }
     public String getMember5()
     {
        return member5;
     }
     public String getMember6()
     {
        return member6;
     }
     public String getMember7()
     {
        return member7;
     }
     public String getMember8()
     {
        return member8;
     }
     public String getMember9()
     {
        return member9;
     }
     public String getMember10()
     {
        return member10;
     }
   
    /**
     *
     */
    public RegisterFormBean1() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) 
    {
        ActionErrors errors = new ActionErrors();
        if (getProjectname() == null || getProjectname().length() < 1)
        {
            errors.add("name", new ActionMessage("error.name.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        return errors;
    
    }
}  

