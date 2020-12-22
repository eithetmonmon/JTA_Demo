package com.may.phyo.db.address.ds;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Address {
    @Id
    private int id;
    private String street_name;
    private String postal_code;

    public Address(){

    }
}
