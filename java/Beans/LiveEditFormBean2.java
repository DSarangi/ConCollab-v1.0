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
public class LiveEditFormBean2 extends org.apache.struts.action.ActionForm {
    
    private int modnosave;
    private int modnosave1;

    private int codenosave;
    private int codenosave1;

    private String editorcontent;
    private String projectname;
    

    
    private int number;

    /**
     * @return
     */
    public int getModnosave() {
        return modnosave;
    }
    public int getModnosave1() {
        return modnosave1;
    }

    public String getEditorcontent() {
        return editorcontent;
    }
    
    public void setEditorcontent(String string) {
         editorcontent=string;
    }
    /**
     * @param string
     */
    public void setModnosave(int in) {
        modnosave = in;
    }
    public void setModnosave1(int in) {
        modnosave1 = in;
    }
    
    public void setCodenosave1(int in) {
        codenosave1 = in;
    }
    
    public int getCodenosave1() {
        return codenosave1;
    }
    public String getProjectname() {
        return projectname;
    }
    public void setProjectname(String string) {
        projectname = string;
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
    public LiveEditFormBean2() {
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
