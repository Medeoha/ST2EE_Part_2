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
        <td>Group</td>
        <td>Last Name</td>
        <td>Fiche visite</td>
        <td>Fiche eval</td>
        <td>Soutenance</td>
        <td>Plannif</td>
        <td>Faite</td>
        <td>Stage Date debut</td>
        <td>Stage Date fin</td>
        <td>Adresse</td>
        <td>Note technique</td>
        <td>Note com</td>
    </tr>
    <c:forEach>
        <%
            Teacher a = (Teacher) request.getSession().getAttribute("key_User");

            for (Intern i : a.getInterns()) {
        %></br><% %>

        <tr>
            <form name="TableFormIndex" method="post" action="ControllerDB">

                <input type="hidden" name="eleve_db" value= "<%=i.getId()%>" />
                <td><input type="text" name="GroupStudent" value=" <%out.print(i.getInfo_intern().getInternGroup());%>" />

                </td><!-- String -->
                <td><input type="text" name="LastNameStudent" value=" <%out.print(i.getInfo_intern().getFirstname());%>"   />

                </td><!-- String -->

                <!-- String -->
                <td>
                    <input type="checkbox" id="fiche_visite" name="fiche_visite"
                           <%if (i.getMission().getVisit_sheet() != null) {
                           %>checked disabled="disabled"<%
                        };%>/>


                </td><!-- String -->
                <td>
                    <input type="checkbox" id="fiche_eval" name="fiche_eval"
                           <%if (i.getMission().getEval_sheet() != null) {
                           %>checked disabled="disabled"<%
                        };%>/>

                </td><!-- String -->


                <td>
                    <input type="checkbox" id="soutenance" name="soutenance"
                           <%if (i.getMission().getSoutenance().booleanValue()) {
                           %>checked<%
                        };%> />
                </td><!-- String -->
                <td>
                    <input type="checkbox" id="plannif" name="plannif"
                           <%if (i.getMission().getVisit_sheet().getVisitPlanned().booleanValue()) {
                           %>checked<%
                        };%>/>

                </td><!-- String -->
                <td>
                    <input type="checkbox" id="faite" name="faite"
                           <%if (i.getMission().getVisit_sheet().getVisitDone().booleanValue()) {
                           %>checked<%
                        };%>/>

                </td><!-- String -->
                <td><input type="text" name="Debut" value=" <%out.print(new java.sql.Date(i.getMission().getStartMission().getTime()));%>" /></td><!-- String -->
                <td><input type="text" name="Fin" value="<%out.print(new java.sql.Date((i.getMission().getEndMission()).getTime()));%>" /></td><!-- String -->
                <td><input type="text" name="Adresse" value="<%out.print(i.getInfo_intern().getAddress());%>" /></td><!-- String -->
                <td><input type="text" name="NoteTech" value="<%out.print(i.getMission().getEval_sheet().getGradeTech());%>" /></td><!-- String -->
                <td><input type="text" name="NoteCom" value="<%out.print(i.getMission().getEval_sheet().getGradeCom());%>" /></td><!-- String -->
                <td><input type="submit" name="submit" value="Valid Edit"/></td>

            </form>
            <form name="detail" method="post" action="ControllerDetail">
                <input type="hidden" name="intern_details" value= "<%=i.getId()%>" />
                <td><input type="submit" name="Details" value="Search"/></td>
            </form>

        </tr>



        <%   }%>
        <form name="Actual_intern" method="get" action="ControllerDB">
            <input type="hidden" name="teachere" value="<%=a.getId()%>" />
            <td><input type="submit" name="Nouveau Stagiaire" value="Nouveau Stagiaire"/></td>
        </form>


    </c:forEach>

</table>

</body>


