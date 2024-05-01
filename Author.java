/*
John Sampson
2-22-2024
COMP 167-004
An author class to represent the author of each book
*/
public class Author {
    private String firstName, lastName;

    //constructor
    public Author(){
        this.firstName = "";
        this.lastName = "";
    }
    public Author(String fName, String lName){
        this.firstName = fName;
        this.lastName = lName;
    }



    //accessors
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }

    //mutators
    public void setFirstName(String fName){
        this.firstName = firstName;
    }
    public void setLastName(String lName){
        this.lastName = lastName;
    }

    public String toString(){//modifies the print behavior of an Author object to print the first and last name
        return this.firstName + " " + this.lastName;
    }
}
