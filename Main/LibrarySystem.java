import java.util.Scanner;
package Main;

public class LibrarySystem {
    private LibraryCatalog catalog;
    private Scanner scanner;

    public LibrarySystem() {
        catalog = new LibraryCatalog();
        scanner = new Scanner(System.in);
    }

    public void addBook() {
        System.out.print("Enter Book ID: ");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Book Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Book Genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter Availability Status (Available/Checked Out): ");
        String availabilityStatus = scanner.nextLine();

        Book book = new Book(bookId, title, author, genre, availabilityStatus);
        if (catalog.addBook(book)) {
            System.out.println("Book added successfully.");
        } else {
            System.out.println("Failed to add book. The Book ID must be unique.");
        }
    }

    public void viewAllBooks() {
        catalog.viewAllBooks();
    }

    public void searchBook() {
        System.out.print("Enter Book ID or Title to search: ");
        String keyword = scanner.nextLine();
        Book book = catalog.searchBook(keyword);
        if (book != null) {
            System.out.println("Book found: " + book);
        } else {
            System.out.println("No book found with that ID or Title.");
        }
    }

    public void updateBook() {
        System.out.print("Enter Book ID to update: ");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new Title (leave blank to skip): ");
        String title = scanner.nextLine();
        System.out.print("Enter new Author (leave blank to skip): ");
        String author = scanner.nextLine();
        System.out.print("Enter new Availability Status (Available/Checked Out, leave blank to skip): ");
        String availabilityStatus = scanner.nextLine();

        if (catalog.updateBook(bookId, title, author, availabilityStatus)) {
            System.out.println("Book details updated successfully.");
        } else {
            System.out.println("No book found with that ID.");
        }
    }

    public void deleteBook() {
        System.out.print("Enter Book ID to delete: ");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        if (catalog.deleteBook(bookId)) {
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("No book found with that ID.");
        }
    }

    public void showMenu() {
        System.out.println("\nLibrary Management System Menu");
        System.out.println("1. Add a Book");
        System.out.println("2. View All Books");
        System.out.println("3. Search a Book");
        System.out.println("4. Update Book Details");
        System.out.println("5. Delete a Book");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    public void start() {
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewAllBooks();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    updateBook();
                    break;
                case 5:
                    deleteBook();
                    break;
                case 6:
                    System.out.println("Exiting system...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
