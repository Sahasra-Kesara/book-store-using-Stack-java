class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

// Custom Stack class
class CustomStack {
    private Node top;

    public CustomStack() {
        top = null;
    }

    // Push a new book onto the stack
    public void push(String book) {
        Node newNode = new Node(book);
        newNode.next = top;
        top = newNode;
    }

    // Pop a book from the stack
    public String pop() {
        if (isEmpty()) {
            System.out.println("No books available to borrow.");
            return null;
        } else {
            String book = top.data;
            top = top.next;
            return book;
        }
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // View all books in the stack
    public void viewAll() {
        if (isEmpty()) {
            System.out.println("No books in the store.");
        } else {
            Node current = top;
            System.out.println("Books in the store:");
            while (current != null) {
                System.out.println(current.data);
                current = current.next;
            }
        }
    }
}

// Bookstore class using the CustomStack
public class Bookstore {
    private CustomStack bookStack;

    public Bookstore() {
        bookStack = new CustomStack();
    }

    // Add a new book
    public void addBook(String book) {
        bookStack.push(book);
        System.out.println(book + " added to the stack.");
    }

    // Borrow (remove) a book
    public String borrowBook() {
        String book = bookStack.pop();
        if (book != null) {
            System.out.println(book + " borrowed from the stack.");
        }
        return book;
    }

    // View all books
    public void viewAllBooks() {
        bookStack.viewAll();
    }

    public static void main(String[] args) {
        Bookstore bookstore = new Bookstore();

        // Add some books
        bookstore.addBook("Harry Potter");
        bookstore.addBook("Lord of the Rings");
        bookstore.addBook("Game of Thrones");

        // View all books
        bookstore.viewAllBooks();

        // Borrow a book
        bookstore.borrowBook();

        // View all books after borrowing one
        bookstore.viewAllBooks();
    }
}