/*
John Sampson
2-20-2024
COMP 167-004
A BookDatabase class that represents a databse of books,
or in this clase book objects
*/
import  java.util.ArrayList;
public class BookDatabase{
    private ArrayList<Book> books;

    //constructors
    public BookDatabase(){
        this.books = new ArrayList<Book>();
    }
    public BookDatabase(ArrayList<Book> bookList){
        this.books = bookList;
    }

    //mutators
    public void addBook(Book book){
        books.add(book);
    }
    public void removeBook(Book book){
        books.remove(book);
    }

    //search methods
    public ArrayList<Book> search(Author searchAuthor){//searches by author
        ArrayList<Book> booksByAuthor = new ArrayList<Book>();
        for (Book book : this.books){
            if ((book.getAuthor().getFirstName().equalsIgnoreCase(searchAuthor.getFirstName()))&&(book.getAuthor().getLastName().equalsIgnoreCase(searchAuthor.getLastName()))){//equalsIgnoreCase is used to avoid mismatches due to improper capitalization
                booksByAuthor.add(book);
            }
        }
        if (!booksByAuthor.isEmpty()){//if at least one book fits the qualifications
            return booksByAuthor;
        }
        else{//if not, print a message saying so and return null
            System.out.println("There are no books by that searchAuthor in the database.");
            return null;
        }
    }
    public ArrayList<Book> search(int startYear, int endYear){
        ArrayList<Book> booksInRange = new ArrayList<Book>();
        for (Book book : books){
            if ((book.getYearPublished() >= startYear) && (book.getYearPublished() <= endYear)){
                booksInRange.add(book);
            }
        }
        if (!booksInRange.isEmpty()){//if at least one book fits the qualifications
            return booksInRange;
        }
        else {//if not, print a message saying so and return null
            System.out.println("There are no books in that year range");
            return null;
        }
    }
    public ArrayList<Book> search(String bookGenre){
        ArrayList<Book> booksInGenre = new ArrayList<Book>();
        for (Book book : books){
            if ((book.getGenre().equals(bookGenre)) && (book.getGenre().equals(bookGenre))){
                booksInGenre.add(book);
            }
        }
        if (!booksInGenre.isEmpty()){//if at least one book fits the qualifications
            return booksInGenre;
        }
        else{//if not, print a message saying so and return null
            System.out.println("There are no books in that genre in the database.");
            return null;
        }
    }

    public String toString(){//when a BookDatabase object is printed, it instead prints each book in the database individually
        for (Book book : this.books){
            System.out.println(book);
        }
        return null;
    }
}
