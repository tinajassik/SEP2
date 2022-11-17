package shared;

public class Author {
    private String fname;
    private String lname;

    private int id;

    public Author(String fname, String lname, int id){
        this.fname = fname;
        this.lname = lname;
        this.id = id;
    }
    public String toString(){
        return "Author name: " + fname + " " + lname + "\n";
    }

    public int getId() {
        return id;
    }

}
