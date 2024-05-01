/*
John Sampson
2-20-2024
COMP 167-004
Creating multiple classes to hold the data
of authors, books, and a database of those books
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class clientProgram{
    public static void main(String[] args){
        BookDatabase database = new BookDatabase();
        try {
            File fileIn = new File("dataset.csv");//find the file and store in the File type var
            Scanner scnr = new Scanner(fileIn);
            scnr.nextLine();//skipping the first row
            while (scnr.hasNextLine()){
                scnr.useDelimiter(",");//changing the delimiter to ',' to get the correct values
                String fName = scnr.next();
                String lName = scnr.next();
                fName = fName.substring(1);//the first name has a newline in front of it, so this removes it. this took me an hour
                Author author = new Author(fName, lName);
                String title = scnr.next();
                int year = scnr.nextInt();
                String genre = scnr.next();
                String publisher = scnr.next();
                double rating = scnr.nextDouble();
                scnr.useDelimiter("\n");//sets delimiter back to \n to not get the next first name
                String strPrice = scnr.next();//the next value is not actually a double, it's actually a ',$'
                strPrice = strPrice.substring(2);//this removes those characters
                Scanner getDouble = new Scanner(strPrice);//this allows me to take the double from the string
                double price = getDouble.nextDouble();
                Book book = new Book(author, title, year, publisher, genre, rating, price);//create the book, each of the variable names is the same as the parameter names
                database.addBook(book);//add the book to the database
            }
        }
        catch (FileNotFoundException e) {//in case the file can't be found
            System.out.println("File not found");
        }

        //calling all search methods
        //search by author
        System.out.println("Searching by Author");
        Author searchAuthor = new Author("Bayo","Ogunjimi");
        ArrayList<Book> booksByAuthor = database.search(searchAuthor);
        for (Book books : booksByAuthor){//for each book in the returned database
            System.out.println(books);
        }
        System.out.println();//spacing out the output a bit

        //search by publication year
        System.out.println("Searching by Range of Publication Year");
        int startYear = 2000;
        int endYear = 2010;
        ArrayList<Book> booksInYearRange = database.search(startYear, endYear);
        for (Book books : booksInYearRange){
            System.out.println(books);
        }
        System.out.println();

        //search by genre
        System.out.println("Searching by Genre");
        String bookGenre = " Anthologies";
        ArrayList<Book> booksInGenre = database.search(bookGenre);
        for (Book books : booksInGenre){
            System.out.println(books);
        }
    }
}
