<?xml version="1.0" encoding="CP1251"?>
<%@ page language="java" contentType="text/html; charset=CP1251" import="java.util.*" import="beans.Animals" %>
<%@ taglib uri="nagtag.tld" prefix="nt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=CP1251"/>
    <title>Nag JSP Homework</title>
    <%! Map<String, Animals> anim;
    	int count;
     %>
  </head>
  <body>
     <center>
     <% HttpSession hs = request.getSession();
        anim = (Map<String, Animals>) hs.getAttribute(hs.getId()); 
        String delStr = (String) hs.getAttribute("del" + hs.getId());
        if(delStr == null) delStr = "";
      %>
        <br><b><%= delStr %> </b>
        <br><b>Id = <%= hs.getId() %></b><br>
     <table border="1">
        <nt:header />
     <% if(anim != null) {
            Set<String> animKeys = anim.keySet();
            for(String an: animKeys) {
            	count = 1;
                Animals animal = anim.get(an);
             	for(String name: animal.getNames()) { %>
                    <tr>	
             	 <% if(count == 1) {
             	        count++; %>
             	        <td> <%= an%> </td>
             	 <% } else { %>
             	 	<td>  </td>
             	 <% } %>
                       <td> <%= name %> </td>
                       <td> <a href="DelAnim?anim=<%= an%>&name=<%= name%>">delete</td>
                    </tr>    	
             <%	}
            }
        }
      %>
     	<nt:newanimal action="Add" method="get">
     	   <nt:name nname="name" />
     	   <nt:value nname="value" />
     	   <nt:submit value="add" />
     	</nt:newanimal>
     </table>
  </body>
</html>


