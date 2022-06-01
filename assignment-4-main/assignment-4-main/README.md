# Assignment 4

## Implementation 
The Main class first gives options to the user to enter number from one to three:
```java
System.out.println("{1} LIST ALL MEMBERS");
System.out.println("{2} ADD NEW MEMBER");
System.out.println("{3} ENTER ID TO SELECT A MEMBER");
```
There are three main methods to handle these options Except the 1st option which only lists the members, the other two options above gives also other sub-options to the user such as in the 2nd option it gives the following alternative also:
```java
System.out.print("  ENTER NAME MEMBER:  ");
System.out.print("  OPTIONAL: ENTER EMAIL OR Y TO CONTINUE: "); 
```
and if the user press 3 from the options above, the following options appear:
```java
System.out.println("{1} DELETE A MEMBER");
System.out.println("{2} ADD A BOAT BELONGS TO THE SELECTED MEMBER");
System.out.println("{3} SELECT A BOAT");
```
The FileHandling class contains two major methods that handle the reading and writing to manuplate the registery file that is input and output data. The relation between FileHandling and Boatclub Main is like the following the BoatclubMain contains the constructor for Filehandling and 
```java
    FileHandling filehandle = new FileHandling(); // FileHandling Constructor

    filehandle.writeInTheRegisteryFile(ui.getMembers()); // it saves in the file while done
```

The HandlingUi class holds the methods such as showMembers, On top of that there are two methods to check if the the members ID and email are unique and one more method to genarate Alphnumeric ID. The BoatclubMain also contains the the constructor below to set and get data from FileHandling by using the methods which exist in Handlingui shuch as showAllMembers, setNewMembers and selectMemberById.
```java
    Handlingui ui = new Handlingui(filehandle.getMembers()); // HandlingUi Constructor
```
The Boat class has the common attributes of all types boat and get inherited by which is one of the four object oriented pillars.
The Member class has three attributes (id, name and email) and boat arraylist to keep the boats he/she owns.

## Class Diagram
The diagram represent the implentation, the relation between the "Boat" and the four typ of boats is inheritance relation. 
The program contains nine classes which are the four types of boats that are inherited from the "Boat" and the boat has two more relation, one with the "member" who owns it and second with "handlingUi" (user interface) which holds multiple methods such as showMembers, methods to chek if the the members ID and email are unique. The relation between the boat and member is composition because the boat can not belong to a member if the member is disappeared so it is fully dependent on the members existence. The "handlingUi" user interface has aggregation relation with the boat and member, because it is not fully dependent on the Boat class beacuse the "handlingUi" user interface can still exist by just relating to the "member" class with having similare relation (aggregation).

The BoatClubMain class is that holds the main class to run the code, fully dependent on the "fileHandling" and "handlingUi" classes. because the main class can not be independent without relating to the hadlingUi which most of the methods are kept in and be access on th emain class. The same with file Handling class which contains the reading and writing file class to input and output the data.  

