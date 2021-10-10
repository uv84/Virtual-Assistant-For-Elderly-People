package com.example.vaep;

public class dataholder {
    String name,contact,work,pimage,email;

    public dataholder() {
    }

    public dataholder(String name, String contact, String pimage, String email) {
        this.name = name;
        this.contact = contact;

        this.pimage = pimage;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }



    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
