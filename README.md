Lift---Drag-Workflow
====================

Project of the module of Applications in High End Computing

In order to run the program we will need to execute the database server first.
This can be easily done executing the runAerofoil.sh or runAerofoil.bat scripts for unix/windows systems.

After this we will have to connect the database with the program. We can do it following the next instructions:

1- In Netbeans go to "Window" -> "Services"

2- Click on "Databases" and check if "jdbc:hsqldb:hsql://localhost/aerofoil [ on PUBLIC]" exists. If not you can add it following the tutorial in this link:
http://wiki.netbeans.org/HSQLDBenNetBeans

3- Right click on "jdbc:hsqldb:hsql://localhost/aerofoil [ on PUBLIC]" and then "Connect". When it asks for username and password just click "OK"

4- Now you can run the code
