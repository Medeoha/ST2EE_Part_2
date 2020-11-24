<%-- 
    Document   : welcom
    Created on : 22 nov. 2020, 14:27:12
    Author     : narut
--%>

<%@page import="java.util.Set"%>
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
              > Your FirstName is: ${key_User.firstname} </span> <br/>
        <span style="color: blue; font-weight: bold; font-size: 24"
              > Your LastName is: ${key_User.lastname} </span><br/>
                      <span style="color: blue; font-weight: bold; font-size: 24"
              > Yours interns are: ${key_User.getInterns()} </span>
               <span style="color: blue; font-weight: bold; font-size: 24"
>                  </br>
                     <%
                            Teacher a = (Teacher)request.getSession().getAttribute("key_User");
                            
                            for(Intern i : a.getInterns())
                            {
                                out.println(i.getInfo_intern().getFirstname());%></br><% 
                            }
                        
                     %>
                    Your first student name is:${key_User.getInterns().iterator().next().getInfo_intern().getFirstname()} <br/>
                   
    </span>

    </body>
</html>