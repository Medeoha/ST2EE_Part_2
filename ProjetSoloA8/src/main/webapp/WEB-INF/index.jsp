<%-- 
<%-- 
    Document   : index
    Created on : 22 nov. 2020, 14:11:31
    Author     : narut
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">

<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="content-language" content="fr-FR"/>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../style.css">
    <title>Efrei Paris - Connexion</title>
</head>

<body style="overflow: hidden;" >
    <div class="login-page" >
        <div class="middle">
            <div class="login-container_me the-containers">
                <div class="header_me">
                    <img src="../efrei-paris_110x40.png" alt="Efrei Paris" class="app-logo_me"/>
                    <h2>Connexion</h2>
                </div>
                <br>
                <form class="login-form_me" id="login-form_me"  action="Controller" method="post" accept-charset="UTF-8" novalidate>
                    <div class="form-group">
                        <label class="control-label me" for="username">Identifiant</label>
                        <input id="username" type="text" name="loginForm" class="form-control" required/>
                    </div>
                    <br></br>
                    <div class="form-group">
                        <label class="control-label me" for="password">Mot de passe</label>
                        <input id="password" type="password" name="pwdForm" class="form-control" required/>
                    </div>
                    <div class="footer">
                        <br></br>
                        <% if(request.getAttribute("errMsg") != null)
                        {%>

                           <label>Identifiant ou mot de passe incorrect.</label>

                        <% } %>
                        <button type="submit" class="btn-submit_me">
                            Connexion
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>




</html>



