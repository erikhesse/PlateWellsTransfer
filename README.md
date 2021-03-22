# PlateWellsTransfer

The Java project was originally developed using JDeveloper v 11.1.2.4.0 with jdk 6 (v1.6.24).

Also tested the application using Visual Studio Code v1.54.1 with AdoptOpenJDK v 11.0.10.9.

The project contains the following files:<br />
<strong>Client\Client.jpr</strong>		 - java project file<br />
<strong>Client\Compounds.xml</strong>		 - XML file containing list of compound IDs<br />
<strong>Client\Plates.xml</strong>		 - XML file containing list of plates with rows and compounds<br />
<strong>src\client\CompoundTracking.java</strong> 	- class for reading and writting the XML files<br />
<strong>src\client\frmAddCompound.java</strong>		- class of type JDialog to get selected compound from user<br /> 
<strong>src\client\frmCreatePlate.java</strong>		- class of type JDialog to allow user to create a new plate<br />
<strong>src\client\frmMain.java</strong>			- class of type JFrame for the main form window of the application<br />
<strong>src\client\frmRegisterCompound.java</strong>	- class of type JFrame to allow user to register a compound which is saved to the Compounds.xml file<br />
<strong>src\client\frmTransferCompound.java</strong>	- class of type JDialog to allow user to transfer a compound from a specified well to new plate well locations<br />
<strong>src\client\Plate.java</strong>			- class Plate definition contains a List of Wells<br />
<strong>src\client\PlateWells.java</strong>		- class contains void Main, entry point of application<br />
<strong>src\client\Well.java</strong>			- class Well definition contains the well properties<br />
