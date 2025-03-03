package com.bridgelab.addressbookapp.controllers;


import com.bridgelab.addressbookapp.DTO.AddressBookDTO;
import com.bridgelab.addressbookapp.model.AddressBookDetails;
import com.bridgelab.addressbookapp.service.AddressBookServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/addressBookApp")
public class AddressBookAppControllers {
    @Autowired
    AddressBookServiceLayer addressBookServiceLayer;
    @GetMapping
    public ResponseEntity<List<AddressBookDetails>> get(){
        return ResponseEntity.ok(addressBookServiceLayer.get());
    }
    @PostMapping
    public String Create(@RequestBody AddressBookDTO addressBookDTO){
       return addressBookServiceLayer.create(addressBookDTO);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<AddressBookDetails>> getByID(@PathVariable int id){
        Optional<AddressBookDetails> book=addressBookServiceLayer.findById(id);
        if (book.isPresent()){
            return ResponseEntity.ok(book);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public String Update(@RequestBody AddressBookDTO newAddress,@PathVariable int id){
       return addressBookServiceLayer.update(newAddress,id);
    }

    @DeleteMapping("/{id}")
    public String deleteByID(@PathVariable int id){
        return addressBookServiceLayer.deleteBuyID(id);
    }


}
