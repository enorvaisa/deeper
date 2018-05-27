APPLICATION PURPOSE:

Application is able to handle two requests.
One public endpoint (/getIntersectionPoints) accepts as an input information about a square and a line and returns information where and if these two objects intersect
Second endpoint(/getCurrentRequests) is protected with username/password and returns information about how many requests are currently beying processed by the application.

ARCHITECTURAL OVERVIEW AND LIBRARIES USED:

For main application core was chosen SpringBoot as it is simple and reliable all in one solution which has Spring, REST controllers and embedded application server.
For mathematical calculations was used JTS Topology Suite, Java library for creating and manipulating vector geometry as it has convenient methods for this specific task.
For some multi threaded tests TestNG library was used.

INSTRUCTIONS HOW TO LAUNCH AND TEST APPLICATION:

Java version 1.8 and Maven must be installed to launch this application.

Steps to run application:
- Open command line tool and navigate to root folder (where pom.xml is located)
- enter "mvn spring-boot:run" and press enter
- wait while application starts at http://localhost:8080

Example how to test square and line intersection REST service:
http://localhost:8080/getIntersectionPoints?sp1x=0&sp1y=0&sp2x=0&sp2y=10&sp3x=10&sp3y=10&sp4x=10&sp4y=0&lp1x=5&lp1y=-1&lp2x=5&lp2y=11

sp1x=0&sp1y=0&sp2x=0&sp2y=10&sp3x=10&sp3y=10&sp4x=10&sp4y=0 - 4 square points with x,y coordinates
lp1x=5&lp1y=-1&lp2x=5&lp2y=11 - 2 line points with x,y coordinates

Example how to test current requests REST service:
http://localhost:8080/getCurrentRequests (username/password is deeper/deeper)


You can also run application tests with command "mvn test" (note application must be stopped as tests also start application on same port)