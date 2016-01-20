package nagtaglib;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import java.io.IOException;

public class NagSubmit extends TagSupport {
    private String in = "<td>\n" + 
    			"   <input type=\"submit\" name=\"press\" value=\"";
    public String value = "";

    public String getValue() {
    	return value;
    }

    public void setValue(String value) {
    	this.value = value;
    }

    public int doStartTag() throws JspException {
    	JspWriter out = pageContext.getOut();
    	try {
    	    out.print(in + (this.value.equals("") ? "submit\" />\n</td>" : this.value + "\" />\n</td>"));
    	} catch(IOException e) {
    	    System.out.println("NagTag.Submit: " + e);
    	}
    	return SKIP_BODY;
    }
}
              