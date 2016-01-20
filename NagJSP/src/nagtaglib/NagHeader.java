package nagtaglib;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import java.io.IOException;

public class NagHeader extends TagSupport {
    private String in = "<tr>\n" + 
    			    "<td><b>Name</b></td>\n" + 
                            "<td><b>Value</b></td>\n" +
                            "<td><b>Action</b></td>\n" +
                        "</tr>";

    public int doStartTag() throws JspException {
    	JspWriter out = pageContext.getOut();
    	try {
    	    out.print(in);
    	} catch(IOException e) {
    	    System.out.println("NagTag.Header: " + e);
    	}
    	return SKIP_BODY;
    }
}
              