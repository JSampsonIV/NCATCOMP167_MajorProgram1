/*
John Sampson
2-22-2024
COMP 167-004
A book class to hold all the information related to a book,
including the author, title, genre, and price
*/
public class Book {
    private Author author;
    private String title, publisher, genre;//variables of the same type have been declared...
    private int yearPublished;
    private double rating, price;//...on the same line to save space

    //constructors
    public Book(){
        this.author = new Author();
        this.title = "";
        this.yearPublished = 0;
        this.genre = "";
        this.rating = 0.0;
        this.price = 0.0;
    }
    public Book(Author bookAuthor, String bookTitle, int year, String publish, String bookGenre, double bookRating, double bookPrice){
        this.author = bookAuthor;
        this.title = bookTitle;
        this.yearPublished = year;
        this.publisher = publish;
        this.genre = bookGenre;
        this.rating = bookRating;
        this.price = bookPrice;
    }

    //accessors
    public Author getAuthor(){
        return author;
    }
    public String getTitle(){
        return this.title;
    }
    public int getYearPublished(){
        return this.yearPublished;
    }
    public String getPublisher(){
        return publisher;
    }
    public String getGenre(){
        return genre;
    }
    public double getRating(){
        return rating;
    }
    public double getPrice(){
        return price;
    }

    //mutators
    public void setTitle(String bookTitle){
        this.title = bookTitle;
    }
    public void setYearPublished(int yearPublished){
        this.yearPublished = yearPublished;
    }
    public void setPublisher(String publisher){
        this.publisher = publisher;
    }
    public void setGenre(String genre){
        this.genre = genre;
    }
    public void setRating(double rating){
        this.rating = rating;
    }
    public void setPrice(double price){
        this.price = price;
    }

    public String toString(){//modifies the print behavior of a Book object to print a descriptive list of the book's information
        System.out.println("Author: " + this.author);
        return "Title: " + this.title + "\n" +
                "Published " + this.yearPublished + " by " + this.publisher + "\n" +
                "Genre: " + this.genre + "\n" +
                "Rating: " + this.rating + "\n" +
                "Price: $" + this.price;
    }
}
