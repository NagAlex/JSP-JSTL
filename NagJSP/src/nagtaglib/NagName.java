package nagtaglib;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import java.io.IOException;

public class NagName extends TagSupport {
    private String in = "<td>\n" + 
    		        "   <input type=\"text\" name=\"";
    public String nname = "";

    public String getNname() {
    	return nname;
    }

    public void setNname(String nname) {
    	this.nname = nname;
    }

    public int doStartTag() throws JspException {
    	JspWriter out = pageContext.getOut();
    	try {
    	    out.print(in + this.nname + "\" size=\"25\" />\n</td>");
    	} catch(IOException e) {
    	    System.out.println("NagTag.NagName: " + e);
    	}
    	return SKIP_BODY;
    }
}
              