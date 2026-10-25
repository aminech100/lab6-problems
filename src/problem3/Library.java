package problem3;

import java.util.ArrayList;

public class Library {
    private int capacity;
    ArrayList<Document> documents;

    public Library(int capacity) {
        this.capacity = capacity;
        this.documents = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public ArrayList<Document> getDocuments() {
        return documents;
    }

    public void displayDocuments(){
        System.out.println("========== Library Documents ==========");
        if (documents.isEmpty()){
            System.out.println("Library is empty");
        } else {
            for (Document d : documents){
                System.out.println(d);
            }
        }
    }

    public boolean add(Document doc) {
        if (documents.size() < capacity && doc != null && !documents.contains(doc)) {
            documents.add(doc);
            doc.setLibrary(this);
            return true;
        }
        return false;
    }

    public boolean delete(Document doc) {

        if (documents.remove(doc)){
            doc.setLibrary(null);
            return true;
        }
        return false;
    }

    public Document document(int numRec) {
        for (Document doc : documents) {
            if (doc.getNumRec() == numRec) {
                return doc;
            }
        }
        return null;
    }

    public void displayAuthors(){
        System.out.println("========== List of Authors ==========");
        boolean authorExists = false;
        for (Document doc : documents){
            if (doc instanceof Book){
                System.out.println("- " + ((Book) doc).getAuthor() + " (Book: " + doc.getTitle() + ")");
                authorExists = true;
            }
        }
        if (!authorExists){
            System.out.println("No authors found in Library");
        }
    }
}
