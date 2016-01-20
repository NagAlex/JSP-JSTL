import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import beans.Animals;

public class AddAnimalServlet extends HttpServlet {
    Map<String, Animals> animalMap;
    
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs)
    			throws ServletException, IOException {
	HttpSession hs = rq.getSession();
	String id = hs.getId();

	System.out.println("Servlet:Session Id=" + id);
	System.out.println("Servlet:Session TimeOut=" + hs.getMaxInactiveInterval());

        hs.setAttribute("del" + id, "");
	String animalName = rq.getParameter("name");
	String name = rq.getParameter("value");
	if((!animalName.equals("")) && (!name.equals(""))) {
	    if(hs.getAttribute(id) != null) 
	    	animalMap = (Map<String, Animals>) hs.getAttribute(id);
	    else 
	        animalMap = new Hashtable<>();

	    Animals animal;
	    if(animalMap.containsKey(animalName))
	    	animal = animalMap.get(animalName);
	    else {
	    	animal = new Animals();
	    	animalMap.put(animalName, animal);
	    }
	    animal.addName(name);
	    hs.setAttribute(id, animalMap);
	}
	
	rq.getRequestDispatcher("index.jsp").forward(rq, rs);
    }
}