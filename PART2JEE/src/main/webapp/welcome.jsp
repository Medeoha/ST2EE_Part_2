<%-- 
    Document   : welcom
    Created on : 22 nov. 2020, 14:27:12
    Author     : narut
--%>

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
    </body>
</html>