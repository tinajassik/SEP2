package shared;

import java.io.Serializable;

public class Author implements Serializable {
    private String fname;
    private String lname;

    private int id;

    public Author(String fname, String lname, int id){
        this.fname = fname;
        this.lname = lname;
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String toString() {
        return fname + " " + lname;
    }
}
