package problem5;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Stack Test ===");
        BookStack bookStack = new BookStack();

        bookStack.push(new Book("The Hobbit", "J.R.R. Tolkien", 1937));
        bookStack.push(new Book("1984", "George Orwell", 1949));
        bookStack.push(new Book("Clean Code", "Robert C. Martin", 2008));

        bookStack.display();

        Book poppedBook = bookStack.pop();
        System.out.println("Popped: " + poppedBook);

        System.out.println("Top: " + bookStack.peek());

        bookStack.display();

        System.out.println("=== Queue Test ===");
        BookQueue bookQueue = new BookQueue();

        bookQueue.enqueue(new Book("The Hobbit", "J.R.R. Tolkien", 1937));
        bookQueue.enqueue(new Book("1984", "George Orwell", 1949));
        bookQueue.enqueue(new Book("Clean Code", "Robert C. Martin", 2008));

        bookQueue.display();

        Book dequeuedBook = bookQueue.dequeue();
        System.out.println("Dequeued: " + dequeuedBook);

        System.out.println("Front: " + bookQueue.peek());

        bookQueue.display();
    }
}
