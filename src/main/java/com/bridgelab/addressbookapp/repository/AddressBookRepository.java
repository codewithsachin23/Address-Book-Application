package com.bridgelab.addressbookapp.repository;

import com.bridgelab.addressbookapp.model.AddressBookDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookRepository extends JpaRepository<AddressBookDetails,Integer> {

}
