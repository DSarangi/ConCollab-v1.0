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
public class Editor2Bean extends org.apache.struts.action.ActionForm {
    
    private String code2;
    
    private int modnoview;
    private int codenoview;
    private String projectname;
    

    /**
     * @return
     */
    public String getCode2() {
        return code2;
    }

    /**
     * @param string
     */
    public void setCode2(String string) {
        code2 = string;
    }

    /**
     * @return
     */
    public int getModnoview() {
        return modnoview;
    }

    /**
     * @param i
     */
    public void setModnoview(int i) {
        modnoview = i;
    }
    public void setCodenoview(int i) {
        codenoview = i;
    }
    public int getCodenoview() {
        return codenoview;
    }
    
    public void setProjectname(String string)
    {
        projectname=string;
    }
    
    public String getProjectname()
    {
        return projectname;
    }
    

    /**
     *
     */
    public Editor2Bean() {
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
   /* public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (getName() == null || getName().length() < 1) {
            errors.add("name", new ActionMessage("error.name.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        return errors;
    }
    */
}
