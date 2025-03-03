package com.bridgelab.addressbookapp.DTO;
public class AddressBookDTO {

    private String name;
    private String department;


    public AddressBookDTO() {
    }

    public AddressBookDTO(String name, String department) {
        this.name = name;
        this.department = department;
    }
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
