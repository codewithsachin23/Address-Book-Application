package com.bridgelab.addressbookapp.service;

import com.bridgelab.addressbookapp.DTO.AddressBookDTO;
import com.bridgelab.addressbookapp.model.AddressBookDetails;
import com.bridgelab.addressbookapp.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class AddressBookServiceLayer {
    @Autowired
    AddressBookRepository addressBookRepository;

    public List<AddressBookDetails> get(){
        return addressBookRepository.findAll();
    }
    public String create(AddressBookDTO addressBookDTO){
        AddressBookDetails addressBookDetails=new AddressBookDetails(addressBookDTO.getName(),addressBookDTO.getDepartment());
        addressBookRepository.save(addressBookDetails);
        return "Created";
    }
    public Optional<AddressBookDetails> findById(int id){
        Optional<AddressBookDetails>details=addressBookRepository.findById(id);
        if (details.isPresent()){
            return details;
        }else {
            return Optional.empty();
        }
    }
    public String update(AddressBookDTO newAddressBookDTO,int id){
        Optional<AddressBookDetails> addressBookDetails=addressBookRepository.findById(id);
        if (addressBookDetails.isPresent()){
            AddressBookDetails addressBookDetail=addressBookDetails.get();
            addressBookDetail.setName(newAddressBookDTO.getName());
            addressBookDetail.setDepartment(newAddressBookDTO.getDepartment());
            addressBookRepository.save(addressBookDetail);
        }
            return "update done";

    }

    public String deleteBuyID(int id){
         addressBookRepository.deleteById(id);
         return "Record deleted";
    }

}
