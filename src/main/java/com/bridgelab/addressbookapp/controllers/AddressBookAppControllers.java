package com.bridgelab.addressbookapp.controllers;


import com.bridgelab.addressbookapp.model.AddressBookDetails;
import com.bridgelab.addressbookapp.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/addressBookApp")
public class AddressBookAppControllers {
    @Autowired
    AddressBookRepository addressBookRepository;
    @GetMapping
    public ResponseEntity<List<AddressBookDetails>> get(){
        return ResponseEntity.ok(addressBookRepository.findAll());
    }
    @PostMapping
    public String Create(@RequestBody AddressBookDetails addressBookDetails){
        addressBookRepository.save(addressBookDetails);
        return "Done";
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<AddressBookDetails>> getByID(@PathVariable int id){
        Optional<AddressBookDetails> book=addressBookRepository.findById(id);
        if (book.isPresent()){
            return ResponseEntity.ok(book);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public String Update(@RequestBody AddressBookDetails newAddress,@PathVariable int id){
        Optional<AddressBookDetails> details=addressBookRepository.findById(id);
        if (details.isPresent()){
            AddressBookDetails addressBookDetails=details.get();
            addressBookDetails.setName(newAddress.getName());
            addressBookDetails.setDepartment(newAddress.getDepartment());
            addressBookRepository.save(addressBookDetails);
        }
        return "update done";
    }
    @DeleteMapping("/{id}")
    public String deleteByID(@PathVariable int id){
        addressBookRepository.deleteById(id);
        return " record Deleted";
    }


}
