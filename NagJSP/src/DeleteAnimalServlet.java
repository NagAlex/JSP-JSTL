import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import beans.Animals;

public class DeleteAnimalServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs)
    			throws ServletException, IOException {
	HttpSession hs = rq.getSession();
	String id = hs.getId();
	
	String anim = rq.getParameter("anim");
	String name = rq.getParameter("name");

        hs.setAttribute("del" + id, "");
        Map<String, Animals> animalMap = (Map<String, Animals>) hs.getAttribute(id);
        if(animalMap != null){
            if(animalMap.containsKey(anim)) {	
            	Animals animal = animalMap.get(anim);
            	Set<String> animalNames = animal.getNames();
            	if(animalNames.size() == 1) {
            	    animal.removeAll();
            	    animalMap.remove(anim);
            	} else 
            	    animal.removeName(name);
            	hs.setAttribute("del" + id, anim + " whith name " + name + " deleted successfully.");
            	hs.setAttribute(id, animalMap);
            }
        }
	
	System.out.println("DeleteAnimalServlet: aminal " + anim + "(name " + name + ") deleted");
	rq.getRequestDispatcher("index.jsp").forward(rq, rs);
    }
}