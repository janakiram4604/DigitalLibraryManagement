package Main;

import java.util.*;

public class LibraryCatalog {
    private List<Book> books;

    public LibraryCatalog() {
        this.books = new ArrayList<>(); // Using ArrayList for temporary storage
    }

    // Add a book to the collection
    public boolean addBook(Book book) {
        // Ensure that the Book ID is unique
        for (Book b : books) {
            if (b.getBookId() == book.getBookId()) {
                System.out.println("Error: A book with this Book ID already exists.");
                return false; // Book ID already exists, return false
            }
        }
        books.add(book);
        return true; // Book added successfully
    }

    // View all books in the collection
    public void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    // Search a book by ID or Title
    public Book searchBook(String keyword) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(keyword) || String.valueOf(book.getBookId()).equals(keyword)) {
                return book;
            }
        }
        return null;
    }

    // Update book details (e.g., Availability Status, Title, Author)
    public boolean updateBook(int bookId, String title, String author, String availabilityStatus) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                if (title != null && !title.isEmpty())
                    book.setAvailabilityStatus(availabilityStatus);
                if (author != null && !author.isEmpty())
                    book.setAvailabilityStatus(availabilityStatus);
                return true;
            }
        }
        return false;
    }

    // Remove a book from the catalog
    public boolean deleteBook(int bookId) {
        return books.removeIf(book -> book.getBookId() == bookId);
    }
}
