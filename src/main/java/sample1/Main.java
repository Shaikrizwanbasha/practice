package sample1;

import java.util.Scanner;

public class Main {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        Library library = new Library();

	        library.addBook(new Book(1,"Energize Your Mind","Gaur Gopal Das","8688217677",true));
	        library.addBook(new Book(2, "Lifes amazing secrates", "Gaur Gopal das","9963391656", true));
	        library.addBook(new Book(3, "Some Thing I Never Told You","Pengvin", "1238568521", true));
	        library.addBook(new Book(4, "The Train", "comic book", "852214589", true));
	        System.out.println("Welcome to the Library Management System!");

	        while (true) {
	            System.out.println("\nSelect an option:");
	            System.out.println("1. List available books");
	            System.out.println("2. Borrow a book");
	            System.out.println("3. Return a book");
	            System.out.println("4. Exit");

	            int choice = scanner.nextInt();
	            scanner.nextLine(); 

	            Book bookToReturn;
				switch (choice) {
	                case 1:
	                    library.listAvailableBooks();
	                    break;
	                case 2:
	                	// borrowing the book
	                    System.out.print("Enter your name: ");
	                    String patronName = scanner.nextLine();
	                    System.out.print("Enter book title to borrow: ");
	                    String bookTitle = scanner.nextLine().toLowerCase();// convert to lowercase
	                    bookTitle =bookTitle.substring(0,1).toUpperCase()+bookTitle.substring(1);

	                    Patron patron = new Patron(patronName.hashCode(), patronName);
	                    Book bookToBorrow = library.findBookByTitle(bookTitle);

	                    if (bookToBorrow != null) {
	                        patron.borrowBook(bookToBorrow);
	                    } else {
	                        System.out.println("Book not found.");
	                    }
	                    break;
	                case 3:
	                	// Returning a book
	                	System.out.print("Enter your name: ");
	                	patronName = scanner.nextLine();
	                	System.out.print("Enter book title to return: ");
	                	String inputBookTitle = scanner.nextLine().toLowerCase(); // Convert to lowercase
	                	String formattedBookTitle = inputBookTitle.substring(0, 1).toUpperCase() + inputBookTitle.substring(1); // Convert the first character to uppercase

	                	System.out.println("Input Title: " + inputBookTitle);
	                	System.out.println("Formatted Title: " + formattedBookTitle);

	                	bookToReturn = library.findBookByTitle(formattedBookTitle);
	                	if (bookToReturn != null) {
	                	    Patron.returnBook(bookToReturn);
	                	    System.out.println("Book returned in Library");
	                	} else {
	                	    System.out.println("Book not found.");
	                	}

	                    break;
	                case 4:
	                    System.out.println("Thank you for using the Library Management System!");
	                    return;
	                default:
	                    System.out.println("Invalid choice. Please select a valid option.");
	            }
	        }
	    }
	}

