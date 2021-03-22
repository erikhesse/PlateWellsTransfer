# PlateWellsTransfer

The Java project was originally developed using JDeveloper v 11.1.2.4.0 with jdk 6 (v1.6.24).

Also tested the application using Visual Studio Code v1.54.1 with AdoptOpenJDK v 11.0.10.9.

The project contains the following files:
Client\Client.jpr		 - java project file
Client\Compounds.xml		 - XML file containing list of compound IDs
Client\Plates.xml		 - XML file containing list of plates with rows and compounds
src\client\CompoundTracking.java 	- class for reading and writting the XML files
src\client\frmAddCompound.java		- class of type JDialog to get selected compound from user 
src\client\frmCreatePlate.java		- class of type JDialog to allow user to create a new plate
src\client\frmMain.java			- class of type JFrame for the main form window of the application
src\client\frmRegisterCompound.java	- class of type JFrame to allow user to register a compound which is saved to the Compounds.xml file
src\client\frmTransferCompound.java	- class of type JDialog to allow user to transfer a compound from a specified well to new plate well locations
src\client\Plate.java			- class Plate definition contains a List of Wells
src\client\PlateWells.java		- class contains void Main, entry point of application
src\client\Well.java			- class Well definition contains the well properties
