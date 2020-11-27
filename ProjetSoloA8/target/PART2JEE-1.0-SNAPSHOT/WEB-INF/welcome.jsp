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

<body style="overflow:hidden">
    
    <div class="header_me">
        <img src="../efrei-paris_110x40.png" alt="Efrei Paris" class="app-logo_me" />
        <form name="LogOut" method="post" action="LogOutController">
            <td><input class="btn-submit_me" type="submit" name="detail" value="Log Out" /></td>
        </form>
        <br>
        <form style="display: flex;padding:10px;"id= "searchbox" method= "get" action= "RechercheController" >
            <input name= "q " type= "text " size= "30" placeholder= "Type here… " />
            <input style="padding:-10px;" class="btn-submit_me" id= "button-submit" type= "submit" value= "Search " />
            </form>
    </div>
    <div class="login-page">
        <div class="container-students the-containers" style="overflow-y:scroll">
            
            <table >
                <tr style="background-color:#3978bb;position: -webkit-sticky;
                position: sticky;top: 10px;color: whitesmoke;height: 100%;z-index:auto;">
                    <td style="height:40px;">Groupe</td>
                    <td>Nom</td>
                    <td>Fiche visite</td>
                    <td>Fiche eval</td>
                    <td>Soutenance</td>
                    <td>Plannif</td>
                    <td>Faite</td>
                    <td>Date debut</td>
                    <td>Date fin</td>
                    <td>Adresse</td>
                    <td>Note tech</td>
                    <td>Note comm</td>
                </tr>
                <div class="yeet"></div>
                <c:forEach>
                    <%
            Teacher a = (Teacher) request.getSession().getAttribute("key_User");
%>            <form name="Actual_intern" method="get" action="ControllerDB">
    <input  type="hidden" name="teachere" value="<%=a.getId()%>" />
    <input style="width:200px;"class="btn-submit_me ccc"
            type="submit" name="Nouveau Stagiaire" value="Nouveau Stagiaire" />
</form><%
            for (Intern i : a.getInterns()) {
        %><% %>

            <form name="TableFormIndex" method="post" action="ControllerDB">

                
         <tr style="overflow-y:scroll">       

                <input  type="hidden" name="eleve_db" value= "<%=i.getId()%>" />
                    <td><input size="5" class="input-form" type="text" name="GroupStudent"
                            value=" <%out.print(i.getInfo_intern().getInternGroup());%>" />

                    </td><!-- String -->
                    <td><input style="margin-left:5px;" class="input-form" type="text" name="LastNameStudent"
                            value=" <%out.print(i.getInfo_intern().getFirstname());%>" />

                    </td><!-- String -->

                    <!-- String -->
                    <td>
                        <input type="checkbox" id="fiche_visite" name="fiche_visite" <%if (i.getMission().getVisit_sheet() != null) {
                           %>checked disabled="disabled" <%
                        };%> />


                    </td><!-- String -->
                    <td>
                        <input type="checkbox" id="fiche_eval" name="fiche_eval" <%if (i.getMission().getEval_sheet() != null) {
                           %>checked disabled="disabled" <%
                        };%> />

                    </td><!-- String -->


                    <td>
                        <input type="checkbox" id="soutenance" name="soutenance" <%if (i.getMission().getSoutenance().booleanValue()) {
                           %>checked<%
                        };%> />
                    </td><!-- String -->
                    <td>
                        <input type="checkbox" id="plannif" name="plannif" <%if (i.getMission().getVisit_sheet().getVisitPlanned().booleanValue()) {
                           %>checked<%
                        };%> />

                    </td><!-- String -->
                    <td>
                        <input type="checkbox" id="faite" name="faite" <%if (i.getMission().getVisit_sheet().getVisitDone().booleanValue()) {
                           %>checked<%
                        };%> />

                    </td><!-- String -->
                    <td><input  type="text" maxlength="10" size="10" class="input-form" name="Debut"
                            value=" <%out.print(new java.sql.Date(i.getMission().getStartMission().getTime()));%>" />
                    </td>
                    <!-- String -->
                    <td><input type="text" maxlength="10" size="10" class="input-form" name="Fin"
                            value="<%out.print(new java.sql.Date((i.getMission().getEndMission()).getTime()));%>" />
                    </td>
                    <!-- String -->
                    <td><input type="text" class="input-form" name="Adresse"
                            value="<%out.print(i.getInfo_intern().getAddress());%>" />
                    </td>
                    <!-- String -->
                    <td><input type="text" maxlength="4" size="4" class="input-form" name="NoteTech"
                            value="<%out.print(i.getMission().getEval_sheet().getGradeTech());%>" /></td><!-- String -->
                    <td><input type="text" maxlength="4" size="4" class="input-form" name="NoteCom"
                            value="<%out.print(i.getMission().getEval_sheet().getGradeCom());%>" /></td><!-- String -->
                    <td><input style="margin-left:5px;" class="btn-submit_me" type="submit" name="submit"
                            value="Valid Edit" /></td>
                    </form>
                    <form name="detail" method="post" action="ControllerDetail">
                        <input type="hidden" name="intern_details" value="<%=i.getId()%>" />
                        <td><input style="margin-left:5px;" class="btn-submit_me" type="submit" name="Details"
                                value="Details" /></td>
                    </form>
                    </tr>



                    <%   }%>


            </table>

        </div>
    </div>
</body>
<style>



</style>
</html>