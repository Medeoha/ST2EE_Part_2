-Using jdk1.8.0_271 (this version is required for IDE and GlassFish)
-Using GlassFish 5.1.0

-Download IntelliJ IDE & Wamp 

-Create the database on Wamp (MySQL 5.7.28)

- Copy and paste the entire .sql file provided to create the database. 

		/!\ BE CAREFUL, THIS IS NOT THE SAME DATABASE AS VERSION 1 /!\
		/!\If a user is already named "adm" you may have to delete this user and restart the database script./!\


																				   
-Configure the connection of your MySQL server in the following way: 
	-Click on database to the right of IntelliJ 
	- + -> Data source -> MySQL
	-Name : st2eedb
	-host: localhost port: 3306 (or the one where your SQL server is running but normally wamp set port a 3306)
	-User: adm
	-Password: adm
	-Test the connection
	-Download the necessary driver (lastest stable)
	-Retest the connection
	-It is possible that you cannot connect to the database because of a time zone problem, to solve this problem, please log in. 
	to your database using phpmyadmin using wamp as root(username : root,mdp: empty), select st2eedb , go to SQL and 
	enter the following command: SET GLOBAL time_zone = '+1:00' then try to connect again;	
	-Normally you are connected to your database !
	
-Configure your GlassFish server in the following way:
    -Edit configuration -> + -> glassfish -> local
	-Name (server tab): GlassFish 5.1.0
	-Application server (server tab) : find the path to the place where you installed your glassfish on your computer
	-URL (Server tab): http://localhost:8080/Controller
	-JRE (Server tab): Use if it is not by default the JAVA 1.8.0_271 
	-Server Domain (ongler Server): domain1
	-Username (server tab): remove the user name which is left by default and leave the space blank.
	-Deploy at the server startup (Deployment tab): + -> Artifacts -> ProjectSoloA8:war
	-Check use custom context, remove the "/" and leave the location empty (Deployment tab)
	-Apply
	
-To launch the project
	- Open project 
	- Select the project 
	
	
	You can normally start the project!
	There are several teacher accounts, 
the first one:
       username: adm
       password: adm
has a student 

the 2 others 
   username: 123
   password: 123
and
   username: azerty
   password: azerty
do not have a student.

It is possible to search by last name, first name, commentaries and YEAR of beginning of the internship.

/!\ WARNING /!\
It is possible to add a student, but due to a refresh problem,
you have to restart the project after adding one or more students to see them displayed and be able to modify them.
/!\ WARNING /!\

 
 





