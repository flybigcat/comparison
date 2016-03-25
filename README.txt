Author: Huijuan (Ann) Huang
Time: 02/19、2016

What Is This?
-------------

This is Web Project "Comparison"  
to find out unique records of two uploaded files.

Language and Tools:
Back end: Java (Servlet)
Front end: HTML, CSS, JSP(dynamic Java embedded HTML documents), JavaScript, JQuery
Architecture: MVC
Libraries: JSTL, bootstrap
Server: Tomcat
(IDE: Eclipse)

How does this Application work
-----------------------
1. Under Eclipse IDE, run web application "comparison' on server 
2. choose Tomcat (right version. e.g. Tomcat 7.0) server
3. Application start
4. default web is http://localhost:8080/comparison/


How To Setup Configuration
--------------------------
Here is setup configuration in the Tomcat server built in eclipse IDE
(For Linux Tomcat setup  is https://www.mulesoft.com/tcat/tomcat-on-linux-installation-and-configuration)

1. Java
Download and install the latest Java SE JDK from Sun/Oracle
http://www.oracle.com/technetwork/java/javase/downloads/index.html
Set a JAVA_HOME environment variable to the directory where JDK is installed.

2. Tomcat
Download the latest Tomcat 7 binary release from the Apache Project.
http://tomcat.apache.org/download-70.cgi

Add the JAR files of the following library to the lib folder under the Tomcat directory:
jstl.jar and standard.jar from JSP Standard Tag Library (JSTL).

3. Eclipse
Download Eclipse IDE for Java EE Developers from Eclipse.org
http://www.eclipse.org/downloads/

4. Import project
Eclipse -> File -> Import -> General -> Exiting Projects in to workspace

5. Configure Build Path
Download the following JAR files and save in the directory of comparison/WebContent/WEB-INF/lib
commons-fileupload-1.3.1.jar
commons-io-1.3.2.jar

Configure build path
right click project -> Build Path -> Configure build path -> Libraries

5. Run project on the server
Right click project -> Run As -> Run on Server -> ADD JARS -> 
add commons-fileupload-1.3.1.jar  and commons-io-1.3.2.jar in the library
The two jars are in the WebContent/WEB-INF/lib directory

The first time it runs, the server is needed to be setup by start Tomcat with the right version.

Default website is http://localhost:8080/comparison/ which is home entry page

6. If a different format is used in the input file, modification is only needed for RecordEntry.java.

7. Sample test files are in the comparison/test/ directory 

8. If persistent data storage: database is needed, please refer to scripts file(database creation and table comparison to find out unique records)

9. demo.mp4 is provided as demo
The following link is demo video in the dropbox, please feel free to check it 
https://goo.gl/2Nr4Ns




