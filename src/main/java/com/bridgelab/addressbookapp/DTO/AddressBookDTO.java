package com.bridgelab.addressbookapp.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AddressBookDTO {
    private String name;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber ;
}
