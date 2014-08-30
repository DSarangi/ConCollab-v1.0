/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author diptimaya
 */
public class AddingModuleBean extends org.apache.struts.action.ActionForm {
    
    private String moddescription;
    private String projectname;
    private String projectname1;
    private int nomodules;

    /**
     * @return
     */
    public String getModdescription() {
        return moddescription;
    }

    /**
     * @param string
     */
    public void setModdescription(String string) {
        moddescription = string;
    }
    
    public void setProjectname(String string) {
        projectname = string;
    }
    
     public void setProjectname1(String string) {
        projectname1 = string;
    }
     
      public String getProjectname() {
        return projectname;
    }
      
    public String getProjectname1() {
        return projectname1;
    }  

    /**
     * @return
     */
    public int getNomodules() {
        return nomodules;
    }

    /**
     * @param i
     */
    public void setNomodules(int i) {
        nomodules = i;
    }

    /**
     *
     */
    public AddingModuleBean() {
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
    /**public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (getName() == null || getName().length() < 1) {
            errors.add("name", new ActionMessage("error.name.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        return errors;
    }**/
}
