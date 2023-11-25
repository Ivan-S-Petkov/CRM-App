# CRM System
## _Project Overview:_

This is Java-based, console application. It implements the main OOP principles in order to create a Client Relationship Management System. The system enables users to manage client information for a business.

### Key Functions
The user could pick between the following options:
- List all companies
- Add company
- Edit company
- Search company by Industry
- Search company by Id
- Search company by Name
- Remove company
- Save data to CSV or JSON file

### Structure
#### Data Package
The data package contains three classes - Reader, Writer and Constants and takes care of the file management.
 - Constant class implements main variables for file names and locations.
 - Reader class implements methods to read from CSV or JSON file.
 - Writer class implements methods to write to CSV or JSON file.
 
#### UI Package
Its purpose is to take care of user itterations both displaying messages and reading and validating user inputs.
 - Menu class contains basic console messages that should be displayed to the user.
 - InputService is taking care of all user inputs using the System.in Scanner.
 - InputValidationService implement boolean methods that return if the user input is valid.

#### Utils Package
At the moment it includes only the ValidationUtils class. It includes basic validation whether the input is integer, positive integer, double, positive double or empty strings.

#### Models Package
It includes Company class that holds the basic company model. The @JsonProperty have been added for all attributes which are used for annotating the JSON File. The method toString is used in the CSV Writer method as converts the class attributes to comma separated string.

#### Services Package
This package implements two interfaces: Manager and Service along with ClientManager, ClientService and Config class.
- The Config class is responsible for switching between CSV and JSON data read/write by changing the FILE_TYPE value.
- ClientService class implements the Service interface. It contains the a Map of companies and implements the methods to add, edit, list, searchBy /Id, Name, Industry/. The load and save methods are responsible for file data handling /read and write/. The method getIndustries returns a set of industries which are later on show to the user as suggestion list when he triggers the command "4 - Search by Industry" command.
- ClientManger class is the engine of the application. Switch statement routes the user's command and triggers further readings on user input, validations and data manipulations. When adding new company to the records, the application takes care of getting the next ID, so it should not be supplied.

### Input Test Data
Below are some records that could be used while testing the application:\
\
Tazzy,Real Estate Investment Trusts,Faustina Ervin,87949.47\
Flashspan,n/a,Othello Larratt,50930.39\
Abata,Trucking Freight/Courier Services,Merrill Janczyk,51940.73\
Trilith,Computer Software: Prepackaged Software,Billie Coenraets,87335.62\
Cogidoo,n/a,Wilt Clive,39480.53\
Rhynoodle,Savings Institutions,Reynolds Glander,8737.92\
Quimm,n/a,Sarette Willimot,43291.53\
Edgetag,Major Banks,Bettina Alcalde,67840.8\
Buzzdog,Investment Managers,Hastie Shotboult,39427.3\
Yakidoo,n/a,Patrice McCaster,90548.02\




