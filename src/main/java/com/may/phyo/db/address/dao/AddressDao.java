package com.may.phyo.db.address.dao;

import com.may.phyo.db.address.ds.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDao extends CrudRepository<Address,Integer> {
}
