package subbusinesstier;

import java.util.ArrayList;
import java.util.List;
import subbusinesstier.entities.BookTitle;

public class Facade {

    List< BookTitle> bookTitles;

    public Facade() { //1-a iteracja
        bookTitles = new ArrayList<>();
    }

    public List<BookTitle> getBookTitles() { //1-a iteracja
        return bookTitles;
    }

    void setBookTitles(List<BookTitle> booktitles) { //1-a iteracja
        bookTitles = booktitles;
    }

    public BookTitle findBookTitle(BookTitle booktitle) { //1-a iteracja
        int idx;
        if ((idx = bookTitles.indexOf(booktitle)) != -1) {
            booktitle = bookTitles.get(idx);
            return booktitle;
        }
        return null;
    }

    public String addBookTitle(String data[]) { //1-a iteracja
        Factory factory = new Factory();
        BookTitle newbooktitle = factory.createBookTitle(data);
        BookTitle result = findBookTitle(newbooktitle);
        if (result == null) {
            bookTitles.add(newbooktitle);
            String info = newbooktitle.toString();
            return info;
        }
        return null;
    }

    public ArrayList<String> addBook(String data1[], String data2[]) { //2-a iteracja
        BookTitle booktitleexist, searchpattern;
        Factory fabryka = new Factory();
        searchpattern = fabryka.createBookTitle(data1);
        if ((booktitleexist = findBookTitle(searchpattern)) != null) {
            return booktitleexist.addBook(data2);
        }
        return null;
    }

    /* 
    public ArrayList<String> searchBookTitle(String data[]) { //kolejne iteracje
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    public String searchAccessibleBook(String data1[], Object data2) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public Object[][] getDataOfBookTitles() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void printBooks() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void printBookTitles() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    */
    
    public static void main(String t[]) {
        Facade ap = new Facade();
        String t1[] = {"1", "Author1", "Title1", "ISBN1", "Publisher1"}; //1-a iteracja
        String t2[] = {"1", "Author2", "Title2", "ISBN2", "Publisher2"}; //1-a iteracja
        String t3[] = {"1", "Author3", "Title3", "ISBN3", "Publisher3"}; //1-a iteracja
        ap.addBookTitle(t1); //1-a iteracja
        ap.addBookTitle(t2); //1-a iteracja
        ap.addBookTitle(t2); //1-a iteracja
        ap.addBookTitle(t3); //1-a iteracja
        String lan = ap.getBookTitles().toString(); //1-a iteracja
        System.out.println(lan); //1-a iteracja
        String d1[] = {"0", "ISBN1"}; //2-a iteracja
        String d2[] = {"0", "ISBN2"}; //2-a iteracja
        String d3[] = {"0", "ISBN5"}; //2-a iteracja
        String tr1[] = {"0", "1"}; //2-a iteracja
        String tr2[] = {"0", "2"}; //2-a iteracja
        ArrayList<String> pom = ap.addBook(d1, tr1); //2-a iteracja
        if (pom != null) { //2-a iteracja
            System.out.print(pom);
        } //2-a iteracja
        pom = ap.addBook(d2, tr1); //2-a iteracja
        if (pom != null) { //2-a iteracja
            System.out.print(pom);
        } //2-a iteracja
        pom = ap.addBook(d2, tr1); //2-a iteracja
        if (pom != null) { //2-a iteracja
            System.out.print(pom);
        } //2-a iteracja
        pom = ap.addBook(d2, tr2); //2-a iteracja
        if (pom != null) { //2-a iteracja
            System.out.print(pom);
        } //2-a iteracja
        pom = ap.addBook(d3, tr2); //2-a iteracja
        if (pom != null) { //2-a iteracja
            System.out.print(pom);
        } //2-a iteracja
        System.out.println(); //2-a iteracja
    } //1-a iteracja
}
