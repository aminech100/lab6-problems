package problem5;

import java.util.LinkedList;

public class BookStack {
    private LinkedList<Book> stack;

    public BookStack() {
        this.stack = new LinkedList<>();
    }

    public void push(Book book) {
        stack.addFirst(book);
    }

    public Book pop() {
        // code here and don't to test if it's empty
        return stack.removeFirst();
    }

    public Book peek() {
        // code here and don't to test if it's empty
        return stack.removeFirst();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void display() {
        System.out.println("Stack contents (top to bottom):");
        for (Book b : stack) {
            System.out.println("- " + b);
        }
    }
}

