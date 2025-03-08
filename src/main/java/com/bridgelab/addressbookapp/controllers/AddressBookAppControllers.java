package com.bridgelab.addressbookapp.controllers;


import com.bridgelab.addressbookapp.DTO.AddressBookDTO;
import com.bridgelab.addressbookapp.model.AddressBookDetails;
import com.bridgelab.addressbookapp.service.AddressBookServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/addressBookApp")
@CrossOrigin(origins = "http://localhost:4200")
public class AddressBookAppControllers {
    @Autowired
    AddressBookServiceLayer addressBookServiceLayer;
    @GetMapping("/viewPerson")
    public ResponseEntity<List<AddressBookDetails>> get(){
        return ResponseEntity.ok(addressBookServiceLayer.get());
    }
    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> Create(@RequestBody AddressBookDTO addressBookDTO){
       return ResponseEntity.ok(addressBookServiceLayer.create(addressBookDTO));

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

    @PutMapping("update/{id}")
    public String Update(@RequestBody AddressBookDTO newAddress,@PathVariable int id){
       return addressBookServiceLayer.update(newAddress,id);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteByID(@PathVariable int id){
        return ResponseEntity.ok(addressBookServiceLayer.deleteBuyID(id));
    }


}
