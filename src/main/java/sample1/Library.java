package sample1;
import java.util.ArrayList;
import java.util.List;
public class Library {
	
	    private List<Book> books;

	    public Library() {
	        books = new ArrayList<Book>();
	    }

	    public void addBook(Book book) {
	    	books.add(book);
	    }
	    public void listAvailableBooks() {
	    
	    	 System.out.println("Available Books:");
	         for (Book book : books) {
	             if (book.isAvailable()) {
	                 System.out.println(book.getTitle() + " by " + book.getAuthor());
	             }
	         }
	     }
	    

	    public Book findBookByTitle(String title) {
	    	 for (Book book : books) {
	             if (book.getTitle().equalsIgnoreCase(title)) {
	                 return book;
	             }
	         }
	         return null;    
	    }

	    public void updateBookAvailability(int bookId, boolean available) {
	    	   for (Book book : books) {
	               if (book.getId() == bookId) {
	                   book.setAvailable(available);
	                   return;
	               }
	           }
	           System.out.println("Book with ID " + bookId + " not found.");
	    }
	}

