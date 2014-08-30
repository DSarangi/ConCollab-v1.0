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
public class Editor1Bean extends org.apache.struts.action.ActionForm {
    
    private int modnoview;
    private int codenoview;
    
    private String code1;
    private String projectname;
    
    private int number;

    /**
     * @return
     */
    public int getModnoview() {
        return modnoview;
    }

    /**
     * @param string
     */
    public void setModnoview(int in) {
        modnoview = in;
    }
    
    public int getCodenoview() {
        return codenoview;
    }
    
    public void setCodenoview(int in) {
        codenoview = in;
    }
    

    /**
     * @return
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param i
     */
    public void setNumber(int i) {
        number = i;
    }

    /**
     *
     */
    public Editor1Bean() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void setCode1(String string)
    {
        code1=string;
    }
    public String getCode1()
    {
        return code1;
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
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    /*public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (getName() == null || getName().length() < 1) {
            errors.add("name", new ActionMessage("error.name.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        return errors;
    }
    */
}
