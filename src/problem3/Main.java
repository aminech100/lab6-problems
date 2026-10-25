package problem3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the capacity (n) of the library: ");
        int capacity = scanner.nextInt();
        scanner.nextLine();

        Library library = new Library(capacity);

        Book defaultBook = new Book("Effective Java", "Joshua Bloch", 416);
        Dictionary defaultDict = new Dictionary("Oxford English Dictionary", "English");

        library.add(defaultBook);
        library.add(defaultDict);

        int choice;
        do {
            System.out.println("\n========== LIBRARY MENU ==========");
            System.out.println("1. Display all documents");
            System.out.println("2. Add a document");
            System.out.println("3. Delete a document");
            System.out.println("4. Search document by record number");
            System.out.println("5. Display authors");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    library.displayDocuments();
                    break;
                case 2:
                    if (library.getDocuments().size() >= library.getCapacity()) {
                        System.out.println("Library is full!");
                        break;
                    }
                    System.out.println("Select document type:");
                    System.out.println("1. Book");
                    System.out.println("2. Magazine");
                    System.out.println("3. Dictionary");
                    System.out.println("4. Novel");
                    System.out.println("5. Textbook");
                    System.out.print("Choice: ");
                    int type = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();

                    Document newDoc = null;
                    switch (type) {
                        case 1:
                            System.out.print("Enter author: ");
                            String author = scanner.nextLine();
                            System.out.print("Enter number of pages: ");
                            int pages = scanner.nextInt();
                            newDoc = new Book(title, author, pages);
                            break;
                        case 2:
                            System.out.print("Enter month: ");
                            String month = scanner.nextLine();
                            System.out.print("Enter year: ");
                            int year = scanner.nextInt();
                            newDoc = new Magazine(title, month, year);
                            break;
                        case 3:
                            System.out.print("Enter language: ");
                            String lang = scanner.nextLine();
                            newDoc = new Dictionary(title, lang);
                            break;
                        case 4:
                            System.out.print("Enter author: ");
                            String nAuthor = scanner.nextLine();
                            System.out.print("Enter number of pages: ");
                            int nPages = scanner.nextInt();
                            System.out.print("Enter price: ");
                            double price = scanner.nextDouble();
                            newDoc = new Novel(title, nAuthor, nPages, price);
                            break;
                        case 5:
                            System.out.print("Enter author: ");
                            String tAuthor = scanner.nextLine();
                            System.out.print("Enter number of pages: ");
                            int tPages = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Enter level: ");
                            String level = scanner.nextLine();
                            newDoc = new Textbook(title, tAuthor, tPages, level);
                            break;
                        default:
                            System.out.println("Invalid type!");
                    }

                    if (newDoc != null) {
                        if (library.add(newDoc)) {
                            System.out.println("Document added successfully!");
                        } else {
                            System.out.println("Failed to add document.");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter record number (numRec) to delete: ");
                    int recNum = scanner.nextInt();
                    Document docToDelete = library.document(recNum);
                    if (docToDelete != null) {
                        library.delete(docToDelete);
                        System.out.println("Document deleted successfully!");
                    } else {
                        System.out.println("Document not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter record number (numRec) to search: ");
                    int searchNum = scanner.nextInt();
                    Document found = library.document(searchNum);
                    if (found != null) {
                        System.out.println("Found: " + found);
                    } else {
                        System.out.println("Document not found.");
                    }
                    break;

                case 5:
                    library.displayAuthors();
                    break;

                case 6:
                    System.out.println("Exiting application. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
