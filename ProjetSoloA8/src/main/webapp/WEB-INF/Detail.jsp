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
    <link rel="stylesheet" type="text/css" href="../style.css">

    <title>EFREI Paris - Intern</title>
</head>

<body style="overflow: hidden;">
    
    <div class="header_me">
        <img src="../efrei-paris_110x40.png" alt="Efrei Paris" class="app-logo_me" />
        <form name="LogOut" method="post" action="LogOutController">
            <td><input class="btn-submit_me" type="submit" name="detail" value="Log Out" /></td>
        </form>
    </div>

    <div class="login-page">
        <div class="container-students the-containers" style="overflow: auto;">

            <table style="border-spacing: 0;">
                <tr style="color: whitesmoke;background-color: #366eaa;">
                    <td style="height:40px;" >Identifiant</td>
                    <td>Last Name</td>
                    <td>First Name</td>
                    <td>Groupe</td>
                    <td>Adresse</td>
                    <td>Maître d'apprentissage</td>
                    <td>Date de début</td>
                    <td>Date de fin</td>
                    <td>Description de la mission</td>
                    <td>Commentaires</td>
                    <td style="width:500px"></td>
                    <td style="width:500px"></td>

                </tr>
                
                <%
            Intern i = (Intern) request.getAttribute("key_User");
        %><% %>

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
                <td><label><%out.print(new java.sql.Date((i.getMission().getStartMission().getTime())));%></label>
                </td>
                <td><label><%out.print(new java.sql.Date((i.getMission().getEndMission()).getTime()));%></label>
                </td>
                <td><input type="text" name="Description_mission"
                        value="<%=i.getMission().getMidInternshipMeetingInfo()%>" /></td>
                <td><input type="text" name="Description" value="<%=i.getMission().getCommentsOfTheIntern()%>" />
                </td>

                <td><input class="btn-submit_me" type="submit" name="submit" value="Valid Edit" /></td>

            </form>


                </tr>



            </table>
        </div>
    </div>

</body>

</html>