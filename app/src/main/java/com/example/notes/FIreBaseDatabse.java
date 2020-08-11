package com.example.notes;

public class FIreBaseDatabse  {

    String  Lastname;
    String Tableid;
    String username;
    String  firstname;

    @Override
    public String toString() {
        return "FIreBaseDatabse{" +
                "Lastname='" + Lastname + '\'' +
                ", Tableid='" + Tableid + '\'' +
                ", username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                '}';
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setTableid(String tableid) {
        Tableid = tableid;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }


    FIreBaseDatabse(){

    }

    public FIreBaseDatabse(String Tableid,String username,String firstname, String Lastname) {
        this.username = username;
        this.Tableid = Tableid;
        this.firstname = firstname;
        this.Lastname = Lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getTableid() {
        return Tableid;
    }

    public String getLastname() {
        return Lastname;
    }
    public String getUsername(){ return username;}

}
