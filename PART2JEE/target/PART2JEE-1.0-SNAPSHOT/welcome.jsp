<%-- 
    Document   : welcom
    Created on : 22 nov. 2020, 14:27:12
    Author     : narut
--%>

<%@page import="Models.*"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;
              charset=UTF-8">
        <title>JPA Tutorial - Welcome page</title>
    </head>
    <body>
        <h1> <span style="color: red; font-weight: bold" >
                Congratulations! </span><br/>
            Simply reaching this page means that your JPA is working
            properly! </h1>
        <span style="color: blue; font-weight: bold; font-size: 24"
              > Your login is: ${key_User.firstname} </span> <br/>
        <span style="color: blue; font-weight: bold; font-size: 24"
              > Your password is: ${key_User.lastname} </span>
                      <span style="color: blue; font-weight: bold; font-size: 24"
              > Your password is: ${key_User.interns} </span>
              <%-- <span style="color: blue; font-weight: bold; font-size: 24"
                    key_User.interns.next().info_intern.lastname
                    > Your password is: <% Teacher key_User = (Teacher)request.getAttribute("key_User");
                                            Iterator it = key_User.getInterns().iterator();
                                            while(it.hasNext())
                                            {
                                               Intern yes = (Intern) it.next();
                                               String test = yes.getInfo_intern().getFirstname();
                                               out.print(test);
                                            }%></span> --%>

    </body>
</html>