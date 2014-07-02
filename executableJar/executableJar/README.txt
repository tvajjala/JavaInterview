CREATING EXECUTABLE JAR
============================================
1. create manifest.txt file add main class name (fully qualified class name)
	Main-Class: com.innominds.test.Broadcaster
IMP: PRESS ENTER AFTER CLASSNAME WITHOUT ANY SPACES 
2. place the all the classes and resources into one empty folder along with above manifest.txt file

3. run below command from CMD to create Executable Jar
	jar cfvm multicastclient.jar manifest.txt ./*
4. view the console which traces the added files into jar
5. to test the executable jar file run below command
	java -jar multicastclient.jar