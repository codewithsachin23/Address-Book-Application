package com.bridgelab.addressbookapp.service;

import com.bridgelab.addressbookapp.DTO.AddressBookDTO;
import com.bridgelab.addressbookapp.model.AddressBookDetails;
import com.bridgelab.addressbookapp.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AddressBookServiceLayer {
    @Autowired
    AddressBookRepository addressBookRepository;

    public List<AddressBookDetails> get(){
        return addressBookRepository.findAll();
    }

    public Map<String, Object> create(AddressBookDTO addressBookDTO){
        AddressBookDetails addressBookDetails=new AddressBookDetails(0,addressBookDTO.getName(),addressBookDTO.getAddress(),addressBookDTO.getCity(),addressBookDTO.getState(),addressBookDTO.getZipCode(),addressBookDTO.getPhoneNumber());
        addressBookRepository.save(addressBookDetails);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Contact added successfully");
        response.put("contact", addressBookDetails);
        return response;
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
            addressBookDetail.setAddress(newAddressBookDTO.getAddress());
            addressBookDetail.setCity(newAddressBookDTO.getCity());
            addressBookDetail.setState(newAddressBookDTO.getState());
            addressBookDetail.setZipCode(newAddressBookDTO.getZipCode());
            addressBookDetail.setPhoneNumber(newAddressBookDTO.getPhoneNumber());
            addressBookRepository.save(addressBookDetail);
        }
            return "update done";
    }

    public ResponseEntity<String> deleteBuyID(int id){
         addressBookRepository.deleteById(id);
         return ResponseEntity.ok("recordDeleted");

    }

}
