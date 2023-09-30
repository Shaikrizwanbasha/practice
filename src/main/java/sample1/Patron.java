package sample1;



	import java.util.ArrayList;
	import java.util.List;

	public class Patron {
	    private int cardNumber;
	    private static String name;
	    private static  List<Book> borrowedBooks;

	    public Patron(int cardNumber, String name) {
	        this.cardNumber = cardNumber;
	        this.name = name;
	        borrowedBooks = new ArrayList<Book>();
	    }

	    public int getCardNumber() {
	        return cardNumber;
	    }

	    public String getName() {
	        return name;
	    }

	    public static List<Book> getBorrowedBooks() {
	        return borrowedBooks;
	    }

	    public void borrowBook(Book book) {
	        if (book.isAvailable()) {
	            borrowedBooks.add(book);
	            book.setAvailable(true);
	            System.out.println(name + " has borrowed the book: " + book.getTitle());
	        } else {
	            System.out.println("The book is not available for borrowing.");
	        }
	    }

	    public static void returnBook(Book book) {
	        if (borrowedBooks.contains(book)) {
	            borrowedBooks.remove(book);
	            book.setAvailable(true); // Corrected line
	            System.out.println(name + " has returned the book: " + book.getTitle()); // Use getTitle() instead of getAuthor()
	        } else {
	            System.out.println(name + " did not borrow this book.");
	        }
	    }

	    }

