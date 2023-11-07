
import java.util.ArrayList;
import java.util.List;


class Book {
    private String title;
    private String author;
    private int bookId;

    public Book(String title, String author, int bookId) {
        this.title = title;
        this.author = author;
        this.bookId = bookId;
    }

    public int getBookId() {
        return bookId;
    }

    public String toString() {
        return "Book ID: " + bookId + "\nTitle: " + title + "\nAuthor: " + author;
    }
}

class User {
    private String username;
    private List<Book> borrowedBooks;

    public User(String username) {
        this.username = username;
        borrowedBooks = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }
}

class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            boolean isBorrowed = false;
            for (User user : users) {
                if (user.getBorrowedBooks().contains(book)) {
                    isBorrowed = true;
                    break;
                }
            }
            if (!isBorrowed) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }
}



public class DigitalLibraryManagement {
    
    public static void main(String[] args) {
        Library library = new Library();

       
        library.addBook(new Book("Book 1", "Author 1", 1));
        library.addBook(new Book("Book 2", "Author 2", 2));
        library.addBook(new Book("Book 3", "Author 3", 3));

        
        User user1 = new User("User1");
        User user2 = new User("User2");

        library.addUser(user1);
        library.addUser(user2);

       
        List<Book> availableBooks = library.getAvailableBooks();
        if (!availableBooks.isEmpty()) {
            Book bookToBorrow = availableBooks.get(0);
            user1.borrowBook(bookToBorrow);
        }

        System.out.println("User 1's borrowed books:");
        for (Book book : user1.getBorrowedBooks()) {
            System.out.println(book);
        }

        System.out.println("\nAvailable books in the library:");
        for (Book book : library.getAvailableBooks()) {
            System.out.println(book);
        }
    }
}

