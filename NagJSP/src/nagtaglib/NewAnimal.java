package nagtaglib;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import java.io.IOException;

public class NewAnimal extends TagSupport {

    private String action = "";
    private String method = "";

    public String getAction() {
    	return this.action;
    }

    public void setAction(String action) {
    	this.action = action;
    }

    public String getMethod() {
    	return this.method;
    }

    public void setMethod(String method) {
    	this.method = method;
    }


    public int doStartTag() throws JspException {
    	String in = "<tr>\n<form name=\"form1\" action=\"" + this.action + "\" " + 
    		    "method=\"" + this.method + "\">";
    	JspWriter out = pageContext.getOut();
    	try {
    	    out.print(in);
    	} catch(IOException e) {
    	    System.out.println("NagTag.NewAnimal: " + e);
    	}
    	return EVAL_BODY_INCLUDE;
    }

    public int doEndTag() throws JspException {
    	String in = "</form>\n</tr>";
    	JspWriter out = pageContext.getOut();
    	try {
    	    out.print(in);
    	} catch (IOException e) {
    	    System.out.println("NagTag.NewAnimal.EndTag(): " + e);
    	}
    	return EVAL_PAGE;
    }
}
              