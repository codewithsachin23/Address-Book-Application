package com.bridgelab.addressbookapp.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity

public class AddressBookDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
    private String name;
   private String department;

    public AddressBookDetails() {
    }

    public AddressBookDetails(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


}
