package lst;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class NagSessionLst implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent se) {
    	HttpSession ss = se.getSession();
    	ss.setMaxInactiveInterval(5*60);
    	System.out.println("\nNagJspSession:created:Id=" + se.getSession().getId());
    	System.out.println("NagJspSession:TimeOut=" + se.getSession().getMaxInactiveInterval() + "\n");
    }

    public void sessionDestroyed(HttpSessionEvent se) {
    	System.out.println("NagSessionLst:sessionDestroyed:Id=" + se.getSession().getId());
    }
}