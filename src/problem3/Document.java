package problem3;

public class Document {
    static int counter = 1;
    protected int numRec;
    protected String title;
    protected Library library;

    public Document(String title) {
        this.title = title;
        this.numRec = counter ++;
    }

    public int getNumRec() {
        return numRec;
    }

    public String getTitle() {
        return title;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    @Override
    public String toString(){
        return "Document [Record Number: " + numRec + ", Title: " + title + "]";
    }

}
