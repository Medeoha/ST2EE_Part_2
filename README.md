-Utilisation jdk1.8.0_271 (cette version est indispensable pour IDE et pour GlassFish)
-Utilisation de GlassFish 5.1.0

-Download IDE IntelliJ & Wamp

-Créer la base de donnée sur Wamp (MySQL 5.7.28)

- Copier coller l'integralité du fichier .sql fournit pour creer la database


																				   
-Configurez la connexion de votre serveur MySQL de la facon suivante : 
	-Cliquez sur database à droite de IntelliJ 
	- + -> Data source -> MySQL
	-Name : st2eedb
	-host: localhost port: 3306 (ou celui où votre serveur SQL tourne mais normalement wamp set le port a 3306)
	-User : adm
	-Password: adm
	-Testez la connexion
	-Telechargez le driver necessaire (lastest stable)
	-Retestez la connexion
	-Il est possible que vous ne puissiez pas vous connectez à la databaseà cause d'un probleme de zone horaire, pour regler ce soucis, connectez vous 
	à votre base de donnée a l'aide de phpmyadmin à l'aide wamp en root(username : root,mdp: vide), selectionnez st2eedb , allez sur SQL et 
	rentrez la commande suivante : SET GLOBAL time_zone = '+1:00' puis retentez de vous connecter;	
	-Normalement vous etes connecté a votre database !
	
-Configurez votre serveur GlassFish de la facon suivante :
    -Edit configuration -> + -> glassfish -> local
	-Name (onglet server) : GlassFish 5.1.0
	-Application server (onglet server) : recherchezle chemin vers l'endroit où vous avez installé votre glassfish sur votre ordinateur
	-URL (onglet Server)  : http://localhost:8080/Controller
	-JRE (onglet Server) : Utilisez si il n'est pas par défaut le JAVA 1.8.0_271 
	-Server Domain (ongler Server) : domain1
	-Username (onglet server) : retirez e user name qui est laissé par défaut et laisser l'espace blanc
	-Deploy at the server startup (onglet Deployment) : + -> Artifacts -> ProjetSoloA8:war
	-Apply
	
-Pour lancer le projet
	- Ouvrir projet 
	- Selectionnez le projet 
	
	
	Vous pouvez normalement lancer le projet !

