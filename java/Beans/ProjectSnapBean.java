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
public class ProjectSnapBean extends org.apache.struts.action.ActionForm {
    
    private String name;
    private String projectname;
    private int nomodules;
    private int[] list;
    private int number;
    private String projname1;

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @param string
     */
    public void setName(String string) {
        name = string;
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
    public ProjectSnapBean() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * This is the action called from the Struts framework.
     *
     * @param value
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
    }*/
    public void setProjectname(String value)
    {
        projectname=value;
    }
    public void setNomodules(int in)
    {
        nomodules=in;
    }
    public void setList(int[] li)
    {
        list=li;
    }
    public void setProjname1(String value)
    {
        projname1=value;
    }
    public String getProjectname()
    {
        return projectname;
    }
    public int getNomodules()
    {
        return nomodules;
    }
    public int[] getList()
    {
        return list;
    }
    public String getProjname1()
    {
        return projname1;
    }
}
