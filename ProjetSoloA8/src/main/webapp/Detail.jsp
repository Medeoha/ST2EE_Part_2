<%--
    Document   : welcom
    Created on : 22 nov. 2020, 14:27:12
    Author     : narut
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Set"%>
<%@page import="Models.*"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%--
  Created by IntelliJ IDEA.
  User: etienne
  Date: 12/11/2020
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">

    <title>Title</title>
</head>
<body>


<form name="LogOut" method="post" action="LogOutController">
    <td><input type="submit" name="detail" value="Log Out"/></td>
</form>
<table>
    <tr>
        <td>Identifiant</td>
        <td>Last Name</td>
        <td>First Name</td>
        <td>Groupe</td>
        <td>Adresse</td>
        <td>Maître d'apprentissage</td>
        <td>Date de début</td>
        <td>Date de fin</td>
        <td>Description de la mission</td>
        <td>Commentaires</td>

    </tr>
    <c:forEach>
        <%
            Intern i = (Intern) request.getAttribute("key_User");
        %></br><% %>

        <tr>
            <form name="Detail" method="get" action="ControllerDetail">
                <!---Details Stagiaire -->
                <input type="hidden" name="student_db_detail" value="<%=i.getId()%>" />
                <td><label><%=i.getId()%></label></td>
                <td><label><%=i.getInfo_intern().getLastname()%></label></td>
                <td><label><%=i.getInfo_intern().getFirstname()%></label></td>
                <td><label><%=i.getInfo_intern().getInternGroup()%></label></td>
                <!---Details Stagiaire -->
                <td><input type="text" name="Adresse" value="<%=i.getInfo_intern().getAddress()%>" /></td>
                <td><label><%=i.getTeacher().getLastname()%></label></td>
                <td><label><%out.print(new java.sql.Date((i.getMission().getStartMission().getTime())));%></label></td>
                <td><label><%out.print(new java.sql.Date((i.getMission().getEndMission()).getTime()));%></label></td>
                <td><input type="text" name="Description_mission" value="<%=i.getMission().getMidInternshipMeetingInfo()%>" /></td>
                <td><input type="text" name="Description" value="<%=i.getMission().getCommentsOfTheIntern()%>" /></td>

                <td><input type="submit" name="submit" value="Valid Edit"/></td>

            </form>


        </tr>



    </c:forEach>

</table>

</body>


<%--

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
                            }%></br><%
                                out.println("FIN, CE PROFESSEUR POSSEDE " + a.getInterns().size() + " ETUDIANTS");

                     %>


    </span>

    </body>
</html>--%>