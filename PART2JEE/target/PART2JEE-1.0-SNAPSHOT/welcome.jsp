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

<form name="Recherche" method="post" action="TableSearch">
    <td><input type="text" name="search" /></td>
    <td><input type="submit" name="search" value="Search"/></td>
</form>
<form name="LogOut" method="post" action="Logout">
    <td><input type="submit" name="detail" value="Log Out"/></td>
</form>
    <table>
        <tr>
            <td>Group</td>
            <td>Last Name</td>
            
            <td>Fiche visite</td>
            <td>Fiche eval</td>
            <td>Rapport</td>
            <td>Soutenance</td>
            <td>Plannif</td>
            <td>Faite</td>
            <td>Stage Date debut</td>
            <td>Stage Date fin</td>
            <td>Entreprise nom</td>
            <td>Maitre de stage</td>
            <td>Adresse</td>
            <td>Note technique</td>
            <td>Notet com</td>
        </tr>
        <c:forEach>
             <%
                            Teacher a = (Teacher)request.getSession().getAttribute("key_User");
                            
                            for(Intern i : a.getInterns())
                            {
                                %></br><% %>
                            
                            <tr>
                                <form name="TableFormIndex" method="get" action="ControllerDB">

                                    <input type="hidden" name="id_student" value="" />
                                <td><input type="text" name="GroupStudent" value=" <%out.print(i.getInfo_intern().getInternGroup());%>" />

                                </td><!-- String -->
                                <td><input type="text" name="LastNameStudent" value=" <%out.print(i.getInfo_intern().getFirstname());%>"   />
                                   
                               </td><!-- String -->
                                <td>
                                    <input type="checkbox" id="cdc" name="cdc"
                                           <%out.print(i.getInfo_intern().getFirstname());%>
                                </td>
                                <!-- String -->
                                <td>
                                    <input type="checkbox" id="fiche_visite" name="fiche_visite"
                                           <%if(i.getMission().getVisit_sheet()!=null)
                                           {
                                                %>checked<%
                                                        };%>/>


                                </td><!-- String -->
                                <td>
                                    <input type="checkbox" id="fiche_eval" name="fiche_eval"
                                            <%if(i.getMission().getEval_sheet()!=null)
                                           {
                                                %>checked<%
                                                        };%>/>

                                </td><!-- String -->
                           
       
                                <td>
                                    <input type="checkbox" id="soutenance" name="soutenance"/>
                                      <%if(i.getMission().getSoutenance()!=null)
                                           {
                                                %>checked<%
                                                        };%> 
                                </td><!-- String -->
                                <td>
                                    <input type="checkbox" id="plannif" name="plannif" 
                                            <%if(i.getMission().getVisit_sheet().getVisitPlanned()!=null)
                                           {
                                                %>checked<%
                                                        };%>/>

                                </td><!-- String -->
                                <td>
                                    <input type="checkbox" id="faite" name="faite"
                                            <%if(i.getMission().getVisit_sheet().getVisitDone()!=null)
                                           {
                                                %>checked<%
                                                        };%>/>

                                </td><!-- String -->
                                <td><input type="text" name="Debut" value=" <%out.print(i.getMission().getStartMission());%>" /></td><!-- String -->
                                <td><input type="text" name="Fin" value="<%out.print(i.getMission().getEndMission());%>" /></td><!-- String -->
                                <td><input type="text" name="NomEntreprise" value="" /></td><!-- String -->
                                <td><input type="text" name="Mds" value="" /></td><!-- String -->
                                <td><input type="text" name="Adresse" value="<%out.print(i.getInfo_intern().getAddress());%>" /></td><!-- String -->
                                <td><input type="text" name="NoteTech" value="<%out.print(i.getMission().getEval_sheet().getGradeTech());%>" /></td><!-- String -->
                                <td><input type="text" name="NoteCom" value="<%out.print(i.getMission().getEval_sheet().getGradeCom());%>" /></td><!-- String -->
                                <td><input type="submit" name="submit" value="Valid Edit"/></td>

                                </form>
                                <form name="Actual_intern" method="post" action="ControllerDB">
                                    <input type="hidden" name="Intern" value="i" />
                                    <td><input type="submit" name="detail" value="Detail"/></td>
                                </form>
                            </tr>
                                         <%   }%></br><% 
                                            out.println("FIN, CE PROFESSEUR POSSEDE " + a.getInterns().size() + " ETUDIANTS");

                            %>     

                     <%%>                          
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